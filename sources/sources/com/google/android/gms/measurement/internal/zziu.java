package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zziu implements Runnable {
    final /* synthetic */ zziy zza;

    zziu(zziy zziyVar) {
        this.zza = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zziy zziyVar = this.zza;
        zziyVar.zza = zziyVar.zzh;
    }
}
