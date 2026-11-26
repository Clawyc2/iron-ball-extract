package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaoq {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 0, Ascii.DLE, 0, -128, 0, 0, -86, 0, 56, -101, 113};
    private static final byte[] zzc = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean zza(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = new zzeg(8);
        int i = zzaop.zza(zzadbVar, zzegVar).zza;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        zzadbVar.zzi(zzegVar.zzi(), 0, 4);
        zzegVar.zzh(0);
        int iZzB = zzegVar.zzB();
        if (iZzB == 1463899717) {
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(iZzB).length() + 23);
        sb.append("Unsupported form type: ");
        sb.append(iZzB);
        zzdt.zze("WavHeaderReader", sb.toString());
        return false;
    }

    public static zzaoo zzb(zzadb zzadbVar) throws IOException {
        byte[] bArr;
        int i;
        byte[] bArr2;
        zzeg zzegVar = new zzeg(16);
        long j = zzd(1718449184, zzadbVar, zzegVar).zzb;
        zzgmd.zzh(j >= 16);
        zzadbVar.zzi(zzegVar.zzi(), 0, 16);
        zzegVar.zzh(0);
        int iZzu = zzegVar.zzu();
        int iZzu2 = zzegVar.zzu();
        int iZzI = zzegVar.zzI();
        int iZzI2 = zzegVar.zzI();
        int iZzu3 = zzegVar.zzu();
        int iZzu4 = zzegVar.zzu();
        int i2 = ((int) j) - 16;
        if (i2 > 0) {
            bArr = new byte[i2];
            zzadbVar.zzi(bArr, 0, i2);
            if (iZzu == 65534) {
                if (i2 == 24) {
                    zzeg zzegVar2 = new zzeg(bArr);
                    zzegVar2.zzu();
                    int iZzu5 = zzegVar2.zzu();
                    if (iZzu5 != 0 && iZzu5 != iZzu4) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzu5).length() + 33 + String.valueOf(iZzu4).length() + 19);
                        sb.append("validBits ( ");
                        sb.append(iZzu5);
                        sb.append(")  != bitsPerSample( ");
                        sb.append(iZzu4);
                        sb.append(") are not supported");
                        throw zzat.zzc(sb.toString());
                    }
                    int iZzI3 = zzegVar2.zzI();
                    if ((iZzI3 >> 18) != 0) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzI3).length() + 21);
                        sb2.append("invalid channel mask ");
                        sb2.append(iZzI3);
                        throw zzat.zzc(sb2.toString());
                    }
                    if (iZzI3 != 0 && Integer.bitCount(iZzI3) != iZzu2) {
                        int iBitCount = Integer.bitCount(iZzI3);
                        StringBuilder sb3 = new StringBuilder(String.valueOf(iBitCount).length() + 46 + String.valueOf(iZzI3).length());
                        sb3.append("invalid number of channels (");
                        sb3.append(iBitCount);
                        sb3.append(") in channel mask ");
                        sb3.append(iZzI3);
                        throw zzat.zzc(sb3.toString());
                    }
                    iZzu = zzegVar2.zzu();
                    byte[] bArr3 = new byte[14];
                    zzegVar2.zzm(bArr3, 0, 14);
                    if (!Arrays.equals(bArr3, zzb) && !Arrays.equals(bArr3, zzc)) {
                        throw zzat.zzc("invalid wav format extension guid");
                    }
                } else {
                    bArr2 = bArr;
                    i = 65534;
                }
            }
            zzadbVar.zzf((int) (zzadbVar.zzm() - zzadbVar.zzn()));
            return new zzaoo(i, iZzu2, iZzI, iZzI2, iZzu3, iZzu4, bArr2);
        }
        bArr = zzep.zzb;
        i = iZzu;
        bArr2 = bArr;
        zzadbVar.zzf((int) (zzadbVar.zzm() - zzadbVar.zzn()));
        return new zzaoo(i, iZzu2, iZzI, iZzI2, iZzu3, iZzu4, bArr2);
    }

    public static Pair zzc(zzadb zzadbVar) throws IOException {
        zzadbVar.zzl();
        zzaop zzaopVarZzd = zzd(1684108385, zzadbVar, new zzeg(8));
        zzadbVar.zzf(8);
        return Pair.create(Long.valueOf(zzadbVar.zzn()), Long.valueOf(zzaopVarZzd.zzb));
    }

    private static zzaop zzd(int i, zzadb zzadbVar, zzeg zzegVar) throws IOException {
        zzaop zzaopVarZza = zzaop.zza(zzadbVar, zzegVar);
        while (true) {
            int i2 = zzaopVarZza.zza;
            if (i2 == i) {
                return zzaopVarZza;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 28);
            sb.append("Ignoring unknown WAV chunk: ");
            sb.append(i2);
            zzdt.zzc("WavHeaderReader", sb.toString());
            long j = zzaopVarZza.zzb;
            long j2 = 8 + j;
            if ((1 & j) != 0) {
                j2 = 9 + j;
            }
            if (j2 > 2147483647L) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 40);
                sb2.append("Chunk is too large (~2GB+) to skip; id: ");
                sb2.append(i2);
                throw zzat.zzc(sb2.toString());
            }
            zzadbVar.zzf((int) j2);
            zzaopVarZza = zzaop.zza(zzadbVar, zzegVar);
        }
    }
}
