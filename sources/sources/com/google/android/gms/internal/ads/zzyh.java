package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzyh extends zzya {
    private final boolean zze;
    private final zzxt zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final int zzv;

    /* JADX WARN: Code duplicated, block: B:122:0x0189  */
    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    /* JADX WARN: Code duplicated, block: B:32:0x004f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0053  */
    /* JADX WARN: Code duplicated, block: B:36:0x0057  */
    /* JADX WARN: Code duplicated, block: B:38:0x005d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0064  */
    /* JADX WARN: Code duplicated, block: B:42:0x0068  */
    /* JADX WARN: Code duplicated, block: B:45:0x006e  */
    /* JADX WARN: Code duplicated, block: B:90:0x012f  */
    public zzyh(int i, zzbg zzbgVar, int i2, zzxt zzxtVar, int i3, String str, int i4, boolean z) {
        boolean z2;
        boolean z3;
        int i5;
        int iZzj;
        int i6;
        byte b;
        boolean z4;
        int i7;
        float f;
        int i8;
        zzv zzvVar;
        int i9;
        int i10;
        int i11;
        super(i, zzbgVar, i2);
        this.zzf = zzxtVar;
        int i12 = 1;
        int i13 = true != zzxtVar.zzM ? 16 : 24;
        boolean z5 = zzxtVar.zzL;
        if (!z || (((i9 = (zzvVar = this.zzd).zzv) != -1 && i9 > zzxtVar.zza) || ((i10 = zzvVar.zzw) != -1 && i10 > zzxtVar.zzb))) {
            z2 = false;
        } else {
            float f2 = zzvVar.zzz;
            if ((f2 == -1.0f || f2 <= zzxtVar.zzc) && ((i11 = zzvVar.zzj) == -1 || i11 <= zzxtVar.zzd)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.zze = z2;
        if (z) {
            zzv zzvVar2 = this.zzd;
            int i14 = zzvVar2.zzv;
            if (i14 != -1) {
                int i15 = zzxtVar.zze;
                if (i14 >= 0) {
                    i7 = zzvVar2.zzw;
                    if (i7 != -1) {
                        int i16 = zzxtVar.zzf;
                        if (i7 >= 0) {
                            f = zzvVar2.zzz;
                            if (f != -1.0f) {
                                int i17 = zzxtVar.zzg;
                                if (f >= 0.0f) {
                                    i8 = zzvVar2.zzj;
                                    if (i8 != -1) {
                                        int i18 = zzxtVar.zzh;
                                        if (i8 >= 0) {
                                            z3 = false;
                                        }
                                    }
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                i8 = zzvVar2.zzj;
                                if (i8 != -1) {
                                    int i19 = zzxtVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                    } else {
                        f = zzvVar2.zzz;
                        if (f != -1.0f) {
                            int i110 = zzxtVar.zzg;
                            if (f >= 0.0f) {
                                i8 = zzvVar2.zzj;
                                if (i8 != -1) {
                                    int i111 = zzxtVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i8 = zzvVar2.zzj;
                            if (i8 != -1) {
                                int i112 = zzxtVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    }
                } else {
                    z3 = false;
                }
            } else {
                i7 = zzvVar2.zzw;
                if (i7 != -1) {
                    int i113 = zzxtVar.zzf;
                    if (i7 >= 0) {
                        f = zzvVar2.zzz;
                        if (f != -1.0f) {
                            int i114 = zzxtVar.zzg;
                            if (f >= 0.0f) {
                                i8 = zzvVar2.zzj;
                                if (i8 != -1) {
                                    int i115 = zzxtVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i8 = zzvVar2.zzj;
                            if (i8 != -1) {
                                int i116 = zzxtVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    f = zzvVar2.zzz;
                    if (f != -1.0f) {
                        int i117 = zzxtVar.zzg;
                        if (f >= 0.0f) {
                            i8 = zzvVar2.zzj;
                            if (i8 != -1) {
                                int i118 = zzxtVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        i8 = zzvVar2.zzj;
                        if (i8 != -1) {
                            int i119 = zzxtVar.zzh;
                            if (i8 >= 0) {
                                z3 = false;
                            }
                        }
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
        }
        this.zzg = z3;
        this.zzh = zzlp.zzaa(i3, false);
        zzv zzvVar3 = this.zzd;
        float f3 = zzvVar3.zzz;
        this.zzi = f3 != -1.0f && f3 >= 10.0f;
        this.zzj = zzvVar3.zzj;
        this.zzk = zzvVar3.zzc();
        int i20 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i20 >= zzxtVar.zzo.size()) {
                iZzj = 0;
                i20 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzyi.zzj(this.zzd, (String) zzxtVar.zzo.get(i20), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i20++;
                }
            }
        }
        this.zzm = i20;
        this.zzn = iZzj;
        int i21 = this.zzd.zzf;
        int i22 = zzxtVar.zzp;
        this.zzo = zzyi.zzm(i21, 0);
        int i23 = this.zzd.zzf;
        this.zzq = i23 == 0 || (i23 & 1) != 0;
        this.zzr = zzyi.zzj(this.zzd, str, zzyi.zzi(str) == null);
        for (int i24 = 0; i24 < zzxtVar.zzm.size(); i24++) {
            String str2 = this.zzd.zzo;
            if (str2 != null && str2.equals(zzxtVar.zzm.get(i24))) {
                i5 = i24;
                break;
            }
        }
        this.zzl = i5;
        this.zzp = zzyi.zzn(this.zzd, zzxtVar.zzn);
        this.zzt = (i3 & 384) == 128;
        this.zzu = (i3 & 64) == 64;
        zzv zzvVar4 = this.zzd;
        String str3 = zzvVar4.zzo;
        if (str3 == null) {
            i6 = 0;
        } else {
            i6 = 4;
            switch (str3) {
                case "video/dolby-vision":
                    b = 0;
                    break;
                case "video/av01":
                    b = 1;
                    break;
                case "video/hevc":
                    b = 2;
                    break;
                case "video/avc":
                    b = 4;
                    break;
                case "video/x-vnd.on2.vp9":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                i6 = 5;
            } else if (b != 1) {
                if (b == 2) {
                    i6 = 3;
                } else if (b == 3) {
                    i6 = 2;
                } else if (b != 4) {
                    i6 = 0;
                } else {
                    i6 = 1;
                }
            }
        }
        this.zzv = i6;
        if ((zzvVar4.zzf & 16384) != 0) {
            i12 = 0;
        } else {
            zzxt zzxtVar2 = this.zzf;
            if (!zzlp.zzaa(i3, zzxtVar2.zzV) || (!(z4 = this.zze) && !zzxtVar2.zzK)) {
                i12 = 0;
            } else if (zzlp.zzaa(i3, false) && this.zzg && z4 && zzvVar4.zzj != -1) {
                boolean z6 = zzxtVar2.zzG;
                boolean z7 = zzxtVar2.zzF;
                if ((i13 & i3) != 0) {
                    i12 = 2;
                }
            }
        }
        this.zzs = i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzi(zzyh zzyhVar, zzyh zzyhVar2) {
        zzgot zzgotVarZza = zzgot.zzg().zzd(zzyhVar.zzh, zzyhVar2.zzh).zza(Integer.valueOf(zzyhVar.zzm), Integer.valueOf(zzyhVar2.zzm), zzgqy.zzb().zza()).zzb(zzyhVar.zzn, zzyhVar2.zzn).zzb(zzyhVar.zzo, zzyhVar2.zzo).zza(Integer.valueOf(zzyhVar.zzp), Integer.valueOf(zzyhVar2.zzp), zzgqy.zzb().zza()).zzd(zzyhVar.zzq, zzyhVar2.zzq).zzb(zzyhVar.zzr, zzyhVar2.zzr).zzd(zzyhVar.zzi, zzyhVar2.zzi).zzd(zzyhVar.zze, zzyhVar2.zze).zzd(zzyhVar.zzg, zzyhVar2.zzg).zza(Integer.valueOf(zzyhVar.zzl), Integer.valueOf(zzyhVar2.zzl), zzgqy.zzb().zza());
        boolean z = zzyhVar.zzt;
        zzgot zzgotVarZzd = zzgotVarZza.zzd(z, zzyhVar2.zzt);
        boolean z2 = zzyhVar.zzu;
        zzgot zzgotVarZzd2 = zzgotVarZzd.zzd(z2, zzyhVar2.zzu);
        if (z && z2) {
            zzgotVarZzd2 = zzgotVarZzd2.zzb(zzyhVar.zzv, zzyhVar2.zzv);
        }
        return zzgotVarZzd2.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(zzyh zzyhVar, zzyh zzyhVar2) {
        zzgqy zzgqyVarZza = (zzyhVar.zze && zzyhVar.zzh) ? zzyi.zzc : zzyi.zzc.zza();
        zzgot zzgotVarZzg = zzgot.zzg();
        boolean z = zzyhVar.zzf.zzF;
        return zzgotVarZzg.zza(Integer.valueOf(zzyhVar.zzk), Integer.valueOf(zzyhVar2.zzk), zzgqyVarZza).zza(Integer.valueOf(zzyhVar.zzj), Integer.valueOf(zzyhVar2.zzj), zzgqyVarZza).zze();
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final int zza() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final /* bridge */ /* synthetic */ boolean zzc(zzya zzyaVar) {
        zzyh zzyhVar = (zzyh) zzyaVar;
        if (!Objects.equals(this.zzd.zzo, zzyhVar.zzd.zzo)) {
            return false;
        }
        boolean z = this.zzf.zzN;
        return this.zzt == zzyhVar.zzt && this.zzu == zzyhVar.zzu;
    }
}
