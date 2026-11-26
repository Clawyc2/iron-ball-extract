package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzams implements zzamq {
    private static final double[] zzc = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zza;
    private zzaem zzb;
    private final zzaoi zzd;
    private final String zze;
    private final zzeg zzf;
    private final zzanh zzg;
    private final boolean[] zzh = new boolean[4];
    private final zzamr zzi = new zzamr(128);
    private long zzj;
    private boolean zzk;
    private boolean zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private boolean zzq;
    private boolean zzr;

    zzams(zzaoi zzaoiVar, String str) {
        zzeg zzegVar;
        this.zzd = zzaoiVar;
        this.zze = str;
        if (zzaoiVar != null) {
            this.zzg = new zzanh(178, 128);
            zzegVar = new zzeg();
        } else {
            zzegVar = null;
            this.zzg = null;
        }
        this.zzf = zzegVar;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        zzfm.zzi(this.zzh);
        this.zzi.zza();
        zzanh zzanhVar = this.zzg;
        if (zzanhVar != null) {
            zzanhVar.zza();
        }
        this.zzj = 0L;
        this.zzk = false;
        this.zzn = -9223372036854775807L;
        this.zzp = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zza = zzaoeVar.zzc();
        this.zzb = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        zzaoi zzaoiVar = this.zzd;
        if (zzaoiVar != null) {
            zzaoiVar.zza(zzaddVar, zzaoeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzn = j;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0104  */
    /* JADX WARN: Code duplicated, block: B:41:0x0133  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        long j;
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        double d;
        int i5;
        int i6;
        this.zzb.getClass();
        int iZzg = zzegVar.zzg();
        int iZze = zzegVar.zze();
        byte[] bArrZzi = zzegVar.zzi();
        this.zzj += (long) zzegVar.zzd();
        this.zzb.zzz(zzegVar, zzegVar.zzd());
        while (true) {
            int iZzh = zzfm.zzh(bArrZzi, iZzg, iZze, this.zzh);
            if (iZzh == iZze) {
                break;
            }
            int i7 = iZzh + 3;
            int i8 = zzegVar.zzi()[i7] & 255;
            int i9 = iZzh - iZzg;
            if (!this.zzl) {
                if (i9 > 0) {
                    this.zzi.zzc(bArrZzi, iZzg, iZzh);
                }
                int i10 = i9 < 0 ? -i9 : 0;
                zzamr zzamrVar = this.zzi;
                if (zzamrVar.zzb(i8, i10)) {
                    String str = this.zza;
                    str.getClass();
                    String str2 = this.zze;
                    byte[] bArrCopyOf = Arrays.copyOf(zzamrVar.zzc, zzamrVar.zza);
                    int i11 = bArrCopyOf[4] & 255;
                    byte b = bArrCopyOf[5];
                    int i12 = bArrCopyOf[6] & 255;
                    int i13 = (i11 << 4) | ((b & 255) >> 4);
                    int i14 = (bArrCopyOf[7] & 240) >> 4;
                    int i15 = ((b & Ascii.SI) << 8) | i12;
                    if (i14 == 2) {
                        i2 = i15 * 4;
                        i3 = i13 * 3;
                    } else if (i14 != 3) {
                        if (i14 != 4) {
                            f = 1.0f;
                        } else {
                            i2 = i15 * 121;
                            i3 = i13 * 100;
                        }
                        zzt zztVar = new zzt();
                        zztVar.zza(str);
                        zztVar.zzl(str2);
                        zztVar.zzm("video/mpeg2");
                        zztVar.zzt(i13);
                        zztVar.zzu(i15);
                        zztVar.zzz(f);
                        zztVar.zzp(Collections.singletonList(bArrCopyOf));
                        zzv zzvVarZzM = zztVar.zzM();
                        i4 = (bArrCopyOf[7] & Ascii.SI) - 1;
                        j2 = 0;
                        if (i4 >= 0 && i4 < 8) {
                            d = zzc[i4];
                            byte b2 = bArrCopyOf[zzamrVar.zzb + 9];
                            i5 = (b2 & 96) >> 5;
                            i6 = b2 & Ascii.US;
                            if (i5 != i6) {
                                d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                            }
                            j2 = (long) (1000000.0d / d);
                        }
                        Pair pairCreate = Pair.create(zzvVarZzM, Long.valueOf(j2));
                        this.zzb.zzu((zzv) pairCreate.first);
                        this.zzm = ((Long) pairCreate.second).longValue();
                        this.zzl = true;
                    } else {
                        i2 = i15 * 16;
                        i3 = i13 * 9;
                    }
                    f = i2 / i3;
                    zzt zztVar2 = new zzt();
                    zztVar2.zza(str);
                    zztVar2.zzl(str2);
                    zztVar2.zzm("video/mpeg2");
                    zztVar2.zzt(i13);
                    zztVar2.zzu(i15);
                    zztVar2.zzz(f);
                    zztVar2.zzp(Collections.singletonList(bArrCopyOf));
                    zzv zzvVarZzM2 = zztVar2.zzM();
                    i4 = (bArrCopyOf[7] & Ascii.SI) - 1;
                    j2 = 0;
                    if (i4 >= 0) {
                        d = zzc[i4];
                        byte b3 = bArrCopyOf[zzamrVar.zzb + 9];
                        i5 = (b3 & 96) >> 5;
                        i6 = b3 & Ascii.US;
                        if (i5 != i6) {
                            d *= (((double) i5) + 1.0d) / ((double) (i6 + 1));
                        }
                        j2 = (long) (1000000.0d / d);
                    }
                    Pair pairCreate2 = Pair.create(zzvVarZzM2, Long.valueOf(j2));
                    this.zzb.zzu((zzv) pairCreate2.first);
                    this.zzm = ((Long) pairCreate2.second).longValue();
                    this.zzl = true;
                }
            }
            zzanh zzanhVar = this.zzg;
            if (zzanhVar != null) {
                if (i9 > 0) {
                    zzanhVar.zzd(bArrZzi, iZzg, iZzh);
                    i = 0;
                } else {
                    i = -i9;
                }
                if (zzanhVar.zze(i)) {
                    int iZza = zzfm.zza(zzanhVar.zza, zzanhVar.zzb);
                    zzeg zzegVar2 = this.zzf;
                    String str3 = zzep.zza;
                    zzegVar2.zzb(zzanhVar.zza, iZza);
                    this.zzd.zzb(this.zzp, zzegVar2);
                }
                if (i8 == 178) {
                    if (zzegVar.zzi()[iZzh + 2] == 1) {
                        zzanhVar.zzc(178);
                    }
                    i8 = 178;
                }
            }
            if (i8 == 0 || i8 == 179) {
                int i16 = iZze - iZzh;
                if (this.zzr && this.zzl) {
                    j = -9223372036854775807L;
                    long j3 = this.zzp;
                    if (j3 != -9223372036854775807L) {
                        j = -9223372036854775807L;
                        this.zzb.zzx(j3, this.zzq ? 1 : 0, ((int) (this.zzj - this.zzo)) - i16, i16, null);
                    }
                } else {
                    j = -9223372036854775807L;
                }
                if (!this.zzk || this.zzr) {
                    this.zzo = this.zzj - ((long) i16);
                    long j4 = this.zzn;
                    if (j4 == j) {
                        long j5 = this.zzp;
                        j4 = j5 != j ? j5 + this.zzm : j;
                    }
                    this.zzp = j4;
                    z = false;
                    this.zzq = false;
                    this.zzn = j;
                    z2 = true;
                    this.zzk = true;
                } else {
                    z2 = true;
                    z = false;
                }
                this.zzr = i8 == 0 ? z2 : z;
            } else if (i8 == 184) {
                this.zzq = true;
            }
            iZzg = i7;
            iZze = iZze;
        }
        if (!this.zzl) {
            this.zzi.zzc(bArrZzi, iZzg, iZze);
        }
        zzanh zzanhVar2 = this.zzg;
        if (zzanhVar2 != null) {
            zzanhVar2.zzd(bArrZzi, iZzg, iZze);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
        zzaem zzaemVar = this.zzb;
        zzaemVar.getClass();
        if (z) {
            boolean z2 = this.zzq;
            long j = this.zzj - this.zzo;
            zzaemVar.zzx(this.zzp, z2 ? 1 : 0, (int) j, 0, null);
        }
    }
}
