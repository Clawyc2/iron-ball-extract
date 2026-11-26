package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.location.GeofenceStatusCodes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaww implements zzawv {
    protected static volatile zzayd zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzaxv zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    protected zzaww(Context context) {
        try {
            zzavz.zza();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdk)).booleanValue()) {
                this.zzr = new zzaxv();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzo() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        LinkedList linkedList = this.zzc;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x007c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0080 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x0082  */
    /* JADX WARN: Code duplicated, block: B:40:0x0085  */
    private final String zzp(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzawu zzawuVarZzh;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        String strZzb;
        int i5;
        int i6;
        zzauc zzaucVarZza;
        int i7;
        int i8;
        int i9 = i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcV)).booleanValue();
        zzauc zzaucVarZzb = null;
        if (zBooleanValue) {
            zzawuVarZzh = zza != null ? zza.zzh() : null;
            str2 = "be";
        } else {
            zzawuVarZzh = null;
            str2 = null;
        }
        try {
            if (i9 == 3) {
                zzaucVarZzb = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i8 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    if (zBooleanValue) {
                        if (i9 == i2) {
                            i4 = PointerIconCompat.TYPE_HELP;
                        } else {
                            if (i9 == 2) {
                                i4 = PointerIconCompat.TYPE_VERTICAL_TEXT;
                            } else {
                                i3 = 1001;
                                i9 = 1;
                            }
                            zzawuVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                        }
                        i3 = i4;
                        zzawuVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                    }
                }
            } else {
                if (i9 == 2) {
                    zzaucVarZza = zzc(context, view, activity);
                    i7 = PointerIconCompat.TYPE_TEXT;
                } else {
                    zzaucVarZza = zza(context, null);
                    i7 = 1000;
                }
                zzaucVarZzb = zzaucVarZza;
                i8 = i7;
            }
            if (!zBooleanValue || zzawuVarZzh == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzawuVarZzh.zza(i8, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    if (zBooleanValue && zzawuVarZzh != null) {
                        if (i9 == i2) {
                            i4 = PointerIconCompat.TYPE_HELP;
                        } else {
                            if (i9 == 2) {
                                i4 = PointerIconCompat.TYPE_VERTICAL_TEXT;
                            } else {
                                i3 = 1001;
                                i9 = 1;
                            }
                            zzawuVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                        }
                        i3 = i4;
                        zzawuVarZzh.zza(i3, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, exc);
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            i2 = 3;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (zzaucVarZzb != null) {
            try {
                if (((zzauz) zzaucVarZzb.zzbu()).zzbr() == 0) {
                    strZzb = Integer.toString(5);
                } else {
                    zzauz zzauzVar = (zzauz) zzaucVarZzb.zzbu();
                    int i10 = zzavz.zzc;
                    strZzb = zzavz.zzb(zzauzVar.zzaN(), str);
                    if (zBooleanValue && zzawuVarZzh != null) {
                        if (i9 == i2) {
                            i5 = PointerIconCompat.TYPE_CELL;
                        } else {
                            i5 = i9 == 2 ? PointerIconCompat.TYPE_ALIAS : 1004;
                        }
                        zzawuVarZzh.zza(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, null);
                    }
                }
            } catch (Exception e4) {
                strZzb = Integer.toString(7);
                if (zBooleanValue && zzawuVarZzh != null) {
                    if (i9 == i2) {
                        i6 = PointerIconCompat.TYPE_CROSSHAIR;
                    } else {
                        i6 = i9 == 2 ? PointerIconCompat.TYPE_COPY : GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT;
                    }
                    zzawuVarZzh.zza(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, e4);
                }
            }
        } else {
            strZzb = Integer.toString(5);
        }
        return strZzb;
    }

    protected abstract zzauc zza(Context context, zzato zzatoVar);

    protected abstract zzauc zzb(Context context, View view, Activity activity);

    protected abstract zzauc zzc(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzawv
    public final synchronized void zzd(MotionEvent motionEvent) {
        Long l;
        if (this.zzu) {
            zzo();
            this.zzu = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzs = motionEvent.getRawX();
            this.zzt = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d = rawX - this.zzs;
            double d2 = rawY - this.zzt;
            this.zzk += Math.sqrt((d * d) + (d2 * d2));
            this.zzs = rawX;
            this.zzt = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    this.zzb = motionEventObtain;
                    LinkedList linkedList = this.zzc;
                    linkedList.add(motionEventObtain);
                    if (linkedList.size() > 6) {
                        ((MotionEvent) linkedList.remove()).recycle();
                    }
                    this.zzf++;
                    this.zzh = zzn(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.zze += (long) (motionEvent.getHistorySize() + 1);
                    zzayf zzayfVarZzm = zzm(motionEvent);
                    Long l2 = zzayfVarZzm.zzd;
                    if (l2 != null && zzayfVarZzm.zzg != null) {
                        this.zzi += l2.longValue() + zzayfVarZzm.zzg.longValue();
                    }
                    if (this.zzq != null && (l = zzayfVarZzm.zze) != null && zzayfVarZzm.zzh != null) {
                        this.zzj += l.longValue() + zzayfVarZzm.zzh.longValue();
                    }
                } else if (action2 == 3) {
                    this.zzg++;
                }
            } catch (zzaxt unused) {
            }
        } else {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final synchronized void zze(int i, int i2, int i3) {
        if (this.zzb != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcT)).booleanValue()) {
                zzo();
            } else {
                this.zzb.recycle();
            }
        }
        DisplayMetrics displayMetrics = this.zzq;
        if (displayMetrics != null) {
            this.zzb = MotionEvent.obtain(0L, i3, 1, i * displayMetrics.density, i2 * this.zzq.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzb = null;
        }
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzg(Context context, String str, View view) {
        return zzp(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public void zzh(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        zzaxv zzaxvVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdk)).booleanValue() || (zzaxvVar = this.zzr) == null) {
            return;
        }
        zzaxvVar.zza(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzj(Context context, View view, Activity activity) {
        return zzp(context, null, 2, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzk(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzl(Context context) {
        if (zzayg.zzd()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzp(context, null, 1, null, null, null);
    }

    protected abstract zzayf zzm(MotionEvent motionEvent) throws zzaxt;

    protected abstract long zzn(StackTraceElement[] stackTraceElementArr) throws zzaxt;
}
