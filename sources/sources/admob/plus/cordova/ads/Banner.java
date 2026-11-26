package admob.plus.cordova.ads;

import admob.plus.cordova.ExecuteContext;
import admob.plus.cordova.Generated;
import admob.plus.core.Context;
import admob.plus.core.Helper;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Banner extends AdBase {
    private static final String TAG = "AdMobPlus.Banner";
    private static FrameLayout bannerSlot;
    private static ViewGroup originalWebViewParent;
    private static ViewGroup rootLinearLayout;
    private static int screenWidth;
    private static FrameLayout webViewFrame;
    private final AdSize adSize;
    private final int gravity;
    private boolean hidden;
    private int lastBottomInset;
    private int lastRelativeBottomInset;
    private int lastRelativeTopInset;
    private int lastTopInset;
    private boolean linearBannerVisible;
    private AdView mAdView;
    private AdView mAdViewOld;
    private RelativeLayout mRelativeLayout;
    private final Integer offset;
    private boolean pendingShowAfterOrientationChange;
    private boolean suppressBannerDuringOrientationChange;

    public Banner(ExecuteContext executeContext) {
        super(executeContext);
        this.mRelativeLayout = null;
        this.mAdViewOld = null;
        this.hidden = false;
        this.linearBannerVisible = false;
        this.lastTopInset = 0;
        this.lastBottomInset = 0;
        this.lastRelativeTopInset = 0;
        this.lastRelativeBottomInset = 0;
        this.pendingShowAfterOrientationChange = false;
        this.suppressBannerDuringOrientationChange = false;
        this.adSize = executeContext.optAdSize();
        this.gravity = "top".equals(executeContext.optPosition()) ? 48 : 80;
        this.offset = executeContext.optOffset();
    }

    public static void destroyParentView() {
        ViewGroup parentView = Helper.getParentView(rootLinearLayout);
        if (parentView != null) {
            parentView.removeAllViews();
        }
        rootLinearLayout = null;
        originalWebViewParent = null;
        webViewFrame = null;
        bannerSlot = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runJustBeforeBeingDrawn(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: admob.plus.cordova.ads.Banner.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                runnable.run();
                return true;
            }
        });
    }

    @Override // admob.plus.core.GenericAd
    public boolean isLoaded() {
        return this.mAdView != null;
    }

    @Override // admob.plus.core.GenericAd
    public void load(Context context) {
        if (this.mAdView == null) {
            this.mAdView = createBannerView();
        }
        if (this.offset == null) {
            destroyRelativeLayoutMode();
            ensureLinearBannerLayout();
        }
        this.mAdView.loadAd(this.adRequest);
        context.resolve();
    }

    private AdView createBannerView() {
        AdView adView = new AdView(getActivity());
        adView.setAdUnitId(this.adUnitId);
        adView.setAdSize(this.adSize);
        adView.setFocusable(false);
        adView.setFocusableInTouchMode(false);
        adView.setBackgroundColor(0);
        adView.setAdListener(new AnonymousClass2(adView));
        return adView;
    }

    /* JADX INFO: renamed from: admob.plus.cordova.ads.Banner$2, reason: invalid class name */
    class AnonymousClass2 extends AdListener {
        final /* synthetic */ AdView val$adView;

        AnonymousClass2(AdView adView) {
            this.val$adView = adView;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClicked() {
            Banner.this.emit(Generated.Events.AD_CLICK);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            Banner.this.emit(Generated.Events.AD_DISMISS);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Banner.this.emit(Generated.Events.AD_LOAD_FAIL, loadAdError);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            Banner.this.emit(Generated.Events.AD_IMPRESSION);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            if (Banner.this.offset == null && (Banner.this.linearBannerVisible || Banner.this.mAdViewOld != null)) {
                Banner.this.addBannerViewWithLinearLayout();
            } else if (Banner.this.offset != null && this.val$adView == Banner.this.mAdView && Banner.this.mAdView.getParent() == null) {
                Banner.this.addBannerViewWithRelativeLayout();
            }
            if (Banner.this.mAdViewOld != null) {
                Banner banner = Banner.this;
                banner.removeBannerView(banner.mAdViewOld);
                Banner.this.mAdViewOld = null;
            }
            if (Banner.this.offset == null) {
                Banner.this.applyBannerSlotLayout();
            }
            Banner.runJustBeforeBeingDrawn(this.val$adView, new Runnable() { // from class: admob.plus.cordova.ads.Banner$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m27lambda$onAdLoaded$0$admobpluscordovaadsBanner$2();
                }
            });
            Banner banner2 = Banner.this;
            banner2.emit(Generated.Events.AD_LOAD, banner2.computeAdSize());
        }

        /* JADX INFO: renamed from: lambda$onAdLoaded$0$admob-plus-cordova-ads-Banner$2, reason: not valid java name */
        /* synthetic */ void m27lambda$onAdLoaded$0$admobpluscordovaadsBanner$2() {
            Banner banner = Banner.this;
            banner.emit(Generated.Events.BANNER_SIZE, banner.computeAdSize());
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            Banner.this.emit(Generated.Events.AD_SHOW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> computeAdSize() {
        final int width = this.mAdView.getWidth();
        final int height = this.mAdView.getHeight();
        return new HashMap<String, Object>() { // from class: admob.plus.cordova.ads.Banner.3
            {
                put("size", new HashMap<String, Object>() { // from class: admob.plus.cordova.ads.Banner.3.1
                    {
                        put("width", Integer.valueOf(Helper.pxToDp(width)));
                        put("height", Integer.valueOf(Helper.pxToDp(height)));
                        put("widthInPixels", Integer.valueOf(width));
                        put("heightInPixels", Integer.valueOf(height));
                    }
                });
            }
        };
    }

    @Override // admob.plus.core.GenericAd
    public void show(Context context) {
        this.hidden = false;
        if (this.mAdView == null) {
            AdView adViewCreateBannerView = createBannerView();
            this.mAdView = adViewCreateBannerView;
            adViewCreateBannerView.loadAd(this.adRequest);
        }
        resumeBannerViews();
        addBannerView();
        context.resolve();
    }

    @Override // admob.plus.core.GenericAd
    public void hide(Context context) {
        this.hidden = true;
        if (this.mAdView != null) {
            pauseBannerViews();
            if (this.offset == null) {
                this.linearBannerVisible = false;
                hideBannerLinearLayout();
            } else {
                this.mAdView.setVisibility(8);
            }
        }
        context.resolve();
    }

    @Override // admob.plus.cordova.ads.AdBase
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = getActivity().getResources().getDisplayMetrics().widthPixels;
        if (i != screenWidth) {
            screenWidth = i;
            getActivity().runOnUiThread(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m26lambda$onConfigurationChanged$1$admobpluscordovaadsBanner();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onConfigurationChanged$1$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m26lambda$onConfigurationChanged$1$admobpluscordovaadsBanner() {
        if (this.hidden) {
            this.pendingShowAfterOrientationChange = false;
            this.suppressBannerDuringOrientationChange = false;
            return;
        }
        AdView adView = this.mAdView;
        this.pendingShowAfterOrientationChange = adView != null && adView.getVisibility() == 0;
        this.suppressBannerDuringOrientationChange = true;
        AdView adView2 = this.mAdView;
        if (adView2 != null) {
            adView2.setVisibility(4);
        }
        if (this.offset == null) {
            this.pendingShowAfterOrientationChange = false;
            this.suppressBannerDuringOrientationChange = false;
            this.mAdView.setVisibility(0);
            ensureLinearBannerLayout();
            applyBannerSlotLayout();
        }
        reloadBannerView();
        View view = this.offset == null ? rootLinearLayout : this.mRelativeLayout;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m25lambda$onConfigurationChanged$0$admobpluscordovaadsBanner();
                }
            }, 150L);
        }
    }

    /* JADX INFO: renamed from: lambda$onConfigurationChanged$0$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m25lambda$onConfigurationChanged$0$admobpluscordovaadsBanner() {
        this.suppressBannerDuringOrientationChange = false;
        if (this.pendingShowAfterOrientationChange && this.mAdView != null) {
            if (this.offset == null) {
                addBannerViewWithLinearLayout();
            } else {
                applyRelativeBannerMargins();
                this.mAdView.setVisibility(0);
            }
        }
        this.pendingShowAfterOrientationChange = false;
    }

    private void reloadBannerView() {
        AdView adView;
        if (this.hidden || (adView = this.mAdView) == null || adView.getVisibility() == 8) {
            return;
        }
        pauseBannerViews();
        AdView adView2 = this.mAdViewOld;
        if (adView2 != null) {
            removeBannerView(adView2);
        }
        this.mAdViewOld = this.mAdView;
        AdView adViewCreateBannerView = createBannerView();
        this.mAdView = adViewCreateBannerView;
        adViewCreateBannerView.loadAd(this.adRequest);
        if (this.offset != null) {
            addBannerView();
        }
    }

    @Override // admob.plus.cordova.ads.AdBase
    public void onPause(boolean z) {
        pauseBannerViews();
        super.onPause(z);
    }

    private void pauseBannerViews() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.pause();
        }
        AdView adView2 = this.mAdViewOld;
        if (adView2 == null || adView2 == this.mAdView) {
            return;
        }
        adView2.pause();
    }

    @Override // admob.plus.cordova.ads.AdBase
    public void onResume(boolean z) {
        super.onResume(z);
        resumeBannerViews();
    }

    private void resumeBannerViews() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.resume();
        }
        AdView adView2 = this.mAdViewOld;
        if (adView2 != null) {
            adView2.resume();
        }
    }

    @Override // admob.plus.cordova.ads.AdBase
    public void onDestroy() {
        resetLinearBannerLayout();
        AdView adView = this.mAdView;
        if (adView != null) {
            removeBannerView(adView);
            this.mAdView = null;
        }
        AdView adView2 = this.mAdViewOld;
        if (adView2 != null) {
            removeBannerView(adView2);
            this.mAdViewOld = null;
        }
        destroyRelativeLayoutMode();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeBannerView(AdView adView) {
        Helper.removeFromParentView(adView);
        adView.removeAllViews();
        adView.destroy();
    }

    private void addBannerView() {
        if (this.mAdView == null) {
            return;
        }
        if (this.offset == null) {
            destroyRelativeLayoutMode();
            addBannerViewWithLinearLayout();
        } else {
            this.linearBannerVisible = false;
            resetLinearBannerLayout();
            ViewGroup parentView = Helper.getParentView(this.mAdView);
            RelativeLayout relativeLayout = this.mRelativeLayout;
            if (parentView == relativeLayout && relativeLayout != null) {
                return;
            } else {
                addBannerViewWithRelativeLayout();
            }
        }
        ViewGroup contentView = getContentView();
        if (contentView != null) {
            contentView.bringToFront();
            contentView.requestLayout();
            contentView.requestFocus();
        }
    }

    private void ensureLinearBannerLayout() {
        ViewGroup parentView;
        final View webView = getWebView();
        if ((rootLinearLayout == null || bannerSlot == null || webViewFrame == null) && (parentView = Helper.getParentView(webView)) != null) {
            if (rootLinearLayout != null) {
                resetLinearBannerLayout();
                parentView = Helper.getParentView(webView);
                if (parentView == null) {
                    return;
                }
            }
            originalWebViewParent = parentView;
            LinearLayout linearLayout = new LinearLayout(getActivity());
            rootLinearLayout = linearLayout;
            linearLayout.setOrientation(1);
            rootLinearLayout.setBackgroundColor(0);
            FrameLayout frameLayout = new FrameLayout(getActivity());
            webViewFrame = frameLayout;
            frameLayout.setBackgroundColor(0);
            FrameLayout frameLayout2 = new FrameLayout(getActivity());
            bannerSlot = frameLayout2;
            frameLayout2.setBackgroundColor(0);
            bannerSlot.setVisibility(8);
            parentView.removeView(webView);
            webViewFrame.addView(webView, new FrameLayout.LayoutParams(-1, -1));
            ViewCompat.setOnApplyWindowInsetsListener(webViewFrame, new OnApplyWindowInsetsListener() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda11
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return this.f$0.m20lambda$ensureLinearBannerLayout$2$admobpluscordovaadsBanner(webView, view, windowInsetsCompat);
                }
            });
            if (isPositionTop()) {
                rootLinearLayout.addView(bannerSlot, new LinearLayout.LayoutParams(-1, 0));
                rootLinearLayout.addView(webViewFrame, new LinearLayout.LayoutParams(-1, 0, 1.0f));
            } else {
                rootLinearLayout.addView(webViewFrame, new LinearLayout.LayoutParams(-1, 0, 1.0f));
                rootLinearLayout.addView(bannerSlot, new LinearLayout.LayoutParams(-1, 0));
            }
            parentView.addView(rootLinearLayout, new ViewGroup.LayoutParams(-1, -1));
            ViewCompat.setOnApplyWindowInsetsListener(rootLinearLayout, new OnApplyWindowInsetsListener() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda12
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return this.f$0.m22lambda$ensureLinearBannerLayout$4$admobpluscordovaadsBanner(webView, view, windowInsetsCompat);
                }
            });
            rootLinearLayout.post(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m24lambda$ensureLinearBannerLayout$6$admobpluscordovaadsBanner(webView);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$ensureLinearBannerLayout$2$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m20lambda$ensureLinearBannerLayout$2$admobpluscordovaadsBanner(View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        clearWebViewInsetMargin(view);
        return windowInsetsCompat;
    }

    /* JADX INFO: renamed from: lambda$ensureLinearBannerLayout$4$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m22lambda$ensureLinearBannerLayout$4$admobpluscordovaadsBanner(final View view, View view2, WindowInsetsCompat windowInsetsCompat) {
        this.lastTopInset = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        this.lastBottomInset = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        view2.post(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m21lambda$ensureLinearBannerLayout$3$admobpluscordovaadsBanner(view);
            }
        });
        return windowInsetsCompat;
    }

    /* JADX INFO: renamed from: lambda$ensureLinearBannerLayout$3$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m21lambda$ensureLinearBannerLayout$3$admobpluscordovaadsBanner(View view) {
        applyBannerSlotLayout();
        clearWebViewInsetMargin(view);
    }

    /* JADX INFO: renamed from: lambda$ensureLinearBannerLayout$6$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m24lambda$ensureLinearBannerLayout$6$admobpluscordovaadsBanner(final View view) {
        ViewCompat.requestApplyInsets(rootLinearLayout);
        rootLinearLayout.postDelayed(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m23lambda$ensureLinearBannerLayout$5$admobpluscordovaadsBanner(view);
            }
        }, 100L);
    }

    /* JADX INFO: renamed from: lambda$ensureLinearBannerLayout$5$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m23lambda$ensureLinearBannerLayout$5$admobpluscordovaadsBanner(View view) {
        applyBannerSlotLayout();
        clearWebViewInsetMargin(view);
        rootLinearLayout.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBannerViewWithLinearLayout() {
        AdView adView;
        ensureLinearBannerLayout();
        if (bannerSlot == null || (adView = this.mAdView) == null) {
            return;
        }
        this.linearBannerVisible = true;
        Helper.removeFromParentView(adView);
        bannerSlot.removeAllViews();
        this.mAdView.setVisibility(this.suppressBannerDuringOrientationChange ? 4 : 0);
        this.mAdView.setFocusable(false);
        this.mAdView.setFocusableInTouchMode(false);
        this.mAdView.setBackgroundColor(0);
        bannerSlot.addView(this.mAdView, new FrameLayout.LayoutParams(-1, -1));
        bannerSlot.setVisibility(0);
        applyBannerSlotLayout();
        ViewGroup viewGroup = rootLinearLayout;
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m15x5d4af9b7();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addBannerViewWithLinearLayout$8$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m15x5d4af9b7() {
        ViewCompat.requestApplyInsets(rootLinearLayout);
        rootLinearLayout.postDelayed(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14x48623176();
            }
        }, 100L);
    }

    /* JADX INFO: renamed from: lambda$addBannerViewWithLinearLayout$7$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m14x48623176() {
        applyBannerSlotLayout();
        clearWebViewInsetMargin(getWebView());
        rootLinearLayout.requestLayout();
    }

    private void hideBannerLinearLayout() {
        if (bannerSlot == null) {
            return;
        }
        Helper.removeFromParentView(this.mAdView);
        bannerSlot.removeAllViews();
        bannerSlot.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = bannerSlot.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = 0;
            layoutParams2.setMargins(0, 0, 0, 0);
            bannerSlot.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyBannerSlotLayout() {
        AdView adView;
        int heightInPixels;
        if (bannerSlot == null || (adView = this.mAdView) == null || !this.linearBannerVisible) {
            return;
        }
        if (adView.getAdSize() != null) {
            heightInPixels = this.mAdView.getAdSize().getHeightInPixels(getActivity());
        } else {
            heightInPixels = this.adSize.getHeightInPixels(getActivity());
        }
        ViewGroup.LayoutParams layoutParams = bannerSlot.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.height = heightInPixels;
            if (isPositionTop()) {
                layoutParams2.setMargins(0, this.lastTopInset, 0, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, this.lastBottomInset);
            }
            bannerSlot.setLayoutParams(layoutParams2);
            bannerSlot.requestLayout();
        }
    }

    private void clearWebViewInsetMargin(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (isPositionTop()) {
                layoutParams2.setMargins(layoutParams2.leftMargin, 0, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            } else {
                layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, 0);
            }
            view.setLayoutParams(layoutParams2);
            view.requestLayout();
        }
    }

    private void resetLinearBannerLayout() {
        View webView = getWebView();
        this.linearBannerVisible = false;
        Helper.removeFromParentView(this.mAdView);
        FrameLayout frameLayout = bannerSlot;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            bannerSlot = null;
        }
        if (webViewFrame != null) {
            Helper.removeFromParentView(webView);
            webViewFrame.removeAllViews();
            webViewFrame = null;
        }
        if (originalWebViewParent != null && Helper.getParentView(webView) != originalWebViewParent) {
            Helper.removeFromParentView(webView);
            originalWebViewParent.addView(webView, new FrameLayout.LayoutParams(-1, -1));
        }
        Helper.removeFromParentView(rootLinearLayout);
        rootLinearLayout = null;
        originalWebViewParent = null;
    }

    private void destroyRelativeLayoutMode() {
        RelativeLayout relativeLayout = this.mRelativeLayout;
        if (relativeLayout != null) {
            Helper.removeFromParentView(relativeLayout);
            this.mRelativeLayout = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBannerViewWithRelativeLayout() {
        if (this.mRelativeLayout == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getActivity());
            this.mRelativeLayout = relativeLayout;
            relativeLayout.setFocusable(false);
            this.mRelativeLayout.setFocusableInTouchMode(false);
            this.mRelativeLayout.setClickable(false);
            ViewGroup contentView = getContentView();
            if (contentView != null) {
                contentView.addView(this.mRelativeLayout, new ViewGroup.LayoutParams(-1, -1));
            } else {
                Log.e(TAG, "Unable to find content view");
            }
        }
        Helper.removeFromParentView(this.mAdView);
        this.mAdView.setVisibility(0);
        this.mAdView.setFocusable(false);
        this.mAdView.setFocusableInTouchMode(false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        if (isPositionTop()) {
            layoutParams.addRule(10);
            layoutParams.setMargins(0, this.offset.intValue(), 0, 0);
        } else {
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, this.offset.intValue());
        }
        this.mRelativeLayout.addView(this.mAdView, layoutParams);
        this.mRelativeLayout.bringToFront();
        ViewCompat.setOnApplyWindowInsetsListener(this.mRelativeLayout, new OnApplyWindowInsetsListener() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda6
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.m16x8360cc8b(view, windowInsetsCompat);
            }
        });
        this.mRelativeLayout.post(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m18xad325d0d();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$addBannerViewWithRelativeLayout$10$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m16x8360cc8b(View view, WindowInsetsCompat windowInsetsCompat) {
        this.lastRelativeTopInset = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        this.lastRelativeBottomInset = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
        view.post(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m19x8ca1cd9f();
            }
        });
        return windowInsetsCompat;
    }

    /* JADX INFO: renamed from: lambda$addBannerViewWithRelativeLayout$9$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m19x8ca1cd9f() {
        applyRelativeBannerMargins();
        if (this.suppressBannerDuringOrientationChange || !this.pendingShowAfterOrientationChange) {
            return;
        }
        this.mAdView.setVisibility(0);
        this.pendingShowAfterOrientationChange = false;
    }

    /* JADX INFO: renamed from: lambda$addBannerViewWithRelativeLayout$12$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m18xad325d0d() {
        ViewCompat.requestApplyInsets(this.mRelativeLayout);
        this.mRelativeLayout.postDelayed(new Runnable() { // from class: admob.plus.cordova.ads.Banner$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m17x984994cc();
            }
        }, 100L);
    }

    /* JADX INFO: renamed from: lambda$addBannerViewWithRelativeLayout$11$admob-plus-cordova-ads-Banner, reason: not valid java name */
    /* synthetic */ void m17x984994cc() {
        ViewCompat.requestApplyInsets(this.mRelativeLayout);
        this.mAdView.requestLayout();
    }

    private void applyRelativeBannerMargins() {
        AdView adView = this.mAdView;
        if (adView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = adView.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (isPositionTop()) {
                layoutParams2.setMargins(0, this.lastRelativeTopInset + this.offset.intValue(), 0, 0);
            } else {
                layoutParams2.setMargins(0, 0, 0, this.lastRelativeBottomInset + this.offset.intValue());
            }
            this.mAdView.setLayoutParams(layoutParams2);
            this.mAdView.requestLayout();
        }
    }

    private boolean isPositionTop() {
        return this.gravity == 48;
    }

    /* JADX INFO: renamed from: admob.plus.cordova.ads.Banner$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType;

        static {
            int[] iArr = new int[AdSizeType.values().length];
            $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType = iArr;
            try {
                iArr[AdSizeType.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType[AdSizeType.LARGE_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType[AdSizeType.MEDIUM_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType[AdSizeType.FULL_BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType[AdSizeType.LEADERBOARD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType[AdSizeType.ADAPTIVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum AdSizeType {
        BANNER,
        LARGE_BANNER,
        MEDIUM_RECTANGLE,
        FULL_BANNER,
        LEADERBOARD,
        ADAPTIVE;

        public static AdSize getAdSize(int i, Activity activity) {
            switch (AnonymousClass4.$SwitchMap$admob$plus$cordova$ads$Banner$AdSizeType[values()[i].ordinal()]) {
                case 1:
                    return AdSize.BANNER;
                case 2:
                    return AdSize.LARGE_BANNER;
                case 3:
                    return AdSize.MEDIUM_RECTANGLE;
                case 4:
                    return AdSize.FULL_BANNER;
                case 5:
                    return AdSize.LEADERBOARD;
                case 6:
                    return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, (int) (getAdWidthInPixels(activity) / activity.getResources().getDisplayMetrics().density));
                default:
                    return AdSize.BANNER;
            }
        }

        private static int getAdWidthInPixels(Activity activity) {
            return activity.getResources().getDisplayMetrics().widthPixels;
        }
    }
}
