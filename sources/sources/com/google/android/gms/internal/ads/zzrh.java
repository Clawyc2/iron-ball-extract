package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.work.PeriodicWorkRequest;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.time.DurationKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzrh implements zzqh {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private zzqx zzA;
    private zzav zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;
    private ByteBuffer zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private boolean zzU;
    private zze zzV;
    private AudioDeviceInfo zzW;
    private long zzX;
    private boolean zzY;
    private boolean zzZ;
    private Looper zzaa;
    private long zzab;
    private long zzac;
    private Handler zzad;
    private Context zzae;
    private boolean zzaf;
    private int zzag;
    private boolean zzah;
    private final zzqr zzai;
    private final zzqn zzaj;
    private final Context zzd;
    private final zzqm zze;
    private final zzrp zzf;
    private final zzck zzg;
    private final zzro zzh;
    private final zzgpe zzi;
    private final zzql zzj;
    private final ArrayDeque zzk;
    private zzrg zzl;
    private final zzrc zzm;
    private final zzrc zzn;
    private final int zzo;
    private zzpc zzp;
    private zzqe zzq;
    private zzqq zzr;
    private zzqq zzs;
    private zzcc zzt;
    private AudioTrack zzu;
    private zzpe zzv;
    private zzpj zzw;
    private zzrb zzx;
    private zzd zzy;
    private zzqx zzz;

    static /* synthetic */ void zzE(AudioTrack audioTrack, final zzqe zzqeVar, Handler handler, final zzqb zzqbVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqeVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqeVar.zzc(zzqbVar);
                    }
                });
            }
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzqeVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqeVar.zzc(zzqbVar);
                    }
                });
            }
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    static /* synthetic */ boolean zzH() {
        boolean z;
        synchronized (zza) {
            z = zzc > 0;
        }
        return z;
    }

    private final void zzM() {
        zzcc zzccVar = this.zzs.zzi;
        this.zzt = zzccVar;
        zzccVar.zzb(zzce.zza);
    }

    private final AudioTrack zzN(zzqq zzqqVar) throws zzqd {
        Context context;
        try {
            int i = this.zzT;
            int i2 = this.zzo;
            Context context2 = null;
            if (i2 != -1 && (context = this.zzd) != null && Build.VERSION.SDK_INT >= 34) {
                if (this.zzae == null) {
                    this.zzae = context.createDeviceContext(i2);
                }
                context2 = this.zzae;
                i = 0;
            }
            return zzaf(zzqqVar.zza(), this.zzy, i, zzqqVar.zza, context2);
        } catch (zzqd e) {
            zzqe zzqeVar = this.zzq;
            if (zzqeVar != null) {
                zzqeVar.zzb(e);
            }
            throw e;
        }
    }

    private final void zzO(long j) throws Exception {
        zzR(j);
        if (this.zzO != null) {
            return;
        }
        if (!this.zzt.zzc()) {
            ByteBuffer byteBuffer = this.zzM;
            if (byteBuffer != null) {
                zzQ(byteBuffer);
                zzR(j);
                return;
            }
            return;
        }
        while (!this.zzt.zzg()) {
            do {
                ByteBuffer byteBufferZze = this.zzt.zze();
                if (byteBufferZze.hasRemaining()) {
                    zzQ(byteBufferZze);
                    zzR(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzM;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzt.zzd(this.zzM);
                    }
                }
            } while (this.zzO == null);
            return;
        }
    }

    private final boolean zzP() throws Exception {
        if (!this.zzt.zzc()) {
            zzR(Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzf();
        zzO(Long.MIN_VALUE);
        if (!this.zzt.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzO;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x013f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0141 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0143  */
    /* JADX WARN: Code duplicated, block: B:49:0x0147  */
    /* JADX WARN: Code duplicated, block: B:51:0x014b  */
    /* JADX WARN: Code duplicated, block: B:53:0x014f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0153  */
    /* JADX WARN: Code duplicated, block: B:57:0x0157  */
    /* JADX WARN: Code duplicated, block: B:60:0x0175  */
    /* JADX WARN: Code duplicated, block: B:61:0x0188  */
    /* JADX WARN: Code duplicated, block: B:62:0x0195  */
    /* JADX WARN: Code duplicated, block: B:63:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x01bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:67:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:68:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:73:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:79:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x01eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x004b A[SYNTHETIC] */
    private final void zzQ(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        zzgmd.zzh(this.zzO == null);
        if (byteBuffer.hasRemaining()) {
            if (this.zzs.zzc == 0) {
                int iZzs = (int) zzep.zzs(zzep.zzq(20L), this.zzs.zze);
                long jZzG = zzG();
                long j = iZzs;
                if (jZzG < j) {
                    zzqq zzqqVar = this.zzs;
                    int i12 = zzqqVar.zzg;
                    int i13 = zzqqVar.zzd;
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int iPosition = byteBuffer.position();
                    int i14 = (int) jZzG;
                    while (byteBuffer.hasRemaining() && i14 < iZzs) {
                        if (i12 != 2) {
                            if (i12 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i12 != 4) {
                                if (i12 != 21) {
                                    if (i12 == 22) {
                                        i8 = byteBuffer.get() & 255;
                                        i9 = (byteBuffer.get() & 255) << 8;
                                        i10 = (byteBuffer.get() & 255) << 16;
                                        i11 = (byteBuffer.get() & 255) << 24;
                                    } else if (i12 == 268435456) {
                                        i = (byteBuffer.get() & 255) << 24;
                                        i2 = (byteBuffer.get() & 255) << 16;
                                    } else if (i12 == 1342177280) {
                                        i5 = (byteBuffer.get() & 255) << 24;
                                        i6 = (byteBuffer.get() & 255) << 16;
                                        i7 = (byteBuffer.get() & 255) << 8;
                                    } else {
                                        if (i12 != 1610612736) {
                                            throw new IllegalStateException();
                                        }
                                        i8 = (byteBuffer.get() & 255) << 24;
                                        i9 = (byteBuffer.get() & 255) << 16;
                                        i10 = (byteBuffer.get() & 255) << 8;
                                        i11 = byteBuffer.get() & 255;
                                    }
                                    i3 = i8 | i9 | i10 | i11;
                                } else {
                                    i5 = (byteBuffer.get() & 255) << 8;
                                    i6 = (byteBuffer.get() & 255) << 16;
                                    i7 = (byteBuffer.get() & 255) << 24;
                                }
                                i3 = i5 | i6 | i7;
                            } else {
                                float fMax = Math.max(-1.0f, Math.min(byteBuffer.getFloat(), 1.0f));
                                i3 = (int) (fMax < 0.0f ? (-fMax) * (-2.14748365E9f) : fMax * 2.14748365E9f);
                            }
                            i4 = (int) ((((long) i3) * ((long) i14)) / j);
                            if (i12 != 2) {
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 3) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 4) {
                                if (i12 != 21) {
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i12 != 22) {
                                    byteBufferOrder.put((byte) i4);
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i12 != 268435456) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                } else if (i12 != 1342177280) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                } else {
                                    if (i12 == 1610612736) {
                                        throw new IllegalStateException();
                                    }
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) i4);
                                }
                            } else if (i4 < 0) {
                                byteBufferOrder.putFloat((-i4) / (-2.14748365E9f));
                            } else {
                                byteBufferOrder.putFloat(i4 / 2.14748365E9f);
                            }
                            if (byteBuffer.position() == iPosition + i13) {
                                i14++;
                                iPosition = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            i2 = (byteBuffer.get() & 255) << 24;
                        }
                        i3 = i | i2;
                        i4 = (int) ((((long) i3) * ((long) i14)) / j);
                        if (i12 != 2) {
                            byteBufferOrder.put((byte) (i4 >> 16));
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i12 != 3) {
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i12 != 4) {
                            if (i12 != 21) {
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 22) {
                                byteBufferOrder.put((byte) i4);
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i12 != 268435456) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                            } else if (i12 != 1342177280) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                            } else {
                                if (i12 == 1610612736) {
                                    throw new IllegalStateException();
                                }
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) i4);
                            }
                        } else if (i4 < 0) {
                            byteBufferOrder.putFloat((-i4) / (-2.14748365E9f));
                        } else {
                            byteBufferOrder.putFloat(i4 / 2.14748365E9f);
                        }
                        if (byteBuffer.position() == iPosition + i13) {
                            i14++;
                            iPosition = byteBuffer.position();
                        }
                    }
                    byteBufferOrder.put(byteBuffer);
                    byteBufferOrder.flip();
                    byteBuffer2 = byteBufferOrder;
                } else {
                    byteBuffer2 = byteBuffer;
                }
            } else {
                byteBuffer2 = byteBuffer;
            }
            this.zzO = byteBuffer2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0030  */
    private final void zzR(long j) throws Exception {
        zzqe zzqeVar;
        if (this.zzO == null) {
            return;
        }
        zzrc zzrcVar = this.zzn;
        if (zzrcVar.zzb()) {
            return;
        }
        int iRemaining = this.zzO.remaining();
        boolean z = true;
        int iWrite = this.zzu.write(this.zzO, iRemaining, 1);
        this.zzX = SystemClock.elapsedRealtime();
        if (iWrite >= 0) {
            zzrcVar.zzc();
            if (zzab(this.zzu)) {
                if (this.zzG > 0) {
                    this.zzZ = false;
                }
                if (this.zzS && (zzqeVar = this.zzq) != null && iWrite < iRemaining) {
                }
            }
            int i = this.zzs.zzc;
            if (i == 0) {
                this.zzF += (long) iWrite;
            }
            if (iWrite == iRemaining) {
                if (i != 0) {
                    zzgmd.zzh(this.zzO == this.zzM);
                    this.zzG += ((long) this.zzH) * ((long) this.zzN);
                }
                this.zzO = null;
                return;
            }
            return;
        }
        if (iWrite != -6 && iWrite != -32) {
            z = false;
        } else if (zzG() <= 0) {
            if (zzab(this.zzu)) {
                zzS();
            } else {
                z = false;
            }
        }
        zzqg zzqgVar = new zzqg(iWrite, this.zzs.zza, z);
        zzqe zzqeVar2 = this.zzq;
        if (zzqeVar2 != null) {
            zzqeVar2.zzb(zzqgVar);
        }
        if (!zzqgVar.zzb || this.zzd == null) {
            zzrcVar.zza(zzqgVar);
            return;
        }
        zzpe zzpeVar = zzpe.zza;
        this.zzv = zzpeVar;
        this.zzw.zza(zzpeVar);
        throw zzqgVar;
    }

    private final void zzS() {
        if (this.zzs.zzc == 1) {
            this.zzY = true;
        }
    }

    private final void zzT() {
        if (zzX()) {
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzU(zzav zzavVar) {
        zzqx zzqxVar = new zzqx(zzavVar, -9223372036854775807L, -9223372036854775807L, null);
        if (zzX()) {
            this.zzz = zzqxVar;
        } else {
            this.zzA = zzqxVar;
        }
    }

    private final void zzV(long j) {
        zzav zzavVar;
        boolean z;
        if (zzW()) {
            zzqr zzqrVar = this.zzai;
            zzavVar = this.zzB;
            zzqrVar.zzb(zzavVar);
        } else {
            zzavVar = zzav.zza;
        }
        zzav zzavVar2 = zzavVar;
        this.zzB = zzavVar2;
        if (zzW()) {
            zzqr zzqrVar2 = this.zzai;
            z = this.zzC;
            zzqrVar2.zzc(z);
        } else {
            z = false;
        }
        this.zzC = z;
        this.zzk.add(new zzqx(zzavVar2, Math.max(0L, j), zzep.zzr(zzG(), this.zzs.zze), null));
        zzM();
        zzqe zzqeVar = this.zzq;
        if (zzqeVar != null) {
            ((zzrk) zzqeVar).zza.zzaw().zzh(this.zzC);
        }
    }

    private final boolean zzW() {
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc != 0) {
            return false;
        }
        int i = zzqqVar.zza.zzI;
        return true;
    }

    private final boolean zzX() {
        return this.zzu != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzY, reason: merged with bridge method [inline-methods] */
    public final long zzF() {
        zzqq zzqqVar = this.zzs;
        return zzqqVar.zzc == 0 ? this.zzD / ((long) zzqqVar.zzb) : this.zzE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzZ, reason: merged with bridge method [inline-methods] */
    public final long zzG() {
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j2 = zzqqVar.zzd;
        String str = zzep.zza;
        return ((j + j2) - 1) / j2;
    }

    @EnsuresNonNull({"audioCapabilities"})
    private final void zzaa() {
        Context context;
        Looper looperMyLooper = Looper.myLooper();
        boolean z = true;
        if (this.zzw != null && this.zzaa != looperMyLooper) {
            z = false;
        }
        zzgmd.zzj(z, "DefaultAudioSink accessed on multiple threads: %s and %s", zzae(this.zzaa), zzae(looperMyLooper));
        if (this.zzw == null && (context = this.zzd) != null) {
            this.zzaa = looperMyLooper;
            zzpj zzpjVar = new zzpj(context, new zzpi() { // from class: com.google.android.gms.internal.ads.zzqs
                @Override // com.google.android.gms.internal.ads.zzpi
                public final /* synthetic */ void zza(zzpe zzpeVar) {
                    this.zza.zzC(zzpeVar);
                }
            }, this.zzy, this.zzW);
            this.zzw = zzpjVar;
            this.zzv = zzpjVar.zzd();
        }
        this.zzv.getClass();
    }

    private static boolean zzab(AudioTrack audioTrack) {
        return Build.VERSION.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final void zzac() {
        if (this.zzQ) {
            return;
        }
        this.zzQ = true;
        this.zzj.zzf(zzG());
        if (zzab(this.zzu)) {
            this.zzR = false;
        }
        this.zzu.stop();
    }

    private final boolean zzad(long j) {
        long jZzb = this.zzj.zzb();
        AudioTrack audioTrack = this.zzu;
        audioTrack.getClass();
        return j > zzep.zzs(jZzb, audioTrack.getSampleRate());
    }

    private static String zzae(Looper looper) {
        return looper == null ? "null" : looper.getThread().getName();
    }

    private static final AudioTrack zzaf(zzqb zzqbVar, zzd zzdVar, int i, zzv zzvVar, Context context) throws zzqd {
        Exception exc;
        try {
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzdVar.zza()).setAudioFormat(zzep.zzC(zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza)).setTransferMode(1).setBufferSizeInBytes(zzqbVar.zze).setSessionId(i);
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    sessionId.setOffloadedPlayback(zzqbVar.zzd);
                } catch (IllegalArgumentException | UnsupportedOperationException e) {
                    exc = e;
                    throw new zzqd(0, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar, zzqbVar.zzd, exc);
                }
            }
            if (Build.VERSION.SDK_INT >= 34 && context != null) {
                sessionId.setContext(context);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            int state = audioTrackBuild.getState();
            if (state == 1) {
                return audioTrackBuild;
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzqd(state, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar, zzqbVar.zzd, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e2) {
            exc = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzA() {
        zzz();
        zzgpe zzgpeVar = this.zzi;
        int size = zzgpeVar.size();
        for (int i = 0; i < size; i++) {
            ((zzcg) zzgpeVar.get(i)).zzj();
        }
        this.zzg.zzj();
        this.zzh.zzj();
        zzcc zzccVar = this.zzt;
        if (zzccVar != null) {
            zzccVar.zzh();
        }
        this.zzS = false;
        this.zzY = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzB() {
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zze();
        }
    }

    public final void zzC(zzpe zzpeVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzaa;
        zzgmd.zzj(looper == looperMyLooper, "Current looper (%s) is not the playback looper (%s)", zzae(looperMyLooper), zzae(this.zzaa));
        zzpe zzpeVar2 = this.zzv;
        if (zzpeVar2 == null || zzpeVar.equals(zzpeVar2)) {
            return;
        }
        this.zzv = zzpeVar;
        zzqe zzqeVar = this.zzq;
        if (zzqeVar != null) {
            ((zzrk) zzqeVar).zza.zzR();
        }
    }

    final /* synthetic */ void zzD() {
        if (this.zzac >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            ((zzrk) this.zzq).zza.zzay(true);
            this.zzac = 0L;
        }
    }

    final /* synthetic */ zzqe zzI() {
        return this.zzq;
    }

    final /* synthetic */ AudioTrack zzJ() {
        return this.zzu;
    }

    final /* synthetic */ void zzK(boolean z) {
        this.zzR = true;
    }

    final /* synthetic */ boolean zzL() {
        return this.zzS;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zza(zzqe zzqeVar) {
        this.zzq = zzqeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzb(zzpc zzpcVar) {
        this.zzp = zzpcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzc(zzdc zzdcVar) {
        this.zzj.zzi(zzdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzd(zzv zzvVar) {
        return zze(zzvVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final int zze(zzv zzvVar) {
        zzaa();
        if (!"audio/raw".equals(zzvVar.zzo)) {
            return this.zzv.zzd(zzvVar, this.zzy) != null ? 2 : 0;
        }
        int i = zzvVar.zzI;
        if (zzep.zzA(i)) {
            return i != 2 ? 1 : 2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 22);
        sb.append("Invalid PCM encoding: ");
        sb.append(i);
        zzdt.zzc("DefaultAudioSink", sb.toString());
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final zzpl zzf(zzv zzvVar) {
        return this.zzY ? zzpl.zza : this.zzaj.zza(zzvVar, this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final long zzg(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzX() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzj.zzb(), zzep.zzr(zzG(), this.zzs.zze));
        while (true) {
            arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || jMin < ((zzqx) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzA = (zzqx) arrayDeque.remove();
        }
        zzqx zzqxVar = this.zzA;
        long j2 = jMin - zzqxVar.zzc;
        long jZzv = zzep.zzv(j2, zzqxVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZzd = this.zzai.zzd(j2);
            zzqx zzqxVar2 = this.zzA;
            j = zzqxVar2.zzb + jZzd;
            zzqxVar2.zzd = jZzd - jZzv;
        } else {
            zzqx zzqxVar3 = this.zzA;
            j = zzqxVar3.zzb + jZzv + zzqxVar3.zzd;
        }
        long jZze = this.zzai.zze();
        long jZzr = j + zzep.zzr(jZze, this.zzs.zze);
        long j3 = this.zzab;
        if (jZze > j3) {
            long jZzr2 = zzep.zzr(jZze - j3, this.zzs.zze);
            this.zzab = jZze;
            this.zzac += jZzr2;
            if (this.zzad == null) {
                this.zzad = new Handler(Looper.myLooper());
            }
            this.zzad.removeCallbacksAndMessages(null);
            this.zzad.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzD();
                }
            }, 100L);
        }
        return jZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzh(zzv zzvVar, int i, int[] iArr) throws zzqc {
        zzcc zzccVar;
        int i2;
        int i3;
        int iZzE;
        int iIntValue;
        int i4;
        int i5;
        zzaa();
        if ("audio/raw".equals(zzvVar.zzo)) {
            int i6 = zzvVar.zzI;
            zzgmd.zza(zzep.zzA(i6));
            int i7 = zzvVar.zzG;
            iZzE = zzep.zzE(i6) * i7;
            zzgpb zzgpbVar = new zzgpb();
            zzgpbVar.zzh(this.zzi);
            zzgpbVar.zzf(this.zzg);
            zzgpbVar.zzg(this.zzai.zza());
            zzccVar = new zzcc(zzgpbVar.zzi());
            if (zzccVar.equals(this.zzt)) {
                zzccVar = this.zzt;
            }
            this.zzf.zzq(zzvVar.zzJ, zzvVar.zzK);
            this.zze.zzq(iArr);
            try {
                zzcd zzcdVarZza = zzccVar.zza(new zzcd(zzvVar.zzH, i7, i6));
                int i8 = zzcdVarZza.zzd;
                i2 = zzcdVarZza.zzb;
                int i9 = zzcdVarZza.zzc;
                int iZzB = zzep.zzB(i9);
                int iZzE2 = zzep.zzE(i8) * i9;
                i3 = 0;
                iIntValue = iZzB;
                i4 = i8;
                i5 = iZzE2;
            } catch (zzcf e) {
                throw new zzqc(e, zzvVar);
            }
        } else {
            zzccVar = new zzcc(zzgpe.zzi());
            i2 = zzvVar.zzH;
            zzpl zzplVar = zzpl.zza;
            Pair pairZzd = this.zzv.zzd(zzvVar, this.zzy);
            if (pairZzd == null) {
                String strValueOf = String.valueOf(zzvVar);
                String.valueOf(strValueOf);
                throw new zzqc("Unable to configure passthrough for: ".concat(String.valueOf(strValueOf)), zzvVar);
            }
            int iIntValue2 = ((Integer) pairZzd.first).intValue();
            i3 = 2;
            iZzE = -1;
            iIntValue = ((Integer) pairZzd.second).intValue();
            i4 = iIntValue2;
            i5 = -1;
        }
        int i10 = i2;
        if (i4 == 0) {
            String strValueOf2 = String.valueOf(zzvVar);
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 37 + String.valueOf(strValueOf2).length());
            sb.append("Invalid output encoding (mode=");
            sb.append(i3);
            sb.append(") for: ");
            sb.append(strValueOf2);
            throw new zzqc(sb.toString(), zzvVar);
        }
        if (iIntValue == 0) {
            String strValueOf3 = String.valueOf(zzvVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 43 + String.valueOf(strValueOf3).length());
            sb2.append("Invalid output channel config (mode=");
            sb2.append(i3);
            sb2.append(") for: ");
            sb2.append(strValueOf3);
            throw new zzqc(sb2.toString(), zzvVar);
        }
        int i11 = zzvVar.zzj;
        if ("audio/vnd.dts.hd;profile=lbr".equals(zzvVar.zzo) && i11 == -1) {
            i11 = 768000;
        }
        int i12 = i11;
        int minBufferSize = AudioTrack.getMinBufferSize(i10, iIntValue, i4);
        zzgmd.zzh(minBufferSize != -2);
        int i13 = i5 != -1 ? i5 : 1;
        int i14 = i4;
        int iZzb = zzrj.zzb(minBufferSize, i14, i3, i13, i10, i12);
        int i15 = i13;
        int iMax = (((Math.max(minBufferSize, iZzb) + i15) - 1) / i15) * i15;
        this.zzY = false;
        zzqq zzqqVar = new zzqq(zzvVar, iZzE, i3, i5, i10, iIntValue, i14, iMax, zzccVar, false, false, false);
        if (zzX()) {
            this.zzr = zzqqVar;
        } else {
            this.zzs = zzqqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzi() {
        this.zzS = true;
        if (zzX()) {
            this.zzj.zzc();
            if (!this.zzQ || zzab(this.zzu)) {
                this.zzu.play();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzj() {
        this.zzI = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:140:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:142:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:144:0x0301  */
    /* JADX WARN: Code duplicated, block: B:147:0x030b  */
    /* JADX WARN: Code duplicated, block: B:149:0x0314  */
    /* JADX WARN: Code duplicated, block: B:150:0x0317  */
    /* JADX WARN: Code duplicated, block: B:152:0x0321 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:153:0x0323  */
    /* JADX WARN: Code duplicated, block: B:155:0x0327  */
    /* JADX WARN: Code duplicated, block: B:156:0x033c  */
    /* JADX WARN: Code duplicated, block: B:157:0x034d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0365  */
    /* JADX WARN: Code duplicated, block: B:162:0x0381  */
    /* JADX WARN: Code duplicated, block: B:224:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzk(ByteBuffer byteBuffer, long j, int i) throws Exception {
        AudioTrack audioTrackZzN;
        zzpc zzpcVar;
        boolean z;
        int iZzb;
        int iPosition;
        byte b;
        int i2;
        int i3;
        byte b2;
        int i4;
        int i5;
        long jZzr;
        ByteBuffer byteBuffer2 = this.zzM;
        zzgmd.zza(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.zzr != null) {
            if (!zzP()) {
                return false;
            }
            zzqq zzqqVar = this.zzr;
            zzqq zzqqVar2 = this.zzs;
            if (zzqqVar2.zzc == zzqqVar.zzc && zzqqVar2.zzg == zzqqVar.zzg && zzqqVar2.zze == zzqqVar.zze && zzqqVar2.zzf == zzqqVar.zzf && zzqqVar2.zzd == zzqqVar.zzd) {
                boolean z2 = zzqqVar2.zzj;
                boolean z3 = zzqqVar.zzj;
                boolean z4 = zzqqVar2.zzk;
                boolean z5 = zzqqVar.zzk;
                this.zzs = zzqqVar;
                this.zzr = null;
                AudioTrack audioTrack = this.zzu;
                if (audioTrack != null && zzab(audioTrack)) {
                    boolean z6 = this.zzs.zzk;
                }
            } else {
                zzac();
                if (zzn()) {
                    return false;
                }
                zzz();
            }
            zzV(j);
        }
        if (!zzX()) {
            try {
                if (this.zzm.zzb()) {
                    return false;
                }
                try {
                    zzqq zzqqVar3 = this.zzs;
                    if (zzqqVar3 == null) {
                        throw null;
                    }
                    audioTrackZzN = zzN(zzqqVar3);
                    this.zzu = audioTrackZzN;
                    if (zzab(audioTrackZzN)) {
                        AudioTrack audioTrack2 = this.zzu;
                        if (this.zzl == null) {
                            this.zzl = new zzrg(this);
                        }
                        this.zzl.zza(audioTrack2);
                        boolean z7 = this.zzs.zzk;
                    }
                    if (Build.VERSION.SDK_INT >= 31 && (zzpcVar = this.zzp) != null) {
                        AudioTrack audioTrack3 = this.zzu;
                        LogSessionId logSessionIdZza = zzpcVar.zza();
                        if (!logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                            audioTrack3.setLogSessionId(logSessionIdZza);
                        }
                    }
                    zzql zzqlVar = this.zzj;
                    AudioTrack audioTrack4 = this.zzu;
                    zzqq zzqqVar4 = this.zzs;
                    zzqlVar.zza(audioTrack4, zzqqVar4.zzg, zzqqVar4.zzd, zzqqVar4.zzh, this.zzaf);
                    this.zzag = 0;
                    this.zzah = false;
                    zzT();
                    int i6 = this.zzV.zza;
                    AudioDeviceInfo audioDeviceInfo = this.zzW;
                    if (audioDeviceInfo != null) {
                        this.zzu.setPreferredDevice(audioDeviceInfo);
                        zzpj zzpjVar = this.zzw;
                        if (zzpjVar != null) {
                            zzpjVar.zzc(this.zzW);
                        }
                    }
                    zzpj zzpjVar2 = this.zzw;
                    if (zzpjVar2 != null) {
                        this.zzx = new zzrb(this.zzu, zzpjVar2);
                    }
                    this.zzJ = true;
                    int audioSessionId = this.zzu.getAudioSessionId();
                    int i7 = this.zzT;
                    this.zzT = audioSessionId;
                    zzqe zzqeVar = this.zzq;
                    if (zzqeVar != null) {
                        ((zzrk) zzqeVar).zza.zzaw().zzk(this.zzs.zza());
                        if (audioSessionId != i7) {
                            this.zzU = true;
                            zzqe zzqeVar2 = this.zzq;
                            int i8 = this.zzT;
                            if (Build.VERSION.SDK_INT >= 35) {
                                zzrl zzrlVar = ((zzrk) zzqeVar2).zza;
                                if (zzrlVar.zzax() != null) {
                                    zzrlVar.zzax().zza(i8);
                                }
                            }
                            ((zzrk) zzqeVar2).zza.zzaw().zzm(i8);
                        }
                    }
                } catch (zzqd e) {
                    zzqq zzqqVar5 = this.zzs;
                    if (zzqqVar5.zzh > 1000000) {
                        zzv zzvVar = zzqqVar5.zza;
                        int i9 = zzqqVar5.zzb;
                        int i10 = zzqqVar5.zzc;
                        int i11 = zzqqVar5.zzd;
                        int i12 = zzqqVar5.zze;
                        int i13 = zzqqVar5.zzf;
                        int i14 = zzqqVar5.zzg;
                        zzcc zzccVar = zzqqVar5.zzi;
                        boolean z8 = zzqqVar5.zzj;
                        boolean z9 = zzqqVar5.zzk;
                        boolean z10 = zzqqVar5.zzl;
                        zzqq zzqqVar6 = new zzqq(zzvVar, i9, i10, i11, i12, i13, i14, DurationKt.NANOS_IN_MILLIS, zzccVar, false, false, false);
                        try {
                            audioTrackZzN = zzN(zzqqVar6);
                            this.zzs = zzqqVar6;
                        } catch (zzqd e2) {
                            e.addSuppressed(e2);
                            zzS();
                            throw e;
                        }
                    }
                    zzS();
                    throw e;
                }
            } catch (zzqd e3) {
                if (e3.zzb) {
                    throw e3;
                }
                this.zzm.zza(e3);
                return false;
            }
        }
        this.zzm.zzc();
        if (this.zzJ) {
            this.zzK = Math.max(0L, j);
            this.zzI = false;
            this.zzJ = false;
            zzV(j);
            if (this.zzS) {
                zzi();
            }
        }
        zzG();
        AudioTrack audioTrack5 = this.zzu;
        audioTrack5.getClass();
        int underrunCount = audioTrack5.getUnderrunCount();
        int i15 = this.zzag;
        this.zzag = underrunCount;
        if (underrunCount > i15 && this.zzq != null) {
            zzqq zzqqVar7 = this.zzs;
            int i16 = zzqqVar7.zzd;
            if (i16 != -1) {
                long j2 = zzqqVar7.zzh / i16;
                AudioTrack audioTrack6 = this.zzu;
                audioTrack6.getClass();
                jZzr = zzep.zzr(j2, audioTrack6.getSampleRate());
            } else {
                jZzr = -9223372036854775807L;
            }
            ((zzrk) this.zzq).zza.zzaw().zze(this.zzs.zzh, zzep.zzp(jZzr), SystemClock.elapsedRealtime() - this.zzX);
        }
        if (this.zzM == null) {
            zzgmd.zza(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            zzqq zzqqVar8 = this.zzs;
            if (zzqqVar8.zzc != 0 && this.zzH == 0) {
                int i17 = zzqqVar8.zzg;
                if (i17 == 20) {
                    z = true;
                    iZzb = zzadz.zzb(byteBuffer);
                } else if (i17 != 30) {
                    switch (i17) {
                        case 5:
                        case 6:
                            iZzb = zzacb.zze(byteBuffer);
                            z = true;
                            break;
                        case 7:
                        case 8:
                            int i18 = zzacz.zza;
                            if (byteBuffer.getInt(0) == -233094848) {
                                z = true;
                                iZzb = 1024;
                            } else {
                                if (byteBuffer.getInt(0) == -398277519) {
                                    iZzb = 1024;
                                } else if (byteBuffer.getInt(0) != 622876772) {
                                    iPosition = byteBuffer.position();
                                    b = byteBuffer.get(iPosition);
                                    if (b != -2) {
                                        if (b != -1) {
                                            if (b != 31) {
                                                i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                                i4 = byteBuffer.get(iPosition + 5) & 252;
                                            } else {
                                                i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                                b2 = byteBuffer.get(iPosition + 6);
                                            }
                                            i2 = (i4 >> 2) | i3;
                                            z = true;
                                        } else {
                                            i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                            b2 = byteBuffer.get(iPosition + 7);
                                        }
                                        i4 = b2 & 60;
                                        i2 = (i4 >> 2) | i3;
                                        z = true;
                                    } else {
                                        z = true;
                                        i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                                    }
                                    iZzb = (i2 + 1) * 32;
                                } else {
                                    iZzb = 4096;
                                }
                                z = true;
                            }
                            break;
                        case 9:
                            iZzb = zzadx.zzb(zzep.zzK(byteBuffer, byteBuffer.position()));
                            if (iZzb == -1) {
                                throw new IllegalArgumentException();
                            }
                            z = true;
                            break;
                        case 10:
                            iZzb = 1024;
                            z = true;
                            break;
                        case 11:
                        case 12:
                            iZzb = 2048;
                            z = true;
                            break;
                        default:
                            switch (i17) {
                                case 14:
                                    int i19 = zzacb.zza;
                                    int iPosition2 = byteBuffer.position();
                                    int iLimit = byteBuffer.limit() - 10;
                                    int i20 = iPosition2;
                                    while (true) {
                                        if (i20 > iLimit) {
                                            i5 = -1;
                                        } else if ((zzep.zzK(byteBuffer, i20 + 4) & (-2)) == -126718022) {
                                            i5 = i20 - iPosition2;
                                        } else {
                                            i20++;
                                        }
                                    }
                                    if (i5 != -1) {
                                        iZzb = (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                                    } else {
                                        iZzb = 0;
                                    }
                                    break;
                                case 15:
                                    iZzb = 512;
                                    break;
                                case 16:
                                    iZzb = 1024;
                                    break;
                                case 17:
                                    int i21 = zzace.zza;
                                    byte[] bArr = new byte[16];
                                    int iPosition3 = byteBuffer.position();
                                    byteBuffer.get(bArr);
                                    byteBuffer.position(iPosition3);
                                    iZzb = zzace.zzb(new zzef(bArr, 16)).zzc;
                                    break;
                                case 18:
                                    iZzb = zzacb.zze(byteBuffer);
                                    break;
                                default:
                                    StringBuilder sb = new StringBuilder(String.valueOf(i17).length() + 27);
                                    sb.append("Unexpected audio encoding: ");
                                    sb.append(i17);
                                    throw new IllegalStateException(sb.toString());
                            }
                            z = true;
                            break;
                    }
                } else {
                    int i110 = zzacz.zza;
                    if (byteBuffer.getInt(0) == -233094848) {
                        if (byteBuffer.getInt(0) == -398277519) {
                            iZzb = 1024;
                        } else if (byteBuffer.getInt(0) != 622876772) {
                            iZzb = 4096;
                        } else {
                            iPosition = byteBuffer.position();
                            b = byteBuffer.get(iPosition);
                            if (b != -2) {
                                if (b != -1) {
                                    if (b != 31) {
                                        i3 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                                        i4 = byteBuffer.get(iPosition + 5) & 252;
                                    } else {
                                        i3 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                                        b2 = byteBuffer.get(iPosition + 6);
                                    }
                                    i2 = (i4 >> 2) | i3;
                                    z = true;
                                } else {
                                    i3 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                                    b2 = byteBuffer.get(iPosition + 7);
                                }
                                i4 = b2 & 60;
                                i2 = (i4 >> 2) | i3;
                                z = true;
                            } else {
                                z = true;
                                i2 = ((byteBuffer.get(iPosition + 5) & 1) << 6) | ((byteBuffer.get(iPosition + 4) & 252) >> 2);
                            }
                            iZzb = (i2 + 1) * 32;
                        }
                        z = true;
                    } else {
                        z = true;
                        iZzb = 1024;
                    }
                }
                this.zzH = iZzb;
                if (iZzb == 0) {
                    return z;
                }
            }
            if (this.zzz != null) {
                if (!zzP()) {
                    return false;
                }
                zzV(j);
                this.zzz = null;
            }
            long jZzr2 = this.zzK + zzep.zzr(zzF() - this.zzf.zzs(), this.zzs.zza.zzH);
            if (!this.zzI && Math.abs(jZzr2 - j) > 200000) {
                zzqe zzqeVar3 = this.zzq;
                if (zzqeVar3 != null) {
                    zzqeVar3.zzb(new zzqf(j, jZzr2));
                }
                this.zzI = true;
            }
            if (this.zzI) {
                if (!zzP()) {
                    return false;
                }
                long j3 = j - jZzr2;
                this.zzK += j3;
                this.zzI = false;
                zzV(j);
                zzqe zzqeVar4 = this.zzq;
                if (zzqeVar4 != null && j3 != 0) {
                    ((zzrk) zzqeVar4).zza.zzao();
                }
            }
            if (this.zzs.zzc == 0) {
                this.zzD += (long) byteBuffer.remaining();
            } else {
                this.zzE += ((long) this.zzH) * ((long) i);
            }
            this.zzM = byteBuffer;
            this.zzN = i;
        }
        zzO(j);
        if (!this.zzM.hasRemaining()) {
            this.zzM = null;
            this.zzN = 0;
            return true;
        }
        if (!this.zzj.zze(zzG())) {
            return false;
        }
        zzdt.zzc("DefaultAudioSink", "Resetting stalled audio track");
        zzz();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzl() throws zzqg {
        if (!this.zzP && zzX() && zzP()) {
            zzac();
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzm() {
        if (zzX()) {
            return this.zzP && !zzn();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzn() {
        if (zzX()) {
            return !(Build.VERSION.SDK_INT >= 29 && this.zzu.isOffloadedPlayback() && this.zzR) && zzad(zzG());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzo(zzav zzavVar) {
        float f = zzavVar.zzb;
        String str = zzep.zza;
        this.zzB = new zzav(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzavVar.zzc, 8.0f)));
        zzU(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final zzav zzp() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzq(boolean z) {
        this.zzC = z;
        zzU(this.zzB);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzr(zzd zzdVar) {
        if (this.zzy.equals(zzdVar)) {
            return;
        }
        this.zzy = zzdVar;
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zzb(zzdVar);
        }
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzs(int i) {
        if (this.zzU) {
            if (this.zzT != i) {
                return;
            } else {
                this.zzU = false;
            }
        }
        if (this.zzT != i) {
            this.zzT = i;
            zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzt(zze zzeVar) {
        if (this.zzV.equals(zzeVar)) {
            return;
        }
        if (this.zzu != null) {
            int i = this.zzV.zza;
        }
        this.zzV = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzu(AudioDeviceInfo audioDeviceInfo) {
        this.zzW = audioDeviceInfo;
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zzc(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            audioTrack.setPreferredDevice(this.zzW);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final long zzv() {
        if (!zzX()) {
            return -9223372036854775807L;
        }
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc == 0) {
            return zzep.zzr(this.zzu.getBufferSizeInFrames(), zzqqVar.zze);
        }
        long bufferSizeInFrames = this.zzu.getBufferSizeInFrames();
        int iZzf = zzade.zzf(this.zzs.zzg);
        zzgmd.zzh(iZzf != -2147483647);
        return zzep.zzt(bufferSizeInFrames, 1000000L, iZzf, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzw(int i, int i2) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzab(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzx(float f) {
        if (this.zzL != f) {
            this.zzL = f;
            zzT();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzy() {
        this.zzS = false;
        if (zzX()) {
            this.zzj.zzg();
            if (!this.zzQ || zzab(this.zzu)) {
                this.zzu.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzz() {
        if (zzX()) {
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzF = 0L;
            this.zzG = 0L;
            this.zzZ = false;
            this.zzH = 0;
            this.zzA = new zzqx(this.zzB, 0L, 0L, null);
            this.zzK = 0L;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzR = false;
            this.zzf.zzr();
            zzM();
            zzql zzqlVar = this.zzj;
            if (zzqlVar.zzd()) {
                this.zzu.pause();
            }
            if (zzab(this.zzu)) {
                zzrg zzrgVar = this.zzl;
                zzrgVar.getClass();
                zzrgVar.zzb(this.zzu);
            }
            final zzqb zzqbVarZza = this.zzs.zza();
            zzqq zzqqVar = this.zzr;
            if (zzqqVar != null) {
                this.zzs = zzqqVar;
                this.zzr = null;
            }
            zzqlVar.zzh();
            zzrb zzrbVar = this.zzx;
            if (zzrbVar != null) {
                zzrbVar.zza();
                this.zzx = null;
            }
            final AudioTrack audioTrack = this.zzu;
            final zzqe zzqeVar = this.zzq;
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzep.zzg("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzrh.zzE(audioTrack, zzqeVar, handler, zzqbVarZza);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            }
            this.zzu = null;
        }
        this.zzn.zzc();
        this.zzm.zzc();
        this.zzab = 0L;
        this.zzac = 0L;
        Handler handler2 = this.zzad;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* synthetic */ zzrh(zzqp zzqpVar, byte[] bArr) {
        int deviceId;
        byte[] bArr2 = null;
        Context applicationContext = zzqpVar.zzb() == null ? null : zzqpVar.zzb().getApplicationContext();
        this.zzd = applicationContext;
        this.zzy = zzd.zza;
        this.zzv = applicationContext != null ? null : zzqpVar.zzc();
        this.zzai = zzqpVar.zzd();
        zzqn zzqnVarZze = zzqpVar.zze();
        zzqnVarZze.getClass();
        this.zzaj = zzqnVarZze;
        this.zzj = new zzql(new zzrd(this, bArr2));
        zzqm zzqmVar = new zzqm();
        this.zze = zzqmVar;
        zzrp zzrpVar = new zzrp();
        this.zzf = zzrpVar;
        this.zzg = new zzck();
        this.zzh = new zzro();
        this.zzi = zzgpe.zzk(zzrpVar, zzqmVar);
        this.zzL = 1.0f;
        this.zzT = 0;
        this.zzV = new zze(0, 0.0f);
        zzav zzavVar = zzav.zza;
        this.zzA = new zzqx(zzavVar, 0L, 0L, null);
        this.zzB = zzavVar;
        this.zzC = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzrc();
        this.zzn = new zzrc();
        int i = -1;
        if (Build.VERSION.SDK_INT >= 34 && zzqpVar.zzb() != null && (deviceId = zzqpVar.zzb().getDeviceId()) != 0 && deviceId != -1) {
            i = deviceId;
        }
        this.zzo = i;
        this.zzaf = true;
    }
}
