package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjj implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zzc;
    final /* synthetic */ zzjy zzd;

    zzjj(zzjy zzjyVar, zzaw zzawVar, String str, com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        this.zzd = zzjyVar;
        this.zza = zzawVar;
        this.zzb = str;
        this.zzc = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzge zzgeVar;
        byte[] bArrZzu = null;
        try {
            try {
                zzjy zzjyVar = this.zzd;
                zzek zzekVar = zzjyVar.zzb;
                if (zzekVar == null) {
                    zzjyVar.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service to bundle");
                    zzgeVar = this.zzd.zzs;
                } else {
                    bArrZzu = zzekVar.zzu(this.zza, this.zzb);
                    this.zzd.zzQ();
                    zzgeVar = this.zzd.zzs;
                }
            } catch (RemoteException e) {
                this.zzd.zzs.zzay().zzd().zzb("Failed to send event to the service to bundle", e);
                zzgeVar = this.zzd.zzs;
            }
            zzln zzlnVarZzv = zzgeVar.zzv();
        } finally {
            this.zzd.zzs.zzv().zzS(this.zzc, bArrZzu);
        }
    }
}
