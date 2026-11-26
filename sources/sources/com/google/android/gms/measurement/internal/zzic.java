package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzic implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzij zzb;

    zzic(zzij zzijVar, Boolean bool) {
        this.zzb = zzijVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzaa(this.zza, true);
    }
}
