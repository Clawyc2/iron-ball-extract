package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamm implements zzamq {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzaem zzi;
    private zzaem zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzaem zzw;
    private long zzx;
    private final zzef zzc = new zzef(new byte[7], 7);
    private final zzeg zzd = new zzeg(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = -9223372036854775807L;
    private long zzv = -9223372036854775807L;

    public zzamm(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzi();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzi();
    }

    private final boolean zzh(zzeg zzegVar, byte[] bArr, int i) {
        int iMin = Math.min(zzegVar.zzd(), i - this.zzl);
        zzegVar.zzm(bArr, this.zzl, iMin);
        int i2 = this.zzl + iMin;
        this.zzl = i2;
        return i2 == i;
    }

    private final void zzi() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzj(zzaem zzaemVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzaemVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final void zzk() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzeg zzegVar, byte[] bArr, int i) {
        if (zzegVar.zzd() < i) {
            return false;
        }
        zzegVar.zzm(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzv = -9223372036854775807L;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzh = zzaoeVar.zzc();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 1);
        this.zzi = zzaemVarZzu;
        this.zzw = zzaemVarZzu;
        if (!this.zzb) {
            this.zzj = new zzacx();
            return;
        }
        zzaoeVar.zza();
        zzaem zzaemVarZzu2 = zzaddVar.zzu(zzaoeVar.zzb(), 5);
        this.zzj = zzaemVarZzu2;
        zzt zztVar = new zzt();
        zztVar.zza(zzaoeVar.zzc());
        zztVar.zzl(this.zzg);
        zztVar.zzm("application/id3");
        zzaemVarZzu2.zzu(zztVar.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzv = j;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x0201  */
    /* JADX WARN: Code duplicated, block: B:73:0x020f  */
    /* JADX WARN: Code duplicated, block: B:75:0x021a  */
    /* JADX WARN: Code duplicated, block: B:77:0x021e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0222  */
    /* JADX WARN: Code duplicated, block: B:84:0x0231  */
    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) throws zzat {
        int i;
        boolean z;
        int i2;
        int iZzj;
        byte[] bArrZzi;
        int iZze;
        int i3;
        byte b;
        int i4;
        int i5;
        int i6;
        byte b2;
        this.zzi.getClass();
        String str = zzep.zza;
        while (zzegVar.zzd() > 0) {
            int i7 = this.zzk;
            char c = 7;
            int i8 = 3;
            int i9 = 2;
            if (i7 == 0) {
                byte[] bArrZzi2 = zzegVar.zzi();
                int iZzg = zzegVar.zzg();
                int iZze2 = zzegVar.zze();
                while (true) {
                    if (iZzg < iZze2) {
                        int i10 = iZzg + 1;
                        byte b3 = bArrZzi2[iZzg];
                        int i11 = b3 & 255;
                        int i12 = i8;
                        if (this.zzm == 512 && zzl((byte) -1, (byte) i11)) {
                            if (!this.zzo) {
                                int i13 = iZzg - 1;
                                zzegVar.zzh(iZzg);
                                zzef zzefVar = this.zzc;
                                if (zzm(zzegVar, zzefVar.zza, 1)) {
                                    zzefVar.zzf(4);
                                    int iZzj2 = zzefVar.zzj(1);
                                    int i14 = this.zzp;
                                    if (i14 != -1 && iZzj2 != i14) {
                                        c = 7;
                                    } else if (this.zzq == -1) {
                                        if (zzm(zzegVar, zzefVar.zza, 4)) {
                                            zzefVar.zzf(14);
                                            iZzj = zzefVar.zzj(13);
                                            c = 7;
                                            if (iZzj >= 7) {
                                                bArrZzi = zzegVar.zzi();
                                                iZze = zzegVar.zze();
                                                i3 = i13 + iZzj;
                                                if (i3 >= iZze) {
                                                    b = bArrZzi[i3];
                                                    if (b == -1) {
                                                        i6 = i3 + 1;
                                                        if (i6 != iZze) {
                                                            b2 = bArrZzi[i6];
                                                            if (zzl((byte) -1, b2) || ((b2 & 8) >> 3) != iZzj2) {
                                                            }
                                                        }
                                                    } else if (b == 73 || ((i4 = i3 + 1) != iZze && (bArrZzi[i4] != 68 || ((i5 = i3 + 2) != iZze && bArrZzi[i5] != 51)))) {
                                                    }
                                                }
                                            }
                                        }
                                    } else if (zzm(zzegVar, zzefVar.zza, 1)) {
                                        zzefVar.zzf(i9);
                                        if (zzefVar.zzj(4) == this.zzq) {
                                            zzegVar.zzh(iZzg + 1);
                                            if (zzm(zzegVar, zzefVar.zza, 4)) {
                                                zzefVar.zzf(14);
                                                iZzj = zzefVar.zzj(13);
                                                c = 7;
                                                if (iZzj >= 7) {
                                                    bArrZzi = zzegVar.zzi();
                                                    iZze = zzegVar.zze();
                                                    i3 = i13 + iZzj;
                                                    if (i3 >= iZze) {
                                                        b = bArrZzi[i3];
                                                        if (b == -1) {
                                                            i6 = i3 + 1;
                                                            if (i6 != iZze) {
                                                                b2 = bArrZzi[i6];
                                                                if (zzl((byte) -1, b2)) {
                                                                }
                                                            }
                                                        } else if (b == 73) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            c = 7;
                                        }
                                    }
                                } else {
                                    c = 7;
                                }
                            }
                            this.zzr = (b3 & 8) >> 3;
                            this.zzn = 1 == ((b3 & 1) ^ 1);
                            if (this.zzo) {
                                zzk();
                            } else {
                                this.zzk = 1;
                                this.zzl = 0;
                            }
                            zzegVar.zzh(i10);
                        } else {
                            c = c;
                        }
                        int i15 = this.zzm;
                        int i16 = i15 | i11;
                        if (i16 == 329) {
                            i = 2;
                            z = false;
                            i2 = 768;
                        } else if (i16 == 511) {
                            i = 2;
                            z = false;
                            i2 = 512;
                        } else if (i16 == 836) {
                            i = 2;
                            z = false;
                            i2 = 1024;
                        } else if (i16 == 1075) {
                            this.zzk = 2;
                            this.zzl = i12;
                            this.zzu = 0;
                            this.zzd.zzh(0);
                            zzegVar.zzh(i10);
                        } else if (i15 != 256) {
                            this.zzm = 256;
                            i8 = i12;
                            i9 = 2;
                        } else {
                            i12 = i12;
                            i = 2;
                            z = false;
                            iZzg = i10;
                            i8 = i12;
                            i9 = i;
                        }
                        this.zzm = i2;
                        iZzg = i10;
                        i8 = i12;
                        i9 = i;
                    } else {
                        zzegVar.zzh(iZzg);
                    }
                }
            } else if (i7 != 1) {
                if (i7 == 2) {
                    zzeg zzegVar2 = this.zzd;
                    if (zzh(zzegVar, zzegVar2.zzi(), 10)) {
                        this.zzj.zzz(zzegVar2, 10);
                        zzegVar2.zzh(6);
                        zzj(this.zzj, 0L, 10, zzegVar2.zzG() + 10);
                    }
                } else if (i7 != 3) {
                    int iMin = Math.min(zzegVar.zzd(), this.zzu - this.zzl);
                    this.zzw.zzz(zzegVar, iMin);
                    int i17 = this.zzl + iMin;
                    this.zzl = i17;
                    if (i17 == this.zzu) {
                        zzgmd.zzh(this.zzv != -9223372036854775807L);
                        this.zzw.zzx(this.zzv, 1, this.zzu, 0, null);
                        this.zzv += this.zzx;
                        zzi();
                    }
                } else {
                    int i18 = true != this.zzn ? 5 : 7;
                    zzef zzefVar2 = this.zzc;
                    if (zzh(zzegVar, zzefVar2.zza, i18)) {
                        zzefVar2.zzf(0);
                        if (this.zzs) {
                            zzefVar2.zzh(10);
                        } else {
                            int iZzj3 = zzefVar2.zzj(2) + 1;
                            if (iZzj3 != 2) {
                                StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 50);
                                sb.append("Detected audio object type: ");
                                sb.append(iZzj3);
                                sb.append(", but assuming AAC LC.");
                                zzdt.zzc("AdtsReader", sb.toString());
                            }
                            zzefVar2.zzh(5);
                            int iZzj4 = zzefVar2.zzj(3);
                            int i19 = this.zzq;
                            int i20 = zzabz.zza;
                            byte[] bArr = {(byte) (((i19 >> 1) & 7) | 16), (byte) (((iZzj4 << 3) & 120) | ((i19 << 7) & 128))};
                            zzaby zzabyVarZza = zzabz.zza(bArr);
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzh);
                            zztVar.zzl(this.zzg);
                            zztVar.zzm("audio/mp4a-latm");
                            zztVar.zzj(zzabyVarZza.zzc);
                            zztVar.zzE(zzabyVarZza.zzb);
                            zztVar.zzF(zzabyVarZza.zza);
                            zztVar.zzp(Collections.singletonList(bArr));
                            zztVar.zze(this.zze);
                            zztVar.zzg(this.zzf);
                            zzv zzvVarZzM = zztVar.zzM();
                            this.zzt = 1024000000 / ((long) zzvVarZzM.zzH);
                            this.zzi.zzu(zzvVarZzM);
                            this.zzs = true;
                        }
                        zzefVar2.zzh(4);
                        int iZzj5 = zzefVar2.zzj(13);
                        int i21 = iZzj5 - 7;
                        if (this.zzn) {
                            i21 = iZzj5 - 9;
                        }
                        zzj(this.zzi, this.zzt, 0, i21);
                    }
                }
            } else if (zzegVar.zzd() != 0) {
                zzef zzefVar3 = this.zzc;
                zzefVar3.zza[0] = zzegVar.zzi()[zzegVar.zzg()];
                zzefVar3.zzf(2);
                int iZzj6 = zzefVar3.zzj(4);
                int i22 = this.zzq;
                if (i22 == -1 || iZzj6 == i22) {
                    if (!this.zzo) {
                        this.zzo = true;
                        this.zzp = this.zzr;
                        this.zzq = iZzj6;
                    }
                    zzk();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
