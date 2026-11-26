package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjy extends zzf {
    private final zzjx zza;
    private zzek zzb;
    private volatile Boolean zzc;
    private final zzap zzd;
    private final zzkp zze;
    private final List zzf;
    private final zzap zzg;

    protected zzjy(zzge zzgeVar) {
        super(zzgeVar);
        this.zzf = new ArrayList();
        this.zze = new zzkp(zzgeVar.zzav());
        this.zza = new zzjx(this);
        this.zzd = new zzji(this, zzgeVar);
        this.zzg = new zzjk(this, zzgeVar);
    }

    private final zzq zzO(boolean z) {
        Pair pairZza;
        this.zzs.zzaw();
        zzel zzelVarZzh = this.zzs.zzh();
        String str = null;
        if (z) {
            zzeu zzeuVarZzay = this.zzs.zzay();
            if (zzeuVarZzay.zzs.zzm().zzb != null && (pairZza = zzeuVarZzay.zzs.zzm().zzb.zza()) != null && pairZza != zzfj.zza) {
                str = String.valueOf(pairZza.second) + ":" + ((String) pairZza.first);
            }
        }
        return zzelVarZzh.zzj(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzP() {
        zzg();
        this.zzs.zzay().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        Iterator it = this.zzf.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                this.zzs.zzay().zzd().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ() {
        zzg();
        this.zze.zzb();
        zzap zzapVar = this.zzd;
        this.zzs.zzf();
        zzapVar.zzd(((Long) zzeh.zzI.zza(null)).longValue());
    }

    private final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzs.zzf();
        if (size >= 1000) {
            this.zzs.zzay().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.zzd(60000L);
        zzr();
    }

    private final boolean zzS() {
        this.zzs.zzaw();
        return true;
    }

    static /* bridge */ /* synthetic */ void zzo(zzjy zzjyVar, ComponentName componentName) {
        zzjyVar.zzg();
        if (zzjyVar.zzb != null) {
            zzjyVar.zzb = null;
            zzjyVar.zzs.zzay().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjyVar.zzg();
            zzjyVar.zzr();
        }
    }

    protected final void zzA(zzaw zzawVar, String str) {
        Preconditions.checkNotNull(zzawVar);
        zzg();
        zza();
        zzS();
        zzR(new zzjn(this, true, zzO(true), this.zzs.zzi().zzo(zzawVar), zzawVar, str));
    }

    public final void zzB(com.google.android.gms.internal.measurement.zzcf zzcfVar, zzaw zzawVar, String str) {
        zzg();
        zza();
        if (this.zzs.zzv().zzo(12451000) == 0) {
            zzR(new zzjj(this, zzawVar, str, zzcfVar));
        } else {
            this.zzs.zzay().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.zzs.zzv().zzS(zzcfVar, new byte[0]);
        }
    }

    protected final void zzC() {
        zzg();
        zza();
        zzq zzqVarZzO = zzO(false);
        zzS();
        this.zzs.zzi().zzj();
        zzR(new zzjc(this, zzqVarZzO));
    }

    final void zzD(zzek zzekVar, AbstractSafeParcelable abstractSafeParcelable, zzq zzqVar) {
        int size;
        zzg();
        zza();
        zzS();
        this.zzs.zzf();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList();
            List listZzi = this.zzs.zzi().zzi(100);
            if (listZzi != null) {
                arrayList.addAll(listZzi);
                size = listZzi.size();
            } else {
                size = 0;
            }
            if (abstractSafeParcelable != null && size < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i3);
                if (abstractSafeParcelable2 instanceof zzaw) {
                    try {
                        zzekVar.zzk((zzaw) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e) {
                        this.zzs.zzay().zzd().zzb("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzli) {
                    try {
                        zzekVar.zzt((zzli) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e2) {
                        this.zzs.zzay().zzd().zzb("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzekVar.zzn((zzac) abstractSafeParcelable2, zzqVar);
                    } catch (RemoteException e3) {
                        this.zzs.zzay().zzd().zzb("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    this.zzs.zzay().zzd().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    protected final void zzE(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzg();
        zza();
        this.zzs.zzaw();
        zzR(new zzjo(this, true, zzO(true), this.zzs.zzi().zzn(zzacVar), new zzac(zzacVar), zzacVar));
    }

    protected final void zzF(boolean z) {
        zzg();
        zza();
        if (z) {
            zzS();
            this.zzs.zzi().zzj();
        }
        if (zzM()) {
            zzR(new zzjm(this, zzO(false)));
        }
    }

    protected final void zzG(zziq zziqVar) {
        zzg();
        zza();
        zzR(new zzjg(this, zziqVar));
    }

    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        zzR(new zzjh(this, zzO(false), bundle));
    }

    protected final void zzI() {
        zzg();
        zza();
        zzR(new zzjl(this, zzO(true)));
    }

    protected final void zzJ(zzek zzekVar) {
        zzg();
        Preconditions.checkNotNull(zzekVar);
        this.zzb = zzekVar;
        zzQ();
        zzP();
    }

    protected final void zzK(zzli zzliVar) {
        zzg();
        zza();
        zzS();
        zzR(new zzja(this, zzO(true), this.zzs.zzi().zzp(zzliVar), zzliVar));
    }

    public final boolean zzL() {
        zzg();
        zza();
        return this.zzb != null;
    }

    final boolean zzM() {
        zzg();
        zza();
        return !zzN() || this.zzs.zzv().zzm() >= ((Integer) zzeh.zzaf.zza(null)).intValue();
    }

    final boolean zzN() {
        zzg();
        zza();
        if (this.zzc == null) {
            zzg();
            zza();
            zzfj zzfjVarZzm = this.zzs.zzm();
            zzfjVarZzm.zzg();
            boolean z = false;
            Boolean boolValueOf = !zzfjVarZzm.zza().contains("use_service") ? null : Boolean.valueOf(zzfjVarZzm.zza().getBoolean("use_service", false));
            boolean z2 = true;
            if (boolValueOf == null || !boolValueOf.booleanValue()) {
                this.zzs.zzaw();
                if (this.zzs.zzh().zzh() == 1) {
                    z = true;
                } else {
                    this.zzs.zzay().zzj().zza("Checking service availability");
                    int iZzo = this.zzs.zzv().zzo(12451000);
                    if (iZzo == 0) {
                        this.zzs.zzay().zzj().zza("Service available");
                    } else if (iZzo == 1) {
                        this.zzs.zzay().zzj().zza("Service missing");
                    } else if (iZzo != 2) {
                        if (iZzo == 3) {
                            this.zzs.zzay().zzk().zza("Service disabled");
                        } else if (iZzo == 9) {
                            this.zzs.zzay().zzk().zza("Service invalid");
                        } else if (iZzo != 18) {
                            this.zzs.zzay().zzk().zzb("Unexpected service status", Integer.valueOf(iZzo));
                        } else {
                            this.zzs.zzay().zzk().zza("Service updating");
                        }
                        z2 = false;
                    } else {
                        this.zzs.zzay().zzc().zza("Service container out of date");
                        if (this.zzs.zzv().zzm() >= 17443) {
                            z = boolValueOf == null;
                            z2 = false;
                        }
                    }
                    z = true;
                }
                if (!z && this.zzs.zzf().zzx()) {
                    this.zzs.zzay().zzd().zza("No way to upload. Consider using the full version of Analytics");
                } else if (z2) {
                    zzfj zzfjVarZzm2 = this.zzs.zzm();
                    zzfjVarZzm2.zzg();
                    SharedPreferences.Editor editorEdit = zzfjVarZzm2.zza().edit();
                    editorEdit.putBoolean("use_service", z);
                    editorEdit.apply();
                }
                z2 = z;
            }
            this.zzc = Boolean.valueOf(z2);
        }
        return this.zzc.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    final Boolean zzj() {
        return this.zzc;
    }

    protected final void zzq() {
        zzg();
        zza();
        zzq zzqVarZzO = zzO(true);
        this.zzs.zzi().zzk();
        zzR(new zzjf(this, zzqVarZzO));
    }

    final void zzr() {
        zzg();
        zza();
        if (zzL()) {
            return;
        }
        if (zzN()) {
            this.zza.zzc();
            return;
        }
        if (this.zzs.zzf().zzx()) {
            return;
        }
        this.zzs.zzaw();
        List<ResolveInfo> listQueryIntentServices = this.zzs.zzau().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzs.zzau(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            this.zzs.zzay().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextZzau = this.zzs.zzau();
        this.zzs.zzaw();
        intent.setComponent(new ComponentName(contextZzau, "com.google.android.gms.measurement.AppMeasurementService"));
        this.zza.zzb(intent);
    }

    public final void zzs() {
        zzg();
        zza();
        this.zza.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzs.zzau(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzcf zzcfVar) {
        zzg();
        zza();
        zzR(new zzje(this, zzO(false), zzcfVar));
    }

    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new zzjd(this, atomicReference, zzO(false)));
    }

    protected final void zzv(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2) {
        zzg();
        zza();
        zzR(new zzjq(this, str, str2, zzO(false), zzcfVar));
    }

    protected final void zzw(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzR(new zzjp(this, atomicReference, null, str2, str3, zzO(false)));
    }

    protected final void zzx(AtomicReference atomicReference, boolean z) {
        zzg();
        zza();
        zzR(new zzjb(this, atomicReference, zzO(false), z));
    }

    protected final void zzy(com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2, boolean z) {
        zzg();
        zza();
        zzR(new zziz(this, str, str2, zzO(false), z, zzcfVar));
    }

    protected final void zzz(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zza();
        zzR(new zzjr(this, atomicReference, null, str2, str3, zzO(false), z));
    }
}
