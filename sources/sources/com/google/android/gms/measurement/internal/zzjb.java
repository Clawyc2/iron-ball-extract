package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjb implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzjy zzd;

    zzjb(zzjy zzjyVar, AtomicReference atomicReference, zzq zzqVar, boolean z) {
        this.zzd = zzjyVar;
        this.zza = atomicReference;
        this.zzb = zzqVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                try {
                    zzjy zzjyVar = this.zzd;
                    zzek zzekVar = zzjyVar.zzb;
                    if (zzekVar == null) {
                        zzjyVar.zzs.zzay().zzd().zza("Failed to get all user properties; not connected to service");
                        this.zza.notify();
                        return;
                    }
                    Preconditions.checkNotNull(this.zzb);
                    this.zza.set(zzekVar.zze(this.zzb, this.zzc));
                    this.zzd.zzQ();
                    atomicReference = this.zza;
                    atomicReference.notify();
                } catch (RemoteException e) {
                    this.zzd.zzs.zzay().zzd().zzb("Failed to get all user properties; remote exception", e);
                    atomicReference = this.zza;
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
