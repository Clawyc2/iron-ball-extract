package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrq implements zzifh {
    private final zzifq zza;

    private zzdrq(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdrq zza(zzifq zzifqVar) {
        return new zzdrq(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbdz.zza.EnumC0009zza enumC0009zza = ((zzcyf) this.zza).zza().zzp.zza == 3 ? zzbdz.zza.EnumC0009zza.REWARDED_INTERSTITIAL : zzbdz.zza.EnumC0009zza.REWARD_BASED_VIDEO_AD;
        zzifp.zzb(enumC0009zza);
        return enumC0009zza;
    }
}
