package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaaw implements zzbt {
    private final Context zza;
    private final zzbs zzb;
    private final SparseArray zzc;
    private final boolean zzd;
    private final zzabx zze;
    private final zzdc zzf;
    private final CopyOnWriteArraySet zzg;
    private final long zzh;
    private final zzabb zzi;
    private zzel zzj = new zzel(10);
    private zzv zzk;
    private zzdm zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private long zzq;
    private int zzr;

    /* synthetic */ zzaaw(zzaao zzaaoVar, byte[] bArr) {
        this.zza = zzaaoVar.zze();
        zzbs zzbsVarZzg = zzaaoVar.zzg();
        zzbsVarZzg.getClass();
        this.zzb = zzbsVarZzg;
        this.zzc = new SparseArray();
        zzgpe.zzi();
        this.zzd = zzaaoVar.zzh();
        zzdc zzdcVarZzi = zzaaoVar.zzi();
        this.zzf = zzdcVarZzi;
        this.zzh = zzaaoVar.zzj() != -9223372036854775807L ? -zzaaoVar.zzj() : -9223372036854775807L;
        zzabb zzabbVarZzk = zzaaoVar.zzk();
        this.zzi = zzabbVarZzk;
        this.zze = new zzaab(zzaaoVar.zzf(), zzabbVarZzk, zzdcVarZzi);
        new zzaan(this);
        this.zzg = new CopyOnWriteArraySet();
        this.zzk = new zzt().zzM();
        this.zzp = -9223372036854775807L;
        this.zzq = -9223372036854775807L;
        this.zzr = -1;
        this.zzo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zzi zzC(zzi zziVar) {
        return (zziVar == null || !zziVar.zzf()) ? zzi.zza : zziVar;
    }

    final /* synthetic */ void zzA(long j) {
        this.zzq = j;
    }

    public final void zza(int i) {
        this.zzr = 1;
    }

    public final zzabx zzb(int i) {
        SparseArray sparseArray = this.zzc;
        if (zzep.zza(sparseArray, 0)) {
            return (zzabx) sparseArray.get(0);
        }
        zzaaq zzaaqVar = new zzaaq(this, this.zza, 0);
        this.zzg.add(zzaaqVar);
        sparseArray.put(0, zzaaqVar);
        return zzaaqVar;
    }

    public final void zzc(Surface surface, zzeh zzehVar) {
        Pair pair = this.zzm;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzeh) this.zzm.second).equals(zzehVar)) {
            return;
        }
        this.zzm = Pair.create(surface, zzehVar);
        zzehVar.zza();
        zzehVar.zzb();
    }

    public final void zzd() {
        zzeh zzehVar = zzeh.zza;
        zzehVar.zza();
        zzehVar.zzb();
        this.zzm = null;
    }

    public final void zze() {
        this.zze.zza();
    }

    public final void zzf() {
        this.zze.zzb();
    }

    public final void zzg() {
        if (this.zzo == 2) {
            return;
        }
        zzdm zzdmVar = this.zzl;
        if (zzdmVar != null) {
            zzdmVar.zzl(null);
        }
        this.zzm = null;
        this.zzo = 2;
    }

    final /* synthetic */ void zzh() {
        this.zzn--;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0057  */
    /* JADX WARN: Code duplicated, block: B:24:0x005a  */
    /* JADX WARN: Code duplicated, block: B:26:0x005e A[Catch: zzdj -> 0x0094, TRY_LEAVE, TryCatch #1 {zzdj -> 0x0094, blocks: (B:7:0x0010, B:9:0x0015, B:11:0x001b, B:14:0x0022, B:16:0x0030, B:18:0x0036, B:21:0x003d, B:26:0x005e), top: B:38:0x0010 }] */
    final /* synthetic */ boolean zzi(zzv zzvVar, int i) throws zzabw {
        zzgmd.zzh(this.zzo == 0);
        zzi zziVarZzC = zzC(zzvVar.zzE);
        try {
            int i2 = zziVarZzC.zzd;
            if (i2 != 7) {
                if (zzdk.zzc(i2) && Build.VERSION.SDK_INT >= 29) {
                    Object[] objArr = {Integer.valueOf(i2)};
                    String str = zzep.zza;
                    zzdt.zzc("PlaybackVidGraphWrapper", String.format(Locale.US, "Color transfer %d is not supported. Falling back to OpenGl tone mapping.", objArr));
                    zziVarZzC = zzi.zza;
                } else if (i2 != 2 || i2 == 10) {
                    zziVarZzC = zzi.zza;
                }
            } else if (Build.VERSION.SDK_INT >= 34 || !zzdk.zzd()) {
                i2 = 7;
                if (zzdk.zzc(i2)) {
                    if (i2 != 2) {
                        zziVarZzC = zzi.zza;
                    } else {
                        zziVarZzC = zzi.zza;
                    }
                } else if (i2 != 2) {
                    zziVarZzC = zzi.zza;
                } else {
                    zziVarZzC = zzi.zza;
                }
            } else {
                zzh zzhVarZzd = zziVarZzC.zzd();
                zzhVarZzd.zzc(6);
                zziVarZzC = zzhVarZzd.zzg();
            }
            zzi zziVar = zziVarZzC;
            zzdc zzdcVar = this.zzf;
            Looper looperMyLooper = Looper.myLooper();
            looperMyLooper.getClass();
            this.zzl = zzdcVar.zzd(looperMyLooper, null);
            try {
                zzbs zzbsVar = this.zzb;
                Context context = this.zza;
                zzl zzlVar = zzl.zzb;
                final zzdm zzdmVar = this.zzl;
                Objects.requireNonNull(zzdmVar);
                zzbsVar.zza(context, zziVar, zzlVar, this, new Executor() { // from class: com.google.android.gms.internal.ads.zzaap
                    @Override // java.util.concurrent.Executor
                    public final /* synthetic */ void execute(Runnable runnable) {
                        zzdmVar.zzm(runnable);
                    }
                }, 0L, false);
                throw null;
            } catch (zzbo e) {
                throw new zzabw(e, zzvVar);
            }
        } catch (zzdj e2) {
            throw new zzabw(e2, zzvVar);
        }
    }

    final /* synthetic */ boolean zzj(boolean z) {
        return this.zze.zzh(false);
    }

    final /* synthetic */ void zzk() {
        this.zze.zzi();
    }

    final /* synthetic */ void zzl(long j, long j2) throws zzabw {
        this.zze.zzv(j, j2);
    }

    final /* synthetic */ void zzm(boolean z) {
        if (this.zzo == 1) {
            this.zzn++;
            zzabx zzabxVar = this.zze;
            zzabxVar.zzg(z);
            while (this.zzj.zzc() > 1) {
                this.zzj.zzd();
            }
            if (this.zzj.zzc() == 1) {
                zzaav zzaavVar = (zzaav) this.zzj.zzd();
                zzaavVar.getClass();
                zzabxVar.zzs(1, this.zzk, zzaavVar.zza, zzaavVar.zzb, zzgpe.zzi());
            }
            this.zzp = -9223372036854775807L;
            this.zzq = -9223372036854775807L;
            zzdm zzdmVar = this.zzl;
            zzdmVar.getClass();
            zzdmVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaar
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzh();
                }
            });
        }
    }

    final /* synthetic */ void zzn(boolean z) {
        this.zze.zzw(z);
    }

    final /* synthetic */ void zzo() {
        this.zze.zzt();
    }

    final /* synthetic */ void zzp(zzaax zzaaxVar) {
        this.zze.zzl(zzaaxVar);
    }

    final /* synthetic */ void zzq(float f) {
        this.zzi.zzc(f);
        this.zze.zzm(f);
    }

    final /* synthetic */ void zzr(int i) {
        this.zze.zzr(i);
    }

    final /* synthetic */ boolean zzs() {
        int i = this.zzr;
        return i != -1 && i == 0;
    }

    final /* synthetic */ boolean zzt() {
        return this.zzd;
    }

    final /* synthetic */ long zzu() {
        return this.zzh;
    }

    final /* synthetic */ zzabb zzv() {
        return this.zzi;
    }

    final /* synthetic */ zzel zzw() {
        return this.zzj;
    }

    final /* synthetic */ void zzx(zzel zzelVar) {
        this.zzj = zzelVar;
    }

    final /* synthetic */ long zzy() {
        return this.zzp;
    }

    final /* synthetic */ long zzz() {
        return this.zzq;
    }
}
