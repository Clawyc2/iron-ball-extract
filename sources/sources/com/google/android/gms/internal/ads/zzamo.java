package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamo implements zzamq {
    private final zzeg zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzaem zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = -9223372036854775807L;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = "video/mp2t";

    public zzamo(String str, int i, int i2, String str2) {
        this.zza = new zzeg(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    private final boolean zzf(zzeg zzegVar, byte[] bArr, int i) {
        int iMin = Math.min(zzegVar.zzd(), i - this.zzi);
        zzegVar.zzm(bArr, this.zzi, iMin);
        int i2 = this.zzi + iMin;
        this.zzi = i2;
        return i2 == i;
    }

    @RequiresNonNull({"output"})
    private final void zzg(zzacy zzacyVar) {
        int i;
        int i2 = zzacyVar.zzb;
        if (i2 == -2147483647 || (i = zzacyVar.zzc) == -1) {
            return;
        }
        zzv zzvVar = this.zzl;
        if (zzvVar != null && i == zzvVar.zzG && i2 == zzvVar.zzH && Objects.equals(zzacyVar.zza, zzvVar.zzo)) {
            return;
        }
        zzv zzvVar2 = this.zzl;
        zzt zztVar = zzvVar2 == null ? new zzt() : zzvVar2.zza();
        zztVar.zza(this.zzf);
        zztVar.zzl(this.zze);
        zztVar.zzm(zzacyVar.zza);
        zztVar.zzE(i);
        zztVar.zzF(i2);
        zztVar.zze(this.zzc);
        zztVar.zzg(this.zzd);
        zzv zzvVarZzM = zztVar.zzM();
        this.zzl = zzvVarZzM;
        this.zzg.zzu(zzvVarZzM);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = -9223372036854775807L;
        this.zzb.set(0);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzf = zzaoeVar.zzc();
        this.zzg = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) throws zzat {
        int i;
        byte b;
        int i2;
        byte b2;
        this.zzg.getClass();
        while (zzegVar.zzd() > 0) {
            int i3 = this.zzh;
            if (i3 == 0) {
                while (zzegVar.zzd() > 0) {
                    int i4 = this.zzj << 8;
                    this.zzj = i4;
                    int iZzs = i4 | zzegVar.zzs();
                    this.zzj = iZzs;
                    int iZza = zzacz.zza(iZzs);
                    this.zzn = iZza;
                    if (iZza != 0) {
                        byte[] bArrZzi = this.zza.zzi();
                        int i5 = this.zzj;
                        bArrZzi[0] = (byte) ((i5 >> 24) & 255);
                        bArrZzi[1] = (byte) ((i5 >> 16) & 255);
                        bArrZzi[2] = (byte) ((i5 >> 8) & 255);
                        bArrZzi[3] = (byte) (i5 & 255);
                        this.zzi = 4;
                        this.zzj = 0;
                        if (iZza != 3 && iZza != 4) {
                            if (iZza != 1) {
                                this.zzh = 2;
                                break;
                            } else {
                                this.zzh = 1;
                                break;
                            }
                        }
                        this.zzh = 4;
                        break;
                    }
                }
            } else if (i3 == 1) {
                zzeg zzegVar2 = this.zza;
                if (zzf(zzegVar, zzegVar2.zzi(), 18)) {
                    byte[] bArrZzi2 = zzegVar2.zzi();
                    if (this.zzl == null) {
                        zzv zzvVarZzb = zzacz.zzb(bArrZzi2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzvVarZzb;
                        this.zzg.zzu(zzvVarZzb);
                    }
                    this.zzm = zzacz.zzc(bArrZzi2);
                    byte b3 = bArrZzi2[0];
                    if (b3 != -2) {
                        if (b3 == -1) {
                            i = (bArrZzi2[4] & 7) << 4;
                            b2 = bArrZzi2[7];
                        } else if (b3 != 31) {
                            i = (bArrZzi2[4] & 1) << 6;
                            b = bArrZzi2[5];
                        } else {
                            i = (bArrZzi2[5] & 7) << 4;
                            b2 = bArrZzi2[6];
                        }
                        i2 = b2 & 60;
                        this.zzk = zzgst.zza(zzep.zzr(((i | (i2 >> 2)) + 1) * 32, this.zzl.zzH));
                        zzegVar2.zzh(0);
                        this.zzg.zzz(zzegVar2, 18);
                        this.zzh = 6;
                    } else {
                        i = (bArrZzi2[5] & 1) << 6;
                        b = bArrZzi2[4];
                    }
                    i2 = b & 252;
                    this.zzk = zzgst.zza(zzep.zzr(((i | (i2 >> 2)) + 1) * 32, this.zzl.zzH));
                    zzegVar2.zzh(0);
                    this.zzg.zzz(zzegVar2, 18);
                    this.zzh = 6;
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    zzeg zzegVar3 = this.zza;
                    if (zzf(zzegVar, zzegVar3.zzi(), this.zzo)) {
                        zzacy zzacyVarZzd = zzacz.zzd(zzegVar3.zzi());
                        zzg(zzacyVarZzd);
                        this.zzm = zzacyVarZzd.zzd;
                        long j = zzacyVarZzd.zze;
                        this.zzk = j != -9223372036854775807L ? j : 0L;
                        zzegVar3.zzh(0);
                        this.zzg.zzz(zzegVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i3 == 4) {
                    zzeg zzegVar4 = this.zza;
                    if (zzf(zzegVar, zzegVar4.zzi(), 6)) {
                        int iZzg = zzacz.zzg(zzegVar4.zzi());
                        this.zzp = iZzg;
                        int i6 = this.zzi;
                        if (i6 > iZzg) {
                            int i7 = i6 - iZzg;
                            this.zzi = i6 - i7;
                            zzegVar.zzh(zzegVar.zzg() - i7);
                        }
                        this.zzh = 5;
                    }
                } else if (i3 != 5) {
                    int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                    this.zzg.zzz(zzegVar, iMin);
                    int i8 = this.zzi + iMin;
                    this.zzi = i8;
                    if (i8 == this.zzm) {
                        zzgmd.zzh(this.zzq != -9223372036854775807L);
                        this.zzg.zzx(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzeg zzegVar5 = this.zza;
                    if (zzf(zzegVar, zzegVar5.zzi(), this.zzp)) {
                        zzacy zzacyVarZzf = zzacz.zzf(zzegVar5.zzi(), this.zzb);
                        if (this.zzn == 3) {
                            zzg(zzacyVarZzf);
                        }
                        this.zzm = zzacyVarZzf.zzd;
                        long j2 = zzacyVarZzf.zze;
                        this.zzk = j2 != -9223372036854775807L ? j2 : 0L;
                        zzegVar5.zzh(0);
                        this.zzg.zzz(zzegVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzeg zzegVar6 = this.zza;
                if (zzf(zzegVar, zzegVar6.zzi(), 7)) {
                    this.zzo = zzacz.zze(zzegVar6.zzi());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
