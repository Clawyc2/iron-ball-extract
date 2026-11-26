package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkl extends zzap {
    final /* synthetic */ zzkm zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkl(zzkm zzkmVar, zzgz zzgzVar) {
        super(zzgzVar);
        this.zza = zzkmVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzkm zzkmVar = this.zza;
        zzkmVar.zzc.zzg();
        zzkmVar.zzd(false, false, zzkmVar.zzc.zzs.zzav().elapsedRealtime());
        zzkmVar.zzc.zzs.zzd().zzf(zzkmVar.zzc.zzs.zzav().elapsedRealtime());
    }
}
