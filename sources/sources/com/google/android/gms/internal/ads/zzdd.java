package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdd {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", "A", "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    public static String zza(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String zzb(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        int i5;
        Object[] objArr = {zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)};
        String str = zzep.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i6 = 6;
        while (true) {
            if (i6 <= 0) {
                break;
            }
            int i7 = i6 - 1;
            if (iArr[i7] != 0) {
                break;
            }
            i6 = i7;
        }
        for (i5 = 0; i5 < i6; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static String zzc(byte[] bArr) {
        int length = bArr.length;
        zzgmd.zzd(length >= 17, "Invalid APV CSD length: %s", length);
        byte b = bArr[0];
        zzgmd.zzd(b == 1, "Invalid APV CSD version: %s", b);
        Object[] objArr = {Integer.valueOf(bArr[5]), Integer.valueOf(bArr[6]), Integer.valueOf(bArr[7])};
        String str = zzep.zza;
        return String.format(Locale.US, "apv1.apvf%d.apvl%d.apvb%d", objArr);
    }

    /* JADX WARN: Code duplicated, block: B:190:0x0331  */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0200, code lost:
    
        if (r8.equals("vp09") != true) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0202, code lost:
    
        r8 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x020b, code lost:
    
        if (r8.equals("s263") != true) goto L499;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x020d, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0216, code lost:
    
        if (r8.equals("mp4a") != true) goto L500;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0218, code lost:
    
        r8 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0220, code lost:
    
        if (r8.equals("iamf") != true) goto L501;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0222, code lost:
    
        r8 = 10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x022b, code lost:
    
        if (r8.equals("hvc1") != true) goto L502;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x022d, code lost:
    
        r8 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0235, code lost:
    
        if (r8.equals("hev1") != true) goto L503;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0237, code lost:
    
        r8 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x023f, code lost:
    
        if (r8.equals("avc2") != true) goto L504;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0241, code lost:
    
        r8 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0249, code lost:
    
        if (r8.equals("avc1") != true) goto L505;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x024b, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0253, code lost:
    
        if (r8.equals("av01") != true) goto L506;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0255, code lost:
    
        r8 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x025d, code lost:
    
        if (r8.equals("apv1") != true) goto L507;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x025f, code lost:
    
        r8 = 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0267, code lost:
    
        if (r8.equals("ac-4") != true) goto L508;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0269, code lost:
    
        r8 = 9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x026c, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0273, code lost:
    
        switch(r8) {
            case 0: goto L451;
            case 1: goto L386;
            case 2: goto L386;
            case 3: goto L331;
            case 4: goto L329;
            case 5: goto L329;
            case 6: goto L276;
            case 7: goto L256;
            case 8: goto L221;
            case 9: goto L182;
            case 10: goto L149;
            default: goto L148;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:500:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:501:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:502:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:503:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:504:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:505:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:506:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:507:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:508:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:509:?, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v100 int, still in use, count: 1, list:
      (r1v100 int) from 0x0067: IF  (r1v100 int) != (1567 int)  -> B:20:0x0069 A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v100 int, still in use, count: 1, list:
      (r1v100 int) from 0x0067: IF  (r1v100 int) != (1567 int)  -> B:20:0x0069 A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair zzd(com.google.android.gms.internal.ads.zzv r23) {
        /*
            Method dump skipped, instruction units count: 2390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.zzd(com.google.android.gms.internal.ads.zzv):android.util.Pair");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x019c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0068  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Pair zze(String str, String[] strArr, zzi zziVar) {
        int i;
        Integer num;
        if (strArr.length < 4) {
            String.valueOf(str);
            zzdt.zzc("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            String.valueOf(str);
            zzdt.zzc("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String strGroup = matcher.group(1);
        byte b = 6;
        if ("1".equals(strGroup)) {
            i = 1;
        } else if ("2".equals(strGroup)) {
            i = (zziVar == null || zziVar.zzd != 6) ? 2 : 4096;
        } else {
            if (!"6".equals(strGroup)) {
                String.valueOf(strGroup);
                zzdt.zzc("CodecSpecificDataUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup)));
                return null;
            }
            i = 6;
        }
        String str2 = strArr[3];
        if (str2 != null) {
            switch (str2.hashCode()) {
                case 70821:
                    if (!str2.equals("H30")) {
                        b = -1;
                    } else {
                        b = Ascii.CR;
                    }
                    break;
                case 70914:
                    if (!str2.equals("H60")) {
                        b = -1;
                    } else {
                        b = Ascii.SO;
                    }
                    break;
                case 70917:
                    if (!str2.equals("H63")) {
                        b = -1;
                    } else {
                        b = Ascii.SI;
                    }
                    break;
                case 71007:
                    if (!str2.equals("H90")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 71010:
                    if (!str2.equals("H93")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 74665:
                    if (!str2.equals("L30")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 74758:
                    if (!str2.equals("L60")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 74761:
                    if (!str2.equals("L63")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 74851:
                    if (!str2.equals("L90")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 74854:
                    if (!str2.equals("L93")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 2193639:
                    if (!str2.equals("H120")) {
                        b = -1;
                    } else {
                        b = Ascii.DC2;
                    }
                    break;
                case 2193642:
                    if (!str2.equals("H123")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case 2193732:
                    if (!str2.equals("H150")) {
                        b = -1;
                    } else {
                        b = Ascii.DC4;
                    }
                    break;
                case 2193735:
                    if (!str2.equals("H153")) {
                        b = -1;
                    } else {
                        b = Ascii.NAK;
                    }
                    break;
                case 2193738:
                    if (!str2.equals("H156")) {
                        b = -1;
                    } else {
                        b = Ascii.SYN;
                    }
                    break;
                case 2193825:
                    if (!str2.equals("H180")) {
                        b = -1;
                    } else {
                        b = Ascii.ETB;
                    }
                    break;
                case 2193828:
                    if (!str2.equals("H183")) {
                        b = -1;
                    } else {
                        b = Ascii.CAN;
                    }
                    break;
                case 2193831:
                    if (!str2.equals("H186")) {
                        b = -1;
                    } else {
                        b = Ascii.EM;
                    }
                    break;
                case 2312803:
                    if (!str2.equals("L120")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 2312806:
                    if (!str2.equals("L123")) {
                        b = -1;
                    }
                    break;
                case 2312896:
                    if (!str2.equals("L150")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 2312899:
                    if (!str2.equals("L153")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case 2312902:
                    if (!str2.equals("L156")) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 2312989:
                    if (!str2.equals("L180")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case 2312992:
                    if (!str2.equals("L183")) {
                        b = -1;
                    } else {
                        b = Ascii.VT;
                    }
                    break;
                case 2312995:
                    if (!str2.equals("L186")) {
                        b = -1;
                    } else {
                        b = Ascii.FF;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    num = 1;
                    break;
                case 1:
                    num = 4;
                    break;
                case 2:
                    num = 16;
                    break;
                case 3:
                    num = 64;
                    break;
                case 4:
                    num = 256;
                    break;
                case 5:
                    num = 1024;
                    break;
                case 6:
                    num = 4096;
                    break;
                case 7:
                    num = 16384;
                    break;
                case 8:
                    num = 65536;
                    break;
                case 9:
                    num = 262144;
                    break;
                case 10:
                    num = 1048576;
                    break;
                case 11:
                    num = 4194304;
                    break;
                case 12:
                    num = 16777216;
                    break;
                case 13:
                    num = 2;
                    break;
                case 14:
                    num = 8;
                    break;
                case 15:
                    num = 32;
                    break;
                case 16:
                    num = 128;
                    break;
                case 17:
                    num = 512;
                    break;
                case 18:
                    num = 2048;
                    break;
                case 19:
                    num = 8192;
                    break;
                case 20:
                    num = 32768;
                    break;
                case 21:
                    num = 131072;
                    break;
                case 22:
                    num = 524288;
                    break;
                case 23:
                    num = 2097152;
                    break;
                case 24:
                    num = 8388608;
                    break;
                case 25:
                    num = 33554432;
                    break;
                default:
                    num = null;
                    break;
            }
        } else {
            num = null;
        }
        if (num != null) {
            return new Pair(Integer.valueOf(i), num);
        }
        String.valueOf(str2);
        zzdt.zzc("CodecSpecificDataUtil", "Unknown HEVC level string: ".concat(String.valueOf(str2)));
        return null;
    }

    public static byte[] zzf(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }
}
