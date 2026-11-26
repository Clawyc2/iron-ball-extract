package com.google.android.gms.internal.ads;

import admob.plus.cordova.Generated;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalz {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(map2);
    }

    public static zzalt zza(zzeg zzegVar, List list) {
        String strZzN = zzegVar.zzN(StandardCharsets.UTF_8);
        if (strZzN != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(strZzN);
            if (matcher.matches()) {
                return zzd(null, matcher, zzegVar, list);
            }
            String strZzN2 = zzegVar.zzN(StandardCharsets.UTF_8);
            if (strZzN2 != null) {
                Matcher matcher2 = pattern.matcher(strZzN2);
                if (matcher2.matches()) {
                    return zzd(strZzN.trim(), matcher2, zzegVar, list);
                }
            }
        }
        return null;
    }

    static zzcl zzb(String str) {
        zzaly zzalyVar = new zzaly();
        zze(str, zzalyVar);
        return zzalyVar.zza();
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x012a  */
    static SpannedString zzc(String str, String str2, List list) {
        byte b;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str2.length()) {
            int length = i + 1;
            char cCharAt = str2.charAt(i);
            if (cCharAt == '&') {
                int iIndexOf = str2.indexOf(59, length);
                int iIndexOf2 = str2.indexOf(32, length);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(length, iIndexOf);
                    int iHashCode = strSubstring.hashCode();
                    if (iHashCode != 3309) {
                        if (iHashCode != 3464) {
                            if (iHashCode != 96708) {
                                if (iHashCode == 3374865 && strSubstring.equals("nbsp")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (strSubstring.equals("amp")) {
                                b = 3;
                            } else {
                                b = -1;
                            }
                        } else if (strSubstring.equals("lt")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (strSubstring.equals("gt")) {
                        b = 1;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        spannableStringBuilder.append(Typography.less);
                    } else if (b == 1) {
                        spannableStringBuilder.append(Typography.greater);
                    } else if (b == 2) {
                        spannableStringBuilder.append(' ');
                    } else if (b != 3) {
                        StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 33);
                        sb.append("ignoring unsupported entity: '&");
                        sb.append(strSubstring);
                        sb.append(";'");
                        zzdt.zzc("WebvttCueParser", sb.toString());
                    } else {
                        spannableStringBuilder.append(Typography.amp);
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
            } else if (length < str2.length()) {
                char cCharAt2 = str2.charAt(length);
                int iIndexOf3 = str2.indexOf(62, length);
                length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                int i2 = length - 2;
                boolean z = str2.charAt(i2) == '/';
                int i3 = i + (cCharAt2 == '/' ? 2 : 1);
                if (!z) {
                    i2 = length - 1;
                }
                String strSubstring2 = str2.substring(i3, i2);
                if (!strSubstring2.trim().isEmpty()) {
                    String strTrim = strSubstring2.trim();
                    zzgmd.zza(!strTrim.isEmpty());
                    String str3 = zzep.zza;
                    String str4 = strTrim.split("[ \\.]", 2)[0];
                    switch (str4) {
                        case "b":
                        case "c":
                        case "i":
                        case "lang":
                        case "ruby":
                        case "rt":
                        case "u":
                        case "v":
                            if (cCharAt2 == '/') {
                                while (!arrayDeque.isEmpty()) {
                                    zzalw zzalwVar = (zzalw) arrayDeque.pop();
                                    zzf(str, zzalwVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new zzalv(zzalwVar, spannableStringBuilder.length(), null));
                                    }
                                    if (zzalwVar.zza.equals(str4)) {
                                        break;
                                    }
                                }
                                break;
                            } else {
                                if (!z) {
                                    arrayDeque.push(zzalw.zza(strSubstring2, spannableStringBuilder.length()));
                                }
                                break;
                            }
                            break;
                    }
                }
            }
            i = length;
        }
        while (!arrayDeque.isEmpty()) {
            zzf(str, (zzalw) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        zzf(str, zzalw.zzb(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static zzalt zzd(String str, Matcher matcher, zzeg zzegVar, List list) {
        zzaly zzalyVar = new zzaly();
        try {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw null;
            }
            String str2 = strGroup;
            zzalyVar.zza = zzamb.zza(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                throw null;
            }
            String str3 = strGroup2;
            zzalyVar.zzb = zzamb.zza(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            zze(strGroup3, zzalyVar);
            StringBuilder sb = new StringBuilder();
            String strZzN = zzegVar.zzN(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(strZzN)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strZzN.trim());
                strZzN = zzegVar.zzN(StandardCharsets.UTF_8);
            }
            zzalyVar.zzc = zzc(str, sb.toString(), list);
            return new zzalt(zzalyVar.zza().zzr(), zzalyVar.zza, zzalyVar.zzb);
        } catch (IllegalArgumentException unused) {
            String strGroup4 = matcher.group();
            String.valueOf(strGroup4);
            zzdt.zzc("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(strGroup4)));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x0085  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:96:0x016e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void zze(String str, zzaly zzalyVar) {
        byte b;
        byte b2;
        byte b3;
        Matcher matcher = zzb.matcher(str);
        while (matcher.find()) {
            int i = 1;
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i2 = 2;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                if ("line".equals(strGroup)) {
                    int iIndexOf = strGroup2.indexOf(44);
                    byte b4 = -1;
                    if (iIndexOf != -1) {
                        String strSubstring = strGroup2.substring(iIndexOf + 1);
                        switch (strSubstring.hashCode()) {
                            case -1364013995:
                                if (strSubstring.equals("center")) {
                                    b4 = 1;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring.equals("middle")) {
                                    b4 = 2;
                                }
                                break;
                            case 100571:
                                if (strSubstring.equals("end")) {
                                    b4 = 3;
                                }
                                break;
                            case 109757538:
                                if (strSubstring.equals(Generated.Actions.START)) {
                                    b4 = 0;
                                }
                                break;
                        }
                        if (b4 == 0) {
                            i2 = 0;
                        } else if (b4 == 1 || b4 == 2) {
                            i2 = 1;
                        } else if (b4 != 3) {
                            String.valueOf(strSubstring);
                            zzdt.zzc("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(strSubstring)));
                            i2 = Integer.MIN_VALUE;
                        }
                        zzalyVar.zzg = i2;
                        strGroup2 = strGroup2.substring(0, iIndexOf);
                    }
                    if (strGroup2.endsWith("%")) {
                        zzalyVar.zze = zzamb.zzb(strGroup2);
                        zzalyVar.zzf = 0;
                    } else {
                        zzalyVar.zze = Integer.parseInt(strGroup2);
                        zzalyVar.zzf = 1;
                    }
                } else if ("align".equals(strGroup)) {
                    switch (strGroup2) {
                        case "center":
                            b = 2;
                            break;
                        case "middle":
                            b = 3;
                            break;
                        case "end":
                            b = 4;
                            break;
                        case "left":
                            b = 1;
                            break;
                        case "right":
                            b = 5;
                            break;
                        case "start":
                            b = 0;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b != 0) {
                        if (b == 1) {
                            i = 4;
                        } else if (b == 2 || b == 3) {
                            i = 2;
                        } else if (b == 4) {
                            i = 3;
                        } else if (b != 5) {
                            zzdt.zzc("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                            i = 2;
                        } else {
                            i = 5;
                        }
                    }
                    zzalyVar.zzd = i;
                } else if ("position".equals(strGroup)) {
                    int iIndexOf2 = strGroup2.indexOf(44);
                    if (iIndexOf2 != -1) {
                        String strSubstring2 = strGroup2.substring(iIndexOf2 + 1);
                        switch (strSubstring2) {
                            case "line-left":
                                b3 = 0;
                                break;
                            case "center":
                                b3 = 2;
                                break;
                            case "line-right":
                                b3 = 4;
                                break;
                            case "middle":
                                b3 = 3;
                                break;
                            case "end":
                                b3 = 5;
                                break;
                            case "start":
                                b3 = 1;
                                break;
                            default:
                                b3 = -1;
                                break;
                        }
                        if (b3 == 0 || b3 == 1) {
                            i = 0;
                        } else if (b3 != 2 && b3 != 3) {
                            if (b3 == 4 || b3 == 5) {
                                i = 2;
                            } else {
                                String.valueOf(strSubstring2);
                                zzdt.zzc("WebvttCueParser", "Invalid anchor value: ".concat(String.valueOf(strSubstring2)));
                                i = Integer.MIN_VALUE;
                            }
                        }
                        zzalyVar.zzi = i;
                        strGroup2 = strGroup2.substring(0, iIndexOf2);
                    }
                    zzalyVar.zzh = zzamb.zzb(strGroup2);
                } else if ("size".equals(strGroup)) {
                    zzalyVar.zzj = zzamb.zzb(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    int iHashCode = strGroup2.hashCode();
                    if (iHashCode != 3462) {
                        if (iHashCode == 3642 && strGroup2.equals("rl")) {
                            b2 = 0;
                        } else {
                            b2 = -1;
                        }
                    } else if (strGroup2.equals("lr")) {
                        b2 = 1;
                    } else {
                        b2 = -1;
                    }
                    if (b2 != 0) {
                        if (b2 != 1) {
                            zzdt.zzc("WebvttCueParser", "Invalid 'vertical' value: ".concat(strGroup2));
                            i = Integer.MIN_VALUE;
                        } else {
                            i = 2;
                        }
                    }
                    zzalyVar.zzk = i;
                } else {
                    StringBuilder sb = new StringBuilder(strGroup.length() + 21 + strGroup2.length());
                    sb.append("Unknown cue setting ");
                    sb.append(strGroup);
                    sb.append(":");
                    sb.append(strGroup2);
                    zzdt.zzc("WebvttCueParser", sb.toString());
                }
            } catch (NumberFormatException unused) {
                String strGroup3 = matcher.group();
                String.valueOf(strGroup3);
                zzdt.zzc("WebvttCueParser", "Skipping bad cue setting: ".concat(String.valueOf(strGroup3)));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0086  */
    private static void zzf(String str, zzalw zzalwVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        byte b;
        int i = zzalwVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzalwVar.zza;
        int iHashCode = str2.hashCode();
        int i2 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode != 3511770) {
                        if (iHashCode != 98) {
                            if (iHashCode != 99) {
                                if (iHashCode != 117) {
                                    if (iHashCode == 118 && str2.equals("v")) {
                                        b = 5;
                                    } else {
                                        b = -1;
                                    }
                                } else if (str2.equals("u")) {
                                    b = 3;
                                } else {
                                    b = -1;
                                }
                            } else if (str2.equals("c")) {
                                b = 4;
                            } else {
                                b = -1;
                            }
                        } else if (str2.equals("b")) {
                            b = 0;
                        } else {
                            b = -1;
                        }
                    } else if (str2.equals("ruby")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str2.equals("lang")) {
                    b = 6;
                } else {
                    b = -1;
                }
            } else if (str2.equals("i")) {
                b = 1;
            } else {
                b = -1;
            }
        } else if (str2.equals("")) {
            b = 7;
        } else {
            b = -1;
        }
        switch (b) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i, length, 33);
                break;
            case 2:
                int iZzg = zzg(list2, str, zzalwVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, zzalv.zza);
                int i3 = i;
                int i4 = 0;
                int length2 = 0;
                while (i4 < arrayList.size()) {
                    if ("rt".equals(((zzalv) arrayList.get(i4)).zzc().zza)) {
                        zzalv zzalvVar = (zzalv) arrayList.get(i4);
                        int iZzg2 = zzg(list2, str, zzalvVar.zzc());
                        if (iZzg2 == i2) {
                            iZzg2 = iZzg != i2 ? iZzg : 1;
                        }
                        int i5 = zzalvVar.zzc().zzb - length2;
                        int iZzd = zzalvVar.zzd() - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i5, iZzd);
                        spannableStringBuilder.delete(i5, iZzd);
                        spannableStringBuilder.setSpan(new zzcr(charSequenceSubSequence.toString(), iZzg2), i3, i5, 33);
                        length2 += charSequenceSubSequence.length();
                        i3 = i5;
                    }
                    i4++;
                    i2 = -1;
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                break;
            case 4:
                for (String str3 : zzalwVar.zzd) {
                    Map map = zzc;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i, length, 33);
                    } else {
                        Map map2 = zzd;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i, length, 33);
                        }
                    }
                }
                break;
            case 5:
                spannableStringBuilder.setSpan(new zzcu(zzalwVar.zzc), i, length, 33);
                break;
            case 6:
            case 7:
                break;
            default:
                return;
        }
        List listZzh = zzh(list2, str, zzalwVar);
        for (int i6 = 0; i6 < listZzh.size(); i6++) {
            zzals zzalsVar = ((zzalx) listZzh.get(i6)).zzb;
            if (zzalsVar != null) {
                if (zzalsVar.zzf() != -1) {
                    zzcs.zza(spannableStringBuilder, new StyleSpan(zzalsVar.zzf()), i, length, 33);
                }
                if (zzalsVar.zzg()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i, length, 33);
                }
                if (zzalsVar.zzo()) {
                    zzcs.zza(spannableStringBuilder, new ForegroundColorSpan(zzalsVar.zzm()), i, length, 33);
                }
                if (zzalsVar.zzr()) {
                    zzcs.zza(spannableStringBuilder, new BackgroundColorSpan(zzalsVar.zzp()), i, length, 33);
                }
                if (zzalsVar.zzk() != null) {
                    zzcs.zza(spannableStringBuilder, new TypefaceSpan(zzalsVar.zzk()), i, length, 33);
                }
                int iZzu = zzalsVar.zzu();
                if (iZzu == 1) {
                    zzcs.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzalsVar.zzv(), true), i, length, 33);
                } else if (iZzu == 2) {
                    zzcs.zza(spannableStringBuilder, new RelativeSizeSpan(zzalsVar.zzv()), i, length, 33);
                } else if (iZzu == 3) {
                    zzcs.zza(spannableStringBuilder, new RelativeSizeSpan(zzalsVar.zzv() / 100.0f), i, length, 33);
                }
                if (zzalsVar.zzz()) {
                    spannableStringBuilder.setSpan(new zzcq(), i, length, 33);
                }
            }
        }
    }

    private static int zzg(List list, String str, zzalw zzalwVar) {
        List listZzh = zzh(list, str, zzalwVar);
        for (int i = 0; i < listZzh.size(); i++) {
            zzals zzalsVar = ((zzalx) listZzh.get(i)).zzb;
            if (zzalsVar.zzx() != -1) {
                return zzalsVar.zzx();
            }
        }
        return -1;
    }

    private static List zzh(List list, String str, zzalw zzalwVar) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzals zzalsVar = (zzals) list.get(i);
            int iZze = zzalsVar.zze(str, zzalwVar.zza, zzalwVar.zzd, zzalwVar.zzc);
            if (iZze > 0) {
                arrayList.add(new zzalx(iZze, zzalsVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
