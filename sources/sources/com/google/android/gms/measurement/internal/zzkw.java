package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkw implements zzew {
    final /* synthetic */ String zza;
    final /* synthetic */ zzlf zzb;

    zzkw(zzlf zzlfVar, String str) {
        this.zzb = zzlfVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzew
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzb.zzK(i, th, bArr, this.zza);
    }
}
