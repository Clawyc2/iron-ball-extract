package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfba implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzfbb zzd;
    final /* synthetic */ zzfbe zze;

    zzfba(zzfbe zzfbeVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzfbb zzfbbVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzfbbVar;
        Objects.requireNonNull(zzfbeVar);
        this.zze = zzfbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzfbe zzfbeVar = this.zze;
        zzcqq zzcqqVar = (zzcqq) zzfbeVar.zzj().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcqqVar == null ? zzfhp.zzb(th, null) : zzcqqVar.zza().zzg(th);
        synchronized (zzfbeVar) {
            zzfbeVar.zzl(null);
            if (zzcqqVar != null) {
                zzcqqVar.zze().zzdN(zzeVarZzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzja)).booleanValue()) {
                    zzfbeVar.zzh().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfaz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzi().zzdN(zzeVarZzb);
                        }
                    });
                }
            } else {
                zzfbeVar.zzi().zzdN(zzeVarZzb);
                ((zzcqq) zzfbeVar.zzg(this.zzd).zzh()).zza().zzd().zzo();
            }
            zzfhk.zza(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzk = zzfbeVar.zzk();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzh(zzeVarZzb);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzk.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zzf(zzeVarZzb);
                zzflc zzflcVar2 = this.zzc;
                zzflcVar2.zzj(th);
                zzflcVar2.zzd(false);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0063 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x002b, B:11:0x003f, B:13:0x0043, B:15:0x0087, B:14:0x0063), top: B:20:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0020 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x002b, B:11:0x003f, B:13:0x0043, B:15:0x0087, B:14:0x0063), top: B:20:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflm zzflmVar;
        zzfbe zzfbeVar = this.zze;
        zzcto zzctoVar = (zzcto) obj;
        synchronized (zzfbeVar) {
            if (zzctoVar != null) {
                zzctoVar.zzt();
                zzfbeVar.zzl(null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzja)).booleanValue()) {
                    zzctoVar.zzq().zzc(zzfbeVar.zzi());
                }
                this.zza.zzb(zzctoVar);
                if (((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                    zzflp zzflpVarZzk = zzfbeVar.zzk();
                    zzflc zzflcVar = this.zzc;
                    zzflcVar.zzg(zzctoVar.zzr().zzb);
                    zzflcVar.zzi(zzctoVar.zzn().zze());
                    zzflcVar.zzd(true);
                    zzflpVarZzk.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zze(zzctoVar.zzr().zzb);
                    zzflmVar.zzg(zzctoVar.zzn().zze());
                    zzflc zzflcVar2 = this.zzc;
                    zzflcVar2.zzd(true);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } else {
                zzfbeVar.zzl(null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzja)).booleanValue()) {
                    zzctoVar.zzq().zzc(zzfbeVar.zzi());
                }
                this.zza.zzb(zzctoVar);
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflp zzflpVarZzk2 = zzfbeVar.zzk();
                    zzflc zzflcVar3 = this.zzc;
                    zzflcVar3.zzg(zzctoVar.zzr().zzb);
                    zzflcVar3.zzi(zzctoVar.zzn().zze());
                    zzflcVar3.zzd(true);
                    zzflpVarZzk2.zzb(zzflcVar3.zzm());
                } else {
                    zzflp zzflpVarZzk3 = zzfbeVar.zzk();
                    zzflc zzflcVar4 = this.zzc;
                    zzflcVar4.zzg(zzctoVar.zzr().zzb);
                    zzflcVar4.zzi(zzctoVar.zzn().zze());
                    zzflcVar4.zzd(true);
                    zzflpVarZzk3.zzb(zzflcVar4.zzm());
                }
            }
            throw th;
        }
    }
}
