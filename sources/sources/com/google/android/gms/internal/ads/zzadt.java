package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzadt {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;
    public final float zzl;
    public final int zzm;
    public final String zzn;
    public final zzfj zzo;

    private zzadt(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, float f, int i13, String str, zzfj zzfjVar) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
        this.zzg = i8;
        this.zzh = i9;
        this.zzi = i10;
        this.zzj = i11;
        this.zzk = i12;
        this.zzl = f;
        this.zzm = i13;
        this.zzn = str;
        this.zzo = zzfjVar;
    }

    public static zzadt zza(zzeg zzegVar) throws zzat {
        return zzc(zzegVar, false, null);
    }

    public static zzadt zzb(zzeg zzegVar, zzfj zzfjVar) throws zzat {
        return zzc(zzegVar, true, zzfjVar);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0294  */
    /* JADX WARN: Code duplicated, block: B:116:0x0297  */
    /* JADX WARN: Code duplicated, block: B:99:0x0253 A[PHI: r34
      0x0253: PHI (r34v2 int) = (r34v0 int), (r34v0 int), (r34v0 int), (r34v0 int), (r34v3 int) binds: [B:38:0x0136, B:39:0x0138, B:93:0x0237, B:94:0x0239, B:36:0x012c] A[DONT_GENERATE, DONT_INLINE]] */
    private static zzadt zzc(zzeg zzegVar, boolean z, zzfj zzfjVar) throws zzat {
        boolean z2;
        boolean z3;
        String str;
        int i;
        int i2;
        zzff zzffVar;
        int i3;
        int iMax;
        int i4;
        int iMax2;
        int i5;
        int i6;
        int i7 = 4;
        boolean z4 = true;
        if (z) {
            try {
                zzegVar.zzk(4);
            } catch (ArrayIndexOutOfBoundsException e) {
                e = e;
                z3 = true;
                if (z3 != z) {
                    str = "HEVC config";
                } else {
                    str = "L-HEVC config";
                }
                throw zzat.zzb("Error parsing".concat(str), e);
            }
        } else {
            try {
                zzegVar.zzk(21);
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                z2 = z4;
                z3 = z2;
                if (z3 != z) {
                    str = "HEVC config";
                } else {
                    str = "L-HEVC config";
                }
                throw zzat.zzb("Error parsing".concat(str), e);
            }
        }
        int iZzs = zzegVar.zzs() & 3;
        int iZzs2 = zzegVar.zzs();
        int iZzg = zzegVar.zzg();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < iZzs2; i10++) {
            zzegVar.zzk(1);
            int iZzt = zzegVar.zzt();
            for (int i11 = 0; i11 < iZzt; i11++) {
                int iZzt2 = zzegVar.zzt();
                i9 += iZzt2 + 4;
                zzegVar.zzk(iZzt2);
            }
        }
        zzegVar.zzh(iZzg);
        byte[] bArr = new byte[i9];
        zzfj zzfjVar2 = zzfjVar;
        int i12 = 0;
        float f = 1.0f;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        int i21 = -1;
        int i22 = -1;
        int i23 = -1;
        int i24 = -1;
        String strZzb = null;
        int i25 = 0;
        while (i25 < iZzs2) {
            int iZzs3 = zzegVar.zzs() & 63;
            int iZzt3 = zzegVar.zzt();
            z2 = z4;
            int i26 = i8;
            zzfj zzfjVarZze = zzfjVar2;
            while (i26 < iZzt3) {
                try {
                    int iZzt4 = zzegVar.zzt();
                    int i27 = i26;
                    System.arraycopy(zzfm.zza, i8, bArr, i12, i7);
                    int i28 = i12 + 4;
                    System.arraycopy(zzegVar.zzi(), zzegVar.zzg(), bArr, i28, iZzt4);
                    int i29 = 32;
                    if (iZzs3 == 32) {
                        if (i27 == 0) {
                            zzfjVarZze = zzfm.zze(bArr, i28, i28 + iZzt4);
                            i2 = i28;
                            i = iZzs;
                            i6 = 0;
                            i5 = 0;
                        }
                        i12 = i2 + iZzt4;
                        zzegVar.zzk(iZzt4);
                        i26 = i6 + 1;
                        i8 = i5;
                        iZzs = i;
                        i7 = 4;
                    } else {
                        i29 = iZzs3;
                    }
                    i = iZzs;
                    if (i29 != 33) {
                        i2 = i28;
                        int i30 = 8;
                        if (i29 == 39 && i27 == 0) {
                            int i31 = i12 + 6;
                            int i32 = (i2 + iZzt4) - 1;
                            while (true) {
                                byte b = bArr[i32];
                                if (b != 0) {
                                    if (b == 0 || i32 <= i31) {
                                        break;
                                    }
                                    zzfn zzfnVar = new zzfn(bArr, i31, i32 + 1);
                                    while (true) {
                                        if (zzfnVar.zzd(16)) {
                                            int i33 = i30;
                                            int iZzf = zzfnVar.zzf(i33);
                                            int i34 = 0;
                                            while (iZzf == 255) {
                                                i34 += 255;
                                                iZzf = zzfnVar.zzf(i33);
                                            }
                                            int i35 = i34 + iZzf;
                                            int iZzf2 = zzfnVar.zzf(i33);
                                            int i36 = 0;
                                            while (iZzf2 == 255) {
                                                i36 += 255;
                                                iZzf2 = zzfnVar.zzf(8);
                                            }
                                            i30 = 8;
                                            int i37 = i36 + iZzf2;
                                            if (i37 == 0 || !zzfnVar.zzd(i37)) {
                                                break;
                                            }
                                            if (i35 == 176) {
                                                int iZzg2 = zzfnVar.zzg();
                                                boolean zZze = zzfnVar.zze();
                                                int iZzg3 = zZze ? zzfnVar.zzg() : 0;
                                                int iZzg4 = zzfnVar.zzg();
                                                int iZzg5 = -1;
                                                int iZzg6 = -1;
                                                int i38 = -1;
                                                int iZzf3 = -1;
                                                int i39 = -1;
                                                int iZzf4 = -1;
                                                int i40 = 0;
                                                while (true) {
                                                    if (i40 > iZzg4) {
                                                        zzffVar = new zzff(iZzg2, iZzg3, iZzg4 + 1, iZzg5, iZzg6, i38, iZzf3, i39, iZzf4);
                                                        break;
                                                    }
                                                    iZzg5 = zzfnVar.zzg();
                                                    iZzg6 = zzfnVar.zzg();
                                                    boolean z5 = zZze;
                                                    int iZzf5 = zzfnVar.zzf(6);
                                                    if (iZzf5 != 63) {
                                                        if (iZzf5 == 0) {
                                                            i3 = iZzf5;
                                                            iMax = Math.max(0, iZzg2 - 30);
                                                        } else {
                                                            i3 = iZzf5;
                                                            iMax = Math.max(0, (i3 + iZzg2) - 31);
                                                        }
                                                        iZzf3 = zzfnVar.zzf(iMax);
                                                        if (z5) {
                                                            int iZzf6 = zzfnVar.zzf(6);
                                                            if (iZzf6 != 63) {
                                                                if (iZzf6 == 0) {
                                                                    i4 = iZzf6;
                                                                    iMax2 = Math.max(0, iZzg3 - 30);
                                                                } else {
                                                                    i4 = iZzf6;
                                                                    iMax2 = Math.max(0, (i4 + iZzg3) - 31);
                                                                }
                                                                iZzf4 = zzfnVar.zzf(iMax2);
                                                                i39 = i4;
                                                            }
                                                        }
                                                        if (zzfnVar.zze()) {
                                                            zzfnVar.zzb(10);
                                                        }
                                                        i40++;
                                                        zZze = z5;
                                                        i38 = i3;
                                                    }
                                                }
                                            } else {
                                                zzfnVar.zzb(i37 * 8);
                                            }
                                        }
                                    }
                                } else if (i32 > i31) {
                                    i32--;
                                }
                                zzffVar = null;
                                break;
                            }
                            if (zzffVar == null || zzfjVarZze == null) {
                                i5 = 0;
                            } else {
                                i5 = 0;
                                if (zzffVar.zza == ((zzez) zzfjVarZze.zza.get(0)).zzb) {
                                    i6 = i27;
                                    i23 = 4;
                                } else {
                                    i23 = 5;
                                }
                            }
                            i6 = i27;
                        } else {
                            i5 = 0;
                            i6 = i27;
                        }
                    } else if (i27 == 0) {
                        zzfg zzfgVarZzf = zzfm.zzf(bArr, i28, i28 + iZzt4, zzfjVarZze);
                        int i41 = zzfgVarZzf.zza + 1;
                        int i42 = zzfgVarZzf.zze;
                        int i43 = zzfgVarZzf.zzf;
                        int i44 = zzfgVarZzf.zzg;
                        i2 = i28;
                        int i45 = zzfgVarZzf.zzh;
                        int i46 = zzfgVarZzf.zzc + 8;
                        int i47 = zzfgVarZzf.zzd + 8;
                        int i48 = zzfgVarZzf.zzk;
                        int i49 = zzfgVarZzf.zzl;
                        int i50 = zzfgVarZzf.zzm;
                        float f2 = zzfgVarZzf.zzi;
                        int i51 = zzfgVarZzf.zzj;
                        zzfb zzfbVar = zzfgVarZzf.zzb;
                        if (zzfbVar != null) {
                            strZzb = zzdd.zzb(zzfbVar.zza, zzfbVar.zzb, zzfbVar.zzc, zzfbVar.zzd, zzfbVar.zze, zzfbVar.zzf);
                        }
                        i22 = i50;
                        f = f2;
                        i24 = i51;
                        i6 = i27;
                        i19 = i47;
                        i20 = i48;
                        i21 = i49;
                        i16 = i44;
                        i17 = i45;
                        i18 = i46;
                        i5 = 0;
                        i14 = i42;
                        i15 = i43;
                        i13 = i41;
                    } else {
                        i2 = i28;
                        i5 = 0;
                        i6 = i27;
                    }
                    i12 = i2 + iZzt4;
                    zzegVar.zzk(iZzt4);
                    i26 = i6 + 1;
                    i8 = i5;
                    iZzs = i;
                    i7 = 4;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    e = e3;
                    z3 = z2;
                    if (z3 != z) {
                        str = "HEVC config";
                    } else {
                        str = "L-HEVC config";
                    }
                    throw zzat.zzb("Error parsing".concat(str), e);
                }
            }
            i25++;
            zzfjVar2 = zzfjVarZze;
            z4 = z2;
            iZzs = iZzs;
            i7 = 4;
        }
        z2 = z4;
        return new zzadt(i9 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iZzs + 1, i13, i14, i15, i16, i17, i18, i19, i20, i21, i22, i23, f, i24, strZzb, zzfjVar2);
    }
}
