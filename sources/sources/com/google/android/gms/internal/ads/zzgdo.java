package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgdo {
    private final Context zza;
    private final zzgjd zzb;
    private final zzgbk zzc;
    private final String zzd;

    zzgdo(Context context, zzgjd zzgjdVar, zzgbk zzgbkVar, zzfxt zzfxtVar) {
        this.zza = context;
        this.zzb = zzgjdVar;
        this.zzc = zzgbkVar;
        this.zzd = zzfxtVar.zzb();
    }

    public final String zza(boolean z, long j) {
        String string;
        zzgjb zzgjbVarZza = this.zzb.zza(55);
        try {
            try {
                zzgjbVarZza.zza();
                zzavi zzaviVarZza = zzavj.zza();
                zzaviVarZza.zzb(this.zzd);
                zzaviVarZza.zza("0.808261137");
                Context context = this.zza;
                zzaviVarZza.zzd(context.getPackageName());
                zzaviVarZza.zzc(System.currentTimeMillis() / 1000);
                zzaviVarZza.zzf((System.currentTimeMillis() - j) / 1000);
                try {
                    zzaviVarZza.zze(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                } catch (PackageManager.NameNotFoundException unused) {
                    zzaviVarZza.zze(-1L);
                }
                zzgbk zzgbkVar = this.zzc;
                if (!zzgbkVar.zzc()) {
                    zzgbkVar.zza();
                }
                zzavp zzavpVarZzf = zzgbkVar.zzf(((zzavj) zzaviVarZza.zzbu()).zzaN(), null);
                zzavpVarZzf.zzc(5);
                zzavpVarZzf.zzd(2);
                string = zzfyo.zza(((zzavq) zzavpVarZzf.zzbu()).zzaN(), true);
            } catch (Throwable th) {
                zzgjbVarZza.zzc();
                throw th;
            }
        } catch (UnsupportedEncodingException e) {
            zzgjbVarZza.zzb(e);
            string = Integer.toString(7);
        } catch (Throwable th2) {
            zzgjbVarZza.zzb(th2);
            throw th2;
        }
        zzgjbVarZza.zzc();
        return string;
    }
}
