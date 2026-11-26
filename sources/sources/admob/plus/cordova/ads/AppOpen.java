package admob.plus.cordova.ads;

import admob.plus.cordova.ExecuteContext;
import admob.plus.cordova.Generated;
import admob.plus.core.Context;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

/* JADX INFO: loaded from: classes.dex */
public class AppOpen extends AdBase {
    private AppOpenAd mAd;
    private final AdRequest mAdRequest;

    public AppOpen(ExecuteContext executeContext) {
        super(executeContext);
        this.mAd = null;
        this.mAdRequest = executeContext.optAdRequest();
    }

    @Override // admob.plus.cordova.ads.AdBase
    public void onDestroy() {
        clear();
        super.onDestroy();
    }

    @Override // admob.plus.core.GenericAd
    public void load(final Context context) {
        clear();
        AppOpenAd.load(getActivity().getApplicationContext(), this.adUnitId, this.mAdRequest, new AppOpenAd.AppOpenAdLoadCallback() { // from class: admob.plus.cordova.ads.AppOpen.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(AppOpenAd appOpenAd) {
                AppOpen.this.mAd = appOpenAd;
                appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: admob.plus.cordova.ads.AppOpen.1.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        AppOpen.this.clear();
                        AppOpen.this.emit(Generated.Events.AD_DISMISS);
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        AppOpen.this.clear();
                        AppOpen.this.emit(Generated.Events.AD_SHOW_FAIL, adError);
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        AppOpen.this.emit(Generated.Events.AD_SHOW);
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                        AppOpen.this.emit(Generated.Events.AD_IMPRESSION);
                    }
                });
                AppOpen.this.emit(Generated.Events.AD_LOAD);
                context.resolve();
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                AppOpen.this.clear();
                AppOpen.this.emit(Generated.Events.AD_LOAD_FAIL, loadAdError);
                context.reject(loadAdError.toString());
            }
        });
    }

    @Override // admob.plus.core.GenericAd
    public boolean isLoaded() {
        return this.mAd != null;
    }

    @Override // admob.plus.core.GenericAd
    public void show(Context context) {
        AppOpenAd appOpenAd = this.mAd;
        if (appOpenAd != null) {
            appOpenAd.show(getActivity());
            context.resolve(true);
        } else {
            context.reject("AppOpenAd not loaded");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        this.mAd = null;
    }
}
