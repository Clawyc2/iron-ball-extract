package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzte extends zzhr {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private ArrayDeque zzA;
    private zztb zzB;
    private zzsy zzC;
    private int zzD;
    private boolean zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private long zzJ;
    private boolean zzK;
    private long zzL;
    private int zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private int zzV;
    private int zzW;
    private int zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzhs zza;
    private boolean zzaa;
    private long zzab;
    private boolean zzac;
    private boolean zzad;
    private boolean zzae;
    private zztd zzaf;
    private long zzag;
    private boolean zzah;
    private boolean zzai;
    private boolean zzaj;
    private long zzak;
    private final zzst zzc;
    private final zztg zzd;
    private final float zze;
    private final zzhh zzf;
    private final zzhh zzg;
    private final zzhh zzh;
    private final zzsm zzi;
    private final MediaCodec.BufferInfo zzj;
    private final ArrayDeque zzk;
    private final zzrm zzl;
    private zzv zzm;
    private zzv zzn;
    private zzrs zzo;
    private zzrs zzp;
    private zzlm zzq;
    private MediaCrypto zzr;
    private long zzs;
    private float zzt;
    private float zzu;
    private zzsv zzv;
    private zzv zzw;
    private MediaFormat zzx;
    private boolean zzy;
    private float zzz;

    public zzte(int i, zzst zzstVar, zztg zztgVar, boolean z, float f) {
        super(i);
        this.zzc = zzstVar;
        zztgVar.getClass();
        this.zzd = zztgVar;
        this.zze = f;
        this.zzf = new zzhh(0, 0);
        this.zzg = new zzhh(0, 0);
        this.zzh = new zzhh(2, 0);
        zzsm zzsmVar = new zzsm();
        this.zzi = zzsmVar;
        this.zzj = new MediaCodec.BufferInfo();
        this.zzt = 1.0f;
        this.zzu = 1.0f;
        this.zzs = -9223372036854775807L;
        this.zzk = new ArrayDeque();
        this.zzaf = zztd.zza;
        zzsmVar.zzj(0);
        zzsmVar.zzc.order(ByteOrder.nativeOrder());
        this.zzl = new zzrm();
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzV = 0;
        this.zzM = -1;
        this.zzN = -1;
        this.zzL = -9223372036854775807L;
        this.zzab = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
        this.zzJ = -9223372036854775807L;
        this.zzW = 0;
        this.zzX = 0;
        this.zza = new zzhs();
        this.zzaj = false;
        this.zzak = 0L;
    }

    private final void zzao() {
        this.zzR = false;
        zzat();
    }

    private final void zzat() {
        zzaw();
        this.zzT = false;
        this.zzi.zza();
        this.zzh.zza();
        this.zzS = false;
        this.zzl.zzb();
    }

    private final boolean zzau() {
        if (this.zzv == null) {
            return false;
        }
        if (zzaK()) {
            zzaI();
            return true;
        }
        if (zzaL()) {
            zzav();
            return false;
        }
        this.zzaj = true;
        return false;
    }

    private final void zzav() {
        try {
            zzsv zzsvVar = this.zzv;
            if (zzsvVar == null) {
                throw null;
            }
            zzsvVar.zzj();
            zzaN();
        } catch (Throwable th) {
            zzaN();
            throw th;
        }
    }

    private final void zzaw() {
        this.zzab = -9223372036854775807L;
        this.zzaf.zzf = -9223372036854775807L;
        this.zzag = -9223372036854775807L;
    }

    private final boolean zzax(int i) throws zzib {
        zzkj zzkjVarZzH = zzH();
        zzhh zzhhVar = this.zzf;
        zzhhVar.zza();
        int iZzO = zzO(zzkjVarZzH, zzhhVar, i | 4);
        if (iZzO == -5) {
            zzam(zzkjVarZzH);
            return true;
        }
        if (iZzO != -4 || !zzhhVar.zzb()) {
            return false;
        }
        this.zzac = true;
        zzbl();
        return false;
    }

    private final boolean zzay(long j) {
        return this.zzs == -9223372036854775807L || zzL().zzb() - j < this.zzs;
    }

    protected static boolean zzbd(zzv zzvVar) {
        return zzvVar.zzN == 0;
    }

    private final boolean zzbf() {
        return this.zzN >= 0;
    }

    private final void zzbg() {
        this.zzM = -1;
        this.zzg.zzc = null;
    }

    private final void zzbh() {
        this.zzN = -1;
        this.zzO = null;
    }

    private final boolean zzbi(zzv zzvVar) throws zzib {
        if (this.zzv != null && this.zzX != 3 && zze() != 0) {
            float f = this.zzu;
            zzvVar.getClass();
            float fZzai = zzai(f, zzvVar, zzI());
            float f2 = this.zzz;
            if (f2 != fZzai) {
                if (fZzai == -1.0f) {
                    zzbk();
                    return false;
                }
                if (f2 != -1.0f || fZzai > this.zze) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzai);
                    zzsv zzsvVar = this.zzv;
                    zzsvVar.getClass();
                    zzsvVar.zzo(bundle);
                    this.zzz = fZzai;
                }
            }
        }
        return true;
    }

    private final boolean zzbj() throws zzib {
        if (this.zzY) {
            this.zzW = 1;
            if (this.zzF) {
                this.zzX = 3;
                return false;
            }
            this.zzX = 2;
        } else {
            zzbo();
        }
        return true;
    }

    private final void zzbk() throws zzib {
        if (this.zzY) {
            this.zzW = 1;
            this.zzX = 3;
        } else {
            zzaI();
            zzaA();
        }
    }

    private final void zzbm(zztd zztdVar) {
        this.zzaf = zztdVar;
        if (zztdVar.zzd != -9223372036854775807L) {
            this.zzah = true;
        }
    }

    private final zztd zzbn() {
        ArrayDeque arrayDeque = this.zzk;
        return !arrayDeque.isEmpty() ? (zztd) arrayDeque.getLast() : this.zzaf;
    }

    private final boolean zzbp(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzv zzvVar = this.zzn;
        return (zzvVar != null && Objects.equals(zzvVar.zzo, "audio/opus") && zzadz.zzf(j, j2)) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected void zzA(long j, boolean z, boolean z2) throws zzib {
        if (z2) {
            this.zzac = false;
            this.zzad = false;
            if (this.zzR) {
                zzat();
            } else {
                zzaJ();
            }
            zzel zzelVar = this.zzaf.zze;
            if (zzelVar.zzc() > 0) {
                this.zzae = true;
            }
            zzelVar.zzb();
            this.zzk.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected void zzD() {
        this.zzm = null;
        zzbm(zztd.zza);
        this.zzk.clear();
        if (this.zzR) {
            zzao();
        } else {
            zzau();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected void zzE() {
        try {
            zzao();
            zzaI();
        } finally {
            this.zzp = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final long zzT(long j, long j2) {
        return zzah(j, j2, this.zzK);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public void zzV(float f, float f2) throws zzib {
        this.zzt = f;
        this.zzu = f2;
        zzbi(this.zzw);
    }

    /* JADX WARN: Code duplicated, block: B:220:0x036a A[LOOP:0: B:117:0x01f0->B:220:0x036a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:362:0x059f  */
    /* JADX WARN: Code duplicated, block: B:364:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:368:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:371:0x05c4  */
    /* JADX WARN: Code duplicated, block: B:373:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:376:0x05d6  */
    /* JADX WARN: Code duplicated, block: B:377:0x05d9  */
    /* JADX WARN: Code duplicated, block: B:403:0x0369 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzte] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    @Override // com.google.android.gms.internal.ads.zzln
    public void zzX(long j, long j2) throws Throwable {
        ?? r12;
        boolean z;
        ?? r13;
        boolean z2;
        ?? r2;
        zzsx zzsxVarZzaP;
        int i;
        StackTraceElement[] stackTrace;
        boolean z3;
        boolean z4;
        Throwable th;
        long j3;
        ByteBuffer byteBuffer;
        int i2;
        MediaCodec.BufferInfo bufferInfo;
        long j4;
        int i3;
        long j5;
        boolean z5;
        boolean z6;
        boolean z7 = true;
        try {
            try {
                if (this.zzad) {
                    zzar();
                    return;
                }
                int i4 = 2;
                if (this.zzm == null && !zzax(2)) {
                    return;
                }
                zzaA();
                byte b = -5;
                ?? r6 = 0;
                try {
                    try {
                        try {
                            try {
                                if (this.zzR) {
                                    try {
                                        try {
                                            Trace.beginSection("bypassRender");
                                            while (true) {
                                                zzgmd.zzh(this.zzad ^ z7);
                                                zzsm zzsmVar = this.zzi;
                                                try {
                                                    if (zzsmVar.zzp()) {
                                                        ByteBuffer byteBuffer2 = zzsmVar.zzc;
                                                        int i5 = this.zzN;
                                                        int iZzo = zzsmVar.zzo();
                                                        long j6 = zzsmVar.zze;
                                                        boolean zZzbp = zzbp(zzG(), zzsmVar.zzn());
                                                        boolean zZzb = zzsmVar.zzb();
                                                        zzv zzvVar = this.zzn;
                                                        if (zzvVar == null) {
                                                            throw r6;
                                                        }
                                                        if (zzaq(j, j2, null, byteBuffer2, i5, 0, iZzo, j6, zZzbp, zZzb, zzvVar)) {
                                                            zzaV(zzsmVar.zzn());
                                                            zzsmVar.zza();
                                                            r6 = 0;
                                                        } else {
                                                            z7 = true;
                                                        }
                                                        z4 = false;
                                                        break;
                                                    }
                                                    r6 = r6;
                                                    if (!this.zzac) {
                                                        z7 = true;
                                                        if (this.zzS) {
                                                            zzgmd.zzh(zzsmVar.zzq(this.zzh));
                                                            z4 = false;
                                                            this.zzS = false;
                                                        } else {
                                                            z4 = false;
                                                        }
                                                        if (this.zzT) {
                                                            if (!zzsmVar.zzp()) {
                                                                zzao();
                                                                this.zzT = z4;
                                                                zzaA();
                                                                if (!this.zzR) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        zzgmd.zzh(!this.zzac);
                                                        zzkj zzkjVarZzH = zzH();
                                                        zzhh zzhhVar = this.zzh;
                                                        zzhhVar.zza();
                                                        while (true) {
                                                            zzhhVar.zza();
                                                            int iZzO = zzO(zzkjVarZzH, zzhhVar, z4 ? 1 : 0);
                                                            if (iZzO == -5) {
                                                                zzam(zzkjVarZzH);
                                                                break;
                                                            }
                                                            if (iZzO != -4) {
                                                                if (!zzdb()) {
                                                                    break;
                                                                }
                                                                zzbn().zzf = this.zzab;
                                                                break;
                                                            }
                                                            if (zzhhVar.zzb()) {
                                                                this.zzac = true;
                                                                zzbn().zzf = this.zzab;
                                                                break;
                                                            }
                                                            this.zzab = Math.max(this.zzab, zzhhVar.zze);
                                                            if (zzdb() || this.zzg.zzd()) {
                                                                zzbn().zzf = this.zzab;
                                                            }
                                                            if (this.zzae) {
                                                                zzv zzvVar2 = this.zzm;
                                                                if (zzvVar2 == null) {
                                                                    throw r6;
                                                                }
                                                                this.zzn = zzvVar2;
                                                                if (Objects.equals(zzvVar2.zzo, "audio/opus") && !this.zzn.zzr.isEmpty()) {
                                                                    int iZze = zzadz.zze((byte[]) this.zzn.zzr.get(z4 ? 1 : 0));
                                                                    zzt zztVarZza = this.zzn.zza();
                                                                    zztVarZza.zzH(iZze);
                                                                    this.zzn = zztVarZza.zzM();
                                                                }
                                                                zzan(this.zzn, r6);
                                                                this.zzae = z4;
                                                            }
                                                            zzhhVar.zzl();
                                                            zzv zzvVar3 = this.zzn;
                                                            if (zzvVar3 != null && Objects.equals(zzvVar3.zzo, "audio/opus")) {
                                                                if (zzhhVar.zze()) {
                                                                    zzhhVar.zza = this.zzn;
                                                                    zzas(zzhhVar);
                                                                }
                                                                if (zzadz.zzf(zzG(), zzhhVar.zze)) {
                                                                    this.zzl.zza(zzhhVar, this.zzn.zzr);
                                                                }
                                                            }
                                                            if (zzsmVar.zzp()) {
                                                                long jZzG = zzG();
                                                                if (zzbp(jZzG, zzsmVar.zzn()) == zzbp(jZzG, zzhhVar.zze)) {
                                                                }
                                                                this.zzS = true;
                                                                break;
                                                            }
                                                            if (!zzsmVar.zzq(zzhhVar)) {
                                                                this.zzS = true;
                                                                break;
                                                            }
                                                        }
                                                        if (zzsmVar.zzp()) {
                                                            zzsmVar.zzl();
                                                        }
                                                        if (!zzsmVar.zzp() && !this.zzac && !this.zzT) {
                                                            break;
                                                        }
                                                    } else {
                                                        z7 = true;
                                                        this.zzad = true;
                                                        z4 = false;
                                                        break;
                                                    }
                                                } catch (IllegalStateException e) {
                                                    e = e;
                                                    z7 = true;
                                                    b = 0;
                                                    z = z7;
                                                    r13 = b;
                                                    z2 = e instanceof MediaCodec.CodecException;
                                                    if (!z2) {
                                                        stackTrace = e.getStackTrace();
                                                        if (stackTrace.length > 0) {
                                                        }
                                                        throw e;
                                                    }
                                                    zzal(e);
                                                    if (z2) {
                                                        r2 = r13;
                                                    } else {
                                                        r2 = r13;
                                                    }
                                                    if (r2 != 0) {
                                                        zzaI();
                                                    }
                                                    zzsxVarZzaP = zzaP(e, this.zzC);
                                                    if (zzsxVarZzaP.zza == 1101) {
                                                        i = 4006;
                                                    } else {
                                                        i = 4003;
                                                    }
                                                    throw zzN(zzsxVarZzaP, this.zzm, r2, i);
                                                }
                                            }
                                            Trace.endSection();
                                        } catch (IllegalStateException e2) {
                                            e = e2;
                                        }
                                    } catch (MediaCodec.CryptoException e3) {
                                        e = e3;
                                        b = 0;
                                        r12 = b;
                                        throw zzN(e, this.zzm, r12, zzep.zzF(e.getErrorCode()));
                                    }
                                } else {
                                    byte b2 = -5;
                                    Throwable th2 = null;
                                    boolean z8 = false;
                                    if (this.zzv != null) {
                                        long jZzb = zzL().zzb();
                                        Trace.beginSection("drainAndFeed");
                                        long j7 = jZzb;
                                        while (true) {
                                            zzsv zzsvVar = this.zzv;
                                            if (zzsvVar == null) {
                                                throw th2;
                                            }
                                            try {
                                                if (!zzbf()) {
                                                    try {
                                                        MediaCodec.BufferInfo bufferInfo2 = this.zzj;
                                                        int iZzf = zzsvVar.zzf(bufferInfo2);
                                                        if (iZzf >= 0) {
                                                            th = th2;
                                                            bufferInfo2.presentationTimeUs -= this.zzak;
                                                            if (!this.zzH) {
                                                                if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                                                                    zzbl();
                                                                    j3 = j7;
                                                                    break;
                                                                }
                                                                this.zzN = iZzf;
                                                                ByteBuffer byteBufferZzi = zzsvVar.zzi(iZzf);
                                                                this.zzO = byteBufferZzi;
                                                                if (byteBufferZzi != null) {
                                                                    byteBufferZzi.position(bufferInfo2.offset);
                                                                    this.zzO.limit(bufferInfo2.offset + bufferInfo2.size);
                                                                }
                                                                zzv zzvVar4 = (zzv) this.zzaf.zze.zze(bufferInfo2.presentationTimeUs);
                                                                if (zzvVar4 == null && this.zzah && this.zzx != null) {
                                                                    zzvVar4 = (zzv) this.zzaf.zze.zzd();
                                                                }
                                                                if (zzvVar4 != null) {
                                                                    this.zzn = zzvVar4;
                                                                } else if (this.zzy && this.zzn != null) {
                                                                }
                                                                zzv zzvVar5 = this.zzn;
                                                                if (zzvVar5 == null) {
                                                                    throw th;
                                                                }
                                                                zzan(zzvVar5, this.zzx);
                                                                this.zzy = z8;
                                                                this.zzah = z8;
                                                            } else {
                                                                this.zzH = z8;
                                                                zzsvVar.zzc(iZzf, z8);
                                                                j3 = j7;
                                                                if (!zzay(j3)) {
                                                                    break;
                                                                    break;
                                                                }
                                                                j7 = j3;
                                                                th2 = th;
                                                                z7 = true;
                                                                i4 = 2;
                                                                z8 = false;
                                                                b2 = -5;
                                                            }
                                                        } else {
                                                            if (iZzf != -2) {
                                                                if (this.zzI && (this.zzac || this.zzW == i4)) {
                                                                    zzbl();
                                                                }
                                                                long j8 = this.zzJ;
                                                                if (j8 != -9223372036854775807L && j8 + 100 < zzL().zza()) {
                                                                    zzbl();
                                                                }
                                                                th = th2;
                                                                j3 = j7;
                                                                break;
                                                            }
                                                            this.zzaa = z7;
                                                            zzsv zzsvVar2 = this.zzv;
                                                            if (zzsvVar2 == null) {
                                                                throw th2;
                                                            }
                                                            MediaFormat mediaFormatZzg = zzsvVar2.zzg();
                                                            if (this.zzD != 0 && mediaFormatZzg.getInteger("width") == 32 && mediaFormatZzg.getInteger("height") == 32) {
                                                                this.zzH = z7;
                                                            } else {
                                                                this.zzx = mediaFormatZzg;
                                                                this.zzy = z7;
                                                            }
                                                            th = th2;
                                                            j3 = j7;
                                                            if (!zzay(j3)) {
                                                                break;
                                                            }
                                                            j7 = j3;
                                                            th2 = th;
                                                            z7 = true;
                                                            i4 = 2;
                                                            z8 = false;
                                                            b2 = -5;
                                                        }
                                                    } catch (IllegalStateException e4) {
                                                        e = e4;
                                                        z3 = z8;
                                                        z = true;
                                                        r13 = z3;
                                                    }
                                                    z2 = e instanceof MediaCodec.CodecException;
                                                    if (!z2) {
                                                        stackTrace = e.getStackTrace();
                                                        if (stackTrace.length > 0 || !stackTrace[r13].getClassName().equals("android.media.MediaCodec")) {
                                                            throw e;
                                                        }
                                                    }
                                                    zzal(e);
                                                    if (z2 || !((MediaCodec.CodecException) e).isRecoverable()) {
                                                        r2 = r13;
                                                    } else {
                                                        r2 = z;
                                                    }
                                                    if (r2 != 0) {
                                                        zzaI();
                                                    }
                                                    zzsxVarZzaP = zzaP(e, this.zzC);
                                                    if (zzsxVarZzaP.zza == 1101) {
                                                        i = 4006;
                                                    } else {
                                                        i = 4003;
                                                    }
                                                    throw zzN(zzsxVarZzaP, this.zzm, r2, i);
                                                }
                                                th = th2;
                                                zzv zzvVar6 = this.zzn;
                                                if (zzvVar6 == null) {
                                                    throw th;
                                                }
                                                if (zzaq(j, j2, zzsvVar, byteBuffer, i2, i3, 1, j5, z5, z6, zzvVar6)) {
                                                    zzaV(bufferInfo.presentationTimeUs);
                                                    boolean z9 = (bufferInfo.flags & 4) != 0;
                                                    if (!z9 && this.zzZ && this.zzQ) {
                                                        this.zzJ = zzL().zza();
                                                    }
                                                    zzbh();
                                                    if (z9) {
                                                        zzbl();
                                                    } else {
                                                        j3 = j4;
                                                        if (!zzay(j3)) {
                                                            break;
                                                            break;
                                                        }
                                                        j7 = j3;
                                                        th2 = th;
                                                        z7 = true;
                                                        i4 = 2;
                                                        z8 = false;
                                                        b2 = -5;
                                                    }
                                                }
                                                j3 = j4;
                                                break;
                                            } catch (IllegalStateException e5) {
                                                e = e5;
                                                r13 = z8;
                                                z = true;
                                            }
                                            this.zzP = (this.zzaj || this.zzj.presentationTimeUs < zzG()) ? true : z8;
                                            long j9 = this.zzaf.zzf;
                                            this.zzQ = (j9 == -9223372036854775807L || j9 > this.zzj.presentationTimeUs) ? z8 : true;
                                            byteBuffer = this.zzO;
                                            i2 = this.zzN;
                                            bufferInfo = this.zzj;
                                            j4 = j7;
                                            i3 = bufferInfo.flags;
                                            j5 = bufferInfo.presentationTimeUs;
                                            z5 = this.zzP;
                                            z6 = this.zzQ;
                                        }
                                        do {
                                            zzsv zzsvVar3 = this.zzv;
                                            if (zzsvVar3 == null || this.zzW == 2 || this.zzac) {
                                                break;
                                            }
                                            if (this.zzM < 0) {
                                                int iZze2 = zzsvVar3.zze();
                                                this.zzM = iZze2;
                                                if (iZze2 < 0) {
                                                    break;
                                                    break;
                                                } else {
                                                    zzhh zzhhVar2 = this.zzg;
                                                    zzhhVar2.zzc = zzsvVar3.zzh(iZze2);
                                                    zzhhVar2.zza();
                                                }
                                            }
                                            z = true;
                                            if (this.zzW == 1) {
                                                if (!this.zzI) {
                                                    this.zzZ = true;
                                                    zzsvVar3.zza(this.zzM, 0, 0, 0L, 4);
                                                    zzbg();
                                                }
                                                this.zzW = 2;
                                                break;
                                            }
                                            try {
                                                if (this.zzG) {
                                                    this.zzG = false;
                                                    ByteBuffer byteBuffer3 = this.zzg.zzc;
                                                    if (byteBuffer3 == null) {
                                                        throw th;
                                                    }
                                                    byteBuffer3.put(zzb);
                                                    zzsvVar3.zza(this.zzM, 0, 38, 0L, 0);
                                                    zzbg();
                                                    this.zzY = true;
                                                } else {
                                                    if (this.zzV == 1) {
                                                        int i6 = 0;
                                                        while (true) {
                                                            zzv zzvVar7 = this.zzw;
                                                            if (zzvVar7 == null) {
                                                                throw th;
                                                            }
                                                            if (i6 >= zzvVar7.zzr.size()) {
                                                                this.zzV = 2;
                                                                break;
                                                            }
                                                            byte[] bArr = (byte[]) this.zzw.zzr.get(i6);
                                                            ByteBuffer byteBuffer4 = this.zzg.zzc;
                                                            if (byteBuffer4 == null) {
                                                                throw th;
                                                            }
                                                            byteBuffer4.put(bArr);
                                                            i6++;
                                                        }
                                                    }
                                                    zzhh zzhhVar3 = this.zzg;
                                                    ByteBuffer byteBuffer5 = zzhhVar3.zzc;
                                                    if (byteBuffer5 == null) {
                                                        throw th;
                                                    }
                                                    int iPosition = byteBuffer5.position();
                                                    zzkj zzkjVarZzH2 = zzH();
                                                    try {
                                                        int iZzO2 = zzO(zzkjVarZzH2, zzhhVar3, 0);
                                                        if (iZzO2 == -3) {
                                                            if (!zzdb()) {
                                                                break;
                                                            }
                                                            zzbn().zzf = this.zzab;
                                                            break;
                                                        }
                                                        if (iZzO2 == -5) {
                                                            if (this.zzV == 2) {
                                                                this.zzg.zza();
                                                                this.zzV = 1;
                                                            }
                                                            zzam(zzkjVarZzH2);
                                                        } else {
                                                            zzhh zzhhVar4 = this.zzg;
                                                            if (zzhhVar4.zzb()) {
                                                                zzbn().zzf = this.zzab;
                                                                if (this.zzV == 2) {
                                                                    zzhhVar4.zza();
                                                                    this.zzV = 1;
                                                                }
                                                                this.zzac = true;
                                                                if (!this.zzY) {
                                                                    zzbl();
                                                                    break;
                                                                } else {
                                                                    if (!this.zzI) {
                                                                        this.zzZ = true;
                                                                        zzsvVar3.zza(this.zzM, 0, 0, 0L, 4);
                                                                        zzbg();
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                            }
                                                            if (!this.zzY && !zzhhVar4.zzc()) {
                                                                zzhhVar4.zza();
                                                                if (this.zzV == 2) {
                                                                    this.zzV = 1;
                                                                }
                                                            } else if (!zzaT(zzhhVar4)) {
                                                                boolean zZzk = zzhhVar4.zzk();
                                                                if (zZzk) {
                                                                    zzhhVar4.zzb.zzc(iPosition);
                                                                }
                                                                long j10 = zzhhVar4.zze;
                                                                if (this.zzae) {
                                                                    zzel zzelVar = zzbn().zze;
                                                                    zzv zzvVar8 = this.zzm;
                                                                    if (zzvVar8 == null) {
                                                                        throw th;
                                                                    }
                                                                    zzelVar.zza(j10, zzvVar8);
                                                                    this.zzae = false;
                                                                }
                                                                this.zzab = Math.max(this.zzab, j10);
                                                                if (zzdb() || zzhhVar4.zzd()) {
                                                                    zzbn().zzf = this.zzab;
                                                                }
                                                                zzhhVar4.zzl();
                                                                if (zzhhVar4.zze()) {
                                                                    zzas(zzhhVar4);
                                                                }
                                                                if (this.zzaj) {
                                                                    long j11 = this.zzab;
                                                                    if (j10 <= j11) {
                                                                        this.zzak += (j11 - j10) + 1;
                                                                    }
                                                                    this.zzab = j10;
                                                                    this.zzaj = false;
                                                                }
                                                                zzaR(zzhhVar4);
                                                                int iZzaS = zzaS(zzhhVar4);
                                                                long j12 = j10 + this.zzak;
                                                                if (zZzk) {
                                                                    zzsvVar3.zzb(this.zzM, 0, zzhhVar4.zzb, j12, iZzaS);
                                                                } else {
                                                                    int i7 = this.zzM;
                                                                    ByteBuffer byteBuffer6 = zzhhVar4.zzc;
                                                                    if (byteBuffer6 == null) {
                                                                        throw th;
                                                                    }
                                                                    zzsvVar3.zza(i7, 0, byteBuffer6.limit(), j12, iZzaS);
                                                                }
                                                                zzbg();
                                                                this.zzY = true;
                                                                this.zzV = 0;
                                                                this.zza.zzc++;
                                                            }
                                                        }
                                                    } catch (zzhg e6) {
                                                        zzal(e6);
                                                        zzax(0);
                                                        zzav();
                                                    }
                                                }
                                            } catch (IllegalStateException e7) {
                                                e = e7;
                                                r13 = 0;
                                                z2 = e instanceof MediaCodec.CodecException;
                                                if (!z2) {
                                                    stackTrace = e.getStackTrace();
                                                    if (stackTrace.length > 0) {
                                                    }
                                                    throw e;
                                                }
                                                zzal(e);
                                                if (z2) {
                                                    r2 = r13;
                                                } else {
                                                    r2 = r13;
                                                }
                                                if (r2 != 0) {
                                                    zzaI();
                                                }
                                                zzsxVarZzaP = zzaP(e, this.zzC);
                                                if (zzsxVarZzaP.zza == 1101) {
                                                    i = 4006;
                                                } else {
                                                    i = 4003;
                                                }
                                                throw zzN(zzsxVarZzaP, this.zzm, r2, i);
                                            }
                                        } while (zzay(j3));
                                        Trace.endSection();
                                    } else {
                                        this.zza.zzd += zzP(j);
                                        zzax(1);
                                    }
                                }
                                this.zza.zza();
                            } catch (IllegalStateException e8) {
                                e = e8;
                            }
                        } catch (IllegalStateException e9) {
                            e = e9;
                            z3 = false;
                        }
                    } catch (MediaCodec.CryptoException e10) {
                        e = e10;
                    }
                } catch (MediaCodec.CryptoException e11) {
                    e = e11;
                    throw zzN(e, this.zzm, r12, zzep.zzF(e.getErrorCode()));
                } catch (IllegalStateException e12) {
                    e = e12;
                }
            } catch (IllegalStateException e13) {
                e = e13;
                z = true;
            }
        } catch (MediaCodec.CryptoException e14) {
            e = e14;
            r12 = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public boolean zzY() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public boolean zzZ() {
        return this.zzad;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0283 A[Catch: zztb -> 0x02b1, TryCatch #3 {zztb -> 0x02b1, blocks: (B:25:0x0057, B:27:0x005e, B:29:0x0065, B:31:0x007b, B:32:0x0086, B:37:0x0093, B:39:0x009b, B:41:0x009f, B:42:0x00a2, B:44:0x00a6, B:46:0x00af, B:143:0x026a, B:145:0x0283, B:147:0x028c, B:150:0x0298, B:151:0x029a, B:146:0x0286, B:153:0x029c, B:154:0x029d, B:156:0x02a2, B:157:0x02a3, B:158:0x02ad, B:35:0x008a, B:36:0x0092, B:160:0x02b0), top: B:171:0x0057, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0286 A[Catch: zztb -> 0x02b1, TryCatch #3 {zztb -> 0x02b1, blocks: (B:25:0x0057, B:27:0x005e, B:29:0x0065, B:31:0x007b, B:32:0x0086, B:37:0x0093, B:39:0x009b, B:41:0x009f, B:42:0x00a2, B:44:0x00a6, B:46:0x00af, B:143:0x026a, B:145:0x0283, B:147:0x028c, B:150:0x0298, B:151:0x029a, B:146:0x0286, B:153:0x029c, B:154:0x029d, B:156:0x02a2, B:157:0x02a3, B:158:0x02ad, B:35:0x008a, B:36:0x0092, B:160:0x02b0), top: B:171:0x0057, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:184:0x0298 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:186:0x0292 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x010c  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [com.google.android.gms.internal.ads.zzst] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.google.android.gms.internal.ads.zzsy] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.internal.ads.zzss] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzte] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayDeque] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected final void zzaA() throws zzib {
        zzv zzvVar;
        boolean z;
        ?? Zzaf;
        zztb zztbVar;
        zztb zztbVar2;
        boolean z2;
        zzsy zzsyVar;
        if (this.zzv != null || this.zzR || (zzvVar = this.zzm) == null) {
            return;
        }
        boolean z3 = true;
        if (zzaB(zzvVar)) {
            zzao();
            String str = zzvVar.zzo;
            if ("audio/mp4a-latm".equals(str) || "audio/mpeg".equals(str) || "audio/opus".equals(str)) {
                this.zzi.zzm(32);
            } else {
                this.zzi.zzm(1);
            }
            this.zzR = true;
            return;
        }
        zzrs zzrsVar = this.zzp;
        this.zzo = zzrsVar;
        if (zzrsVar != null) {
            zzgmd.zzh(true);
            zzrs zzrsVar2 = this.zzo;
            boolean z4 = zzsb.zza;
            zzrsVar2.zza();
        }
        try {
            zzv zzvVar2 = this.zzm;
            MediaCrypto mediaCrypto = null;
            if (zzvVar2 == null) {
                throw null;
            }
            if (this.zzA == null) {
                try {
                    List listZzad = zzad(this.zzd, zzvVar2, false);
                    listZzad.isEmpty();
                    this.zzA = new ArrayDeque();
                    if (!listZzad.isEmpty()) {
                        this.zzA.add((zzsy) listZzad.get(0));
                    }
                    this.zzB = null;
                } catch (zzti e) {
                    throw new zztb(zzvVar2, (Throwable) e, false, -49998);
                }
            }
            if (this.zzA.isEmpty()) {
                throw new zztb(zzvVar2, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzA;
            if (arrayDeque == null) {
                throw null;
            }
            while (this.zzv == null) {
                zzsy zzsyVar2 = (zzsy) arrayDeque.peekFirst();
                if (zzsyVar2 == null) {
                    throw mediaCrypto;
                }
                zzaQ(zzvVar2);
                if (!zzaC(zzsyVar2)) {
                    return;
                }
                try {
                    this.zzC = zzsyVar2;
                    zzv zzvVar3 = this.zzm;
                    if (zzvVar3 == null) {
                        throw mediaCrypto;
                    }
                    String str2 = zzsyVar2.zza;
                    float fZzai = zzai(this.zzu, zzvVar3, zzI());
                    if (fZzai <= this.zze) {
                        fZzai = -1.0f;
                    }
                    long jZzb = zzL().zzb();
                    z = z3;
                    try {
                        Zzaf = zzaf(zzsyVar2, zzvVar3, mediaCrypto, fZzai);
                        if (Build.VERSION.SDK_INT >= 31) {
                            LogSessionId logSessionIdZza = zzK().zza();
                            if (!logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                                Zzaf.zzb.setString("log-session-id", logSessionIdZza.getStringId());
                            }
                        }
                        try {
                            StringBuilder sb = new StringBuilder(str2.length() + 12);
                            sb.append("createCodec:");
                            sb.append(str2);
                            Trace.beginSection(sb.toString());
                            zzsv zzsvVarZzb = this.zzc.zzb(Zzaf);
                            this.zzv = zzsvVarZzb;
                            this.zzK = zzsvVarZzb.zzl(new zztc(this, null));
                            Trace.endSection();
                            long jZzb2 = zzL().zzb();
                            if (!zzsyVar2.zzc(zzvVar3)) {
                                Object[] objArr = {zzv.zze(zzvVar3), str2};
                                String str3 = zzep.zza;
                                zzdt.zzc("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr));
                            }
                            this.zzz = fZzai;
                            this.zzw = zzvVar3;
                            this.zzD = (Build.VERSION.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str2) && (Build.MODEL.startsWith("SM-T585") || Build.MODEL.startsWith("SM-A510") || Build.MODEL.startsWith("SM-A520") || Build.MODEL.startsWith("SM-J700"))) ? 2 : 0;
                            this.zzE = (Build.VERSION.SDK_INT == 29 && "c2.android.aac.decoder".equals(str2)) ? z : false;
                            this.zzF = false;
                            String str4 = zzsyVar2.zza;
                            if (Build.VERSION.SDK_INT <= 25 && "OMX.rk.video_decoder.avc".equals(str4)) {
                                z2 = z;
                            } else if ((Build.VERSION.SDK_INT > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str4) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str4) || "OMX.bcm.vdec.avc.tunnel".equals(str4) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str4) || "OMX.bcm.vdec.hevc.tunnel".equals(str4) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str4))) && !("Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && zzsyVar2.zzf)) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            this.zzI = z2;
                            zzsv zzsvVar = this.zzv;
                            if (zzsvVar == null) {
                                throw null;
                            }
                            if (zze() == 2) {
                                try {
                                    zzsyVar = zzsyVar2;
                                    try {
                                        this.zzL = zzL().zzb() + 1000;
                                    } catch (Exception e2) {
                                        e = e2;
                                        Zzaf = zzsyVar;
                                        zzdt.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(Zzaf.zza), e);
                                        arrayDeque.removeFirst();
                                        zztbVar = new zztb(zzvVar2, (Throwable) e, false, (zzsy) Zzaf);
                                        zzal(zztbVar);
                                        zztbVar2 = this.zzB;
                                        if (zztbVar2 == null) {
                                            this.zzB = zztbVar;
                                        } else {
                                            this.zzB = zztbVar2.zza(zztbVar);
                                        }
                                        if (!arrayDeque.isEmpty()) {
                                            throw this.zzB;
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    zzsyVar = zzsyVar2;
                                }
                            } else {
                                zzsyVar = zzsyVar2;
                            }
                            this.zza.zza++;
                            Zzaf = zzsyVar;
                            try {
                                zzaj(str2, Zzaf, jZzb2, jZzb2 - jZzb);
                            } catch (Exception e4) {
                                e = e4;
                            }
                            z3 = z;
                            mediaCrypto = null;
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        Zzaf = zzsyVar2;
                    }
                } catch (Exception e6) {
                    e = e6;
                    z = z3;
                }
                Zzaf = zzsyVar2;
                zzdt.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(Zzaf.zza), e);
                arrayDeque.removeFirst();
                zztbVar = new zztb(zzvVar2, (Throwable) e, false, (zzsy) Zzaf);
                zzal(zztbVar);
                zztbVar2 = this.zzB;
                if (zztbVar2 == null) {
                    this.zzB = zztbVar;
                } else {
                    this.zzB = zztbVar2.zza(zztbVar);
                }
                if (!arrayDeque.isEmpty()) {
                    throw this.zzB;
                }
                z3 = z;
                mediaCrypto = null;
            }
            this.zzA = mediaCrypto;
        } catch (zztb e7) {
            throw zzN(e7, zzvVar, false, 4001);
        }
    }

    protected final boolean zzaB(zzv zzvVar) {
        return this.zzp == null && zzae(zzvVar);
    }

    protected boolean zzaC(zzsy zzsyVar) {
        return true;
    }

    protected final boolean zzaD() {
        return this.zzR;
    }

    protected final zzsv zzaE() {
        return this.zzv;
    }

    protected final zzv zzaF() {
        return this.zzw;
    }

    protected final MediaFormat zzaG() {
        return this.zzx;
    }

    protected final zzsy zzaH() {
        return this.zzC;
    }

    protected final void zzaI() {
        try {
            zzsv zzsvVar = this.zzv;
            if (zzsvVar != null) {
                zzsvVar.zzk();
                this.zza.zzb++;
                zzsy zzsyVar = this.zzC;
                if (zzsyVar == null) {
                    throw null;
                }
                zzak(zzsyVar.zza);
            }
            this.zzv = null;
            this.zzr = null;
            this.zzo = null;
            zzaO();
        } catch (Throwable th) {
            this.zzv = null;
            this.zzr = null;
            this.zzo = null;
            zzaO();
            throw th;
        }
    }

    protected final boolean zzaJ() throws zzib {
        boolean zZzau = zzau();
        if (zZzau) {
            zzaA();
        }
        return zZzau;
    }

    protected boolean zzaK() {
        int i = this.zzX;
        if (i == 3 || ((this.zzE && !this.zzaa) || (this.zzF && this.zzZ))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            zzbo();
            return false;
        } catch (zzib e) {
            zzdt.zzd("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    protected boolean zzaL() {
        return true;
    }

    protected final long zzaM() {
        return this.zzak;
    }

    protected void zzaN() {
        zzbg();
        zzbh();
        zzaw();
        this.zzL = -9223372036854775807L;
        this.zzZ = false;
        this.zzJ = -9223372036854775807L;
        this.zzY = false;
        this.zzG = false;
        this.zzH = false;
        this.zzP = false;
        this.zzQ = false;
        this.zzW = 0;
        this.zzX = 0;
        this.zzV = this.zzU ? 1 : 0;
        this.zzaj = false;
        this.zzak = 0L;
    }

    protected final void zzaO() {
        zzaN();
        this.zzA = null;
        this.zzC = null;
        this.zzw = null;
        this.zzx = null;
        this.zzy = false;
        this.zzaa = false;
        this.zzz = -1.0f;
        this.zzD = 0;
        this.zzE = false;
        this.zzF = false;
        this.zzI = false;
        this.zzK = false;
        this.zzU = false;
        this.zzV = 0;
    }

    protected zzsx zzaP(Throwable th, zzsy zzsyVar) {
        return new zzsx(th, zzsyVar);
    }

    protected boolean zzaQ(zzv zzvVar) throws zzib {
        return true;
    }

    protected void zzaR(zzhh zzhhVar) throws zzib {
    }

    protected int zzaS(zzhh zzhhVar) {
        return 0;
    }

    protected boolean zzaT(zzhh zzhhVar) {
        return false;
    }

    protected final long zzaU() {
        return this.zzag;
    }

    protected void zzaV(long j) {
        this.zzag = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || j < ((zztd) arrayDeque.peek()).zzb) {
                return;
            }
            zztd zztdVar = (zztd) arrayDeque.poll();
            zztdVar.getClass();
            zzbm(zztdVar);
            zzap();
        }
    }

    protected final boolean zzaW() {
        if (this.zzm == null) {
            return false;
        }
        if (zzQ() || zzbf()) {
            return true;
        }
        return this.zzL != -9223372036854775807L && zzL().zzb() < this.zzL;
    }

    protected final float zzaX() {
        return this.zzt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzlm zzaY() {
        return this.zzq;
    }

    protected final boolean zzaZ() throws zzib {
        return zzbi(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final int zzab(zzv zzvVar) throws zzib {
        try {
            return zzac(this.zzd, zzvVar);
        } catch (zzti e) {
            throw zzN(e, zzvVar, false, 4002);
        }
    }

    protected abstract int zzac(zztg zztgVar, zzv zzvVar) throws zzti;

    protected abstract List zzad(zztg zztgVar, zzv zzvVar, boolean z) throws zzti;

    protected boolean zzae(zzv zzvVar) {
        return false;
    }

    protected abstract zzss zzaf(zzsy zzsyVar, zzv zzvVar, MediaCrypto mediaCrypto, float f);

    protected zzht zzag(zzsy zzsyVar, zzv zzvVar, zzv zzvVar2) {
        throw null;
    }

    protected long zzah(long j, long j2, boolean z) {
        return super.zzT(j, j2);
    }

    protected float zzai(float f, zzv zzvVar, zzv[] zzvVarArr) {
        throw null;
    }

    protected void zzaj(String str, zzss zzssVar, long j, long j2) {
        throw null;
    }

    protected void zzak(String str) {
        throw null;
    }

    protected void zzal(Exception exc) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00b6  */
    protected zzht zzam(zzkj zzkjVar) throws zzib {
        int i;
        boolean z = true;
        this.zzae = true;
        zzv zzvVarZzM = zzkjVar.zzb;
        zzvVarZzM.getClass();
        String str = zzvVarZzM.zzo;
        if (str == null) {
            throw zzN(new IllegalArgumentException("Sample MIME type is null."), zzvVarZzM, false, 4005);
        }
        if ((Objects.equals(str, "video/av01") || Objects.equals(str, "video/x-vnd.on2.vp9")) && !zzvVarZzM.zzr.isEmpty()) {
            zzt zztVarZza = zzvVarZzM.zza();
            zztVarZza.zzp(null);
            zzvVarZzM = zztVarZza.zzM();
        }
        zzv zzvVar = zzvVarZzM;
        this.zzp = zzkjVar.zza;
        this.zzm = zzvVar;
        if (this.zzR) {
            this.zzT = true;
            return null;
        }
        zzsv zzsvVar = this.zzv;
        if (zzsvVar == null) {
            this.zzA = null;
            zzaA();
            return null;
        }
        zzsy zzsyVar = this.zzC;
        zzsyVar.getClass();
        zzv zzvVar2 = this.zzw;
        zzvVar2.getClass();
        zzrs zzrsVar = this.zzo;
        zzrs zzrsVar2 = this.zzp;
        if (zzrsVar != zzrsVar2) {
            zzbk();
            return new zzht(zzsyVar.zza, zzvVar2, zzvVar, 0, 128);
        }
        zzht zzhtVarZzag = zzag(zzsyVar, zzvVar2, zzvVar);
        int i2 = zzhtVarZzag.zzd;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (zzbi(zzvVar)) {
                        this.zzw = zzvVar;
                        if (zzrsVar2 == zzrsVar || zzbj()) {
                        }
                    } else {
                        i = 16;
                    }
                } else if (zzbi(zzvVar)) {
                    this.zzU = true;
                    this.zzV = 1;
                    int i3 = this.zzD;
                    if (i3 != 2 && (i3 != 1 || zzvVar.zzv != zzvVar2.zzv || zzvVar.zzw != zzvVar2.zzw)) {
                        z = false;
                    }
                    this.zzG = z;
                    this.zzw = zzvVar;
                    if (zzrsVar2 == zzrsVar || zzbj()) {
                    }
                } else {
                    i = 16;
                }
            } else if (zzbi(zzvVar)) {
                this.zzw = zzvVar;
                if (zzrsVar2 != zzrsVar) {
                    if (zzbj()) {
                    }
                } else if (this.zzY) {
                    this.zzW = 1;
                    if (this.zzF) {
                        this.zzX = 3;
                    } else {
                        this.zzX = 1;
                    }
                }
            } else {
                i = 16;
            }
            return (i2 != 0 || (this.zzv == zzsvVar && this.zzX != 3)) ? zzhtVarZzag : new zzht(zzsyVar.zza, zzvVar2, zzvVar, 0, i);
        }
        zzbk();
        i = 0;
        if (i2 != 0) {
        }
    }

    protected void zzan(zzv zzvVar, MediaFormat mediaFormat) throws zzib {
        throw null;
    }

    protected void zzap() {
    }

    protected abstract boolean zzaq(long j, long j2, zzsv zzsvVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) throws zzib;

    protected void zzar() throws zzib {
        throw null;
    }

    protected void zzas(zzhh zzhhVar) throws zzib {
        throw null;
    }

    public final void zzaz() {
        this.zzai = true;
    }

    protected final long zzba() {
        return this.zzaf.zzf;
    }

    protected final long zzbb() {
        return this.zzaf.zzd;
    }

    protected final long zzbc() {
        return this.zzaf.zzc;
    }

    final /* synthetic */ zzlm zzbe() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzlp
    public final int zzu() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzli
    public void zzx(int i, Object obj) throws zzib {
        if (i == 11) {
            zzlm zzlmVar = (zzlm) obj;
            zzlmVar.getClass();
            this.zzq = zzlmVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected void zzy(boolean z, boolean z2) throws zzib {
        this.zza = new zzhs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzhr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void zzz(com.google.android.gms.internal.ads.zzv[] r12, long r13, long r15, com.google.android.gms.internal.ads.zzuu r17) throws com.google.android.gms.internal.ads.zzib {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zztd r12 = r11.zzaf
            long r0 = r12.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            com.google.android.gms.internal.ads.zztd r4 = new com.google.android.gms.internal.ads.zztd
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbm(r4)
            boolean r12 = r11.zzai
            if (r12 == 0) goto L56
            r11.zzap()
            return
        L24:
            java.util.ArrayDeque r12 = r11.zzk
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.zzab
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.zzag
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            com.google.android.gms.internal.ads.zztd r4 = new com.google.android.gms.internal.ads.zztd
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbm(r4)
            com.google.android.gms.internal.ads.zztd r12 = r11.zzaf
            long r12 = r12.zzd
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.zzap()
        L56:
            return
        L57:
            com.google.android.gms.internal.ads.zztd r0 = new com.google.android.gms.internal.ads.zztd
            long r1 = r11.zzab
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzte.zzz(com.google.android.gms.internal.ads.zzv[], long, long, com.google.android.gms.internal.ads.zzuu):void");
    }

    private final void zzbo() throws zzib {
        zzrs zzrsVar = this.zzp;
        zzrsVar.getClass();
        this.zzo = zzrsVar;
        this.zzW = 0;
        this.zzX = 0;
    }

    private final void zzbl() throws zzib {
        int i = this.zzX;
        if (i == 1) {
            zzav();
            return;
        }
        if (i == 2) {
            zzav();
            zzbo();
        } else if (i != 3) {
            this.zzad = true;
            zzar();
        } else {
            zzaI();
            zzaA();
        }
    }
}
