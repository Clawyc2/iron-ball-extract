package com.google.android.gms.internal.measurement;

import androidx.core.text.HtmlCompat;
import androidx.core.view.MotionEventCompat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlo<T> implements zzlw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzmx.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzll zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzkz zzm;
    private final zzmn zzn;
    private final zzjr zzo;
    private final zzlq zzp;
    private final zzlg zzq;

    private zzlo(int[] iArr, Object[] objArr, int i, int i2, zzll zzllVar, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = z;
        boolean z3 = false;
        if (zzjrVar != null && zzjrVar.zzc(zzllVar)) {
            z3 = true;
        }
        this.zzh = z3;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzp = zzlqVar;
        this.zzm = zzkzVar;
        this.zzn = zzmnVar;
        this.zzo = zzjrVar;
        this.zzg = zzllVar;
        this.zzq = zzlgVar;
    }

    private static int zzA(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzB(int i) {
        return this.zzc[i + 1];
    }

    private static long zzC(Object obj, long j) {
        return ((Long) zzmx.zzf(obj, j)).longValue();
    }

    private final zzki zzD(int i) {
        int i2 = i / 3;
        return (zzki) this.zzd[i2 + i2 + 1];
    }

    private final zzlw zzE(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzlw zzlwVar = (zzlw) this.zzd[i3];
        if (zzlwVar != null) {
            return zzlwVar;
        }
        zzlw zzlwVarZzb = zzlt.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzlwVarZzb;
        return zzlwVarZzb;
    }

    private final Object zzF(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private static Field zzG(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzH(Object obj, Object obj2, int i) {
        long jZzB = zzB(i) & 1048575;
        if (zzO(obj2, i)) {
            Object objZzf = zzmx.zzf(obj, jZzB);
            Object objZzf2 = zzmx.zzf(obj2, jZzB);
            if (objZzf != null && objZzf2 != null) {
                zzmx.zzs(obj, jZzB, zzkm.zzg(objZzf, objZzf2));
                zzJ(obj, i);
            } else if (objZzf2 != null) {
                zzmx.zzs(obj, jZzB, objZzf2);
                zzJ(obj, i);
            }
        }
    }

    private final void zzI(Object obj, Object obj2, int i) {
        int iZzB = zzB(i);
        int i2 = this.zzc[i];
        long j = iZzB & 1048575;
        if (zzR(obj2, i2, i)) {
            Object objZzf = zzR(obj, i2, i) ? zzmx.zzf(obj, j) : null;
            Object objZzf2 = zzmx.zzf(obj2, j);
            if (objZzf != null && objZzf2 != null) {
                zzmx.zzs(obj, j, zzkm.zzg(objZzf, objZzf2));
                zzK(obj, i2, i);
            } else if (objZzf2 != null) {
                zzmx.zzs(obj, j, objZzf2);
                zzK(obj, i2, i);
            }
        }
    }

    private final void zzJ(Object obj, int i) {
        int iZzy = zzy(i);
        long j = 1048575 & iZzy;
        if (j == 1048575) {
            return;
        }
        zzmx.zzq(obj, j, (1 << (iZzy >>> 20)) | zzmx.zzc(obj, j));
    }

    private final void zzK(Object obj, int i, int i2) {
        zzmx.zzq(obj, zzy(i2) & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final void zzL(Object obj, zznf zznfVar) throws IOException {
        int i;
        boolean z;
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iZzB = zzB(i4);
            int[] iArr = this.zzc;
            int i6 = iArr[i4];
            int iZzA = zzA(iZzB);
            if (iZzA <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            long j = iZzB & i2;
            switch (iZzA) {
                case 0:
                    if ((i5 & i) != 0) {
                        zznfVar.zzf(i6, zzmx.zza(obj, j));
                    }
                    break;
                case 1:
                    if ((i5 & i) != 0) {
                        zznfVar.zzo(i6, zzmx.zzb(obj, j));
                    }
                    break;
                case 2:
                    if ((i5 & i) != 0) {
                        zznfVar.zzt(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 3:
                    if ((i5 & i) != 0) {
                        zznfVar.zzJ(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 4:
                    if ((i5 & i) != 0) {
                        zznfVar.zzr(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 5:
                    if ((i5 & i) != 0) {
                        zznfVar.zzm(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 6:
                    if ((i5 & i) != 0) {
                        zznfVar.zzk(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 7:
                    if ((i5 & i) != 0) {
                        zznfVar.zzb(i6, zzmx.zzw(obj, j));
                    }
                    break;
                case 8:
                    if ((i5 & i) != 0) {
                        zzT(i6, unsafe.getObject(obj, j), zznfVar);
                    }
                    break;
                case 9:
                    if ((i5 & i) != 0) {
                        zznfVar.zzv(i6, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                case 10:
                    if ((i5 & i) != 0) {
                        zznfVar.zzd(i6, (zzjd) unsafe.getObject(obj, j));
                    }
                    break;
                case 11:
                    if ((i5 & i) != 0) {
                        zznfVar.zzH(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 12:
                    if ((i5 & i) != 0) {
                        zznfVar.zzi(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 13:
                    if ((i5 & i) != 0) {
                        zznfVar.zzw(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 14:
                    if ((i5 & i) != 0) {
                        zznfVar.zzy(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 15:
                    if ((i5 & i) != 0) {
                        zznfVar.zzA(i6, unsafe.getInt(obj, j));
                    }
                    break;
                case 16:
                    if ((i5 & i) != 0) {
                        zznfVar.zzC(i6, unsafe.getLong(obj, j));
                    }
                    break;
                case 17:
                    if ((i5 & i) != 0) {
                        zznfVar.zzq(i6, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                case 18:
                    zzly.zzJ(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 19:
                    zzly.zzN(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 20:
                    zzly.zzQ(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 21:
                    zzly.zzY(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 22:
                    zzly.zzP(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 23:
                    zzly.zzM(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 24:
                    zzly.zzL(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 25:
                    zzly.zzH(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 26:
                    zzly.zzW(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar);
                    break;
                case 27:
                    zzly.zzR(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, zzE(i4));
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    zzly.zzI(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar);
                    break;
                case 29:
                    z = false;
                    zzly.zzX(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 30:
                    z = false;
                    zzly.zzK(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 31:
                    z = false;
                    zzly.zzS(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 32:
                    z = false;
                    zzly.zzT(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    z = false;
                    zzly.zzU(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case 34:
                    z = false;
                    zzly.zzV(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    zzly.zzJ(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 36:
                    zzly.zzN(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    zzly.zzQ(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzly.zzY(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    zzly.zzP(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    zzly.zzM(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    zzly.zzL(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzly.zzH(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzly.zzX(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzly.zzK(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzly.zzS(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzly.zzT(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzly.zzU(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 48:
                    zzly.zzV(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, true);
                    break;
                case 49:
                    zzly.zzO(this.zzc[i4], (List) unsafe.getObject(obj, j), zznfVar, zzE(i4));
                    break;
                case 50:
                    zzM(zznfVar, i6, unsafe.getObject(obj, j), i4);
                    break;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzf(i6, zzn(obj, j));
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzo(i6, zzo(obj, j));
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzt(i6, zzC(obj, j));
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzJ(i6, zzC(obj, j));
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzr(i6, zzr(obj, j));
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzm(i6, zzC(obj, j));
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzk(i6, zzr(obj, j));
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzb(i6, zzS(obj, j));
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i4)) {
                        zzT(i6, unsafe.getObject(obj, j), zznfVar);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzv(i6, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzd(i6, (zzjd) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzH(i6, zzr(obj, j));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzi(i6, zzr(obj, j));
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzw(i6, zzr(obj, j));
                    }
                    break;
                case 65:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzy(i6, zzC(obj, j));
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzA(i6, zzr(obj, j));
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzC(i6, zzC(obj, j));
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i4)) {
                        zznfVar.zzq(i6, unsafe.getObject(obj, j), zzE(i4));
                    }
                    break;
                default:
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        zzmn zzmnVar = this.zzn;
        zzmnVar.zzi(zzmnVar.zzc(obj), zznfVar);
    }

    private final void zzM(zznf zznfVar, int i, Object obj, int i2) throws IOException {
        if (obj == null) {
            return;
        }
        throw null;
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        return zzO(obj, i) == zzO(obj2, i);
    }

    private final boolean zzO(Object obj, int i) {
        int iZzy = zzy(i);
        long j = iZzy & 1048575;
        if (j != 1048575) {
            return (zzmx.zzc(obj, j) & (1 << (iZzy >>> 20))) != 0;
        }
        int iZzB = zzB(i);
        long j2 = iZzB & 1048575;
        switch (zzA(iZzB)) {
            case 0:
                return Double.doubleToRawLongBits(zzmx.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzmx.zzb(obj, j2)) != 0;
            case 2:
                return zzmx.zzd(obj, j2) != 0;
            case 3:
                return zzmx.zzd(obj, j2) != 0;
            case 4:
                return zzmx.zzc(obj, j2) != 0;
            case 5:
                return zzmx.zzd(obj, j2) != 0;
            case 6:
                return zzmx.zzc(obj, j2) != 0;
            case 7:
                return zzmx.zzw(obj, j2);
            case 8:
                Object objZzf = zzmx.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzjd) {
                    return !zzjd.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzmx.zzf(obj, j2) != null;
            case 10:
                return !zzjd.zzb.equals(zzmx.zzf(obj, j2));
            case 11:
                return zzmx.zzc(obj, j2) != 0;
            case 12:
                return zzmx.zzc(obj, j2) != 0;
            case 13:
                return zzmx.zzc(obj, j2) != 0;
            case 14:
                return zzmx.zzd(obj, j2) != 0;
            case 15:
                return zzmx.zzc(obj, j2) != 0;
            case 16:
                return zzmx.zzd(obj, j2) != 0;
            case 17:
                return zzmx.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzP(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzO(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzQ(Object obj, int i, zzlw zzlwVar) {
        return zzlwVar.zzk(zzmx.zzf(obj, i & 1048575));
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzmx.zzc(obj, (long) (zzy(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzmx.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zznf zznfVar) throws IOException {
        if (obj instanceof String) {
            zznfVar.zzF(i, (String) obj);
        } else {
            zznfVar.zzd(i, (zzjd) obj);
        }
    }

    static zzmo zzd(Object obj) {
        zzke zzkeVar = (zzke) obj;
        zzmo zzmoVar = zzkeVar.zzc;
        if (zzmoVar != zzmo.zzc()) {
            return zzmoVar;
        }
        zzmo zzmoVarZze = zzmo.zze();
        zzkeVar.zzc = zzmoVarZze;
        return zzmoVarZze;
    }

    static zzlo zzl(Class cls, zzli zzliVar, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar) {
        if (zzliVar instanceof zzlv) {
            return zzm((zzlv) zzliVar, zzlqVar, zzkzVar, zzmnVar, zzjrVar, zzlgVar);
        }
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x025d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0260  */
    /* JADX WARN: Code duplicated, block: B:127:0x0279  */
    /* JADX WARN: Code duplicated, block: B:128:0x027c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0373  */
    /* JADX WARN: Code duplicated, block: B:182:0x0388  */
    static zzlo zzm(zzlv zzlvVar, zzlq zzlqVar, zzkz zzkzVar, zzmn zzmnVar, zzjr zzjrVar, zzlg zzlgVar) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        char cCharAt;
        int i6;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int i8;
        char cCharAt4;
        int i9;
        char cCharAt5;
        int i10;
        char cCharAt6;
        int i11;
        char cCharAt7;
        int i12;
        char cCharAt8;
        int i13;
        int i14;
        int i15;
        int iObjectFieldOffset;
        int i16;
        int i17;
        int i18;
        Field fieldZzG;
        char cCharAt9;
        int i19;
        int i20;
        int i21;
        Object obj;
        Field fieldZzG2;
        int i22;
        Object obj2;
        Field fieldZzG3;
        int i23;
        char cCharAt10;
        int i24;
        int i25;
        char cCharAt11;
        int i26;
        char cCharAt12;
        int i27;
        char cCharAt13;
        boolean z = zzlvVar.zzc() == 2;
        String strZzd = zzlvVar.zzd();
        int length = strZzd.length();
        char c = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i28 = 1;
            while (true) {
                i = i28 + 1;
                if (strZzd.charAt(i28) < 55296) {
                    break;
                }
                i28 = i;
            }
        } else {
            i = 1;
        }
        int i29 = i + 1;
        int iCharAt5 = strZzd.charAt(i);
        if (iCharAt5 >= 55296) {
            int i30 = iCharAt5 & 8191;
            int i31 = 13;
            while (true) {
                i27 = i29 + 1;
                cCharAt13 = strZzd.charAt(i29);
                if (cCharAt13 < 55296) {
                    break;
                }
                i30 |= (cCharAt13 & 8191) << i31;
                i31 += 13;
                i29 = i27;
            }
            iCharAt5 = i30 | (cCharAt13 << i31);
            i29 = i27;
        }
        if (iCharAt5 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i3 = 0;
            iCharAt4 = 0;
            i2 = 0;
            iArr = zza;
            i4 = 0;
        } else {
            int i32 = i29 + 1;
            int iCharAt6 = strZzd.charAt(i29);
            if (iCharAt6 >= 55296) {
                int i33 = iCharAt6 & 8191;
                int i34 = 13;
                while (true) {
                    i12 = i32 + 1;
                    cCharAt8 = strZzd.charAt(i32);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i33 |= (cCharAt8 & 8191) << i34;
                    i34 += 13;
                    i32 = i12;
                }
                iCharAt6 = i33 | (cCharAt8 << i34);
                i32 = i12;
            }
            int i35 = i32 + 1;
            int iCharAt7 = strZzd.charAt(i32);
            if (iCharAt7 >= 55296) {
                int i36 = iCharAt7 & 8191;
                int i37 = 13;
                while (true) {
                    i11 = i35 + 1;
                    cCharAt7 = strZzd.charAt(i35);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i36 |= (cCharAt7 & 8191) << i37;
                    i37 += 13;
                    i35 = i11;
                }
                iCharAt7 = i36 | (cCharAt7 << i37);
                i35 = i11;
            }
            int i38 = i35 + 1;
            iCharAt = strZzd.charAt(i35);
            if (iCharAt >= 55296) {
                int i39 = iCharAt & 8191;
                int i40 = 13;
                while (true) {
                    i10 = i38 + 1;
                    cCharAt6 = strZzd.charAt(i38);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt6 & 8191) << i40;
                    i40 += 13;
                    i38 = i10;
                }
                iCharAt = i39 | (cCharAt6 << i40);
                i38 = i10;
            }
            int i41 = i38 + 1;
            iCharAt2 = strZzd.charAt(i38);
            if (iCharAt2 >= 55296) {
                int i42 = iCharAt2 & 8191;
                int i43 = 13;
                while (true) {
                    i9 = i41 + 1;
                    cCharAt5 = strZzd.charAt(i41);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt5 & 8191) << i43;
                    i43 += 13;
                    i41 = i9;
                }
                iCharAt2 = i42 | (cCharAt5 << i43);
                i41 = i9;
            }
            int i44 = i41 + 1;
            iCharAt3 = strZzd.charAt(i41);
            if (iCharAt3 >= 55296) {
                int i45 = iCharAt3 & 8191;
                int i46 = 13;
                while (true) {
                    i8 = i44 + 1;
                    cCharAt4 = strZzd.charAt(i44);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt4 & 8191) << i46;
                    i46 += 13;
                    i44 = i8;
                }
                iCharAt3 = i45 | (cCharAt4 << i46);
                i44 = i8;
            }
            int i47 = i44 + 1;
            int iCharAt8 = strZzd.charAt(i44);
            if (iCharAt8 >= 55296) {
                int i48 = iCharAt8 & 8191;
                int i49 = 13;
                while (true) {
                    i7 = i47 + 1;
                    cCharAt3 = strZzd.charAt(i47);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt3 & 8191) << i49;
                    i49 += 13;
                    i47 = i7;
                }
                iCharAt8 = i48 | (cCharAt3 << i49);
                i47 = i7;
            }
            int i50 = i47 + 1;
            int iCharAt9 = strZzd.charAt(i47);
            if (iCharAt9 >= 55296) {
                int i51 = iCharAt9 & 8191;
                int i52 = 13;
                while (true) {
                    i6 = i50 + 1;
                    cCharAt2 = strZzd.charAt(i50);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt2 & 8191) << i52;
                    i52 += 13;
                    i50 = i6;
                }
                iCharAt9 = i51 | (cCharAt2 << i52);
                i50 = i6;
            }
            int i53 = i50 + 1;
            iCharAt4 = strZzd.charAt(i50);
            if (iCharAt4 >= 55296) {
                int i54 = iCharAt4 & 8191;
                int i55 = 13;
                while (true) {
                    i5 = i53 + 1;
                    cCharAt = strZzd.charAt(i53);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i55;
                    i55 += 13;
                    i53 = i5;
                }
                iCharAt4 = i54 | (cCharAt << i55);
                i53 = i5;
            }
            int[] iArr2 = new int[iCharAt4 + iCharAt8 + iCharAt9];
            i2 = iCharAt6 + iCharAt6 + iCharAt7;
            i3 = iCharAt8;
            iArr = iArr2;
            i4 = iCharAt6;
            i29 = i53;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzlvVar.zze();
        Class<?> cls = zzlvVar.zza().getClass();
        int[] iArr3 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 + iCharAt3];
        int i56 = i3 + iCharAt4;
        int i57 = i56;
        int i58 = iCharAt4;
        int i59 = 0;
        int i60 = 0;
        while (i29 < length) {
            int i61 = i29 + 1;
            int iCharAt10 = strZzd.charAt(i29);
            if (iCharAt10 >= c) {
                int i62 = iCharAt10 & 8191;
                int i63 = i61;
                int i64 = 13;
                while (true) {
                    i26 = i63 + 1;
                    cCharAt12 = strZzd.charAt(i63);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i62 |= (cCharAt12 & 8191) << i64;
                    i64 += 13;
                    i63 = i26;
                }
                iCharAt10 = i62 | (cCharAt12 << i64);
                i13 = i26;
            } else {
                i13 = i61;
            }
            int i65 = i13 + 1;
            int iCharAt11 = strZzd.charAt(i13);
            if (iCharAt11 >= c) {
                int i66 = iCharAt11 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i25 = i67 + 1;
                    cCharAt11 = strZzd.charAt(i67);
                    i14 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i66 |= (cCharAt11 & 8191) << i68;
                    i68 += 13;
                    i67 = i25;
                    length = i14;
                }
                iCharAt11 = i66 | (cCharAt11 << i68);
                i15 = i25;
            } else {
                i14 = length;
                i15 = i65;
            }
            int i69 = iCharAt11 & 255;
            int[] iArr4 = iArr3;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i60] = i59;
                i60++;
            }
            if (i69 >= 51) {
                int i70 = i15 + 1;
                int iCharAt12 = strZzd.charAt(i15);
                if (iCharAt12 >= 55296) {
                    int i71 = iCharAt12 & 8191;
                    int i72 = i70;
                    int i73 = 13;
                    while (true) {
                        i23 = i72 + 1;
                        cCharAt10 = strZzd.charAt(i72);
                        i24 = i71;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i71 = i24 | ((cCharAt10 & 8191) << i73);
                        i73 += 13;
                        i72 = i23;
                    }
                    iCharAt12 = i24 | (cCharAt10 << i73);
                    i19 = i23;
                } else {
                    i19 = i70;
                }
                int i74 = iCharAt12;
                int i75 = i69 - 51;
                int i76 = i19;
                if (i75 == 9 || i75 == 17) {
                    int i77 = i59 / 3;
                    i20 = i2 + 1;
                    objArr[i77 + i77 + 1] = objArrZze[i2];
                } else {
                    if (i75 == 12 && !z) {
                        int i78 = i59 / 3;
                        i20 = i2 + 1;
                        objArr[i78 + i78 + 1] = objArrZze[i2];
                    }
                    i21 = i74 + i74;
                    obj = objArrZze[i21];
                    if (obj instanceof Field) {
                        fieldZzG2 = (Field) obj;
                    } else {
                        fieldZzG2 = zzG(cls, (String) obj);
                        objArrZze[i21] = fieldZzG2;
                    }
                    int iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzG2);
                    i22 = i21 + 1;
                    obj2 = objArrZze[i22];
                    if (obj2 instanceof Field) {
                        fieldZzG3 = (Field) obj2;
                    } else {
                        fieldZzG3 = zzG(cls, (String) obj2);
                        objArrZze[i22] = fieldZzG3;
                    }
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG3);
                    i17 = iObjectFieldOffset2;
                    strZzd = strZzd;
                    i29 = i76;
                    i16 = 0;
                }
                i2 = i20;
                i21 = i74 + i74;
                obj = objArrZze[i21];
                if (obj instanceof Field) {
                    fieldZzG2 = (Field) obj;
                } else {
                    fieldZzG2 = zzG(cls, (String) obj);
                    objArrZze[i21] = fieldZzG2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzG2);
                i22 = i21 + 1;
                obj2 = objArrZze[i22];
                if (obj2 instanceof Field) {
                    fieldZzG3 = (Field) obj2;
                } else {
                    fieldZzG3 = zzG(cls, (String) obj2);
                    objArrZze[i22] = fieldZzG3;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG3);
                i17 = iObjectFieldOffset3;
                strZzd = strZzd;
                i29 = i76;
                i16 = 0;
            } else {
                int i79 = i2 + 1;
                Field fieldZzG4 = zzG(cls, (String) objArrZze[i2]);
                if (i69 == 9 || i69 == 17) {
                    int i80 = i59 / 3;
                    objArr[i80 + i80 + 1] = fieldZzG4.getType();
                } else {
                    if (i69 == 27 || i69 == 49) {
                        int i81 = i59 / 3;
                        i2 += 2;
                        objArr[i81 + i81 + 1] = objArrZze[i79];
                    } else if (i69 == 12 || i69 == 30 || i69 == 44) {
                        if (!z) {
                            int i82 = i59 / 3;
                            i2 += 2;
                            objArr[i82 + i82 + 1] = objArrZze[i79];
                        }
                    } else if (i69 == 50) {
                        int i83 = i58 + 1;
                        iArr[i58] = i59;
                        int i84 = i59 / 3;
                        int i85 = i84 + i84;
                        int i86 = i2 + 2;
                        objArr[i85] = objArrZze[i79];
                        if ((iCharAt11 & 2048) != 0) {
                            objArr[i85 + 1] = objArrZze[i86];
                            i2 += 3;
                        } else {
                            i2 = i86;
                        }
                        i58 = i83;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzG4);
                    iObjectFieldOffset = 1048575;
                    if ((iCharAt11 & 4096) == 4096 || i69 > 17) {
                        i29 = i15;
                        i16 = 0;
                    } else {
                        int i87 = i15 + 1;
                        int iCharAt13 = strZzd.charAt(i15);
                        if (iCharAt13 >= 55296) {
                            int i88 = iCharAt13 & 8191;
                            int i89 = 13;
                            while (true) {
                                i18 = i87 + 1;
                                cCharAt9 = strZzd.charAt(i87);
                                if (cCharAt9 < 55296) {
                                    break;
                                }
                                i88 |= (cCharAt9 & 8191) << i89;
                                i89 += 13;
                                i87 = i18;
                            }
                            iCharAt13 = i88 | (cCharAt9 << i89);
                        } else {
                            i18 = i87;
                        }
                        int i90 = i4 + i4 + (iCharAt13 / 32);
                        Object obj3 = objArrZze[i90];
                        if (obj3 instanceof Field) {
                            fieldZzG = (Field) obj3;
                        } else {
                            fieldZzG = zzG(cls, (String) obj3);
                            objArrZze[i90] = fieldZzG;
                        }
                        i16 = iCharAt13 % 32;
                        int i91 = i18;
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzG);
                        i29 = i91;
                    }
                    if (i69 < 18 && i69 <= 49) {
                        iArr[i57] = iObjectFieldOffset4;
                        i57++;
                    }
                    i17 = iObjectFieldOffset4;
                }
                i2 = i79;
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldZzG4);
                iObjectFieldOffset = 1048575;
                if ((iCharAt11 & 4096) == 4096) {
                    i29 = i15;
                    i16 = 0;
                } else {
                    i29 = i15;
                    i16 = 0;
                }
                if (i69 < 18) {
                }
                i17 = iObjectFieldOffset5;
            }
            int i92 = i59 + 1;
            iArr4[i59] = iCharAt10;
            int i93 = i59 + 2;
            int i94 = i16;
            iArr4[i92] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i69 << 20) | i17;
            i59 += 3;
            iArr4[i93] = (i94 << 20) | iObjectFieldOffset;
            iArr3 = iArr4;
            length = i14;
            strZzd = strZzd;
            c = 55296;
        }
        return new zzlo(iArr3, objArr, iCharAt, iCharAt2, zzlvVar.zza(), z, false, iArr, iCharAt4, i56, zzlqVar, zzkzVar, zzmnVar, zzjrVar, zzlgVar, null);
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzmx.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzmx.zzf(obj, j)).floatValue();
    }

    private final int zzp(Object obj) {
        int i;
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzv;
        int iZzA5;
        int iZzA6;
        int iZzd;
        int iZzA7;
        int iZzo;
        int iZzz;
        int iZzA8;
        int i2;
        Unsafe unsafe = zzb;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        for (int i6 = 0; i6 < this.zzc.length; i6 += 3) {
            int iZzB2 = zzB(i6);
            int[] iArr = this.zzc;
            int i7 = iArr[i6];
            int iZzA9 = zzA(iZzB2);
            if (iZzA9 <= 17) {
                int i8 = iArr[i6 + 2];
                int i9 = i8 & 1048575;
                i = 1 << (i8 >>> 20);
                if (i9 != i5) {
                    i4 = unsafe.getInt(obj, i9);
                    i5 = i9;
                }
            } else {
                i = 0;
            }
            long j = iZzB2 & 1048575;
            switch (iZzA9) {
                case 0:
                    if ((i4 & i) != 0) {
                        iZzA = zzjl.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i3 += iZzo;
                    }
                    break;
                case 1:
                    if ((i4 & i) != 0) {
                        iZzA2 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i3 += iZzo;
                    }
                    break;
                case 2:
                    if ((i4 & i) != 0) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzA3 = zzjl.zzA(i7 << 3);
                        iZzB = zzjl.zzB(j2);
                        i3 += iZzA3 + iZzB;
                    }
                    break;
                case 3:
                    if ((i4 & i) != 0) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzA3 = zzjl.zzA(i7 << 3);
                        iZzB = zzjl.zzB(j3);
                        i3 += iZzA3 + iZzB;
                    }
                    break;
                case 4:
                    if ((i4 & i) != 0) {
                        int i10 = unsafe.getInt(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzv(i10);
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 5:
                    if ((i4 & i) != 0) {
                        iZzA = zzjl.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i3 += iZzo;
                    }
                    break;
                case 6:
                    if ((i4 & i) != 0) {
                        iZzA2 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i3 += iZzo;
                    }
                    break;
                case 7:
                    if ((i4 & i) != 0) {
                        iZzA5 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA5 + 1;
                        i3 += iZzo;
                    }
                    break;
                case 8:
                    if ((i4 & i) != 0) {
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzjd) {
                            iZzA6 = zzjl.zzA(i7 << 3);
                            iZzd = ((zzjd) object).zzd();
                            iZzA7 = zzjl.zzA(iZzd);
                            i2 = iZzA6 + iZzA7 + iZzd;
                            i3 += i2;
                        } else {
                            iZzA4 = zzjl.zzA(i7 << 3);
                            iZzv = zzjl.zzy((String) object);
                            i2 = iZzA4 + iZzv;
                            i3 += i2;
                        }
                    }
                    break;
                case 9:
                    if ((i4 & i) != 0) {
                        iZzo = zzly.zzo(i7, unsafe.getObject(obj, j), zzE(i6));
                        i3 += iZzo;
                    }
                    break;
                case 10:
                    if ((i4 & i) != 0) {
                        zzjd zzjdVar = (zzjd) unsafe.getObject(obj, j);
                        iZzA6 = zzjl.zzA(i7 << 3);
                        iZzd = zzjdVar.zzd();
                        iZzA7 = zzjl.zzA(iZzd);
                        i2 = iZzA6 + iZzA7 + iZzd;
                        i3 += i2;
                    }
                    break;
                case 11:
                    if ((i4 & i) != 0) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzA(i11);
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 12:
                    if ((i4 & i) != 0) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzv(i12);
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 13:
                    if ((i4 & i) != 0) {
                        iZzA2 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i3 += iZzo;
                    }
                    break;
                case 14:
                    if ((i4 & i) != 0) {
                        iZzA = zzjl.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i3 += iZzo;
                    }
                    break;
                case 15:
                    if ((i4 & i) != 0) {
                        int i13 = unsafe.getInt(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzA((i13 >> 31) ^ (i13 + i13));
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 16:
                    if ((i & i4) != 0) {
                        long j4 = unsafe.getLong(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzB((j4 >> 63) ^ (j4 + j4));
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 17:
                    if ((i4 & i) != 0) {
                        iZzo = zzjl.zzu(i7, (zzll) unsafe.getObject(obj, j), zzE(i6));
                        i3 += iZzo;
                    }
                    break;
                case 18:
                    iZzo = zzly.zzh(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 19:
                    iZzo = zzly.zzf(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 20:
                    iZzo = zzly.zzm(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 21:
                    iZzo = zzly.zzx(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 22:
                    iZzo = zzly.zzk(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 23:
                    iZzo = zzly.zzh(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 24:
                    iZzo = zzly.zzf(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 25:
                    iZzo = zzly.zza(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 26:
                    iZzo = zzly.zzu(i7, (List) unsafe.getObject(obj, j));
                    i3 += iZzo;
                    break;
                case 27:
                    iZzo = zzly.zzp(i7, (List) unsafe.getObject(obj, j), zzE(i6));
                    i3 += iZzo;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    iZzo = zzly.zzc(i7, (List) unsafe.getObject(obj, j));
                    i3 += iZzo;
                    break;
                case 29:
                    iZzo = zzly.zzv(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 30:
                    iZzo = zzly.zzd(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 31:
                    iZzo = zzly.zzf(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 32:
                    iZzo = zzly.zzh(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    iZzo = zzly.zzq(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case 34:
                    iZzo = zzly.zzs(i7, (List) unsafe.getObject(obj, j), false);
                    i3 += iZzo;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 36:
                    iZzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZzv = zzly.zzn((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZzv = zzly.zzy((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZzv = zzly.zzl((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    iZzv = zzly.zzb((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZzv = zzly.zzw((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZzv = zzly.zze((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZzv = zzly.zzr((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 48:
                    iZzv = zzly.zzt((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i7);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 49:
                    iZzo = zzly.zzj(i7, (List) unsafe.getObject(obj, j), zzE(i6));
                    i3 += iZzo;
                    break;
                case 50:
                    zzlg.zza(i7, unsafe.getObject(obj, j), zzF(i6));
                    break;
                case 51:
                    if (zzR(obj, i7, i6)) {
                        iZzA = zzjl.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i3 += iZzo;
                    }
                    break;
                case 52:
                    if (zzR(obj, i7, i6)) {
                        iZzA2 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i3 += iZzo;
                    }
                    break;
                case 53:
                    if (zzR(obj, i7, i6)) {
                        long jZzC = zzC(obj, j);
                        iZzA3 = zzjl.zzA(i7 << 3);
                        iZzB = zzjl.zzB(jZzC);
                        i3 += iZzA3 + iZzB;
                    }
                    break;
                case 54:
                    if (zzR(obj, i7, i6)) {
                        long jZzC2 = zzC(obj, j);
                        iZzA3 = zzjl.zzA(i7 << 3);
                        iZzB = zzjl.zzB(jZzC2);
                        i3 += iZzA3 + iZzB;
                    }
                    break;
                case 55:
                    if (zzR(obj, i7, i6)) {
                        int iZzr = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzv(iZzr);
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 56:
                    if (zzR(obj, i7, i6)) {
                        iZzA = zzjl.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i3 += iZzo;
                    }
                    break;
                case 57:
                    if (zzR(obj, i7, i6)) {
                        iZzA2 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i3 += iZzo;
                    }
                    break;
                case 58:
                    if (zzR(obj, i7, i6)) {
                        iZzA5 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA5 + 1;
                        i3 += iZzo;
                    }
                    break;
                case 59:
                    if (zzR(obj, i7, i6)) {
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzjd) {
                            iZzA6 = zzjl.zzA(i7 << 3);
                            iZzd = ((zzjd) object2).zzd();
                            iZzA7 = zzjl.zzA(iZzd);
                            i2 = iZzA6 + iZzA7 + iZzd;
                            i3 += i2;
                        } else {
                            iZzA4 = zzjl.zzA(i7 << 3);
                            iZzv = zzjl.zzy((String) object2);
                            i2 = iZzA4 + iZzv;
                            i3 += i2;
                        }
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i7, i6)) {
                        iZzo = zzly.zzo(i7, unsafe.getObject(obj, j), zzE(i6));
                        i3 += iZzo;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i7, i6)) {
                        zzjd zzjdVar2 = (zzjd) unsafe.getObject(obj, j);
                        iZzA6 = zzjl.zzA(i7 << 3);
                        iZzd = zzjdVar2.zzd();
                        iZzA7 = zzjl.zzA(iZzd);
                        i2 = iZzA6 + iZzA7 + iZzd;
                        i3 += i2;
                    }
                    break;
                case 62:
                    if (zzR(obj, i7, i6)) {
                        int iZzr2 = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzA(iZzr2);
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i7, i6)) {
                        int iZzr3 = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzv(iZzr3);
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 64:
                    if (zzR(obj, i7, i6)) {
                        iZzA2 = zzjl.zzA(i7 << 3);
                        iZzo = iZzA2 + 4;
                        i3 += iZzo;
                    }
                    break;
                case 65:
                    if (zzR(obj, i7, i6)) {
                        iZzA = zzjl.zzA(i7 << 3);
                        iZzo = iZzA + 8;
                        i3 += iZzo;
                    }
                    break;
                case 66:
                    if (zzR(obj, i7, i6)) {
                        int iZzr4 = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzA((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 67:
                    if (zzR(obj, i7, i6)) {
                        long jZzC3 = zzC(obj, j);
                        iZzA4 = zzjl.zzA(i7 << 3);
                        iZzv = zzjl.zzB((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i2 = iZzA4 + iZzv;
                        i3 += i2;
                    }
                    break;
                case 68:
                    if (zzR(obj, i7, i6)) {
                        iZzo = zzjl.zzu(i7, (zzll) unsafe.getObject(obj, j), zzE(i6));
                        i3 += iZzo;
                    }
                    break;
            }
        }
        zzmn zzmnVar = this.zzn;
        int iZza = i3 + zzmnVar.zza(zzmnVar.zzc(obj));
        if (!this.zzh) {
            return iZza;
        }
        this.zzo.zza(obj);
        throw null;
    }

    private final int zzq(Object obj) {
        int iZzA;
        int iZzA2;
        int iZzA3;
        int iZzB;
        int iZzA4;
        int iZzv;
        int iZzA5;
        int iZzA6;
        int iZzd;
        int iZzA7;
        int iZzo;
        int iZzz;
        int iZzA8;
        int i;
        Unsafe unsafe = zzb;
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzB2 = zzB(i3);
            int iZzA9 = zzA(iZzB2);
            int i4 = this.zzc[i3];
            long j = iZzB2 & 1048575;
            if (iZzA9 >= zzjw.DOUBLE_LIST_PACKED.zza() && iZzA9 <= zzjw.SINT64_LIST_PACKED.zza()) {
                int i5 = this.zzc[i3 + 2];
            }
            switch (iZzA9) {
                case 0:
                    if (zzO(obj, i3)) {
                        iZzA = zzjl.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                    }
                    break;
                case 1:
                    if (zzO(obj, i3)) {
                        iZzA2 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 2:
                    if (zzO(obj, i3)) {
                        long jZzd = zzmx.zzd(obj, j);
                        iZzA3 = zzjl.zzA(i4 << 3);
                        iZzB = zzjl.zzB(jZzd);
                        i2 += iZzA3 + iZzB;
                    }
                    break;
                case 3:
                    if (zzO(obj, i3)) {
                        long jZzd2 = zzmx.zzd(obj, j);
                        iZzA3 = zzjl.zzA(i4 << 3);
                        iZzB = zzjl.zzB(jZzd2);
                        i2 += iZzA3 + iZzB;
                    }
                    break;
                case 4:
                    if (zzO(obj, i3)) {
                        int iZzc = zzmx.zzc(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzv(iZzc);
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 5:
                    if (zzO(obj, i3)) {
                        iZzA = zzjl.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                    }
                    break;
                case 6:
                    if (zzO(obj, i3)) {
                        iZzA2 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 7:
                    if (zzO(obj, i3)) {
                        iZzA5 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA5 + 1;
                        i2 += iZzo;
                    }
                    break;
                case 8:
                    if (zzO(obj, i3)) {
                        Object objZzf = zzmx.zzf(obj, j);
                        if (objZzf instanceof zzjd) {
                            iZzA6 = zzjl.zzA(i4 << 3);
                            iZzd = ((zzjd) objZzf).zzd();
                            iZzA7 = zzjl.zzA(iZzd);
                            i = iZzA6 + iZzA7 + iZzd;
                            i2 += i;
                        } else {
                            iZzA4 = zzjl.zzA(i4 << 3);
                            iZzv = zzjl.zzy((String) objZzf);
                            i = iZzA4 + iZzv;
                            i2 += i;
                        }
                    }
                    break;
                case 9:
                    if (zzO(obj, i3)) {
                        iZzo = zzly.zzo(i4, zzmx.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
                case 10:
                    if (zzO(obj, i3)) {
                        zzjd zzjdVar = (zzjd) zzmx.zzf(obj, j);
                        iZzA6 = zzjl.zzA(i4 << 3);
                        iZzd = zzjdVar.zzd();
                        iZzA7 = zzjl.zzA(iZzd);
                        i = iZzA6 + iZzA7 + iZzd;
                        i2 += i;
                    }
                    break;
                case 11:
                    if (zzO(obj, i3)) {
                        int iZzc2 = zzmx.zzc(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzA(iZzc2);
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 12:
                    if (zzO(obj, i3)) {
                        int iZzc3 = zzmx.zzc(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzv(iZzc3);
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 13:
                    if (zzO(obj, i3)) {
                        iZzA2 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 14:
                    if (zzO(obj, i3)) {
                        iZzA = zzjl.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                    }
                    break;
                case 15:
                    if (zzO(obj, i3)) {
                        int iZzc4 = zzmx.zzc(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzA((iZzc4 >> 31) ^ (iZzc4 + iZzc4));
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 16:
                    if (zzO(obj, i3)) {
                        long jZzd3 = zzmx.zzd(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzB((jZzd3 >> 63) ^ (jZzd3 + jZzd3));
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 17:
                    if (zzO(obj, i3)) {
                        iZzo = zzjl.zzu(i4, (zzll) zzmx.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
                case 18:
                    iZzo = zzly.zzh(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 19:
                    iZzo = zzly.zzf(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 20:
                    iZzo = zzly.zzm(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 21:
                    iZzo = zzly.zzx(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 22:
                    iZzo = zzly.zzk(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 23:
                    iZzo = zzly.zzh(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 24:
                    iZzo = zzly.zzf(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 25:
                    iZzo = zzly.zza(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 26:
                    iZzo = zzly.zzu(i4, (List) zzmx.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 27:
                    iZzo = zzly.zzp(i4, (List) zzmx.zzf(obj, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    iZzo = zzly.zzc(i4, (List) zzmx.zzf(obj, j));
                    i2 += iZzo;
                    break;
                case 29:
                    iZzo = zzly.zzv(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 30:
                    iZzo = zzly.zzd(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 31:
                    iZzo = zzly.zzf(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 32:
                    iZzo = zzly.zzh(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    iZzo = zzly.zzq(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case 34:
                    iZzo = zzly.zzs(i4, (List) zzmx.zzf(obj, j), false);
                    i2 += iZzo;
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    iZzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 36:
                    iZzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    iZzv = zzly.zzn((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    iZzv = zzly.zzy((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    iZzv = zzly.zzl((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    iZzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    iZzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    iZzv = zzly.zzb((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    iZzv = zzly.zzw((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    iZzv = zzly.zze((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    iZzv = zzly.zzg((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    iZzv = zzly.zzi((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    iZzv = zzly.zzr((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 48:
                    iZzv = zzly.zzt((List) unsafe.getObject(obj, j));
                    if (iZzv > 0) {
                        iZzz = zzjl.zzz(i4);
                        iZzA8 = zzjl.zzA(iZzv);
                        iZzA4 = iZzz + iZzA8;
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 49:
                    iZzo = zzly.zzj(i4, (List) zzmx.zzf(obj, j), zzE(i3));
                    i2 += iZzo;
                    break;
                case 50:
                    zzlg.zza(i4, zzmx.zzf(obj, j), zzF(i3));
                    break;
                case 51:
                    if (zzR(obj, i4, i3)) {
                        iZzA = zzjl.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                    }
                    break;
                case 52:
                    if (zzR(obj, i4, i3)) {
                        iZzA2 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 53:
                    if (zzR(obj, i4, i3)) {
                        long jZzC = zzC(obj, j);
                        iZzA3 = zzjl.zzA(i4 << 3);
                        iZzB = zzjl.zzB(jZzC);
                        i2 += iZzA3 + iZzB;
                    }
                    break;
                case 54:
                    if (zzR(obj, i4, i3)) {
                        long jZzC2 = zzC(obj, j);
                        iZzA3 = zzjl.zzA(i4 << 3);
                        iZzB = zzjl.zzB(jZzC2);
                        i2 += iZzA3 + iZzB;
                    }
                    break;
                case 55:
                    if (zzR(obj, i4, i3)) {
                        int iZzr = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzv(iZzr);
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 56:
                    if (zzR(obj, i4, i3)) {
                        iZzA = zzjl.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                    }
                    break;
                case 57:
                    if (zzR(obj, i4, i3)) {
                        iZzA2 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 58:
                    if (zzR(obj, i4, i3)) {
                        iZzA5 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA5 + 1;
                        i2 += iZzo;
                    }
                    break;
                case 59:
                    if (zzR(obj, i4, i3)) {
                        Object objZzf2 = zzmx.zzf(obj, j);
                        if (objZzf2 instanceof zzjd) {
                            iZzA6 = zzjl.zzA(i4 << 3);
                            iZzd = ((zzjd) objZzf2).zzd();
                            iZzA7 = zzjl.zzA(iZzd);
                            i = iZzA6 + iZzA7 + iZzd;
                            i2 += i;
                        } else {
                            iZzA4 = zzjl.zzA(i4 << 3);
                            iZzv = zzjl.zzy((String) objZzf2);
                            i = iZzA4 + iZzv;
                            i2 += i;
                        }
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i4, i3)) {
                        iZzo = zzly.zzo(i4, zzmx.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i4, i3)) {
                        zzjd zzjdVar2 = (zzjd) zzmx.zzf(obj, j);
                        iZzA6 = zzjl.zzA(i4 << 3);
                        iZzd = zzjdVar2.zzd();
                        iZzA7 = zzjl.zzA(iZzd);
                        i = iZzA6 + iZzA7 + iZzd;
                        i2 += i;
                    }
                    break;
                case 62:
                    if (zzR(obj, i4, i3)) {
                        int iZzr2 = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzA(iZzr2);
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i4, i3)) {
                        int iZzr3 = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzv(iZzr3);
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 64:
                    if (zzR(obj, i4, i3)) {
                        iZzA2 = zzjl.zzA(i4 << 3);
                        iZzo = iZzA2 + 4;
                        i2 += iZzo;
                    }
                    break;
                case 65:
                    if (zzR(obj, i4, i3)) {
                        iZzA = zzjl.zzA(i4 << 3);
                        iZzo = iZzA + 8;
                        i2 += iZzo;
                    }
                    break;
                case 66:
                    if (zzR(obj, i4, i3)) {
                        int iZzr4 = zzr(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzA((iZzr4 >> 31) ^ (iZzr4 + iZzr4));
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 67:
                    if (zzR(obj, i4, i3)) {
                        long jZzC3 = zzC(obj, j);
                        iZzA4 = zzjl.zzA(i4 << 3);
                        iZzv = zzjl.zzB((jZzC3 >> 63) ^ (jZzC3 + jZzC3));
                        i = iZzA4 + iZzv;
                        i2 += i;
                    }
                    break;
                case 68:
                    if (zzR(obj, i4, i3)) {
                        iZzo = zzjl.zzu(i4, (zzll) zzmx.zzf(obj, j), zzE(i3));
                        i2 += iZzo;
                    }
                    break;
            }
        }
        zzmn zzmnVar = this.zzn;
        return i2 + zzmnVar.zza(zzmnVar.zzc(obj));
    }

    private static int zzr(Object obj, long j) {
        return ((Integer) zzmx.zzf(obj, j)).intValue();
    }

    private final int zzs(Object obj, byte[] bArr, int i, int i2, int i3, long j, zziq zziqVar) throws IOException {
        Unsafe unsafe = zzb;
        Object objZzF = zzF(i3);
        Object object = unsafe.getObject(obj, j);
        if (!((zzlf) object).zze()) {
            zzlf zzlfVarZzb = zzlf.zza().zzb();
            zzlg.zzb(zzlfVarZzb, object);
            unsafe.putObject(obj, j, zzlfVarZzb);
        }
        throw null;
    }

    private final int zzt(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zziq zziqVar) throws IOException {
        Object object;
        Unsafe unsafe = zzb;
        long j2 = this.zzc[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(zzir.zzn(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(zzir.zzb(bArr, i))));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iZzm = zzir.zzm(bArr, i, zziqVar);
                unsafe.putObject(obj, j, Long.valueOf(zziqVar.zzb));
                unsafe.putInt(obj, j2, i4);
                return iZzm;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iZzj = zzir.zzj(bArr, i, zziqVar);
                unsafe.putObject(obj, j, Integer.valueOf(zziqVar.zza));
                unsafe.putInt(obj, j2, i4);
                return iZzj;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(zzir.zzn(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 8;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(zzir.zzb(bArr, i)));
                unsafe.putInt(obj, j2, i4);
                return i + 4;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iZzm2 = zzir.zzm(bArr, i, zziqVar);
                unsafe.putObject(obj, j, Boolean.valueOf(zziqVar.zzb != 0));
                unsafe.putInt(obj, j2, i4);
                return iZzm2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iZzj2 = zzir.zzj(bArr, i, zziqVar);
                int i9 = zziqVar.zza;
                if (i9 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0 && !zznc.zzf(bArr, iZzj2, iZzj2 + i9)) {
                        throw zzko.zzc();
                    }
                    unsafe.putObject(obj, j, new String(bArr, iZzj2, i9, zzkm.zzb));
                    iZzj2 += i9;
                }
                unsafe.putInt(obj, j2, i4);
                return iZzj2;
            case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                if (i5 != 2) {
                    return i;
                }
                int iZzd = zzir.zzd(zzE(i8), bArr, i, i2, zziqVar);
                object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, zziqVar.zzc);
                } else {
                    unsafe.putObject(obj, j, zzkm.zzg(object, zziqVar.zzc));
                }
                unsafe.putInt(obj, j2, i4);
                return iZzd;
            case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                if (i5 != 2) {
                    return i;
                }
                int iZza = zzir.zza(bArr, i, zziqVar);
                unsafe.putObject(obj, j, zziqVar.zzc);
                unsafe.putInt(obj, j2, i4);
                return iZza;
            case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                if (i5 != 0) {
                    return i;
                }
                int iZzj3 = zzir.zzj(bArr, i, zziqVar);
                int i10 = zziqVar.zza;
                zzki zzkiVarZzD = zzD(i8);
                if (zzkiVarZzD != null && !zzkiVarZzD.zza(i10)) {
                    zzd(obj).zzh(i3, Long.valueOf(i10));
                    return iZzj3;
                }
                unsafe.putObject(obj, j, Integer.valueOf(i10));
                unsafe.putInt(obj, j2, i4);
                return iZzj3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iZzj4 = zzir.zzj(bArr, i, zziqVar);
                unsafe.putObject(obj, j, Integer.valueOf(zzjh.zzb(zziqVar.zza)));
                unsafe.putInt(obj, j2, i4);
                return iZzj4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iZzm3 = zzir.zzm(bArr, i, zziqVar);
                unsafe.putObject(obj, j, Long.valueOf(zzjh.zzc(zziqVar.zzb)));
                unsafe.putInt(obj, j2, i4);
                return iZzm3;
            case 68:
                if (i5 == 3) {
                    int iZzc = zzir.zzc(zzE(i8), bArr, i, i2, (i3 & (-8)) | 4, zziqVar);
                    object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                    if (object == null) {
                        unsafe.putObject(obj, j, zziqVar.zzc);
                    } else {
                        unsafe.putObject(obj, j, zzkm.zzg(object, zziqVar.zzc));
                    }
                    unsafe.putInt(obj, j2, i4);
                    return iZzc;
                }
                break;
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0080. Please report as an issue. */
    private final int zzu(Object obj, byte[] bArr, int i, int i2, zziq zziqVar) throws IOException {
        Unsafe unsafe;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        this = this;
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i13 = i2;
        zziqVar = zziqVar;
        Unsafe unsafe2 = zzb;
        int i14 = -1;
        int iZzm = i;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1048575;
        while (iZzm < i13) {
            int iZzk = iZzm + 1;
            int i19 = bArr2[iZzm];
            if (i19 < 0) {
                iZzk = zzir.zzk(i19, bArr2, iZzk, zziqVar);
                i19 = zziqVar.zza;
            }
            int i20 = iZzk;
            int i21 = i19 >>> 3;
            int i22 = i19 & 7;
            int iZzx = i21 > i15 ? this.zzx(i21, i16 / 3) : this.zzw(i21);
            if (iZzx == i14) {
                unsafe = unsafe2;
                i3 = i19;
                i4 = i14;
                i5 = i21;
                i6 = 0;
                obj = obj2;
            } else {
                int[] iArr = this.zzc;
                int i23 = iArr[iZzx + 1];
                int iZzA = zzA(i23);
                int i24 = i19;
                int i25 = iZzx;
                long j = i23 & 1048575;
                if (iZzA <= 17) {
                    int i26 = iArr[i25 + 2];
                    int i27 = 1 << (i26 >>> 20);
                    int i28 = i26 & 1048575;
                    if (i28 != i18) {
                        int i29 = 1048575;
                        if (i18 != 1048575) {
                            unsafe2.putInt(obj2, i18, i17);
                            i29 = 1048575;
                        }
                        if (i28 != i29) {
                            i17 = unsafe2.getInt(obj2, i28);
                        }
                        i18 = i28;
                    }
                    switch (iZzA) {
                        case 0:
                            i12 = i25;
                            if (i22 != 1) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                zzmx.zzo(obj2, j, Double.longBitsToDouble(zzir.zzn(bArr2, i20)));
                                iZzm = i20 + 8;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 1:
                            i12 = i25;
                            if (i22 != 5) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                zzmx.zzp(obj2, j, Float.intBitsToFloat(zzir.zzb(bArr2, i20)));
                                iZzm = i20 + 4;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 2:
                        case 3:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                int iZzm2 = zzir.zzm(bArr2, i20, zziqVar);
                                Unsafe unsafe3 = unsafe2;
                                Object obj3 = obj2;
                                unsafe3.putLong(obj3, j, zziqVar.zzb);
                                unsafe2 = unsafe3;
                                obj2 = obj3;
                                i17 |= i27;
                                iZzm = iZzm2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                                i13 = i2;
                            }
                            break;
                        case 4:
                        case 11:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                int iZzj = zzir.zzj(bArr2, i20, zziqVar);
                                unsafe2.putInt(obj2, j, zziqVar.zza);
                                i17 |= i27;
                                i13 = i2;
                                iZzm = iZzj;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 5:
                        case 14:
                            i12 = i25;
                            if (i22 != 1) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                Unsafe unsafe4 = unsafe2;
                                Object obj4 = obj2;
                                unsafe4.putLong(obj4, j, zzir.zzn(bArr2, i20));
                                unsafe2 = unsafe4;
                                obj2 = obj4;
                                iZzm = i20 + 8;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 6:
                        case 13:
                            i12 = i25;
                            if (i22 != 5) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                unsafe2.putInt(obj2, j, zzir.zzb(bArr2, i20));
                                iZzm = i20 + 4;
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 7:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzir.zzm(bArr2, i20, zziqVar);
                                zzmx.zzm(obj2, j, zziqVar.zzb != 0);
                                i17 |= i27;
                                i13 = i2;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 8:
                            i12 = i25;
                            if (i22 != 2) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = (536870912 & i23) == 0 ? zzir.zzg(bArr2, i20, zziqVar) : zzir.zzh(bArr2, i20, zziqVar);
                                unsafe2.putObject(obj2, j, zziqVar.zzc);
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 9:
                            i12 = i25;
                            if (i22 != 2) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzir.zzd(this.zzE(i12), bArr2, i20, i13, zziqVar);
                                Object object = unsafe2.getObject(obj2, j);
                                if (object == null) {
                                    unsafe2.putObject(obj2, j, zziqVar.zzc);
                                } else {
                                    unsafe2.putObject(obj2, j, zzkm.zzg(object, zziqVar.zzc));
                                }
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 10:
                            i12 = i25;
                            if (i22 != 2) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzir.zza(bArr2, i20, zziqVar);
                                unsafe2.putObject(obj2, j, zziqVar.zzc);
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 12:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzir.zzj(bArr2, i20, zziqVar);
                                unsafe2.putInt(obj2, j, zziqVar.zza);
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 15:
                            i12 = i25;
                            if (i22 != 0) {
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                iZzm = zzir.zzj(bArr2, i20, zziqVar);
                                unsafe2.putInt(obj2, j, zzjh.zzb(zziqVar.zza));
                                i17 |= i27;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        case 16:
                            if (i22 != 0) {
                                i12 = i25;
                                obj = obj2;
                                unsafe = unsafe2;
                                i5 = i21;
                                i6 = i12;
                                i4 = -1;
                                i3 = i24 == true ? 1 : 0;
                            } else {
                                int iZzm3 = zzir.zzm(bArr2, i20, zziqVar);
                                Unsafe unsafe5 = unsafe2;
                                Object obj5 = obj2;
                                i12 = i25;
                                unsafe5.putLong(obj5, j, zzjh.zzc(zziqVar.zzb));
                                unsafe2 = unsafe5;
                                obj2 = obj5;
                                i17 |= i27;
                                iZzm = iZzm3;
                                i15 = i21;
                                i16 = i12;
                                i14 = -1;
                            }
                            break;
                        default:
                            i12 = i25;
                            obj = obj2;
                            unsafe = unsafe2;
                            i5 = i21;
                            i6 = i12;
                            i4 = -1;
                            i3 = i24 == true ? 1 : 0;
                            break;
                    }
                } else {
                    i6 = i25;
                    if (iZzA != 27) {
                        i7 = i20;
                        Unsafe unsafe6 = unsafe2;
                        if (iZzA <= 49) {
                            i8 = i17;
                            unsafe = unsafe6;
                            i4 = -1;
                            i10 = i18;
                            int iZzv = this.zzv(obj, bArr, i7, i2, i24 == true ? 1 : 0, i21, i22, i6, i23, iZzA, j, zziqVar);
                            i9 = i24 == true ? 1 : 0;
                            i11 = i21;
                            if (iZzv != i7) {
                                obj2 = obj;
                                iZzm = iZzv;
                                i16 = i6;
                                i15 = i11;
                                i18 = i10;
                                i14 = i4;
                                i17 = i8;
                                unsafe2 = unsafe;
                                bArr2 = bArr;
                                i13 = i2;
                            } else {
                                i20 = iZzv;
                                i5 = i11;
                                i3 = i9;
                            }
                        } else {
                            i8 = i17;
                            unsafe = unsafe6;
                            i4 = -1;
                            i9 = i24 == true ? 1 : 0;
                            i10 = i18;
                            i11 = i21;
                            if (iZzA == 50) {
                                if (i22 == 2) {
                                    int iZzs = zzs(obj, bArr, i7, i2, i6, j, zziqVar);
                                    i6 = i6;
                                    if (iZzs != i7) {
                                        this = this;
                                        obj2 = obj;
                                        bArr2 = bArr;
                                        zziqVar = zziqVar;
                                        iZzm = iZzs;
                                        i16 = i6;
                                        i15 = i11;
                                        i18 = i10;
                                        i14 = -1;
                                        i17 = i8;
                                        unsafe2 = unsafe;
                                        i13 = i2;
                                    } else {
                                        i20 = iZzs;
                                    }
                                } else {
                                    i6 = i6;
                                    i20 = i7;
                                }
                                i5 = i11;
                                i3 = i9;
                            } else {
                                i5 = i11;
                                int iZzt = zzt(obj, bArr, i7, i2, i9 == true ? 1 : 0, i5, i22, i23, iZzA, j, i6, zziqVar);
                                obj = obj;
                                i3 = i9 == true ? 1 : 0;
                                i6 = i6;
                                if (iZzt != i7) {
                                    i15 = i5;
                                    iZzm = iZzt;
                                    i16 = i6;
                                    obj2 = obj;
                                    i18 = i10;
                                    i14 = i4;
                                    i17 = i8;
                                    unsafe2 = unsafe;
                                    bArr2 = bArr;
                                    i13 = i2;
                                } else {
                                    i20 = iZzt;
                                }
                            }
                        }
                    } else if (i22 == 2) {
                        zzkl zzklVarZzd = (zzkl) unsafe2.getObject(obj2, j);
                        if (!zzklVarZzd.zzc()) {
                            int size = zzklVarZzd.size();
                            zzklVarZzd = zzklVarZzd.zzd(size == 0 ? 10 : size + size);
                            unsafe2.putObject(obj2, j, zzklVarZzd);
                        }
                        int iZze = zzir.zze(this.zzE(i6), i24 == true ? 1 : 0, bArr2, i20, i2, zzklVarZzd, zziqVar);
                        bArr2 = bArr;
                        zziqVar = zziqVar;
                        iZzm = iZze;
                        i16 = i6;
                        unsafe2 = unsafe2;
                        i15 = i21;
                        i14 = -1;
                        obj2 = obj;
                        i13 = i2;
                    } else {
                        i7 = i20;
                        i10 = i18;
                        i8 = i17;
                        unsafe = unsafe2;
                        i11 = i21;
                        i4 = -1;
                        i9 = i24 == true ? 1 : 0;
                        i20 = i7;
                        i5 = i11;
                        i3 = i9;
                    }
                    i18 = i10;
                    i17 = i8;
                }
            }
            int iZzi = zzir.zzi(i3 == true ? 1 : 0, bArr, i20, i2, zzd(obj), zziqVar);
            bArr2 = bArr;
            zziqVar = zziqVar;
            i15 = i5;
            i16 = i6;
            obj2 = obj;
            i14 = i4;
            unsafe2 = unsafe;
            i13 = i2;
            iZzm = iZzi;
            this = this;
        }
        Object obj6 = obj2;
        Unsafe unsafe7 = unsafe2;
        int i30 = i13;
        int i31 = i18;
        int i32 = i17;
        if (i31 != 1048575) {
            unsafe7.putInt(obj6, i31, i32);
        }
        if (iZzm == i30) {
            return iZzm;
        }
        throw zzko.zze();
    }

    private final int zzv(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, zziq zziqVar) throws IOException {
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzl;
        int iZzj = i;
        int i12 = i2;
        Unsafe unsafe = zzb;
        zzkl zzklVarZzd = (zzkl) unsafe.getObject(obj, j2);
        if (!zzklVarZzd.zzc()) {
            int size = zzklVarZzd.size();
            zzklVarZzd = zzklVarZzd.zzd(size == 0 ? 10 : size + size);
            unsafe.putObject(obj, j2, zzklVarZzd);
        }
        switch (i7) {
            case 18:
            case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                if (i5 == 2) {
                    zzjn zzjnVar = (zzjn) zzklVarZzd;
                    int iZzj2 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i13 = zziqVar.zza + iZzj2;
                    while (iZzj2 < i13) {
                        zzjnVar.zze(Double.longBitsToDouble(zzir.zzn(bArr, iZzj2)));
                        iZzj2 += 8;
                    }
                    if (iZzj2 == i13) {
                        return iZzj2;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 1) {
                    zzjn zzjnVar2 = (zzjn) zzklVarZzd;
                    zzjnVar2.zze(Double.longBitsToDouble(zzir.zzn(bArr, i)));
                    while (true) {
                        i8 = iZzj + 8;
                        if (i8 < i12) {
                            iZzj = zzir.zzj(bArr, i8, zziqVar);
                            if (i3 == zziqVar.zza) {
                                zzjnVar2.zze(Double.longBitsToDouble(zzir.zzn(bArr, iZzj)));
                            }
                        }
                    }
                    return i8;
                }
                return i;
            case 19:
            case 36:
                if (i5 == 2) {
                    zzjx zzjxVar = (zzjx) zzklVarZzd;
                    int iZzj3 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i14 = zziqVar.zza + iZzj3;
                    while (iZzj3 < i14) {
                        zzjxVar.zze(Float.intBitsToFloat(zzir.zzb(bArr, iZzj3)));
                        iZzj3 += 4;
                    }
                    if (iZzj3 == i14) {
                        return iZzj3;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 5) {
                    zzjx zzjxVar2 = (zzjx) zzklVarZzd;
                    zzjxVar2.zze(Float.intBitsToFloat(zzir.zzb(bArr, i)));
                    while (true) {
                        i9 = iZzj + 4;
                        if (i9 < i12) {
                            iZzj = zzir.zzj(bArr, i9, zziqVar);
                            if (i3 == zziqVar.zza) {
                                zzjxVar2.zze(Float.intBitsToFloat(zzir.zzb(bArr, iZzj)));
                            }
                        }
                    }
                    return i9;
                }
                return i;
            case 20:
            case 21:
            case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
            case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                if (i5 == 2) {
                    zzla zzlaVar = (zzla) zzklVarZzd;
                    int iZzj4 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i15 = zziqVar.zza + iZzj4;
                    while (iZzj4 < i15) {
                        iZzj4 = zzir.zzm(bArr, iZzj4, zziqVar);
                        zzlaVar.zzg(zziqVar.zzb);
                    }
                    if (iZzj4 == i15) {
                        return iZzj4;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 0) {
                    zzla zzlaVar2 = (zzla) zzklVarZzd;
                    int iZzm = zzir.zzm(bArr, iZzj, zziqVar);
                    zzlaVar2.zzg(zziqVar.zzb);
                    while (iZzm < i12) {
                        int iZzj5 = zzir.zzj(bArr, iZzm, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzm;
                        }
                        iZzm = zzir.zzm(bArr, iZzj5, zziqVar);
                        zzlaVar2.zzg(zziqVar.zzb);
                    }
                    return iZzm;
                }
                return i;
            case 22:
            case 29:
            case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                if (i5 == 2) {
                    return zzir.zzf(bArr, iZzj, zzklVarZzd, zziqVar);
                }
                if (i5 == 0) {
                    return zzir.zzl(i3, bArr, iZzj, i12, zzklVarZzd, zziqVar);
                }
                return i;
            case 23:
            case 32:
            case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                if (i5 == 2) {
                    zzla zzlaVar3 = (zzla) zzklVarZzd;
                    int iZzj6 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i16 = zziqVar.zza + iZzj6;
                    while (iZzj6 < i16) {
                        zzlaVar3.zzg(zzir.zzn(bArr, iZzj6));
                        iZzj6 += 8;
                    }
                    if (iZzj6 == i16) {
                        return iZzj6;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 1) {
                    zzla zzlaVar4 = (zzla) zzklVarZzd;
                    zzlaVar4.zzg(zzir.zzn(bArr, i));
                    while (true) {
                        i10 = iZzj + 8;
                        if (i10 < i12) {
                            iZzj = zzir.zzj(bArr, i10, zziqVar);
                            if (i3 == zziqVar.zza) {
                                zzlaVar4.zzg(zzir.zzn(bArr, iZzj));
                            }
                        }
                    }
                    return i10;
                }
                return i;
            case 24:
            case 31:
            case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                if (i5 == 2) {
                    zzkf zzkfVar = (zzkf) zzklVarZzd;
                    int iZzj7 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i17 = zziqVar.zza + iZzj7;
                    while (iZzj7 < i17) {
                        zzkfVar.zzh(zzir.zzb(bArr, iZzj7));
                        iZzj7 += 4;
                    }
                    if (iZzj7 == i17) {
                        return iZzj7;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 5) {
                    zzkf zzkfVar2 = (zzkf) zzklVarZzd;
                    zzkfVar2.zzh(zzir.zzb(bArr, i));
                    while (true) {
                        i11 = iZzj + 4;
                        if (i11 < i12) {
                            iZzj = zzir.zzj(bArr, i11, zziqVar);
                            if (i3 == zziqVar.zza) {
                                zzkfVar2.zzh(zzir.zzb(bArr, iZzj));
                            }
                        }
                    }
                    return i11;
                }
                return i;
            case 25:
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                if (i5 == 2) {
                    zzis zzisVar = (zzis) zzklVarZzd;
                    int iZzj8 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i18 = zziqVar.zza + iZzj8;
                    while (iZzj8 < i18) {
                        iZzj8 = zzir.zzm(bArr, iZzj8, zziqVar);
                        zzisVar.zze(zziqVar.zzb != 0);
                    }
                    if (iZzj8 == i18) {
                        return iZzj8;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 0) {
                    zzis zzisVar2 = (zzis) zzklVarZzd;
                    int iZzm2 = zzir.zzm(bArr, iZzj, zziqVar);
                    zzisVar2.zze(zziqVar.zzb != 0);
                    while (iZzm2 < i12) {
                        int iZzj9 = zzir.zzj(bArr, iZzm2, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzm2;
                        }
                        iZzm2 = zzir.zzm(bArr, iZzj9, zziqVar);
                        zzisVar2.zze(zziqVar.zzb != 0);
                    }
                    return iZzm2;
                }
                return i;
            case 26:
                if (i5 == 2) {
                    if ((j & 536870912) == 0) {
                        int iZzj10 = zzir.zzj(bArr, iZzj, zziqVar);
                        int i19 = zziqVar.zza;
                        if (i19 < 0) {
                            throw zzko.zzd();
                        }
                        if (i19 == 0) {
                            zzklVarZzd.add("");
                        } else {
                            zzklVarZzd.add(new String(bArr, iZzj10, i19, zzkm.zzb));
                            iZzj10 += i19;
                        }
                        while (iZzj10 < i12) {
                            int iZzj11 = zzir.zzj(bArr, iZzj10, zziqVar);
                            if (i3 != zziqVar.zza) {
                                return iZzj10;
                            }
                            iZzj10 = zzir.zzj(bArr, iZzj11, zziqVar);
                            int i20 = zziqVar.zza;
                            if (i20 < 0) {
                                throw zzko.zzd();
                            }
                            if (i20 == 0) {
                                zzklVarZzd.add("");
                            } else {
                                zzklVarZzd.add(new String(bArr, iZzj10, i20, zzkm.zzb));
                                iZzj10 += i20;
                            }
                        }
                        return iZzj10;
                    }
                    int iZzj12 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i21 = zziqVar.zza;
                    if (i21 < 0) {
                        throw zzko.zzd();
                    }
                    if (i21 == 0) {
                        zzklVarZzd.add("");
                    } else {
                        int i22 = iZzj12 + i21;
                        if (!zznc.zzf(bArr, iZzj12, i22)) {
                            throw zzko.zzc();
                        }
                        zzklVarZzd.add(new String(bArr, iZzj12, i21, zzkm.zzb));
                        iZzj12 = i22;
                    }
                    while (iZzj12 < i12) {
                        int iZzj13 = zzir.zzj(bArr, iZzj12, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzj12;
                        }
                        iZzj12 = zzir.zzj(bArr, iZzj13, zziqVar);
                        int i23 = zziqVar.zza;
                        if (i23 < 0) {
                            throw zzko.zzd();
                        }
                        if (i23 == 0) {
                            zzklVarZzd.add("");
                        } else {
                            int i24 = iZzj12 + i23;
                            if (!zznc.zzf(bArr, iZzj12, i24)) {
                                throw zzko.zzc();
                            }
                            zzklVarZzd.add(new String(bArr, iZzj12, i23, zzkm.zzb));
                            iZzj12 = i24;
                        }
                    }
                    return iZzj12;
                }
                return i;
            case 27:
                if (i5 == 2) {
                    return zzir.zze(zzE(i6), i3, bArr, iZzj, i12, zzklVarZzd, zziqVar);
                }
                return i;
            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                if (i5 == 2) {
                    int iZzj14 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i25 = zziqVar.zza;
                    if (i25 < 0) {
                        throw zzko.zzd();
                    }
                    if (i25 > bArr.length - iZzj14) {
                        throw zzko.zzf();
                    }
                    if (i25 == 0) {
                        zzklVarZzd.add(zzjd.zzb);
                    } else {
                        zzklVarZzd.add(zzjd.zzl(bArr, iZzj14, i25));
                        iZzj14 += i25;
                    }
                    while (iZzj14 < i12) {
                        int iZzj15 = zzir.zzj(bArr, iZzj14, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzj14;
                        }
                        iZzj14 = zzir.zzj(bArr, iZzj15, zziqVar);
                        int i26 = zziqVar.zza;
                        if (i26 < 0) {
                            throw zzko.zzd();
                        }
                        if (i26 > bArr.length - iZzj14) {
                            throw zzko.zzf();
                        }
                        if (i26 == 0) {
                            zzklVarZzd.add(zzjd.zzb);
                        } else {
                            zzklVarZzd.add(zzjd.zzl(bArr, iZzj14, i26));
                            iZzj14 += i26;
                        }
                    }
                    return iZzj14;
                }
                return i;
            case 30:
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                if (i5 != 2) {
                    if (i5 == 0) {
                        iZzl = zzir.zzl(i3, bArr, iZzj, i12, zzklVarZzd, zziqVar);
                    }
                    return i;
                }
                iZzl = zzir.zzf(bArr, iZzj, zzklVarZzd, zziqVar);
                zzke zzkeVar = (zzke) obj;
                zzmo zzmoVar = zzkeVar.zzc;
                if (zzmoVar == zzmo.zzc()) {
                    zzmoVar = null;
                }
                Object objZzC = zzly.zzC(i4, zzklVarZzd, zzD(i6), zzmoVar, this.zzn);
                if (objZzC == null) {
                    return iZzl;
                }
                zzkeVar.zzc = (zzmo) objZzC;
                return iZzl;
            case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                if (i5 == 2) {
                    zzkf zzkfVar3 = (zzkf) zzklVarZzd;
                    int iZzj16 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i27 = zziqVar.zza + iZzj16;
                    while (iZzj16 < i27) {
                        iZzj16 = zzir.zzj(bArr, iZzj16, zziqVar);
                        zzkfVar3.zzh(zzjh.zzb(zziqVar.zza));
                    }
                    if (iZzj16 == i27) {
                        return iZzj16;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 0) {
                    zzkf zzkfVar4 = (zzkf) zzklVarZzd;
                    int iZzj17 = zzir.zzj(bArr, iZzj, zziqVar);
                    zzkfVar4.zzh(zzjh.zzb(zziqVar.zza));
                    while (iZzj17 < i12) {
                        int iZzj18 = zzir.zzj(bArr, iZzj17, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzj17;
                        }
                        iZzj17 = zzir.zzj(bArr, iZzj18, zziqVar);
                        zzkfVar4.zzh(zzjh.zzb(zziqVar.zza));
                    }
                    return iZzj17;
                }
                return i;
            case 34:
            case 48:
                if (i5 == 2) {
                    zzla zzlaVar5 = (zzla) zzklVarZzd;
                    int iZzj19 = zzir.zzj(bArr, iZzj, zziqVar);
                    int i28 = zziqVar.zza + iZzj19;
                    while (iZzj19 < i28) {
                        iZzj19 = zzir.zzm(bArr, iZzj19, zziqVar);
                        zzlaVar5.zzg(zzjh.zzc(zziqVar.zzb));
                    }
                    if (iZzj19 == i28) {
                        return iZzj19;
                    }
                    throw zzko.zzf();
                }
                if (i5 == 0) {
                    zzla zzlaVar6 = (zzla) zzklVarZzd;
                    int iZzm3 = zzir.zzm(bArr, iZzj, zziqVar);
                    zzlaVar6.zzg(zzjh.zzc(zziqVar.zzb));
                    while (iZzm3 < i12) {
                        int iZzj20 = zzir.zzj(bArr, iZzm3, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzm3;
                        }
                        iZzm3 = zzir.zzm(bArr, iZzj20, zziqVar);
                        zzlaVar6.zzg(zzjh.zzc(zziqVar.zzb));
                    }
                    return iZzm3;
                }
                return i;
            default:
                if (i5 == 3) {
                    zzlw zzlwVarZzE = zzE(i6);
                    int i29 = (i3 & (-8)) | 4;
                    int iZzc = zzir.zzc(zzlwVarZzE, bArr, iZzj, i12, i29, zziqVar);
                    zzklVarZzd.add(zziqVar.zzc);
                    while (iZzc < i12) {
                        int iZzj21 = zzir.zzj(bArr, iZzc, zziqVar);
                        if (i3 != zziqVar.zza) {
                            return iZzc;
                        }
                        iZzc = zzir.zzc(zzlwVarZzE, bArr, iZzj21, i12, i29, zziqVar);
                        zzklVarZzd.add(zziqVar.zzc);
                        i12 = i2;
                    }
                    return iZzc;
                }
                return i;
        }
    }

    private final int zzw(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, 0);
    }

    private final int zzx(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzz(i, i2);
    }

    private final int zzy(int i) {
        return this.zzc[i + 2];
    }

    private final int zzz(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
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

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zza(Object obj) {
        return this.zzi ? zzq(obj) : zzp(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final int zzb(Object obj) {
        int i;
        int iZzc;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzB = zzB(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzB;
            int iHashCode = 37;
            switch (zzA(iZzB)) {
                case 0:
                    i = i2 * 53;
                    iZzc = zzkm.zzc(Double.doubleToLongBits(zzmx.zza(obj, j)));
                    i2 = i + iZzc;
                    break;
                case 1:
                    i = i2 * 53;
                    iZzc = Float.floatToIntBits(zzmx.zzb(obj, j));
                    i2 = i + iZzc;
                    break;
                case 2:
                    i = i2 * 53;
                    iZzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 3:
                    i = i2 * 53;
                    iZzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 4:
                    i = i2 * 53;
                    iZzc = zzmx.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 5:
                    i = i2 * 53;
                    iZzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 6:
                    i = i2 * 53;
                    iZzc = zzmx.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 7:
                    i = i2 * 53;
                    iZzc = zzkm.zza(zzmx.zzw(obj, j));
                    i2 = i + iZzc;
                    break;
                case 8:
                    i = i2 * 53;
                    iZzc = ((String) zzmx.zzf(obj, j)).hashCode();
                    i2 = i + iZzc;
                    break;
                case 9:
                    Object objZzf = zzmx.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iZzc = zzmx.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 11:
                    i = i2 * 53;
                    iZzc = zzmx.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 12:
                    i = i2 * 53;
                    iZzc = zzmx.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 13:
                    i = i2 * 53;
                    iZzc = zzmx.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 14:
                    i = i2 * 53;
                    iZzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 15:
                    i = i2 * 53;
                    iZzc = zzmx.zzc(obj, j);
                    i2 = i + iZzc;
                    break;
                case 16:
                    i = i2 * 53;
                    iZzc = zzkm.zzc(zzmx.zzd(obj, j));
                    i2 = i + iZzc;
                    break;
                case 17:
                    Object objZzf2 = zzmx.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
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
                    i = i2 * 53;
                    iZzc = zzmx.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 50:
                    i = i2 * 53;
                    iZzc = zzmx.zzf(obj, j).hashCode();
                    i2 = i + iZzc;
                    break;
                case 51:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zzc(Double.doubleToLongBits(zzn(obj, j)));
                        i2 = i + iZzc;
                    }
                    break;
                case 52:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = Float.floatToIntBits(zzo(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 53:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 54:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 55:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 56:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 57:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 58:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zza(zzS(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 59:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = ((String) zzmx.zzf(obj, j)).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzmx.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzmx.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
                case 62:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 64:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 65:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 66:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzr(obj, j);
                        i2 = i + iZzc;
                    }
                    break;
                case 67:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzkm.zzc(zzC(obj, j));
                        i2 = i + iZzc;
                    }
                    break;
                case 68:
                    if (zzR(obj, i4, i3)) {
                        i = i2 * 53;
                        iZzc = zzmx.zzf(obj, j).hashCode();
                        i2 = i + iZzc;
                    }
                    break;
            }
        }
        int iHashCode2 = (i2 * 53) + this.zzn.zzc(obj).hashCode();
        if (!this.zzh) {
            return iHashCode2;
        }
        this.zzo.zza(obj);
        throw null;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12181. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzc(java.lang.Object r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zziq r34) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzlo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zziq):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final Object zze() {
        return ((zzke) this.zzg).zzl(4, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzf(Object obj) {
        int i;
        int i2 = this.zzk;
        while (true) {
            i = this.zzl;
            if (i2 >= i) {
                break;
            }
            long jZzB = zzB(this.zzj[i2]) & 1048575;
            Object objZzf = zzmx.zzf(obj, jZzB);
            if (objZzf != null) {
                ((zzlf) objZzf).zzc();
                zzmx.zzs(obj, jZzB, objZzf);
            }
            i2++;
        }
        int length = this.zzj.length;
        while (i < length) {
            this.zzm.zza(obj, this.zzj[i]);
            i++;
        }
        this.zzn.zzg(obj);
        if (this.zzh) {
            this.zzo.zzb(obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zziq zziqVar) throws IOException {
        if (this.zzi) {
            zzu(obj, bArr, i, i2, zziqVar);
        } else {
            zzc(obj, bArr, i, i2, 0, zziqVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzi(Object obj, zznf zznfVar) throws IOException {
        if (!this.zzi) {
            zzL(obj, zznfVar);
            return;
        }
        if (this.zzh) {
            this.zzo.zza(obj);
            throw null;
        }
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            int i2 = this.zzc[i];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzO(obj, i)) {
                        zznfVar.zzf(i2, zzmx.zza(obj, iZzB & 1048575));
                    }
                    break;
                case 1:
                    if (zzO(obj, i)) {
                        zznfVar.zzo(i2, zzmx.zzb(obj, iZzB & 1048575));
                    }
                    break;
                case 2:
                    if (zzO(obj, i)) {
                        zznfVar.zzt(i2, zzmx.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 3:
                    if (zzO(obj, i)) {
                        zznfVar.zzJ(i2, zzmx.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 4:
                    if (zzO(obj, i)) {
                        zznfVar.zzr(i2, zzmx.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 5:
                    if (zzO(obj, i)) {
                        zznfVar.zzm(i2, zzmx.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 6:
                    if (zzO(obj, i)) {
                        zznfVar.zzk(i2, zzmx.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 7:
                    if (zzO(obj, i)) {
                        zznfVar.zzb(i2, zzmx.zzw(obj, iZzB & 1048575));
                    }
                    break;
                case 8:
                    if (zzO(obj, i)) {
                        zzT(i2, zzmx.zzf(obj, iZzB & 1048575), zznfVar);
                    }
                    break;
                case 9:
                    if (zzO(obj, i)) {
                        zznfVar.zzv(i2, zzmx.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
                case 10:
                    if (zzO(obj, i)) {
                        zznfVar.zzd(i2, (zzjd) zzmx.zzf(obj, iZzB & 1048575));
                    }
                    break;
                case 11:
                    if (zzO(obj, i)) {
                        zznfVar.zzH(i2, zzmx.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 12:
                    if (zzO(obj, i)) {
                        zznfVar.zzi(i2, zzmx.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 13:
                    if (zzO(obj, i)) {
                        zznfVar.zzw(i2, zzmx.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 14:
                    if (zzO(obj, i)) {
                        zznfVar.zzy(i2, zzmx.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 15:
                    if (zzO(obj, i)) {
                        zznfVar.zzA(i2, zzmx.zzc(obj, iZzB & 1048575));
                    }
                    break;
                case 16:
                    if (zzO(obj, i)) {
                        zznfVar.zzC(i2, zzmx.zzd(obj, iZzB & 1048575));
                    }
                    break;
                case 17:
                    if (zzO(obj, i)) {
                        zznfVar.zzq(i2, zzmx.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
                case 18:
                    zzly.zzJ(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 19:
                    zzly.zzN(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 20:
                    zzly.zzQ(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 21:
                    zzly.zzY(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 22:
                    zzly.zzP(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 23:
                    zzly.zzM(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 24:
                    zzly.zzL(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 25:
                    zzly.zzH(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 26:
                    zzly.zzW(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar);
                    break;
                case 27:
                    zzly.zzR(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, zzE(i));
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                    zzly.zzI(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar);
                    break;
                case 29:
                    zzly.zzX(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 30:
                    zzly.zzK(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 31:
                    zzly.zzS(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 32:
                    zzly.zzT(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                    zzly.zzU(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case 34:
                    zzly.zzV(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, false);
                    break;
                case MotionEventCompat.AXIS_GENERIC_4 /* 35 */:
                    zzly.zzJ(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case 36:
                    zzly.zzN(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_6 /* 37 */:
                    zzly.zzQ(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_7 /* 38 */:
                    zzly.zzY(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_8 /* 39 */:
                    zzly.zzP(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_9 /* 40 */:
                    zzly.zzM(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_10 /* 41 */:
                    zzly.zzL(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    zzly.zzH(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    zzly.zzX(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    zzly.zzK(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    zzly.zzS(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzly.zzT(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    zzly.zzU(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case 48:
                    zzly.zzV(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, true);
                    break;
                case 49:
                    zzly.zzO(i2, (List) zzmx.zzf(obj, iZzB & 1048575), zznfVar, zzE(i));
                    break;
                case 50:
                    zzM(zznfVar, i2, zzmx.zzf(obj, iZzB & 1048575), i);
                    break;
                case 51:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzf(i2, zzn(obj, iZzB & 1048575));
                    }
                    break;
                case 52:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzo(i2, zzo(obj, iZzB & 1048575));
                    }
                    break;
                case 53:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzt(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 54:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzJ(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 55:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzr(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 56:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzm(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 57:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzk(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 58:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzb(i2, zzS(obj, iZzB & 1048575));
                    }
                    break;
                case 59:
                    if (zzR(obj, i2, i)) {
                        zzT(i2, zzmx.zzf(obj, iZzB & 1048575), zznfVar);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzv(i2, zzmx.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzd(i2, (zzjd) zzmx.zzf(obj, iZzB & 1048575));
                    }
                    break;
                case 62:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzH(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzi(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 64:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzw(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 65:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzy(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 66:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzA(i2, zzr(obj, iZzB & 1048575));
                    }
                    break;
                case 67:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzC(i2, zzC(obj, iZzB & 1048575));
                    }
                    break;
                case 68:
                    if (zzR(obj, i2, i)) {
                        zznfVar.zzq(i2, zzmx.zzf(obj, iZzB & 1048575), zzE(i));
                    }
                    break;
            }
        }
        zzmn zzmnVar = this.zzn;
        zzmnVar.zzi(zzmnVar.zzc(obj), zznfVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzZ;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzB = zzB(i);
            long j = iZzB & 1048575;
            switch (zzA(iZzB)) {
                case 0:
                    if (!zzN(obj, obj2, i) || Double.doubleToLongBits(zzmx.zza(obj, j)) != Double.doubleToLongBits(zzmx.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzN(obj, obj2, i) || Float.floatToIntBits(zzmx.zzb(obj, j)) != Float.floatToIntBits(zzmx.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzN(obj, obj2, i) || zzmx.zzd(obj, j) != zzmx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzN(obj, obj2, i) || zzmx.zzd(obj, j) != zzmx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzN(obj, obj2, i) || zzmx.zzc(obj, j) != zzmx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzN(obj, obj2, i) || zzmx.zzd(obj, j) != zzmx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzN(obj, obj2, i) || zzmx.zzc(obj, j) != zzmx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzN(obj, obj2, i) || zzmx.zzw(obj, j) != zzmx.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzN(obj, obj2, i) || !zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzN(obj, obj2, i) || !zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzN(obj, obj2, i) || !zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzN(obj, obj2, i) || zzmx.zzc(obj, j) != zzmx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzN(obj, obj2, i) || zzmx.zzc(obj, j) != zzmx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzN(obj, obj2, i) || zzmx.zzc(obj, j) != zzmx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzN(obj, obj2, i) || zzmx.zzd(obj, j) != zzmx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzN(obj, obj2, i) || zzmx.zzc(obj, j) != zzmx.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzN(obj, obj2, i) || zzmx.zzd(obj, j) != zzmx.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzN(obj, obj2, i) || !zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
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
                    zZzZ = zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j));
                    break;
                case 50:
                    zZzZ = zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j));
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
                    long jZzy = zzy(i) & 1048575;
                    if (zzmx.zzc(obj, jZzy) != zzmx.zzc(obj2, jZzy) || !zzly.zzZ(zzmx.zzf(obj, j), zzmx.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzZ) {
                return false;
            }
        }
        if (!this.zzn.zzc(obj).equals(this.zzn.zzc(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0093  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b8 A[LOOP:1: B:45:0x00a7->B:50:0x00b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzlw
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzlw zzlwVarZzE;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzk) {
            int i7 = this.zzj[i6];
            int i8 = this.zzc[i7];
            int iZzB = zzB(i7);
            int i9 = this.zzc[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i2 = i5;
                i = i10;
            } else {
                int i12 = i5;
                i = i4;
                i2 = i12;
            }
            if ((268435456 & iZzB) != 0 && !zzP(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzA = zzA(iZzB);
            if (iZzA == 9 || iZzA == 17) {
                if (zzP(obj, i7, i, i2, i11) && !zzQ(obj, iZzB, zzE(i7))) {
                    return false;
                }
            } else if (iZzA == 27) {
                list = (List) zzmx.zzf(obj, iZzB & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzlwVarZzE = zzE(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzlwVarZzE.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzA == 60 || iZzA == 68) {
                if (zzR(obj, i8, i7) && !zzQ(obj, iZzB, zzE(i7))) {
                    return false;
                }
            } else if (iZzA == 49) {
                list = (List) zzmx.zzf(obj, iZzB & 1048575);
                if (list.isEmpty()) {
                    zzlwVarZzE = zzE(i7);
                    while (i3 < list.size()) {
                        if (!zzlwVarZzE.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzA == 50 && !((zzlf) zzmx.zzf(obj, iZzB & 1048575)).isEmpty()) {
                throw null;
            }
            i6++;
            i4 = i;
            i5 = i2;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlw
    public final void zzg(Object obj, Object obj2) {
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzB = zzB(i);
            long j = 1048575 & iZzB;
            int i2 = this.zzc[i];
            switch (zzA(iZzB)) {
                case 0:
                    if (zzO(obj2, i)) {
                        zzmx.zzo(obj, j, zzmx.zza(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 1:
                    if (zzO(obj2, i)) {
                        zzmx.zzp(obj, j, zzmx.zzb(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 2:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 3:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 4:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 5:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 6:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 7:
                    if (zzO(obj2, i)) {
                        zzmx.zzm(obj, j, zzmx.zzw(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 8:
                    if (zzO(obj2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 9:
                    zzH(obj, obj2, i);
                    break;
                case 10:
                    if (zzO(obj2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 11:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 12:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 13:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 14:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 15:
                    if (zzO(obj2, i)) {
                        zzmx.zzq(obj, j, zzmx.zzc(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 16:
                    if (zzO(obj2, i)) {
                        zzmx.zzr(obj, j, zzmx.zzd(obj2, j));
                        zzJ(obj, i);
                    }
                    break;
                case 17:
                    zzH(obj, obj2, i);
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
                    this.zzm.zzb(obj, obj2, j);
                    break;
                case 50:
                    zzly.zzaa(this.zzq, obj, obj2, j);
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
                    if (zzR(obj2, i2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case LockFreeTaskQueueCore.FROZEN_SHIFT /* 60 */:
                    zzI(obj, obj2, i);
                    break;
                case LockFreeTaskQueueCore.CLOSED_SHIFT /* 61 */:
                case 62:
                case HtmlCompat.FROM_HTML_MODE_COMPACT /* 63 */:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i2, i)) {
                        zzmx.zzs(obj, j, zzmx.zzf(obj2, j));
                        zzK(obj, i2, i);
                    }
                    break;
                case 68:
                    zzI(obj, obj2, i);
                    break;
            }
        }
        zzly.zzF(this.zzn, obj, obj2);
        if (this.zzh) {
            zzly.zzE(this.zzo, obj, obj2);
        }
    }
}
