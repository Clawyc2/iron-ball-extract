package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzor implements zzpa {
    public static final zzgmv zza = zzop.zza;
    private static final Random zzb = new Random();
    private final zzbe zzc;
    private final zzbd zzd;
    private final HashMap zze;
    private zzoz zzf;
    private zzbf zzg;
    private String zzh;
    private long zzi;

    public zzor() {
        throw null;
    }

    public zzor(zzgmv zzgmvVar) {
        this.zzc = new zzbe();
        this.zzd = new zzbd();
        this.zze = new HashMap();
        this.zzg = zzbf.zza;
        this.zzi = -1L;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzl(zzmj zzmjVar) {
        if (zzmjVar.zzb.zzg()) {
            String str = this.zzh;
            if (str != null) {
                zzoq zzoqVar = (zzoq) this.zze.get(str);
                zzoqVar.getClass();
                zzm(zzoqVar);
                return;
            }
            return;
        }
        zzoq zzoqVar2 = (zzoq) this.zze.get(this.zzh);
        int i = zzmjVar.zzc;
        zzuu zzuuVar = zzmjVar.zzd;
        this.zzh = zzo(i, zzuuVar).zze();
        zzc(zzmjVar);
        if (zzuuVar == null || !zzuuVar.zzb()) {
            return;
        }
        if (zzoqVar2 != null) {
            if (zzoqVar2.zzg() == zzuuVar.zzd && zzoqVar2.zzh() != null) {
                zzuu zzuuVarZzh = zzoqVar2.zzh();
                if (zzuuVarZzh.zzb == zzuuVar.zzb) {
                    zzuu zzuuVarZzh2 = zzoqVar2.zzh();
                    if (zzuuVarZzh2.zzc == zzuuVar.zzc) {
                        return;
                    }
                }
            }
        }
        zzo(i, new zzuu(zzuuVar.zza, zzuuVar.zzd));
    }

    private final void zzm(zzoq zzoqVar) {
        if (zzoqVar.zzg() != -1) {
            this.zzi = zzoqVar.zzg();
        }
        this.zzh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final long zzi() {
        zzoq zzoqVar = (zzoq) this.zze.get(this.zzh);
        return (zzoqVar == null || zzoqVar.zzg() == -1) ? this.zzi + 1 : zzoqVar.zzg();
    }

    private final zzoq zzo(int i, zzuu zzuuVar) {
        HashMap map = this.zze;
        long j = Long.MAX_VALUE;
        zzoq zzoqVar = null;
        for (zzoq zzoqVar2 : map.values()) {
            zzoqVar2.zzc(i, zzuuVar);
            if (zzoqVar2.zzb(i, zzuuVar)) {
                long jZzg = zzoqVar2.zzg();
                if (jZzg == -1 || jZzg < j) {
                    zzoqVar = zzoqVar2;
                    j = jZzg;
                } else if (jZzg == j) {
                    String str = zzep.zza;
                    if (zzoqVar.zzh() != null && zzoqVar2.zzh() != null) {
                        zzoqVar = zzoqVar2;
                    }
                }
            }
        }
        if (zzoqVar != null) {
            return zzoqVar;
        }
        String strZzp = zzp();
        zzoq zzoqVar3 = new zzoq(this, strZzp, i, zzuuVar);
        map.put(strZzp, zzoqVar3);
        return zzoqVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzp() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final void zza(zzoz zzozVar) {
        this.zzf = zzozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized String zzb(zzbf zzbfVar, zzuu zzuuVar) {
        return zzo(zzbfVar.zzo(zzuuVar.zza, this.zzd).zzc, zzuuVar).zze();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003b A[Catch: all -> 0x00af, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0082, B:30:0x0088, B:31:0x008b, B:33:0x0097, B:35:0x009d, B:41:0x00ae), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0045 A[Catch: all -> 0x00af, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0082, B:30:0x0088, B:31:0x008b, B:33:0x0097, B:35:0x009d, B:41:0x00ae), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0069 A[Catch: all -> 0x00af, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0082, B:30:0x0088, B:31:0x008b, B:33:0x0097, B:35:0x009d, B:41:0x00ae), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0088 A[Catch: all -> 0x00af, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:18:0x003b, B:20:0x0045, B:23:0x004e, B:25:0x0054, B:27:0x0069, B:28:0x0082, B:30:0x0088, B:31:0x008b, B:33:0x0097, B:35:0x009d, B:41:0x00ae), top: B:45:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zzc(zzmj zzmjVar) {
        int i;
        zzoq zzoqVarZzo;
        Object obj;
        int i2;
        zzoq zzoqVarZzo2;
        zzoq zzoqVar;
        if (this.zzf == null) {
            throw null;
        }
        zzbf zzbfVar = zzmjVar.zzb;
        if (!zzbfVar.zzg()) {
            zzuu zzuuVar = zzmjVar.zzd;
            if (zzuuVar == null) {
                i = zzmjVar.zzc;
                zzoqVarZzo = zzo(i, zzuuVar);
                if (this.zzh == null) {
                    this.zzh = zzoqVarZzo.zze();
                }
                if (zzuuVar != null) {
                    obj = zzuuVar.zza;
                    long j = zzuuVar.zzd;
                    i2 = zzuuVar.zzb;
                    zzoqVarZzo2 = zzo(i, new zzuu(obj, j, i2));
                    if (!zzoqVarZzo2.zzi()) {
                        zzoqVarZzo2.zzj(true);
                        zzbd zzbdVar = this.zzd;
                        zzbfVar.zzo(obj, zzbdVar);
                        zzbdVar.zzc(i2);
                        Math.max(0L, zzep.zzp(0L) + zzep.zzp(0L));
                    }
                }
                if (!zzoqVarZzo.zzi()) {
                    zzoqVarZzo.zzj(true);
                }
                if (zzoqVarZzo.zze().equals(this.zzh)) {
                    zzoqVarZzo.zzl(true);
                    this.zzf.zzc(zzmjVar, zzoqVarZzo.zze());
                }
            } else if (zzuuVar.zzd >= zzi() && ((zzoqVar = (zzoq) this.zze.get(this.zzh)) == null || zzoqVar.zzg() != -1 || zzoqVar.zzf() == zzmjVar.zzc)) {
                i = zzmjVar.zzc;
                zzoqVarZzo = zzo(i, zzuuVar);
                if (this.zzh == null) {
                    this.zzh = zzoqVarZzo.zze();
                }
                if (zzuuVar != null && zzuuVar.zzb()) {
                    obj = zzuuVar.zza;
                    long j2 = zzuuVar.zzd;
                    i2 = zzuuVar.zzb;
                    zzoqVarZzo2 = zzo(i, new zzuu(obj, j2, i2));
                    if (!zzoqVarZzo2.zzi()) {
                        zzoqVarZzo2.zzj(true);
                        zzbd zzbdVar2 = this.zzd;
                        zzbfVar.zzo(obj, zzbdVar2);
                        zzbdVar2.zzc(i2);
                        Math.max(0L, zzep.zzp(0L) + zzep.zzp(0L));
                    }
                }
                if (!zzoqVarZzo.zzi()) {
                    zzoqVarZzo.zzj(true);
                }
                if (zzoqVarZzo.zze().equals(this.zzh) && !zzoqVarZzo.zzk()) {
                    zzoqVarZzo.zzl(true);
                    this.zzf.zzc(zzmjVar, zzoqVarZzo.zze());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zzd(zzmj zzmjVar) {
        if (this.zzf == null) {
            throw null;
        }
        zzbf zzbfVar = this.zzg;
        this.zzg = zzmjVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoq zzoqVar = (zzoq) it.next();
            if (!zzoqVar.zza(zzbfVar, this.zzg) || zzoqVar.zzd(zzmjVar)) {
                it.remove();
                if (zzoqVar.zzi()) {
                    if (zzoqVar.zze().equals(this.zzh)) {
                        zzm(zzoqVar);
                    }
                    this.zzf.zzd(zzmjVar, zzoqVar.zze(), false);
                }
            }
        }
        zzl(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zze(zzmj zzmjVar, int i) {
        if (this.zzf == null) {
            throw null;
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoq zzoqVar = (zzoq) it.next();
            if (zzoqVar.zzd(zzmjVar)) {
                it.remove();
                if (zzoqVar.zzi()) {
                    boolean zEquals = zzoqVar.zze().equals(this.zzh);
                    boolean z = false;
                    if (i == 0 && zEquals && zzoqVar.zzk()) {
                        z = true;
                    }
                    if (zEquals) {
                        zzm(zzoqVar);
                    }
                    this.zzf.zzd(zzmjVar, zzoqVar.zze(), z);
                }
            }
        }
        zzl(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized String zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zzg(zzmj zzmjVar) {
        zzoz zzozVar;
        String str = this.zzh;
        if (str != null) {
            zzoq zzoqVar = (zzoq) this.zze.get(str);
            if (zzoqVar == null) {
                throw null;
            }
            zzm(zzoqVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoq zzoqVar2 = (zzoq) it.next();
            it.remove();
            if (zzoqVar2.zzi() && (zzozVar = this.zzf) != null) {
                zzozVar.zzd(zzmjVar, zzoqVar2.zze(), false);
            }
        }
    }

    final /* synthetic */ zzbe zzj() {
        return this.zzc;
    }

    final /* synthetic */ zzbd zzk() {
        return this.zzd;
    }
}
