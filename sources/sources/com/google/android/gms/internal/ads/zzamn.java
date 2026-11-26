package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.primitives.SignedBytes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamn implements zzaod {
    private final List zza;

    public zzamn() {
        this(0);
    }

    public zzamn(int i, List list) {
        this.zza = list;
    }

    private final zzant zzc(zzaoc zzaocVar) {
        return new zzant(zze(zzaocVar), "video/mp2t");
    }

    private final zzaoi zzd(zzaoc zzaocVar) {
        return new zzaoi(zze(zzaocVar), "video/mp2t");
    }

    private final List zze(zzaoc zzaocVar) {
        String str;
        int i;
        List listSingletonList;
        zzeg zzegVar = new zzeg(zzaocVar.zze);
        List arrayList = this.zza;
        while (zzegVar.zzd() > 0) {
            int iZzs = zzegVar.zzs();
            int iZzg = zzegVar.zzg() + zzegVar.zzs();
            if (iZzs == 134) {
                arrayList = new ArrayList();
                int iZzs2 = zzegVar.zzs() & 31;
                for (int i2 = 0; i2 < iZzs2; i2++) {
                    String strZzK = zzegVar.zzK(3, StandardCharsets.UTF_8);
                    int iZzs3 = zzegVar.zzs();
                    boolean z = (iZzs3 & 128) != 0;
                    if (z) {
                        i = iZzs3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bZzs = (byte) zzegVar.zzs();
                    zzegVar.zzk(1);
                    if (z) {
                        int i3 = bZzs & SignedBytes.MAX_POWER_OF_TWO;
                        int i4 = zzdd.zza;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzt zztVar = new zzt();
                    zztVar.zzm(str);
                    zztVar.zze(strZzK);
                    zztVar.zzJ(i);
                    zztVar.zzp(listSingletonList);
                    arrayList.add(zztVar.zzM());
                }
            }
            zzegVar.zzh(iZzg);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaod
    public final SparseArray zza() {
        return new SparseArray();
    }

    public zzamn(int i) {
        this.zza = zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzaod
    public final zzaof zzb(int i, zzaoc zzaocVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzanj(new zzanc(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
            }
            if (i == 21) {
                return new zzanj(new zzana("video/mp2t"));
            }
            if (i == 27) {
                return new zzanj(new zzamx(zzc(zzaocVar), false, false, "video/mp2t"));
            }
            if (i == 36) {
                return new zzanj(new zzamz(zzc(zzaocVar), "video/mp2t"));
            }
            if (i == 45) {
                return new zzanj(new zzand("video/mp2t"));
            }
            if (i == 89) {
                return new zzanj(new zzamp(zzaocVar.zzd, "video/mp2t"));
            }
            if (i == 172) {
                return new zzanj(new zzamj(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
            }
            if (i == 257) {
                return new zzanr(new zzani("application/vnd.dvb.ait", "video/mp2t"));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzanj(new zzamo(zzaocVar.zzb, zzaocVar.zza(), 5408, "video/mp2t"));
                        }
                        switch (i) {
                            case 15:
                                return new zzanj(new zzamm(false, zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
                            case 16:
                                return new zzanj(new zzamv(zzd(zzaocVar), "video/mp2t"));
                            case 17:
                                return new zzanj(new zzanb(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzanr(new zzani("application/x-scte35", "video/mp2t"));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzanj(new zzamo(zzaocVar.zzb, zzaocVar.zza(), 4096, "video/mp2t"));
                }
                return new zzanj(new zzamg(zzaocVar.zzb, zzaocVar.zza(), "video/mp2t"));
            }
        }
        return new zzanj(new zzams(zzd(zzaocVar), "video/mp2t"));
    }
}
