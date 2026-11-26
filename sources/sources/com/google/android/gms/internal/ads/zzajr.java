package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzajr {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzeg zzg = new zzeg(255);

    zzajr() {
    }

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzadb zzadbVar, long j) throws IOException {
        zzgmd.zza(zzadbVar.zzn() == zzadbVar.zzm());
        zzeg zzegVar = this.zzg;
        zzegVar.zza(4);
        while (true) {
            if ((j != -1 && zzadbVar.zzn() + 4 >= j) || !zzade.zze(zzadbVar, zzegVar.zzi(), 0, 4, true)) {
                break;
            }
            zzegVar.zzh(0);
            if (zzegVar.zzz() == 1332176723) {
                zzadbVar.zzl();
                return true;
            }
            zzadbVar.zzf(1);
        }
        do {
            if (j != -1 && zzadbVar.zzn() >= j) {
                break;
            }
        } while (zzadbVar.zzd(1) != -1);
        return false;
    }

    public final boolean zzc(zzadb zzadbVar, boolean z) throws IOException {
        zza();
        zzeg zzegVar = this.zzg;
        zzegVar.zza(27);
        if (zzade.zze(zzadbVar, zzegVar.zzi(), 0, 27, z) && zzegVar.zzz() == 1332176723) {
            if (zzegVar.zzs() != 0) {
                if (z) {
                    return false;
                }
                throw zzat.zzc("unsupported bit stream revision");
            }
            this.zza = zzegVar.zzs();
            this.zzb = zzegVar.zzE();
            zzegVar.zzA();
            zzegVar.zzA();
            zzegVar.zzA();
            int iZzs = zzegVar.zzs();
            this.zzc = iZzs;
            this.zzd = iZzs + 27;
            zzegVar.zza(iZzs);
            if (zzade.zze(zzadbVar, zzegVar.zzi(), 0, this.zzc, z)) {
                for (int i = 0; i < this.zzc; i++) {
                    int[] iArr = this.zzf;
                    int iZzs2 = zzegVar.zzs();
                    iArr[i] = iZzs2;
                    this.zze += iZzs2;
                }
                return true;
            }
        }
        return false;
    }
}
