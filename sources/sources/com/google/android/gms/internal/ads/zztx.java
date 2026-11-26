package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zztx implements zzwk {
    public final zzwk zza;
    final /* synthetic */ zzty zzb;
    private boolean zzc;

    public zztx(zzty zztyVar, zzwk zzwkVar) {
        Objects.requireNonNull(zztyVar);
        this.zzb = zztyVar;
        this.zza = zzwkVar;
    }

    public final void zza() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzb() {
        return !this.zzb.zzo() && this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zzd(zzkj zzkjVar, zzhh zzhhVar, int i) {
        zzty zztyVar = this.zzb;
        if (zztyVar.zzo()) {
            return -3;
        }
        if (this.zzc) {
            zzhhVar.zzg(4);
            return -4;
        }
        long jZzi = zztyVar.zzi();
        int iZzd = this.zza.zzd(zzkjVar, zzhhVar, i);
        if (iZzd != -5) {
            long j = zztyVar.zzb;
            if (j == Long.MIN_VALUE || ((iZzd != -4 || zzhhVar.zze < j) && !(iZzd == -3 && jZzi == Long.MIN_VALUE && !zzhhVar.zzd))) {
                return iZzd;
            }
            zzhhVar.zza();
            zzhhVar.zzg(4);
            this.zzc = true;
            return -4;
        }
        zzv zzvVar = zzkjVar.zzb;
        zzvVar.getClass();
        int i2 = zzvVar.zzJ;
        if (i2 != 0) {
            int i3 = zztyVar.zzb == Long.MIN_VALUE ? zzvVar.zzK : 0;
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzH(i2);
            zztVarZza.zzI(i3);
            zzkjVar.zzb = zztVarZza.zzM();
        } else if (zzvVar.zzK != 0) {
            i2 = 0;
            if (zztyVar.zzb == Long.MIN_VALUE) {
            }
            zzt zztVarZza2 = zzvVar.zza();
            zztVarZza2.zzH(i2);
            zztVarZza2.zzI(i3);
            zzkjVar.zzb = zztVarZza2.zzM();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zze(long j) {
        if (this.zzb.zzo()) {
            return -3;
        }
        return this.zza.zze(j);
    }
}
