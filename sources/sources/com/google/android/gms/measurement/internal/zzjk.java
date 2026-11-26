package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjk extends zzap {
    final /* synthetic */ zzjy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzjk(zzjy zzjyVar, zzgz zzgzVar) {
        super(zzgzVar);
        this.zza = zzjyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        this.zza.zzs.zzay().zzk().zza("Tasks have been queued for a long time");
    }
}
