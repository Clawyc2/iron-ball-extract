package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzanw {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzem zza = new zzem(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzeg zzb = new zzeg();

    zzanw(int i) {
    }

    private final int zze(zzadb zzadbVar) {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzadbVar.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zzadb zzadbVar, zzaea zzaeaVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzadbVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (this.zze) {
            if (this.zzg == -9223372036854775807L) {
                zze(zzadbVar);
                return 0;
            }
            if (this.zzd) {
                long j2 = this.zzf;
                if (j2 == -9223372036854775807L) {
                    zze(zzadbVar);
                    return 0;
                }
                zzem zzemVar = this.zza;
                this.zzh = zzemVar.zzf(this.zzg) - zzemVar.zze(j2);
                zze(zzadbVar);
                return 0;
            }
            int iMin = (int) Math.min(112800L, zzadbVar.zzo());
            if (zzadbVar.zzn() != 0) {
                zzaeaVar.zza = 0L;
                return 1;
            }
            zzeg zzegVar = this.zzb;
            zzegVar.zza(iMin);
            zzadbVar.zzl();
            zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
            int iZze = zzegVar.zze();
            for (int iZzg = zzegVar.zzg(); iZzg < iZze; iZzg++) {
                if (zzegVar.zzi()[iZzg] == 71) {
                    long jZzb = zzaog.zzb(zzegVar, iZzg, i);
                    if (jZzb != -9223372036854775807L) {
                        j = jZzb;
                        break;
                    }
                }
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        }
        long jZzo = zzadbVar.zzo();
        int iMin2 = (int) Math.min(112800L, jZzo);
        long j3 = jZzo - ((long) iMin2);
        if (zzadbVar.zzn() != j3) {
            zzaeaVar.zza = j3;
            return 1;
        }
        zzeg zzegVar2 = this.zzb;
        zzegVar2.zza(iMin2);
        zzadbVar.zzl();
        zzadbVar.zzi(zzegVar2.zzi(), 0, iMin2);
        int iZzg2 = zzegVar2.zzg();
        int iZze2 = zzegVar2.zze();
        for (int i2 = iZze2 - 188; i2 >= iZzg2; i2--) {
            byte[] bArrZzi = zzegVar2.zzi();
            int i3 = 0;
            for (int i4 = -4; i4 <= 4; i4++) {
                int i5 = (i4 * 188) + i2;
                if (i5 >= iZzg2 && i5 < iZze2 && bArrZzi[i5] == 71) {
                    i3++;
                    if (i3 == 5) {
                        long jZzb2 = zzaog.zzb(zzegVar2, i2, i);
                        if (jZzb2 == -9223372036854775807L) {
                            break;
                        }
                        j = jZzb2;
                        break;
                    }
                } else {
                    i3 = 0;
                }
            }
        }
        this.zzg = j;
        this.zze = true;
        return 0;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzem zzd() {
        return this.zza;
    }
}
