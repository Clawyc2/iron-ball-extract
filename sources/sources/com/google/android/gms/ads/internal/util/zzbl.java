package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzapx;
import com.google.android.gms.internal.ads.zzaqz;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzcca;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes.dex */
@ParametersAreNonnullByDefault
public final class zzbl {
    private static zzapx zza;
    private static final Object zzb = new Object();

    /* JADX WARN: Code duplicated, block: B:14:0x0034 A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:15:0x003c, B:14:0x0034, B:16:0x003e), top: B:21:0x0010 }] */
    public zzbl(Context context) {
        zzapx zzapxVarZza;
        context = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        synchronized (zzb) {
            if (zza == null) {
                zzbeu.zza(context);
                if (ClientLibraryUtils.isPackageSide()) {
                    zzapxVarZza = zzaqz.zza(context, null);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeY)).booleanValue()) {
                        zzapxVarZza = zzay.zzb(context);
                    } else {
                        zzapxVarZza = zzaqz.zza(context, null);
                    }
                }
                zza = zzapxVarZza;
            }
        }
    }

    public final ListenableFuture zza(String str) {
        zzcca zzccaVar = new zzcca();
        zza.zzb(new zzbk(str, null, zzccaVar));
        return zzccaVar;
    }

    public final ListenableFuture zzb(int i, String str, Map map, byte[] bArr) {
        zzbi zzbiVar = new zzbi(null);
        zzbg zzbgVar = new zzbg(this, str, zzbiVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbh zzbhVar = new zzbh(this, i, str, zzbiVar, zzbgVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.zzj()) {
            try {
                zzlVar.zzb(str, ShareTarget.METHOD_GET, zzbhVar.zzm(), zzbhVar.zzn());
            } catch (zzapc e) {
                String message = e.getMessage();
                int i2 = zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(message);
            }
        }
        zza.zzb(zzbhVar);
        return zzbiVar;
    }
}
