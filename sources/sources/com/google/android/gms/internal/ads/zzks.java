package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzks {
    private final zzmi zzc;
    private final zzdm zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzil zzh;
    private zzkp zzi;
    private zzkp zzj;
    private zzkp zzk;
    private zzkp zzl;
    private zzkp zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzka zzr;
    private final zzbd zza = new zzbd();
    private final zzbe zzb = new zzbe();
    private List zzq = new ArrayList();

    public zzks(zzmi zzmiVar, zzdm zzdmVar, zzka zzkaVar, zzil zzilVar) {
        this.zzc = zzmiVar;
        this.zzd = zzdmVar;
        this.zzr = zzkaVar;
        this.zzh = zzilVar;
    }

    private static zzuu zzA(zzbf zzbfVar, Object obj, long j, long j2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbfVar.zzo(obj, zzbdVar);
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzbfVar.zze(obj);
        zzbdVar.zzb();
        zzbfVar.zzo(obj, zzbdVar);
        int iZze = zzbdVar.zze(j);
        return iZze == -1 ? new zzuu(obj, j2, zzbdVar.zzf(j)) : new zzuu(obj, iZze, zzbdVar.zzd(iZze), j2);
    }

    private final void zzB() {
        int i = zzgpe.zzd;
        final zzgpb zzgpbVar = new zzgpb();
        for (zzkp zzkpVarZzp = this.zzi; zzkpVarZzp != null; zzkpVarZzp = zzkpVarZzp.zzp()) {
            zzgpbVar.zzf(zzkpVarZzp.zzg.zza);
        }
        zzkp zzkpVar = this.zzj;
        final zzuu zzuuVar = zzkpVar == null ? null : zzkpVar.zzg.zza;
        this.zzd.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgpbVar, zzuuVar);
            }
        });
    }

    private final long zzC(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzkp zzkpVar = (zzkp) this.zzq.get(i);
            if (zzkpVar.zzb.equals(obj)) {
                return zzkpVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final int zzD(zzbf zzbfVar) {
        zzbf zzbfVar2;
        zzkp zzkpVarZzp = this.zzi;
        if (zzkpVarZzp == null) {
            return 0;
        }
        int iZze = zzbfVar.zze(zzkpVarZzp.zzb);
        while (true) {
            zzbfVar2 = zzbfVar;
            iZze = zzbfVar2.zzl(iZze, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkpVarZzp.getClass();
                if (zzkpVarZzp.zzp() == null || zzkpVarZzp.zzg.zzh) {
                    break;
                }
                zzkpVarZzp = zzkpVarZzp.zzp();
            }
            zzkp zzkpVarZzp2 = zzkpVarZzp.zzp();
            if (iZze == -1 || zzkpVarZzp2 == null || zzbfVar2.zze(zzkpVarZzp2.zzb) != iZze) {
                break;
            }
            zzkpVarZzp = zzkpVarZzp2;
            zzbfVar = zzbfVar2;
        }
        int iZzs = zzs(zzkpVarZzp);
        zzkpVarZzp.zzg = zzx(zzbfVar2, zzkpVarZzp.zzg);
        return iZzs;
    }

    private final zzkq zzE(zzbf zzbfVar, zzkp zzkpVar, long j) {
        zzbf zzbfVar2;
        long j2;
        zzbe zzbeVar;
        Object obj;
        long j3;
        long j4;
        long j5;
        zzkq zzkqVar = zzkpVar.zzg;
        long jZza = zzkpVar.zza();
        long j6 = zzkqVar.zze;
        long j7 = (jZza + j6) - j;
        if (!zzkqVar.zzh) {
            zzuu zzuuVar = zzkqVar.zza;
            Object obj2 = zzuuVar.zza;
            zzbd zzbdVar = this.zza;
            zzbfVar.zzo(obj2, zzbdVar);
            boolean z = zzkqVar.zzg;
            if (!zzuuVar.zzb()) {
                int i = zzuuVar.zze;
                if (i != -1) {
                    zzbdVar.zzi(i);
                }
                int iZzd = zzbdVar.zzd(i);
                zzbdVar.zzk(i);
                if (iZzd != zzbdVar.zzg(i)) {
                    return zzG(zzbfVar, obj2, i, iZzd, j6, zzuuVar.zzd, false);
                }
                zzK(zzbfVar, obj2, i);
                return zzH(zzbfVar, obj2, 0L, j6, zzuuVar.zzd, false);
            }
            int i2 = zzuuVar.zzb;
            if (zzbdVar.zzg(i2) == -1) {
                return null;
            }
            int iZza = zzbdVar.zzg.zza(i2).zza(zzuuVar.zzc);
            if (iZza < 0) {
                return zzG(zzbfVar, obj2, i2, iZza, zzkqVar.zzc, zzuuVar.zzd, false);
            }
            long jLongValue = zzkqVar.zzc;
            if (jLongValue == -9223372036854775807L) {
                Pair pairZzn = zzbfVar.zzn(this.zzb, zzbdVar, zzbdVar.zzc, -9223372036854775807L, Math.max(0L, j7));
                zzbfVar2 = zzbfVar;
                if (pairZzn == null) {
                    return null;
                }
                jLongValue = ((Long) pairZzn.second).longValue();
                j2 = -9223372036854775807L;
            } else {
                zzbfVar2 = zzbfVar;
                j2 = jLongValue;
            }
            zzK(zzbfVar2, obj2, i2);
            return zzH(zzbfVar2, obj2, Math.max(0L, jLongValue), j2, zzuuVar.zzd, false);
        }
        zzuu zzuuVar2 = zzkqVar.zza;
        Object obj3 = zzuuVar2.zza;
        int iZze = zzbfVar.zze(obj3);
        int i3 = this.zzf;
        boolean z2 = this.zzg;
        zzbe zzbeVar2 = this.zzb;
        zzbd zzbdVar2 = this.zza;
        long j8 = 0;
        int iZzl = zzbfVar.zzl(iZze, zzbdVar2, zzbeVar2, i3, z2);
        if (iZzl == -1) {
            return null;
        }
        int i4 = zzbfVar.zzd(iZzl, zzbdVar2, true).zzc;
        Object obj4 = zzbdVar2.zzb;
        obj4.getClass();
        long j9 = zzuuVar2.zzd;
        if (zzbfVar.zzb(i4, zzbeVar2, 0L).zzn == iZzl) {
            Pair pairZzn2 = zzbfVar.zzn(zzbeVar2, zzbdVar2, i4, -9223372036854775807L, Math.max(0L, j7));
            if (pairZzn2 == null) {
                return null;
            }
            Object obj5 = pairZzn2.first;
            long jLongValue2 = ((Long) pairZzn2.second).longValue();
            zzkp zzkpVarZzp = zzkpVar.zzp();
            if (zzkpVarZzp == null || !zzkpVarZzp.zzb.equals(obj5)) {
                long jZzC = zzC(obj5);
                if (jZzC == -1) {
                    jZzC = this.zze;
                    this.zze = 1 + jZzC;
                }
                j5 = jZzC;
            } else {
                j5 = zzkpVarZzp.zzg.zza.zzd;
            }
            zzbeVar = zzbeVar2;
            j3 = jLongValue2;
            obj = obj5;
            j4 = j5;
            j8 = -9223372036854775807L;
        } else {
            zzbeVar = zzbeVar2;
            obj = obj4;
            j3 = 0;
            j4 = j9;
        }
        zzuu zzuuVarZzA = zzA(zzbfVar, obj, j3, j4, zzbeVar, zzbdVar2);
        long j10 = j3;
        if (j8 != -9223372036854775807L && zzkqVar.zzc != -9223372036854775807L) {
            zzbfVar.zzo(obj3, zzbdVar2).zzb();
            int i5 = zzbdVar2.zzg.zzd;
        }
        return zzF(zzbfVar, zzuuVarZzA, j8, j10);
    }

    private final zzkq zzF(zzbf zzbfVar, zzuu zzuuVar, long j, long j2) {
        Object obj = zzuuVar.zza;
        zzbfVar.zzo(obj, this.zza);
        return zzuuVar.zzb() ? zzG(zzbfVar, obj, zzuuVar.zzb, zzuuVar.zzc, j, zzuuVar.zzd, false) : zzH(zzbfVar, obj, j2, j, zzuuVar.zzd, false);
    }

    private final zzkq zzG(zzbf zzbfVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzuu zzuuVar = new zzuu(obj, i, i2, j2);
        Object obj2 = zzuuVar.zza;
        int i3 = zzuuVar.zzb;
        int i4 = zzuuVar.zzc;
        zzbd zzbdVar = this.zza;
        long jZzh = zzbfVar.zzo(obj2, zzbdVar).zzh(i3, i4);
        if (i2 == zzbdVar.zzd(i)) {
            zzbdVar.zzj();
        }
        zzbdVar.zzk(i3);
        long jMax = 0;
        if (jZzh != -9223372036854775807L && jZzh <= 0) {
            jMax = Math.max(0L, (-1) + jZzh);
        }
        return new zzkq(zzuuVar, jMax, j, -9223372036854775807L, jZzh, false, false, false, false, false);
    }

    private final zzkq zzH(zzbf zzbfVar, Object obj, long j, long j2, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        int iZzf = zzbdVar.zzf(jMax);
        if (iZzf == -1) {
            zzbdVar.zzb();
        } else {
            zzbdVar.zzk(iZzf);
        }
        zzuu zzuuVar = new zzuu(obj, j3, iZzf);
        boolean zZzL = zzL(zzuuVar);
        boolean zZzI = zzI(zzbfVar, zzuuVar);
        boolean zZzJ = zzJ(zzbfVar, zzuuVar, zZzL);
        if (iZzf != -1) {
            zzbdVar.zzk(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzi(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzc(iZzf);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = j4;
            j5 = j6;
        } else {
            j5 = zzbdVar.zzd;
            j6 = -9223372036854775807L;
        }
        if (j5 != -9223372036854775807L && jMax >= j5) {
            jMax = Math.max(0L, j5 - 1);
        }
        return new zzkq(zzuuVar, jMax, j2, j6, j5, false, false, zZzL, zZzI, zZzJ);
    }

    private final boolean zzI(zzbf zzbfVar, zzuu zzuuVar) {
        if (!zzL(zzuuVar)) {
            return false;
        }
        Object obj = zzuuVar.zza;
        return zzbfVar.zzb(zzbfVar.zzo(obj, this.zza).zzc, this.zzb, 0L).zzo == zzbfVar.zze(obj);
    }

    private final boolean zzJ(zzbf zzbfVar, zzuu zzuuVar, boolean z) {
        int iZze = zzbfVar.zze(zzuuVar.zza);
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzd(iZze, zzbdVar, false).zzc;
        zzbe zzbeVar = this.zzb;
        return !zzbfVar.zzb(i, zzbeVar, 0L).zzi && zzbfVar.zzl(iZze, zzbdVar, zzbeVar, this.zzf, this.zzg) == -1 && z;
    }

    private final long zzK(zzbf zzbfVar, Object obj, int i) {
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        zzbdVar.zzc(i);
        long j = zzbdVar.zzg.zza(i).zzi;
        return 0L;
    }

    private static final boolean zzL(zzuu zzuuVar) {
        return !zzuuVar.zzb() && zzuuVar.zze == -1;
    }

    public final int zza(zzbf zzbfVar, int i) {
        this.zzf = i;
        return zzD(zzbfVar);
    }

    public final int zzb(zzbf zzbfVar, boolean z) {
        this.zzg = z;
        return zzD(zzbfVar);
    }

    public final void zzc(zzbf zzbfVar, zzil zzilVar) {
        this.zzh = zzilVar;
        long j = zzilVar.zzb;
        zzj();
    }

    public final boolean zzd(zzus zzusVar) {
        zzkp zzkpVar = this.zzl;
        return zzkpVar != null && zzkpVar.zza == zzusVar;
    }

    public final boolean zze(zzus zzusVar) {
        zzkp zzkpVar = this.zzm;
        return zzkpVar != null && zzkpVar.zza == zzusVar;
    }

    public final void zzf(long j) {
        zzkp zzkpVar = this.zzl;
        if (zzkpVar != null) {
            zzkpVar.zzi(j);
        }
    }

    public final boolean zzg() {
        zzkp zzkpVar = this.zzl;
        if (zzkpVar != null) {
            return !zzkpVar.zzg.zzj && zzkpVar.zzd() && this.zzl.zzg.zze != -9223372036854775807L && this.zzn < 100;
        }
        return true;
    }

    public final zzkq zzh(long j, zzlf zzlfVar) {
        zzkp zzkpVar = this.zzl;
        return zzkpVar == null ? zzF(zzlfVar.zza, zzlfVar.zzb, zzlfVar.zzc, zzlfVar.zzs) : zzE(zzlfVar.zza, zzkpVar, j);
    }

    public final void zzj() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzkp) this.zzq.get(i)).zzn();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final zzkp zzk() {
        return this.zzl;
    }

    public final zzkp zzl() {
        return this.zzm;
    }

    public final zzkp zzm() {
        return this.zzi;
    }

    public final zzkp zzn() {
        return this.zzj;
    }

    public final zzkp zzo() {
        return this.zzk;
    }

    public final zzkp zzp() {
        zzkp zzkpVar = this.zzk;
        zzkp zzkpVar2 = this.zzj;
        if (zzkpVar == zzkpVar2) {
            zzkpVar2.getClass();
            this.zzk = zzkpVar2.zzp();
        }
        zzkpVar2.getClass();
        this.zzj = zzkpVar2.zzp();
        zzB();
        zzkp zzkpVar3 = this.zzj;
        zzkpVar3.getClass();
        return zzkpVar3;
    }

    public final zzkp zzq() {
        zzkp zzkpVar = this.zzk;
        zzkpVar.getClass();
        this.zzk = zzkpVar.zzp();
        zzB();
        zzkp zzkpVar2 = this.zzk;
        zzkpVar2.getClass();
        return zzkpVar2;
    }

    public final zzkp zzr() {
        zzkp zzkpVar = this.zzi;
        if (zzkpVar == null) {
            return null;
        }
        if (zzkpVar == this.zzj) {
            this.zzj = zzkpVar.zzp();
        }
        if (zzkpVar == this.zzk) {
            this.zzk = zzkpVar.zzp();
        }
        zzkpVar.zzn();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzkp zzkpVar2 = this.zzi;
            this.zzo = zzkpVar2.zzb;
            this.zzp = zzkpVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzp();
        zzB();
        return this.zzi;
    }

    public final void zzt() {
        zzkp zzkpVar = this.zzm;
        if (zzkpVar == null || zzkpVar.zze()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzkp zzkpVar2 = (zzkp) this.zzq.get(i);
                if (!zzkpVar2.zze()) {
                    this.zzm = zzkpVar2;
                    return;
                }
            }
        }
    }

    public final zzkp zzu(zzus zzusVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzkp zzkpVar = (zzkp) this.zzq.get(i);
            if (zzkpVar.zza == zzusVar) {
                return zzkpVar;
            }
        }
        return null;
    }

    public final void zzv() {
        if (this.zzn == 0) {
            return;
        }
        zzkp zzkpVarZzp = this.zzi;
        zzkpVarZzp.getClass();
        this.zzo = zzkpVarZzp.zzb;
        this.zzp = zzkpVarZzp.zzg.zza.zzd;
        while (zzkpVarZzp != null) {
            zzkpVarZzp.zzn();
            zzkpVarZzp = zzkpVarZzp.zzp();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzB();
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    public final int zzw(zzbf zzbfVar, long j, long j2, long j3) {
        zzkq zzkqVarZzx;
        boolean z;
        zzkp zzkpVarZzp = this.zzi;
        zzkp zzkpVar = null;
        while (true) {
            int i = 0;
            if (zzkpVarZzp == null) {
                return 0;
            }
            zzkq zzkqVar = zzkpVarZzp.zzg;
            if (zzkpVar == null) {
                zzkqVarZzx = zzx(zzbfVar, zzkqVar);
            } else {
                zzkq zzkqVarZzE = zzE(zzbfVar, zzkpVar, j);
                if (zzkqVarZzE == null || zzkqVar.zzb != zzkqVarZzE.zzb || !zzkqVar.zza.equals(zzkqVarZzE.zza)) {
                    return zzs(zzkpVar);
                }
                zzkqVarZzx = zzkqVarZzE;
            }
            zzkpVarZzp.zzg = zzkqVarZzx.zzb(zzkqVar.zzc);
            long j4 = zzkqVar.zze;
            long j5 = zzkqVarZzx.zze;
            if (j4 != j5) {
                zzkpVarZzp.zzs();
                long jZza = j5 == -9223372036854775807L ? Long.MAX_VALUE : j5 + zzkpVarZzp.zza();
                if (zzkpVarZzp == this.zzj) {
                    boolean z2 = zzkpVarZzp.zzg.zzg;
                    if (j2 == Long.MIN_VALUE || j2 >= jZza) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                boolean z3 = zzkpVarZzp == this.zzk && (j3 == Long.MIN_VALUE || j3 >= jZza);
                int iZzs = zzs(zzkpVarZzp);
                if (iZzs != 0) {
                    return iZzs;
                }
                if (j4 == -9223372036854775807L) {
                    long j6 = zzkqVar.zzd;
                    j4 = -9223372036854775807L;
                }
                if (z && j4 != -9223372036854775807L) {
                    i = 1;
                }
                return z3 ? i | 2 : i;
            }
            zzkpVar = zzkpVarZzp;
            zzkpVarZzp = zzkpVarZzp.zzp();
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    /* JADX WARN: Code duplicated, block: B:20:0x005e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    public final zzkq zzx(zzbf zzbfVar, zzkq zzkqVar) {
        long j;
        long jZzh;
        long j2;
        long j3;
        int i;
        int i2;
        zzuu zzuuVar = zzkqVar.zza;
        boolean zZzL = zzL(zzuuVar);
        boolean zZzI = zzI(zzbfVar, zzuuVar);
        boolean zZzJ = zzJ(zzbfVar, zzuuVar, zZzL);
        Object obj = zzuuVar.zza;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        if (zzuuVar.zzb() || (i2 = zzuuVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            zzbdVar.zzc(i2);
            j = 0;
        }
        if (!zzuuVar.zzb()) {
            if (j != -9223372036854775807L) {
                j2 = 0;
                j3 = 0;
            } else {
                jZzh = zzbdVar.zzd;
            }
            if (zzuuVar.zzb()) {
                zzbdVar.zzk(zzuuVar.zzb);
            } else {
                i = zzuuVar.zze;
                if (i != -1) {
                    zzbdVar.zzk(i);
                }
            }
            long j4 = zzkqVar.zzb;
            long j5 = zzkqVar.zzc;
            boolean z = zzkqVar.zzf;
            return new zzkq(zzuuVar, j4, j5, j3, j2, false, false, zZzL, zZzI, zZzJ);
        }
        jZzh = zzbdVar.zzh(zzuuVar.zzb, zzuuVar.zzc);
        j2 = jZzh;
        j3 = j;
        if (zzuuVar.zzb()) {
            zzbdVar.zzk(zzuuVar.zzb);
        } else {
            i = zzuuVar.zze;
            if (i != -1) {
                zzbdVar.zzk(i);
            }
        }
        long j6 = zzkqVar.zzb;
        long j7 = zzkqVar.zzc;
        boolean z2 = zzkqVar.zzf;
        return new zzkq(zzuuVar, j6, j7, j3, j2, false, false, zZzL, zZzI, zZzJ);
    }

    public final zzuu zzy(zzbf zzbfVar, Object obj, long j) {
        long jZzC;
        int iZze;
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZze = zzbfVar.zze(obj2)) == -1 || zzbfVar.zzd(iZze, zzbdVar, false).zzc != i) {
            zzkp zzkpVarZzp = this.zzi;
            while (true) {
                if (zzkpVarZzp == null) {
                    zzkp zzkpVarZzp2 = this.zzi;
                    while (true) {
                        if (zzkpVarZzp2 == null) {
                            jZzC = zzC(obj);
                            if (jZzC != -1) {
                                break;
                            }
                            jZzC = this.zze;
                            this.zze = 1 + jZzC;
                            if (this.zzi != null) {
                                break;
                            }
                            this.zzo = obj;
                            this.zzp = jZzC;
                            break;
                        }
                        int iZze2 = zzbfVar.zze(zzkpVarZzp2.zzb);
                        if (iZze2 != -1 && zzbfVar.zzd(iZze2, zzbdVar, false).zzc == i) {
                            jZzC = zzkpVarZzp2.zzg.zza.zzd;
                            break;
                        }
                        zzkpVarZzp2 = zzkpVarZzp2.zzp();
                    }
                } else {
                    if (zzkpVarZzp.zzb.equals(obj)) {
                        jZzC = zzkpVarZzp.zzg.zza.zzd;
                        break;
                    }
                    zzkpVarZzp = zzkpVarZzp.zzp();
                }
            }
        } else {
            jZzC = this.zzp;
        }
        long j2 = jZzC;
        zzbfVar.zzo(obj, zzbdVar);
        int i2 = zzbdVar.zzc;
        zzbe zzbeVar = this.zzb;
        zzbfVar.zzb(i2, zzbeVar, 0L);
        Object obj3 = obj;
        for (int iZze3 = zzbfVar.zze(obj); iZze3 >= zzbeVar.zzn; iZze3--) {
            zzbfVar.zzd(iZze3, zzbdVar, true);
            zzbdVar.zzb();
            if (zzbdVar.zze(zzbdVar.zzd) != -1) {
                Object obj4 = zzbdVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzA(zzbfVar, obj3, j, j2, zzbeVar, zzbdVar);
    }

    final /* synthetic */ void zzz(zzgpb zzgpbVar, zzuu zzuuVar) {
        this.zzc.zzz(zzgpbVar.zzi(), zzuuVar);
    }

    public final zzkp zzi(zzkq zzkqVar) {
        zzkp zzkpVarZza;
        zzkp zzkpVar = this.zzl;
        long jZza = zzkpVar == null ? 1000000000000L : (zzkpVar.zza() + zzkpVar.zzg.zze) - zzkqVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzkpVarZza = null;
                break;
            }
            zzkq zzkqVar2 = ((zzkp) this.zzq.get(i)).zzg;
            long j = zzkqVar2.zze;
            long j2 = zzkqVar.zze;
            if ((j == -9223372036854775807L || j == j2) && zzkqVar2.zzb == zzkqVar.zzb && zzkqVar2.zza.equals(zzkqVar.zza)) {
                zzkpVarZza = (zzkp) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzkpVarZza == null) {
            zzkpVarZza = this.zzr.zza(zzkqVar, jZza);
        } else {
            zzkpVarZza.zzg = zzkqVar;
            zzkpVarZza.zzb(jZza);
        }
        zzkp zzkpVar2 = this.zzl;
        if (zzkpVar2 != null) {
            zzkpVar2.zzo(zzkpVarZza);
        } else {
            this.zzi = zzkpVarZza;
            this.zzj = zzkpVarZza;
            this.zzk = zzkpVarZza;
        }
        this.zzo = null;
        this.zzl = zzkpVarZza;
        this.zzn++;
        zzB();
        return zzkpVarZza;
    }

    public final int zzs(zzkp zzkpVar) {
        zzkpVar.getClass();
        int i = 0;
        if (zzkpVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzkpVar;
        while (zzkpVar.zzp() != null) {
            zzkpVar = zzkpVar.zzp();
            zzkpVar.getClass();
            if (zzkpVar == this.zzj) {
                zzkp zzkpVar2 = this.zzi;
                this.zzj = zzkpVar2;
                this.zzk = zzkpVar2;
                i = 3;
            }
            if (zzkpVar == this.zzk) {
                this.zzk = this.zzj;
                i |= 2;
            }
            zzkpVar.zzn();
            this.zzn--;
        }
        zzkp zzkpVar3 = this.zzl;
        zzkpVar3.getClass();
        zzkpVar3.zzo(null);
        zzB();
        return i;
    }
}
