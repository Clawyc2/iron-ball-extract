package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjd implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzjy zzc;

    zzjd(zzjy zzjyVar, AtomicReference atomicReference, zzq zzqVar) {
        this.zzc = zzjyVar;
        this.zza = atomicReference;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.zza) {
            try {
                try {
                    if (this.zzc.zzs.zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                        zzjy zzjyVar = this.zzc;
                        zzek zzekVar = zzjyVar.zzb;
                        if (zzekVar != null) {
                            Preconditions.checkNotNull(this.zzb);
                            this.zza.set(zzekVar.zzd(this.zzb));
                            String str = (String) this.zza.get();
                            if (str != null) {
                                this.zzc.zzs.zzq().zzO(str);
                                this.zzc.zzs.zzm().zze.zzb(str);
                            }
                            this.zzc.zzQ();
                            atomicReference = this.zza;
                            atomicReference.notify();
                            return;
                        }
                        zzjyVar.zzs.zzay().zzd().zza("Failed to get app instance id");
                        this.zza.notify();
                    } else {
                        this.zzc.zzs.zzay().zzl().zza("Analytics storage consent denied; will not get app instance id");
                        this.zzc.zzs.zzq().zzO(null);
                        this.zzc.zzs.zzm().zze.zzb(null);
                        this.zza.set(null);
                        this.zza.notify();
                    }
                } catch (RemoteException e) {
                    this.zzc.zzs.zzay().zzd().zzb("Failed to get app instance id", e);
                    atomicReference = this.zza;
                }
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
