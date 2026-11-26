package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkd implements Runnable {
    final /* synthetic */ zzlf zza;
    final /* synthetic */ Runnable zzb;

    zzkd(zzkf zzkfVar, zzlf zzlfVar, Runnable runnable) {
        this.zza = zzlfVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzA();
        this.zza.zzz(this.zzb);
        this.zza.zzX();
    }
}
