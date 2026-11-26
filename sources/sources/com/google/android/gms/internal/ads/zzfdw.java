package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfdw implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzdjd zzd;
    final /* synthetic */ zzfdy zze;

    zzfdw(zzfdy zzfdyVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzdjd zzdjdVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzdjdVar;
        Objects.requireNonNull(zzfdyVar);
        this.zze = zzfdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdjd zzdjdVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdjdVar.zzb().zzg(th);
        zzfdy zzfdyVar = this.zze;
        synchronized (zzfdyVar) {
            zzfdyVar.zzi(null);
            zzdjdVar.zza().zzdN(zzeVarZzg);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjb)).booleanValue()) {
                zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzdN(zzeVarZzg);
                    }
                });
                zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzg().zzdN(zzeVarZzg);
                    }
                });
            }
            zzfhk.zza(zzeVarZzg.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzh = zzfdyVar.zzh();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzh(zzeVarZzg);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzh.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zzf(zzeVarZzg);
                zzflc zzflcVar2 = this.zzc;
                zzflcVar2.zzj(th);
                zzflcVar2.zzd(false);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0047 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0092 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0020 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbel zzbelVar;
        zzflm zzflmVar;
        zzfdy zzfdyVar = this.zze;
        zzdhw zzdhwVar = (zzdhw) obj;
        synchronized (zzfdyVar) {
            if (zzdhwVar != null) {
                zzdhwVar.zzt();
                zzfdyVar.zzi(null);
                zzbelVar = zzbeu.zzjb;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                    zzdce zzdceVarZzq = zzdhwVar.zzq();
                    zzdceVarZzq.zza(zzfdyVar.zzf());
                    zzdceVarZzq.zzd(zzfdyVar.zzg());
                }
                this.zza.zzb(zzdhwVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                    zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzf().zzg();
                        }
                    });
                    zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfds
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzg();
                        }
                    });
                }
                if (((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                    zzflp zzflpVarZzh = zzfdyVar.zzh();
                    zzflc zzflcVar = this.zzc;
                    zzflcVar.zzg(zzdhwVar.zzr().zzb);
                    zzflcVar.zzi(zzdhwVar.zzn().zze());
                    zzflcVar.zzd(true);
                    zzflpVarZzh.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zze(zzdhwVar.zzr().zzb);
                    zzflmVar.zzg(zzdhwVar.zzn().zze());
                    zzflc zzflcVar2 = this.zzc;
                    zzflcVar2.zzd(true);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } else {
                zzfdyVar.zzi(null);
                zzbelVar = zzbeu.zzjb;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                    zzdce zzdceVarZzq2 = zzdhwVar.zzq();
                    zzdceVarZzq2.zza(zzfdyVar.zzf());
                    zzdceVarZzq2.zzd(zzfdyVar.zzg());
                }
                this.zza.zzb(zzdhwVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                    zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzf().zzg();
                        }
                    });
                    zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfds
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzg();
                        }
                    });
                }
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflp zzflpVarZzh2 = zzfdyVar.zzh();
                    zzflc zzflcVar3 = this.zzc;
                    zzflcVar3.zzg(zzdhwVar.zzr().zzb);
                    zzflcVar3.zzi(zzdhwVar.zzn().zze());
                    zzflcVar3.zzd(true);
                    zzflpVarZzh2.zzb(zzflcVar3.zzm());
                } else {
                    zzflp zzflpVarZzh3 = zzfdyVar.zzh();
                    zzflc zzflcVar4 = this.zzc;
                    zzflcVar4.zzg(zzdhwVar.zzr().zzb);
                    zzflcVar4.zzi(zzdhwVar.zzn().zze());
                    zzflcVar4.zzd(true);
                    zzflpVarZzh3.zzb(zzflcVar4.zzm());
                }
            }
            throw th;
        }
    }
}
