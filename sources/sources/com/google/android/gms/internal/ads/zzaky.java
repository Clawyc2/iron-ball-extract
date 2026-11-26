package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.work.WorkRequest;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaky implements zzaki {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzakx zzc;
    private final zzeg zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzaky() {
        this(null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zzb(zzeg zzegVar, Charset charset) {
        while (true) {
            String strZzN = zzegVar.zzN(charset);
            if (strZzN == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzN)) {
                while (true) {
                    String strZzN2 = zzegVar.zzN(charset);
                    if (strZzN2 == null || (zzegVar.zzd() != 0 && zzegVar.zzp(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzN2.split(":");
                    if (strArrSplit.length == 2) {
                        byte b = 0;
                        String strZza = zzglm.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (!strZza.equals("playresx")) {
                                    b = -1;
                                }
                                break;
                            case 1879649549:
                                if (!strZza.equals("playresy")) {
                                    b = -1;
                                } else {
                                    b = 1;
                                }
                                break;
                            default:
                                b = -1;
                                break;
                        }
                        if (b == 0) {
                            this.zzf = Float.parseFloat(strArrSplit[1].trim());
                        } else if (b == 1) {
                            try {
                                this.zzg = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzN)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzakz zzakzVarZza = null;
                while (true) {
                    String strZzN3 = zzegVar.zzN(charset);
                    if (strZzN3 != null && (zzegVar.zzd() == 0 || zzegVar.zzp(charset) != 91)) {
                        if (strZzN3.startsWith("Format:")) {
                            zzakzVarZza = zzakz.zza(strZzN3);
                        } else if (strZzN3.startsWith("Style:")) {
                            if (zzakzVarZza == null) {
                                zzdt.zzc("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzN3));
                            } else {
                                zzalb zzalbVarZza = zzalb.zza(strZzN3, zzakzVarZza);
                                if (zzalbVarZza != null) {
                                    linkedHashMap.put(zzalbVarZza.zza, zzalbVarZza);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzN)) {
                zzdt.zzb("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzN)) {
                return;
            }
        }
    }

    private static long zzc(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = zzep.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * WorkRequest.MIN_BACKOFF_MILLIS);
    }

    private static float zzd(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zze(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:141:0x0317 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i, int i2, zzakh zzakhVar, zzdg zzdgVar) {
        zzakx zzakxVarZza;
        zzakx zzakxVar;
        int i3;
        Layout.Alignment alignment;
        int i4;
        int i5;
        int i6;
        Integer num;
        int i7;
        zzaky zzakyVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzeg zzegVar = zzakyVar.zzd;
        zzegVar.zzb(bArr, i + i2);
        zzegVar.zzh(i);
        Charset charsetZzR = zzegVar.zzR();
        if (charsetZzR == null) {
            charsetZzR = StandardCharsets.UTF_8;
        }
        if (zzakyVar.zzb) {
            zzakxVarZza = zzakyVar.zzc;
        } else {
            zzakyVar.zzb(zzegVar, charsetZzR);
            zzakxVarZza = null;
        }
        while (true) {
            String strZzN = zzegVar.zzN(charsetZzR);
            if (strZzN == null) {
                int i8 = 0;
                while (i8 < arrayList.size()) {
                    List list = (List) arrayList.get(i8);
                    if (!list.isEmpty()) {
                        if (i8 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue = ((Long) arrayList2.get(i8)).longValue();
                        zzdgVar.zza(new zzaka(list, jLongValue, ((Long) arrayList2.get(i8 + 1)).longValue() - jLongValue));
                    } else if (i8 == 0) {
                        i8 = 0;
                        if (i8 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue2 = ((Long) arrayList2.get(i8)).longValue();
                        zzdgVar.zza(new zzaka(list, jLongValue2, ((Long) arrayList2.get(i8 + 1)).longValue() - jLongValue2));
                    }
                    i8++;
                }
                return;
            }
            if (strZzN.startsWith("Format:")) {
                zzakxVarZza = zzakx.zza(strZzN);
            } else {
                if (strZzN.startsWith("Dialogue:")) {
                    if (zzakxVarZza == null) {
                        zzdt.zzc("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzN));
                    } else {
                        zzgmd.zza(strZzN.startsWith("Dialogue:"));
                        String strSubstring = strZzN.substring(9);
                        int i9 = zzakxVarZza.zzf;
                        String[] strArrSplit = strSubstring.split(",", i9);
                        if (strArrSplit.length != i9) {
                            zzdt.zzc("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzN));
                        } else {
                            int i10 = zzakxVarZza.zza;
                            if (i10 != -1) {
                                try {
                                    i3 = Integer.parseInt(strArrSplit[i10].trim());
                                } catch (RuntimeException unused) {
                                    String str = strArrSplit[zzakxVarZza.zza];
                                    String.valueOf(str);
                                    zzdt.zzc("SsaParser", "Fail to parse layer: ".concat(String.valueOf(str)));
                                    i3 = 0;
                                }
                            } else {
                                i3 = 0;
                            }
                            long jZzc = zzc(strArrSplit[zzakxVarZza.zzb]);
                            if (jZzc == -9223372036854775807L) {
                                zzdt.zzc("SsaParser", "Skipping invalid timing: ".concat(strZzN));
                            } else {
                                long jZzc2 = zzc(strArrSplit[zzakxVarZza.zzc]);
                                if (jZzc2 == -9223372036854775807L || jZzc2 <= jZzc) {
                                    zzakxVar = zzakxVarZza;
                                    zzegVar = zzegVar;
                                    zzdt.zzc("SsaParser", "Skipping invalid timing: ".concat(strZzN));
                                } else {
                                    Map map = zzakyVar.zze;
                                    zzalb zzalbVar = (map == null || (i7 = zzakxVarZza.zzd) == -1) ? null : (zzalb) map.get(strArrSplit[i7].trim());
                                    String str2 = strArrSplit[zzakxVarZza.zze];
                                    zzala zzalaVarZza = zzala.zza(str2);
                                    String strReplace = zzala.zzb(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = zzakyVar.zzf;
                                    float f2 = zzakyVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzcl zzclVar = new zzcl();
                                    zzclVar.zza(spannableString);
                                    zzclVar.zzq(i3);
                                    if (zzalbVar != null) {
                                        Integer num2 = zzalbVar.zzc;
                                        zzakxVar = zzakxVarZza;
                                        if (num2 != null) {
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        }
                                        if (zzalbVar.zzj == 3 && (num = zzalbVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f3 = zzalbVar.zze;
                                        if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            zzclVar.zzl(f3 / f2, 1);
                                        }
                                        if (!zzalbVar.zzf) {
                                            i5 = 0;
                                            i6 = 33;
                                            if (zzalbVar.zzg) {
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                        } else if (zzalbVar.zzg) {
                                            i5 = 0;
                                            i6 = 33;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i5 = 0;
                                            i6 = 33;
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                        }
                                        if (zzalbVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i5, spannableString.length(), i6);
                                        }
                                        if (zzalbVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i5, spannableString.length(), i6);
                                        }
                                    } else {
                                        zzakxVar = zzakxVarZza;
                                        zzegVar = zzegVar;
                                        f = f;
                                    }
                                    int i11 = zzalaVarZza.zza;
                                    if (i11 == -1) {
                                        i11 = zzalbVar != null ? zzalbVar.zzb : -1;
                                    }
                                    switch (i11) {
                                        case 0:
                                        default:
                                            StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 19);
                                            sb.append("Unknown alignment: ");
                                            sb.append(i11);
                                            zzdt.zzc("SsaParser", sb.toString());
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzclVar.zzd(alignment);
                                    int i12 = Integer.MIN_VALUE;
                                    switch (i11) {
                                        case 0:
                                        default:
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 19);
                                            sb2.append("Unknown alignment: ");
                                            sb2.append(i11);
                                            zzdt.zzc("SsaParser", sb2.toString());
                                        case -1:
                                            i4 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i4 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i4 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i4 = 2;
                                            break;
                                    }
                                    zzclVar.zzj(i4);
                                    switch (i11) {
                                        case -1:
                                            break;
                                        case 0:
                                        default:
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(i11).length() + 19);
                                            sb3.append("Unknown alignment: ");
                                            sb3.append(i11);
                                            zzdt.zzc("SsaParser", sb3.toString());
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i12 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i12 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i12 = 0;
                                            break;
                                    }
                                    zzclVar.zzg(i12);
                                    PointF pointF = zzalaVarZza.zzb;
                                    if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                        zzclVar.zzi(zzd(zzclVar.zzk()));
                                        zzclVar.zzf(zzd(zzclVar.zzh()), 0);
                                    } else {
                                        zzclVar.zzi(pointF.x / f);
                                        zzclVar.zzf(pointF.y / f2, 0);
                                    }
                                    zzcm zzcmVarZzr = zzclVar.zzr();
                                    int iZze = zze(jZzc2, arrayList2, arrayList);
                                    for (int iZze2 = zze(jZzc, arrayList2, arrayList); iZze2 < iZze; iZze2++) {
                                        ((List) arrayList.get(iZze2)).add(zzcmVarZzr);
                                    }
                                }
                            }
                        }
                    }
                    zzakxVar = zzakxVarZza;
                    zzegVar = zzegVar;
                } else {
                    zzakxVar = zzakxVarZza;
                    zzegVar = zzegVar;
                }
                zzakyVar = this;
                charsetZzR = charsetZzR;
                zzakxVarZza = zzakxVar;
                zzegVar = zzegVar;
            }
        }
    }

    public zzaky(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzeg();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzi = zzep.zzi((byte[]) list.get(0));
        zzgmd.zza(strZzi.startsWith("Format:"));
        zzakx zzakxVarZza = zzakx.zza(strZzi);
        zzakxVarZza.getClass();
        this.zzc = zzakxVarZza;
        zzb(new zzeg((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
