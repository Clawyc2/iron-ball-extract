package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgvz {
    private final List zza = new ArrayList();
    private final zzhel zzb = zzhel.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final void zzc() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzgvx) it.next()).zzd(false);
        }
    }

    public final zzgvz zza(zzgvx zzgvxVar) {
        if (zzgvxVar.zzh() != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgvxVar.zzc()) {
            zzc();
        }
        zzgvxVar.zzi(this);
        this.zza.add(zzgvxVar);
        return this;
    }

    public final zzgwe zzb() throws GeneralSecurityException {
        int i;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        this.zzc = true;
        List<zzgvx> list = this.zza;
        zzhld zzhldVarZzh = zzhlg.zzh();
        ArrayList arrayList = new ArrayList(list.size());
        int i2 = 0;
        while (i2 < list.size() - 1) {
            int i3 = i2 + 1;
            if (((zzgvx) list.get(i2)).zzg() == zzgvy.zza && ((zzgvx) list.get(i3)).zzg() != zzgvy.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i2 = i3;
        }
        HashSet hashSet = new HashSet();
        byte[] bArr = null;
        Integer num = null;
        for (zzgvx zzgvxVar : list) {
            zzgvxVar.zze();
            if (zzgvxVar.zzg() == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (zzgvxVar.zzg() == zzgvy.zza) {
                int i4 = 0;
                while (true) {
                    if (i4 != 0 && !hashSet.contains(Integer.valueOf(i4))) {
                        break;
                    }
                    int i5 = zzhgi.zza;
                    i4 = 0;
                    while (i4 == 0) {
                        byte[] bArrZza = zzhfz.zza(4);
                        i4 = (bArrZza[3] & 255) | ((bArrZza[0] & 255) << 24) | ((bArrZza[1] & 255) << 16) | ((bArrZza[2] & 255) << 8);
                    }
                }
                i = i4;
            } else {
                zzgvxVar.zzg();
                i = 0;
            }
            Integer numValueOf = Integer.valueOf(i);
            if (hashSet.contains(numValueOf)) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 31);
                sb.append("Id ");
                sb.append(i);
                sb.append(" is used twice in the keyset");
                throw new GeneralSecurityException(sb.toString());
            }
            hashSet.add(numValueOf);
            zzgvt zzgvtVarZzc = zzhes.zza().zzc(zzgvxVar.zzf(), true != zzgvxVar.zzf().zza() ? null : numValueOf);
            zzgwc zzgwcVar = new zzgwc(zzgvtVarZzc, zzgwe.zzj(zzgvxVar.zze()), i, zzgvxVar.zzc(), false, zzgwc.zza, null);
            zzhldVarZzh.zzb(zzgwe.zzq(zzgvtVarZzc, zzgwe.zzj(zzgvxVar.zze()), i));
            if (zzgvxVar.zzc()) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgvxVar.zze() != zzgvv.zza) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzgwcVar);
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzhldVarZzh.zza(num.intValue());
        zzhlg zzhlgVar = (zzhlg) zzhldVarZzh.zzbu();
        zzgwe.zzn(zzhlgVar);
        return zzgwe.zzh(new zzgwe(zzhlgVar, arrayList, this.zzb, bArr));
    }
}
