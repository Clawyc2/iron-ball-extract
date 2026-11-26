package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekg {
    private final zzgvb zzc;
    private zzekw zzf;
    private final String zzh;
    private final int zzi;
    private final zzekv zzj;
    private zzffu zzk;
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private int zzg = Integer.MAX_VALUE;
    private boolean zzl = false;

    zzekg(zzfgf zzfgfVar, zzekv zzekvVar, zzgvb zzgvbVar) {
        this.zzi = zzfgfVar.zzb.zzb.zzr;
        this.zzj = zzekvVar;
        this.zzc = zzgvbVar;
        this.zzh = zzelc.zzb(zzfgfVar);
        List list = zzfgfVar.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzffu) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized boolean zze() {
        if (this.zzl) {
            return false;
        }
        List list = this.zzb;
        if (!list.isEmpty() && ((zzffu) list.get(0)).zzav && !this.zzd.isEmpty()) {
            return false;
        }
        if (!zzd()) {
            List list2 = this.zzd;
            if (list2.size() < this.zzi && zzf(false)) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzf(boolean z) {
        for (zzffu zzffuVar : this.zzb) {
            Integer num = (Integer) this.zza.get(zzffuVar);
            Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
            if (z || !this.zze.contains(zzffuVar.zzat)) {
                if (numValueOf.intValue() < this.zzg) {
                    return true;
                }
                if (numValueOf.intValue() > this.zzg) {
                    break;
                }
            }
        }
        return false;
    }

    private final synchronized boolean zzg() {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) this.zza.get((zzffu) it.next());
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    private final synchronized boolean zzh() {
        return zzf(true) || zzg();
    }

    private final synchronized void zzi() {
        this.zzj.zzd(this.zzk);
        zzekw zzekwVar = this.zzf;
        if (zzekwVar != null) {
            this.zzc.zza(zzekwVar);
        } else {
            this.zzc.zzb(new zzekz(3, this.zzh));
        }
    }

    @Nullable
    final synchronized zzffu zza() {
        if (zze()) {
            int i = 0;
            while (true) {
                List list = this.zzb;
                if (i >= list.size()) {
                    break;
                }
                zzffu zzffuVar = (zzffu) list.get(i);
                String str = zzffuVar.zzat;
                Set set = this.zze;
                if (!set.contains(str)) {
                    if (zzffuVar.zzav) {
                        this.zzl = true;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        set.add(str);
                    }
                    this.zzd.add(zzffuVar);
                    return (zzffu) list.remove(i);
                }
                i++;
            }
        }
        return null;
    }

    final synchronized void zzb(zzekw zzekwVar, zzffu zzffuVar) {
        this.zzl = false;
        this.zzd.remove(zzffuVar);
        if (zzd()) {
            zzekwVar.zzm();
            return;
        }
        Integer num = (Integer) this.zza.get(zzffuVar);
        Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (numValueOf.intValue() > this.zzg) {
            this.zzj.zzf(zzffuVar);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzf(this.zzk);
        }
        this.zzg = numValueOf.intValue();
        this.zzf = zzekwVar;
        this.zzk = zzffuVar;
        if (zzh()) {
            return;
        }
        zzi();
    }

    final synchronized void zzc(Throwable th, zzffu zzffuVar) {
        this.zzl = false;
        this.zzd.remove(zzffuVar);
        this.zze.remove(zzffuVar.zzat);
        if (zzd() || zzh()) {
            return;
        }
        zzi();
    }

    final synchronized boolean zzd() {
        return this.zzc.isDone();
    }
}
