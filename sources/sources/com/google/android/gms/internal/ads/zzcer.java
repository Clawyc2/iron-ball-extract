package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcer extends zzarb {
    static final zzcer zzb = new zzcer();

    zzcer() {
    }

    @Override // com.google.android.gms.internal.ads.zzarb
    public final zzarf zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzarh();
        }
        return "mvhd".equals(str) ? new zzari() : new zzarj(str);
    }
}
