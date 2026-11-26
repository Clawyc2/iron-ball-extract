package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzji extends zzap {
    final /* synthetic */ zzjy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzji(zzjy zzjyVar, zzgz zzgzVar) {
        super(zzgzVar);
        this.zza = zzjyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzjy zzjyVar = this.zza;
        zzjyVar.zzg();
        if (zzjyVar.zzL()) {
            zzjyVar.zzs.zzay().zzj().zza("Inactivity, disconnecting from the service");
            zzjyVar.zzs();
        }
    }
}
