package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfwo implements zzfvh {
    private final CoroutineScope zza;
    private final Mutex zzb;
    private final Mutex zzc;
    private final Mutex zzd;
    private boolean zze;
    private zzfvf zzf;
    private boolean zzg;
    private final DataStore zzh;
    private final zzdss zzi;

    public zzfwo(DataStore adQualityDataStore, zzfwq coroutineScopeProvider, zzdss dataPinger, zzfvq clock) {
        Intrinsics.checkNotNullParameter(adQualityDataStore, "adQualityDataStore");
        Intrinsics.checkNotNullParameter(coroutineScopeProvider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(dataPinger, "dataPinger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.zzi = dataPinger;
        this.zza = coroutineScopeProvider.zza();
        this.zzb = MutexKt.Mutex$default(false, 1, null);
        this.zzc = MutexKt.Mutex$default(false, 1, null);
        this.zzd = MutexKt.Mutex$default(false, 1, null);
        this.zzh = adQualityDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzs(String str, Continuation continuation) throws Throwable {
        zzfvt zzfvtVar;
        Mutex mutex;
        Throwable th;
        Mutex mutex2;
        if (continuation instanceof zzfvt) {
            zzfvtVar = (zzfvt) continuation;
            int i = zzfvtVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfvtVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzfvtVar = new zzfvt(this, continuation);
            }
        } else {
            zzfvtVar = new zzfvt(this, continuation);
        }
        Object obj = zzfvtVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfvtVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzd;
                zzfvtVar.zza = str;
                zzfvtVar.zzb = mutex;
                zzfvtVar.zze = 1;
                if (mutex.lock(null, zzfvtVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) zzfvtVar.zza;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) zzfvtVar.zzb;
            String str2 = (String) zzfvtVar.zza;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            str = str2;
            DataStore dataStore = this.zzh;
            zzfvu zzfvuVar = new zzfvu(str, null);
            zzfvtVar.zza = mutex;
            zzfvtVar.zzb = null;
            zzfvtVar.zze = 2;
            Object objUpdateData = dataStore.updateData(zzfvuVar, zzfvtVar);
            if (objUpdateData != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objUpdateData;
                mutex2 = mutex4;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzt(Continuation continuation) throws Throwable {
        zzfvw zzfvwVar;
        Mutex mutex;
        Mutex mutex2;
        Throwable th;
        if (continuation instanceof zzfvw) {
            zzfvwVar = (zzfvw) continuation;
            int i = zzfvwVar.zzd;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfvwVar.zzd = i - Integer.MIN_VALUE;
            } else {
                zzfvwVar = new zzfvw(this, continuation);
            }
        } else {
            zzfvwVar = new zzfvw(this, continuation);
        }
        Object obj = zzfvwVar.zzb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfvwVar.zzd;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzd;
                zzfvwVar.zza = mutex;
                zzfvwVar.zzd = 1;
                if (mutex.lock(null, zzfvwVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) zzfvwVar.zza;
                try {
                    ResultKt.throwOnFailure(obj);
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            Mutex mutex3 = (Mutex) zzfvwVar.zza;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            DataStore dataStore = this.zzh;
            zzfvx zzfvxVar = new zzfvx(null);
            zzfvwVar.zza = mutex;
            zzfvwVar.zzd = 2;
            Object objUpdateData = dataStore.updateData(zzfvxVar, zzfvwVar);
            if (objUpdateData != coroutine_suspended) {
                mutex2 = mutex;
                obj = objUpdateData;
                mutex2.unlock(null);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzu(long j, Continuation continuation) throws Throwable {
        zzfvv zzfvvVar;
        Mutex mutex;
        if (continuation instanceof zzfvv) {
            zzfvvVar = (zzfvv) continuation;
            int i = zzfvvVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfvvVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzfvvVar = new zzfvv(this, continuation);
            }
        } else {
            zzfvvVar = new zzfvv(this, continuation);
        }
        Object obj = zzfvvVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfvvVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzb;
            zzfvvVar.zzb = mutex2;
            zzfvvVar.zza = j;
            zzfvvVar.zze = 1;
            if (mutex2.lock(null, zzfvvVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = zzfvvVar.zza;
            mutex = (Mutex) zzfvvVar.zzb;
            ResultKt.throwOnFailure(obj);
        }
        try {
            zzfvf zzfvfVar = this.zzf;
            if (zzfvfVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzfvfVar = null;
            }
            zzfvf zzfvfVar2 = this.zzf;
            if (zzfvfVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzfvfVar2 = null;
            }
            long jZzi = j - zzfvfVar2.zzi();
            zzfvf zzfvfVar3 = this.zzf;
            if (zzfvfVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzfvfVar3 = null;
            }
            zzfvfVar.zzb(jZzi - zzfvfVar3.zzg());
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:33:0x009c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzv(Continuation continuation) throws Throwable {
        zzfwa zzfwaVar;
        Mutex mutex;
        Mutex mutex2;
        zzfvg zzfvgVar;
        Mutex mutex3;
        if (continuation instanceof zzfwa) {
            zzfwaVar = (zzfwa) continuation;
            int i = zzfwaVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfwaVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzfwaVar = new zzfwa(this, continuation);
            }
        } else {
            zzfwaVar = new zzfwa(this, continuation);
        }
        Object objUpdateData = zzfwaVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfwaVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objUpdateData);
                mutex = this.zzb;
                zzfwaVar.zza = mutex;
                zzfwaVar.zze = 1;
                if (mutex.lock(null, zzfwaVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex3 = (Mutex) zzfwaVar.zza;
                    try {
                        ResultKt.throwOnFailure(objUpdateData);
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        mutex3.unlock(null);
                        throw th;
                    }
                }
                mutex2 = (Mutex) zzfwaVar.zzb;
                zzfvgVar = (zzfvg) zzfwaVar.zza;
                ResultKt.throwOnFailure(objUpdateData);
                try {
                    DataStore dataStore = this.zzh;
                    zzfwb zzfwbVar = new zzfwb(zzfvgVar, null);
                    zzfwaVar.zza = mutex2;
                    zzfwaVar.zzb = null;
                    zzfwaVar.zze = 3;
                    objUpdateData = dataStore.updateData(zzfwbVar, zzfwaVar);
                    if (objUpdateData != coroutine_suspended) {
                        mutex3 = mutex2;
                        mutex3.unlock(null);
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                } catch (Throwable th2) {
                    th = th2;
                    mutex3 = mutex2;
                    mutex3.unlock(null);
                    throw th;
                }
            }
            mutex = (Mutex) zzfwaVar.zza;
            ResultKt.throwOnFailure(objUpdateData);
            zzfvf zzfvfVar = this.zzf;
            if (zzfvfVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzfvfVar = null;
            }
            zzfvg zzfvgVar2 = (zzfvg) zzfvfVar.zzbu();
            mutex.unlock(null);
            Intrinsics.checkNotNull(zzfvgVar2);
            mutex2 = this.zzd;
            zzfwaVar.zza = zzfvgVar2;
            zzfwaVar.zzb = mutex2;
            zzfwaVar.zze = 2;
            if (mutex2.lock(null, zzfwaVar) != coroutine_suspended) {
                zzfvgVar = zzfvgVar2;
                DataStore dataStore2 = this.zzh;
                zzfwb zzfwbVar2 = new zzfwb(zzfvgVar, null);
                zzfwaVar.zza = mutex2;
                zzfwaVar.zzb = null;
                zzfwaVar.zze = 3;
                objUpdateData = dataStore2.updateData(zzfwbVar2, zzfwaVar);
                if (objUpdateData != coroutine_suspended) {
                    mutex3 = mutex2;
                    mutex3.unlock(null);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            mutex.unlock(null);
            throw th3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    private static final boolean zzw(zzfvg zzfvgVar) {
        boolean z;
        List listZzk = zzfvgVar.zzk();
        Long l = listZzk != null ? (Long) CollectionsKt.lastOrNull(listZzk) : null;
        boolean z2 = zzfvgVar.zzl() > zzfvgVar.zzm() && !zzfvgVar.zzd();
        if (l != null) {
            if (zzfvgVar.zzi() - l.longValue() > 5000) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        return z2 || z;
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zza() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwj(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzb(String gwsQueryId) {
        Intrinsics.checkNotNullParameter(gwsQueryId, "gwsQueryId");
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwd(this, gwsQueryId, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzc() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfvz(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzd() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwn(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zze() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwh(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzf() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwl(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzg() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwf(this, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d0, code lost:
    
        if (zzt(r0) == r1) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.internal.ads.zzfwo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzh(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzh(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzi(String str, Continuation continuation) throws Throwable {
        zzfwc zzfwcVar;
        String str2;
        Mutex mutex;
        long j;
        if (continuation instanceof zzfwc) {
            zzfwcVar = (zzfwc) continuation;
            int i = zzfwcVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfwcVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzfwcVar = new zzfwc(this, continuation);
            }
        } else {
            zzfwcVar = new zzfwc(this, continuation);
        }
        Object obj = zzfwcVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfwcVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzb;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzfwcVar.zzf = str;
            zzfwcVar.zza = mutex2;
            zzfwcVar.zzb = jCurrentTimeMillis;
            zzfwcVar.zze = 1;
            if (mutex2.lock(null, zzfwcVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
            mutex = mutex2;
            j = jCurrentTimeMillis;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = zzfwcVar.zzb;
            mutex = (Mutex) zzfwcVar.zza;
            str2 = zzfwcVar.zzf;
            ResultKt.throwOnFailure(obj);
        }
        try {
            if (this.zze) {
                return Unit.INSTANCE;
            }
            this.zze = true;
            zzhwi zzhwiVarZzcc = zzfvg.zzp().zzcc();
            Intrinsics.checkNotNullExpressionValue(zzhwiVarZzcc, "toBuilder(...)");
            zzfvf zzfvfVar = (zzfvf) zzhwiVarZzcc;
            this.zzf = zzfvfVar;
            if (zzfvfVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzfvfVar = null;
            }
            zzfvfVar.zza(str2);
            zzfvfVar.zzj(j);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0089 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:31:0x0085, B:33:0x0089, B:34:0x008f), top: B:50:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
    
        if (zzv(r0) == r1) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzj(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.android.gms.internal.ads.zzfvy
            if (r0 == 0) goto L13
            r0 = r11
            com.google.android.gms.internal.ads.zzfvy r0 = (com.google.android.gms.internal.ads.zzfvy) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvy r0 = new com.google.android.gms.internal.ads.zzfvy
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L52
            if (r2 == r6) goto L4a
            if (r2 == r5) goto L40
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            kotlin.ResultKt.throwOnFailure(r11)
            goto La8
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3c:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9f
        L40:
            long r5 = r0.zzb
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L85
        L4a:
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L61
        L52:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r2 = r10.zzc
            r0.zza = r2
            r0.zze = r6
            java.lang.Object r11 = r2.lock(r7, r0)
            if (r11 == r1) goto Lb5
        L61:
            boolean r11 = r10.zzg     // Catch: java.lang.Throwable -> Lb0
            if (r11 == 0) goto L6b
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb0
            r2.unlock(r7)
            return r11
        L6b:
            r10.zzg = r6     // Catch: java.lang.Throwable -> Lb0
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb0
            r2.unlock(r7)
            kotlinx.coroutines.sync.Mutex r2 = r10.zzb
            long r8 = java.lang.System.currentTimeMillis()
            r0.zza = r2
            r0.zzb = r8
            r0.zze = r5
            java.lang.Object r11 = r2.lock(r7, r0)
            if (r11 == r1) goto Lb5
            r5 = r8
        L85:
            com.google.android.gms.internal.ads.zzfvf r11 = r10.zzf     // Catch: java.lang.Throwable -> Lab
            if (r11 != 0) goto L8f
            java.lang.String r11 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch: java.lang.Throwable -> Lab
            r11 = r7
        L8f:
            r11.zzo(r5)     // Catch: java.lang.Throwable -> Lab
            r2.unlock(r7)
            r0.zza = r7
            r0.zze = r4
            java.lang.Object r11 = r10.zzu(r5, r0)
            if (r11 == r1) goto Lb5
        L9f:
            r0.zze = r3
            java.lang.Object r11 = r10.zzv(r0)
            if (r11 != r1) goto La8
            goto Lb5
        La8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lab:
            r11 = move-exception
            r2.unlock(r7)
            throw r11
        Lb0:
            r11 = move-exception
            r2.unlock(r7)
            throw r11
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzj(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:31:0x007e A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008a A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008e A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ae A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00bb A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bf A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cf A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9 A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00dd A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00fd A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x010d A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzk(Continuation continuation) throws Throwable {
        zzfwm zzfwmVar;
        Mutex mutex;
        Mutex mutex2;
        long j;
        zzfvf zzfvfVar;
        zzfvf zzfvfVar2;
        zzfvf zzfvfVar3;
        zzfvf zzfvfVar4;
        zzfvf zzfvfVar5;
        zzfvf zzfvfVar6;
        long jLongValue;
        zzfvf zzfvfVar7;
        zzfvf zzfvfVar8;
        if (continuation instanceof zzfwm) {
            zzfwmVar = (zzfwm) continuation;
            int i = zzfwmVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfwmVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzfwmVar = new zzfwm(this, continuation);
            }
        } else {
            zzfwmVar = new zzfwm(this, continuation);
        }
        Object obj = zzfwmVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfwmVar.zze;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.zzc;
                zzfwmVar.zza = mutex;
                zzfwmVar.zze = 1;
                if (mutex.lock(null, zzfwmVar) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                mutex = (Mutex) zzfwmVar.zza;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = zzfwmVar.zzb;
                mutex2 = (Mutex) zzfwmVar.zza;
                ResultKt.throwOnFailure(obj);
            }
            try {
                zzfvfVar = this.zzf;
                if (zzfvfVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzfvfVar = null;
                }
                if (zzfvfVar.zzr() > 0) {
                    zzfvfVar6 = this.zzf;
                    if (zzfvfVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar6 = null;
                    }
                    List listZzq = zzfvfVar6.zzq();
                    Intrinsics.checkNotNullExpressionValue(listZzq, "getAdClickTimestampsMsList(...)");
                    Object objLast = CollectionsKt.last((List<? extends Object>) listZzq);
                    Intrinsics.checkNotNullExpressionValue(objLast, "last(...)");
                    jLongValue = j - ((Number) objLast).longValue();
                    zzfvfVar7 = this.zzf;
                    if (zzfvfVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar7 = null;
                    }
                    zzfvfVar7.zzt();
                    if (jLongValue < 5000) {
                        zzfvfVar8 = this.zzf;
                        if (zzfvfVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzfvfVar8 = null;
                        }
                        zzfvfVar8.zzd(zzfvfVar8.zzc() + 1);
                    }
                }
                zzfvfVar2 = this.zzf;
                if (zzfvfVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzfvfVar2 = null;
                }
                if (zzfvfVar2.zzn() > 0) {
                    zzfvfVar4 = this.zzf;
                    if (zzfvfVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar4 = null;
                    }
                    List listZzm = zzfvfVar4.zzm();
                    Intrinsics.checkNotNullExpressionValue(listZzm, "getAppBackgroundTimestampsMsList(...)");
                    Object objLast2 = CollectionsKt.last((List<? extends Object>) listZzm);
                    Intrinsics.checkNotNullExpressionValue(objLast2, "last(...)");
                    long jLongValue2 = j - ((Number) objLast2).longValue();
                    zzfvfVar5 = this.zzf;
                    if (zzfvfVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar5 = null;
                    }
                    zzfvfVar5.zzh(zzfvfVar5.zzg() + jLongValue2);
                }
                zzfvfVar3 = this.zzf;
                if (zzfvfVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzfvfVar3 = null;
                }
                zzfvfVar3.zzp(j);
                return Unit.INSTANCE;
            } finally {
                mutex2.unlock(null);
            }
            if (!this.zzg) {
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return unit;
            }
            this.zzg = false;
            Unit unit2 = Unit.INSTANCE;
            mutex.unlock(null);
            Mutex mutex3 = this.zzb;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzfwmVar.zza = mutex3;
            zzfwmVar.zzb = jCurrentTimeMillis;
            zzfwmVar.zze = 2;
            if (mutex3.lock(null, zzfwmVar) != coroutine_suspended) {
                mutex2 = mutex3;
                j = jCurrentTimeMillis;
                zzfvfVar = this.zzf;
                if (zzfvfVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzfvfVar = null;
                }
                if (zzfvfVar.zzr() > 0) {
                    zzfvfVar6 = this.zzf;
                    if (zzfvfVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar6 = null;
                    }
                    List listZzq2 = zzfvfVar6.zzq();
                    Intrinsics.checkNotNullExpressionValue(listZzq2, "getAdClickTimestampsMsList(...)");
                    Object objLast3 = CollectionsKt.last((List<? extends Object>) listZzq2);
                    Intrinsics.checkNotNullExpressionValue(objLast3, "last(...)");
                    jLongValue = j - ((Number) objLast3).longValue();
                    zzfvfVar7 = this.zzf;
                    if (zzfvfVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar7 = null;
                    }
                    zzfvfVar7.zzt();
                    if (jLongValue < 5000) {
                        zzfvfVar8 = this.zzf;
                        if (zzfvfVar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                            zzfvfVar8 = null;
                        }
                        zzfvfVar8.zzd(zzfvfVar8.zzc() + 1);
                    }
                }
                zzfvfVar2 = this.zzf;
                if (zzfvfVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzfvfVar2 = null;
                }
                if (zzfvfVar2.zzn() > 0) {
                    zzfvfVar4 = this.zzf;
                    if (zzfvfVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar4 = null;
                    }
                    List listZzm2 = zzfvfVar4.zzm();
                    Intrinsics.checkNotNullExpressionValue(listZzm2, "getAppBackgroundTimestampsMsList(...)");
                    Object objLast4 = CollectionsKt.last((List<? extends Object>) listZzm2);
                    Intrinsics.checkNotNullExpressionValue(objLast4, "last(...)");
                    long jLongValue3 = j - ((Number) objLast4).longValue();
                    zzfvfVar5 = this.zzf;
                    if (zzfvfVar5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                        zzfvfVar5 = null;
                    }
                    zzfvfVar5.zzh(zzfvfVar5.zzg() + jLongValue3);
                }
                zzfvfVar3 = this.zzf;
                if (zzfvfVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                    zzfvfVar3 = null;
                }
                zzfvfVar3.zzp(j);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0091 A[Catch: all -> 0x00fc, TRY_ENTER, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0099 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a7 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b7 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c2 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f6, code lost:
    
        if (zzs(r14, r0) == r1) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzl(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0090 A[Catch: all -> 0x0106, TRY_ENTER, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0098 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00b6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c1 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00cc A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0100, code lost:
    
        if (zzs(r15, r0) == r1) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object zzm(kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzm(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object zzn(Continuation continuation) throws Throwable {
        zzfwe zzfweVar;
        Mutex mutex;
        long j;
        if (continuation instanceof zzfwe) {
            zzfweVar = (zzfwe) continuation;
            int i = zzfweVar.zze;
            if ((i & Integer.MIN_VALUE) != 0) {
                zzfweVar.zze = i - Integer.MIN_VALUE;
            } else {
                zzfweVar = new zzfwe(this, continuation);
            }
        } else {
            zzfweVar = new zzfwe(this, continuation);
        }
        Object obj = zzfweVar.zzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = zzfweVar.zze;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.zzb;
            long jCurrentTimeMillis = System.currentTimeMillis();
            zzfweVar.zzb = mutex2;
            zzfweVar.zza = jCurrentTimeMillis;
            zzfweVar.zze = 1;
            if (mutex2.lock(null, zzfweVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            j = jCurrentTimeMillis;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = zzfweVar.zza;
            mutex = (Mutex) zzfweVar.zzb;
            ResultKt.throwOnFailure(obj);
        }
        try {
            zzfvf zzfvfVar = this.zzf;
            if (zzfvfVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adQualityDataBuilder");
                zzfvfVar = null;
            }
            zzfvfVar.zzs(j);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }
}
