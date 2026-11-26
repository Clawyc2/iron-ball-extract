package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzko zzb;

    zzkh(zzko zzkoVar, long j) {
        this.zzb = zzkoVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzko.zzj(this.zzb, this.zza);
    }
}
