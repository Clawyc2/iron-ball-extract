package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzxb {
    private final zzdc zza = zzdc.zza;

    protected final zzxc zza(zzbg zzbgVar, int[] iArr, int i, zzza zzzaVar, zzgpe zzgpeVar) {
        return new zzxc(zzbgVar, iArr, 0, zzzaVar, WorkRequest.MIN_BACKOFF_MILLIS, 25000L, 25000L, 1279, 719, 0.7f, 0.75f, zzgpeVar, this.zza);
    }
}
