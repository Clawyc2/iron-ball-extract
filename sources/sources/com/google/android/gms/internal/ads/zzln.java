package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzln extends zzli {
    String zzS();

    default long zzT(long j, long j2) {
        if (zze() != 1) {
            return WorkRequest.MIN_BACKOFF_MILLIS;
        }
        if (zzY() || zzZ()) {
            return 1000000L;
        }
        return WorkRequest.MIN_BACKOFF_MILLIS;
    }

    default boolean zzU(long j) {
        return false;
    }

    default void zzV(float f, float f2) throws zzib {
    }

    default void zzW() {
    }

    void zzX(long j, long j2) throws zzib;

    boolean zzY();

    boolean zzZ();

    int zza();

    zzlp zzb();

    void zzc(int i, zzpc zzpcVar, zzdc zzdcVar);

    void zzcY() throws zzib;

    void zzcZ(zzv[] zzvVarArr, zzwk zzwkVar, long j, long j2, zzuu zzuuVar) throws zzib;

    zzko zzd();

    zzwk zzda();

    boolean zzdb();

    int zze();

    void zzf(zzlq zzlqVar, zzv[] zzvVarArr, zzwk zzwkVar, long j, boolean z, boolean z2, long j2, long j3, zzuu zzuuVar) throws zzib;

    long zzk();

    void zzl();

    boolean zzm();

    void zzn() throws IOException;

    void zzo(zzbf zzbfVar);

    void zzp(long j, boolean z) throws zzib;

    void zzq();

    void zzr();

    void zzs();

    default void zzt() {
    }
}
