package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgmm implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzgms zzb;

    zzgmm(zzgms zzgmsVar, CharSequence charSequence) {
        this.zza = charSequence;
        Objects.requireNonNull(zzgmsVar);
        this.zzb = zzgmsVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zzb.zzf(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        zzglx.zzb(sb, this, ", ");
        sb.append(']');
        return sb.toString();
    }
}
