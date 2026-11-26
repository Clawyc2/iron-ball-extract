package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaon implements zzada {
    private zzadd zza;
    private zzaem zzb;
    private zzaok zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    static {
        int i = zzaom.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return zzaoq.zza(zzadbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zza = zzaddVar;
        this.zzb = zzaddVar.zzu(0, 1);
        zzaddVar.zzv();
    }

    /* JADX WARN: Code duplicated, block: B:47:0x010a  */
    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        int i;
        this.zzb.getClass();
        String str = zzep.zza;
        int i2 = this.zzc;
        int iZzz = 4;
        if (i2 == 0) {
            zzgmd.zzh(zzadbVar.zzn() == 0);
            int i3 = this.zzf;
            if (i3 != -1) {
                zzadbVar.zzf(i3);
                this.zzc = 4;
            } else {
                if (!zzaoq.zza(zzadbVar)) {
                    throw zzat.zzb("Unsupported or unrecognized wav file type.", null);
                }
                zzadbVar.zzf((int) (zzadbVar.zzm() - zzadbVar.zzn()));
                this.zzc = 1;
            }
            return 0;
        }
        long jZzE = -1;
        if (i2 == 1) {
            int i4 = zzaoq.zza;
            zzeg zzegVar = new zzeg(8);
            zzaop zzaopVarZza = zzaop.zza(zzadbVar, zzegVar);
            if (zzaopVarZza.zza != 1685272116) {
                zzadbVar.zzl();
            } else {
                zzadbVar.zzk(8);
                zzegVar.zzh(0);
                zzadbVar.zzi(zzegVar.zzi(), 0, 8);
                jZzE = zzegVar.zzE();
                zzadbVar.zzf(((int) zzaopVarZza.zzb) + 8);
            }
            this.zzd = jZzE;
            this.zzc = 2;
            return 0;
        }
        if (i2 == 2) {
            zzaoo zzaooVarZzb = zzaoq.zzb(zzadbVar);
            int i5 = zzaooVarZzb.zza;
            if (i5 == 17) {
                this.zze = new zzaoj(this.zza, this.zzb, zzaooVarZzb);
            } else if (i5 == 6) {
                this.zze = new zzaol(this.zza, this.zzb, zzaooVarZzb, "audio/g711-alaw", -1);
            } else if (i5 == 7) {
                this.zze = new zzaol(this.zza, this.zzb, zzaooVarZzb, "audio/g711-mlaw", -1);
            } else {
                int i6 = zzaooVarZzb.zze;
                if (i5 == 1) {
                    iZzz = zzep.zzz(i6, ByteOrder.LITTLE_ENDIAN);
                    i = iZzz;
                } else {
                    if (i5 != 3) {
                        if (i5 == 65534) {
                            iZzz = zzep.zzz(i6, ByteOrder.LITTLE_ENDIAN);
                            i = iZzz;
                        }
                    } else if (i6 == 32) {
                        i = iZzz;
                    }
                    i = 0;
                }
                if (i == 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 29);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(i5);
                    throw zzat.zzc(sb.toString());
                }
                this.zze = new zzaol(this.zza, this.zzb, zzaooVarZzb, "audio/raw", i);
            }
            this.zzc = 3;
            return 0;
        }
        if (i2 != 3) {
            zzgmd.zzh(this.zzg != -1);
            long jZzn = this.zzg - zzadbVar.zzn();
            zzaok zzaokVar = this.zze;
            zzaokVar.getClass();
            return zzaokVar.zzc(zzadbVar, jZzn) ? -1 : 0;
        }
        Pair pairZzc = zzaoq.zzc(zzadbVar);
        this.zzf = ((Long) pairZzc.first).intValue();
        long jLongValue = ((Long) pairZzc.second).longValue();
        long j = this.zzd;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        long j2 = ((long) this.zzf) + jLongValue;
        this.zzg = j2;
        long jZzo = zzadbVar.zzo();
        if (jZzo != -1 && j2 > jZzo) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(j2).length() + 29 + String.valueOf(jZzo).length());
            sb2.append("Data exceeds input length: ");
            sb2.append(j2);
            sb2.append(", ");
            sb2.append(jZzo);
            zzdt.zzc("WavExtractor", sb2.toString());
            this.zzg = jZzo;
            j2 = jZzo;
        }
        zzaok zzaokVar2 = this.zze;
        zzaokVar2.getClass();
        zzaokVar2.zzb(this.zzf, j2);
        this.zzc = 4;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzc = j == 0 ? 0 : 4;
        zzaok zzaokVar = this.zze;
        if (zzaokVar != null) {
            zzaokVar.zza(j2);
        }
    }
}
