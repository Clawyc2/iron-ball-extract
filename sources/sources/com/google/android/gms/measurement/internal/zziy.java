package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziy extends zzf {
    protected zziq zza;
    private volatile zziq zzb;
    private volatile zziq zzc;
    private final Map zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zziq zzg;
    private zziq zzh;
    private boolean zzi;
    private final Object zzj;
    private zziq zzk;
    private String zzl;

    public zziy(zzge zzgeVar) {
        super(zzgeVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(Activity activity, zziq zziqVar, boolean z) {
        zziq zziqVar2;
        zziq zziqVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zziqVar.zzb == null) {
            zziqVar2 = new zziq(zziqVar.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zziqVar.zzc, zziqVar.zze, zziqVar.zzf);
        } else {
            zziqVar2 = zziqVar;
        }
        this.zzc = this.zzb;
        this.zzb = zziqVar2;
        this.zzs.zzaz().zzp(new zzit(this, zziqVar2, zziqVar3, this.zzs.zzav().elapsedRealtime(), z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:48:0x00b8  */
    public final void zzB(zziq zziqVar, zziq zziqVar2, long j, boolean z, Bundle bundle) {
        long j2;
        zzg();
        boolean z2 = false;
        boolean z3 = (zziqVar2 != null && zziqVar2.zzc == zziqVar.zzc && zzir.zza(zziqVar2.zzb, zziqVar.zzb) && zzir.zza(zziqVar2.zza, zziqVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzln.zzK(zziqVar, bundle2, true);
            if (zziqVar2 != null) {
                String str = zziqVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zziqVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zziqVar2.zzc);
            }
            if (z2) {
                zzkm zzkmVar = this.zzs.zzu().zzb;
                long j3 = j - zzkmVar.zzb;
                zzkmVar.zzb = j;
                if (j3 > 0) {
                    this.zzs.zzv().zzI(bundle2, j3);
                }
            }
            if (!this.zzs.zzf().zzu()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != zziqVar.zze ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : "app";
            long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis();
            if (zziqVar.zze) {
                long j4 = zziqVar.zzf;
                if (j4 == 0) {
                    j2 = jCurrentTimeMillis;
                } else {
                    j2 = j4;
                }
            } else {
                j2 = jCurrentTimeMillis;
            }
            this.zzs.zzq().zzH(str3, "_vs", j2, bundle2);
        }
        if (z2) {
            zzC(this.zza, true, j);
        }
        this.zza = zziqVar;
        if (zziqVar.zze) {
            this.zzh = zziqVar;
        }
        this.zzs.zzt().zzG(zziqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzC(zziq zziqVar, boolean z, long j) {
        this.zzs.zzd().zzf(this.zzs.zzav().elapsedRealtime());
        if (!this.zzs.zzu().zzb.zzd(zziqVar != null && zziqVar.zzd, z, j) || zziqVar == null) {
            return;
        }
        zziqVar.zzd = false;
    }

    static /* bridge */ /* synthetic */ void zzp(zziy zziyVar, Bundle bundle, zziq zziqVar, zziq zziqVar2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zziyVar.zzB(zziqVar, zziqVar2, j, true, zziyVar.zzs.zzv().zzy(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    private final zziq zzz(Activity activity) {
        Preconditions.checkNotNull(activity);
        zziq zziqVar = (zziq) this.zzd.get(activity);
        if (zziqVar == null) {
            zziq zziqVar2 = new zziq(null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zziqVar2);
            zziqVar = zziqVar2;
        }
        return this.zzg != null ? this.zzg : zziqVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final zziq zzi() {
        return this.zzb;
    }

    public final zziq zzj(boolean z) {
        zza();
        zzg();
        if (!z) {
            return this.zza;
        }
        zziq zziqVar = this.zza;
        return zziqVar != null ? zziqVar : this.zzh;
    }

    final String zzl(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] strArrSplit = canonicalName.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        this.zzs.zzf();
        if (length2 <= 100) {
            return str2;
        }
        this.zzs.zzf();
        return str2.substring(0, 100);
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzs.zzf().zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zziq(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzs.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long jElapsedRealtime = this.zzs.zzav().elapsedRealtime();
        if (!this.zzs.zzf().zzu()) {
            this.zzb = null;
            this.zzs.zzaz().zzp(new zziv(this, jElapsedRealtime));
        } else {
            zziq zziqVarZzz = zzz(activity);
            this.zzc = this.zzb;
            this.zzb = null;
            this.zzs.zzaz().zzp(new zziw(this, zziqVarZzz, jElapsedRealtime));
        }
    }

    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzs.zzf().zzu()) {
                    this.zzg = null;
                    this.zzs.zzaz().zzp(new zzix(this));
                }
            }
        }
        if (!this.zzs.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzs.zzaz().zzp(new zziu(this));
        } else {
            zzA(activity, zzz(activity), false);
            zzd zzdVarZzd = this.zzs.zzd();
            zzdVarZzd.zzs.zzaz().zzp(new zzc(zzdVarZzd, zzdVarZzd.zzs.zzav().elapsedRealtime()));
        }
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zziq zziqVar;
        if (!this.zzs.zzf().zzu() || bundle == null || (zziqVar = (zziq) this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zziqVar.zzc);
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, zziqVar.zza);
        bundle2.putString("referrer_name", zziqVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r5.length() <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r6.length() <= 100) goto L39;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzw(android.app.Activity r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r2 > 100) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r4 > 100) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziy.zzx(android.os.Bundle, long):void");
    }

    public final void zzy(String str, zziq zziqVar) {
        zzg();
        synchronized (this) {
            String str2 = this.zzl;
            if (str2 == null || str2.equals(str) || zziqVar != null) {
                this.zzl = str;
                this.zzk = zziqVar;
            }
        }
    }
}
