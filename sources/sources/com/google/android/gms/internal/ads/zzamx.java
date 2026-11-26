package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamx implements zzamq {
    private final zzant zza;
    private long zzf;
    private String zzh;
    private zzaem zzi;
    private zzamw zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = "video/mp2t";
    private final boolean[] zzg = new boolean[3];
    private final zzanh zzc = new zzanh(7, 128);
    private final zzanh zzd = new zzanh(8, 128);
    private final zzanh zze = new zzanh(6, 128);
    private long zzl = -9223372036854775807L;
    private final zzeg zzn = new zzeg();

    public zzamx(zzant zzantVar, boolean z, boolean z2, String str) {
        this.zza = zzantVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(long j, int i, long j2) {
        if (!this.zzk) {
            this.zzc.zzc(i);
            this.zzd.zzc(i);
        }
        this.zze.zzc(i);
        this.zzj.zzd(j, i, j2, this.zzm);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        if (!this.zzk) {
            this.zzc.zzd(bArr, i, i2);
            this.zzd.zzd(bArr, i, i2);
        }
        this.zze.zzd(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = -9223372036854775807L;
        zzfm.zzi(this.zzg);
        this.zzc.zza();
        this.zzd.zza();
        this.zze.zza();
        this.zza.zze();
        zzamw zzamwVar = this.zzj;
        if (zzamwVar != null) {
            zzamwVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzh = zzaoeVar.zzc();
        this.zzi = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        this.zzj = new zzamw(this.zzi, false, false);
        this.zza.zza(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzl = j;
        int i2 = i & 2;
        this.zzm = (i2 != 0) | this.zzm;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0041  */
    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        int i;
        int i2;
        this.zzi.getClass();
        String str = zzep.zza;
        int iZzg = zzegVar.zzg();
        int iZze = zzegVar.zze();
        byte[] bArrZzi = zzegVar.zzi();
        this.zzf += (long) zzegVar.zzd();
        this.zzi.zzz(zzegVar, zzegVar.zzd());
        while (true) {
            int iZzh = zzfm.zzh(bArrZzi, iZzg, iZze, this.zzg);
            if (iZzh == iZze) {
                zzg(bArrZzi, iZzg, iZze);
                return;
            }
            int i3 = bArrZzi[iZzh + 3] & Ascii.US;
            if (iZzh > 0) {
                int i4 = iZzh - 1;
                if (bArrZzi[i4] == 0) {
                    i2 = 4;
                    i = i4;
                } else {
                    i = iZzh;
                    i2 = 3;
                }
            } else {
                i = iZzh;
                i2 = 3;
            }
            int i5 = i - iZzg;
            if (i5 > 0) {
                zzg(bArrZzi, iZzg, i);
            }
            int i6 = iZze - i;
            long j = this.zzf - ((long) i6);
            zzh(j, i6, i5 < 0 ? -i5 : 0, this.zzl);
            zzf(j, i3, this.zzl);
            iZzg = i + i2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
        this.zzi.getClass();
        String str = zzep.zza;
        if (z) {
            this.zza.zzd();
            zzh(this.zzf, 0, 0, this.zzl);
            zzf(this.zzf, 9, this.zzl);
            zzh(this.zzf, 0, 0, this.zzl);
        }
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzh(long j, int i, int i2, long j2) {
        if (!this.zzk) {
            zzanh zzanhVar = this.zzc;
            zzanhVar.zze(i2);
            zzanh zzanhVar2 = this.zzd;
            zzanhVar2.zze(i2);
            if (this.zzk) {
                if (zzanhVar.zzb()) {
                    zzfl zzflVarZzd = zzfm.zzd(zzanhVar.zza, 4, zzanhVar.zzb);
                    this.zza.zzb(zzflVarZzd.zzm);
                    this.zzj.zza(zzflVarZzd);
                    zzanhVar.zza();
                } else if (zzanhVar2.zzb()) {
                    this.zzj.zzb(zzfm.zzg(zzanhVar2.zza, 4, zzanhVar2.zzb));
                    zzanhVar2.zza();
                }
            } else if (zzanhVar.zzb() && zzanhVar2.zzb()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzanhVar.zza, zzanhVar.zzb));
                arrayList.add(Arrays.copyOf(zzanhVar2.zza, zzanhVar2.zzb));
                zzfl zzflVarZzd2 = zzfm.zzd(zzanhVar.zza, 4, zzanhVar.zzb);
                zzfk zzfkVarZzg = zzfm.zzg(zzanhVar2.zza, 4, zzanhVar2.zzb);
                String strZza = zzdd.zza(zzflVarZzd2.zza, zzflVarZzd2.zzb, zzflVarZzd2.zzc);
                zzaem zzaemVar = this.zzi;
                zzt zztVar = new zzt();
                zztVar.zza(this.zzh);
                zztVar.zzl(this.zzb);
                zztVar.zzm("video/avc");
                zztVar.zzj(strZza);
                zztVar.zzt(zzflVarZzd2.zze);
                zztVar.zzu(zzflVarZzd2.zzf);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzflVarZzd2.zzj);
                zzhVar.zzb(zzflVarZzd2.zzk);
                zzhVar.zzc(zzflVarZzd2.zzl);
                zzhVar.zze(zzflVarZzd2.zzh + 8);
                zzhVar.zzf(zzflVarZzd2.zzi + 8);
                zztVar.zzC(zzhVar.zzg());
                zztVar.zzz(zzflVarZzd2.zzg);
                zztVar.zzp(arrayList);
                int i3 = zzflVarZzd2.zzm;
                zztVar.zzo(i3);
                zzaemVar.zzu(zztVar.zzM());
                this.zzk = true;
                this.zza.zzb(i3);
                this.zzj.zza(zzflVarZzd2);
                this.zzj.zzb(zzfkVarZzg);
                zzanhVar.zza();
                zzanhVar2.zza();
            }
        }
        zzanh zzanhVar3 = this.zze;
        if (zzanhVar3.zze(i2)) {
            int iZza = zzfm.zza(zzanhVar3.zza, zzanhVar3.zzb);
            zzeg zzegVar = this.zzn;
            zzegVar.zzb(zzanhVar3.zza, iZza);
            zzegVar.zzh(4);
            this.zza.zzc(j2, zzegVar);
        }
        if (this.zzj.zze(j, i, this.zzk)) {
            this.zzm = false;
        }
    }
}
