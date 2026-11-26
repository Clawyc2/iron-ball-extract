package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzpo;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzel extends zzf {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    zzel(zzge zzgeVar, long j) {
        super(zzgeVar);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = j;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:37:0x0101  */
    /* JADX WARN: Code duplicated, block: B:38:0x0111  */
    /* JADX WARN: Code duplicated, block: B:39:0x0121  */
    /* JADX WARN: Code duplicated, block: B:40:0x0131  */
    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    /* JADX WARN: Code duplicated, block: B:42:0x0151  */
    /* JADX WARN: Code duplicated, block: B:45:0x016b  */
    /* JADX WARN: Code duplicated, block: B:48:0x018b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0194 A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:54:0x01ae A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x01bc A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01d2 A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x01d5 A[Catch: IllegalStateException -> 0x01db, TryCatch #3 {IllegalStateException -> 0x01db, blocks: (B:46:0x0173, B:49:0x018c, B:51:0x0194, B:55:0x01b2, B:54:0x01ae, B:57:0x01bc, B:59:0x01d2, B:61:0x01d7, B:60:0x01d5), top: B:89:0x0173 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0206  */
    /* JADX WARN: Code duplicated, block: B:70:0x020c  */
    /* JADX WARN: Code duplicated, block: B:71:0x021c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0226  */
    /* JADX WARN: Code duplicated, block: B:77:0x023b  */
    /* JADX WARN: Code duplicated, block: B:79:0x023f  */
    /* JADX WARN: Code duplicated, block: B:81:0x024c  */
    /* JADX WARN: Code duplicated, block: B:91:0x023b A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.measurement.internal.zzf
    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    protected final void zzd() {
        String str;
        String string;
        Object[] objArr;
        int iZza;
        List listZzp;
        Iterator it;
        String strZzc;
        String str2;
        Context contextZzau;
        String strZzz;
        String packageName = this.zzs.zzau().getPackageName();
        PackageManager packageManager = this.zzs.zzau().getPackageManager();
        int i = Integer.MIN_VALUE;
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        String str3 = "Unknown";
        try {
            if (packageManager != null) {
                try {
                    installerPackageName = packageManager.getInstallerPackageName(packageName);
                } catch (IllegalArgumentException unused) {
                    this.zzs.zzay().zzd().zzb("Error retrieving app installer package name. appId", zzeu.zzn(packageName));
                }
                if (installerPackageName == null) {
                    installerPackageName = "manual_install";
                } else if ("com.android.vending".equals(installerPackageName)) {
                    installerPackageName = "";
                }
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(this.zzs.zzau().getPackageName(), 0);
                    if (packageInfo != null) {
                        CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                        string = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                        try {
                            str3 = packageInfo.versionName;
                            i = packageInfo.versionCode;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            str = str3;
                            str3 = string;
                            this.zzs.zzay().zzd().zzc("Error retrieving package info. appId, appName", zzeu.zzn(packageName), str3);
                            string = str3;
                            str3 = str;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused3) {
                    str = "Unknown";
                }
                this.zza = packageName;
                this.zzd = installerPackageName;
                this.zzb = str3;
                this.zzc = i;
                this.zze = string;
                this.zzf = 0L;
                if (TextUtils.isEmpty(this.zzs.zzw()) && "am".equals(this.zzs.zzx())) {
                    objArr = true;
                } else {
                    objArr = false;
                }
                iZza = this.zzs.zza();
                switch (iZza) {
                    case 0:
                        this.zzs.zzay().zzj().zza("App measurement collection enabled");
                        break;
                    case 1:
                        this.zzs.zzay().zzi().zza("App measurement deactivated via the manifest");
                        break;
                    case 2:
                        this.zzs.zzay().zzj().zza("App measurement deactivated via the init parameters");
                        break;
                    case 3:
                        this.zzs.zzay().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                        break;
                    case 4:
                        this.zzs.zzay().zzi().zza("App measurement disabled via the manifest");
                        break;
                    case 5:
                        this.zzs.zzay().zzj().zza("App measurement disabled via the init parameters");
                        break;
                    case 6:
                        this.zzs.zzay().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                        break;
                    case 7:
                        this.zzs.zzay().zzi().zza("App measurement disabled via the global data collection setting");
                        break;
                    default:
                        this.zzs.zzay().zzi().zza("App measurement disabled due to denied storage consent");
                        break;
                }
                this.zzk = "";
                this.zzl = "";
                this.zzs.zzaw();
                if (objArr != false) {
                    this.zzl = this.zzs.zzw();
                }
                strZzc = zzip.zzc(this.zzs.zzau(), "google_app_id", this.zzs.zzz());
                this.zzk = true != TextUtils.isEmpty(strZzc) ? strZzc : "";
                if (!TextUtils.isEmpty(strZzc)) {
                    contextZzau = this.zzs.zzau();
                    strZzz = this.zzs.zzz();
                    Preconditions.checkNotNull(contextZzau);
                    Resources resources = contextZzau.getResources();
                    if (!TextUtils.isEmpty(strZzz)) {
                        strZzz = zzfw.zza(contextZzau);
                    }
                    this.zzl = zzfw.zzb("admob_app_id", resources, strZzz);
                }
                if (iZza == 0) {
                    zzes zzesVarZzj = this.zzs.zzay().zzj();
                    String str4 = this.zza;
                    if (TextUtils.isEmpty(this.zzk)) {
                        str2 = this.zzl;
                    } else {
                        str2 = this.zzk;
                    }
                    zzesVarZzj.zzc("App measurement enabled for app package, google app id", str4, str2);
                }
                this.zzh = null;
                this.zzs.zzaw();
                listZzp = this.zzs.zzf().zzp("analytics.safelisted_events");
                if (listZzp != null) {
                    this.zzh = listZzp;
                } else if (listZzp.isEmpty()) {
                    this.zzs.zzay().zzl().zza("Safelisted event list is empty. Ignoring");
                } else {
                    it = listZzp.iterator();
                    do {
                        if (it.hasNext()) {
                            this.zzh = listZzp;
                        }
                    } while (this.zzs.zzv().zzab("safelisted event", (String) it.next()));
                }
                if (packageManager != null) {
                    this.zzj = InstantApps.isInstantApp(this.zzs.zzau()) ? 1 : 0;
                } else {
                    this.zzj = 0;
                }
            }
            this.zzs.zzay().zzd().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzeu.zzn(packageName));
            strZzc = zzip.zzc(this.zzs.zzau(), "google_app_id", this.zzs.zzz());
            this.zzk = true != TextUtils.isEmpty(strZzc) ? strZzc : "";
            if (!TextUtils.isEmpty(strZzc)) {
                contextZzau = this.zzs.zzau();
                strZzz = this.zzs.zzz();
                Preconditions.checkNotNull(contextZzau);
                Resources resources2 = contextZzau.getResources();
                if (!TextUtils.isEmpty(strZzz)) {
                    strZzz = zzfw.zza(contextZzau);
                }
                this.zzl = zzfw.zzb("admob_app_id", resources2, strZzz);
            }
            if (iZza == 0) {
                zzes zzesVarZzj2 = this.zzs.zzay().zzj();
                String str5 = this.zza;
                if (TextUtils.isEmpty(this.zzk)) {
                    str2 = this.zzl;
                } else {
                    str2 = this.zzk;
                }
                zzesVarZzj2.zzc("App measurement enabled for app package, google app id", str5, str2);
            }
        } catch (IllegalStateException e) {
            this.zzs.zzay().zzd().zzc("Fetching Google App Id failed with exception. appId", zzeu.zzn(packageName), e);
        }
        string = "Unknown";
        this.zza = packageName;
        this.zzd = installerPackageName;
        this.zzb = str3;
        this.zzc = i;
        this.zze = string;
        this.zzf = 0L;
        if (TextUtils.isEmpty(this.zzs.zzw())) {
            objArr = false;
        } else {
            objArr = false;
        }
        iZza = this.zzs.zza();
        switch (iZza) {
            case 0:
                this.zzs.zzay().zzj().zza("App measurement collection enabled");
                break;
            case 1:
                this.zzs.zzay().zzi().zza("App measurement deactivated via the manifest");
                break;
            case 2:
                this.zzs.zzay().zzj().zza("App measurement deactivated via the init parameters");
                break;
            case 3:
                this.zzs.zzay().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            case 4:
                this.zzs.zzay().zzi().zza("App measurement disabled via the manifest");
                break;
            case 5:
                this.zzs.zzay().zzj().zza("App measurement disabled via the init parameters");
                break;
            case 6:
                this.zzs.zzay().zzl().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            case 7:
                this.zzs.zzay().zzi().zza("App measurement disabled via the global data collection setting");
                break;
            default:
                this.zzs.zzay().zzi().zza("App measurement disabled due to denied storage consent");
                break;
        }
        this.zzk = "";
        this.zzl = "";
        this.zzs.zzaw();
        if (objArr != false) {
            this.zzl = this.zzs.zzw();
        }
        this.zzh = null;
        this.zzs.zzaw();
        listZzp = this.zzs.zzf().zzp("analytics.safelisted_events");
        if (listZzp != null) {
            this.zzh = listZzp;
        } else if (listZzp.isEmpty()) {
            this.zzs.zzay().zzl().zza("Safelisted event list is empty. Ignoring");
        } else {
            it = listZzp.iterator();
            do {
                if (it.hasNext()) {
                    this.zzh = listZzp;
                }
            } while (this.zzs.zzv().zzab("safelisted event", (String) it.next()));
        }
        if (packageManager != null) {
            this.zzj = InstantApps.isInstantApp(this.zzs.zzau()) ? 1 : 0;
        } else {
            this.zzj = 0;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return true;
    }

    final int zzh() {
        zza();
        return this.zzj;
    }

    final int zzi() {
        zza();
        return this.zzc;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:51:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:54:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:55:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:58:0x021b  */
    /* JADX WARN: Code duplicated, block: B:60:0x022c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0239  */
    /* JADX WARN: Code duplicated, block: B:62:0x023e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0256  */
    /* JADX WARN: Code duplicated, block: B:68:0x0260  */
    /* JADX WARN: Code duplicated, block: B:77:0x0286  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzq zzj(String str) {
        String str2;
        zzge zzgeVar;
        long jZza;
        long jMin;
        Boolean boolZzk;
        Boolean boolValueOf;
        long j;
        long j2;
        String str3;
        zzg();
        String strZzl = zzl();
        String strZzm = zzm();
        zza();
        String str4 = this.zzb;
        zza();
        long j3 = this.zzc;
        zza();
        Preconditions.checkNotNull(this.zzd);
        String str5 = this.zzd;
        this.zzs.zzf().zzh();
        zza();
        zzg();
        long j4 = this.zzf;
        if (j4 == 0) {
            zzln zzlnVarZzv = this.zzs.zzv();
            Context contextZzau = this.zzs.zzau();
            String packageName = this.zzs.zzau().getPackageName();
            zzlnVarZzv.zzg();
            Preconditions.checkNotNull(contextZzau);
            Preconditions.checkNotEmpty(packageName);
            PackageManager packageManager = contextZzau.getPackageManager();
            MessageDigest messageDigestZzF = zzln.zzF();
            long jZzp = -1;
            if (messageDigestZzF == null) {
                zzlnVarZzv.zzs.zzay().zzd().zza("Could not get MD5 instance");
            } else {
                if (packageManager != null) {
                    try {
                        if (zzlnVarZzv.zzag(contextZzau, packageName)) {
                            jZzp = 0;
                        } else {
                            PackageInfo packageInfo = Wrappers.packageManager(contextZzau).getPackageInfo(zzlnVarZzv.zzs.zzau().getPackageName(), 64);
                            if (packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                                zzlnVarZzv.zzs.zzay().zzk().zza("Could not get signatures");
                            } else {
                                jZzp = zzln.zzp(messageDigestZzF.digest(packageInfo.signatures[0].toByteArray()));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        zzlnVarZzv.zzs.zzay().zzd().zzb("Package name not found", e);
                        j4 = 0;
                    }
                }
                j4 = 0;
                this.zzf = j4;
            }
            j4 = jZzp;
            this.zzf = j4;
        }
        boolean zZzJ = this.zzs.zzJ();
        boolean z = !this.zzs.zzm().zzk;
        zzg();
        if (this.zzs.zzJ()) {
            zzpo.zzc();
            if (this.zzs.zzf().zzs(null, zzeh.zzaa)) {
                this.zzs.zzay().zzj().zza("Disabled IID for tests.");
            } else {
                try {
                    Class<?> clsLoadClass = this.zzs.zzau().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if (clsLoadClass != null) {
                        try {
                            try {
                                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzs.zzau());
                                if (objInvoke == null) {
                                    z = z;
                                    str2 = null;
                                } else {
                                    z = z;
                                    try {
                                        str2 = (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                                    } catch (Exception unused) {
                                        this.zzs.zzay().zzl().zza("Failed to retrieve Firebase Instance Id");
                                        str2 = null;
                                    }
                                }
                            } catch (Exception unused2) {
                                this.zzs.zzay().zzm().zza("Failed to obtain Firebase Analytics instance");
                                str2 = null;
                                zzgeVar = this.zzs;
                                jZza = zzgeVar.zzm().zzc.zza();
                                if (jZza == 0) {
                                    jMin = zzgeVar.zzc;
                                } else {
                                    jMin = Math.min(zzgeVar.zzc, jZza);
                                }
                                zza();
                                int i = this.zzj;
                                boolean zZzr = this.zzs.zzf().zzr();
                                zzfj zzfjVarZzm = this.zzs.zzm();
                                zzfjVarZzm.zzg();
                                String str6 = str2;
                                boolean z2 = zzfjVarZzm.zza().getBoolean("deferred_analytics_collection", false);
                                zza();
                                String str7 = this.zzl;
                                boolZzk = this.zzs.zzf().zzk("google_analytics_default_allow_ad_personalization_signals");
                                if (boolZzk == null) {
                                    boolValueOf = null;
                                } else {
                                    boolValueOf = Boolean.valueOf(!boolZzk.booleanValue());
                                }
                                j = this.zzg;
                                List list = this.zzh;
                                String strZzh = this.zzs.zzm().zzc().zzh();
                                if (this.zzi == null) {
                                    j2 = j;
                                    if (this.zzs.zzf().zzs(null, zzeh.zzaE)) {
                                        this.zzi = this.zzs.zzv().zzC();
                                    } else {
                                        this.zzi = "";
                                    }
                                } else {
                                    j2 = j;
                                }
                                String str8 = this.zzi;
                                zzpi.zzc();
                                str3 = null;
                                if (this.zzs.zzf().zzs(null, zzeh.zzaz)) {
                                    zzg();
                                    if (this.zzn != 0) {
                                        long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis() - this.zzn;
                                        if (this.zzm != null) {
                                            zzo();
                                        }
                                    }
                                    if (this.zzm == null) {
                                        zzo();
                                    }
                                    str3 = this.zzm;
                                }
                                return new zzq(strZzl, strZzm, str4, j3, str5, 68000L, j4, str, zZzJ, z, str6, 0L, jMin, i, zZzr, z2, str7, boolValueOf, j2, list, (String) null, strZzh, str8, str3);
                            }
                        } catch (Exception unused3) {
                        }
                    }
                } catch (ClassNotFoundException unused4) {
                    z = z;
                }
            }
            z = z;
            str2 = null;
        } else {
            z = z;
            str2 = null;
        }
        zzgeVar = this.zzs;
        jZza = zzgeVar.zzm().zzc.zza();
        if (jZza == 0) {
            jMin = zzgeVar.zzc;
        } else {
            jMin = Math.min(zzgeVar.zzc, jZza);
        }
        zza();
        int i2 = this.zzj;
        boolean zZzr2 = this.zzs.zzf().zzr();
        zzfj zzfjVarZzm2 = this.zzs.zzm();
        zzfjVarZzm2.zzg();
        String str9 = str2;
        boolean z3 = zzfjVarZzm2.zza().getBoolean("deferred_analytics_collection", false);
        zza();
        String str10 = this.zzl;
        boolZzk = this.zzs.zzf().zzk("google_analytics_default_allow_ad_personalization_signals");
        if (boolZzk == null) {
            boolValueOf = null;
        } else {
            boolValueOf = Boolean.valueOf(!boolZzk.booleanValue());
        }
        j = this.zzg;
        List list2 = this.zzh;
        String strZzh2 = this.zzs.zzm().zzc().zzh();
        if (this.zzi == null) {
            j2 = j;
            if (this.zzs.zzf().zzs(null, zzeh.zzaE)) {
                this.zzi = this.zzs.zzv().zzC();
            } else {
                this.zzi = "";
            }
        } else {
            j2 = j;
        }
        String str11 = this.zzi;
        zzpi.zzc();
        str3 = null;
        if (this.zzs.zzf().zzs(null, zzeh.zzaz)) {
            zzg();
            if (this.zzn != 0) {
                long jCurrentTimeMillis2 = this.zzs.zzav().currentTimeMillis() - this.zzn;
                if (this.zzm != null && jCurrentTimeMillis2 > 86400000 && this.zzo == null) {
                    zzo();
                }
            }
            if (this.zzm == null) {
                zzo();
            }
            str3 = this.zzm;
        }
        return new zzq(strZzl, strZzm, str4, j3, str5, 68000L, j4, str, zZzJ, z, str9, 0L, jMin, i2, zZzr2, z3, str10, boolValueOf, j2, list2, (String) null, strZzh2, str11, str3);
    }

    final String zzk() {
        zza();
        return this.zzl;
    }

    final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    final List zzn() {
        return this.zzh;
    }

    final void zzo() {
        String str;
        zzg();
        if (this.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            this.zzs.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            this.zzs.zzay().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        }
        this.zzs.zzay().zzc().zza(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.zzm = str;
        this.zzn = this.zzs.zzav().currentTimeMillis();
    }

    final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z = false;
        if (str2 != null && !str2.equals(str)) {
            z = true;
        }
        this.zzo = str;
        return z;
    }
}
