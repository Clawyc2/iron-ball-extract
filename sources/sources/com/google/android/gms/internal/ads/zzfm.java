package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfm {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zzb(zzv zzvVar) {
        String str = zzvVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            return 1;
        }
        return (Objects.equals(str, "video/hevc") || zzas.zze(zzvVar.zzk, "video/hevc")) ? 2 : 0;
    }

    public static boolean zzc(byte[] bArr, int i, int i2, zzv zzvVar) {
        String str = zzvVar.zzo;
        if (Objects.equals(str, "video/avc")) {
            byte b = bArr[4];
            if (((b & 96) >> 5) != 0) {
                return true;
            }
            int i3 = b & Ascii.US;
            return (i3 == 1 || i3 == 9 || i3 == 14) ? false : true;
        }
        if (Objects.equals(str, "video/hevc")) {
            zzfa zzfaVarZzk = zzk(new zzfn(bArr, 4, i2 + 4));
            int i4 = zzfaVarZzk.zza;
            if (i4 == 35) {
                return false;
            }
            return (i4 <= 14 && i4 % 2 == 0 && zzfaVarZzk.zzc == zzvVar.zzF + (-1)) ? false : true;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:101:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:104:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:107:0x01da  */
    /* JADX WARN: Code duplicated, block: B:109:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:110:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:113:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:114:0x0205  */
    /* JADX WARN: Code duplicated, block: B:116:0x020b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0214  */
    /* JADX WARN: Code duplicated, block: B:122:0x0220  */
    /* JADX WARN: Code duplicated, block: B:125:0x022b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0234  */
    /* JADX WARN: Code duplicated, block: B:131:0x023b  */
    /* JADX WARN: Code duplicated, block: B:134:0x0247  */
    /* JADX WARN: Code duplicated, block: B:136:0x0268  */
    /* JADX WARN: Code duplicated, block: B:141:0x00aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0059  */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:27:0x0079  */
    /* JADX WARN: Code duplicated, block: B:30:0x007e  */
    /* JADX WARN: Code duplicated, block: B:32:0x0084  */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    /* JADX WARN: Code duplicated, block: B:35:0x008a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0093 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0095  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:58:0x010f  */
    /* JADX WARN: Code duplicated, block: B:61:0x0123  */
    /* JADX WARN: Code duplicated, block: B:63:0x0135  */
    /* JADX WARN: Code duplicated, block: B:64:0x0138 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x013a  */
    /* JADX WARN: Code duplicated, block: B:66:0x013d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0141  */
    /* JADX WARN: Code duplicated, block: B:69:0x0144  */
    /* JADX WARN: Code duplicated, block: B:84:0x016a A[PHI: r2
      0x016a: PHI (r2v4 int) = (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v3 int), (r2v7 int) binds: [B:73:0x0155, B:75:0x0159, B:77:0x015d, B:79:0x0161, B:81:0x0165, B:83:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x016e  */
    /* JADX WARN: Code duplicated, block: B:87:0x0170 A[PHI: r2
      0x0170: PHI (r2v6 int) = (r2v4 int), (r2v3 int) binds: [B:85:0x016c, B:82:0x0167] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x017c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0182  */
    /* JADX WARN: Code duplicated, block: B:94:0x018c  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a0  */
    public static zzfl zzd(byte[] bArr, int i, int i2) {
        int iZzg;
        int i3;
        boolean zZze;
        int i4;
        int iZzg2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iZzh;
        int i10;
        int i11;
        int iZzg3;
        boolean z;
        boolean zZze2;
        int i12;
        int i13;
        int i14;
        int iZzg4;
        float f;
        int i15;
        int i16;
        float f2;
        int i17;
        int i18;
        int iZzb;
        int iZzc;
        boolean zZze3;
        boolean zZze4;
        int i19;
        int iZzf;
        int iZzf2;
        int iZzf3;
        int i20;
        int i21;
        zzfn zzfnVar = new zzfn(bArr, i, i2);
        int iZzf4 = zzfnVar.zzf(8);
        int iZzf5 = zzfnVar.zzf(8);
        int iZzf6 = zzfnVar.zzf(8);
        int iZzg5 = zzfnVar.zzg();
        if (iZzf4 == 100 || iZzf4 == 110 || iZzf4 == 122 || iZzf4 == 244 || iZzf4 == 44 || iZzf4 == 83 || iZzf4 == 86 || iZzf4 == 118 || iZzf4 == 128) {
            iZzg = zzfnVar.zzg();
            if (iZzg == 3) {
                zZze = zzfnVar.zze();
                i3 = 3;
            } else {
                i3 = iZzg;
                zZze = false;
            }
            i4 = 16;
            int iZzg6 = zzfnVar.zzg();
            iZzg2 = zzfnVar.zzg();
            zzfnVar.zza();
            if (zzfnVar.zze()) {
                if (i3 != 3) {
                    i6 = 8;
                } else {
                    i6 = 12;
                }
                for (i7 = 0; i7 < i6; i7++) {
                    if (!zzfnVar.zze()) {
                        if (i7 < 6) {
                            i8 = 16;
                        } else {
                            i8 = 64;
                        }
                        iZzh = 8;
                        i10 = 8;
                        for (i9 = 0; i9 < i8; i9++) {
                            if (iZzh != 0) {
                                iZzh = ((i10 + zzfnVar.zzh()) + 256) % 256;
                            }
                            if (iZzh != 0) {
                                i10 = iZzh;
                            }
                        }
                    }
                }
            }
            i5 = iZzg6;
        } else if (iZzf4 == 138) {
            iZzf4 = 138;
            iZzg = zzfnVar.zzg();
            if (iZzg == 3) {
                zZze = zzfnVar.zze();
                i3 = 3;
            } else {
                i3 = iZzg;
                zZze = false;
            }
            i4 = 16;
            int iZzg7 = zzfnVar.zzg();
            iZzg2 = zzfnVar.zzg();
            zzfnVar.zza();
            if (zzfnVar.zze()) {
                if (i3 != 3) {
                    i6 = 8;
                } else {
                    i6 = 12;
                }
                while (i7 < i6) {
                    if (!zzfnVar.zze()) {
                        if (i7 < 6) {
                            i8 = 16;
                        } else {
                            i8 = 64;
                        }
                        iZzh = 8;
                        i10 = 8;
                        while (i9 < i8) {
                            if (iZzh != 0) {
                                iZzh = ((i10 + zzfnVar.zzh()) + 256) % 256;
                            }
                            if (iZzh != 0) {
                                i10 = iZzh;
                            }
                        }
                    }
                }
            }
            i5 = iZzg7;
        } else {
            iZzg = 1;
            i4 = 16;
            i5 = 0;
            zZze = false;
            iZzg2 = 0;
        }
        int iZzg8 = zzfnVar.zzg() + 4;
        int iZzg9 = zzfnVar.zzg();
        if (iZzg9 != 0) {
            if (iZzg9 == 1) {
                boolean zZze5 = zzfnVar.zze();
                zzfnVar.zzh();
                zzfnVar.zzh();
                long jZzg = zzfnVar.zzg();
                for (int i22 = 0; i22 < jZzg; i22++) {
                    zzfnVar.zzg();
                }
                z = zZze5;
                iZzg9 = 1;
                i11 = 244;
                iZzg3 = 0;
            } else {
                i11 = 244;
                iZzg3 = 0;
            }
            int iZzg10 = zzfnVar.zzg();
            zzfnVar.zza();
            int iZzg11 = zzfnVar.zzg() + 1;
            int iZzg12 = zzfnVar.zzg() + 1;
            zZze2 = zzfnVar.zze();
            i12 = 2 - (zZze2 ? 1 : 0);
            if (!zZze2) {
                zzfnVar.zza();
            }
            zzfnVar.zza();
            i13 = iZzg11 * 16;
            i14 = iZzg12 * i12 * 16;
            if (zzfnVar.zze()) {
                int iZzg13 = zzfnVar.zzg();
                int iZzg14 = zzfnVar.zzg();
                int iZzg15 = zzfnVar.zzg();
                int iZzg16 = zzfnVar.zzg();
                if (iZzg == 0) {
                    i20 = 1;
                } else {
                    if (iZzg == 3) {
                        i20 = 1;
                    } else {
                        i20 = 2;
                    }
                    if (iZzg == 1) {
                        i21 = 2;
                    } else {
                        i21 = 1;
                    }
                    i12 *= i21;
                }
                i13 -= (iZzg13 + iZzg14) * i20;
                i14 -= (iZzg15 + iZzg16) * i12;
            }
            if (iZzf4 != 44 || iZzf4 == 86 || iZzf4 == 100 || iZzf4 == 110 || iZzf4 == 122) {
                if ((iZzf5 & 16) != 0) {
                    iZzg4 = 0;
                } else {
                    iZzg4 = i4;
                }
            } else if (iZzf4 == i11) {
                iZzf4 = i11;
                if ((iZzf5 & 16) != 0) {
                    iZzg4 = 0;
                } else {
                    iZzg4 = i4;
                }
            } else {
                iZzg4 = i4;
            }
            f = 1.0f;
            i15 = -1;
            if (zzfnVar.zze()) {
                if (zzfnVar.zze()) {
                    iZzf = zzfnVar.zzf(8);
                    if (iZzf == 255) {
                        int i23 = i4;
                        iZzf2 = zzfnVar.zzf(i23);
                        iZzf3 = zzfnVar.zzf(i23);
                        if (iZzf2 != 0 && iZzf3 != 0) {
                            f = iZzf2 / iZzf3;
                        }
                    } else if (iZzf < 17) {
                        f = zzb[iZzf];
                    } else {
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzf).length() + 35);
                        sb.append("Unexpected aspect_ratio_idc value: ");
                        sb.append(iZzf);
                        zzdt.zzc("NalUnitUtil", sb.toString());
                    }
                }
                if (zzfnVar.zze()) {
                    zzfnVar.zza();
                }
                if (zzfnVar.zze()) {
                    zzfnVar.zzb(3);
                    if (true != zzfnVar.zze()) {
                        i19 = 2;
                    } else {
                        i19 = 1;
                    }
                    if (zzfnVar.zze()) {
                        int iZzf7 = zzfnVar.zzf(8);
                        int iZzf8 = zzfnVar.zzf(8);
                        zzfnVar.zzb(8);
                        iZzb = zzi.zzb(iZzf7);
                        iZzc = zzi.zzc(iZzf8);
                    } else {
                        iZzb = -1;
                        iZzc = -1;
                    }
                    i15 = i19;
                } else {
                    iZzb = -1;
                    iZzc = -1;
                }
                if (zzfnVar.zze()) {
                    zzfnVar.zzg();
                    zzfnVar.zzg();
                }
                if (zzfnVar.zze()) {
                    zzfnVar.zzb(65);
                }
                zZze3 = zzfnVar.zze();
                if (zZze3) {
                    zzo(zzfnVar);
                }
                zZze4 = zzfnVar.zze();
                if (zZze4) {
                    zzo(zzfnVar);
                }
                if (zZze3 || zZze4) {
                    zzfnVar.zza();
                }
                zzfnVar.zza();
                if (zzfnVar.zze()) {
                    zzfnVar.zza();
                    zzfnVar.zzg();
                    zzfnVar.zzg();
                    zzfnVar.zzg();
                    zzfnVar.zzg();
                    iZzg4 = zzfnVar.zzg();
                    zzfnVar.zzg();
                }
                i18 = iZzc;
                i16 = iZzg4;
                f2 = f;
                i17 = i15;
                i15 = iZzb;
            } else {
                i16 = iZzg4;
                f2 = 1.0f;
                i17 = -1;
                i18 = -1;
            }
            return new zzfl(iZzf4, iZzf5, iZzf6, iZzg5, iZzg10, i13, i14, f2, i5, iZzg2, zZze, zZze2, iZzg8, iZzg9, iZzg3, z, i15, i17, i18, i16);
        }
        iZzg3 = zzfnVar.zzg() + 4;
        i11 = 244;
        z = false;
        int iZzg17 = zzfnVar.zzg();
        zzfnVar.zza();
        int iZzg18 = zzfnVar.zzg() + 1;
        int iZzg19 = zzfnVar.zzg() + 1;
        zZze2 = zzfnVar.zze();
        i12 = 2 - (zZze2 ? 1 : 0);
        if (!zZze2) {
            zzfnVar.zza();
        }
        zzfnVar.zza();
        i13 = iZzg18 * 16;
        i14 = iZzg19 * i12 * 16;
        if (zzfnVar.zze()) {
            int iZzg110 = zzfnVar.zzg();
            int iZzg111 = zzfnVar.zzg();
            int iZzg112 = zzfnVar.zzg();
            int iZzg113 = zzfnVar.zzg();
            if (iZzg == 0) {
                i20 = 1;
            } else {
                if (iZzg == 3) {
                    i20 = 1;
                } else {
                    i20 = 2;
                }
                if (iZzg == 1) {
                    i21 = 2;
                } else {
                    i21 = 1;
                }
                i12 *= i21;
            }
            i13 -= (iZzg110 + iZzg111) * i20;
            i14 -= (iZzg112 + iZzg113) * i12;
        }
        if (iZzf4 != 44) {
            if ((iZzf5 & 16) != 0) {
                iZzg4 = 0;
            } else {
                iZzg4 = i4;
            }
        } else if ((iZzf5 & 16) != 0) {
            iZzg4 = 0;
        } else {
            iZzg4 = i4;
        }
        f = 1.0f;
        i15 = -1;
        if (zzfnVar.zze()) {
            if (zzfnVar.zze()) {
                iZzf = zzfnVar.zzf(8);
                if (iZzf == 255) {
                    int i24 = i4;
                    iZzf2 = zzfnVar.zzf(i24);
                    iZzf3 = zzfnVar.zzf(i24);
                    if (iZzf2 != 0) {
                        f = iZzf2 / iZzf3;
                    }
                } else if (iZzf < 17) {
                    f = zzb[iZzf];
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzf).length() + 35);
                    sb2.append("Unexpected aspect_ratio_idc value: ");
                    sb2.append(iZzf);
                    zzdt.zzc("NalUnitUtil", sb2.toString());
                }
            }
            if (zzfnVar.zze()) {
                zzfnVar.zza();
            }
            if (zzfnVar.zze()) {
                zzfnVar.zzb(3);
                if (true != zzfnVar.zze()) {
                    i19 = 2;
                } else {
                    i19 = 1;
                }
                if (zzfnVar.zze()) {
                    int iZzf9 = zzfnVar.zzf(8);
                    int iZzf10 = zzfnVar.zzf(8);
                    zzfnVar.zzb(8);
                    iZzb = zzi.zzb(iZzf9);
                    iZzc = zzi.zzc(iZzf10);
                } else {
                    iZzb = -1;
                    iZzc = -1;
                }
                i15 = i19;
            } else {
                iZzb = -1;
                iZzc = -1;
            }
            if (zzfnVar.zze()) {
                zzfnVar.zzg();
                zzfnVar.zzg();
            }
            if (zzfnVar.zze()) {
                zzfnVar.zzb(65);
            }
            zZze3 = zzfnVar.zze();
            if (zZze3) {
                zzo(zzfnVar);
            }
            zZze4 = zzfnVar.zze();
            if (zZze4) {
                zzo(zzfnVar);
            }
            if (zZze3) {
                zzfnVar.zza();
            } else {
                zzfnVar.zza();
            }
            zzfnVar.zza();
            if (zzfnVar.zze()) {
                zzfnVar.zza();
                zzfnVar.zzg();
                zzfnVar.zzg();
                zzfnVar.zzg();
                zzfnVar.zzg();
                iZzg4 = zzfnVar.zzg();
                zzfnVar.zzg();
            }
            i18 = iZzc;
            i16 = iZzg4;
            f2 = f;
            i17 = i15;
            i15 = iZzb;
        } else {
            i16 = iZzg4;
            f2 = 1.0f;
            i17 = -1;
            i18 = -1;
        }
        return new zzfl(iZzf4, iZzf5, iZzf6, iZzg5, iZzg17, i13, i14, f2, i5, iZzg2, zZze, zZze2, iZzg8, iZzg9, iZzg3, z, i15, i17, i18, i16);
    }

    /* JADX WARN: Code duplicated, block: B:453:0x014e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x0110  */
    /* JADX WARN: Code duplicated, block: B:65:0x0127  */
    /* JADX WARN: Code duplicated, block: B:69:0x013b  */
    /* JADX WARN: Code duplicated, block: B:71:0x0140  */
    /* JADX WARN: Code duplicated, block: B:73:0x0148  */
    /* JADX WARN: Multi-variable type inference failed */
    public static zzfj zze(byte[] bArr, int i, int i2) {
        int i3;
        zzfi zzfiVar;
        boolean z;
        int iZzf;
        int iZzf2;
        int iZzf3;
        int iZzf4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int[] iArr;
        int[] iArr2;
        int i9;
        int i10;
        boolean zZze;
        int i11;
        int i12;
        int i13;
        int iZzg;
        int i14;
        int i15;
        int i16;
        boolean z2;
        boolean z3;
        zzfn zzfnVar = new zzfn(bArr, i, i2);
        zzfa zzfaVarZzk = zzk(zzfnVar);
        zzfnVar.zzb(4);
        boolean zZze2 = zzfnVar.zze();
        boolean zZze3 = zzfnVar.zze();
        int iZzf5 = zzfnVar.zzf(6);
        int i17 = iZzf5 + 1;
        int iZzf6 = zzfnVar.zzf(3);
        zzfnVar.zzb(17);
        zzfb zzfbVarZzl = zzl(zzfnVar, true, iZzf6, null);
        int i18 = 0;
        for (int i19 = true != zzfnVar.zze() ? iZzf6 : 0; i19 <= iZzf6; i19++) {
            zzfnVar.zzg();
            zzfnVar.zzg();
            zzfnVar.zzg();
        }
        int iZzf7 = zzfnVar.zzf(6);
        int iZzg2 = zzfnVar.zzg() + 1;
        int i20 = 6;
        zzfc zzfcVar = new zzfc(zzgpe.zzj(zzfbVarZzl), new int[1]);
        boolean z4 = i17 >= 2 && iZzg2 >= 2;
        boolean z5 = zZze2 && zZze3;
        int i21 = 1;
        int i22 = iZzf7 + 1;
        if (!z4 || !z5 || i22 < i17) {
            return new zzfj(zzfaVarZzk, null, zzfcVar, null, null);
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iZzg2, i22);
        int[] iArr4 = new int[iZzg2];
        int[] iArr5 = new int[iZzg2];
        iArr3[0][0] = 0;
        iArr4[0] = 1;
        iArr5[0] = 0;
        int i23 = 1;
        while (i23 < iZzg2) {
            int i24 = i18;
            while (i18 <= iZzf7) {
                if (zzfnVar.zze()) {
                    iArr3[i23][i24] = i18;
                    iArr5[i23] = i18;
                    i24++;
                }
                iArr4[i23] = i24;
                i18++;
            }
            i23++;
            i18 = 0;
        }
        if (zzfnVar.zze()) {
            zzfnVar.zzb(64);
            if (zzfnVar.zze()) {
                zzfnVar.zzg();
            }
            int iZzg3 = zzfnVar.zzg();
            int i25 = 0;
            while (i25 < iZzg3) {
                zzfnVar.zzg();
                if (i25 == 0 || zzfnVar.zze()) {
                    boolean zZze4 = zzfnVar.zze();
                    boolean zZze5 = zzfnVar.zze();
                    z3 = zZze4;
                    z2 = zZze5;
                    if (zZze4 || zZze5) {
                        zZze = zzfnVar.zze();
                        if (zZze) {
                            zzfnVar.zzb(19);
                        }
                        zzfnVar.zzb(8);
                        if (zZze) {
                            zzfnVar.zzb(4);
                        }
                        zzfnVar.zzb(15);
                        i12 = zZze4;
                        i11 = zZze5;
                    }
                    i13 = 0;
                    while (i13 <= iZzf6) {
                        if (!zzfnVar.zze() || zzfnVar.zze()) {
                            zzfnVar.zzg();
                        } else {
                            if (zzfnVar.zze()) {
                                iZzg = 0;
                            }
                            zzfa zzfaVar = zzfaVarZzk;
                            i14 = i12 + i11;
                            int[][] iArr6 = iArr3;
                            i15 = 0;
                            while (i15 < i14) {
                                int i26 = i14;
                                for (i16 = 0; i16 <= iZzg; i16++) {
                                    zzfnVar.zzg();
                                    zzfnVar.zzg();
                                    if (zZze) {
                                        zzfnVar.zzg();
                                        zzfnVar.zzg();
                                    }
                                    zzfnVar.zza();
                                }
                                i15++;
                                i14 = i26;
                            }
                            i13++;
                            zzfaVarZzk = zzfaVar;
                            i25 = i25;
                            iArr3 = iArr6;
                        }
                        iZzg = zzfnVar.zzg();
                        zzfa zzfaVar2 = zzfaVarZzk;
                        i14 = i12 + i11;
                        int[][] iArr7 = iArr3;
                        i15 = 0;
                        while (i15 < i14) {
                            int i27 = i14;
                            while (i16 <= iZzg) {
                                zzfnVar.zzg();
                                zzfnVar.zzg();
                                if (zZze) {
                                    zzfnVar.zzg();
                                    zzfnVar.zzg();
                                }
                                zzfnVar.zza();
                            }
                            i15++;
                            i14 = i27;
                        }
                        i13++;
                        zzfaVarZzk = zzfaVar2;
                        i25 = i25;
                        iArr3 = iArr7;
                    }
                    i25++;
                } else {
                    z3 = false;
                    z2 = false;
                }
                zZze = false;
                i12 = z3;
                i11 = z2;
                i13 = 0;
                while (i13 <= iZzf6) {
                    if (zzfnVar.zze()) {
                        zzfnVar.zzg();
                        iZzg = zzfnVar.zzg();
                    } else {
                        zzfnVar.zzg();
                        iZzg = zzfnVar.zzg();
                    }
                    zzfa zzfaVar3 = zzfaVarZzk;
                    i14 = i12 + i11;
                    int[][] iArr8 = iArr3;
                    i15 = 0;
                    while (i15 < i14) {
                        int i28 = i14;
                        while (i16 <= iZzg) {
                            zzfnVar.zzg();
                            zzfnVar.zzg();
                            if (zZze) {
                                zzfnVar.zzg();
                                zzfnVar.zzg();
                            }
                            zzfnVar.zza();
                        }
                        i15++;
                        i14 = i28;
                    }
                    i13++;
                    zzfaVarZzk = zzfaVar3;
                    i25 = i25;
                    iArr3 = iArr8;
                }
                i25++;
            }
        }
        zzfa zzfaVar4 = zzfaVarZzk;
        int[][] iArr9 = iArr3;
        if (!zzfnVar.zze()) {
            return new zzfj(zzfaVar4, null, zzfcVar, null, null);
        }
        zzfnVar.zzc();
        zzfb zzfbVarZzl2 = zzl(zzfnVar, false, iZzf6, zzfbVarZzl);
        boolean zZze6 = zzfnVar.zze();
        boolean[] zArr = new boolean[16];
        int i29 = 0;
        for (int i30 = 0; i30 < 16; i30++) {
            boolean zZze7 = zzfnVar.zze();
            zArr[i30] = zZze7;
            if (zZze7) {
                i29++;
            }
        }
        if (i29 == 0 || !zArr[1]) {
            return new zzfj(zzfaVar4, null, zzfcVar, null, null);
        }
        int i31 = i29 + 1;
        int[] iArr10 = new int[i29];
        for (int i32 = 0; i32 < i29 - (zZze6 ? 1 : 0); i32++) {
            iArr10[i32] = zzfnVar.zzf(3);
        }
        int[] iArr11 = new int[i31];
        if (zZze6) {
            for (int i33 = 1; i33 < i29; i33++) {
                for (int i34 = 0; i34 < i33; i34++) {
                    iArr11[i33] = iArr11[i33] + iArr10[i34] + 1;
                }
            }
            iArr11[i29] = 6;
        }
        int[][] iArr12 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i17, i29);
        int[] iArr13 = new int[i17];
        iArr13[0] = 0;
        boolean zZze8 = zzfnVar.zze();
        int i35 = 1;
        while (i35 < i17) {
            if (zZze8) {
                iArr13[i35] = zzfnVar.zzf(i20);
            } else {
                iArr13[i35] = i35;
            }
            if (zZze6) {
                i10 = i35;
                int i36 = 0;
                while (i36 < i29) {
                    int i37 = i36 + 1;
                    iArr12[i10][i36] = (iArr13[i10] & ((1 << iArr11[i37]) - 1)) >> iArr11[i36];
                    i36 = i37;
                }
            } else {
                int i38 = 0;
                while (i38 < i29) {
                    iArr12[i35][i38] = zzfnVar.zzf(iArr10[i38] + 1);
                    i38++;
                    i35 = i35;
                }
                i10 = i35;
            }
            i35 = i10 + 1;
            i20 = 6;
        }
        int[] iArr14 = new int[i22];
        int i39 = 1;
        int i40 = 0;
        while (i40 < i17) {
            iArr14[iArr13[i40]] = -1;
            int[] iArr15 = iArr14;
            int i41 = 0;
            int i42 = 0;
            while (i41 < 16) {
                if (zArr[i41]) {
                    i9 = i21;
                    if (i41 == i9) {
                        iArr15[iArr13[i40]] = iArr12[i40][i42];
                        i41 = i9;
                    }
                    i42++;
                } else {
                    i9 = i21;
                }
                i41 += i9;
                i21 = i9;
            }
            if (i40 > 0) {
                int i43 = 0;
                while (true) {
                    if (i43 >= i40) {
                        i39++;
                        break;
                    }
                    int i44 = i43;
                    if (iArr15[iArr13[i40]] == iArr15[iArr13[i43]]) {
                        break;
                    }
                    i43 = i44 + 1;
                }
            }
            i40++;
            iArr14 = iArr15;
            i21 = 1;
        }
        int[] iArr16 = iArr14;
        int iZzf8 = zzfnVar.zzf(4);
        if (i39 < 2 || iZzf8 == 0) {
            return new zzfj(zzfaVar4, null, zzfcVar, null, null);
        }
        int[] iArr17 = new int[i39];
        for (int i45 = 0; i45 < i39; i45++) {
            iArr17[i45] = zzfnVar.zzf(iZzf8);
        }
        int[] iArr18 = new int[i22];
        for (int i46 = 0; i46 < i17; i46++) {
            iArr18[Math.min(iArr13[i46], iZzf7)] = i46;
        }
        zzgpb zzgpbVar = new zzgpb();
        int i47 = 0;
        while (i47 <= iZzf7) {
            int[] iArr19 = iArr17;
            int i48 = i39;
            int iMin = Math.min(iArr16[i47], i48 - 1);
            int[] iArr20 = iArr18;
            zzgpbVar.zzf(new zzez(iArr20[i47], iMin >= 0 ? iArr19[iMin] : -1));
            i47++;
            i39 = i48;
            iArr17 = iArr19;
            iArr18 = iArr20;
        }
        zzgpe zzgpeVarZzi = zzgpbVar.zzi();
        if (((zzez) zzgpeVarZzi.get(0)).zzb == -1) {
            return new zzfj(zzfaVar4, null, zzfcVar, null, null);
        }
        zzfc zzfcVar2 = zzfcVar;
        int i49 = 1;
        while (true) {
            zzfa zzfaVar5 = zzfaVar4;
            if (i49 > iZzf7) {
                zzfaVar4 = zzfaVar5;
                i3 = -1;
                i49 = -1;
                break;
            }
            zzfaVar4 = zzfaVar5;
            i3 = -1;
            if (((zzez) zzgpeVarZzi.get(i49)).zzb != -1) {
                break;
            }
            i49++;
        }
        if (i49 == i3) {
            return new zzfj(zzfaVar4, null, zzfcVar2, null, null);
        }
        boolean[][] zArr2 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i17, i17);
        boolean[][] zArr3 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i17, i17);
        int i50 = 1;
        while (i50 < i17) {
            boolean[][] zArr4 = zArr3;
            for (int i51 = 0; i51 < i50; i51++) {
                boolean[] zArr5 = zArr2[i50];
                boolean[] zArr6 = zArr4[i50];
                boolean zZze9 = zzfnVar.zze();
                zArr6[i51] = zZze9;
                zArr5[i51] = zZze9;
            }
            i50++;
            zArr3 = zArr4;
        }
        boolean[][] zArr7 = zArr3;
        for (int i52 = 1; i52 < i17; i52++) {
            int i53 = 0;
            while (i53 < iZzf5) {
                zzfc zzfcVar3 = zzfcVar2;
                for (int i54 = 0; i54 < i52; i54++) {
                    boolean[] zArr8 = zArr7[i52];
                    if (zArr8[i54] && zArr7[i54][i53]) {
                        zArr8[i53] = true;
                        break;
                    }
                }
                i53++;
                zzfcVar2 = zzfcVar3;
            }
        }
        zzfc zzfcVar4 = zzfcVar2;
        int[] iArr21 = new int[i22];
        for (int i55 = 0; i55 < i17; i55++) {
            int i56 = 0;
            for (int i57 = 0; i57 < i55; i57++) {
                i56 += zArr2[i55][i57] ? 1 : 0;
            }
            iArr21[iArr13[i55]] = i56;
        }
        int i58 = 0;
        for (int i59 = 0; i59 < i17; i59++) {
            if (iArr21[iArr13[i59]] == 0) {
                i58++;
            }
        }
        if (i58 > 1) {
            return new zzfj(zzfaVar4, null, zzfcVar4, null, null);
        }
        zzfc zzfcVar5 = zzfcVar4;
        int[] iArr22 = new int[i17];
        int[] iArr23 = new int[iZzg2];
        if (zzfnVar.zze()) {
            int i60 = 0;
            while (i60 < i17) {
                int i61 = i60;
                iArr22[i61] = zzfnVar.zzf(3);
                i60 = i61 + 1;
            }
        } else {
            Arrays.fill(iArr22, 0, i17, iZzf6);
        }
        int i62 = 0;
        while (i62 < iZzg2) {
            int i63 = i62;
            zzfc zzfcVar6 = zzfcVar5;
            int[] iArr24 = iArr13;
            int iMax = 0;
            for (int i64 = 0; i64 < iArr4[i63]; i64++) {
                iMax = Math.max(iMax, iArr22[((zzez) zzgpeVarZzi.get(iArr9[i63][i64])).zza]);
            }
            iArr23[i63] = iMax + 1;
            i62 = i63 + 1;
            zzfcVar5 = zzfcVar6;
            iArr13 = iArr24;
        }
        zzfc zzfcVar7 = zzfcVar5;
        int[] iArr25 = iArr13;
        if (zzfnVar.zze()) {
            int i65 = 0;
            while (i65 < iZzf5) {
                int i66 = i65 + 1;
                for (int i67 = i66; i67 < i17; i67++) {
                    if (zArr2[i67][i65]) {
                        zzfnVar.zzb(3);
                    }
                }
                i65 = i66;
            }
        }
        zzfnVar.zza();
        int iZzg4 = zzfnVar.zzg() + 1;
        zzgpb zzgpbVar2 = new zzgpb();
        zzgpbVar2.zzf(zzfbVarZzl);
        if (iZzg4 > 1) {
            zzgpbVar2.zzf(zzfbVarZzl2);
            for (int i68 = 2; i68 < iZzg4; i68++) {
                zzfbVarZzl2 = zzl(zzfnVar, zzfnVar.zze(), iZzf6, zzfbVarZzl2);
                zzgpbVar2.zzf(zzfbVarZzl2);
            }
        }
        zzgpe zzgpeVarZzi2 = zzgpbVar2.zzi();
        int iZzg5 = zzfnVar.zzg() + iZzg2;
        if (iZzg5 > iZzg2) {
            return new zzfj(zzfaVar4, null, zzfcVar7, null, null);
        }
        int iZzf9 = zzfnVar.zzf(2);
        int i69 = 0;
        boolean[][] zArr9 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iZzg5, i22);
        int[] iArr26 = new int[iZzg5];
        int[] iArr27 = new int[iZzg5];
        int i70 = 0;
        while (i69 < iZzg2) {
            iArr26[i69] = i70;
            boolean[][] zArr10 = zArr9;
            int i71 = iArr5[i69];
            iArr27[i69] = i71;
            if (iZzf9 == 0) {
                i8 = i69;
                iArr = iArr4;
                iArr2 = iArr26;
                Arrays.fill(zArr10[i69], i70, iArr4[i8], true);
                iArr2[i8] = iArr[i8];
            } else {
                i8 = i69;
                iArr = iArr4;
                iArr2 = iArr26;
                if (iZzf9 == 1) {
                    for (int i72 = 0; i72 < iArr[i8]; i72++) {
                        zArr10[i8][i72] = iArr9[i8][i72] == i71;
                    }
                    iArr2[i8] = 1;
                } else {
                    i70 = 0;
                    zArr10[0][0] = true;
                    iArr2[0] = 1;
                }
                i69 = i8 + 1;
                zArr9 = zArr10;
                iArr4 = iArr;
                iArr26 = iArr2;
            }
            i70 = 0;
            i69 = i8 + 1;
            zArr9 = zArr10;
            iArr4 = iArr;
            iArr26 = iArr2;
        }
        boolean[][] zArr11 = zArr9;
        int[] iArr28 = iArr4;
        int[] iArr29 = iArr26;
        int[] iArr30 = new int[i22];
        int i73 = 2;
        int[] iArr31 = new int[2];
        iArr31[1] = i22;
        iArr31[i70] = iZzg5;
        boolean[][] zArr12 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iArr31);
        int i74 = 1;
        int i75 = 0;
        while (i74 < iZzg5) {
            int i76 = iZzf9;
            if (iZzf9 == i73) {
                for (int i77 = 0; i77 < iArr28[i74]; i77++) {
                    zArr11[i74][i77] = zzfnVar.zze();
                    int i78 = iArr29[i74];
                    boolean z6 = zArr11[i74][i77];
                    iArr29[i74] = i78 + (z6 ? 1 : 0);
                    if (z6) {
                        iArr27[i74] = iArr9[i74][i77];
                    }
                }
            }
            if (i75 == 0) {
                i4 = 0;
                if (iArr9[i74][0] == 0 && zArr11[i74][0]) {
                    int i79 = 0;
                    for (int i80 = 1; i80 < iArr28[i74]; i80++) {
                        if (iArr9[i74][i80] == i49 && zArr11[i74][i49]) {
                            i79 = i74;
                        }
                    }
                    i75 = i79;
                } else {
                    i75 = 0;
                }
            } else {
                i4 = 0;
            }
            int i81 = i4;
            while (i81 < iArr28[i74]) {
                if (iZzg4 > 1) {
                    zArr12[i74][i81] = zArr11[i74][i81];
                    i7 = i49;
                    i5 = iZzg4;
                    int iZzc = zzgsj.zzc(iZzg4, RoundingMode.CEILING);
                    if (zArr12[i74][i81]) {
                        i6 = i81;
                        break;
                    }
                    int i82 = ((zzez) zzgpeVarZzi.get(iArr9[i74][i81])).zza;
                    int i83 = i4;
                    while (true) {
                        if (i83 >= i81) {
                            i6 = i81;
                            break;
                        }
                        i6 = i81;
                        if (zArr7[i82][((zzez) zzgpeVarZzi.get(iArr9[i74][i83])).zza]) {
                            zArr12[i74][i6] = true;
                            break;
                        }
                        i83++;
                        i81 = i6;
                    }
                    if (zArr12[i74][i6]) {
                        if (i75 <= 0 || i74 != i75) {
                            zzfnVar.zzb(iZzc);
                        } else {
                            iArr30[i6] = zzfnVar.zzf(iZzc);
                        }
                    }
                } else {
                    i5 = iZzg4;
                    i6 = i81;
                    i7 = i49;
                }
                i81 = i6 + 1;
                i49 = i7;
                iZzg4 = i5;
            }
            int i84 = iZzg4;
            int i85 = i49;
            if (iArr29[i74] == 1 && iArr21[iArr27[i74]] > 0) {
                zzfnVar.zza();
            }
            i74++;
            iZzf9 = i76;
            i49 = i85;
            iZzg4 = i84;
            i73 = 2;
        }
        if (i75 == 0) {
            return new zzfj(zzfaVar4, null, zzfcVar7, null, null);
        }
        zzfa zzfaVar6 = zzfaVar4;
        int iZzg6 = zzfnVar.zzg();
        int i86 = iZzg6 + 1;
        zzgpb zzgpbVarZzv = zzgpe.zzv(i86);
        int[] iArr32 = new int[i17];
        int i87 = 0;
        while (i87 < i86) {
            zzgpe zzgpeVar = zzgpeVarZzi;
            int iZzf10 = zzfnVar.zzf(16);
            zzfa zzfaVar7 = zzfaVar6;
            int iZzf11 = zzfnVar.zzf(16);
            if (zzfnVar.zze()) {
                iZzf2 = zzfnVar.zzf(2);
                if (iZzf2 == 3) {
                    zzfnVar.zza();
                }
                iZzf3 = zzfnVar.zzf(4);
                iZzf4 = zzfnVar.zzf(4);
            } else {
                iZzf2 = 0;
                iZzf3 = 0;
                iZzf4 = 0;
            }
            if (zzfnVar.zze()) {
                int iZzg7 = zzfnVar.zzg();
                int iZzg8 = zzfnVar.zzg();
                int iZzg9 = zzfnVar.zzg();
                int iZzg10 = zzfnVar.zzg();
                iZzf10 = zzm(iZzf10, iZzf2, iZzg7, iZzg8);
                iZzf11 = zzn(iZzf11, iZzf2, iZzg9, iZzg10);
            }
            zzgpbVarZzv.zzf(new zzfd(iZzf2, iZzf3, iZzf4, iZzf10, iZzf11));
            i87++;
            zzgpeVarZzi = zzgpeVar;
            zzfaVar6 = zzfaVar7;
            zArr12 = zArr12;
            zArr2 = zArr2;
            zzgpeVarZzi2 = zzgpeVarZzi2;
        }
        zzgpe zzgpeVar2 = zzgpeVarZzi;
        zzfa zzfaVar8 = zzfaVar6;
        zzgpe zzgpeVar3 = zzgpeVarZzi2;
        boolean[][] zArr13 = zArr12;
        boolean[][] zArr14 = zArr2;
        if (i86 <= 1 || !zzfnVar.zze()) {
            for (int i88 = 1; i88 < i17; i88++) {
                iArr32[i88] = Math.min(i88, iZzg6);
            }
        } else {
            int iZzc2 = zzgsj.zzc(i86, RoundingMode.CEILING);
            for (int i89 = 1; i89 < i17; i89++) {
                iArr32[i89] = zzfnVar.zzf(iZzc2);
            }
        }
        zzfe zzfeVar = new zzfe(zzgpbVarZzv.zzi(), iArr32);
        zzfnVar.zzb(2);
        for (int i90 = 1; i90 < i17; i90++) {
            if (iArr21[iArr25[i90]] == 0) {
                zzfnVar.zza();
            }
        }
        for (int i91 = 1; i91 < iZzg5; i91++) {
            boolean zZze10 = zzfnVar.zze();
            int i92 = 0;
            while (i92 < iArr23[i91]) {
                if ((i92 <= 0 || !zZze10) ? i92 == 0 : zzfnVar.zze()) {
                    for (int i93 = 0; i93 < iArr28[i91]; i93++) {
                        if (zArr13[i91][i93]) {
                            zzfnVar.zzg();
                        }
                    }
                    zzfnVar.zzg();
                    zzfnVar.zzg();
                }
                i92++;
            }
        }
        int iZzg11 = zzfnVar.zzg() + 2;
        if (zzfnVar.zze()) {
            zzfnVar.zzb(iZzg11);
        } else {
            for (int i94 = 1; i94 < i17; i94++) {
                for (int i95 = 0; i95 < i94; i95++) {
                    if (zArr14[i94][i95]) {
                        zzfnVar.zzb(iZzg11);
                    }
                }
            }
        }
        int iZzg12 = zzfnVar.zzg();
        for (int i96 = 1; i96 <= iZzg12; i96++) {
            zzfnVar.zzb(8);
        }
        if (zzfnVar.zze()) {
            zzfnVar.zzc();
            if (zzfnVar.zze() || zzfnVar.zze()) {
                zzfnVar.zza();
            }
            boolean zZze11 = zzfnVar.zze();
            boolean zZze12 = zzfnVar.zze();
            if (zZze11 || zZze12) {
                for (int i97 = 0; i97 < iZzg2; i97++) {
                    for (int i98 = 0; i98 < iArr23[i97]; i98++) {
                        boolean zZze13 = zZze11 ? zzfnVar.zze() : false;
                        boolean zZze14 = zZze12 ? zzfnVar.zze() : false;
                        if (zZze13) {
                            zzfnVar.zzb(32);
                        }
                        if (zZze14) {
                            zzfnVar.zzb(18);
                        }
                    }
                }
            }
            boolean zZze15 = zzfnVar.zze();
            if (zZze15) {
                z = true;
                iZzf = zzfnVar.zzf(4) + 1;
            } else {
                z = true;
                iZzf = i17;
            }
            zzgpb zzgpbVarZzv2 = zzgpe.zzv(iZzf);
            int[] iArr33 = new int[i17];
            int i99 = 0;
            while (i99 < iZzf) {
                zzfnVar.zzb(3);
                int i100 = z != zzfnVar.zze() ? 2 : 1;
                int iZzb = zzi.zzb(zzfnVar.zzf(8));
                int iZzc3 = zzi.zzc(zzfnVar.zzf(8));
                zzfnVar.zzb(8);
                zzgpbVarZzv2.zzf(new zzfh(iZzb, i100, iZzc3));
                i99++;
                z = true;
            }
            if (zZze15 && iZzf > 1) {
                for (int i101 = 0; i101 < i17; i101++) {
                    iArr33[i101] = zzfnVar.zzf(4);
                }
            }
            zzfiVar = new zzfi(zzgpbVarZzv2.zzi(), iArr33);
        } else {
            zzfiVar = null;
        }
        return new zzfj(zzfaVar8, zzgpeVar2, new zzfc(zzgpeVar3, iArr30), zzfeVar, zzfiVar);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004a  */
    /* JADX WARN: Code duplicated, block: B:194:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ac  */
    public static zzfg zzf(byte[] bArr, int i, int i2, zzfj zzfjVar) {
        boolean z;
        int i3;
        int i4;
        int iZzn;
        int iZzm;
        int iZzg;
        int i5;
        int i6;
        int i7;
        int i8;
        int iZzg2;
        int i9;
        int iMax;
        float f;
        int i10;
        int i11;
        int i12;
        int iZzb;
        int iZzc;
        int i13;
        zzfi zzfiVar;
        int i14;
        zzfe zzfeVar;
        zzfa zzfaVarZzk = zzk(new zzfn(bArr, i, i2));
        zzfn zzfnVar = new zzfn(bArr, i + 2, i2);
        zzfnVar.zzb(4);
        int iZzf = zzfnVar.zzf(3);
        int i15 = zzfaVarZzk.zzb;
        if (i15 == 0 || iZzf != 7) {
            z = false;
        } else {
            iZzf = 7;
            z = true;
        }
        if (zzfjVar != null) {
            zzgpe zzgpeVar = zzfjVar.zza;
            if (zzgpeVar.isEmpty()) {
                i3 = 0;
            } else {
                i3 = ((zzez) zzgpeVar.get(Math.min(i15, zzgpeVar.size() - 1))).zza;
            }
        } else {
            i3 = 0;
        }
        zzfb zzfbVarZzl = null;
        if (!z) {
            zzfnVar.zza();
            zzfbVarZzl = zzl(zzfnVar, true, iZzf, null);
        } else if (zzfjVar != null) {
            zzfc zzfcVar = zzfjVar.zzb;
            int i16 = zzfcVar.zzb[i3];
            zzgpe zzgpeVar2 = zzfcVar.zza;
            if (zzgpeVar2.size() > i16) {
                zzfbVarZzl = (zzfb) zzgpeVar2.get(i16);
            }
        }
        int iZzg3 = zzfnVar.zzg();
        if (z) {
            int iZzf2 = zzfnVar.zze() ? zzfnVar.zzf(8) : -1;
            if (zzfjVar == null || (zzfeVar = zzfjVar.zzc) == null) {
                i6 = 0;
                i8 = 0;
                iZzg = 0;
                i9 = 0;
                iZzg2 = 0;
                i5 = 0;
                i7 = 0;
            } else {
                if (iZzf2 == -1) {
                    iZzf2 = zzfeVar.zzb[i3];
                }
                if (iZzf2 != -1) {
                    zzgpe zzgpeVar3 = zzfeVar.zza;
                    if (zzgpeVar3.size() > iZzf2) {
                        zzfd zzfdVar = (zzfd) zzgpeVar3.get(iZzf2);
                        int i17 = zzfdVar.zza;
                        i7 = zzfdVar.zzd;
                        i5 = zzfdVar.zze;
                        iZzg = zzfdVar.zzb;
                        iZzg2 = zzfdVar.zzc;
                        i9 = i17;
                        i6 = i5;
                        i8 = i7;
                    } else {
                        i6 = 0;
                        i8 = 0;
                        iZzg = 0;
                        i9 = 0;
                        iZzg2 = 0;
                        i5 = 0;
                        i7 = 0;
                    }
                } else {
                    i6 = 0;
                    i8 = 0;
                    iZzg = 0;
                    i9 = 0;
                    iZzg2 = 0;
                    i5 = 0;
                    i7 = 0;
                }
            }
        } else {
            int iZzg4 = zzfnVar.zzg();
            if (iZzg4 == 3) {
                zzfnVar.zza();
                i4 = 3;
            } else {
                i4 = iZzg4;
            }
            int iZzg5 = zzfnVar.zzg();
            int iZzg6 = zzfnVar.zzg();
            if (zzfnVar.zze()) {
                int iZzg7 = zzfnVar.zzg();
                int iZzg8 = zzfnVar.zzg();
                int iZzg9 = zzfnVar.zzg();
                int iZzg10 = zzfnVar.zzg();
                iZzm = zzm(iZzg5, i4, iZzg7, iZzg8);
                iZzn = zzn(iZzg6, i4, iZzg9, iZzg10);
            } else {
                iZzn = iZzg6;
                iZzm = iZzg5;
            }
            iZzg = zzfnVar.zzg();
            i5 = iZzn;
            i6 = iZzg6;
            i7 = iZzm;
            i8 = iZzg5;
            iZzg2 = zzfnVar.zzg();
            i9 = iZzg4;
        }
        int iZzg11 = zzfnVar.zzg();
        if (z) {
            iMax = -1;
        } else {
            iMax = -1;
            for (int i18 = true != zzfnVar.zze() ? iZzf : 0; i18 <= iZzf; i18++) {
                zzfnVar.zzg();
                iMax = Math.max(zzfnVar.zzg(), iMax);
                zzfnVar.zzg();
            }
        }
        zzfnVar.zzg();
        zzfnVar.zzg();
        zzfnVar.zzg();
        zzfnVar.zzg();
        zzfnVar.zzg();
        zzfnVar.zzg();
        if (zzfnVar.zze()) {
            if (z && zzfnVar.zze()) {
                zzfnVar.zzb(6);
            } else if (zzfnVar.zze()) {
                int i19 = 4;
                int i20 = 0;
                while (i20 < i19) {
                    int i21 = i19;
                    int i22 = iMax;
                    for (int i23 = 0; i23 < 6; i23 += i20 == 3 ? 3 : 1) {
                        if (zzfnVar.zze()) {
                            int iMin = Math.min(64, 1 << ((i20 + i20) + 4));
                            if (i20 > 1) {
                                zzfnVar.zzh();
                            }
                            for (int i24 = 0; i24 < iMin; i24++) {
                                zzfnVar.zzh();
                            }
                        } else {
                            zzfnVar.zzg();
                        }
                    }
                    i20++;
                    iMax = i22;
                    i19 = i21;
                }
            }
        }
        int i25 = iMax;
        zzfnVar.zzb(2);
        if (zzfnVar.zze()) {
            zzfnVar.zzb(8);
            zzfnVar.zzg();
            zzfnVar.zzg();
            zzfnVar.zza();
        }
        int iZzg12 = zzfnVar.zzg();
        int i26 = 0;
        int[] iArr = new int[0];
        int i27 = iZzf;
        int[] iArrCopyOf = new int[0];
        int i28 = iZzg;
        int i29 = -1;
        int i30 = -1;
        while (i26 < iZzg12) {
            if (i26 == 0 || !zzfnVar.zze()) {
                int iZzg13 = zzfnVar.zzg();
                int iZzg14 = zzfnVar.zzg();
                int[] iArr2 = new int[iZzg13];
                int i31 = 0;
                while (i31 < iZzg13) {
                    iArr2[i31] = (i31 > 0 ? iArr2[i31 - 1] : 0) - (zzfnVar.zzg() + 1);
                    zzfnVar.zza();
                    i31++;
                }
                int[] iArr3 = new int[iZzg14];
                int i32 = 0;
                while (i32 < iZzg14) {
                    iArr3[i32] = (i32 > 0 ? iArr3[i32 - 1] : 0) + zzfnVar.zzg() + 1;
                    zzfnVar.zza();
                    i32++;
                }
                iArr = iArr2;
                iArrCopyOf = iArr3;
                i29 = iZzg13;
                i30 = iZzg14;
            } else {
                int i33 = i29 + i30;
                boolean zZze = zzfnVar.zze();
                boolean z2 = true;
                int iZzg15 = zzfnVar.zzg() + 1;
                int i34 = 1 - ((zZze ? 1 : 0) + (zZze ? 1 : 0));
                int i35 = i33 + 1;
                boolean[] zArr = new boolean[i35];
                int i36 = 0;
                while (i36 <= i33) {
                    if (zzfnVar.zze()) {
                        zArr[i36] = z2;
                    } else {
                        zArr[i36] = zzfnVar.zze();
                    }
                    i36++;
                    z2 = true;
                }
                int i37 = i30 - 1;
                int[] iArr4 = new int[i35];
                int[] iArr5 = new int[i35];
                int i38 = 0;
                while (true) {
                    i14 = i34 * iZzg15;
                    if (i37 < 0) {
                        break;
                    }
                    int i39 = iArrCopyOf[i37] + i14;
                    if (i39 < 0 && zArr[i29 + i37]) {
                        iArr4[i38] = i39;
                        i38++;
                    }
                    i37--;
                }
                if (i14 < 0 && zArr[i33]) {
                    iArr4[i38] = i14;
                    i38++;
                }
                int i40 = i38;
                for (int i41 = 0; i41 < i29; i41++) {
                    int i42 = iArr[i41] + i14;
                    if (i42 < 0 && zArr[i41]) {
                        iArr4[i40] = i42;
                        i40++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i40);
                int i43 = 0;
                for (int i44 = i29 - 1; i44 >= 0; i44--) {
                    int i45 = iArr[i44] + i14;
                    if (i45 > 0 && zArr[i44]) {
                        iArr5[i43] = i45;
                        i43++;
                    }
                }
                if (i14 > 0 && zArr[i33]) {
                    iArr5[i43] = i14;
                    i43++;
                }
                int i46 = i43;
                for (int i47 = 0; i47 < i30; i47++) {
                    int i48 = iArrCopyOf[i47] + i14;
                    if (i48 > 0 && zArr[i29 + i47]) {
                        iArr5[i46] = i48;
                        i46++;
                    }
                }
                iArr = iArrCopyOf2;
                iArrCopyOf = Arrays.copyOf(iArr5, i46);
                i29 = i40;
                i30 = i46;
            }
            i26++;
            iZzg12 = iZzg12;
            i3 = i3;
            zzfaVarZzk = zzfaVarZzk;
        }
        zzfa zzfaVar = zzfaVarZzk;
        int i49 = i3;
        if (zzfnVar.zze()) {
            int iZzg16 = zzfnVar.zzg();
            for (int i50 = 0; i50 < iZzg16; i50++) {
                zzfnVar.zzb(iZzg11 + 5);
            }
        }
        zzfnVar.zzb(2);
        float f2 = 1.0f;
        if (zzfnVar.zze()) {
            if (zzfnVar.zze()) {
                int iZzf3 = zzfnVar.zzf(8);
                if (iZzf3 == 255) {
                    int iZzf4 = zzfnVar.zzf(16);
                    int iZzf5 = zzfnVar.zzf(16);
                    if (iZzf4 != 0 && iZzf5 != 0) {
                        f2 = iZzf4 / iZzf5;
                    }
                } else if (iZzf3 < 17) {
                    f2 = zzb[iZzf3];
                } else {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzf3).length() + 35);
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(iZzf3);
                    zzdt.zzc("NalUnitUtil", sb.toString());
                }
            }
            if (zzfnVar.zze()) {
                zzfnVar.zza();
            }
            if (zzfnVar.zze()) {
                zzfnVar.zzb(3);
                i13 = true != zzfnVar.zze() ? 2 : 1;
                if (zzfnVar.zze()) {
                    int iZzf6 = zzfnVar.zzf(8);
                    int iZzf7 = zzfnVar.zzf(8);
                    zzfnVar.zzb(8);
                    iZzb = zzi.zzb(iZzf6);
                    iZzc = zzi.zzc(iZzf7);
                } else {
                    iZzb = -1;
                    iZzc = -1;
                }
            } else if (zzfjVar == null || (zzfiVar = zzfjVar.zzd) == null) {
                iZzb = -1;
                iZzc = -1;
                i13 = -1;
            } else {
                int i51 = zzfiVar.zzb[i49];
                zzgpe zzgpeVar4 = zzfiVar.zza;
                if (zzgpeVar4.size() > i51) {
                    zzfh zzfhVar = (zzfh) zzgpeVar4.get(i51);
                    int i52 = zzfhVar.zza;
                    int i53 = zzfhVar.zzb;
                    iZzc = zzfhVar.zzc;
                    iZzb = i52;
                    i13 = i53;
                } else {
                    iZzb = -1;
                    iZzc = -1;
                    i13 = -1;
                }
            }
            if (zzfnVar.zze()) {
                zzfnVar.zzg();
                zzfnVar.zzg();
            }
            zzfnVar.zza();
            if (zzfnVar.zze()) {
                i5 += i5;
            }
            i10 = iZzb;
            f = f2;
            i12 = iZzc;
            i11 = i13;
        } else {
            f = 1.0f;
            i10 = -1;
            i11 = -1;
            i12 = -1;
        }
        return new zzfg(zzfaVar, i27, zzfbVarZzl, i9, i28, iZzg2, iZzg3, i7, i5, i8, i6, f, i25, i10, i11, i12);
    }

    public static zzfk zzg(byte[] bArr, int i, int i2) {
        zzfn zzfnVar = new zzfn(bArr, 4, i2);
        int iZzg = zzfnVar.zzg();
        int iZzg2 = zzfnVar.zzg();
        zzfnVar.zza();
        return new zzfk(iZzg, iZzg2, zzfnVar.zze());
    }

    public static int zzh(byte[] bArr, int i, int i2, boolean[] zArr) {
        int i3 = i2 - i;
        zzgmd.zzh(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            zzi(zArr);
            return i - 3;
        }
        if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            zzi(zArr);
            return i - 2;
        }
        if (i3 > 2 && zArr[2] && bArr[i] == 0 && bArr[i + 1] == 1) {
            zzi(zArr);
            return i - 1;
        }
        int i4 = i2 - 1;
        int i5 = i + 2;
        while (i5 < i4) {
            byte b = bArr[i5];
            if ((b & 254) == 0) {
                int i6 = i5 - 2;
                if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                    zzi(zArr);
                    return i6;
                }
                i5 = i6;
            }
            i5 += 3;
        }
        zArr[0] = i3 <= 2 ? !(i3 != 2 ? !(zArr[1] && bArr[i4] == 1) : !(zArr[2] && bArr[i2 + (-2)] == 0 && bArr[i4] == 1)) : bArr[i2 + (-3)] == 0 && bArr[i2 + (-2)] == 0 && bArr[i4] == 1;
        zArr[1] = i3 <= 1 ? zArr[2] && bArr[i4] == 0 : bArr[i2 + (-2)] == 0 && bArr[i4] == 0;
        zArr[2] = bArr[i4] == 0;
        return i2;
    }

    public static void zzi(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static String zzj(List list) {
        for (int i = 0; i < list.size(); i++) {
            byte[] bArr = (byte[]) list.get(i);
            int length = bArr.length;
            if (length > 3) {
                boolean[] zArr = new boolean[3];
                int i2 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                int i3 = 0;
                while (true) {
                    int length2 = bArr.length;
                    if (i3 >= length2) {
                        break;
                    }
                    int iZzh = zzh(bArr, i3, length2, zArr);
                    if (iZzh != length2) {
                        zzgpbVar.zzf(Integer.valueOf(iZzh));
                    }
                    i3 = iZzh + 3;
                }
                zzgpe zzgpeVarZzi = zzgpbVar.zzi();
                for (int i4 = 0; i4 < zzgpeVarZzi.size(); i4++) {
                    if (((Integer) zzgpeVarZzi.get(i4)).intValue() + 3 < length) {
                        zzfn zzfnVar = new zzfn(bArr, ((Integer) zzgpeVarZzi.get(i4)).intValue() + 3, length);
                        zzfa zzfaVarZzk = zzk(zzfnVar);
                        if (zzfaVarZzk.zza == 33 && zzfaVarZzk.zzb == 0) {
                            zzfnVar.zzb(4);
                            int iZzf = zzfnVar.zzf(3);
                            zzfnVar.zza();
                            zzfb zzfbVarZzl = zzl(zzfnVar, true, iZzf, null);
                            return zzdd.zzb(zzfbVarZzl.zza, zzfbVarZzl.zzb, zzfbVarZzl.zzc, zzfbVarZzl.zzd, zzfbVarZzl.zze, zzfbVarZzl.zzf);
                        }
                    }
                }
            }
        }
        return null;
    }

    private static zzfa zzk(zzfn zzfnVar) {
        zzfnVar.zza();
        return new zzfa(zzfnVar.zzf(6), zzfnVar.zzf(6), zzfnVar.zzf(3) - 1);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x005c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0062  */
    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:30:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c A[SYNTHETIC] */
    private static zzfb zzl(zzfn zzfnVar, boolean z, int i, zzfb zzfbVar) {
        int[] iArr;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean zZze;
        int iZzf;
        int i5;
        int i6;
        int[] iArr2 = new int[6];
        if (!z) {
            if (zzfbVar != null) {
                int i7 = zzfbVar.zza;
                zZze = zzfbVar.zzb;
                iZzf = zzfbVar.zzc;
                i5 = zzfbVar.zzd;
                iArr2 = zzfbVar.zze;
                i2 = i7;
            } else {
                iArr = iArr2;
                i2 = 0;
                z2 = false;
                i3 = 0;
                i4 = 0;
            }
            int iZzf2 = zzfnVar.zzf(8);
            i6 = 0;
            for (int i8 = 0; i8 < i; i8++) {
                if (zzfnVar.zze()) {
                    i6 += 88;
                }
                if (zzfnVar.zze()) {
                    i6 += 8;
                }
            }
            zzfnVar.zzb(i6);
            if (i > 0) {
                int i9 = 8 - i;
                zzfnVar.zzb(i9 + i9);
            }
            return new zzfb(i2, z2, i3, i4, iArr, iZzf2);
        }
        int iZzf3 = zzfnVar.zzf(2);
        zZze = zzfnVar.zze();
        iZzf = zzfnVar.zzf(5);
        i5 = 0;
        for (int i10 = 0; i10 < 32; i10++) {
            if (zzfnVar.zze()) {
                i5 |= 1 << i10;
            }
        }
        for (int i11 = 0; i11 < 6; i11++) {
            iArr2[i11] = zzfnVar.zzf(8);
        }
        i2 = iZzf3;
        iArr = iArr2;
        z2 = zZze;
        i3 = iZzf;
        i4 = i5;
        int iZzf4 = zzfnVar.zzf(8);
        i6 = 0;
        while (i8 < i) {
            if (zzfnVar.zze()) {
                i6 += 88;
            }
            if (zzfnVar.zze()) {
                i6 += 8;
            }
        }
        zzfnVar.zzb(i6);
        if (i > 0) {
            int i12 = 8 - i;
            zzfnVar.zzb(i12 + i12);
        }
        return new zzfb(i2, z2, i3, i4, iArr, iZzf4);
    }

    private static int zzm(int i, int i2, int i3, int i4) {
        int i5 = 2;
        if (i2 != 1 && i2 != 2) {
            i5 = 1;
        }
        return i - (i5 * (i3 + i4));
    }

    private static int zzn(int i, int i2, int i3, int i4) {
        return i - ((i2 == 1 ? 2 : 1) * (i3 + i4));
    }

    private static void zzo(zzfn zzfnVar) {
        int iZzg = zzfnVar.zzg() + 1;
        zzfnVar.zzb(8);
        for (int i = 0; i < iZzg; i++) {
            zzfnVar.zzg();
            zzfnVar.zzg();
            zzfnVar.zza();
        }
        zzfnVar.zzb(20);
    }

    public static int zza(byte[] bArr, int i) {
        int i2;
        synchronized (zzc) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    try {
                        if (i3 >= i - 2) {
                            i3 = i;
                            break;
                        }
                        int i5 = i3 + 1;
                        if (bArr[i3] == 0 && bArr[i5] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3 = i5;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i4) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = zzd[i8] - i6;
                System.arraycopy(bArr, i6, bArr, i7, i9);
                int i10 = i7 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i7 = i10 + 2;
                bArr[i11] = 0;
                i6 += i9 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i7, i2 - i7);
        }
        return i2;
    }
}
