package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.work.WorkRequest;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaik {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        String str = zzep.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    /* JADX WARN: Code duplicated, block: B:283:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:357:0x073f  */
    /* JADX WARN: Code duplicated, block: B:358:0x0741  */
    /* JADX WARN: Code duplicated, block: B:361:0x074c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:362:0x074e  */
    /* JADX WARN: Code duplicated, block: B:363:0x0750  */
    /* JADX WARN: Code duplicated, block: B:367:0x075b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:368:0x075d  */
    /* JADX WARN: Code duplicated, block: B:369:0x075f  */
    /* JADX WARN: Code duplicated, block: B:373:0x076a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:374:0x076c  */
    /* JADX WARN: Code duplicated, block: B:375:0x076e  */
    /* JADX WARN: Code duplicated, block: B:379:0x0778  */
    /* JADX WARN: Code duplicated, block: B:380:0x077a  */
    /* JADX WARN: Code duplicated, block: B:383:0x0784  */
    /* JADX WARN: Code duplicated, block: B:384:0x0786  */
    /* JADX WARN: Code duplicated, block: B:387:0x078e  */
    /* JADX WARN: Code duplicated, block: B:388:0x07a2  */
    /* JADX WARN: Code duplicated, block: B:600:0x0dc0  */
    /* JADX WARN: Code duplicated, block: B:601:0x0dc4  */
    /* JADX WARN: Code duplicated, block: B:603:0x0dc8  */
    /* JADX WARN: Code duplicated, block: B:605:0x0dd5  */
    /* JADX WARN: Code duplicated, block: B:606:0x0de1  */
    /* JADX WARN: Code duplicated, block: B:611:0x0e2b  */
    /* JADX WARN: Code duplicated, block: B:612:0x0e5f  */
    /* JADX WARN: Code duplicated, block: B:72:0x014e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0150 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0152  */
    /* JADX WARN: Code duplicated, block: B:75:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0156  */
    /* JADX WARN: Code duplicated, block: B:77:0x0159  */
    /* JADX WARN: Code duplicated, block: B:80:0x015f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0161  */
    /* JADX WARN: Code duplicated, block: B:82:0x0164  */
    /* JADX WARN: Code duplicated, block: B:84:0x0167  */
    /* JADX WARN: Code duplicated, block: B:86:0x016f  */
    /* JADX WARN: Multi-variable type inference failed */
    public static List zzb(zzeu zzeuVar, zzads zzadsVar, long j, zzq zzqVar, boolean z, boolean z2, zzglu zzgluVar, boolean z3) throws zzat {
        int i;
        int i2;
        long jZzz;
        int i3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        long j2;
        long jZzt;
        long jZzt2;
        String str;
        zzeu zzeuVar2;
        long[] jArr;
        long[] jArr2;
        zzv zzvVarZzM;
        zzajf zzajfVar;
        zzet zzetVar;
        zzap zzapVar;
        zzap zzapVar2;
        Pair pairZzn;
        ArrayList arrayList;
        String str2;
        zzq zzqVar2;
        int i6;
        String str3;
        long j3;
        int i7;
        int i8;
        int i9;
        zzaig zzaigVar;
        String str4;
        int i10;
        int i11;
        int i12;
        int i13;
        zzgpe zzgpeVarZzi;
        boolean z6;
        char c;
        int i14;
        int i15;
        zzfj zzfjVar;
        boolean z7;
        zzadt zzadtVarZzb;
        boolean z8;
        int i16;
        int i17;
        int i18;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        zzq zzqVarZzb;
        zzgpe zzgpeVarZzj;
        String str5;
        zzgpe zzgpeVarZzj2;
        String str6;
        long j4;
        boolean z16;
        zzajf zzajfVar2;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int i19 = 0;
        while (true) {
            List list = zzeuVar.zzc;
            if (i19 >= list.size()) {
                return arrayList3;
            }
            zzeu zzeuVar3 = (zzeu) list.get(i19);
            if (zzeuVar3.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i2 = i19;
            } else {
                zzev zzevVarZzc = zzeuVar.zzc(1836476516);
                zzevVarZzc.getClass();
                zzeu zzeuVarZzd = zzeuVar3.zzd(1835297121);
                zzeuVarZzd.getClass();
                zzev zzevVarZzc2 = zzeuVarZzd.zzc(1751411826);
                zzevVarZzc2.getClass();
                int iZzi = zzi(zzevVarZzc2.zza);
                int i20 = 1;
                if (iZzi == 1936684398) {
                    i = 1;
                } else if (iZzi == 1986618469) {
                    i = 2;
                } else if (iZzi == 1952807028 || iZzi == 1935832172 || iZzi == 1937072756 || iZzi == 1668047728 || iZzi == 1937072752) {
                    i = 3;
                } else {
                    i = iZzi == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    i2 = i19;
                    zzeuVar2 = zzeuVar3;
                } else {
                    zzev zzevVarZzc3 = zzeuVar3.zzc(1953196132);
                    zzevVarZzc3.getClass();
                    zzeg zzegVar = zzevVarZzc3.zza;
                    int i21 = 8;
                    zzegVar.zzh(8);
                    int iZza = zza(zzegVar.zzB());
                    zzegVar.zzk(iZza == 0 ? 8 : 16);
                    int iZzB = zzegVar.zzB();
                    char c2 = 0;
                    int i22 = 4;
                    zzegVar.zzk(4);
                    int iZzg = zzegVar.zzg();
                    int i23 = 0;
                    while (true) {
                        if (iZza == 0) {
                            i21 = i22;
                        }
                        i2 = i19;
                        if (i23 >= i21) {
                            zzegVar.zzk(i21);
                        } else {
                            if (zzegVar.zzi()[iZzg + i23] != -1) {
                                jZzz = iZza == 0 ? zzegVar.zzz() : zzegVar.zzJ();
                                if (jZzz != 0) {
                                    break;
                                }
                                break;
                            }
                            i23++;
                            i19 = i2;
                            i21 = 8;
                            i22 = 4;
                        }
                        jZzz = -9223372036854775807L;
                        break;
                    }
                    zzegVar.zzk(10);
                    int iZzt = zzegVar.zzt();
                    zzegVar.zzk(4);
                    int iZzB2 = zzegVar.zzB();
                    int iZzB3 = zzegVar.zzB();
                    zzegVar.zzk(4);
                    int iZzB4 = zzegVar.zzB();
                    int iZzB5 = zzegVar.zzB();
                    if (iZzB2 != 0) {
                        if (iZzB2 == 0) {
                            if (iZzB3 == -65536) {
                                if (iZzB4 != 65536) {
                                    if (iZzB4 == -65536) {
                                        if (iZzB5 == 0) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        z4 = z5;
                                        iZzB4 = -65536;
                                    }
                                    iZzB3 = -65536;
                                } else if (iZzB5 == 0) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (true != z4) {
                                    i5 = 270;
                                    i4 = i5;
                                    i20 = 1;
                                }
                                iZzB3 = -65536;
                            }
                            i3 = 0;
                        } else {
                            i3 = iZzB2;
                        }
                        i4 = ((i3 != -65536 || i3 == 65536) && iZzB3 == 0 && iZzB4 == 0 && iZzB5 == -65536) ? 180 : 0;
                    } else {
                        if (iZzB3 == 65536) {
                            if (iZzB4 != -65536) {
                                if (iZzB4 == 65536) {
                                    z16 = iZzB5 != 0;
                                    iZzB4 = 65536;
                                }
                                iZzB3 = 65536;
                            } else {
                                z16 = iZzB5 != 0;
                            }
                            if (true != z16) {
                                i5 = 90;
                            } else {
                                iZzB3 = 65536;
                            }
                            i4 = i5;
                            i20 = 1;
                        }
                        iZzB2 = 0;
                        if (iZzB2 == 0) {
                            if (iZzB3 == -65536) {
                                if (iZzB4 != 65536) {
                                    if (iZzB4 == -65536) {
                                        if (iZzB5 == 0) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        z4 = z5;
                                        iZzB4 = -65536;
                                    }
                                    iZzB3 = -65536;
                                } else if (iZzB5 == 0) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (true != z4) {
                                    i5 = 270;
                                    i4 = i5;
                                    i20 = 1;
                                }
                                iZzB3 = -65536;
                            }
                            i3 = 0;
                        } else {
                            i3 = iZzB2;
                        }
                        if (i3 != -65536) {
                        }
                    }
                    zzegVar.zzk(16);
                    short sZzv = zzegVar.zzv();
                    zzegVar.zzk(2);
                    short sZzv2 = zzegVar.zzv();
                    long j5 = j == -9223372036854775807L ? jZzz : j;
                    long j6 = zzd(zzevVarZzc.zza).zzc;
                    if (j5 == -9223372036854775807L) {
                        j2 = j6;
                        jZzt = -9223372036854775807L;
                    } else {
                        j2 = j6;
                        jZzt = zzep.zzt(j5, 1000000L, j2, RoundingMode.DOWN);
                    }
                    zzeu zzeuVarZzd2 = zzeuVarZzd.zzd(1835626086);
                    zzeuVarZzd2.getClass();
                    zzeu zzeuVarZzd3 = zzeuVarZzd2.zzd(1937007212);
                    zzeuVarZzd3.getClass();
                    zzev zzevVarZzc4 = zzeuVarZzd.zzc(1835296868);
                    zzevVarZzc4.getClass();
                    zzeg zzegVar2 = zzevVarZzc4.zza;
                    int i24 = 8;
                    zzegVar2.zzh(8);
                    int iZza2 = zza(zzegVar2.zzB());
                    zzegVar2.zzk(iZza2 == 0 ? 8 : 16);
                    long jZzz2 = zzegVar2.zzz();
                    int iZzg2 = zzegVar2.zzg();
                    int i25 = 0;
                    while (true) {
                        if (iZza2 == 0) {
                            i24 = 4;
                        }
                        if (i25 >= i24) {
                            zzeuVar3 = zzeuVar3;
                            zzegVar2.zzk(i24);
                            jZzt2 = -9223372036854775807L;
                            break;
                        }
                        if (zzegVar2.zzi()[iZzg2 + i25] != -1) {
                            long jZzz3 = iZza2 == 0 ? zzegVar2.zzz() : zzegVar2.zzJ();
                            jZzt2 = jZzz3 == 0 ? -9223372036854775807L : zzep.zzt(jZzz3, 1000000L, jZzz2, RoundingMode.DOWN);
                            break;
                        }
                        i25++;
                        zzeuVar3 = zzeuVar3;
                        i24 = 8;
                    }
                    int iZzt2 = zzegVar2.zzt();
                    char c3 = (char) (((iZzt2 >> 10) & 31) + 96);
                    char c4 = (char) (((iZzt2 >> 5) & 31) + 96);
                    char c5 = (char) ((iZzt2 & 31) + 96);
                    int i26 = 3;
                    char[] cArr = new char[3];
                    cArr[0] = c3;
                    cArr[i20] = c4;
                    char c6 = 2;
                    cArr[2] = c5;
                    int i27 = 0;
                    while (true) {
                        if (i27 >= i26) {
                            str = new String(cArr);
                            break;
                        }
                        char c7 = cArr[i27];
                        if (c7 < 'a' || c7 > 'z') {
                            str = null;
                            break;
                        }
                        i27++;
                        i26 = 3;
                    }
                    zzev zzevVarZzc5 = zzeuVarZzd3.zzc(1937011556);
                    if (zzevVarZzc5 == null) {
                        zzdt.zzc("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
                        zzeuVar2 = zzeuVar3;
                    } else {
                        long j7 = jZzt2;
                        String strZzc = zzaid.zzc(jZzz2, j7, str);
                        zzeg zzegVar3 = zzevVarZzc5.zza;
                        zzegVar3.zzh(12);
                        int iZzB6 = zzegVar3.zzB();
                        zzaig zzaigVar2 = new zzaig(iZzB6);
                        int i28 = iZzt;
                        int i29 = 0;
                        while (i29 < iZzB6) {
                            int i30 = i;
                            int iZzg3 = zzegVar3.zzg();
                            int iZzB7 = zzegVar3.zzB();
                            long j8 = j7;
                            String str7 = "childAtomSize must be positive";
                            zzade.zza(iZzB7 > 0 ? i20 : c2, "childAtomSize must be positive");
                            int iZzB8 = zzegVar3.zzB();
                            int i31 = iZzB6;
                            if (iZzB8 == 1635148593 || iZzB8 == 1635148595 || iZzB8 == 1701733238 || iZzB8 == 1831958048 || iZzB8 == 1836070006 || iZzB8 == 1752589105 || iZzB8 == 1751479857 || iZzB8 == 1932670515 || iZzB8 == 1211250227 || iZzB8 == 1748121139 || iZzB8 == 1987063864 || iZzB8 == 1987063865 || iZzB8 == 1635135537 || iZzB8 == 1685479798 || iZzB8 == 1685479729 || iZzB8 == 1685481573 || iZzB8 == 1685481521 || iZzB8 == 1634760241) {
                                sZzv2 = sZzv2;
                                sZzv = sZzv;
                                i28 = i28;
                                i30 = i30;
                                j8 = j8;
                                int i32 = iZzB8;
                                int i33 = iZzB;
                                int i34 = iZzB7;
                                zzegVar3.zzh(iZzg3 + 16);
                                zzegVar3.zzk(16);
                                int iZzt3 = zzegVar3.zzt();
                                i29 = i29;
                                int iZzt4 = zzegVar3.zzt();
                                arrayList = arrayList3;
                                zzegVar3.zzk(50);
                                int iZzg4 = zzegVar3.zzg();
                                str2 = str;
                                int i35 = 1701733238;
                                if (i32 == 1701733238) {
                                    Pair pairZzr = zzr(zzegVar3, iZzg3, i34);
                                    if (pairZzr != null) {
                                        int iIntValue = ((Integer) pairZzr.first).intValue();
                                        zzqVarZzb = zzqVar == null ? null : zzqVar.zzb(((zzajg) pairZzr.second).zzb);
                                        zzaigVar2.zza[i29] = (zzajg) pairZzr.second;
                                        i35 = iIntValue;
                                    } else {
                                        zzqVarZzb = zzqVar;
                                    }
                                    zzegVar3.zzh(iZzg4);
                                    i32 = i35;
                                    zzqVar2 = zzqVarZzb;
                                } else {
                                    zzqVar2 = zzqVar;
                                }
                                iZzg3 = iZzg3;
                                if (i32 == 1831958048) {
                                    int i36 = i32;
                                    str3 = "video/mpeg";
                                    i6 = i36;
                                } else {
                                    i6 = 1211250227;
                                    if (i32 == 1211250227) {
                                        str3 = "video/3gpp";
                                    } else {
                                        i6 = i32;
                                        str3 = null;
                                    }
                                }
                                zzq zzqVar3 = zzqVar2;
                                String str8 = strZzc;
                                int i37 = iZzg4;
                                int i38 = i4;
                                j3 = jZzz2;
                                float fZzH = 1.0f;
                                int i39 = 8;
                                int iZzc = -1;
                                int i40 = -1;
                                int i41 = 8;
                                List listZzj = null;
                                int i42 = -1;
                                zzfj zzfjVar2 = null;
                                int i43 = -1;
                                ByteBuffer byteBufferZzm = null;
                                zzahz zzahzVarZzq = null;
                                zzaib zzaibVar = null;
                                int i44 = -1;
                                int i45 = -1;
                                byte[] bArrCopyOfRange = null;
                                int i46 = -1;
                                boolean z17 = false;
                                int i47 = -1;
                                String str9 = null;
                                while (i37 - iZzg3 < i34) {
                                    zzegVar3.zzh(i37);
                                    int iZzg5 = zzegVar3.zzg();
                                    int iZzB9 = zzegVar3.zzB();
                                    if (iZzB9 != 0) {
                                        i9 = iZzB9;
                                    } else {
                                        if (zzegVar3.zzg() - iZzg3 == i34) {
                                            break;
                                        }
                                        i9 = 0;
                                    }
                                    zzade.zza(i9 > 0, str7);
                                    int iZzB10 = zzegVar3.zzB();
                                    if (iZzB10 == 1635148611) {
                                        int i48 = iZzg5 + 8;
                                        zzade.zza(str3 == null, null);
                                        zzegVar3.zzh(i48);
                                        zzacf zzacfVarZza = zzacf.zza(zzegVar3);
                                        List list2 = zzacfVarZza.zza;
                                        zzaigVar2.zzc = zzacfVarZza.zzb;
                                        if (z17) {
                                            z15 = true;
                                        } else {
                                            fZzH = zzacfVarZza.zzk;
                                            z15 = false;
                                        }
                                        String str10 = zzacfVarZza.zzl;
                                        int i49 = zzacfVarZza.zzj;
                                        int i50 = zzacfVarZza.zzg;
                                        int i51 = zzacfVarZza.zzh;
                                        int i52 = zzacfVarZza.zzi;
                                        int i53 = zzacfVarZza.zze;
                                        i10 = zzacfVarZza.zzf;
                                        zzaigVar = zzaigVar2;
                                        i6 = i6;
                                        str9 = str10;
                                        str4 = str7;
                                        z17 = z15;
                                        i40 = i50;
                                        i39 = i53;
                                        zzfjVar2 = zzfjVar2;
                                        str3 = "video/avc";
                                        i45 = i49;
                                        iZzc = i52;
                                        i42 = i51;
                                        listZzj = list2;
                                    } else if (iZzB10 == 1752589123) {
                                        int i54 = iZzg5 + 8;
                                        zzade.zza(str3 == null, null);
                                        zzegVar3.zzh(i54);
                                        zzadt zzadtVarZza = zzadt.zza(zzegVar3);
                                        List list3 = zzadtVarZza.zza;
                                        zzaigVar2.zzc = zzadtVarZza.zzb;
                                        if (z17) {
                                            z14 = true;
                                        } else {
                                            fZzH = zzadtVarZza.zzl;
                                            z14 = false;
                                        }
                                        int i55 = zzadtVarZza.zzm;
                                        int i56 = zzadtVarZza.zzc;
                                        String str11 = zzadtVarZza.zzn;
                                        int i57 = zzadtVarZza.zzk;
                                        if (i57 == -1) {
                                            i57 = i43;
                                        }
                                        int i58 = zzadtVarZza.zzd;
                                        int i59 = zzadtVarZza.zze;
                                        int i60 = zzadtVarZza.zzh;
                                        i42 = zzadtVarZza.zzi;
                                        int i61 = zzadtVarZza.zzj;
                                        int i62 = zzadtVarZza.zzf;
                                        int i63 = zzadtVarZza.zzg;
                                        zzfjVar2 = zzadtVarZza.zzo;
                                        zzaigVar = zzaigVar2;
                                        i6 = i6;
                                        i10 = i63;
                                        str4 = str7;
                                        str9 = str11;
                                        i47 = i58;
                                        i39 = i62;
                                        str3 = "video/hevc";
                                        z17 = z14;
                                        i46 = i59;
                                        i40 = i60;
                                        i43 = i57;
                                        listZzj = list3;
                                        i44 = i56;
                                        iZzc = i61;
                                        i45 = i55;
                                    } else if (iZzB10 == 1818785347) {
                                        int i64 = iZzg5 + 8;
                                        zzade.zza("video/hevc".equals(str3), "lhvC must follow hvcC atom");
                                        if (zzfjVar2 != null) {
                                            if (zzfjVar2.zza.size() >= 2) {
                                                zzfjVar = zzfjVar2;
                                                z7 = true;
                                            } else {
                                                zzfjVar = zzfjVar2;
                                            }
                                            zzade.zza(z7, "must have at least two layers");
                                            zzegVar3.zzh(i64);
                                            zzfjVar.getClass();
                                            zzadtVarZzb = zzadt.zzb(zzegVar3, zzfjVar);
                                            if (zzaigVar2.zzc == zzadtVarZzb.zzb) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            zzade.zza(z8, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                            i16 = zzadtVarZzb.zzh;
                                            if (i16 != -1) {
                                                if (i40 == i16) {
                                                    z13 = true;
                                                } else {
                                                    z13 = false;
                                                }
                                                zzade.zza(z13, "colorSpace must be the same for both views");
                                            }
                                            i17 = zzadtVarZzb.zzi;
                                            if (i17 != -1) {
                                                if (i42 == i17) {
                                                    z12 = true;
                                                } else {
                                                    z12 = false;
                                                }
                                                zzade.zza(z12, "colorRange must be the same for both views");
                                            }
                                            i18 = zzadtVarZzb.zzj;
                                            if (i18 != -1) {
                                                if (iZzc == i18) {
                                                    z11 = true;
                                                } else {
                                                    z11 = false;
                                                }
                                                zzade.zza(z11, "colorTransfer must be the same for both views");
                                            }
                                            if (i39 == zzadtVarZzb.zzf) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            zzade.zza(z9, "bitdepthLuma must be the same for both views");
                                            if (i41 == zzadtVarZzb.zzg) {
                                                z10 = true;
                                            } else {
                                                z10 = false;
                                            }
                                            zzade.zza(z10, "bitdepthChroma must be the same for both views");
                                            if (listZzj != null) {
                                                int i65 = zzgpe.zzd;
                                                zzgpb zzgpbVar = new zzgpb();
                                                zzgpbVar.zzh(listZzj);
                                                zzgpbVar.zzh(zzadtVarZzb.zza);
                                                listZzj = zzgpbVar.zzi();
                                            } else {
                                                zzade.zza(false, "initializationData must be already set from hvcC atom");
                                                listZzj = null;
                                            }
                                            str3 = "video/mv-hevc";
                                            zzaigVar = zzaigVar2;
                                            i6 = i6;
                                            zzfjVar2 = zzfjVar;
                                            str9 = zzadtVarZzb.zzn;
                                            str4 = str7;
                                            i10 = i41;
                                        } else {
                                            zzfjVar = null;
                                        }
                                        z7 = false;
                                        zzade.zza(z7, "must have at least two layers");
                                        zzegVar3.zzh(i64);
                                        zzfjVar.getClass();
                                        zzadtVarZzb = zzadt.zzb(zzegVar3, zzfjVar);
                                        if (zzaigVar2.zzc == zzadtVarZzb.zzb) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        zzade.zza(z8, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                        i16 = zzadtVarZzb.zzh;
                                        if (i16 != -1) {
                                            if (i40 == i16) {
                                                z13 = true;
                                            } else {
                                                z13 = false;
                                            }
                                            zzade.zza(z13, "colorSpace must be the same for both views");
                                        }
                                        i17 = zzadtVarZzb.zzi;
                                        if (i17 != -1) {
                                            if (i42 == i17) {
                                                z12 = true;
                                            } else {
                                                z12 = false;
                                            }
                                            zzade.zza(z12, "colorRange must be the same for both views");
                                        }
                                        i18 = zzadtVarZzb.zzj;
                                        if (i18 != -1) {
                                            if (iZzc == i18) {
                                                z11 = true;
                                            } else {
                                                z11 = false;
                                            }
                                            zzade.zza(z11, "colorTransfer must be the same for both views");
                                        }
                                        if (i39 == zzadtVarZzb.zzf) {
                                            z9 = true;
                                        } else {
                                            z9 = false;
                                        }
                                        zzade.zza(z9, "bitdepthLuma must be the same for both views");
                                        if (i41 == zzadtVarZzb.zzg) {
                                            z10 = true;
                                        } else {
                                            z10 = false;
                                        }
                                        zzade.zza(z10, "bitdepthChroma must be the same for both views");
                                        if (listZzj != null) {
                                            int i66 = zzgpe.zzd;
                                            zzgpb zzgpbVar2 = new zzgpb();
                                            zzgpbVar2.zzh(listZzj);
                                            zzgpbVar2.zzh(zzadtVarZzb.zza);
                                            listZzj = zzgpbVar2.zzi();
                                        } else {
                                            zzade.zza(false, "initializationData must be already set from hvcC atom");
                                            listZzj = null;
                                        }
                                        str3 = "video/mv-hevc";
                                        zzaigVar = zzaigVar2;
                                        i6 = i6;
                                        zzfjVar2 = zzfjVar;
                                        str9 = zzadtVarZzb.zzn;
                                        str4 = str7;
                                        i10 = i41;
                                    } else if (iZzB10 == 1986361461) {
                                        zzegVar3.zzh(iZzg5 + 8);
                                        int iZzg6 = zzegVar3.zzg();
                                        zzaigVar = zzaigVar2;
                                        zzaic zzaicVar = null;
                                        while (iZzg6 - iZzg5 < i9) {
                                            zzegVar3.zzh(iZzg6);
                                            int iZzB11 = zzegVar3.zzB();
                                            zzade.zza(iZzB11 > 0, str7);
                                            int i67 = i41;
                                            if (zzegVar3.zzB() == 1702454643) {
                                                zzegVar3.zzh(iZzg6 + 8);
                                                int iZzg7 = zzegVar3.zzg();
                                                while (true) {
                                                    if (iZzg7 - iZzg6 >= iZzB11) {
                                                        i15 = iZzB11;
                                                        zzaicVar = null;
                                                        break;
                                                    }
                                                    zzegVar3.zzh(iZzg7);
                                                    int iZzB12 = zzegVar3.zzB();
                                                    zzade.zza(iZzB12 > 0, str7);
                                                    i15 = iZzB11;
                                                    if (zzegVar3.zzB() == 1937011305) {
                                                        zzegVar3.zzk(4);
                                                        int iZzs = zzegVar3.zzs();
                                                        zzaicVar = new zzaic(new zzaif(1 == (iZzs & 1), (iZzs & 2) == 2, (iZzs & 8) == 8));
                                                        break;
                                                    }
                                                    iZzg7 += iZzB12;
                                                    iZzB11 = i15;
                                                }
                                            } else {
                                                i15 = iZzB11;
                                            }
                                            iZzg6 += i15;
                                            i41 = i67;
                                            str7 = str7;
                                        }
                                        str4 = str7;
                                        i10 = i41;
                                        zzaij zzaijVar = zzaicVar == null ? null : new zzaij(zzaicVar);
                                        if (zzaijVar != null) {
                                            if (zzfjVar2 == null) {
                                                zzfjVar2 = null;
                                            } else if (zzfjVar2.zza.size() >= 2) {
                                                zzade.zza(zzaijVar.zza(), "both eye views must be marked as available");
                                                zzade.zza(!zzaijVar.zzb().zza().zzc(), "for MV-HEVC, eye_views_reversed must be set to false");
                                            }
                                            if (i43 == -1) {
                                                i43 = true != zzaijVar.zzb().zza().zzc() ? 4 : 5;
                                            } else {
                                                zzfjVar2 = zzfjVar2;
                                            }
                                        }
                                        i11 = i39;
                                        i6 = i6;
                                        i12 = i42;
                                        zzfjVar2 = zzfjVar2;
                                        i13 = i43;
                                        i39 = i11;
                                        i42 = i12;
                                        i43 = i13;
                                    } else {
                                        zzaigVar = zzaigVar2;
                                        str4 = str7;
                                        i10 = i41;
                                        if (iZzB10 == 1685480259 || iZzB10 == 1685485123 || iZzB10 == 1685485379) {
                                            i11 = i39;
                                            i6 = i6;
                                            i12 = i42;
                                            zzfjVar2 = zzfjVar2;
                                            i13 = i43;
                                            int i68 = i9 - 8;
                                            int i69 = iZzg5 + 8;
                                            byte[] bArr = new byte[i68];
                                            zzegVar3.zzm(bArr, 0, i68);
                                            if (listZzj != null) {
                                                int i70 = zzgpe.zzd;
                                                zzgpb zzgpbVar3 = new zzgpb();
                                                zzgpbVar3.zzh(listZzj);
                                                zzgpbVar3.zzf(bArr);
                                                zzgpeVarZzi = zzgpbVar3.zzi();
                                            } else {
                                                zzade.zza(false, "initializationData must already be set from hvcC or avcC atom");
                                                zzgpeVarZzi = null;
                                            }
                                            zzegVar3.zzh(i69);
                                            zzer zzerVarZza = zzer.zza(zzegVar3);
                                            if (zzerVarZza != null) {
                                                str9 = zzerVarZza.zza;
                                                listZzj = zzgpeVarZzi;
                                                str3 = "video/dolby-vision";
                                            } else {
                                                listZzj = zzgpeVarZzi;
                                            }
                                        } else if (iZzB10 == 1987076931) {
                                            int i71 = iZzg5 + 12;
                                            zzade.zza(str3 == null, null);
                                            zzegVar3.zzh(i71);
                                            byte bZzs = (byte) zzegVar3.zzs();
                                            byte bZzs2 = (byte) zzegVar3.zzs();
                                            int iZzs2 = zzegVar3.zzs();
                                            int i72 = iZzs2 >> 4;
                                            int i73 = iZzs2 >> 1;
                                            String str12 = i6 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                            if (str12.equals("video/x-vnd.on2.vp9")) {
                                                int i74 = zzdd.zza;
                                                i14 = 1;
                                                c = 3;
                                                listZzj = zzgpe.zzj(new byte[]{1, 1, bZzs, 2, 1, bZzs2, 3, 1, (byte) i72, 4, 1, (byte) (i73 & 7)});
                                            } else {
                                                c = 3;
                                                i14 = 1;
                                            }
                                            int i75 = iZzs2 & 1;
                                            int iZzs3 = zzegVar3.zzs();
                                            int iZzs4 = zzegVar3.zzs();
                                            int iZzb = zzi.zzb(iZzs3);
                                            int i76 = i14 != i75 ? 2 : 1;
                                            iZzc = zzi.zzc(iZzs4);
                                            i42 = i76;
                                            i6 = i6;
                                            i40 = iZzb;
                                            i10 = i72;
                                            str3 = str12;
                                            zzfjVar2 = zzfjVar2;
                                            i39 = i10;
                                        } else if (iZzB10 == 1635135811) {
                                            int i77 = i9 - 8;
                                            byte[] bArr2 = new byte[i77];
                                            zzegVar3.zzm(bArr2, 0, i77);
                                            zzgpe zzgpeVarZzj3 = zzgpe.zzj(bArr2);
                                            zzegVar3.zzh(iZzg5 + 8);
                                            zzi zziVarZzk = zzk(zzegVar3);
                                            int i78 = zziVarZzk.zzf;
                                            int i79 = zziVarZzk.zzg;
                                            int i80 = zziVarZzk.zzb;
                                            i10 = i79;
                                            i42 = zziVarZzk.zzc;
                                            str3 = "video/av01";
                                            zzfjVar2 = zzfjVar2;
                                            listZzj = zzgpeVarZzj3;
                                            iZzc = zziVarZzk.zzd;
                                            i39 = i78;
                                            i40 = i80;
                                        } else if (iZzB10 == 1668050025) {
                                            if (byteBufferZzm == null) {
                                                byteBufferZzm = zzm();
                                            }
                                            ByteBuffer byteBuffer = byteBufferZzm;
                                            byteBuffer.position(21);
                                            byteBuffer.putShort(zzegVar3.zzv());
                                            byteBuffer.putShort(zzegVar3.zzv());
                                            byteBufferZzm = byteBuffer;
                                            zzfjVar2 = zzfjVar2;
                                        } else if (iZzB10 == 1835295606) {
                                            if (byteBufferZzm == null) {
                                                byteBufferZzm = zzm();
                                            }
                                            ByteBuffer byteBuffer2 = byteBufferZzm;
                                            short sZzv3 = zzegVar3.zzv();
                                            short sZzv4 = zzegVar3.zzv();
                                            short sZzv5 = zzegVar3.zzv();
                                            short sZzv6 = zzegVar3.zzv();
                                            i6 = i6;
                                            short sZzv7 = zzegVar3.zzv();
                                            zzfjVar2 = zzfjVar2;
                                            short sZzv8 = zzegVar3.zzv();
                                            int i81 = i39;
                                            short sZzv9 = zzegVar3.zzv();
                                            int i82 = i42;
                                            short sZzv10 = zzegVar3.zzv();
                                            long jZzz4 = zzegVar3.zzz();
                                            long jZzz5 = zzegVar3.zzz();
                                            byteBuffer2.position(1);
                                            byteBuffer2.putShort(sZzv7);
                                            byteBuffer2.putShort(sZzv8);
                                            byteBuffer2.putShort(sZzv3);
                                            byteBuffer2.putShort(sZzv4);
                                            byteBuffer2.putShort(sZzv5);
                                            byteBuffer2.putShort(sZzv6);
                                            byteBuffer2.putShort(sZzv9);
                                            byteBuffer2.putShort(sZzv10);
                                            byteBuffer2.putShort((short) (jZzz4 / WorkRequest.MIN_BACKOFF_MILLIS));
                                            byteBuffer2.putShort((short) (jZzz5 / WorkRequest.MIN_BACKOFF_MILLIS));
                                            byteBufferZzm = byteBuffer2;
                                            i39 = i81;
                                            i42 = i82;
                                            i43 = i43;
                                        } else {
                                            i11 = i39;
                                            i6 = i6;
                                            i12 = i42;
                                            zzfjVar2 = zzfjVar2;
                                            i13 = i43;
                                            if (iZzB10 == 1681012275) {
                                                zzade.zza(str3 == null, null);
                                                str3 = "video/3gpp";
                                            } else if (iZzB10 == 1702061171) {
                                                zzade.zza(str3 == null, null);
                                                zzaib zzaibVarZzp = zzp(zzegVar3, iZzg5);
                                                String strZza = zzaibVarZzp.zza();
                                                byte[] bArrZzb = zzaibVarZzp.zzb();
                                                if (bArrZzb != null) {
                                                    zzaibVar = zzaibVarZzp;
                                                    str3 = strZza;
                                                    listZzj = zzgpe.zzj(bArrZzb);
                                                } else {
                                                    zzaibVar = zzaibVarZzp;
                                                    str3 = strZza;
                                                }
                                            } else if (iZzB10 == 1651798644) {
                                                zzahzVarZzq = zzq(zzegVar3, iZzg5);
                                            } else if (iZzB10 == 1885434736) {
                                                zzegVar3.zzh(iZzg5 + 8);
                                                fZzH = zzegVar3.zzH() / zzegVar3.zzH();
                                                i39 = i11;
                                                i42 = i12;
                                                i43 = i13;
                                                z17 = true;
                                            } else if (iZzB10 == 1937126244) {
                                                int i83 = iZzg5 + 8;
                                                while (true) {
                                                    if (i83 - iZzg5 >= i9) {
                                                        bArrCopyOfRange = null;
                                                        break;
                                                    }
                                                    zzegVar3.zzh(i83);
                                                    int iZzB13 = zzegVar3.zzB() + i83;
                                                    if (zzegVar3.zzB() == 1886547818) {
                                                        bArrCopyOfRange = Arrays.copyOfRange(zzegVar3.zzi(), i83, iZzB13);
                                                        break;
                                                    }
                                                    i83 = iZzB13;
                                                }
                                            } else if (iZzB10 == 1936995172) {
                                                int iZzs5 = zzegVar3.zzs();
                                                zzegVar3.zzk(3);
                                                if (iZzs5 == 0) {
                                                    int iZzs6 = zzegVar3.zzs();
                                                    if (iZzs6 == 0) {
                                                        i39 = i11;
                                                        i42 = i12;
                                                        i43 = 0;
                                                    } else if (iZzs6 == 1) {
                                                        i39 = i11;
                                                        i42 = i12;
                                                        i43 = 1;
                                                    } else if (iZzs6 == 2) {
                                                        i39 = i11;
                                                        i42 = i12;
                                                        i43 = 2;
                                                    } else if (iZzs6 == 3) {
                                                        i43 = 3;
                                                        i39 = i11;
                                                        i42 = i12;
                                                    }
                                                }
                                            } else if (iZzB10 == 1634760259) {
                                                int i84 = i9 - 12;
                                                byte[] bArr3 = new byte[i84];
                                                zzegVar3.zzh(iZzg5 + 12);
                                                zzegVar3.zzm(bArr3, 0, i84);
                                                String strZzc2 = zzdd.zzc(bArr3);
                                                zzgpe zzgpeVarZzj4 = zzgpe.zzj(bArr3);
                                                zzi zziVarZzl = zzl(new zzeg(bArr3));
                                                int i85 = zziVarZzl.zzf;
                                                int i86 = zziVarZzl.zzg;
                                                i40 = zziVarZzl.zzb;
                                                str9 = strZzc2;
                                                i39 = i85;
                                                i10 = i86;
                                                i42 = zziVarZzl.zzc;
                                                str3 = "video/apv";
                                                i43 = i13;
                                                iZzc = zziVarZzl.zzd;
                                                listZzj = zzgpeVarZzj4;
                                            } else if (iZzB10 == 1668246642 && i40 == -1) {
                                                if (iZzc == -1) {
                                                    int iZzB14 = zzegVar3.zzB();
                                                    if (iZzB14 == 1852009592 || iZzB14 == 1852009571) {
                                                        int iZzt5 = zzegVar3.zzt();
                                                        int iZzt6 = zzegVar3.zzt();
                                                        zzegVar3.zzk(2);
                                                        if (i9 != 19) {
                                                            z6 = false;
                                                        } else if ((zzegVar3.zzs() & 128) != 0) {
                                                            i9 = 19;
                                                            z6 = true;
                                                        } else {
                                                            i9 = 19;
                                                            z6 = false;
                                                        }
                                                        int iZzb2 = zzi.zzb(iZzt5);
                                                        int i87 = true != z6 ? 2 : 1;
                                                        i40 = iZzb2;
                                                        i42 = i87;
                                                        i39 = i11;
                                                        i43 = i13;
                                                        iZzc = zzi.zzc(iZzt6);
                                                    } else {
                                                        zzdt.zzc("BoxParsers", "Unsupported color type: ".concat(zzew.zze(iZzB14)));
                                                        iZzc = -1;
                                                        i40 = -1;
                                                        i39 = i11;
                                                        i42 = i12;
                                                        i43 = i13;
                                                    }
                                                } else {
                                                    i40 = -1;
                                                }
                                            }
                                            i39 = i11;
                                            i42 = i12;
                                            i43 = i13;
                                        }
                                        i39 = i11;
                                        i42 = i12;
                                        i43 = i13;
                                    }
                                    i37 += i9;
                                    i34 = i34;
                                    zzaigVar2 = zzaigVar;
                                    i6 = i6;
                                    i41 = i10;
                                    zzfjVar2 = zzfjVar2;
                                    str7 = str4;
                                }
                                int i88 = i39;
                                zzaig zzaigVar3 = zzaigVar2;
                                iZzB7 = i34;
                                int i89 = i41;
                                int i90 = i42;
                                int i91 = i43;
                                c6 = 2;
                                if (str3 == null) {
                                    strZzc = str8;
                                    i8 = i38;
                                    i7 = i33;
                                    zzaigVar2 = zzaigVar3;
                                } else {
                                    zzt zztVar = new zzt();
                                    i7 = i33;
                                    zztVar.zzb(i7);
                                    zztVar.zzm(str3);
                                    zztVar.zzj(str9);
                                    zztVar.zzt(iZzt3);
                                    zztVar.zzu(iZzt4);
                                    zztVar.zzv(i47);
                                    zztVar.zzw(i46);
                                    zztVar.zzz(fZzH);
                                    i8 = i38;
                                    zztVar.zzy(i8);
                                    zztVar.zzA(bArrCopyOfRange);
                                    zztVar.zzB(i91);
                                    zztVar.zzp(listZzj);
                                    zztVar.zzo(i45);
                                    zztVar.zzD(i44);
                                    zztVar.zzq(zzqVar3);
                                    strZzc = str8;
                                    zztVar.zze(strZzc);
                                    zzh zzhVar = new zzh();
                                    zzhVar.zza(i40);
                                    zzhVar.zzb(i90);
                                    zzhVar.zzc(iZzc);
                                    zzhVar.zzd(byteBufferZzm != null ? byteBufferZzm.array() : null);
                                    zzhVar.zze(i88);
                                    zzhVar.zzf(i89);
                                    zztVar.zzC(zzhVar.zzg());
                                    if (zzahzVarZzq != null) {
                                        zztVar.zzh(zzgst.zzb(zzahzVarZzq.zza()));
                                        zztVar.zzi(zzgst.zzb(zzahzVarZzq.zzb()));
                                    } else if (zzaibVar != null) {
                                        zztVar.zzh(zzgst.zzb(zzaibVar.zzc()));
                                        zztVar.zzi(zzgst.zzb(zzaibVar.zzd()));
                                    }
                                    zzaigVar2 = zzaigVar3;
                                    zzaigVar2.zzb = zztVar.zzM();
                                }
                            } else if (iZzB8 == 1836069985 || iZzB8 == 1701733217 || iZzB8 == 1633889587 || iZzB8 == 1700998451 || iZzB8 == 1633889588 || iZzB8 == 1835823201 || iZzB8 == 1685353315 || iZzB8 == 1685353317 || iZzB8 == 1685353320 || iZzB8 == 1685353324 || iZzB8 == 1685353336 || iZzB8 == 1935764850 || iZzB8 == 1935767394 || iZzB8 == 1819304813 || iZzB8 == 1936684916 || iZzB8 == 1953984371 || iZzB8 == 778924082 || iZzB8 == 778924083 || iZzB8 == 1835557169 || iZzB8 == 1835560241 || iZzB8 == 1634492771 || iZzB8 == 1634492791 || iZzB8 == 1970037111 || iZzB8 == 1332770163 || iZzB8 == 1716281667 || iZzB8 == 1767992678 || iZzB8 == 1768973165 || iZzB8 == 1718641517) {
                                zzaigVar2 = zzaigVar2;
                                sZzv2 = sZzv2;
                                sZzv = sZzv;
                                i28 = i28;
                                i30 = i30;
                                j8 = j8;
                                i7 = iZzB;
                                zzo(zzegVar3, iZzB8, iZzg3, iZzB7, i7, strZzc, z2, zzqVar, zzaigVar2, i29);
                                str2 = str;
                                iZzg3 = iZzg3;
                                iZzB7 = iZzB7;
                                strZzc = strZzc;
                                i29 = i29;
                                arrayList = arrayList3;
                                i8 = i4;
                                j3 = jZzz2;
                                c6 = 2;
                            } else {
                                if (iZzB8 == 1414810956 || iZzB8 == 1954034535 || iZzB8 == 2004251764 || iZzB8 == 1937010800 || iZzB8 == 1664495672 || iZzB8 == 1836070003) {
                                    zzegVar3.zzh(iZzg3 + 16);
                                    if (iZzB8 == 1414810956) {
                                        str6 = "application/ttml+xml";
                                    } else {
                                        if (iZzB8 == 1954034535) {
                                            int i92 = iZzB7 - 16;
                                            byte[] bArr4 = new byte[i92];
                                            zzegVar3.zzm(bArr4, 0, i92);
                                            zzgpeVarZzj2 = zzgpe.zzj(bArr4);
                                            str6 = "application/x-quicktime-tx3g";
                                        } else if (iZzB8 == 2004251764) {
                                            str6 = "application/x-mp4-vtt";
                                        } else if (iZzB8 == 1937010800) {
                                            str6 = "application/ttml+xml";
                                            j4 = 0;
                                            zzgpeVarZzj2 = null;
                                            if (str6 != null) {
                                                zzeg zzegVar4 = zzegVar3;
                                                zzt zztVar2 = new zzt();
                                                zztVar2.zzb(iZzB);
                                                zztVar2.zzm(str6);
                                                zztVar2.zze(strZzc);
                                                zztVar2.zzr(j4);
                                                zztVar2.zzp(zzgpeVarZzj2);
                                                zzaigVar2.zzb = zztVar2.zzM();
                                                zzegVar3 = zzegVar4;
                                            }
                                            str2 = str;
                                            i7 = iZzB;
                                            arrayList = arrayList3;
                                            i8 = i4;
                                            j3 = jZzz2;
                                        } else if (iZzB8 == 1664495672) {
                                            zzaigVar2.zzd = i20;
                                            str6 = "application/x-mp4-cea-608";
                                        } else {
                                            int iZzg8 = zzegVar3.zzg();
                                            zzegVar3.zzk(4);
                                            if (zzegVar3.zzB() == 1702061171) {
                                                zzaib zzaibVarZzp2 = zzp(zzegVar3, iZzg8);
                                                if (zzaibVarZzp2.zzb() != null && zzaibVarZzp2.zzb().length == 64) {
                                                    String strZzj = zzj(zzaibVarZzp2.zzb(), sZzv, sZzv2);
                                                    String str13 = zzep.zza;
                                                    zzgpeVarZzj = zzgpe.zzj(strZzj.getBytes(StandardCharsets.UTF_8));
                                                    str5 = "application/vobsub";
                                                }
                                                str2 = str;
                                                i7 = iZzB;
                                                arrayList = arrayList3;
                                                i8 = i4;
                                                j3 = jZzz2;
                                            } else {
                                                zzgpeVarZzj = null;
                                                str5 = null;
                                            }
                                            zzgpeVarZzj2 = zzgpeVarZzj;
                                            str6 = str5;
                                        }
                                        j4 = Long.MAX_VALUE;
                                        if (str6 != null) {
                                            zzeg zzegVar5 = zzegVar3;
                                            zzt zztVar3 = new zzt();
                                            zztVar3.zzb(iZzB);
                                            zztVar3.zzm(str6);
                                            zztVar3.zze(strZzc);
                                            zztVar3.zzr(j4);
                                            zztVar3.zzp(zzgpeVarZzj2);
                                            zzaigVar2.zzb = zztVar3.zzM();
                                            zzegVar3 = zzegVar5;
                                        }
                                        str2 = str;
                                        i7 = iZzB;
                                        arrayList = arrayList3;
                                        i8 = i4;
                                        j3 = jZzz2;
                                    }
                                    j4 = Long.MAX_VALUE;
                                    zzgpeVarZzj2 = null;
                                    if (str6 != null) {
                                        zzeg zzegVar6 = zzegVar3;
                                        zzt zztVar4 = new zzt();
                                        zztVar4.zzb(iZzB);
                                        zztVar4.zzm(str6);
                                        zztVar4.zze(strZzc);
                                        zztVar4.zzr(j4);
                                        zztVar4.zzp(zzgpeVarZzj2);
                                        zzaigVar2.zzb = zztVar4.zzM();
                                        zzegVar3 = zzegVar6;
                                    }
                                    str2 = str;
                                    i7 = iZzB;
                                    arrayList = arrayList3;
                                    i8 = i4;
                                    j3 = jZzz2;
                                } else if (iZzB8 == 1835365492) {
                                    zzegVar3.zzh(iZzg3 + 16);
                                    char c8 = c2;
                                    zzegVar3.zzM(c8);
                                    String strZzM = zzegVar3.zzM(c8);
                                    if (strZzM != null) {
                                        zzt zztVar5 = new zzt();
                                        zztVar5.zzb(iZzB);
                                        zztVar5.zzm(strZzM);
                                        zzaigVar2.zzb = zztVar5.zzM();
                                    }
                                } else if (iZzB8 == 1667329389) {
                                    zzt zztVar6 = new zzt();
                                    zztVar6.zzb(iZzB);
                                    zztVar6.zzm("application/x-camera-motion");
                                    zzaigVar2.zzb = zztVar6.zzM();
                                }
                                str2 = str;
                                i7 = iZzB;
                                arrayList = arrayList3;
                                i8 = i4;
                                j3 = jZzz2;
                            }
                            zzegVar3.zzh(iZzg3 + iZzB7);
                            char c9 = c6;
                            i29++;
                            str = str2;
                            c6 = c9;
                            i4 = i8;
                            iZzB = i7;
                            strZzc = strZzc;
                            zzaigVar2 = zzaigVar2;
                            sZzv2 = sZzv2;
                            i = i30;
                            arrayList3 = arrayList;
                            jZzz2 = j3;
                            iZzB6 = i31;
                            sZzv = sZzv;
                            i28 = i28;
                            j7 = j8;
                            i20 = 1;
                            c2 = 0;
                        }
                        String str14 = str;
                        zzaig zzaigVar4 = zzaigVar2;
                        int i93 = i;
                        int i94 = iZzB;
                        long j9 = j7;
                        arrayList3 = arrayList3;
                        long j10 = jZzz2;
                        int i95 = i28;
                        if (z) {
                            zzeuVar2 = zzeuVar3;
                        } else {
                            zzeuVar2 = zzeuVar3;
                            zzeu zzeuVarZzd4 = zzeuVar2.zzd(1701082227);
                            if (zzeuVarZzd4 != null && (pairZzn = zzn(zzeuVarZzd4)) != null) {
                                long[] jArr3 = (long[]) pairZzn.first;
                                jArr2 = (long[]) pairZzn.second;
                                jArr = jArr3;
                            }
                            zzvVarZzM = zzaigVar4.zzb;
                            if (zzvVarZzM == null) {
                                zzgluVar = zzgluVar;
                                zzajfVar = null;
                            } else {
                                if (i95 != 0) {
                                    zzetVar = new zzet(i95);
                                    zzt zztVarZza = zzvVarZzM.zza();
                                    zzapVar = zzvVarZzM.zzl;
                                    if (zzapVar != null) {
                                        zzapVar2 = zzapVar.zzg(zzetVar);
                                    } else {
                                        zzapVar2 = new zzap(-9223372036854775807L, zzetVar);
                                    }
                                    zztVarZza.zzk(zzapVar2);
                                    zzvVarZzM = zztVarZza.zzM();
                                }
                                zzajf zzajfVar3 = new zzajf(i94, i93, zzaid.zza(j10, j9, str14), j2, jZzt, zzaid.zzb(j10, j9, str14), zzvVarZzM, zzaigVar4.zzd, zzaigVar4.zza, zzaigVar4.zzc, jArr, jArr2);
                                zzgluVar = zzgluVar;
                                zzajfVar = zzajfVar3;
                            }
                        }
                        jArr = null;
                        jArr2 = null;
                        zzvVarZzM = zzaigVar4.zzb;
                        if (zzvVarZzM == null) {
                            zzgluVar = zzgluVar;
                            zzajfVar = null;
                        } else {
                            if (i95 != 0) {
                                zzetVar = new zzet(i95);
                                zzt zztVarZza2 = zzvVarZzM.zza();
                                zzapVar = zzvVarZzM.zzl;
                                if (zzapVar != null) {
                                    zzapVar2 = zzapVar.zzg(zzetVar);
                                } else {
                                    zzapVar2 = new zzap(-9223372036854775807L, zzetVar);
                                }
                                zztVarZza2.zzk(zzapVar2);
                                zzvVarZzM = zztVarZza2.zzM();
                            }
                            zzajf zzajfVar4 = new zzajf(i94, i93, zzaid.zza(j10, j9, str14), j2, jZzt, zzaid.zzb(j10, j9, str14), zzvVarZzM, zzaigVar4.zzd, zzaigVar4.zza, zzaigVar4.zzc, jArr, jArr2);
                            zzgluVar = zzgluVar;
                            zzajfVar = zzajfVar4;
                        }
                    }
                    zzajfVar2 = (zzajf) zzgluVar.apply(zzajfVar);
                    if (zzajfVar2 != null) {
                        zzeu zzeuVarZzd5 = zzeuVar2.zzd(1835297121);
                        zzeuVarZzd5.getClass();
                        zzeu zzeuVarZzd6 = zzeuVarZzd5.zzd(1835626086);
                        zzeuVarZzd6.getClass();
                        zzeu zzeuVarZzd7 = zzeuVarZzd6.zzd(1937007212);
                        zzeuVarZzd7.getClass();
                        zzaji zzajiVarZzg = zzg(zzajfVar2, zzeuVarZzd7, zzadsVar, false);
                        arrayList2 = arrayList3;
                        arrayList2.add(zzajiVarZzg);
                    } else {
                        arrayList2 = arrayList3;
                    }
                    i19 = i2 + 1;
                    arrayList3 = arrayList2;
                }
                zzajfVar = null;
                zzajfVar2 = (zzajf) zzgluVar.apply(zzajfVar);
                if (zzajfVar2 != null) {
                    zzeu zzeuVarZzd8 = zzeuVar2.zzd(1835297121);
                    zzeuVarZzd8.getClass();
                    zzeu zzeuVarZzd9 = zzeuVarZzd8.zzd(1835626086);
                    zzeuVarZzd9.getClass();
                    zzeu zzeuVarZzd10 = zzeuVarZzd9.zzd(1937007212);
                    zzeuVarZzd10.getClass();
                    zzaji zzajiVarZzg2 = zzg(zzajfVar2, zzeuVarZzd10, zzadsVar, false);
                    arrayList2 = arrayList3;
                    arrayList2.add(zzajiVarZzg2);
                } else {
                    arrayList2 = arrayList3;
                }
                i19 = i2 + 1;
                arrayList3 = arrayList2;
            }
            i19 = i2 + 1;
            arrayList3 = arrayList2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00da  */
    public static zzap zzc(zzev zzevVar) {
        int iZzF;
        zzeg zzegVar = zzevVar.zza;
        zzegVar.zzh(8);
        zzap zzapVar = new zzap(-9223372036854775807L, new zzao[0]);
        while (zzegVar.zzd() >= 8) {
            int iZzg = zzegVar.zzg();
            int iZzB = zzegVar.zzB() + iZzg;
            int iZzB2 = zzegVar.zzB();
            zzap zzapVar2 = null;
            if (iZzB2 == 1835365473) {
                zzegVar.zzh(iZzg);
                zzegVar.zzk(8);
                zzf(zzegVar);
                while (zzegVar.zzg() < iZzB) {
                    int iZzg2 = zzegVar.zzg();
                    int iZzB3 = zzegVar.zzB() + iZzg2;
                    if (zzegVar.zzB() == 1768715124) {
                        zzegVar.zzh(iZzg2);
                        zzegVar.zzk(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzegVar.zzg() < iZzB3) {
                            zzao zzaoVarZzc = zzait.zzc(zzegVar);
                            if (zzaoVarZzc != null) {
                                arrayList.add(zzaoVarZzc);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzapVar2 = new zzap(arrayList);
                            break;
                        }
                        break;
                    }
                    zzegVar.zzh(iZzB3);
                }
                zzapVar = zzapVar.zzf(zzapVar2);
            } else if (iZzB2 == 1936553057) {
                zzegVar.zzh(iZzg);
                zzegVar.zzk(12);
                while (zzegVar.zzg() < iZzB) {
                    int iZzg3 = zzegVar.zzg();
                    int iZzB4 = zzegVar.zzB();
                    if (zzegVar.zzB() == 1935766900) {
                        if (iZzB4 < 16) {
                            break;
                        }
                        zzegVar.zzk(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int iZzs = zzegVar.zzs();
                            int iZzs2 = zzegVar.zzs();
                            if (iZzs == 0) {
                                i = iZzs2;
                            } else if (iZzs == 1) {
                                i2 = iZzs2;
                            }
                        }
                        if (i == 12) {
                            iZzF = 240;
                        } else if (i == 13) {
                            iZzF = 120;
                        } else if (i == 21 && zzegVar.zzd() >= 8 && zzegVar.zzg() + 8 <= iZzB) {
                            int iZzB5 = zzegVar.zzB();
                            int iZzB6 = zzegVar.zzB();
                            if (iZzB5 < 12 || iZzB6 != 1936877170) {
                                iZzF = -2147483647;
                            } else {
                                iZzF = zzegVar.zzF();
                            }
                        } else {
                            iZzF = -2147483647;
                        }
                        if (iZzF == -2147483647) {
                            break;
                        }
                        zzapVar2 = new zzap(-9223372036854775807L, new zzaha(iZzF, i2));
                        break;
                    }
                    zzegVar.zzh(iZzg3 + iZzB4);
                }
                zzapVar = zzapVar.zzf(zzapVar2);
            } else if (iZzB2 == -1451722374) {
                zzapVar = zzapVar.zzf(zzh(zzegVar));
            }
            zzegVar.zzh(iZzB);
        }
        return zzapVar;
    }

    public static zzey zzd(zzeg zzegVar) {
        long jZzD;
        long jZzD2;
        zzegVar.zzh(8);
        if (zza(zzegVar.zzB()) == 0) {
            jZzD = zzegVar.zzz();
            jZzD2 = zzegVar.zzz();
        } else {
            jZzD = zzegVar.zzD();
            jZzD2 = zzegVar.zzD();
        }
        return new zzey(jZzD, jZzD2, zzegVar.zzz());
    }

    public static zzap zze(zzeu zzeuVar) {
        zzes zzesVar;
        zzev zzevVarZzc = zzeuVar.zzc(1751411826);
        zzev zzevVarZzc2 = zzeuVar.zzc(1801812339);
        zzev zzevVarZzc3 = zzeuVar.zzc(1768715124);
        if (zzevVarZzc != null && zzevVarZzc2 != null && zzevVarZzc3 != null && zzi(zzevVarZzc.zza) == 1835299937) {
            zzeg zzegVar = zzevVarZzc2.zza;
            zzegVar.zzh(12);
            int iZzB = zzegVar.zzB();
            String[] strArr = new String[iZzB];
            for (int i = 0; i < iZzB; i++) {
                int iZzB2 = zzegVar.zzB();
                zzegVar.zzk(4);
                strArr[i] = zzegVar.zzK(iZzB2 - 8, StandardCharsets.UTF_8);
            }
            zzeg zzegVar2 = zzevVarZzc3.zza;
            zzegVar2.zzh(8);
            ArrayList arrayList = new ArrayList();
            while (zzegVar2.zzd() > 8) {
                int iZzg = zzegVar2.zzg() + zzegVar2.zzB();
                int iZzB3 = zzegVar2.zzB() - 1;
                if (iZzB3 < 0 || iZzB3 >= iZzB) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzB3).length() + 41);
                    sb.append("Skipped metadata with unknown key index: ");
                    sb.append(iZzB3);
                    zzdt.zzc("BoxParsers", sb.toString());
                } else {
                    String str = strArr[iZzB3];
                    while (true) {
                        int iZzg2 = zzegVar2.zzg();
                        if (iZzg2 >= iZzg) {
                            zzesVar = null;
                            break;
                        }
                        int iZzB4 = zzegVar2.zzB();
                        if (zzegVar2.zzB() == 1684108385) {
                            int iZzB5 = zzegVar2.zzB();
                            int iZzB6 = zzegVar2.zzB();
                            int i2 = iZzB4 - 16;
                            byte[] bArr = new byte[i2];
                            zzegVar2.zzm(bArr, 0, i2);
                            zzesVar = new zzes(str, bArr, iZzB6, iZzB5);
                            break;
                        }
                        zzegVar2.zzh(iZzg2 + iZzB4);
                    }
                    if (zzesVar != null) {
                        arrayList.add(zzesVar);
                    }
                }
                zzegVar2.zzh(iZzg);
            }
            if (!arrayList.isEmpty()) {
                return new zzap(arrayList);
            }
        }
        return null;
    }

    public static void zzf(zzeg zzegVar) {
        int iZzg = zzegVar.zzg();
        zzegVar.zzk(4);
        if (zzegVar.zzB() != 1751411826) {
            iZzg += 4;
        }
        zzegVar.zzh(iZzg);
    }

    /* JADX WARN: Code duplicated, block: B:106:0x029c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x029e  */
    /* JADX WARN: Code duplicated, block: B:108:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:140:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:142:0x0406  */
    /* JADX WARN: Code duplicated, block: B:147:0x042f  */
    /* JADX WARN: Code duplicated, block: B:149:0x0440  */
    /* JADX WARN: Code duplicated, block: B:151:0x044d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0451  */
    /* JADX WARN: Code duplicated, block: B:175:0x04fc A[PHI: r28
      0x04fc: PHI (r28v8 long) = (r28v0 long), (r28v0 long), (r28v10 long), (r28v10 long), (r28v10 long), (r28v10 long) binds: [B:152:0x044f, B:154:0x0453, B:156:0x048e, B:158:0x0494, B:160:0x049a, B:162:0x04a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:177:0x0500  */
    /* JADX WARN: Code duplicated, block: B:180:0x0506  */
    /* JADX WARN: Code duplicated, block: B:190:0x054f  */
    /* JADX WARN: Code duplicated, block: B:191:0x0551  */
    /* JADX WARN: Code duplicated, block: B:195:0x056a  */
    /* JADX WARN: Code duplicated, block: B:197:0x0574  */
    /* JADX WARN: Code duplicated, block: B:200:0x059f  */
    /* JADX WARN: Code duplicated, block: B:204:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:207:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:210:0x05c2  */
    /* JADX WARN: Code duplicated, block: B:213:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:217:0x05d2  */
    /* JADX WARN: Code duplicated, block: B:219:0x05da A[LOOP:8: B:215:0x05cb->B:219:0x05da, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:222:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:223:0x05e8  */
    /* JADX WARN: Code duplicated, block: B:225:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:229:0x0607  */
    /* JADX WARN: Code duplicated, block: B:230:0x0609  */
    /* JADX WARN: Code duplicated, block: B:233:0x060e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0611  */
    /* JADX WARN: Code duplicated, block: B:236:0x0614  */
    /* JADX WARN: Code duplicated, block: B:237:0x0617  */
    /* JADX WARN: Code duplicated, block: B:240:0x061b  */
    /* JADX WARN: Code duplicated, block: B:242:0x061e  */
    /* JADX WARN: Code duplicated, block: B:243:0x0621  */
    /* JADX WARN: Code duplicated, block: B:247:0x062d  */
    /* JADX WARN: Code duplicated, block: B:249:0x0637  */
    /* JADX WARN: Code duplicated, block: B:250:0x0649  */
    /* JADX WARN: Code duplicated, block: B:252:0x0650  */
    /* JADX WARN: Code duplicated, block: B:254:0x0672  */
    /* JADX WARN: Code duplicated, block: B:255:0x0675  */
    /* JADX WARN: Code duplicated, block: B:258:0x0683  */
    /* JADX WARN: Code duplicated, block: B:266:0x06b4  */
    /* JADX WARN: Code duplicated, block: B:267:0x06c9  */
    /* JADX WARN: Code duplicated, block: B:276:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:288:0x05ab A[ADDED_TO_REGION, EDGE_INSN: B:288:0x05ab->B:203:0x05ab BREAK  A[LOOP:6: B:198:0x059b->B:202:0x05a5], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:291:0x05c4 A[ADDED_TO_REGION, EDGE_INSN: B:291:0x05c4->B:211:0x05c4 BREAK  A[LOOP:7: B:205:0x05af->B:209:0x05bd], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x05dd A[EDGE_INSN: B:292:0x05dd->B:220:0x05dd BREAK  A[LOOP:8: B:215:0x05cb->B:219:0x05da], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:293:0x05dd A[EDGE_INSN: B:293:0x05dd->B:220:0x05dd BREAK  A[LOOP:8: B:215:0x05cb->B:219:0x05da], SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r23v10 */
    /* JADX WARN: Type inference failed for: r23v11 */
    /* JADX WARN: Type inference failed for: r23v21 */
    /* JADX WARN: Type inference failed for: r23v22 */
    /* JADX WARN: Type inference failed for: r23v23 */
    /* JADX WARN: Type inference failed for: r23v9 */
    public static zzaji zzg(zzajf zzajfVar, zzeu zzeuVar, zzads zzadsVar, boolean z) throws zzat {
        zzaie zzaiiVar;
        boolean z2;
        int iZzH;
        int iZzH2;
        int i;
        int iZzH3;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long j;
        long j2;
        long[] jArr2;
        long j3;
        long j4;
        long jZzt;
        long[] jArr3;
        long[] jArr4;
        zzajf zzajfVar2;
        long j5;
        int[] iArr3;
        long[] jArr5;
        int[] iArr4;
        int i5;
        int length;
        int i6;
        long j6;
        long j7;
        int i7;
        int i8;
        boolean z3;
        long[] jArr6;
        int[] iArr5;
        int[] iArr6;
        long[] jArr7;
        int i9;
        int i10;
        int i11;
        boolean z4;
        int[] iArr7;
        int[] iArr8;
        boolean z5;
        boolean z6;
        long[] jArr8;
        int[] iArr9;
        int[] iArr10;
        long[] jArr9;
        int i12;
        boolean z7;
        int i13;
        long j8;
        zzajf zzajfVarZzb;
        long j9;
        int i14;
        boolean z8;
        int i15;
        int[] iArr11;
        long jZzt2;
        boolean z9;
        int[] iArr12;
        long j10;
        int[] iArr13;
        int i16;
        long j11;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z10;
        int i21;
        int i22;
        int length2;
        long jZzt3;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        ?? r23;
        int i31;
        zzajf zzajfVarZzb2 = zzajfVar;
        zzev zzevVarZzc = zzeuVar.zzc(1937011578);
        if (zzevVarZzc != null) {
            zzaiiVar = new zzaih(zzevVarZzc, zzajfVarZzb2.zzg);
        } else {
            zzev zzevVarZzc2 = zzeuVar.zzc(1937013298);
            if (zzevVarZzc2 == null) {
                throw zzat.zzb("Track has no sample table size information", null);
            }
            zzaiiVar = new zzaii(zzevVarZzc2);
        }
        int iZza = zzaiiVar.zza();
        if (iZza == 0) {
            return new zzaji(zzajfVarZzb2, new long[0], new int[0], 0, new long[0], new int[0], 0L, 0);
        }
        if (zzajfVarZzb2.zzb == 2) {
            long j12 = zzajfVarZzb2.zzf;
            if (j12 > 0) {
                zzt zztVarZza = zzajfVarZzb2.zzg.zza();
                zztVarZza.zzx(iZza / (j12 / 1000000.0f));
                zzajfVarZzb2 = zzajfVarZzb2.zzb(zztVarZza.zzM());
            }
        }
        zzev zzevVarZzc3 = zzeuVar.zzc(1937007471);
        if (zzevVarZzc3 == null) {
            zzevVarZzc3 = zzeuVar.zzc(1668232756);
            zzevVarZzc3.getClass();
            z2 = true;
        } else {
            z2 = false;
        }
        zzev zzevVarZzc4 = zzeuVar.zzc(1937011555);
        zzevVarZzc4.getClass();
        zzeg zzegVar = zzevVarZzc4.zza;
        zzev zzevVarZzc5 = zzeuVar.zzc(1937011827);
        zzevVarZzc5.getClass();
        zzeg zzegVar2 = zzevVarZzc5.zza;
        zzev zzevVarZzc6 = zzeuVar.zzc(1937011571);
        zzeg zzegVar3 = zzevVarZzc6 != null ? zzevVarZzc6.zza : null;
        zzev zzevVarZzc7 = zzeuVar.zzc(1668576371);
        zzeg zzegVar4 = zzevVarZzc7 != null ? zzevVarZzc7.zza : null;
        zzaia zzaiaVar = new zzaia(zzegVar, zzevVarZzc3.zza, z2);
        zzegVar2.zzh(12);
        int iZzH4 = zzegVar2.zzH() - 1;
        int iZzH5 = zzegVar2.zzH();
        int iZzH6 = zzegVar2.zzH();
        if (zzegVar4 != null) {
            zzegVar4.zzh(12);
            iZzH = zzegVar4.zzH();
        } else {
            iZzH = 0;
        }
        if (zzegVar3 != null) {
            zzegVar3.zzh(12);
            iZzH2 = zzegVar3.zzH();
            if (iZzH2 > 0) {
                iZzH3 = zzegVar3.zzH() - 1;
                i = 0;
            } else {
                i = 0;
                iZzH3 = -1;
                zzegVar3 = null;
            }
        } else {
            iZzH2 = 0;
            i = 0;
            iZzH3 = -1;
        }
        int iZzb = zzaiiVar.zzb();
        zzv zzvVar = zzajfVarZzb2.zzg;
        if (iZzb != -1) {
            String str = zzvVar.zzo;
            i2 = 1;
            if (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iZzH4 == 0) {
                if (iZzH == 0 && iZzH2 == 0) {
                    int i32 = zzaiaVar.zza;
                    long[] jArr10 = new long[i32];
                    int[] iArr14 = new int[i32];
                    while (zzaiaVar.zza()) {
                        int i33 = zzaiaVar.zzb;
                        jArr10[i33] = zzaiaVar.zzd;
                        iArr14[i33] = zzaiaVar.zzc;
                    }
                    long j13 = iZzH6;
                    int i34 = 8192 / iZzb;
                    int i35 = i;
                    int i36 = i35;
                    while (i35 < i32) {
                        int i37 = iArr14[i35];
                        String str2 = zzep.zza;
                        i36 += ((i37 + i34) - 1) / i34;
                        i35++;
                    }
                    long[] jArr11 = new long[i36];
                    iArr2 = new int[i36];
                    jArr = new long[i36];
                    iArr = new int[i36];
                    int i38 = i;
                    int i39 = i38;
                    int i40 = i39;
                    i3 = i40;
                    int i41 = i3;
                    while (i40 < i32) {
                        int i42 = iArr14[i40];
                        long j14 = jArr10[i40];
                        int i43 = i41;
                        int i44 = i32;
                        int iMax = i3;
                        int i45 = i43;
                        int i46 = i39;
                        int i47 = i42;
                        while (i47 > 0) {
                            int iMin = Math.min(i34, i47);
                            jArr11[i45] = j14;
                            int i48 = i47;
                            int i49 = iZzb * iMin;
                            iArr2[i45] = i49;
                            int i50 = i46 + i49;
                            iMax = Math.max(iMax, i49);
                            jArr[i45] = ((long) i38) * j13;
                            iArr[i45] = 1;
                            j14 += (long) iArr2[i45];
                            i38 += iMin;
                            i47 = i48 - iMin;
                            i45++;
                            i46 = i50;
                            iZzb = iZzb;
                        }
                        i40++;
                        int i51 = i45;
                        i3 = iMax;
                        i32 = i44;
                        i41 = i51;
                        i39 = i46;
                    }
                    long j15 = j13 * ((long) i38);
                    j2 = i39;
                    j = j15;
                    jArr2 = jArr11;
                    i4 = i36;
                } else {
                    iZzH4 = i;
                }
            }
            j3 = zzajfVarZzb2.zzf;
            if (j3 > 0) {
                jZzt3 = zzep.zzt(j2 * 8, 1000000L, j3, RoundingMode.HALF_DOWN);
                if (jZzt3 > 0 && jZzt3 < 2147483647L) {
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzh((int) jZzt3);
                    zzajfVarZzb2 = zzajfVarZzb2.zzb(zztVarZza2.zzM());
                }
            }
            j4 = zzajfVarZzb2.zzc;
            jZzt = zzep.zzt(j, 1000000L, j4, RoundingMode.DOWN);
            jArr3 = zzajfVarZzb2.zzi;
            jArr4 = jArr2;
            zzajfVar2 = zzajfVarZzb2;
            if (jArr3 == null) {
                zzep.zzu(jArr, 1000000L, j4);
                return new zzaji(zzajfVar2, jArr4, iArr2, i3, jArr, iArr, jZzt, i4);
            }
            j5 = j4;
            iArr3 = iArr2;
            jArr5 = jArr;
            iArr4 = iArr;
            i5 = i3;
            length = jArr3.length;
            if (length == 1) {
                if (zzajfVar2.zzb == 1 || (length2 = jArr5.length) < 2) {
                    j6 = j5;
                } else {
                    long[] jArr12 = zzajfVar2.zzj;
                    jArr12.getClass();
                    long j16 = jArr12[i];
                    long j17 = jArr3[i];
                    long j18 = zzajfVar2.zzd;
                    long jZzt4 = zzep.zzt(j17, j5, j18, RoundingMode.DOWN);
                    j5 = j5;
                    long j19 = jZzt4 + j16;
                    int i52 = length2 - 1;
                    int i53 = i;
                    int iMax2 = Math.max(i53, Math.min(4, i52));
                    int iMax3 = Math.max(i53, Math.min(length2 - 4, i52));
                    if (jArr5[i53] > j16 || j16 >= jArr5[iMax2] || jArr5[iMax3] >= j19 || j19 > 2 + j) {
                        j6 = j5;
                    } else {
                        long jMax = Math.max(0L, j - j19);
                        long j20 = j16 - jArr5[0];
                        long j21 = zzajfVar2.zzg.zzH;
                        long jZzt5 = zzep.zzt(j20, j21, j5, RoundingMode.DOWN);
                        long jZzt6 = zzep.zzt(jMax, j21, j5, RoundingMode.DOWN);
                        j6 = j5;
                        if (jZzt5 != 0) {
                            if (jZzt5 <= 2147483647L && jZzt6 <= 2147483647L) {
                                zzadsVar.zza = (int) jZzt5;
                                zzadsVar.zzb = (int) jZzt6;
                                zzep.zzu(jArr5, 1000000L, j6);
                                return new zzaji(zzajfVar2, jArr4, iArr3, i5, jArr5, iArr4, zzep.zzt(jArr3[0], 1000000L, j18, RoundingMode.DOWN), i4);
                            }
                        } else if (jZzt6 != 0) {
                            jZzt5 = 0;
                            if (jZzt5 <= 2147483647L) {
                                zzadsVar.zza = (int) jZzt5;
                                zzadsVar.zzb = (int) jZzt6;
                                zzep.zzu(jArr5, 1000000L, j6);
                                return new zzaji(zzajfVar2, jArr4, iArr3, i5, jArr5, iArr4, zzep.zzt(jArr3[0], 1000000L, j18, RoundingMode.DOWN), i4);
                            }
                        }
                    }
                }
                i6 = 1;
            } else {
                i6 = length;
                j6 = j5;
            }
            if (i6 != 1 && jArr3[0] == 0) {
                long[] jArr13 = zzajfVar2.zzj;
                jArr13.getClass();
                long j22 = jArr13[0];
                int i54 = 0;
                while (i54 < jArr5.length) {
                    long j23 = j6;
                    jArr5[i54] = zzep.zzt(jArr5[i54] - j22, 1000000L, j23, RoundingMode.DOWN);
                    i54++;
                    j6 = j23;
                }
                return new zzaji(zzajfVar2, jArr4, iArr3, i5, jArr5, iArr4, zzep.zzt(j - j22, 1000000L, j6, RoundingMode.DOWN), i4);
            }
            j7 = j6;
            i7 = i4;
            i8 = zzajfVar2.zzb;
            if (i8 == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            jArr6 = zzajfVar2.zzj;
            iArr5 = new int[i6];
            iArr6 = new int[i6];
            jArr6.getClass();
            jArr7 = jArr6;
            i9 = 0;
            i10 = 0;
            i11 = 0;
            z4 = false;
            while (i10 < jArr3.length) {
                iArr12 = iArr5;
                j10 = jArr7[i10];
                if (j10 != -1) {
                    iArr13 = iArr4;
                    i16 = i10;
                    long j24 = j7;
                    long jZzt7 = zzep.zzt(jArr3[i10], j24, zzajfVar2.zzd, RoundingMode.DOWN);
                    j7 = j24;
                    iArr12[i16] = zzep.zzm(jArr5, j10, true, true);
                    j11 = j10 + jZzt7;
                    iArr6[i16] = zzep.zzo(jArr5, j11, z3, false);
                    i17 = iArr12[i16];
                    while (true) {
                        i18 = iArr12[i16];
                        if (i18 >= 0 || (iArr13[i18] & 1) != 0) {
                            break;
                        }
                        iArr12[i16] = i18 - 1;
                    }
                    if (i18 < 0) {
                        iArr12[i16] = i17;
                        while (true) {
                            i19 = iArr12[i16];
                            if (i19 < iArr6[i16] || (iArr13[i19] & 1) != 0) {
                                break;
                            }
                            iArr12[i16] = i19 + 1;
                        }
                    } else {
                        i19 = i18;
                    }
                    if (i8 == 2 && i19 != iArr6[i16]) {
                        while (true) {
                            i21 = iArr6[i16];
                            if (i21 >= jArr5.length - 1) {
                                break;
                            }
                            i22 = i21 + 1;
                            if (jArr5[i22] > j11) {
                                break;
                            }
                            iArr6[i16] = i22;
                        }
                    }
                    int i55 = iArr6[i16];
                    i20 = iArr12[i16];
                    i11 += i55 - i20;
                    if (i9 != i20) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z4 |= z10;
                    i9 = i55;
                } else {
                    iArr13 = iArr4;
                    i16 = i10;
                }
                iArr4 = iArr13;
                jArr7 = jArr7;
                i10 = i16 + 1;
                iArr5 = iArr12;
            }
            iArr7 = iArr5;
            iArr8 = iArr4;
            if (i11 != i7) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z4 | z5;
            if (z6) {
                jArr8 = new long[i11];
            } else {
                jArr8 = jArr4;
            }
            if (z6) {
                iArr9 = new int[i11];
            } else {
                iArr9 = iArr3;
            }
            if (true == z6) {
                i5 = 0;
            }
            if (z6) {
                iArr10 = new int[i11];
            } else {
                iArr10 = iArr8;
            }
            jArr9 = new long[i11];
            i12 = 0;
            z7 = false;
            i13 = 0;
            j8 = 0;
            while (i12 < jArr3.length) {
                j9 = jArr6[i12];
                i14 = iArr7[i12];
                z8 = z6;
                i15 = iArr6[i12];
                if (z8) {
                    int i56 = i15 - i14;
                    System.arraycopy(jArr4, i14, jArr8, i13, i56);
                    System.arraycopy(iArr3, i14, iArr9, i13, i56);
                    iArr11 = iArr8;
                    System.arraycopy(iArr11, i14, iArr10, i13, i56);
                } else {
                    iArr11 = iArr8;
                }
                while (i14 < i15) {
                    int[] iArr15 = iArr11;
                    long jZzt8 = zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN);
                    jZzt2 = zzep.zzt(jArr5[i14] - j9, 1000000L, j7, RoundingMode.DOWN);
                    if (jZzt2 < 0) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    z7 = (!z9) | z7;
                    jArr9[i13] = jZzt8 + jZzt2;
                    if (z8 && iArr9[i13] > i5) {
                        i5 = iArr3[i14];
                    }
                    i13++;
                    i14++;
                    iArr11 = iArr15;
                }
                iArr8 = iArr11;
                j8 += jArr3[i12];
                i12++;
                z6 = z8;
                jArr9 = jArr9;
                iArr9 = iArr9;
            }
            int[] iArr16 = iArr9;
            long[] jArr14 = jArr9;
            long jZzt9 = zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN);
            if (z7) {
                zzt zztVarZza3 = zzajfVar2.zzg.zza();
                zztVarZza3.zzs(true);
                zzajfVarZzb = zzajfVar2.zzb(zztVarZza3.zzM());
            } else {
                zzajfVarZzb = zzajfVar2;
            }
            return new zzaji(zzajfVarZzb, jArr8, iArr16, i5, jArr14, iArr10, jZzt9, jArr8.length);
        }
        i2 = 1;
        long[] jArr15 = new long[iZza];
        int[] iArr17 = new int[iZza];
        jArr = new long[iZza];
        zzeg zzegVar5 = zzegVar4;
        int[] iArrCopyOf = new int[iZza];
        int i57 = iZzH2;
        zzaie zzaieVar = zzaiiVar;
        int i58 = iZzH;
        int i59 = iZzH4;
        long j25 = 0;
        long j26 = 0;
        long j27 = 0;
        int iZzH7 = iZzH3;
        int i60 = i;
        int iZzB = i60;
        int i61 = iZzB;
        int i62 = i61;
        int iZzH8 = i62;
        while (true) {
            if (i60 >= iZza) {
                iArr2 = iArr17;
                break;
            }
            long j28 = j25;
            ?? r24 = i2;
            while (true) {
                if (i62 == 0) {
                    boolean zZza = zzaiaVar.zza();
                    if (!zZza) {
                        i30 = i;
                        r23 = zZza;
                        break;
                    }
                    zzeg zzegVar6 = zzegVar2;
                    long j29 = zzaiaVar.zzd;
                    i62 = zzaiaVar.zzc;
                    j28 = j29;
                    zzegVar2 = zzegVar6;
                    zzegVar3 = zzegVar3;
                    iZza = iZza;
                    r24 = zZza;
                } else {
                    i30 = i62;
                    r23 = r24;
                    break;
                }
            }
            zzeg zzegVar7 = zzegVar2;
            zzeg zzegVar8 = zzegVar3;
            if (r23 == 0) {
                zzdt.zzc("BoxParsers", "Unexpected end of chunk data");
                long[] jArrCopyOf = Arrays.copyOf(jArr15, i60);
                int[] iArrCopyOf2 = Arrays.copyOf(iArr17, i60);
                long[] jArrCopyOf2 = Arrays.copyOf(jArr, i60);
                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i60);
                iArr2 = iArrCopyOf2;
                jArr = jArrCopyOf2;
                jArr15 = jArrCopyOf;
                iZza = i60;
                break;
            }
            if (zzegVar5 != null) {
                int i63 = i58;
                while (iZzH8 == 0) {
                    if (i63 <= 0) {
                        iZzH8 = i;
                        break;
                    }
                    i63--;
                    iZzH8 = zzegVar5.zzH();
                    iZzB = zzegVar5.zzB();
                }
                iZzH8--;
                i58 = i63;
            }
            int iZzc = zzaieVar.zzc();
            long j30 = iZzc;
            j27 += j30;
            if (iZzc > i61) {
                i61 = iZzc;
            }
            jArr15[i60] = j28;
            iArr17[i60] = iZzc;
            zzaia zzaiaVar2 = zzaiaVar;
            int i64 = i61;
            jArr[i60] = j26 + ((long) iZzB);
            iArrCopyOf[i60] = zzegVar8 == null ? i2 : i;
            if (i60 == iZzH7) {
                iArrCopyOf[i60] = i2;
            }
            if (zzegVar8 == null || i60 != iZzH7) {
                i31 = i57;
            } else {
                i31 = i57 - 1;
                if (i31 > 0) {
                    iZzH7 = zzegVar8.zzH() - 1;
                }
                j26 += (long) iZzH6;
                iZzH5--;
                if (iZzH5 != 0) {
                    if (i59 > 0) {
                        i59--;
                        iZzH5 = zzegVar7.zzH();
                        iZzH6 = zzegVar7.zzB();
                    } else {
                        iZzH5 = i;
                    }
                }
                long j31 = j28 + j30;
                i62 = i30 - 1;
                i57 = i31;
                zzaiaVar = zzaiaVar2;
                zzegVar2 = zzegVar7;
                zzegVar3 = zzegVar8;
                j25 = j31;
                i60++;
                i61 = i64;
                iZza = iZza;
            }
            j26 += (long) iZzH6;
            iZzH5--;
            if (iZzH5 != 0) {
                if (i59 > 0) {
                    i59--;
                    iZzH5 = zzegVar7.zzH();
                    iZzH6 = zzegVar7.zzB();
                } else {
                    iZzH5 = i;
                }
            }
            long j32 = j28 + j30;
            i62 = i30 - 1;
            i57 = i31;
            zzaiaVar = zzaiaVar2;
            zzegVar2 = zzegVar7;
            zzegVar3 = zzegVar8;
            j25 = j32;
            i60++;
            i61 = i64;
            iZza = iZza;
        }
        iArr = iArrCopyOf;
        long j33 = j26 + ((long) iZzB);
        if (zzegVar5 == null) {
            i23 = i2;
            break;
        }
        while (true) {
            if (i58 <= 0) {
                i23 = i2;
                break;
            }
            if (zzegVar5.zzH() != 0) {
                i23 = i;
                break;
            }
            zzegVar5.zzB();
            i58--;
        }
        if (i57 != 0) {
            i24 = iZzH5;
            i25 = i62;
            i26 = i59;
            i27 = iZzH8;
            i28 = i23;
            i29 = i57;
        } else if (iZzH5 != 0) {
            i24 = iZzH5;
            i25 = i62;
            i26 = i59;
            i27 = iZzH8;
            i28 = i23;
            i29 = i;
        } else if (i62 != 0) {
            i25 = i62;
            i24 = i;
            i26 = i59;
            i27 = iZzH8;
            i28 = i23;
            i29 = i24;
        } else if (i59 != 0) {
            i24 = i;
            i25 = i24;
            i26 = i59;
            i27 = iZzH8;
            i28 = i23;
            i29 = i25;
        } else {
            if (iZzH8 == 0) {
                if (i23 == 0) {
                    i29 = i;
                    i28 = i29;
                    i24 = i28;
                    i25 = i24;
                    i26 = i25;
                    i27 = i26;
                } else {
                    iZza = iZza;
                    jArr15 = jArr15;
                }
                i4 = iZza;
                jArr2 = jArr15;
                j = j33;
                j2 = j27;
                i3 = i61;
                j3 = zzajfVarZzb2.zzf;
                if (j3 > 0) {
                    jZzt3 = zzep.zzt(j2 * 8, 1000000L, j3, RoundingMode.HALF_DOWN);
                    if (jZzt3 > 0) {
                        zzt zztVarZza4 = zzvVar.zza();
                        zztVarZza4.zzh((int) jZzt3);
                        zzajfVarZzb2 = zzajfVarZzb2.zzb(zztVarZza4.zzM());
                    }
                }
                j4 = zzajfVarZzb2.zzc;
                jZzt = zzep.zzt(j, 1000000L, j4, RoundingMode.DOWN);
                jArr3 = zzajfVarZzb2.zzi;
                jArr4 = jArr2;
                zzajfVar2 = zzajfVarZzb2;
                if (jArr3 == null) {
                    zzep.zzu(jArr, 1000000L, j4);
                    return new zzaji(zzajfVar2, jArr4, iArr2, i3, jArr, iArr, jZzt, i4);
                }
                j5 = j4;
                iArr3 = iArr2;
                jArr5 = jArr;
                iArr4 = iArr;
                i5 = i3;
                length = jArr3.length;
                if (length == 1) {
                    if (zzajfVar2.zzb == 1) {
                        j6 = j5;
                    } else {
                        j6 = j5;
                    }
                    i6 = 1;
                } else {
                    i6 = length;
                    j6 = j5;
                }
                if (i6 != 1) {
                }
                j7 = j6;
                i7 = i4;
                i8 = zzajfVar2.zzb;
                if (i8 == 1) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                jArr6 = zzajfVar2.zzj;
                iArr5 = new int[i6];
                iArr6 = new int[i6];
                jArr6.getClass();
                jArr7 = jArr6;
                i9 = 0;
                i10 = 0;
                i11 = 0;
                z4 = false;
                while (i10 < jArr3.length) {
                    iArr12 = iArr5;
                    j10 = jArr7[i10];
                    if (j10 != -1) {
                        iArr13 = iArr4;
                        i16 = i10;
                        long j210 = j7;
                        long jZzt10 = zzep.zzt(jArr3[i10], j210, zzajfVar2.zzd, RoundingMode.DOWN);
                        j7 = j210;
                        iArr12[i16] = zzep.zzm(jArr5, j10, true, true);
                        j11 = j10 + jZzt10;
                        iArr6[i16] = zzep.zzo(jArr5, j11, z3, false);
                        i17 = iArr12[i16];
                        while (true) {
                            i18 = iArr12[i16];
                            if (i18 >= 0) {
                                break;
                            }
                            break;
                            break;
                            iArr12[i16] = i18 - 1;
                        }
                        if (i18 < 0) {
                            iArr12[i16] = i17;
                            while (true) {
                                i19 = iArr12[i16];
                                if (i19 < iArr6[i16]) {
                                    break;
                                }
                                break;
                                break;
                                iArr12[i16] = i19 + 1;
                            }
                        } else {
                            i19 = i18;
                        }
                        if (i8 == 2) {
                            while (true) {
                                i21 = iArr6[i16];
                                if (i21 >= jArr5.length - 1) {
                                    break;
                                    break;
                                }
                                i22 = i21 + 1;
                                if (jArr5[i22] > j11) {
                                    break;
                                    break;
                                }
                                iArr6[i16] = i22;
                            }
                        }
                        int i510 = iArr6[i16];
                        i20 = iArr12[i16];
                        i11 += i510 - i20;
                        if (i9 != i20) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z4 |= z10;
                        i9 = i510;
                    } else {
                        iArr13 = iArr4;
                        i16 = i10;
                    }
                    iArr4 = iArr13;
                    jArr7 = jArr7;
                    i10 = i16 + 1;
                    iArr5 = iArr12;
                }
                iArr7 = iArr5;
                iArr8 = iArr4;
                if (i11 != i7) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                z6 = z4 | z5;
                if (z6) {
                    jArr8 = new long[i11];
                } else {
                    jArr8 = jArr4;
                }
                if (z6) {
                    iArr9 = new int[i11];
                } else {
                    iArr9 = iArr3;
                }
                if (true == z6) {
                    i5 = 0;
                }
                if (z6) {
                    iArr10 = new int[i11];
                } else {
                    iArr10 = iArr8;
                }
                jArr9 = new long[i11];
                i12 = 0;
                z7 = false;
                i13 = 0;
                j8 = 0;
                while (i12 < jArr3.length) {
                    j9 = jArr6[i12];
                    i14 = iArr7[i12];
                    z8 = z6;
                    i15 = iArr6[i12];
                    if (z8) {
                        int i511 = i15 - i14;
                        System.arraycopy(jArr4, i14, jArr8, i13, i511);
                        System.arraycopy(iArr3, i14, iArr9, i13, i511);
                        iArr11 = iArr8;
                        System.arraycopy(iArr11, i14, iArr10, i13, i511);
                    } else {
                        iArr11 = iArr8;
                    }
                    while (i14 < i15) {
                        int[] iArr18 = iArr11;
                        long jZzt11 = zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN);
                        jZzt2 = zzep.zzt(jArr5[i14] - j9, 1000000L, j7, RoundingMode.DOWN);
                        if (jZzt2 < 0) {
                            z9 = false;
                        } else {
                            z9 = true;
                        }
                        z7 = (!z9) | z7;
                        jArr9[i13] = jZzt11 + jZzt2;
                        if (z8) {
                            i5 = iArr3[i14];
                        }
                        i13++;
                        i14++;
                        iArr11 = iArr18;
                    }
                    iArr8 = iArr11;
                    j8 += jArr3[i12];
                    i12++;
                    z6 = z8;
                    jArr9 = jArr9;
                    iArr9 = iArr9;
                }
                int[] iArr19 = iArr9;
                long[] jArr16 = jArr9;
                long jZzt12 = zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN);
                if (z7) {
                    zzt zztVarZza5 = zzajfVar2.zzg.zza();
                    zztVarZza5.zzs(true);
                    zzajfVarZzb = zzajfVar2.zzb(zztVarZza5.zzM());
                } else {
                    zzajfVarZzb = zzajfVar2;
                }
                return new zzaji(zzajfVarZzb, jArr8, iArr19, i5, jArr16, iArr10, jZzt12, jArr8.length);
            }
            i24 = i;
            i25 = i24;
            i26 = i25;
            i27 = iZzH8;
            i28 = i23;
            i29 = i26;
        }
        int i65 = zzajfVarZzb2.zza;
        int length3 = String.valueOf(i65).length() + 66 + String.valueOf(i29).length() + 35 + String.valueOf(i24).length() + 26 + String.valueOf(i25).length() + 33 + String.valueOf(i26).length() + 36;
        int length4 = String.valueOf(i27).length();
        String str3 = i2 != i28 ? ", ctts invalid" : "";
        StringBuilder sb = new StringBuilder(length3 + length4 + str3.length());
        sb.append("Inconsistent stbl box for track ");
        sb.append(i65);
        sb.append(": remainingSynchronizationSamples ");
        sb.append(i29);
        sb.append(", remainingSamplesAtTimestampDelta ");
        sb.append(i24);
        sb.append(", remainingSamplesInChunk ");
        sb.append(i25);
        sb.append(", remainingTimestampDeltaChanges ");
        sb.append(i26);
        sb.append(", remainingSamplesAtTimestampOffset ");
        sb.append(i27);
        sb.append(str3);
        zzdt.zzc("BoxParsers", sb.toString());
        i4 = iZza;
        jArr2 = jArr15;
        j = j33;
        j2 = j27;
        i3 = i61;
        j3 = zzajfVarZzb2.zzf;
        if (j3 > 0) {
            jZzt3 = zzep.zzt(j2 * 8, 1000000L, j3, RoundingMode.HALF_DOWN);
            if (jZzt3 > 0) {
                zzt zztVarZza6 = zzvVar.zza();
                zztVarZza6.zzh((int) jZzt3);
                zzajfVarZzb2 = zzajfVarZzb2.zzb(zztVarZza6.zzM());
            }
        }
        j4 = zzajfVarZzb2.zzc;
        jZzt = zzep.zzt(j, 1000000L, j4, RoundingMode.DOWN);
        jArr3 = zzajfVarZzb2.zzi;
        jArr4 = jArr2;
        zzajfVar2 = zzajfVarZzb2;
        if (jArr3 == null) {
            zzep.zzu(jArr, 1000000L, j4);
            return new zzaji(zzajfVar2, jArr4, iArr2, i3, jArr, iArr, jZzt, i4);
        }
        j5 = j4;
        iArr3 = iArr2;
        jArr5 = jArr;
        iArr4 = iArr;
        i5 = i3;
        length = jArr3.length;
        if (length == 1) {
            if (zzajfVar2.zzb == 1) {
                j6 = j5;
            } else {
                j6 = j5;
            }
            i6 = 1;
        } else {
            i6 = length;
            j6 = j5;
        }
        if (i6 != 1) {
        }
        j7 = j6;
        i7 = i4;
        i8 = zzajfVar2.zzb;
        if (i8 == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        jArr6 = zzajfVar2.zzj;
        iArr5 = new int[i6];
        iArr6 = new int[i6];
        jArr6.getClass();
        jArr7 = jArr6;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        z4 = false;
        while (i10 < jArr3.length) {
            iArr12 = iArr5;
            j10 = jArr7[i10];
            if (j10 != -1) {
                iArr13 = iArr4;
                i16 = i10;
                long j211 = j7;
                long jZzt13 = zzep.zzt(jArr3[i10], j211, zzajfVar2.zzd, RoundingMode.DOWN);
                j7 = j211;
                iArr12[i16] = zzep.zzm(jArr5, j10, true, true);
                j11 = j10 + jZzt13;
                iArr6[i16] = zzep.zzo(jArr5, j11, z3, false);
                i17 = iArr12[i16];
                while (true) {
                    i18 = iArr12[i16];
                    if (i18 >= 0) {
                        break;
                        break;
                    }
                    break;
                    break;
                    iArr12[i16] = i18 - 1;
                }
                if (i18 < 0) {
                    iArr12[i16] = i17;
                    while (true) {
                        i19 = iArr12[i16];
                        if (i19 < iArr6[i16]) {
                            break;
                            break;
                        }
                        break;
                        break;
                        iArr12[i16] = i19 + 1;
                    }
                } else {
                    i19 = i18;
                }
                if (i8 == 2) {
                    while (true) {
                        i21 = iArr6[i16];
                        if (i21 >= jArr5.length - 1) {
                            break;
                            break;
                        }
                        i22 = i21 + 1;
                        if (jArr5[i22] > j11) {
                            break;
                            break;
                        }
                        iArr6[i16] = i22;
                    }
                }
                int i512 = iArr6[i16];
                i20 = iArr12[i16];
                i11 += i512 - i20;
                if (i9 != i20) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z4 |= z10;
                i9 = i512;
            } else {
                iArr13 = iArr4;
                i16 = i10;
            }
            iArr4 = iArr13;
            jArr7 = jArr7;
            i10 = i16 + 1;
            iArr5 = iArr12;
        }
        iArr7 = iArr5;
        iArr8 = iArr4;
        if (i11 != i7) {
            z5 = true;
        } else {
            z5 = false;
        }
        z6 = z4 | z5;
        if (z6) {
            jArr8 = new long[i11];
        } else {
            jArr8 = jArr4;
        }
        if (z6) {
            iArr9 = new int[i11];
        } else {
            iArr9 = iArr3;
        }
        if (true == z6) {
            i5 = 0;
        }
        if (z6) {
            iArr10 = new int[i11];
        } else {
            iArr10 = iArr8;
        }
        jArr9 = new long[i11];
        i12 = 0;
        z7 = false;
        i13 = 0;
        j8 = 0;
        while (i12 < jArr3.length) {
            j9 = jArr6[i12];
            i14 = iArr7[i12];
            z8 = z6;
            i15 = iArr6[i12];
            if (z8) {
                int i513 = i15 - i14;
                System.arraycopy(jArr4, i14, jArr8, i13, i513);
                System.arraycopy(iArr3, i14, iArr9, i13, i513);
                iArr11 = iArr8;
                System.arraycopy(iArr11, i14, iArr10, i13, i513);
            } else {
                iArr11 = iArr8;
            }
            while (i14 < i15) {
                int[] iArr110 = iArr11;
                long jZzt14 = zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN);
                jZzt2 = zzep.zzt(jArr5[i14] - j9, 1000000L, j7, RoundingMode.DOWN);
                if (jZzt2 < 0) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                z7 = (!z9) | z7;
                jArr9[i13] = jZzt14 + jZzt2;
                if (z8) {
                    i5 = iArr3[i14];
                }
                i13++;
                i14++;
                iArr11 = iArr110;
            }
            iArr8 = iArr11;
            j8 += jArr3[i12];
            i12++;
            z6 = z8;
            jArr9 = jArr9;
            iArr9 = iArr9;
        }
        int[] iArr111 = iArr9;
        long[] jArr17 = jArr9;
        long jZzt15 = zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN);
        if (z7) {
            zzt zztVarZza7 = zzajfVar2.zzg.zza();
            zztVarZza7.zzs(true);
            zzajfVarZzb = zzajfVar2.zzb(zztVarZza7.zzM());
        } else {
            zzajfVarZzb = zzajfVar2;
        }
        return new zzaji(zzajfVarZzb, jArr8, iArr111, i5, jArr17, iArr10, jZzt15, jArr8.length);
    }

    private static zzap zzh(zzeg zzegVar) {
        short sZzv = zzegVar.zzv();
        zzegVar.zzk(2);
        String strZzK = zzegVar.zzK(sZzv, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzK.lastIndexOf(43), strZzK.lastIndexOf(45));
        try {
            return new zzap(-9223372036854775807L, new zzex(Float.parseFloat(strZzK.substring(0, iMax)), Float.parseFloat(strZzK.substring(iMax, strZzK.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static int zzi(zzeg zzegVar) {
        zzegVar.zzh(16);
        return zzegVar.zzB();
    }

    private static String zzj(byte[] bArr, int i, int i2) {
        zzgmd.zzh(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i3 = 0; i3 < bArr.length - 3; i3 += 4) {
            int iZze = zzgst.zze(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3]);
            String str = zzep.zza;
            int i4 = ((iZze >> 8) & 255) - 128;
            int i5 = (iZze >> 16) & 255;
            int i6 = (iZze & 255) - 128;
            arrayList.add(String.format("%06x", Integer.valueOf(Math.max(0, Math.min(i5 + ((i6 * 17790) / 10000), 255)) | (Math.max(0, Math.min(((i4 * 14075) / 10000) + i5, 255)) << 16) | (Math.max(0, Math.min((i5 - ((i6 * 3455) / 10000)) - ((i4 * 7169) / 10000), 255)) << 8))));
        }
        String strZzd = zzglx.zzd(arrayList, ", ");
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 7 + String.valueOf(i2).length() + 10 + strZzd.length() + 1);
        sb.append("size: ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append("\npalette: ");
        sb.append(strZzd);
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0047 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0049  */
    /* JADX WARN: Code duplicated, block: B:75:0x015e  */
    /* JADX WARN: Code duplicated, block: B:83:0x0178 A[PHI: r3
      0x0178: PHI (r3v5 int) = (r3v4 int), (r3v4 int), (r3v8 int) binds: [B:76:0x016a, B:77:0x016c, B:82:0x0177] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x0187  */
    private static zzi zzk(zzeg zzegVar) {
        int i;
        int iZzj;
        int iZzj2;
        zzh zzhVar = new zzh();
        byte[] bArrZzi = zzegVar.zzi();
        zzef zzefVar = new zzef(bArrZzi, bArrZzi.length);
        zzefVar.zzf(zzegVar.zzg() * 8);
        zzefVar.zzo(1);
        int iZzj3 = zzefVar.zzj(3);
        zzefVar.zzh(6);
        boolean zZzi = zzefVar.zzi();
        boolean zZzi2 = zzefVar.zzi();
        boolean z = false;
        if (iZzj3 != 2) {
            if (iZzj3 <= 2) {
                i = true != zZzi ? 8 : 10;
                zzhVar.zze(i);
                zzhVar.zzf(i);
            }
        } else if (zZzi) {
            i = true == zZzi2 ? 12 : 10;
            zzhVar.zze(i);
            zzhVar.zzf(i);
        } else {
            zZzi = false;
            iZzj3 = 2;
            if (iZzj3 <= 2) {
                if (true != zZzi) {
                }
                zzhVar.zze(i);
                zzhVar.zzf(i);
            }
        }
        int i2 = 13;
        zzefVar.zzh(13);
        zzefVar.zzg();
        int iZzj4 = zzefVar.zzj(4);
        if (iZzj4 != 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzj4).length() + 22);
            sb.append("Unsupported obu_type: ");
            sb.append(iZzj4);
            zzdt.zzb("BoxParsers", sb.toString());
            return zzhVar.zzg();
        }
        if (zzefVar.zzi()) {
            zzdt.zzb("BoxParsers", "Unsupported obu_extension_flag");
            return zzhVar.zzg();
        }
        boolean zZzi3 = zzefVar.zzi();
        zzefVar.zzg();
        if (zZzi3 && zzefVar.zzj(8) > 127) {
            zzdt.zzb("BoxParsers", "Excessive obu_size");
            return zzhVar.zzg();
        }
        int iZzj5 = zzefVar.zzj(3);
        zzefVar.zzg();
        if (zzefVar.zzi()) {
            zzdt.zzb("BoxParsers", "Unsupported reduced_still_picture_header");
            return zzhVar.zzg();
        }
        if (zzefVar.zzi()) {
            zzdt.zzb("BoxParsers", "Unsupported timing_info_present_flag");
            return zzhVar.zzg();
        }
        if (zzefVar.zzi()) {
            zzdt.zzb("BoxParsers", "Unsupported initial_display_delay_present_flag");
            return zzhVar.zzg();
        }
        int iZzj6 = zzefVar.zzj(5);
        for (int i3 = 0; i3 <= iZzj6; i3++) {
            zzefVar.zzh(12);
            if (zzefVar.zzj(5) > 7) {
                zzefVar.zzg();
            }
        }
        int iZzj7 = zzefVar.zzj(4);
        int iZzj8 = zzefVar.zzj(4);
        zzefVar.zzh(iZzj7 + 1);
        zzefVar.zzh(iZzj8 + 1);
        if (zzefVar.zzi()) {
            zzefVar.zzh(7);
        }
        zzefVar.zzh(7);
        boolean zZzi4 = zzefVar.zzi();
        if (zZzi4) {
            zzefVar.zzh(2);
        }
        if ((zzefVar.zzi() || zzefVar.zzj(1) > 0) && !zzefVar.zzi()) {
            zzefVar.zzh(1);
        }
        if (zZzi4) {
            zzefVar.zzh(3);
        }
        zzefVar.zzh(3);
        boolean zZzi5 = zzefVar.zzi();
        if (iZzj5 != 2) {
            if (iZzj5 != 1) {
            }
            if (zzefVar.zzi()) {
                int iZzj9 = zzefVar.zzj(8);
                iZzj = zzefVar.zzj(8);
                int iZzj10 = zzefVar.zzj(8);
                if (!z || iZzj9 != 1) {
                    i2 = iZzj;
                    iZzj2 = zzefVar.zzj(1);
                } else if (iZzj != 13) {
                    iZzj9 = 1;
                    i2 = iZzj;
                    iZzj2 = zzefVar.zzj(1);
                } else if (iZzj10 == 0) {
                    iZzj2 = 1;
                    iZzj9 = 1;
                } else {
                    iZzj9 = 1;
                    iZzj2 = zzefVar.zzj(1);
                }
                zzhVar.zza(zzi.zzb(iZzj9));
                zzhVar.zzb(iZzj2 != 1 ? 2 : 1);
                zzhVar.zzc(zzi.zzc(i2));
            }
            return zzhVar.zzg();
        }
        if (zZzi5) {
            zzefVar.zzg();
        }
        if (zzefVar.zzi()) {
            z = true;
        }
        if (zzefVar.zzi()) {
            int iZzj11 = zzefVar.zzj(8);
            iZzj = zzefVar.zzj(8);
            int iZzj12 = zzefVar.zzj(8);
            if (!z) {
                i2 = iZzj;
                iZzj2 = zzefVar.zzj(1);
            } else {
                i2 = iZzj;
                iZzj2 = zzefVar.zzj(1);
            }
            zzhVar.zza(zzi.zzb(iZzj11));
            zzhVar.zzb(iZzj2 != 1 ? 2 : 1);
            zzhVar.zzc(zzi.zzc(i2));
        }
        return zzhVar.zzg();
    }

    private static zzi zzl(zzeg zzegVar) {
        zzh zzhVar = new zzh();
        byte[] bArrZzi = zzegVar.zzi();
        zzef zzefVar = new zzef(bArrZzi, bArrZzi.length);
        zzefVar.zzf(zzegVar.zzg() * 8);
        zzefVar.zzo(1);
        int iZzj = zzefVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzefVar.zzo(1);
            int iZzj2 = zzefVar.zzj(8);
            for (int i2 = 0; i2 < iZzj2; i2++) {
                zzefVar.zzh(6);
                boolean zZzi = zzefVar.zzi();
                zzefVar.zzg();
                zzefVar.zzo(11);
                zzefVar.zzh(4);
                int iZzj3 = zzefVar.zzj(4) + 8;
                zzhVar.zze(iZzj3);
                zzhVar.zzf(iZzj3);
                zzefVar.zzo(1);
                if (zZzi) {
                    int iZzj4 = zzefVar.zzj(8);
                    int iZzj5 = zzefVar.zzj(8);
                    zzefVar.zzo(1);
                    boolean zZzi2 = zzefVar.zzi();
                    zzhVar.zza(zzi.zzb(iZzj4));
                    zzhVar.zzb(true != zZzi2 ? 2 : 1);
                    zzhVar.zzc(zzi.zzc(iZzj5));
                }
            }
        }
        return zzhVar.zzg();
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static Pair zzn(zzeu zzeuVar) {
        zzev zzevVarZzc = zzeuVar.zzc(1701606260);
        if (zzevVarZzc == null) {
            return null;
        }
        zzeg zzegVar = zzevVarZzc.zza;
        zzegVar.zzh(8);
        int iZza = zza(zzegVar.zzB());
        int iZzH = zzegVar.zzH();
        long[] jArr = new long[iZzH];
        long[] jArr2 = new long[iZzH];
        for (int i = 0; i < iZzH; i++) {
            jArr[i] = iZza == 1 ? zzegVar.zzJ() : zzegVar.zzz();
            jArr2[i] = iZza == 1 ? zzegVar.zzD() : zzegVar.zzB();
            if (zzegVar.zzv() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            zzegVar.zzk(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Code duplicated, block: B:133:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:136:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:139:0x0203  */
    /* JADX WARN: Code duplicated, block: B:141:0x0219  */
    /* JADX WARN: Code duplicated, block: B:142:0x0228  */
    /* JADX WARN: Code duplicated, block: B:145:0x0244  */
    /* JADX WARN: Code duplicated, block: B:146:0x0255  */
    /* JADX WARN: Code duplicated, block: B:147:0x0260  */
    /* JADX WARN: Code duplicated, block: B:149:0x0265  */
    /* JADX WARN: Code duplicated, block: B:151:0x0270  */
    /* JADX WARN: Code duplicated, block: B:153:0x0278  */
    /* JADX WARN: Code duplicated, block: B:154:0x028b  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:159:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:161:0x02af  */
    /* JADX WARN: Code duplicated, block: B:182:0x0314  */
    /* JADX WARN: Code duplicated, block: B:183:0x031a  */
    /* JADX WARN: Code duplicated, block: B:185:0x031f  */
    /* JADX WARN: Code duplicated, block: B:186:0x0330  */
    /* JADX WARN: Code duplicated, block: B:188:0x0335  */
    /* JADX WARN: Code duplicated, block: B:189:0x0346  */
    /* JADX WARN: Code duplicated, block: B:191:0x034b  */
    /* JADX WARN: Code duplicated, block: B:192:0x035c  */
    /* JADX WARN: Code duplicated, block: B:194:0x0361 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:195:0x0363  */
    /* JADX WARN: Code duplicated, block: B:198:0x0391  */
    /* JADX WARN: Code duplicated, block: B:272:0x05d8 A[PHI: r10 r11 r27 r29 r31 r32
      0x05d8: PHI (r10v13 int) = (r44v1 int), (r10v18 int), (r10v21 int), (r10v22 int), (r10v22 int) binds: [B:276:0x0617, B:274:0x05de, B:273:0x05db, B:270:0x05d4, B:271:0x05d6] A[DONT_GENERATE, DONT_INLINE]
      0x05d8: PHI (r11v42 java.lang.String) = 
      (r11v41 java.lang.String)
      (r11v41 java.lang.String)
      (r11v41 java.lang.String)
      (r11v41 java.lang.String)
      (r11v46 java.lang.String)
     binds: [B:276:0x0617, B:274:0x05de, B:273:0x05db, B:270:0x05d4, B:271:0x05d6] A[DONT_GENERATE, DONT_INLINE]
      0x05d8: PHI (r27v2 int) = (r27v1 int), (r27v1 int), (r27v1 int), (r27v3 int), (r27v3 int) binds: [B:276:0x0617, B:274:0x05de, B:273:0x05db, B:270:0x05d4, B:271:0x05d6] A[DONT_GENERATE, DONT_INLINE]
      0x05d8: PHI (r29v1 int) = (r8v11 int), (r29v3 int), (r29v4 int), (r29v4 int), (r29v4 int) binds: [B:276:0x0617, B:274:0x05de, B:273:0x05db, B:270:0x05d4, B:271:0x05d6] A[DONT_GENERATE, DONT_INLINE]
      0x05d8: PHI (r31v1 int) = (r31v2 int), (r31v3 int), (r31v4 int), (r31v4 int), (r31v4 int) binds: [B:276:0x0617, B:274:0x05de, B:273:0x05db, B:270:0x05d4, B:271:0x05d6] A[DONT_GENERATE, DONT_INLINE]
      0x05d8: PHI (r32v1 int) = (r14v5 int), (r32v3 int), (r32v4 int), (r32v4 int), (r32v4 int) binds: [B:276:0x0617, B:274:0x05de, B:273:0x05db, B:270:0x05d4, B:271:0x05d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:274:0x05de  */
    /* JADX WARN: Code duplicated, block: B:275:0x0608  */
    /* JADX WARN: Code duplicated, block: B:277:0x0619  */
    /* JADX WARN: Code duplicated, block: B:279:0x0627  */
    /* JADX WARN: Code duplicated, block: B:281:0x062f  */
    /* JADX WARN: Code duplicated, block: B:294:0x0688  */
    /* JADX WARN: Code duplicated, block: B:296:0x0691  */
    /* JADX WARN: Code duplicated, block: B:297:0x069c  */
    /* JADX WARN: Code duplicated, block: B:299:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:29:0x0087  */
    /* JADX WARN: Code duplicated, block: B:314:0x0370 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0155  */
    private static void zzo(zzeg zzegVar, int i, int i2, int i3, int i4, String str, boolean z, zzq zzqVar, zzaig zzaigVar, int i5) throws zzat {
        int iZzt;
        int i6;
        int iZzt2;
        int iZzF;
        int iZzB;
        int i7;
        String str2;
        String string;
        List listZzk;
        zzaib zzaibVarZzp;
        zzahz zzahzVarZzq;
        int iZzB2;
        boolean z2;
        String str3;
        int iZzB3;
        int i8;
        int i9;
        String strZza;
        byte[] bArrZzb;
        String str4;
        zzeg zzegVar2;
        int i10;
        int i11;
        int i12;
        int iZzz;
        int iZzs;
        byte[] bArr;
        int iZzs2;
        String str5;
        byte[] bArr2;
        int i13 = i;
        int i14 = i3;
        zzq zzqVarZzb = zzqVar;
        zzegVar.zzh(i2 + 16);
        if (z) {
            iZzt = zzegVar.zzt();
            zzegVar.zzk(6);
        } else {
            zzegVar.zzk(8);
            iZzt = 0;
        }
        int i15 = 32;
        if (iZzt == 0 || iZzt == 1) {
            i6 = 2;
            iZzt2 = zzegVar.zzt();
            zzegVar.zzk(6);
            iZzF = zzegVar.zzF();
            zzegVar.zzh(zzegVar.zzg() - 4);
            iZzB = zzegVar.zzB();
            if (iZzt == 1) {
                zzegVar.zzk(16);
            }
            i7 = -1;
        } else {
            if (iZzt != 2) {
                return;
            }
            zzegVar.zzk(16);
            iZzF = (int) Math.round(Double.longBitsToDouble(zzegVar.zzD()));
            int iZzH = zzegVar.zzH();
            zzegVar.zzk(4);
            i6 = 2;
            int iZzH2 = zzegVar.zzH();
            int iZzH3 = zzegVar.zzH();
            int i16 = iZzH3 & 1;
            int i17 = iZzH3 & 2;
            if (i16 == 0) {
                if (iZzH2 == 8) {
                    i7 = 3;
                } else if (iZzH2 == 16) {
                    i7 = i17 != 0 ? 268435456 : 2;
                } else if (iZzH2 == 24) {
                    i7 = i17 != 0 ? 1342177280 : 21;
                } else if (iZzH2 == 32) {
                    i7 = i17 != 0 ? 1610612736 : 22;
                } else {
                    i7 = -1;
                }
            } else if (iZzH2 == 32) {
                i7 = 4;
            } else {
                i7 = -1;
            }
            zzegVar.zzk(8);
            iZzt2 = iZzH;
            iZzB = 0;
        }
        if (i13 == 1767992678) {
            iZzt2 = -1;
            iZzF = -1;
        } else {
            if (i13 == 1935764850) {
                iZzF = 8000;
            } else if (i13 == 1935767394) {
                iZzF = 16000;
                i13 = 1935767394;
            }
            iZzt2 = 1;
        }
        int iZzg = zzegVar.zzg();
        int iIntValue = 1701733217;
        if (i13 == 1701733217) {
            Pair pairZzr = zzr(zzegVar, i2, i14);
            if (pairZzr != null) {
                iIntValue = ((Integer) pairZzr.first).intValue();
                zzqVarZzb = zzqVarZzb == null ? null : zzqVarZzb.zzb(((zzajg) pairZzr.second).zzb);
                zzaigVar.zza[i5] = (zzajg) pairZzr.second;
            }
            i13 = iIntValue;
            zzegVar.zzh(iZzg);
        }
        if (i13 == 1633889587) {
            str2 = "audio/ac3";
        } else if (i13 == 1700998451) {
            str2 = "audio/eac3";
        } else if (i13 == 1633889588) {
            str2 = "audio/ac4";
        } else if (i13 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (i13 == 1685353320 || i13 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (i13 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (i13 == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (i13 == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (i13 != 1935767394) {
                if (i13 == 1936684916) {
                    i7 = i6;
                    str2 = "audio/raw";
                } else if (i13 == 1953984371) {
                    i13 = i13;
                    str2 = "audio/raw";
                    i7 = 268435456;
                } else if (i13 == 1819304813) {
                    if (i7 == -1) {
                        i7 = i6;
                    }
                    str2 = "audio/raw";
                } else if (i13 == 778924082 || i13 == 778924083) {
                    str2 = "audio/mpeg";
                } else if (i13 == 1835557169) {
                    str2 = "audio/mha1";
                } else if (i13 == 1835560241) {
                    i13 = i13;
                    str2 = "audio/mhm1";
                } else if (i13 == 1634492771) {
                    str2 = "audio/alac";
                } else if (i13 == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (i13 == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (i13 == 1332770163) {
                    str2 = "audio/opus";
                } else if (i13 == 1716281667) {
                    str2 = "audio/flac";
                } else if (i13 == 1835823201) {
                    str2 = "audio/true-hd";
                } else if (i13 == 1767992678) {
                    i13 = 1767992678;
                    str2 = "audio/iamf";
                } else {
                    i13 = i13;
                    str2 = null;
                }
                int i18 = i7;
                string = null;
                listZzk = null;
                zzaibVarZzp = null;
                zzahzVarZzq = null;
                while (iZzg - i2 < i14) {
                    zzegVar.zzh(iZzg);
                    iZzB2 = zzegVar.zzB();
                    if (iZzB2 > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    str3 = string;
                    String str6 = "childAtomSize must be positive";
                    zzade.zza(z2, "childAtomSize must be positive");
                    iZzB3 = zzegVar.zzB();
                    iZzF = iZzF;
                    if (iZzB3 == 1835557187) {
                        zzegVar.zzh(iZzg + 8);
                        zzegVar.zzk(1);
                        iZzs2 = zzegVar.zzs();
                        zzegVar.zzk(1);
                        if (Objects.equals(str2, "audio/mhm1")) {
                            str5 = String.format("mhm1.%02X", Integer.valueOf(iZzs2));
                        } else {
                            str5 = String.format("mha1.%02X", Integer.valueOf(iZzs2));
                        }
                        int iZzt3 = zzegVar.zzt();
                        bArr2 = new byte[iZzt3];
                        str3 = str5;
                        zzegVar.zzm(bArr2, 0, iZzt3);
                        if (listZzk == null) {
                            listZzk = zzgpe.zzj(bArr2);
                            iZzF = iZzF;
                            iZzB2 = iZzB2;
                            iZzg = iZzg;
                            iZzB = iZzB;
                            string = str3;
                        } else {
                            listZzk = zzgpe.zzk(bArr2, (byte[]) listZzk.get(0));
                            string = str3;
                            iZzB2 = iZzB2;
                            iZzB = iZzB;
                        }
                    } else if (iZzB3 == 1835557200) {
                        zzegVar.zzh(iZzg + 8);
                        iZzs = zzegVar.zzs();
                        if (iZzs > 0) {
                            bArr = new byte[iZzs];
                            zzegVar.zzm(bArr, 0, iZzs);
                            if (listZzk == null) {
                                listZzk = zzgpe.zzj(bArr);
                                string = str3;
                                iZzB2 = iZzB2;
                                iZzg = iZzg;
                                iZzB = iZzB;
                                iZzF = iZzF;
                            } else {
                                listZzk = zzgpe.zzk((byte[]) listZzk.get(0), bArr);
                                string = str3;
                                iZzB2 = iZzB2;
                                iZzB = iZzB;
                            }
                        } else {
                            iZzF = iZzF;
                            iZzB2 = iZzB2;
                            iZzg = iZzg;
                            iZzB = iZzB;
                            string = str3;
                        }
                    } else {
                        if (iZzB3 == 1702061171) {
                            iZzg = iZzg;
                            i8 = iZzg;
                            i9 = -1;
                        } else if (!z && iZzB3 == 2002876005) {
                            int iZzg2 = zzegVar.zzg();
                            zzade.zza(iZzg2 >= iZzg, null);
                            int i19 = iZzg2;
                            while (true) {
                                if (i19 - iZzg >= iZzB2) {
                                    iZzg = iZzg;
                                    i8 = -1;
                                    i9 = -1;
                                    break;
                                }
                                zzegVar.zzh(i19);
                                int iZzB4 = zzegVar.zzB();
                                zzade.zza(iZzB4 > 0, str6);
                                String str7 = str6;
                                if (zzegVar.zzB() == 1702061171) {
                                    iZzg = iZzg;
                                    i8 = i19;
                                    i9 = -1;
                                    break;
                                }
                                i19 += iZzB4;
                                str6 = str7;
                            }
                        } else if (iZzB3 == 1651798644) {
                            zzahzVarZzq = zzq(zzegVar, iZzg);
                            string = str3;
                            iZzB2 = iZzB2;
                            iZzB = iZzB;
                        } else {
                            if (iZzB3 == 1684103987) {
                                zzegVar.zzh(iZzg + 8);
                                zzaigVar.zzb = zzacb.zza(zzegVar, Integer.toString(i4), str, zzqVarZzb);
                            } else if (iZzB3 == 1684366131) {
                                zzegVar.zzh(iZzg + 8);
                                zzaigVar.zzb = zzacb.zzb(zzegVar, Integer.toString(i4), str, zzqVarZzb);
                            } else if (iZzB3 == 1684103988) {
                                zzegVar.zzh(iZzg + 8);
                                zzaigVar.zzb = zzace.zza(zzegVar, Integer.toString(i4), str, zzqVarZzb);
                            } else if (iZzB3 != 1684892784) {
                                if (iZzB3 != 1684305011 || iZzB3 == 1969517683) {
                                    iZzB2 = iZzB2;
                                    iZzg = iZzg;
                                    iZzB = iZzB;
                                    zzt zztVar = new zzt();
                                    zztVar.zzb(i4);
                                    zztVar.zzm(str2);
                                    zztVar.zzE(iZzt2);
                                    iZzF = iZzF;
                                    zztVar.zzF(iZzF);
                                    zztVar.zzq(zzqVarZzb);
                                    zztVar.zze(str);
                                    zzaigVar.zzb = zztVar.zzM();
                                } else {
                                    if (iZzB3 == 1682927731) {
                                        int i20 = iZzB2 - 8;
                                        byte[] bArr3 = zzb;
                                        int length = bArr3.length;
                                        iZzB2 = iZzB2;
                                        byte[] bArrCopyOf = Arrays.copyOf(bArr3, length + i20);
                                        zzegVar.zzh(iZzg + 8);
                                        zzegVar.zzm(bArrCopyOf, length, i20);
                                        listZzk = zzadz.zza(bArrCopyOf);
                                    } else {
                                        iZzB2 = iZzB2;
                                        if (iZzB3 == 1684425825) {
                                            byte[] bArr4 = new byte[iZzB2 - 8];
                                            bArr4[0] = 102;
                                            bArr4[1] = 76;
                                            bArr4[i6] = 97;
                                            bArr4[3] = 67;
                                            zzegVar.zzh(iZzg + 12);
                                            zzegVar.zzm(bArr4, 4, iZzB2 - 12);
                                            listZzk = zzgpe.zzj(bArr4);
                                        } else if (iZzB3 == 1634492771) {
                                            int i21 = iZzB2 - 12;
                                            byte[] bArr5 = new byte[i21];
                                            zzegVar.zzh(iZzg + 12);
                                            zzegVar.zzm(bArr5, 0, i21);
                                            int i22 = zzdd.zza;
                                            zzeg zzegVar3 = new zzeg(bArr5);
                                            zzegVar3.zzh(5);
                                            int iZzs3 = zzegVar3.zzs();
                                            zzegVar3.zzh(9);
                                            int iZzs4 = zzegVar3.zzs();
                                            zzegVar3.zzh(20);
                                            int[] iArr = {zzegVar3.zzH(), iZzs4, iZzs3};
                                            int i23 = iArr[0];
                                            int i24 = iArr[1];
                                            int iZzz2 = zzep.zzz(iZzs3, ByteOrder.LITTLE_ENDIAN);
                                            listZzk = zzgpe.zzj(bArr5);
                                            iZzt2 = i24;
                                            i18 = iZzz2;
                                            iZzF = i23;
                                            iZzg = iZzg;
                                            iZzB = iZzB;
                                            string = str3;
                                        } else if (iZzB3 == 1767990114) {
                                            zzegVar.zzh(iZzg + 9);
                                            int iZza = zzgst.zza(zzegVar.zzP());
                                            byte[] bArr6 = new byte[iZza];
                                            zzegVar.zzm(bArr6, 0, iZza);
                                            int i25 = zzdd.zza;
                                            zzeg zzegVar4 = new zzeg(bArr6);
                                            String str8 = null;
                                            String str9 = null;
                                            while (zzegVar4.zzd() > 0 && (str8 == null || str9 == null)) {
                                                int iZzs5 = zzegVar4.zzs();
                                                byte[] bArr7 = bArr6;
                                                int i26 = iZzs5 >> 3;
                                                int i27 = iZzs5 & 2;
                                                int i28 = iZzs5 & 1;
                                                int iZza2 = zzgst.zza(zzegVar4.zzP());
                                                if (i26 > 4 && i26 < 24 && i27 != 0) {
                                                    zzegVar4.zzQ();
                                                    zzegVar4.zzQ();
                                                }
                                                if (i28 != 0) {
                                                    zzegVar4.zzk(zzgst.zza(zzegVar4.zzP()));
                                                }
                                                int iZzg3 = zzegVar4.zzg() + iZza2;
                                                int i29 = iZzg;
                                                if (i26 == 31) {
                                                    zzegVar4.zzk(4);
                                                    Object[] objArr = {Integer.valueOf(zzegVar4.zzs()), Integer.valueOf(zzegVar4.zzs())};
                                                    String str10 = zzep.zza;
                                                    str8 = String.format(Locale.US, "iamf.%03X.%03X", objArr);
                                                } else {
                                                    if (i26 == 0) {
                                                        zzegVar4.zzQ();
                                                        String strZzK = zzegVar4.zzK(4, StandardCharsets.UTF_8);
                                                        if (strZzK.equals("mp4a")) {
                                                            zzegVar4.zzQ();
                                                            zzegVar4.zzk(i6);
                                                            zzef zzefVar = new zzef();
                                                            zzefVar.zza(zzegVar4);
                                                            int iZzj = zzefVar.zzj(5);
                                                            if (iZzj == 31) {
                                                                iZzj = zzefVar.zzj(6) + 32;
                                                            }
                                                            StringBuilder sb = new StringBuilder(strZzK.length() + 4 + String.valueOf(iZzj).length());
                                                            sb.append(strZzK);
                                                            sb.append(".40.");
                                                            sb.append(iZzj);
                                                            strZzK = sb.toString();
                                                        }
                                                        str9 = strZzK;
                                                    }
                                                    zzegVar4.zzh(iZzg3);
                                                    bArr6 = bArr7;
                                                    iZzg = i29;
                                                    iZzB = iZzB;
                                                    i6 = 2;
                                                }
                                                iZzB = iZzB;
                                                zzegVar4.zzh(iZzg3);
                                                bArr6 = bArr7;
                                                iZzg = i29;
                                                iZzB = iZzB;
                                                i6 = 2;
                                            }
                                            byte[] bArr8 = bArr6;
                                            iZzg = iZzg;
                                            iZzB = iZzB;
                                            if (str8 == null || str9 == null) {
                                                string = null;
                                            } else {
                                                StringBuilder sb2 = new StringBuilder(str8.length() + 1 + str9.length());
                                                sb2.append(str8);
                                                sb2.append(".");
                                                sb2.append(str9);
                                                string = sb2.toString();
                                            }
                                            listZzk = zzgpe.zzj(bArr8);
                                            iZzF = iZzF;
                                        } else {
                                            iZzg = iZzg;
                                            iZzB = iZzB;
                                            if (iZzB3 == 1885564227) {
                                                zzegVar.zzh(iZzg + 12);
                                                ByteOrder byteOrder = (zzegVar.zzs() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                                int iZzs6 = zzegVar.zzs();
                                                if (i13 == 1768973165) {
                                                    iZzz = zzep.zzz(iZzs6, byteOrder);
                                                } else {
                                                    iZzz = (i13 == 1718641517 && iZzs6 == i15 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? 4 : i18;
                                                }
                                                iZzF = iZzF;
                                                i18 = iZzz;
                                                if (iZzz != -1) {
                                                    str2 = "audio/raw";
                                                }
                                            } else {
                                                iZzF = iZzF;
                                            }
                                        }
                                    }
                                    string = str3;
                                    iZzB = iZzB;
                                }
                                string = str3;
                            } else {
                                if (iZzB > 0) {
                                    StringBuilder sb3 = new StringBuilder(String.valueOf(iZzB).length() + 49);
                                    sb3.append("Invalid sample rate for Dolby TrueHD MLP stream: ");
                                    sb3.append(iZzB);
                                    throw zzat.zzb(sb3.toString(), null);
                                }
                                string = str3;
                                iZzB2 = iZzB2;
                                iZzF = iZzB;
                                iZzB = iZzF;
                                iZzt2 = i6;
                            }
                            iZzF = iZzF;
                            iZzB2 = iZzB2;
                            iZzg = iZzg;
                            iZzB = iZzB;
                            string = str3;
                        }
                        if (i8 != i9) {
                            zzaibVarZzp = zzp(zzegVar, i8);
                            strZza = zzaibVarZzp.zza();
                            bArrZzb = zzaibVarZzp.zzb();
                            if (bArrZzb == null) {
                                if ("audio/vorbis".equals(strZza)) {
                                    zzegVar2 = new zzeg(bArrZzb);
                                    i10 = 1;
                                    zzegVar2.zzk(1);
                                    i11 = 0;
                                    while (zzegVar2.zzd() > 0 && zzegVar2.zzn() == 255) {
                                        zzegVar2.zzk(i10);
                                        i11 += 255;
                                        i10 = 1;
                                    }
                                    int iZzs7 = i11 + zzegVar2.zzs();
                                    i12 = 0;
                                    while (zzegVar2.zzd() > 0 && zzegVar2.zzn() == 255) {
                                        zzegVar2.zzk(1);
                                        i12 += 255;
                                    }
                                    int iZzs8 = i12 + zzegVar2.zzs();
                                    byte[] bArr9 = new byte[iZzs7];
                                    int iZzg4 = zzegVar2.zzg();
                                    System.arraycopy(bArrZzb, iZzg4, bArr9, 0, iZzs7);
                                    int i30 = iZzg4 + iZzs7 + iZzs8;
                                    int length2 = bArrZzb.length - i30;
                                    byte[] bArr10 = new byte[length2];
                                    System.arraycopy(bArrZzb, i30, bArr10, 0, length2);
                                    listZzk = zzgpe.zzk(bArr9, bArr10);
                                } else {
                                    if ("audio/mp4a-latm".equals(strZza)) {
                                        zzaby zzabyVarZza = zzabz.zza(bArrZzb);
                                        iZzF = zzabyVarZza.zza;
                                        iZzt2 = zzabyVarZza.zzb;
                                        str4 = zzabyVarZza.zzc;
                                    } else {
                                        str4 = str3;
                                    }
                                    zzgpe zzgpeVarZzj = zzgpe.zzj(bArrZzb);
                                    str2 = strZza;
                                    string = str4;
                                    listZzk = zzgpeVarZzj;
                                }
                            }
                            str2 = strZza;
                        }
                        string = str3;
                    }
                    iZzg += iZzB2;
                    iZzB = iZzB;
                    i6 = 2;
                    i15 = 32;
                    i14 = i3;
                }
                String str11 = string;
                if (zzaigVar.zzb == null || str2 == null) {
                }
                zzt zztVar2 = new zzt();
                zztVar2.zzb(i4);
                zztVar2.zzm(str2);
                zztVar2.zzj(str11);
                zztVar2.zzE(iZzt2);
                zztVar2.zzF(iZzF);
                zztVar2.zzG(i18);
                zztVar2.zzp(listZzk);
                zztVar2.zzq(zzqVarZzb);
                zztVar2.zze(str);
                if (zzaibVarZzp != null) {
                    zztVar2.zzh(zzgst.zzb(zzaibVarZzp.zzc()));
                    zztVar2.zzi(zzgst.zzb(zzaibVarZzp.zzd()));
                } else if (zzahzVarZzq != null) {
                    zztVar2.zzh(zzgst.zzb(zzahzVarZzq.zza()));
                    zztVar2.zzi(zzgst.zzb(zzahzVarZzq.zzb()));
                }
                zzaigVar.zzb = zztVar2.zzM();
                return;
            }
            str2 = "audio/amr-wb";
        }
        i13 = i13;
        int i110 = i7;
        string = null;
        listZzk = null;
        zzaibVarZzp = null;
        zzahzVarZzq = null;
        while (iZzg - i2 < i14) {
            zzegVar.zzh(iZzg);
            iZzB2 = zzegVar.zzB();
            if (iZzB2 > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            str3 = string;
            String str12 = "childAtomSize must be positive";
            zzade.zza(z2, "childAtomSize must be positive");
            iZzB3 = zzegVar.zzB();
            iZzF = iZzF;
            if (iZzB3 == 1835557187) {
                zzegVar.zzh(iZzg + 8);
                zzegVar.zzk(1);
                iZzs2 = zzegVar.zzs();
                zzegVar.zzk(1);
                if (Objects.equals(str2, "audio/mhm1")) {
                    str5 = String.format("mhm1.%02X", Integer.valueOf(iZzs2));
                } else {
                    str5 = String.format("mha1.%02X", Integer.valueOf(iZzs2));
                }
                int iZzt4 = zzegVar.zzt();
                bArr2 = new byte[iZzt4];
                str3 = str5;
                zzegVar.zzm(bArr2, 0, iZzt4);
                if (listZzk == null) {
                    listZzk = zzgpe.zzj(bArr2);
                    iZzF = iZzF;
                    iZzB2 = iZzB2;
                    iZzg = iZzg;
                    iZzB = iZzB;
                    string = str3;
                } else {
                    listZzk = zzgpe.zzk(bArr2, (byte[]) listZzk.get(0));
                    string = str3;
                    iZzB2 = iZzB2;
                    iZzB = iZzB;
                }
            } else if (iZzB3 == 1835557200) {
                zzegVar.zzh(iZzg + 8);
                iZzs = zzegVar.zzs();
                if (iZzs > 0) {
                    bArr = new byte[iZzs];
                    zzegVar.zzm(bArr, 0, iZzs);
                    if (listZzk == null) {
                        listZzk = zzgpe.zzj(bArr);
                        string = str3;
                        iZzB2 = iZzB2;
                        iZzg = iZzg;
                        iZzB = iZzB;
                        iZzF = iZzF;
                    } else {
                        listZzk = zzgpe.zzk((byte[]) listZzk.get(0), bArr);
                        string = str3;
                        iZzB2 = iZzB2;
                        iZzB = iZzB;
                    }
                } else {
                    iZzF = iZzF;
                    iZzB2 = iZzB2;
                    iZzg = iZzg;
                    iZzB = iZzB;
                    string = str3;
                }
            } else {
                if (iZzB3 == 1702061171) {
                    if (!z) {
                    }
                    if (iZzB3 == 1651798644) {
                        zzahzVarZzq = zzq(zzegVar, iZzg);
                        string = str3;
                        iZzB2 = iZzB2;
                        iZzB = iZzB;
                    } else {
                        if (iZzB3 == 1684103987) {
                            zzegVar.zzh(iZzg + 8);
                            zzaigVar.zzb = zzacb.zza(zzegVar, Integer.toString(i4), str, zzqVarZzb);
                        } else if (iZzB3 == 1684366131) {
                            zzegVar.zzh(iZzg + 8);
                            zzaigVar.zzb = zzacb.zzb(zzegVar, Integer.toString(i4), str, zzqVarZzb);
                        } else if (iZzB3 == 1684103988) {
                            zzegVar.zzh(iZzg + 8);
                            zzaigVar.zzb = zzace.zza(zzegVar, Integer.toString(i4), str, zzqVarZzb);
                        } else if (iZzB3 != 1684892784) {
                            if (iZzB > 0) {
                                StringBuilder sb4 = new StringBuilder(String.valueOf(iZzB).length() + 49);
                                sb4.append("Invalid sample rate for Dolby TrueHD MLP stream: ");
                                sb4.append(iZzB);
                                throw zzat.zzb(sb4.toString(), null);
                            }
                            string = str3;
                            iZzB2 = iZzB2;
                            iZzF = iZzB;
                            iZzB = iZzF;
                            iZzt2 = i6;
                        } else if (iZzB3 != 1684305011) {
                            iZzB2 = iZzB2;
                            iZzg = iZzg;
                            iZzB = iZzB;
                            zzt zztVar3 = new zzt();
                            zztVar3.zzb(i4);
                            zztVar3.zzm(str2);
                            zztVar3.zzE(iZzt2);
                            iZzF = iZzF;
                            zztVar3.zzF(iZzF);
                            zztVar3.zzq(zzqVarZzb);
                            zztVar3.zze(str);
                            zzaigVar.zzb = zztVar3.zzM();
                            string = str3;
                        } else {
                            iZzB2 = iZzB2;
                            iZzg = iZzg;
                            iZzB = iZzB;
                            zzt zztVar4 = new zzt();
                            zztVar4.zzb(i4);
                            zztVar4.zzm(str2);
                            zztVar4.zzE(iZzt2);
                            iZzF = iZzF;
                            zztVar4.zzF(iZzF);
                            zztVar4.zzq(zzqVarZzb);
                            zztVar4.zze(str);
                            zzaigVar.zzb = zztVar4.zzM();
                            string = str3;
                        }
                        iZzF = iZzF;
                        iZzB2 = iZzB2;
                        iZzg = iZzg;
                        iZzB = iZzB;
                        string = str3;
                    }
                } else {
                    iZzg = iZzg;
                    i8 = iZzg;
                    i9 = -1;
                }
                if (i8 != i9) {
                    zzaibVarZzp = zzp(zzegVar, i8);
                    strZza = zzaibVarZzp.zza();
                    bArrZzb = zzaibVarZzp.zzb();
                    if (bArrZzb == null) {
                        if ("audio/vorbis".equals(strZza)) {
                            zzegVar2 = new zzeg(bArrZzb);
                            i10 = 1;
                            zzegVar2.zzk(1);
                            i11 = 0;
                            while (zzegVar2.zzd() > 0) {
                                zzegVar2.zzk(i10);
                                i11 += 255;
                                i10 = 1;
                            }
                            int iZzs9 = i11 + zzegVar2.zzs();
                            i12 = 0;
                            while (zzegVar2.zzd() > 0) {
                                zzegVar2.zzk(1);
                                i12 += 255;
                            }
                            int iZzs10 = i12 + zzegVar2.zzs();
                            byte[] bArr11 = new byte[iZzs9];
                            int iZzg5 = zzegVar2.zzg();
                            System.arraycopy(bArrZzb, iZzg5, bArr11, 0, iZzs9);
                            int i31 = iZzg5 + iZzs9 + iZzs10;
                            int length3 = bArrZzb.length - i31;
                            byte[] bArr12 = new byte[length3];
                            System.arraycopy(bArrZzb, i31, bArr12, 0, length3);
                            listZzk = zzgpe.zzk(bArr11, bArr12);
                        } else {
                            if ("audio/mp4a-latm".equals(strZza)) {
                                zzaby zzabyVarZza2 = zzabz.zza(bArrZzb);
                                iZzF = zzabyVarZza2.zza;
                                iZzt2 = zzabyVarZza2.zzb;
                                str4 = zzabyVarZza2.zzc;
                            } else {
                                str4 = str3;
                            }
                            zzgpe zzgpeVarZzj2 = zzgpe.zzj(bArrZzb);
                            str2 = strZza;
                            string = str4;
                            listZzk = zzgpeVarZzj2;
                        }
                    }
                    str2 = strZza;
                }
                string = str3;
            }
            iZzg += iZzB2;
            iZzB = iZzB;
            i6 = 2;
            i15 = 32;
            i14 = i3;
        }
        String str13 = string;
        if (zzaigVar.zzb == null) {
        }
    }

    private static zzaib zzp(zzeg zzegVar, int i) {
        zzegVar.zzh(i + 12);
        zzegVar.zzk(1);
        zzs(zzegVar);
        zzegVar.zzk(2);
        int iZzs = zzegVar.zzs();
        if ((iZzs & 128) != 0) {
            zzegVar.zzk(2);
        }
        if ((iZzs & 64) != 0) {
            zzegVar.zzk(zzegVar.zzs());
        }
        if ((iZzs & 32) != 0) {
            zzegVar.zzk(2);
        }
        zzegVar.zzk(1);
        zzs(zzegVar);
        String strZzf = zzas.zzf(zzegVar.zzs());
        if ("audio/mpeg".equals(strZzf) || "audio/vnd.dts".equals(strZzf) || "audio/vnd.dts.hd".equals(strZzf)) {
            return new zzaib(strZzf, null, -1L, -1L);
        }
        zzegVar.zzk(4);
        long jZzz = zzegVar.zzz();
        long jZzz2 = zzegVar.zzz();
        zzegVar.zzk(1);
        int iZzs2 = zzs(zzegVar);
        long j = jZzz2;
        byte[] bArr = new byte[iZzs2];
        zzegVar.zzm(bArr, 0, iZzs2);
        if (j <= 0) {
            j = -1;
        }
        return new zzaib(strZzf, bArr, j, jZzz > 0 ? jZzz : -1L);
    }

    private static zzahz zzq(zzeg zzegVar, int i) {
        zzegVar.zzh(i + 8);
        zzegVar.zzk(4);
        return new zzahz(zzegVar.zzz(), zzegVar.zzz());
    }

    private static Pair zzr(zzeg zzegVar, int i, int i2) throws zzat {
        zzajg zzajgVar;
        Pair pairCreate;
        int i3;
        int i4;
        int iZzg = zzegVar.zzg();
        while (iZzg - i < i2) {
            zzegVar.zzh(iZzg);
            int iZzB = zzegVar.zzB();
            zzade.zza(iZzB > 0, "childAtomSize must be positive");
            if (zzegVar.zzB() == 1936289382) {
                int i5 = iZzg + 8;
                int i6 = 0;
                int i7 = -1;
                Integer numValueOf = null;
                String strZzK = null;
                while (i5 - iZzg < iZzB) {
                    zzegVar.zzh(i5);
                    int iZzB2 = zzegVar.zzB();
                    int iZzB3 = zzegVar.zzB();
                    if (iZzB3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzegVar.zzB());
                    } else if (iZzB3 == 1935894637) {
                        zzegVar.zzk(4);
                        strZzK = zzegVar.zzK(4, StandardCharsets.UTF_8);
                    } else if (iZzB3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzB2;
                    }
                    i5 += iZzB2;
                }
                byte[] bArr = null;
                if ("cenc".equals(strZzK) || "cbc1".equals(strZzK) || "cens".equals(strZzK) || "cbcs".equals(strZzK)) {
                    zzade.zza(numValueOf != null, "frma atom is mandatory");
                    zzade.zza(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            zzajgVar = null;
                            break;
                        }
                        zzegVar.zzh(i8);
                        int iZzB4 = zzegVar.zzB();
                        if (zzegVar.zzB() == 1952804451) {
                            int iZza = zza(zzegVar.zzB());
                            zzegVar.zzk(1);
                            if (iZza == 0) {
                                zzegVar.zzk(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int iZzs = zzegVar.zzs();
                                i3 = iZzs & 15;
                                i4 = (iZzs & 240) >> 4;
                            }
                            boolean z = zzegVar.zzs() == 1;
                            int iZzs2 = zzegVar.zzs();
                            byte[] bArr2 = new byte[16];
                            zzegVar.zzm(bArr2, 0, 16);
                            if (z && iZzs2 == 0) {
                                int iZzs3 = zzegVar.zzs();
                                byte[] bArr3 = new byte[iZzs3];
                                zzegVar.zzm(bArr3, 0, iZzs3);
                                bArr = bArr3;
                            }
                            zzajgVar = new zzajg(z, strZzK, iZzs2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i8 += iZzB4;
                    }
                    zzade.zza(zzajgVar != null, "tenc atom is mandatory");
                    String str = zzep.zza;
                    pairCreate = Pair.create(numValueOf, zzajgVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzg += iZzB;
        }
        return null;
    }

    private static int zzs(zzeg zzegVar) {
        int iZzs = zzegVar.zzs();
        int i = iZzs & WorkQueueKt.MASK;
        while ((iZzs & 128) == 128) {
            iZzs = zzegVar.zzs();
            i = (i << 7) | (iZzs & WorkQueueKt.MASK);
        }
        return i;
    }
}
