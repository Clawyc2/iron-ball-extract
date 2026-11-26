package com.google.android.gms.internal.ads;

import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamz implements zzamq {
    private final zzant zza;
    private String zzb;
    private zzaem zzc;
    private zzamy zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzanh zzg = new zzanh(32, 128);
    private final zzanh zzh = new zzanh(33, 128);
    private final zzanh zzi = new zzanh(34, 128);
    private final zzanh zzj = new zzanh(39, 128);
    private final zzanh zzk = new zzanh(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzeg zzn = new zzeg();

    public zzamz(zzant zzantVar, String str) {
        this.zza = zzantVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(long j, int i, int i2, long j2) {
        this.zzd.zzb(j, i, i2, j2, this.zze);
        if (!this.zze) {
            this.zzg.zzc(i2);
            this.zzh.zzc(i2);
            this.zzi.zzc(i2);
        }
        this.zzj.zzc(i2);
        this.zzk.zzc(i2);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zzd(bArr, i, i2);
            this.zzh.zzd(bArr, i, i2);
            this.zzi.zzd(bArr, i, i2);
        }
        this.zzj.zzd(bArr, i, i2);
        this.zzk.zzd(bArr, i, i2);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzh(long j, int i, int i2, long j2) {
        this.zzd.zzd(j, i, this.zze);
        if (!this.zze) {
            zzanh zzanhVar = this.zzg;
            zzanhVar.zze(i2);
            zzanh zzanhVar2 = this.zzh;
            zzanhVar2.zze(i2);
            zzanh zzanhVar3 = this.zzi;
            zzanhVar3.zze(i2);
            if (zzanhVar.zzb() && zzanhVar2.zzb() && zzanhVar3.zzb()) {
                String str = this.zzb;
                int i3 = zzanhVar.zzb;
                byte[] bArr = new byte[zzanhVar2.zzb + i3 + zzanhVar3.zzb];
                System.arraycopy(zzanhVar.zza, 0, bArr, 0, i3);
                System.arraycopy(zzanhVar2.zza, 0, bArr, zzanhVar.zzb, zzanhVar2.zzb);
                System.arraycopy(zzanhVar3.zza, 0, bArr, zzanhVar.zzb + zzanhVar2.zzb, zzanhVar3.zzb);
                String strZzb = null;
                zzfg zzfgVarZzf = zzfm.zzf(zzanhVar2.zza, 3, zzanhVar2.zzb, null);
                zzfb zzfbVar = zzfgVarZzf.zzb;
                if (zzfbVar != null) {
                    int i4 = zzfbVar.zzf;
                    int[] iArr = zzfbVar.zze;
                    int i5 = zzfbVar.zzd;
                    strZzb = zzdd.zzb(zzfbVar.zza, zzfbVar.zzb, zzfbVar.zzc, i5, iArr, i4);
                }
                zzt zztVar = new zzt();
                zztVar.zza(str);
                zztVar.zzl("video/mp2t");
                zztVar.zzm("video/hevc");
                zztVar.zzj(strZzb);
                zztVar.zzt(zzfgVarZzf.zze);
                zztVar.zzu(zzfgVarZzf.zzf);
                zztVar.zzv(zzfgVarZzf.zzg);
                zztVar.zzw(zzfgVarZzf.zzh);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzfgVarZzf.zzk);
                zzhVar.zzb(zzfgVarZzf.zzl);
                zzhVar.zzc(zzfgVarZzf.zzm);
                zzhVar.zze(zzfgVarZzf.zzc + 8);
                zzhVar.zzf(zzfgVarZzf.zzd + 8);
                zztVar.zzC(zzhVar.zzg());
                zztVar.zzz(zzfgVarZzf.zzi);
                zztVar.zzo(zzfgVarZzf.zzj);
                zztVar.zzD(zzfgVarZzf.zza + 1);
                zztVar.zzp(Collections.singletonList(bArr));
                zzv zzvVarZzM = zztVar.zzM();
                this.zzc.zzu(zzvVarZzM);
                int i6 = zzvVarZzM.zzq;
                zzgmd.zzh(i6 != -1);
                this.zza.zzb(i6);
                this.zze = true;
            }
        }
        zzanh zzanhVar4 = this.zzj;
        if (zzanhVar4.zze(i2)) {
            int iZza = zzfm.zza(zzanhVar4.zza, zzanhVar4.zzb);
            zzeg zzegVar = this.zzn;
            zzegVar.zzb(zzanhVar4.zza, iZza);
            zzegVar.zzk(5);
            this.zza.zzc(j2, zzegVar);
        }
        zzanh zzanhVar5 = this.zzk;
        if (zzanhVar5.zze(i2)) {
            int iZza2 = zzfm.zza(zzanhVar5.zza, zzanhVar5.zzb);
            zzeg zzegVar2 = this.zzn;
            zzegVar2.zzb(zzanhVar5.zza, iZza2);
            zzegVar2.zzk(5);
            this.zza.zzc(j2, zzegVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzfm.zzi(this.zzf);
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
        this.zzj.zza();
        this.zzk.zza();
        this.zza.zze();
        zzamy zzamyVar = this.zzd;
        if (zzamyVar != null) {
            zzamyVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzb = zzaoeVar.zzc();
        this.zzc = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        this.zzd = new zzamy(this.zzc);
        this.zza.zza(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        this.zzc.getClass();
        String str = zzep.zza;
        while (zzegVar.zzd() > 0) {
            int iZzg = zzegVar.zzg();
            int iZze = zzegVar.zze();
            byte[] bArrZzi = zzegVar.zzi();
            this.zzl += (long) zzegVar.zzd();
            this.zzc.zzz(zzegVar, zzegVar.zzd());
            while (iZzg < iZze) {
                int iZzh = zzfm.zzh(bArrZzi, iZzg, iZze, this.zzf);
                if (iZzh == iZze) {
                    zzg(bArrZzi, iZzg, iZze);
                    return;
                }
                int i = bArrZzi[iZzh + 3] & 126;
                int i2 = 3;
                if (iZzh > 0) {
                    int i3 = iZzh - 1;
                    if (bArrZzi[i3] == 0) {
                        i2 = 4;
                        iZzh = i3;
                    }
                }
                int i4 = iZzh - iZzg;
                if (i4 > 0) {
                    zzg(bArrZzi, iZzg, iZzh);
                }
                int i5 = iZze - iZzh;
                long j = this.zzl - ((long) i5);
                zzh(j, i5, i4 < 0 ? -i4 : 0, this.zzm);
                zzf(j, i5, i >> 1, this.zzm);
                iZzg = iZzh + i2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
        this.zzc.getClass();
        String str = zzep.zza;
        if (z) {
            this.zza.zzd();
            zzh(this.zzl, 0, 0, this.zzm);
            zzf(this.zzl, 0, 48, this.zzm);
        }
    }
}
