package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgh implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzgw zzb;

    zzgh(zzgw zzgwVar, zzac zzacVar) {
        this.zzb = zzgwVar;
        this.zza = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzN(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
