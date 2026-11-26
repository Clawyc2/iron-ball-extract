package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import androidx.work.impl.Scheduler;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import kotlinx.coroutines.scheduling.WorkQueueKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
@ParametersAreNonnullByDefault
public class zzchj extends WebViewClient implements zzciw {
    public static final /* synthetic */ int zzc = 0;
    private zzdvi zzA;
    private boolean zzB;
    private boolean zzC;
    private int zzD;
    private boolean zzE;
    private final zzegj zzG;
    private View.OnAttachStateChangeListener zzH;
    protected final zzcgy zza;
    protected zzbzt zzb;
    private final zzbdt zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzr zzh;
    private zzciu zzi;
    private zzciv zzj;
    private zzbkn zzk;
    private zzbkp zzl;
    private zzdgv zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private com.google.android.gms.ads.internal.overlay.zzad zzw;
    private zzbum zzx;
    private com.google.android.gms.ads.internal.zzb zzy;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbuh zzz = null;
    private final HashSet zzF = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgm)).split(",")));

    public zzchj(zzcgy zzcgyVar, zzbdt zzbdtVar, boolean z, zzbum zzbumVar, zzbuh zzbuhVar, zzegj zzegjVar) {
        this.zzd = zzbdtVar;
        this.zza = zzcgyVar;
        this.zzs = z;
        this.zzx = zzbumVar;
        this.zzG = zzegjVar;
    }

    private final void zzaa(final View view, final zzbzt zzbztVar, final int i) {
        if (!zzbztVar.zzc() || i <= 0) {
            return;
        }
        zzbztVar.zzd(view);
        if (zzbztVar.zzc()) {
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzS(view, zzbztVar, i);
                }
            }, 100L);
        }
    }

    private final void zzab() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzH;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zza).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    private static WebResourceResponse zzac() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbb)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzad(String str, Map map) throws Throwable {
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                int i2 = zzfue.zzb;
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(10000);
                uRLConnectionOpenConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                com.google.android.gms.ads.internal.util.zzs zzsVarZzc = com.google.android.gms.ads.internal.zzt.zzc();
                try {
                    zzcgy zzcgyVar = this.zza;
                    zzsVarZzc.zzb(zzcgyVar.getContext(), zzcgyVar.zzs().afmaVersion, false, httpURLConnection, false, 60000);
                    WebResourceResponse webResourceResponseZzc = null;
                    com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                    zzlVar.zza(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzlVar.zzc(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        com.google.android.gms.ads.internal.zzt.zzc();
                        com.google.android.gms.ads.internal.zzt.zzc();
                        String contentType = httpURLConnection.getContentType();
                        String strTrim = "";
                        String strTrim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
                        com.google.android.gms.ads.internal.zzt.zzc();
                        String contentType2 = httpURLConnection.getContentType();
                        if (!TextUtils.isEmpty(contentType2)) {
                            String[] strArrSplit = contentType2.split(";");
                            if (strArrSplit.length != 1) {
                                for (int i3 = 1; i3 < strArrSplit.length; i3++) {
                                    if (strArrSplit[i3].trim().startsWith("charset")) {
                                        String[] strArrSplit2 = strArrSplit[i3].trim().split("=");
                                        if (strArrSplit2.length > 1) {
                                            strTrim = strArrSplit2[1].trim();
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        String str2 = strTrim;
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        HashMap map2 = new HashMap(headerFields.size());
                        for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                            if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                                map2.put(entry2.getKey(), entry2.getValue().get(0));
                            }
                        }
                        webResourceResponseZzc = com.google.android.gms.ads.internal.zzt.zzf().zzc(strTrim2, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), map2, httpURLConnection.getInputStream());
                    } else {
                        String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        }
                        if (!headerField.startsWith("tel:")) {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Protocol is null");
                                webResourceResponseZzc = zzac();
                            } else if (protocol.equals(ProxyConfig.MATCH_HTTP) || protocol.equals(ProxyConfig.MATCH_HTTPS)) {
                                StringBuilder sb = new StringBuilder(headerField.length() + 15);
                                sb.append("Redirecting to ");
                                sb.append(headerField);
                                String string = sb.toString();
                                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                StringBuilder sb2 = new StringBuilder(protocol.length() + 20);
                                sb2.append("Unsupported scheme: ");
                                sb2.append(protocol);
                                String string2 = sb2.toString();
                                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzi(string2);
                                webResourceResponseZzc = zzac();
                            }
                        }
                    }
                    TrafficStats.clearThreadStatsTag();
                    return webResourceResponseZzc;
                } catch (Throwable th) {
                    th = th;
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzae, reason: merged with bridge method [inline-methods] */
    public final void zzY(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                String str3 = (String) map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                com.google.android.gms.ads.internal.util.zze.zza(sb.toString());
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzblx) it.next()).zza(this.zza, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final /* synthetic */ void zzW(boolean z, long j) {
        this.zza.zzu(z, j);
    }

    private static final boolean zzag(zzcgy zzcgyVar) {
        return zzcgyVar.zzC() != null && zzcgyVar.zzC().zzb();
    }

    private static final boolean zzah(boolean z, zzcgy zzcgyVar) {
        return (!z || zzcgyVar.zzN().zzg() || zzcgyVar.zzO().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String.valueOf(str);
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzO(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            zzcgy zzcgyVar = this.zza;
            if (zzcgyVar.zzX()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                zzcgyVar.zzY();
                return;
            }
            this.zzB = true;
            zzciv zzcivVar = this.zzj;
            if (zzcivVar != null) {
                zzcivVar.zza();
                this.zzj = null;
            }
            zzu();
            zzcgy zzcgyVar2 = this.zza;
            if (zzcgyVar2.zzL() != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmU)).booleanValue()) {
                    zzcgyVar2.zzL().zzz(str);
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzJ(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case WorkQueueKt.MASK /* 127 */:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String.valueOf(str);
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZzd = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZzd.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZzd.getHost())) {
            zzO(uriZzd);
        } else {
            if (this.zzn && webView == this.zza.zzD()) {
                String scheme = uriZzd.getScheme();
                if (ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) || ProxyConfig.MATCH_HTTPS.equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzbzt zzbztVar = this.zzb;
                        if (zzbztVar != null) {
                            zzbztVar.zzb(str);
                        }
                        this.zzg = null;
                    }
                    zzdgv zzdgvVar = this.zzm;
                    if (zzdgvVar != null) {
                        zzdgvVar.zzdz();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            zzcgy zzcgyVar = this.zza;
            if (zzcgyVar.zzD().willNotDraw()) {
                String.valueOf(str);
                com.google.android.gms.ads.internal.util.client.zzo.zzi("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzaxa zzaxaVarZzS = zzcgyVar.zzS();
                    zzfgr zzfgrVarZzT = zzcgyVar.zzT();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmY)).booleanValue() || zzfgrVarZzT == null) {
                        if (zzaxaVarZzS != null && zzaxaVarZzS.zza(uriZzd)) {
                            uriZzd = zzaxaVarZzS.zzd(uriZzd, zzcgyVar.getContext(), (View) zzcgyVar, zzcgyVar.zzj());
                        }
                    } else if (zzaxaVarZzS != null && zzaxaVarZzS.zza(uriZzd)) {
                        uriZzd = zzfgrVarZzT.zza(uriZzd, zzcgyVar.getContext(), (View) zzcgyVar, zzcgyVar.zzj());
                    }
                } catch (zzaxb unused) {
                    String.valueOf(str);
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzy;
                if (zzbVar == null || zzbVar.zzb()) {
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZzd.toString(), null, null, null, null, null, null);
                    zzcgy zzcgyVar2 = this.zza;
                    zzv(zzcVar, true, false, zzcgyVar2 != null ? zzcgyVar2.zzn() : "");
                } else {
                    zzbVar.zzc(str);
                }
            }
        }
        return true;
    }

    public final void zzA(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbuh zzbuhVar = this.zzz;
        boolean zZzd = zzbuhVar != null ? zzbuhVar.zzd() : false;
        com.google.android.gms.ads.internal.zzt.zzb();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zza.getContext(), adOverlayInfoParcel, !zZzd, this.zzA);
        zzbzt zzbztVar = this.zzb;
        if (zzbztVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzbztVar.zzb(str);
        }
    }

    public final void zzB(String str, zzblx zzblxVar) {
        synchronized (this.zzf) {
            HashMap map = this.zze;
            List copyOnWriteArrayList = (List) map.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                map.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzblxVar);
        }
    }

    public final void zzC(String str, zzblx zzblxVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzblxVar);
        }
    }

    public final void zzD(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.clear();
        }
    }

    public final void zzE(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzblx> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzblx zzblxVar : list) {
                if (predicate.apply(zzblxVar)) {
                    arrayList.add(zzblxVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void zzF() {
        zzbzt zzbztVar = this.zzb;
        if (zzbztVar != null) {
            zzbztVar.zzf();
            this.zzb = null;
        }
        zzab();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzu = false;
            this.zzw = null;
            this.zzy = null;
            this.zzx = null;
            zzbuh zzbuhVar = this.zzz;
            if (zzbuhVar != null) {
                zzbuhVar.zzb(true);
                this.zzz = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzG(zzciu zzciuVar) {
        this.zzi = zzciuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzH(zzciv zzcivVar) {
        this.zzj = zzcivVar;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final zzdvi zzI() {
        return this.zzA;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0095  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fb A[Catch: all -> 0x01e1, TryCatch #3 {all -> 0x01e1, blocks: (B:59:0x018c, B:61:0x019e, B:62:0x01a5, B:71:0x01e9, B:73:0x01fb, B:74:0x0202), top: B:103:0x00df }] */
    /* JADX WARN: Code duplicated, block: B:88:0x02bb A[Catch: Exception | NoClassDefFoundError -> 0x02e5, Exception -> 0x02e7, TryCatch #12 {Exception | NoClassDefFoundError -> 0x02e5, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:10:0x0036, B:12:0x0044, B:14:0x0060, B:16:0x0079, B:18:0x0090, B:19:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:63:0x01b0, B:43:0x016f, B:88:0x02bb, B:91:0x02cb, B:93:0x02d1, B:95:0x02df, B:76:0x0238, B:77:0x026b, B:75:0x0206, B:42:0x013e, B:27:0x00d3, B:78:0x026c, B:80:0x0276, B:82:0x027c, B:84:0x02af), top: B:106:0x000c }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02d1 A[Catch: Exception | NoClassDefFoundError -> 0x02e5, Exception -> 0x02e7, TryCatch #12 {Exception | NoClassDefFoundError -> 0x02e5, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:10:0x0036, B:12:0x0044, B:14:0x0060, B:16:0x0079, B:18:0x0090, B:19:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:63:0x01b0, B:43:0x016f, B:88:0x02bb, B:91:0x02cb, B:93:0x02d1, B:95:0x02df, B:76:0x0238, B:77:0x026b, B:75:0x0206, B:42:0x013e, B:27:0x00d3, B:78:0x026c, B:80:0x0276, B:82:0x027c, B:84:0x02af), top: B:106:0x000c }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    protected final WebResourceResponse zzJ(String str, Map map) {
        WebResourceResponse webResourceResponse;
        int i;
        InputStream inputStream;
        InputStream inputStreamZzb;
        Long l;
        final boolean z;
        final boolean z2;
        String string;
        try {
            Map map2 = new HashMap();
            zzcgy zzcgyVar = this.zza;
            if (zzcgyVar.zzC() != null) {
                map2 = zzcgyVar.zzC().zzaw;
            }
            String strZza = zzcah.zza(str, zzcgyVar.getContext(), this.zzE, map2);
            if (!strZza.equals(str)) {
                return zzad(strZza, map);
            }
            Parcelable.Creator<zzbdf> creator = zzbdf.CREATOR;
            zzbdf zzbdfVarZza = zzbdf.zza(Uri.parse(str));
            if (zzbdfVarZza != null) {
                HashMap map3 = new HashMap();
                map3.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, ProxyConfig.MATCH_ALL_SCHEMES);
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameterNames().contains("range")) {
                    List listZze = zzgms.zza(zzglr.zzc('-')).zze(uri.getQueryParameter("range"));
                    if (listZze.size() == 2) {
                        int i2 = Integer.parseInt((String) listZze.get(0));
                        int i3 = Integer.parseInt((String) listZze.get(1)) + 1;
                        if (i2 > 0) {
                            zzbdfVarZza.zzh = i2;
                        }
                        i = i3 - i2;
                    } else {
                        i = -1;
                    }
                } else {
                    i = -1;
                }
                final boolean z3 = "X-Afma-Gcache-CachedBytes";
                webResourceResponse = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeS)).booleanValue()) {
                    zzbdfVarZza.zzi = zzgmu.zza(zzcgyVar.zzn());
                    zzbdfVarZza.zzj = zzcgyVar.zzp();
                    if (zzbdfVarZza.zzg) {
                        l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeU);
                    } else {
                        l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeT);
                    }
                    try {
                        long jLongValue = l.longValue();
                        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
                        com.google.android.gms.ads.internal.zzt.zzz();
                        Future futureZza = zzbdq.zza(zzcgyVar.getContext(), zzbdfVarZza);
                        try {
                            zzbdr zzbdrVar = (zzbdr) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                            try {
                                try {
                                    map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbdrVar.zzc()));
                                    map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbdrVar.zzd()));
                                    map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbdrVar.zzf()));
                                    map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbdrVar.zze()));
                                    inputStreamZzb = zzbdrVar.zzb();
                                    if (i != -1) {
                                        try {
                                            inputStreamZzb = zzgsd.zzb(inputStreamZzb, i);
                                        } catch (InterruptedException e) {
                                            e = e;
                                            z2 = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                            }
                                            futureZza.cancel(true);
                                            Thread.currentThread().interrupt();
                                            final long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchd
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    this.zza.zzV(z2, jElapsedRealtime2);
                                                }
                                            });
                                            StringBuilder sb = new StringBuilder(String.valueOf(jElapsedRealtime2).length() + 24);
                                            sb.append("Cache connection took ");
                                            sb.append(jElapsedRealtime2);
                                            sb.append("ms");
                                            string = sb.toString();
                                        } catch (ExecutionException e2) {
                                            e = e2;
                                            z = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                            }
                                            futureZza.cancel(true);
                                            final long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    this.zza.zzU(z, jElapsedRealtime3);
                                                }
                                            });
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(jElapsedRealtime3).length() + 24);
                                            sb2.append("Cache connection took ");
                                            sb2.append(jElapsedRealtime3);
                                            sb2.append("ms");
                                            string = sb2.toString();
                                        } catch (TimeoutException e3) {
                                            e = e3;
                                            z = true;
                                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                            }
                                            futureZza.cancel(true);
                                            final long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
                                                @Override // java.lang.Runnable
                                                public final /* synthetic */ void run() {
                                                    this.zza.zzU(z, jElapsedRealtime4);
                                                }
                                            });
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(jElapsedRealtime4).length() + 24);
                                            sb3.append("Cache connection took ");
                                            sb3.append(jElapsedRealtime4);
                                            sb3.append("ms");
                                            string = sb3.toString();
                                        }
                                    }
                                    final long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                    final boolean z4 = true;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable(z4, jElapsedRealtime5) { // from class: com.google.android.gms.internal.ads.zzchb
                                        private final /* synthetic */ long zzb;

                                        {
                                            this.zzb = jElapsedRealtime5;
                                        }

                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzT(true, this.zzb);
                                        }
                                    });
                                    StringBuilder sb4 = new StringBuilder(String.valueOf(jElapsedRealtime5).length() + 24);
                                    sb4.append("Cache connection took ");
                                    sb4.append(jElapsedRealtime5);
                                    sb4.append("ms");
                                    string = sb4.toString();
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = 1;
                                    final long jElapsedRealtime6 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzche
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            this.zza.zzW(z3, jElapsedRealtime6);
                                        }
                                    });
                                    StringBuilder sb5 = new StringBuilder(String.valueOf(jElapsedRealtime6).length() + 24);
                                    sb5.append("Cache connection took ");
                                    sb5.append(jElapsedRealtime6);
                                    sb5.append("ms");
                                    com.google.android.gms.ads.internal.util.zze.zza(sb5.toString());
                                    throw th;
                                }
                            } catch (InterruptedException e4) {
                                e = e4;
                                inputStreamZzb = null;
                            } catch (ExecutionException e5) {
                                e = e5;
                                inputStreamZzb = null;
                                z = true;
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                }
                                futureZza.cancel(true);
                                final long jElapsedRealtime7 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzU(z, jElapsedRealtime7);
                                    }
                                });
                                StringBuilder sb6 = new StringBuilder(String.valueOf(jElapsedRealtime7).length() + 24);
                                sb6.append("Cache connection took ");
                                sb6.append(jElapsedRealtime7);
                                sb6.append("ms");
                                string = sb6.toString();
                                com.google.android.gms.ads.internal.util.zze.zza(string);
                                inputStream = inputStreamZzb;
                                if (inputStream != null) {
                                    return new WebResourceResponse("", "", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "OK", map3, inputStream);
                                }
                                if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                                }
                            } catch (TimeoutException e6) {
                                e = e6;
                                inputStreamZzb = null;
                                z = true;
                                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                                }
                                futureZza.cancel(true);
                                final long jElapsedRealtime8 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        this.zza.zzU(z, jElapsedRealtime8);
                                    }
                                });
                                StringBuilder sb7 = new StringBuilder(String.valueOf(jElapsedRealtime8).length() + 24);
                                sb7.append("Cache connection took ");
                                sb7.append(jElapsedRealtime8);
                                sb7.append("ms");
                                string = sb7.toString();
                                com.google.android.gms.ads.internal.util.zze.zza(string);
                                inputStream = inputStreamZzb;
                                if (inputStream != null) {
                                    return new WebResourceResponse("", "", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "OK", map3, inputStream);
                                }
                                if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                                }
                            }
                        } catch (InterruptedException e7) {
                            e = e7;
                            inputStreamZzb = null;
                            z2 = false;
                        } catch (ExecutionException e8) {
                            e = e8;
                            inputStreamZzb = null;
                            z = false;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                            }
                            futureZza.cancel(true);
                            final long jElapsedRealtime9 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzU(z, jElapsedRealtime9);
                                }
                            });
                            StringBuilder sb8 = new StringBuilder(String.valueOf(jElapsedRealtime9).length() + 24);
                            sb8.append("Cache connection took ");
                            sb8.append(jElapsedRealtime9);
                            sb8.append("ms");
                            string = sb8.toString();
                            com.google.android.gms.ads.internal.util.zze.zza(string);
                            inputStream = inputStreamZzb;
                            if (inputStream != null) {
                                return new WebResourceResponse("", "", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "OK", map3, inputStream);
                            }
                            if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                            }
                        } catch (TimeoutException e9) {
                            e = e9;
                            inputStreamZzb = null;
                            z = false;
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeX)).booleanValue()) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AdWebViewClient.interceptRequest.gcache");
                            }
                            futureZza.cancel(true);
                            final long jElapsedRealtime10 = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - jElapsedRealtime;
                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzU(z, jElapsedRealtime10);
                                }
                            });
                            StringBuilder sb9 = new StringBuilder(String.valueOf(jElapsedRealtime10).length() + 24);
                            sb9.append("Cache connection took ");
                            sb9.append(jElapsedRealtime10);
                            sb9.append("ms");
                            string = sb9.toString();
                            com.google.android.gms.ads.internal.util.zze.zza(string);
                            inputStream = inputStreamZzb;
                            if (inputStream != null) {
                                return new WebResourceResponse("", "", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "OK", map3, inputStream);
                            }
                            if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z3 = 0;
                        }
                        com.google.android.gms.ads.internal.util.zze.zza(string);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    zzbdc zzbdcVarZzc = com.google.android.gms.ads.internal.zzt.zzj().zzc(zzbdfVarZza);
                    if (zzbdcVarZzc == null || !zzbdcVarZzc.zza()) {
                        inputStream = null;
                    } else {
                        map3.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbdcVarZzc.zzd()));
                        map3.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbdcVarZzc.zzg()));
                        map3.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbdcVarZzc.zze()));
                        map3.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbdcVarZzc.zzf()));
                        inputStreamZzb = zzbdcVarZzc.zzb();
                        if (i != -1) {
                            inputStreamZzb = zzgsd.zzb(inputStreamZzb, i);
                        }
                    }
                    if (inputStream != null) {
                        return new WebResourceResponse("", "", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "OK", map3, inputStream);
                    }
                }
                inputStream = inputStreamZzb;
                if (inputStream != null) {
                    return new WebResourceResponse("", "", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "OK", map3, inputStream);
                }
            } else {
                webResourceResponse = null;
            }
            return (com.google.android.gms.ads.internal.util.client.zzl.zzj() || !((Boolean) zzbgq.zzb.zze()).booleanValue()) ? webResourceResponse : zzad(str, map);
        } catch (Exception | NoClassDefFoundError e10) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e10, "AdWebViewClient.interceptRequest");
            return zzac();
        }
    }

    public final void zzK(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzL() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchf
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcgy zzcgyVar = this.zza.zza;
                    zzcgyVar.zzah();
                    com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = zzcgyVar.zzL();
                    if (zzmVarZzL != null) {
                        zzmVarZzL.zzv();
                    }
                }
            });
        }
    }

    public final void zzM(boolean z) {
        this.zzE = z;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzN(int i, int i2) {
        zzbuh zzbuhVar = this.zzz;
        if (zzbuhVar != null) {
            zzbuhVar.zze(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzO(Uri uri) {
        String strValueOf = String.valueOf(uri);
        String.valueOf(strValueOf);
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(strValueOf)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            String strValueOf2 = String.valueOf(uri);
            String.valueOf(strValueOf2);
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(strValueOf2)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhl)).booleanValue() || com.google.android.gms.ads.internal.zzt.zzh().zza() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcbv.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchg
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() throws Throwable {
                    int i = zzchj.zzc;
                    com.google.android.gms.ads.internal.zzt.zzh().zza().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgl)).booleanValue() && this.zzF.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgn)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgui.zzr(com.google.android.gms.ads.internal.zzt.zzc().zzf(uri), new zzcha(this, list, path, uri), zzcbv.zzf);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        zzY(com.google.android.gms.ads.internal.util.zzs.zzU(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzP(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzQ(boolean z) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzR(boolean z) {
        synchronized (this.zzf) {
            this.zzv = z;
        }
    }

    final /* synthetic */ void zzS(View view, zzbzt zzbztVar, int i) {
        zzaa(view, zzbztVar, i - 1);
    }

    final /* synthetic */ void zzT(boolean z, long j) {
        zzW(true, j);
    }

    final /* synthetic */ void zzX(View view, zzbzt zzbztVar, int i) {
        zzaa(view, zzbztVar, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzZ(com.google.android.gms.ads.internal.client.zza zzaVar, zzbkn zzbknVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbkp zzbkpVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, boolean z, zzbma zzbmaVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbuo zzbuoVar, zzbzt zzbztVar, zzefy zzefyVar, zzfng zzfngVar, zzdvi zzdviVar, zzbms zzbmsVar, zzdgv zzdgvVar, zzbmr zzbmrVar, zzbml zzbmlVar, zzbly zzblyVar, zzcpe zzcpeVar, zzdwl zzdwlVar, zzcxn zzcxnVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zza.getContext(), zzbztVar, null) : zzbVar;
        zzcgy zzcgyVar = this.zza;
        this.zzz = new zzbuh(zzcgyVar, zzbuoVar);
        this.zzb = zzbztVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbk)).booleanValue()) {
            zzB("/adMetadata", new zzbkm(zzbknVar));
        }
        if (zzbkpVar != null) {
            zzB("/appEvent", new zzbko(zzbkpVar));
        }
        zzB("/backButton", zzblw.zzj);
        zzB("/refresh", zzblw.zzk);
        zzB("/canOpenApp", zzblw.zzb);
        zzB("/canOpenURLs", zzblw.zza);
        zzB("/canOpenIntents", zzblw.zzc);
        zzB("/close", zzblw.zzd);
        zzB("/customClose", zzblw.zze);
        zzB("/instrument", zzblw.zzn);
        zzB("/delayPageLoaded", zzblw.zzp);
        zzB("/delayPageClosed", zzblw.zzq);
        zzB("/getLocationInfo", zzblw.zzr);
        zzB("/log", zzblw.zzg);
        zzB("/mraid", new zzbme(zzbVar2, this.zzz, zzbuoVar));
        zzbum zzbumVar = this.zzx;
        if (zzbumVar != null) {
            zzB("/mraidLoaded", zzbumVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzB("/open", new zzbmk(zzbVar3, this.zzz, zzefyVar, zzdviVar, zzcpeVar, zzcxnVar));
        zzB("/precache", new zzcff());
        zzB("/touch", zzblw.zzi);
        zzB("/video", zzblw.zzl);
        zzB("/videoMeta", zzblw.zzm);
        if (zzefyVar == null || zzfngVar == null) {
            zzB("/click", zzblw.zzb(zzdgvVar, zzcpeVar));
            zzB("/httpTrack", zzblw.zzf);
        } else {
            zzB("/click", zzfgy.zza(zzefyVar, zzfngVar, zzcpeVar, zzdgvVar));
            zzB("/httpTrack", zzfgy.zzb(zzefyVar, zzfngVar));
        }
        if (com.google.android.gms.ads.internal.zzt.zzD().zza(zzcgyVar.getContext())) {
            Map map = new HashMap();
            if (zzcgyVar.zzC() != null) {
                map = zzcgyVar.zzC().zzaw;
            }
            zzB("/logScionEvent", new zzbmd(zzcgyVar.getContext(), map));
        }
        if (zzbmaVar != null) {
            zzB("/setInterstitialProperties", new zzblz(zzbmaVar));
        }
        if (zzbmsVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjT)).booleanValue()) {
                zzB("/inspectorNetworkExtras", zzbmsVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkm)).booleanValue() && zzbmrVar != null) {
            zzB("/shareSheet", zzbmrVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziu)).booleanValue() && zzdwlVar != null) {
            zzB("/onDeviceStorageEvent", new zzbmf(zzdwlVar));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkr)).booleanValue() && zzbmlVar != null) {
            zzB("/inspectorOutOfContextTest", zzbmlVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkw)).booleanValue() && zzblyVar != null) {
            zzB("/inspectorStorage", zzblyVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmz)).booleanValue()) {
            zzB("/bindPlayStoreOverlay", zzblw.zzu);
            zzB("/presentPlayStoreOverlay", zzblw.zzv);
            zzB("/expandPlayStoreOverlay", zzblw.zzw);
            zzB("/collapsePlayStoreOverlay", zzblw.zzx);
            zzB("/closePlayStoreOverlay", zzblw.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdN)).booleanValue()) {
            zzB("/setPAIDPersonalizationEnabled", zzblw.zzA);
            zzB("/resetPAID", zzblw.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmT)).booleanValue() && zzcgyVar.zzC() != null && zzcgyVar.zzC().zzar) {
            zzB("/writeToLocalStorage", zzblw.zzB);
            zzB("/clearLocalStorageKeys", zzblw.zzC);
        }
        this.zzg = zzaVar;
        this.zzh = zzrVar;
        this.zzk = zzbknVar;
        this.zzl = zzbkpVar;
        this.zzw = zzadVar;
        this.zzy = zzbVar3;
        this.zzm = zzdgvVar;
        this.zzA = zzdviVar;
        this.zzn = z;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zza(int i, int i2, boolean z) {
        zzbum zzbumVar = this.zzx;
        if (zzbumVar != null) {
            zzbumVar.zzb(i, i2);
        }
        zzbuh zzbuhVar = this.zzz;
        if (zzbuhVar != null) {
            zzbuhVar.zzc(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzb(zzffu zzffuVar) {
        zzcgy zzcgyVar = this.zza;
        if (com.google.android.gms.ads.internal.zzt.zzD().zza(zzcgyVar.getContext())) {
            zzD("/logScionEvent");
            new HashMap();
            zzB("/logScionEvent", new zzbmd(zzcgyVar.getContext(), zzffuVar.zzaw));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzc(zzcpe zzcpeVar) {
        zzD("/click");
        zzB("/click", zzblw.zzb(this.zzm, zzcpeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzd(zzcpe zzcpeVar, zzefy zzefyVar, zzfng zzfngVar) {
        zzD("/click");
        if (zzefyVar == null || zzfngVar == null) {
            zzB("/click", zzblw.zzb(this.zzm, zzcpeVar));
        } else {
            zzB("/click", zzfgy.zza(zzefyVar, zzfngVar, zzcpeVar, this.zzm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final void zzdV() {
        zzdgv zzdgvVar = this.zzm;
        if (zzdgvVar != null) {
            zzdgvVar.zzdV();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final void zzdz() {
        zzdgv zzdgvVar = this.zzm;
        if (zzdgvVar != null) {
            zzdgvVar.zzdz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zze(zzcpe zzcpeVar, zzefy zzefyVar, zzdvi zzdviVar) {
        zzD("/open");
        zzB("/open", new zzbmk(this.zzy, this.zzz, zzefyVar, zzdviVar, zzcpeVar, null));
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final com.google.android.gms.ads.internal.zzb zzh() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzi(com.google.android.gms.ads.internal.zzb zzbVar) {
        this.zzy = zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzj(zzbzt zzbztVar) {
        this.zzb = zzbztVar;
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final boolean zzk() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    public final boolean zzm() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzn() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzv;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzo() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzp() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzq() {
        zzbzt zzbztVar = this.zzb;
        if (zzbztVar != null) {
            zzcgy zzcgyVar = this.zza;
            WebView webViewZzD = zzcgyVar.zzD();
            if (ViewCompat.isAttachedToWindow(webViewZzD)) {
                zzaa(webViewZzD, zzbztVar, 10);
                return;
            }
            zzab();
            zzcgz zzcgzVar = new zzcgz(this, zzbztVar);
            this.zzH = zzcgzVar;
            ((View) zzcgyVar).addOnAttachStateChangeListener(zzcgzVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzr() {
        synchronized (this.zzf) {
        }
        this.zzD++;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzs() {
        this.zzD--;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzciw
    public final void zzt() {
        zzbdt zzbdtVar = this.zzd;
        if (zzbdtVar != null) {
            zzbdtVar.zzc(10005);
        }
        this.zzC = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzu();
        this.zza.destroy();
    }

    public final void zzu() {
        if (this.zzi != null && ((this.zzB && this.zzD <= 0) || this.zzC || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzch)).booleanValue()) {
                zzcgy zzcgyVar = this.zza;
                if (zzcgyVar.zzq() != null) {
                    zzbfb.zza(zzcgyVar.zzq().zzc(), zzcgyVar.zzi(), "awfllc");
                }
            }
            this.zzi.zza((this.zzC || this.zzo) ? false : true, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zza.zzap();
    }

    public final void zzv(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        zzcgy zzcgyVar = this.zza;
        boolean zZzW = zzcgyVar.zzW();
        boolean z3 = false;
        boolean z4 = zzah(zZzW, zzcgyVar) || z2;
        if (z4 || !z) {
            z3 = true;
        }
        zzA(new AdOverlayInfoParcel(zzcVar, z4 ? null : this.zzg, zZzW ? null : this.zzh, this.zzw, zzcgyVar.zzs(), zzcgyVar, z3 ? null : this.zzm, str));
    }

    public final void zzw(String str, String str2, int i) {
        zzegj zzegjVar = this.zzG;
        zzcgy zzcgyVar = this.zza;
        zzA(new AdOverlayInfoParcel(zzcgyVar, zzcgyVar.zzs(), str, str2, 14, zzegjVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbvb] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final void zzx(boolean z, int i, boolean z2) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzdgv zzdgvVar;
        zzcgy zzcgyVar = this.zza;
        boolean zZzah = zzah(zzcgyVar.zzW(), zzcgyVar);
        boolean z3 = true;
        if (!zZzah && z2) {
            z3 = false;
        }
        if (zZzah) {
            zzaVar = null;
            zzdgvVar = null;
        } else {
            zzaVar = this.zzg;
            zzdgvVar = null;
        }
        zzdgv zzdgvVar2 = zzdgvVar;
        zzA(new AdOverlayInfoParcel(zzaVar, this.zzh, this.zzw, zzcgyVar, z, i, zzcgyVar.zzs(), z3 ? zzdgvVar2 : this.zzm, zzag(zzcgyVar) ? this.zzG : zzdgvVar2));
    }

    public final void zzy(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcgy zzcgyVar = this.zza;
        boolean zZzW = zzcgyVar.zzW();
        boolean zZzah = zzah(zZzW, zzcgyVar);
        boolean z4 = true;
        if (!zZzah && z2) {
            z4 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzah ? null : this.zzg;
        zzchi zzchiVar = zZzW ? null : new zzchi(zzcgyVar, this.zzh);
        zzbkn zzbknVar = this.zzk;
        zzegj zzegjVar = null;
        zzbkp zzbkpVar = this.zzl;
        boolean z5 = z4;
        zzchi zzchiVar2 = zzchiVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzcgyVar.zzs();
        zzdgv zzdgvVar = z5 ? null : this.zzm;
        if (zzag(zzcgyVar)) {
            zzegjVar = this.zzG;
        }
        zzA(new AdOverlayInfoParcel(zzaVar, zzchiVar2, zzbknVar, zzbkpVar, zzadVar, zzcgyVar, z, i, str, versionInfoParcelZzs, zzdgvVar, zzegjVar, z3));
    }

    public final void zzz(boolean z, int i, String str, String str2, boolean z2) {
        zzcgy zzcgyVar = this.zza;
        boolean zZzW = zzcgyVar.zzW();
        boolean zZzah = zzah(zZzW, zzcgyVar);
        boolean z3 = true;
        if (!zZzah && z2) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzah ? null : this.zzg;
        zzchi zzchiVar = zZzW ? null : new zzchi(zzcgyVar, this.zzh);
        zzbkn zzbknVar = this.zzk;
        zzegj zzegjVar = null;
        zzbkp zzbkpVar = this.zzl;
        boolean z4 = z3;
        zzchi zzchiVar2 = zzchiVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel versionInfoParcelZzs = zzcgyVar.zzs();
        zzdgv zzdgvVar = z4 ? null : this.zzm;
        if (zzag(zzcgyVar)) {
            zzegjVar = this.zzG;
        }
        zzA(new AdOverlayInfoParcel(zzaVar, zzchiVar2, zzbknVar, zzbkpVar, zzadVar, zzcgyVar, z, i, str, str2, versionInfoParcelZzs, zzdgvVar, zzegjVar));
    }
}
