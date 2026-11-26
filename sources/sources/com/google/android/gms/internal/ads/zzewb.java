package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzewb implements zzexy {
    private final zzfgn zza;
    private final PackageInfo zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;

    public zzewb(zzfgn zzfgnVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzfgnVar;
        this.zzb = packageInfo;
        this.zzc = zzgVar;
    }

    private final void zzc(Bundle bundle) {
        int i;
        zzbhx zzbhxVar = this.zza.zzj;
        if (zzbhxVar == null || (i = zzbhxVar.zzi) == 0) {
            return;
        }
        bundle.putBoolean("sccg_tap", zzbhxVar.zzj);
        bundle.putInt("sccg_dir", i);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x010b  */
    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        JSONArray jSONArrayOptJSONArray;
        String str;
        zzfgn zzfgnVar = this.zza;
        ArrayList<String> arrayList = zzfgnVar.zzh;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (arrayList == null) {
            return;
        }
        if (arrayList.isEmpty()) {
            zzcxqVar.zza.putInt("native_version", 0);
            return;
        }
        Bundle bundle = zzcxqVar.zza;
        bundle.putInt("native_version", 3);
        bundle.putStringArrayList("native_templates", arrayList);
        bundle.putStringArrayList("native_custom_templates", zzfgnVar.zzi);
        zzbhx zzbhxVar = zzfgnVar.zzj;
        if (zzbhxVar != null) {
            String str2 = "landscape";
            if (zzbhxVar.zza > 3) {
                bundle.putBoolean("enable_native_media_orientation", true);
                int i = zzbhxVar.zzh;
                if (i == 1) {
                    str = "any";
                } else if (i == 2) {
                    str = "landscape";
                } else if (i != 3) {
                    str = i != 4 ? EnvironmentCompat.MEDIA_UNKNOWN : "square";
                } else {
                    str = "portrait";
                }
                if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(str)) {
                    bundle.putString("native_media_orientation", str);
                }
            }
            int i2 = zzbhxVar.zzc;
            if (i2 == 0) {
                str2 = "any";
            } else if (i2 == 1) {
                str2 = "portrait";
            } else if (i2 != 2) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(str2)) {
                bundle.putString("native_image_orientation", str2);
            }
            bundle.putBoolean("native_multiple_images", zzbhxVar.zzd);
            bundle.putBoolean("use_custom_mute", zzbhxVar.zzg);
            zzc(bundle);
        }
        PackageInfo packageInfo = this.zzb;
        int i3 = packageInfo != null ? packageInfo.versionCode : 0;
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzc;
        if (i3 > zzgVar.zzg()) {
            zzgVar.zzt();
            zzgVar.zzf(i3);
        }
        JSONObject jSONObjectZzs = zzgVar.zzs();
        String string = null;
        if (jSONObjectZzs != null && (jSONArrayOptJSONArray = jSONObjectZzs.optJSONArray(zzfgnVar.zzg)) != null) {
            string = jSONArrayOptJSONArray.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            bundle.putString("native_advanced_settings", string);
        }
        int i4 = zzfgnVar.zzl;
        if (i4 > 1) {
            bundle.putInt("max_num_ads", i4);
        }
        zzboi zzboiVar = zzfgnVar.zzb;
        if (zzboiVar != null) {
            String str3 = zzboiVar.zzc;
            if (TextUtils.isEmpty(str3)) {
                String str4 = "p";
                if (zzboiVar.zza >= 2) {
                    int i5 = zzboiVar.zzd;
                    if (i5 == 2 || i5 != 3) {
                        str4 = "l";
                    }
                } else {
                    int i6 = zzboiVar.zzb;
                    if (i6 == 1) {
                        str4 = "l";
                    } else if (i6 != 2) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 41);
                        sb.append("Instream ad video aspect ratio ");
                        sb.append(i6);
                        sb.append(" is wrong.");
                        com.google.android.gms.ads.internal.util.client.zzo.zzf(sb.toString());
                        str4 = "l";
                    }
                }
                bundle.putString("ia_var", str4);
            } else {
                bundle.putString("ad_tag", str3);
            }
            bundle.putBoolean("instr", true);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmR)).booleanValue() || zzbhxVar == null) {
            return;
        }
        com.google.android.gms.ads.internal.client.zzga zzgaVar = zzbhxVar.zzf;
        if (zzgaVar != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("startMuted", zzgaVar.zza);
            bundle2.putBoolean("clickToExpandRequested", zzgaVar.zzc);
            bundle2.putBoolean("customControlsRequested", zzgaVar.zzb);
            bundle.putBundle("video", bundle2);
        }
        bundle.putBoolean("disable_image_loading", zzbhxVar.zzb);
        bundle.putInt("preferred_ad_choices_position", zzbhxVar.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ArrayList arrayList = this.zza.zzh;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        zzc(zzcxqVar.zzb);
    }
}
