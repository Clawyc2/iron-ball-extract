package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzalr {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzeg zzc = new zzeg();
    private final StringBuilder zzd = new StringBuilder();

    static void zzb(zzeg zzegVar) {
        while (true) {
            for (boolean z = true; zzegVar.zzd() > 0 && z; z = false) {
                char c = (char) zzegVar.zzi()[zzegVar.zzg()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzegVar.zzk(1);
                } else {
                    int iZzg = zzegVar.zzg();
                    int iZze = zzegVar.zze();
                    byte[] bArrZzi = zzegVar.zzi();
                    if (iZzg + 2 <= iZze) {
                        int i = iZzg + 1;
                        if (bArrZzi[iZzg] == 47) {
                            int i2 = iZzg + 2;
                            if (bArrZzi[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzi[i2]) == '*' && ((char) bArrZzi[i3]) == '/') {
                                        iZze = i2 + 2;
                                        i2 = iZze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzegVar.zzk(iZze - zzegVar.zzg());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    static String zzc(zzeg zzegVar, StringBuilder sb) {
        zzb(zzegVar);
        if (zzegVar.zzd() == 0) {
            return null;
        }
        String strZzd = zzd(zzegVar, sb);
        if (!strZzd.isEmpty()) {
            return strZzd;
        }
        char cZzs = (char) zzegVar.zzs();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cZzs).length());
        sb2.append(cZzs);
        return sb2.toString();
    }

    private static String zzd(zzeg zzegVar, StringBuilder sb) {
        char c;
        sb.setLength(0);
        int iZzg = zzegVar.zzg();
        int iZze = zzegVar.zze();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (iZzg < iZze && !z) {
                    c = (char) zzegVar.zzi()[iZzg];
                    if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                        break;
                    }
                    z = true;
                } else {
                    break loop0;
                }
            }
            sb.append(c);
            iZzg++;
        }
        zzegVar.zzk(iZzg - zzegVar.zzg());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:110:0x0202  */
    /* JADX WARN: Code duplicated, block: B:116:0x0215  */
    /* JADX WARN: Code duplicated, block: B:118:0x021b  */
    /* JADX WARN: Code duplicated, block: B:120:0x0223  */
    /* JADX WARN: Code duplicated, block: B:122:0x022b  */
    /* JADX WARN: Code duplicated, block: B:123:0x0230  */
    /* JADX WARN: Code duplicated, block: B:125:0x0238  */
    /* JADX WARN: Code duplicated, block: B:126:0x023d  */
    /* JADX WARN: Code duplicated, block: B:128:0x0245  */
    /* JADX WARN: Code duplicated, block: B:130:0x024d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0252  */
    /* JADX WARN: Code duplicated, block: B:133:0x025a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0262  */
    /* JADX WARN: Code duplicated, block: B:136:0x0267  */
    /* JADX WARN: Code duplicated, block: B:138:0x026f  */
    /* JADX WARN: Code duplicated, block: B:140:0x027f  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:145:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:151:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:153:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:154:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:156:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:157:0x02db  */
    /* JADX WARN: Code duplicated, block: B:159:0x02de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x02e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:161:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:164:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:165:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:177:0x02e7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:196:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:198:0x0305 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x003c  */
    /* JADX WARN: Code duplicated, block: B:96:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:97:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:99:0x01ce  */
    public final List zza(zzeg zzegVar) {
        String strTrim;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b;
        boolean z;
        StringBuilder sb = this.zzd;
        int i = 0;
        sb.setLength(0);
        int iZzg = zzegVar.zzg();
        while (!TextUtils.isEmpty(zzegVar.zzN(StandardCharsets.UTF_8))) {
        }
        zzeg zzegVar2 = this.zzc;
        zzegVar2.zzb(zzegVar.zzi(), zzegVar.zzg());
        zzegVar2.zzh(iZzg);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzb(zzegVar2);
            if (zzegVar2.zzd() >= 5 && "::cue".equals(zzegVar2.zzK(5, StandardCharsets.UTF_8))) {
                int iZzg2 = zzegVar2.zzg();
                String strZzc = zzc(zzegVar2, sb);
                if (strZzc == null) {
                    strTrim = null;
                } else if ("{".equals(strZzc)) {
                    zzegVar2.zzh(iZzg2);
                    strTrim = "";
                } else {
                    if ("(".equals(strZzc)) {
                        int iZzg3 = zzegVar2.zzg();
                        int iZze = zzegVar2.zze();
                        int i2 = i;
                        while (iZzg3 < iZze && i2 == 0) {
                            int i3 = iZzg3 + 1;
                            i2 = ((char) zzegVar2.zzi()[iZzg3]) == ')' ? 1 : i;
                            iZzg3 = i3;
                        }
                        strTrim = zzegVar2.zzK((iZzg3 - 1) - zzegVar2.zzg(), StandardCharsets.UTF_8).trim();
                    } else {
                        strTrim = null;
                    }
                    if (!")".equals(zzc(zzegVar2, sb))) {
                        strTrim = null;
                    }
                }
            } else {
                strTrim = null;
            }
            if (strTrim == null || !"{".equals(zzc(zzegVar2, sb))) {
                break;
            }
            zzals zzalsVar = new zzals();
            if (!strTrim.isEmpty()) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher2 = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        zzalsVar.zzd(strGroup2);
                    }
                    strTrim = strTrim.substring(i, iIndexOf);
                }
                String str = zzep.zza;
                String[] strArrSplit = strTrim.split("\\.", -1);
                String str2 = strArrSplit[i];
                int iIndexOf2 = str2.indexOf(35);
                if (iIndexOf2 != -1) {
                    zzalsVar.zzb(str2.substring(i, iIndexOf2));
                    zzalsVar.zza(str2.substring(iIndexOf2 + 1));
                } else {
                    zzalsVar.zzb(str2);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzalsVar.zzc((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            int i4 = i;
            String strZzc2 = null;
            while (i4 == 0) {
                int iZzg4 = zzegVar2.zzg();
                strZzc2 = zzc(zzegVar2, sb);
                int i5 = (strZzc2 == null || "}".equals(strZzc2)) ? 1 : i;
                if (i5 == 0) {
                    zzegVar2.zzh(iZzg4);
                    zzb(zzegVar2);
                    String strZzd = zzd(zzegVar2, sb);
                    if (!strZzd.isEmpty() && ":".equals(zzc(zzegVar2, sb))) {
                        zzb(zzegVar2);
                        StringBuilder sb2 = new StringBuilder();
                        int i6 = i;
                        while (true) {
                            if (i6 != 0) {
                                string = sb2.toString();
                                break;
                            }
                            int iZzg5 = zzegVar2.zzg();
                            String strZzc3 = zzc(zzegVar2, sb);
                            if (strZzc3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZzc3) || ";".equals(strZzc3)) {
                                zzegVar2.zzh(iZzg5);
                                i6 = 1;
                            } else {
                                sb2.append(strZzc3);
                            }
                        }
                        if (string != null && !string.isEmpty()) {
                            int iZzg6 = zzegVar2.zzg();
                            String strZzc4 = zzc(zzegVar2, sb);
                            if (";".equals(strZzc4)) {
                                if ("color".equals(strZzd)) {
                                    zzalsVar.zzn(zzde.zzb(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalsVar.zzq(zzde.zzb(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalsVar.zzw(1);
                                    } else if ("under".equals(string)) {
                                        zzalsVar.zzw(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string)) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    zzalsVar.zzy(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzalsVar.zzh(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalsVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzalsVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzalsVar.zzj(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzglm.zza(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592) {
                                                    b = -1;
                                                } else {
                                                    b = 0;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzalsVar.zzt(1);
                                        } else if (b != 1) {
                                            zzalsVar.zzt(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalsVar.zzt(3);
                                        }
                                        String strGroup3 = matcher.group(1);
                                        strGroup3.getClass();
                                        zzalsVar.zzs(Float.parseFloat(strGroup3));
                                    } else {
                                        StringBuilder sb3 = new StringBuilder(string.length() + 22);
                                        sb3.append("Invalid font-size: '");
                                        sb3.append(string);
                                        sb3.append("'.");
                                        zzdt.zzc("WebvttCssParser", sb3.toString());
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strZzc4)) {
                                zzegVar2.zzh(iZzg6);
                                if ("color".equals(strZzd)) {
                                    zzalsVar.zzn(zzde.zzb(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalsVar.zzq(zzde.zzb(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalsVar.zzw(1);
                                    } else if ("under".equals(string)) {
                                        zzalsVar.zzw(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string) || string.startsWith("digits")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzalsVar.zzy(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if ("underline".equals(string)) {
                                        zzalsVar.zzh(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalsVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if ("bold".equals(string)) {
                                        zzalsVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if ("italic".equals(string)) {
                                        zzalsVar.zzj(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzglm.zza(string));
                                    if (matcher.matches()) {
                                        StringBuilder sb4 = new StringBuilder(string.length() + 22);
                                        sb4.append("Invalid font-size: '");
                                        sb4.append(string);
                                        sb4.append("'.");
                                        zzdt.zzc("WebvttCssParser", sb4.toString());
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592 && strGroup.equals("px")) {
                                                    b = 0;
                                                } else {
                                                    b = -1;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b = 1;
                                            } else {
                                                b = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b = 2;
                                        } else {
                                            b = -1;
                                        }
                                        if (b != 0) {
                                            zzalsVar.zzt(1);
                                        } else if (b != 1) {
                                            zzalsVar.zzt(2);
                                        } else {
                                            if (b == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalsVar.zzt(3);
                                        }
                                        String strGroup4 = matcher.group(1);
                                        strGroup4.getClass();
                                        zzalsVar.zzs(Float.parseFloat(strGroup4));
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i4 = i5;
                i = 0;
            }
            if ("}".equals(strZzc2)) {
                arrayList.add(zzalsVar);
            }
            i = 0;
        }
        return arrayList;
    }
}
