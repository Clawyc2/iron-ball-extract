package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcaw;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzay {
    private final String zza;
    private final String zzb;
    private final zzcaw zzc;

    /* synthetic */ zzay(zzax zzaxVar, byte[] bArr) {
        this.zza = zzaxVar.zzd();
        this.zzb = zzaxVar.zze();
        this.zzc = zzaxVar.zzf();
    }

    public final Set zza() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    public final zzbdz.zza.EnumC0009zza zzc() {
        byte b;
        switch (this.zza) {
            case "NATIVE":
                b = 2;
                break;
            case "INTERSTITIAL":
                b = 1;
                break;
            case "REWARDED":
                b = 3;
                break;
            case "BANNER":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return zzbdz.zza.EnumC0009zza.BANNER;
        }
        if (b == 1) {
            return zzbdz.zza.EnumC0009zza.INTERSTITIAL;
        }
        if (b != 2) {
            return b != 3 ? zzbdz.zza.EnumC0009zza.AD_INITIATER_UNSPECIFIED : zzbdz.zza.EnumC0009zza.REWARD_BASED_VIDEO_AD;
        }
        return zzbdz.zza.EnumC0009zza.AD_LOADER;
    }

    final String zzd() {
        return this.zzb;
    }

    final zzcaw zze() {
        return this.zzc;
    }
}
