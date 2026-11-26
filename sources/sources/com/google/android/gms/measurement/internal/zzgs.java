package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgs implements Runnable {
    final /* synthetic */ zzli zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgw zzc;

    zzgs(zzgw zzgwVar, zzli zzliVar, zzq zzqVar) {
        this.zzc = zzgwVar;
        this.zza = zzliVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzP(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzW(this.zza, this.zzb);
        }
    }
}
