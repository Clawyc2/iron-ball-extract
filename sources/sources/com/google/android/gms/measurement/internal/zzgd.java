package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgd implements Runnable {
    final /* synthetic */ zzhh zza;
    final /* synthetic */ zzge zzb;

    zzgd(zzge zzgeVar, zzhh zzhhVar) {
        this.zzb = zzgeVar;
        this.zza = zzhhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzge.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
