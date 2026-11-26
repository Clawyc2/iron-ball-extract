package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhwd {
    private static final zzhwd zzd = new zzhwd(true);
    final zzhyy zza = new zzhyu();
    boolean zzb;
    boolean zzc;

    private zzhwd() {
    }

    public static zzhwd zza() {
        return zzd;
    }

    static void zzf(zzhvt zzhvtVar, zzhzp zzhzpVar, int i, Object obj) throws IOException {
        if (zzhzpVar == zzhzp.GROUP) {
            zzhvtVar.zzJ(i, 3);
            ((zzhxz) obj).zzdc(zzhvtVar);
            zzhvtVar.zzJ(i, 4);
            return;
        }
        zzhvtVar.zzJ(i, zzhzpVar.zzb());
        zzhzq zzhzqVar = zzhzq.INT;
        switch (zzhzpVar) {
            case DOUBLE:
                zzhvtVar.zzv(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case FLOAT:
                zzhvtVar.zzt(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case INT64:
                zzhvtVar.zzu(((Long) obj).longValue());
                break;
            case UINT64:
                zzhvtVar.zzu(((Long) obj).longValue());
                break;
            case INT32:
                zzhvtVar.zzr(((Integer) obj).intValue());
                break;
            case FIXED64:
                zzhvtVar.zzv(((Long) obj).longValue());
                break;
            case FIXED32:
                zzhvtVar.zzt(((Integer) obj).intValue());
                break;
            case BOOL:
                zzhvtVar.zzq(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case STRING:
                if (!(obj instanceof zzhvi)) {
                    zzhvtVar.zzx((String) obj);
                } else {
                    zzhvtVar.zzl((zzhvi) obj);
                }
                break;
            case GROUP:
                ((zzhxz) obj).zzdc(zzhvtVar);
                break;
            case MESSAGE:
                zzhvtVar.zzp((zzhxz) obj);
                break;
            case BYTES:
                if (!(obj instanceof zzhvi)) {
                    byte[] bArr = (byte[]) obj;
                    zzhvtVar.zzm(bArr, 0, bArr.length);
                } else {
                    zzhvtVar.zzl((zzhvi) obj);
                }
                break;
            case UINT32:
                zzhvtVar.zzs(((Integer) obj).intValue());
                break;
            case ENUM:
                if (!(obj instanceof zzhws)) {
                    zzhvtVar.zzr(((Integer) obj).intValue());
                } else {
                    zzhvtVar.zzr(((zzhws) obj).zza());
                }
                break;
            case SFIXED32:
                zzhvtVar.zzt(((Integer) obj).intValue());
                break;
            case SFIXED64:
                zzhvtVar.zzv(((Long) obj).longValue());
                break;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                zzhvtVar.zzs((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                zzhvtVar.zzu((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    static int zzh(zzhzp zzhzpVar, int i, Object obj) {
        int iZzA = zzhvt.zzA(i << 3);
        if (zzhzpVar == zzhzp.GROUP) {
            iZzA += iZzA;
        }
        return iZzA + zzi(zzhzpVar, obj);
    }

    static int zzi(zzhzp zzhzpVar, Object obj) {
        int iZzc;
        int iZzA;
        zzhzp zzhzpVar2 = zzhzp.DOUBLE;
        zzhzq zzhzqVar = zzhzq.INT;
        switch (zzhzpVar) {
            case DOUBLE:
                ((Double) obj).doubleValue();
                int i = zzhvt.zzf;
                return 8;
            case FLOAT:
                ((Float) obj).floatValue();
                int i2 = zzhvt.zzf;
                return 4;
            case INT64:
                return zzhvt.zzB(((Long) obj).longValue());
            case UINT64:
                return zzhvt.zzB(((Long) obj).longValue());
            case INT32:
                return zzhvt.zzB(((Integer) obj).intValue());
            case FIXED64:
                ((Long) obj).longValue();
                int i3 = zzhvt.zzf;
                return 8;
            case FIXED32:
                ((Integer) obj).intValue();
                int i4 = zzhvt.zzf;
                return 4;
            case BOOL:
                ((Boolean) obj).booleanValue();
                int i5 = zzhvt.zzf;
                return 1;
            case STRING:
                if (!(obj instanceof zzhvi)) {
                    return zzhvt.zzC((String) obj);
                }
                int i6 = zzhvt.zzf;
                iZzc = ((zzhvi) obj).zzc();
                iZzA = zzhvt.zzA(iZzc);
                break;
                break;
            case GROUP:
                return ((zzhxz) obj).zzbr();
            case MESSAGE:
                if (!(obj instanceof zzhxi)) {
                    return zzhvt.zzD((zzhxz) obj);
                }
                iZzc = ((zzhxi) obj).zzb();
                iZzA = zzhvt.zzA(iZzc);
                break;
                break;
            case BYTES:
                if (!(obj instanceof zzhvi)) {
                    int i7 = zzhvt.zzf;
                    iZzc = ((byte[]) obj).length;
                    iZzA = zzhvt.zzA(iZzc);
                } else {
                    int i8 = zzhvt.zzf;
                    iZzc = ((zzhvi) obj).zzc();
                    iZzA = zzhvt.zzA(iZzc);
                }
                break;
            case UINT32:
                return zzhvt.zzA(((Integer) obj).intValue());
            case ENUM:
                return obj instanceof zzhws ? zzhvt.zzB(((zzhws) obj).zza()) : zzhvt.zzB(((Integer) obj).intValue());
            case SFIXED32:
                ((Integer) obj).intValue();
                int i9 = zzhvt.zzf;
                return 4;
            case SFIXED64:
                ((Long) obj).longValue();
                int i10 = zzhvt.zzf;
                return 8;
            case SINT32:
                int iIntValue = ((Integer) obj).intValue();
                return zzhvt.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case SINT64:
                long jLongValue = ((Long) obj).longValue();
                return zzhvt.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzA + iZzc;
    }

    public static int zzj(zzhwc zzhwcVar, Object obj) {
        zzhzp zzhzpVarZzb = zzhwcVar.zzb();
        int iZza = zzhwcVar.zza();
        if (!zzhwcVar.zzd()) {
            return zzh(zzhzpVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzhwcVar.zze()) {
            int iZzh = 0;
            while (i < size) {
                iZzh += zzh(zzhzpVarZzb, iZza, list.get(i));
                i++;
            }
            return iZzh;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzi = 0;
        while (i < size) {
            iZzi += zzi(zzhzpVarZzb, list.get(i));
            i++;
        }
        return zzhvt.zzA(iZza << 3) + iZzi + zzhvt.zzA(iZzi);
    }

    private static boolean zzk(Map.Entry entry) {
        zzhwc zzhwcVar = (zzhwc) entry.getKey();
        if (zzhwcVar.zzc() != zzhzq.MESSAGE) {
            return true;
        }
        if (!zzhwcVar.zzd()) {
            return zzl(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzl(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(Object obj) {
        if (obj instanceof zzhya) {
            return ((zzhya) obj).zzbi();
        }
        if (obj instanceof zzhxi) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzm(Map.Entry entry) {
        int i;
        int iZzA;
        int iZzA2;
        zzhwc zzhwcVar = (zzhwc) entry.getKey();
        Object value = entry.getValue();
        if (zzhwcVar.zzc() != zzhzq.MESSAGE || zzhwcVar.zzd() || zzhwcVar.zze()) {
            return zzj(zzhwcVar, value);
        }
        if (value instanceof zzhxi) {
            int iZza = ((zzhwc) entry.getKey()).zza();
            int iZzA3 = zzhvt.zzA(8);
            i = iZzA3 + iZzA3;
            iZzA = zzhvt.zzA(16) + zzhvt.zzA(iZza);
            int iZzA4 = zzhvt.zzA(24);
            int iZzb = ((zzhxi) value).zzb();
            iZzA2 = iZzA4 + zzhvt.zzA(iZzb) + iZzb;
        } else {
            int iZza2 = ((zzhwc) entry.getKey()).zza();
            int iZzA5 = zzhvt.zzA(8);
            i = iZzA5 + iZzA5;
            iZzA = zzhvt.zzA(16) + zzhvt.zzA(iZza2);
            iZzA2 = zzhvt.zzA(24) + zzhvt.zzD((zzhxz) value);
        }
        return i + iZzA + iZzA2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzn(zzhwc zzhwcVar, Object obj) {
        boolean z;
        zzhwcVar.zzb();
        byte[] bArr = zzhxb.zzb;
        obj.getClass();
        zzhzp zzhzpVar = zzhzp.DOUBLE;
        zzhzq zzhzqVar = zzhzq.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case LONG:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case FLOAT:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case DOUBLE:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case BOOLEAN:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case STRING:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case BYTE_STRING:
                if ((obj instanceof zzhvi) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzhws)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            case MESSAGE:
                if ((obj instanceof zzhxz) || (obj instanceof zzhxi)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzhwcVar.zza()), zzhwcVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhwd zzhwdVar = new zzhwd();
        zzhyy zzhyyVar = this.zza;
        int iZzc = zzhyyVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzd = zzhyyVar.zzd(i);
            zzhwdVar.zzd((zzhwc) ((zzhyv) entryZzd).zza(), entryZzd.getValue());
        }
        for (Map.Entry entry : zzhyyVar.zze()) {
            zzhwdVar.zzd((zzhwc) entry.getKey(), entry.getValue());
        }
        zzhwdVar.zzc = this.zzc;
        return zzhwdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzhwd) {
            return this.zza.equals(((zzhwd) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        zzhyy zzhyyVar = this.zza;
        int iZzc = zzhyyVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzhyyVar.zzd(i).getValue();
            if (value instanceof zzhwo) {
                ((zzhwo) value).zzbm();
            }
        }
        Iterator it = zzhyyVar.zze().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzhwo) {
                ((zzhwo) value2).zzbm();
            }
        }
        zzhyyVar.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzhyy zzhyyVar = this.zza;
        if (zzhyyVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzc ? new zzhxh(zzhyyVar.entrySet().iterator()) : zzhyyVar.entrySet().iterator();
    }

    public final void zzd(zzhwc zzhwcVar, Object obj) {
        if (!zzhwcVar.zzd()) {
            zzn(zzhwcVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzn(zzhwcVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzhxi) {
            this.zzc = true;
        }
        this.zza.put(zzhwcVar, obj);
    }

    public final boolean zze() {
        zzhyy zzhyyVar = this.zza;
        int iZzc = zzhyyVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzk(zzhyyVar.zzd(i))) {
                return false;
            }
        }
        Iterator it = zzhyyVar.zze().iterator();
        while (it.hasNext()) {
            if (!zzk((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int zzg() {
        zzhyy zzhyyVar = this.zza;
        int iZzc = zzhyyVar.zzc();
        int iZzm = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzm += zzm(zzhyyVar.zzd(i));
        }
        Iterator it = zzhyyVar.zze().iterator();
        while (it.hasNext()) {
            iZzm += zzm((Map.Entry) it.next());
        }
        return iZzm;
    }

    private zzhwd(boolean z) {
        zzb();
        zzb();
    }
}
