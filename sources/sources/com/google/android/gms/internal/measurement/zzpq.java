package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpq implements zzpp {
    public static final zzia zza = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza().zzf("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpp
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
