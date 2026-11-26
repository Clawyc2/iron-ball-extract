package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzij extends zzf {
    protected zzii zza;
    final zzs zzb;
    protected boolean zzc;
    private zzhe zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private zzai zzi;
    private int zzj;
    private final AtomicLong zzk;
    private long zzl;
    private int zzm;
    private final zzlm zzn;

    protected zzij(zzge zzgeVar) {
        super(zzgeVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new zzhx(this);
        this.zzg = new AtomicReference();
        this.zzi = new zzai(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzs(zzgeVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(Boolean bool, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzm().zzh(bool);
        if (z) {
            zzfj zzfjVarZzm = this.zzs.zzm();
            zzge zzgeVar = zzfjVarZzm.zzs;
            zzfjVarZzm.zzg();
            SharedPreferences.Editor editorEdit = zzfjVarZzm.zza().edit();
            if (bool != null) {
                editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                editorEdit.remove("measurement_enabled_from_api");
            }
            editorEdit.apply();
        }
        if (this.zzs.zzK() || !(bool == null || bool.booleanValue())) {
            zzab();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzab() {
        zzij zzijVar;
        zzg();
        String strZza = this.zzs.zzm().zzh.zza();
        if (strZza == null) {
            zzijVar = this;
        } else if ("unset".equals(strZza)) {
            zzijVar = this;
            zzijVar.zzY("app", "_npa", null, this.zzs.zzav().currentTimeMillis());
        } else {
            zzijVar = this;
            zzijVar.zzY("app", "_npa", Long.valueOf(true != "true".equals(strZza) ? 0L : 1L), zzijVar.zzs.zzav().currentTimeMillis());
        }
        if (!zzijVar.zzs.zzJ() || !zzijVar.zzc) {
            zzijVar.zzs.zzay().zzc().zza("Updating Scion state (FE)");
            zzijVar.zzs.zzt().zzI();
            return;
        }
        zzijVar.zzs.zzay().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzok.zzc();
        if (zzijVar.zzs.zzf().zzs(null, zzeh.zzad)) {
            zzijVar.zzs.zzu().zza.zza();
        }
        zzijVar.zzs.zzaz().zzp(new zzhm(this));
    }

    static /* bridge */ /* synthetic */ void zzv(zzij zzijVar, zzai zzaiVar, zzai zzaiVar2) {
        boolean z;
        zzah[] zzahVarArr = {zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            zzah zzahVar = zzahVarArr[i];
            if (!zzaiVar2.zzi(zzahVar) && zzaiVar.zzi(zzahVar)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zZzl = zzaiVar.zzl(zzaiVar2, zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE);
        if (z || zZzl) {
            zzijVar.zzs.zzh().zzo();
        }
    }

    static /* synthetic */ void zzw(zzij zzijVar, zzai zzaiVar, int i, long j, boolean z, boolean z2) {
        zzijVar.zzg();
        zzijVar.zza();
        if (j <= zzijVar.zzl && zzai.zzj(zzijVar.zzm, i)) {
            zzijVar.zzs.zzay().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzaiVar);
            return;
        }
        zzfj zzfjVarZzm = zzijVar.zzs.zzm();
        zzge zzgeVar = zzfjVarZzm.zzs;
        zzfjVarZzm.zzg();
        if (!zzfjVarZzm.zzl(i)) {
            zzijVar.zzs.zzay().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        SharedPreferences.Editor editorEdit = zzfjVarZzm.zza().edit();
        editorEdit.putString("consent_settings", zzaiVar.zzh());
        editorEdit.putInt("consent_source", i);
        editorEdit.apply();
        zzijVar.zzl = j;
        zzijVar.zzm = i;
        zzijVar.zzs.zzt().zzF(z);
        if (z2) {
            zzijVar.zzs.zzt().zzu(new AtomicReference());
        }
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long jCurrentTimeMillis = this.zzs.zzav().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, jCurrentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzs.zzaz().zzp(new zzht(this, bundle2));
    }

    public final void zzB() {
        if (!(this.zzs.zzau().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) this.zzs.zzau().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzs.zzm().zzr.zzb(new Bundle());
            return;
        }
        Bundle bundleZza = this.zzs.zzm().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                if (this.zzs.zzv().zzaf(obj)) {
                    this.zzs.zzv().zzN(this.zzn, null, 27, null, null, 0);
                }
                this.zzs.zzay().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            } else if (zzln.zzah(str)) {
                this.zzs.zzay().zzl().zzb("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleZza.remove(str);
            } else {
                zzln zzlnVarZzv = this.zzs.zzv();
                this.zzs.zzf();
                if (zzlnVarZzv.zzaa("param", str, 100, obj)) {
                    this.zzs.zzv().zzO(bundleZza, str, obj);
                }
            }
        }
        this.zzs.zzv();
        int iZzc = this.zzs.zzf().zzc();
        if (bundleZza.size() > iZzc) {
            int i = 0;
            for (String str2 : new TreeSet(bundleZza.keySet())) {
                i++;
                if (i > iZzc) {
                    bundleZza.remove(str2);
                }
            }
            this.zzs.zzv().zzN(this.zzn, null, 26, null, null, 0);
            this.zzs.zzay().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzs.zzm().zzr.zzb(bundleZza);
        this.zzs.zzt().zzH(bundleZza);
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if (str2 == FirebaseAnalytics.Event.SCREEN_VIEW || (str2 != null && str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            this.zzs.zzs().zzx(bundle2, j);
            return;
        }
        boolean z3 = true;
        if (z2 && this.zzd != null && !zzln.zzah(str2)) {
            z3 = false;
        }
        zzM(str3, str2, j, bundle2, z2, z3, z, null);
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzge.zzO();
        zzM(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str2, this.zzs.zzav().currentTimeMillis(), bundle, false, true, true, str3);
    }

    final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzs.zzav().currentTimeMillis(), bundle);
    }

    final void zzH(String str, String str2, long j, Bundle bundle) {
        zzg();
        boolean z = true;
        if (this.zzd != null && !zzln.zzah(str2)) {
            z = false;
        }
        zzI(str, str2, j, bundle, true, z, true, null);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x010c  */
    /* JADX WARN: Multi-variable type inference failed */
    protected final void zzI(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        int i;
        long j2;
        String str4;
        Bundle[] bundleArr;
        int i2;
        String str5 = str;
        Preconditions.checkNotEmpty(str5);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        if (!this.zzs.zzJ()) {
            this.zzs.zzay().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List listZzn = this.zzs.zzh().zzn();
        if (listZzn != null && !listZzn.contains(str2)) {
            this.zzs.zzay().zzc().zzc("Dropping non-safelisted event. event name, origin", str2, str5);
            return;
        }
        if (!this.zzf) {
            this.zzf = true;
            try {
                try {
                    (!this.zzs.zzN() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzs.zzau().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, this.zzs.zzau());
                } catch (Exception e) {
                    this.zzs.zzay().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                this.zzs.zzay().zzi().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            this.zzs.zzaw();
            zzY(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lgclid", bundle.getString("gclid"), this.zzs.zzav().currentTimeMillis());
        }
        zzij zzijVar = this;
        zzijVar.zzs.zzaw();
        if (z && zzln.zzal(str2)) {
            zzijVar.zzs.zzv().zzL(bundle, zzijVar.zzs.zzm().zzr.zza());
        }
        if (!z3) {
            zzijVar.zzs.zzaw();
            if (!"_iap".equals(str2)) {
                zzln zzlnVarZzv = zzijVar.zzs.zzv();
                if (!zzlnVarZzv.zzac(NotificationCompat.CATEGORY_EVENT, str2)) {
                    i2 = 2;
                } else if (zzlnVarZzv.zzZ(NotificationCompat.CATEGORY_EVENT, zzhb.zza, zzhb.zzb, str2)) {
                    zzlnVarZzv.zzs.zzf();
                    if (zzlnVarZzv.zzY(NotificationCompat.CATEGORY_EVENT, 40, str2)) {
                        i2 = 0;
                    } else {
                        i2 = 2;
                    }
                } else {
                    i2 = 13;
                }
                if (i2 != 0) {
                    zzijVar.zzs.zzay().zze().zzb("Invalid public event name. Event will not be logged (FE)", zzijVar.zzs.zzj().zzd(str2));
                    zzln zzlnVarZzv2 = zzijVar.zzs.zzv();
                    zzijVar.zzs.zzf();
                    zzijVar.zzs.zzv().zzN(zzijVar.zzn, null, i2, "_ev", zzlnVarZzv2.zzD(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        zzpf.zzc();
        if (zzijVar.zzs.zzf().zzs(null, zzeh.zzak)) {
            zzijVar.zzs.zzaw();
            zziq zziqVarZzj = zzijVar.zzs.zzs().zzj(false);
            if (zziqVarZzj != null && !bundle.containsKey("_sc")) {
                zziqVarZzj.zzd = true;
            }
            zzln.zzK(zziqVarZzj, bundle, z && !z3);
        } else {
            zzijVar.zzs.zzaw();
            zziq zziqVarZzj2 = zzijVar.zzs.zzs().zzj(false);
            if (zziqVarZzj2 != null && !bundle.containsKey("_sc")) {
                zziqVarZzj2.zzd = true;
            }
            zzln.zzK(zziqVarZzj2, bundle, z && !z3);
        }
        boolean zEquals = "am".equals(str5);
        boolean zZzah = zzln.zzah(str2);
        if (!z || zzijVar.zzd == null || zZzah) {
            z4 = zEquals;
        } else {
            if (!zEquals) {
                zzijVar.zzs.zzay().zzc().zzc("Passing event to registered event handler (FE)", zzijVar.zzs.zzj().zzd(str2), zzijVar.zzs.zzj().zzb(bundle));
                Preconditions.checkNotNull(zzijVar.zzd);
                zzijVar.zzd.interceptEvent(str5, str2, bundle, j);
                return;
            }
            z4 = true;
        }
        if (zzijVar.zzs.zzM()) {
            int iZzh = zzijVar.zzs.zzv().zzh(str2);
            if (iZzh != 0) {
                zzijVar.zzs.zzay().zze().zzb("Invalid event name. Event will not be logged (FE)", zzijVar.zzs.zzj().zzd(str2));
                zzln zzlnVarZzv3 = zzijVar.zzs.zzv();
                zzijVar.zzs.zzf();
                zzijVar.zzs.zzv().zzN(zzijVar.zzn, str3, iZzh, "_ev", zzlnVarZzv3.zzD(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle bundleZzy = zzijVar.zzs.zzv().zzy(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(bundleZzy);
            zzijVar.zzs.zzaw();
            if (zzijVar.zzs.zzs().zzj(false) == null || !"_ae".equals(str2)) {
                i = 0;
                j2 = 0;
            } else {
                zzkm zzkmVar = zzijVar.zzs.zzu().zzb;
                j2 = 0;
                long jElapsedRealtime = zzkmVar.zzc.zzs.zzav().elapsedRealtime();
                i = 0;
                long j3 = jElapsedRealtime - zzkmVar.zzb;
                zzkmVar.zzb = jElapsedRealtime;
                if (j3 > 0) {
                    zzijVar.zzs.zzv().zzI(bundleZzy, j3);
                }
            }
            zzob.zzc();
            if (zzijVar.zzs.zzf().zzs(null, zzeh.zzac)) {
                if (!DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(str5) && "_ssr".equals(str2)) {
                    zzln zzlnVarZzv4 = zzijVar.zzs.zzv();
                    String string = bundleZzy.getString("_ffr");
                    if (Strings.isEmptyOrWhitespace(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    if (zzll.zza(string, zzlnVarZzv4.zzs.zzm().zzo.zza())) {
                        zzlnVarZzv4.zzs.zzay().zzc().zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    zzlnVarZzv4.zzs.zzm().zzo.zzb(string);
                } else if ("_ae".equals(str2)) {
                    String strZza = zzijVar.zzs.zzv().zzs.zzm().zzo.zza();
                    if (!TextUtils.isEmpty(strZza)) {
                        bundleZzy.putString("_ffr", strZza);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(bundleZzy);
            if (zzijVar.zzs.zzm().zzj.zza() > j2 && zzijVar.zzs.zzm().zzk(j) && zzijVar.zzs.zzm().zzl.zzb()) {
                zzijVar.zzs.zzay().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                str4 = "_ae";
                zzY(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sid", null, zzijVar.zzs.zzav().currentTimeMillis());
                zzY(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_sno", null, this.zzs.zzav().currentTimeMillis());
                zzY(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_se", null, this.zzs.zzav().currentTimeMillis());
                zzijVar = this;
            } else {
                str4 = "_ae";
            }
            if (bundleZzy.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                zzijVar.zzs.zzay().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                zzijVar.zzs.zzu().zza.zzb(j, true);
            }
            ArrayList arrayList2 = new ArrayList(bundleZzy.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i3 = i; i3 < size; i3++) {
                String str6 = (String) arrayList2.get(i3);
                if (str6 != null) {
                    zzijVar.zzs.zzv();
                    Object obj = bundleZzy.get(str6);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[1];
                        bundleArr[i] = (Bundle) obj;
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        bundleZzy.putParcelableArray(str6, bundleArr);
                    }
                }
            }
            int i4 = i;
            while (i4 < arrayList.size()) {
                ArrayList arrayList4 = arrayList;
                Bundle bundleZzt = (Bundle) arrayList4.get(i4);
                String str7 = i4 != 0 ? "_ep" : str2;
                bundleZzt.putString("_o", str5);
                if (z2) {
                    bundleZzt = zzijVar.zzs.zzv().zzt(bundleZzt);
                }
                String str8 = str5;
                Bundle bundle2 = bundleZzt;
                zzijVar.zzs.zzt().zzA(new zzaw(str7, new zzau(bundleZzt), str8, j), str3);
                if (!z4) {
                    Iterator it = zzijVar.zze.iterator();
                    while (it.hasNext()) {
                        ((zzhf) it.next()).onEvent(str, str2, new Bundle(bundle2), j);
                    }
                }
                i4++;
                str5 = str;
                j = j;
                arrayList = arrayList4;
            }
            zzijVar.zzs.zzaw();
            if (zzijVar.zzs.zzs().zzj(i) == null || !str4.equals(str2)) {
                return;
            }
            zzijVar.zzs.zzu().zzb.zzd(true, true, zzijVar.zzs.zzav().elapsedRealtime());
        }
    }

    public final void zzJ(zzhf zzhfVar) {
        zza();
        Preconditions.checkNotNull(zzhfVar);
        if (this.zze.add(zzhfVar)) {
            return;
        }
        this.zzs.zzay().zzk().zza("OnEventListener already registered");
    }

    public final void zzK(long j) {
        this.zzg.set(null);
        this.zzs.zzaz().zzp(new zzhr(this, j));
    }

    final void zzL(long j, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zza("Resetting analytics data (FE)");
        zzko zzkoVarZzu = this.zzs.zzu();
        zzkoVarZzu.zzg();
        zzkn zzknVar = zzkoVarZzu.zza;
        zzkoVarZzu.zzb.zza();
        zzpi.zzc();
        if (this.zzs.zzf().zzs(null, zzeh.zzaz)) {
            this.zzs.zzh().zzo();
        }
        boolean zZzJ = this.zzs.zzJ();
        zzfj zzfjVarZzm = this.zzs.zzm();
        zzfjVarZzm.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzfjVarZzm.zzs.zzm().zzo.zza())) {
            zzfjVarZzm.zzo.zzb(null);
        }
        zzok.zzc();
        if (zzfjVarZzm.zzs.zzf().zzs(null, zzeh.zzad)) {
            zzfjVarZzm.zzj.zzb(0L);
        }
        if (!zzfjVarZzm.zzs.zzf().zzv()) {
            zzfjVarZzm.zzi(!zZzJ);
        }
        zzfjVarZzm.zzp.zzb(null);
        zzfjVarZzm.zzq.zzb(0L);
        zzfjVarZzm.zzr.zzb(null);
        if (z) {
            this.zzs.zzt().zzC();
        }
        zzok.zzc();
        if (this.zzs.zzf().zzs(null, zzeh.zzad)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzc = !zZzJ;
    }

    protected final void zzM(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzs.zzaz().zzp(new zzho(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    final void zzN(String str, String str2, long j, Object obj) {
        this.zzs.zzaz().zzp(new zzhp(this, str, str2, obj, j));
    }

    final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzay().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzha.zza(bundle2, "app_id", String.class, null);
        zzha.zza(bundle2, "origin", String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzha.zza(bundle2, "value", Object.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzha.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle2.get("value");
        if (this.zzs.zzv().zzl(string) != 0) {
            this.zzs.zzay().zzd().zzb("Invalid conditional user property name", this.zzs.zzj().zzf(string));
            return;
        }
        if (this.zzs.zzv().zzd(string, obj) != 0) {
            this.zzs.zzay().zzd().zzc("Invalid conditional user property value", this.zzs.zzj().zzf(string), obj);
            return;
        }
        Object objZzB = this.zzs.zzv().zzB(string, obj);
        if (objZzB == null) {
            this.zzs.zzay().zzd().zzc("Unable to normalize conditional user property value", this.zzs.zzj().zzf(string), obj);
            return;
        }
        zzha.zzb(bundle2, objZzB);
        long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
        if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
            this.zzs.zzf();
            if (j2 > 15552000000L || j2 < 1) {
                this.zzs.zzay().zzd().zzc("Invalid conditional user property timeout", this.zzs.zzj().zzf(string), Long.valueOf(j2));
                return;
            }
        }
        long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
        this.zzs.zzf();
        if (j3 > 15552000000L || j3 < 1) {
            this.zzs.zzay().zzd().zzc("Invalid conditional user property time to live", this.zzs.zzj().zzf(string), Long.valueOf(j3));
        } else {
            this.zzs.zzaz().zzp(new zzhs(this, bundle2));
        }
    }

    public final void zzR(Bundle bundle, int i, long j) {
        zza();
        String strZzg = zzai.zzg(bundle);
        if (strZzg != null) {
            this.zzs.zzay().zzl().zzb("Ignoring invalid consent setting", strZzg);
            this.zzs.zzay().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), i, j);
    }

    public final void zzS(zzai zzaiVar, int i, long j) {
        boolean zZzk;
        boolean z;
        boolean z2;
        zza();
        if (i != -10 && zzaiVar.zze() == null && zzaiVar.zzf() == null) {
            this.zzs.zzay().zzl().zza("Discarding empty consent settings");
            return;
        }
        synchronized (this.zzh) {
            try {
                zzai zzaiVar2 = this.zzi;
                boolean z3 = false;
                if (zzai.zzj(i, this.zzj)) {
                    try {
                        zZzk = zzaiVar.zzk(this.zzi);
                        z = true;
                        if (zzaiVar.zzi(zzah.ANALYTICS_STORAGE) && !this.zzi.zzi(zzah.ANALYTICS_STORAGE)) {
                            z3 = true;
                        }
                        zzaiVar = zzaiVar.zzd(this.zzi);
                        this.zzi = zzaiVar;
                        this.zzj = i;
                        z2 = z3;
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                } else {
                    zZzk = false;
                    z = false;
                    z2 = false;
                }
                zzai zzaiVar3 = zzaiVar;
                if (!z) {
                    this.zzs.zzay().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzaiVar3);
                    return;
                }
                long andIncrement = this.zzk.getAndIncrement();
                if (zZzk) {
                    this.zzg.set(null);
                    this.zzs.zzaz().zzq(new zzid(this, zzaiVar3, j, i, andIncrement, z2, zzaiVar2));
                    return;
                }
                zzie zzieVar = new zzie(this, zzaiVar3, i, andIncrement, z2, zzaiVar2);
                if (i == 30 || i == -10) {
                    this.zzs.zzaz().zzq(zzieVar);
                } else {
                    this.zzs.zzaz().zzp(zzieVar);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void zzT(zzhe zzheVar) {
        zzhe zzheVar2;
        zzg();
        zza();
        if (zzheVar != null && zzheVar != (zzheVar2 = this.zzd)) {
            Preconditions.checkState(zzheVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzheVar;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.zzs.zzaz().zzp(new zzic(this, bool));
    }

    final void zzV(zzai zzaiVar) {
        zzg();
        boolean z = (zzaiVar.zzi(zzah.ANALYTICS_STORAGE) && zzaiVar.zzi(zzah.AD_STORAGE)) || this.zzs.zzt().zzM();
        if (z != this.zzs.zzK()) {
            this.zzs.zzG(z);
            zzfj zzfjVarZzm = this.zzs.zzm();
            zzge zzgeVar = zzfjVarZzm.zzs;
            zzfjVarZzm.zzg();
            Boolean boolValueOf = zzfjVarZzm.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzfjVarZzm.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || boolValueOf == null || boolValueOf.booleanValue()) {
                zzaa(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzW(String str, String str2, Object obj, boolean z) {
        zzX(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ldl", obj, true, this.zzs.zzav().currentTimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0055  */
    /* JADX WARN: Code duplicated, block: B:19:0x0065  */
    final void zzY(String str, String str2, Object obj, long j) {
        String str3;
        Object obj2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zza();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (!TextUtils.isEmpty(str4)) {
                    Long lValueOf = Long.valueOf(true != "false".equals(str4.toLowerCase(Locale.ENGLISH)) ? 0L : 1L);
                    this.zzs.zzm().zzh.zzb(lValueOf.longValue() == 1 ? "true" : "false");
                    obj2 = lValueOf;
                } else if (obj == null) {
                    this.zzs.zzm().zzh.zzb("unset");
                    obj2 = obj;
                } else {
                    str3 = str2;
                    obj2 = obj;
                }
            } else if (obj == null) {
                this.zzs.zzm().zzh.zzb("unset");
                obj2 = obj;
            } else {
                str3 = str2;
                obj2 = obj;
            }
            str3 = "_npa";
        } else {
            str3 = str2;
            obj2 = obj;
        }
        if (!this.zzs.zzJ()) {
            this.zzs.zzay().zzj().zza("User property not set since app measurement is disabled");
        } else if (this.zzs.zzM()) {
            this.zzs.zzt().zzK(new zzli(str3, j, obj2, str));
        }
    }

    public final void zzZ(zzhf zzhfVar) {
        zza();
        Preconditions.checkNotNull(zzhfVar);
        if (this.zze.remove(zzhfVar)) {
            return;
        }
        this.zzs.zzay().zzk().zza("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzs.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzs.zzaz().zzd(atomicReference, 15000L, "boolean test flag value", new zzhv(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzs.zzaz().zzd(atomicReference, 15000L, "double test flag value", new zzib(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzs.zzaz().zzd(atomicReference, 15000L, "int test flag value", new zzia(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzs.zzaz().zzd(atomicReference, 15000L, "long test flag value", new zzhz(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final String zzp() {
        zziq zziqVarZzi = this.zzs.zzs().zzi();
        if (zziqVarZzi != null) {
            return zziqVarZzi.zzb;
        }
        return null;
    }

    public final String zzq() {
        zziq zziqVarZzi = this.zzs.zzs().zzi();
        if (zziqVarZzi != null) {
            return zziqVarZzi.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzs.zzaz().zzd(atomicReference, 15000L, "String test flag value", new zzhy(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get conditional user properties", new zzhu(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return zzln.zzH(list);
        }
        this.zzs.zzay().zzd().zzb("Timed out waiting for get conditional user properties", null);
        return new ArrayList();
    }

    public final List zzt(boolean z) {
        zza();
        this.zzs.zzay().zzj().zza("Getting user properties (FE)");
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get user properties", new zzhq(this, atomicReference, z));
        List list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        this.zzs.zzay().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z) {
        if (this.zzs.zzaz().zzs()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        this.zzs.zzaw();
        if (zzab.zza()) {
            this.zzs.zzay().zzd().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzs.zzaz().zzd(atomicReference, 5000L, "get user properties", new zzhw(this, atomicReference, null, str, str2, z));
        List<zzli> list = (List) atomicReference.get();
        if (list == null) {
            this.zzs.zzay().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzli zzliVar : list) {
            Object objZza = zzliVar.zza();
            if (objZza != null) {
                arrayMap.put(zzliVar.zzb, objZza);
            }
        }
        return arrayMap;
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzs.zzM()) {
            if (this.zzs.zzf().zzs(null, zzeh.zzX)) {
                zzag zzagVarZzf = this.zzs.zzf();
                zzagVarZzf.zzs.zzaw();
                Boolean boolZzk = zzagVarZzf.zzk("google_analytics_deferred_deep_link_enabled");
                if (boolZzk != null && boolZzk.booleanValue()) {
                    this.zzs.zzay().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhl
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzij zzijVar = this.zza;
                            zzijVar.zzg();
                            if (zzijVar.zzs.zzm().zzm.zzb()) {
                                zzijVar.zzs.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long jZza = zzijVar.zzs.zzm().zzn.zza();
                            zzijVar.zzs.zzm().zzn.zzb(1 + jZza);
                            zzijVar.zzs.zzf();
                            if (jZza < 5) {
                                zzijVar.zzs.zzE();
                            } else {
                                zzijVar.zzs.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                zzijVar.zzs.zzm().zzm.zza(true);
                            }
                        }
                    });
                }
            }
            this.zzs.zzt().zzq();
            this.zzc = false;
            zzfj zzfjVarZzm = this.zzs.zzm();
            zzfjVarZzm.zzg();
            String string = zzfjVarZzm.zza().getString("previous_os_version", null);
            zzfjVarZzm.zzs.zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor editorEdit = zzfjVarZzm.zza().edit();
                editorEdit.putString("previous_os_version", str);
                editorEdit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.zzs.zzg().zzu();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzG(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_ou", bundle);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:22:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x005c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    public final void zzX(String str, String str2, Object obj, boolean z, long j) {
        int i;
        int iZzl;
        int iZzd;
        Object objZzB;
        String str3 = str == null ? "app" : str;
        if (!z) {
            zzln zzlnVarZzv = this.zzs.zzv();
            if (!zzlnVarZzv.zzac("user property", str2)) {
                i = 6;
            } else if (zzlnVarZzv.zzZ("user property", zzhd.zza, null, str2)) {
                zzlnVarZzv.zzs.zzf();
                if (zzlnVarZzv.zzY("user property", 24, str2)) {
                    i = 0;
                } else {
                    i = 6;
                }
            } else {
                iZzl = 15;
            }
            if (i != 0) {
                zzln zzlnVarZzv2 = this.zzs.zzv();
                this.zzs.zzf();
                this.zzs.zzv().zzN(this.zzn, null, i, "_ev", zzlnVarZzv2.zzD(str2, 24, true), str2 != null ? str2.length() : 0);
            } else {
                if (obj != null) {
                    zzN(str3, str2, j, null);
                    return;
                }
                iZzd = this.zzs.zzv().zzd(str2, obj);
                if (iZzd != 0) {
                    zzln zzlnVarZzv3 = this.zzs.zzv();
                    this.zzs.zzf();
                    this.zzs.zzv().zzN(this.zzn, null, iZzd, "_ev", zzlnVarZzv3.zzD(str2, 24, true), (!(obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
                } else {
                    objZzB = this.zzs.zzv().zzB(str2, obj);
                    if (objZzB != null) {
                        zzN(str3, str2, j, objZzB);
                    }
                }
            }
        }
        iZzl = this.zzs.zzv().zzl(str2);
        i = iZzl;
        if (i != 0) {
            zzln zzlnVarZzv4 = this.zzs.zzv();
            this.zzs.zzf();
            this.zzs.zzv().zzN(this.zzn, null, i, "_ev", zzlnVarZzv4.zzD(str2, 24, true), str2 != null ? str2.length() : 0);
        } else {
            if (obj != null) {
                zzN(str3, str2, j, null);
                return;
            }
            iZzd = this.zzs.zzv().zzd(str2, obj);
            if (iZzd != 0) {
                zzln zzlnVarZzv5 = this.zzs.zzv();
                this.zzs.zzf();
                this.zzs.zzv().zzN(this.zzn, null, iZzd, "_ev", zzlnVarZzv5.zzD(str2, 24, true), (!(obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
            } else {
                objZzB = this.zzs.zzv().zzB(str2, obj);
                if (objZzB != null) {
                    zzN(str3, str2, j, objZzB);
                }
            }
        }
    }
}
