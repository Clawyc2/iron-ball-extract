package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaiz implements zzada {
    public static final /* synthetic */ int zza = 0;
    private int zzA;
    private zzafz zzB;
    private final zzakg zzb;
    private final int zzc;
    private final zzeg zzd;
    private final zzeg zze;
    private final zzeg zzf;
    private final zzeg zzg;
    private final ArrayDeque zzh;
    private final zzajd zzi;
    private final List zzj;
    private zzgpe zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzo;
    private zzeg zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private long zzw;
    private zzadd zzx;
    private zzaiy[] zzy;
    private long[][] zzz;

    static {
        int i = zzaiv.zza;
    }

    @Deprecated
    public zzaiz() {
        this(zzakg.zza, 16);
    }

    static /* synthetic */ long zzg(zzaji zzajiVar, long j, long j2) {
        int iZzk = zzk(zzajiVar, j);
        return iZzk == -1 ? j2 : Math.min(zzajiVar.zzc[iZzk], j2);
    }

    private final void zzi() {
        this.zzl = 0;
        this.zzo = 0;
    }

    private final void zzj(long j) throws zzat {
        zzap zzapVar;
        int i;
        while (true) {
            ArrayDeque arrayDeque = this.zzh;
            if (arrayDeque.isEmpty() || ((zzeu) arrayDeque.peek()).zza != j) {
                break;
            }
            zzeu zzeuVar = (zzeu) arrayDeque.pop();
            if (zzeuVar.zzd == 1836019574) {
                zzeu zzeuVarZzd = zzeuVar.zzd(1835365473);
                new ArrayList();
                zzap zzapVarZze = zzeuVarZzd != null ? zzaik.zze(zzeuVarZzd) : null;
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                boolean z = this.zzA == 1;
                zzads zzadsVar = new zzads();
                zzev zzevVarZzc = zzeuVar.zzc(1969517665);
                if (zzevVarZzc != null) {
                    zzap zzapVarZzc = zzaik.zzc(zzevVarZzc);
                    zzadsVar.zza(zzapVarZzc);
                    zzapVar = zzapVarZzc;
                } else {
                    zzapVar = null;
                }
                zzev zzevVarZzc2 = zzeuVar.zzc(1836476516);
                zzevVarZzc2.getClass();
                zzap zzapVar2 = new zzap(-9223372036854775807L, zzaik.zzd(zzevVarZzc2.zza));
                int i3 = this.zzc;
                List listZzb = zzaik.zzb(zzeuVar, zzadsVar, -9223372036854775807L, null, 1 == (i3 & 1), z, zzaiw.zza, false);
                String strZza = zzaiu.zza(listZzb);
                int i4 = 0;
                int i5 = 0;
                long j2 = -9223372036854775807L;
                int size = -1;
                while (i4 < listZzb.size()) {
                    zzaji zzajiVar = (zzaji) listZzb.get(i4);
                    int i6 = i2;
                    if (zzajiVar.zzb == 0) {
                        i = i5;
                    } else {
                        zzajf zzajfVar = zzajiVar.zza;
                        zzadd zzaddVar = this.zzx;
                        i = i5 + 1;
                        int i7 = zzajfVar.zzb;
                        zzaiy zzaiyVar = new zzaiy(zzajfVar, zzajiVar, zzaddVar.zzu(i5, i7));
                        long j3 = zzajfVar.zze;
                        if (j3 == -9223372036854775807L) {
                            j3 = zzajiVar.zzh;
                        }
                        zzaem zzaemVar = zzaiyVar.zzc;
                        long jMax = Math.max(j2, j3);
                        zzv zzvVar = zzajfVar.zzg;
                        String str = zzvVar.zzo;
                        int i8 = "audio/true-hd".equals(str) ? zzajiVar.zze * 16 : zzajiVar.zze + 30;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzn(i8);
                        if (i7 == 2) {
                            int i9 = zzvVar.zzf;
                            if ((i3 & 8) != 0) {
                                i9 |= size == -1 ? 1 : 2;
                            }
                            zztVarZza.zzg(i9);
                            i7 = 2;
                        }
                        zzait.zzb(i7, zzadsVar, zztVarZza);
                        zzap zzapVar3 = zzvVar.zzl;
                        List list = this.zzj;
                        zzap[] zzapVarArr = new zzap[3];
                        zzapVarArr[i6] = list.isEmpty() ? null : new zzap(list);
                        zzapVarArr[1] = zzapVar;
                        zzapVarArr[2] = zzapVar2;
                        zzait.zza(i7, zzapVarZze, zztVarZza, zzapVar3, zzapVarArr);
                        zztVarZza.zzl(strZza);
                        if (Objects.equals(str, "audio/mpeg")) {
                            zzaiyVar.zzf = zztVarZza.zzM();
                        } else {
                            zzaemVar.zzu(zztVarZza.zzM());
                        }
                        if (i7 == 2 && size == -1) {
                            size = arrayList.size();
                        }
                        arrayList.add(zzaiyVar);
                        j2 = jMax;
                    }
                    i4++;
                    listZzb = listZzb;
                    i2 = i6;
                    i5 = i;
                    arrayDeque = arrayDeque;
                }
                ArrayDeque arrayDeque2 = arrayDeque;
                int i10 = -1;
                zzaiy[] zzaiyVarArr = (zzaiy[]) arrayList.toArray(new zzaiy[i2]);
                this.zzy = zzaiyVarArr;
                int length = zzaiyVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i11 = 0; i11 < zzaiyVarArr.length; i11++) {
                    jArr[i11] = new long[zzaiyVarArr[i11].zzb.zzb];
                    jArr2[i11] = zzaiyVarArr[i11].zzb.zzf[0];
                }
                long j4 = 0;
                int i12 = 0;
                while (i12 < zzaiyVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i13 = i10;
                    for (int i14 = 0; i14 < zzaiyVarArr.length; i14++) {
                        if (!zArr[i14]) {
                            long j6 = jArr2[i14];
                            if (j6 <= j5) {
                                i13 = i14;
                                j5 = j6;
                            }
                        }
                    }
                    int i15 = iArr[i13];
                    long[] jArr3 = jArr[i13];
                    jArr3[i15] = j4;
                    zzaji zzajiVar2 = zzaiyVarArr[i13].zzb;
                    zzaiy[] zzaiyVarArr2 = zzaiyVarArr;
                    boolean[] zArr2 = zArr;
                    j4 += (long) zzajiVar2.zzd[i15];
                    int i16 = i15 + 1;
                    iArr[i13] = i16;
                    if (i16 < jArr3.length) {
                        jArr2[i13] = zzajiVar2.zzf[i16];
                    } else {
                        zArr2[i13] = true;
                        i12++;
                    }
                    zzaiyVarArr = zzaiyVarArr2;
                    zArr = zArr2;
                    i10 = -1;
                }
                this.zzz = jArr;
                this.zzx.zzv();
                this.zzx.zzw(new zzaix(j2, this.zzy, size));
                arrayDeque2.clear();
                this.zzl = 2;
            } else if (!arrayDeque.isEmpty()) {
                ((zzeu) arrayDeque.peek()).zzb(zzeuVar);
            }
        }
        if (this.zzl != 2) {
            zzi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(zzaji zzajiVar, long j) {
        int iZza = zzajiVar.zza(j);
        return iZza == -1 ? zzajiVar.zzb(j) : iZza;
    }

    private static int zzl(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzaeh zzaehVarZzb = zzaje.zzb(zzadbVar, (this.zzc & 2) != 0);
        this.zzk = zzaehVarZzb != null ? zzgpe.zzj(zzaehVarZzb) : zzgpe.zzi();
        return zzaehVarZzb == null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        if ((this.zzc & 16) == 0) {
            zzaddVar = new zzakj(zzaddVar, this.zzb);
        }
        this.zzx = zzaddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzh.clear();
        this.zzo = 0;
        this.zzq = -1;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = false;
        if (j == 0) {
            if (this.zzl != 3) {
                zzi();
                return;
            } else {
                this.zzi.zza();
                this.zzj.clear();
                return;
            }
        }
        for (zzaiy zzaiyVar : this.zzy) {
            zzaji zzajiVar = zzaiyVar.zzb;
            int iZza = zzajiVar.zza(j2);
            if (iZza == -1) {
                iZza = zzajiVar.zzb(j2);
            }
            zzaiyVar.zze = iZza;
            zzaen zzaenVar = zzaiyVar.zzd;
            if (zzaenVar != null) {
                zzaenVar.zza();
            }
        }
    }

    public zzaiz(zzakg zzakgVar, int i) {
        this.zzb = zzakgVar;
        this.zzc = i;
        this.zzk = zzgpe.zzi();
        this.zzl = (i & 4) != 0 ? 3 : 0;
        this.zzi = new zzajd();
        this.zzj = new ArrayList();
        this.zzg = new zzeg(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzeg(zzfm.zza);
        this.zze = new zzeg(6);
        this.zzf = new zzeg();
        this.zzq = -1;
        this.zzx = zzadd.zza;
        this.zzy = new zzaiy[0];
    }

    /* JADX WARN: Code duplicated, block: B:318:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0085  */
    /* JADX WARN: Code duplicated, block: B:37:0x0094  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        long j;
        long j2;
        zzaem zzaemVar;
        int i;
        int i2;
        int iZzb;
        boolean z;
        boolean z2;
        while (true) {
            int i3 = this.zzl;
            long j3 = 0;
            if (i3 == 0) {
                if (this.zzo == 0) {
                    zzeg zzegVar = this.zzg;
                    if (!zzadbVar.zzb(zzegVar.zzi(), 0, 8, true)) {
                        if (this.zzA != 2 || (this.zzc & 2) == 0) {
                            return -1;
                        }
                        zzaem zzaemVarZzu = this.zzx.zzu(0, 4);
                        zzafz zzafzVar = this.zzB;
                        zzap zzapVar = zzafzVar == null ? null : new zzap(-9223372036854775807L, zzafzVar);
                        zzt zztVar = new zzt();
                        zztVar.zzk(zzapVar);
                        zzaemVarZzu.zzu(zztVar.zzM());
                        this.zzx.zzv();
                        this.zzx.zzw(new zzaec(-9223372036854775807L, 0L));
                        return -1;
                    }
                    this.zzo = 8;
                    zzegVar.zzh(0);
                    this.zzn = zzegVar.zzz();
                    this.zzm = zzegVar.zzB();
                }
                long j4 = this.zzn;
                if (j4 == 1) {
                    zzeg zzegVar2 = this.zzg;
                    zzadbVar.zzc(zzegVar2.zzi(), 8, 8);
                    this.zzo += 8;
                    this.zzn = zzegVar2.zzJ();
                } else if (j4 == 0) {
                    long jZzo = zzadbVar.zzo();
                    if (jZzo == -1) {
                        zzeu zzeuVar = (zzeu) this.zzh.peek();
                        jZzo = zzeuVar != null ? zzeuVar.zza : -1L;
                    }
                    if (jZzo != -1) {
                        this.zzn = (jZzo - zzadbVar.zzn()) + ((long) this.zzo);
                    }
                }
                long j5 = this.zzn;
                int i4 = this.zzo;
                long j6 = i4;
                if (j5 < j6) {
                    if (this.zzm != 1718773093 || i4 != 8) {
                        throw zzat.zzc("Atom size less than header length (unsupported).");
                    }
                    this.zzn = j6;
                    i4 = 8;
                }
                int i5 = this.zzm;
                if (i5 == 1836019574 || i5 == 1953653099 || i5 == 1835297121 || i5 == 1835626086 || i5 == 1937007212 || i5 == 1701082227 || i5 == 1835365473 || i5 == 1635284069) {
                    long jZzn = zzadbVar.zzn();
                    long j7 = this.zzn;
                    long j8 = jZzn + j7;
                    long j9 = this.zzo;
                    if (j7 != j9 && this.zzm == 1835365473) {
                        zzeg zzegVar3 = this.zzf;
                        zzegVar3.zza(8);
                        zzadbVar.zzi(zzegVar3.zzi(), 0, 8);
                        zzaik.zzf(zzegVar3);
                        zzadbVar.zzf(zzegVar3.zzg());
                        zzadbVar.zzl();
                    }
                    long j10 = j8 - j9;
                    this.zzh.push(new zzeu(this.zzm, j10));
                    if (this.zzn == this.zzo) {
                        zzj(j10);
                    } else {
                        zzi();
                    }
                } else if (i5 == 1835296868 || i5 == 1836476516 || i5 == 1751411826 || i5 == 1937011556 || i5 == 1937011827 || i5 == 1937011571 || i5 == 1668576371 || i5 == 1701606260 || i5 == 1937011555 || i5 == 1937011578 || i5 == 1937013298 || i5 == 1937007471 || i5 == 1668232756 || i5 == 1953196132 || i5 == 1718909296 || i5 == 1969517665 || i5 == 1801812339 || i5 == 1768715124) {
                    zzgmd.zzh(i4 == 8);
                    zzgmd.zzh(this.zzn <= 2147483647L);
                    zzeg zzegVar4 = new zzeg((int) this.zzn);
                    System.arraycopy(this.zzg.zzi(), 0, zzegVar4.zzi(), 0, 8);
                    this.zzp = zzegVar4;
                    this.zzl = 1;
                } else {
                    long jZzn2 = zzadbVar.zzn();
                    long j11 = this.zzo;
                    long j12 = jZzn2 - j11;
                    if (this.zzm == 1836086884) {
                        this.zzB = new zzafz(0L, j12, -9223372036854775807L, j12 + j11, this.zzn - j11);
                    }
                    this.zzp = null;
                    this.zzl = 1;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.zzi.zzb(zzadbVar, zzaeaVar, this.zzj);
                        if (zzaeaVar.zza == 0) {
                            zzi();
                        }
                        return 1;
                    }
                    long jZzn3 = zzadbVar.zzn();
                    int i6 = this.zzq;
                    if (i6 == -1) {
                        int i7 = -1;
                        int i8 = -1;
                        boolean z3 = true;
                        boolean z4 = true;
                        long j13 = Long.MAX_VALUE;
                        long j14 = Long.MAX_VALUE;
                        long j15 = Long.MAX_VALUE;
                        int i9 = 0;
                        j2 = 262144;
                        while (true) {
                            zzaiy[] zzaiyVarArr = this.zzy;
                            if (i9 >= zzaiyVarArr.length) {
                                break;
                            }
                            zzaiy zzaiyVar = zzaiyVarArr[i9];
                            int i10 = zzaiyVar.zze;
                            zzaji zzajiVar = zzaiyVar.zzb;
                            long j16 = j3;
                            if (i10 != zzajiVar.zzb) {
                                long j17 = zzajiVar.zzc[i10];
                                long[][] jArr = this.zzz;
                                jArr.getClass();
                                long j18 = jArr[i9][i10];
                                long j19 = j17 - jZzn3;
                                boolean z5 = j19 < j16 || j19 >= 262144;
                                if (z5) {
                                    z = z4;
                                } else {
                                    if (z4) {
                                        z4 = z5;
                                        i8 = i9;
                                        j14 = j18;
                                        j15 = j19;
                                    } else {
                                        z = false;
                                    }
                                    if (j18 < j13) {
                                        z3 = z5;
                                        i7 = i9;
                                        j13 = j18;
                                    }
                                }
                                if (z5 != z || j19 >= j15) {
                                    z4 = z;
                                } else {
                                    z4 = z5;
                                    i8 = i9;
                                    j14 = j18;
                                    j15 = j19;
                                }
                                if (j18 < j13) {
                                    z3 = z5;
                                    i7 = i9;
                                    j13 = j18;
                                }
                            }
                            i9++;
                            j3 = j16;
                        }
                        j = j3;
                        i6 = (j13 == Long.MAX_VALUE || !z3 || j14 < j13 + 10485760) ? i8 : i7;
                        this.zzq = i6;
                        if (i6 == -1) {
                            return -1;
                        }
                    } else {
                        j = 0;
                        j2 = 262144;
                    }
                    zzaiy zzaiyVar2 = this.zzy[i6];
                    zzaem zzaemVar2 = zzaiyVar2.zzc;
                    int i11 = zzaiyVar2.zze;
                    zzaji zzajiVar2 = zzaiyVar2.zzb;
                    long j20 = zzajiVar2.zzc[i11] + this.zzw;
                    int[] iArr = zzajiVar2.zzd;
                    int i12 = iArr[i11];
                    zzaen zzaenVar = zzaiyVar2.zzd;
                    zzaem zzaemVar3 = zzaemVar2;
                    int i13 = 0;
                    long j21 = (j20 - jZzn3) + ((long) this.zzr);
                    if (j21 < j || j21 >= j2) {
                        zzaeaVar.zza = j20;
                        return 1;
                    }
                    zzajf zzajfVar = zzaiyVar2.zza;
                    if (zzajfVar.zzh == 1) {
                        j21 += 8;
                        i12 -= 8;
                    }
                    int i14 = i12;
                    zzadbVar.zzf((int) j21);
                    zzv zzvVar = zzajfVar.zzg;
                    String str = zzvVar.zzo;
                    if (!Objects.equals(str, "video/avc")) {
                        Objects.equals(str, "video/hevc");
                    }
                    this.zzu = true;
                    int i15 = zzajfVar.zzk;
                    if (i15 == 0) {
                        zzaemVar = zzaemVar3;
                        if ("audio/ac4".equals(str)) {
                            if (this.zzs == 0) {
                                zzeg zzegVar5 = this.zzf;
                                zzace.zzc(i14, zzegVar5);
                                zzaemVar.zzz(zzegVar5, 7);
                                this.zzs += 7;
                            }
                            i14 += 7;
                        } else if (zzaiyVar2.zzf != null && Objects.equals(str, "audio/mpeg")) {
                            zzv zzvVarZzM = zzaiyVar2.zzf;
                            zzeg zzegVar6 = this.zzf;
                            zzegVar6.zza(4);
                            zzadbVar.zzi(zzegVar6.zzi(), 0, 4);
                            zzadbVar.zzl();
                            zzadw zzadwVar = new zzadw();
                            if (zzadwVar.zza(zzegVar6.zzB()) && !Objects.equals(zzvVarZzM.zzo, zzadwVar.zzb)) {
                                zzt zztVarZza = zzvVarZzM.zza();
                                String str2 = zzadwVar.zzb;
                                str2.getClass();
                                zztVarZza.zzm(str2);
                                zzvVarZzM = zztVarZza.zzM();
                            }
                            zzaemVar.zzu(zzvVarZzM);
                            zzaiyVar2.zzf = null;
                        } else if (zzaenVar != null) {
                            zzaenVar.zzb(zzadbVar);
                        }
                        while (true) {
                            int i16 = this.zzs;
                            if (i16 >= i14) {
                                break;
                            }
                            int iZzy = zzaemVar.zzy(zzadbVar, i14 - i16, false);
                            this.zzr += iZzy;
                            this.zzs += iZzy;
                            this.zzt -= iZzy;
                        }
                    } else {
                        zzeg zzegVar7 = this.zze;
                        byte[] bArrZzi = zzegVar7.zzi();
                        bArrZzi[0] = 0;
                        bArrZzi[1] = 0;
                        bArrZzi[2] = 0;
                        int i17 = 4 - i15;
                        i14 += i17;
                        while (this.zzs < i14) {
                            int i18 = this.zzt;
                            if (i18 == 0) {
                                if (this.zzu || zzfm.zzb(zzvVar) + i15 > iArr[i11] - this.zzr) {
                                    i2 = i15;
                                    iZzb = i13;
                                } else {
                                    iZzb = zzfm.zzb(zzvVar);
                                    i2 = i15 + iZzb;
                                }
                                zzadbVar.zzc(bArrZzi, i17, i2);
                                this.zzr += i2;
                                int i19 = i13;
                                zzegVar7.zzh(i19);
                                int iZzB = zzegVar7.zzB();
                                if (iZzB < 0) {
                                    throw zzat.zzb("Invalid NAL length", null);
                                }
                                this.zzt = iZzB - iZzb;
                                zzeg zzegVar8 = this.zzd;
                                zzegVar8.zzh(i19);
                                i = i15;
                                zzaem zzaemVar4 = zzaemVar3;
                                zzaemVar4.zzz(zzegVar8, 4);
                                this.zzs += 4;
                                if (iZzb > 0) {
                                    zzaemVar4.zzz(zzegVar7, iZzb);
                                    this.zzs += iZzb;
                                    if (zzfm.zzc(bArrZzi, 4, iZzb, zzvVar)) {
                                        this.zzu = true;
                                        zzaemVar3 = zzaemVar4;
                                        i15 = i;
                                    }
                                    i13 = 0;
                                }
                                zzaemVar3 = zzaemVar4;
                            } else {
                                i = i15;
                                int iZzy2 = zzaemVar3.zzy(zzadbVar, i18, i13);
                                this.zzr += iZzy2;
                                this.zzs += iZzy2;
                                this.zzt -= iZzy2;
                            }
                            i15 = i;
                            i13 = 0;
                        }
                        zzaemVar = zzaemVar3;
                    }
                    int i20 = i14;
                    long j22 = zzajiVar2.zzf[i11];
                    int i21 = zzajiVar2.zzg[i11];
                    if (!this.zzu) {
                        i21 |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    }
                    int i22 = i21;
                    if (zzaenVar != null) {
                        zzaem zzaemVar5 = zzaemVar;
                        zzaenVar.zzc(zzaemVar5, j22, i22, i20, 0, null);
                        if (i11 + 1 == zzajiVar2.zzb) {
                            zzaenVar.zzd(zzaemVar5, null);
                        }
                    } else {
                        zzaemVar.zzx(j22, i22, i20, 0, null);
                    }
                    zzaiyVar2.zze++;
                    this.zzq = -1;
                    this.zzr = 0;
                    this.zzs = 0;
                    this.zzt = 0;
                    this.zzu = false;
                    return 0;
                }
                long j23 = this.zzn - ((long) this.zzo);
                long jZzn4 = zzadbVar.zzn() + j23;
                zzeg zzegVar9 = this.zzp;
                if (zzegVar9 != null) {
                    zzadbVar.zzc(zzegVar9.zzi(), this.zzo, (int) j23);
                    if (this.zzm == 1718909296) {
                        this.zzv = true;
                        zzegVar9.zzh(8);
                        int iZzl = zzl(zzegVar9.zzB());
                        if (iZzl == 0) {
                            zzegVar9.zzk(4);
                            do {
                                if (zzegVar9.zzd() <= 0) {
                                    iZzl = 0;
                                    break;
                                }
                                iZzl = zzl(zzegVar9.zzB());
                            } while (iZzl == 0);
                        }
                        this.zzA = iZzl;
                    } else {
                        ArrayDeque arrayDeque = this.zzh;
                        if (!arrayDeque.isEmpty()) {
                            ((zzeu) arrayDeque.peek()).zza(new zzev(this.zzm, zzegVar9));
                        }
                    }
                } else {
                    if (!this.zzv && this.zzm == 1835295092) {
                        this.zzA = 1;
                    }
                    if (j23 < 262144) {
                        zzadbVar.zzf((int) j23);
                    } else {
                        zzaeaVar.zza = zzadbVar.zzn() + j23;
                        z2 = true;
                    }
                    zzj(jZzn4);
                    if (z2 && this.zzl != 2) {
                        return 1;
                    }
                }
                z2 = false;
                zzj(jZzn4);
                if (z2) {
                    continue;
                }
            }
        }
    }
}
