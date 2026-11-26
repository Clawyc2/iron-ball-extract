package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.textclassifier.TextClassifier;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdt;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbkp;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbvb;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzcho;
import com.google.android.gms.internal.ads.zzciu;
import com.google.android.gms.internal.ads.zzciw;
import com.google.android.gms.internal.ads.zzcji;
import com.google.android.gms.internal.ads.zzczb;
import com.google.android.gms.internal.ads.zzdgv;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzegk;
import com.google.android.gms.internal.ads.zzegl;
import com.google.android.gms.internal.ads.zzehd;
import com.google.android.gms.internal.ads.zzehf;
import com.google.android.gms.internal.ads.zzfuz;
import com.google.android.gms.internal.ads.zzgmu;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes.dex */
public class zzm extends zzbvh implements zzah {
    static final int zza = Color.argb(0, 0, 0, 0);
    public static final /* synthetic */ int zzo = 0;
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcgy zzd;
    zzj zze;
    zzu zzf;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    zzi zzl;
    private Runnable zzr;
    private boolean zzs;
    private boolean zzt;
    private Toolbar zzx;
    boolean zzg = false;
    boolean zzj = false;
    boolean zzk = false;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzp = new Object();
    private final View.OnClickListener zzq = new zzd(this);
    private boolean zzu = false;
    private boolean zzv = false;
    private boolean zzw = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048  */
    private final void zzJ(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        boolean z;
        boolean z2;
        com.google.android.gms.ads.internal.zzl zzlVar;
        boolean z3;
        int i;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        boolean z4 = (adOverlayInfoParcel2 == null || (zzlVar2 = adOverlayInfoParcel2.zzo) == null || !zzlVar2.zzb) ? false : true;
        Activity activity = this.zzb;
        boolean zZzd = com.google.android.gms.ads.internal.zzt.zzf().zzd(activity, configuration);
        if (!this.zzk || z4) {
            if (zZzd) {
                if (((Boolean) zzbd.zzc().zzd(zzbeu.zzaW)).booleanValue()) {
                    z = false;
                }
                z2 = z;
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel == null && (zzlVar = adOverlayInfoParcel.zzo) != null && zzlVar.zzg) {
                z = true;
                z2 = z;
            } else {
                z = true;
                z2 = false;
            }
        } else if (((Boolean) zzbd.zzc().zzd(zzbeu.zzaX)).booleanValue()) {
            if (zZzd) {
                if (((Boolean) zzbd.zzc().zzd(zzbeu.zzaW)).booleanValue()) {
                    z = false;
                }
                z2 = z;
            }
            adOverlayInfoParcel = this.zzc;
            if (adOverlayInfoParcel == null) {
            }
            z = true;
            z2 = false;
        } else {
            z = false;
            z2 = z;
        }
        Window window = activity.getWindow();
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzbw)).booleanValue()) {
            View decorView = window.getDecorView();
            if (z) {
                i = z2 ? 5894 : 5380;
                z3 = true;
            } else {
                i = 256;
                z3 = false;
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (z2) {
                window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            }
            z3 = true;
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
            z3 = false;
        }
        if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzoq)).booleanValue() || Build.VERSION.SDK_INT > 34 || Build.VERSION.SDK_INT < 28 || !z3) {
            return;
        }
        window.getAttributes().layoutInDisplayCutoutMode = 1;
        WindowCompat.setDecorFitsSystemWindows(window, false);
    }

    private final void zzK(View view) {
        zzehf zzehfVarZzU;
        zzehd zzehdVarZzV;
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar == null) {
            return;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfS)).booleanValue() && (zzehdVarZzV = zzcgyVar.zzV()) != null) {
            zzehdVarZzV.zzf(view);
        } else if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfR)).booleanValue() && (zzehfVarZzU = zzcgyVar.zzU()) != null && zzehfVarZzU.zzb()) {
            com.google.android.gms.ads.internal.zzt.zzu().zzg(zzehfVarZzU.zza(), view);
        }
    }

    private static final void zzL(zzehf zzehfVar, View view) {
        if (zzehfVar == null || view == null) {
            return;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfR)).booleanValue() && zzehfVar.zzb()) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzh(zzehfVar.zza(), view);
    }

    protected final void zzA() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzrVar;
        if (!this.zzb.isFinishing() || this.zzu) {
            return;
        }
        this.zzu = true;
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null) {
            zzcgyVar.zzH(this.zzn - 1);
            synchronized (this.zzp) {
                if (!this.zzs && this.zzd.zzaa()) {
                    if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfD)).booleanValue() && !this.zzv && (adOverlayInfoParcel = this.zzc) != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
                        zzrVar.zzdX();
                    }
                    this.zzr = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzf
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zzB();
                        }
                    };
                    com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(this.zzr, ((Long) zzbd.zzc().zzd(zzbeu.zzbp)).longValue());
                    return;
                }
            }
        }
        zzB();
    }

    final void zzB() {
        zzcgy zzcgyVar;
        zzr zzrVar;
        if (this.zzv) {
            return;
        }
        this.zzv = true;
        zzcgy zzcgyVar2 = this.zzd;
        if (zzcgyVar2 != null) {
            this.zzl.removeView(zzcgyVar2.zzE());
            zzj zzjVar = this.zze;
            if (zzjVar != null) {
                this.zzd.zzai(zzjVar.zzd);
                this.zzd.zzag(false);
                if (((Boolean) zzbd.zzc().zzd(zzbeu.zznI)).booleanValue() && this.zzd.getParent() != null) {
                    ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzE());
                }
                ViewGroup viewGroup = this.zze.zzc;
                View viewZzE = this.zzd.zzE();
                zzj zzjVar2 = this.zze;
                viewGroup.addView(viewZzE, zzjVar2.zza, zzjVar2.zzb);
                this.zze = null;
            } else {
                Activity activity = this.zzb;
                if (activity.getApplicationContext() != null) {
                    this.zzd.zzai(activity.getApplicationContext());
                }
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdY(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcgyVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzL(zzcgyVar.zzU(), this.zzc.zzd.zzE());
    }

    public final void zzC() {
        if (this.zzm) {
            this.zzm = false;
            zzD();
        }
    }

    protected final void zzD() {
        this.zzd.zzI();
    }

    public final void zzE() {
        this.zzl.zzb = true;
    }

    public final void zzF() {
        synchronized (this.zzp) {
            this.zzs = true;
            if (this.zzr != null) {
                zzfuz zzfuzVar = com.google.android.gms.ads.internal.util.zzs.zza;
                zzfuzVar.removeCallbacks(this.zzr);
                zzfuzVar.post(this.zzr);
            }
        }
    }

    public final void zzG(zzegl zzeglVar) throws RemoteException, zzh {
        zzbvb zzbvbVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbvbVar = adOverlayInfoParcel.zzv) == null) {
            throw new zzh("noioou");
        }
        zzbvbVar.zzh(ObjectWrapper.wrap(zzeglVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzH(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            Activity activity = this.zzb;
            zzegk zzegkVarZze = zzegl.zze();
            zzegkVarZze.zza(activity);
            zzegkVarZze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzi(strArr, iArr, ObjectWrapper.wrap(zzegkVarZze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    public final void zzb() {
        this.zzn = 3;
        Activity activity = this.zzb;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null) {
            zzcgyVar.zzae(null);
        }
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzw(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzt = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzah
    public final void zzd() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdA();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final boolean zzg() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzjT)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zZzZ = this.zzd.zzZ();
        if (!zZzZ) {
            this.zzd.zze("onbackblocked", Collections.emptyMap());
        }
        return zZzZ;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public void zzh(Bundle bundle) {
        zzr zzrVar;
        if (!this.zzt) {
            this.zzb.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            Activity activity = this.zzb;
            AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
            this.zzc = adOverlayInfoParcelZza;
            if (adOverlayInfoParcelZza == null) {
                throw new zzh("Could not get info for ad overlay.");
            }
            if (adOverlayInfoParcelZza.zzw) {
                if (Build.VERSION.SDK_INT >= 28) {
                    activity.setShowWhenLocked(true);
                } else {
                    activity.getWindow().addFlags(524288);
                }
            }
            if (this.zzc.zzm.clientJarVersion > 7500000) {
                this.zzn = 4;
            }
            if (activity.getIntent() != null) {
                this.zzw = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            com.google.android.gms.ads.internal.zzl zzlVar = adOverlayInfoParcel.zzo;
            if (zzlVar != null) {
                boolean z = zzlVar.zza;
                this.zzk = z;
                if (z) {
                    if (adOverlayInfoParcel.zzk != 5 && zzlVar.zzf != -1) {
                        new zzl(this, null).zzb();
                    }
                }
            } else if (adOverlayInfoParcel.zzk == 5) {
                this.zzk = true;
                if (adOverlayInfoParcel.zzk != 5) {
                    new zzl(this, null).zzb();
                }
            } else {
                this.zzk = false;
            }
            if (bundle == null) {
                if (this.zzw) {
                    zzczb zzczbVar = this.zzc.zzt;
                    if (zzczbVar != null) {
                        zzczbVar.zza();
                    }
                    zzr zzrVar2 = this.zzc.zzc;
                    if (zzrVar2 != null) {
                        zzrVar2.zzh();
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                if (adOverlayInfoParcel2.zzk != 1) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.zzb;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                    }
                    zzdgv zzdgvVar = this.zzc.zzu;
                    if (zzdgvVar != null) {
                        zzdgvVar.zzdz();
                    }
                }
            }
            AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
            if (adOverlayInfoParcel3 != null && (zzrVar = adOverlayInfoParcel3.zzc) != null) {
                zzrVar.zzdt();
            }
            AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
            zzi zziVar = new zzi(activity, adOverlayInfoParcel4.zzn, adOverlayInfoParcel4.zzm.afmaVersion, adOverlayInfoParcel4.zzs);
            this.zzl = zziVar;
            zziVar.setId(1000);
            com.google.android.gms.ads.internal.zzt.zzf().zzj(activity);
            AdOverlayInfoParcel adOverlayInfoParcel5 = this.zzc;
            int i = adOverlayInfoParcel5.zzk;
            if (i == 1) {
                zzy(false);
                return;
            }
            if (i == 2) {
                this.zze = new zzj(adOverlayInfoParcel5.zzd);
                zzy(false);
            } else if (i == 3) {
                zzy(true);
            } else {
                if (i != 5) {
                    throw new zzh("Could not determine ad overlay type.");
                }
                zzy(false);
            }
        } catch (zzh e) {
            String message = e.getMessage();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            this.zzn = 4;
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzi() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdv();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzj() {
        zzr zzrVar;
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue()) {
            zzcgy zzcgyVar = this.zzd;
            if (zzcgyVar == null || zzcgyVar.zzX()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("The webview does not exist. Ignoring action.");
            } else {
                this.zzd.onResume();
            }
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdu();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzk() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdC();
        }
        zzJ(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue()) {
            return;
        }
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null && !zzcgyVar.zzX()) {
            this.zzd.onResume();
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzl() {
        zzr zzrVar;
        zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdB();
        }
        if (!((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzm(int i, int i2, Intent intent) {
        zzdvi zzdviVarZzI;
        AdOverlayInfoParcel adOverlayInfoParcel;
        if (i == 236) {
            zzbel zzbelVar = zzbeu.zzog;
            if (((Boolean) zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 66);
                sb.append("Callback from intent launch with requestCode: 236 and resultCode: ");
                sb.append(i2);
                com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
                zzcgy zzcgyVar = this.zzd;
                if (zzcgyVar == null || zzcgyVar.zzP() == null || (zzdviVarZzI = zzcgyVar.zzP().zzI()) == null || (adOverlayInfoParcel = this.zzc) == null || !((Boolean) zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                    return;
                }
                zzdvh zzdvhVarZza = zzdviVarZzI.zza();
                zzdvhVarZza.zzc("action", "hilca");
                zzdvhVarZza.zzc("gqi", zzgmu.zza(adOverlayInfoParcel.zzq));
                StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length());
                sb2.append(i2);
                zzdvhVarZza.zzc("hilr", sb2.toString());
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("callerPackage");
                    String stringExtra2 = intent.getStringExtra("loadingStage");
                    if (stringExtra != null) {
                        zzdvhVarZza.zzc("hilcp", stringExtra);
                    }
                    if (stringExtra2 != null) {
                        zzdvhVarZza.zzc("hills", stringExtra2);
                    }
                }
                zzdvhVarZza.zzf();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzn(IObjectWrapper iObjectWrapper) {
        zzJ((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzp() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdD();
        }
        if (((Boolean) zzbd.zzc().zzd(zzbeu.zzfF)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzq() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdE();
        }
        zzcgy zzcgyVar = this.zzd;
        if (zzcgyVar != null) {
            try {
                this.zzl.removeView(zzcgyVar.zzE());
            } catch (NullPointerException unused) {
            }
        }
        zzA();
    }

    public final void zzr(boolean z) {
        if (this.zzc.zzw) {
            return;
        }
        int iIntValue = ((Integer) zzbd.zzc().zzd(zzbeu.zzfI)).intValue();
        boolean z2 = ((Boolean) zzbd.zzc().zzd(zzbeu.zzbs)).booleanValue() || z;
        zzt zztVar = new zzt();
        zztVar.zzd = 50;
        zztVar.zza = true != z2 ? 0 : iIntValue;
        zztVar.zzb = true != z2 ? iIntValue : 0;
        zztVar.zzc = iIntValue;
        this.zzf = new zzu(this.zzb, zztVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        zzt(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
        zzK(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzs() {
        this.zzt = true;
    }

    public final void zzt(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzl zzlVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzbd.zzc().zzd(zzbeu.zzbq)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzlVar2 = adOverlayInfoParcel2.zzo) != null && zzlVar2.zzh;
        boolean z5 = ((Boolean) zzbd.zzc().zzd(zzbeu.zzbr)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzlVar = adOverlayInfoParcel.zzo) != null && zzlVar.zzi;
        if (z && z2 && z4 && !z5) {
            new zzbun(this.zzd, "useCustomClose").zzg("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzu zzuVar = this.zzf;
        if (zzuVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzuVar.zza(z3);
        }
    }

    public final void zzu(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    public final void zzv() {
        this.zzl.removeView(this.zzf);
        zzr(true);
    }

    public final void zzw(int i) {
        Activity activity = this.zzb;
        if (activity.getApplicationInfo().targetSdkVersion >= ((Integer) zzbd.zzc().zzd(zzbeu.zzgA)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) zzbd.zzc().zzd(zzbeu.zzgB)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzbd.zzc().zzd(zzbeu.zzgC)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzbd.zzc().zzd(zzbeu.zzgD)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzx(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.zzb;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzh.addView(view, -1, -1);
        activity.setContentView(this.zzh);
        this.zzt = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    protected final void zzy(boolean z) throws zzh {
        boolean z2;
        Resources.Theme theme;
        ?? r2;
        if (!this.zzt) {
            this.zzb.requestWindowFeature(1);
        }
        Activity activity = this.zzb;
        Window window = activity.getWindow();
        if (window == null) {
            throw new zzh("Invalid activity, no window available.");
        }
        zzcgy zzcgyVar = this.zzc.zzd;
        zzciw zzciwVarZzP = zzcgyVar != null ? zzcgyVar.zzP() : null;
        boolean z3 = zzciwVarZzP != null && zzciwVarZzP.zzk();
        this.zzm = false;
        if (z3) {
            int i = this.zzc.zzj;
            if (i == 6) {
                z2 = activity.getResources().getConfiguration().orientation == 1;
                this.zzm = z2;
            } else if (i == 7) {
                z2 = activity.getResources().getConfiguration().orientation == 2;
                this.zzm = z2;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(z2).length() + 41);
        sb.append("Delay onShow to next orientation change: ");
        sb.append(z2);
        String string = sb.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
        zzw(this.zzc.zzj);
        window.setFlags(16777216, 16777216);
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Hardware acceleration on the AdActivity window enabled.");
        if (this.zzk) {
            this.zzl.setBackgroundColor(zza);
        } else {
            this.zzl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        activity.setContentView(this.zzl);
        this.zzt = true;
        if (z) {
            try {
                com.google.android.gms.ads.internal.zzt.zzd();
                zzcgy zzcgyVar2 = this.zzc.zzd;
                zzcji zzcjiVarZzN = zzcgyVar2 != null ? zzcgyVar2.zzN() : null;
                zzcgy zzcgyVar3 = this.zzc.zzd;
                String strZzO = zzcgyVar3 != null ? zzcgyVar3.zzO() : null;
                AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                VersionInfoParcel versionInfoParcel = adOverlayInfoParcel.zzm;
                zzcgy zzcgyVar4 = adOverlayInfoParcel.zzd;
                String str = strZzO;
                theme = null;
                boolean z4 = false;
                zzcgy zzcgyVarZza = zzcho.zza(activity, zzcjiVarZzN, str, true, z3, null, null, versionInfoParcel, null, null, zzcgyVar4 != null ? zzcgyVar4.zzk() : null, zzbdt.zza(), null, null, null, null, null);
                this.zzd = zzcgyVarZza;
                zzciw zzciwVarZzP2 = zzcgyVarZza.zzP();
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                zzbkn zzbknVar = adOverlayInfoParcel2.zzp;
                zzbkp zzbkpVar = adOverlayInfoParcel2.zze;
                zzad zzadVar = adOverlayInfoParcel2.zzi;
                zzcgy zzcgyVar5 = adOverlayInfoParcel2.zzd;
                zzciwVarZzP2.zzZ(null, zzbknVar, null, zzbkpVar, zzadVar, true, null, zzcgyVar5 != null ? zzcgyVar5.zzP().zzh() : null, null, null, null, null, null, null, null, null, null, null, null, null, null);
                this.zzd.zzP().zzG(new zzciu() { // from class: com.google.android.gms.ads.internal.overlay.zzg
                    @Override // com.google.android.gms.internal.ads.zzciu
                    public final /* synthetic */ void zza(boolean z5, int i3, String str2, String str3) {
                        zzcgy zzcgyVar6 = this.zza.zzd;
                        if (zzcgyVar6 != null) {
                            zzcgyVar6.zzI();
                        }
                    }
                });
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                String str2 = adOverlayInfoParcel3.zzl;
                if (str2 != null) {
                    this.zzd.loadUrl(str2);
                } else {
                    String str3 = adOverlayInfoParcel3.zzh;
                    if (str3 == null) {
                        throw new zzh("No URL or HTML to display in ad overlay.");
                    }
                    this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str3, "text/html", "UTF-8", null);
                }
                zzcgy zzcgyVar6 = this.zzc.zzd;
                r2 = z4;
                if (zzcgyVar6 != null) {
                    zzcgyVar6.zzan(this);
                    r2 = z4;
                }
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error obtaining webview.", e);
                throw new zzh("Could not obtain webview for the overlay.", e);
            }
        } else {
            theme = null;
            r2 = 0;
            zzcgy zzcgyVar7 = this.zzc.zzd;
            this.zzd = zzcgyVar7;
            zzcgyVar7.zzai(this.zzb);
        }
        if (this.zzc.zzw) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.zzd.zzD(), r2);
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzbh)).booleanValue() && Build.VERSION.SDK_INT >= 27) {
                this.zzd.zzD().setTextClassifier(TextClassifier.NO_OP);
            }
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzbi)).booleanValue()) {
                this.zzd.zzD().setDownloadListener(zze.zza);
            }
        }
        this.zzd.zzae(this);
        zzcgy zzcgyVar8 = this.zzc.zzd;
        if (zzcgyVar8 != null) {
            zzL(zzcgyVar8.zzU(), this.zzl);
        }
        if (this.zzc.zzk != 5) {
            ViewParent parent = this.zzd.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzd.zzE());
            }
            if (this.zzk) {
                this.zzd.zzat();
            }
            if (this.zzc.zzw) {
                Toolbar toolbar = new Toolbar(this.zzb);
                this.zzx = toolbar;
                toolbar.setId(View.generateViewId());
                this.zzd.zzE().setId(View.generateViewId());
                this.zzx.setBackgroundColor(-12303292);
                this.zzx.setVisibility(r2);
                try {
                    this.zzx.setNavigationIcon(com.google.android.gms.ads.internal.zzt.zzh().zzf().getDrawable(R.drawable.admob_close_button_white_cross, theme));
                } catch (Resources.NotFoundException | NullPointerException e2) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Error obtaining close icon.", e2);
                }
                this.zzx.setNavigationOnClickListener(this.zzq);
                this.zzx.setTitleMarginStart(r2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(10);
                this.zzl.addView(this.zzx, layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(3, this.zzx.getId());
                layoutParams2.addRule(12);
                this.zzl.addView(this.zzd.zzE(), layoutParams2);
                zzK(this.zzx);
            } else {
                this.zzl.addView(this.zzd.zzE(), -1, -1);
            }
        }
        if (!z && !this.zzm) {
            zzD();
        }
        if (this.zzc.zzk != 5) {
            zzr(z3);
            if (this.zzd.zzR()) {
                zzt(z3, true);
                return;
            }
            return;
        }
        Activity activity2 = this.zzb;
        zzegk zzegkVarZze = zzegl.zze();
        zzegkVarZze.zza(activity2);
        zzegkVarZze.zzb(this);
        zzegkVarZze.zzc(this.zzc.zzq);
        zzegkVarZze.zzd(this.zzc.zzr);
        try {
            zzG(zzegkVarZze.zze());
        } catch (RemoteException | zzh e3) {
            throw new zzh(e3.getMessage(), e3);
        }
    }

    public final void zzz(String str) {
        Toolbar toolbar = this.zzx;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }
}
