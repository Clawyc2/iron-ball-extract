package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzale {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgpo zze = zzgpo.zzj(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "none");
    private static final zzgpo zzf = zzgpo.zzk("dot", "sesame", "circle");
    private static final zzgpo zzg = zzgpo.zzj("filled", "open");
    private static final zzgpo zzh = zzgpo.zzk("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzale(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    public static zzale zza(String str) {
        byte b;
        int i;
        if (str == null) {
            return null;
        }
        String strZza = zzglm.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzgpo zzgpoVarZzp = zzgpo.zzp(TextUtils.split(strZza, zzd));
        String str2 = (String) zzgps.zzb(zzgro.zza(zzh, zzgpoVarZzp), "outside");
        int iHashCode = str2.hashCode();
        int i2 = -1;
        int i3 = 0;
        if (iHashCode != -1106037339) {
            if (iHashCode == 92734940 && str2.equals("after")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str2.equals("outside")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            i = b != 1 ? 1 : -2;
        } else {
            i = 2;
        }
        zzgrn zzgrnVarZza = zzgro.zza(zze, zzgpoVarZzp);
        if (zzgrnVarZza.isEmpty()) {
            zzgrn zzgrnVarZza2 = zzgro.zza(zzg, zzgpoVarZzp);
            zzgrn zzgrnVarZza3 = zzgro.zza(zzf, zzgpoVarZzp);
            if (!zzgrnVarZza2.isEmpty() || !zzgrnVarZza3.isEmpty()) {
                String str3 = (String) zzgps.zzb(zzgrnVarZza2, "filled");
                int i4 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzgps.zzb(zzgrnVarZza3, "circle");
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 == 99657 && str4.equals("dot")) {
                        i2 = 0;
                    }
                } else if (str4.equals("sesame")) {
                    i2 = 1;
                }
                if (i2 == 0) {
                    i2 = 2;
                } else if (i2 != 1) {
                    i3 = i4;
                    i2 = 1;
                } else {
                    i2 = 3;
                }
                i3 = i4;
            }
        } else {
            String str5 = (String) zzgrnVarZza.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals("none")) {
                i2 = 0;
            }
        }
        return new zzale(i2, i3, i);
    }
}
