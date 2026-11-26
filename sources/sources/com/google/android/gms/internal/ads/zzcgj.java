package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcgj extends zzft implements zzgu {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgt zze;
    private zzgf zzf;
    private HttpURLConnection zzg;
    private final Queue zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private final long zzq;
    private final long zzr;

    zzcgj(String str, zzgz zzgzVar, int i, int i2, long j, long j2) {
        super(true);
        zzcv.zza(str);
        this.zzd = str;
        this.zze = new zzgt();
        this.zzb = i;
        this.zzc = i2;
        this.zzh = new ArrayDeque();
        this.zzq = j;
        this.zzr = j2;
        if (zzgzVar != null) {
            zze(zzgzVar);
        }
    }

    private final void zzl() {
        while (true) {
            Queue queue = this.zzh;
            if (queue.isEmpty()) {
                this.zzg = null;
                return;
            }
            try {
                ((HttpURLConnection) queue.remove()).disconnect();
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unexpected error while disconnecting", e);
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
            long j2 = this.zzm;
            if (j - j2 == 0) {
                return -1;
            }
            long j3 = this.zzn + j2;
            long j4 = i2;
            long j5 = this.zzr;
            long j6 = j3 + j4 + j5;
            long j7 = this.zzp;
            long j8 = j7 + 1;
            if (j6 > j8) {
                long j9 = this.zzo;
                if (j7 < j9) {
                    long jMin = Math.min(j9, Math.max(((this.zzq + j8) - j5) - 1, (j8 + j4) - 1));
                    zzk(j8, jMin, 2);
                    this.zzp = jMin;
                    j7 = jMin;
                }
            }
            int i3 = this.zzi.read(bArr, i, (int) Math.min(j4, ((j7 + 1) - this.zzn) - this.zzm));
            if (i3 == -1) {
                throw new EOFException();
            }
            this.zzm += (long) i3;
            zzh(i3);
            return i3;
        } catch (IOException e) {
            throw new zzgq(e, this.zzf, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws zzgq {
        this.zzf = zzgfVar;
        this.zzm = 0L;
        long j = zzgfVar.zze;
        long j2 = zzgfVar.zzf;
        long jMin = j2 == -1 ? this.zzq : Math.min(this.zzq, j2);
        this.zzn = j;
        HttpURLConnection httpURLConnectionZzk = zzk(j, (jMin + j) - 1, 1);
        this.zzg = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zza.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j3 = Long.parseLong(matcher.group(2));
                    long j4 = Long.parseLong(matcher.group(3));
                    long j5 = zzgfVar.zzf;
                    if (j5 != -1) {
                        this.zzl = j5;
                        this.zzo = Math.max(j3, (this.zzn + j5) - 1);
                    } else {
                        this.zzl = j4 - this.zzn;
                        this.zzo = j4 - 1;
                    }
                    this.zzp = j3;
                    this.zzj = true;
                    zzg(zzgfVar);
                    return this.zzl;
                } catch (NumberFormatException unused) {
                    StringBuilder sb = new StringBuilder(String.valueOf(headerField).length() + 27);
                    sb.append("Unexpected Content-Range [");
                    sb.append(headerField);
                    sb.append("]");
                    String string = sb.toString();
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf(string);
                }
            }
        }
        throw new zzcgh(headerField, zzgfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0025 */
    @Override // com.google.android.gms.internal.ads.zzgb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd() throws com.google.android.gms.internal.ads.zzgq {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r7.zzi     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L16
            r2.close()     // Catch: java.io.IOException -> La java.lang.Throwable -> L25
            goto L16
        La:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzgq r3 = new com.google.android.gms.internal.ads.zzgq     // Catch: java.lang.Throwable -> L25
            com.google.android.gms.internal.ads.zzgf r4 = r7.zzf     // Catch: java.lang.Throwable -> L25
            r5 = 2000(0x7d0, float:2.803E-42)
            r6 = 3
            r3.<init>(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> L25
            throw r3     // Catch: java.lang.Throwable -> L25
        L16:
            r7.zzi = r1
            r7.zzl()
            boolean r1 = r7.zzj
            if (r1 == 0) goto L24
            r7.zzj = r0
            r7.zzi()
        L24:
            return
        L25:
            r2 = move-exception
            r7.zzi = r1
            r7.zzl()
            boolean r1 = r7.zzj
            if (r1 == 0) goto L34
            r7.zzj = r0
            r7.zzi()
        L34:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgj.zzd():void");
    }

    @Override // com.google.android.gms.internal.ads.zzgb, com.google.android.gms.internal.ads.zzgu
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final HttpURLConnection zzk(long j, long j2, int i) throws zzgq {
        IOException iOException;
        String string = this.zzf.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzb);
            httpURLConnection.setReadTimeout(this.zzc);
            for (Map.Entry entry : this.zze.zza().entrySet()) {
                try {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                } catch (IOException e) {
                    iOException = e;
                    String.valueOf(string);
                    String strValueOf = String.valueOf(string);
                    throw new zzgq("Unable to connect to ".concat(strValueOf), iOException, this.zzf, 2000, i);
                }
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 7 + String.valueOf(j2).length());
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            sb.append(j2);
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, sb.toString());
            httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zzd);
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "identity");
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            httpURLConnection.connect();
            this.zzh.add(httpURLConnection);
            String string2 = this.zzf.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzk = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcgi(this.zzk, headerFields, this.zzf, i);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzi != null) {
                        inputStream = new SequenceInputStream(this.zzi, inputStream);
                    }
                    this.zzi = inputStream;
                    return httpURLConnection;
                } catch (IOException e2) {
                    zzl();
                    throw new zzgq(e2, this.zzf, 2000, i);
                }
            } catch (IOException e3) {
                zzl();
                String.valueOf(string2);
                String strValueOf2 = String.valueOf(string2);
                throw new zzgq("Unable to connect to ".concat(strValueOf2), e3, this.zzf, 2000, i);
            }
        } catch (IOException e4) {
            iOException = e4;
        }
    }
}
