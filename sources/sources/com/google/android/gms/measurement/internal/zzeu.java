package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeu extends zzgy {
    private char zza;
    private long zzb;
    private String zzc;
    private final zzes zzd;
    private final zzes zze;
    private final zzes zzf;
    private final zzes zzg;
    private final zzes zzh;
    private final zzes zzi;
    private final zzes zzj;
    private final zzes zzk;
    private final zzes zzl;

    zzeu(zzge zzgeVar) {
        super(zzgeVar);
        this.zza = (char) 0;
        this.zzb = -1L;
        this.zzd = new zzes(this, 6, false, false);
        this.zze = new zzes(this, 6, true, false);
        this.zzf = new zzes(this, 6, false, true);
        this.zzg = new zzes(this, 5, false, false);
        this.zzh = new zzes(this, 5, true, false);
        this.zzi = new zzes(this, 5, false, true);
        this.zzj = new zzes(this, 4, false, false);
        this.zzk = new zzes(this, 3, false, false);
        this.zzl = new zzes(this, 2, false, false);
    }

    protected static Object zzn(String str) {
        if (str == null) {
            return null;
        }
        return new zzet(str);
    }

    static String zzo(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String strZzp = zzp(z, obj);
        String strZzp2 = zzp(z, obj2);
        String strZzp3 = zzp(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(strZzp)) {
            sb.append(str2);
            sb.append(strZzp);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(strZzp2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(strZzp2);
        }
        if (!TextUtils.isEmpty(strZzp3)) {
            sb.append(str3);
            sb.append(strZzp3);
        }
        return sb.toString();
    }

    static String zzp(boolean z, Object obj) {
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z) {
                return obj.toString();
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return obj.toString();
            }
            String str = obj.toString().charAt(0) == '-' ? "-" : "";
            String strValueOf = String.valueOf(Math.abs(l.longValue()));
            return str + Math.round(Math.pow(10.0d, strValueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d);
        }
        if (obj instanceof Boolean) {
            return obj.toString();
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof zzet) {
                return ((zzet) obj).zza;
            }
            return z ? "-" : obj.toString();
        }
        Throwable th = (Throwable) obj;
        StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
        String strZzy = zzy(zzge.class.getCanonicalName());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && zzy(className).equals(strZzy)) {
                sb.append(": ");
                sb.append(stackTraceElement);
                break;
            }
        }
        return sb.toString();
    }

    private static String zzy(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(0, iLastIndexOf);
    }

    public final zzes zzc() {
        return this.zzk;
    }

    public final zzes zzd() {
        return this.zzd;
    }

    public final zzes zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzgy
    protected final boolean zzf() {
        return false;
    }

    public final zzes zzh() {
        return this.zze;
    }

    public final zzes zzi() {
        return this.zzj;
    }

    public final zzes zzj() {
        return this.zzl;
    }

    public final zzes zzk() {
        return this.zzg;
    }

    public final zzes zzl() {
        return this.zzi;
    }

    public final zzes zzm() {
        return this.zzh;
    }

    @EnsuresNonNull({"logTagDoNotUseDirectly"})
    protected final String zzq() {
        String str;
        synchronized (this) {
            if (this.zzc == null) {
                if (this.zzs.zzy() != null) {
                    this.zzc = this.zzs.zzy();
                } else {
                    this.zzc = this.zzs.zzf().zzn();
                }
            }
            Preconditions.checkNotNull(this.zzc);
            str = this.zzc;
        }
        return str;
    }

    protected final void zzt(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(zzq(), i)) {
            Log.println(i, zzq(), zzo(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzgb zzgbVarZzo = this.zzs.zzo();
        if (zzgbVarZzo == null) {
            Log.println(6, zzq(), "Scheduler not set. Not logging error/warn");
        } else {
            if (!zzgbVarZzo.zzx()) {
                Log.println(6, zzq(), "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i >= 9) {
                i = 8;
            }
            zzgbVarZzo.zzp(new zzer(this, i, str, obj, obj2, obj3));
        }
    }
}
