package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaqj implements zzapn {
    protected final zzaql zza;
    private final zzaqi zzb;

    public zzaqj(zzaqi zzaqiVar) {
        zzaql zzaqlVar = new zzaql(4096);
        this.zzb = zzaqiVar;
        this.zza = zzaqlVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:102:0x01da  */
    /* JADX WARN: Code duplicated, block: B:116:0x020f  */
    /* JADX WARN: Code duplicated, block: B:143:0x024d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:97:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c1 A[DONT_INVERT] */
    @Override // com.google.android.gms.internal.ads.zzapn
    public zzapq zza(zzapu zzapuVar) throws Throwable {
        byte[] bArr;
        int iZza;
        zzaqd zzappVar;
        String str;
        zzapq zzapqVar;
        int iZzo;
        Map mapEmptyMap;
        byte[] byteArray;
        byte[] bArrZza;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            zzaqs zzaqsVar = null;
            try {
                zzapd zzapdVarZzk = zzapuVar.zzk();
                if (zzapdVarZzk == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str2 = zzapdVarZzk.zzb;
                    if (str2 != null) {
                        map.put(HttpHeaders.IF_NONE_MATCH, str2);
                    }
                    long j = zzapdVarZzk.zzd;
                    if (j > 0) {
                        map.put(HttpHeaders.IF_MODIFIED_SINCE, zzaqr.zzc(j));
                    }
                    mapEmptyMap = map;
                }
                zzaqs zzaqsVarZza = this.zzb.zza(zzapuVar, mapEmptyMap);
                try {
                    int iZza2 = zzaqsVarZza.zza();
                    List listZzb = zzaqsVarZza.zzb();
                    if (iZza2 == 304) {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        zzapd zzapdVarZzk2 = zzapuVar.zzk();
                        if (zzapdVarZzk2 == null) {
                            return new zzapq(304, (byte[]) null, true, jElapsedRealtime2, listZzb);
                        }
                        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                        if (!listZzb.isEmpty()) {
                            Iterator it = listZzb.iterator();
                            while (it.hasNext()) {
                                treeSet.add(((zzapm) it.next()).zza());
                            }
                        }
                        ArrayList arrayList = new ArrayList(listZzb);
                        List list = zzapdVarZzk2.zzh;
                        if (list != null) {
                            if (!list.isEmpty()) {
                                for (zzapm zzapmVar : zzapdVarZzk2.zzh) {
                                    if (!treeSet.contains(zzapmVar.zza())) {
                                        arrayList.add(zzapmVar);
                                    }
                                }
                            }
                        } else if (!zzapdVarZzk2.zzg.isEmpty()) {
                            for (Map.Entry entry : zzapdVarZzk2.zzg.entrySet()) {
                                if (!treeSet.contains(entry.getKey())) {
                                    arrayList.add(new zzapm((String) entry.getKey(), (String) entry.getValue()));
                                }
                            }
                        }
                        return new zzapq(304, zzapdVarZzk2.zza, true, jElapsedRealtime2, (List) arrayList);
                    }
                    InputStream inputStreamZzd = zzaqsVarZza.zzd();
                    if (inputStreamZzd != null) {
                        int iZzc = zzaqsVarZza.zzc();
                        zzaql zzaqlVar = this.zza;
                        zzaqw zzaqwVar = new zzaqw(zzaqlVar, iZzc);
                        try {
                            bArrZza = zzaqlVar.zza(1024);
                            while (true) {
                                try {
                                    int i = inputStreamZzd.read(bArrZza);
                                    if (i == -1) {
                                        break;
                                    }
                                    zzaqwVar.write(bArrZza, 0, i);
                                } catch (Throwable th) {
                                    th = th;
                                    try {
                                        inputStreamZzd.close();
                                    } catch (IOException unused) {
                                        zzaqg.zza("Error occurred when closing InputStream", new Object[0]);
                                    }
                                    zzaqlVar.zzb(bArrZza);
                                    zzaqwVar.close();
                                    throw th;
                                }
                            }
                            byteArray = zzaqwVar.toByteArray();
                            try {
                                inputStreamZzd.close();
                            } catch (IOException unused2) {
                                zzaqg.zza("Error occurred when closing InputStream", new Object[0]);
                            }
                            zzaqlVar.zzb(bArrZza);
                            zzaqwVar.close();
                        } catch (Throwable th2) {
                            th = th2;
                            bArrZza = null;
                        }
                    } else {
                        byteArray = new byte[0];
                    }
                    byte[] bArr2 = byteArray;
                    try {
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                        if (zzaqg.zzb || jElapsedRealtime3 > 3000) {
                            zzaqg.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", zzapuVar, Long.valueOf(jElapsedRealtime3), bArr2 != null ? Integer.valueOf(bArr2.length) : "null", Integer.valueOf(iZza2), Integer.valueOf(zzapuVar.zzy().zzb()));
                        }
                        if (iZza2 < 200 || iZza2 > 299) {
                            throw new IOException();
                        }
                        return new zzapq(iZza2, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzb);
                    } catch (IOException e) {
                        e = e;
                        zzaqsVar = zzaqsVarZza;
                        bArr = bArr2;
                        if (e instanceof SocketTimeoutException) {
                            zzappVar = new zzaqc();
                            str = "socket";
                        } else {
                            if (!(e instanceof MalformedURLException)) {
                                String strZzh = zzapuVar.zzh();
                                String.valueOf(strZzh);
                                throw new RuntimeException("Bad URL ".concat(String.valueOf(strZzh)), e);
                            }
                            if (zzaqsVar != null) {
                                throw new zzapr(e);
                            }
                            iZza = zzaqsVar.zza();
                            zzaqg.zzc("Unexpected response code %d for %s", Integer.valueOf(iZza), zzapuVar.zzh());
                            if (bArr != null) {
                                zzapqVar = new zzapq(iZza, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqsVar.zzb());
                                if (iZza == 401 && iZza != 403) {
                                    if (iZza < 400 || iZza > 499) {
                                        throw new zzaqb(zzapqVar);
                                    }
                                    throw new zzaph(zzapqVar);
                                }
                                zzappVar = new zzapc(zzapqVar);
                                str = "auth";
                            } else {
                                zzappVar = new zzapp();
                                str = "network";
                            }
                        }
                        zzapi zzapiVarZzy = zzapuVar.zzy();
                        iZzo = zzapuVar.zzo();
                        try {
                            zzapiVarZzy.zzc(zzappVar);
                            zzapuVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzo)));
                        } catch (zzaqd e2) {
                            zzapuVar.zzc(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iZzo)));
                            throw e2;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    bArr = null;
                    zzaqsVar = zzaqsVarZza;
                    if (e instanceof SocketTimeoutException) {
                        zzappVar = new zzaqc();
                        str = "socket";
                    } else {
                        if (!(e instanceof MalformedURLException)) {
                            String strZzh2 = zzapuVar.zzh();
                            String.valueOf(strZzh2);
                            throw new RuntimeException("Bad URL ".concat(String.valueOf(strZzh2)), e);
                        }
                        if (zzaqsVar != null) {
                            throw new zzapr(e);
                        }
                        iZza = zzaqsVar.zza();
                        zzaqg.zzc("Unexpected response code %d for %s", Integer.valueOf(iZza), zzapuVar.zzh());
                        if (bArr != null) {
                            zzapqVar = new zzapq(iZza, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqsVar.zzb());
                            if (iZza == 401) {
                            }
                            zzappVar = new zzapc(zzapqVar);
                            str = "auth";
                        } else {
                            zzappVar = new zzapp();
                            str = "network";
                        }
                    }
                    zzapi zzapiVarZzy2 = zzapuVar.zzy();
                    iZzo = zzapuVar.zzo();
                    zzapiVarZzy2.zzc(zzappVar);
                    zzapuVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzo)));
                }
            } catch (IOException e4) {
                e = e4;
                bArr = null;
            }
            zzapuVar.zzc(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iZzo)));
        }
    }
}
