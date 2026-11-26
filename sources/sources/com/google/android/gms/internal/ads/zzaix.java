package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaix implements zzaed {
    private final long zza;
    private final zzaiy[] zzb;
    private final int zzc;

    public zzaix(long j, zzaiy[] zzaiyVarArr, int i) {
        this.zza = j;
        this.zzb = zzaiyVarArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:32:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0075 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int i;
        long jZzg;
        long jZzg2;
        zzaji zzajiVar;
        int iZzb;
        zzaiy[] zzaiyVarArr = this.zzb;
        if (zzaiyVarArr.length == 0) {
            zzaee zzaeeVar = zzaee.zza;
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        int i2 = this.zzc;
        if (i2 != -1) {
            zzaji zzajiVar2 = zzaiyVarArr[i2].zzb;
            int iZzk = zzaiz.zzk(zzajiVar2, j);
            if (iZzk == -1) {
                zzaee zzaeeVar2 = zzaee.zza;
                return new zzaeb(zzaeeVar2, zzaeeVar2);
            }
            long[] jArr = zzajiVar2.zzf;
            j3 = jArr[iZzk];
            long[] jArr2 = zzajiVar2.zzc;
            j2 = jArr2[iZzk];
            if (j3 < j && iZzk < zzajiVar2.zzb - 1 && (iZzb = zzajiVar2.zzb(j)) != -1 && iZzb != iZzk) {
                j4 = jArr[iZzb];
                j5 = jArr2[iZzb];
            }
            jZzg = j2;
            jZzg2 = j5;
            for (i = 0; i < zzaiyVarArr.length; i++) {
                if (i != i2) {
                    zzajiVar = zzaiyVarArr[i].zzb;
                    jZzg = zzaiz.zzg(zzajiVar, j3, jZzg);
                    if (j4 != -9223372036854775807L) {
                        jZzg2 = zzaiz.zzg(zzajiVar, j4, jZzg2);
                    }
                }
            }
            zzaee zzaeeVar3 = new zzaee(j3, jZzg);
            return j4 == -9223372036854775807L ? new zzaeb(zzaeeVar3, zzaeeVar3) : new zzaeb(zzaeeVar3, new zzaee(j4, jZzg2));
        }
        j2 = Long.MAX_VALUE;
        j3 = j;
        j4 = -9223372036854775807L;
        j5 = -1;
        jZzg = j2;
        jZzg2 = j5;
        while (i < zzaiyVarArr.length) {
            if (i != i2) {
                zzajiVar = zzaiyVarArr[i].zzb;
                jZzg = zzaiz.zzg(zzajiVar, j3, jZzg);
                if (j4 != -9223372036854775807L) {
                    jZzg2 = zzaiz.zzg(zzajiVar, j4, jZzg2);
                }
            }
        }
        zzaee zzaeeVar4 = new zzaee(j3, jZzg);
        if (j4 == -9223372036854775807L) {
        }
    }
}
