package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaai {
    private final Context zza;
    private boolean zzb;
    private zztg zzc = zztg.zzb;
    private final zzst zzd;
    private Handler zze;
    private zzabs zzf;

    public zzaai(Context context) {
        this.zza = context;
        this.zzd = new zzsn(context, null, null);
    }

    public final zzaai zza(zztg zztgVar) {
        this.zzc = zztgVar;
        return this;
    }

    public final zzaai zzb(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzaai zzc(zzabs zzabsVar) {
        this.zzf = zzabsVar;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public final zzaak zzd() {
        boolean z;
        zzgmd.zzh(!this.zzb);
        Handler handler = this.zze;
        if (handler == null && this.zzf == null) {
            z = true;
        } else {
            z = false;
            if (handler != null && this.zzf != null) {
                z = true;
            }
        }
        zzgmd.zzh(z);
        this.zzb = true;
        return new zzaak(this);
    }

    final /* synthetic */ Context zze() {
        return this.zza;
    }

    final /* synthetic */ zztg zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzst zzg() {
        return this.zzd;
    }

    final /* synthetic */ Handler zzh() {
        return this.zze;
    }

    final /* synthetic */ zzabs zzi() {
        return this.zzf;
    }
}
