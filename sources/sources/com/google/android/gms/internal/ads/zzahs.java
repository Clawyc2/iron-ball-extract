package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahs implements zzada {
    public static final /* synthetic */ int zza = 0;
    private final zzeg zzb;
    private final zzadw zzc;
    private final zzads zzd;
    private final zzadu zze;
    private final zzaem zzf;
    private zzadd zzg;
    private zzaem zzh;
    private zzaem zzi;
    private int zzj;
    private zzap zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzahu zzq;
    private boolean zzr;

    static {
        int i = zzahq.zza;
    }

    public zzahs() {
        throw null;
    }

    public zzahs(int i) {
        this.zzb = new zzeg(10);
        this.zzc = new zzadw();
        this.zzd = new zzads();
        this.zzl = -9223372036854775807L;
        this.zze = new zzadu();
        zzacx zzacxVar = new zzacx();
        this.zzf = zzacxVar;
        this.zzi = zzacxVar;
        this.zzo = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:36:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:50:0x010a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0115  */
    /* JADX WARN: Code duplicated, block: B:54:0x011a  */
    /* JADX WARN: Code duplicated, block: B:56:0x0126  */
    /* JADX WARN: Code duplicated, block: B:57:0x0129  */
    /* JADX WARN: Code duplicated, block: B:59:0x012f  */
    /* JADX WARN: Code duplicated, block: B:61:0x013c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0140  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v44 */
    /* JADX WARN: Type inference failed for: r2v47 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [com.google.android.gms.internal.ads.zzaed, com.google.android.gms.internal.ads.zzahu] */
    /* JADX WARN: Type inference failed for: r2v52, types: [com.google.android.gms.internal.ads.zzaht] */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r5v23, types: [com.google.android.gms.internal.ads.zzadd] */
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
    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private final int zzh(zzadb zzadbVar) throws Throwable {
        long j;
        Throwable th;
        int iZzB;
        zzahw zzahwVarZza;
        zzads zzadsVar;
        long jZzn;
        long jZzo;
        long jZzb;
        long j2;
        int i;
        Object zzahnVar;
        long j3;
        long j4;
        int i2;
        int i3;
        zzagt zzagtVar;
        Object objZzd;
        zzahv zzahvVar;
        if (this.zzj == 0) {
            try {
                zzj(zzadbVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzq == null) {
            zzadw zzadwVar = this.zzc;
            zzeg zzegVar = new zzeg(zzadwVar.zzc);
            zzadbVar.zzi(zzegVar.zzi(), 0, zzadwVar.zzc);
            int i4 = 21;
            if ((zzadwVar.zza & 1) != 0) {
                if (zzadwVar.zze != 1) {
                    i4 = 36;
                }
            } else if (zzadwVar.zze == 1) {
                i4 = 13;
            }
            j = -9223372036854775807L;
            if (zzegVar.zze() >= i4 + 4) {
                zzegVar.zzh(i4);
                iZzB = zzegVar.zzB();
                if (iZzB != 1483304551) {
                    if (iZzB == 1231971951) {
                        iZzB = 1231971951;
                    } else if (zzegVar.zze() >= 40) {
                        zzegVar.zzh(36);
                        if (zzegVar.zzB() == 1447187017) {
                            iZzB = 1447187017;
                        } else {
                            iZzB = 0;
                        }
                    } else {
                        iZzB = 0;
                    }
                }
            } else if (zzegVar.zze() >= 40) {
                zzegVar.zzh(36);
                if (zzegVar.zzB() == 1447187017) {
                    iZzB = 1447187017;
                } else {
                    iZzB = 0;
                }
            } else {
                iZzB = 0;
            }
            if (iZzB == 1231971951) {
                zzahwVarZza = zzahw.zza(zzadwVar, zzegVar);
                zzadsVar = this.zzd;
                if (!zzadsVar.zzb() && (i2 = zzahwVarZza.zzd) != -1 && (i3 = zzahwVarZza.zze) != -1) {
                    zzadsVar.zza = i2;
                    zzadsVar.zzb = i3;
                }
                jZzn = zzadbVar.zzn();
                if (zzadbVar.zzo() != -1) {
                    j3 = zzahwVarZza.zzc;
                    if (j3 != -1) {
                        j4 = j3 + jZzn;
                        if (zzadbVar.zzo() != j4) {
                            long jZzo2 = zzadbVar.zzo();
                            th = null;
                            StringBuilder sb = new StringBuilder(String.valueOf(jZzo2).length() + 53 + String.valueOf(j4).length() + 20);
                            sb.append("Data size mismatch between stream (");
                            sb.append(jZzo2);
                            sb.append(") and Xing frame (");
                            sb.append(j4);
                            sb.append("), using Xing value.");
                            zzdt.zzb("Mp3Extractor", sb.toString());
                        } else {
                            th = null;
                        }
                    } else {
                        th = null;
                    }
                } else {
                    th = null;
                }
                zzadbVar.zzf(zzadwVar.zzc);
                if (iZzB == 1483304551) {
                    zzahnVar = zzahx.zzd(zzahwVarZza, jZzn);
                } else {
                    jZzo = zzadbVar.zzo();
                    jZzb = zzahwVarZza.zzb();
                    if (jZzb == -9223372036854775807L) {
                        zzahnVar = th;
                    } else {
                        j2 = zzahwVarZza.zzc;
                        if (j2 != r14) {
                            jZzo = jZzn + j2;
                            i = zzahwVarZza.zza.zzc;
                        } else if (jZzo != -1) {
                            j2 = jZzo - jZzn;
                            i = zzahwVarZza.zza.zzc;
                        } else {
                            zzahnVar = th;
                        }
                        long j5 = j2 - ((long) i);
                        zzahnVar = new zzahn(jZzo, jZzn + ((long) zzahwVarZza.zza.zzc), zzgst.zza(zzep.zzt(j5, 8000000L, jZzb, RoundingMode.HALF_UP)), zzgst.zza(zzgso.zza(j5, zzahwVarZza.zzb, RoundingMode.HALF_UP)), false);
                    }
                }
            } else {
                if (iZzB == 1447187017) {
                    zzahv zzahvVarZzd = zzahv.zzd(zzadbVar.zzo(), zzadbVar.zzn(), zzadwVar, zzegVar);
                    zzadbVar.zzf(zzadwVar.zzc);
                    zzahvVar = zzahvVarZzd;
                } else if (iZzB != 1483304551) {
                    zzadbVar.zzl();
                    zzahvVar = null;
                } else {
                    zzahwVarZza = zzahw.zza(zzadwVar, zzegVar);
                    zzadsVar = this.zzd;
                    if (!zzadsVar.zzb()) {
                        zzadsVar.zza = i2;
                        zzadsVar.zzb = i3;
                    }
                    jZzn = zzadbVar.zzn();
                    if (zzadbVar.zzo() != -1) {
                        j3 = zzahwVarZza.zzc;
                        if (j3 != -1) {
                            j4 = j3 + jZzn;
                            if (zzadbVar.zzo() != j4) {
                                long jZzo3 = zzadbVar.zzo();
                                th = null;
                                StringBuilder sb2 = new StringBuilder(String.valueOf(jZzo3).length() + 53 + String.valueOf(j4).length() + 20);
                                sb2.append("Data size mismatch between stream (");
                                sb2.append(jZzo3);
                                sb2.append(") and Xing frame (");
                                sb2.append(j4);
                                sb2.append("), using Xing value.");
                                zzdt.zzb("Mp3Extractor", sb2.toString());
                            } else {
                                th = null;
                            }
                        } else {
                            th = null;
                        }
                    } else {
                        th = null;
                    }
                    zzadbVar.zzf(zzadwVar.zzc);
                    if (iZzB == 1483304551) {
                        zzahnVar = zzahx.zzd(zzahwVarZza, jZzn);
                    } else {
                        jZzo = zzadbVar.zzo();
                        jZzb = zzahwVarZza.zzb();
                        if (jZzb == -9223372036854775807L) {
                            zzahnVar = th;
                        } else {
                            j2 = zzahwVarZza.zzc;
                            if (j2 != r14) {
                                jZzo = jZzn + j2;
                                i = zzahwVarZza.zza.zzc;
                            } else if (jZzo != -1) {
                                j2 = jZzo - jZzn;
                                i = zzahwVarZza.zza.zzc;
                            } else {
                                zzahnVar = th;
                            }
                            long j6 = j2 - ((long) i);
                            zzahnVar = new zzahn(jZzo, jZzn + ((long) zzahwVarZza.zza.zzc), zzgst.zza(zzep.zzt(j6, 8000000L, jZzb, RoundingMode.HALF_UP)), zzgst.zza(zzgso.zza(j6, zzahwVarZza.zzb, RoundingMode.HALF_UP)), false);
                        }
                    }
                }
                th = null;
                zzahnVar = zzahvVar;
            }
            zzap zzapVar = this.zzk;
            long jZzn2 = zzadbVar.zzn();
            if (zzapVar == null || (zzagtVar = (zzagt) zzapVar.zzc(zzagt.class, zzgmh.zza())) == null) {
                objZzd = th;
            } else {
                zzagv zzagvVar = (zzagv) zzapVar.zzc(zzagv.class, zzahr.zza);
                objZzd = zzahp.zzd(jZzn2, zzagtVar, zzagvVar == null ? -9223372036854775807L : zzep.zzq(Long.parseLong((String) zzagvVar.zzb.get(0))));
            }
            ?? zzahnVar2 = zzahnVar;
            if (this.zzr) {
                zzahnVar2 = new zzaht();
            } else {
                if (objZzd != null) {
                    zzahnVar2 = objZzd;
                } else if (zzahnVar == null) {
                    zzahnVar2 = th;
                }
                if (zzahnVar2 == 0) {
                    zzeg zzegVar2 = this.zzb;
                    zzadbVar.zzi(zzegVar2.zzi(), 0, 4);
                    zzegVar2.zzh(0);
                    zzadwVar.zza(zzegVar2.zzB());
                    zzahnVar2 = new zzahn(zzadbVar.zzo(), zzadbVar.zzn(), zzadwVar.zzf, zzadwVar.zzc, false);
                }
            }
            this.zzq = zzahnVar2;
            this.zzg.zzw(zzahnVar2);
            zzt zztVar = new zzt();
            zztVar.zzl("audio/mpeg");
            zztVar.zzm(zzadwVar.zzb);
            zztVar.zzn(4096);
            zztVar.zzE(zzadwVar.zze);
            zztVar.zzF(zzadwVar.zzd);
            zzads zzadsVar2 = this.zzd;
            zztVar.zzH(zzadsVar2.zza);
            zztVar.zzI(zzadsVar2.zzb);
            zztVar.zzk(this.zzk);
            if (this.zzq.zzg() != -2147483647) {
                zztVar.zzh(this.zzq.zzg());
            }
            this.zzi.zzu(zztVar.zzM());
            this.zzn = zzadbVar.zzn();
        } else {
            j = -9223372036854775807L;
            th = null;
            long j7 = this.zzn;
            if (j7 != 0) {
                long jZzn3 = zzadbVar.zzn();
                if (jZzn3 < j7) {
                    zzadbVar.zzf((int) (j7 - jZzn3));
                }
            }
        }
        int i5 = this.zzp;
        if (i5 == 0) {
            zzadbVar.zzl();
            if (zzk(zzadbVar)) {
                return -1;
            }
            zzeg zzegVar3 = this.zzb;
            zzegVar3.zzh(0);
            int iZzB2 = zzegVar3.zzB();
            if (!zzm(iZzB2, this.zzj) || zzadx.zza(iZzB2) == -1) {
                zzadbVar.zzf(1);
                this.zzj = 0;
                return 0;
            }
            zzadw zzadwVar2 = this.zzc;
            zzadwVar2.zza(iZzB2);
            if (this.zzl == j) {
                this.zzl = this.zzq.zze(zzadbVar.zzn());
            }
            i5 = zzadwVar2.zzc;
            this.zzp = i5;
            this.zzo = zzadbVar.zzn() + ((long) i5);
            zzahu zzahuVar = this.zzq;
            if (zzahuVar instanceof zzaho) {
                zzi(this.zzm + ((long) zzadwVar2.zzg));
                throw th;
            }
        }
        int iZzy = this.zzi.zzy(zzadbVar, i5, true);
        if (iZzy == -1) {
            return -1;
        }
        int i6 = this.zzp - iZzy;
        this.zzp = i6;
        if (i6 > 0) {
            return 0;
        }
        zzaem zzaemVar = this.zzi;
        long jZzi = zzi(this.zzm);
        zzadw zzadwVar3 = this.zzc;
        zzaemVar.zzx(jZzi, 1, zzadwVar3.zzc, 0, null);
        this.zzm += (long) zzadwVar3.zzg;
        this.zzp = 0;
        return 0;
    }

    private final long zzi(long j) {
        return this.zzl + ((j * 1000000) / ((long) this.zzc.zzd));
    }

    private final boolean zzj(zzadb zzadbVar, boolean z) throws IOException {
        int iZzm;
        int i;
        int iZza;
        zzadbVar.zzl();
        long jZzn = zzadbVar.zzn();
        int i2 = true != z ? 131072 : 32768;
        if (jZzn == 0) {
            zzap zzapVarZza = this.zze.zza(zzadbVar, null, i2);
            this.zzk = zzapVarZza;
            if (zzapVarZza != null) {
                this.zzd.zza(zzapVarZza);
            }
            iZzm = (int) zzadbVar.zzm();
            if (!z) {
                zzadbVar.zzf(iZzm);
            }
            i = 0;
        } else {
            iZzm = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (zzk(zzadbVar)) {
                if (i3 > 0) {
                    break;
                }
                zzl();
                throw new EOFException();
            }
            zzeg zzegVar = this.zzb;
            zzegVar.zzh(0);
            int iZzB = zzegVar.zzB();
            if ((i == 0 || zzm(iZzB, i)) && (iZza = zzadx.zza(iZzB)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    this.zzc.zza(iZzB);
                    i = iZzB;
                }
                zzadbVar.zzk(iZza - 4);
            } else {
                int i5 = i4 + 1;
                if (i4 == i2) {
                    if (z) {
                        return false;
                    }
                    zzl();
                    throw new EOFException();
                }
                if (z) {
                    zzadbVar.zzl();
                    zzadbVar.zzk(iZzm + i5);
                } else {
                    zzadbVar.zzf(1);
                }
                i3 = 0;
                i4 = i5;
                i = 0;
            }
        }
        if (z) {
            zzadbVar.zzf(iZzm + i4);
        } else {
            zzadbVar.zzl();
        }
        this.zzj = i;
        return true;
    }

    private final boolean zzk(zzadb zzadbVar) throws IOException {
        zzahu zzahuVar = this.zzq;
        if (zzahuVar != null) {
            long jZzf = zzahuVar.zzf();
            if (jZzf != -1 && zzadbVar.zzm() > jZzf - 4) {
                return true;
            }
        }
        try {
            return !zzadbVar.zzh(this.zzb.zzi(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final void zzl() {
        zzahu zzahuVar = this.zzq;
        if ((zzahuVar instanceof zzahn) && zzahuVar.zzb()) {
            long j = this.zzo;
            if (j == -1 || j == this.zzq.zzf()) {
                return;
            }
            this.zzq = ((zzahn) this.zzq).zzh(this.zzo);
            zzadd zzaddVar = this.zzg;
            zzaddVar.getClass();
            zzaddVar.zzw(this.zzq);
            this.zzh.getClass();
            this.zzq.zza();
        }
    }

    private static boolean zzm(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return zzj(zzadbVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzg = zzaddVar;
        zzaem zzaemVarZzu = zzaddVar.zzu(0, 1);
        this.zzh = zzaemVarZzu;
        this.zzi = zzaemVarZzu;
        this.zzg.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws Throwable {
        this.zzh.getClass();
        String str = zzep.zza;
        int iZzh = zzh(zzadbVar);
        if (iZzh == -1 && (this.zzq instanceof zzaho)) {
            if (this.zzq.zza() != zzi(this.zzm)) {
                throw null;
            }
        }
        return iZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzj = 0;
        this.zzl = -9223372036854775807L;
        this.zzm = 0L;
        this.zzp = 0;
        zzahu zzahuVar = this.zzq;
        if (zzahuVar instanceof zzaho) {
            throw null;
        }
    }

    public final void zzg() {
        this.zzr = true;
    }
}
