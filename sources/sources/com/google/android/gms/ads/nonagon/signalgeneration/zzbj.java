package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbxj;
import com.google.android.gms.internal.ads.zzduq;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzbj {
    public final String zza;
    public String zzb;
    public zzbxj zzd;
    public Bundle zze;
    private long zzg;
    private long zzh;
    public String zzc = null;
    public Bundle zzf = new Bundle();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    public zzbj(JsonReader jsonReader, zzbxj zzbxjVar) throws IOException {
        Bundle bundle;
        byte b;
        this.zzg = -1L;
        this.zzh = -1L;
        this.zzd = zzbxjVar;
        HashMap map = new HashMap();
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            switch (strNextName == null ? "" : strNextName) {
                case "start_time":
                    b = 2;
                    break;
                case "params":
                    b = 0;
                    break;
                case "signal_dictionary":
                    b = 1;
                    break;
                case "end_time":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                strNextString = jsonReader.nextString();
            } else if (b == 1) {
                map = new HashMap();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    map.put(jsonReader.nextName(), jsonReader.nextString());
                }
                jsonReader.endObject();
            } else if (b == 2) {
                this.zzg = jsonReader.nextLong();
            } else if (b != 3) {
                jsonReader.skipValue();
            } else {
                this.zzh = jsonReader.nextLong();
            }
        }
        this.zza = strNextString;
        jsonReader.endObject();
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                this.zzf.putString((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue() || zzbxjVar == null || (bundle = zzbxjVar.zzm) == null) {
            return;
        }
        bundle.putLong(zzduq.GET_SIGNALS_SDKCORE_START.zza(), this.zzg);
        zzbxjVar.zzm.putLong(zzduq.GET_SIGNALS_SDKCORE_END.zza(), this.zzh);
    }
}
