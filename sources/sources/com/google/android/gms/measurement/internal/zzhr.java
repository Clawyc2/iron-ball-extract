package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhr implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzij zzb;

    zzhr(zzij zzijVar, long j) {
        this.zzb = zzijVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzs.zzt().zzu(new AtomicReference());
    }
}
