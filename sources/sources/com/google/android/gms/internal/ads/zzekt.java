package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekt implements zzguf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzffx zzb;
    final /* synthetic */ zzffu zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfnc zze;
    final /* synthetic */ zzfgf zzf;
    final /* synthetic */ zzekv zzg;

    zzekt(zzekv zzekvVar, long j, zzffx zzffxVar, zzffu zzffuVar, String str, zzfnc zzfncVar, zzfgf zzfgfVar) {
        this.zza = j;
        this.zzb = zzffxVar;
        this.zzc = zzffuVar;
        this.zzd = str;
        this.zze = zzfncVar;
        this.zzf = zzfgfVar;
        Objects.requireNonNull(zzekvVar);
        this.zzg = zzekvVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006a A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0076 A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0091 A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[Catch: all -> 0x00ef, DONT_GENERATE, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        int i;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        Integer numValueOf;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i3;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        zzekv zzekvVar = this.zzg;
        long jElapsedRealtime = zzekvVar.zzj().elapsedRealtime() - this.zza;
        if (!(th instanceof TimeoutException)) {
            if (th instanceof zzekd) {
                i = 3;
            } else if (th instanceof CancellationException) {
                i2 = 4;
            } else {
                if (!(th instanceof zzfgu)) {
                    if (th instanceof zzdzv) {
                        i2 = zzfhp.zza(th).zza == 3 ? 1 : 6;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbT)).booleanValue() && (th instanceof zzeho) && (zzeVarZzb = ((zzeho) th).zzb()) != null) {
                            numValueOf = Integer.valueOf(zzeVarZzb.zza);
                            i = i2;
                        }
                    } else {
                        i = 6;
                    }
                    synchronized (zzekvVar) {
                        if (zzekvVar.zzn()) {
                            zzekvVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzeho ? (zzeho) th : null, jElapsedRealtime);
                            jElapsedRealtime = jElapsedRealtime;
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjj)).booleanValue()) {
                            zzfng zzfngVarZzl = zzekvVar.zzl();
                            zzfnc zzfncVar = this.zze;
                            zzfgf zzfgfVar = this.zzf;
                            zzffu zzffuVar = this.zzc;
                            zzfngVarZzl.zza(zzfncVar.zza(zzfgfVar, zzffuVar, zzffuVar.zzn), zzffuVar.zzax);
                        }
                        if (zzekvVar.zzp()) {
                            return;
                        }
                        LinkedHashMap linkedHashMapZzm = zzekvVar.zzm();
                        zzffu zzffuVar2 = this.zzc;
                        linkedHashMapZzm.put(zzffuVar2, new zzeku(this.zzd, zzffuVar2.zzaf, i, jElapsedRealtime, numValueOf));
                        zzeVarZza = zzfhp.zza(th);
                        i3 = zzeVarZza.zza;
                        if ((i3 != 3 || i3 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                        }
                        zzekvVar.zzo().zze(zzffuVar2, jElapsedRealtime, zzeVarZza);
                    }
                }
                i2 = 5;
            }
            numValueOf = null;
            synchronized (zzekvVar) {
                if (zzekvVar.zzn()) {
                    zzekvVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzeho ? (zzeho) th : null, jElapsedRealtime);
                    jElapsedRealtime = jElapsedRealtime;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjj)).booleanValue()) {
                    zzfng zzfngVarZzl2 = zzekvVar.zzl();
                    zzfnc zzfncVar2 = this.zze;
                    zzfgf zzfgfVar2 = this.zzf;
                    zzffu zzffuVar3 = this.zzc;
                    zzfngVarZzl2.zza(zzfncVar2.zza(zzfgfVar2, zzffuVar3, zzffuVar3.zzn), zzffuVar3.zzax);
                }
                if (zzekvVar.zzp()) {
                    return;
                }
                LinkedHashMap linkedHashMapZzm2 = zzekvVar.zzm();
                zzffu zzffuVar4 = this.zzc;
                linkedHashMapZzm2.put(zzffuVar4, new zzeku(this.zzd, zzffuVar4.zzaf, i, jElapsedRealtime, numValueOf));
                zzeVarZza = zzfhp.zza(th);
                i3 = zzeVarZza.zza;
                zzeVarZza = i3 != 3 ? zzfhp.zza(new zzeho(13, zzeVarZza.zzd)) : zzfhp.zza(new zzeho(13, zzeVarZza.zzd));
                zzekvVar.zzo().zze(zzffuVar4, jElapsedRealtime, zzeVarZza);
            }
        }
        i2 = 2;
        i = i2;
        numValueOf = null;
        synchronized (zzekvVar) {
            if (zzekvVar.zzn()) {
                zzekvVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzeho ? (zzeho) th : null, jElapsedRealtime);
                jElapsedRealtime = jElapsedRealtime;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjj)).booleanValue()) {
                zzfng zzfngVarZzl3 = zzekvVar.zzl();
                zzfnc zzfncVar3 = this.zze;
                zzfgf zzfgfVar3 = this.zzf;
                zzffu zzffuVar5 = this.zzc;
                zzfngVarZzl3.zza(zzfncVar3.zza(zzfgfVar3, zzffuVar5, zzffuVar5.zzn), zzffuVar5.zzax);
            }
            if (zzekvVar.zzp()) {
                return;
            }
            LinkedHashMap linkedHashMapZzm3 = zzekvVar.zzm();
            zzffu zzffuVar6 = this.zzc;
            linkedHashMapZzm3.put(zzffuVar6, new zzeku(this.zzd, zzffuVar6.zzaf, i, jElapsedRealtime, numValueOf));
            zzeVarZza = zzfhp.zza(th);
            i3 = zzeVarZza.zza;
            if (i3 != 3) {
            }
            zzekvVar.zzo().zze(zzffuVar6, jElapsedRealtime, zzeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        long j;
        zzekv zzekvVar = this.zzg;
        long jElapsedRealtime = zzekvVar.zzj().elapsedRealtime() - this.zza;
        synchronized (zzekvVar) {
            if (zzekvVar.zzn()) {
                j = jElapsedRealtime;
                zzekvVar.zzk().zza(this.zzb, this.zzc, 0, null, j);
            } else {
                j = jElapsedRealtime;
            }
            if (zzekvVar.zzp()) {
                return;
            }
            zzffu zzffuVar = this.zzc;
            if (zzekvVar.zzi(zzffuVar)) {
                ((zzeku) zzekvVar.zzm().get(zzffuVar)).zzd = j;
            } else {
                long j2 = j;
                j = j2;
                zzekvVar.zzm().put(zzffuVar, new zzeku(this.zzd, zzffuVar.zzaf, 0, j2, null));
            }
            zzekvVar.zzo().zzd(zzffuVar, j, null);
        }
    }
}
