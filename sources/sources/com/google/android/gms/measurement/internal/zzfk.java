package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zznv;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfk implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzbr zza;
    final /* synthetic */ ServiceConnection zzb;
    final /* synthetic */ zzfl zzc;

    zzfk(zzfl zzflVar, com.google.android.gms.internal.measurement.zzbr zzbrVar, ServiceConnection serviceConnection) {
        this.zzc = zzflVar;
        this.zza = zzbrVar;
        this.zzb = serviceConnection;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x012c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0143  */
    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundleZzd;
        zzfl zzflVar = this.zzc;
        zzfm zzfmVar = zzflVar.zza;
        String str = zzflVar.zzb;
        com.google.android.gms.internal.measurement.zzbr zzbrVar = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfmVar.zza.zzaz().zzg();
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            bundleZzd = zzbrVar.zzd(bundle);
            if (bundleZzd == null) {
                zzfmVar.zza.zzay().zzd().zza("Install Referrer Service returned a null response");
                bundleZzd = null;
            }
        } catch (Exception e) {
            zzfmVar.zza.zzay().zzd().zzb("Exception occurred while retrieving the Install Referrer", e.getMessage());
        }
        zzfmVar.zza.zzaz().zzg();
        zzge.zzO();
        if (bundleZzd != null) {
            long j = bundleZzd.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                zzfmVar.zza.zzay().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundleZzd.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzfmVar.zza.zzay().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfmVar.zza.zzay().zzj().zzb("InstallReferrer API result", string);
                    zzln zzlnVarZzv = zzfmVar.zza.zzv();
                    Uri uri = Uri.parse("?".concat(string));
                    zznv.zzc();
                    boolean zZzs = zzfmVar.zza.zzf().zzs(null, zzeh.zzal);
                    zznv.zzc();
                    Bundle bundleZzs = zzlnVarZzv.zzs(uri, zZzs, zzfmVar.zza.zzf().zzs(null, zzeh.zzao));
                    if (bundleZzs == null) {
                        zzfmVar.zza.zzay().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = bundleZzs.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) {
                            if (j == zzfmVar.zza.zzm().zzd.zza()) {
                                zzfmVar.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                            }
                            if (zzfmVar.zza.zzJ()) {
                                zzfmVar.zza.zzm().zzd.zzb(j);
                                zzfmVar.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                bundleZzs.putString("_cis", "referrer API v2");
                                zzfmVar.zza.zzq().zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", bundleZzs, str);
                            }
                        } else {
                            long j2 = bundleZzd.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                zzfmVar.zza.zzay().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                bundleZzs.putLong("click_timestamp", j2);
                                if (j == zzfmVar.zza.zzm().zzd.zza()) {
                                    zzfmVar.zza.zzay().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                                }
                                if (zzfmVar.zza.zzJ()) {
                                    zzfmVar.zza.zzm().zzd.zzb(j);
                                    zzfmVar.zza.zzay().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                                    bundleZzs.putString("_cis", "referrer API v2");
                                    zzfmVar.zza.zzq().zzF(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_cmp", bundleZzs, str);
                                }
                            }
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfmVar.zza.zzau(), serviceConnection);
    }
}
