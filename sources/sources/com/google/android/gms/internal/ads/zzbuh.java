package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbuh extends zzbun {
    private String zza;
    private boolean zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final Object zzi;
    private final zzcgy zzj;
    private final Activity zzk;
    private zzcji zzl;
    private ImageView zzm;
    private LinearLayout zzn;
    private final zzbuo zzo;
    private PopupWindow zzp;
    private RelativeLayout zzq;
    private ViewGroup zzr;

    static {
        CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    }

    public zzbuh(zzcgy zzcgyVar, zzbuo zzbuoVar) {
        super(zzcgyVar, "resize");
        this.zza = "top-right";
        this.zzb = true;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = -1;
        this.zzi = new Object();
        this.zzj = zzcgyVar;
        this.zzk = zzcgyVar.zzj();
        this.zzo = zzbuoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzf(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlQ)).booleanValue()) {
            this.zzq.removeView((View) this.zzj);
            this.zzp.dismiss();
        } else {
            this.zzp.dismiss();
            this.zzq.removeView((View) this.zzj);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlR)).booleanValue()) {
            View view = (View) this.zzj;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
        ViewGroup viewGroup = this.zzr;
        if (viewGroup != null) {
            viewGroup.removeView(this.zzm);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlS)).booleanValue()) {
                try {
                    ViewGroup viewGroup2 = this.zzr;
                    zzcgy zzcgyVar = this.zzj;
                    viewGroup2.addView((View) zzcgyVar);
                    zzcgyVar.zzaf(this.zzl);
                } catch (IllegalStateException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to add webview back to view hierarchy.", e);
                }
            } else {
                ViewGroup viewGroup3 = this.zzr;
                zzcgy zzcgyVar2 = this.zzj;
                viewGroup3.addView((View) zzcgyVar2);
                zzcgyVar2.zzaf(this.zzl);
            }
        }
        if (z) {
            zzk("default");
            zzbuo zzbuoVar = this.zzo;
            if (zzbuoVar != null) {
                zzbuoVar.zzb();
            }
        }
        this.zzp = null;
        this.zzq = null;
        this.zzr = null;
        this.zzn = null;
    }

    /* JADX WARN: Code duplicated, block: B:85:0x0194 A[PHI: r17
      0x0194: PHI (r17v12 int) = (r17v5 int), (r17v6 int), (r17v7 int), (r17v8 int), (r17v9 int), (r17v10 int), (r17v13 int) binds: [B:83:0x0190, B:80:0x0183, B:77:0x0177, B:74:0x016b, B:71:0x015f, B:68:0x0153, B:66:0x0148] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    public final void zza(Map map) {
        int i;
        int i2;
        byte b;
        int i3;
        int i4;
        int i5;
        int i6;
        synchronized (this.zzi) {
            Activity activity = this.zzk;
            if (activity == null) {
                zzg("Not an activity context. Cannot resize.");
                return;
            }
            zzcgy zzcgyVar = this.zzj;
            if (zzcgyVar.zzN() == null) {
                zzg("Webview is not yet available, size is not set.");
                return;
            }
            if (zzcgyVar.zzN().zzg()) {
                zzg("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (zzcgyVar.zzW()) {
                zzg("Cannot resize an expanded banner.");
                return;
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zzh = com.google.android.gms.ads.internal.util.zzs.zzT((String) map.get("width"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zze = com.google.android.gms.ads.internal.util.zzs.zzT((String) map.get("height"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zzf = com.google.android.gms.ads.internal.util.zzs.zzT((String) map.get("offsetX"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
                com.google.android.gms.ads.internal.zzt.zzc();
                this.zzg = com.google.android.gms.ads.internal.util.zzs.zzT((String) map.get("offsetY"));
            }
            if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
                this.zzb = Boolean.parseBoolean((String) map.get("allowOffscreen"));
            }
            String str = (String) map.get("customClosePosition");
            if (!TextUtils.isEmpty(str)) {
                this.zza = str;
            }
            if (this.zzh < 0 || this.zze < 0) {
                zzg("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null) {
                com.google.android.gms.ads.internal.zzt.zzc();
                int[] iArrZzab = com.google.android.gms.ads.internal.util.zzs.zzab(activity);
                com.google.android.gms.ads.internal.zzt.zzc();
                int[] iArrZzX = com.google.android.gms.ads.internal.util.zzs.zzX(activity);
                int i7 = iArrZzab[0];
                int i8 = iArrZzab[1];
                int i9 = this.zzh;
                int[] iArr = null;
                if (i9 < 50 || i9 > i7) {
                    i = 50;
                    int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Width is too small or too large.");
                } else {
                    int i11 = this.zze;
                    if (i11 < 50 || i11 > i8) {
                        i = 50;
                        int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Height is too small or too large.");
                    } else if (i11 == i8 && i9 == i7) {
                        int i13 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot resize to a full-screen ad.");
                        i = 50;
                    } else if (this.zzb) {
                        String str2 = this.zza;
                        switch (str2.hashCode()) {
                            case -1364013995:
                                i = 50;
                                if (!str2.equals("center")) {
                                    b = -1;
                                } else {
                                    b = 2;
                                }
                                break;
                            case -1012429441:
                                i = 50;
                                if (!str2.equals("top-left")) {
                                    b = -1;
                                } else {
                                    b = 0;
                                }
                                break;
                            case -655373719:
                                i = 50;
                                if (!str2.equals("bottom-left")) {
                                    b = -1;
                                } else {
                                    b = 3;
                                }
                                break;
                            case 1163912186:
                                i = 50;
                                if (!str2.equals("bottom-right")) {
                                    b = -1;
                                } else {
                                    b = 5;
                                }
                                break;
                            case 1288627767:
                                i = 50;
                                if (!str2.equals("bottom-center")) {
                                    b = -1;
                                } else {
                                    b = 4;
                                }
                                break;
                            case 1755462605:
                                i = 50;
                                if (!str2.equals("top-center")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            default:
                                i = 50;
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            i3 = this.zzc + this.zzf;
                            i4 = this.zzd;
                        } else if (b != 1) {
                            if (b != 2) {
                                if (b == 3) {
                                    i3 = this.zzc + this.zzf;
                                    i6 = this.zzd;
                                } else if (b == 4) {
                                    i3 = ((this.zzc + this.zzf) + (i9 >> 1)) - 25;
                                    i6 = this.zzd;
                                } else if (b != 5) {
                                    i3 = ((this.zzc + this.zzf) + i9) - 50;
                                    i4 = this.zzd;
                                } else {
                                    i3 = ((this.zzc + this.zzf) + i9) - 50;
                                    i6 = this.zzd;
                                }
                                i5 = ((i6 + this.zzg) + i11) - 50;
                            } else {
                                i3 = ((this.zzc + this.zzf) + (i9 >> 1)) - 25;
                                i5 = ((this.zzd + this.zzg) + (i11 >> 1)) - 25;
                            }
                            if (i3 >= 0 && i3 + 50 <= i7 && i5 >= iArrZzX[0] && i5 + 50 <= iArrZzX[1]) {
                                iArr = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                            }
                        } else {
                            i3 = ((this.zzc + this.zzf) + (i9 >> 1)) - 25;
                            i4 = this.zzd;
                        }
                        i5 = i4 + this.zzg;
                        if (i3 >= 0) {
                            iArr = new int[]{this.zzc + this.zzf, this.zzd + this.zzg};
                        }
                    } else {
                        i = 50;
                        com.google.android.gms.ads.internal.zzt.zzc();
                        int[] iArrZzab2 = com.google.android.gms.ads.internal.util.zzs.zzab(activity);
                        com.google.android.gms.ads.internal.zzt.zzc();
                        int[] iArrZzX2 = com.google.android.gms.ads.internal.util.zzs.zzX(activity);
                        int i14 = iArrZzab2[0];
                        int i15 = this.zzc + this.zzf;
                        int i16 = this.zzd + this.zzg;
                        if (i15 < 0) {
                            i2 = 0;
                        } else {
                            int i17 = this.zzh;
                            i2 = i15 + i17 > i14 ? i14 - i17 : i15;
                        }
                        int i18 = iArrZzX2[0];
                        if (i16 < i18) {
                            i16 = i18;
                        } else {
                            int i19 = this.zze;
                            int i20 = i16 + i19;
                            int i21 = iArrZzX2[1];
                            if (i20 > i21) {
                                i16 = i21 - i19;
                            }
                        }
                        iArr = new int[]{i2, i16};
                    }
                }
                if (iArr == null) {
                    zzg("Resize location out of screen or close button is not visible.");
                    return;
                }
                com.google.android.gms.ads.internal.client.zzbb.zza();
                int iZzC = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, this.zzh);
                com.google.android.gms.ads.internal.client.zzbb.zza();
                int iZzC2 = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, this.zze);
                ViewParent parent = ((View) zzcgyVar).getParent();
                if (!(parent instanceof ViewGroup)) {
                    zzg("Webview is detached, probably in the middle of a resize or expand.");
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.removeView((View) zzcgyVar);
                PopupWindow popupWindow = this.zzp;
                if (popupWindow == null) {
                    this.zzr = viewGroup;
                    com.google.android.gms.ads.internal.zzt.zzc();
                    ((View) zzcgyVar).setDrawingCacheEnabled(true);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((View) zzcgyVar).getDrawingCache());
                    ((View) zzcgyVar).setDrawingCacheEnabled(false);
                    ImageView imageView = new ImageView(activity);
                    this.zzm = imageView;
                    imageView.setImageBitmap(bitmapCreateBitmap);
                    this.zzl = zzcgyVar.zzN();
                    this.zzr.addView(this.zzm);
                } else {
                    popupWindow.dismiss();
                }
                RelativeLayout relativeLayout = new RelativeLayout(activity);
                this.zzq = relativeLayout;
                relativeLayout.setBackgroundColor(0);
                this.zzq.setLayoutParams(new ViewGroup.LayoutParams(iZzC, iZzC2));
                com.google.android.gms.ads.internal.zzt.zzc();
                PopupWindow popupWindow2 = new PopupWindow((View) this.zzq, iZzC, iZzC2, false);
                this.zzp = popupWindow2;
                popupWindow2.setOutsideTouchable(false);
                this.zzp.setTouchable(true);
                this.zzp.setClippingEnabled(!this.zzb);
                byte b2 = -1;
                this.zzq.addView((View) zzcgyVar, -1, -1);
                this.zzn = new LinearLayout(activity);
                com.google.android.gms.ads.internal.client.zzbb.zza();
                int i22 = i;
                int iZzC3 = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, i22);
                com.google.android.gms.ads.internal.client.zzbb.zza();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iZzC3, com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, i22));
                String str3 = this.zza;
                switch (str3.hashCode()) {
                    case -1364013995:
                        if (str3.equals("center")) {
                            b2 = 2;
                        }
                        break;
                    case -1012429441:
                        if (str3.equals("top-left")) {
                            b2 = 0;
                        }
                        break;
                    case -655373719:
                        if (str3.equals("bottom-left")) {
                            b2 = 3;
                        }
                        break;
                    case 1163912186:
                        if (str3.equals("bottom-right")) {
                            b2 = 5;
                        }
                        break;
                    case 1288627767:
                        if (str3.equals("bottom-center")) {
                            b2 = 4;
                        }
                        break;
                    case 1755462605:
                        if (str3.equals("top-center")) {
                            b2 = 1;
                        }
                        break;
                }
                if (b2 == 0) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                } else if (b2 == 1) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                } else if (b2 == 2) {
                    layoutParams.addRule(13);
                } else if (b2 == 3) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                } else if (b2 == 4) {
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                } else if (b2 != 5) {
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                } else {
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                }
                this.zzn.setOnClickListener(new zzbuf(this));
                this.zzn.setContentDescription("Close button");
                this.zzq.addView(this.zzn, layoutParams);
                try {
                    PopupWindow popupWindow3 = this.zzp;
                    View decorView = window.getDecorView();
                    com.google.android.gms.ads.internal.client.zzbb.zza();
                    int iZzC4 = com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, iArr[0]);
                    com.google.android.gms.ads.internal.client.zzbb.zza();
                    popupWindow3.showAtLocation(decorView, 0, iZzC4, com.google.android.gms.ads.internal.util.client.zzf.zzC(activity, iArr[1]));
                    int i23 = iArr[0];
                    int i24 = iArr[1];
                    zzbuo zzbuoVar = this.zzo;
                    if (zzbuoVar != null) {
                        zzbuoVar.zza(i23, i24, this.zzh, this.zze);
                    }
                    this.zzj.zzaf(zzcji.zzc(iZzC, iZzC2));
                    int i25 = iArr[0];
                    int i26 = iArr[1];
                    com.google.android.gms.ads.internal.zzt.zzc();
                    zzi(i25, i26 - com.google.android.gms.ads.internal.util.zzs.zzX(this.zzk)[0], this.zzh, this.zze);
                    zzk("resized");
                    return;
                } catch (RuntimeException e) {
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 26);
                    sb.append("Cannot show popup window: ");
                    sb.append(message);
                    zzg(sb.toString());
                    RelativeLayout relativeLayout2 = this.zzq;
                    zzcgy zzcgyVar2 = this.zzj;
                    relativeLayout2.removeView((View) zzcgyVar2);
                    ViewGroup viewGroup2 = this.zzr;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(this.zzm);
                        this.zzr.addView((View) zzcgyVar2);
                        zzcgyVar2.zzaf(this.zzl);
                    }
                    return;
                }
            }
            zzg("Activity context is not ready, cannot get window or decor view.");
        }
    }

    public final void zzb(final boolean z) {
        synchronized (this.zzi) {
            if (this.zzp != null) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlP)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    zzf(z);
                } else {
                    zzcbv.zzf.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbug
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzf(z);
                        }
                    });
                }
            }
        }
    }

    public final void zzc(int i, int i2, boolean z) {
        synchronized (this.zzi) {
            this.zzc = i;
            this.zzd = i2;
        }
    }

    public final boolean zzd() {
        boolean z;
        synchronized (this.zzi) {
            z = this.zzp != null;
        }
        return z;
    }

    public final void zze(int i, int i2) {
        this.zzc = i;
        this.zzd = i2;
    }
}
