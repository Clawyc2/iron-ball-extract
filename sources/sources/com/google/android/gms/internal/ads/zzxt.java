package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxt extends zzbl {
    public static final zzxt zzJ = new zzxt(new zzxs());
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final boolean zzQ;
    public final boolean zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final boolean zzU;
    public final boolean zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final boolean zzY;
    private final SparseArray zzZ;
    private final SparseBooleanArray zzaa;

    static {
        String str = zzep.zza;
        Integer.toString(1000, 36);
        Integer.toString(1001, 36);
        Integer.toString(1002, 36);
        Integer.toString(PointerIconCompat.TYPE_HELP, 36);
        Integer.toString(1004, 36);
        Integer.toString(GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT, 36);
        Integer.toString(PointerIconCompat.TYPE_CELL, 36);
        Integer.toString(PointerIconCompat.TYPE_CROSSHAIR, 36);
        Integer.toString(PointerIconCompat.TYPE_TEXT, 36);
        Integer.toString(PointerIconCompat.TYPE_VERTICAL_TEXT, 36);
        Integer.toString(PointerIconCompat.TYPE_ALIAS, 36);
        Integer.toString(PointerIconCompat.TYPE_COPY, 36);
        Integer.toString(PointerIconCompat.TYPE_NO_DROP, 36);
        Integer.toString(PointerIconCompat.TYPE_ALL_SCROLL, 36);
        Integer.toString(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 36);
        Integer.toString(PointerIconCompat.TYPE_ZOOM_IN, 36);
    }

    private zzxt(zzxs zzxsVar) {
        super(zzxsVar);
        this.zzK = zzxsVar.zzz();
        this.zzL = false;
        this.zzM = zzxsVar.zzA();
        this.zzN = false;
        this.zzO = zzxsVar.zzB();
        this.zzP = false;
        this.zzQ = false;
        this.zzR = false;
        this.zzS = false;
        this.zzT = zzxsVar.zzC();
        this.zzU = zzxsVar.zzD();
        this.zzV = zzxsVar.zzE();
        this.zzW = false;
        this.zzX = zzxsVar.zzF();
        this.zzY = false;
        this.zzZ = zzxsVar.zzG();
        this.zzaa = zzxsVar.zzH();
    }

    /* synthetic */ zzxt(zzxs zzxsVar, byte[] bArr) {
        this(zzxsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxt zzxtVar = (zzxt) obj;
            if (super.equals(zzxtVar) && this.zzK == zzxtVar.zzK && this.zzM == zzxtVar.zzM && this.zzO == zzxtVar.zzO && this.zzT == zzxtVar.zzT && this.zzU == zzxtVar.zzU && this.zzV == zzxtVar.zzV && this.zzX == zzxtVar.zzX) {
                SparseBooleanArray sparseBooleanArray = this.zzaa;
                SparseBooleanArray sparseBooleanArray2 = zzxtVar.zzaa;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    for (int i = 0; i < size; i++) {
                        if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) >= 0) {
                        }
                    }
                    SparseArray sparseArray = this.zzZ;
                    SparseArray sparseArray2 = zzxtVar.zzZ;
                    int size2 = sparseArray.size();
                    if (sparseArray2.size() == size2) {
                        for (int i2 = 0; i2 < size2; i2++) {
                            int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i2));
                            if (iIndexOfKey >= 0) {
                                Map map = (Map) sparseArray.valueAt(i2);
                                Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                                if (map2.size() == map.size()) {
                                    for (Map.Entry entry : map.entrySet()) {
                                        zzwv zzwvVar = (zzwv) entry.getKey();
                                        if (!map2.containsKey(zzwvVar) || !Objects.equals(entry.getValue(), map2.get(zzwvVar))) {
                                        }
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.zzK ? 1 : 0)) * 961) + (this.zzM ? 1 : 0)) * 961) + (this.zzO ? 1 : 0)) * 28629151) + (this.zzT ? 1 : 0)) * 31) + (this.zzU ? 1 : 0)) * 31) + (this.zzV ? 1 : 0)) * 961) + (this.zzX ? 1 : 0)) * 31;
    }

    public final boolean zza(int i) {
        return this.zzaa.get(i);
    }

    @Deprecated
    public final boolean zzb(int i, zzwv zzwvVar) {
        Map map = (Map) this.zzZ.get(i);
        return map != null && map.containsKey(zzwvVar);
    }

    @Deprecated
    public final zzxu zzc(int i, zzwv zzwvVar) {
        Map map = (Map) this.zzZ.get(i);
        if (map != null) {
            return (zzxu) map.get(zzwvVar);
        }
        return null;
    }

    public final zzxs zzd() {
        return new zzxs(this, null);
    }

    final /* synthetic */ SparseArray zze() {
        return this.zzZ;
    }

    final /* synthetic */ SparseBooleanArray zzf() {
        return this.zzaa;
    }
}
