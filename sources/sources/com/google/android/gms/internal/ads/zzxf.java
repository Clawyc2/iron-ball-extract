package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzxf extends zzya implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxt zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;

    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b1  */
    public zzxf(int i, zzbg zzbgVar, int i2, zzxt zzxtVar, int i3, boolean z, zzgme zzgmeVar, int i4) {
        int i5;
        int iZzj;
        byte b;
        boolean z2;
        int i6;
        int iZzj2;
        boolean z3;
        super(i, zzbgVar, i2);
        this.zzh = zzxtVar;
        int i7 = 1;
        int i8 = true != zzxtVar.zzT ? 16 : 24;
        boolean z4 = zzxtVar.zzP;
        this.zzg = zzyi.zzi(this.zzd.zzd);
        this.zzi = zzlp.zzaa(i3, false);
        int i9 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i9 >= zzxtVar.zzq.size()) {
                iZzj = 0;
                i9 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzyi.zzj(this.zzd, (String) zzxtVar.zzq.get(i9), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        this.zzk = i9;
        this.zzj = iZzj;
        int i10 = this.zzd.zzf;
        int i11 = zzxtVar.zzs;
        this.zzl = zzyi.zzm(i10, 0);
        this.zzm = zzyi.zzn(this.zzd, zzxtVar.zzr);
        zzv zzvVar = this.zzd;
        int i12 = zzvVar.zzf;
        this.zzn = i12 == 0 || (i12 & 1) != 0;
        this.zzq = 1 == (zzvVar.zze & 1);
        String str = zzvVar.zzo;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -2123537834) {
                if (iHashCode != 187078297) {
                    if (iHashCode == 1504698186 && str.equals("audio/iamf")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (str.equals("audio/ac4")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (str.equals("audio/eac3-joc")) {
                b = 0;
            } else {
                b = -1;
            }
            if (b == 0 || b == 1 || b == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        this.zzx = z2;
        this.zzr = zzvVar.zzG;
        this.zzs = zzvVar.zzH;
        this.zzt = zzvVar.zzj;
        int i13 = zzvVar.zzj;
        this.zzf = (i13 == -1 || i13 <= zzxtVar.zzu) && ((i6 = zzvVar.zzG) == -1 || i6 <= zzxtVar.zzt) && zzgmeVar.zza(zzvVar);
        String str2 = zzep.zza;
        String[] strArrSplit = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            strArrSplit[i14] = zzep.zzh(strArrSplit[i14]);
        }
        int i15 = 0;
        while (true) {
            if (i15 >= strArrSplit.length) {
                iZzj2 = 0;
                i15 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj2 = zzyi.zzj(this.zzd, strArrSplit[i15], false);
                if (iZzj2 > 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.zzo = i15;
        this.zzp = iZzj2;
        for (int i16 = 0; i16 < zzxtVar.zzv.size(); i16++) {
            String str3 = this.zzd.zzo;
            if (str3 != null && str3.equals(zzxtVar.zzv.get(i16))) {
                i5 = i16;
                break;
            }
        }
        this.zzu = i5;
        this.zzv = (i3 & 384) == 128;
        this.zzw = (i3 & 64) == 64;
        zzxt zzxtVar2 = this.zzh;
        if (zzlp.zzaa(i3, zzxtVar2.zzV) && ((z3 = this.zzf) || zzxtVar2.zzO)) {
            int i17 = zzxtVar2.zzw.zzb;
            if (zzlp.zzaa(i3, false) && z3 && this.zzd.zzj != -1) {
                boolean z5 = zzxtVar2.zzG;
                boolean z6 = zzxtVar2.zzF;
                if ((zzxtVar2.zzX || !z) && (i8 & i3) != 0) {
                    i7 = 2;
                }
            }
        } else {
            i7 = 0;
        }
        this.zze = i7;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final /* bridge */ /* synthetic */ boolean zzc(zzya zzyaVar) {
        String str;
        zzxt zzxtVar = this.zzh;
        zzxf zzxfVar = (zzxf) zzyaVar;
        boolean z = zzxtVar.zzR;
        zzv zzvVar = this.zzd;
        int i = zzvVar.zzG;
        if (i == -1) {
            return false;
        }
        zzv zzvVar2 = zzxfVar.zzd;
        if (i != zzvVar2.zzG || (str = zzvVar.zzo) == null || !TextUtils.equals(str, zzvVar2.zzo)) {
            return false;
        }
        boolean z2 = zzxtVar.zzQ;
        int i2 = zzvVar.zzH;
        if (i2 == -1 || i2 != zzvVar2.zzH) {
            return false;
        }
        boolean z3 = zzxtVar.zzS;
        return this.zzv == zzxfVar.zzv && this.zzw == zzxfVar.zzw;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxf zzxfVar) {
        boolean z = this.zzf;
        zzgqy zzgqyVarZza = (z && this.zzi) ? zzyi.zzc : zzyi.zzc.zza();
        zzgot zzgotVarZza = zzgot.zzg().zzd(this.zzi, zzxfVar.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzxfVar.zzk), zzgqy.zzb().zza()).zzb(this.zzj, zzxfVar.zzj).zzb(this.zzl, zzxfVar.zzl).zza(Integer.valueOf(this.zzm), Integer.valueOf(zzxfVar.zzm), zzgqy.zzb().zza()).zzd(this.zzq, zzxfVar.zzq).zzd(this.zzn, zzxfVar.zzn).zza(Integer.valueOf(this.zzo), Integer.valueOf(zzxfVar.zzo), zzgqy.zzb().zza()).zzb(this.zzp, zzxfVar.zzp).zzd(z, zzxfVar.zzf).zza(Integer.valueOf(this.zzu), Integer.valueOf(zzxfVar.zzu), zzgqy.zzb().zza());
        boolean z2 = this.zzh.zzF;
        zzgot zzgotVarZza2 = zzgotVarZza.zzd(this.zzv, zzxfVar.zzv).zzd(this.zzw, zzxfVar.zzw).zzd(this.zzx, zzxfVar.zzx).zza(Integer.valueOf(this.zzr), Integer.valueOf(zzxfVar.zzr), zzgqyVarZza).zza(Integer.valueOf(this.zzs), Integer.valueOf(zzxfVar.zzs), zzgqyVarZza);
        if (Objects.equals(this.zzg, zzxfVar.zzg)) {
            zzgotVarZza2 = zzgotVarZza2.zza(Integer.valueOf(this.zzt), Integer.valueOf(zzxfVar.zzt), zzgqyVarZza);
        }
        return zzgotVarZza2.zze();
    }
}
