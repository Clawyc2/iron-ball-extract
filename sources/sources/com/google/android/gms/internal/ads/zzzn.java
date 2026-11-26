package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzn {
    public static final zzzh zza = new zzzh(2, -9223372036854775807L, null);
    public static final zzzh zzb = new zzzh(3, -9223372036854775807L, null);
    private final zzzt zzc = zzzt.zzb(zzep.zzf("ExoPlayer:Loader:ProgressiveMediaPeriod"), zzzg.zza);
    private zzzi zzd;
    private IOException zze;

    public zzzn(String str) {
    }

    public static zzzh zza(boolean z, long j) {
        return new zzzh(z ? 1 : 0, j, null);
    }

    public final boolean zzb() {
        return this.zze != null;
    }

    public final void zzc() {
        this.zze = null;
    }

    public final long zzd(zzzj zzzjVar, zzzf zzzfVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzzi(this, looperMyLooper, zzzjVar, zzzfVar, i, jElapsedRealtime).zzb(0L);
        return jElapsedRealtime;
    }

    public final boolean zze() {
        return this.zzd != null;
    }

    public final void zzg(zzzk zzzkVar) {
        zzzi zzziVar = this.zzd;
        if (zzziVar != null) {
            zzziVar.zzc(true);
        }
        zzzt zzztVar = this.zzc;
        zzztVar.execute(new zzzl(zzzkVar));
        zzztVar.zza();
    }

    public final void zzh(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzzi zzziVar = this.zzd;
        if (zzziVar != null) {
            zzziVar.zza(i);
        }
    }

    final /* synthetic */ zzzt zzi() {
        return this.zzc;
    }

    final /* synthetic */ zzzi zzj() {
        return this.zzd;
    }

    final /* synthetic */ void zzk(zzzi zzziVar) {
        this.zzd = zzziVar;
    }

    final /* synthetic */ void zzl(IOException iOException) {
        this.zze = iOException;
    }

    public final void zzf() {
        zzzi zzziVar = this.zzd;
        zzziVar.getClass();
        zzziVar.zzc(false);
    }
}
