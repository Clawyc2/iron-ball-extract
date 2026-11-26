package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfne implements zzguf {
    final /* synthetic */ zzflc zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzdbd zzc;
    final /* synthetic */ zzfng zzd;

    zzfne(zzfng zzfngVar, zzflc zzflcVar, zzflm zzflmVar, zzdbd zzdbdVar) {
        this.zza = zzflcVar;
        this.zzb = zzflmVar;
        this.zzc = zzdbdVar;
        Objects.requireNonNull(zzfngVar);
        this.zzd = zzfngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflc zzflcVar = this.zza;
        if (zzflcVar == null) {
            return;
        }
        zzflcVar.zzd(false);
        zzflm zzflmVar = this.zzb;
        if (zzflmVar != null) {
            zzflmVar.zza(zzflcVar);
            zzflmVar.zzh();
        } else {
            zzfng zzfngVar = this.zzd;
            zzfngVar.zze().zzb(zzflcVar.zzm());
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0095  */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        byte b;
        int i;
        int i2;
        zzflc zzflcVar = this.zza;
        com.google.android.gms.ads.internal.util.client.zzt zztVar = (com.google.android.gms.ads.internal.util.client.zzt) obj;
        if (zzflcVar != null) {
            zzflcVar.zzd(zztVar == com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
            zzflm zzflmVar = this.zzb;
            if (zzflmVar == null) {
                this.zzd.zze().zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zza(zzflcVar);
                zzflmVar.zzh();
            }
        }
        zzdbd zzdbdVar = this.zzc;
        if (zzdbdVar != null) {
            String strZzb = this.zzd.zzd().zzb();
            if (TextUtils.isEmpty(strZzb)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(strZzb);
                Parcelable.Creator<com.google.android.gms.ads.internal.client.zzt> creator = com.google.android.gms.ads.internal.client.zzt.CREATOR;
                String strOptString = jSONObject.optString("type");
                String strOptString2 = jSONObject.optString("precision");
                String strOptString3 = jSONObject.optString(FirebaseAnalytics.Param.CURRENCY);
                long jOptLong = jSONObject.optLong("value", 0L);
                int iHashCode = strOptString.hashCode();
                byte b2 = -1;
                if (iHashCode != 66934) {
                    if (iHashCode != 66944) {
                        if (iHashCode == 1349395245 && strOptString.equals("ONE_PIXEL")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strOptString.equals("CPM")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strOptString.equals("CPC")) {
                    b = 1;
                } else {
                    b = -1;
                }
                if (b == 0) {
                    i = 1;
                } else if (b == 1) {
                    i = 2;
                } else if (b != 2) {
                    i = 0;
                } else {
                    jOptLong /= 1000;
                    i = 3;
                }
                int iHashCode2 = strOptString2.hashCode();
                if (iHashCode2 != -2131980260) {
                    if (iHashCode2 != 399232571) {
                        if (iHashCode2 == 1271254246 && strOptString2.equals("PUBLISHER_PROVIDED")) {
                            b2 = 1;
                        }
                    } else if (strOptString2.equals("PRECISE")) {
                        b2 = 2;
                    }
                } else if (strOptString2.equals("ESTIMATED")) {
                    b2 = 0;
                }
                if (b2 == 0) {
                    i2 = 1;
                } else if (b2 != 1) {
                    i2 = b2 != 2 ? 0 : 3;
                } else {
                    i2 = 2;
                }
                zzdbdVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, i2, strOptString3, jOptLong));
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "UrlPinger.pingUrl");
            }
        }
    }
}
