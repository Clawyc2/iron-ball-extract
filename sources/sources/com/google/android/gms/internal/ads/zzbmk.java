package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmk implements zzblx {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdvi zzb;
    private final zzbuh zzd;
    private final zzefy zze;
    private final zzcpe zzf;
    private final zzcxn zzg;
    private com.google.android.gms.ads.internal.util.client.zzu zzc = null;
    private com.google.android.gms.ads.internal.overlay.zzaa zzh = null;
    private final zzgus zzi = zzcbv.zzg;

    public zzbmk(com.google.android.gms.ads.internal.zzb zzbVar, zzbuh zzbuhVar, zzefy zzefyVar, zzdvi zzdviVar, zzcpe zzcpeVar, zzcxn zzcxnVar) {
        this.zza = zzbVar;
        this.zzd = zzbuhVar;
        this.zze = zzefyVar;
        this.zzb = zzdviVar;
        this.zzf = zzcpeVar;
        this.zzg = zzcxnVar;
    }

    public static boolean zzb(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    public static int zzc(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzd(Context context, zzaxa zzaxaVar, Uri uri, View view, Activity activity, zzfgr zzfgrVar) {
        if (zzaxaVar != null) {
            try {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmY)).booleanValue() || zzfgrVar == null) {
                    if (zzaxaVar.zze(uri)) {
                        return zzaxaVar.zzd(uri, context, view, activity);
                    }
                } else if (zzaxaVar.zze(uri)) {
                    return zzfgrVar.zza(uri, context, view, activity);
                }
            } catch (zzaxb unused) {
            } catch (Exception e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            }
        }
        return uri;
    }

    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String string = uri.toString();
            String.valueOf(string);
            String strValueOf = String.valueOf(string);
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error adding click uptime parameter to url: ".concat(strValueOf), e);
        }
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:132:0x036a  */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final void zzf(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean zZzb;
        Object obj;
        zzcxn zzcxnVar;
        zzcgy zzcgyVar = (zzcgy) zzaVar;
        zzffu zzffuVarZzC = zzcgyVar.zzC();
        zzffx zzffxVarZzaC = zzcgyVar.zzaC();
        boolean zZza = false;
        if (zzffuVarZzC == null || zzffxVarZzaC == null) {
            str3 = "";
            zZzb = false;
        } else {
            str3 = zzffxVarZzaC.zzb;
            zZzb = zzffuVarZzC.zzb();
        }
        boolean z = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlK)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("0")) ? false : true;
        boolean z2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznM)).booleanValue() && map.containsKey("ig_cl") && ((String) map.get("ig_cl")).equals("true");
        if ("expand".equalsIgnoreCase(str2)) {
            if (zzcgyVar.zzW()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzl(false);
                ((zzcio) zzaVar).zzaI(zzb(map), zzc(map), z);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzl(false);
            boolean z3 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmU)).booleanValue() && Objects.equals(map.get("is_allowed_for_lock_screen"), "1");
            if (str != null) {
                ((zzcio) zzaVar).zzaJ(zzb(map), zzc(map), str, z, z3);
                return;
            } else {
                ((zzcio) zzaVar).zzaK(zzb(map), zzc(map), (String) map.get("html"), (String) map.get("baseurl"), z);
                return;
            }
        }
        Intent uri = null;
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzcgyVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfo)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                zzg(10);
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfi)).booleanValue()) {
                    int i2 = zzbft.zza;
                    String packageName = CustomTabsClient.getPackageName(context, null);
                    if (packageName != null && !context.getPackageName().equals(packageName)) {
                        zZza = true;
                    }
                } else {
                    zZza = zzbfv.zza(context);
                }
                if (zZza) {
                    boolean z4 = z2;
                    String str4 = str3;
                    zzl(true);
                    if (TextUtils.isEmpty(str)) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot open browser with null or empty url");
                        zzg(7);
                        return;
                    }
                    Uri uriZze = zze(zzd(zzcgyVar.getContext(), zzcgyVar.zzS(), Uri.parse(str), zzcgyVar.zzE(), zzcgyVar.zzj(), zzcgyVar.zzT()));
                    if (zZzb && this.zze != null && zzi(zzaVar, zzcgyVar.getContext(), uriZze.toString(), str4)) {
                        return;
                    }
                    this.zzh = new zzbmh(this);
                    zzcio zzcioVar = (zzcio) zzaVar;
                    String string = uriZze.toString();
                    com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzh;
                    Bundle bundle = new Bundle();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfn)).booleanValue()) {
                        if (map.containsKey("cct_init_h")) {
                            try {
                                bundle.putInt("h", Integer.parseInt((String) map.get("cct_init_h")));
                            } catch (NumberFormatException e) {
                                com.google.android.gms.ads.internal.util.zze.zzb("Invalid cct initial height parameter.", e);
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OpenGmsgHandler.getChromeCustomTabConfigBundle");
                            }
                        }
                        if (map.containsKey("cct_bp")) {
                            try {
                                bundle.putInt("cbp", Integer.parseInt((String) map.get("cct_bp")));
                            } catch (NumberFormatException e2) {
                                com.google.android.gms.ads.internal.util.zze.zzb("Invalid cct close button position parameter.", e2);
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e2, "OpenGmsgHandler.getChromeCustomTabConfigBundle");
                            }
                        }
                    }
                    zzcioVar.zzaH(new com.google.android.gms.ads.internal.overlay.zzc(null, string, null, null, null, null, null, null, ObjectWrapper.wrap(zzaaVar).asBinder(), true, bundle), z, z4, str4);
                    return;
                }
                zzg(4);
            }
            map.put("use_first_package", "true");
            map.put("use_running_process", "true");
            zzk(zzaVar, map, zZzb, str3, z, z2);
            return;
        }
        boolean z5 = z2;
        String str5 = str3;
        if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            zzk(zzaVar, map, zZzb, str5, z, z5);
            return;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar2 = zzaVar;
        Map map2 = map;
        boolean z6 = zZzb;
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjd)).booleanValue()) {
                zzl(true);
                String str6 = (String) map2.get("p");
                if (str6 == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Package name missing from open app action.");
                    return;
                }
                if (z6 && this.zze != null && zzi(zzaVar2, zzcgyVar.getContext(), str6, str5)) {
                    return;
                }
                PackageManager packageManager = zzcgyVar.getContext().getPackageManager();
                if (packageManager == null) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot get package manager from open app action.");
                    return;
                } else {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str6);
                    if (launchIntentForPackage != null) {
                        ((zzcio) zzaVar2).zzaH(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzh), z, z5, str5);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        zzl(true);
        String str7 = (String) map2.get("intent_url");
        if (!TextUtils.isEmpty(str7)) {
            try {
                uri = Intent.parseUri(str7, 0);
            } catch (URISyntaxException e3) {
                String.valueOf(str7);
                String strValueOf = String.valueOf(str7);
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error parsing the url: ".concat(strValueOf), e3);
            }
        }
        if (uri != null && uri.getData() != null) {
            Uri data = uri.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri uriZze2 = zze(zzd(zzcgyVar.getContext(), zzcgyVar.zzS(), data, zzcgyVar.zzE(), zzcgyVar.zzj(), zzcgyVar.zzT()));
                if (TextUtils.isEmpty(uri.getType())) {
                    uri.setData(uriZze2);
                } else if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzje)).booleanValue()) {
                    uri.setDataAndType(uriZze2, uri.getType());
                } else {
                    uri.setData(uriZze2);
                }
            }
        }
        boolean z7 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjz)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map2.containsKey("event_id");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznR)).booleanValue() && (zzcxnVar = this.zzg) != null) {
            zzcxnVar.zzl();
        }
        HashMap map3 = new HashMap();
        if (z7) {
            boolean z8 = z;
            obj = "event_id";
            zzbmi zzbmiVar = new zzbmi(this, z8, zzaVar2, map3, map2);
            zzaVar2 = zzaVar2;
            map2 = map2;
            this.zzh = zzbmiVar;
        } else {
            boolean z9 = z;
            obj = "event_id";
            zZza = z9;
        }
        if (uri != null) {
            if (!z6 || this.zze == null || !zzi(zzaVar2, zzcgyVar.getContext(), uri.getData().toString(), str5)) {
                ((zzcio) zzaVar2).zzaH(new com.google.android.gms.ads.internal.overlay.zzc(uri, this.zzh), zZza, z5, str5);
                return;
            } else {
                if (z7) {
                    map3.put((String) map2.get(obj), true);
                    ((zzbot) zzaVar2).zze("openIntentAsync", map3);
                    return;
                }
                return;
            }
        }
        String string2 = !TextUtils.isEmpty(str) ? zze(zzd(zzcgyVar.getContext(), zzcgyVar.zzS(), Uri.parse(str), zzcgyVar.zzE(), zzcgyVar.zzj(), zzcgyVar.zzT())).toString() : str;
        if (!z6 || this.zze == null || !zzi(zzaVar2, zzcgyVar.getContext(), string2, str5)) {
            ((zzcio) zzaVar2).zzaH(new com.google.android.gms.ads.internal.overlay.zzc((String) map2.get("i"), string2, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get("f"), (String) map2.get("e"), this.zzh), zZza, z5, str5);
        } else if (z7) {
            map3.put((String) map2.get(obj), true);
            ((zzbot) zzaVar2).zze("openIntentAsync", map3);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzjt)).booleanValue() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzjo)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzjn)).booleanValue()) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zzi(com.google.android.gms.ads.internal.client.zza r10, android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmk.zzi(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    private final void zzj(Context context, String str, String str2) {
        zzefy zzefyVar = this.zze;
        zzefyVar.zzd(str);
        zzdvi zzdviVar = this.zzb;
        if (zzdviVar != null) {
            zzegj.zzk(context, zzdviVar, zzefyVar, str, "dialog_not_shown", zzgph.zzb("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0153  */
    private final void zzk(com.google.android.gms.ads.internal.client.zza zzaVar, Map map, boolean z, String str, boolean z2, boolean z3) {
        boolean z4;
        Uri uriBuild;
        zzcgy zzcgyVar;
        Intent intentZzd;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo resolveInfoZzb;
        zzl(true);
        zzcgy zzcgyVar2 = (zzcgy) zzaVar;
        Context context = zzcgyVar2.getContext();
        zzaxa zzaxaVarZzS = zzcgyVar2.zzS();
        View viewZzE = zzcgyVar2.zzE();
        zzfgr zzfgrVarZzT = zzcgyVar2.zzT();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str2 = (String) map.get("u");
        if (TextUtils.isEmpty(str2)) {
            zzcgyVar = zzcgyVar2;
            intentZzd = null;
        } else {
            Uri uriZze = zze(zzd(context, zzaxaVarZzS, Uri.parse(str2), viewZzE, null, zzfgrVarZzT));
            boolean z5 = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean z6 = Boolean.parseBoolean((String) map.get("use_running_process"));
            if (Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
                z4 = true;
            } else if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfe)).booleanValue()) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (ProxyConfig.MATCH_HTTP.equalsIgnoreCase(uriZze.getScheme())) {
                uriBuild = uriZze.buildUpon().scheme(ProxyConfig.MATCH_HTTPS).build();
            } else {
                uriBuild = ProxyConfig.MATCH_HTTPS.equalsIgnoreCase(uriZze.getScheme()) ? uriZze.buildUpon().scheme(ProxyConfig.MATCH_HTTP).build() : null;
            }
            ArrayList arrayList = new ArrayList();
            Intent intentZza = zzbmj.zza(uriZze, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
            Intent intentZza2 = zzbmj.zza(uriBuild, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
            if (z4) {
                com.google.android.gms.ads.internal.zzt.zzc();
                com.google.android.gms.ads.internal.util.zzs.zzs(context, intentZza);
                com.google.android.gms.ads.internal.zzt.zzc();
                com.google.android.gms.ads.internal.util.zzs.zzs(context, intentZza2);
            }
            ResolveInfo resolveInfoZzc = zzbmj.zzc(intentZza, arrayList, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
            if (resolveInfoZzc != null) {
                intentZzd = zzbmj.zzd(intentZza, resolveInfoZzc, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
            } else {
                if (intentZza2 != null && (resolveInfoZzb = zzbmj.zzb(intentZza2, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT)) != null) {
                    intentZzd = zzbmj.zzd(intentZza, resolveInfoZzb, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
                    if (zzbmj.zzb(intentZzd, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT) == null) {
                    }
                }
                if (arrayList.isEmpty()) {
                    zzcgyVar = zzcgyVar2;
                } else if (!z6 || activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    zzcgyVar = zzcgyVar2;
                    if (z5) {
                        intentZzd = zzbmj.zzd(intentZza, (ResolveInfo) arrayList.get(0), context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
                    }
                } else {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i < size) {
                            ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                int i2 = i + 1;
                                if (it.hasNext()) {
                                    zzcgyVar = zzcgyVar2;
                                    if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                        intentZzd = zzbmj.zzd(intentZza, resolveInfo, context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
                                    } else {
                                        zzcgyVar2 = zzcgyVar;
                                    }
                                } else {
                                    i = i2;
                                }
                            }
                        } else {
                            zzcgyVar = zzcgyVar2;
                            if (z5) {
                                intentZzd = zzbmj.zzd(intentZza, (ResolveInfo) arrayList.get(0), context, zzaxaVarZzS, viewZzE, zzfgrVarZzT);
                            }
                        }
                    }
                }
                intentZzd = intentZza;
            }
            zzcgyVar = zzcgyVar2;
        }
        if (!z || this.zze == null || intentZzd == null || !zzi(zzaVar, zzcgyVar.getContext(), intentZzd.getData().toString(), str)) {
            try {
                ((zzcio) zzaVar).zzaH(new com.google.android.gms.ads.internal.overlay.zzc(intentZzd, this.zzh), z2, z3, str);
            } catch (ActivityNotFoundException e) {
                String message = e.getMessage();
                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            }
        }
    }

    private final void zzl(boolean z) {
        zzbuh zzbuhVar = this.zzd;
        if (zzbuhVar != null) {
            zzbuhVar.zzb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzg(int i) {
        zzdvi zzdviVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfh)).booleanValue() || (zzdviVar = this.zzb) == null) {
            return;
        }
        zzdvh zzdvhVarZza = zzdviVar.zza();
        zzdvhVarZza.zzc("action", "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdvhVarZza.zzc("cct_open_status", str);
        zzdvhVarZza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcpe zzcpeVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcgy zzcgyVar = (zzcgy) zzaVar;
        if (zzcgyVar.zzC() != null) {
            map2 = zzcgyVar.zzC().zzaw;
        }
        String strZza = zzcah.zza(str, zzcgyVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzb()) {
            zzgui.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlb)).booleanValue() && (zzcpeVar = this.zzf) != null && zzcpe.zzc(strZza)) ? zzcpeVar.zzb(strZza, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgui.zza(strZza), new zzbmg(this, map, zzaVar, str2), this.zzi);
        } else {
            zzbVar.zzc(strZza);
        }
    }
}
