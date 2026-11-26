package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Build;
import androidx.work.WorkRequest;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzql {
    private long zzA;
    private boolean zzB;
    private long zzC;
    private zzdc zzD;
    boolean zza;
    private final zzqk zzb;
    private final long[] zzc;
    private AudioTrack zzd;
    private zzqj zze;
    private int zzf;
    private long zzg;
    private float zzh;
    private boolean zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private int zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzql(zzqk zzqkVar) {
        this.zzb = zzqkVar;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzc = new long[10];
        this.zzA = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzD = zzdc.zza;
    }

    private final void zzj(long j) {
        if (this.zza) {
            long j2 = this.zzj;
            if (j2 == -9223372036854775807L || j < j2) {
                return;
            }
            long jZza = this.zzD.zza() - zzep.zzp(zzep.zzw(j - j2, this.zzh));
            this.zzj = -9223372036854775807L;
            this.zzb.zza(jZza);
        }
    }

    private final long zzk(long j) {
        long jZzv;
        if (this.zzu == 0) {
            jZzv = this.zzv != -9223372036854775807L ? zzep.zzr(zzo(), this.zzf) : zzm();
        } else {
            jZzv = zzep.zzv(j + this.zzk, this.zzh);
        }
        long jMax = Math.max(0L, jZzv - this.zzn);
        return this.zzv != -9223372036854775807L ? Math.min(zzep.zzr(this.zzy, this.zzf), jMax) : jMax;
    }

    private final void zzl() {
        this.zzk = 0L;
        this.zzu = 0;
        this.zzt = 0;
        this.zzl = 0L;
        this.zzz = -9223372036854775807L;
        this.zzA = -9223372036854775807L;
        this.zzi = false;
    }

    private final long zzm() {
        return zzep.zzr(zzn(), this.zzf);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0067  */
    private final long zzn() {
        if (this.zzv != -9223372036854775807L) {
            return Math.min(this.zzy, zzo());
        }
        long jZzb = this.zzD.zzb();
        if (jZzb - this.zzq >= 5) {
            AudioTrack audioTrack = this.zzd;
            audioTrack.getClass();
            int playState = audioTrack.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
                if (Build.VERSION.SDK_INT > 29) {
                    if (this.zzr > playbackHeadPosition) {
                        this.zzs++;
                    }
                    this.zzr = playbackHeadPosition;
                } else if (playbackHeadPosition != 0 || this.zzr <= 0 || playState != 3) {
                    this.zzw = -9223372036854775807L;
                    if (this.zzr > playbackHeadPosition) {
                        this.zzs++;
                    }
                    this.zzr = playbackHeadPosition;
                } else if (this.zzw == -9223372036854775807L) {
                    this.zzw = jZzb;
                }
            }
            this.zzq = jZzb;
        }
        return this.zzr + this.zzC + (this.zzs << 32);
    }

    private final long zzo() {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.zzx;
        }
        return this.zzx + zzep.zzs(zzep.zzv(zzep.zzq(this.zzD.zzb()) - this.zzv, this.zzh), this.zzf);
    }

    public final void zza(AudioTrack audioTrack, int i, int i2, int i3, boolean z) {
        this.zzd = audioTrack;
        this.zze = new zzqj(audioTrack, this.zzb);
        this.zzf = audioTrack.getSampleRate();
        boolean zZzA = zzep.zzA(i);
        this.zzo = zZzA;
        this.zzg = zZzA ? zzep.zzr(i3 / i2, this.zzf) : -9223372036854775807L;
        this.zzr = 0L;
        this.zzs = 0L;
        this.zzB = false;
        this.zzC = 0L;
        this.zzv = -9223372036854775807L;
        this.zzw = -9223372036854775807L;
        this.zzp = 0L;
        this.zzn = 0L;
        this.zzh = 1.0f;
        this.zzj = -9223372036854775807L;
        this.zza = z;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c9  */
    public final long zzb() {
        long j;
        Method method;
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        long j2 = 1000;
        if (audioTrack.getPlayState() == 3) {
            long jZzc = this.zzD.zzc() / 1000;
            if (jZzc - this.zzl >= WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS) {
                long jZzm = zzm();
                if (jZzm != 0) {
                    long[] jArr = this.zzc;
                    jArr[this.zzt] = zzep.zzw(jZzm, this.zzh) - jZzc;
                    this.zzt = (this.zzt + 1) % 10;
                    int i = this.zzu;
                    if (i < 10) {
                        this.zzu = i + 1;
                    }
                    this.zzl = jZzc;
                    this.zzk = 0L;
                    int i2 = 0;
                    while (true) {
                        int i3 = this.zzu;
                        if (i2 >= i3) {
                            break;
                        }
                        this.zzk += jArr[i2] / ((long) i3);
                        i2++;
                        j2 = j2;
                    }
                } else {
                    j = 1000;
                }
            }
            j = j2;
            if (this.zzo && (method = this.zzm) != null && jZzc - this.zzp >= 500000) {
                try {
                    AudioTrack audioTrack2 = this.zzd;
                    if (audioTrack2 == null) {
                        throw null;
                    }
                    Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                    String str = zzep.zza;
                    long jIntValue = (((long) num.intValue()) * j) - this.zzg;
                    this.zzn = jIntValue;
                    long jMax = Math.max(jIntValue, 0L);
                    this.zzn = jMax;
                    if (jMax > 5000000) {
                        this.zzb.zzd(jMax);
                        this.zzn = 0L;
                    }
                    this.zzp = jZzc;
                } catch (Exception unused) {
                    this.zzm = null;
                }
            }
            zzqj zzqjVar = this.zze;
            zzqjVar.getClass();
            zzqjVar.zza(jZzc, this.zzh, zzk(jZzc));
        } else {
            j = 1000;
        }
        long jZzc2 = this.zzD.zzc() / j;
        zzqj zzqjVar2 = this.zze;
        zzqjVar2.getClass();
        boolean zZzb = zzqjVar2.zzb();
        long jZze = zZzb ? zzqjVar2.zze(jZzc2, this.zzh) : zzk(jZzc2);
        int playState = audioTrack.getPlayState();
        if (playState == 3) {
            if (zZzb || !zzqjVar2.zzc()) {
                zzj(jZze);
            }
            long j3 = this.zzA;
            if (j3 != -9223372036854775807L) {
                long j4 = jZze - this.zzz;
                long jZzv = zzep.zzv(jZzc2 - j3, this.zzh);
                long j5 = this.zzz + jZzv;
                long jAbs = Math.abs(j5 - jZze);
                if (j4 != 0 && jAbs < 1000000) {
                    long j6 = (jZzv * 10) / 100;
                    jZze = Math.max(j5 - j6, Math.min(jZze, j5 + j6));
                }
            }
            if (!this.zza && !this.zzi) {
                long j7 = this.zzz;
                if (j7 != -9223372036854775807L && jZze > j7) {
                    this.zzi = true;
                    String str2 = zzep.zza;
                    this.zzb.zza(this.zzD.zza() - zzep.zzp(zzep.zzw(zzep.zzp(jZze - j7), this.zzh)));
                }
            }
            this.zzA = jZzc2;
            this.zzz = jZze;
        } else if (playState == 1) {
            zzj(jZze);
            return jZze;
        }
        return jZze;
    }

    public final void zzc() {
        if (this.zzv != -9223372036854775807L) {
            this.zzv = zzep.zzq(this.zzD.zzb());
        }
        this.zzj = zzm();
        zzqj zzqjVar = this.zze;
        zzqjVar.getClass();
        zzqjVar.zzd();
    }

    public final boolean zzd() {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zze(long j) {
        return this.zzw != -9223372036854775807L && j > 0 && this.zzD.zzb() - this.zzw >= 200;
    }

    public final void zzf(long j) {
        this.zzx = zzn();
        this.zzv = zzep.zzq(this.zzD.zzb());
        this.zzy = j;
    }

    public final void zzg() {
        zzl();
        if (this.zzv == -9223372036854775807L) {
            zzqj zzqjVar = this.zze;
            zzqjVar.getClass();
            zzqjVar.zzd();
        }
        this.zzx = zzn();
    }

    public final void zzh() {
        zzl();
        this.zzd = null;
        this.zze = null;
    }

    public final void zzi(zzdc zzdcVar) {
        this.zzD = zzdcVar;
    }
}
