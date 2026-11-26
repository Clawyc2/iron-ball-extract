package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzanu implements zzacl {
    private final zzem zza;
    private final zzeg zzb = new zzeg();
    private final int zzc;

    public zzanu(int i, zzem zzemVar, int i2) {
        this.zzc = i;
        this.zza = zzemVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final zzack zza(zzadb zzadbVar, long j) throws IOException {
        int iZza;
        int iZza2;
        long jZzn = zzadbVar.zzn();
        int iMin = (int) Math.min(112800L, zzadbVar.zzo() - jZzn);
        zzeg zzegVar = this.zzb;
        zzegVar.zza(iMin);
        zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
        int iZze = zzegVar.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzegVar.zzd() >= 188 && (iZza2 = (iZza = zzaog.zza(zzegVar.zzi(), zzegVar.zzg(), iZze)) + 188) <= iZze) {
            long jZzb = zzaog.zzb(zzegVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZze = this.zza.zze(jZzb);
                if (jZze > j) {
                    return j3 == -9223372036854775807L ? zzack.zza(jZze, jZzn) : zzack.zzc(jZzn + j4);
                }
                j4 = iZza;
                if (100000 + jZze > j) {
                    return zzack.zzc(jZzn + j4);
                }
                j3 = jZze;
            }
            zzegVar.zzh(iZza2);
            j2 = iZza2;
        }
        return j3 != -9223372036854775807L ? zzack.zzb(j3, jZzn + j2) : zzack.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzacl
    public final void zzb() {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
    }
}
