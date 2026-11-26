package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.work.WorkRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzvy implements zzus, zzadd, zzzf, zzzk, zzwi {
    private static final Map zzb;
    private static final zzv zzc;
    private zzvx zzA;
    private zzaed zzB;
    private long zzC;
    private boolean zzD;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private int zzI;
    private boolean zzJ;
    private long zzK;
    private boolean zzM;
    private int zzN;
    private boolean zzO;
    private boolean zzP;
    private final Uri zzd;
    private final zzgb zze;
    private final zzrz zzf;
    private final zzve zzg;
    private final zzru zzh;
    private final zzvq zzi;
    private final zzyv zzj;
    private final long zzk;
    private final long zzl;
    private final zzvn zzn;
    private zzur zzs;
    private zzagf zzt;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;
    private final zzzn zzm = new zzzn("ProgressiveMediaPeriod");
    private final zzdf zzo = new zzdf(zzdc.zza);
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvu
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzD();
        }
    };
    private final Runnable zzq = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvr
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzE();
        }
    };
    private final Handler zzr = zzep.zzc(null);
    private zzvw[] zzv = new zzvw[0];
    private zzwj[] zzu = new zzwj[0];
    private long zzL = -9223372036854775807L;
    private int zzE = 1;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzt zztVar = new zzt();
        zztVar.zza("icy");
        zztVar.zzm("application/x-icy");
        zzc = zztVar.zzM();
    }

    public zzvy(Uri uri, zzgb zzgbVar, zzvn zzvnVar, zzrz zzrzVar, zzru zzruVar, zzze zzzeVar, zzve zzveVar, zzvq zzvqVar, zzyv zzyvVar, String str, int i, int i2, zzv zzvVar, long j, zzzt zzztVar) {
        this.zzd = uri;
        this.zze = zzgbVar;
        this.zzf = zzrzVar;
        this.zzh = zzruVar;
        this.zzg = zzveVar;
        this.zzi = zzvqVar;
        this.zzj = zzyvVar;
        this.zzk = i;
        this.zzn = zzvnVar;
        this.zzl = j;
    }

    private final void zzR(int i) {
        zzaa();
        zzvx zzvxVar = this.zzA;
        boolean[] zArr = zzvxVar.zzd;
        if (zArr[i]) {
            return;
        }
        zzv zzvVarZza = zzvxVar.zza.zza(i).zza(0);
        this.zzg.zzh(new zzuq(1, zzas.zzg(zzvVarZza.zzo), zzvVarZza, 0, null, zzep.zzp(this.zzK), -9223372036854775807L));
        zArr[i] = true;
    }

    private final void zzS(int i) {
        zzaa();
        if (this.zzM) {
            if ((!this.zzy || this.zzA.zzb[i]) && !this.zzu[i].zzl(false)) {
                this.zzL = 0L;
                this.zzM = false;
                this.zzG = true;
                this.zzK = 0L;
                this.zzN = 0;
                for (zzwj zzwjVar : this.zzu) {
                    zzwjVar.zzb(false);
                }
                zzur zzurVar = this.zzs;
                zzurVar.getClass();
                zzurVar.zzs(this);
            }
        }
    }

    private final boolean zzT() {
        return this.zzG || zzZ();
    }

    private final zzaem zzU(zzvw zzvwVar) {
        int length = this.zzu.length;
        for (int i = 0; i < length; i++) {
            if (zzvwVar.equals(this.zzv[i])) {
                return this.zzu[i];
            }
        }
        if (this.zzw) {
            int i2 = zzvwVar.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 55);
            sb.append("Extractor added new track (id=");
            sb.append(i2);
            sb.append(") after finishing tracks.");
            zzdt.zzc("ProgressiveMediaPeriod", sb.toString());
            return new zzacx();
        }
        zzwj zzwjVar = new zzwj(this.zzj, this.zzf, this.zzh);
        zzwjVar.zzt(this);
        int i3 = length + 1;
        zzvw[] zzvwVarArr = (zzvw[]) Arrays.copyOf(this.zzv, i3);
        zzvwVarArr[length] = zzvwVar;
        String str = zzep.zza;
        this.zzv = zzvwVarArr;
        zzwj[] zzwjVarArr = (zzwj[]) Arrays.copyOf(this.zzu, i3);
        zzwjVarArr[length] = zzwjVar;
        this.zzu = zzwjVarArr;
        return zzwjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public final void zzD() {
        int i;
        if (this.zzP || this.zzx || !this.zzw || this.zzB == null) {
            return;
        }
        for (zzwj zzwjVar : this.zzu) {
            if (zzwjVar.zzi() == null) {
                return;
            }
        }
        this.zzo.zzb();
        int length = this.zzu.length;
        zzbg[] zzbgVarArr = new zzbg[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzv zzvVarZzi = this.zzu[i2].zzi();
            zzvVarZzi.getClass();
            String str = zzvVarZzi.zzo;
            boolean zZza = zzas.zza(str);
            boolean z = zZza || zzas.zzb(str);
            zArr[i2] = z;
            this.zzy = z | this.zzy;
            this.zzz = this.zzl != -9223372036854775807L && length == 1 && zzas.zzc(str);
            zzagf zzagfVar = this.zzt;
            if (zzagfVar != null) {
                if (zZza || this.zzv[i2].zzb) {
                    zzap zzapVar = zzvVarZzi.zzl;
                    zzap zzapVar2 = zzapVar == null ? new zzap(-9223372036854775807L, zzagfVar) : zzapVar.zzg(zzagfVar);
                    zzt zztVarZza = zzvVarZzi.zza();
                    zztVarZza.zzk(zzapVar2);
                    zzvVarZzi = zztVarZza.zzM();
                }
                if (zZza && zzvVarZzi.zzh == -1 && zzvVarZzi.zzi == -1 && (i = zzagfVar.zza) != -1) {
                    zzt zztVarZza2 = zzvVarZzi.zza();
                    zztVarZza2.zzh(i);
                    zzvVarZzi = zztVarZza2.zzM();
                }
            }
            zzv zzvVarZzb = zzvVarZzi.zzb(this.zzf.zzb(zzvVarZzi));
            zzbgVarArr[i2] = new zzbg(Integer.toString(i2), zzvVarZzb);
            this.zzH = zzvVarZzb.zzu | this.zzH;
        }
        this.zzA = new zzvx(new zzwv(zzbgVarArr), zArr);
        if (this.zzz && this.zzC == -9223372036854775807L) {
            this.zzC = this.zzl;
            this.zzB = new zzvo(this, this.zzB);
        }
        this.zzi.zzb(this.zzC, this.zzB, this.zzD);
        this.zzx = true;
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzp(this);
    }

    private final void zzW() {
        zzvp zzvpVar = new zzvp(this, this.zzd, this.zze, this.zzn, this, this.zzo);
        if (this.zzx) {
            zzgmd.zzh(zzZ());
            long j = this.zzC;
            if (j != -9223372036854775807L && this.zzL > j) {
                this.zzO = true;
                this.zzL = -9223372036854775807L;
                return;
            }
            zzaed zzaedVar = this.zzB;
            zzaedVar.getClass();
            zzvpVar.zzd(zzaedVar.zzc(this.zzL).zza.zzc, this.zzL);
            for (zzwj zzwjVar : this.zzu) {
                zzwjVar.zzc(this.zzL);
            }
            this.zzL = -9223372036854775807L;
        }
        this.zzN = zzX();
        this.zzm.zzd(zzvpVar, this, zzze.zza(this.zzE));
    }

    private final int zzX() {
        int iZzd = 0;
        for (zzwj zzwjVar : this.zzu) {
            iZzd += zzwjVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    private final long zzY(boolean z) {
        int i = 0;
        long jMax = Long.MIN_VALUE;
        while (true) {
            zzwj[] zzwjVarArr = this.zzu;
            if (i >= zzwjVarArr.length) {
                return jMax;
            }
            if (z) {
                jMax = Math.max(jMax, zzwjVarArr[i].zzj());
            } else {
                zzvx zzvxVar = this.zzA;
                zzvxVar.getClass();
                if (zzvxVar.zzc[i]) {
                    jMax = Math.max(jMax, zzwjVarArr[i].zzj());
                }
            }
            i++;
        }
    }

    private final boolean zzZ() {
        return this.zzL != -9223372036854775807L;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzaa() {
        zzgmd.zzh(this.zzx);
        this.zzA.getClass();
        this.zzB.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzA(zzzj zzzjVar, long j, long j2, boolean z) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf());
        zzvpVar.zze();
        this.zzg.zzf(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)));
        if (z) {
            return;
        }
        for (zzwj zzwjVar : this.zzu) {
            zzwjVar.zzb(false);
        }
        if (this.zzI > 0) {
            zzur zzurVar = this.zzs;
            zzurVar.getClass();
            zzurVar.zzs(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzB(zzzj zzzjVar, long j, long j2) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        if (this.zzC == -9223372036854775807L && this.zzB != null) {
            long jZzY = zzY(true);
            long j3 = jZzY == Long.MIN_VALUE ? 0L : jZzY + WorkRequest.MIN_BACKOFF_MILLIS;
            this.zzC = j3;
            this.zzi.zzb(j3, this.zzB, this.zzD);
        }
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf());
        zzvpVar.zze();
        this.zzg.zze(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)));
        this.zzO = true;
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzC(zzzj zzzjVar, long j, long j2, int i) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        this.zzg.zzd(i == 0 ? new zzul(zzvpVar.zze(), zzvpVar.zzh(), j) : new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf()), new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)), i);
    }

    final /* synthetic */ void zzG() {
        this.zzJ = true;
    }

    final /* synthetic */ void zzH() {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    final /* synthetic */ long zzI(boolean z) {
        return zzY(true);
    }

    final /* synthetic */ long zzL() {
        return this.zzk;
    }

    final /* synthetic */ Runnable zzM() {
        return this.zzq;
    }

    final /* synthetic */ Handler zzN() {
        return this.zzr;
    }

    final /* synthetic */ zzagf zzO() {
        return this.zzt;
    }

    final /* synthetic */ void zzP(zzagf zzagfVar) {
        this.zzt = zzagfVar;
    }

    final /* synthetic */ long zzQ() {
        return this.zzC;
    }

    public final void zza() {
        if (this.zzx) {
            for (zzwj zzwjVar : this.zzu) {
                zzwjVar.zze();
            }
        }
        this.zzm.zzg(this);
        this.zzr.removeCallbacksAndMessages(null);
        this.zzs = null;
        this.zzP = true;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzs = zzurVar;
        this.zzo.zza();
        zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        zzr();
        if (this.zzO && !this.zzx) {
            throw zzat.zzb("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        zzaa();
        return this.zzA.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        zzyk zzykVar;
        zzaa();
        zzvx zzvxVar = this.zzA;
        zzwv zzwvVar = zzvxVar.zza;
        boolean[] zArr3 = zzvxVar.zzc;
        int i = this.zzI;
        int i2 = 0;
        for (int i3 = 0; i3 < zzykVarArr.length; i3++) {
            zzwk zzwkVar = zzwkVarArr[i3];
            if (zzwkVar != null && (zzykVarArr[i3] == null || !zArr[i3])) {
                int iZza = ((zzvv) zzwkVar).zza();
                zzgmd.zzh(zArr3[iZza]);
                this.zzI--;
                zArr3[iZza] = false;
                zzwkVarArr[i3] = null;
            }
        }
        boolean z = !this.zzF ? j == 0 || this.zzz : i != 0;
        for (int i4 = 0; i4 < zzykVarArr.length; i4++) {
            if (zzwkVarArr[i4] == null && (zzykVar = zzykVarArr[i4]) != null) {
                zzgmd.zzh(zzykVar.zze() == 1);
                zzgmd.zzh(zzykVar.zzf(0) == 0);
                int iZzb = zzwvVar.zzb(zzykVar.zza());
                zzgmd.zzh(!zArr3[iZzb]);
                this.zzI++;
                zArr3[iZzb] = true;
                this.zzH = zzykVar.zzc().zzu | this.zzH;
                zzwkVarArr[i4] = new zzvv(this, iZzb);
                zArr2[i4] = true;
                if (!z) {
                    zzwj zzwjVar = this.zzu[iZzb];
                    z = (zzwjVar.zzh() == 0 || zzwjVar.zzo(j, true)) ? false : true;
                }
            }
        }
        if (this.zzI == 0) {
            this.zzM = false;
            this.zzG = false;
            this.zzH = false;
            zzzn zzznVar = this.zzm;
            if (zzznVar.zze()) {
                zzwj[] zzwjVarArr = this.zzu;
                int length = zzwjVarArr.length;
                while (i2 < length) {
                    zzwjVarArr[i2].zzs();
                    i2++;
                }
                zzznVar.zzf();
            } else {
                this.zzO = false;
                for (zzwj zzwjVar2 : this.zzu) {
                    zzwjVar2.zzb(false);
                }
            }
        } else if (z) {
            j = zzj(j);
            while (i2 < zzwkVarArr.length) {
                if (zzwkVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzF = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z) {
        if (this.zzz) {
            return;
        }
        zzaa();
        if (zzZ()) {
            return;
        }
        boolean[] zArr = this.zzA.zzc;
        int length = this.zzu.length;
        for (int i = 0; i < length; i++) {
            this.zzu[i].zzr(j, false, zArr[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        if (this.zzH) {
            this.zzH = false;
        } else {
            if (!this.zzG) {
                return -9223372036854775807L;
            }
            if (!this.zzO && zzX() <= this.zzN) {
                return -9223372036854775807L;
            }
            this.zzG = false;
        }
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        long jZzY;
        zzaa();
        if (this.zzO || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (zzZ()) {
            return this.zzL;
        }
        if (this.zzy) {
            int length = this.zzu.length;
            jZzY = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzvx zzvxVar = this.zzA;
                if (zzvxVar.zzb[i] && zzvxVar.zzc[i] && !this.zzu[i].zzk()) {
                    jZzY = Math.min(jZzY, this.zzu[i].zzj());
                }
            }
        } else {
            jZzY = Long.MAX_VALUE;
        }
        if (jZzY == Long.MAX_VALUE) {
            jZzY = zzY(false);
        }
        return jZzY == Long.MIN_VALUE ? this.zzK : jZzY;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:37:0x007e A[LOOP:1: B:36:0x007c->B:37:0x007e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:40:0x008a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0093 A[LOOP:2: B:41:0x0091->B:42:0x0093, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:35:0x0079, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x008a, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        zzzn zzznVar;
        int i;
        zzaa();
        boolean[] zArr = this.zzA.zzb;
        if (true != this.zzB.zzb()) {
            j = 0;
        }
        this.zzG = false;
        long j2 = this.zzK;
        this.zzK = j;
        if (zzZ()) {
            this.zzL = j;
            return j;
        }
        if (this.zzE == 7 || !(this.zzO || this.zzm.zze())) {
            this.zzM = false;
            this.zzL = j;
            this.zzO = false;
            this.zzH = false;
            zzznVar = this.zzm;
            if (zzznVar.zze()) {
                zzznVar.zzc();
                for (zzwj zzwjVar : this.zzu) {
                    zzwjVar.zzb(false);
                }
                break;
            }
            for (zzwj zzwjVar2 : this.zzu) {
                zzwjVar2.zzs();
            }
            zzznVar.zzf();
            return j;
        }
        int length = this.zzu.length;
        for (int i2 = 0; i2 < length; i2++) {
            zzwj zzwjVar3 = this.zzu[i2];
            if (zzwjVar3.zzh() != 0 || j2 != j) {
                if (!(this.zzz ? zzwjVar3.zzn(zzwjVar3.zzg()) : zzwjVar3.zzo(j, this.zzO)) && (zArr[i2] || !this.zzy)) {
                    this.zzM = false;
                    this.zzL = j;
                    this.zzO = false;
                    this.zzH = false;
                    zzznVar = this.zzm;
                    if (zzznVar.zze()) {
                        zzznVar.zzc();
                        while (i < r2) {
                            zzwjVar.zzb(false);
                        }
                        break;
                        break;
                    }
                    while (i < r3) {
                        zzwjVar2.zzs();
                    }
                    zzznVar.zzf();
                    return j;
                }
            }
        }
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x00da A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:78:0x00db A[RETURN] */
    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        long j2;
        boolean z;
        long j3;
        boolean z2;
        zzaa();
        if (!this.zzB.zzb()) {
            return 0L;
        }
        zzaeb zzaebVarZzc = this.zzB.zzc(j);
        zzaee zzaeeVar = zzaebVarZzc.zza;
        zzaee zzaeeVar2 = zzaebVarZzc.zzb;
        long j4 = zzlvVar.zzd;
        if (j4 == 0) {
            if (zzlvVar.zze == 0) {
                return j;
            }
            j4 = 0;
        }
        String str = zzep.zza;
        long j5 = j - j4;
        long j6 = Long.MAX_VALUE;
        long j7 = (((j4 ^ j) > 0L ? 1 : ((j4 ^ j) == 0L ? 0 : -1)) >= 0) | (((j ^ j5) > 0L ? 1 : ((j ^ j5) == 0L ? 0 : -1)) >= 0) ? j5 : ((j5 >>> 63) ^ 1) + Long.MAX_VALUE;
        long j8 = Long.MIN_VALUE;
        if (j7 != Long.MIN_VALUE) {
            if (j7 == Long.MAX_VALUE) {
                if (j5 != Long.MAX_VALUE) {
                    j7 = Long.MIN_VALUE;
                } else {
                    j7 = Long.MAX_VALUE;
                }
            }
        } else if (j5 == Long.MIN_VALUE) {
            j5 = Long.MIN_VALUE;
            if (j7 == Long.MAX_VALUE) {
                if (j5 != Long.MAX_VALUE) {
                    j7 = Long.MIN_VALUE;
                } else {
                    j7 = Long.MAX_VALUE;
                }
            }
        } else {
            j7 = Long.MIN_VALUE;
        }
        long j9 = zzlvVar.zze;
        long j10 = j + j9;
        long j11 = (((j ^ j10) > 0L ? 1 : ((j ^ j10) == 0L ? 0 : -1)) >= 0) | (((j9 ^ j) > 0L ? 1 : ((j9 ^ j) == 0L ? 0 : -1)) < 0) ? j10 : ((j10 >>> 63) ^ 1) + Long.MAX_VALUE;
        if (j11 == Long.MIN_VALUE) {
            if (j10 == Long.MIN_VALUE) {
            }
            j2 = zzaeeVar.zzb;
            if (j7 <= j2 || j2 > j6) {
                z = false;
            } else {
                z = true;
            }
            j3 = zzaeeVar2.zzb;
            z2 = j7 > j3 && j3 <= j6;
            if (!z && z2) {
                if (Math.abs(j2 - j) <= Math.abs(j3 - j)) {
                    return j2;
                }
                return j3;
            }
            if (!z) {
                if (z2) {
                    return j3;
                }
                return j7;
            }
            return j2;
        }
        j8 = j10;
        if (j11 == Long.MAX_VALUE) {
            int i = (j8 > Long.MAX_VALUE ? 1 : (j8 == Long.MAX_VALUE ? 0 : -1));
        } else {
            j6 = j11;
        }
        j2 = zzaeeVar.zzb;
        if (j7 <= j2) {
            z = false;
        } else {
            z = false;
        }
        j3 = zzaeeVar2.zzb;
        if (j7 > j3) {
        }
        if (!z) {
        }
        if (!z) {
            if (z2) {
                return j3;
            }
            return j7;
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        if (this.zzO) {
            return false;
        }
        zzzn zzznVar = this.zzm;
        if (zzznVar.zzb() || this.zzM) {
            return false;
        }
        if (this.zzx && this.zzI == 0) {
            return false;
        }
        boolean zZza = this.zzo.zza();
        if (zzznVar.zze()) {
            return zZza;
        }
        zzW();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zzm.zze() && this.zzo.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzo() {
        for (zzwj zzwjVar : this.zzu) {
            zzwjVar.zza();
        }
        this.zzn.zzb();
    }

    final boolean zzp(int i) {
        return !zzT() && this.zzu[i].zzl(this.zzO);
    }

    final void zzq(int i) throws IOException {
        this.zzu[i].zzf();
        zzr();
    }

    final void zzr() throws IOException {
        this.zzm.zzh(zzze.zza(this.zzE));
    }

    final int zzs(int i, zzkj zzkjVar, zzhh zzhhVar, int i2) {
        if (zzT()) {
            return -3;
        }
        zzR(i);
        int iZzm = this.zzu[i].zzm(zzkjVar, zzhhVar, i2, this.zzO);
        if (iZzm == -3) {
            zzS(i);
        }
        return iZzm;
    }

    final int zzt(int i, long j) {
        if (zzT()) {
            return 0;
        }
        zzR(i);
        zzwj zzwjVar = this.zzu[i];
        int iZzp = zzwjVar.zzp(j, this.zzO);
        zzwjVar.zzq(iZzp);
        if (iZzp != 0) {
            return iZzp;
        }
        zzS(i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i, int i2) {
        return zzU(new zzvw(i, false));
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzw = true;
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(final zzaed zzaedVar) {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzF(zzaedVar);
            }
        });
    }

    final zzaem zzx() {
        return zzU(new zzvw(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void zzy(zzv zzvVar) {
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ zzzh zzz(zzzj zzzjVar, long j, long j2, IOException iOException, int i) {
        long jMin;
        zzzh zzzhVarZza;
        zzaed zzaedVar;
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf());
        zzvpVar.zzg();
        String str = zzep.zza;
        if ((iOException instanceof zzat) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgp) || (iOException instanceof zzzm)) {
            jMin = -9223372036854775807L;
            break;
        }
        Throwable cause = iOException;
        while (true) {
            if (cause == null) {
                jMin = Math.min((i - 1) * 1000, 5000);
                break;
            }
            if ((cause instanceof zzgc) && ((zzgc) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
            cause = cause.getCause();
        }
        if (jMin == -9223372036854775807L) {
            zzzhVarZza = zzzn.zzb;
        } else {
            int iZzX = zzX();
            boolean z = iZzX > this.zzN;
            if (this.zzJ || !((zzaedVar = this.zzB) == null || zzaedVar.zza() == -9223372036854775807L)) {
                this.zzN = iZzX;
            } else {
                boolean z2 = this.zzx;
                if (!z2 || zzT()) {
                    this.zzG = z2;
                    this.zzK = 0L;
                    this.zzN = 0;
                    for (zzwj zzwjVar : this.zzu) {
                        zzwjVar.zzb(false);
                    }
                    zzvpVar.zzd(0L, 0L);
                } else {
                    this.zzM = true;
                    zzzhVarZza = zzzn.zza;
                }
            }
            zzzhVarZza = zzzn.zza(z, jMin);
        }
        boolean zZza = zzzhVarZza.zza();
        this.zzg.zzg(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)), iOException, !zZza);
        if (!zZza) {
            zzvpVar.zze();
        }
        return zzzhVarZza;
    }

    final /* synthetic */ void zzE() {
        if (this.zzP) {
            return;
        }
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    final /* synthetic */ void zzF(zzaed zzaedVar) {
        this.zzB = this.zzt == null ? zzaedVar : new zzaec(-9223372036854775807L, 0L);
        this.zzC = zzaedVar.zza();
        boolean z = false;
        if (!this.zzJ && zzaedVar.zza() == -9223372036854775807L) {
            z = true;
        }
        this.zzD = z;
        this.zzE = true == z ? 7 : 1;
        if (this.zzx) {
            this.zzi.zzb(this.zzC, zzaedVar, z);
        } else {
            zzD();
        }
    }
}
