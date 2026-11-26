package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgn implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgw zzb;

    zzgn(zzgw zzgwVar, zzq zzqVar) {
        this.zzb = zzgwVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzA();
        zzlf zzlfVar = this.zzb.zza;
        zzq zzqVar = this.zza;
        zzlfVar.zzaz().zzg();
        zzlfVar.zzB();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzlfVar.zzd(zzqVar);
    }
}
