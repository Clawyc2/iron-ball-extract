package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzair implements zzada {
    private static final byte[] zza;
    private static final zzv zzb;
    private long zzA;
    private long zzB;
    private zzaiq zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private zzadd zzI;
    private zzaem[] zzJ;
    private zzaem[] zzK;
    private boolean zzL;
    private long zzM;
    private final zzakg zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzeg zzg;
    private final zzeg zzh;
    private final zzeg zzi;
    private final byte[] zzj;
    private final zzeg zzk;
    private final zzagc zzl;
    private final zzeg zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzfq zzp;
    private final zzacp zzq;
    private zzgpe zzr;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzeg zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    static {
        int i = zzain.zza;
        zza = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        zzt zztVar = new zzt();
        zztVar.zzm("application/x-emsg");
        zzb = zztVar.zzM();
    }

    @Deprecated
    public zzair() {
        this(zzakg.zza, 32, null, null, zzgpe.zzi(), null);
    }

    private final void zzh() {
        this.zzs = 0;
        this.zzv = 0;
    }

    /* JADX WARN: Code duplicated, block: B:139:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:142:0x0412 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0414  */
    /* JADX WARN: Code duplicated, block: B:144:0x041d  */
    /* JADX WARN: Code duplicated, block: B:147:0x0426  */
    /* JADX WARN: Code duplicated, block: B:148:0x0431  */
    /* JADX WARN: Code duplicated, block: B:151:0x043a  */
    /* JADX WARN: Code duplicated, block: B:152:0x043f  */
    /* JADX WARN: Code duplicated, block: B:153:0x0441 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x0443  */
    /* JADX WARN: Code duplicated, block: B:155:0x0448  */
    /* JADX WARN: Code duplicated, block: B:156:0x044a A[PHI: r32
      0x044a: PHI (r32v4 int) = (r5v57 int), (r32v5 int) binds: [B:152:0x043f, B:155:0x0448] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:158:0x044e  */
    /* JADX WARN: Code duplicated, block: B:159:0x0457  */
    /* JADX WARN: Code duplicated, block: B:162:0x0471  */
    /* JADX WARN: Code duplicated, block: B:165:0x0483 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x0485 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:167:0x0487  */
    /* JADX WARN: Code duplicated, block: B:168:0x048c  */
    /* JADX WARN: Code duplicated, block: B:169:0x048f  */
    private final void zzi(long j) throws zzat {
        zzap zzapVar;
        int i;
        int i2;
        byte[] bArr;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        int i7;
        boolean z2;
        int i8;
        long j2;
        long j3;
        int i9;
        int iZzB;
        int iZzB2;
        int iZzB3;
        int iZzB4;
        long jZzt;
        boolean z3;
        long[] jArr2;
        while (true) {
            ArrayDeque arrayDeque = this.zzn;
            if (arrayDeque.isEmpty() || ((zzeu) arrayDeque.peek()).zza != j) {
                break;
            }
            zzeu zzeuVar = (zzeu) arrayDeque.pop();
            int i10 = zzeuVar.zzd;
            int i11 = 12;
            int i12 = 8;
            char c = 1;
            if (i10 == 1836019574) {
                zzq zzqVarZzm = zzm(zzeuVar.zzb);
                zzeu zzeuVarZzd = zzeuVar.zzd(1836475768);
                zzeuVarZzd.getClass();
                SparseArray sparseArray = new SparseArray();
                List list = zzeuVarZzd.zzb;
                int size = list.size();
                int i13 = 0;
                long jZzz = -9223372036854775807L;
                while (i13 < size) {
                    zzev zzevVar = (zzev) list.get(i13);
                    int i14 = zzevVar.zzd;
                    if (i14 == 1953654136) {
                        zzeg zzegVar = zzevVar.zza;
                        zzegVar.zzh(i11);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzegVar.zzB()), new zzail(zzegVar.zzB() - 1, zzegVar.zzB(), zzegVar.zzB(), zzegVar.zzB()));
                        sparseArray.put(((Integer) pairCreate.first).intValue(), (zzail) pairCreate.second);
                    } else if (i14 == 1835362404) {
                        zzeg zzegVar2 = zzevVar.zza;
                        zzegVar2.zzh(8);
                        jZzz = zzaik.zza(zzegVar2.zzB()) == 0 ? zzegVar2.zzz() : zzegVar2.zzJ();
                    }
                    i13++;
                    i11 = 12;
                }
                zzeu zzeuVarZzd2 = zzeuVar.zzd(1835365473);
                zzap zzapVarZze = zzeuVarZzd2 != null ? zzaik.zze(zzeuVarZzd2) : null;
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
                List listZzb = zzaik.zzb(zzeuVar, zzadsVar, jZzz, zzqVarZzm, (this.zzd & 16) != 0, false, new zzglu(this) { // from class: com.google.android.gms.internal.ads.zzaim
                    @Override // com.google.android.gms.internal.ads.zzglu
                    public final /* synthetic */ Object apply(Object obj) {
                        return (zzajf) obj;
                    }
                }, false);
                int size2 = listZzb.size();
                SparseArray sparseArray2 = this.zzf;
                if (sparseArray2.size() == 0) {
                    String strZza = zzaiu.zza(listZzb);
                    int i15 = 0;
                    while (i15 < size2) {
                        zzaji zzajiVar = (zzaji) listZzb.get(i15);
                        zzajf zzajfVar = zzajiVar.zza;
                        zzadd zzaddVar = this.zzI;
                        int i16 = zzajfVar.zzb;
                        zzaem zzaemVarZzu = zzaddVar.zzu(i15, i16);
                        char c2 = c;
                        long j4 = zzajfVar.zze;
                        int i17 = i15;
                        zzv zzvVar = zzajfVar.zzg;
                        zzap zzapVar3 = zzapVar2;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzl(strZza);
                        zzait.zzb(i16, zzadsVar, zztVarZza);
                        zzads zzadsVar2 = zzadsVar;
                        String str = strZza;
                        zzap[] zzapVarArr = new zzap[2];
                        zzapVarArr[0] = zzapVar;
                        zzapVarArr[c2] = zzapVar3;
                        zzait.zza(i16, zzapVarZze, zztVarZza, zzvVar.zzl, zzapVarArr);
                        int i18 = zzajfVar.zza;
                        sparseArray2.put(i18, new zzaiq(zzaemVarZzu, zzajiVar, zzn(sparseArray, i18), zztVarZza.zzM()));
                        this.zzA = Math.max(this.zzA, j4);
                        i15 = i17 + 1;
                        c = c2;
                        zzadsVar = zzadsVar2;
                        zzapVar2 = zzapVar3;
                        strZza = str;
                    }
                    this.zzI.zzv();
                } else {
                    zzgmd.zzh(sparseArray2.size() == size2);
                    for (int i19 = 0; i19 < size2; i19++) {
                        zzaji zzajiVar2 = (zzaji) listZzb.get(i19);
                        int i20 = zzajiVar2.zza.zza;
                        ((zzaiq) sparseArray2.get(i20)).zza(zzajiVar2, zzn(sparseArray, i20));
                    }
                }
            } else {
                boolean z4 = true;
                int i21 = 16;
                int i22 = 0;
                if (i10 == 1836019558) {
                    SparseArray sparseArray3 = this.zzf;
                    int i23 = this.zzd;
                    byte[] bArr2 = this.zzj;
                    List list2 = zzeuVar.zzc;
                    int size3 = list2.size();
                    int i24 = 0;
                    while (i24 < size3) {
                        zzeu zzeuVar2 = (zzeu) list2.get(i24);
                        if (zzeuVar2.zzd == 1953653094) {
                            zzev zzevVarZzc3 = zzeuVar2.zzc(1952868452);
                            zzevVarZzc3.getClass();
                            zzeg zzegVar3 = zzevVarZzc3.zza;
                            zzegVar3.zzh(i12);
                            int iZzB5 = zzegVar3.zzB();
                            int i25 = zzaik.zza;
                            zzaiq zzaiqVar = (zzaiq) sparseArray3.get(zzegVar3.zzB());
                            if (zzaiqVar == null) {
                                zzaiqVar = null;
                            } else {
                                if ((iZzB5 & 1) != 0) {
                                    long jZzJ = zzegVar3.zzJ();
                                    zzajh zzajhVar = zzaiqVar.zzb;
                                    zzajhVar.zzb = jZzJ;
                                    zzajhVar.zzc = jZzJ;
                                }
                                zzail zzailVar = zzaiqVar.zze;
                                zzaiqVar.zzb.zza = new zzail((iZzB5 & 2) != 0 ? zzegVar3.zzB() - 1 : zzailVar.zza, (iZzB5 & 8) != 0 ? zzegVar3.zzB() : zzailVar.zzb, (iZzB5 & 16) != 0 ? zzegVar3.zzB() : zzailVar.zzc, (iZzB5 & 32) != 0 ? zzegVar3.zzB() : zzailVar.zzd);
                            }
                            if (zzaiqVar == null) {
                                i = 8;
                            } else {
                                zzajh zzajhVar2 = zzaiqVar.zzb;
                                long j5 = zzajhVar2.zzp;
                                boolean z5 = zzajhVar2.zzq;
                                zzaiqVar.zzc();
                                boolean z6 = z4;
                                zzaiqVar.zzl(z6);
                                zzev zzevVarZzc4 = zzeuVar2.zzc(1952867444);
                                if (zzevVarZzc4 == null || (i23 & 2) != 0) {
                                    zzajhVar2.zzp = j5;
                                    zzajhVar2.zzq = z5;
                                } else {
                                    zzeg zzegVar4 = zzevVarZzc4.zza;
                                    zzegVar4.zzh(8);
                                    zzajhVar2.zzp = zzaik.zza(zzegVar4.zzB()) == z6 ? zzegVar4.zzJ() : zzegVar4.zzz();
                                    zzajhVar2.zzq = z6;
                                }
                                List list3 = zzeuVar2.zzb;
                                int size4 = list3.size();
                                i23 = i23;
                                int i26 = i22;
                                int i27 = i26;
                                int i28 = i27;
                                while (true) {
                                    i2 = 1953658222;
                                    if (i26 >= size4) {
                                        break;
                                    }
                                    List list4 = list2;
                                    zzev zzevVar2 = (zzev) list3.get(i26);
                                    int i29 = size3;
                                    if (zzevVar2.zzd == 1953658222) {
                                        zzeg zzegVar5 = zzevVar2.zza;
                                        zzegVar5.zzh(12);
                                        int iZzH = zzegVar5.zzH();
                                        if (iZzH > 0) {
                                            i28 += iZzH;
                                            i27++;
                                        }
                                    }
                                    i26++;
                                    size3 = i29;
                                    list2 = list4;
                                }
                                list2 = list2;
                                size3 = size3;
                                int i30 = i22;
                                zzaiqVar.zzh = i30;
                                zzaiqVar.zzg = i30;
                                zzaiqVar.zzf = i30;
                                zzajhVar2.zzd = i27;
                                zzajhVar2.zze = i28;
                                if (zzajhVar2.zzg.length < i27) {
                                    zzajhVar2.zzf = new long[i27];
                                    zzajhVar2.zzg = new int[i27];
                                }
                                if (zzajhVar2.zzh.length < i28) {
                                    int i31 = (i28 * 125) / 100;
                                    zzajhVar2.zzh = new int[i31];
                                    zzajhVar2.zzi = new long[i31];
                                    zzajhVar2.zzj = new boolean[i31];
                                    zzajhVar2.zzl = new boolean[i31];
                                }
                                int i32 = 0;
                                int i33 = 0;
                                int i34 = 0;
                                while (i32 < size4) {
                                    long j6 = 0;
                                    zzev zzevVar3 = (zzev) list3.get(i32);
                                    if (zzevVar3.zzd == i2) {
                                        int i35 = i33 + 1;
                                        zzeg zzegVar6 = zzevVar3.zza;
                                        zzegVar6.zzh(8);
                                        int iZzB6 = zzegVar6.zzB();
                                        zzajf zzajfVar2 = zzaiqVar.zzd.zza;
                                        int i36 = i33;
                                        zzail zzailVar2 = zzajhVar2.zza;
                                        String str2 = zzep.zza;
                                        zzajhVar2.zzg[i36] = zzegVar6.zzH();
                                        long[] jArr3 = zzajhVar2.zzf;
                                        int i37 = i34;
                                        long j7 = zzajhVar2.zzb;
                                        jArr3[i36] = j7;
                                        if ((iZzB6 & 1) != 0) {
                                            jArr3[i36] = j7 + ((long) zzegVar6.zzB());
                                        }
                                        boolean z7 = (iZzB6 & 4) != 0;
                                        int i38 = zzailVar2.zzd;
                                        int iZzB7 = z7 ? zzegVar6.zzB() : i38;
                                        boolean z8 = z7;
                                        int i39 = iZzB6 & 256;
                                        int i40 = iZzB6 & 512;
                                        int i41 = iZzB6 & 1024;
                                        int i42 = iZzB6 & 2048;
                                        long[] jArr4 = zzajfVar2.zzi;
                                        if (jArr4 != null) {
                                            i4 = i41;
                                            if (jArr4.length == 1 && (jArr2 = zzajfVar2.zzj) != null) {
                                                long j8 = jArr4[0];
                                                if (j8 == 0) {
                                                    i5 = i38;
                                                    i6 = iZzB7;
                                                } else {
                                                    i5 = i38;
                                                    i6 = iZzB7;
                                                    if (zzep.zzt(j8, 1000000L, zzajfVar2.zzd, RoundingMode.DOWN) + zzep.zzt(jArr2[0], 1000000L, zzajfVar2.zzc, RoundingMode.DOWN) >= zzajfVar2.zze) {
                                                    }
                                                }
                                                j6 = jArr2[0];
                                            }
                                            iArr = zzajhVar2.zzh;
                                            jArr = zzajhVar2.zzi;
                                            zArr = zzajhVar2.zzj;
                                            i7 = i5;
                                            if (zzajfVar2.zzb == 2 || (i23 & 1) == 0) {
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            i8 = i37 + zzajhVar2.zzg[i36];
                                            j2 = zzajfVar2.zzc;
                                            j3 = zzajhVar2.zzp;
                                            i9 = i37;
                                            while (i9 < i8) {
                                                if (i39 != 0) {
                                                    iZzB = zzegVar6.zzB();
                                                } else {
                                                    iZzB = zzailVar2.zzb;
                                                }
                                                zzj(iZzB);
                                                if (i40 != 0) {
                                                    iZzB2 = zzegVar6.zzB();
                                                } else {
                                                    iZzB2 = zzailVar2.zzc;
                                                }
                                                zzj(iZzB2);
                                                if (i4 != 0) {
                                                    iZzB3 = zzegVar6.zzB();
                                                } else if (i9 != 0) {
                                                    iZzB3 = i7;
                                                } else if (z8) {
                                                    iZzB3 = i6;
                                                    i9 = 0;
                                                } else {
                                                    i9 = 0;
                                                    iZzB3 = i7;
                                                }
                                                if (i42 != 0) {
                                                    iZzB4 = zzegVar6.zzB();
                                                } else {
                                                    iZzB4 = 0;
                                                }
                                                zzail zzailVar3 = zzailVar2;
                                                jZzt = zzep.zzt((((long) iZzB4) + j3) - j6, 1000000L, j2, RoundingMode.DOWN);
                                                jArr[i9] = jZzt;
                                                if (!zzajhVar2.zzq) {
                                                    jArr[i9] = jZzt + zzaiqVar.zzd.zzh;
                                                }
                                                iArr[i9] = iZzB2;
                                                if (((iZzB3 >> 16) & 1) != 0) {
                                                    z3 = false;
                                                } else if (z2) {
                                                    z3 = true;
                                                } else if (i9 == 0) {
                                                    z3 = true;
                                                    i9 = 0;
                                                } else {
                                                    z3 = false;
                                                }
                                                zArr[i9] = z3;
                                                j3 += (long) iZzB;
                                                i9++;
                                                z2 = z2;
                                                zzailVar2 = zzailVar3;
                                            }
                                            zzajhVar2.zzp = j3;
                                            i34 = i8;
                                            i33 = i35;
                                        } else {
                                            i4 = i41;
                                        }
                                        i5 = i38;
                                        i6 = iZzB7;
                                        iArr = zzajhVar2.zzh;
                                        jArr = zzajhVar2.zzi;
                                        zArr = zzajhVar2.zzj;
                                        i7 = i5;
                                        if (zzajfVar2.zzb == 2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        i8 = i37 + zzajhVar2.zzg[i36];
                                        j2 = zzajfVar2.zzc;
                                        j3 = zzajhVar2.zzp;
                                        i9 = i37;
                                        while (i9 < i8) {
                                            if (i39 != 0) {
                                                iZzB = zzegVar6.zzB();
                                            } else {
                                                iZzB = zzailVar2.zzb;
                                            }
                                            zzj(iZzB);
                                            if (i40 != 0) {
                                                iZzB2 = zzegVar6.zzB();
                                            } else {
                                                iZzB2 = zzailVar2.zzc;
                                            }
                                            zzj(iZzB2);
                                            if (i4 != 0) {
                                                iZzB3 = zzegVar6.zzB();
                                            } else if (i9 != 0) {
                                                iZzB3 = i7;
                                            } else if (z8) {
                                                iZzB3 = i6;
                                                i9 = 0;
                                            } else {
                                                i9 = 0;
                                                iZzB3 = i7;
                                            }
                                            if (i42 != 0) {
                                                iZzB4 = zzegVar6.zzB();
                                            } else {
                                                iZzB4 = 0;
                                            }
                                            zzail zzailVar4 = zzailVar2;
                                            jZzt = zzep.zzt((((long) iZzB4) + j3) - j6, 1000000L, j2, RoundingMode.DOWN);
                                            jArr[i9] = jZzt;
                                            if (!zzajhVar2.zzq) {
                                                jArr[i9] = jZzt + zzaiqVar.zzd.zzh;
                                            }
                                            iArr[i9] = iZzB2;
                                            if (((iZzB3 >> 16) & 1) != 0) {
                                                z3 = false;
                                            } else if (z2) {
                                                z3 = true;
                                            } else if (i9 == 0) {
                                                z3 = true;
                                                i9 = 0;
                                            } else {
                                                z3 = false;
                                            }
                                            zArr[i9] = z3;
                                            j3 += (long) iZzB;
                                            i9++;
                                            z2 = z2;
                                            zzailVar2 = zzailVar4;
                                        }
                                        zzajhVar2.zzp = j3;
                                        i34 = i8;
                                        i33 = i35;
                                    }
                                    i32++;
                                    i24 = i24;
                                    i2 = 1953658222;
                                }
                                i24 = i24;
                                zzajf zzajfVar3 = zzaiqVar.zzd.zza;
                                zzail zzailVar5 = zzajhVar2.zza;
                                zzailVar5.getClass();
                                zzajg zzajgVarZza = zzajfVar3.zza(zzailVar5.zza);
                                zzev zzevVarZzc5 = zzeuVar2.zzc(1935763834);
                                if (zzevVarZzc5 != null) {
                                    zzajgVarZza.getClass();
                                    int i43 = zzajgVarZza.zzd;
                                    zzeg zzegVar7 = zzevVarZzc5.zza;
                                    zzegVar7.zzh(8);
                                    if ((zzegVar7.zzB() & 1) == 1) {
                                        zzegVar7.zzk(8);
                                    }
                                    int iZzs = zzegVar7.zzs();
                                    int iZzH2 = zzegVar7.zzH();
                                    int i44 = zzajhVar2.zze;
                                    if (iZzH2 > i44) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzH2).length() + 56 + String.valueOf(i44).length());
                                        sb.append("Saiz sample count ");
                                        sb.append(iZzH2);
                                        sb.append(" is greater than fragment sample count");
                                        sb.append(i44);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    if (iZzs == 0) {
                                        boolean[] zArr2 = zzajhVar2.zzl;
                                        i3 = 0;
                                        for (int i45 = 0; i45 < iZzH2; i45++) {
                                            int iZzs2 = zzegVar7.zzs();
                                            i3 += iZzs2;
                                            zArr2[i45] = iZzs2 > i43;
                                        }
                                        z = false;
                                    } else {
                                        boolean z9 = iZzs > i43;
                                        i3 = iZzs * iZzH2;
                                        z = false;
                                        Arrays.fill(zzajhVar2.zzl, 0, iZzH2, z9);
                                    }
                                    Arrays.fill(zzajhVar2.zzl, iZzH2, zzajhVar2.zze, z);
                                    if (i3 > 0) {
                                        zzajhVar2.zza(i3);
                                    }
                                }
                                zzev zzevVarZzc6 = zzeuVar2.zzc(1935763823);
                                if (zzevVarZzc6 != null) {
                                    zzeg zzegVar8 = zzevVarZzc6.zza;
                                    zzegVar8.zzh(8);
                                    int iZzB8 = zzegVar8.zzB();
                                    if ((iZzB8 & 1) == 1) {
                                        zzegVar8.zzk(8);
                                    }
                                    int iZzH3 = zzegVar8.zzH();
                                    if (iZzH3 != 1) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzH3).length() + 29);
                                        sb2.append("Unexpected saio entry count: ");
                                        sb2.append(iZzH3);
                                        throw zzat.zzb(sb2.toString(), null);
                                    }
                                    zzajhVar2.zzc += zzaik.zza(iZzB8) == 0 ? zzegVar8.zzz() : zzegVar8.zzJ();
                                }
                                zzev zzevVarZzc7 = zzeuVar2.zzc(1936027235);
                                if (zzevVarZzc7 != null) {
                                    zzk(zzevVarZzc7.zza, 0, zzajhVar2);
                                }
                                String str3 = zzajgVarZza != null ? zzajgVarZza.zzb : null;
                                zzeg zzegVar9 = null;
                                zzeg zzegVar10 = null;
                                for (int i46 = 0; i46 < list3.size(); i46++) {
                                    zzev zzevVar4 = (zzev) list3.get(i46);
                                    zzeg zzegVar11 = zzevVar4.zza;
                                    int i47 = zzevVar4.zzd;
                                    if (i47 == 1935828848) {
                                        zzegVar11.zzh(12);
                                        if (zzegVar11.zzB() == 1936025959) {
                                            zzegVar9 = zzegVar11;
                                        }
                                    } else if (i47 == 1936158820) {
                                        zzegVar11.zzh(12);
                                        if (zzegVar11.zzB() == 1936025959) {
                                            zzegVar10 = zzegVar11;
                                        }
                                    }
                                }
                                if (zzegVar9 == null || zzegVar10 == null) {
                                    z4 = true;
                                } else {
                                    zzegVar9.zzh(8);
                                    int iZza = zzaik.zza(zzegVar9.zzB());
                                    zzegVar9.zzk(4);
                                    if (iZza == 1) {
                                        zzegVar9.zzk(4);
                                    }
                                    if (zzegVar9.zzB() != 1) {
                                        throw zzat.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzegVar10.zzh(8);
                                    int iZza2 = zzaik.zza(zzegVar10.zzB());
                                    zzegVar10.zzk(4);
                                    if (iZza2 == 1) {
                                        if (zzegVar10.zzz() == 0) {
                                            throw zzat.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZza2 >= 2) {
                                        zzegVar10.zzk(4);
                                    }
                                    if (zzegVar10.zzz() != 1) {
                                        throw zzat.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    z4 = true;
                                    zzegVar10.zzk(1);
                                    int iZzs3 = zzegVar10.zzs();
                                    int i48 = (iZzs3 & 240) >> 4;
                                    int i49 = iZzs3 & 15;
                                    if (zzegVar10.zzs() == 1) {
                                        int iZzs4 = zzegVar10.zzs();
                                        int i50 = i21;
                                        byte[] bArr3 = new byte[i50];
                                        zzegVar10.zzm(bArr3, 0, i50);
                                        if (iZzs4 == 0) {
                                            int iZzs5 = zzegVar10.zzs();
                                            byte[] bArr4 = new byte[iZzs5];
                                            zzegVar10.zzm(bArr4, 0, iZzs5);
                                            bArr = bArr4;
                                        } else {
                                            bArr = null;
                                        }
                                        zzajhVar2.zzk = true;
                                        zzajhVar2.zzm = new zzajg(true, str3, iZzs4, bArr3, i48, i49, bArr);
                                    }
                                }
                                int size5 = list3.size();
                                for (int i51 = 0; i51 < size5; i51++) {
                                    zzev zzevVar5 = (zzev) list3.get(i51);
                                    if (zzevVar5.zzd == 1970628964) {
                                        zzeg zzegVar12 = zzevVar5.zza;
                                        zzegVar12.zzh(8);
                                        zzegVar12.zzm(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zza)) {
                                            zzk(zzegVar12, 16, zzajhVar2);
                                        }
                                    }
                                }
                                i = 8;
                                i22 = 0;
                                i21 = 16;
                            }
                            i24++;
                            i12 = i;
                            i22 = i22;
                            z4 = z4;
                            i21 = i21;
                            i23 = i23;
                            size3 = size3;
                            list2 = list2;
                        } else {
                            i = i12;
                        }
                        i24++;
                        i12 = i;
                        i22 = i22;
                        z4 = z4;
                        i21 = i21;
                        i23 = i23;
                        size3 = size3;
                        list2 = list2;
                    }
                    int i52 = i22;
                    zzq zzqVarZzm2 = zzm(zzeuVar.zzb);
                    if (zzqVarZzm2 != null) {
                        int size6 = sparseArray3.size();
                        for (int i53 = i52; i53 < size6; i53++) {
                            ((zzaiq) sparseArray3.valueAt(i53)).zzb(zzqVarZzm2);
                        }
                    }
                    if (this.zzz != -9223372036854775807L) {
                        int size7 = sparseArray3.size();
                        for (int i54 = i52; i54 < size7; i54++) {
                            zzaiq zzaiqVar2 = (zzaiq) sparseArray3.valueAt(i54);
                            long j9 = this.zzz;
                            int i55 = zzaiqVar2.zzf;
                            while (true) {
                                zzajh zzajhVar3 = zzaiqVar2.zzb;
                                if (i55 >= zzajhVar3.zze || zzajhVar3.zzi[i55] > j9) {
                                    break;
                                }
                                if (zzajhVar3.zzj[i55]) {
                                    zzaiqVar2.zzi = i55;
                                }
                                i55++;
                            }
                        }
                        this.zzz = -9223372036854775807L;
                    }
                } else if (!arrayDeque.isEmpty()) {
                    ((zzeu) arrayDeque.peek()).zzb(zzeuVar);
                }
            }
        }
        zzh();
    }

    private static int zzj(int i) throws zzat {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
        sb.append("Unexpected negative value: ");
        sb.append(i);
        throw zzat.zzb(sb.toString(), null);
    }

    private static void zzk(zzeg zzegVar, int i, zzajh zzajhVar) throws zzat {
        zzegVar.zzh(i + 8);
        int iZzB = zzegVar.zzB();
        int i2 = zzaik.zza;
        if ((iZzB & 1) != 0) {
            throw zzat.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzB & 2) != 0;
        int iZzH = zzegVar.zzH();
        if (iZzH == 0) {
            Arrays.fill(zzajhVar.zzl, 0, zzajhVar.zze, false);
            return;
        }
        int i3 = zzajhVar.zze;
        if (iZzH != i3) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzH).length() + 58 + String.valueOf(i3).length());
            sb.append("Senc sample count ");
            sb.append(iZzH);
            sb.append(" is different from fragment sample count");
            sb.append(i3);
            throw zzat.zzb(sb.toString(), null);
        }
        Arrays.fill(zzajhVar.zzl, 0, iZzH, z);
        zzajhVar.zza(zzegVar.zzd());
        zzeg zzegVar2 = zzajhVar.zzn;
        zzegVar.zzm(zzegVar2.zzi(), 0, zzegVar2.zze());
        zzegVar2.zzh(0);
        zzajhVar.zzo = false;
    }

    private static Pair zzl(zzeg zzegVar, long j) throws zzat {
        long jZzJ;
        long jZzJ2;
        zzeg zzegVar2 = zzegVar;
        zzegVar2.zzh(8);
        int iZza = zzaik.zza(zzegVar2.zzB());
        zzegVar2.zzk(4);
        long jZzz = zzegVar2.zzz();
        if (iZza == 0) {
            jZzJ = zzegVar2.zzz();
            jZzJ2 = zzegVar2.zzz();
        } else {
            jZzJ = zzegVar2.zzJ();
            jZzJ2 = zzegVar2.zzJ();
        }
        long j2 = j + jZzJ2;
        long jZzt = zzep.zzt(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
        zzegVar2.zzk(2);
        int iZzt = zzegVar2.zzt();
        int[] iArr = new int[iZzt];
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        long[] jArr3 = new long[iZzt];
        long j3 = j2;
        long j4 = jZzt;
        int i = 0;
        while (i < iZzt) {
            int iZzB = zzegVar2.zzB();
            if ((Integer.MIN_VALUE & iZzB) != 0) {
                throw zzat.zzb("Unhandled indirect reference", null);
            }
            long jZzz2 = zzegVar2.zzz();
            iArr[i] = iZzB & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            jZzJ += jZzz2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jZzt2 = zzep.zzt(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
            jArr4[i] = jZzt2 - jArr5[i];
            zzegVar2.zzk(4);
            j3 += (long) iArr[i];
            i++;
            zzegVar2 = zzegVar;
            iZzt = iZzt;
            j4 = jZzt2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jZzt), new zzaco(iArr, jArr, jArr2, jArr3));
    }

    private static zzq zzm(List list) {
        int i;
        UUID[] uuidArr;
        zzajb zzajbVar;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList = null;
        while (i2 < size) {
            zzev zzevVar = (zzev) list.get(i2);
            if (zzevVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrZzi = zzevVar.zza.zzi();
                zzeg zzegVar = new zzeg(bArrZzi);
                if (zzegVar.zze() < 32) {
                    i = i2;
                    zzajbVar = null;
                } else {
                    zzegVar.zzh(0);
                    int iZzd = zzegVar.zzd();
                    int iZzB = zzegVar.zzB();
                    if (iZzB != iZzd) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzB).length() + 52 + String.valueOf(iZzd).length());
                        sb.append("Advertised atom size (");
                        sb.append(iZzB);
                        sb.append(") does not match buffer size: ");
                        sb.append(iZzd);
                        zzdt.zzc("PsshAtomUtil", sb.toString());
                    } else {
                        int iZzB2 = zzegVar.zzB();
                        if (iZzB2 != 1886614376) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzB2).length() + 23);
                            sb2.append("Atom type is not pssh: ");
                            sb2.append(iZzB2);
                            zzdt.zzc("PsshAtomUtil", sb2.toString());
                        } else {
                            int iZza = zzaik.zza(zzegVar.zzB());
                            if (iZza > 1) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(iZza).length() + 26);
                                sb3.append("Unsupported pssh version: ");
                                sb3.append(iZza);
                                zzdt.zzc("PsshAtomUtil", sb3.toString());
                            } else {
                                UUID uuid = new UUID(zzegVar.zzD(), zzegVar.zzD());
                                if (iZza == 1) {
                                    int iZzH = zzegVar.zzH();
                                    uuidArr = new UUID[iZzH];
                                    int i3 = 0;
                                    while (i3 < iZzH) {
                                        UUID[] uuidArr2 = uuidArr;
                                        int i4 = i3;
                                        uuidArr2[i4] = new UUID(zzegVar.zzD(), zzegVar.zzD());
                                        i3 = i4 + 1;
                                        i2 = i2;
                                        uuidArr = uuidArr2;
                                    }
                                } else {
                                    uuidArr = null;
                                }
                                i = i2;
                                int iZzH2 = zzegVar.zzH();
                                int iZzd2 = zzegVar.zzd();
                                if (iZzH2 != iZzd2) {
                                    StringBuilder sb4 = new StringBuilder(String.valueOf(iZzH2).length() + 49 + String.valueOf(iZzd2).length());
                                    sb4.append("Atom data size (");
                                    sb4.append(iZzH2);
                                    sb4.append(") does not match the bytes left: ");
                                    sb4.append(iZzd2);
                                    zzdt.zzc("PsshAtomUtil", sb4.toString());
                                    zzajbVar = null;
                                } else {
                                    byte[] bArr = new byte[iZzH2];
                                    zzegVar.zzm(bArr, 0, iZzH2);
                                    zzajbVar = new zzajb(uuid, iZza, bArr, uuidArr);
                                }
                            }
                        }
                    }
                    i = i2;
                    zzajbVar = null;
                }
                UUID uuid2 = zzajbVar == null ? null : zzajbVar.zza;
                if (uuid2 == null) {
                    zzdt.zzc("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzp(uuid2, null, "video/mp4", bArrZzi));
                }
                i2 = i + 1;
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList == null) {
            return null;
        }
        return new zzq(arrayList);
    }

    private static final zzail zzn(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzail) sparseArray.valueAt(0);
        }
        zzail zzailVar = (zzail) sparseArray.get(i);
        zzailVar.getClass();
        return zzailVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzaeh zzaehVarZza = zzaje.zza(zzadbVar);
        this.zzr = zzaehVarZza != null ? zzgpe.zzj(zzaehVarZza) : zzgpe.zzi();
        return zzaehVarZza == null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzaddVar = new zzakj(zzaddVar, this.zzc);
        }
        this.zzI = zzaddVar;
        zzh();
        zzaem[] zzaemVarArr = new zzaem[2];
        this.zzJ = zzaemVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzaemVarArr[0] = this.zzI.zzu(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzaem[] zzaemVarArr2 = (zzaem[]) zzep.zzb(this.zzJ, i);
        this.zzJ = zzaemVarArr2;
        for (zzaem zzaemVar : zzaemVarArr2) {
            zzaemVar.zzu(zzb);
        }
        List list = this.zze;
        this.zzK = new zzaem[list.size()];
        while (i4 < this.zzK.length) {
            zzaem zzaemVarZzu = this.zzI.zzu(i3, 3);
            zzaemVarZzu.zzu((zzv) list.get(i4));
            this.zzK[i4] = zzaemVarZzu;
            i4++;
            i3++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0210  */
    /* JADX WARN: Code duplicated, block: B:111:0x0222  */
    /* JADX WARN: Code duplicated, block: B:121:0x025a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0289  */
    /* JADX WARN: Code duplicated, block: B:125:0x0291  */
    /* JADX WARN: Code duplicated, block: B:126:0x0295  */
    /* JADX WARN: Code duplicated, block: B:128:0x029d  */
    /* JADX WARN: Code duplicated, block: B:131:0x02af  */
    /* JADX WARN: Code duplicated, block: B:132:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:137:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:140:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:141:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:145:0x0300  */
    /* JADX WARN: Code duplicated, block: B:147:0x0313  */
    /* JADX WARN: Code duplicated, block: B:150:0x031c  */
    /* JADX WARN: Code duplicated, block: B:153:0x032e  */
    /* JADX WARN: Code duplicated, block: B:458:0x0166 A[EDGE_INSN: B:458:0x0166->B:71:0x0166 BREAK  A[LOOP:6: B:68:0x0154->B:70:0x015a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:459:0x0328 A[EDGE_INSN: B:459:0x0328->B:151:0x0328 BREAK  A[LOOP:7: B:143:0x02f8->B:462:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:464:0x024f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x0247 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:466:0x023d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0154 A[LOOP:6: B:68:0x0154->B:70:0x015a, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:70:0x015a A[LOOP:6: B:68:0x0154->B:70:0x015a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x016a  */
    /* JADX WARN: Code duplicated, block: B:75:0x0182  */
    /* JADX WARN: Code duplicated, block: B:77:0x0186  */
    /* JADX WARN: Code duplicated, block: B:83:0x0193  */
    /* JADX WARN: Code duplicated, block: B:85:0x01a4 A[PHI: r28
      0x01a4: PHI (r28v3 com.google.android.gms.internal.ads.zzaiq) = (r28v1 com.google.android.gms.internal.ads.zzaiq), (r28v4 com.google.android.gms.internal.ads.zzaiq) binds: [B:84:0x01a2, B:82:0x0190] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:90:0x01cf A[ADDED_TO_REGION] */
    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        zzaiq zzaiqVar;
        char c;
        zzajf zzajfVar;
        zzaem zzaemVar;
        long jZzd;
        int i;
        zzeg zzegVar;
        byte[] bArrZzi;
        int i2;
        boolean z;
        int i3;
        zzaiq zzaiqVar2;
        char c2;
        int iZzy;
        int i4;
        zzfq zzfqVar;
        zzfq zzfqVar2;
        zzfq zzfqVar3;
        int iZzb;
        zzaiq zzaiqVar3;
        int iZzB;
        int i5;
        String str;
        char c3;
        zzaiq zzaiqVar4;
        int iZzg;
        zzajg zzajgVarZzj;
        zzael zzaelVar;
        ArrayDeque arrayDeque;
        int i6;
        zzaip zzaipVar;
        int i7;
        long j;
        long j2;
        int i8;
        int i9;
        int i10;
        int i11;
        int iZzi;
        String strZzM;
        String strZzM2;
        long jZzt;
        long jZzz;
        long j3;
        long j4;
        while (true) {
            int i12 = this.zzs;
            char c4 = 2;
            if (i12 == 0) {
                if (this.zzv == 0) {
                    zzeg zzegVar2 = this.zzm;
                    if (!zzadbVar.zzb(zzegVar2.zzi(), 0, 8, true)) {
                        if (this.zzM == -1) {
                            this.zzp.zze();
                            return -1;
                        }
                        zzaeaVar.zza = 0L;
                        this.zzM = -1L;
                        this.zzI.zzw(this.zzq.zzb());
                        return 1;
                    }
                    this.zzv = 8;
                    zzegVar2.zzh(0);
                    this.zzu = zzegVar2.zzz();
                    this.zzt = zzegVar2.zzB();
                }
                long j5 = this.zzu;
                if (j5 == 1) {
                    zzeg zzegVar3 = this.zzm;
                    zzadbVar.zzc(zzegVar3.zzi(), 8, 8);
                    this.zzv += 8;
                    this.zzu = zzegVar3.zzJ();
                } else if (j5 == 0) {
                    long jZzo = zzadbVar.zzo();
                    if (jZzo == -1) {
                        ArrayDeque arrayDeque2 = this.zzn;
                        jZzo = !arrayDeque2.isEmpty() ? ((zzeu) arrayDeque2.peek()).zza : -1L;
                    }
                    if (jZzo != -1) {
                        this.zzu = (jZzo - zzadbVar.zzn()) + ((long) this.zzv);
                    }
                }
                long j6 = this.zzu;
                int i13 = this.zzv;
                long j7 = i13;
                if (j6 < j7) {
                    if (this.zzt != 1718773093 || i13 != 8) {
                        throw zzat.zzc("Atom size less than header length (unsupported).");
                    }
                    this.zzu = j7;
                    j6 = j7;
                }
                if (this.zzM != -1) {
                    if (this.zzt == 1936286840) {
                        zzeg zzegVar4 = this.zzk;
                        zzegVar4.zza((int) j6);
                        System.arraycopy(this.zzm.zzi(), 0, zzegVar4.zzi(), 0, 8);
                        zzadbVar.zzc(zzegVar4.zzi(), 8, (int) (this.zzu - ((long) this.zzv)));
                        this.zzq.zza((zzaco) zzl(new zzev(1936286840, zzegVar4).zza, zzadbVar.zzm()).second);
                    } else {
                        zzadbVar.zze((int) (j6 - j7), true);
                    }
                    zzh();
                } else {
                    long jZzn = zzadbVar.zzn() - j7;
                    int i14 = this.zzt;
                    if ((i14 == 1836019558 || i14 == 1835295092) && !this.zzL) {
                        this.zzI.zzw(new zzaec(this.zzA, jZzn));
                        this.zzL = true;
                    }
                    if (this.zzt == 1836019558) {
                        SparseArray sparseArray = this.zzf;
                        int size = sparseArray.size();
                        for (int i15 = 0; i15 < size; i15++) {
                            zzajh zzajhVar = ((zzaiq) sparseArray.valueAt(i15)).zzb;
                            zzajhVar.zzc = jZzn;
                            zzajhVar.zzb = jZzn;
                        }
                    }
                    int i16 = this.zzt;
                    if (i16 == 1835295092) {
                        this.zzC = null;
                        this.zzx = jZzn + this.zzu;
                        this.zzs = 2;
                    } else if (i16 == 1836019574 || i16 == 1953653099 || i16 == 1835297121 || i16 == 1835626086 || i16 == 1937007212 || i16 == 1836019558 || i16 == 1953653094 || i16 == 1836475768 || i16 == 1701082227 || i16 == 1835365473) {
                        long jZzn2 = zzadbVar.zzn();
                        long j8 = this.zzu;
                        long j9 = jZzn2 + j8;
                        if (j8 != this.zzv && i16 == 1835365473) {
                            zzeg zzegVar5 = this.zzk;
                            zzegVar5.zza(8);
                            zzadbVar.zzi(zzegVar5.zzi(), 0, 8);
                            zzaik.zzf(zzegVar5);
                            zzadbVar.zzf(zzegVar5.zzg());
                            zzadbVar.zzl();
                        }
                        long j10 = j9 - 8;
                        this.zzn.push(new zzeu(this.zzt, j10));
                        if (this.zzu == this.zzv) {
                            zzi(j10);
                        } else {
                            zzh();
                        }
                    } else if (i16 == 1751411826 || i16 == 1835296868 || i16 == 1836476516 || i16 == 1936286840 || i16 == 1937011556 || i16 == 1937011827 || i16 == 1668576371 || i16 == 1937011555 || i16 == 1937011578 || i16 == 1937013298 || i16 == 1937007471 || i16 == 1668232756 || i16 == 1937011571 || i16 == 1952867444 || i16 == 1952868452 || i16 == 1953196132 || i16 == 1953654136 || i16 == 1953658222 || i16 == 1886614376 || i16 == 1935763834 || i16 == 1935763823 || i16 == 1936027235 || i16 == 1970628964 || i16 == 1935828848 || i16 == 1936158820 || i16 == 1701606260 || i16 == 1835362404 || i16 == 1701671783 || i16 == 1969517665 || i16 == 1801812339 || i16 == 1768715124) {
                        if (this.zzv != 8) {
                            throw zzat.zzc("Leaf atom defines extended atom size (unsupported).");
                        }
                        if (this.zzu > 2147483647L) {
                            throw zzat.zzc("Leaf atom with length > 2147483647 (unsupported).");
                        }
                        zzeg zzegVar6 = new zzeg((int) this.zzu);
                        System.arraycopy(this.zzm.zzi(), 0, zzegVar6.zzi(), 0, 8);
                        this.zzw = zzegVar6;
                        this.zzs = 1;
                    } else {
                        if (this.zzu > 2147483647L) {
                            throw zzat.zzc("Skipping atom with length > 2147483647 (unsupported).");
                        }
                        this.zzw = null;
                        this.zzs = 1;
                    }
                }
            } else if (i12 != 1) {
                long j11 = Long.MAX_VALUE;
                if (i12 != 2) {
                    zzaiqVar = this.zzC;
                    if (zzaiqVar != null) {
                        c = 2;
                        break;
                    }
                    SparseArray sparseArray2 = this.zzf;
                    int size2 = sparseArray2.size();
                    long j12 = Long.MAX_VALUE;
                    int i17 = 0;
                    zzaiq zzaiqVar5 = null;
                    while (i17 < size2) {
                        char c5 = c4;
                        zzaiq zzaiqVar6 = (zzaiq) sparseArray2.valueAt(i17);
                        if ((zzaiqVar6.zzk() || zzaiqVar6.zzf != zzaiqVar6.zzd.zzb) && (!zzaiqVar6.zzk() || zzaiqVar6.zzh != zzaiqVar6.zzb.zzd)) {
                            long jZze = zzaiqVar6.zze();
                            if (jZze < j12) {
                                zzaiqVar5 = zzaiqVar6;
                                j12 = jZze;
                            }
                        }
                        i17++;
                        c4 = c5;
                    }
                    c = c4;
                    if (zzaiqVar5 != null) {
                        int iZze = (int) (zzaiqVar5.zze() - zzadbVar.zzn());
                        if (iZze < 0) {
                            zzdt.zzc("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZze = 0;
                        }
                        zzadbVar.zzf(iZze);
                        this.zzC = zzaiqVar5;
                        zzaiqVar = zzaiqVar5;
                        break;
                    }
                    int iZzn = (int) (this.zzx - zzadbVar.zzn());
                    if (iZzn < 0) {
                        throw zzat.zzb("Offset to end of mdat was negative.", null);
                    }
                    zzadbVar.zzf(iZzn);
                    zzh();
                } else {
                    SparseArray sparseArray3 = this.zzf;
                    int size3 = sparseArray3.size();
                    zzaiq zzaiqVar7 = null;
                    for (int i18 = 0; i18 < size3; i18++) {
                        zzajh zzajhVar2 = ((zzaiq) sparseArray3.valueAt(i18)).zzb;
                        if (zzajhVar2.zzo) {
                            long j13 = zzajhVar2.zzc;
                            if (j13 < j11) {
                                zzaiqVar7 = (zzaiq) sparseArray3.valueAt(i18);
                                j11 = j13;
                            }
                        }
                    }
                    if (zzaiqVar7 == null) {
                        this.zzs = 3;
                    } else {
                        int iZzn2 = (int) (j11 - zzadbVar.zzn());
                        if (iZzn2 < 0) {
                            throw zzat.zzb("Offset to encryption data was negative.", null);
                        }
                        zzadbVar.zzf(iZzn2);
                        zzajh zzajhVar3 = zzaiqVar7.zzb;
                        zzeg zzegVar7 = zzajhVar3.zzn;
                        zzadbVar.zzc(zzegVar7.zzi(), 0, zzegVar7.zze());
                        zzegVar7.zzh(0);
                        zzajhVar3.zzo = false;
                    }
                }
            } else {
                long j14 = this.zzu - ((long) this.zzv);
                zzeg zzegVar8 = this.zzw;
                int i19 = (int) j14;
                if (zzegVar8 != null) {
                    zzadbVar.zzc(zzegVar8.zzi(), 8, i19);
                    zzev zzevVar = new zzev(this.zzt, zzegVar8);
                    ArrayDeque arrayDeque3 = this.zzn;
                    if (arrayDeque3.isEmpty()) {
                        int i20 = zzevVar.zzd;
                        if (i20 == 1936286840) {
                            Pair pairZzl = zzl(zzevVar.zza, zzadbVar.zzn());
                            this.zzq.zza((zzaco) pairZzl.second);
                            if (!this.zzL) {
                                this.zzB = ((Long) pairZzl.first).longValue();
                                this.zzI.zzw((zzaed) pairZzl.second);
                                this.zzL = true;
                            }
                        } else if (i20 == 1701671783) {
                            zzeg zzegVar9 = zzevVar.zza;
                            if (this.zzJ.length != 0) {
                                zzegVar9.zzh(8);
                                int iZza = zzaik.zza(zzegVar9.zzB());
                                if (iZza == 0) {
                                    strZzM = zzegVar9.zzM((char) 0);
                                    strZzM.getClass();
                                    strZzM2 = zzegVar9.zzM((char) 0);
                                    strZzM2.getClass();
                                    long jZzz2 = zzegVar9.zzz();
                                    long jZzt2 = zzep.zzt(zzegVar9.zzz(), 1000000L, jZzz2, RoundingMode.DOWN);
                                    long j15 = this.zzB;
                                    long j16 = j15 != -9223372036854775807L ? j15 + jZzt2 : -9223372036854775807L;
                                    jZzt = zzep.zzt(zzegVar9.zzz(), 1000L, jZzz2, RoundingMode.DOWN);
                                    jZzz = zzegVar9.zzz();
                                    j3 = jZzt2;
                                    j4 = j16;
                                } else if (iZza != 1) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 35);
                                    sb.append("Skipping unsupported emsg version: ");
                                    sb.append(iZza);
                                    zzdt.zzc("FragmentedMp4Extractor", sb.toString());
                                } else {
                                    long jZzz3 = zzegVar9.zzz();
                                    long jZzt3 = zzep.zzt(zzegVar9.zzJ(), 1000000L, jZzz3, RoundingMode.DOWN);
                                    long jZzt4 = zzep.zzt(zzegVar9.zzz(), 1000L, jZzz3, RoundingMode.DOWN);
                                    long jZzz4 = zzegVar9.zzz();
                                    strZzM = zzegVar9.zzM((char) 0);
                                    strZzM.getClass();
                                    strZzM2 = zzegVar9.zzM((char) 0);
                                    strZzM2.getClass();
                                    jZzt = jZzt4;
                                    jZzz = jZzz4;
                                    j3 = -9223372036854775807L;
                                    j4 = jZzt3;
                                }
                                String str2 = strZzM;
                                String str3 = strZzM2;
                                byte[] bArr = new byte[zzegVar9.zzd()];
                                zzegVar9.zzm(bArr, 0, zzegVar9.zzd());
                                zzeg zzegVar10 = new zzeg(this.zzl.zza(new zzagb(str2, str3, jZzt, jZzz, bArr)));
                                int iZzd = zzegVar10.zzd();
                                for (zzaem zzaemVar2 : this.zzJ) {
                                    zzegVar10.zzh(0);
                                    zzaemVar2.zzz(zzegVar10, iZzd);
                                }
                                if (j4 == -9223372036854775807L) {
                                    this.zzo.addLast(new zzaip(j3, true, iZzd));
                                    this.zzy += iZzd;
                                } else {
                                    ArrayDeque arrayDeque4 = this.zzo;
                                    if (arrayDeque4.isEmpty()) {
                                        for (zzaem zzaemVar3 : this.zzJ) {
                                            zzaemVar3.zzx(j4, 1, iZzd, 0, null);
                                        }
                                    } else {
                                        arrayDeque4.addLast(new zzaip(j4, false, iZzd));
                                        this.zzy += iZzd;
                                    }
                                }
                            }
                        }
                    } else {
                        ((zzeu) arrayDeque3.peek()).zza(zzevVar);
                    }
                } else {
                    zzadbVar.zzf(i19);
                }
                zzi(zzadbVar.zzn());
            }
        }
        String str4 = "video/avc";
        if (this.zzs == 3) {
            this.zzD = zzaiqVar.zzf();
            String str5 = zzaiqVar.zzd.zza.zzg.zzo;
            if (!Objects.equals(str5, "video/avc")) {
                Objects.equals(str5, "video/hevc");
            }
            this.zzG = true;
            if (zzaiqVar.zzf < zzaiqVar.zzi) {
                zzadbVar.zzf(this.zzD);
                zzajg zzajgVarZzj2 = zzaiqVar.zzj();
                if (zzajgVarZzj2 != null) {
                    zzajh zzajhVar4 = zzaiqVar.zzb;
                    zzeg zzegVar11 = zzajhVar4.zzn;
                    int i21 = zzajgVarZzj2.zzd;
                    if (i21 != 0) {
                        zzegVar11.zzk(i21);
                    }
                    if (zzajhVar4.zzb(zzaiqVar.zzf)) {
                        zzegVar11.zzk(zzegVar11.zzt() * 6);
                    }
                }
                if (!zzaiqVar.zzh()) {
                    this.zzC = null;
                }
                i6 = 3;
            } else {
                if (zzaiqVar.zzd.zza.zzh == 1) {
                    this.zzD -= 8;
                    zzadbVar.zzf(8);
                }
                if ("audio/ac4".equals(zzaiqVar.zzd.zza.zzg.zzo)) {
                    this.zzE = zzaiqVar.zzi(this.zzD, 7);
                    int i22 = this.zzD;
                    zzeg zzegVar12 = this.zzk;
                    zzace.zzc(i22, zzegVar12);
                    zzaiqVar.zza.zzz(zzegVar12, 7);
                    iZzi = this.zzE + 7;
                    this.zzE = iZzi;
                    i11 = 0;
                } else {
                    i11 = 0;
                    iZzi = zzaiqVar.zzi(this.zzD, 0);
                    this.zzE = iZzi;
                }
                this.zzD += iZzi;
                this.zzs = 4;
                this.zzF = i11;
                zzajfVar = zzaiqVar.zzd.zza;
                zzaemVar = zzaiqVar.zza;
                jZzd = zzaiqVar.zzd();
                i = zzajfVar.zzk;
                if (i == 0) {
                    while (true) {
                        i9 = this.zzE;
                        i10 = this.zzD;
                        if (i9 < i10) {
                            break;
                        }
                        this.zzE += zzaemVar.zzy(zzadbVar, i10 - i9, false);
                    }
                } else {
                    zzegVar = this.zzh;
                    bArrZzi = zzegVar.zzi();
                    bArrZzi[0] = 0;
                    bArrZzi[1] = 0;
                    bArrZzi[c] = 0;
                    i2 = 4 - i;
                    z = true;
                    while (this.zzE < this.zzD) {
                        i3 = this.zzF;
                        if (i3 == 0) {
                            if (this.zzK.length <= 0 || !this.zzG) {
                                iZzb = zzfm.zzb(zzajfVar.zzg);
                                zzaiqVar3 = zzaiqVar;
                                if (i + iZzb > this.zzD - this.zzE) {
                                }
                                zzadbVar.zzc(bArrZzi, i2, i + iZzb);
                                zzegVar.zzh(0);
                                iZzB = zzegVar.zzB();
                                if (iZzB < 0) {
                                    throw zzat.zzb("Invalid NAL length", null);
                                }
                                this.zzF = iZzB - iZzb;
                                zzeg zzegVar13 = this.zzg;
                                zzegVar13.zzh(0);
                                zzaemVar.zzz(zzegVar13, 4);
                                this.zzE += 4;
                                this.zzD += i2;
                                if (this.zzK.length > 0 || iZzb <= 0) {
                                    i5 = i2;
                                    str = str4;
                                    c3 = 6;
                                } else {
                                    zzv zzvVar = zzajfVar.zzg;
                                    byte b = bArrZzi[4];
                                    byte[] bArr2 = zzfm.zza;
                                    String str6 = zzvVar.zzo;
                                    if (Objects.equals(str6, str4)) {
                                        i5 = i2;
                                    } else {
                                        i5 = i2;
                                        if (!zzas.zze(zzvVar.zzk, str4)) {
                                            str = str4;
                                            c3 = 6;
                                        }
                                        boolean z2 = ((!Objects.equals(str6, "video/hevc") || zzas.zze(zzvVar.zzk, "video/hevc")) && ((b & 126) >> 1) == 39) ? z : false;
                                        this.zzH = z2;
                                        zzaemVar.zzz(zzegVar, iZzb);
                                        this.zzE += iZzb;
                                        if (iZzb > 0 || this.zzG || !zzfm.zzc(bArrZzi, 4, iZzb, zzajfVar.zzg)) {
                                            i2 = i5;
                                            str4 = str;
                                            zzaiqVar = zzaiqVar3;
                                        } else {
                                            this.zzG = z;
                                            i2 = i5;
                                            str4 = str;
                                            zzaiqVar = zzaiqVar3;
                                        }
                                    }
                                    str = str4;
                                    c3 = 6;
                                    if ((b & Ascii.US) != 6) {
                                        if (Objects.equals(str6, "video/hevc")) {
                                        }
                                    }
                                    this.zzH = z2;
                                    zzaemVar.zzz(zzegVar, iZzb);
                                    this.zzE += iZzb;
                                    if (iZzb > 0) {
                                    }
                                    i2 = i5;
                                    str4 = str;
                                    zzaiqVar = zzaiqVar3;
                                }
                                this.zzH = z2;
                                zzaemVar.zzz(zzegVar, iZzb);
                                this.zzE += iZzb;
                                if (iZzb > 0) {
                                }
                                i2 = i5;
                                str4 = str;
                                zzaiqVar = zzaiqVar3;
                            } else {
                                zzaiqVar3 = zzaiqVar;
                            }
                            iZzb = 0;
                            zzadbVar.zzc(bArrZzi, i2, i + iZzb);
                            zzegVar.zzh(0);
                            iZzB = zzegVar.zzB();
                            if (iZzB < 0) {
                                throw zzat.zzb("Invalid NAL length", null);
                            }
                            this.zzF = iZzB - iZzb;
                            zzeg zzegVar14 = this.zzg;
                            zzegVar14.zzh(0);
                            zzaemVar.zzz(zzegVar14, 4);
                            this.zzE += 4;
                            this.zzD += i2;
                            if (this.zzK.length > 0) {
                                i5 = i2;
                                str = str4;
                                c3 = 6;
                            } else {
                                i5 = i2;
                                str = str4;
                                c3 = 6;
                            }
                            this.zzH = z2;
                            zzaemVar.zzz(zzegVar, iZzb);
                            this.zzE += iZzb;
                            if (iZzb > 0) {
                            }
                            i2 = i5;
                            str4 = str;
                            zzaiqVar = zzaiqVar3;
                        } else {
                            zzaiqVar2 = zzaiqVar;
                            int i23 = i2;
                            String str7 = str4;
                            if (this.zzH) {
                                zzeg zzegVar15 = this.zzi;
                                zzegVar15.zza(i3);
                                zzadbVar.zzc(zzegVar15.zzi(), 0, this.zzF);
                                zzaemVar.zzz(zzegVar15, this.zzF);
                                iZzy = this.zzF;
                                int iZza2 = zzfm.zza(zzegVar15.zzi(), zzegVar15.zze());
                                zzegVar15.zzh(0);
                                zzegVar15.zzf(iZza2);
                                i4 = zzajfVar.zzg.zzq;
                                if (i4 == -1) {
                                    zzfqVar3 = this.zzp;
                                    if (zzfqVar3.zzb() != 0) {
                                        zzfqVar3.zza(0);
                                    }
                                } else {
                                    zzfqVar = this.zzp;
                                    if (zzfqVar.zzb() != i4) {
                                        zzfqVar.zza(i4);
                                    }
                                }
                                zzfqVar2 = this.zzp;
                                zzfqVar2.zzc(jZzd, zzegVar15);
                                c2 = 4;
                                if ((zzaiqVar2.zzg() & 4) != 0) {
                                    zzfqVar2.zze();
                                }
                            } else {
                                c2 = 4;
                                iZzy = zzaemVar.zzy(zzadbVar, i3, false);
                            }
                            this.zzE += iZzy;
                            this.zzF -= iZzy;
                            i2 = i23;
                            str4 = str7;
                            zzaiqVar = zzaiqVar2;
                        }
                        z = true;
                    }
                }
                zzaiqVar4 = zzaiqVar;
                iZzg = zzaiqVar4.zzg();
                if (!this.zzG) {
                    iZzg |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                }
                int i24 = iZzg;
                zzajgVarZzj = zzaiqVar4.zzj();
                if (zzajgVarZzj != null) {
                    zzaelVar = zzajgVarZzj.zzc;
                } else {
                    zzaelVar = null;
                }
                zzaemVar.zzx(jZzd, i24, this.zzD, 0, zzaelVar);
                while (true) {
                    arrayDeque = this.zzo;
                    if (!arrayDeque.isEmpty()) {
                        break;
                    }
                    zzaipVar = (zzaip) arrayDeque.removeFirst();
                    int i25 = this.zzy;
                    i7 = zzaipVar.zzc;
                    this.zzy = i25 - i7;
                    j = zzaipVar.zza;
                    if (zzaipVar.zzb) {
                        j += jZzd;
                    }
                    j2 = j;
                    for (zzaem zzaemVar4 : this.zzJ) {
                        zzaemVar4.zzx(j2, 1, i7, this.zzy, null);
                    }
                }
                if (!zzaiqVar4.zzh()) {
                    this.zzC = null;
                }
                i6 = 3;
            }
        } else {
            zzajfVar = zzaiqVar.zzd.zza;
            zzaemVar = zzaiqVar.zza;
            jZzd = zzaiqVar.zzd();
            i = zzajfVar.zzk;
            if (i == 0) {
                while (true) {
                    i9 = this.zzE;
                    i10 = this.zzD;
                    if (i9 < i10) {
                        break;
                        break;
                    }
                    this.zzE += zzaemVar.zzy(zzadbVar, i10 - i9, false);
                }
            } else {
                zzegVar = this.zzh;
                bArrZzi = zzegVar.zzi();
                bArrZzi[0] = 0;
                bArrZzi[1] = 0;
                bArrZzi[c] = 0;
                i2 = 4 - i;
                z = true;
                while (this.zzE < this.zzD) {
                    i3 = this.zzF;
                    if (i3 == 0) {
                        if (this.zzK.length <= 0) {
                            iZzb = zzfm.zzb(zzajfVar.zzg);
                            zzaiqVar3 = zzaiqVar;
                            if (i + iZzb > this.zzD - this.zzE) {
                                iZzb = 0;
                            }
                        } else {
                            iZzb = zzfm.zzb(zzajfVar.zzg);
                            zzaiqVar3 = zzaiqVar;
                            if (i + iZzb > this.zzD - this.zzE) {
                                iZzb = 0;
                            }
                        }
                        zzadbVar.zzc(bArrZzi, i2, i + iZzb);
                        zzegVar.zzh(0);
                        iZzB = zzegVar.zzB();
                        if (iZzB < 0) {
                            throw zzat.zzb("Invalid NAL length", null);
                        }
                        this.zzF = iZzB - iZzb;
                        zzeg zzegVar16 = this.zzg;
                        zzegVar16.zzh(0);
                        zzaemVar.zzz(zzegVar16, 4);
                        this.zzE += 4;
                        this.zzD += i2;
                        if (this.zzK.length > 0) {
                            i5 = i2;
                            str = str4;
                            c3 = 6;
                        } else {
                            i5 = i2;
                            str = str4;
                            c3 = 6;
                        }
                        this.zzH = z2;
                        zzaemVar.zzz(zzegVar, iZzb);
                        this.zzE += iZzb;
                        if (iZzb > 0) {
                        }
                        i2 = i5;
                        str4 = str;
                        zzaiqVar = zzaiqVar3;
                    } else {
                        zzaiqVar2 = zzaiqVar;
                        int i26 = i2;
                        String str8 = str4;
                        if (this.zzH) {
                            zzeg zzegVar17 = this.zzi;
                            zzegVar17.zza(i3);
                            zzadbVar.zzc(zzegVar17.zzi(), 0, this.zzF);
                            zzaemVar.zzz(zzegVar17, this.zzF);
                            iZzy = this.zzF;
                            int iZza3 = zzfm.zza(zzegVar17.zzi(), zzegVar17.zze());
                            zzegVar17.zzh(0);
                            zzegVar17.zzf(iZza3);
                            i4 = zzajfVar.zzg.zzq;
                            if (i4 == -1) {
                                zzfqVar3 = this.zzp;
                                if (zzfqVar3.zzb() != 0) {
                                    zzfqVar3.zza(0);
                                }
                            } else {
                                zzfqVar = this.zzp;
                                if (zzfqVar.zzb() != i4) {
                                    zzfqVar.zza(i4);
                                }
                            }
                            zzfqVar2 = this.zzp;
                            zzfqVar2.zzc(jZzd, zzegVar17);
                            c2 = 4;
                            if ((zzaiqVar2.zzg() & 4) != 0) {
                                zzfqVar2.zze();
                            }
                        } else {
                            c2 = 4;
                            iZzy = zzaemVar.zzy(zzadbVar, i3, false);
                        }
                        this.zzE += iZzy;
                        this.zzF -= iZzy;
                        i2 = i26;
                        str4 = str8;
                        zzaiqVar = zzaiqVar2;
                    }
                    z = true;
                }
            }
            zzaiqVar4 = zzaiqVar;
            iZzg = zzaiqVar4.zzg();
            if (!this.zzG) {
                iZzg |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            }
            int i27 = iZzg;
            zzajgVarZzj = zzaiqVar4.zzj();
            if (zzajgVarZzj != null) {
                zzaelVar = zzajgVarZzj.zzc;
            } else {
                zzaelVar = null;
            }
            zzaemVar.zzx(jZzd, i27, this.zzD, 0, zzaelVar);
            while (true) {
                arrayDeque = this.zzo;
                if (!arrayDeque.isEmpty()) {
                    break;
                    break;
                }
                zzaipVar = (zzaip) arrayDeque.removeFirst();
                int i28 = this.zzy;
                i7 = zzaipVar.zzc;
                this.zzy = i28 - i7;
                j = zzaipVar.zza;
                if (zzaipVar.zzb) {
                    j += jZzd;
                }
                j2 = j;
                while (i8 < r2) {
                    zzaemVar4.zzx(j2, 1, i7, this.zzy, null);
                }
            }
            if (!zzaiqVar4.zzh()) {
                this.zzC = null;
            }
            i6 = 3;
        }
        this.zzs = i6;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzaiq) sparseArray.valueAt(i)).zzc();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzd();
        this.zzz = j2;
        this.zzn.clear();
        zzh();
    }

    final /* synthetic */ void zzg(long j, zzeg zzegVar) {
        zzacn.zza(j, zzegVar, this.zzK);
    }

    public zzair(zzakg zzakgVar, int i, zzem zzemVar, zzajf zzajfVar, List list, zzaem zzaemVar) {
        this.zzc = zzakgVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzagc();
        this.zzm = new zzeg(16);
        this.zzg = new zzeg(zzfm.zza);
        this.zzh = new zzeg(6);
        this.zzi = new zzeg();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzeg(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzr = zzgpe.zzi();
        this.zzA = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzB = -9223372036854775807L;
        this.zzI = zzadd.zza;
        this.zzJ = new zzaem[0];
        this.zzK = new zzaem[0];
        this.zzp = new zzfq(new zzfp() { // from class: com.google.android.gms.internal.ads.zzaio
            @Override // com.google.android.gms.internal.ads.zzfp
            public final /* synthetic */ void zza(long j, zzeg zzegVar) {
                this.zza.zzg(j, zzegVar);
            }
        });
        this.zzq = new zzacp();
        this.zzM = -1L;
    }
}
