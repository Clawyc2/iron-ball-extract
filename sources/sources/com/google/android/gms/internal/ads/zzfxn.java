package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.InputEvent;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfxn {
    private final zzfzl zza;
    private final zzgam zzb;
    private final zzghy zzc;
    private final zzgjd zzd;
    private final long zze;
    private final zzifb zzf;
    private final long zzg;
    private final long zzh = System.currentTimeMillis();
    private final boolean zzi;
    private final long zzj;

    zzfxn(zzfzl zzfzlVar, zzgam zzgamVar, zzghy zzghyVar, zzgjd zzgjdVar, zzifb zzifbVar, zzfxt zzfxtVar) {
        this.zza = zzfzlVar;
        this.zzb = zzgamVar;
        this.zzc = zzghyVar;
        this.zzd = zzgjdVar;
        this.zze = zzfxtVar.zzh();
        this.zzf = zzifbVar;
        this.zzg = zzfxtVar.zzg();
        this.zzi = zzfxtVar.zzq();
        this.zzj = zzfxtVar.zzp();
    }

    public final ListenableFuture zza() {
        return this.zza.zza();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzb(Context context) {
        String strZza;
        boolean z = false;
        if (this.zzi) {
            if (System.currentTimeMillis() - this.zzh <= this.zzj) {
                z = true;
            }
        }
        zzgjb zzgjbVarZza = this.zzd.zza(3);
        try {
            try {
                try {
                    zzgjbVarZza.zza();
                    strZza = (String) zzgui.zzj(this.zza.zzb(), new zzfxk(this, context), zzguz.zza()).get(z ? this.zzg : this.zze, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    zzgjbVarZza.zzb(e);
                    strZza = "";
                } catch (ExecutionException e2) {
                    e = e2;
                    Throwable cause = e.getCause();
                    if (cause != null) {
                        e = cause;
                    }
                    zzgjbVarZza.zzb(e);
                    strZza = Integer.toString(3);
                }
            } catch (TimeoutException e3) {
                zzgjbVarZza.zzb(e3);
                strZza = z ? ((zzgdo) this.zzf.zzb()).zza(true, this.zzh) : Integer.toString(17);
            } catch (Throwable th) {
                zzgjbVarZza.zzb(th);
                throw th;
            }
            zzgjbVarZza.zzc();
            return strZza;
        } catch (Throwable th2) {
            zzgjbVarZza.zzc();
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzc(Context context, String str, View view, Activity activity) {
        String string;
        zzgjb zzgjbVarZza = this.zzd.zza(4);
        try {
            try {
                zzgjbVarZza.zza();
                try {
                    string = (String) zzgui.zzj(this.zza.zzb(), new zzfxl(this, context, null, view, activity), zzguz.zza()).get(this.zze, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e = e;
                    Thread.currentThread().interrupt();
                    zzgjbVarZza.zzb(e);
                    string = "";
                } catch (ExecutionException e2) {
                    e = e2;
                    ExecutionException executionException = e;
                    Throwable cause = executionException.getCause();
                    if (cause != null) {
                        executionException = cause;
                    }
                    zzgjbVarZza.zzb(executionException);
                    string = Integer.toString(3);
                } catch (TimeoutException e3) {
                    e = e3;
                    zzgjbVarZza.zzb(e);
                    string = Integer.toString(17);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zzgjbVarZza.zzb(th2);
                    throw th2;
                }
            } catch (Throwable th3) {
                zzgjbVarZza.zzc();
                throw th3;
            }
        } catch (InterruptedException e4) {
            e = e4;
        } catch (ExecutionException e5) {
            e = e5;
        } catch (TimeoutException e6) {
            e = e6;
        } catch (Throwable th4) {
            th = th4;
        }
        zzgjbVarZza.zzc();
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String zzd(Context context, String str, View view, Activity activity) {
        String string;
        zzgjb zzgjbVarZza = this.zzd.zza(5);
        try {
            try {
                zzgjbVarZza.zza();
                try {
                    string = (String) zzgui.zzj(this.zza.zzb(), new zzfxm(this, context, str, view, null), zzguz.zza()).get(this.zze, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e = e;
                    Thread.currentThread().interrupt();
                    zzgjbVarZza.zzb(e);
                    string = "";
                } catch (ExecutionException e2) {
                    e = e2;
                    ExecutionException executionException = e;
                    Throwable cause = executionException.getCause();
                    if (cause != null) {
                        executionException = cause;
                    }
                    zzgjbVarZza.zzb(executionException);
                    string = Integer.toString(3);
                } catch (TimeoutException e3) {
                    e = e3;
                    zzgjbVarZza.zzb(e);
                    string = Integer.toString(17);
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    zzgjbVarZza.zzb(th2);
                    throw th2;
                }
            } catch (Throwable th3) {
                zzgjbVarZza.zzc();
                throw th3;
            }
        } catch (InterruptedException e4) {
            e = e4;
        } catch (ExecutionException e5) {
            e = e5;
        } catch (TimeoutException e6) {
            e = e6;
        } catch (Throwable th4) {
            th = th4;
        }
        zzgjbVarZza.zzc();
        return string;
    }

    public final void zze(List list) {
        this.zzc.zza(list);
    }

    public final void zzf(InputEvent inputEvent) {
        this.zzb.zze(inputEvent);
    }

    final /* synthetic */ zzgam zzg() {
        return this.zzb;
    }

    public final int zzh() {
        return this.zzb.zzh();
    }
}
