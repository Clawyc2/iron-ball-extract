package com.google.android.gms.measurement.internal;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzer implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Object zzc;
    final /* synthetic */ Object zzd;
    final /* synthetic */ Object zze;
    final /* synthetic */ zzeu zzf;

    zzer(zzeu zzeuVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzeuVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfj zzfjVarZzm = this.zzf.zzs.zzm();
        if (!zzfjVarZzm.zzx()) {
            Log.println(6, this.zzf.zzq(), "Persisted config not initialized. Not logging error/warn");
            return;
        }
        zzeu zzeuVar = this.zzf;
        if (zzeuVar.zza == 0) {
            if (zzeuVar.zzs.zzf().zzy()) {
                zzeu zzeuVar2 = this.zzf;
                zzeuVar2.zzs.zzaw();
                zzeuVar2.zza = 'C';
            } else {
                zzeu zzeuVar3 = this.zzf;
                zzeuVar3.zzs.zzaw();
                zzeuVar3.zza = 'c';
            }
        }
        zzeu zzeuVar4 = this.zzf;
        if (zzeuVar4.zzb < 0) {
            zzeuVar4.zzs.zzf().zzh();
            zzeuVar4.zzb = 68000L;
        }
        char cCharAt = "01VDIWEA?".charAt(this.zza);
        zzeu zzeuVar5 = this.zzf;
        String strSubstring = "2" + cCharAt + zzeuVar5.zza + zzeuVar5.zzb + ":" + zzeu.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
        if (strSubstring.length() > 1024) {
            strSubstring = this.zzb.substring(0, 1024);
        }
        zzfh zzfhVar = zzfjVarZzm.zzb;
        if (zzfhVar != null) {
            zzfhVar.zzb(strSubstring, 1L);
        }
    }
}
