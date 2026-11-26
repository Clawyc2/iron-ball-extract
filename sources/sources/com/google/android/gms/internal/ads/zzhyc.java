package com.google.android.gms.internal.ads;

import androidx.core.text.HtmlCompat;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhyc<T> implements zzhyr<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhzj.zzt();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhxz zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhzc zzm;
    private final zzhvz zzn;

    private zzhyc(int[] iArr, Object[] objArr, int i, int i2, zzhxz zzhxzVar, boolean z, int[] iArr2, int i3, int i4, zzhyf zzhyfVar, zzhxl zzhxlVar, zzhzc zzhzcVar, zzhvz zzhvzVar, zzhxu zzhxuVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhxzVar instanceof zzhwo;
        boolean z2 = false;
        if (zzhvzVar != null && (zzhxzVar instanceof zzhwk)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzhzcVar;
        this.zzn = zzhvzVar;
        this.zzg = zzhxzVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzD(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean zzE(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzhwo) {
            return ((zzhwo) obj).zzaX();
        }
        return true;
    }

    private static void zzF(Object obj) {
        if (zzE(obj)) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
    }

    private static double zzG(Object obj, long j) {
        return ((Double) zzhzj.zzn(obj, j)).doubleValue();
    }

    private static float zzH(Object obj, long j) {
        return ((Float) zzhzj.zzn(obj, j)).floatValue();
    }

    private static int zzI(Object obj, long j) {
        return ((Integer) zzhzj.zzn(obj, j)).intValue();
    }

    private static long zzJ(Object obj, long j) {
        return ((Long) zzhzj.zzn(obj, j)).longValue();
    }

    private static boolean zzK(Object obj, long j) {
        return ((Boolean) zzhzj.zzn(obj, j)).booleanValue();
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private final boolean zzM(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzN(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return (zzhzj.zzd(obj, j) & (1 << (iZzB >>> 20))) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch (zzC(iZzA)) {
            case 0:
                return Double.doubleToRawLongBits(zzhzj.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhzj.zzj(obj, j2)) != 0;
            case 2:
                return zzhzj.zzf(obj, j2) != 0;
            case 3:
                return zzhzj.zzf(obj, j2) != 0;
            case 4:
                return zzhzj.zzd(obj, j2) != 0;
            case 5:
                return zzhzj.zzf(obj, j2) != 0;
            case 6:
                return zzhzj.zzd(obj, j2) != 0;
            case 7:
                return zzhzj.zzh(obj, j2);
            case 8:
                Object objZzn = zzhzj.zzn(obj, j2);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzhvi) {
                    return !zzhvi.zzb.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhzj.zzn(obj, j2) != null;
            case 10:
                return !zzhvi.zzb.equals(zzhzj.zzn(obj, j2));
            case 11:
                return zzhzj.zzd(obj, j2) != 0;
            case 12:
                return zzhzj.zzd(obj, j2) != 0;
            case 13:
                return zzhzj.zzd(obj, j2) != 0;
            case 14:
                return zzhzj.zzf(obj, j2) != 0;
            case 15:
                return zzhzj.zzd(obj, j2) != 0;
            case 16:
                return zzhzj.zzf(obj, j2) != 0;
            case 17:
                return zzhzj.zzn(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzO(Object obj, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zzhzj.zze(obj, j, (1 << (iZzB >>> 20)) | zzhzj.zzd(obj, j));
    }

    private final boolean zzP(Object obj, int i, int i2) {
        return zzhzj.zzd(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final void zzQ(Object obj, int i, int i2) {
        zzhzj.zze(obj, zzB(i2) & 1048575, i);
    }

    private final int zzR(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzS(i, 0);
    }

    private final int zzS(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static final int zzT(byte[] bArr, int i, int i2, zzhzp zzhzpVar, Class cls, zzhuw zzhuwVar) throws IOException {
        zzhzp zzhzpVar2 = zzhzp.DOUBLE;
        switch (zzhzpVar) {
            case DOUBLE:
                int i3 = i + 8;
                zzhuwVar.zzc = Double.valueOf(Double.longBitsToDouble(zzhux.zze(bArr, i)));
                return i3;
            case FLOAT:
                int i4 = i + 4;
                zzhuwVar.zzc = Float.valueOf(Float.intBitsToFloat(zzhux.zzd(bArr, i)));
                return i4;
            case INT64:
            case UINT64:
                int iZzc = zzhux.zzc(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Long.valueOf(zzhuwVar.zzb);
                return iZzc;
            case INT32:
            case UINT32:
            case ENUM:
                int iZza = zzhux.zza(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Integer.valueOf(zzhuwVar.zza);
                return iZza;
            case FIXED64:
            case SFIXED64:
                int i5 = i + 8;
                zzhuwVar.zzc = Long.valueOf(zzhux.zze(bArr, i));
                return i5;
            case FIXED32:
            case SFIXED32:
                int i6 = i + 4;
                zzhuwVar.zzc = Integer.valueOf(zzhux.zzd(bArr, i));
                return i6;
            case BOOL:
                int iZzc2 = zzhux.zzc(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Boolean.valueOf(zzhuwVar.zzb != 0);
                return iZzc2;
            case STRING:
                return zzhux.zzf(bArr, i, zzhuwVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzhux.zzh(zzhyj.zza().zzb(cls), bArr, i, i2, zzhuwVar);
            case BYTES:
                return zzhux.zzg(bArr, i, zzhuwVar);
            case SINT32:
                int iZza2 = zzhux.zza(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Integer.valueOf(zzhvn.zzK(zzhuwVar.zza));
                return iZza2;
            case SINT64:
                int iZzc3 = zzhux.zzc(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Long.valueOf(zzhvn.zzL(zzhuwVar.zzb));
                return iZzc3;
        }
    }

    private static final void zzU(int i, Object obj, zzhzr zzhzrVar) throws IOException {
        if (obj instanceof String) {
            zzhzrVar.zzm(i, (String) obj);
        } else {
            zzhzrVar.zzn(i, (zzhvi) obj);
        }
    }

    static zzhzd zzh(Object obj) {
        zzhwo zzhwoVar = (zzhwo) obj;
        zzhzd zzhzdVar = zzhwoVar.zzt;
        if (zzhzdVar != zzhzd.zza()) {
            return zzhzdVar;
        }
        zzhzd zzhzdVarZzb = zzhzd.zzb();
        zzhwoVar.zzt = zzhzdVarZzb;
        return zzhzdVarZzb;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:130:0x028a  */
    /* JADX WARN: Code duplicated, block: B:131:0x028d  */
    /* JADX WARN: Code duplicated, block: B:170:0x034e  */
    /* JADX WARN: Code duplicated, block: B:185:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ad  */
    static zzhyc zzm(Class cls, zzhxw zzhxwVar, zzhyf zzhyfVar, zzhxl zzhxlVar, zzhzc zzhzcVar, zzhvz zzhvzVar, zzhxu zzhxuVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        char c;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzn;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZzn2;
        int i27;
        Object obj2;
        Field fieldZzn3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zzhxwVar instanceof zzhyl)) {
            throw null;
        }
        zzhyl zzhylVar = (zzhyl) zzhxwVar;
        String strZzd = zzhylVar.zzd();
        int length = strZzd.length();
        char c2 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (strZzd.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = strZzd.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = strZzd.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = strZzd.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = strZzd.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strZzd.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = strZzd.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strZzd.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = strZzd.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strZzd.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = strZzd.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strZzd.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = strZzd.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strZzd.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = strZzd.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = strZzd.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = strZzd.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    cCharAt = strZzd.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int i60 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt6;
            i5 = iCharAt9;
            i6 = i60;
            iArr = iArr2;
            i7 = iCharAt3;
            i33 = i57;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzhylVar.zze();
        Class<?> cls2 = zzhylVar.zzb().getClass();
        int i62 = i5 + i3;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i5;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i33 < length) {
            int i68 = i33 + 1;
            int iCharAt10 = strZzd.charAt(i33);
            if (iCharAt10 >= c2) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i30 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i30;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i16 = i30;
            } else {
                i16 = i68;
            }
            int i72 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c2) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i29 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i29;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i17 = i29;
            } else {
                i17 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            zzhyl zzhylVar2 = zzhylVar;
            int i77 = iCharAt11 & 2048;
            if (i76 >= 51) {
                int i78 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                char c3 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i28 = i80 + 1;
                        cCharAt10 = strZzd.charAt(i80);
                        if (cCharAt10 < c3) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i28;
                        c3 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i81);
                    i23 = i28;
                } else {
                    i23 = i78;
                }
                int i82 = i23;
                int i83 = i76 - 51;
                if (i83 == 9 || i83 == 17) {
                    i24 = i6 + 1;
                    int i84 = i67 / 3;
                    objArr[i84 + i84 + 1] = objArrZze[i6];
                } else {
                    if (i83 != 12) {
                        i25 = i77;
                    } else if (zzhylVar2.zzc() == 1 || i77 != 0) {
                        i24 = i6 + 1;
                        int i85 = i67 / 3;
                        objArr[i85 + i85 + 1] = objArrZze[i6];
                    } else {
                        i25 = 0;
                    }
                    i26 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i26];
                    int i86 = i25;
                    if (obj instanceof Field) {
                        fieldZzn2 = (Field) obj;
                    } else {
                        fieldZzn2 = zzn(cls2, (String) obj);
                        objArrZze[i26] = fieldZzn2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZzn3 = (Field) obj2;
                    } else {
                        fieldZzn3 = zzn(cls2, (String) obj2);
                        objArrZze[i27] = fieldZzn3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                    strZzd = strZzd;
                    i20 = i86;
                    i17 = i82;
                    i19 = 0;
                    c = 55296;
                }
                i6 = i24;
                i25 = i77;
                i26 = iCharAt12 + iCharAt12;
                obj = objArrZze[i26];
                int i88 = i25;
                if (obj instanceof Field) {
                    fieldZzn2 = (Field) obj;
                } else {
                    fieldZzn2 = zzn(cls2, (String) obj);
                    objArrZze[i26] = fieldZzn2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn2);
                i27 = i26 + 1;
                obj2 = objArrZze[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZzn3 = (Field) obj2;
                } else {
                    fieldZzn3 = zzn(cls2, (String) obj2);
                    objArrZze[i27] = fieldZzn3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                strZzd = strZzd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZzn4 = zzn(cls2, (String) objArrZze[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZzn4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zzhylVar2.zzc() == 1 || i77 != 0) {
                                i6 += 2;
                                int i92 = i67 / 3;
                                objArr[i92 + i92 + 1] = objArrZze[i90];
                            } else {
                                i6 = i90;
                                i77 = 0;
                            }
                        } else if (i76 == 50) {
                            int i93 = i6 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i67;
                            int i95 = i67 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrZze[i90];
                            if (i77 != 0) {
                                objArr[i96 + 1] = objArrZze[i93];
                                i6 += 3;
                                i64 = i94;
                            } else {
                                i6 = i93;
                                i64 = i94;
                                i77 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            c = 55296;
                            iObjectFieldOffset2 = 1048575;
                            i19 = 0;
                        } else {
                            int i97 = i17 + 1;
                            int iCharAt13 = strZzd.charAt(i17);
                            if (iCharAt13 >= 55296) {
                                int i98 = iCharAt13 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i21 = i97 + 1;
                                    cCharAt9 = strZzd.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i21;
                                }
                                iCharAt13 = i98 | (cCharAt9 << i99);
                            } else {
                                i21 = i97;
                            }
                            int i100 = i18 + i18 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i100];
                            if (obj3 instanceof Field) {
                                fieldZzn = (Field) obj3;
                            } else {
                                fieldZzn = zzn(cls2, (String) obj3);
                                objArrZze[i100] = fieldZzn;
                            }
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzn);
                            i19 = iCharAt13 % 32;
                            i17 = i21;
                            c = 55296;
                            iObjectFieldOffset2 = iObjectFieldOffset3;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i77;
                    } else {
                        i22 = 1;
                        i6 += 2;
                    }
                    int i101 = i67 / 3;
                    objArr[i101 + i101 + i22] = objArrZze[i90];
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                    if ((iCharAt11 & 4096) != 0) {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    } else {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i20 = i77;
                }
                i6 = i90;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                if ((iCharAt11 & 4096) != 0) {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                } else {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i20 = i77;
            }
            int i102 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i103 = i67 + 2;
            iArr3[i102] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i76 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr3[i103] = (i19 << 20) | iObjectFieldOffset2;
            i33 = i17;
            strZzd = strZzd;
            c2 = c;
            zzhylVar = zzhylVar2;
            length = length;
            i7 = i18;
        }
        return new zzhyc(iArr3, objArr, i2, i4, zzhylVar.zzb(), false, iArr, i5, i62, zzhyfVar, zzhxlVar, zzhzcVar, zzhvzVar, zzhxuVar);
    }

    private static Field zzn(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzhyr zzhyrVarZzq = zzq(i);
            if (!zzN(obj, i)) {
                if (zzE(object)) {
                    Object objZza = zzhyrVarZzq.zza();
                    zzhyrVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzO(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzhyrVarZzq.zza();
                zzhyrVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzhyrVarZzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzP(obj2, i2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzhyr zzhyrVarZzq = zzq(i);
            if (!zzP(obj, i2, i)) {
                if (zzE(object)) {
                    Object objZza = zzhyrVarZzq.zza();
                    zzhyrVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzQ(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzhyrVarZzq.zza();
                zzhyrVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzhyrVarZzq.zzd(object2, object);
        }
    }

    private final zzhyr zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhyr zzhyrVar = (zzhyr) objArr[i3];
        if (zzhyrVar != null) {
            return zzhyrVar;
        }
        zzhyr zzhyrVarZzb = zzhyj.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzhyrVarZzb;
        return zzhyrVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzhwu zzs(int i) {
        int i2 = i / 3;
        return (zzhwu) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzhyr zzhyrVarZzq = zzq(i);
        int iZzA = zzA(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzhyrVarZzq.zza();
        }
        Object object = zzb.getObject(obj, iZzA);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzhyrVarZzq.zza();
        if (object != null) {
            zzhyrVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzO(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzhyr zzhyrVarZzq = zzq(i2);
        if (!zzP(obj, i, i2)) {
            return zzhyrVarZzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzhyrVarZzq.zza();
        if (object != null) {
            zzhyrVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzQ(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzhzc zzhzcVar, Object obj3) {
        zzhwu zzhwuVarZzs;
        int i2 = this.zzc[i];
        Object objZzn = zzhzj.zzn(obj, zzA(i) & 1048575);
        if (objZzn == null || (zzhwuVarZzs = zzs(i)) == null) {
            return obj2;
        }
        zzhxr zzhxrVarZze = ((zzhxs) zzr(i)).zze();
        Iterator it = ((zzhxt) objZzn).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzhwuVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzhzcVar.zzh(obj3);
                }
                int iZzc = zzhxs.zzc(zzhxrVarZze, entry.getKey(), entry.getValue());
                zzhvi zzhviVar = zzhvi.zzb;
                byte[] bArr = new byte[iZzc];
                int i3 = zzhvt.zzf;
                zzhvq zzhvqVar = new zzhvq(bArr, 0, iZzc);
                try {
                    zzhxs.zzb(zzhvqVar, zzhxrVarZze, entry.getKey(), entry.getValue());
                    zzhzcVar.zzd(obj2, i2, zzhve.zza(zzhvqVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzhyr zzhyrVar) {
        return zzhyrVar.zzl(zzhzj.zzn(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzhym zzhymVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zzhzj.zzo(obj, j, zzhymVar.zzn());
        } else if (this.zzi) {
            zzhzj.zzo(obj, j, zzhymVar.zzm());
        } else {
            zzhzj.zzo(obj, j, zzhymVar.zzq());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final Object zza() {
        return ((zzhwo) this.zzg).zzbg();
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzG;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzA = zzA(i);
            long j = iZzA & 1048575;
            switch (zzC(iZzA)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzhzj.zzl(obj, j)) != Double.doubleToLongBits(zzhzj.zzl(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzhzj.zzj(obj, j)) != Float.floatToIntBits(zzhzj.zzj(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzhzj.zzh(obj, j) != zzhzj.zzh(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                case 34:
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    zZzG = zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j));
                    break;
                case 50:
                    zZzG = zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzB = zzB(i) & 1048575;
                    if (zzhzj.zzd(obj, jZzB) != zzhzj.zzd(obj2, jZzB) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzG) {
                return false;
            }
        }
        if (!((zzhwo) obj).zzt.equals(((zzhwo) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzhwk) obj).zza.equals(((zzhwk) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzhwo) obj).zzt.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzhwk) obj).zza.zza.hashCode() : iHashCode;
            }
            int iZzA = zzA(i3);
            int i5 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzC) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhzj.zzl(obj, j));
                    byte[] bArr = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhzj.zzj(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr2 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr3 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr4 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzhxb.zzb(zzhzj.zzh(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzhzj.zzn(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzn = zzhzj.zzn(obj, j);
                    if (objZzn != null) {
                        iHashCode2 = objZzn.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr5 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr6 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzn2 = zzhzj.zzn(obj, j);
                    if (objZzn2 != null) {
                        iHashCode2 = objZzn2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                case 34:
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzG(obj, j));
                        byte[] bArr7 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzH(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr8 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr9 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr10 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhxb.zzb(zzK(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzhzj.zzn(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr11 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr12 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzhyt.zzI(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzhyt.zzH(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzA = zzA(i);
            int i2 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzC) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzhzj.zzm(obj, j, zzhzj.zzl(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzhzj.zzk(obj, j, zzhzj.zzj(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzhzj.zzi(obj, j, zzhzj.zzh(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 9:
                    zzo(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 17:
                    zzo(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                case 34:
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                case 36:
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    zzhxa zzhxaVarZzh = (zzhxa) zzhzj.zzn(obj, j);
                    zzhxa zzhxaVar = (zzhxa) zzhzj.zzn(obj2, j);
                    int size = zzhxaVarZzh.size();
                    int size2 = zzhxaVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzhxaVarZzh.zza()) {
                            zzhxaVarZzh = zzhxaVarZzh.zzh(size2 + size);
                        }
                        zzhxaVarZzh.addAll(zzhxaVar);
                    }
                    if (size > 0) {
                        zzhxaVar = zzhxaVarZzh;
                    }
                    zzhzj.zzo(obj, j, zzhxaVar);
                    break;
                case 50:
                    int i4 = zzhyt.zza;
                    zzhzj.zzo(obj, j, zzhxu.zzb(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzP(obj2, i3, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzQ(obj, i3, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzp(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzP(obj2, i3, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzQ(obj, i3, i);
                    }
                    break;
                case 68:
                    zzp(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x038c  */
    /* JADX WARN: Code duplicated, block: B:211:0x0550  */
    @Override // com.google.android.gms.internal.ads.zzhyr
    public final int zze(Object obj) {
        int i;
        int iZzA;
        int iZzA2;
        int iZzB;
        int iZzA3;
        int iZzA4;
        int iZzA5;
        int iZzc;
        int iZzA6;
        int iZzD;
        int iZzs;
        int size;
        int iZzt;
        int iZzA7;
        int iZzA8;
        int iZzaT;
        int iZzA9;
        int iZzA10;
        int iZzB2;
        int iZzB3;
        int iZzA11;
        int iZzA12;
        int iZzE;
        int iZzA13;
        int iZzA14;
        int iZzA15;
        int iZzc2;
        int iZzA16;
        zzhyc<T> zzhycVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzA17 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzhycVar.zzc;
            if (i2 >= iArr.length) {
                int iZzi = iZzA17 + ((zzhwo) obj).zzt.zzi();
                if (!zzhycVar.zzh) {
                    return iZzi;
                }
                zzhyy zzhyyVar = ((zzhwk) obj).zza.zza;
                int iZzc3 = zzhyyVar.zzc();
                int iZzj = 0;
                for (int i5 = 0; i5 < iZzc3; i5++) {
                    Map.Entry entryZzd = zzhyyVar.zzd(i5);
                    iZzj += zzhwd.zzj((zzhwc) ((zzhyv) entryZzd).zza(), entryZzd.getValue());
                }
                for (Map.Entry entry : zzhyyVar.zze()) {
                    iZzj += zzhwd.zzj((zzhwc) entry.getKey(), entry.getValue());
                }
                return iZzi + iZzj;
            }
            int iZzA18 = zzhycVar.zzA(i2);
            int iZzC = zzC(iZzA18);
            int i6 = iArr[i2];
            int i7 = iArr[i2 + 2];
            int i8 = i7 & 1048575;
            if (iZzC <= 17) {
                if (i8 != i4) {
                    i3 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzA18 & 1048575;
            if (iZzC >= zzhwe.DOUBLE_LIST_PACKED.zza()) {
                zzhwe.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzC) {
                case 0:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA17 += zzhvt.zzA(i6 << 3) + 8;
                    }
                    break;
                case 1:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA = zzhvt.zzA(i6 << 3);
                        iZzA4 = iZzA + 4;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 2:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzB(j2);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 3:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzB(j3);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 4:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzB(j4);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 5:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA3 = zzhvt.zzA(i6 << 3);
                        iZzA4 = iZzA3 + 8;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 6:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA = zzhvt.zzA(i6 << 3);
                        iZzA4 = iZzA + 4;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 7:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA4 = zzhvt.zzA(i6 << 3) + 1;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 8:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzhvi) {
                            iZzA5 = zzhvt.zzA(i10);
                            iZzc = ((zzhvi) object).zzc();
                            iZzA6 = zzhvt.zzA(iZzc);
                            iZzA4 = iZzA5 + iZzA6 + iZzc;
                            iZzA17 += iZzA4;
                        } else {
                            iZzA2 = zzhvt.zzA(i10);
                            iZzB = zzhvt.zzC((String) object);
                            iZzA4 = iZzA2 + iZzB;
                            iZzA17 += iZzA4;
                        }
                    }
                    zzhycVar = this;
                    break;
                case 9:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzD = zzhyt.zzD(i6, unsafe.getObject(obj, j), zzhycVar.zzq(i2));
                        iZzA17 += iZzD;
                    }
                    break;
                case 10:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        zzhvi zzhviVar = (zzhvi) unsafe.getObject(obj, j);
                        iZzA5 = zzhvt.zzA(i6 << 3);
                        iZzc = zzhviVar.zzc();
                        iZzA6 = zzhvt.zzA(iZzc);
                        iZzA4 = iZzA5 + iZzA6 + iZzc;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 11:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzA(i11);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 12:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzB(j5);
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 13:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA = zzhvt.zzA(i6 << 3);
                        iZzA4 = iZzA + 4;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 14:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzA3 = zzhvt.zzA(i6 << 3);
                        iZzA4 = iZzA3 + 8;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 15:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzA((i12 >> 31) ^ (i12 + i12));
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 16:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzA2 = zzhvt.zzA(i6 << 3);
                        iZzB = zzhvt.zzB((j6 >> 63) ^ (j6 + j6));
                        iZzA4 = iZzA2 + iZzB;
                        iZzA17 += iZzA4;
                    }
                    zzhycVar = this;
                    break;
                case 17:
                    if (zzhycVar.zzM(obj, i2, i4, i3, i)) {
                        iZzD = zzhyt.zzE(i6, (zzhxz) unsafe.getObject(obj, j), zzhycVar.zzq(i2));
                        iZzA17 += iZzD;
                    }
                    break;
                case 18:
                    iZzD = zzhyt.zzC(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA17 += iZzD;
                    break;
                case 19:
                    iZzD = zzhyt.zzA(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA17 += iZzD;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzhyt.zza;
                    if (list.size() == 0) {
                        iZzs = 0;
                    } else {
                        iZzs = zzhyt.zzs(list) + (list.size() * zzhvt.zzA(i6 << 3));
                    }
                    iZzA17 += iZzs;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzhyt.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzhyt.zzt(list2);
                        iZzA7 = zzhvt.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzD = iZzt + iZzB2;
                    }
                    iZzA17 += iZzD;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzhyt.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzhyt.zzw(list3);
                        iZzA7 = zzhvt.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzD = iZzt + iZzB2;
                    }
                    iZzA17 += iZzD;
                    break;
                case 23:
                    iZzD = zzhyt.zzC(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA17 += iZzD;
                    break;
                case 24:
                    iZzD = zzhyt.zzA(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA17 += iZzD;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzhyt.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzD = 0;
                    } else {
                        iZzD = size2 * (zzhvt.zzA(i6 << 3) + 1);
                    }
                    iZzA17 += iZzD;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i17 = zzhyt.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzs = 0;
                    } else {
                        iZzs = zzhvt.zzA(i6 << 3) * size3;
                        if (list5 instanceof zzhxk) {
                            zzhxk zzhxkVar = (zzhxk) list5;
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object objZzc = zzhxkVar.zzc();
                                if (objZzc instanceof zzhvi) {
                                    int iZzc4 = ((zzhvi) objZzc).zzc();
                                    iZzs += zzhvt.zzA(iZzc4) + iZzc4;
                                } else {
                                    iZzs += zzhvt.zzC((String) objZzc);
                                }
                            }
                        } else {
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object obj2 = list5.get(i19);
                                if (obj2 instanceof zzhvi) {
                                    int iZzc5 = ((zzhvi) obj2).zzc();
                                    iZzs += zzhvt.zzA(iZzc5) + iZzc5;
                                } else {
                                    iZzs += zzhvt.zzC((String) obj2);
                                }
                            }
                        }
                    }
                    iZzA17 += iZzs;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzhyr zzhyrVarZzq = zzhycVar.zzq(i2);
                    int i20 = zzhyt.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzA8 = 0;
                    } else {
                        iZzA8 = zzhvt.zzA(i6 << 3) * size4;
                        for (int i21 = 0; i21 < size4; i21++) {
                            Object obj3 = list6.get(i21);
                            if (obj3 instanceof zzhxj) {
                                iZzaT = ((zzhxj) obj3).zzb();
                                iZzA9 = zzhvt.zzA(iZzaT);
                            } else {
                                iZzaT = ((zzhur) obj3).zzaT(zzhyrVarZzq);
                                iZzA9 = zzhvt.zzA(iZzaT);
                            }
                            iZzA8 += iZzA9 + iZzaT;
                        }
                    }
                    iZzA17 += iZzA8;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzhyt.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzA10 = 0;
                    } else {
                        iZzA10 = size5 * zzhvt.zzA(i6 << 3);
                        for (int i23 = 0; i23 < list7.size(); i23++) {
                            int iZzc6 = ((zzhvi) list7.get(i23)).zzc();
                            iZzA10 += zzhvt.zzA(iZzc6) + iZzc6;
                        }
                    }
                    iZzA17 += iZzA10;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzhyt.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzhyt.zzx(list8);
                        iZzA7 = zzhvt.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzD = iZzt + iZzB2;
                    }
                    iZzA17 += iZzD;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzhyt.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzhyt.zzv(list9);
                        iZzA7 = zzhvt.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzD = iZzt + iZzB2;
                    }
                    iZzA17 += iZzD;
                    break;
                case 31:
                    iZzD = zzhyt.zzA(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA17 += iZzD;
                    break;
                case 32:
                    iZzD = zzhyt.zzC(i6, (List) unsafe.getObject(obj, j), false);
                    iZzA17 += iZzD;
                    break;
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i26 = zzhyt.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzhyt.zzy(list10);
                        iZzA7 = zzhvt.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzD = iZzt + iZzB2;
                    }
                    iZzA17 += iZzD;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i27 = zzhyt.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzhyt.zzu(list11);
                        iZzA7 = zzhvt.zzA(i6 << 3);
                        iZzB2 = size * iZzA7;
                        iZzD = iZzt + iZzB2;
                    }
                    iZzA17 += iZzD;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZzB3 = zzhyt.zzB((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case 36:
                    iZzB3 = zzhyt.zzz((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZzB3 = zzhyt.zzs((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZzB3 = zzhyt.zzt((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZzB3 = zzhyt.zzw((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZzB3 = zzhyt.zzB((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZzB3 = zzhyt.zzz((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i28 = zzhyt.zza;
                    iZzB3 = list12.size();
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZzB3 = zzhyt.zzx((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZzB3 = zzhyt.zzv((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZzB3 = zzhyt.zzz((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZzB3 = zzhyt.zzB((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZzB3 = zzhyt.zzy((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case 48:
                    iZzB3 = zzhyt.zzu((List) unsafe.getObject(obj, j));
                    if (iZzB3 > 0) {
                        iZzA11 = zzhvt.zzA(i6 << 3);
                        iZzA12 = zzhvt.zzA(iZzB3);
                        iZzA10 = iZzA11 + iZzA12 + iZzB3;
                        iZzA17 += iZzA10;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzhyr zzhyrVarZzq2 = zzhycVar.zzq(i2);
                    int i29 = zzhyt.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzE = 0;
                    } else {
                        iZzE = 0;
                        for (int i30 = 0; i30 < size6; i30++) {
                            iZzE += zzhyt.zzE(i6, (zzhxz) list13.get(i30), zzhyrVarZzq2);
                        }
                    }
                    iZzA17 += iZzE;
                    break;
                case 50:
                    zzhxt zzhxtVar = (zzhxt) unsafe.getObject(obj, j);
                    zzhxs zzhxsVar = (zzhxs) zzhycVar.zzr(i2);
                    if (zzhxtVar.isEmpty()) {
                        iZzs = 0;
                    } else {
                        iZzs = 0;
                        for (Map.Entry entry2 : zzhxtVar.entrySet()) {
                            iZzs += zzhxsVar.zzd(i6, entry2.getKey(), entry2.getValue());
                        }
                    }
                    iZzA17 += iZzs;
                    break;
                case 51:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzA13 = zzhvt.zzA(i6 << 3);
                        iZzD = iZzA13 + 8;
                        iZzA17 += iZzD;
                    }
                    break;
                case 52:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzA14 = zzhvt.zzA(i6 << 3);
                        iZzD = iZzA14 + 4;
                        iZzA17 += iZzD;
                    }
                    break;
                case 53:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        long jZzJ = zzJ(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzB(jZzJ);
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 54:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        long jZzJ2 = zzJ(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzB(jZzJ2);
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 55:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        long jZzI = zzI(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzB(jZzI);
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 56:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzA13 = zzhvt.zzA(i6 << 3);
                        iZzD = iZzA13 + 8;
                        iZzA17 += iZzD;
                    }
                    break;
                case 57:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzA14 = zzhvt.zzA(i6 << 3);
                        iZzD = iZzA14 + 4;
                        iZzA17 += iZzD;
                    }
                    break;
                case 58:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzD = zzhvt.zzA(i6 << 3) + 1;
                        iZzA17 += iZzD;
                    }
                    break;
                case 59:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        int i31 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzhvi) {
                            iZzA15 = zzhvt.zzA(i31);
                            iZzc2 = ((zzhvi) object2).zzc();
                            iZzA16 = zzhvt.zzA(iZzc2);
                            iZzD = iZzA15 + iZzA16 + iZzc2;
                            iZzA17 += iZzD;
                        } else {
                            iZzt = zzhvt.zzA(i31);
                            iZzB2 = zzhvt.zzC((String) object2);
                            iZzD = iZzt + iZzB2;
                            iZzA17 += iZzD;
                        }
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzD = zzhyt.zzD(i6, unsafe.getObject(obj, j), zzhycVar.zzq(i2));
                        iZzA17 += iZzD;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        zzhvi zzhviVar2 = (zzhvi) unsafe.getObject(obj, j);
                        iZzA15 = zzhvt.zzA(i6 << 3);
                        iZzc2 = zzhviVar2.zzc();
                        iZzA16 = zzhvt.zzA(iZzc2);
                        iZzD = iZzA15 + iZzA16 + iZzc2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 62:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        int iZzI = zzI(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzA(iZzI);
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        long jZzI2 = zzI(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzB(jZzI2);
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 64:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzA14 = zzhvt.zzA(i6 << 3);
                        iZzD = iZzA14 + 4;
                        iZzA17 += iZzD;
                    }
                    break;
                case 65:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzA13 = zzhvt.zzA(i6 << 3);
                        iZzD = iZzA13 + 8;
                        iZzA17 += iZzD;
                    }
                    break;
                case 66:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        int iZzI2 = zzI(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzA((iZzI2 >> 31) ^ (iZzI2 + iZzI2));
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 67:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        long jZzJ3 = zzJ(obj, j);
                        iZzt = zzhvt.zzA(i6 << 3);
                        iZzB2 = zzhvt.zzB((jZzJ3 >> 63) ^ (jZzJ3 + jZzJ3));
                        iZzD = iZzt + iZzB2;
                        iZzA17 += iZzD;
                    }
                    break;
                case 68:
                    if (zzhycVar.zzP(obj, i6, i2)) {
                        iZzD = zzhyt.zzE(i6, (zzhxz) unsafe.getObject(obj, j), zzhycVar.zzq(i2));
                        iZzA17 += iZzD;
                    }
                    break;
            }
            i2 += 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzf(Object obj, zzhzr zzhzrVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        boolean z;
        int i;
        int i2;
        int i3;
        zzhyc<T> zzhycVar = this;
        if (zzhycVar.zzh) {
            zzhwd zzhwdVar = ((zzhwk) obj).zza;
            if (zzhwdVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzc = zzhwdVar.zzc();
                entry = (Map.Entry) itZzc.next();
                it = itZzc;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = zzhycVar.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr.length) {
            int iZzA = zzhycVar.zzA(i6);
            int iZzC = zzC(iZzA);
            int i8 = iArr[i6];
            if (iZzC <= 17) {
                int i9 = iArr[i6 + 2];
                z = true;
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i7;
                i3 = 1 << (i9 >>> 20);
            } else {
                z = true;
                i = i5;
                i2 = i7;
                i3 = 0;
            }
            while (true) {
                if (entry != null) {
                    zzhvz zzhvzVar = zzhycVar.zzn;
                    i4 = i4;
                    if (((zzhwl) entry.getKey()).zza <= i8) {
                        zzhvzVar.zzb(zzhzrVar, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                } else {
                    i4 = i4;
                }
            }
            long j = iZzA & i4;
            switch (iZzC) {
                case 0:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzf(i8, zzhzj.zzl(obj, j));
                    }
                    break;
                case 1:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zze(i8, zzhzj.zzj(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 2:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzc(i8, unsafe.getLong(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 3:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzh(i8, unsafe.getLong(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 4:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 5:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzj(i8, unsafe.getLong(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 6:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 7:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzl(i8, zzhzj.zzh(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 8:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzU(i8, unsafe.getObject(obj, j), zzhzrVar);
                    }
                    zzhycVar = this;
                    break;
                case 9:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzr(i8, unsafe.getObject(obj, j), zzhycVar.zzq(i6));
                    }
                    break;
                case 10:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzn(i8, (zzhvi) unsafe.getObject(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 11:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzo(i8, unsafe.getInt(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 12:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzg(i8, unsafe.getInt(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 13:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzb(i8, unsafe.getInt(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 14:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzd(i8, unsafe.getLong(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 15:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzp(i8, unsafe.getInt(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 16:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzq(i8, unsafe.getLong(obj, j));
                    }
                    zzhycVar = this;
                    break;
                case 17:
                    if (zzhycVar.zzM(obj, i6, i, i2, i3)) {
                        zzhzrVar.zzs(i8, unsafe.getObject(obj, j), zzhycVar.zzq(i6));
                    }
                    break;
                case 18:
                    zzhyt.zza(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 19:
                    zzhyt.zzb(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 20:
                    zzhyt.zzc(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 21:
                    zzhyt.zzd(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 22:
                    zzhyt.zzh(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 23:
                    zzhyt.zzf(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 24:
                    zzhyt.zzk(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 25:
                    zzhyt.zzn(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 26:
                    zzhyt.zzo(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar);
                    break;
                case 27:
                    zzhyt.zzq(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, zzhycVar.zzq(i6));
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    zzhyt.zzp(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar);
                    break;
                case 29:
                    zzhyt.zzi(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 30:
                    zzhyt.zzm(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 31:
                    zzhyt.zzl(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 32:
                    zzhyt.zzg(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    zzhyt.zzj(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case 34:
                    zzhyt.zze(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    zzhyt.zza(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case 36:
                    zzhyt.zzb(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    zzhyt.zzc(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzhyt.zzd(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    zzhyt.zzh(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    zzhyt.zzf(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    zzhyt.zzk(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzhyt.zzn(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzhyt.zzi(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzhyt.zzm(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzhyt.zzl(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzhyt.zzg(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzhyt.zzj(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case 48:
                    zzhyt.zze(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, z);
                    break;
                case 49:
                    zzhyt.zzr(iArr[i6], (List) unsafe.getObject(obj, j), zzhzrVar, zzhycVar.zzq(i6));
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zzhzrVar.zzM(i8, ((zzhxs) zzhycVar.zzr(i6)).zze(), (zzhxt) object);
                    }
                    break;
                case 51:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzf(i8, zzG(obj, j));
                    }
                    break;
                case 52:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zze(i8, zzH(obj, j));
                    }
                    break;
                case 53:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzc(i8, zzJ(obj, j));
                    }
                    break;
                case 54:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzh(i8, zzJ(obj, j));
                    }
                    break;
                case 55:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzi(i8, zzI(obj, j));
                    }
                    break;
                case 56:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzj(i8, zzJ(obj, j));
                    }
                    break;
                case 57:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzk(i8, zzI(obj, j));
                    }
                    break;
                case 58:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzl(i8, zzK(obj, j));
                    }
                    break;
                case 59:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzU(i8, unsafe.getObject(obj, j), zzhzrVar);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzr(i8, unsafe.getObject(obj, j), zzhycVar.zzq(i6));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzn(i8, (zzhvi) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzo(i8, zzI(obj, j));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzg(i8, zzI(obj, j));
                    }
                    break;
                case 64:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzb(i8, zzI(obj, j));
                    }
                    break;
                case 65:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzd(i8, zzJ(obj, j));
                    }
                    break;
                case 66:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzp(i8, zzI(obj, j));
                    }
                    break;
                case 67:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzq(i8, zzJ(obj, j));
                    }
                    break;
                case 68:
                    if (zzhycVar.zzP(obj, i8, i6)) {
                        zzhzrVar.zzs(i8, unsafe.getObject(obj, j), zzhycVar.zzq(i6));
                    }
                    break;
                default:
                    break;
            }
            i6 += 3;
            i7 = i2;
            i4 = i4;
            i5 = i;
            entry = entry;
        }
        while (entry != null) {
            zzhycVar.zzn.zzb(zzhzrVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        ((zzhwo) obj).zzt.zzg(zzhzrVar);
    }

    /* JADX WARN: Code duplicated, block: B:184:0x0585 A[LOOP:3: B:182:0x0581->B:184:0x0585, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:186:0x0595  */
    /* JADX WARN: Code duplicated, block: B:195:0x05a8 A[LOOP:1: B:193:0x05a4->B:195:0x05a8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:198:0x05ba  */
    /* JADX WARN: Code duplicated, block: B:211:0x0570 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x057e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:310:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzg(Object obj, zzhym zzhymVar, zzhvy zzhvyVar) throws Throwable {
        zzhyc<T> zzhycVar;
        Object obj2;
        Throwable th;
        int i;
        Object objZzx;
        zzhzc zzhzcVar;
        Object objZzx2;
        Object obj3;
        int i2;
        zzhvyVar.getClass();
        zzF(obj);
        zzhzc zzhzcVar2 = this.zzm;
        Object objZzh = null;
        while (true) {
            try {
                int iZzb = zzhymVar.zzb();
                int iZzR = zzR(iZzb);
                if (iZzR >= 0) {
                    obj3 = obj;
                    zzhycVar = this;
                    try {
                        int iZzA = zzA(iZzR);
                        try {
                            switch (zzC(iZzA)) {
                                case 0:
                                    obj2 = obj3;
                                    zzhzj.zzm(obj2, iZzA & 1048575, zzhymVar.zze());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 1:
                                    obj2 = obj3;
                                    zzhzj.zzk(obj2, iZzA & 1048575, zzhymVar.zzf());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 2:
                                    obj2 = obj3;
                                    zzhzj.zzg(obj2, iZzA & 1048575, zzhymVar.zzh());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 3:
                                    obj2 = obj3;
                                    zzhzj.zzg(obj2, iZzA & 1048575, zzhymVar.zzg());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 4:
                                    obj2 = obj3;
                                    zzhzj.zze(obj2, iZzA & 1048575, zzhymVar.zzi());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 5:
                                    obj2 = obj3;
                                    zzhzj.zzg(obj2, iZzA & 1048575, zzhymVar.zzj());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 6:
                                    obj2 = obj3;
                                    zzhzj.zze(obj2, iZzA & 1048575, zzhymVar.zzk());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 7:
                                    obj2 = obj3;
                                    zzhzj.zzi(obj2, iZzA & 1048575, zzhymVar.zzl());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 8:
                                    obj2 = obj3;
                                    zzz(obj2, iZzA, zzhymVar);
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 9:
                                    obj2 = obj3;
                                    zzhxz zzhxzVar = (zzhxz) zzt(obj2, iZzR);
                                    zzhymVar.zzo(zzhxzVar, zzq(iZzR), zzhvyVar);
                                    zzu(obj2, iZzR, zzhxzVar);
                                    obj = obj2;
                                    break;
                                case 10:
                                    obj2 = obj3;
                                    zzhzj.zzo(obj2, iZzA & 1048575, zzhymVar.zzq());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 11:
                                    obj2 = obj3;
                                    zzhzj.zze(obj2, iZzA & 1048575, zzhymVar.zzr());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 12:
                                    obj2 = obj3;
                                    int iZzs = zzhymVar.zzs();
                                    zzhwu zzhwuVarZzs = zzs(iZzR);
                                    if (zzhwuVarZzs == null || zzhwuVarZzs.zza(iZzs)) {
                                        zzhzj.zze(obj2, iZzA & 1048575, iZzs);
                                        zzO(obj2, iZzR);
                                    } else {
                                        objZzh = zzhyt.zzK(obj2, iZzb, iZzs, objZzh, zzhzcVar2);
                                    }
                                    obj = obj2;
                                    break;
                                case 13:
                                    obj2 = obj3;
                                    zzhzj.zze(obj2, iZzA & 1048575, zzhymVar.zzt());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 14:
                                    obj2 = obj3;
                                    zzhzj.zzg(obj2, iZzA & 1048575, zzhymVar.zzu());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 15:
                                    obj2 = obj3;
                                    zzhzj.zze(obj2, iZzA & 1048575, zzhymVar.zzv());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 16:
                                    obj2 = obj3;
                                    zzhzj.zzg(obj2, iZzA & 1048575, zzhymVar.zzw());
                                    zzO(obj2, iZzR);
                                    obj = obj2;
                                    break;
                                case 17:
                                    obj2 = obj3;
                                    zzhxz zzhxzVar2 = (zzhxz) zzt(obj2, iZzR);
                                    zzhymVar.zzp(zzhxzVar2, zzq(iZzR), zzhvyVar);
                                    zzu(obj2, iZzR, zzhxzVar2);
                                    obj = obj2;
                                    break;
                                case 18:
                                    obj2 = obj3;
                                    zzhymVar.zzx(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 19:
                                    obj2 = obj3;
                                    zzhymVar.zzy(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 20:
                                    obj2 = obj3;
                                    zzhymVar.zzA(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 21:
                                    obj2 = obj3;
                                    zzhymVar.zzz(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 22:
                                    obj2 = obj3;
                                    zzhymVar.zzB(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 23:
                                    obj2 = obj3;
                                    zzhymVar.zzC(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 24:
                                    obj2 = obj3;
                                    zzhymVar.zzD(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 25:
                                    obj2 = obj3;
                                    zzhymVar.zzE(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 26:
                                    obj2 = obj3;
                                    if (zzD(iZzA)) {
                                        ((zzhvo) zzhymVar).zzF(zzhxl.zza(obj2, iZzA & 1048575), true);
                                    } else {
                                        ((zzhvo) zzhymVar).zzF(zzhxl.zza(obj2, iZzA & 1048575), false);
                                    }
                                    obj = obj2;
                                    break;
                                case 27:
                                    obj2 = obj3;
                                    zzhymVar.zzG(zzhxl.zza(obj2, iZzA & 1048575), zzq(iZzR), zzhvyVar);
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                                    obj2 = obj3;
                                    zzhymVar.zzI(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 29:
                                    obj2 = obj3;
                                    zzhymVar.zzJ(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 30:
                                    List listZza = zzhxl.zza(obj3, iZzA & 1048575);
                                    zzhymVar.zzK(listZza);
                                    objZzh = zzhyt.zzJ(obj3, iZzb, listZza, zzs(iZzR), objZzh, zzhzcVar2);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 31:
                                    obj2 = obj3;
                                    zzhymVar.zzL(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 32:
                                    obj2 = obj3;
                                    zzhymVar.zzM(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                                    obj2 = obj3;
                                    zzhymVar.zzN(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 34:
                                    obj2 = obj3;
                                    zzhymVar.zzO(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                                    obj2 = obj3;
                                    zzhymVar.zzx(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 36:
                                    obj2 = obj3;
                                    zzhymVar.zzy(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                                    obj2 = obj3;
                                    zzhymVar.zzA(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                                    obj2 = obj3;
                                    zzhymVar.zzz(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                                    obj2 = obj3;
                                    zzhymVar.zzB(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                                    obj2 = obj3;
                                    zzhymVar.zzC(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                                    obj2 = obj3;
                                    zzhymVar.zzD(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                    obj2 = obj3;
                                    zzhymVar.zzE(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                    obj2 = obj3;
                                    zzhymVar.zzJ(zzhxl.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                    try {
                                        List listZza2 = zzhxl.zza(obj3, iZzA & 1048575);
                                        zzhymVar.zzK(listZza2);
                                        try {
                                            objZzh = zzhyt.zzJ(obj3, iZzb, listZza2, zzs(iZzR), objZzh, zzhzcVar2);
                                            obj2 = obj3;
                                        } catch (zzhxc unused) {
                                            obj2 = obj3;
                                            if (objZzh == null) {
                                                try {
                                                    objZzh = zzhzcVar2.zzh(obj2);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    th = th;
                                                    i = zzhycVar.zzk;
                                                    objZzx = objZzh;
                                                    while (i < zzhycVar.zzl) {
                                                        zzhzc zzhzcVar3 = zzhzcVar2;
                                                        objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar3, obj2);
                                                        i++;
                                                        zzhycVar = this;
                                                        zzhzcVar2 = zzhzcVar3;
                                                    }
                                                    zzhzcVar = zzhzcVar2;
                                                    if (objZzx != null) {
                                                        throw th;
                                                    }
                                                    zzhzcVar.zzi(obj2, objZzx);
                                                    throw th;
                                                }
                                            }
                                            if (!zzhzcVar2.zzk(objZzh, zzhymVar, 0)) {
                                                objZzx2 = objZzh;
                                                for (i2 = zzhycVar.zzk; i2 < zzhycVar.zzl; i2++) {
                                                    zzhzc zzhzcVar4 = zzhzcVar2;
                                                    objZzx2 = zzhycVar.zzx(obj2, zzhycVar.zzj[i2], objZzx2, zzhzcVar4, obj2);
                                                    zzhzcVar2 = zzhzcVar4;
                                                }
                                                if (objZzx2 != null) {
                                                    zzhzcVar2.zzi(obj2, objZzx2);
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj2 = obj3;
                                            th = th;
                                            zzhycVar = zzhycVar;
                                            i = zzhycVar.zzk;
                                            objZzx = objZzh;
                                            while (i < zzhycVar.zzl) {
                                                zzhzc zzhzcVar5 = zzhzcVar2;
                                                objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar5, obj2);
                                                i++;
                                                zzhycVar = this;
                                                zzhzcVar2 = zzhzcVar5;
                                            }
                                            zzhzcVar = zzhzcVar2;
                                            if (objZzx != null) {
                                                throw th;
                                            }
                                            zzhzcVar.zzi(obj2, objZzx);
                                            throw th;
                                        }
                                        obj = obj2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj2 = obj3;
                                    }
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                    zzhymVar.zzL(zzhxl.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                    zzhymVar.zzM(zzhxl.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                    zzhymVar.zzN(zzhxl.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 48:
                                    zzhymVar.zzO(zzhxl.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 49:
                                    zzhymVar.zzH(zzhxl.zza(obj3, iZzA & 1048575), zzq(iZzR), zzhvyVar);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 50:
                                    Object objZzr = zzr(iZzR);
                                    long jZzA = zzA(iZzR) & 1048575;
                                    Object objZzn = zzhzj.zzn(obj3, jZzA);
                                    if (objZzn == null) {
                                        objZzn = zzhxt.zza().zzc();
                                        zzhzj.zzo(obj3, jZzA, objZzn);
                                    } else if (zzhxu.zza(objZzn)) {
                                        Object objZzc = zzhxt.zza().zzc();
                                        zzhxu.zzb(objZzc, objZzn);
                                        zzhzj.zzo(obj3, jZzA, objZzc);
                                        objZzn = objZzc;
                                    }
                                    zzhymVar.zzP((zzhxt) objZzn, ((zzhxs) objZzr).zze(), zzhvyVar);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 51:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Double.valueOf(zzhymVar.zze()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 52:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Float.valueOf(zzhymVar.zzf()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 53:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Long.valueOf(zzhymVar.zzh()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 54:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Long.valueOf(zzhymVar.zzg()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 55:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Integer.valueOf(zzhymVar.zzi()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 56:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Long.valueOf(zzhymVar.zzj()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 57:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Integer.valueOf(zzhymVar.zzk()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 58:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Boolean.valueOf(zzhymVar.zzl()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 59:
                                    zzz(obj3, iZzA, zzhymVar);
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                                    zzhxz zzhxzVar3 = (zzhxz) zzv(obj3, iZzb, iZzR);
                                    zzhymVar.zzo(zzhxzVar3, zzq(iZzR), zzhvyVar);
                                    zzw(obj3, iZzb, iZzR, zzhxzVar3);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                                    zzhzj.zzo(obj3, iZzA & 1048575, zzhymVar.zzq());
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 62:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Integer.valueOf(zzhymVar.zzr()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                                    int iZzs2 = zzhymVar.zzs();
                                    zzhwu zzhwuVarZzs2 = zzs(iZzR);
                                    if (zzhwuVarZzs2 != null && !zzhwuVarZzs2.zza(iZzs2)) {
                                        objZzh = zzhyt.zzK(obj3, iZzb, iZzs2, objZzh, zzhzcVar2);
                                        obj = obj3;
                                    }
                                    zzhzj.zzo(obj3, iZzA & 1048575, Integer.valueOf(iZzs2));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 64:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Integer.valueOf(zzhymVar.zzt()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 65:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Long.valueOf(zzhymVar.zzu()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 66:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Integer.valueOf(zzhymVar.zzv()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 67:
                                    zzhzj.zzo(obj3, iZzA & 1048575, Long.valueOf(zzhymVar.zzw()));
                                    zzQ(obj3, iZzb, iZzR);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 68:
                                    try {
                                        zzhxz zzhxzVar4 = (zzhxz) zzv(obj3, iZzb, iZzR);
                                        zzhymVar.zzp(zzhxzVar4, zzq(iZzR), zzhvyVar);
                                        zzw(obj3, iZzb, iZzR, zzhxzVar4);
                                        obj2 = obj3;
                                        obj = obj2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th = th;
                                        zzhycVar = zzhycVar;
                                        obj2 = obj3;
                                        i = zzhycVar.zzk;
                                        objZzx = objZzh;
                                        while (i < zzhycVar.zzl) {
                                            zzhzc zzhzcVar6 = zzhzcVar2;
                                            objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar6, obj2);
                                            i++;
                                            zzhycVar = this;
                                            zzhzcVar2 = zzhzcVar6;
                                        }
                                        zzhzcVar = zzhzcVar2;
                                        if (objZzx != null) {
                                            throw th;
                                        }
                                        zzhzcVar.zzi(obj2, objZzx);
                                        throw th;
                                    }
                                    break;
                                default:
                                    obj2 = obj3;
                                    if (objZzh == null) {
                                        try {
                                            try {
                                                objZzh = zzhzcVar2.zzh(obj2);
                                            } catch (zzhxc unused2) {
                                                if (objZzh == null) {
                                                    objZzh = zzhzcVar2.zzh(obj2);
                                                }
                                                if (!zzhzcVar2.zzk(objZzh, zzhymVar, 0)) {
                                                    objZzx2 = objZzh;
                                                    while (i2 < zzhycVar.zzl) {
                                                        zzhzc zzhzcVar7 = zzhzcVar2;
                                                        objZzx2 = zzhycVar.zzx(obj2, zzhycVar.zzj[i2], objZzx2, zzhzcVar7, obj2);
                                                        zzhzcVar2 = zzhzcVar7;
                                                    }
                                                    if (objZzx2 != null) {
                                                        zzhzcVar2.zzi(obj2, objZzx2);
                                                    }
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            th = th;
                                            zzhycVar = zzhycVar;
                                            i = zzhycVar.zzk;
                                            objZzx = objZzh;
                                            while (i < zzhycVar.zzl) {
                                                zzhzc zzhzcVar8 = zzhzcVar2;
                                                objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar8, obj2);
                                                i++;
                                                zzhycVar = this;
                                                zzhzcVar2 = zzhzcVar8;
                                            }
                                            zzhzcVar = zzhzcVar2;
                                            if (objZzx != null) {
                                                throw th;
                                            }
                                            zzhzcVar.zzi(obj2, objZzx);
                                            throw th;
                                        }
                                    }
                                    try {
                                        if (zzhzcVar2.zzk(objZzh, zzhymVar, 0)) {
                                            obj = obj2;
                                        } else {
                                            objZzx2 = objZzh;
                                            for (int i3 = zzhycVar.zzk; i3 < zzhycVar.zzl; i3++) {
                                                zzhzc zzhzcVar9 = zzhzcVar2;
                                                objZzx2 = zzhycVar.zzx(obj2, zzhycVar.zzj[i3], objZzx2, zzhzcVar9, obj2);
                                                zzhzcVar2 = zzhzcVar9;
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        zzhycVar = zzhycVar;
                                        th = th;
                                        i = zzhycVar.zzk;
                                        objZzx = objZzh;
                                        while (i < zzhycVar.zzl) {
                                            zzhzc zzhzcVar10 = zzhzcVar2;
                                            objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar10, obj2);
                                            i++;
                                            zzhycVar = this;
                                            zzhzcVar2 = zzhzcVar10;
                                        }
                                        zzhzcVar = zzhzcVar2;
                                        if (objZzx != null) {
                                            throw th;
                                        }
                                        zzhzcVar.zzi(obj2, objZzx);
                                        throw th;
                                    }
                                    break;
                            }
                        } catch (zzhxc unused3) {
                            obj2 = obj3;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        zzhycVar = zzhycVar;
                        obj2 = obj3;
                    }
                } else if (iZzb == Integer.MAX_VALUE) {
                    objZzx2 = objZzh;
                    for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                        zzhzc zzhzcVar11 = zzhzcVar2;
                        objZzx2 = zzx(obj, this.zzj[i4], objZzx2, zzhzcVar11, obj);
                        zzhzcVar2 = zzhzcVar11;
                    }
                    obj2 = obj;
                } else {
                    zzhycVar = this;
                    try {
                        if ((!zzhycVar.zzh ? null : zzhvyVar.zzc(zzhycVar.zzg, iZzb)) != null) {
                            obj3 = obj;
                            zzhycVar = zzhycVar;
                            throw null;
                        }
                        if (objZzh == null) {
                            try {
                                objZzh = zzhzcVar2.zzh(obj);
                            } catch (Throwable th9) {
                                th = th9;
                                obj2 = obj;
                                i = zzhycVar.zzk;
                                objZzx = objZzh;
                                while (i < zzhycVar.zzl) {
                                    zzhzc zzhzcVar12 = zzhzcVar2;
                                    objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar12, obj2);
                                    i++;
                                    zzhycVar = this;
                                    zzhzcVar2 = zzhzcVar12;
                                }
                                zzhzcVar = zzhzcVar2;
                                if (objZzx != null) {
                                    throw th;
                                }
                                zzhzcVar.zzi(obj2, objZzx);
                                throw th;
                            }
                        }
                        try {
                            if (zzhzcVar2.zzk(objZzh, zzhymVar, 0)) {
                                obj3 = obj;
                                obj = obj3;
                            } else {
                                int i5 = zzhycVar.zzk;
                                objZzx2 = objZzh;
                                while (i5 < zzhycVar.zzl) {
                                    zzhzc zzhzcVar13 = zzhzcVar2;
                                    Object obj4 = obj;
                                    objZzx2 = zzhycVar.zzx(obj4, zzhycVar.zzj[i5], objZzx2, zzhzcVar13, obj);
                                    zzhzcVar2 = zzhzcVar13;
                                    i5++;
                                    obj = obj4;
                                }
                                obj2 = obj;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            obj3 = obj;
                            zzhycVar = zzhycVar;
                            th = th;
                            zzhycVar = zzhycVar;
                            obj2 = obj3;
                            i = zzhycVar.zzk;
                            objZzx = objZzh;
                            while (i < zzhycVar.zzl) {
                                zzhzc zzhzcVar14 = zzhzcVar2;
                                objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar14, obj2);
                                i++;
                                zzhycVar = this;
                                zzhzcVar2 = zzhzcVar14;
                            }
                            zzhzcVar = zzhzcVar2;
                            if (objZzx != null) {
                                throw th;
                            }
                            zzhzcVar.zzi(obj2, objZzx);
                            throw th;
                        }
                    } catch (Throwable th11) {
                        obj3 = obj;
                        th = th11;
                        obj2 = obj3;
                        i = zzhycVar.zzk;
                        objZzx = objZzh;
                        while (i < zzhycVar.zzl) {
                            zzhzc zzhzcVar15 = zzhzcVar2;
                            objZzx = zzhycVar.zzx(obj2, zzhycVar.zzj[i], objZzx, zzhzcVar15, obj2);
                            i++;
                            zzhycVar = this;
                            zzhzcVar2 = zzhzcVar15;
                        }
                        zzhzcVar = zzhzcVar2;
                        if (objZzx != null) {
                            throw th;
                        }
                        zzhzcVar.zzi(obj2, objZzx);
                        throw th;
                    }
                }
            } catch (Throwable th12) {
                th = th12;
                zzhycVar = this;
                obj2 = obj;
            }
        }
        if (objZzx2 != null) {
            zzhzcVar2.zzi(obj2, objZzx2);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 36661. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzi(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.ads.zzhuw r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3666
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzhuw):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzhuw zzhuwVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzhuwVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzk(Object obj) {
        if (zzE(obj)) {
            if (obj instanceof zzhwo) {
                zzhwo zzhwoVar = (zzhwo) obj;
                zzhwoVar.zzbq();
                zzhwoVar.zzbb();
                zzhwoVar.zzaY();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzA = zzA(i);
                int i2 = 1048575 & iZzA;
                int iZzC = zzC(iZzA);
                long j = i2;
                if (iZzC != 9) {
                    if (iZzC != 60 && iZzC != 68) {
                        switch (iZzC) {
                            case 17:
                                if (zzN(obj, i)) {
                                    zzq(i).zzk(zzb.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                            case 34:
                            case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                            case 36:
                            case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                            case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                            case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                            case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                            case 48:
                            case 49:
                                ((zzhxa) zzhzj.zzn(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzhxt) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzP(obj, iArr[i], i)) {
                        zzq(i).zzk(zzb.getObject(obj, j));
                    }
                } else if (zzN(obj, i)) {
                    zzq(i).zzk(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzj(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e6 A[LOOP:2: B:53:0x00d5->B:58:0x00e6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00fc A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhyr
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzhyr zzhyrVarZzq;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzk) {
            int[] iArr = this.zzj;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzA = zzA(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i12;
            }
            if ((268435456 & iZzA) != 0 && !zzM(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzC = zzC(iZzA);
            if (iZzC == 9 || iZzC == 17) {
                if (zzM(obj, i7, i, i2, i11) && !zzy(obj, iZzA, zzq(i7))) {
                    return false;
                }
            } else if (iZzC == 27) {
                list = (List) zzhzj.zzn(obj, iZzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzhyrVarZzq = zzq(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzhyrVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzC == 60 || iZzC == 68) {
                if (zzP(obj, i8, i7) && !zzy(obj, iZzA, zzq(i7))) {
                    return false;
                }
            } else if (iZzC == 49) {
                list = (List) zzhzj.zzn(obj, iZzA & 1048575);
                if (list.isEmpty()) {
                    zzhyrVarZzq = zzq(i7);
                    while (i3 < list.size()) {
                        if (!zzhyrVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzC != 50) {
                continue;
            } else {
                zzhxt zzhxtVar = (zzhxt) zzhzj.zzn(obj, iZzA & 1048575);
                if (!zzhxtVar.isEmpty() && ((zzhxs) zzr(i7)).zze().zzc.zza() == zzhzq.MESSAGE) {
                    zzhyr zzhyrVarZzb = null;
                    for (Object obj2 : zzhxtVar.values()) {
                        if (zzhyrVarZzb == null) {
                            zzhyrVarZzb = zzhyj.zza().zzb(obj2.getClass());
                        }
                        if (!zzhyrVarZzb.zzl(obj2)) {
                            return false;
                        }
                    }
                }
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzhwk) obj).zza.zze();
    }
}
