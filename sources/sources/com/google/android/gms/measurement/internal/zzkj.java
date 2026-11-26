package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkj implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzkk zzc;

    zzkj(zzkk zzkkVar, long j, long j2) {
        this.zzc = zzkkVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzki
            @Override // java.lang.Runnable
            public final void run() {
                zzkj zzkjVar = this.zza;
                zzkk zzkkVar = zzkjVar.zzc;
                long j = zzkjVar.zza;
                long j2 = zzkjVar.zzb;
                zzkkVar.zza.zzg();
                zzkkVar.zza.zzs.zzay().zzc().zza("Application going to the background");
                zzkkVar.zza.zzs.zzm().zzl.zza(true);
                Bundle bundle = new Bundle();
                if (!zzkkVar.zza.zzs.zzf().zzu()) {
                    zzkkVar.zza.zzb.zzb(j2);
                    zzkkVar.zza.zzb.zzd(false, false, j2);
                }
                zzkkVar.zza.zzs.zzq().zzH(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ab", j, bundle);
            }
        });
    }
}
