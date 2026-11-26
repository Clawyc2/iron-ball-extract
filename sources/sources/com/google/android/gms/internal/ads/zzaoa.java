package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaoa implements zzada {
    private final int zza;
    private final List zzb;
    private final zzeg zzc;
    private final SparseIntArray zzd;
    private final zzaod zze;
    private final zzakg zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzanw zzj;
    private zzanv zzk;
    private zzadd zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    static {
        int i = zzanz.zza;
    }

    @Deprecated
    public zzaoa() {
        this(1, 1, zzakg.zza, new zzem(0L), new zzamn(0), 112800);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        byte[] bArrZzi = this.zzc.zzi();
        zzacr zzacrVar = (zzacr) zzadbVar;
        zzacrVar.zzh(bArrZzi, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    zzacrVar.zze(i, false);
                    return true;
                }
                if (bArrZzi[(i2 * 188) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        if (this.zza == 0) {
            zzaddVar = new zzakj(zzaddVar, this.zzf);
        }
        this.zzl = zzaddVar;
    }

    /* JADX WARN: Code duplicated, block: B:96:0x019c  */
    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        long j;
        long jZzo = zzadbVar.zzo();
        long j2 = -1;
        if (this.zzn) {
            if (jZzo != -1) {
                zzanw zzanwVar = this.zzj;
                if (!zzanwVar.zza()) {
                    return zzanwVar.zzb(zzadbVar, zzaeaVar, this.zzr);
                }
            }
            if (this.zzo) {
                j = 0;
            } else {
                this.zzo = true;
                zzanw zzanwVar2 = this.zzj;
                if (zzanwVar2.zzc() != -9223372036854775807L) {
                    j = 0;
                    zzanv zzanvVar = new zzanv(zzanwVar2.zzd(), zzanwVar2.zzc(), jZzo, this.zzr, 112800);
                    this.zzk = zzanvVar;
                    this.zzl.zzw(zzanvVar.zza());
                } else {
                    j = 0;
                    this.zzl.zzw(new zzaec(zzanwVar2.zzc(), 0L));
                }
            }
            if (this.zzp) {
                this.zzp = false;
                zze(j, j);
                if (zzadbVar.zzn() != j) {
                    zzaeaVar.zza = j;
                    return 1;
                }
            }
            zzanv zzanvVar2 = this.zzk;
            if (zzanvVar2 != null && zzanvVar2.zzc()) {
                return zzanvVar2.zzd(zzadbVar, zzaeaVar);
            }
        } else {
            j2 = -1;
        }
        zzeg zzegVar = this.zzc;
        byte[] bArrZzi = zzegVar.zzi();
        if (9400 - zzegVar.zzg() < 188) {
            int iZzd = zzegVar.zzd();
            if (iZzd > 0) {
                System.arraycopy(bArrZzi, zzegVar.zzg(), bArrZzi, 0, iZzd);
            }
            zzegVar.zzb(bArrZzi, iZzd);
        }
        while (zzegVar.zzd() < 188) {
            int iZze = zzegVar.zze();
            int iZza = zzadbVar.zza(bArrZzi, iZze, 9400 - iZze);
            if (iZza == -1) {
                int i = 0;
                while (true) {
                    SparseArray sparseArray = this.zzg;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzaof zzaofVar = (zzaof) sparseArray.valueAt(i);
                    if (zzaofVar instanceof zzanj) {
                        zzanj zzanjVar = (zzanj) zzaofVar;
                        if (zzanjVar.zzd(false)) {
                            zzanjVar.zzc(new zzeg(), 1);
                        }
                    }
                    i++;
                }
            } else {
                zzegVar.zzf(iZze + iZza);
            }
        }
        int iZzg = zzegVar.zzg();
        int iZze2 = zzegVar.zze();
        int iZza2 = zzaog.zza(zzegVar.zzi(), iZzg, iZze2);
        zzegVar.zzh(iZza2);
        int i2 = iZza2 + 188;
        if (i2 > iZze2) {
            this.zzq += iZza2 - iZzg;
        } else {
            this.zzq = 0;
        }
        int iZze3 = zzegVar.zze();
        if (i2 > iZze3) {
            return 0;
        }
        int iZzB = zzegVar.zzB();
        if ((8388608 & iZzB) != 0) {
            zzegVar.zzh(i2);
            return 0;
        }
        int i3 = (4194304 & iZzB) != 0 ? 1 : 0;
        int i4 = iZzB & 32;
        int i5 = (iZzB >> 8) & 8191;
        zzaof zzaofVar2 = (iZzB & 16) != 0 ? (zzaof) this.zzg.get(i5) : null;
        if (zzaofVar2 == null) {
            zzegVar.zzh(i2);
            return 0;
        }
        int i6 = iZzB & 15;
        SparseIntArray sparseIntArray = this.zzd;
        int i7 = sparseIntArray.get(i5, i6 - 1);
        sparseIntArray.put(i5, i6);
        if (i7 == i6) {
            zzegVar.zzh(i2);
            return 0;
        }
        if (i6 != ((i7 + 1) & 15)) {
            zzaofVar2.zzb();
        }
        if (i4 != 0) {
            int iZzs = zzegVar.zzs();
            i3 |= (zzegVar.zzs() & 64) != 0 ? 2 : 0;
            zzegVar.zzk(iZzs - 1);
        }
        boolean z = this.zzn;
        if (z || !this.zzi.get(i5, false)) {
            zzegVar.zzf(i2);
            zzaofVar2.zzc(zzegVar, i3);
            zzegVar.zzf(iZze3);
            if (!z) {
                if (this.zzn && jZzo != j2) {
                    this.zzp = true;
                }
            }
        } else if (this.zzn) {
            this.zzp = true;
        }
        zzegVar.zzh(i2);
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        zzanv zzanvVar;
        List list = this.zzb;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zzem zzemVar = (zzem) list.get(i);
            if (zzemVar.zzc() != -9223372036854775807L) {
                long jZza = zzemVar.zza();
                if (jZza != -9223372036854775807L && jZza != 0 && jZza != j2) {
                    zzemVar.zzd(j2);
                }
            } else {
                zzemVar.zzd(j2);
            }
        }
        if (j2 != 0 && (zzanvVar = this.zzk) != null) {
            zzanvVar.zzb(j2);
        }
        this.zzc.zza(0);
        this.zzd.clear();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzg;
            if (i2 >= sparseArray.size()) {
                this.zzq = 0;
                return;
            } else {
                ((zzaof) sparseArray.valueAt(i2)).zzb();
                i2++;
            }
        }
    }

    final /* synthetic */ List zzg() {
        return this.zzb;
    }

    final /* synthetic */ zzaod zzh() {
        return this.zze;
    }

    final /* synthetic */ SparseArray zzi() {
        return this.zzg;
    }

    final /* synthetic */ SparseBooleanArray zzj() {
        return this.zzh;
    }

    final /* synthetic */ SparseBooleanArray zzk() {
        return this.zzi;
    }

    final /* synthetic */ zzadd zzl() {
        return this.zzl;
    }

    final /* synthetic */ int zzm() {
        return this.zzm;
    }

    final /* synthetic */ void zzn(int i) {
        this.zzm = i;
    }

    final /* synthetic */ void zzo(boolean z) {
        this.zzn = true;
    }

    final /* synthetic */ void zzp(int i) {
        this.zzr = i;
    }

    public zzaoa(int i, int i2, zzakg zzakgVar, zzem zzemVar, zzaod zzaodVar, int i3) {
        this.zze = zzaodVar;
        this.zza = i2;
        this.zzf = zzakgVar;
        this.zzb = Collections.singletonList(zzemVar);
        this.zzc = new zzeg(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzanw(112800);
        this.zzl = zzadd.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArrayZza = zzaodVar.zza();
        int size = sparseArrayZza.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArrayZza.keyAt(i4), (zzaof) sparseArrayZza.valueAt(i4));
        }
        this.zzg.put(0, new zzanr(new zzanx(this)));
    }
}
