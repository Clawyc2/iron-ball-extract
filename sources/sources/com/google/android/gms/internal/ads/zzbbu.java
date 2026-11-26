package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
@ParametersAreNonnullByDefault
public final class zzbbu extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzbbl zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;

    public zzbbu() {
        zzbbl zzbblVar = new zzbbl();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzbblVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbgl.zzd.zze()).intValue();
        this.zzg = ((Long) zzbgl.zza.zze()).intValue();
        this.zzh = ((Long) zzbgl.zze.zze()).intValue();
        this.zzi = ((Long) zzbgl.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzan)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzao)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzap)).intValue();
        this.zze = ((Long) zzbgl.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzar);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzas)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzat)).booleanValue();
        ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzau)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00f8 */
    /* JADX WARN: Code duplicated, block: B:61:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00e6 A[EXC_TOP_SPLITTER, LOOP:1: B:63:0x00e6->B:70:0x00e6, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.run():void");
    }

    public final void zza() {
        synchronized (this.zzc) {
            if (this.zza) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("Content hash thread already started, quitting...");
            } else {
                this.zza = true;
                start();
            }
        }
    }

    final void zzb(View view) {
        try {
            zzbbk zzbbkVar = new zzbbk(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZze = com.google.android.gms.ads.internal.zzt.zzg().zze();
            if (contextZze != null) {
                String str = this.zzm;
                if (!TextUtils.isEmpty(str)) {
                    String str2 = (String) view.getTag(contextZze.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaq), "id", contextZze.getPackageName()));
                    if (str2 != null && str2.equals(str)) {
                        return;
                    }
                }
            }
            zzbbt zzbbtVarZzc = zzc(view, zzbbkVar);
            zzbbkVar.zzi();
            if (zzbbtVarZzc.zza == 0 && zzbbtVarZzc.zzb == 0) {
                return;
            }
            int i = zzbbtVarZzc.zzb;
            if (i != 0) {
                if (i == 0) {
                }
                this.zzd.zzc(zzbbkVar);
            } else if (zzbbkVar.zzl() == 0) {
                return;
            }
            if (this.zzd.zza(zzbbkVar)) {
                return;
            }
            this.zzd.zzc(zzbbkVar);
        } catch (Exception e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Exception in fetchContentOnUIThread", e);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "ContentFetchTask.fetchContent");
        }
    }

    final zzbbt zzc(View view, zzbbk zzbbkVar) {
        if (view == null) {
            return new zzbbt(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzbbt(this, 0, 0);
            }
            zzbbkVar.zzg(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
            return new zzbbt(this, 1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzcgy)) {
            WebView webView = (WebView) view;
            zzbbkVar.zze();
            webView.post(new zzbbs(this, zzbbkVar, webView, globalVisibleRect));
            return new zzbbt(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) {
            return new zzbbt(this, 0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zzbbt zzbbtVarZzc = zzc(viewGroup.getChildAt(i3), zzbbkVar);
            i += zzbbtVarZzc.zza;
            i2 += zzbbtVarZzc.zzb;
        }
        return new zzbbt(this, i, i2);
    }

    final void zzd(zzbbk zzbbkVar, WebView webView, String str, boolean z) {
        zzbbk zzbbkVar2;
        zzbbkVar.zzd();
        try {
            if (TextUtils.isEmpty(str)) {
                zzbbkVar2 = zzbbkVar;
            } else {
                String strOptString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzbbkVar2 = zzbbkVar;
                    zzbbkVar2.zzf(strOptString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(strOptString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(strOptString);
                    zzbbkVar.zzf(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                    zzbbkVar2 = zzbbkVar;
                }
            }
            if (zzbbkVar2.zza()) {
                this.zzd.zzb(zzbbkVar2);
            }
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Json string may be malformed.");
        } catch (Throwable th) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Failed to get webview content.", th);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            this.zzb = true;
            StringBuilder sb = new StringBuilder(40);
            sb.append("ContentFetchThread: paused, pause = true");
            String string = sb.toString();
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
        }
    }
}
