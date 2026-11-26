package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
@ParametersAreNonnullByDefault
public final class zzbes implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbep
                    @Override // com.google.android.gms.internal.ads.zzgmv
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", "{}");
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00a2 A[Catch: all -> 0x016c, TRY_ENTER, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00a6 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7 A[Catch: all -> 0x016c, TRY_ENTER, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e8 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00f6 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x011a A[Catch: all -> 0x0175, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x000d, B:11:0x000f, B:13:0x0014, B:14:0x0016, B:16:0x0028, B:17:0x002c, B:18:0x002e, B:38:0x0098, B:39:0x009f, B:48:0x00cf, B:62:0x011a, B:75:0x0163, B:76:0x016a, B:79:0x016d, B:80:0x0174, B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:86:0x0009, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0123 A[Catch: all -> 0x016c, TRY_ENTER, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0130 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0155 A[Catch: all -> 0x016c, TryCatch #3 {all -> 0x016c, blocks: (B:20:0x0043, B:23:0x004d, B:27:0x0056, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:35:0x007f, B:37:0x0094, B:41:0x00a2, B:43:0x00a6, B:45:0x00b6, B:47:0x00cb, B:50:0x00d7, B:60:0x0116, B:64:0x0123, B:66:0x0130, B:68:0x013e, B:69:0x0147, B:71:0x0155, B:73:0x0159, B:74:0x015c, B:53:0x00e8, B:55:0x00f6, B:57:0x00fe, B:58:0x0109), top: B:91:0x0043, outer: #0 }] */
    public final void zza(Context context) {
        SharedPreferences sharedPreferencesZzb;
        final SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        zzbge zzbgeVar;
        if (this.zzd) {
            return;
        }
        synchronized (this.zzb) {
            if (this.zzd) {
                return;
            }
            if (!this.zza) {
                this.zza = true;
            }
            this.zzi = TextUtils.equals(context.getPackageName(), "com.google.android.gms");
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzg = context;
            try {
                this.zzf = Wrappers.packageManager(context).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context context2 = this.zzg;
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context2);
                if (remoteContext != null || context2 == null || (remoteContext = context2.getApplicationContext()) != null) {
                    context2 = remoteContext;
                }
                if (context2 != null) {
                    com.google.android.gms.ads.internal.client.zzbd.zza();
                    sharedPreferencesZzb = zzben.zzb(context2);
                } else {
                    sharedPreferencesZzb = null;
                }
                if (sharedPreferencesZzb != null) {
                    zzbhm.zzc(new zzbeo(this, sharedPreferencesZzb));
                }
                if (!this.zzi) {
                    zzbge zzbgeVar2 = zzbgm.zzd;
                    if (((Long) zzbgeVar2.zze()).longValue() > 0 && zzbef.zzd(this.zzg) >= ((Long) zzbgeVar2.zze()).longValue()) {
                        this.zzj = true;
                        this.zzd = true;
                        this.zza = false;
                        this.zzc.open();
                    } else if (this.zzi) {
                        Context context3 = this.zzg;
                        if (!((Boolean) zzbgu.zzi.zze()).booleanValue()) {
                            if (((Boolean) zzbgu.zzj.zze()).booleanValue()) {
                                if (new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbeq
                                    @Override // com.google.android.gms.internal.ads.zzgmv
                                    public final /* synthetic */ Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            }
                            if (context2 == null) {
                                com.google.android.gms.ads.internal.client.zzbd.zza();
                                this.zze = zzben.zzb(context2);
                                if (!this.zzi) {
                                    com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zzg(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            this.zzc.open();
                        }
                        context2 = this.zzg;
                        if (context2 == null) {
                            com.google.android.gms.ads.internal.client.zzbd.zza();
                            this.zze = zzben.zzb(context2);
                            if (!this.zzi) {
                                com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzg(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        this.zzc.open();
                    } else {
                        zzbgeVar = zzbgm.zzf;
                        if (((Long) zzbgeVar.zze()).longValue() > 0 || zzbef.zzc(this.zzg) < ((Long) zzbgeVar.zze()).longValue()) {
                            Context context4 = this.zzg;
                            if (!((Boolean) zzbgu.zzi.zze()).booleanValue()) {
                                if (((Boolean) zzbgu.zzj.zze()).booleanValue() && (sharedPreferences = context4.getSharedPreferences("admob", 0)) != null) {
                                    try {
                                        if (new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbeq
                                            @Override // com.google.android.gms.internal.ads.zzgmv
                                            public final /* synthetic */ Object zza() {
                                                return sharedPreferences.getString("app_settings_json", "{}");
                                            }
                                        })).optBoolean("local_flags_enabled")) {
                                        }
                                    } catch (JSONException unused2) {
                                    }
                                }
                                if (context2 == null) {
                                    com.google.android.gms.ads.internal.client.zzbd.zza();
                                    this.zze = zzben.zzb(context2);
                                    if (!this.zzi && ((Boolean) zzbgu.zzc.zze()).booleanValue()) {
                                        com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                                    }
                                    if (!((Boolean) zzbgu.zzb.zze()).booleanValue() && (sharedPreferences2 = this.zze) != null) {
                                        sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                    }
                                    zzg(this.zze);
                                    this.zzd = true;
                                    this.zza = false;
                                    this.zzc.open();
                                    return;
                                }
                                this.zza = false;
                                this.zzc.open();
                            }
                            context2 = this.zzg;
                            if (context2 == null) {
                                com.google.android.gms.ads.internal.client.zzbd.zza();
                                this.zze = zzben.zzb(context2);
                                if (!this.zzi) {
                                    com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zzg(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            this.zzc.open();
                        } else {
                            this.zzj = true;
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                        }
                    }
                } else if (this.zzi) {
                    zzbgeVar = zzbgm.zzf;
                    if (((Long) zzbgeVar.zze()).longValue() > 0) {
                        Context context5 = this.zzg;
                        if (!((Boolean) zzbgu.zzi.zze()).booleanValue()) {
                            if (((Boolean) zzbgu.zzj.zze()).booleanValue()) {
                                if (new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbeq
                                    @Override // com.google.android.gms.internal.ads.zzgmv
                                    public final /* synthetic */ Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            }
                            if (context2 == null) {
                                com.google.android.gms.ads.internal.client.zzbd.zza();
                                this.zze = zzben.zzb(context2);
                                if (!this.zzi) {
                                    com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zzg(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            this.zzc.open();
                        }
                        context2 = this.zzg;
                        if (context2 == null) {
                            com.google.android.gms.ads.internal.client.zzbd.zza();
                            this.zze = zzben.zzb(context2);
                            if (!this.zzi) {
                                com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzg(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        this.zzc.open();
                    } else {
                        Context context6 = this.zzg;
                        if (!((Boolean) zzbgu.zzi.zze()).booleanValue()) {
                            if (((Boolean) zzbgu.zzj.zze()).booleanValue()) {
                                if (new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbeq
                                    @Override // com.google.android.gms.internal.ads.zzgmv
                                    public final /* synthetic */ Object zza() {
                                        return sharedPreferences.getString("app_settings_json", "{}");
                                    }
                                })).optBoolean("local_flags_enabled")) {
                                }
                            }
                            if (context2 == null) {
                                com.google.android.gms.ads.internal.client.zzbd.zza();
                                this.zze = zzben.zzb(context2);
                                if (!this.zzi) {
                                    com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                                }
                                if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                    sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                                }
                                zzg(this.zze);
                                this.zzd = true;
                                this.zza = false;
                                this.zzc.open();
                                return;
                            }
                            this.zza = false;
                            this.zzc.open();
                        }
                        context2 = this.zzg;
                        if (context2 == null) {
                            com.google.android.gms.ads.internal.client.zzbd.zza();
                            this.zze = zzben.zzb(context2);
                            if (!this.zzi) {
                                com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzg(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        this.zzc.open();
                    }
                } else {
                    Context context7 = this.zzg;
                    if (!((Boolean) zzbgu.zzi.zze()).booleanValue()) {
                        if (((Boolean) zzbgu.zzj.zze()).booleanValue()) {
                            if (new JSONObject((String) zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzbeq
                                @Override // com.google.android.gms.internal.ads.zzgmv
                                public final /* synthetic */ Object zza() {
                                    return sharedPreferences.getString("app_settings_json", "{}");
                                }
                            })).optBoolean("local_flags_enabled")) {
                            }
                        }
                        if (context2 == null) {
                            com.google.android.gms.ads.internal.client.zzbd.zza();
                            this.zze = zzben.zzb(context2);
                            if (!this.zzi) {
                                com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                            }
                            if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                                sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzg(this.zze);
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                            return;
                        }
                        this.zza = false;
                        this.zzc.open();
                    }
                    context2 = this.zzg;
                    if (context2 == null) {
                        com.google.android.gms.ads.internal.client.zzbd.zza();
                        this.zze = zzben.zzb(context2);
                        if (!this.zzi) {
                            com.google.android.gms.ads.internal.client.zzbd.zzd().zza(this.zzg);
                        }
                        if (!((Boolean) zzbgu.zzb.zze()).booleanValue()) {
                            sharedPreferences2.registerOnSharedPreferenceChangeListener(this);
                        }
                        zzg(this.zze);
                        this.zzd = true;
                        this.zza = false;
                        this.zzc.open();
                        return;
                    }
                    this.zza = false;
                    this.zzc.open();
                }
            } catch (Throwable th) {
                this.zza = false;
                this.zzc.open();
                throw th;
            }
        }
    }

    final boolean zzb() {
        return this.zzi;
    }

    public final boolean zzc() {
        return this.zzj;
    }

    public final Object zzd(final zzbel zzbelVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbelVar.zzf();
            }
        }
        if (zzbelVar.zzm() != 2) {
            return (zzbelVar.zzm() == 1 && this.zzh.has(zzbelVar.zze())) ? zzbelVar.zzc(this.zzh) : zzbew.zza(new zzgmv() { // from class: com.google.android.gms.internal.ads.zzber
                @Override // com.google.android.gms.internal.ads.zzgmv
                public final /* synthetic */ Object zza() {
                    return this.zza.zzf(zzbelVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbelVar.zzf() : zzbelVar.zza(bundle);
    }

    final /* synthetic */ Object zzf(zzbel zzbelVar) {
        return zzbelVar.zzd(this.zze);
    }

    public final Object zze(zzbel zzbelVar) {
        return (this.zzd || this.zza) ? zzd(zzbelVar) : zzbelVar.zzf();
    }
}
