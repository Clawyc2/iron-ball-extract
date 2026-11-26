package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzany implements zzanq {
    final /* synthetic */ zzaoa zza;
    private final zzef zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzany(zzaoa zzaoaVar, int i) {
        Objects.requireNonNull(zzaoaVar);
        this.zza = zzaoaVar;
        this.zzb = new zzef(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:36:0x00f1  */
    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zzb(zzeg zzegVar) {
        int i;
        if (zzegVar.zzs() != 2) {
            return;
        }
        zzaoa zzaoaVar = this.zza;
        zzem zzemVar = (zzem) zzaoaVar.zzg().get(0);
        if ((zzegVar.zzs() & 128) != 0) {
            zzegVar.zzk(1);
            int iZzt = zzegVar.zzt();
            int i2 = 3;
            zzegVar.zzk(3);
            zzef zzefVar = this.zzb;
            zzegVar.zzl(zzefVar, 2);
            zzefVar.zzh(3);
            int i3 = 13;
            zzaoaVar.zzp(zzefVar.zzj(13));
            zzegVar.zzl(zzefVar, 2);
            int i4 = 4;
            zzefVar.zzh(4);
            int i5 = 12;
            zzegVar.zzk(zzefVar.zzj(12));
            SparseArray sparseArray = this.zzc;
            sparseArray.clear();
            SparseIntArray sparseIntArray = this.zzd;
            sparseIntArray.clear();
            int iZzd = zzegVar.zzd();
            while (iZzd > 0) {
                int i6 = 5;
                zzegVar.zzl(zzefVar, 5);
                int iZzj = zzefVar.zzj(8);
                zzefVar.zzh(i2);
                int iZzj2 = zzefVar.zzj(i3);
                zzefVar.zzh(i4);
                int iZzj3 = zzefVar.zzj(i5);
                int iZzg = zzegVar.zzg();
                int i7 = iZzg + iZzj3;
                String str = null;
                ArrayList arrayList = null;
                int i8 = -1;
                int iZzs = 0;
                while (zzegVar.zzg() < i7) {
                    int iZzs2 = zzegVar.zzs();
                    int iZzg2 = zzegVar.zzg() + zzegVar.zzs();
                    if (iZzg2 > i7) {
                        break;
                    }
                    if (iZzs2 == i6) {
                        long jZzz = zzegVar.zzz();
                        if (jZzz == 1094921523) {
                            zzaoaVar = zzaoaVar;
                            i8 = 129;
                        } else if (jZzz == 1161904947) {
                            zzaoaVar = zzaoaVar;
                            zzefVar = zzefVar;
                            iZzd = iZzd;
                            i8 = 135;
                            iZzg2 = iZzg2;
                        } else if (jZzz == 1094921524) {
                            zzaoaVar = zzaoaVar;
                            i8 = 172;
                        } else if (jZzz == 1212503619) {
                            i = 36;
                            i8 = i;
                        }
                    } else if (iZzs2 == 106) {
                        zzaoaVar = zzaoaVar;
                        i8 = 129;
                    } else if (iZzs2 == 122) {
                        zzaoaVar = zzaoaVar;
                        zzefVar = zzefVar;
                        iZzd = iZzd;
                        i8 = 135;
                        iZzg2 = iZzg2;
                    } else {
                        if (iZzs2 == 127) {
                            int iZzs3 = zzegVar.zzs();
                            if (iZzs3 == 21) {
                                zzaoaVar = zzaoaVar;
                                i8 = 172;
                            } else if (iZzs3 == 14) {
                                i = 136;
                            } else if (iZzs3 == 33) {
                                i = 139;
                            }
                        } else if (iZzs2 == 123) {
                            i = 138;
                        } else if (iZzs2 == 10) {
                            String strTrim = zzegVar.zzK(3, StandardCharsets.UTF_8).trim();
                            iZzs = zzegVar.zzs();
                            str = strTrim;
                        } else if (iZzs2 == 89) {
                            ArrayList arrayList2 = new ArrayList();
                            while (zzegVar.zzg() < iZzg2) {
                                int i9 = iZzg2;
                                String strTrim2 = zzegVar.zzK(3, StandardCharsets.UTF_8).trim();
                                int iZzs4 = zzegVar.zzs();
                                int i10 = iZzd;
                                byte[] bArr = new byte[4];
                                zzegVar.zzm(bArr, 0, 4);
                                arrayList2.add(new zzaob(strTrim2, iZzs4, bArr));
                                iZzd = i10;
                                iZzg2 = i9;
                                zzefVar = zzefVar;
                                zzaoaVar = zzaoaVar;
                            }
                            zzaoaVar = zzaoaVar;
                            iZzg2 = iZzg2;
                            zzefVar = zzefVar;
                            iZzd = iZzd;
                            arrayList = arrayList2;
                            i8 = 89;
                        } else {
                            zzaoaVar = zzaoaVar;
                            iZzg2 = iZzg2;
                            zzefVar = zzefVar;
                            iZzd = iZzd;
                            if (iZzs2 == 111) {
                                i8 = 257;
                            }
                        }
                        i8 = i;
                    }
                    zzegVar.zzk(iZzg2 - zzegVar.zzg());
                    iZzd = iZzd;
                    zzefVar = zzefVar;
                    zzaoaVar = zzaoaVar;
                    i6 = 5;
                }
                zzaoa zzaoaVar2 = zzaoaVar;
                zzef zzefVar2 = zzefVar;
                int i11 = iZzd;
                zzegVar.zzh(i7);
                zzaoc zzaocVar = new zzaoc(i8, str, iZzs, arrayList, Arrays.copyOfRange(zzegVar.zzi(), iZzg, i7));
                if (iZzj == 6 || iZzj == 5) {
                    iZzj = zzaocVar.zza;
                }
                iZzd = i11 - (iZzj3 + 5);
                if (!zzaoaVar2.zzj().get(iZzj2)) {
                    zzaof zzaofVarZzb = zzaoaVar2.zzh().zzb(iZzj, zzaocVar);
                    sparseIntArray.put(iZzj2, iZzj2);
                    sparseArray.put(iZzj2, zzaofVarZzb);
                }
                i4 = 4;
                zzefVar = zzefVar2;
                zzaoaVar = zzaoaVar2;
                i2 = 3;
                i3 = 13;
                i5 = 12;
            }
            zzaoa zzaoaVar3 = zzaoaVar;
            int size = sparseIntArray.size();
            for (int i12 = 0; i12 < size; i12++) {
                int iKeyAt = sparseIntArray.keyAt(i12);
                int iValueAt = sparseIntArray.valueAt(i12);
                zzaoaVar3.zzj().put(iKeyAt, true);
                zzaoaVar3.zzk().put(iValueAt, true);
                zzaof zzaofVar = (zzaof) sparseArray.valueAt(i12);
                if (zzaofVar != null) {
                    zzaofVar.zza(zzemVar, zzaoaVar3.zzl(), new zzaoe(iZzt, iKeyAt, 8192));
                    zzaoaVar3.zzi().put(iValueAt, zzaofVar);
                }
            }
            zzaoaVar3.zzi().remove(this.zze);
            zzaoaVar3.zzn(0);
            if (zzaoaVar3.zzm() == 0) {
                zzaoaVar3.zzl().zzv();
                zzaoaVar3.zzo(true);
            }
        }
    }
}
