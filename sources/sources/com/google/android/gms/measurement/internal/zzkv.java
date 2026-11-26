package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkv implements Runnable {
    final /* synthetic */ zzlg zza;
    final /* synthetic */ zzlf zzb;

    zzkv(zzlf zzlfVar, zzlg zzlgVar) {
        this.zzb = zzlfVar;
        this.zza = zzlgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlf.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
