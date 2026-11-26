package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.core.view.PointerIconCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzju extends zzf implements zzim {
    public static final /* synthetic */ int zzd = 0;
    private final long zzA;
    private final zzdb zzB;
    private final zzme zzC;
    private int zzD;
    private int zzE;
    private boolean zzF;
    private zzlu zzG;
    private zzlv zzH;
    private zzil zzI;
    private zzax zzJ;
    private zzan zzK;
    private Object zzL;
    private Surface zzM;
    private int zzN;
    private zzeh zzO;
    private zzd zzP;
    private float zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private int zzU;
    private zzan zzV;
    private zzlf zzW;
    private int zzX;
    private long zzY;
    private zzwn zzZ;
    final zzys zzb;
    final zzax zzc;
    private final zzdf zze = new zzdf(zzdc.zza);
    private final Context zzf;
    private final zzbb zzg;
    private final zzln[] zzh;
    private final zzln[] zzi;
    private final zzyr zzj;
    private final zzdm zzk;
    private final zzkf zzl;
    private final zzkh zzm;
    private final zzds zzn;
    private final CopyOnWriteArraySet zzo;
    private final zzbd zzp;
    private final List zzq;
    private final boolean zzr;
    private final zzmi zzs;
    private final Looper zzt;
    private final zzza zzu;
    private final zzdc zzv;
    private final zzit zzw;
    private final zzjs zzx;
    private final zzmg zzy;
    private final zzmh zzz;

    static {
        zzal.zzb("media3.exoplayer");
    }

    public zzju(zzik zzikVar, zzbb zzbbVar) {
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzep.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 30 + String.valueOf(str).length() + 1);
            sb.append("Init ");
            sb.append(hexString);
            sb.append(" [AndroidXMedia3/1.8.0] [");
            sb.append(str);
            sb.append("]");
            zzdt.zzb("ExoPlayerImpl", sb.toString());
            this.zzf = zzikVar.zza.getApplicationContext();
            this.zzs = (zzmi) zzikVar.zzh.apply(zzikVar.zzb);
            this.zzU = zzikVar.zzj;
            this.zzP = zzikVar.zzk;
            this.zzN = zzikVar.zzl;
            this.zzR = false;
            this.zzA = zzikVar.zzq;
            zzit zzitVar = new zzit(this, null);
            this.zzw = zzitVar;
            this.zzx = new zzjs(null);
            zzln[] zzlnVarArrZza = ((zzls) zzikVar.zzc.zza()).zza(new Handler(zzikVar.zzi), zzitVar, zzitVar, zzitVar, zzitVar);
            this.zzh = zzlnVarArrZza;
            int length = zzlnVarArrZza.length;
            this.zzi = new zzln[2];
            int i = 0;
            while (true) {
                zzln[] zzlnVarArr = this.zzi;
                int length2 = zzlnVarArr.length;
                if (i >= 2) {
                    break;
                }
                zzln zzlnVar = this.zzh[i];
                zzlnVarArr[i] = null;
                i++;
            }
            zzyr zzyrVar = (zzyr) zzikVar.zze.zza();
            this.zzj = zzyrVar;
            zzza zzzaVar = (zzza) zzikVar.zzg.zza();
            this.zzu = zzzaVar;
            this.zzr = zzikVar.zzm;
            this.zzH = zzikVar.zzn;
            this.zzG = zzikVar.zzo;
            Looper looper = zzikVar.zzi;
            this.zzt = looper;
            zzdc zzdcVar = zzikVar.zzb;
            this.zzv = zzdcVar;
            this.zzg = zzbbVar;
            this.zzn = new zzds(looper, zzdcVar, new zzdo() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzdo
                public final /* synthetic */ void zza(Object obj, zzs zzsVar) {
                    this.zza.zzJ((zzaz) obj, zzsVar);
                }
            });
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzo = copyOnWriteArraySet;
            this.zzq = new ArrayList();
            this.zzZ = new zzwn(0);
            this.zzI = zzil.zza;
            int length3 = this.zzh.length;
            zzys zzysVar = new zzys(new zzlq[2], new zzyk[2], zzbn.zza, null);
            this.zzb = zzysVar;
            this.zzp = new zzbd();
            zzaw zzawVar = new zzaw();
            zzawVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyrVar.zzd();
            zzawVar.zzb(29, true);
            zzawVar.zzb(23, false);
            zzawVar.zzb(25, false);
            zzawVar.zzb(33, false);
            zzawVar.zzb(26, false);
            zzawVar.zzb(34, false);
            zzax zzaxVarZze = zzawVar.zze();
            this.zzc = zzaxVarZze;
            zzaw zzawVar2 = new zzaw();
            zzawVar2.zzd(zzaxVarZze);
            zzawVar2.zza(4);
            zzawVar2.zza(10);
            this.zzJ = zzawVar2.zze();
            this.zzk = zzdcVar.zzd(looper, null);
            zzkf zzkfVar = new zzkf() { // from class: com.google.android.gms.internal.ads.zziu
                @Override // com.google.android.gms.internal.ads.zzkf
                public final /* synthetic */ void zza(zzke zzkeVar) {
                    this.zza.zzK(zzkeVar);
                }
            };
            this.zzl = zzkfVar;
            this.zzW = zzlf.zza(zzysVar);
            this.zzs.zzx(zzbbVar, looper);
            final zzpc zzpcVar = new zzpc(zzikVar.zzx);
            zzkh zzkhVar = new zzkh(this.zzf, this.zzh, this.zzi, zzyrVar, zzysVar, (zzkl) zzikVar.zzf.zza(), zzzaVar, 0, false, this.zzs, this.zzH, zzikVar.zzy, zzikVar.zzp, false, false, looper, zzdcVar, zzkfVar, zzpcVar, null, this.zzI, this.zzx);
            this.zzm = zzkhVar;
            Looper looperZzn = zzkhVar.zzn();
            this.zzQ = 1.0f;
            zzan zzanVar = zzan.zza;
            this.zzK = zzanVar;
            this.zzV = zzanVar;
            this.zzX = -1;
            int i2 = zzco.zza;
            this.zzS = true;
            zze(this.zzs);
            zzzaVar.zzf(new Handler(looper), this.zzs);
            copyOnWriteArraySet.add(this.zzw);
            if (Build.VERSION.SDK_INT >= 31) {
                final Context context = this.zzf;
                final boolean z = zzikVar.zzv;
                zzdcVar.zzd(zzkhVar.zzn(), null).zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzin
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzoy zzoyVarZza = zzoy.zza(context);
                        if (zzoyVarZza == null) {
                            zzdt.zzc("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.zzD(zzoyVarZza);
                        }
                        zzpcVar.zzb(zzoyVarZza.zzb());
                    }
                });
            }
            zzdb zzdbVar = new zzdb(0, looperZzn, looper, zzdcVar, new zzda() { // from class: com.google.android.gms.internal.ads.zzjf
                @Override // com.google.android.gms.internal.ads.zzda
                public final /* synthetic */ void zza(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    this.zza.zzL(((Integer) obj).intValue(), iIntValue);
                }
            });
            this.zzB = zzdbVar;
            zzdbVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzM();
                }
            });
            new zzhm(zzikVar.zza, looperZzn, zzikVar.zzi, this.zzw, zzdcVar);
            this.zzy = new zzmg(zzikVar.zza, looperZzn, zzdcVar);
            this.zzz = new zzmh(zzikVar.zza, looperZzn, zzdcVar);
            int i3 = zzm.zza;
            zzbv zzbvVar = zzbv.zza;
            this.zzO = zzeh.zza;
            this.zzC = new zzme(this, this.zzw, zzdcVar, zzikVar.zzr, zzikVar.zzs, zzikVar.zzt, zzikVar.zzu);
            zzkhVar.zzg(this.zzG);
            zzkhVar.zzi(this.zzP, false);
            zzao(1, 3, this.zzP);
            zzao(2, 4, Integer.valueOf(this.zzN));
            zzao(2, 5, 0);
            zzao(1, 9, Boolean.valueOf(this.zzR));
            zzao(6, 8, this.zzx);
            zzao(-1, 16, Integer.valueOf(this.zzU));
        } finally {
            this.zze.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzZ, reason: merged with bridge method [inline-methods] */
    public final void zzP(zzib zzibVar) {
        zzlf zzlfVar = this.zzW;
        zzlf zzlfVarZzh = zzlfVar.zzh(zzlfVar.zzb);
        zzlfVarZzh.zzq = zzlfVarZzh.zzs;
        zzlfVarZzh.zzr = 0L;
        zzlf zzlfVarZzag = zzag(zzlfVarZzh, 1);
        if (zzibVar != null) {
            zzlfVarZzag = zzlfVarZzag.zzf(zzibVar);
        }
        this.zzD++;
        this.zzm.zzh();
        zzad(zzlfVarZzag, 0, false, 5, -9223372036854775807L, -1, false);
    }

    private final int zzaa(zzlf zzlfVar) {
        zzbf zzbfVar = zzlfVar.zza;
        return zzbfVar.zzg() ? this.zzX : zzbfVar.zzo(zzlfVar.zzb.zza, this.zzp).zzc;
    }

    private final long zzab(zzlf zzlfVar) {
        zzuu zzuuVar = zzlfVar.zzb;
        if (!zzuuVar.zzb()) {
            return zzep.zzp(zzac(zzlfVar));
        }
        zzbf zzbfVar = zzlfVar.zza;
        zzbfVar.zzo(zzuuVar.zza, this.zzp);
        long j = zzlfVar.zzc;
        if (j != -9223372036854775807L) {
            return zzep.zzp(0L) + zzep.zzp(j);
        }
        long j2 = zzbfVar.zzb(zzaa(zzlfVar), this.zza, 0L).zzl;
        return zzep.zzp(0L);
    }

    private final long zzac(zzlf zzlfVar) {
        zzbf zzbfVar = zzlfVar.zza;
        if (zzbfVar.zzg()) {
            return zzep.zzq(this.zzY);
        }
        boolean z = zzlfVar.zzp;
        long j = zzlfVar.zzs;
        zzuu zzuuVar = zzlfVar.zzb;
        if (zzuuVar.zzb()) {
            return j;
        }
        zzai(zzbfVar, zzuuVar, j);
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:103:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:105:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:107:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:108:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:113:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:116:0x0308  */
    /* JADX WARN: Code duplicated, block: B:118:0x031c  */
    /* JADX WARN: Code duplicated, block: B:120:0x032c  */
    /* JADX WARN: Code duplicated, block: B:123:0x033c  */
    /* JADX WARN: Code duplicated, block: B:126:0x034a  */
    /* JADX WARN: Code duplicated, block: B:131:0x035d  */
    /* JADX WARN: Code duplicated, block: B:134:0x036e  */
    /* JADX WARN: Code duplicated, block: B:137:0x0383  */
    /* JADX WARN: Code duplicated, block: B:140:0x0399  */
    /* JADX WARN: Code duplicated, block: B:143:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:146:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:150:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:151:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:153:0x03f4  */
    /* JADX WARN: Code duplicated, block: B:154:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:157:0x0403  */
    /* JADX WARN: Code duplicated, block: B:158:0x0405  */
    /* JADX WARN: Code duplicated, block: B:160:0x0415  */
    /* JADX WARN: Code duplicated, block: B:163:0x0420  */
    /* JADX WARN: Code duplicated, block: B:165:0x0434  */
    /* JADX WARN: Code duplicated, block: B:166:0x0436  */
    /* JADX WARN: Code duplicated, block: B:170:0x0445  */
    /* JADX WARN: Code duplicated, block: B:173:0x0455  */
    /* JADX WARN: Code duplicated, block: B:176:0x046d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x0471  */
    /* JADX WARN: Code duplicated, block: B:181:0x0477 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:183:0x047b  */
    /* JADX WARN: Code duplicated, block: B:186:0x0481 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:191:0x048b  */
    /* JADX WARN: Code duplicated, block: B:194:0x0492 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:196:0x0496  */
    /* JADX WARN: Code duplicated, block: B:199:0x049e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:204:0x04a8  */
    /* JADX WARN: Code duplicated, block: B:207:0x04b5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:209:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:212:0x04c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:214:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:217:0x04db  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:42:0x010a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0110  */
    /* JADX WARN: Code duplicated, block: B:48:0x011d  */
    /* JADX WARN: Code duplicated, block: B:51:0x012d  */
    /* JADX WARN: Code duplicated, block: B:54:0x013b A[LOOP:1: B:52:0x0135->B:54:0x013b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0158  */
    /* JADX WARN: Code duplicated, block: B:60:0x015b  */
    /* JADX WARN: Code duplicated, block: B:63:0x0186  */
    /* JADX WARN: Code duplicated, block: B:64:0x0188  */
    /* JADX WARN: Code duplicated, block: B:67:0x0190  */
    /* JADX WARN: Code duplicated, block: B:68:0x0192  */
    /* JADX WARN: Code duplicated, block: B:71:0x0198  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:84:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:86:0x0204  */
    /* JADX WARN: Code duplicated, block: B:87:0x0211  */
    /* JADX WARN: Code duplicated, block: B:89:0x0216  */
    /* JADX WARN: Code duplicated, block: B:90:0x021d  */
    /* JADX WARN: Code duplicated, block: B:91:0x0220  */
    /* JADX WARN: Code duplicated, block: B:93:0x0228  */
    /* JADX WARN: Code duplicated, block: B:94:0x022f  */
    /* JADX WARN: Code duplicated, block: B:98:0x025b  */
    /* JADX WARN: Code duplicated, block: B:99:0x028c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.google.android.gms.internal.ads.zzbf] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    private final void zzad(final zzlf zzlfVar, final int i, boolean z, int i2, long j, int i3, boolean z2) {
        int i4;
        zzlf zzlfVar2;
        zzbf zzbfVar;
        final int i5;
        boolean z3;
        Pair pair;
        boolean z4;
        boolean z5;
        int i6;
        boolean zBooleanValue;
        final int iIntValue;
        final zzak zzakVar;
        zzam zzamVarZza;
        List list;
        int i7;
        zzap zzapVar;
        int i8;
        zzbf zzbfVarZzq;
        zzan zzanVarZzw;
        boolean zEquals;
        int i9;
        int i10;
        int i11;
        zzib zzibVar;
        zzib zzibVar2;
        zzys zzysVar;
        zzys zzysVar2;
        zzax zzaxVar;
        zzbb zzbbVar;
        zzf zzfVar;
        zzbf zzbfVarZzq2;
        zzax zzaxVar2;
        boolean z6;
        zzbf zzbfVarZzq3;
        ?? r15;
        int iZzi;
        int i12;
        boolean z7;
        ?? Zzq;
        int iZzs;
        ?? r4;
        zzbf zzbfVarZzq4;
        zzbb zzbbVar2;
        long j2;
        zzbf zzbfVarZzq5;
        boolean z8;
        boolean zZzg;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i13;
        boolean z15;
        zzax zzaxVarZze;
        zzds zzdsVar;
        zzbd zzbdVar;
        int i14;
        Object obj;
        zzak zzakVar2;
        Object obj2;
        int i15;
        long jZzae;
        long jZzae2;
        int iZzs2;
        Object obj3;
        zzak zzakVar3;
        Object obj4;
        int i16;
        long jZzp;
        long jZzp2;
        zzuu zzuuVar;
        int i17 = i2;
        zzlf zzlfVar3 = this.zzW;
        this.zzW = zzlfVar;
        zzbf zzbfVar2 = zzlfVar3.zza;
        zzbf zzbfVar3 = zzlfVar.zza;
        boolean zEquals2 = zzbfVar2.equals(zzbfVar3);
        if (!zzbfVar3.zzg() || !zzbfVar2.zzg()) {
            if (zzbfVar3.zzg() != zzbfVar2.zzg()) {
                pair = new Pair(true, 3);
            } else {
                zzuu zzuuVar2 = zzlfVar3.zzb;
                Object obj5 = zzuuVar2.zza;
                i4 = 0;
                zzbd zzbdVar2 = this.zzp;
                int i18 = zzbfVar2.zzo(obj5, zzbdVar2).zzc;
                zzbe zzbeVar = this.zza;
                Object obj6 = zzbfVar2.zzb(i18, zzbeVar, 0L).zzb;
                zzuu zzuuVar3 = zzlfVar.zzb;
                zzlfVar2 = zzlfVar3;
                zzbfVar = zzbfVar2;
                if (obj6.equals(zzbfVar3.zzb(zzbfVar3.zzo(zzuuVar3.zza, zzbdVar2).zzc, zzbeVar, 0L).zzb)) {
                    if (z) {
                        if (i17 != 0) {
                            i5 = i17;
                        } else if (zzuuVar2.zzd < zzuuVar3.zzd) {
                            pair = new Pair(true, 0);
                            i5 = 0;
                            z3 = true;
                        } else {
                            i5 = 0;
                        }
                        z3 = true;
                    } else {
                        i5 = i17;
                        z3 = false;
                    }
                    pair = new Pair(false, -1);
                } else {
                    if (z) {
                        if (i17 == 0) {
                            i17 = 0;
                            z4 = true;
                            i6 = 1;
                        } else {
                            z4 = true;
                            z5 = true;
                        }
                        Pair pair2 = new Pair(true, Integer.valueOf(i6));
                        boolean z16 = z4;
                        i5 = i17;
                        z3 = z16;
                        pair = pair2;
                    } else {
                        z4 = false;
                        z5 = false;
                    }
                    if (z4 && i17 == 1) {
                        z4 = z5;
                        i6 = 2;
                    } else {
                        if (zEquals2) {
                            throw new IllegalStateException();
                        }
                        i6 = 3;
                    }
                    Pair pair3 = new Pair(true, Integer.valueOf(i6));
                    boolean z17 = z4;
                    i5 = i17;
                    z3 = z17;
                    pair = pair3;
                }
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzbfVar3.zzg()) {
                    zzakVar = null;
                } else {
                    zzakVar = zzbfVar3.zzb(zzbfVar3.zzo(zzlfVar.zzb.zza, this.zzp).zzc, this.zza, 0L).zzd;
                }
                this.zzV = zzan.zza;
            } else {
                zzakVar = null;
            }
            if (zBooleanValue || !zzlfVar2.zzj.equals(zzlfVar.zzj)) {
                zzamVarZza = this.zzV.zza();
                list = zzlfVar.zzj;
                for (i7 = i4; i7 < list.size(); i7++) {
                    zzapVar = (zzap) list.get(i7);
                    for (i8 = i4; i8 < zzapVar.zza(); i8++) {
                        zzapVar.zzb(i8).zza(zzamVarZza);
                    }
                }
                this.zzV = zzamVarZza.zzw();
            }
            zzbfVarZzq = zzq();
            if (zzbfVarZzq.zzg()) {
                zzanVarZzw = this.zzV;
            } else {
                zzak zzakVar4 = zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzd;
                zzam zzamVarZza2 = this.zzV.zza();
                zzamVarZza2.zzv(zzakVar4.zzd);
                zzanVarZzw = zzamVarZza2.zzw();
            }
            zEquals = zzanVarZzw.equals(this.zzK);
            this.zzK = zzanVarZzw;
            if (zzlfVar2.zzl != zzlfVar.zzl) {
                i9 = 1;
            } else {
                i9 = i4;
            }
            if (zzlfVar2.zze != zzlfVar.zze) {
                i10 = 1;
            } else {
                i10 = i4;
            }
            if (i10 == 0 || i9 != 0) {
                zzam();
            }
            if (zzlfVar2.zzg != zzlfVar.zzg) {
                i11 = 1;
            } else {
                i11 = i4;
            }
            if (!zEquals2) {
                this.zzn.zzd(i4, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjn
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj7) {
                        int i19 = zzju.zzd;
                        ((zzaz) obj7).zzb(zzlfVar.zza, i);
                    }
                });
            }
            if (z3) {
                zzbdVar = new zzbd();
                if (zzbfVar.zzg()) {
                    i14 = i3;
                    obj = null;
                    zzakVar2 = null;
                    obj2 = null;
                    i15 = -1;
                } else {
                    Object obj7 = zzlfVar2.zzb.zza;
                    zzbf zzbfVar4 = zzbfVar;
                    zzbfVar4.zzo(obj7, zzbdVar);
                    int i19 = zzbdVar.zzc;
                    int iZze = zzbfVar4.zze(obj7);
                    zzbe zzbeVar2 = this.zza;
                    Object obj8 = zzbfVar4.zzb(i19, zzbeVar2, 0L).zzb;
                    zzakVar2 = zzbeVar2.zzd;
                    i14 = i19;
                    obj = obj8;
                    obj2 = obj7;
                    i15 = iZze;
                }
                if (i5 == 0) {
                    zzuuVar = zzlfVar2.zzb;
                    if (zzuuVar.zzb()) {
                        jZzae = zzbdVar.zzh(zzuuVar.zzb, zzuuVar.zzc);
                        jZzae2 = zzae(zzlfVar2);
                    } else {
                        if (zzuuVar.zze != -1) {
                            jZzae = zzae(this.zzW);
                        } else {
                            jZzae = zzbdVar.zzd;
                        }
                        jZzae2 = jZzae;
                    }
                } else if (zzlfVar2.zzb.zzb()) {
                    jZzae = zzlfVar2.zzs;
                    jZzae2 = zzae(zzlfVar2);
                } else {
                    jZzae = zzlfVar2.zzs;
                    jZzae2 = jZzae;
                }
                String str = zzep.zza;
                zzuu zzuuVar4 = zzlfVar2.zzb;
                final zzba zzbaVar = new zzba(obj, i14, zzakVar2, obj2, i15, zzep.zzp(jZzae), zzep.zzp(jZzae2), zzuuVar4.zzb, zzuuVar4.zzc);
                iZzs2 = zzs();
                if (this.zzW.zza.zzg()) {
                    obj3 = null;
                    zzakVar3 = null;
                    obj4 = null;
                    i16 = -1;
                } else {
                    zzlf zzlfVar4 = this.zzW;
                    Object obj9 = zzlfVar4.zzb.zza;
                    zzlfVar4.zza.zzo(obj9, this.zzp);
                    int iZze2 = this.zzW.zza.zze(obj9);
                    zzbf zzbfVar5 = this.zzW.zza;
                    zzbe zzbeVar3 = this.zza;
                    i16 = iZze2;
                    obj3 = zzbfVar5.zzb(iZzs2, zzbeVar3, 0L).zzb;
                    zzakVar3 = zzbeVar3.zzd;
                    obj4 = obj9;
                }
                jZzp = zzep.zzp(j);
                if (this.zzW.zzb.zzb()) {
                    jZzp2 = zzep.zzp(zzae(this.zzW));
                } else {
                    jZzp2 = jZzp;
                }
                zzuu zzuuVar5 = this.zzW.zzb;
                final zzba zzbaVar2 = new zzba(obj3, iZzs2, zzakVar3, obj4, i16, jZzp, jZzp2, zzuuVar5.zzb, zzuuVar5.zzc);
                this.zzn.zzd(11, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjo
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzo(zzbaVar, zzbaVar2, i5);
                    }
                });
            } else {
                i9 = i9;
                zEquals = zEquals;
            }
            if (zBooleanValue) {
                this.zzn.zzd(1, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjp
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzc(zzakVar, iIntValue);
                    }
                });
            }
            zzibVar = zzlfVar2.zzf;
            zzibVar2 = zzlfVar.zzf;
            if (zzibVar != zzibVar2) {
                zzdsVar = this.zzn;
                zzdsVar.zzd(10, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjq
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzn(zzlfVar.zzf);
                    }
                });
                if (zzibVar2 != null) {
                    zzdsVar.zzd(10, new zzdn() { // from class: com.google.android.gms.internal.ads.zziv
                        @Override // com.google.android.gms.internal.ads.zzdn
                        public final /* synthetic */ void zza(Object obj10) {
                            int i20 = zzju.zzd;
                            ((zzaz) obj10).zzm(zzlfVar.zzf);
                        }
                    });
                }
            }
            zzysVar = zzlfVar2.zzi;
            zzysVar2 = zzlfVar.zzi;
            if (zzysVar != zzysVar2) {
                this.zzj.zzp(zzysVar2.zze);
                this.zzn.zzd(2, new zzdn() { // from class: com.google.android.gms.internal.ads.zziw
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzd(zzlfVar.zzi.zzd);
                    }
                });
            }
            if (!zEquals) {
                final zzan zzanVar = this.zzK;
                this.zzn.zzd(14, new zzdn() { // from class: com.google.android.gms.internal.ads.zzix
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zze(zzanVar);
                    }
                });
            }
            if (i11 != 0) {
                this.zzn.zzd(3, new zzdn() { // from class: com.google.android.gms.internal.ads.zziy
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzf(zzlfVar.zzg);
                    }
                });
            }
            if (i10 == 0 || i9 != 0) {
                this.zzn.zzd(-1, new zzdn() { // from class: com.google.android.gms.internal.ads.zziz
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        zzlf zzlfVar5 = zzlfVar;
                        ((zzaz) obj10).zzh(zzlfVar5.zzl, zzlfVar5.zze);
                    }
                });
            }
            if (i10 != 0) {
                this.zzn.zzd(4, new zzdn() { // from class: com.google.android.gms.internal.ads.zzja
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzi(zzlfVar.zze);
                    }
                });
            }
            if (i9 == 0 || zzlfVar2.zzm != zzlfVar.zzm) {
                this.zzn.zzd(5, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjb
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        zzlf zzlfVar5 = zzlfVar;
                        ((zzaz) obj10).zzj(zzlfVar5.zzl, zzlfVar5.zzm);
                    }
                });
            }
            if (zzlfVar2.zzn != zzlfVar.zzn) {
                this.zzn.zzd(6, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjc
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzk(zzlfVar.zzn);
                    }
                });
            }
            if (zzlfVar2.zzj() != zzlfVar.zzj()) {
                this.zzn.zzd(7, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjd
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzl(zzlfVar.zzj());
                    }
                });
            }
            if (!zzlfVar2.zzo.equals(zzlfVar.zzo)) {
                this.zzn.zzd(12, new zzdn() { // from class: com.google.android.gms.internal.ads.zzje
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj10).zzp(zzlfVar.zzo);
                    }
                });
            }
            zzaxVar = this.zzJ;
            zzbbVar = this.zzg;
            zzax zzaxVar3 = this.zzc;
            String str2 = zzep.zza;
            boolean zZzx = zzbbVar.zzx();
            zzfVar = (zzf) zzbbVar;
            zzbfVarZzq2 = zzfVar.zzq();
            if (!zzbfVarZzq2.zzg()) {
                zzaxVar2 = zzaxVar;
                z6 = zzbfVarZzq2.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzh;
                zzbfVarZzq3 = zzfVar.zzq();
                if (zzbfVarZzq3.zzg()) {
                    i12 = -1;
                    r15 = 0;
                    z7 = false;
                } else {
                    int iZzs3 = zzfVar.zzs();
                    zzfVar.zzl();
                    zzfVar.zzm();
                    r15 = 0;
                    r15 = 0;
                    iZzi = zzbfVarZzq3.zzi(iZzs3, 0, false);
                    i12 = -1;
                    if (iZzi != -1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                Zzq = zzfVar.zzq();
                if (Zzq.zzg()) {
                    r4 = r15;
                } else {
                    iZzs = zzfVar.zzs();
                    zzfVar.zzl();
                    zzfVar.zzm();
                    if (Zzq.zzh(iZzs, r15, r15) != i12) {
                        r4 = 1;
                    } else {
                        r4 = r15;
                    }
                }
                zzbfVarZzq4 = zzfVar.zzq();
                if (!zzbfVarZzq4.zzg()) {
                    zzbbVar2 = zzbbVar;
                    j2 = 0;
                    boolean z18 = zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb();
                    zzbfVarZzq5 = zzfVar.zzq();
                    if (zzbfVarZzq5.zzg() && zzbfVarZzq5.zzb(zzfVar.zzs(), zzfVar.zza, j2).zzi) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zZzg = zzbbVar2.zzq().zzg();
                    zzaw zzawVar = new zzaw();
                    zzawVar.zzd(zzaxVar3);
                    boolean z19 = !zZzx;
                    zzawVar.zzb(4, z19);
                    if (z6 || zZzx) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    zzawVar.zzb(5, z9);
                    if (z7 || zZzx) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    zzawVar.zzb(6, z10);
                    if (!zZzg || (!(z7 || !z18 || z6) || zZzx)) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    zzawVar.zzb(7, z11);
                    if (r4 != 0 || zZzx) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    zzawVar.zzb(8, z12);
                    if (!zZzg || ((r4 == 0 && !(z18 && z8)) || zZzx)) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    zzawVar.zzb(9, z13);
                    zzawVar.zzb(10, z19);
                    if (z6 || zZzx) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    zzawVar.zzb(11, z14);
                    if (z6 || zZzx) {
                        i13 = 12;
                        z15 = false;
                    } else {
                        i13 = 12;
                        z15 = true;
                    }
                    zzawVar.zzb(i13, z15);
                    zzaxVarZze = zzawVar.zze();
                    this.zzJ = zzaxVarZze;
                    if (!zzaxVarZze.equals(zzaxVar2)) {
                        this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                            @Override // com.google.android.gms.internal.ads.zzdn
                            public final /* synthetic */ void zza(Object obj10) {
                                this.zza.zzN((zzaz) obj10);
                            }
                        });
                    }
                    this.zzn.zze();
                    boolean z20 = zzlfVar2.zzp;
                    boolean z21 = zzlfVar.zzp;
                }
                zzbbVar2 = zzbbVar;
                j2 = 0;
                zzbfVarZzq5 = zzfVar.zzq();
                if (zzbfVarZzq5.zzg()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                zZzg = zzbbVar2.zzq().zzg();
                zzaw zzawVar2 = new zzaw();
                zzawVar2.zzd(zzaxVar3);
                boolean z110 = !zZzx;
                zzawVar2.zzb(4, z110);
                if (z6) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                zzawVar2.zzb(5, z9);
                if (z7) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                zzawVar2.zzb(6, z10);
                if (zZzg) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                zzawVar2.zzb(7, z11);
                if (r4 != 0) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzawVar2.zzb(8, z12);
                if (zZzg) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzawVar2.zzb(9, z13);
                zzawVar2.zzb(10, z110);
                if (z6) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                zzawVar2.zzb(11, z14);
                if (z6) {
                    i13 = 12;
                    z15 = false;
                } else {
                    i13 = 12;
                    z15 = false;
                }
                zzawVar2.zzb(i13, z15);
                zzaxVarZze = zzawVar2.zze();
                this.zzJ = zzaxVarZze;
                if (!zzaxVarZze.equals(zzaxVar2)) {
                    this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                        @Override // com.google.android.gms.internal.ads.zzdn
                        public final /* synthetic */ void zza(Object obj10) {
                            this.zza.zzN((zzaz) obj10);
                        }
                    });
                }
                this.zzn.zze();
                boolean z22 = zzlfVar2.zzp;
                boolean z23 = zzlfVar.zzp;
            }
            zzaxVar2 = zzaxVar;
            zzbfVarZzq3 = zzfVar.zzq();
            if (zzbfVarZzq3.zzg()) {
                i12 = -1;
                r15 = 0;
                z7 = false;
            } else {
                int iZzs4 = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                r15 = 0;
                r15 = 0;
                iZzi = zzbfVarZzq3.zzi(iZzs4, 0, false);
                i12 = -1;
                if (iZzi != -1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            Zzq = zzfVar.zzq();
            if (Zzq.zzg()) {
                r4 = r15;
            } else {
                iZzs = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                if (Zzq.zzh(iZzs, r15, r15) != i12) {
                    r4 = 1;
                } else {
                    r4 = r15;
                }
            }
            zzbfVarZzq4 = zzfVar.zzq();
            if (!zzbfVarZzq4.zzg()) {
                zzbbVar2 = zzbbVar;
                j2 = 0;
                if (zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb()) {
                }
                zzbfVarZzq5 = zzfVar.zzq();
                if (zzbfVarZzq5.zzg()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                zZzg = zzbbVar2.zzq().zzg();
                zzaw zzawVar3 = new zzaw();
                zzawVar3.zzd(zzaxVar3);
                boolean z111 = !zZzx;
                zzawVar3.zzb(4, z111);
                if (z6) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                zzawVar3.zzb(5, z9);
                if (z7) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                zzawVar3.zzb(6, z10);
                if (zZzg) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                zzawVar3.zzb(7, z11);
                if (r4 != 0) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzawVar3.zzb(8, z12);
                if (zZzg) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzawVar3.zzb(9, z13);
                zzawVar3.zzb(10, z111);
                if (z6) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                zzawVar3.zzb(11, z14);
                if (z6) {
                    i13 = 12;
                    z15 = false;
                } else {
                    i13 = 12;
                    z15 = false;
                }
                zzawVar3.zzb(i13, z15);
                zzaxVarZze = zzawVar3.zze();
                this.zzJ = zzaxVarZze;
                if (!zzaxVarZze.equals(zzaxVar2)) {
                    this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                        @Override // com.google.android.gms.internal.ads.zzdn
                        public final /* synthetic */ void zza(Object obj10) {
                            this.zza.zzN((zzaz) obj10);
                        }
                    });
                }
                this.zzn.zze();
                boolean z24 = zzlfVar2.zzp;
                boolean z25 = zzlfVar.zzp;
            }
            zzbbVar2 = zzbbVar;
            j2 = 0;
            zzbfVarZzq5 = zzfVar.zzq();
            if (zzbfVarZzq5.zzg()) {
                z8 = false;
            } else {
                z8 = false;
            }
            zZzg = zzbbVar2.zzq().zzg();
            zzaw zzawVar4 = new zzaw();
            zzawVar4.zzd(zzaxVar3);
            boolean z112 = !zZzx;
            zzawVar4.zzb(4, z112);
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            zzawVar4.zzb(5, z9);
            if (z7) {
                z10 = false;
            } else {
                z10 = false;
            }
            zzawVar4.zzb(6, z10);
            if (zZzg) {
                z11 = false;
            } else {
                z11 = false;
            }
            zzawVar4.zzb(7, z11);
            if (r4 != 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzawVar4.zzb(8, z12);
            if (zZzg) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzawVar4.zzb(9, z13);
            zzawVar4.zzb(10, z112);
            if (z6) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzawVar4.zzb(11, z14);
            if (z6) {
                i13 = 12;
                z15 = false;
            } else {
                i13 = 12;
                z15 = false;
            }
            zzawVar4.zzb(i13, z15);
            zzaxVarZze = zzawVar4.zze();
            this.zzJ = zzaxVarZze;
            if (!zzaxVarZze.equals(zzaxVar2)) {
                this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj10) {
                        this.zza.zzN((zzaz) obj10);
                    }
                });
            }
            this.zzn.zze();
            boolean z26 = zzlfVar2.zzp;
            boolean z27 = zzlfVar.zzp;
        }
        pair = new Pair(false, -1);
        zzlfVar2 = zzlfVar3;
        zzbfVar = zzbfVar2;
        i4 = 0;
        i5 = i17;
        z3 = z;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzbfVar3.zzg()) {
                zzakVar = zzbfVar3.zzb(zzbfVar3.zzo(zzlfVar.zzb.zza, this.zzp).zzc, this.zza, 0L).zzd;
            } else {
                zzakVar = null;
            }
            this.zzV = zzan.zza;
        } else {
            zzakVar = null;
        }
        if (zBooleanValue) {
            zzamVarZza = this.zzV.zza();
            list = zzlfVar.zzj;
            while (i7 < list.size()) {
                zzapVar = (zzap) list.get(i7);
                while (i8 < zzapVar.zza()) {
                    zzapVar.zzb(i8).zza(zzamVarZza);
                }
            }
            this.zzV = zzamVarZza.zzw();
        } else {
            zzamVarZza = this.zzV.zza();
            list = zzlfVar.zzj;
            while (i7 < list.size()) {
                zzapVar = (zzap) list.get(i7);
                while (i8 < zzapVar.zza()) {
                    zzapVar.zzb(i8).zza(zzamVarZza);
                }
            }
            this.zzV = zzamVarZza.zzw();
        }
        zzbfVarZzq = zzq();
        if (zzbfVarZzq.zzg()) {
            zzanVarZzw = this.zzV;
        } else {
            zzak zzakVar5 = zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzd;
            zzam zzamVarZza3 = this.zzV.zza();
            zzamVarZza3.zzv(zzakVar5.zzd);
            zzanVarZzw = zzamVarZza3.zzw();
        }
        zEquals = zzanVarZzw.equals(this.zzK);
        this.zzK = zzanVarZzw;
        if (zzlfVar2.zzl != zzlfVar.zzl) {
            i9 = 1;
        } else {
            i9 = i4;
        }
        if (zzlfVar2.zze != zzlfVar.zze) {
            i10 = 1;
        } else {
            i10 = i4;
        }
        if (i10 == 0) {
            zzam();
        } else {
            zzam();
        }
        if (zzlfVar2.zzg != zzlfVar.zzg) {
            i11 = 1;
        } else {
            i11 = i4;
        }
        if (!zEquals2) {
            this.zzn.zzd(i4, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjn
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj10) {
                    int i110 = zzju.zzd;
                    ((zzaz) obj10).zzb(zzlfVar.zza, i);
                }
            });
        }
        if (z3) {
            zzbdVar = new zzbd();
            if (zzbfVar.zzg()) {
                Object obj10 = zzlfVar2.zzb.zza;
                zzbf zzbfVar6 = zzbfVar;
                zzbfVar6.zzo(obj10, zzbdVar);
                int i110 = zzbdVar.zzc;
                int iZze3 = zzbfVar6.zze(obj10);
                zzbe zzbeVar4 = this.zza;
                Object obj11 = zzbfVar6.zzb(i110, zzbeVar4, 0L).zzb;
                zzakVar2 = zzbeVar4.zzd;
                i14 = i110;
                obj = obj11;
                obj2 = obj10;
                i15 = iZze3;
            } else {
                i14 = i3;
                obj = null;
                zzakVar2 = null;
                obj2 = null;
                i15 = -1;
            }
            if (i5 == 0) {
                zzuuVar = zzlfVar2.zzb;
                if (zzuuVar.zzb()) {
                    jZzae = zzbdVar.zzh(zzuuVar.zzb, zzuuVar.zzc);
                    jZzae2 = zzae(zzlfVar2);
                } else {
                    if (zzuuVar.zze != -1) {
                        jZzae = zzae(this.zzW);
                    } else {
                        jZzae = zzbdVar.zzd;
                    }
                    jZzae2 = jZzae;
                }
            } else if (zzlfVar2.zzb.zzb()) {
                jZzae = zzlfVar2.zzs;
                jZzae2 = zzae(zzlfVar2);
            } else {
                jZzae = zzlfVar2.zzs;
                jZzae2 = jZzae;
            }
            String str3 = zzep.zza;
            zzuu zzuuVar6 = zzlfVar2.zzb;
            final zzba zzbaVar3 = new zzba(obj, i14, zzakVar2, obj2, i15, zzep.zzp(jZzae), zzep.zzp(jZzae2), zzuuVar6.zzb, zzuuVar6.zzc);
            iZzs2 = zzs();
            if (this.zzW.zza.zzg()) {
                zzlf zzlfVar5 = this.zzW;
                Object obj12 = zzlfVar5.zzb.zza;
                zzlfVar5.zza.zzo(obj12, this.zzp);
                int iZze4 = this.zzW.zza.zze(obj12);
                zzbf zzbfVar7 = this.zzW.zza;
                zzbe zzbeVar5 = this.zza;
                i16 = iZze4;
                obj3 = zzbfVar7.zzb(iZzs2, zzbeVar5, 0L).zzb;
                zzakVar3 = zzbeVar5.zzd;
                obj4 = obj12;
            } else {
                obj3 = null;
                zzakVar3 = null;
                obj4 = null;
                i16 = -1;
            }
            jZzp = zzep.zzp(j);
            if (this.zzW.zzb.zzb()) {
                jZzp2 = zzep.zzp(zzae(this.zzW));
            } else {
                jZzp2 = jZzp;
            }
            zzuu zzuuVar7 = this.zzW.zzb;
            final zzba zzbaVar4 = new zzba(obj3, iZzs2, zzakVar3, obj4, i16, jZzp, jZzp2, zzuuVar7.zzb, zzuuVar7.zzc);
            this.zzn.zzd(11, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjo
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzo(zzbaVar3, zzbaVar4, i5);
                }
            });
        } else {
            i9 = i9;
            zEquals = zEquals;
        }
        if (zBooleanValue) {
            this.zzn.zzd(1, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzc(zzakVar, iIntValue);
                }
            });
        }
        zzibVar = zzlfVar2.zzf;
        zzibVar2 = zzlfVar.zzf;
        if (zzibVar != zzibVar2) {
            zzdsVar = this.zzn;
            zzdsVar.zzd(10, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjq
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzn(zzlfVar.zzf);
                }
            });
            if (zzibVar2 != null) {
                zzdsVar.zzd(10, new zzdn() { // from class: com.google.android.gms.internal.ads.zziv
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj13) {
                        int i20 = zzju.zzd;
                        ((zzaz) obj13).zzm(zzlfVar.zzf);
                    }
                });
            }
        }
        zzysVar = zzlfVar2.zzi;
        zzysVar2 = zzlfVar.zzi;
        if (zzysVar != zzysVar2) {
            this.zzj.zzp(zzysVar2.zze);
            this.zzn.zzd(2, new zzdn() { // from class: com.google.android.gms.internal.ads.zziw
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzd(zzlfVar.zzi.zzd);
                }
            });
        }
        if (!zEquals) {
            final zzan zzanVar2 = this.zzK;
            this.zzn.zzd(14, new zzdn() { // from class: com.google.android.gms.internal.ads.zzix
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zze(zzanVar2);
                }
            });
        }
        if (i11 != 0) {
            this.zzn.zzd(3, new zzdn() { // from class: com.google.android.gms.internal.ads.zziy
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzf(zzlfVar.zzg);
                }
            });
        }
        if (i10 == 0) {
            this.zzn.zzd(-1, new zzdn() { // from class: com.google.android.gms.internal.ads.zziz
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    zzlf zzlfVar6 = zzlfVar;
                    ((zzaz) obj13).zzh(zzlfVar6.zzl, zzlfVar6.zze);
                }
            });
        } else {
            this.zzn.zzd(-1, new zzdn() { // from class: com.google.android.gms.internal.ads.zziz
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    zzlf zzlfVar6 = zzlfVar;
                    ((zzaz) obj13).zzh(zzlfVar6.zzl, zzlfVar6.zze);
                }
            });
        }
        if (i10 != 0) {
            this.zzn.zzd(4, new zzdn() { // from class: com.google.android.gms.internal.ads.zzja
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzi(zzlfVar.zze);
                }
            });
        }
        if (i9 == 0) {
            this.zzn.zzd(5, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjb
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    zzlf zzlfVar6 = zzlfVar;
                    ((zzaz) obj13).zzj(zzlfVar6.zzl, zzlfVar6.zzm);
                }
            });
        } else {
            this.zzn.zzd(5, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjb
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    zzlf zzlfVar6 = zzlfVar;
                    ((zzaz) obj13).zzj(zzlfVar6.zzl, zzlfVar6.zzm);
                }
            });
        }
        if (zzlfVar2.zzn != zzlfVar.zzn) {
            this.zzn.zzd(6, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjc
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzk(zzlfVar.zzn);
                }
            });
        }
        if (zzlfVar2.zzj() != zzlfVar.zzj()) {
            this.zzn.zzd(7, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjd
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzl(zzlfVar.zzj());
                }
            });
        }
        if (!zzlfVar2.zzo.equals(zzlfVar.zzo)) {
            this.zzn.zzd(12, new zzdn() { // from class: com.google.android.gms.internal.ads.zzje
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    int i20 = zzju.zzd;
                    ((zzaz) obj13).zzp(zzlfVar.zzo);
                }
            });
        }
        zzaxVar = this.zzJ;
        zzbbVar = this.zzg;
        zzax zzaxVar4 = this.zzc;
        String str4 = zzep.zza;
        boolean zZzx2 = zzbbVar.zzx();
        zzfVar = (zzf) zzbbVar;
        zzbfVarZzq2 = zzfVar.zzq();
        if (!zzbfVarZzq2.zzg()) {
            zzaxVar2 = zzaxVar;
            if (zzbfVarZzq2.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzh) {
            }
            zzbfVarZzq3 = zzfVar.zzq();
            if (zzbfVarZzq3.zzg()) {
                i12 = -1;
                r15 = 0;
                z7 = false;
            } else {
                int iZzs5 = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                r15 = 0;
                r15 = 0;
                iZzi = zzbfVarZzq3.zzi(iZzs5, 0, false);
                i12 = -1;
                if (iZzi != -1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            Zzq = zzfVar.zzq();
            if (Zzq.zzg()) {
                r4 = r15;
            } else {
                iZzs = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                if (Zzq.zzh(iZzs, r15, r15) != i12) {
                    r4 = 1;
                } else {
                    r4 = r15;
                }
            }
            zzbfVarZzq4 = zzfVar.zzq();
            if (!zzbfVarZzq4.zzg()) {
                zzbbVar2 = zzbbVar;
                j2 = 0;
                if (zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb()) {
                }
                zzbfVarZzq5 = zzfVar.zzq();
                if (zzbfVarZzq5.zzg()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                zZzg = zzbbVar2.zzq().zzg();
                zzaw zzawVar5 = new zzaw();
                zzawVar5.zzd(zzaxVar4);
                boolean z113 = !zZzx2;
                zzawVar5.zzb(4, z113);
                if (z6) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                zzawVar5.zzb(5, z9);
                if (z7) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                zzawVar5.zzb(6, z10);
                if (zZzg) {
                    z11 = false;
                } else {
                    z11 = false;
                }
                zzawVar5.zzb(7, z11);
                if (r4 != 0) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzawVar5.zzb(8, z12);
                if (zZzg) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzawVar5.zzb(9, z13);
                zzawVar5.zzb(10, z113);
                if (z6) {
                    z14 = false;
                } else {
                    z14 = false;
                }
                zzawVar5.zzb(11, z14);
                if (z6) {
                    i13 = 12;
                    z15 = false;
                } else {
                    i13 = 12;
                    z15 = false;
                }
                zzawVar5.zzb(i13, z15);
                zzaxVarZze = zzawVar5.zze();
                this.zzJ = zzaxVarZze;
                if (!zzaxVarZze.equals(zzaxVar2)) {
                    this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                        @Override // com.google.android.gms.internal.ads.zzdn
                        public final /* synthetic */ void zza(Object obj13) {
                            this.zza.zzN((zzaz) obj13);
                        }
                    });
                }
                this.zzn.zze();
                boolean z28 = zzlfVar2.zzp;
                boolean z29 = zzlfVar.zzp;
            }
            zzbbVar2 = zzbbVar;
            j2 = 0;
            zzbfVarZzq5 = zzfVar.zzq();
            if (zzbfVarZzq5.zzg()) {
                z8 = false;
            } else {
                z8 = false;
            }
            zZzg = zzbbVar2.zzq().zzg();
            zzaw zzawVar6 = new zzaw();
            zzawVar6.zzd(zzaxVar4);
            boolean z114 = !zZzx2;
            zzawVar6.zzb(4, z114);
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            zzawVar6.zzb(5, z9);
            if (z7) {
                z10 = false;
            } else {
                z10 = false;
            }
            zzawVar6.zzb(6, z10);
            if (zZzg) {
                z11 = false;
            } else {
                z11 = false;
            }
            zzawVar6.zzb(7, z11);
            if (r4 != 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzawVar6.zzb(8, z12);
            if (zZzg) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzawVar6.zzb(9, z13);
            zzawVar6.zzb(10, z114);
            if (z6) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzawVar6.zzb(11, z14);
            if (z6) {
                i13 = 12;
                z15 = false;
            } else {
                i13 = 12;
                z15 = false;
            }
            zzawVar6.zzb(i13, z15);
            zzaxVarZze = zzawVar6.zze();
            this.zzJ = zzaxVarZze;
            if (!zzaxVarZze.equals(zzaxVar2)) {
                this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj13) {
                        this.zza.zzN((zzaz) obj13);
                    }
                });
            }
            this.zzn.zze();
            boolean z210 = zzlfVar2.zzp;
            boolean z211 = zzlfVar.zzp;
        }
        zzaxVar2 = zzaxVar;
        zzbfVarZzq3 = zzfVar.zzq();
        if (zzbfVarZzq3.zzg()) {
            i12 = -1;
            r15 = 0;
            z7 = false;
        } else {
            int iZzs6 = zzfVar.zzs();
            zzfVar.zzl();
            zzfVar.zzm();
            r15 = 0;
            r15 = 0;
            iZzi = zzbfVarZzq3.zzi(iZzs6, 0, false);
            i12 = -1;
            if (iZzi != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        Zzq = zzfVar.zzq();
        if (Zzq.zzg()) {
            r4 = r15;
        } else {
            iZzs = zzfVar.zzs();
            zzfVar.zzl();
            zzfVar.zzm();
            if (Zzq.zzh(iZzs, r15, r15) != i12) {
                r4 = 1;
            } else {
                r4 = r15;
            }
        }
        zzbfVarZzq4 = zzfVar.zzq();
        if (!zzbfVarZzq4.zzg()) {
            zzbbVar2 = zzbbVar;
            j2 = 0;
            if (zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb()) {
            }
            zzbfVarZzq5 = zzfVar.zzq();
            if (zzbfVarZzq5.zzg()) {
                z8 = false;
            } else {
                z8 = false;
            }
            zZzg = zzbbVar2.zzq().zzg();
            zzaw zzawVar7 = new zzaw();
            zzawVar7.zzd(zzaxVar4);
            boolean z115 = !zZzx2;
            zzawVar7.zzb(4, z115);
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            zzawVar7.zzb(5, z9);
            if (z7) {
                z10 = false;
            } else {
                z10 = false;
            }
            zzawVar7.zzb(6, z10);
            if (zZzg) {
                z11 = false;
            } else {
                z11 = false;
            }
            zzawVar7.zzb(7, z11);
            if (r4 != 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzawVar7.zzb(8, z12);
            if (zZzg) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzawVar7.zzb(9, z13);
            zzawVar7.zzb(10, z115);
            if (z6) {
                z14 = false;
            } else {
                z14 = false;
            }
            zzawVar7.zzb(11, z14);
            if (z6) {
                i13 = 12;
                z15 = false;
            } else {
                i13 = 12;
                z15 = false;
            }
            zzawVar7.zzb(i13, z15);
            zzaxVarZze = zzawVar7.zze();
            this.zzJ = zzaxVarZze;
            if (!zzaxVarZze.equals(zzaxVar2)) {
                this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                    @Override // com.google.android.gms.internal.ads.zzdn
                    public final /* synthetic */ void zza(Object obj13) {
                        this.zza.zzN((zzaz) obj13);
                    }
                });
            }
            this.zzn.zze();
            boolean z212 = zzlfVar2.zzp;
            boolean z213 = zzlfVar.zzp;
        }
        zzbbVar2 = zzbbVar;
        j2 = 0;
        zzbfVarZzq5 = zzfVar.zzq();
        if (zzbfVarZzq5.zzg()) {
            z8 = false;
        } else {
            z8 = false;
        }
        zZzg = zzbbVar2.zzq().zzg();
        zzaw zzawVar8 = new zzaw();
        zzawVar8.zzd(zzaxVar4);
        boolean z116 = !zZzx2;
        zzawVar8.zzb(4, z116);
        if (z6) {
            z9 = false;
        } else {
            z9 = false;
        }
        zzawVar8.zzb(5, z9);
        if (z7) {
            z10 = false;
        } else {
            z10 = false;
        }
        zzawVar8.zzb(6, z10);
        if (zZzg) {
            z11 = false;
        } else {
            z11 = false;
        }
        zzawVar8.zzb(7, z11);
        if (r4 != 0) {
            z12 = false;
        } else {
            z12 = false;
        }
        zzawVar8.zzb(8, z12);
        if (zZzg) {
            z13 = false;
        } else {
            z13 = false;
        }
        zzawVar8.zzb(9, z13);
        zzawVar8.zzb(10, z116);
        if (z6) {
            z14 = false;
        } else {
            z14 = false;
        }
        zzawVar8.zzb(11, z14);
        if (z6) {
            i13 = 12;
            z15 = false;
        } else {
            i13 = 12;
            z15 = false;
        }
        zzawVar8.zzb(i13, z15);
        zzaxVarZze = zzawVar8.zze();
        this.zzJ = zzaxVarZze;
        if (!zzaxVarZze.equals(zzaxVar2)) {
            this.zzn.zzd(13, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjg
                @Override // com.google.android.gms.internal.ads.zzdn
                public final /* synthetic */ void zza(Object obj13) {
                    this.zza.zzN((zzaz) obj13);
                }
            });
        }
        this.zzn.zze();
        boolean z214 = zzlfVar2.zzp;
        boolean z215 = zzlfVar.zzp;
    }

    private static long zzae(zzlf zzlfVar) {
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        zzbf zzbfVar = zzlfVar.zza;
        zzbfVar.zzo(zzlfVar.zzb.zza, zzbdVar);
        long j = zzlfVar.zzc;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L).zzl;
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0097  */
    private final zzlf zzaf(zzlf zzlfVar, zzbf zzbfVar, Pair pair) {
        boolean z;
        zzgmd.zza(zzbfVar.zzg() || pair != null);
        zzbf zzbfVar2 = zzlfVar.zza;
        long jZzab = zzab(zzlfVar);
        zzlf zzlfVarZzd = zzlfVar.zzd(zzbfVar);
        if (zzbfVar.zzg()) {
            zzuu zzuuVarZzb = zzlf.zzb();
            long jZzq = zzep.zzq(this.zzY);
            zzlf zzlfVarZzh = zzlfVarZzd.zzc(zzuuVarZzb, jZzq, jZzq, jZzq, 0L, zzwv.zza, this.zzb, zzgpe.zzi()).zzh(zzuuVarZzb);
            zzlfVarZzh.zzq = zzlfVarZzh.zzs;
            return zzlfVarZzh;
        }
        zzuu zzuuVar = zzlfVarZzd.zzb;
        Object obj = zzuuVar.zza;
        String str = zzep.zza;
        boolean zEquals = obj.equals(pair.first);
        zzuu zzuuVar2 = !zEquals ? new zzuu(pair.first, -1L) : zzuuVar;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzq2 = zzep.zzq(jZzab);
        if (zzbfVar2.zzg()) {
            z = true;
        } else {
            zzbd zzbdVar = this.zzp;
            zzbfVar2.zzo(obj, zzbdVar);
            if (zEquals && jZzq2 - jLongValue == 1) {
                zzbd zzbdVarZzo = zzbfVar2.zzo(obj, zzbdVar);
                z = true;
                if (jZzq2 == zzbdVarZzo.zzd) {
                    jZzq2--;
                }
            } else {
                z = true;
            }
        }
        if (!zEquals || jLongValue < jZzq2) {
            zzgmd.zzh(zzuuVar2.zzb() ^ z);
            zzuu zzuuVar3 = zzuuVar2;
            zzlf zzlfVarZzh2 = zzlfVarZzd.zzc(zzuuVar3, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? zzwv.zza : zzlfVarZzd.zzh, !zEquals ? this.zzb : zzlfVarZzd.zzi, !zEquals ? zzgpe.zzi() : zzlfVarZzd.zzj).zzh(zzuuVar3);
            zzlfVarZzh2.zzq = jLongValue;
            return zzlfVarZzh2;
        }
        if (jLongValue != jZzq2) {
            zzgmd.zzh(zzuuVar2.zzb() ^ z);
            long jMax = Math.max(0L, zzlfVarZzd.zzr - (jLongValue - jZzq2));
            long j = zzlfVarZzd.zzq;
            if (zzlfVarZzd.zzk.equals(zzuuVar)) {
                j = jLongValue + jMax;
            }
            zzlf zzlfVarZzc = zzlfVarZzd.zzc(zzuuVar2, jLongValue, jLongValue, jLongValue, jMax, zzlfVarZzd.zzh, zzlfVarZzd.zzi, zzlfVarZzd.zzj);
            zzlfVarZzc.zzq = j;
            return zzlfVarZzc;
        }
        int iZze = zzbfVar.zze(zzlfVarZzd.zzk.zza);
        if (iZze != -1) {
            zzbd zzbdVar2 = this.zzp;
            if (zzbfVar.zzd(iZze, zzbdVar2, false).zzc == zzbfVar.zzo(zzuuVar2.zza, zzbdVar2).zzc) {
                return zzlfVarZzd;
            }
        }
        Object obj2 = zzuuVar2.zza;
        zzbd zzbdVar3 = this.zzp;
        zzbfVar.zzo(obj2, zzbdVar3);
        long jZzh = zzuuVar2.zzb() ? zzbdVar3.zzh(zzuuVar2.zzb, zzuuVar2.zzc) : zzbdVar3.zzd;
        zzuu zzuuVar4 = zzuuVar2;
        zzlf zzlfVarZzh3 = zzlfVarZzd.zzc(zzuuVar4, zzlfVarZzd.zzs, zzlfVarZzd.zzs, zzlfVarZzd.zzd, jZzh - zzlfVarZzd.zzs, zzlfVarZzd.zzh, zzlfVarZzd.zzi, zzlfVarZzd.zzj).zzh(zzuuVar4);
        zzlfVarZzh3.zzq = jZzh;
        return zzlfVarZzh3;
    }

    private static zzlf zzag(zzlf zzlfVar, int i) {
        zzlf zzlfVarZze = zzlfVar.zze(i);
        return (i == 1 || i == 4) ? zzlfVarZze.zzg(false) : zzlfVarZze;
    }

    private final Pair zzah(zzbf zzbfVar, int i, long j) {
        if (zzbfVar.zzg()) {
            this.zzX = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.zzY = j;
            return null;
        }
        if (i == -1 || i >= zzbfVar.zza()) {
            i = zzbfVar.zzk(false);
            long j2 = zzbfVar.zzb(i, this.zza, 0L).zzl;
            j = zzep.zzp(0L);
        }
        return zzbfVar.zzm(this.zza, this.zzp, i, zzep.zzq(j));
    }

    private final long zzai(zzbf zzbfVar, zzuu zzuuVar, long j) {
        zzbfVar.zzo(zzuuVar.zza, this.zzp);
        return j;
    }

    private final zzlj zzaj(zzli zzliVar) {
        int iZzaa = zzaa(this.zzW);
        zzbf zzbfVar = this.zzW.zza;
        if (iZzaa == -1) {
            iZzaa = 0;
        }
        zzdc zzdcVar = this.zzv;
        zzkh zzkhVar = this.zzm;
        return new zzlj(zzkhVar, zzliVar, zzbfVar, iZzaa, zzdcVar, zzkhVar.zzn());
    }

    private final void zzak(Object obj) {
        Object obj2 = this.zzL;
        boolean z = false;
        if (obj2 != null && obj2 != obj) {
            z = true;
        }
        boolean zZzl = this.zzm.zzl(obj, z ? this.zzA : -9223372036854775807L);
        if (z) {
            Object obj3 = this.zzL;
            Surface surface = this.zzM;
            if (obj3 == surface) {
                surface.release();
                this.zzM = null;
            }
        }
        this.zzL = obj;
        if (zZzl) {
            return;
        }
        zzP(zzib.zzc(new zzki(3), PointerIconCompat.TYPE_HELP));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzal, reason: merged with bridge method [inline-methods] */
    public final void zzS(final int i, final int i2) {
        if (i == this.zzO.zza() && i2 == this.zzO.zzb()) {
            return;
        }
        this.zzO = new zzeh(i, i2);
        zzds zzdsVar = this.zzn;
        zzdsVar.zzd(24, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjh
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzju.zzd;
                ((zzaz) obj).zzu(i, i2);
            }
        });
        zzdsVar.zze();
        zzao(2, 14, new zzeh(i, i2));
    }

    private final void zzam() {
        int iZzh = zzh();
        if (iZzh != 2 && iZzh != 3) {
            this.zzy.zza(false);
            this.zzz.zza(false);
        } else {
            zzan();
            boolean z = this.zzW.zzp;
            this.zzy.zza(zzk());
            this.zzz.zza(zzk());
        }
    }

    private final void zzan() {
        this.zze.zzd();
        Looper looper = this.zzt;
        if (Thread.currentThread() != looper.getThread()) {
            Object[] objArr = {Thread.currentThread().getName(), looper.getThread().getName()};
            String str = zzep.zza;
            String str2 = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", objArr);
            if (this.zzS) {
                throw new IllegalStateException(str2);
            }
            zzdt.zzd("ExoPlayerImpl", str2, this.zzT ? null : new IllegalStateException());
            this.zzT = true;
        }
    }

    private final void zzao(int i, int i2, Object obj) {
        zzln[] zzlnVarArr = this.zzh;
        int length = zzlnVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzln zzlnVar = zzlnVarArr[i3];
            if (i == -1 || zzlnVar.zza() == i) {
                zzlj zzljVarZzaj = zzaj(zzlnVar);
                zzljVarZzaj.zzb(i2);
                zzljVarZzaj.zzd(obj);
                zzljVarZzaj.zzg();
            }
        }
        zzln[] zzlnVarArr2 = this.zzi;
        int length2 = zzlnVarArr2.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzln zzlnVar2 = zzlnVarArr2[i4];
            if (zzlnVar2 != null && (i == -1 || zzlnVar2.zza() == i)) {
                zzlj zzljVarZzaj2 = zzaj(zzlnVar2);
                zzljVarZzaj2.zzb(i2);
                zzljVarZzaj2.zzd(obj);
                zzljVarZzaj2.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzA() {
        zzan();
        return zzab(this.zzW);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzB(float f) {
        zzan();
        String str = zzep.zza;
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzQ == fMax) {
            return;
        }
        this.zzQ = fMax;
        this.zzm.zzj(fMax);
        zzds zzdsVar = this.zzn;
        zzdsVar.zzd(22, new zzdn() { // from class: com.google.android.gms.internal.ads.zzjm
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i = zzju.zzd;
                ((zzaz) obj).zzr(fMax);
            }
        });
        zzdsVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzC(Surface surface) {
        zzan();
        zzak(surface);
        int i = surface == null ? 0 : -1;
        zzS(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzD(zzml zzmlVar) {
        this.zzs.zzv(zzmlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzE(zzml zzmlVar) {
        zzan();
        this.zzs.zzw(zzmlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final int zzF() {
        zzan();
        int length = this.zzh.length;
        return 2;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ac  */
    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzG(zzuw zzuwVar) {
        zzan();
        List listSingletonList = Collections.singletonList(zzuwVar);
        zzan();
        zzan();
        zzaa(this.zzW);
        zzu();
        this.zzD++;
        List list = this.zzq;
        if (!list.isEmpty()) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                list.remove(i);
            }
            this.zzZ = this.zzZ.zzg(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            zzlb zzlbVar = new zzlb((zzuw) listSingletonList.get(i2), this.zzr);
            arrayList.add(zzlbVar);
            list.add(i2, new zzjt(zzlbVar.zzb, zzlbVar.zza));
        }
        this.zzZ = this.zzZ.zzf(0, arrayList.size());
        zzll zzllVar = new zzll(list, this.zzZ);
        if (!zzllVar.zzg() && zzllVar.zza() < 0) {
            throw new zzw(zzllVar, -1, -9223372036854775807L);
        }
        int iZzk = zzllVar.zzk(false);
        zzlf zzlfVarZzaf = zzaf(this.zzW, zzllVar, zzah(zzllVar, iZzk, -9223372036854775807L));
        int i3 = zzlfVarZzaf.zze;
        if (i3 == 1) {
            i3 = 1;
        } else if (zzllVar.zzg()) {
            i3 = 4;
        } else if (iZzk != -1) {
            if (iZzk >= zzllVar.zza()) {
                i3 = 4;
            } else {
                i3 = 2;
            }
        }
        zzlf zzlfVarZzag = zzag(zzlfVarZzaf, i3);
        this.zzm.zzy(arrayList, iZzk, zzep.zzq(-9223372036854775807L), this.zzZ);
        zzad(zzlfVarZzag, 0, (this.zzW.zzb.zza.equals(zzlfVarZzag.zzb.zza) || this.zzW.zza.zzg()) ? false : true, 4, zzac(zzlfVarZzag), -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzim
    public final void zzH() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzep.zza;
        String strZza = zzal.zza();
        int length = String.valueOf(hexString).length();
        StringBuilder sb = new StringBuilder(length + 33 + String.valueOf(str).length() + 3 + String.valueOf(strZza).length() + 1);
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [AndroidXMedia3/1.8.0] [");
        sb.append(str);
        sb.append("] [");
        sb.append(strZza);
        sb.append("]");
        zzdt.zzb("ExoPlayerImpl", sb.toString());
        zzan();
        this.zzy.zza(false);
        this.zzz.zza(false);
        this.zzC.zzv();
        if (!this.zzm.zzm()) {
            zzds zzdsVar = this.zzn;
            zzdsVar.zzd(10, zzjl.zza);
            zzdsVar.zze();
        }
        this.zzn.zzf();
        this.zzk.zzl(null);
        zzza zzzaVar = this.zzu;
        zzmi zzmiVar = this.zzs;
        zzzaVar.zzg(zzmiVar);
        boolean z = this.zzW.zzp;
        zzlf zzlfVarZzag = zzag(this.zzW, 1);
        this.zzW = zzlfVarZzag;
        zzlf zzlfVarZzh = zzlfVarZzag.zzh(zzlfVarZzag.zzb);
        this.zzW = zzlfVarZzh;
        zzlfVarZzh.zzq = zzlfVarZzh.zzs;
        this.zzW.zzr = 0L;
        zzmiVar.zzy();
        Surface surface = this.zzM;
        if (surface != null) {
            surface.release();
            this.zzM = null;
        }
        int i = zzco.zza;
    }

    public final zzib zzI() {
        zzan();
        return this.zzW.zzf;
    }

    final /* synthetic */ void zzJ(zzaz zzazVar, zzs zzsVar) {
        zzazVar.zza(this.zzg, new zzay(zzsVar));
    }

    final /* synthetic */ void zzK(final zzke zzkeVar) {
        this.zzk.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO(zzkeVar);
            }
        });
    }

    final /* synthetic */ void zzL(int i, final int i2) {
        zzan();
        Integer numValueOf = Integer.valueOf(i2);
        zzao(1, 10, numValueOf);
        zzao(2, 10, numValueOf);
        zzdn zzdnVar = new zzdn() { // from class: com.google.android.gms.internal.ads.zzji
            @Override // com.google.android.gms.internal.ads.zzdn
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzju.zzd;
                ((zzaz) obj).zzq(i2);
            }
        };
        zzds zzdsVar = this.zzn;
        zzdsVar.zzd(21, zzdnVar);
        zzdsVar.zze();
    }

    final /* synthetic */ void zzM() {
        String str = zzep.zza;
        int iGenerateAudioSessionId = zzcb.zza(this.zzf).generateAudioSessionId();
        if (iGenerateAudioSessionId == -1) {
            iGenerateAudioSessionId = 0;
        }
        this.zzB.zzb(Integer.valueOf(iGenerateAudioSessionId));
    }

    final /* synthetic */ void zzN(zzaz zzazVar) {
        zzazVar.zzg(this.zzJ);
    }

    final /* synthetic */ void zzO(zzke zzkeVar) {
        boolean z;
        int i = this.zzD - zzkeVar.zzb;
        this.zzD = i;
        boolean z2 = true;
        if (zzkeVar.zzc) {
            this.zzE = zzkeVar.zzd;
            this.zzF = true;
        }
        if (i == 0) {
            zzbf zzbfVar = zzkeVar.zza.zza;
            if (!this.zzW.zza.zzg() && zzbfVar.zzg()) {
                this.zzX = -1;
                this.zzY = 0L;
            }
            if (!zzbfVar.zzg()) {
                List listZzw = ((zzll) zzbfVar).zzw();
                int size = listZzw.size();
                List list = this.zzq;
                zzgmd.zzh(size == list.size());
                for (int i2 = 0; i2 < listZzw.size(); i2++) {
                    ((zzjt) list.get(i2)).zzc((zzbf) listZzw.get(i2));
                }
            }
            long j = -9223372036854775807L;
            if (this.zzF) {
                if (zzkeVar.zza.zzb.equals(this.zzW.zzb) && zzkeVar.zza.zzd == this.zzW.zzs) {
                    z2 = false;
                }
                if (z2) {
                    if (zzbfVar.zzg() || zzkeVar.zza.zzb.zzb()) {
                        j = zzkeVar.zza.zzd;
                    } else {
                        zzlf zzlfVar = zzkeVar.zza;
                        zzuu zzuuVar = zzlfVar.zzb;
                        long j2 = zzlfVar.zzd;
                        zzai(zzbfVar, zzuuVar, j2);
                        j = j2;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            this.zzF = false;
            zzad(zzkeVar.zza, 1, z, this.zzE, j, -1, false);
        }
    }

    final /* synthetic */ void zzQ(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzak(surface);
        this.zzM = surface;
    }

    final /* synthetic */ void zzR(Object obj) {
        zzak(null);
    }

    final /* synthetic */ zzds zzT() {
        return this.zzn;
    }

    final /* synthetic */ zzmi zzU() {
        return this.zzs;
    }

    final /* synthetic */ zzdb zzV() {
        return this.zzB;
    }

    final /* synthetic */ Object zzW() {
        return this.zzL;
    }

    final /* synthetic */ boolean zzX() {
        return this.zzR;
    }

    final /* synthetic */ void zzY(boolean z) {
        this.zzR = z;
    }

    @Override // com.google.android.gms.internal.ads.zzf
    protected final void zzc(int i, long j, int i2, boolean z) {
        zzan();
        if (i == -1) {
            return;
        }
        zzgmd.zza(i >= 0);
        zzbf zzbfVar = this.zzW.zza;
        if (zzbfVar.zzg() || i < zzbfVar.zza()) {
            this.zzs.zzA();
            this.zzD++;
            if (zzx()) {
                zzdt.zzc("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzke zzkeVar = new zzke(this.zzW);
                zzkeVar.zza(1);
                this.zzl.zza(zzkeVar);
                return;
            }
            zzlf zzlfVarZzag = this.zzW;
            int i3 = zzlfVarZzag.zze;
            if (i3 == 3 || (i3 == 4 && !zzbfVar.zzg())) {
                zzlfVarZzag = zzag(this.zzW, 2);
            }
            int iZzs = zzs();
            zzlf zzlfVarZzaf = zzaf(zzlfVarZzag, zzbfVar, zzah(zzbfVar, i, j));
            this.zzm.zzf(zzbfVar, i, zzep.zzq(j));
            zzad(zzlfVarZzaf, 0, true, 1, zzac(zzlfVarZzaf), iZzs, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final Looper zzd() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzf(zzaz zzazVar) {
        zzan();
        this.zzn.zzc(zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzg() {
        zzan();
        zzlf zzlfVar = this.zzW;
        if (zzlfVar.zze != 1) {
            return;
        }
        zzlf zzlfVarZzf = zzlfVar.zzf(null);
        zzlf zzlfVarZzag = zzag(zzlfVarZzf, true != zzlfVarZzf.zza.zzg() ? 2 : 4);
        this.zzD++;
        this.zzm.zzd();
        zzad(zzlfVarZzag, 1, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzh() {
        zzan();
        return this.zzW.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzi() {
        zzan();
        return this.zzW.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzj(boolean z) {
        zzan();
        zzlf zzlfVar = this.zzW;
        int i = zzlfVar.zzn;
        int i2 = 0;
        if (i == 1) {
            if (z) {
                i = 1;
            } else {
                i = 1;
                i2 = 1;
            }
        }
        if (zzlfVar.zzl == z && i == i2 && zzlfVar.zzm == 1) {
            return;
        }
        this.zzD++;
        boolean z2 = zzlfVar.zzp;
        zzlf zzlfVarZzi = zzlfVar.zzi(z, 1, i2);
        this.zzm.zze(z, 1, i2);
        zzad(zzlfVarZzi, 0, false, 5, -9223372036854775807L, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzk() {
        zzan();
        return this.zzW.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzl() {
        zzan();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzm() {
        zzan();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzav zzn() {
        zzan();
        return this.zzW.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzo() {
        zzan();
        zzP(null);
        new zzco(zzgpe.zzi(), this.zzW.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbn zzp() {
        zzan();
        return this.zzW.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbf zzq() {
        zzan();
        return this.zzW.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzr() {
        zzan();
        if (this.zzW.zza.zzg()) {
            return 0;
        }
        zzlf zzlfVar = this.zzW;
        return zzlfVar.zza.zze(zzlfVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzs() {
        zzan();
        int iZzaa = zzaa(this.zzW);
        if (iZzaa == -1) {
            return 0;
        }
        return iZzaa;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzt() {
        zzan();
        if (!zzx()) {
            zzbf zzbfVarZzq = zzq();
            if (zzbfVarZzq.zzg()) {
                return -9223372036854775807L;
            }
            return zzep.zzp(zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzm);
        }
        zzlf zzlfVar = this.zzW;
        zzuu zzuuVar = zzlfVar.zzb;
        zzbf zzbfVar = zzlfVar.zza;
        Object obj = zzuuVar.zza;
        zzbd zzbdVar = this.zzp;
        zzbfVar.zzo(obj, zzbdVar);
        return zzep.zzp(zzbdVar.zzh(zzuuVar.zzb, zzuuVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzu() {
        zzan();
        return zzep.zzp(zzac(this.zzW));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzv() {
        zzan();
        if (zzx()) {
            zzlf zzlfVar = this.zzW;
            return zzlfVar.zzk.equals(zzlfVar.zzb) ? zzep.zzp(this.zzW.zzq) : zzt();
        }
        zzan();
        if (this.zzW.zza.zzg()) {
            return this.zzY;
        }
        zzlf zzlfVar2 = this.zzW;
        long j = 0;
        if (zzlfVar2.zzk.zzd != zzlfVar2.zzb.zzd) {
            return zzep.zzp(zzlfVar2.zza.zzb(zzs(), this.zza, 0L).zzm);
        }
        long j2 = zzlfVar2.zzq;
        if (this.zzW.zzk.zzb()) {
            zzlf zzlfVar3 = this.zzW;
            zzlfVar3.zza.zzo(zzlfVar3.zzk.zza, this.zzp).zzc(this.zzW.zzk.zzb);
        } else {
            j = j2;
        }
        zzlf zzlfVar4 = this.zzW;
        zzai(zzlfVar4.zza, zzlfVar4.zzk, j);
        return zzep.zzp(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzw() {
        zzan();
        return zzep.zzp(this.zzW.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzx() {
        zzan();
        return this.zzW.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzy() {
        zzan();
        if (zzx()) {
            return this.zzW.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzz() {
        zzan();
        if (zzx()) {
            return this.zzW.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zze(zzaz zzazVar) {
        zzazVar.getClass();
        this.zzn.zzb(zzazVar);
    }
}
