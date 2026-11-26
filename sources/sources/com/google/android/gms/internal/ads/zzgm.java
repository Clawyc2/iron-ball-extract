package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.webkit.ProxyConfig;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgm extends zzft implements zzgu {
    private final boolean zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgt zze;
    private final zzgt zzf;
    private zzgf zzg;
    private HttpURLConnection zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;

    /* synthetic */ zzgm(String str, int i, int i2, boolean z, boolean z2, zzgt zzgtVar, zzgme zzgmeVar, boolean z3, byte[] bArr) {
        super(true);
        this.zzd = str;
        this.zzb = i;
        this.zzc = i2;
        this.zza = z;
        this.zze = zzgtVar;
        this.zzf = new zzgt();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0070  */
    private final HttpURLConnection zzk(URL url, int i, byte[] bArr, long j, long j2, boolean z, boolean z2, Map map) throws IOException {
        StringBuilder sb;
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzb);
        httpURLConnection.setReadTimeout(this.zzc);
        HashMap map2 = new HashMap();
        map2.putAll(this.zze.zza());
        map2.putAll(this.zzf.zza());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j != 0) {
            sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        } else if (j2 == -1) {
            string = null;
        } else {
            j = 0;
            sb = new StringBuilder("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        }
        if (string != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, string);
        }
        String str = this.zzd;
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, str);
        }
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, true != z ? "identity" : "gzip");
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(false);
        int i2 = zzgf.zzh;
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private final URL zzl(URL url, String str, zzgf zzgfVar) throws zzgq {
        if (str == null) {
            throw new zzgq("Null location redirect", zzgfVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!ProxyConfig.MATCH_HTTPS.equals(protocol) && !ProxyConfig.MATCH_HTTP.equals(protocol)) {
                String.valueOf(protocol);
                throw new zzgq("Unsupported protocol redirect: ".concat(String.valueOf(protocol)), zzgfVar, 2001, 1);
            }
            if (this.zza || protocol.equals(url.getProtocol())) {
                return url2;
            }
            String protocol2 = url.getProtocol();
            StringBuilder sb = new StringBuilder(String.valueOf(protocol2).length() + 40 + String.valueOf(protocol).length() + 1);
            sb.append("Disallowed cross-protocol redirect (");
            sb.append(protocol2);
            sb.append(" to ");
            sb.append(protocol);
            sb.append(")");
            throw new zzgq(sb.toString(), zzgfVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new zzgq(e, zzgfVar, 2001, 1);
        }
    }

    private final void zzm() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                zzdt.zzf("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) throws zzgq {
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.zzl;
            if (j != -1) {
                long j2 = j - this.zzm;
                if (j2 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j2);
            }
            InputStream inputStream = this.zzi;
            String str = zzep.zza;
            int i3 = inputStream.read(bArr, i, i2);
            if (i3 == -1) {
                return -1;
            }
            this.zzm += (long) i3;
            zzh(i3);
            return i3;
        } catch (IOException e) {
            zzgf zzgfVar = this.zzg;
            String str2 = zzep.zza;
            throw zzgq.zza(e, zzgfVar, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws zzgq {
        zzgm zzgmVar;
        long j;
        int i;
        HttpURLConnection httpURLConnectionZzk;
        byte[] bArrZza;
        long j2;
        zzgm zzgmVar2 = this;
        zzgmVar2.zzg = zzgfVar;
        long j3 = 0;
        zzgmVar2.zzm = 0L;
        zzgmVar2.zzl = 0L;
        zzf(zzgfVar);
        try {
            URL url = new URL(zzgfVar.zza.toString());
            int i2 = zzgfVar.zzb;
            byte[] bArr = zzgfVar.zzc;
            long j4 = zzgfVar.zze;
            long j5 = zzgfVar.zzf;
            boolean zZza = zzgfVar.zza(1);
            int i3 = 0;
            try {
                if (zzgmVar2.zza) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i3 + 1;
                        if (i3 > 20) {
                            StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 20);
                            sb.append("Too many redirects: ");
                            sb.append(i5);
                            throw new zzgq(new NoRouteToHostException(sb.toString()), zzgfVar, 2001, 1);
                        }
                        j = j3;
                        i = i4;
                        zzgmVar2 = this;
                        HttpURLConnection httpURLConnectionZzk2 = zzgmVar2.zzk(url, 1, null, j4, j5, zZza, false, zzgfVar.zzd);
                        URL url2 = url;
                        long j6 = j5;
                        zzgmVar = zzgmVar2;
                        try {
                            int responseCode = httpURLConnectionZzk2.getResponseCode();
                            String headerField = httpURLConnectionZzk2.getHeaderField(HttpHeaders.LOCATION);
                            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                                httpURLConnectionZzk = httpURLConnectionZzk2;
                                break;
                            }
                            httpURLConnectionZzk2.disconnect();
                            URL urlZzl = zzgmVar.zzl(url2, headerField, zzgfVar);
                            j5 = j6;
                            url = urlZzl;
                            i4 = i;
                            i3 = i5;
                            j3 = j;
                        } catch (IOException e) {
                            e = e;
                        }
                        zzgmVar.zzm();
                        throw zzgq.zza(e, zzgfVar, 1);
                    }
                }
                httpURLConnectionZzk = zzgmVar2.zzk(url, 1, null, j4, j5, zZza, true, zzgfVar.zzd);
                zzgmVar = this;
                j = 0;
                i = 0;
                zzgmVar.zzh = httpURLConnectionZzk;
                zzgmVar.zzk = httpURLConnectionZzk.getResponseCode();
                String responseMessage = httpURLConnectionZzk.getResponseMessage();
                int i6 = zzgmVar.zzk;
                if (i6 < 200 || i6 > 299) {
                    Map<String, List<String>> headerFields = httpURLConnectionZzk.getHeaderFields();
                    if (zzgmVar.zzk == 416) {
                        if (zzgfVar.zze == zzgv.zza(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE))) {
                            zzgmVar.zzj = true;
                            zzg(zzgfVar);
                            long j7 = zzgfVar.zzf;
                            return j7 != -1 ? j7 : j;
                        }
                    }
                    InputStream errorStream = httpURLConnectionZzk.getErrorStream();
                    try {
                        bArrZza = errorStream != null ? zzgsd.zza(errorStream) : zzep.zzb;
                    } catch (IOException unused) {
                        bArrZza = zzep.zzb;
                    }
                    zzgmVar.zzm();
                    throw new zzgs(zzgmVar.zzk, responseMessage, zzgmVar.zzk == 416 ? new zzgc(2008) : null, headerFields, zzgfVar, bArrZza);
                }
                httpURLConnectionZzk.getContentType();
                if (zzgmVar.zzk == 200) {
                    j2 = zzgfVar.zze;
                    if (j2 == j) {
                        j2 = j;
                    }
                } else {
                    j2 = j;
                }
                boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                if (zEqualsIgnoreCase) {
                    zzgmVar.zzl = zzgfVar.zzf;
                } else {
                    long j8 = zzgfVar.zzf;
                    if (j8 != -1) {
                        zzgmVar.zzl = j8;
                    } else {
                        long jZzb = zzgv.zzb(httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_LENGTH), httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE));
                        zzgmVar.zzl = jZzb != -1 ? jZzb - j2 : -1L;
                    }
                }
                try {
                    zzgmVar.zzi = httpURLConnectionZzk.getInputStream();
                    if (zEqualsIgnoreCase) {
                        zzgmVar.zzi = new GZIPInputStream(zzgmVar.zzi);
                    }
                    zzgmVar.zzj = true;
                    zzg(zzgfVar);
                    if (j2 != j) {
                        try {
                            byte[] bArr2 = new byte[4096];
                            while (j2 > j) {
                                int iMin = (int) Math.min(j2, 4096L);
                                InputStream inputStream = zzgmVar.zzi;
                                String str = zzep.zza;
                                int i7 = inputStream.read(bArr2, i, iMin);
                                if (Thread.currentThread().isInterrupted()) {
                                    throw new zzgq(new InterruptedIOException(), zzgfVar, 2000, 1);
                                }
                                if (i7 == -1) {
                                    throw new zzgq(zzgfVar, 2008, 1);
                                }
                                j2 -= (long) i7;
                                zzgmVar.zzh(i7);
                            }
                        } catch (IOException e2) {
                            zzgmVar.zzm();
                            if (e2 instanceof zzgq) {
                                throw ((zzgq) e2);
                            }
                            throw new zzgq(e2, zzgfVar, 2000, 1);
                        }
                    }
                    return zzgmVar.zzl;
                } catch (IOException e3) {
                    zzgmVar.zzm();
                    throw new zzgq(e3, zzgfVar, 2000, 1);
                }
            } catch (IOException e4) {
                e = e4;
                zzgmVar = this;
            }
        } catch (IOException e5) {
            e = e5;
            zzgmVar = zzgmVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzh;
        if (httpURLConnection != null) {
            return Uri.parse(httpURLConnection.getURL().toString());
        }
        zzgf zzgfVar = this.zzg;
        if (zzgfVar != null) {
            return zzgfVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws zzgq {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zzgf zzgfVar = this.zzg;
                    String str = zzep.zza;
                    throw new zzgq(e, zzgfVar, 2000, 3);
                }
            }
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzi();
            }
            this.zzh = null;
            this.zzg = null;
        } catch (Throwable th) {
            this.zzi = null;
            zzm();
            if (this.zzj) {
                this.zzj = false;
                zzi();
            }
            this.zzh = null;
            this.zzg = null;
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb, com.google.android.gms.internal.ads.zzgu
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzh;
        return httpURLConnection == null ? zzgph.zza() : new zzgl(httpURLConnection.getHeaderFields());
    }
}
