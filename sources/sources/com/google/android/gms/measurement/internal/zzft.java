package com.google.android.gms.measurement.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzft implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzfv zza;

    zzft(zzfv zzfvVar) {
        this.zza = zzfvVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzes zzesVarZzc;
        int i2 = i - 1;
        if (i2 == 0) {
            zzesVarZzc = this.zza.zzs.zzay().zzc();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzesVarZzc = this.zza.zzs.zzay().zzj();
            } else if (i2 != 4) {
                zzesVarZzc = this.zza.zzs.zzay().zzi();
            } else if (z) {
                zzesVarZzc = this.zza.zzs.zzay().zzm();
            } else {
                zzesVarZzc = !z2 ? this.zza.zzs.zzay().zzl() : this.zza.zzs.zzay().zzk();
            }
        } else if (z) {
            zzesVarZzc = this.zza.zzs.zzay().zzh();
        } else {
            zzesVarZzc = !z2 ? this.zza.zzs.zzay().zze() : this.zza.zzs.zzay().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzesVarZzc.zzb(str, list.get(0));
            return;
        }
        if (size == 2) {
            zzesVarZzc.zzc(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzesVarZzc.zza(str);
        } else {
            zzesVarZzc.zzd(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
