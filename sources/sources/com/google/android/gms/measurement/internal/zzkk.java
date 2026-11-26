package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkk {
    final /* synthetic */ zzko zza;
    private zzkj zzb;

    zzkk(zzko zzkoVar) {
        this.zza = zzkoVar;
    }

    final void zza(long j) {
        this.zzb = new zzkj(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        this.zza.zzd.postDelayed(this.zzb, 2000L);
    }

    final void zzb() {
        this.zza.zzg();
        zzkj zzkjVar = this.zzb;
        if (zzkjVar != null) {
            this.zza.zzd.removeCallbacks(zzkjVar);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
