package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhtx extends AbstractMap implements Serializable {
    private static final Comparator zze = new zzhtq();
    zzhtw zza;
    int zzb;
    int zzc;
    final zzhtw zzd;
    private final Comparator zzf;
    private final boolean zzg;
    private zzhts zzh;
    private zzhtu zzi;

    public zzhtx() {
        this(zze, true);
    }

    private final void zzf(zzhtw zzhtwVar, zzhtw zzhtwVar2) {
        zzhtw zzhtwVar3 = zzhtwVar.zza;
        zzhtwVar.zza = null;
        if (zzhtwVar2 != null) {
            zzhtwVar2.zza = zzhtwVar3;
        }
        if (zzhtwVar3 == null) {
            this.zza = zzhtwVar2;
        } else if (zzhtwVar3.zzb == zzhtwVar) {
            zzhtwVar3.zzb = zzhtwVar2;
        } else {
            zzhtwVar3.zzc = zzhtwVar2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0080 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0080 A[SYNTHETIC] */
    private final void zzg(zzhtw zzhtwVar, boolean z) {
        while (zzhtwVar != null) {
            zzhtw zzhtwVar2 = zzhtwVar.zzb;
            zzhtw zzhtwVar3 = zzhtwVar.zzc;
            boolean z2 = false;
            int i = zzhtwVar2 != null ? zzhtwVar2.zzi : 0;
            int i2 = zzhtwVar3 != null ? zzhtwVar3.zzi : 0;
            int i3 = i - i2;
            boolean z3 = true;
            if (i3 == -2) {
                zzhtw zzhtwVar4 = zzhtwVar3.zzb;
                zzhtw zzhtwVar5 = zzhtwVar3.zzc;
                int i4 = (zzhtwVar4 != null ? zzhtwVar4.zzi : 0) - (zzhtwVar5 != null ? zzhtwVar5.zzi : 0);
                if (i4 != -1) {
                    if (i4 == 0) {
                        if (!z) {
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        z3 = z;
                    }
                    zzi(zzhtwVar3);
                    zzh(zzhtwVar);
                    if (z3) {
                        return;
                    }
                } else {
                    z2 = z;
                }
                zzh(zzhtwVar);
                z3 = z2;
                if (z3) {
                    return;
                }
            } else if (i3 == 2) {
                zzhtw zzhtwVar6 = zzhtwVar2.zzb;
                zzhtw zzhtwVar7 = zzhtwVar2.zzc;
                int i5 = (zzhtwVar6 != null ? zzhtwVar6.zzi : 0) - (zzhtwVar7 != null ? zzhtwVar7.zzi : 0);
                if (i5 != 1) {
                    if (i5 == 0) {
                        if (!z) {
                        }
                        if (z3) {
                            return;
                        }
                    } else {
                        z3 = z;
                    }
                    zzh(zzhtwVar2);
                    zzi(zzhtwVar);
                    if (z3) {
                        return;
                    }
                } else {
                    z2 = z;
                }
                zzi(zzhtwVar);
                z3 = z2;
                if (z3) {
                    return;
                }
            } else if (i3 == 0) {
                zzhtwVar.zzi = i + 1;
                if (z) {
                    return;
                }
            } else {
                zzhtwVar.zzi = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            zzhtwVar = zzhtwVar.zza;
        }
    }

    private final void zzh(zzhtw zzhtwVar) {
        zzhtw zzhtwVar2 = zzhtwVar.zzb;
        zzhtw zzhtwVar3 = zzhtwVar.zzc;
        zzhtw zzhtwVar4 = zzhtwVar3.zzb;
        zzhtw zzhtwVar5 = zzhtwVar3.zzc;
        zzhtwVar.zzc = zzhtwVar4;
        if (zzhtwVar4 != null) {
            zzhtwVar4.zza = zzhtwVar;
        }
        zzf(zzhtwVar, zzhtwVar3);
        zzhtwVar3.zzb = zzhtwVar;
        zzhtwVar.zza = zzhtwVar3;
        int iMax = Math.max(zzhtwVar2 != null ? zzhtwVar2.zzi : 0, zzhtwVar4 != null ? zzhtwVar4.zzi : 0) + 1;
        zzhtwVar.zzi = iMax;
        zzhtwVar3.zzi = Math.max(iMax, zzhtwVar5 != null ? zzhtwVar5.zzi : 0) + 1;
    }

    private final void zzi(zzhtw zzhtwVar) {
        zzhtw zzhtwVar2 = zzhtwVar.zzb;
        zzhtw zzhtwVar3 = zzhtwVar.zzc;
        zzhtw zzhtwVar4 = zzhtwVar2.zzb;
        zzhtw zzhtwVar5 = zzhtwVar2.zzc;
        zzhtwVar.zzb = zzhtwVar5;
        if (zzhtwVar5 != null) {
            zzhtwVar5.zza = zzhtwVar;
        }
        zzf(zzhtwVar, zzhtwVar2);
        zzhtwVar2.zzc = zzhtwVar;
        zzhtwVar.zza = zzhtwVar2;
        int iMax = Math.max(zzhtwVar3 != null ? zzhtwVar3.zzi : 0, zzhtwVar5 != null ? zzhtwVar5.zzi : 0) + 1;
        zzhtwVar.zzi = iMax;
        zzhtwVar2.zzi = Math.max(iMax, zzhtwVar4 != null ? zzhtwVar4.zzi : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zza = null;
        this.zzb = 0;
        this.zzc++;
        zzhtw zzhtwVar = this.zzd;
        zzhtwVar.zze = zzhtwVar;
        zzhtwVar.zzd = zzhtwVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return zzb(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzhts zzhtsVar = this.zzh;
        if (zzhtsVar != null) {
            return zzhtsVar;
        }
        zzhts zzhtsVar2 = new zzhts(this);
        this.zzh = zzhtsVar2;
        return zzhtsVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzhtw zzhtwVarZzb = zzb(obj);
        if (zzhtwVarZzb != null) {
            return zzhtwVarZzb.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzhtu zzhtuVar = this.zzi;
        if (zzhtuVar != null) {
            return zzhtuVar;
        }
        zzhtu zzhtuVar2 = new zzhtu(this);
        this.zzi = zzhtuVar2;
        return zzhtuVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        if (obj2 == null && !this.zzg) {
            throw new NullPointerException("value == null");
        }
        zzhtw zzhtwVarZza = zza(obj, true);
        Object obj3 = zzhtwVarZza.zzh;
        zzhtwVarZza.zzh = obj2;
        return obj3;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzhtw zzhtwVarZze = zze(obj);
        if (zzhtwVarZze != null) {
            return zzhtwVarZze.zzh;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb;
    }

    final zzhtw zza(Object obj, boolean z) {
        int iCompareTo;
        zzhtw zzhtwVar;
        Comparator comparator = this.zzf;
        zzhtw zzhtwVar2 = this.zza;
        if (zzhtwVar2 != null) {
            Comparable comparable = comparator == zze ? (Comparable) obj : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(zzhtwVar2.zzf) : comparator.compare(obj, zzhtwVar2.zzf);
                if (iCompareTo == 0) {
                    return zzhtwVar2;
                }
                zzhtw zzhtwVar3 = iCompareTo < 0 ? zzhtwVar2.zzb : zzhtwVar2.zzc;
                if (zzhtwVar3 == null) {
                    break;
                }
                zzhtwVar2 = zzhtwVar3;
            }
        } else {
            iCompareTo = 0;
        }
        int i = iCompareTo;
        if (!z) {
            return null;
        }
        zzhtw zzhtwVar4 = this.zzd;
        if (zzhtwVar2 != null) {
            zzhtw zzhtwVar5 = zzhtwVar2;
            zzhtwVar = new zzhtw(this.zzg, zzhtwVar5, obj, zzhtwVar4, zzhtwVar4.zze);
            if (i < 0) {
                zzhtwVar5.zzb = zzhtwVar;
            } else {
                zzhtwVar5.zzc = zzhtwVar;
            }
            zzg(zzhtwVar5, true);
        } else {
            if (comparator == zze && !(obj instanceof Comparable)) {
                String name = obj.getClass().getName();
                String.valueOf(name);
                throw new ClassCastException(String.valueOf(name).concat(" is not Comparable"));
            }
            zzhtwVar = new zzhtw(this.zzg, null, obj, zzhtwVar4, zzhtwVar4.zze);
            this.zza = zzhtwVar;
        }
        this.zzb++;
        this.zzc++;
        return zzhtwVar;
    }

    final zzhtw zzb(Object obj) {
        if (obj != null) {
            try {
                return zza(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    final zzhtw zzc(Map.Entry entry) {
        zzhtw zzhtwVarZzb = zzb(entry.getKey());
        if (zzhtwVarZzb == null || !Objects.equals(zzhtwVarZzb.zzh, entry.getValue())) {
            return null;
        }
        return zzhtwVarZzb;
    }

    final void zzd(zzhtw zzhtwVar, boolean z) {
        zzhtw zzhtwVar2;
        zzhtw zzhtwVar3;
        int i;
        if (z) {
            zzhtw zzhtwVar4 = zzhtwVar.zze;
            zzhtwVar4.zzd = zzhtwVar.zzd;
            zzhtwVar.zzd.zze = zzhtwVar4;
        }
        zzhtw zzhtwVar5 = zzhtwVar.zzb;
        zzhtw zzhtwVar6 = zzhtwVar.zzc;
        zzhtw zzhtwVar7 = zzhtwVar.zza;
        int i2 = 0;
        if (zzhtwVar5 == null || zzhtwVar6 == null) {
            if (zzhtwVar5 != null) {
                zzf(zzhtwVar, zzhtwVar5);
                zzhtwVar.zzb = null;
            } else if (zzhtwVar6 != null) {
                zzf(zzhtwVar, zzhtwVar6);
                zzhtwVar.zzc = null;
            } else {
                zzf(zzhtwVar, null);
            }
            zzg(zzhtwVar7, false);
            this.zzb--;
            this.zzc++;
            return;
        }
        if (zzhtwVar5.zzi > zzhtwVar6.zzi) {
            do {
                zzhtwVar3 = zzhtwVar5;
                zzhtwVar5 = zzhtwVar5.zzc;
            } while (zzhtwVar5 != null);
        } else {
            do {
                zzhtwVar2 = zzhtwVar6;
                zzhtwVar6 = zzhtwVar6.zzb;
            } while (zzhtwVar6 != null);
            zzhtwVar3 = zzhtwVar2;
        }
        zzd(zzhtwVar3, false);
        zzhtw zzhtwVar8 = zzhtwVar.zzb;
        if (zzhtwVar8 != null) {
            i = zzhtwVar8.zzi;
            zzhtwVar3.zzb = zzhtwVar8;
            zzhtwVar8.zza = zzhtwVar3;
            zzhtwVar.zzb = null;
        } else {
            i = 0;
        }
        zzhtw zzhtwVar9 = zzhtwVar.zzc;
        if (zzhtwVar9 != null) {
            i2 = zzhtwVar9.zzi;
            zzhtwVar3.zzc = zzhtwVar9;
            zzhtwVar9.zza = zzhtwVar3;
            zzhtwVar.zzc = null;
        }
        zzhtwVar3.zzi = Math.max(i, i2) + 1;
        zzf(zzhtwVar, zzhtwVar3);
    }

    final zzhtw zze(Object obj) {
        zzhtw zzhtwVarZzb = zzb(obj);
        if (zzhtwVarZzb != null) {
            zzd(zzhtwVarZzb, true);
        }
        return zzhtwVarZzb;
    }

    public zzhtx(Comparator comparator, boolean z) {
        this.zzb = 0;
        this.zzc = 0;
        this.zzf = comparator;
        this.zzg = z;
        this.zzd = new zzhtw(z);
    }

    public zzhtx(boolean z) {
        this(zze, false);
    }
}
