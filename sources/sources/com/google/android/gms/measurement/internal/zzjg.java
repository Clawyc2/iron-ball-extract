package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjg implements Runnable {
    final /* synthetic */ zziq zza;
    final /* synthetic */ zzjy zzb;

    zzjg(zzjy zzjyVar, zziq zziqVar) {
        this.zzb = zzjyVar;
        this.zza = zziqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjy zzjyVar = this.zzb;
        zzek zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zziq zziqVar = this.zza;
            if (zziqVar == null) {
                zzekVar.zzq(0L, null, null, zzjyVar.zzs.zzau().getPackageName());
            } else {
                zzekVar.zzq(zziqVar.zzc, zziqVar.zza, zziqVar.zzb, zzjyVar.zzs.zzau().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send current screen to the service", e);
        }
    }
}
