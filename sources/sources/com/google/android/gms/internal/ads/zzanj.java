package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzanj implements zzaof {
    private final zzamq zza;
    private final zzef zzb = new zzef(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzem zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzanj(zzamq zzamqVar) {
        this.zza = zzamqVar;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzeg zzegVar, byte[] bArr, int i) {
        int iMin = Math.min(zzegVar.zzd(), i - this.zzd);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            zzegVar.zzk(iMin);
        } else {
            zzegVar.zzm(bArr, this.zzd, iMin);
        }
        int i2 = this.zzd + iMin;
        this.zzd = i2;
        return i2 == i;
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
        this.zze = zzemVar;
        this.zza.zzb(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zzb() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaof
    public final void zzc(zzeg zzegVar, int i) throws zzat {
        int i2;
        int i3;
        long jZze;
        this.zze.getClass();
        int i4 = -1;
        int i5 = 2;
        if ((i & 1) != 0) {
            int i6 = this.zzc;
            if (i6 != 0 && i6 != 1) {
                if (i6 != 2) {
                    int i7 = this.zzj;
                    if (i7 != -1) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 48);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i7);
                        sb.append(" more bytes");
                        zzdt.zzc("PesReader", sb.toString());
                    }
                    this.zza.zze(zzegVar.zze() == 0);
                } else {
                    zzdt.zzc("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i8 = i;
        while (zzegVar.zzd() > 0) {
            int i9 = this.zzc;
            if (i9 == 0) {
                i2 = i5;
                zzegVar.zzk(zzegVar.zzd());
            } else if (i9 != 1) {
                if (i9 != i5) {
                    int iZzd = zzegVar.zzd();
                    int i10 = this.zzj;
                    int i11 = i10 == i4 ? 0 : iZzd - i10;
                    if (i11 > 0) {
                        iZzd -= i11;
                        zzegVar.zzf(zzegVar.zzg() + iZzd);
                    }
                    zzamq zzamqVar = this.zza;
                    zzamqVar.zzd(zzegVar);
                    int i12 = this.zzj;
                    if (i12 != i4) {
                        int i13 = i12 - iZzd;
                        this.zzj = i13;
                        if (i13 == 0) {
                            zzamqVar.zze(false);
                            zze(1);
                        }
                    }
                } else {
                    int iMin = Math.min(10, this.zzi);
                    zzef zzefVar = this.zzb;
                    if (zzf(zzegVar, zzefVar.zza, iMin) && zzf(zzegVar, null, this.zzi)) {
                        zzefVar.zzf(0);
                        if (this.zzf) {
                            zzefVar.zzh(4);
                            long jZzj = zzefVar.zzj(3);
                            zzefVar.zzh(1);
                            int iZzj = zzefVar.zzj(15) << 15;
                            zzefVar.zzh(1);
                            long jZzj2 = zzefVar.zzj(15);
                            zzefVar.zzh(1);
                            if (!this.zzh && this.zzg) {
                                zzefVar.zzh(4);
                                long jZzj3 = ((long) zzefVar.zzj(3)) << 30;
                                zzefVar.zzh(1);
                                int iZzj2 = zzefVar.zzj(15) << 15;
                                zzefVar.zzh(1);
                                long jZzj4 = zzefVar.zzj(15);
                                zzefVar.zzh(1);
                                this.zze.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                                this.zzh = true;
                            }
                            jZze = this.zze.zze(jZzj2 | (jZzj << 30) | ((long) iZzj));
                        } else {
                            jZze = -9223372036854775807L;
                        }
                        i8 |= true != this.zzk ? 0 : 4;
                        this.zza.zzc(jZze, i8);
                        zze(3);
                        i4 = -1;
                        i5 = 2;
                    }
                }
                i2 = i5;
            } else {
                zzef zzefVar2 = this.zzb;
                if (zzf(zzegVar, zzefVar2.zza, 9)) {
                    zzefVar2.zzf(0);
                    int iZzj3 = zzefVar2.zzj(24);
                    if (iZzj3 != 1) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj3).length() + 30);
                        sb2.append("Unexpected start code prefix: ");
                        sb2.append(iZzj3);
                        zzdt.zzc("PesReader", sb2.toString());
                        i4 = -1;
                        this.zzj = -1;
                        i3 = 0;
                        i2 = 2;
                    } else {
                        zzefVar2.zzh(8);
                        int iZzj4 = zzefVar2.zzj(16);
                        zzefVar2.zzh(5);
                        this.zzk = zzefVar2.zzi();
                        i2 = 2;
                        zzefVar2.zzh(2);
                        this.zzf = zzefVar2.zzi();
                        this.zzg = zzefVar2.zzi();
                        zzefVar2.zzh(6);
                        int iZzj5 = zzefVar2.zzj(8);
                        this.zzi = iZzj5;
                        if (iZzj4 == 0) {
                            this.zzj = -1;
                            i4 = -1;
                        } else {
                            int i14 = (iZzj4 - 3) - iZzj5;
                            this.zzj = i14;
                            if (i14 < 0) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(i14).length() + 36);
                                sb3.append("Found negative packet payload size: ");
                                sb3.append(i14);
                                zzdt.zzc("PesReader", sb3.toString());
                                i4 = -1;
                                this.zzj = -1;
                            } else {
                                i4 = -1;
                            }
                        }
                        i3 = 2;
                    }
                    zze(i3);
                } else {
                    i4 = -1;
                    i2 = 2;
                }
            }
            i5 = i2;
        }
    }

    public final boolean zzd(boolean z) {
        return this.zzc == 3 && this.zzj == -1;
    }
}
