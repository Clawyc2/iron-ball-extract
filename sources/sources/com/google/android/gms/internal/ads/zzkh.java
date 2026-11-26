package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.work.WorkRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkh implements Handler.Callback, zzur, zzyq, zzld, zzhy, zzlh, zzhp, zzaax {
    private static final long zza = zzep.zzp(WorkRequest.MIN_BACKOFF_MILLIS);
    private zzlv zzA;
    private boolean zzC;
    private boolean zzD;
    private zzkg zzE;
    private int zzF;
    private zzlf zzG;
    private zzke zzH;
    private boolean zzI;
    private boolean zzK;
    private boolean zzL;
    private boolean zzN;
    private boolean zzQ;
    private int zzR;
    private zzkg zzS;
    private long zzT;
    private long zzU;
    private int zzV;
    private boolean zzW;
    private zzib zzX;
    private zzil zzZ;
    private boolean zzab;
    private final zzhu zzad;
    private final zzlr[] zzb;
    private final zzlp[] zzc;
    private final boolean[] zzd;
    private final zzyr zze;
    private final zzys zzf;
    private final zzkl zzg;
    private final zzza zzh;
    private final zzdm zzi;
    private final zzlg zzj;
    private final Looper zzk;
    private final zzbe zzl;
    private final zzbd zzm;
    private final long zzn;
    private final zzhz zzo;
    private final ArrayList zzp;
    private final zzdc zzq;
    private final zzkf zzr;
    private final zzks zzs;
    private final zzle zzt;
    private final long zzu;
    private final zzpc zzv;
    private final zzmi zzw;
    private final zzdm zzx;
    private final boolean zzy;
    private final zzhq zzz;
    private long zzaa = -9223372036854775807L;
    private int zzO = 0;
    private boolean zzP = false;
    private boolean zzJ = false;
    private float zzac = 1.0f;
    private zzlu zzB = zzlu.zza;
    private long zzY = -9223372036854775807L;
    private long zzM = -9223372036854775807L;

    public zzkh(Context context, zzln[] zzlnVarArr, zzln[] zzlnVarArr2, zzyr zzyrVar, zzys zzysVar, zzkl zzklVar, zzza zzzaVar, int i, boolean z, zzmi zzmiVar, zzlv zzlvVar, zzhu zzhuVar, long j, boolean z2, boolean z3, Looper looper, zzdc zzdcVar, zzkf zzkfVar, zzpc zzpcVar, zzlg zzlgVar, zzil zzilVar, final zzaax zzaaxVar) {
        this.zzr = zzkfVar;
        this.zze = zzyrVar;
        this.zzf = zzysVar;
        this.zzg = zzklVar;
        this.zzh = zzzaVar;
        int i2 = 0;
        this.zzA = zzlvVar;
        this.zzad = zzhuVar;
        this.zzu = j;
        this.zzq = zzdcVar;
        this.zzv = zzpcVar;
        this.zzZ = zzilVar;
        this.zzw = zzmiVar;
        this.zzn = zzklVar.zzf(zzpcVar);
        zzklVar.zzg(zzpcVar);
        zzbf zzbfVar = zzbf.zza;
        this.zzG = zzlf.zza(zzysVar);
        this.zzH = new zzke(this.zzG);
        int length = zzlnVarArr.length;
        this.zzc = new zzlp[2];
        this.zzd = new boolean[2];
        zzlo zzloVarZzg = zzyrVar.zzg();
        this.zzb = new zzlr[2];
        boolean z4 = false;
        while (true) {
            int length2 = zzlnVarArr.length;
            if (i2 >= 2) {
                this.zzy = z4;
                this.zzo = new zzhz(this, zzdcVar);
                this.zzp = new ArrayList();
                this.zzl = new zzbe();
                this.zzm = new zzbd();
                zzyrVar.zzr(this, zzzaVar);
                this.zzW = true;
                zzdm zzdmVarZzd = zzdcVar.zzd(looper, null);
                this.zzx = zzdmVarZzd;
                this.zzs = new zzks(zzmiVar, zzdmVarZzd, new zzka(this), zzilVar);
                this.zzt = new zzle(this, zzmiVar, zzdmVarZzd, zzpcVar);
                zzlg zzlgVar2 = new zzlg(null);
                this.zzj = zzlgVar2;
                Looper looperZza = zzlgVar2.zza();
                this.zzk = looperZza;
                zzdm zzdmVarZzd2 = zzdcVar.zzd(looperZza, this);
                this.zzi = zzdmVarZzd2;
                this.zzz = new zzhq(context, looperZza, this);
                zzdmVarZzd2.zzd(35, new zzaax() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // com.google.android.gms.internal.ads.zzaax
                    public final /* synthetic */ void zzcS(long j2, long j3, zzv zzvVar, MediaFormat mediaFormat) {
                        this.zza.zzcS(j2, j3, zzvVar, mediaFormat);
                    }
                }).zza();
                return;
            }
            zzlnVarArr[i2].zzc(i2, zzpcVar, zzdcVar);
            this.zzc[i2] = zzlnVarArr[i2].zzb();
            this.zzc[i2].zzv(zzloVarZzg);
            zzln zzlnVar = zzlnVarArr2[i2];
            if (zzlnVar != null) {
                zzlnVar.zzc(i2, zzpcVar, zzdcVar);
                z4 = true;
            }
            this.zzb[i2] = new zzlr(zzlnVarArr[i2], zzlnVarArr2[i2], i2);
            i2++;
        }
    }

    private final void zzA(IOException iOException, int i) {
        zzks zzksVar = this.zzs;
        zzib zzibVarZza = zzib.zza(iOException, i);
        zzkp zzkpVarZzm = zzksVar.zzm();
        if (zzkpVarZzm != null) {
            zzibVarZza = zzibVarZza.zzd(zzkpVarZzm.zzg.zza);
        }
        zzdt.zzf("ExoPlayerImplInternal", "Playback error", zzibVarZza);
        zzW(false, false);
        this.zzG = this.zzG.zzf(zzibVarZza);
    }

    private final void zzB(int i) {
        zzlf zzlfVar = this.zzG;
        if (zzlfVar.zze != i) {
            if (i != 2) {
                this.zzY = -9223372036854775807L;
            }
            if (i != 3) {
                boolean z = zzlfVar.zzp;
            }
            this.zzG = this.zzG.zze(i);
        }
    }

    private final void zzC() {
        this.zzH.zzb(this.zzG);
        if (this.zzH.zzd()) {
            this.zzr.zza(this.zzH);
            this.zzH = new zzke(this.zzG);
        }
    }

    private final void zzD(float f) throws zzib {
        this.zzac = f;
        float fZza = f * this.zzz.zza();
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlrVarArr[i].zzL(fZza);
            i++;
        }
    }

    private final void zzE(boolean z, int i, boolean z2, int i2) throws zzib {
        this.zzH.zza(z2 ? 1 : 0);
        zzG(z, i, i2);
    }

    private final void zzF() throws zzib {
        zzlf zzlfVar = this.zzG;
        zzG(zzlfVar.zzl, zzlfVar.zzn, zzlfVar.zzm);
    }

    private final void zzG(boolean z, int i, int i2) throws zzib {
        zzH(z, this.zzz.zzc(z, this.zzG.zze), i, i2);
    }

    private final void zzH(boolean z, int i, int i2, int i3) throws zzib {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            i = -1;
            z2 = false;
        }
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        boolean z3 = this.zzC;
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = z3 ? 4 : 0;
        }
        zzlf zzlfVar = this.zzG;
        if (zzlfVar.zzl == z2 && zzlfVar.zzn == i2 && zzlfVar.zzm == i3) {
            return;
        }
        this.zzG = zzlfVar.zzi(z2, i3, i2);
        zzaC(false, false);
        zzks zzksVar = this.zzs;
        for (zzkp zzkpVarZzm = zzksVar.zzm(); zzkpVarZzm != null; zzkpVarZzm = zzkpVarZzm.zzp()) {
            for (zzyk zzykVar : zzkpVarZzm.zzr().zzc) {
            }
        }
        if (!zzax()) {
            zzK();
            zzL();
            boolean z4 = this.zzG.zzp;
            zzksVar.zzf(this.zzT);
            return;
        }
        int i4 = this.zzG.zze;
        if (i4 == 3) {
            this.zzo.zza();
            zzJ();
            this.zzi.zzh(2);
        } else if (i4 == 2) {
            this.zzi.zzh(2);
        }
    }

    private final void zzI(boolean z) throws zzib {
        zzuu zzuuVar = this.zzs.zzm().zzg.zza;
        long jZzT = zzT(zzuuVar, this.zzG.zzs, true, false);
        if (jZzT != this.zzG.zzs) {
            zzlf zzlfVar = this.zzG;
            this.zzG = zzao(zzuuVar, jZzT, zzlfVar.zzc, zzlfVar.zzd, z, 5);
        }
    }

    private final void zzJ() throws zzib {
        zzkp zzkpVarZzm = this.zzs.zzm();
        if (zzkpVarZzm == null) {
            return;
        }
        zzys zzysVarZzr = zzkpVarZzm.zzr();
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzysVarZzr.zza(i)) {
                zzlrVarArr[i].zzv();
            }
            i++;
        }
    }

    private final void zzK() throws zzib {
        this.zzo.zzb();
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlrVarArr[i].zzw();
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void zzL() throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzL():void");
    }

    private final void zzM(zzav zzavVar) {
        this.zzi.zzk(16);
        this.zzo.zzi(zzavVar);
    }

    private final void zzN(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(i, z);
                }
            });
        }
    }

    private final long zzO(zzbf zzbfVar, Object obj, long j) {
        int i = zzbfVar.zzo(obj, this.zzm).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        if (zzbeVar.zzf == -9223372036854775807L || !zzbeVar.zzb() || !zzbeVar.zzi) {
            return -9223372036854775807L;
        }
        long j2 = zzbeVar.zzg;
        String str = zzep.zza;
        return zzep.zzq((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbeVar.zzf) - j;
    }

    private final boolean zzP(zzbf zzbfVar, zzuu zzuuVar) {
        if (!zzuuVar.zzb() && !zzbfVar.zzg()) {
            int i = zzbfVar.zzo(zzuuVar.zza, this.zzm).zzc;
            zzbe zzbeVar = this.zzl;
            zzbfVar.zzb(i, zzbeVar, 0L);
            if (zzbeVar.zzb() && zzbeVar.zzi && zzbeVar.zzf != -9223372036854775807L) {
                return true;
            }
        }
        return false;
    }

    private final void zzQ(long j) {
        long jMin = 1000;
        if (zzw()) {
            jMin = this.zzG.zze != 3 ? zza : 1000L;
            zzlr[] zzlrVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                jMin = Math.min(jMin, zzep.zzp(zzlrVarArr[i].zzk(this.zzT, this.zzU)));
            }
            if (this.zzG.zzj()) {
                zzks zzksVar = this.zzs;
                zzkp zzkpVarZzp = zzksVar.zzm() != null ? zzksVar.zzm().zzp() : null;
                if (zzkpVarZzp != null) {
                    if (this.zzT + (zzep.zzq(jMin) * this.zzG.zzo.zzb) >= zzkpVarZzp.zzc()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (this.zzG.zze != 3 || zzax()) {
            jMin = zza;
        }
        this.zzi.zzj(2, j + jMin);
    }

    private final void zzR(zzkg zzkgVar, boolean z) throws Throwable {
        long jLongValue;
        long j;
        long j2;
        boolean z2;
        zzuu zzuuVar;
        zzuu zzuuVar2;
        boolean z3;
        long j3;
        long jZzk;
        long jZzS;
        boolean z4;
        zzlf zzlfVar;
        zzbf zzbfVar;
        zzuu zzuuVar3;
        long j4;
        zzuu zzuuVar4;
        long j5;
        long j6;
        boolean z5;
        zzlf zzlfVar2;
        int i;
        this.zzH.zza(z ? 1 : 0);
        if (this.zzD) {
            if (this.zzE != null) {
                this.zzF++;
            }
            this.zzE = zzkgVar;
            return;
        }
        zzbf zzbfVar2 = this.zzG.zza;
        int i2 = this.zzO;
        boolean z6 = this.zzP;
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzaD = zzaD(zzbfVar2, zzkgVar, true, i2, z6, zzbeVar, zzbdVar);
        if (pairZzaD == null) {
            Pair pairZzY = zzY(this.zzG.zza);
            zzuuVar = (zzuu) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            z2 = !this.zzG.zza.zzg();
            j = -9223372036854775807L;
            j2 = 0;
        } else {
            Object obj = pairZzaD.first;
            jLongValue = ((Long) pairZzaD.second).longValue();
            long j7 = zzkgVar.zzc;
            j = j7 == -9223372036854775807L ? -9223372036854775807L : jLongValue;
            j2 = 0;
            zzuu zzuuVarZzy = this.zzs.zzy(this.zzG.zza, obj, jLongValue);
            if (zzuuVarZzy.zzb()) {
                this.zzG.zza.zzo(zzuuVarZzy.zza, zzbdVar);
                if (zzbdVar.zzd(zzuuVarZzy.zzb) == zzuuVarZzy.zzc) {
                    zzbdVar.zzj();
                }
                zzuuVar = zzuuVarZzy;
                z2 = true;
                jLongValue = 0;
            } else {
                z2 = j7 == -9223372036854775807L;
                zzuuVar = zzuuVarZzy;
            }
        }
        try {
            if (this.zzG.zza.zzg()) {
                this.zzS = zzkgVar;
            } else if (pairZzaD == null) {
                if (this.zzG.zze != 1) {
                    zzB(4);
                }
                zzX(false, true, false, true);
            } else {
                try {
                    try {
                        if (zzuuVar.equals(this.zzG.zzb)) {
                            zzkp zzkpVarZzm = this.zzs.zzm();
                            if (zzkpVarZzm == null || !zzkpVarZzm.zze || jLongValue == j2) {
                                jZzk = jLongValue;
                            } else {
                                zzus zzusVar = zzkpVarZzm.zza;
                                long j8 = zzbeVar.zzm;
                                if (this.zzC && j8 != -9223372036854775807L) {
                                    Double d = this.zzB.zzc;
                                }
                                jZzk = zzusVar.zzk(jLongValue, this.zzA);
                            }
                            if (zzep.zzp(jZzk) == zzep.zzp(this.zzG.zzs) && ((i = (zzlfVar2 = this.zzG).zze) == 2 || i == 3)) {
                                jLongValue = zzlfVar2.zzs;
                            }
                            this.zzG = zzao(zzuuVar4, j6, j5, j6, z5, 2);
                        }
                        jZzk = jLongValue;
                        zzag(zzbfVar, zzuuVar3, zzbfVar, zzlfVar.zzb, j4, true);
                        zzuuVar4 = zzuuVar3;
                        j5 = j4;
                        j6 = jZzS;
                        z5 = z4;
                        this.zzG = zzao(zzuuVar4, j6, j5, j6, z5, 2);
                    } catch (Throwable th) {
                        th = th;
                        zzuuVar2 = zzuuVar3;
                        j = j4;
                        j3 = jZzS;
                        z3 = z4;
                        this.zzG = zzao(zzuuVar2, j3, j, j3, z3, 2);
                        throw th;
                    }
                    zzlfVar = this.zzG;
                    zzbfVar = zzlfVar.zza;
                    zzuuVar3 = zzuuVar;
                    j4 = j;
                } catch (Throwable th2) {
                    th = th2;
                    zzuuVar2 = zzuuVar;
                }
                this.zzD = this.zzC;
                jZzS = zzS(zzuuVar, jZzk, this.zzG.zze == 4);
                z4 = z2 | (jLongValue != jZzS);
            }
            z5 = z2;
            zzuuVar4 = zzuuVar;
            j6 = jLongValue;
            j5 = j;
            this.zzG = zzao(zzuuVar4, j6, j5, j6, z5, 2);
        } catch (Throwable th3) {
            th = th3;
            zzuuVar2 = zzuuVar;
            z3 = z2;
            j3 = jLongValue;
        }
    }

    private final long zzS(zzuu zzuuVar, long j, boolean z) throws zzib {
        zzks zzksVar = this.zzs;
        return zzT(zzuuVar, j, zzksVar.zzm() != zzksVar.zzn(), z);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00c6  */
    private final long zzT(zzuu zzuuVar, long j, boolean z, boolean z2) throws zzib {
        zzK();
        boolean z3 = true;
        zzaC(false, true);
        if (z2 || this.zzG.zze == 3) {
            zzB(2);
        }
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzm = zzksVar.zzm();
        zzkp zzkpVarZzp = zzkpVarZzm;
        while (zzkpVarZzp != null && !zzuuVar.equals(zzkpVarZzp.zzg.zza)) {
            zzkpVarZzp = zzkpVarZzp.zzp();
        }
        if (z || zzkpVarZzm != zzkpVarZzp || (zzkpVarZzp != null && zzkpVarZzp.zza() + j < 0)) {
            zzaa();
            if (zzkpVarZzp != null) {
                while (zzksVar.zzm() != zzkpVarZzp) {
                    zzksVar.zzr();
                }
                zzksVar.zzs(zzkpVarZzp);
                zzkpVarZzp.zzb(1000000000000L);
                zzap();
                zzkpVarZzp.zzh = true;
            }
        }
        zzab();
        if (zzkpVarZzp != null) {
            zzksVar.zzs(zzkpVarZzp);
            if (!zzkpVarZzp.zze) {
                zzkpVarZzp.zzg = zzkpVarZzp.zzg.zza(j);
            } else if (zzkpVarZzp.zzf) {
                if (this.zzC) {
                    boolean z4 = this.zzB.zzi;
                    if (this.zzG.zza.zzg() || !zzkpVarZzp.zzg.zza.equals(this.zzG.zzb)) {
                        zzus zzusVar = zzkpVarZzp.zza;
                        j = zzusVar.zzj(j);
                        zzusVar.zzf(j - this.zzn, false);
                    } else {
                        zzlr[] zzlrVarArr = this.zzb;
                        boolean zZzF = true;
                        for (int i = 0; i < 2; i++) {
                            zzlr zzlrVar = zzlrVarArr[i];
                            if (zzlrVar.zzM()) {
                                zZzF &= zzlrVar.zzF(zzkpVarZzp, j);
                            }
                        }
                        if (zZzF) {
                            zzus zzusVar2 = zzkpVarZzp.zza;
                            long j2 = this.zzG.zzs;
                            zzlv zzlvVar = zzlv.zzb;
                            if (zzusVar2.zzk(j2, zzlvVar) == zzusVar2.zzk(j, zzlvVar)) {
                                z3 = false;
                            } else {
                                zzus zzusVar3 = zzkpVarZzp.zza;
                                j = zzusVar3.zzj(j);
                                zzusVar3.zzf(j - this.zzn, false);
                            }
                        } else {
                            zzus zzusVar4 = zzkpVarZzp.zza;
                            j = zzusVar4.zzj(j);
                            zzusVar4.zzf(j - this.zzn, false);
                        }
                    }
                } else {
                    zzus zzusVar5 = zzkpVarZzp.zza;
                    j = zzusVar5.zzj(j);
                    zzusVar5.zzf(j - this.zzn, false);
                }
            }
            zzU(j, z3);
            zzam();
        } else {
            zzksVar.zzv();
            zzU(j, true);
        }
        zzas(false);
        this.zzi.zzh(2);
        return j;
    }

    private final void zzU(long j, boolean z) throws zzib {
        zzkp zzkpVarZzm = this.zzs.zzm();
        long jZza = j + (zzkpVarZzm == null ? 1000000000000L : zzkpVarZzm.zza());
        this.zzT = jZza;
        this.zzo.zzc(jZza);
        zzlr[] zzlrVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzlrVarArr[i].zzE(zzkpVarZzm, this.zzT, z);
        }
        for (zzkp zzkpVarZzm2 = r0.zzm(); zzkpVarZzm2 != null; zzkpVarZzm2 = zzkpVarZzm2.zzp()) {
            for (zzyk zzykVar : zzkpVarZzm2.zzr().zzc) {
            }
        }
    }

    private final void zzV() throws zzib {
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlrVarArr[i].zzz(this.zzC ? this.zzB : null);
            i++;
        }
    }

    private final void zzW(boolean z, boolean z2) {
        zzX(z || !this.zzQ, false, true, false);
        this.zzH.zza(z2 ? 1 : 0);
        this.zzg.zzc(this.zzv);
        this.zzz.zzc(this.zzG.zzl, 1);
        zzB(1);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0092 A[PHI: r2 r7 r9
      0x0092: PHI (r2v2 com.google.android.gms.internal.ads.zzuu) = (r2v1 com.google.android.gms.internal.ads.zzuu), (r2v19 com.google.android.gms.internal.ads.zzuu) binds: [B:25:0x006a, B:27:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:25:0x006a, B:27:0x008f] A[DONT_GENERATE, DONT_INLINE]
      0x0092: PHI (r9v2 long) = (r9v1 long), (r9v7 long) binds: [B:25:0x006a, B:27:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d7 A[PHI: r3
      0x00d7: PHI (r3v3 com.google.android.gms.internal.ads.zzbf) = 
      (r3v2 com.google.android.gms.internal.ads.zzbf)
      (r3v2 com.google.android.gms.internal.ads.zzbf)
      (r3v6 com.google.android.gms.internal.ads.zzbf)
      (r3v6 com.google.android.gms.internal.ads.zzbf)
     binds: [B:31:0x00a0, B:33:0x00a4, B:35:0x00b5, B:37:0x00cb] A[DONT_GENERATE, DONT_INLINE]] */
    private final void zzX(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        zzuu zzuuVar;
        zzbf zzbfVar;
        this.zzi.zzk(2);
        this.zzD = false;
        this.zzE = null;
        this.zzX = null;
        zzaC(false, true);
        this.zzo.zzb();
        this.zzT = 1000000000000L;
        try {
            zzaa();
        } catch (zzib | RuntimeException e) {
            zzdt.zzf("ExoPlayerImplInternal", "Disable failed.", e);
        }
        if (z) {
            zzlr[] zzlrVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                try {
                    zzlrVarArr[i].zzG();
                } catch (RuntimeException e2) {
                    zzdt.zzf("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.zzR = 0;
        zzlf zzlfVar = this.zzG;
        zzuu zzuuVar2 = zzlfVar.zzb;
        long jLongValue = zzlfVar.zzs;
        long j = (this.zzG.zzb.zzb() || zzaB(this.zzG, this.zzm)) ? this.zzG.zzc : this.zzG.zzs;
        if (z2) {
            this.zzS = null;
            Pair pairZzY = zzY(this.zzG.zza);
            zzuuVar2 = (zzuu) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            j = -9223372036854775807L;
            z5 = zzuuVar2.equals(this.zzG.zzb) ? false : true;
        }
        long j2 = jLongValue;
        long j3 = j;
        zzks zzksVar = this.zzs;
        zzksVar.zzv();
        this.zzN = false;
        zzbf zzbfVarZzx = this.zzG.zza;
        if (z3 && (zzbfVarZzx instanceof zzll)) {
            zzbfVarZzx = ((zzll) zzbfVarZzx).zzx(this.zzt.zzq());
            if (zzuuVar2.zzb != -1) {
                Object obj = zzuuVar2.zza;
                zzbd zzbdVar = this.zzm;
                zzbfVarZzx.zzo(obj, zzbdVar);
                zzbe zzbeVar = this.zzl;
                zzbfVarZzx.zzb(zzbdVar.zzc, zzbeVar, 0L);
                if (zzbeVar.zzb()) {
                    zzbfVar = zzbfVarZzx;
                    zzuuVar = new zzuu(obj, zzuuVar2.zzd);
                } else {
                    zzuuVar = zzuuVar2;
                    zzbfVar = zzbfVarZzx;
                }
            } else {
                zzuuVar = zzuuVar2;
                zzbfVar = zzbfVarZzx;
            }
        } else {
            zzuuVar = zzuuVar2;
            zzbfVar = zzbfVarZzx;
        }
        zzlf zzlfVar2 = this.zzG;
        int i2 = zzlfVar2.zze;
        zzib zzibVar = z4 ? null : zzlfVar2.zzf;
        zzwv zzwvVar = z5 ? zzwv.zza : zzlfVar2.zzh;
        zzys zzysVar = z5 ? this.zzf : this.zzG.zzi;
        List listZzi = z5 ? zzgpe.zzi() : this.zzG.zzj;
        zzlf zzlfVar3 = this.zzG;
        this.zzG = new zzlf(zzbfVar, zzuuVar, j3, j2, i2, zzibVar, false, zzwvVar, zzysVar, listZzi, zzuuVar, zzlfVar3.zzl, zzlfVar3.zzm, zzlfVar3.zzn, zzlfVar3.zzo, j2, 0L, j2, 0L, false);
        if (z3) {
            zzksVar.zzj();
            this.zzt.zzg();
        }
    }

    private final Pair zzY(zzbf zzbfVar) {
        long j = 0;
        if (zzbfVar.zzg()) {
            return Pair.create(zzlf.zzb(), 0L);
        }
        int iZzk = zzbfVar.zzk(this.zzP);
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, iZzk, -9223372036854775807L);
        zzuu zzuuVarZzy = this.zzs.zzy(zzbfVar, pairZzm.first, 0L);
        long jLongValue = ((Long) pairZzm.second).longValue();
        if (zzuuVarZzy.zzb()) {
            zzbfVar.zzo(zzuuVarZzy.zza, zzbdVar);
            if (zzuuVarZzy.zzc == zzbdVar.zzd(zzuuVarZzy.zzb)) {
                zzbdVar.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzuuVarZzy, Long.valueOf(j));
    }

    private final void zzZ(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.zzg() && zzbfVar2.zzg()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
            return;
        }
        zzkd zzkdVar = (zzkd) arrayList.get(size);
        Object obj = zzkdVar.zzb;
        zzlj zzljVar = zzkdVar.zza;
        String str = zzep.zza;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaA, reason: merged with bridge method [inline-methods] */
    public final boolean zzw() {
        if (!this.zzC) {
            return false;
        }
        boolean z = this.zzB.zzg;
        return true;
    }

    private static boolean zzaB(zzlf zzlfVar, zzbd zzbdVar) {
        zzuu zzuuVar = zzlfVar.zzb;
        zzbf zzbfVar = zzlfVar.zza;
        return zzbfVar.zzg() || zzbfVar.zzo(zzuuVar.zza, zzbdVar).zzf;
    }

    private final void zzaC(boolean z, boolean z2) {
        this.zzL = z;
        long jElapsedRealtime = -9223372036854775807L;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzM = jElapsedRealtime;
    }

    private static Pair zzaD(zzbf zzbfVar, zzkg zzkgVar, boolean z, int i, boolean z2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbf zzbfVar2 = zzkgVar.zza;
        if (zzbfVar.zzg()) {
            return null;
        }
        boolean zZzg = zzbfVar2.zzg();
        zzbf zzbfVar3 = zzbfVar2;
        if (true == zZzg) {
            zzbfVar3 = zzbfVar;
        }
        try {
            Pair pairZzm = zzbfVar3.zzm(zzbeVar, zzbdVar, zzkgVar.zzb, zzkgVar.zzc);
            zzbf zzbfVar4 = zzbfVar3;
            if (!zzbfVar.equals(zzbfVar4)) {
                if (zzbfVar.zze(pairZzm.first) == -1) {
                    int iZzr = zzr(zzbeVar, zzbdVar, i, z2, pairZzm.first, zzbfVar4, zzbfVar);
                    if (iZzr != -1) {
                        return zzbfVar.zzm(zzbeVar, zzbdVar, iZzr, -9223372036854775807L);
                    }
                    return null;
                }
                if (zzbfVar4.zzo(pairZzm.first, zzbdVar).zzf && zzbfVar4.zzb(zzbdVar.zzc, zzbeVar, 0L).zzn == zzbfVar4.zze(pairZzm.first)) {
                    return zzbfVar.zzm(zzbeVar, zzbdVar, zzbfVar.zzo(pairZzm.first, zzbdVar).zzc, zzkgVar.zzc);
                }
            }
            return pairZzm;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private static final void zzaE(zzlj zzljVar) throws zzib {
        zzljVar.zzh();
        try {
            zzljVar.zza().zzx(zzljVar.zzc(), zzljVar.zze());
        } finally {
            zzljVar.zzi(true);
        }
    }

    private static final boolean zzaF(zzkp zzkpVar) {
        if (zzkpVar != null) {
            try {
                if (zzkpVar.zze) {
                    zzwk[] zzwkVarArr = zzkpVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzwk zzwkVar = zzwkVarArr[i];
                        if (zzwkVar != null) {
                            zzwkVar.zzc();
                        }
                    }
                } else {
                    zzkpVar.zza.zzc();
                }
                if (zzkpVar.zzg() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private final void zzaa() throws zzib {
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                this.zzaa = -9223372036854775807L;
                return;
            }
            int iZzd = zzlrVarArr[i].zzd();
            zzlrVarArr[i].zzA(this.zzo);
            zzN(i, false);
            this.zzR -= iZzd;
            i++;
        }
    }

    private final void zzab() {
        if (this.zzy && zzaz()) {
            zzlr[] zzlrVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzlr zzlrVar = zzlrVarArr[i];
                int iZzd = zzlrVar.zzd();
                zzlrVar.zzC(this.zzo);
                this.zzR -= iZzd - zzlrVar.zzd();
            }
            this.zzaa = -9223372036854775807L;
        }
    }

    private final void zzac() throws zzib {
        zzad();
        zzI(true);
    }

    private final void zzad() throws zzib {
        zzys zzysVarZzk;
        zzys zzysVar;
        boolean z;
        zzkh zzkhVar;
        int i;
        zzhz zzhzVar = this.zzo;
        float f = zzhzVar.zzj().zzb;
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzm = zzksVar.zzm();
        zzkp zzkpVarZzn = zzksVar.zzn();
        zzys zzysVar2 = null;
        boolean z2 = true;
        loop0: while (true) {
            if (zzkpVarZzm == null || !zzkpVarZzm.zze) {
                return;
            }
            zzlf zzlfVar = this.zzG;
            zzysVarZzk = zzkpVarZzm.zzk(f, zzlfVar.zza, zzlfVar.zzl);
            zzysVar = zzkpVarZzm == zzksVar.zzm() ? zzysVarZzk : zzysVar2;
            zzys zzysVarZzr = zzkpVarZzm.zzr();
            z = false;
            if (zzysVarZzr == null) {
                break;
            }
            zzyk[] zzykVarArr = zzysVarZzk.zzc;
            if (zzysVarZzr.zzc.length != zzykVarArr.length) {
                break;
            }
            for (int i2 = 0; i2 < zzykVarArr.length; i2++) {
                if (!zzysVarZzk.zzb(zzysVarZzr, i2)) {
                    break loop0;
                }
            }
            if (zzkpVarZzm != zzkpVarZzn) {
                z = true;
            }
            z2 &= z;
            zzkpVarZzm = zzkpVarZzm.zzp();
            zzysVar2 = zzysVar;
        }
        if (z2) {
            zzkp zzkpVarZzm2 = zzksVar.zzm();
            int iZzs = zzksVar.zzs(zzkpVarZzm2) & 1;
            zzlr[] zzlrVarArr = this.zzb;
            boolean[] zArr = new boolean[2];
            zzysVar.getClass();
            long jZzm = zzkpVarZzm2.zzm(zzysVar, this.zzG.zzs, 1 == iZzs, zArr);
            zzlf zzlfVar2 = this.zzG;
            if (zzlfVar2.zze != 4 && jZzm != zzlfVar2.zzs) {
                z = true;
            }
            zzlf zzlfVar3 = this.zzG;
            i = 2;
            zzkhVar = this;
            zzkhVar.zzG = zzao(zzlfVar3.zzb, jZzm, zzlfVar3.zzc, zzlfVar3.zzd, z, 5);
            if (z) {
                zzkhVar.zzU(jZzm, true);
            }
            zzkhVar.zzab();
            boolean[] zArr2 = new boolean[2];
            for (int i3 = 0; i3 < 2; i3++) {
                int iZzd = zzlrVarArr[i3].zzd();
                zArr2[i3] = zzlrVarArr[i3].zzM();
                zzlrVarArr[i3].zzD(zzkpVarZzm2.zzc[i3], zzhzVar, zzkhVar.zzT, zArr[i3]);
                if (iZzd - zzlrVarArr[i3].zzd() > 0) {
                    zzkhVar.zzN(i3, false);
                }
                zzkhVar.zzR -= iZzd - zzlrVarArr[i3].zzd();
            }
            zzkhVar.zzaq(zArr2, zzkhVar.zzT);
            zzkpVarZzm2.zzh = true;
        } else {
            zzkhVar = this;
            i = 2;
            zzksVar.zzs(zzkpVarZzm);
            if (zzkpVarZzm.zze) {
                long jMax = Math.max(zzkpVarZzm.zzg.zzb, zzkhVar.zzT - zzkpVarZzm.zza());
                if (zzkhVar.zzy && zzkhVar.zzaz() && zzksVar.zzo() == zzkpVarZzm) {
                    zzkhVar.zzab();
                }
                zzkpVarZzm.zzl(zzysVarZzk, jMax, false);
            }
        }
        zzkhVar.zzas(true);
        if (zzkhVar.zzG.zze != 4) {
            zzkhVar.zzam();
            zzkhVar.zzL();
            zzkhVar.zzi.zzh(i);
        }
    }

    private final boolean zzae() {
        zzkp zzkpVarZzm = this.zzs.zzm();
        long j = zzkpVarZzm.zzg.zze;
        if (zzkpVarZzm.zze) {
            return j == -9223372036854775807L || this.zzG.zzs < j || !zzax();
        }
        return false;
    }

    /* JADX WARN: Failed to calculate best type for var: r0v39 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v39 ??, new type: com.google.android.gms.internal.ads.zzdm
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v1 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v4 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v5 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v6 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v7 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v7 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v8 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v8 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r15v9 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v9 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r2v17 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r2v17 ??, new type: com.google.android.gms.internal.ads.zzdm
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r15v0 ??, new type: byte
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    private final void zzaf(com.google.android.gms.internal.ads.zzbf r31, boolean r32) throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 1015
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzaf(com.google.android.gms.internal.ads.zzbf, boolean):void");
    }

    private final void zzag(zzbf zzbfVar, zzuu zzuuVar, zzbf zzbfVar2, zzuu zzuuVar2, long j, boolean z) throws zzib {
        if (!zzP(zzbfVar, zzuuVar)) {
            zzav zzavVar = zzuuVar.zzb() ? zzav.zza : this.zzG.zzo;
            if (this.zzo.zzj().equals(zzavVar)) {
                return;
            }
            zzM(zzavVar);
            zzal(this.zzG.zzo, zzavVar.zzb, false, false);
            return;
        }
        Object obj = zzuuVar.zza;
        zzbd zzbdVar = this.zzm;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        zzhu zzhuVar = this.zzad;
        zzaf zzafVar = zzbeVar.zzj;
        String str = zzep.zza;
        zzhuVar.zza(zzafVar);
        if (j != -9223372036854775807L) {
            zzhuVar.zzb(zzO(zzbfVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzbfVar2.zzg() ? zzbfVar2.zzb(zzbfVar2.zzo(zzuuVar2.zza, zzbdVar).zzc, zzbeVar, 0L).zzb : null, zzbeVar.zzb) || z) {
            zzhuVar.zzb(-9223372036854775807L);
        }
    }

    private final long zzah(zzkp zzkpVar) {
        if (zzkpVar == null) {
            return 0L;
        }
        long jZza = zzkpVar.zza();
        if (zzkpVar.zze) {
            int i = 0;
            while (true) {
                zzlr[] zzlrVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzlrVarArr[i].zzp(zzkpVar)) {
                    long jZzf = zzlrVarArr[i].zzf(zzkpVar);
                    if (jZzf == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZza = Math.max(jZzf, jZza);
                }
                i++;
            }
        }
        return jZza;
    }

    private final void zzai() {
        zzks zzksVar = this.zzs;
        zzksVar.zzt();
        zzkp zzkpVarZzl = zzksVar.zzl();
        if (zzkpVarZzl != null) {
            if (!zzkpVarZzl.zzd || zzkpVarZzl.zze) {
                zzus zzusVar = zzkpVarZzl.zza;
                if (zzusVar.zzn()) {
                    return;
                }
                if (this.zzg.zzj(this.zzv, this.zzG.zza, zzkpVarZzl.zzg.zza, zzkpVarZzl.zze ? zzusVar.zzi() : 0L)) {
                    if (!zzkpVarZzl.zzd) {
                        zzkpVarZzl.zzt(this, zzkpVarZzl.zzg.zzb);
                        return;
                    }
                    zzkm zzkmVar = new zzkm();
                    zzkmVar.zza(this.zzT - zzkpVarZzl.zza());
                    zzkmVar.zzb(this.zzo.zzj().zzb);
                    zzkmVar.zzc(this.zzM);
                    zzkpVarZzl.zzj(new zzkn(zzkmVar, null));
                }
            }
        }
    }

    private final void zzaj() {
        zzkp zzkpVarZzm = this.zzs.zzm();
        boolean z = false;
        if (zzkpVarZzm != null && zzkpVarZzm.zzg.zzi && this.zzJ) {
            z = true;
        }
        this.zzK = z;
    }

    private final void zzak(zzav zzavVar, boolean z) throws zzib {
        zzal(zzavVar, zzavVar.zzb, true, z);
    }

    private final void zzal(zzav zzavVar, float f, boolean z, boolean z2) throws zzib {
        int i;
        if (z) {
            if (z2) {
                this.zzH.zza(1);
            }
            zzlf zzlfVar = this.zzG;
            zzbf zzbfVar = zzlfVar.zza;
            zzuu zzuuVar = zzlfVar.zzb;
            long j = zzlfVar.zzc;
            long j2 = zzlfVar.zzd;
            int i2 = zzlfVar.zze;
            zzib zzibVar = zzlfVar.zzf;
            boolean z3 = zzlfVar.zzg;
            zzwv zzwvVar = zzlfVar.zzh;
            zzys zzysVar = zzlfVar.zzi;
            List list = zzlfVar.zzj;
            zzuu zzuuVar2 = zzlfVar.zzk;
            boolean z4 = zzlfVar.zzl;
            int i3 = zzlfVar.zzm;
            int i4 = zzlfVar.zzn;
            long j3 = zzlfVar.zzq;
            long j4 = zzlfVar.zzr;
            long j5 = zzlfVar.zzs;
            long j6 = zzlfVar.zzt;
            boolean z5 = zzlfVar.zzp;
            this.zzG = new zzlf(zzbfVar, zzuuVar, j, j2, i2, zzibVar, z3, zzwvVar, zzysVar, list, zzuuVar2, z4, i3, i4, zzavVar, j3, j4, j5, j6, false);
        }
        float f2 = zzavVar.zzb;
        zzkp zzkpVarZzm = this.zzs.zzm();
        while (true) {
            i = 0;
            if (zzkpVarZzm == null) {
                break;
            }
            zzyk[] zzykVarArr = zzkpVarZzm.zzr().zzc;
            int length = zzykVarArr.length;
            while (i < length) {
                zzyk zzykVar = zzykVarArr[i];
                i++;
            }
            zzkpVarZzm = zzkpVarZzm.zzp();
        }
        zzlr[] zzlrVarArr = this.zzb;
        while (i < 2) {
            zzlrVarArr[i].zzm(f, f2);
            i++;
        }
    }

    private final void zzam() {
        long jZza;
        long jZza2;
        zzks zzksVar = this.zzs;
        boolean zZzh = false;
        if (zzaF(zzksVar.zzk())) {
            zzkp zzkpVarZzk = zzksVar.zzk();
            long jZzau = zzau(zzkpVarZzk.zzg());
            if (zzkpVarZzk == zzksVar.zzm()) {
                jZza = this.zzT;
                jZza2 = zzkpVarZzk.zza();
            } else {
                jZza = this.zzT - zzkpVarZzk.zza();
                jZza2 = zzkpVarZzk.zzg.zzb;
            }
            zzkk zzkkVar = new zzkk(this.zzv, this.zzG.zza, zzkpVarZzk.zzg.zza, jZza - jZza2, jZzau, this.zzo.zzj().zzb, this.zzG.zzl, this.zzL, zzP(this.zzG.zza, zzkpVarZzk.zzg.zza) ? this.zzad.zze() : -9223372036854775807L, this.zzM);
            zzkl zzklVar = this.zzg;
            boolean zZzh2 = zzklVar.zzh(zzkkVar);
            zzkp zzkpVarZzm = zzksVar.zzm();
            if (zZzh2 || !zzkpVarZzm.zze || jZzau >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzkpVarZzm.zza.zzf(this.zzG.zzs, false);
                zZzh = zzklVar.zzh(zzkkVar);
            }
        }
        this.zzN = zZzh;
        if (zZzh) {
            zzkp zzkpVarZzk2 = zzksVar.zzk();
            zzkpVarZzk2.getClass();
            zzkm zzkmVar = new zzkm();
            zzkmVar.zza(this.zzT - zzkpVarZzk2.zza());
            zzkmVar.zzb(this.zzo.zzj().zzb);
            zzkmVar.zzc(this.zzM);
            zzkpVarZzk2.zzj(new zzkn(zzkmVar, null));
        }
        zzan();
    }

    private final void zzan() {
        zzkp zzkpVarZzk = this.zzs.zzk();
        boolean z = true;
        if (!this.zzN && (zzkpVarZzk == null || !zzkpVarZzk.zza.zzn())) {
            z = false;
        }
        zzlf zzlfVar = this.zzG;
        if (z != zzlfVar.zzg) {
            this.zzG = zzlfVar.zzg(z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0099  */
    private final zzlf zzao(zzuu zzuuVar, long j, long j2, long j3, boolean z, int i) {
        List list;
        zzys zzysVar;
        zzkp zzkpVarZzm;
        int i2 = 0;
        this.zzW = (!this.zzW && j == this.zzG.zzs && zzuuVar.equals(this.zzG.zzb)) ? false : true;
        zzaj();
        zzlf zzlfVar = this.zzG;
        zzwv zzwvVar = zzlfVar.zzh;
        zzys zzysVar2 = zzlfVar.zzi;
        List listZzi = zzlfVar.zzj;
        if (this.zzt.zzb()) {
            zzks zzksVar = this.zzs;
            zzkp zzkpVarZzm2 = zzksVar.zzm();
            zzwv zzwvVarZzq = zzkpVarZzm2 == null ? zzwv.zza : zzkpVarZzm2.zzq();
            zzys zzysVarZzr = zzkpVarZzm2 == null ? this.zzf : zzkpVarZzm2.zzr();
            zzyk[] zzykVarArr = zzysVarZzr.zzc;
            zzgpb zzgpbVar = new zzgpb();
            boolean z2 = false;
            for (zzyk zzykVar : zzykVarArr) {
                if (zzykVar != null) {
                    zzap zzapVar = zzykVar.zzb(0).zzl;
                    if (zzapVar == null) {
                        zzgpbVar.zzf(new zzap(-9223372036854775807L, new zzao[0]));
                    } else {
                        zzgpbVar.zzf(zzapVar);
                        z2 = true;
                    }
                }
            }
            zzgpe zzgpeVarZzi = z2 ? zzgpbVar.zzi() : zzgpe.zzi();
            if (zzkpVarZzm2 != null) {
                zzkq zzkqVar = zzkpVarZzm2.zzg;
                if (zzkqVar.zzc != j2) {
                    zzkpVarZzm2.zzg = zzkqVar.zzb(j2);
                }
            }
            if (zzksVar.zzm() == zzksVar.zzn() && (zzkpVarZzm = zzksVar.zzm()) != null) {
                zzys zzysVarZzr2 = zzkpVarZzm.zzr();
                while (true) {
                    zzlr[] zzlrVarArr = this.zzb;
                    if (i2 >= 2) {
                        break;
                    }
                    if (zzysVarZzr2.zza(i2)) {
                        if (zzlrVarArr[i2].zze() != 1) {
                            break;
                        }
                        int i3 = zzysVarZzr2.zzb[i2].zzb;
                    }
                    i2++;
                }
            }
            list = zzgpeVarZzi;
            zzwvVar = zzwvVarZzq;
            zzysVar = zzysVarZzr;
        } else {
            if (!zzuuVar.equals(this.zzG.zzb)) {
                zzysVar2 = this.zzf;
                zzwvVar = zzwv.zza;
                listZzi = zzgpe.zzi();
            }
            list = listZzi;
            zzysVar = zzysVar2;
        }
        if (z) {
            this.zzH.zzc(i);
        }
        return this.zzG.zzc(zzuuVar, j, j2, j3, zzat(), zzwvVar, zzysVar, list);
    }

    private final void zzap() throws zzib {
        zzaq(new boolean[2], this.zzs.zzn().zzc());
    }

    private final void zzaq(boolean[] zArr, long j) throws zzib {
        zzlr[] zzlrVarArr;
        long j2;
        zzkp zzkpVarZzn = this.zzs.zzn();
        zzys zzysVarZzr = zzkpVarZzn.zzr();
        int i = 0;
        while (true) {
            zzlrVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzysVarZzr.zza(i)) {
                zzlrVarArr[i].zzG();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < 2) {
            if (!zzysVarZzr.zza(i2) || zzlrVarArr[i2].zzp(zzkpVarZzn)) {
                j2 = j;
            } else {
                j2 = j;
                zzar(zzkpVarZzn, i2, zArr[i2], j2);
            }
            i2++;
            j = j2;
        }
    }

    private final void zzar(zzkp zzkpVar, int i, boolean z, long j) throws zzib {
        zzlr zzlrVar = this.zzb[i];
        if (zzlrVar.zzM()) {
            return;
        }
        boolean z2 = zzkpVar == this.zzs.zzm();
        zzys zzysVarZzr = zzkpVar.zzr();
        zzlq zzlqVar = zzysVarZzr.zzb[i];
        zzyk zzykVar = zzysVarZzr.zzc[i];
        boolean z3 = zzax() && this.zzG.zze == 3;
        boolean z4 = !z && z3;
        this.zzR++;
        zzlrVar.zzx(zzlqVar, zzykVar, zzkpVar.zzc[i], this.zzT, z4, z2, j, zzkpVar.zza(), zzkpVar.zzg.zza, this.zzo);
        zzlrVar.zzy(11, new zzjv(this), zzkpVar);
        if (z3 && z2) {
            zzlrVar.zzv();
        }
    }

    private final void zzas(boolean z) {
        zzkp zzkpVarZzk = this.zzs.zzk();
        zzuu zzuuVar = zzkpVarZzk == null ? this.zzG.zzb : zzkpVarZzk.zzg.zza;
        boolean zEquals = this.zzG.zzk.equals(zzuuVar);
        if (!zEquals) {
            this.zzG = this.zzG.zzh(zzuuVar);
        }
        zzlf zzlfVar = this.zzG;
        zzlfVar.zzq = zzkpVarZzk == null ? zzlfVar.zzs : zzkpVarZzk.zzf();
        this.zzG.zzr = zzat();
        if ((!zEquals || z) && zzkpVarZzk != null && zzkpVarZzk.zze) {
            zzaw(zzkpVarZzk.zzg.zza, zzkpVarZzk.zzq(), zzkpVarZzk.zzr());
        }
    }

    private final long zzat() {
        return zzau(this.zzG.zzq);
    }

    private final long zzau(long j) {
        zzkp zzkpVarZzk = this.zzs.zzk();
        if (zzkpVarZzk == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzT - zzkpVarZzk.zza()));
    }

    private final long zzav(zzkp zzkpVar) {
        zzgmd.zzh(zzkpVar.zze);
        return (long) ((zzkpVar.zzc() - this.zzT) / this.zzo.zzj().zzb);
    }

    private final void zzaw(zzuu zzuuVar, zzwv zzwvVar, zzys zzysVar) {
        long jZza;
        long jZza2;
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzk = zzksVar.zzk();
        zzkpVarZzk.getClass();
        if (zzkpVarZzk == zzksVar.zzm()) {
            jZza = this.zzT;
            jZza2 = zzkpVarZzk.zza();
        } else {
            jZza = this.zzT - zzkpVarZzk.zza();
            jZza2 = zzkpVarZzk.zzg.zzb;
        }
        this.zzg.zzb(new zzkk(this.zzv, this.zzG.zza, zzuuVar, jZza - jZza2, zzau(zzkpVarZzk.zzf()), this.zzo.zzj().zzb, this.zzG.zzl, this.zzL, zzP(this.zzG.zza, zzkpVarZzk.zzg.zza) ? this.zzad.zze() : -9223372036854775807L, this.zzM), zzwvVar, zzysVar.zzc);
    }

    private final boolean zzax() {
        zzlf zzlfVar = this.zzG;
        return zzlfVar.zzl && zzlfVar.zzn == 0;
    }

    private final void zzay(int i) throws zzib, IOException {
        zzlr zzlrVar = this.zzb[i];
        try {
            zzkp zzkpVarZzm = this.zzs.zzm();
            if (zzkpVarZzm == null) {
                throw null;
            }
            zzkp zzkpVar = zzkpVarZzm;
            zzlrVar.zzu(zzkpVarZzm);
        } catch (IOException | RuntimeException e) {
            zzlrVar.zze();
            throw e;
        }
    }

    private final boolean zzaz() {
        if (!this.zzy) {
            return false;
        }
        zzlr[] zzlrVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzlrVarArr[i].zzc()) {
                return true;
            }
        }
        return false;
    }

    static int zzr(zzbe zzbeVar, zzbd zzbdVar, int i, boolean z, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        zzbf zzbfVar3 = zzbfVar;
        Object obj2 = zzbfVar3.zzb(zzbfVar3.zzo(obj, zzbdVar).zzc, zzbeVar, 0L).zzb;
        for (int i2 = 0; i2 < zzbfVar2.zza(); i2++) {
            if (zzbfVar2.zzb(i2, zzbeVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZze = zzbfVar3.zze(obj);
        int iZzc = zzbfVar3.zzc();
        int iZze2 = -1;
        int i3 = 0;
        while (i3 < iZzc && iZze2 == -1) {
            zzbf zzbfVar4 = zzbfVar3;
            int iZzl = zzbfVar4.zzl(iZze, zzbdVar, zzbeVar, i, z);
            if (iZzl == -1) {
                iZze2 = -1;
                break;
            }
            iZze2 = zzbfVar2.zze(zzbfVar4.zzf(iZzl));
            i3++;
            zzbfVar3 = zzbfVar4;
            iZze = iZzl;
        }
        if (iZze2 == -1) {
            return -1;
        }
        return zzbfVar2.zzd(iZze2, zzbdVar, false).zzc;
    }

    static final /* synthetic */ void zzz(zzlj zzljVar) {
        try {
            zzaE(zzljVar);
        } catch (zzib e) {
            zzdt.zzf("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:215:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:267:0x05bf  */
    /* JADX WARN: Code duplicated, block: B:268:0x05c4 A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TRY_LEAVE, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:273:0x05d0 A[Catch: RuntimeException -> 0x06dc, IOException -> 0x06e1, zztu -> 0x06e6, zzgc -> 0x06eb, zzat -> 0x06f0, zzrr -> 0x06f5, zzib -> 0x06fa, TryCatch #16 {zzat -> 0x06f0, zzgc -> 0x06eb, zzib -> 0x06fa, zzrr -> 0x06f5, zztu -> 0x06e6, IOException -> 0x06e1, RuntimeException -> 0x06dc, blocks: (B:270:0x05ca, B:273:0x05d0, B:276:0x05d9, B:281:0x05e8, B:285:0x05f8, B:290:0x060e, B:295:0x0622), top: B:688:0x05ca }] */
    /* JADX WARN: Code duplicated, block: B:275:0x05d8  */
    /* JADX WARN: Code duplicated, block: B:278:0x05dd A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TRY_ENTER, TRY_LEAVE, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x05e5 A[LOOP:15: B:276:0x05d9->B:280:0x05e5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:299:0x065c A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:325:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:327:0x06cd A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, LOOP:18: B:326:0x06cb->B:327:0x06cd, LOOP_END, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:343:0x06ff A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:345:0x0708 A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:347:0x070c A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:349:0x0711 A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:351:0x0719 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:352:0x071a A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:356:0x0728  */
    /* JADX WARN: Code duplicated, block: B:359:0x0734  */
    /* JADX WARN: Code duplicated, block: B:372:0x075b A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, LOOP:5: B:370:0x0757->B:372:0x075b, LOOP_END, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:374:0x077d  */
    /* JADX WARN: Code duplicated, block: B:376:0x0780 A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:418:0x083d A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, LOOP:8: B:417:0x083b->B:418:0x083d, LOOP_END, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:421:0x084b A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:425:0x085b A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:427:0x0861 A[Catch: RuntimeException -> 0x0b00, zzib -> 0x0b02, IOException -> 0x0b36, zztu -> 0x0b3d, zzgc -> 0x0b44, zzat -> 0x0b4b, zzrr -> 0x0b61, TryCatch #24 {zzib -> 0x0b02, RuntimeException -> 0x0b00, blocks: (B:254:0x056a, B:256:0x0579, B:257:0x0582, B:259:0x0593, B:261:0x05a1, B:265:0x05b9, B:362:0x073b, B:364:0x0741, B:366:0x0747, B:369:0x074c, B:370:0x0757, B:372:0x075b, B:376:0x0780, B:378:0x0786, B:380:0x078e, B:381:0x0796, B:382:0x0799, B:384:0x07a2, B:432:0x086e, B:438:0x0886, B:443:0x0892, B:445:0x089a, B:446:0x08a1, B:448:0x08af, B:449:0x08c9, B:451:0x08cd, B:453:0x08d5, B:467:0x0902, B:454:0x08db, B:456:0x08e6, B:460:0x08ef, B:466:0x08ff, B:470:0x0916, B:472:0x091c, B:476:0x0924, B:478:0x092c, B:480:0x0930, B:481:0x093b, B:483:0x0941, B:534:0x0a4e, B:537:0x0a56, B:539:0x0a5a, B:541:0x0a62, B:542:0x0a65, B:543:0x0a69, B:545:0x0a6f, B:547:0x0a78, B:549:0x0a82, B:551:0x0a88, B:553:0x0a8e, B:560:0x0ab0, B:562:0x0ab6, B:566:0x0ac0, B:577:0x0adb, B:574:0x0ad4, B:576:0x0ad8, B:554:0x0a95, B:557:0x0aa3, B:558:0x0aab, B:559:0x0aac, B:484:0x094a, B:486:0x0951, B:488:0x0955, B:513:0x09ef, B:515:0x09fb, B:491:0x095f, B:493:0x0963, B:495:0x0975, B:497:0x0980, B:499:0x098a, B:503:0x0993, B:505:0x099d, B:511:0x09a8, B:516:0x0a08, B:518:0x0a0f, B:520:0x0a13, B:524:0x0a1c, B:526:0x0a2c, B:528:0x0a32, B:530:0x0a3c, B:531:0x0a41, B:532:0x0a46, B:533:0x0a4b, B:469:0x090d, B:387:0x07ac, B:389:0x07b0, B:391:0x07b6, B:393:0x07bc, B:395:0x07c6, B:398:0x07cc, B:399:0x07cf, B:401:0x07d8, B:403:0x07ed, B:405:0x07f6, B:407:0x07fe, B:412:0x0808, B:414:0x0832, B:416:0x0838, B:418:0x083d, B:419:0x0845, B:421:0x084b, B:422:0x084e, B:423:0x0857, B:425:0x085b, B:427:0x0861, B:428:0x0866, B:431:0x086d, B:268:0x05c4, B:278:0x05dd, B:283:0x05ee, B:287:0x0600, B:292:0x0616, B:297:0x0655, B:299:0x065c, B:301:0x0660, B:305:0x0670, B:307:0x0674, B:311:0x067b, B:313:0x0681, B:315:0x069e, B:318:0x06a7, B:319:0x06aa, B:321:0x06b1, B:322:0x06b9, B:324:0x06bf, B:303:0x0666, B:327:0x06cd, B:343:0x06ff, B:345:0x0708, B:347:0x070c, B:349:0x0711, B:361:0x0738, B:352:0x071a, B:354:0x0720, B:358:0x072e, B:360:0x0735, B:581:0x0ae6, B:585:0x0af1), top: B:687:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:688:0x05ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:701:0x077b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:716:0x0866 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:730:0x05e8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:731:0x05bf A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:385:0x07a6
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message r43) {
        /*
            Method dump skipped, instruction units count: 3272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zza(float f) {
        this.zzi.zzh(34);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzb(int i) {
        this.zzi.zze(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzc(zzav zzavVar) {
        this.zzi.zzd(16, zzavVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzcS(long j, long j2, zzv zzvVar, MediaFormat mediaFormat) {
        if (this.zzD) {
            this.zzi.zzc(37).zza();
        }
    }

    public final void zzd() {
        this.zzi.zzc(29).zza();
    }

    public final void zze(boolean z, int i, int i2) {
        this.zzi.zze(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzf(zzbf zzbfVar, int i, long j) {
        this.zzi.zzd(3, new zzkg(zzbfVar, i, j)).zza();
    }

    public final void zzg(zzlu zzluVar) {
        this.zzi.zzd(38, zzluVar).zza();
    }

    public final void zzh() {
        this.zzi.zzc(6).zza();
    }

    public final void zzi(zzd zzdVar, boolean z) {
        this.zzi.zzf(31, 0, 0, zzdVar).zza();
    }

    public final void zzj(float f) {
        this.zzi.zzd(32, Float.valueOf(f)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzk(zzlj zzljVar) {
        if (!this.zzI && this.zzk.getThread().isAlive()) {
            this.zzi.zzd(14, zzljVar).zza();
        } else {
            zzdt.zzc("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzljVar.zzi(false);
        }
    }

    public final boolean zzl(Object obj, long j) {
        if (this.zzI || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzdf zzdfVar = new zzdf(this.zzq);
        this.zzi.zzd(30, new Pair(obj, zzdfVar)).zza();
        if (j != -9223372036854775807L) {
            return zzdfVar.zze(j);
        }
        return true;
    }

    public final boolean zzm() {
        if (this.zzI || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzI = true;
        zzdf zzdfVar = new zzdf(this.zzq);
        this.zzi.zzd(7, zzdfVar).zza();
        return zzdfVar.zze(this.zzu);
    }

    public final Looper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final void zzo() {
        zzdm zzdmVar = this.zzi;
        zzdmVar.zzk(2);
        zzdmVar.zzh(22);
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        this.zzi.zzd(8, zzusVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyq
    public final void zzq() {
        this.zzi.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        this.zzi.zzd(9, (zzus) zzwmVar).zza();
    }

    final /* synthetic */ zzkp zzt(zzkq zzkqVar, long j) {
        zzyv zzyvVarZze = this.zzg.zze(this.zzv);
        long j2 = this.zzZ.zzb;
        zzys zzysVar = this.zzf;
        zzle zzleVar = this.zzt;
        return new zzkp(this.zzc, j, this.zze, zzyvVarZze, zzleVar, zzkqVar, zzysVar, -9223372036854775807L);
    }

    final /* synthetic */ void zzu(int i, boolean z) {
        this.zzw.zzB(i, this.zzb[i].zze(), z);
    }

    final /* synthetic */ void zzv(int i) {
        this.zzw.zzW(i);
    }

    final /* synthetic */ zzdm zzx() {
        return this.zzi;
    }

    public final void zzy(List list, int i, long j, zzwn zzwnVar) {
        this.zzi.zzd(17, new zzkb(list, zzwnVar, i, j, null)).zza();
    }
}
