package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzla implements zzlm {
    final /* synthetic */ zzlf zza;

    zzla(zzlf zzlfVar) {
        this.zza = zzlfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlm
    public final void zza(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzaz().zzp(new zzkz(this, str, "_err", bundle));
            return;
        }
        zzlf zzlfVar = this.zza;
        if (zzlfVar.zzn != null) {
            zzlfVar.zzn.zzay().zzd().zzb("AppId not known when logging event", "_err");
        }
    }
}
