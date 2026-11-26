package admob.plus.cordova.ads;

import admob.plus.cordova.ExecuteContext;
import admob.plus.cordova.Generated;
import admob.plus.core.Context;
import admob.plus.core.Helper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Native extends AdBase {
    public static final String VIEW_DEFAULT_KEY = "default";
    public static final Map<String, ViewProvider> providers = new HashMap();
    private NativeAd mAd;
    private final AdRequest mAdRequest;
    private AdLoader mLoader;
    private View view;
    private final ViewProvider viewProvider;

    public interface ViewProvider {
        View createView(NativeAd nativeAd);

        default void didHide(Native r1) {
        }

        default void didShow(Native r1) {
        }
    }

    public Native(ExecuteContext executeContext) {
        super(executeContext);
        this.mAdRequest = executeContext.optAdRequest();
        String strOptString = executeContext.optString("view");
        strOptString = (strOptString == null || strOptString.isEmpty()) ? "default" : strOptString;
        ViewProvider viewProvider = providers.get(strOptString);
        this.viewProvider = viewProvider;
        if (viewProvider == null) {
            throw new RuntimeException("Cannot find viewProvider: " + strOptString);
        }
    }

    @Override // admob.plus.cordova.ads.AdBase
    public void onDestroy() {
        clear();
        super.onDestroy();
    }

    @Override // admob.plus.core.GenericAd
    public boolean isLoaded() {
        return this.mAd != null;
    }

    @Override // admob.plus.core.GenericAd
    public void load(final Context context) {
        clear();
        AdLoader adLoaderBuild = new AdLoader.Builder(getActivity(), this.adUnitId).forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: admob.plus.cordova.ads.Native$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public final void onNativeAdLoaded(NativeAd nativeAd) {
                this.f$0.m31lambda$load$0$admobpluscordovaadsNative(nativeAd);
            }
        }).withAdListener(new AdListener() { // from class: admob.plus.cordova.ads.Native.1
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Native.this.emit(Generated.Events.AD_LOAD_FAIL, loadAdError);
                Native.this.mAd = null;
                context.reject(loadAdError.getCode() + ": " + loadAdError.getMessage());
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                Native.this.emit(Generated.Events.AD_LOAD);
                context.resolve();
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                Native.this.emit(Generated.Events.AD_SHOW);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                Native.this.emit(Generated.Events.AD_DISMISS);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClicked() {
                Native.this.emit(Generated.Events.AD_CLICK);
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
                Native.this.emit(Generated.Events.AD_IMPRESSION);
            }
        }).build();
        this.mLoader = adLoaderBuild;
        adLoaderBuild.loadAd(this.mAdRequest);
    }

    /* JADX INFO: renamed from: lambda$load$0$admob-plus-cordova-ads-Native, reason: not valid java name */
    /* synthetic */ void m31lambda$load$0$admobpluscordovaadsNative(NativeAd nativeAd) {
        NativeAd nativeAd2 = this.mAd;
        if (nativeAd2 != null) {
            nativeAd2.destroy();
        }
        this.mAd = nativeAd;
    }

    @Override // admob.plus.core.GenericAd
    public void show(Context context) {
        NativeAd nativeAd = this.mAd;
        if (nativeAd == null) {
            context.reject("Native ad not loaded");
            return;
        }
        if (this.view == null) {
            this.view = this.viewProvider.createView(nativeAd);
            ((ViewGroup) Objects.requireNonNull(getContentView())).addView(this.view);
        }
        this.view.setVisibility(0);
        this.view.setX((float) Helper.dpToPx(context.optDouble("x", 0.0d)));
        this.view.setY((float) Helper.dpToPx(context.optDouble("y", 0.0d)));
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        layoutParams.width = (int) Helper.dpToPx(context.optDouble("width", 0.0d));
        layoutParams.height = (int) Helper.dpToPx(context.optDouble("height", 0.0d));
        this.view.setLayoutParams(layoutParams);
        this.viewProvider.didShow(this);
        this.view.requestLayout();
        context.resolve(true);
    }

    @Override // admob.plus.core.GenericAd
    public void hide(Context context) {
        View view = this.view;
        if (view != null) {
            view.setVisibility(8);
        }
        this.viewProvider.didHide(this);
        context.resolve();
    }

    private void clear() {
        NativeAd nativeAd = this.mAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mAd = null;
        }
        View view = this.view;
        if (view != null) {
            if (view instanceof NativeAdView) {
                NativeAdView nativeAdView = (NativeAdView) view;
                nativeAdView.removeAllViews();
                nativeAdView.destroy();
            }
            this.view = null;
        }
        this.mLoader = null;
    }
}
