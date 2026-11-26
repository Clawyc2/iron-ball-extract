package com.google.android.gms.internal.ads;

import androidx.webkit.Profile;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbv {
    public static final zzgus zza;
    public static final zzgus zzb;
    public static final zzgus zzc;
    public static final ScheduledExecutorService zzd;
    public static final zzgut zze;
    public static final zzgus zzf;
    public static final zzgus zzg;

    /* JADX WARN: Code duplicated, block: B:14:0x009b  */
    static {
        ExecutorService threadPoolExecutor;
        ExecutorService executorServiceZza;
        ExecutorService executorServiceZzc;
        if (ClientLibraryUtils.isPackageSide()) {
            zzfuy.zza();
            threadPoolExecutor = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(new zzcbs(Profile.DEFAULT_PROFILE_NAME)));
        } else {
            if (com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmn) != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmn)).booleanValue()) {
                    if (com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmo) != null) {
                        if (com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmp) != null) {
                            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmo)).intValue(), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmo)).intValue(), 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcbs(Profile.DEFAULT_PROFILE_NAME));
                            threadPoolExecutor2.allowCoreThreadTimeOut(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zze(zzbeu.zzmp)).booleanValue());
                            threadPoolExecutor = threadPoolExecutor2;
                        } else {
                            threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcbs(Profile.DEFAULT_PROFILE_NAME));
                        }
                    } else {
                        threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcbs(Profile.DEFAULT_PROFILE_NAME));
                    }
                } else {
                    threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcbs(Profile.DEFAULT_PROFILE_NAME));
                }
            } else {
                threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new zzcbs(Profile.DEFAULT_PROFILE_NAME));
            }
        }
        zza = new zzcbu(threadPoolExecutor, null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZza = zzfuy.zza().zza(5, new zzcbs("Loader"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcbs("Loader"));
            threadPoolExecutor3.allowCoreThreadTimeOut(true);
            executorServiceZza = threadPoolExecutor3;
        }
        zzb = new zzcbu(executorServiceZza, null);
        if (ClientLibraryUtils.isPackageSide()) {
            executorServiceZzc = zzfuy.zza().zzc(new zzcbs("Activeview"), 1);
        } else {
            ThreadPoolExecutor threadPoolExecutor4 = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzcbs("Activeview"));
            threadPoolExecutor4.allowCoreThreadTimeOut(true);
            executorServiceZzc = threadPoolExecutor4;
        }
        zzc = new zzcbu(executorServiceZzc, null);
        zzcbr zzcbrVar = new zzcbr(3, new zzcbs("Schedule"));
        zzd = zzcbrVar;
        zze = zzguz.zzc(zzcbrVar);
        zzf = new zzcbu(new zzcbt(), null);
        zzg = new zzcbu(zzguz.zza(), null);
    }
}
