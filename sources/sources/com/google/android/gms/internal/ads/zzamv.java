package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamv implements zzamq {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzaoi zzb;
    private zzamu zzg;
    private long zzh;
    private String zzi;
    private zzaem zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzamt zze = new zzamt(128);
    private long zzl = -9223372036854775807L;
    private final zzanh zzf = new zzanh(178, 128);
    private final zzeg zzc = new zzeg();

    zzamv(zzaoi zzaoiVar, String str) {
        this.zzb = zzaoiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        zzfm.zzi(this.zzd);
        this.zze.zza();
        zzamu zzamuVar = this.zzg;
        if (zzamuVar != null) {
            zzamuVar.zza();
        }
        this.zzf.zza();
        this.zzh = 0L;
        this.zzl = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzi = zzaoeVar.zzc();
        this.zzj = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        this.zzg = new zzamu(this.zzj);
        this.zzb.zza(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzl = j;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0111  */
    /* JADX WARN: Code duplicated, block: B:50:0x0187  */
    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        int i;
        int i2;
        this.zzg.getClass();
        this.zzj.getClass();
        int iZzg = zzegVar.zzg();
        int iZze = zzegVar.zze();
        byte[] bArrZzi = zzegVar.zzi();
        this.zzh += (long) zzegVar.zzd();
        this.zzj.zzz(zzegVar, zzegVar.zzd());
        while (true) {
            int iZzh = zzfm.zzh(bArrZzi, iZzg, iZze, this.zzd);
            if (iZzh == iZze) {
                break;
            }
            int i3 = iZzh + 3;
            int i4 = zzegVar.zzi()[i3] & 255;
            int i5 = iZzh - iZzg;
            if (!this.zzk) {
                if (i5 > 0) {
                    this.zze.zzc(bArrZzi, iZzg, iZzh);
                }
                int i6 = i5 < 0 ? -i5 : 0;
                zzamt zzamtVar = this.zze;
                if (zzamtVar.zzb(i4, i6)) {
                    zzaem zzaemVar = this.zzj;
                    int i7 = zzamtVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzamtVar.zzc, zzamtVar.zza);
                    zzef zzefVar = new zzef(bArrCopyOf, bArrCopyOf.length);
                    zzefVar.zzo(i7);
                    zzefVar.zzo(4);
                    zzefVar.zzg();
                    zzefVar.zzh(8);
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(4);
                        zzefVar.zzh(3);
                    }
                    int iZzj = zzefVar.zzj(4);
                    float f = 1.0f;
                    if (iZzj == 15) {
                        int iZzj2 = zzefVar.zzj(8);
                        int iZzj3 = zzefVar.zzj(8);
                        if (iZzj3 == 0) {
                            zzdt.zzc("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzj2 / iZzj3;
                        }
                    } else if (iZzj < 7) {
                        f = zza[iZzj];
                    } else {
                        zzdt.zzc("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzefVar.zzi()) {
                        zzefVar.zzh(2);
                        zzefVar.zzh(1);
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(15);
                            zzefVar.zzg();
                            zzefVar.zzh(15);
                            zzefVar.zzg();
                            zzefVar.zzh(15);
                            zzefVar.zzg();
                            zzefVar.zzh(3);
                            zzefVar.zzh(11);
                            zzefVar.zzg();
                            zzefVar.zzh(15);
                            zzefVar.zzg();
                            i2 = 2;
                        } else {
                            i2 = 2;
                        }
                    } else {
                        i2 = 2;
                    }
                    if (zzefVar.zzj(i2) != 0) {
                        zzdt.zzc("H263Reader", "Unhandled video object layer shape");
                    }
                    zzefVar.zzg();
                    int iZzj4 = zzefVar.zzj(16);
                    zzefVar.zzg();
                    if (zzefVar.zzi()) {
                        if (iZzj4 == 0) {
                            zzdt.zzc("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i8 = iZzj4 - 1;
                            int i9 = 0;
                            while (i8 > 0) {
                                i8 >>= 1;
                                i9++;
                            }
                            zzefVar.zzh(i9);
                        }
                    }
                    zzefVar.zzg();
                    int iZzj5 = zzefVar.zzj(13);
                    zzefVar.zzg();
                    int iZzj6 = zzefVar.zzj(13);
                    zzefVar.zzg();
                    zzefVar.zzg();
                    zzt zztVar = new zzt();
                    zztVar.zza(str);
                    zztVar.zzl("video/mp2t");
                    zztVar.zzm("video/mp4v-es");
                    zztVar.zzt(iZzj5);
                    zztVar.zzu(iZzj6);
                    zztVar.zzz(f2);
                    zztVar.zzp(Collections.singletonList(bArrCopyOf));
                    zzaemVar.zzu(zztVar.zzM());
                    this.zzk = true;
                }
            }
            this.zzg.zzc(bArrZzi, iZzg, iZzh);
            zzanh zzanhVar = this.zzf;
            if (i5 > 0) {
                zzanhVar.zzd(bArrZzi, iZzg, iZzh);
                i = 0;
            } else {
                i = -i5;
            }
            if (zzanhVar.zze(i)) {
                int iZza = zzfm.zza(zzanhVar.zza, zzanhVar.zzb);
                zzeg zzegVar2 = this.zzc;
                String str2 = zzep.zza;
                zzegVar2.zzb(zzanhVar.zza, iZza);
                this.zzb.zzb(this.zzl, zzegVar2);
            }
            if (i4 == 178) {
                if (zzegVar.zzi()[iZzh + 2] == 1) {
                    zzanhVar.zzc(178);
                }
                i4 = 178;
            }
            int i10 = iZze - iZzh;
            this.zzg.zzd(this.zzh - ((long) i10), i10, this.zzk);
            this.zzg.zzb(i4, this.zzl);
            iZzg = i3;
            iZze = iZze;
        }
        if (!this.zzk) {
            this.zze.zzc(bArrZzi, iZzg, iZze);
        }
        this.zzg.zzc(bArrZzi, iZzg, iZze);
        this.zzf.zzd(bArrZzi, iZzg, iZze);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
        zzamu zzamuVar = this.zzg;
        zzamuVar.getClass();
        if (z) {
            zzamuVar.zzd(this.zzh, 0, this.zzk);
            this.zzg.zza();
        }
    }
}
