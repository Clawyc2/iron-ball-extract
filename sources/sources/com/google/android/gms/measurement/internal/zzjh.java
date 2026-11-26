package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjh implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzjy zzc;

    zzjh(zzjy zzjyVar, zzq zzqVar, Bundle bundle) {
        this.zzc = zzjyVar;
        this.zza = zzqVar;
        this.zzb = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjy zzjyVar = this.zzc;
        zzek zzekVar = zzjyVar.zzb;
        if (zzekVar == null) {
            zzjyVar.zzs.zzay().zzd().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzekVar.zzr(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzs.zzay().zzd().zzb("Failed to send default event parameters to service", e);
        }
    }
}
