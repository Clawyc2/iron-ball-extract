package com.google.android.gms.internal.measurement;

import com.google.android.gms.ads.AdError;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbN(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        byte b;
        zzat zzatVar;
        int i;
        int i2;
        int i3;
        zzg zzgVar2;
        int iZza;
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !"replace".equals(str) && !FirebaseAnalytics.Event.SEARCH.equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !"toString".equals(str) && !"toUpperCase".equals(str) && !"toLocaleUpperCase".equals(str)) {
            if (!"trim".equals(str)) {
                throw new IllegalArgumentException(String.format("%s is not a String function", str));
            }
        }
        switch (str.hashCode()) {
            case -1789698943:
                str2 = r3;
                str3 = "charAt";
                b = str.equals(str2) ? (byte) 2 : (byte) -1;
                break;
            case -1776922004:
                str3 = "charAt";
                if (str.equals("toString")) {
                    b = Ascii.SO;
                    str2 = r3;
                }
                str2 = r3;
                break;
            case -1464939364:
                str3 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    b = Ascii.FF;
                    str2 = r3;
                }
                str2 = r3;
                break;
            case -1361633751:
                str3 = "charAt";
                if (str.equals(str3)) {
                    str2 = r3;
                    b = 0;
                } else {
                    str2 = r3;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = r3;
                    str3 = "charAt";
                    b = 1;
                } else {
                    str2 = "hasOwnProperty";
                    str3 = "charAt";
                }
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    b = Ascii.CR;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case -906336856:
                if (str.equals(FirebaseAnalytics.Event.SEARCH)) {
                    b = 7;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    b = Ascii.VT;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b = 4;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    b = Ascii.SI;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 3568674:
                if (str.equals("trim")) {
                    b = Ascii.DLE;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 103668165:
                if (str.equals("match")) {
                    b = 5;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b = 8;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 109648666:
                if (str.equals("split")) {
                    b = 9;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 530542161:
                if (str.equals("substring")) {
                    b = 10;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    b = 6;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b = 3;
                    str2 = r3;
                    str3 = "charAt";
                }
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
            default:
                str2 = "hasOwnProperty";
                str3 = "charAt";
                break;
        }
        String strZzi = AdError.UNDEFINED_DOMAIN;
        String str4 = str3;
        switch (b) {
            case 0:
                zzh.zzj(str4, 1, list);
                int iZza2 = !list.isEmpty() ? (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue()) : 0;
                String str5 = this.zza;
                return (iZza2 < 0 || iZza2 >= str5.length()) ? zzap.zzm : new zzat(String.valueOf(str5.charAt(iZza2)));
            case 1:
                zzatVar = this;
                if (!list.isEmpty()) {
                    StringBuilder sb = new StringBuilder(zzatVar.zza);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        sb.append(zzgVar.zzb((zzap) list.get(i4)).zzi());
                    }
                    return new zzat(sb.toString());
                }
                return zzatVar;
            case 2:
                zzh.zzh(str2, 1, list);
                String str6 = this.zza;
                zzap zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                if ("length".equals(zzapVarZzb.zzi())) {
                    return zzaf.zzk;
                }
                double dDoubleValue = zzapVarZzb.zzh().doubleValue();
                return (dDoubleValue != Math.floor(dDoubleValue) || (i = (int) dDoubleValue) < 0 || i >= str6.length()) ? zzaf.zzl : zzaf.zzk;
            case 3:
                zzh.zzj("indexOf", 2, list);
                String str7 = this.zza;
                if (list.size() > 0) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                return new zzah(Double.valueOf(str7.indexOf(strZzi, (int) zzh.zza(list.size() < 2 ? 0.0d : zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()))));
            case 4:
                zzh.zzj("lastIndexOf", 2, list);
                String str8 = this.zza;
                if (list.size() > 0) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                String str9 = strZzi;
                double dDoubleValue2 = list.size() < 2 ? Double.NaN : zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                return new zzah(Double.valueOf(str8.lastIndexOf(str9, (int) (Double.isNaN(dDoubleValue2) ? Double.POSITIVE_INFINITY : zzh.zza(dDoubleValue2)))));
            case 5:
                zzh.zzj("match", 1, list);
                Matcher matcher = Pattern.compile(list.size() <= 0 ? "" : zzgVar.zzb((zzap) list.get(0)).zzi()).matcher(this.zza);
                return matcher.find() ? new zzae(Arrays.asList(new zzat(matcher.group()))) : zzap.zzg;
            case 6:
                zzatVar = this;
                zzh.zzj("replace", 2, list);
                zzap zzapVarZza = zzap.zzf;
                if (!list.isEmpty()) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    if (list.size() > 1) {
                        zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                    }
                }
                String str10 = strZzi;
                String str11 = zzatVar.zza;
                int iIndexOf = str11.indexOf(str10);
                if (iIndexOf >= 0) {
                    if (zzapVarZza instanceof zzai) {
                        zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str10), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                    }
                    return new zzat(str11.substring(0, iIndexOf) + zzapVarZza.zzi() + str11.substring(iIndexOf + str10.length()));
                }
                return zzatVar;
            case 7:
                zzh.zzj(FirebaseAnalytics.Event.SEARCH, 1, list);
                if (!list.isEmpty()) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                Matcher matcher2 = Pattern.compile(strZzi).matcher(this.zza);
                return matcher2.find() ? new zzah(Double.valueOf(matcher2.start())) : new zzah(Double.valueOf(-1.0d));
            case 8:
                zzh.zzj("slice", 2, list);
                String str12 = this.zza;
                double dZza = zzh.zza(!list.isEmpty() ? zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue() : 0.0d);
                int iMax = (int) (dZza < 0.0d ? Math.max(((double) str12.length()) + dZza, 0.0d) : Math.min(dZza, str12.length()));
                double dZza2 = zzh.zza(list.size() > 1 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : str12.length());
                return new zzat(str12.substring(iMax, Math.max(0, ((int) (dZza2 < 0.0d ? Math.max(((double) str12.length()) + dZza2, 0.0d) : Math.min(dZza2, str12.length()))) - iMax) + iMax));
            case 9:
                zzh.zzj("split", 2, list);
                String str13 = this.zza;
                if (str13.length() == 0) {
                    return new zzae(Arrays.asList(this));
                }
                ArrayList arrayList = new ArrayList();
                if (list.isEmpty()) {
                    arrayList.add(this);
                } else {
                    String strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                    long jZzd = list.size() > 1 ? zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()) : 2147483647L;
                    if (jZzd == 0) {
                        return new zzae();
                    }
                    String[] strArrSplit = str13.split(Pattern.quote(strZzi2), ((int) jZzd) + 1);
                    int length = strArrSplit.length;
                    if (!strZzi2.isEmpty() || length <= 0) {
                        i2 = length;
                        i3 = 0;
                    } else {
                        boolean zIsEmpty = strArrSplit[0].isEmpty();
                        i2 = length - 1;
                        i3 = zIsEmpty;
                        if (!strArrSplit[i2].isEmpty()) {
                            i2 = length;
                            i3 = zIsEmpty;
                        }
                    }
                    if (length > jZzd) {
                        i2--;
                    }
                    while (i3 < i2) {
                        arrayList.add(new zzat(strArrSplit[i3]));
                        i3++;
                    }
                }
                return new zzae(arrayList);
            case 10:
                zzh.zzj("substring", 2, list);
                String str14 = this.zza;
                if (list.isEmpty()) {
                    zzgVar2 = zzgVar;
                    iZza = 0;
                } else {
                    zzgVar2 = zzgVar;
                    iZza = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                }
                int iZza3 = list.size() > 1 ? (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue()) : str14.length();
                int iMin = Math.min(Math.max(iZza, 0), str14.length());
                int iMin2 = Math.min(Math.max(iZza3, 0), str14.length());
                return new zzat(str14.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
            case 11:
                zzh.zzh("toLocaleUpperCase", 0, list);
                return new zzat(this.zza.toUpperCase());
            case 12:
                zzh.zzh("toLocaleLowerCase", 0, list);
                return new zzat(this.zza.toLowerCase());
            case 13:
                zzh.zzh("toLowerCase", 0, list);
                return new zzat(this.zza.toLowerCase(Locale.ENGLISH));
            case 14:
                zzh.zzh("toString", 0, list);
                return this;
            case 15:
                zzh.zzh("toUpperCase", 0, list);
                return new zzat(this.zza.toUpperCase(Locale.ENGLISH));
            case 16:
                zzh.zzh("toUpperCase", 0, list);
                return new zzat(this.zza.trim());
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
