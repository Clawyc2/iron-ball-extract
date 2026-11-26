package com.google.android.gms.measurement.internal;

import androidx.collection.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfs extends LruCache {
    final /* synthetic */ zzfv zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfs(zzfv zzfvVar, int i) {
        super(20);
        this.zza = zzfvVar;
    }

    @Override // androidx.collection.LruCache
    protected final /* bridge */ /* synthetic */ Object create(Object obj) {
        String str = (String) obj;
        Preconditions.checkNotEmpty(str);
        return zzfv.zzd(this.zza, str);
    }
}
