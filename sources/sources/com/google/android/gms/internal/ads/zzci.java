package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzci {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private double zzw;

    public zzci(int i, int i2, float f, float f2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = i / i3;
        this.zzf = i / 400;
        int i4 = i / 65;
        this.zzg = i4;
        int i5 = i4 + i4;
        this.zzh = i5;
        this.zzi = new short[i5];
        int i6 = i5 * i2;
        this.zzj = new short[i6];
        this.zzl = new short[i6];
        this.zzn = new short[i6];
    }

    private final short[] zzg(short[] sArr, int i, int i2) {
        int length = sArr.length;
        int i3 = this.zzb;
        int i4 = length / i3;
        return i + i2 <= i4 ? sArr : Arrays.copyOf(sArr, (((i4 * 3) / 2) + i2) * i3);
    }

    private final void zzh(short[] sArr, int i, int i2) {
        short[] sArrZzg = zzg(this.zzl, this.zzm, i2);
        this.zzl = sArrZzg;
        int i3 = this.zzm;
        int i4 = this.zzb;
        System.arraycopy(sArr, i * i4, sArrZzg, i3 * i4, i2 * i4);
        this.zzm += i2;
    }

    private final void zzi(short[] sArr, int i, int i2) {
        int i3;
        for (int i4 = 0; i4 < this.zzh / i2; i4++) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.zzb;
                i3 = i7 * i2;
                if (i5 < i3) {
                    i6 += sArr[(i7 * i) + (i3 * i4) + i5];
                    i5++;
                }
            }
            this.zzi[i4] = (short) (i6 / i3);
        }
    }

    private final int zzj(short[] sArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 255;
        int i6 = 0;
        int i7 = 0;
        while (i2 <= i3) {
            int iAbs = 0;
            for (int i8 = 0; i8 < i2; i8++) {
                int i9 = this.zzb * i;
                iAbs += Math.abs(sArr[i9 + i8] - sArr[(i9 + i2) + i8]);
            }
            int i10 = iAbs * i6;
            int i11 = i4 * i2;
            if (i10 < i11) {
                i4 = iAbs;
            }
            if (i10 < i11) {
                i6 = i2;
            }
            int i12 = iAbs * i5;
            int i13 = i7 * i2;
            if (i12 > i13) {
                i7 = iAbs;
            }
            if (i12 > i13) {
                i5 = i2;
            }
            i2++;
        }
        this.zzu = i4 / i6;
        this.zzv = i7 / i5;
        return i6;
    }

    private static void zzl(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i4 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i3 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i9] = (short) (((sArr2[i7] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i9 += i2;
                i7 += i2;
                i8 += i2;
            }
        }
    }

    public final int zza() {
        int i = this.zzk * this.zzb;
        return i + i;
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i = this.zzb;
        int i2 = iRemaining / i;
        int i3 = i2 * i;
        short[] sArrZzg = zzg(this.zzj, this.zzk, i2);
        this.zzj = sArrZzg;
        shortBuffer.get(sArrZzg, this.zzk * i, (i3 + i3) / 2);
        this.zzk += i2;
        zzk();
    }

    public final void zzc(ShortBuffer shortBuffer) {
        zzgmd.zzh(this.zzm >= 0);
        int iRemaining = shortBuffer.remaining();
        int i = this.zzb;
        int iMin = Math.min(iRemaining / i, this.zzm);
        int i2 = iMin * i;
        shortBuffer.put(this.zzl, 0, i2);
        int i3 = this.zzm - iMin;
        this.zzm = i3;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, i2, sArr, 0, i3 * i);
    }

    public final void zzd() {
        int i = this.zzk;
        int i2 = this.zzr;
        int i3 = this.zzm;
        float f = this.zzc;
        float f2 = this.zzd;
        int i4 = i3 + ((int) ((((((((double) (i - i2)) / ((double) (f / f2))) + ((double) i2)) + this.zzw) + ((double) this.zzo)) / ((double) (this.zze * f2))) + 0.5d));
        this.zzw = 0.0d;
        int i5 = this.zzh;
        int i6 = i5 + i5;
        this.zzj = zzg(this.zzj, i, i + i6);
        int i7 = 0;
        while (true) {
            int i8 = this.zzb;
            if (i7 >= i6 * i8) {
                break;
            }
            this.zzj[(i8 * i) + i7] = 0;
            i7++;
        }
        this.zzk += i6;
        zzk();
        if (this.zzm > i4) {
            this.zzm = Math.max(i4, 0);
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zze() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
        this.zzw = 0.0d;
    }

    public final int zzf() {
        zzgmd.zzh(this.zzm >= 0);
        int i = this.zzm * this.zzb;
        return i + i;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0293 A[LOOP:4: B:12:0x0036->B:105:0x0293, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:115:0x0192 A[EDGE_INSN: B:115:0x0192->B:68:0x0192 BREAK  A[LOOP:4: B:12:0x0036->B:105:0x0293], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0086  */
    /* JADX WARN: Code duplicated, block: B:30:0x008e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0093  */
    /* JADX WARN: Code duplicated, block: B:37:0x0097  */
    /* JADX WARN: Code duplicated, block: B:38:0x009c  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a4  */
    private final void zzk() {
        short[] sArr;
        int i;
        int i2;
        int iZzj;
        int iZzj2;
        int i3;
        int i4;
        int i5;
        double d;
        int i6;
        int i7;
        int i8;
        int i9;
        float f;
        int i10;
        int i11;
        int i12;
        int i13;
        long j;
        long j2;
        float f2 = this.zzc;
        float f3 = this.zzd;
        double d2 = f2 / f3;
        int i14 = this.zzm;
        int i15 = 0;
        int i16 = 1;
        if (d2 > 1.0000100135803223d || d2 < 0.9999899864196777d) {
            int i17 = this.zzk;
            int i18 = this.zzh;
            if (i17 >= i18) {
                int i19 = 0;
                while (true) {
                    int i20 = this.zzr;
                    if (i20 > 0) {
                        int iMin = Math.min(i18, i20);
                        zzh(this.zzj, i19, iMin);
                        this.zzr -= iMin;
                        i19 += iMin;
                        f3 = f3;
                        d = d2;
                    } else {
                        short[] sArr2 = this.zzj;
                        int i21 = this.zza;
                        int i22 = i21 > 4000 ? i21 / 4000 : i16;
                        int i23 = this.zzb;
                        if (i23 != i16) {
                            zzi(sArr2, i19, i22);
                            sArr = this.zzi;
                            i = this.zzf;
                            i2 = this.zzg;
                            iZzj = zzj(sArr, i15, i / i22, i2 / i22);
                            if (i22 != 1) {
                                int i24 = iZzj * i22;
                                int i25 = i22 * 4;
                                i4 = i24 - i25;
                                if (i4 >= i) {
                                    i = i4;
                                }
                                i5 = i24 + i25;
                                if (i5 <= i2) {
                                    i2 = i5;
                                }
                                if (i23 == 1) {
                                    iZzj2 = zzj(sArr2, i19, i, i2);
                                } else {
                                    zzi(sArr2, i19, 1);
                                    iZzj2 = zzj(sArr, i15, i, i2);
                                }
                            } else {
                                iZzj2 = iZzj;
                            }
                            i3 = i23;
                        } else if (i22 == i16) {
                            iZzj2 = zzj(sArr2, i19, this.zzf, this.zzg);
                            i3 = i16;
                        } else {
                            i23 = i16;
                            zzi(sArr2, i19, i22);
                            sArr = this.zzi;
                            i = this.zzf;
                            i2 = this.zzg;
                            iZzj = zzj(sArr, i15, i / i22, i2 / i22);
                            if (i22 != 1) {
                                int i26 = iZzj * i22;
                                int i27 = i22 * 4;
                                i4 = i26 - i27;
                                if (i4 >= i) {
                                    i = i4;
                                }
                                i5 = i26 + i27;
                                if (i5 <= i2) {
                                    i2 = i5;
                                }
                                if (i23 == 1) {
                                    iZzj2 = zzj(sArr2, i19, i, i2);
                                } else {
                                    zzi(sArr2, i19, 1);
                                    iZzj2 = zzj(sArr, i15, i, i2);
                                }
                            } else {
                                iZzj2 = iZzj;
                            }
                            i3 = i23;
                        }
                        int i28 = this.zzu;
                        int i29 = (i28 == 0 || (i9 = this.zzs) == 0 || this.zzv > i28 * 3 || i28 + i28 <= this.zzt * 3) ? iZzj2 : i9;
                        int i30 = i19 + i29;
                        this.zzt = i28;
                        this.zzs = iZzj2;
                        double d3 = i29;
                        if (d2 > 1.0d) {
                            short[] sArr3 = this.zzj;
                            double d4 = d2 - 1.0d;
                            if (d2 >= 2.0d) {
                                i7 = i29;
                                double d5 = (d3 / d4) + this.zzw;
                                int iRound = (int) Math.round(d5);
                                d = d2;
                                this.zzw = d5 - ((double) iRound);
                                i8 = iRound;
                            } else {
                                d = d2;
                                i7 = i29;
                                double d6 = ((d3 * (2.0d - d)) / d4) + this.zzw;
                                int iRound2 = (int) Math.round(d6);
                                this.zzr = iRound2;
                                this.zzw = d6 - ((double) iRound2);
                                i8 = i7;
                            }
                            short[] sArrZzg = zzg(this.zzl, this.zzm, i8);
                            this.zzl = sArrZzg;
                            zzl(i8, i3, sArrZzg, this.zzm, sArr3, i19, sArr3, i30);
                            this.zzm += i8;
                            i19 += i7 + i8;
                        } else {
                            int i31 = i19;
                            d = d2;
                            int i32 = i29;
                            short[] sArr4 = this.zzj;
                            double d7 = 1.0d - d;
                            if (d < 0.5d) {
                                double d8 = ((d3 * d) / d7) + this.zzw;
                                int iRound3 = (int) Math.round(d8);
                                this.zzw = d8 - ((double) iRound3);
                                i6 = iRound3;
                            } else {
                                double d9 = ((d3 * ((d + d) - 1.0d)) / d7) + this.zzw;
                                int iRound4 = (int) Math.round(d9);
                                this.zzr = iRound4;
                                this.zzw = d9 - ((double) iRound4);
                                i6 = i32;
                            }
                            int i33 = i32 + i6;
                            short[] sArrZzg2 = zzg(this.zzl, this.zzm, i33);
                            this.zzl = sArrZzg2;
                            System.arraycopy(sArr4, i31 * i3, sArrZzg2, this.zzm * i3, i32 * i3);
                            zzl(i6, i3, this.zzl, this.zzm + i32, sArr4, i30, sArr4, i31);
                            this.zzm += i33;
                            i19 = i31 + i6;
                        }
                        if (i19 + i18 > i17) {
                            break;
                        }
                        i16 = 1;
                        f3 = f3;
                        i14 = i14;
                        d2 = d;
                        i15 = 0;
                    }
                    i14 = i14;
                    if (i19 + i18 > i17) {
                        break;
                        break;
                    }
                    i16 = 1;
                    f3 = f3;
                    i14 = i14;
                    d2 = d;
                    i15 = 0;
                }
                int i34 = this.zzk - i19;
                short[] sArr5 = this.zzj;
                int i35 = this.zzb;
                System.arraycopy(sArr5, i19 * i35, sArr5, 0, i35 * i34);
                this.zzk = i34;
            }
            f = this.zze * f3;
            if (f != 1.0f || this.zzm == (i10 = i14)) {
            }
            int i36 = this.zza;
            long j3 = i36;
            long j4 = (long) (i36 / f);
            while (j4 != 0 && j3 != 0 && j4 % 2 == 0 && j3 % 2 == 0) {
                j4 /= 2;
                j3 /= 2;
            }
            int i37 = this.zzm - i10;
            short[] sArrZzg3 = zzg(this.zzn, this.zzo, i37);
            this.zzn = sArrZzg3;
            short[] sArr6 = this.zzl;
            int i38 = this.zzb;
            System.arraycopy(sArr6, i10 * i38, sArrZzg3, this.zzo * i38, i37 * i38);
            this.zzm = i10;
            this.zzo += i37;
            int i39 = 0;
            while (true) {
                i11 = this.zzo;
                i12 = i11 - 1;
                if (i39 >= i12) {
                    break;
                }
                while (true) {
                    i13 = this.zzp + 1;
                    j = i13;
                    long j5 = j * j4;
                    j2 = this.zzq;
                    if (j5 <= j2 * j3) {
                        break;
                    }
                    this.zzl = zzg(this.zzl, this.zzm, 1);
                    int i40 = 0;
                    while (i40 < i38) {
                        short[] sArr7 = this.zzl;
                        int i41 = this.zzm * i38;
                        short[] sArr8 = this.zzn;
                        int i42 = (i39 * i38) + i40;
                        short s = sArr8[i42];
                        short s2 = sArr8[i42 + i38];
                        long j6 = ((long) this.zzq) * j3;
                        int i43 = this.zzp;
                        int i44 = i40;
                        long j7 = ((long) (i43 + 1)) * j4;
                        long j8 = j7 - (((long) i43) * j4);
                        long j9 = j7 - j6;
                        sArr7[i41 + i44] = (short) (((j9 * ((long) s)) + ((j8 - j9) * ((long) s2))) / j8);
                        i40 = i44 + 1;
                    }
                    this.zzq++;
                    this.zzm++;
                }
                this.zzp = i13;
                if (j == j3) {
                    this.zzp = 0;
                    zzgmd.zzh(j2 == j4);
                    this.zzq = 0;
                }
                i39++;
            }
            if (i12 != 0) {
                short[] sArr9 = this.zzn;
                System.arraycopy(sArr9, i12 * i38, sArr9, 0, (i11 - i12) * i38);
                this.zzo -= i12;
                return;
            }
            return;
        }
        zzh(this.zzj, 0, this.zzk);
        this.zzk = 0;
        f3 = f3;
        i14 = i14;
        f = this.zze * f3;
        if (f != 1.0f) {
        }
    }
}
