package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjf implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzjy zzb;

    zzjf(zzjy zzjyVar, zzq zzqVar) {
        this.zzb = zzjyVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjy zzjyVar = this.zzb;
        zzek zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzekVar.zzj(this.zza);
            this.zzb.zzs.zzi().zzm();
            this.zzb.zzD(zzekVar, null, this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send app launch to the service", e);
        }
    }
}
