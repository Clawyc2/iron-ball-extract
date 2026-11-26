package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfb implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzfc zzb;

    zzfb(zzfc zzfcVar, boolean z) {
        this.zzb = zzfcVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzJ(this.zza);
    }
}
