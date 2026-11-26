package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzajy extends zzajw {
    private zzajx zza;
    private int zzb;
    private boolean zzc;
    private zzaer zzd;
    private zzaep zze;

    zzajy() {
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final long zzb(zzeg zzegVar) {
        if ((zzegVar.zzi()[0] & 1) == 1) {
            return -1L;
        }
        byte b = zzegVar.zzi()[0];
        zzajx zzajxVar = this.zza;
        zzajxVar.getClass();
        int i = !zzajxVar.zzd[(b >> 1) & (255 >>> (8 - zzajxVar.zze))].zza ? zzajxVar.zza.zze : zzajxVar.zza.zzf;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzegVar.zzj() < zzegVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzegVar.zzi(), zzegVar.zze() + 4);
            zzegVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzegVar.zzf(zzegVar.zze() + 4);
        }
        long j = i2;
        byte[] bArrZzi = zzegVar.zzi();
        bArrZzi[zzegVar.zze() - 4] = (byte) (j & 255);
        bArrZzi[zzegVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzi[zzegVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzi[zzegVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzajw
    protected final void zzj(long j) {
        super.zzj(j);
        this.zzc = j != 0;
        zzaer zzaerVar = this.zzd;
        this.zzb = zzaerVar != null ? zzaerVar.zze : 0;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03ea  */
    @Override // com.google.android.gms.internal.ads.zzajw
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzeg zzegVar, long j, zzaju zzajuVar) throws IOException {
        zzajx zzajxVar;
        int i;
        int iZzb;
        int i2;
        int[] iArr;
        if (this.zza != null) {
            zzajuVar.zza.getClass();
            return false;
        }
        zzaer zzaerVar = this.zzd;
        int i3 = 1;
        if (zzaerVar != null) {
            int i4 = 4;
            zzaep zzaepVar = this.zze;
            if (zzaepVar == null) {
                this.zze = zzaes.zzb(zzegVar, true, true);
            } else {
                byte[] bArr = new byte[zzegVar.zze()];
                System.arraycopy(zzegVar.zzi(), 0, bArr, 0, zzegVar.zze());
                int i5 = zzaerVar.zza;
                int i6 = 5;
                zzaes.zzd(5, zzegVar, false);
                int iZzs = zzegVar.zzs() + 1;
                zzaeo zzaeoVar = new zzaeo(zzegVar.zzi());
                zzaeoVar.zzc(zzegVar.zzg() * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 2;
                    int i9 = 16;
                    if (i7 >= iZzs) {
                        int i10 = i3;
                        int i11 = 6;
                        int iZzb2 = zzaeoVar.zzb(6) + i10;
                        for (int i12 = 0; i12 < iZzb2; i12++) {
                            if (zzaeoVar.zzb(16) != 0) {
                                throw zzat.zzb("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int iZzb3 = zzaeoVar.zzb(6) + i10;
                        int i13 = 0;
                        while (true) {
                            int i14 = 3;
                            if (i13 >= iZzb3) {
                                int i15 = 1;
                                int iZzb4 = zzaeoVar.zzb(i11) + 1;
                                int i16 = 0;
                                while (i16 < iZzb4) {
                                    if (zzaeoVar.zzb(16) > 2) {
                                        throw zzat.zzb("residueType greater than 2 is not decodable", null);
                                    }
                                    zzaeoVar.zzc(24);
                                    zzaeoVar.zzc(24);
                                    zzaeoVar.zzc(24);
                                    int iZzb5 = zzaeoVar.zzb(i11) + i15;
                                    int i17 = 8;
                                    zzaeoVar.zzc(8);
                                    int[] iArr2 = new int[iZzb5];
                                    for (int i18 = 0; i18 < iZzb5; i18++) {
                                        iArr2[i18] = ((zzaeoVar.zza() ? zzaeoVar.zzb(5) : 0) * 8) + zzaeoVar.zzb(3);
                                    }
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            if ((iArr2[i19] & (1 << i20)) != 0) {
                                                zzaeoVar.zzc(i17);
                                            }
                                            i20++;
                                            i17 = 8;
                                        }
                                        i19++;
                                        i17 = 8;
                                    }
                                    i16++;
                                    i11 = 6;
                                    i15 = 1;
                                }
                                int iZzb6 = zzaeoVar.zzb(i11) + 1;
                                for (int i21 = 0; i21 < iZzb6; i21++) {
                                    int iZzb7 = zzaeoVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzb7).length() + 41);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iZzb7);
                                        zzdt.zze("VorbisUtil", sb.toString());
                                    } else {
                                        if (zzaeoVar.zza()) {
                                            i = 1;
                                            iZzb = zzaeoVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzaeoVar.zza()) {
                                            int iZzb8 = zzaeoVar.zzb(8) + i;
                                            for (int i22 = 0; i22 < iZzb8; i22++) {
                                                int i23 = i5 - 1;
                                                zzaeoVar.zzc(zzaes.zza(i23));
                                                zzaeoVar.zzc(zzaes.zza(i23));
                                            }
                                        }
                                        if (zzaeoVar.zzb(2) != 0) {
                                            throw zzat.zzb("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i24 = 0; i24 < i5; i24++) {
                                                zzaeoVar.zzc(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < iZzb; i25++) {
                                            zzaeoVar.zzc(8);
                                            zzaeoVar.zzc(8);
                                            zzaeoVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzaeoVar.zzb(6);
                                int i26 = iZzb9 + 1;
                                zzaeq[] zzaeqVarArr = new zzaeq[i26];
                                for (int i27 = 0; i27 < i26; i27++) {
                                    zzaeqVarArr[i27] = new zzaeq(zzaeoVar.zza(), zzaeoVar.zzb(16), zzaeoVar.zzb(16), zzaeoVar.zzb(8));
                                }
                                if (!zzaeoVar.zza()) {
                                    throw zzat.zzb("framing bit after modes not set as expected", null);
                                }
                                zzajxVar = new zzajx(zzaerVar, zzaepVar, bArr, zzaeqVarArr, zzaes.zza(iZzb9));
                                break;
                            }
                            int iZzb10 = zzaeoVar.zzb(i9);
                            if (iZzb10 == 0) {
                                int i28 = 8;
                                zzaeoVar.zzc(8);
                                zzaeoVar.zzc(16);
                                zzaeoVar.zzc(16);
                                zzaeoVar.zzc(6);
                                zzaeoVar.zzc(8);
                                int iZzb11 = zzaeoVar.zzb(4) + 1;
                                int i29 = 0;
                                while (i29 < iZzb11) {
                                    zzaeoVar.zzc(i28);
                                    i29++;
                                    i28 = 8;
                                }
                            } else {
                                if (iZzb10 != i10) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb10).length() + 41);
                                    sb2.append("floor type greater than 1 not decodable: ");
                                    sb2.append(iZzb10);
                                    throw zzat.zzb(sb2.toString(), null);
                                }
                                int iZzb12 = zzaeoVar.zzb(5);
                                int[] iArr3 = new int[iZzb12];
                                int i30 = -1;
                                for (int i31 = 0; i31 < iZzb12; i31++) {
                                    int iZzb13 = zzaeoVar.zzb(4);
                                    iArr3[i31] = iZzb13;
                                    if (iZzb13 > i30) {
                                        i30 = iZzb13;
                                    }
                                }
                                int i32 = i30 + 1;
                                int[] iArr4 = new int[i32];
                                int i33 = 0;
                                while (i33 < i32) {
                                    int i34 = 1;
                                    iArr4[i33] = zzaeoVar.zzb(i14) + 1;
                                    int iZzb14 = zzaeoVar.zzb(2);
                                    if (iZzb14 > 0) {
                                        i2 = 8;
                                        zzaeoVar.zzc(8);
                                    } else {
                                        i2 = 8;
                                    }
                                    int i35 = i32;
                                    int i36 = 0;
                                    while (true) {
                                        int i37 = i34 << iZzb14;
                                        iArr = iArr3;
                                        if (i36 < i37) {
                                            zzaeoVar.zzc(i2);
                                            i36++;
                                            iArr3 = iArr;
                                            i2 = 8;
                                            i34 = 1;
                                        }
                                    }
                                    i33++;
                                    iArr3 = iArr;
                                    i32 = i35;
                                    i14 = 3;
                                }
                                int[] iArr5 = iArr3;
                                zzaeoVar.zzc(2);
                                int iZzb15 = zzaeoVar.zzb(4);
                                int i38 = 0;
                                int i39 = 0;
                                for (int i40 = 0; i40 < iZzb12; i40++) {
                                    i38 += iArr4[iArr5[i40]];
                                    while (i39 < i38) {
                                        zzaeoVar.zzc(iZzb15);
                                        i39++;
                                    }
                                }
                            }
                            i13++;
                            i11 = 6;
                            i9 = 16;
                            i10 = 1;
                        }
                    } else {
                        if (zzaeoVar.zzb(24) != 5653314) {
                            int iZzd = zzaeoVar.zzd();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(iZzd).length() + 55);
                            sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb3.append(iZzd);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int iZzb16 = zzaeoVar.zzb(16);
                        int iZzb17 = zzaeoVar.zzb(24);
                        if (zzaeoVar.zza()) {
                            zzaeoVar.zzc(i6);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzaeoVar.zzb(zzaes.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZza = zzaeoVar.zza();
                            for (int i41 = 0; i41 < iZzb17; i41++) {
                                if (!zZza) {
                                    zzaeoVar.zzc(i6);
                                } else if (zzaeoVar.zza()) {
                                    zzaeoVar.zzc(i6);
                                }
                            }
                        }
                        int i42 = i4;
                        int iZzb19 = zzaeoVar.zzb(i42);
                        if (iZzb19 > 2) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(iZzb19).length() + 42);
                            sb4.append("lookup type greater than 2 not decodable: ");
                            sb4.append(iZzb19);
                            throw zzat.zzb(sb4.toString(), null);
                        }
                        if (iZzb19 != i3) {
                            if (iZzb19 != 2) {
                                i3 = i3;
                            }
                            i7++;
                            i3 = i3;
                            i4 = 4;
                            i6 = 5;
                        } else {
                            i8 = iZzb19;
                        }
                        zzaeoVar.zzc(32);
                        zzaeoVar.zzc(32);
                        int iZzb20 = zzaeoVar.zzb(i42) + i3;
                        zzaeoVar.zzc(i3);
                        zzaeoVar.zzc((int) ((i8 == i3 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i7++;
                        i3 = i3;
                        i4 = 4;
                        i6 = 5;
                    }
                }
            }
            this.zza = zzajxVar;
            if (zzajxVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzaer zzaerVar2 = zzajxVar.zza;
            arrayList.add(zzaerVar2.zzg);
            arrayList.add(zzajxVar.zzc);
            zzap zzapVarZzc = zzaes.zzc(zzgpe.zzr(zzajxVar.zzb.zza));
            zzt zztVar = new zzt();
            zztVar.zzl("audio/ogg");
            zztVar.zzm("audio/vorbis");
            zztVar.zzh(zzaerVar2.zzd);
            zztVar.zzi(zzaerVar2.zzc);
            zztVar.zzE(zzaerVar2.zza);
            zztVar.zzF(zzaerVar2.zzb);
            zztVar.zzp(arrayList);
            zztVar.zzk(zzapVarZzc);
            zzajuVar.zza = zztVar.zzM();
            return true;
        }
        zzaes.zzd(1, zzegVar, false);
        int iZzI = zzegVar.zzI();
        int iZzs2 = zzegVar.zzs();
        int iZzI2 = zzegVar.zzI();
        int iZzC = zzegVar.zzC();
        int i43 = iZzC <= 0 ? -1 : iZzC;
        int iZzC2 = zzegVar.zzC();
        int i44 = iZzC2 <= 0 ? -1 : iZzC2;
        int iZzC3 = zzegVar.zzC();
        int i45 = iZzC3 <= 0 ? -1 : iZzC3;
        int iZzs3 = zzegVar.zzs();
        this.zzd = new zzaer(iZzI, iZzs2, iZzI2, i43, i44, i45, (int) Math.pow(2.0d, iZzs3 & 15), (int) Math.pow(2.0d, (iZzs3 & 240) >> 4), 1 == (zzegVar.zzs() & 1), Arrays.copyOf(zzegVar.zzi(), zzegVar.zze()));
        zzajxVar = null;
        this.zza = zzajxVar;
        if (zzajxVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzaer zzaerVar3 = zzajxVar.zza;
        arrayList2.add(zzaerVar3.zzg);
        arrayList2.add(zzajxVar.zzc);
        zzap zzapVarZzc2 = zzaes.zzc(zzgpe.zzr(zzajxVar.zzb.zza));
        zzt zztVar2 = new zzt();
        zztVar2.zzl("audio/ogg");
        zztVar2.zzm("audio/vorbis");
        zztVar2.zzh(zzaerVar3.zzd);
        zztVar2.zzi(zzaerVar3.zzc);
        zztVar2.zzE(zzaerVar3.zza);
        zztVar2.zzF(zzaerVar3.zzb);
        zztVar2.zzp(arrayList2);
        zztVar2.zzk(zzapVarZzc2);
        zzajuVar.zza = zztVar2.zzM();
        return true;
    }
}
