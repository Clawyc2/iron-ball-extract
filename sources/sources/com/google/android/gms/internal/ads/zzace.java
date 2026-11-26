package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzace {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Code duplicated, block: B:146:0x020b  */
    /* JADX WARN: Code duplicated, block: B:148:0x0211  */
    /* JADX WARN: Code duplicated, block: B:155:0x0225  */
    /* JADX WARN: Code duplicated, block: B:157:0x0239 A[LOOP:2: B:156:0x0237->B:157:0x0239, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:159:0x0248  */
    /* JADX WARN: Code duplicated, block: B:162:0x0251  */
    /* JADX WARN: Code duplicated, block: B:164:0x025b  */
    /* JADX WARN: Code duplicated, block: B:165:0x0260  */
    /* JADX WARN: Code duplicated, block: B:169:0x026b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0271  */
    /* JADX WARN: Code duplicated, block: B:178:0x029b  */
    /* JADX WARN: Code duplicated, block: B:181:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:182:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:183:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:184:0x02af  */
    /* JADX WARN: Code duplicated, block: B:185:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:186:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:187:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:188:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:189:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:190:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:191:0x02be  */
    /* JADX WARN: Code duplicated, block: B:192:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:195:0x02c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:201:0x02d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:202:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:205:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:208:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:209:0x02df  */
    /* JADX WARN: Code duplicated, block: B:210:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:212:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:214:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:217:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:219:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:221:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:223:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:225:0x0302  */
    /* JADX WARN: Code duplicated, block: B:227:0x0305  */
    /* JADX WARN: Code duplicated, block: B:228:0x032b  */
    /* JADX WARN: Code duplicated, block: B:229:0x032d  */
    /* JADX WARN: Code duplicated, block: B:230:0x0330  */
    /* JADX WARN: Code duplicated, block: B:231:0x0332  */
    /* JADX WARN: Code duplicated, block: B:232:0x0334  */
    /* JADX WARN: Code duplicated, block: B:235:0x0338  */
    /* JADX WARN: Code duplicated, block: B:237:0x037d  */
    public static zzv zza(zzeg zzegVar, String str, String str2, zzq zzqVar) throws zzat {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        boolean zZzi;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        int iZzc;
        int iZzj4;
        int i16;
        zzef zzefVar = new zzef();
        zzefVar.zza(zzegVar);
        int iZzc2 = zzefVar.zzc();
        int iZzj5 = zzefVar.zzj(3);
        if (iZzj5 > 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzj5).length() + 30);
            sb.append("Unsupported AC-4 DSI version: ");
            sb.append(iZzj5);
            throw zzat.zzc(sb.toString());
        }
        int iZzj6 = zzefVar.zzj(7);
        int i17 = true != zzefVar.zzi() ? 44100 : 48000;
        zzefVar.zzh(4);
        int iZzj7 = zzefVar.zzj(9);
        if (iZzj6 > 1) {
            if (iZzj5 == 0) {
                throw zzat.zzc("Invalid AC-4 DSI version: 0");
            }
            if (zzefVar.zzi()) {
                zzefVar.zzh(16);
                if (zzefVar.zzi()) {
                    zzefVar.zzh(128);
                }
            }
        }
        if (iZzj5 == 1) {
            if (!zzg(zzefVar)) {
                throw zzat.zzc("Invalid AC-4 DSI bitrate.");
            }
            zzefVar.zzm();
        }
        zzacc zzaccVar = new zzacc(null);
        int i18 = 0;
        while (true) {
            if (i18 < iZzj7) {
                if (iZzj5 == 0) {
                    zZzi = zzefVar.zzi();
                    iZzj = zzefVar.zzj(5);
                    iZzj2 = zzefVar.zzj(5);
                    iZzj3 = 0;
                    i11 = 0;
                    z2 = false;
                } else {
                    int iZzj8 = zzefVar.zzj(8);
                    iZzj3 = zzefVar.zzj(8);
                    if (iZzj3 == 255) {
                        iZzj3 = zzefVar.zzj(16) + 255;
                    }
                    if (iZzj8 > 2) {
                        zzefVar.zzh(iZzj3 * 8);
                        i18++;
                    } else {
                        int iZzc3 = (iZzc2 - zzefVar.zzc()) / 8;
                        iZzj = zzefVar.zzj(5);
                        iZzj2 = iZzj8;
                        z2 = iZzj == 31;
                        i11 = iZzc3;
                        zZzi = false;
                    }
                }
                zzaccVar.zzf = iZzj2;
                if (zZzi || z2 || iZzj != 6) {
                    zzaccVar.zzg = zzefVar.zzj(3);
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(5);
                    }
                    zzefVar.zzh(2);
                    if (iZzj5 == 1) {
                        if (iZzj2 != 1) {
                            if (iZzj2 == 2) {
                                iZzj2 = 2;
                                zzefVar.zzh(2);
                            }
                            if (iZzj2 <= 0) {
                                i2 = 8;
                                i = 5;
                            } else {
                                if (!zzefVar.zzi() && !zzg(zzefVar)) {
                                    throw zzat.zzc("Can't parse bitrate DSI.");
                                }
                                if (zzefVar.zzi()) {
                                    zzefVar.zzm();
                                    zzefVar.zzo(zzefVar.zzj(16));
                                    i = 5;
                                    iZzj4 = zzefVar.zzj(5);
                                    for (i16 = 0; i16 < iZzj4; i16++) {
                                        zzefVar.zzh(3);
                                        zzefVar.zzh(8);
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = 8;
                                    i = 5;
                                }
                            }
                            zzefVar.zzm();
                            if (iZzj5 == 1) {
                                iZzc = ((i12 - zzefVar.zzc()) / i2) - i11;
                                if (iZzj3 < iZzc) {
                                    throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                                }
                                zzefVar.zzo(iZzj3 - iZzc);
                            }
                            if (zzaccVar.zza) {
                                i4 = -1;
                                if (zzaccVar.zzb == -1) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(i18).length() + 45);
                                    sb2.append("Can't determine channel mode of presentation ");
                                    sb2.append(i18);
                                    throw zzat.zzc(sb2.toString());
                                }
                            }
                            if (zzaccVar.zza) {
                                i9 = zzaccVar.zzb;
                                z = zzaccVar.zzd;
                                i10 = zzaccVar.zze;
                                switch (i9) {
                                    case 0:
                                        i4 = 1;
                                        break;
                                    case 1:
                                        i4 = 2;
                                        break;
                                    case 2:
                                        i4 = 3;
                                        break;
                                    case 3:
                                        i4 = i;
                                        break;
                                    case 4:
                                        i4 = 6;
                                        break;
                                    case 5:
                                    case 7:
                                    case 9:
                                        i4 = i3;
                                        break;
                                    case 6:
                                    case 8:
                                    case 10:
                                        i4 = i2;
                                        break;
                                    case 11:
                                        i4 = 11;
                                        break;
                                    case 12:
                                        i4 = 12;
                                        break;
                                    case 13:
                                        i4 = 13;
                                        break;
                                    case 14:
                                        i4 = 14;
                                        break;
                                    case 15:
                                        i4 = 24;
                                        break;
                                }
                                if (i9 != 11 || i9 == 12 || i9 == 13 || i9 == 14) {
                                    if (!z) {
                                        i4 -= 2;
                                    }
                                    i8 = i4;
                                    if (i10 == 0) {
                                        i8 -= 4;
                                    } else if (i10 == 1) {
                                        i8 -= 2;
                                    }
                                } else {
                                    i8 = i4;
                                }
                            } else {
                                i5 = zzaccVar.zzc;
                                if (i5 > 0) {
                                    i8 = i5 + 1;
                                    if (zzaccVar.zzg == 4 && i8 == 17) {
                                        i8 = 21;
                                    }
                                } else {
                                    i6 = zzaccVar.zzg;
                                    if (i6 != 0) {
                                        i7 = 2;
                                    } else if (i6 != 1) {
                                        i7 = 2;
                                        if (i6 != 2) {
                                            i8 = i2;
                                        } else if (i6 != 3) {
                                            i8 = 10;
                                        } else if (i6 != 4) {
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(i6).length() + 33);
                                            sb3.append("AC-4 level ");
                                            sb3.append(i6);
                                            sb3.append(" has not been defined.");
                                            zzdt.zzc("Ac4Util", sb3.toString());
                                        } else {
                                            i8 = 12;
                                        }
                                    } else {
                                        i8 = 6;
                                    }
                                    i8 = i7;
                                }
                            }
                            if (i8 > 0) {
                                throw zzat.zzc("Cannot determine channel count of presentation.");
                            }
                            Object[] objArr = {Integer.valueOf(iZzj6), Integer.valueOf(zzaccVar.zzf), Integer.valueOf(zzaccVar.zzg)};
                            String str3 = zzep.zza;
                            String str4 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr);
                            zzt zztVar = new zzt();
                            zztVar.zza(str);
                            zztVar.zzm("audio/ac4");
                            zztVar.zzE(i8);
                            zztVar.zzF(i17);
                            zztVar.zzq(zzqVar);
                            zztVar.zze(str2);
                            zztVar.zzj(str4);
                            return zztVar.zzM();
                        }
                        zzefVar.zzh(2);
                    }
                    zzefVar.zzh(5);
                    zzefVar.zzh(10);
                    if (iZzj5 == 1) {
                        if (iZzj2 > 0) {
                            zzaccVar.zza = zzefVar.zzi();
                        }
                        if (zzaccVar.zza) {
                            if (iZzj2 != 1) {
                                i13 = 2;
                                if (iZzj2 == 2) {
                                    i15 = 2;
                                } else {
                                    i12 = iZzc2;
                                    i15 = iZzj2;
                                }
                                zzefVar.zzh(24);
                                i14 = 1;
                            } else {
                                i15 = 1;
                            }
                            i12 = iZzc2;
                            int iZzj9 = zzefVar.zzj(5);
                            if (iZzj9 >= 0 && iZzj9 <= 15) {
                                zzaccVar.zzb = iZzj9;
                            }
                            if (iZzj9 < 11 || iZzj9 > 14) {
                                i13 = 2;
                            } else {
                                zzaccVar.zzd = zzefVar.zzi();
                                i13 = 2;
                                zzaccVar.zze = zzefVar.zzj(2);
                            }
                            zzefVar.zzh(24);
                            i14 = 1;
                        } else {
                            i12 = iZzc2;
                            i13 = 2;
                            i14 = 1;
                            i15 = iZzj2;
                        }
                        if (iZzj2 == i14 || iZzj2 == i13) {
                            if (zzefVar.zzi() && zzefVar.zzi()) {
                                zzefVar.zzh(i13);
                            }
                            if (zzefVar.zzi()) {
                                zzefVar.zzg();
                                int i19 = 8;
                                int iZzj10 = zzefVar.zzj(8);
                                int i20 = 0;
                                while (i20 < iZzj10) {
                                    zzefVar.zzh(i19);
                                    i20++;
                                    i19 = 8;
                                }
                            }
                        }
                        iZzj2 = i15;
                    } else {
                        i12 = iZzc2;
                    }
                    if (!zZzi && !z2) {
                        zzefVar.zzg();
                        if (iZzj == 0 || iZzj == 1 || iZzj == 2) {
                            if (iZzj2 == 0) {
                                for (int i21 = 0; i21 < 2; i21++) {
                                    zzd(zzefVar, zzaccVar);
                                }
                                iZzj2 = 0;
                            } else {
                                for (int i22 = 0; i22 < 2; i22++) {
                                    zze(zzefVar, zzaccVar);
                                }
                            }
                        } else if (iZzj == 3 || iZzj == 4) {
                            if (iZzj2 == 0) {
                                for (int i23 = 0; i23 < 3; i23++) {
                                    zzd(zzefVar, zzaccVar);
                                }
                                iZzj2 = 0;
                            } else {
                                for (int i24 = 0; i24 < 3; i24++) {
                                    zze(zzefVar, zzaccVar);
                                }
                            }
                        } else if (iZzj != 5) {
                            int iZzj11 = zzefVar.zzj(7);
                            for (int i25 = 0; i25 < iZzj11; i25++) {
                                zzefVar.zzh(8);
                            }
                        } else if (iZzj2 == 0) {
                            zzd(zzefVar, zzaccVar);
                            iZzj2 = 0;
                        } else {
                            int iZzj12 = zzefVar.zzj(3);
                            for (int i26 = 0; i26 < iZzj12 + 2; i26++) {
                                zze(zzefVar, zzaccVar);
                            }
                        }
                    } else if (iZzj2 == 0) {
                        zzd(zzefVar, zzaccVar);
                        iZzj2 = 0;
                    } else {
                        zze(zzefVar, zzaccVar);
                    }
                    zzefVar.zzg();
                    if (!zzefVar.zzi()) {
                        i3 = 7;
                    }
                    if (iZzj2 <= 0) {
                        i2 = 8;
                        i = 5;
                    } else {
                        if (!zzefVar.zzi()) {
                        }
                        if (zzefVar.zzi()) {
                            zzefVar.zzm();
                            zzefVar.zzo(zzefVar.zzj(16));
                            i = 5;
                            iZzj4 = zzefVar.zzj(5);
                            while (i16 < iZzj4) {
                                zzefVar.zzh(3);
                                zzefVar.zzh(8);
                            }
                            i2 = 8;
                        } else {
                            i2 = 8;
                            i = 5;
                        }
                    }
                    zzefVar.zzm();
                    if (iZzj5 == 1) {
                        iZzc = ((i12 - zzefVar.zzc()) / i2) - i11;
                        if (iZzj3 < iZzc) {
                            throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                        }
                        zzefVar.zzo(iZzj3 - iZzc);
                    }
                    if (zzaccVar.zza) {
                        i4 = -1;
                        if (zzaccVar.zzb == -1) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(i18).length() + 45);
                            sb4.append("Can't determine channel mode of presentation ");
                            sb4.append(i18);
                            throw zzat.zzc(sb4.toString());
                        }
                    }
                    if (zzaccVar.zza) {
                        i9 = zzaccVar.zzb;
                        z = zzaccVar.zzd;
                        i10 = zzaccVar.zze;
                        switch (i9) {
                            case 0:
                                i4 = 1;
                                break;
                            case 1:
                                i4 = 2;
                                break;
                            case 2:
                                i4 = 3;
                                break;
                            case 3:
                                i4 = i;
                                break;
                            case 4:
                                i4 = 6;
                                break;
                            case 5:
                            case 7:
                            case 9:
                                i4 = i3;
                                break;
                            case 6:
                            case 8:
                            case 10:
                                i4 = i2;
                                break;
                            case 11:
                                i4 = 11;
                                break;
                            case 12:
                                i4 = 12;
                                break;
                            case 13:
                                i4 = 13;
                                break;
                            case 14:
                                i4 = 14;
                                break;
                            case 15:
                                i4 = 24;
                                break;
                        }
                        if (i9 != 11) {
                            if (!z) {
                                i4 -= 2;
                            }
                            i8 = i4;
                            if (i10 == 0) {
                                i8 -= 4;
                            } else if (i10 == 1) {
                                i8 -= 2;
                            }
                        } else {
                            if (!z) {
                                i4 -= 2;
                            }
                            i8 = i4;
                            if (i10 == 0) {
                                i8 -= 4;
                            } else if (i10 == 1) {
                                i8 -= 2;
                            }
                        }
                    } else {
                        i5 = zzaccVar.zzc;
                        if (i5 > 0) {
                            i8 = i5 + 1;
                            if (zzaccVar.zzg == 4) {
                                i8 = 21;
                            }
                        } else {
                            i6 = zzaccVar.zzg;
                            if (i6 != 0) {
                                i7 = 2;
                            } else if (i6 != 1) {
                                i7 = 2;
                                if (i6 != 2) {
                                    i8 = i2;
                                } else if (i6 != 3) {
                                    i8 = 10;
                                } else if (i6 != 4) {
                                    StringBuilder sb5 = new StringBuilder(String.valueOf(i6).length() + 33);
                                    sb5.append("AC-4 level ");
                                    sb5.append(i6);
                                    sb5.append(" has not been defined.");
                                    zzdt.zzc("Ac4Util", sb5.toString());
                                } else {
                                    i8 = 12;
                                }
                            } else {
                                i8 = 6;
                            }
                            i8 = i7;
                        }
                    }
                    if (i8 > 0) {
                        throw zzat.zzc("Cannot determine channel count of presentation.");
                    }
                    Object[] objArr2 = {Integer.valueOf(iZzj6), Integer.valueOf(zzaccVar.zzf), Integer.valueOf(zzaccVar.zzg)};
                    String str5 = zzep.zza;
                    String str6 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr2);
                    zzt zztVar2 = new zzt();
                    zztVar2.zza(str);
                    zztVar2.zzm("audio/ac4");
                    zztVar2.zzE(i8);
                    zztVar2.zzF(i17);
                    zztVar2.zzq(zzqVar);
                    zztVar2.zze(str2);
                    zztVar2.zzj(str6);
                    return zztVar2.zzM();
                }
                i12 = iZzc2;
                i3 = 7;
                int iZzj13 = zzefVar.zzj(7);
                for (int i27 = 0; i27 < iZzj13; i27++) {
                    zzefVar.zzh(15);
                }
                if (iZzj2 <= 0) {
                    i2 = 8;
                    i = 5;
                } else {
                    if (!zzefVar.zzi()) {
                    }
                    if (zzefVar.zzi()) {
                        zzefVar.zzm();
                        zzefVar.zzo(zzefVar.zzj(16));
                        i = 5;
                        iZzj4 = zzefVar.zzj(5);
                        while (i16 < iZzj4) {
                            zzefVar.zzh(3);
                            zzefVar.zzh(8);
                        }
                        i2 = 8;
                    } else {
                        i2 = 8;
                        i = 5;
                    }
                }
                zzefVar.zzm();
                if (iZzj5 == 1) {
                    iZzc = ((i12 - zzefVar.zzc()) / i2) - i11;
                    if (iZzj3 < iZzc) {
                        throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                    }
                    zzefVar.zzo(iZzj3 - iZzc);
                }
                if (zzaccVar.zza) {
                    i4 = -1;
                    if (zzaccVar.zzb == -1) {
                        StringBuilder sb6 = new StringBuilder(String.valueOf(i18).length() + 45);
                        sb6.append("Can't determine channel mode of presentation ");
                        sb6.append(i18);
                        throw zzat.zzc(sb6.toString());
                    }
                }
                if (zzaccVar.zza) {
                    i9 = zzaccVar.zzb;
                    z = zzaccVar.zzd;
                    i10 = zzaccVar.zze;
                    switch (i9) {
                        case 0:
                            i4 = 1;
                            break;
                        case 1:
                            i4 = 2;
                            break;
                        case 2:
                            i4 = 3;
                            break;
                        case 3:
                            i4 = i;
                            break;
                        case 4:
                            i4 = 6;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            i4 = i3;
                            break;
                        case 6:
                        case 8:
                        case 10:
                            i4 = i2;
                            break;
                        case 11:
                            i4 = 11;
                            break;
                        case 12:
                            i4 = 12;
                            break;
                        case 13:
                            i4 = 13;
                            break;
                        case 14:
                            i4 = 14;
                            break;
                        case 15:
                            i4 = 24;
                            break;
                    }
                    if (i9 != 11) {
                        if (!z) {
                            i4 -= 2;
                        }
                        i8 = i4;
                        if (i10 == 0) {
                            i8 -= 4;
                        } else if (i10 == 1) {
                            i8 -= 2;
                        }
                    } else {
                        if (!z) {
                            i4 -= 2;
                        }
                        i8 = i4;
                        if (i10 == 0) {
                            i8 -= 4;
                        } else if (i10 == 1) {
                            i8 -= 2;
                        }
                    }
                } else {
                    i5 = zzaccVar.zzc;
                    if (i5 > 0) {
                        i8 = i5 + 1;
                        if (zzaccVar.zzg == 4) {
                            i8 = 21;
                        }
                    } else {
                        i6 = zzaccVar.zzg;
                        if (i6 != 0) {
                            i7 = 2;
                        } else if (i6 != 1) {
                            i7 = 2;
                            if (i6 != 2) {
                                i8 = i2;
                            } else if (i6 != 3) {
                                i8 = 10;
                            } else if (i6 != 4) {
                                StringBuilder sb7 = new StringBuilder(String.valueOf(i6).length() + 33);
                                sb7.append("AC-4 level ");
                                sb7.append(i6);
                                sb7.append(" has not been defined.");
                                zzdt.zzc("Ac4Util", sb7.toString());
                            } else {
                                i8 = 12;
                            }
                        } else {
                            i8 = 6;
                        }
                        i8 = i7;
                    }
                }
                if (i8 > 0) {
                    throw zzat.zzc("Cannot determine channel count of presentation.");
                }
                Object[] objArr3 = {Integer.valueOf(iZzj6), Integer.valueOf(zzaccVar.zzf), Integer.valueOf(zzaccVar.zzg)};
                String str7 = zzep.zza;
                String str8 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr3);
                zzt zztVar3 = new zzt();
                zztVar3.zza(str);
                zztVar3.zzm("audio/ac4");
                zztVar3.zzE(i8);
                zztVar3.zzF(i17);
                zztVar3.zzq(zzqVar);
                zztVar3.zze(str2);
                zztVar3.zzj(str8);
                return zztVar3.zzM();
            }
            i = 5;
            i2 = 8;
            i3 = 7;
            i4 = -1;
            if (zzaccVar.zza) {
                i9 = zzaccVar.zzb;
                z = zzaccVar.zzd;
                i10 = zzaccVar.zze;
                switch (i9) {
                    case 0:
                        i4 = 1;
                        break;
                    case 1:
                        i4 = 2;
                        break;
                    case 2:
                        i4 = 3;
                        break;
                    case 3:
                        i4 = i;
                        break;
                    case 4:
                        i4 = 6;
                        break;
                    case 5:
                    case 7:
                    case 9:
                        i4 = i3;
                        break;
                    case 6:
                    case 8:
                    case 10:
                        i4 = i2;
                        break;
                    case 11:
                        i4 = 11;
                        break;
                    case 12:
                        i4 = 12;
                        break;
                    case 13:
                        i4 = 13;
                        break;
                    case 14:
                        i4 = 14;
                        break;
                    case 15:
                        i4 = 24;
                        break;
                }
                if (i9 != 11) {
                    if (!z) {
                        i4 -= 2;
                    }
                    i8 = i4;
                    if (i10 == 0) {
                        i8 -= 4;
                    } else if (i10 == 1) {
                        i8 -= 2;
                    }
                } else {
                    if (!z) {
                        i4 -= 2;
                    }
                    i8 = i4;
                    if (i10 == 0) {
                        i8 -= 4;
                    } else if (i10 == 1) {
                        i8 -= 2;
                    }
                }
            } else {
                i5 = zzaccVar.zzc;
                if (i5 > 0) {
                    i8 = i5 + 1;
                    if (zzaccVar.zzg == 4) {
                        i8 = 21;
                    }
                } else {
                    i6 = zzaccVar.zzg;
                    if (i6 != 0) {
                        i7 = 2;
                    } else if (i6 != 1) {
                        i7 = 2;
                        if (i6 != 2) {
                            i8 = i2;
                        } else if (i6 != 3) {
                            i8 = 10;
                        } else if (i6 != 4) {
                            StringBuilder sb8 = new StringBuilder(String.valueOf(i6).length() + 33);
                            sb8.append("AC-4 level ");
                            sb8.append(i6);
                            sb8.append(" has not been defined.");
                            zzdt.zzc("Ac4Util", sb8.toString());
                        } else {
                            i8 = 12;
                        }
                    } else {
                        i8 = 6;
                    }
                    i8 = i7;
                }
            }
            if (i8 > 0) {
                throw zzat.zzc("Cannot determine channel count of presentation.");
            }
            Object[] objArr4 = {Integer.valueOf(iZzj6), Integer.valueOf(zzaccVar.zzf), Integer.valueOf(zzaccVar.zzg)};
            String str9 = zzep.zza;
            String str10 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr4);
            zzt zztVar4 = new zzt();
            zztVar4.zza(str);
            zztVar4.zzm("audio/ac4");
            zztVar4.zzE(i8);
            zztVar4.zzF(i17);
            zztVar4.zzq(zzqVar);
            zztVar4.zze(str2);
            zztVar4.zzj(str10);
            return zztVar4.zzM();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    public static zzacd zzb(zzef zzefVar) {
        int i;
        int iZzj;
        int iZzj2 = zzefVar.zzj(16);
        int iZzj3 = zzefVar.zzj(16);
        if (iZzj3 == 65535) {
            iZzj3 = zzefVar.zzj(24);
            i = 7;
        } else {
            i = 4;
        }
        int i2 = iZzj3 + i;
        if (iZzj2 == 44097) {
            i2 += 2;
        }
        int i3 = i2;
        int iZzj4 = zzefVar.zzj(2);
        int i4 = 0;
        if (iZzj4 == 3) {
            int i5 = 0;
            while (true) {
                iZzj = i5 + zzefVar.zzj(2);
                if (!zzefVar.zzi()) {
                    break;
                }
                i5 = (iZzj + 1) << 2;
            }
            iZzj4 = iZzj + 3;
        }
        int i6 = iZzj4;
        int iZzj5 = zzefVar.zzj(10);
        if (zzefVar.zzi() && zzefVar.zzj(3) > 0) {
            zzefVar.zzh(2);
        }
        int i7 = 44100;
        if (true == zzefVar.zzi()) {
            i7 = 48000;
        }
        int iZzj6 = zzefVar.zzj(4);
        if (i7 == 44100 && iZzj6 == 13) {
            i4 = zzb[13];
        } else if (i7 == 48000 && iZzj6 < 14) {
            i4 = zzb[iZzj6];
            int i8 = iZzj5 % 5;
            if (i8 == 1) {
                if (iZzj6 != 3 || iZzj6 == 8) {
                    i4++;
                }
            } else if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4 && (iZzj6 == 3 || iZzj6 == 8 || iZzj6 == 11)) {
                        i4++;
                    }
                } else if (iZzj6 != 3) {
                    i4++;
                } else {
                    i4++;
                }
            } else if (iZzj6 == 8 || iZzj6 == 11) {
                i4++;
            }
        }
        return new zzacd(i6, 2, i7, i3, i4, null);
    }

    public static void zzc(int i, zzeg zzegVar) {
        zzegVar.zza(7);
        byte[] bArrZzi = zzegVar.zzi();
        bArrZzi[0] = -84;
        bArrZzi[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrZzi[2] = -1;
        bArrZzi[3] = -1;
        bArrZzi[4] = (byte) ((i >> 16) & 255);
        bArrZzi[5] = (byte) ((i >> 8) & 255);
        bArrZzi[6] = (byte) (i & 255);
    }

    private static void zzd(zzef zzefVar, zzacc zzaccVar) throws zzat {
        int iZzj = zzefVar.zzj(5);
        zzefVar.zzh(2);
        if (zzefVar.zzi()) {
            zzefVar.zzh(5);
        }
        if (iZzj >= 7 && iZzj <= 10) {
            zzefVar.zzg();
        }
        if (zzefVar.zzi()) {
            int iZzj2 = zzefVar.zzj(3);
            if (zzaccVar.zzb == -1 && iZzj >= 0 && iZzj <= 15 && (iZzj2 == 0 || iZzj2 == 1)) {
                zzaccVar.zzb = iZzj;
            }
            if (zzefVar.zzi()) {
                zzf(zzefVar);
            }
        }
    }

    private static void zze(zzef zzefVar, zzacc zzaccVar) throws zzat {
        zzefVar.zzh(2);
        boolean zZzi = zzefVar.zzi();
        int iZzj = zzefVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzefVar.zzh(2);
            if (zzefVar.zzi()) {
                zzefVar.zzh(5);
            }
            if (zZzi) {
                zzefVar.zzh(24);
            } else {
                if (zzefVar.zzi()) {
                    if (!zzefVar.zzi()) {
                        zzefVar.zzh(4);
                    }
                    zzaccVar.zzc = zzefVar.zzj(6) + 1;
                }
                zzefVar.zzh(4);
            }
        }
        if (zzefVar.zzi()) {
            zzefVar.zzh(3);
            if (zzefVar.zzi()) {
                zzf(zzefVar);
            }
        }
    }

    private static void zzf(zzef zzefVar) throws zzat {
        int iZzj = zzefVar.zzj(6);
        if (iZzj < 2 || iZzj > 42) {
            throw zzat.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzj)));
        }
        zzefVar.zzh(iZzj * 8);
    }

    private static boolean zzg(zzef zzefVar) {
        if (zzefVar.zzc() < 66) {
            return false;
        }
        zzefVar.zzh(66);
        return true;
    }
}
