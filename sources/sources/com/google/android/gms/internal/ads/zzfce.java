package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfce implements zzguf {
    final /* synthetic */ zzflm zza;
    final /* synthetic */ zzflc zzb;
    final /* synthetic */ zzcsl zzc;
    final /* synthetic */ zzfci zzd;

    zzfce(zzfci zzfciVar, zzflm zzflmVar, zzflc zzflcVar, zzcsl zzcslVar) {
        this.zza = zzflmVar;
        this.zzb = zzflcVar;
        this.zzc = zzcslVar;
        Objects.requireNonNull(zzfciVar);
        this.zzd = zzfciVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Banner ad failed to load", th);
        }
        zzfci zzfciVar = this.zzd;
        synchronized (zzfciVar) {
            zzcsl zzcslVar = this.zzc;
            com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzcslVar.zzc().zzg(th);
            zzfciVar.zzs(zzeVarZzg);
            zzcslVar.zzb().zzdN(zzeVarZzg);
            zzfhk.zza(zzeVarZzg.zza, th, "BannerAdLoader.onFailure");
            if (zzfciVar.zzr()) {
                zzfciVar.zzn();
                zzfciVar.zzo().zzd(zzfciVar.zzq().zzc());
            }
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zza) == null) {
                zzflp zzflpVarZzp = zzfciVar.zzp();
                zzflc zzflcVar = this.zzb;
                zzflcVar.zzh(zzeVarZzg);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzp.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zzf(zzeVarZzg);
                zzflc zzflcVar2 = this.zzb;
                zzflcVar2.zzj(th);
                zzflcVar2.zzd(false);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0046 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0010, B:9:0x0013, B:11:0x0022, B:13:0x0026, B:15:0x006a, B:14:0x0046), top: B:20:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0010 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0010, B:9:0x0013, B:11:0x0022, B:13:0x0026, B:15:0x006a, B:14:0x0046), top: B:20:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflm zzflmVar;
        zzfci zzfciVar = this.zzd;
        zzcrg zzcrgVar = (zzcrg) obj;
        synchronized (zzfciVar) {
            if (zzcrgVar != null) {
                zzcrgVar.zzt();
                if (zzfciVar.zzr()) {
                    zzfciVar.zzc();
                }
                if (((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zza) == null) {
                    zzflp zzflpVarZzp = zzfciVar.zzp();
                    zzflc zzflcVar = this.zzb;
                    zzflcVar.zzg(zzcrgVar.zzr().zzb);
                    zzflcVar.zzi(zzcrgVar.zzn().zze());
                    zzflcVar.zzd(true);
                    zzflpVarZzp.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zze(zzcrgVar.zzr().zzb);
                    zzflmVar.zzg(zzcrgVar.zzn().zze());
                    zzflc zzflcVar2 = this.zzb;
                    zzflcVar2.zzd(true);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } else {
                if (zzfciVar.zzr()) {
                    zzfciVar.zzc();
                }
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflp zzflpVarZzp2 = zzfciVar.zzp();
                    zzflc zzflcVar3 = this.zzb;
                    zzflcVar3.zzg(zzcrgVar.zzr().zzb);
                    zzflcVar3.zzi(zzcrgVar.zzn().zze());
                    zzflcVar3.zzd(true);
                    zzflpVarZzp2.zzb(zzflcVar3.zzm());
                } else {
                    zzflp zzflpVarZzp3 = zzfciVar.zzp();
                    zzflc zzflcVar4 = this.zzb;
                    zzflcVar4.zzg(zzcrgVar.zzr().zzb);
                    zzflcVar4.zzi(zzcrgVar.zzn().zze());
                    zzflcVar4.zzd(true);
                    zzflpVarZzp3.zzb(zzflcVar4.zzm());
                }
            }
            throw th;
        }
    }
}
