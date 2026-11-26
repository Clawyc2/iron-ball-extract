package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeyl implements zzeya {
    private final zzgus zza;
    private final Context zzb;
    private final zzdzt zzc;

    zzeyl(zzgus zzgusVar, Context context, zzdzt zzdztVar) {
        this.zza = zzgusVar;
        this.zzb = context;
        this.zzc = zzdztVar;
    }

    private static ResolveInfo zzd(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeyk
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 38;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0104  */
    /* JADX WARN: Code duplicated, block: B:32:0x0117  */
    /* JADX WARN: Code duplicated, block: B:34:0x0129  */
    /* JADX WARN: Code duplicated, block: B:38:0x013b  */
    /* JADX WARN: Code duplicated, block: B:39:0x013e  */
    /* JADX WARN: Code duplicated, block: B:49:0x0189 A[EDGE_INSN: B:49:0x0189->B:50:0x018c BREAK  A[LOOP:1: B:43:0x015b->B:48:0x0184], PHI: r2
      0x0189: PHI (r2v9 java.lang.String) = (r2v8 java.lang.String), (r2v8 java.lang.String), (r2v10 java.lang.String) binds: [B:40:0x0156, B:41:0x0158, B:89:0x0189] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:52:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:54:0x01be  */
    /* JADX WARN: Code duplicated, block: B:55:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:64:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:67:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:70:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:71:0x0201  */
    /* JADX WARN: Code duplicated, block: B:80:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final /* synthetic */ zzeyj zzc() {
        ActivityInfo activityInfo;
        boolean z;
        String string;
        String str;
        String string2;
        boolean zEquals;
        String language;
        String str2;
        String strZza;
        Context context;
        List<ResolveInfo> listQueryIntentActivities;
        String str3;
        boolean z2;
        Bundle bundle;
        boolean z3;
        boolean z4;
        Context context2 = this.zzb;
        PackageManager packageManager = context2.getPackageManager();
        Locale locale = Locale.getDefault();
        ResolveInfo resolveInfoZzd = zzd(packageManager, "geo:0,0?q=donuts");
        ResolveInfo resolveInfoZzd2 = zzd(packageManager, "http://www.google.com");
        String country = locale.getCountry();
        com.google.android.gms.ads.internal.zzt.zzc();
        com.google.android.gms.ads.internal.client.zzbb.zza();
        boolean zZzw = com.google.android.gms.ads.internal.util.client.zzf.zzw();
        boolean zIsLatchsky = DeviceProperties.isLatchsky(context2);
        boolean zIsSidewinder = DeviceProperties.isSidewinder(context2);
        String language2 = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        LocaleList localeList = LocaleList.getDefault();
        for (int i = 0; i < localeList.size(); i++) {
            arrayList.add(localeList.get(i).getLanguage());
        }
        ResolveInfo resolveInfoZzd3 = zzd(packageManager, "market://details?id=com.google.android.gms.ads");
        String string3 = null;
        if (resolveInfoZzd3 == null || (activityInfo = resolveInfoZzd3.activityInfo) == null) {
            string = null;
            z = true;
        } else {
            try {
                z = true;
                try {
                    PackageInfo packageInfo = Wrappers.packageManager(context2).getPackageInfo(activityInfo.packageName, 0);
                    if (packageInfo != null) {
                        int i2 = packageInfo.versionCode;
                        String str4 = activityInfo.packageName;
                        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 1 + String.valueOf(str4).length());
                        sb.append(i2);
                        sb.append(".");
                        sb.append(str4);
                        string = sb.toString();
                    } else {
                        string = null;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                z = true;
            }
        }
        try {
            PackageInfo packageInfo2 = Wrappers.packageManager(this.zzb).getPackageInfo("com.android.vending", 128);
            if (packageInfo2 != null) {
                int i3 = packageInfo2.versionCode;
                String str5 = packageInfo2.packageName;
                str = string;
                try {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 1 + String.valueOf(str5).length());
                    sb2.append(i3);
                    sb2.append(".");
                    sb2.append(str5);
                    string2 = sb2.toString();
                } catch (Exception unused3) {
                    string2 = null;
                }
                zEquals = false;
                String str6 = Build.FINGERPRINT;
                language = Locale.getDefault().getLanguage();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzos)).booleanValue()) {
                    com.google.android.gms.ads.internal.util.zzq zzqVarZzm = com.google.android.gms.ads.internal.util.zzs.zzm(this.zzb);
                    String strZzb = zzqVarZzm.zzb();
                    strZza = zzqVarZzm.zza();
                    str2 = strZzb;
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzor)).booleanValue()) {
                        language = com.google.android.gms.ads.internal.util.zzs.zzm(this.zzb).zzb();
                    }
                    str2 = language;
                    strZza = null;
                }
                context = this.zzb;
                if (packageManager == null) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
                    ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
                    listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                    if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
                        str3 = string2;
                        zEquals = false;
                        break;
                    }
                    int i4 = 0;
                    while (true) {
                        if (i4 >= listQueryIntentActivities.size()) {
                            str3 = string2;
                            zEquals = false;
                            break;
                        }
                        str3 = string2;
                        if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i4).activityInfo.name)) {
                            zEquals = resolveInfoResolveActivity.activityInfo.packageName.equals(zzifx.zza(context));
                            break;
                        }
                        i4++;
                        string2 = str3;
                    }
                } else {
                    str3 = string2;
                }
                com.google.android.gms.ads.internal.zzt.zzc();
                long availableBytes = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmr)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzc();
                    if (com.google.android.gms.ads.internal.util.zzs.zzF(context)) {
                        z2 = z;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmv)).booleanValue()) {
                    try {
                        bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null && bundle.containsKey("com.google.unity.ads.UNITY_VERSION")) {
                            string3 = bundle.getString("com.google.unity.ads.UNITY_VERSION");
                        }
                    } catch (PackageManager.NameNotFoundException unused4) {
                    }
                } else {
                    string3 = "";
                }
                String str7 = string3;
                if (resolveInfoZzd2 != null) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (resolveInfoZzd != null) {
                    z4 = z;
                } else {
                    z4 = false;
                }
                return new zzeyj(z4, z3, country, zZzw, zIsLatchsky, zIsSidewinder, language2, arrayList, str, str3, str6, zEquals, Build.MODEL, availableBytes, z2, str7, Build.VERSION.SDK_INT, str2, strZza, this.zzc.zza());
            }
            str = string;
        } catch (Exception unused5) {
        }
        string2 = null;
        zEquals = false;
        String str8 = Build.FINGERPRINT;
        language = Locale.getDefault().getLanguage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzos)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzq zzqVarZzm2 = com.google.android.gms.ads.internal.util.zzs.zzm(this.zzb);
            String strZzb2 = zzqVarZzm2.zzb();
            strZza = zzqVarZzm2.zza();
            str2 = strZzb2;
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzor)).booleanValue()) {
                language = com.google.android.gms.ads.internal.util.zzs.zzm(this.zzb).zzb();
            }
            str2 = language;
            strZza = null;
        }
        context = this.zzb;
        if (packageManager == null) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity2 = packageManager.resolveActivity(intent2, 0);
            listQueryIntentActivities = packageManager.queryIntentActivities(intent2, 65536);
            if (listQueryIntentActivities == null) {
                str3 = string2;
                zEquals = false;
                break;
            }
            str3 = string2;
            zEquals = false;
            break;
        }
        str3 = string2;
        com.google.android.gms.ads.internal.zzt.zzc();
        long availableBytes2 = new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmr)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            if (com.google.android.gms.ads.internal.util.zzs.zzF(context)) {
                z2 = z;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmv)).booleanValue()) {
            bundle = Wrappers.packageManager(context).getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                string3 = bundle.getString("com.google.unity.ads.UNITY_VERSION");
            }
        } else {
            string3 = "";
        }
        String str9 = string3;
        if (resolveInfoZzd2 != null) {
            z3 = z;
        } else {
            z3 = false;
        }
        if (resolveInfoZzd != null) {
            z4 = z;
        } else {
            z4 = false;
        }
        return new zzeyj(z4, z3, country, zZzw, zIsLatchsky, zIsSidewinder, language2, arrayList, str, str3, str8, zEquals, Build.MODEL, availableBytes2, z2, str9, Build.VERSION.SDK_INT, str2, strZza, this.zzc.zza());
    }
}
