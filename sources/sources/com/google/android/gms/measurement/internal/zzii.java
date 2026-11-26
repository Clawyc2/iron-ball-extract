package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzii implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzij zza;

    /* synthetic */ zzii(zzij zzijVar, zzih zzihVar) {
        this.zza = zzijVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) throws Throwable {
        zzii zziiVar;
        zzge zzgeVar;
        Uri data;
        try {
            try {
                this.zza.zzs.zzay().zzj().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null || (data = intent.getData()) == null || !data.isHierarchical()) {
                    zzgeVar = this.zza.zzs;
                } else {
                    this.zza.zzs.zzv();
                    String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
                    zziiVar = this;
                    try {
                        this.zza.zzs.zzaz().zzp(new zzig(zziiVar, bundle == null, data, ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) ? "gs" : DebugKt.DEBUG_PROPERTY_VALUE_AUTO, data.getQueryParameter("referrer")));
                        zzgeVar = zziiVar.zza.zzs;
                    } catch (RuntimeException e) {
                        e = e;
                        zziiVar.zza.zzs.zzay().zzd().zzb("Throwable caught in onActivityCreated", e);
                        zzgeVar = zziiVar.zza.zzs;
                    }
                }
            } catch (Throwable th) {
                th = th;
                zziiVar.zza.zzs.zzs().zzr(activity, bundle);
                throw th;
            }
        } catch (RuntimeException e2) {
            e = e2;
            zziiVar = this;
        } catch (Throwable th2) {
            th = th2;
            zziiVar = this;
            zziiVar.zza.zzs.zzs().zzr(activity, bundle);
            throw th;
        }
        zzgeVar.zzs().zzr(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzs.zzs().zzs(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzs.zzs().zzt(activity);
        zzko zzkoVarZzu = this.zza.zzs.zzu();
        zzkoVarZzu.zzs.zzaz().zzp(new zzkh(zzkoVarZzu, zzkoVarZzu.zzs.zzav().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzko zzkoVarZzu = this.zza.zzs.zzu();
        zzkoVarZzu.zzs.zzaz().zzp(new zzkg(zzkoVarZzu, zzkoVarZzu.zzs.zzav().elapsedRealtime()));
        this.zza.zzs.zzs().zzu(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzs.zzs().zzv(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
