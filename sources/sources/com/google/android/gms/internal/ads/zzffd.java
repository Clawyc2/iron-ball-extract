package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzffd implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzffg zzd;
    final /* synthetic */ zzffh zze;

    zzffd(zzffh zzffhVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzffg zzffgVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzffgVar;
        Objects.requireNonNull(zzffhVar);
        this.zze = zzffhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzffh zzffhVar = this.zze;
        zzdrn zzdrnVar = (zzdrn) zzffhVar.zzh().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdrnVar == null ? zzfhp.zzb(th, null) : zzdrnVar.zza().zzg(th);
        synchronized (zzffhVar) {
            try {
                if (zzdrnVar != null) {
                    zzdrnVar.zze().zzdN(zzeVarZzb);
                    zzffhVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffc
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzdN(zzeVarZzb);
                        }
                    });
                } else {
                    zzffhVar.zzg().zzdN(zzeVarZzb);
                    zzffhVar.zze(this.zzd).zzh().zza().zzd().zzo();
                }
                zzfhk.zza(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                    zzflp zzflpVarZzi = zzffhVar.zzi();
                    zzflc zzflcVar = this.zzc;
                    zzflcVar.zzh(zzeVarZzb);
                    zzflcVar.zzj(th);
                    zzflcVar.zzd(false);
                    zzflpVarZzi.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zzf(zzeVarZzb);
                    zzflc zzflcVar2 = this.zzc;
                    zzflcVar2.zzj(th);
                    zzflcVar2.zzd(false);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0067 A[Catch: all -> 0x008d, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0043, B:10:0x0047, B:12:0x008b, B:11:0x0067), top: B:17:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflm zzflmVar;
        zzffh zzffhVar = this.zze;
        zzdri zzdriVar = (zzdri) obj;
        synchronized (zzffhVar) {
            if (zzdriVar != null) {
                zzdriVar.zzt();
                zzdriVar.zzq().zzd(zzffhVar.zzg());
                this.zza.zzb(zzdriVar);
                Executor executorZzf = zzffhVar.zzf();
                final zzfey zzfeyVarZzg = zzffhVar.zzg();
                Objects.requireNonNull(zzfeyVarZzg);
                executorZzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzfeyVarZzg.zzg();
                    }
                });
                zzffhVar.zzg().onAdMetadataChanged();
                if (((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                    zzflp zzflpVarZzi = zzffhVar.zzi();
                    zzflc zzflcVar = this.zzc;
                    zzflcVar.zzg(zzdriVar.zzr().zzb);
                    zzflcVar.zzi(zzdriVar.zzn().zze());
                    zzflcVar.zzd(true);
                    zzflpVarZzi.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zze(zzdriVar.zzr().zzb);
                    zzflmVar.zzg(zzdriVar.zzn().zze());
                    zzflc zzflcVar2 = this.zzc;
                    zzflcVar2.zzd(true);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } else {
                zzdriVar.zzq().zzd(zzffhVar.zzg());
                this.zza.zzb(zzdriVar);
                Executor executorZzf2 = zzffhVar.zzf();
                final zzfey zzfeyVarZzg2 = zzffhVar.zzg();
                Objects.requireNonNull(zzfeyVarZzg2);
                executorZzf2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzfeyVarZzg2.zzg();
                    }
                });
                zzffhVar.zzg().onAdMetadataChanged();
                if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
                    zzflp zzflpVarZzi2 = zzffhVar.zzi();
                    zzflc zzflcVar3 = this.zzc;
                    zzflcVar3.zzg(zzdriVar.zzr().zzb);
                    zzflcVar3.zzi(zzdriVar.zzn().zze());
                    zzflcVar3.zzd(true);
                    zzflpVarZzi2.zzb(zzflcVar3.zzm());
                } else {
                    zzflp zzflpVarZzi3 = zzffhVar.zzi();
                    zzflc zzflcVar4 = this.zzc;
                    zzflcVar4.zzg(zzdriVar.zzr().zzb);
                    zzflcVar4.zzi(zzdriVar.zzn().zze());
                    zzflcVar4.zzd(true);
                    zzflpVarZzi3.zzb(zzflcVar4.zzm());
                }
            }
            throw th;
        }
    }
}
