package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzepn implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzdjz zzd;
    final /* synthetic */ zzepq zze;

    zzepn(zzepq zzepqVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzdjz zzdjzVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzdjzVar;
        Objects.requireNonNull(zzepqVar);
        this.zze = zzepqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdjz zzdjzVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdjzVar.zza().zzg(th);
        zzdjzVar.zzb().zzdN(zzeVarZzg);
        zzepq zzepqVar = this.zze;
        zzepqVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze.zzf().zze().zzdN(zzeVarZzg);
            }
        });
        zzfhk.zza(zzeVarZzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
            zzflp zzflpVarZzg = zzepqVar.zzg();
            zzflc zzflcVar = this.zzc;
            zzflcVar.zzh(zzeVarZzg);
            zzflcVar.zzj(th);
            zzflcVar.zzd(false);
            zzflpVarZzg.zzb(zzflcVar.zzm());
            return;
        }
        zzflmVar.zzf(zzeVarZzg);
        zzflc zzflcVar2 = this.zzc;
        zzflcVar2.zzj(th);
        zzflcVar2.zzd(false);
        zzflmVar.zza(zzflcVar2);
        zzflmVar.zzh();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0061 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x003d, B:10:0x0041, B:12:0x0085, B:11:0x0061), top: B:17:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflm zzflmVar;
        zzepq zzepqVar = this.zze;
        zzcto zzctoVar = (zzcto) obj;
        synchronized (zzepqVar) {
            if (zzctoVar != null) {
                zzctoVar.zzt();
                zzctoVar.zzq().zza(zzepqVar.zzf().zzc());
                this.zza.zzb(zzctoVar);
                zzepqVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzd().zzg();
                    }
                });
                if (((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                    zzflp zzflpVarZzg = zzepqVar.zzg();
                    zzflc zzflcVar = this.zzc;
                    zzflcVar.zzg(zzctoVar.zzr().zzb);
                    zzflcVar.zzi(zzctoVar.zzn().zze());
                    zzflcVar.zzd(true);
                    zzflpVarZzg.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zze(zzctoVar.zzr().zzb);
                    zzflmVar.zzg(zzctoVar.zzn().zze());
                    zzflc zzflcVar2 = this.zzc;
                    zzflcVar2.zzd(true);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } else {
                zzctoVar.zzq().zza(zzepqVar.zzf().zzc());
                this.zza.zzb(zzctoVar);
                zzepqVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepm
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzd().zzg();
                    }
                });
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflp zzflpVarZzg2 = zzepqVar.zzg();
                    zzflc zzflcVar3 = this.zzc;
                    zzflcVar3.zzg(zzctoVar.zzr().zzb);
                    zzflcVar3.zzi(zzctoVar.zzn().zze());
                    zzflcVar3.zzd(true);
                    zzflpVarZzg2.zzb(zzflcVar3.zzm());
                } else {
                    zzflp zzflpVarZzg3 = zzepqVar.zzg();
                    zzflc zzflcVar4 = this.zzc;
                    zzflcVar4.zzg(zzctoVar.zzr().zzb);
                    zzflcVar4.zzi(zzctoVar.zzn().zze());
                    zzflcVar4.zzd(true);
                    zzflpVarZzg3.zzb(zzflcVar4.zzm());
                }
            }
            throw th;
        }
    }
}
