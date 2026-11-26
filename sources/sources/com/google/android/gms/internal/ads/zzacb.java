package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzacb {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {24000, 22050, 16000};
    private static final int[] zze = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] zzf = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] zzg = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzv zza(zzeg zzegVar, String str, String str2, zzq zzqVar) {
        zzef zzefVar = new zzef();
        zzefVar.zza(zzegVar);
        int i = zzc[zzefVar.zzj(2)];
        zzefVar.zzh(8);
        int i2 = zze[zzefVar.zzj(3)];
        if (zzefVar.zzj(1) != 0) {
            i2++;
        }
        int i3 = zzf[zzefVar.zzj(5)] * 1000;
        zzefVar.zzm();
        zzegVar.zzh(zzefVar.zze());
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzm("audio/ac3");
        zztVar.zzE(i2);
        zztVar.zzF(i);
        zztVar.zzq(zzqVar);
        zztVar.zze(str2);
        zztVar.zzh(i3);
        zztVar.zzi(i3);
        return zztVar.zzM();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0062  */
    public static zzv zzb(zzeg zzegVar, String str, String str2, zzq zzqVar) {
        String str3;
        zzef zzefVar = new zzef();
        zzefVar.zza(zzegVar);
        int iZzj = zzefVar.zzj(13) * 1000;
        zzefVar.zzh(3);
        int i = zzc[zzefVar.zzj(2)];
        zzefVar.zzh(10);
        int i2 = zze[zzefVar.zzj(3)];
        if (zzefVar.zzj(1) != 0) {
            i2++;
        }
        zzefVar.zzh(3);
        int iZzj2 = zzefVar.zzj(4);
        zzefVar.zzh(1);
        if (iZzj2 > 0) {
            zzefVar.zzh(6);
            if (zzefVar.zzj(1) != 0) {
                i2 += 2;
            }
            zzefVar.zzh(1);
        }
        if (zzefVar.zzc() > 7) {
            zzefVar.zzh(7);
            if (zzefVar.zzj(1) != 0) {
                str3 = "audio/eac3-joc";
            } else {
                str3 = "audio/eac3";
            }
        } else {
            str3 = "audio/eac3";
        }
        zzefVar.zzm();
        zzegVar.zzh(zzefVar.zze());
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzm(str3);
        zztVar.zzE(i2);
        zztVar.zzF(i);
        zztVar.zzq(zzqVar);
        zztVar.zze(str2);
        zztVar.zzi(iZzj);
        return zztVar.zzM();
    }

    public static zzaca zzc(zzef zzefVar) {
        int iZzf;
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int iZzd = zzefVar.zzd();
        zzefVar.zzh(40);
        int iZzj = zzefVar.zzj(5);
        zzefVar.zzf(iZzd);
        int i9 = -1;
        if (iZzj > 10) {
            zzefVar.zzh(16);
            int iZzj2 = zzefVar.zzj(2);
            if (iZzj2 == 0) {
                i9 = 0;
            } else if (iZzj2 == 1) {
                i9 = 1;
            } else if (iZzj2 == 2) {
                i9 = 2;
            }
            zzefVar.zzh(3);
            int iZzj3 = zzefVar.zzj(11) + 1;
            int iZzj4 = zzefVar.zzj(2);
            if (iZzj4 == 3) {
                i = zzd[zzefVar.zzj(2)];
                i6 = 6;
                i5 = 3;
            } else {
                int iZzj5 = zzefVar.zzj(2);
                int i10 = zzb[iZzj5];
                i5 = iZzj5;
                i = zzc[iZzj4];
                i6 = i10;
            }
            iZzf = iZzj3 + iZzj3;
            int i11 = (iZzf * i) / (i6 * 32);
            int iZzj6 = zzefVar.zzj(3);
            boolean zZzi = zzefVar.zzi();
            i2 = zze[iZzj6] + (zZzi ? 1 : 0);
            zzefVar.zzh(10);
            if (zzefVar.zzi()) {
                zzefVar.zzh(8);
            }
            if (iZzj6 == 0) {
                zzefVar.zzh(5);
                if (zzefVar.zzi()) {
                    zzefVar.zzh(8);
                }
                i7 = 0;
                iZzj6 = 0;
            } else {
                i7 = iZzj6;
            }
            if (i9 == 1) {
                if (zzefVar.zzi()) {
                    zzefVar.zzh(16);
                }
                i8 = 1;
            } else {
                i8 = i9;
            }
            if (zzefVar.zzi()) {
                if (i7 > 2) {
                    zzefVar.zzh(2);
                }
                if ((i7 & 1) != 0 && i7 > 2) {
                    zzefVar.zzh(6);
                }
                if ((i7 & 4) != 0) {
                    zzefVar.zzh(6);
                }
                if (zZzi && zzefVar.zzi()) {
                    zzefVar.zzh(5);
                }
                if (i8 == 0) {
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(6);
                    }
                    if (i7 == 0 && zzefVar.zzi()) {
                        zzefVar.zzh(6);
                    }
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(6);
                    }
                    int iZzj7 = zzefVar.zzj(2);
                    if (iZzj7 == 1) {
                        zzefVar.zzh(5);
                    } else if (iZzj7 == 2) {
                        zzefVar.zzh(12);
                    } else if (iZzj7 == 3) {
                        int iZzj8 = zzefVar.zzj(5);
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(5);
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(4);
                            }
                            if (zzefVar.zzi()) {
                                if (zzefVar.zzi()) {
                                    zzefVar.zzh(4);
                                }
                                if (zzefVar.zzi()) {
                                    zzefVar.zzh(4);
                                }
                            }
                        }
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(5);
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(7);
                                if (zzefVar.zzi()) {
                                    zzefVar.zzh(8);
                                }
                            }
                        }
                        zzefVar.zzh((iZzj8 + 2) * 8);
                        zzefVar.zzm();
                    }
                    if (i7 < 2) {
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(14);
                        }
                        if (iZzj6 == 0 && zzefVar.zzi()) {
                            zzefVar.zzh(14);
                        }
                    }
                    if (!zzefVar.zzi()) {
                        i8 = 0;
                    } else if (i5 == 0) {
                        zzefVar.zzh(5);
                        i8 = 0;
                        i5 = 0;
                    } else {
                        for (int i12 = 0; i12 < i6; i12++) {
                            if (zzefVar.zzi()) {
                                zzefVar.zzh(5);
                            }
                        }
                        i8 = 0;
                    }
                }
            }
            if (zzefVar.zzi()) {
                zzefVar.zzh(5);
                if (i7 == 2) {
                    zzefVar.zzh(4);
                    i7 = 2;
                }
                if (i7 >= 6) {
                    zzefVar.zzh(2);
                }
                if (zzefVar.zzi()) {
                    zzefVar.zzh(8);
                }
                if (i7 == 0 && zzefVar.zzi()) {
                    zzefVar.zzh(8);
                }
                if (iZzj4 < 3) {
                    zzefVar.zzg();
                }
            }
            if (i8 == 0 && i5 != 3) {
                zzefVar.zzg();
            }
            if (i8 == 2 && (i5 == 3 || zzefVar.zzi())) {
                zzefVar.zzh(6);
            }
            i3 = i6 * 256;
            str = (zzefVar.zzi() && zzefVar.zzj(6) == 1 && zzefVar.zzj(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = i11;
        } else {
            zzefVar.zzh(32);
            int iZzj9 = zzefVar.zzj(2);
            String str2 = iZzj9 == 3 ? null : "audio/ac3";
            int iZzj10 = zzefVar.zzj(6);
            int i13 = zzf[iZzj10 / 2] * 1000;
            iZzf = zzf(iZzj9, iZzj10);
            zzefVar.zzh(8);
            int iZzj11 = zzefVar.zzj(3);
            if ((iZzj11 & 1) != 0 && iZzj11 != 1) {
                zzefVar.zzh(2);
            }
            if ((iZzj11 & 4) != 0) {
                zzefVar.zzh(2);
            }
            if (iZzj11 == 2) {
                zzefVar.zzh(2);
            }
            i = iZzj9 < 3 ? zzc[iZzj9] : -1;
            i2 = zze[iZzj11] + (zzefVar.zzi() ? 1 : 0);
            i3 = 1536;
            str = str2;
            i4 = i13;
        }
        return new zzaca(str, i9, i2, i, iZzf, i3, i4, null);
    }

    public static int zzd(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) <= 10) {
            byte b = bArr[4];
            return zzf((b & 192) >> 6, b & 63);
        }
        int i = bArr[2] & 7;
        int i2 = ((bArr[3] & 255) | (i << 8)) + 1;
        return i2 + i2;
    }

    public static int zze(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return zzb[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    private static int zzf(int i, int i2) {
        int i3;
        if (i < 0 || i >= 3 || i2 < 0 || (i3 = i2 >> 1) >= 19) {
            return -1;
        }
        int i4 = zzc[i];
        if (i4 == 44100) {
            int i5 = zzg[i3] + (i2 & 1);
            return i5 + i5;
        }
        int i6 = zzf[i3];
        return i4 == 32000 ? i6 * 6 : i6 * 4;
    }
}
