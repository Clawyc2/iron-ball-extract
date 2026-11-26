package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyi extends zzyo implements zzlo {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgqy zzc = zzgqy.zzc(zzxo.zza);
    public final Context zza;
    private final Object zzd;
    private zzxt zze;
    private Thread zzf;
    private zzxx zzg;
    private zzd zzh;
    private Boolean zzi;
    private final zzxb zzj;

    public zzyi(Context context) {
        zzxb zzxbVar = new zzxb();
        zzxt zzxtVar = zzxt.zzJ;
        this.zzd = new Object();
        byte[] bArr = null;
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzxbVar;
        if (zzxtVar instanceof zzxt) {
            this.zze = zzxtVar;
        } else {
            zzxs zzxsVar = new zzxs(zzxtVar, bArr);
            zzxsVar.zzx((zzbl) zzxtVar);
            this.zze = new zzxt(zzxsVar, bArr);
        }
        this.zzh = zzd.zza;
        if (this.zze.zzU && context == null) {
            zzdt.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    protected static String zzi(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int zzj(zzv zzvVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzvVar.zzd)) {
            return 4;
        }
        String strZzi = zzi(str);
        String strZzi2 = zzi(zzvVar.zzd);
        if (strZzi2 == null || strZzi == null) {
            return (z && strZzi2 == null) ? 1 : 0;
        }
        if (strZzi2.startsWith(strZzi) || strZzi.startsWith(strZzi2)) {
            return 3;
        }
        String str2 = zzep.zza;
        return strZzi2.split("-", 2)[0].equals(strZzi.split("-", 2)[0]) ? 2 : 0;
    }

    static /* synthetic */ int zzm(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    static /* synthetic */ int zzn(zzv zzvVar, zzgpe zzgpeVar) {
        for (int i = 0; i < zzgpeVar.size(); i++) {
            int i2 = 0;
            while (true) {
                List list = zzvVar.zzc;
                if (i2 < list.size()) {
                    if (((zzx) list.get(i2)).zzb.equals(zzgpeVar.get(i))) {
                        return i;
                    }
                    i2++;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public final void zzl() {
        boolean z;
        zzxx zzxxVar;
        synchronized (this.zzd) {
            z = false;
            if (this.zze.zzU && Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null && zzxxVar.zza()) {
                z = true;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static void zzv(zzwv zzwvVar, zzbl zzblVar, Map map) {
        for (int i = 0; i < zzwvVar.zzb; i++) {
            if (((zzbh) zzblVar.zzH.get(zzwvVar.zza(i))) != null) {
                throw null;
            }
        }
    }

    private static final Pair zzw(int i, zzyn zzynVar, int[][][] iArr, zzxz zzxzVar, Comparator comparator) {
        RandomAccess randomAccessZzj;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            if (i == zzynVar.zza(i2)) {
                zzwv zzwvVarZzb = zzynVar.zzb(i2);
                for (int i3 = 0; i3 < zzwvVarZzb.zzb; i3++) {
                    zzbg zzbgVarZza = zzwvVarZzb.zza(i3);
                    List listZza = zzxzVar.zza(i2, zzbgVarZza, iArr[i2][i3]);
                    int i4 = zzbgVarZza.zza;
                    boolean[] zArr = new boolean[i4];
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i5 + 1;
                        zzya zzyaVar = (zzya) listZza.get(i5);
                        int iZza = zzyaVar.zza();
                        if (!zArr[i5] && iZza != 0) {
                            if (iZza == 1) {
                                randomAccessZzj = zzgpe.zzj(zzyaVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzyaVar);
                                for (int i7 = i6; i7 < i4; i7++) {
                                    zzya zzyaVar2 = (zzya) listZza.get(i7);
                                    if (zzyaVar2.zza() == 2 && zzyaVar.zzc(zzyaVar2)) {
                                        arrayList2.add(zzyaVar2);
                                        zArr[i7] = true;
                                    }
                                }
                                randomAccessZzj = arrayList2;
                            }
                            arrayList.add(randomAccessZzj);
                        }
                        i5 = i6;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((zzya) list.get(i8)).zzc;
        }
        zzya zzyaVar3 = (zzya) list.get(0);
        return Pair.create(new zzyj(zzyaVar3.zzb, iArr2, 0), Integer.valueOf(zzyaVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void zza(zzln zzlnVar) {
        synchronized (this.zzd) {
            boolean z = this.zze.zzY;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zzb() {
        zzxx zzxxVar;
        synchronized (this.zzd) {
            Thread thread = this.zzf;
            if (thread != null) {
                zzgmd.zzi(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null) {
            zzxxVar.zze();
            this.zzg = null;
        }
        super.zzb();
    }

    public final zzxt zzc() {
        zzxt zzxtVar;
        synchronized (this.zzd) {
            zzxtVar = this.zze;
        }
        return zzxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final boolean zzd() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final void zze(zzd zzdVar) {
        if (this.zzh.equals(zzdVar)) {
            return;
        }
        this.zzh = zzdVar;
        zzl();
    }

    public final void zzf(zzxs zzxsVar) {
        boolean zEquals;
        zzxt zzxtVar = new zzxt(zzxsVar, null);
        synchronized (this.zzd) {
            zEquals = this.zze.equals(zzxtVar);
            this.zze = zzxtVar;
        }
        if (zEquals) {
            return;
        }
        if (zzxtVar.zzU && this.zza == null) {
            zzdt.zzc("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzyr
    public final zzlo zzg() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    protected final Pair zzh(zzyn zzynVar, int[][][] iArr, final int[] iArr2, zzuu zzuuVar, zzbf zzbfVar) throws zzib {
        final zzxt zzxtVar;
        int i;
        final boolean z;
        final String languageTag;
        int[] iArr3;
        int length;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        Context context3;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzxtVar = this.zze;
        }
        if (this.zzi == null && (context3 = this.zza) != null) {
            this.zzi = Boolean.valueOf(zzep.zzN(context3));
        }
        if (zzxtVar.zzU && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzxx(this.zza, this, this.zzi);
        }
        int i2 = 2;
        zzyj[] zzyjVarArr = new zzyj[2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = 1;
            if (i4 >= 2) {
                z = false;
                break;
            }
            if (zzynVar.zza(i4) == 2 && zzynVar.zzb(i4).zzb > 0) {
                z = true;
                break;
            }
            i4++;
        }
        Pair pairZzw = zzw(1, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxk
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i5, zzbg zzbgVar, int[] iArr4) {
                final zzyi zzyiVar = this.zza;
                final zzxt zzxtVar2 = zzxtVar;
                zzgme zzgmeVar = new zzgme() { // from class: com.google.android.gms.internal.ads.zzxn
                    @Override // com.google.android.gms.internal.ads.zzgme
                    public final /* synthetic */ boolean zza(Object obj) {
                        return zzyiVar.zzk(zzxtVar2, (zzv) obj);
                    }
                };
                int i6 = iArr2[i5];
                int i7 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i8 = 0; i8 < zzbgVar.zza; i8++) {
                    zzgpbVar.zzf(new zzxf(i5, zzbgVar, i8, zzxtVar2, iArr4[i8], z, zzgmeVar, i6));
                }
                return zzgpbVar.zzi();
            }
        }, zzxg.zza);
        if (pairZzw != null) {
            zzyjVarArr[((Integer) pairZzw.second).intValue()] = (zzyj) pairZzw.first;
        }
        final String str = pairZzw == null ? null : ((zzyj) pairZzw.first).zza.zza(((zzyj) pairZzw.first).zzb[0]).zzd;
        int i5 = zzxtVar.zzw.zzb;
        final Point pointZzP = (!zzxtVar.zzk || (context2 = this.zza) == null) ? null : zzep.zzP(context2);
        Pair pairZzw2 = zzw(2, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxp
            /* JADX WARN: Code duplicated, block: B:29:0x004d  */
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i6, zzbg zzbgVar, int[] iArr4) {
                int i7;
                int i8;
                int i9;
                int i10;
                int i11;
                int i12;
                Point point;
                zzbg zzbgVar2 = zzbgVar;
                int i13 = zzyi.zzb;
                Point point2 = pointZzP;
                int i14 = iArr2[i6];
                zzxt zzxtVar2 = zzxtVar;
                int i15 = point2 != null ? point2.x : zzxtVar2.zzi;
                int i16 = point2 != null ? point2.y : zzxtVar2.zzj;
                boolean z2 = zzxtVar2.zzl;
                if (i15 == Integer.MAX_VALUE) {
                    i7 = -1;
                    i8 = Integer.MAX_VALUE;
                } else if (i16 == Integer.MAX_VALUE) {
                    i8 = Integer.MAX_VALUE;
                    i7 = -1;
                } else {
                    int i17 = Integer.MAX_VALUE;
                    for (int i18 = 0; i18 < zzbgVar2.zza; i18++) {
                        zzv zzvVarZza = zzbgVar2.zza(i18);
                        int i19 = zzvVarZza.zzv;
                        if (i19 > 0 && (i10 = zzvVarZza.zzw) > 0) {
                            if (!z2) {
                                i11 = i16;
                                i12 = i15;
                            } else if ((i19 > i10) != (i15 > i16)) {
                                i12 = i16;
                                i11 = i15;
                            } else {
                                i11 = i16;
                                i12 = i15;
                            }
                            int i20 = i19 * i11;
                            int i21 = i10 * i12;
                            if (i20 >= i21) {
                                String str2 = zzep.zza;
                                point = new Point(i12, ((i21 + i19) - 1) / i19);
                            } else {
                                String str3 = zzep.zza;
                                point = new Point(((i20 + i10) - 1) / i10, i11);
                            }
                            int i22 = i19 * i10;
                            if (i19 >= ((int) (point.x * 0.98f)) && i10 >= ((int) (point.y * 0.98f)) && i22 < i17) {
                                i17 = i22;
                            }
                        }
                    }
                    i7 = -1;
                    i8 = i17;
                }
                int i23 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                int i24 = 0;
                while (i24 < zzbgVar2.zza) {
                    int iZzc = zzbgVar2.zza(i24).zzc();
                    if (i8 != Integer.MAX_VALUE) {
                        i9 = i7;
                        boolean z3 = iZzc != i9 && iZzc <= i8;
                        zzgpbVar.zzf(new zzyh(i6, zzbgVar2, i24, zzxtVar2, iArr4[i24], str, i14, z3));
                        i24++;
                        zzbgVar2 = zzbgVar;
                        i7 = i9;
                    } else {
                        i9 = i7;
                    }
                    zzgpbVar.zzf(new zzyh(i6, zzbgVar2, i24, zzxtVar2, iArr4[i24], str, i14, z3));
                    i24++;
                    zzbgVar2 = zzbgVar;
                    i7 = i9;
                }
                return zzgpbVar.zzi();
            }
        }, zzxj.zza);
        boolean z2 = zzxtVar.zzE;
        int i6 = 4;
        Pair pairZzw3 = pairZzw2 == null ? zzw(4, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxm
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i7, zzbg zzbgVar, int[] iArr4) {
                int i8 = zzyi.zzb;
                int i9 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i10 = 0; i10 < zzbgVar.zza; i10++) {
                    zzgpbVar.zzf(new zzxq(i7, zzbgVar, i10, zzxtVar, iArr4[i10]));
                }
                return zzgpbVar.zzi();
            }
        }, zzxh.zza) : null;
        if (pairZzw3 != null) {
            zzyjVarArr[((Integer) pairZzw3.second).intValue()] = (zzyj) pairZzw3.first;
        } else if (pairZzw2 != null) {
            zzyjVarArr[((Integer) pairZzw2.second).intValue()] = (zzyj) pairZzw2.first;
        }
        if (!zzxtVar.zzB || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            languageTag = null;
        } else {
            String str2 = zzep.zza;
            languageTag = locale.toLanguageTag();
        }
        int i7 = 3;
        Pair pairZzw4 = zzw(3, zzynVar, iArr, new zzxz() { // from class: com.google.android.gms.internal.ads.zzxl
            @Override // com.google.android.gms.internal.ads.zzxz
            public final /* synthetic */ List zza(int i8, zzbg zzbgVar, int[] iArr4) {
                int i9 = zzyi.zzb;
                int i10 = zzgpe.zzd;
                zzgpb zzgpbVar = new zzgpb();
                for (int i11 = 0; i11 < zzbgVar.zza; i11++) {
                    zzgpbVar.zzf(new zzxy(i8, zzbgVar, i11, zzxtVar, iArr4[i11], str, languageTag));
                }
                return zzgpbVar.zzi();
            }
        }, zzxi.zza);
        if (pairZzw4 != null) {
            zzyjVarArr[((Integer) pairZzw4.second).intValue()] = (zzyj) pairZzw4.first;
        }
        int i8 = 0;
        while (i8 < i2) {
            int iZza = zzynVar.zza(i8);
            if (iZza != i2 && iZza != i && iZza != i7 && iZza != i6) {
                zzwv zzwvVarZzb = zzynVar.zzb(i8);
                int[][] iArr4 = iArr[i8];
                int i9 = i3;
                int i10 = i9;
                zzbg zzbgVar = null;
                zzxr zzxrVar = null;
                while (i9 < zzwvVarZzb.zzb) {
                    zzbg zzbgVarZza = zzwvVarZzb.zza(i9);
                    int[] iArr5 = iArr4[i9];
                    zzxr zzxrVar2 = zzxrVar;
                    for (int i11 = i3; i11 < zzbgVarZza.zza; i11++) {
                        if (zzlp.zzaa(iArr5[i11], zzxtVar.zzV)) {
                            zzxr zzxrVar3 = new zzxr(zzbgVarZza.zza(i11), iArr5[i11]);
                            if (zzxrVar2 == null || zzxrVar3.compareTo(zzxrVar2) > 0) {
                                zzbgVar = zzbgVarZza;
                                zzxrVar2 = zzxrVar3;
                                i10 = i11;
                            }
                        }
                    }
                    i9++;
                    zzxrVar = zzxrVar2;
                    i3 = 0;
                }
                zzyjVarArr[i8] = zzbgVar == null ? null : new zzyj(zzbgVar, new int[]{i10}, 0);
            }
            i8++;
            i2 = 2;
            i3 = 0;
            i7 = 3;
            i = 1;
            i6 = 4;
        }
        HashMap map = new HashMap();
        int i12 = 2;
        for (int i13 = 0; i13 < 2; i13++) {
            zzv(zzynVar.zzb(i13), zzxtVar, map);
        }
        zzv(zzynVar.zze(), zzxtVar, map);
        for (int i14 = 0; i14 < 2; i14++) {
            if (((zzbh) map.get(Integer.valueOf(zzynVar.zza(i14)))) != null) {
                throw null;
            }
        }
        int i15 = 0;
        while (i15 < i12) {
            zzwv zzwvVarZzb2 = zzynVar.zzb(i15);
            if (zzxtVar.zzb(i15, zzwvVarZzb2)) {
                if (zzxtVar.zzc(i15, zzwvVarZzb2) != null) {
                    throw null;
                }
                zzyjVarArr[i15] = null;
            }
            i15++;
            i12 = 2;
        }
        int i16 = 0;
        while (i16 < i12) {
            int iZza2 = zzynVar.zza(i16);
            if (zzxtVar.zza(i16) || zzxtVar.zzI.contains(Integer.valueOf(iZza2))) {
                zzyjVarArr[i16] = null;
            }
            i16++;
            i12 = 2;
        }
        zzxb zzxbVar = this.zzj;
        zzza zzzaVarZzt = zzt();
        zzgpe zzgpeVarZzd = zzxc.zzd(zzyjVarArr);
        int i17 = 2;
        zzyk[] zzykVarArr = new zzyk[2];
        int i18 = 0;
        while (i18 < i17) {
            zzyj zzyjVar = zzyjVarArr[i18];
            if (zzyjVar != null && (length = (iArr3 = zzyjVar.zzb).length) != 0) {
                zzykVarArr[i18] = length == 1 ? new zzyl(zzyjVar.zza, iArr3[0], 0, 0, null) : zzxbVar.zza(zzyjVar.zza, iArr3, 0, zzzaVarZzt, (zzgpe) zzgpeVarZzd.get(i18));
            }
            i18++;
            i17 = 2;
        }
        zzlq[] zzlqVarArr = new zzlq[i17];
        for (int i19 = 0; i19 < i17; i19++) {
            zzlqVarArr[i19] = (zzxtVar.zza(i19) || zzxtVar.zzI.contains(Integer.valueOf(zzynVar.zza(i19))) || (zzynVar.zza(i19) != -2 && zzykVarArr[i19] == null)) ? null : zzlq.zza;
        }
        boolean z3 = zzxtVar.zzW;
        return Pair.create(zzlqVarArr, zzykVarArr);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    final /* synthetic */ boolean zzk(zzxt zzxtVar, zzv zzvVar) {
        Boolean bool;
        zzxx zzxxVar;
        zzxx zzxxVar2;
        if (!zzxtVar.zzU || ((bool = this.zzi) != null && bool.booleanValue())) {
            return true;
        }
        int i = zzvVar.zzG;
        byte b = -1;
        if (i != -1 && i > 2) {
            String str = zzvVar.zzo;
            if (str != null) {
                switch (str.hashCode()) {
                    case -2123537834:
                        if (str.equals("audio/eac3-joc")) {
                            b = 2;
                        }
                        break;
                    case 187078296:
                        if (str.equals("audio/ac3")) {
                            b = 0;
                        }
                        break;
                    case 187078297:
                        if (str.equals("audio/ac4")) {
                            b = 3;
                        }
                        break;
                    case 1504578661:
                        if (str.equals("audio/eac3")) {
                            b = 1;
                        }
                        break;
                }
                if ((b == 0 || b == 1 || b == 2 || b == 3) && (Build.VERSION.SDK_INT < 32 || (zzxxVar2 = this.zzg) == null || !zzxxVar2.zza())) {
                    return true;
                }
            }
            return Build.VERSION.SDK_INT >= 32 && (zzxxVar = this.zzg) != null && zzxxVar.zza() && zzxxVar.zzb() && this.zzg.zzc() && this.zzg.zzd(this.zzh, zzvVar);
        }
        return true;
    }
}
