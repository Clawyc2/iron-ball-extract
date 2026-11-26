package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagz implements zzao {
    public final List zza;

    public zzagz(List list) {
        this.zza = list;
        boolean z = false;
        if (!list.isEmpty()) {
            long j = ((zzagy) list.get(0)).zzb;
            for (int i = 1; i < list.size(); i++) {
                if (((zzagy) list.get(i)).zza < j) {
                    z = true;
                    break;
                }
                j = ((zzagy) list.get(i)).zzb;
            }
        }
        zzgmd.zza(!z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzagz) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }
}
