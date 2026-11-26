package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfdp implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzfdp(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar3;
    }

    public static zzfdp zzc(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        return new zzfdp(zzifqVar, zzifqVar2, zzifqVar3);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x00a6  */
    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfdm zzb() {
        zzfdm zzfdcVar;
        Context context = (Context) this.zza.zzb();
        zzfhy zzfhyVar = (zzfhy) this.zzb.zzb();
        zzfiq zzfiqVar = (zzfiq) this.zzc.zzb();
        zzcbe zzcbeVarZzi = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgQ)).booleanValue() ? com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi() : com.google.android.gms.ads.internal.zzt.zzh().zzo().zzj();
        boolean z = false;
        if (zzcbeVarZzi != null && zzcbeVarZzi.zzi()) {
            z = true;
        }
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgS)).intValue() > 0) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgP)).booleanValue() || z) {
                zzfip zzfipVarZza = zzfiqVar.zza(zzfig.Rewarded, context, zzfhyVar, new zzfcp(new zzfco()));
                zzfdd zzfddVar = new zzfdd(new zzfdc());
                zzfic zzficVar = zzfipVarZza.zza;
                zzgus zzgusVar = zzcbv.zza;
                zzfdcVar = new zzfct(zzfddVar, new zzfcz(zzficVar, zzgusVar), zzfipVarZza.zzb, zzficVar.zze().zzf, zzgusVar);
            } else {
                zzfdcVar = new zzfdc();
            }
        } else {
            zzfdcVar = new zzfdc();
        }
        return zzfdcVar;
    }
}
