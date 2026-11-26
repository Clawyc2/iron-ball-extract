package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzle {
    final String zza;
    long zzb;

    private zzle(zzlf zzlfVar, String str) {
        this.zza = str;
        this.zzb = zzlfVar.zzav().elapsedRealtime();
    }
}
