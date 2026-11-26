package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zznv;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzig implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ Uri zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzii zze;

    zzig(zzii zziiVar, boolean z, Uri uri, String str, String str2) {
        this.zze = zziiVar;
        this.zza = z;
        this.zzb = uri;
        this.zzc = str;
        this.zzd = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        Bundle bundleZzs;
        String str;
        zzii zziiVar = this.zze;
        boolean z2 = this.zza;
        Uri uri = this.zzb;
        String str2 = this.zzc;
        String str3 = this.zzd;
        zziiVar.zza.zzg();
        try {
            zzln zzlnVarZzv = zziiVar.zza.zzs.zzv();
            zznv.zzc();
            boolean zZzs = zziiVar.zza.zzs.zzf().zzs(null, zzeh.zzam);
            zznv.zzc();
            boolean zZzs2 = zziiVar.zza.zzs.zzf().zzs(null, zzeh.zzan);
            if (TextUtils.isEmpty(str3)) {
                z = z2;
                bundleZzs = null;
            } else {
                if (!str3.contains("gclid") && !str3.contains("utm_campaign") && !str3.contains("utm_source") && !str3.contains("utm_medium") && (!zZzs || (!str3.contains("utm_id") && !str3.contains("dclid")))) {
                    if (zZzs2 && str3.contains("srsltid")) {
                        zZzs2 = true;
                    }
                    zzlnVarZzv.zzs.zzay().zzc().zza("Activity created with data 'referrer' without required params");
                    z = z2;
                    bundleZzs = null;
                }
                z = z2;
                bundleZzs = zzlnVarZzv.zzs(Uri.parse("https://google.com/search?".concat(String.valueOf(str3))), zZzs, zZzs2);
                if (bundleZzs != null) {
                    bundleZzs.putString("_cis", "referrer");
                }
            }
            if (z) {
                zzln zzlnVarZzv2 = zziiVar.zza.zzs.zzv();
                zznv.zzc();
                boolean zZzs3 = zziiVar.zza.zzs.zzf().zzs(null, zzeh.zzam);
                zznv.zzc();
                str = "Activity created with data 'referrer' without required params";
                Bundle bundleZzs2 = zzlnVarZzv2.zzs(uri, zZzs3, zziiVar.zza.zzs.zzf().zzs(null, zzeh.zzan));
                if (bundleZzs2 != null) {
                    bundleZzs2.putString("_cis", "intent");
                    if (!bundleZzs2.containsKey("gclid") && bundleZzs != null && bundleZzs.containsKey("gclid")) {
                        bundleZzs2.putString("_cer", String.format("gclid=%s", bundleZzs.getString("gclid")));
                    }
                    zziiVar.zza.zzG(str2, "_cmp", bundleZzs2);
                    zziiVar.zza.zzb.zza(str2, bundleZzs2);
                }
            } else {
                str = "Activity created with data 'referrer' without required params";
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            zziiVar.zza.zzs.zzay().zzc().zzb("Activity created with referrer", str3);
            if (zziiVar.zza.zzs.zzf().zzs(null, zzeh.zzY)) {
                if (bundleZzs != null) {
                    zziiVar.zza.zzG(str2, "_cmp", bundleZzs);
                    zziiVar.zza.zzb.zza(str2, bundleZzs);
                } else {
                    zziiVar.zza.zzs.zzay().zzc().zzb("Referrer does not contain valid parameters", str3);
                }
                zziiVar.zza.zzW(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", null, true);
                return;
            }
            if (!str3.contains("gclid") || (!str3.contains("utm_campaign") && !str3.contains("utm_source") && !str3.contains("utm_medium") && !str3.contains("utm_term") && !str3.contains("utm_content"))) {
                zziiVar.zza.zzs.zzay().zzc().zza(str);
            } else {
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                zziiVar.zza.zzW(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", str3, true);
            }
        } catch (RuntimeException e) {
            zziiVar.zza.zzs.zzay().zzd().zzb("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }
}
