package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzes implements zzao {
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x0042  */
    public zzes(String str, byte[] bArr, int i, int i2) {
        byte b;
        byte b2;
        boolean z = true;
        switch (str) {
            case "com.android.capture.fps":
                b = 0;
                break;
            case "auxiliary.tracks.interleaved":
                b = 4;
                break;
            case "auxiliary.tracks.length":
                b = 2;
                break;
            case "auxiliary.tracks.offset":
                b = 1;
                break;
            case "auxiliary.tracks.map":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            if (i2 != 23) {
                z = false;
            } else if (bArr.length == 4) {
                i2 = 23;
            } else {
                i2 = 23;
                z = false;
            }
            zzgmd.zza(z);
        } else if (b == 1 || b == 2) {
            if (i2 != 78) {
                z = false;
            } else if (bArr.length == 8) {
                i2 = 78;
            } else {
                i2 = 78;
                z = false;
            }
            zzgmd.zza(z);
        } else if (b == 3) {
            zzgmd.zza(i2 == 0);
        } else if (b == 4) {
            if (i2 != 75) {
                z = false;
            } else if (bArr.length == 1 && ((b2 = bArr[0]) == 0 || b2 == 1)) {
                i2 = 75;
            } else {
                i2 = 75;
                z = false;
            }
            zzgmd.zza(z);
        }
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i;
        this.zzd = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzes zzesVar = (zzes) obj;
            if (this.zza.equals(zzesVar.zza) && Arrays.equals(this.zzb, zzesVar.zzb) && this.zzc == zzesVar.zzc && this.zzd == zzesVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final List zzb() {
        zzgmd.zzi(this.zza.equals("auxiliary.tracks.map"), "Metadata is not an auxiliary tracks map");
        byte[] bArr = this.zzb;
        byte b = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < b; i++) {
            arrayList.add(Integer.valueOf(bArr[i + 2]));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x007e  */
    /* JADX WARN: Code duplicated, block: B:26:0x008c A[LOOP:0: B:24:0x0089->B:26:0x008c, LOOP_END] */
    public final String toString() {
        String string;
        byte[] bArr;
        StringBuilder sb;
        int i = this.zzd;
        if (i != 0) {
            if (i == 1) {
                string = zzep.zzi(this.zzb);
            } else if (i == 23) {
                string = String.valueOf(Float.intBitsToFloat(zzgst.zzd(this.zzb)));
            } else if (i == 67) {
                string = String.valueOf(zzgst.zzd(this.zzb));
            } else if (i == 75) {
                string = String.valueOf(zzeg$$ExternalSyntheticBackport0.m(this.zzb[0]));
            } else if (i != 78) {
                bArr = this.zzb;
                String str = zzep.zza;
                int length = bArr.length;
                sb = new StringBuilder(length + length);
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                    sb.append(Character.forDigit(bArr[i2] & Ascii.SI, 16));
                }
                string = sb.toString();
            } else {
                string = String.valueOf(new zzeg(this.zzb).zzJ());
            }
        } else if (this.zza.equals("auxiliary.tracks.map")) {
            List listZzb = zzb();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("track types = ");
            zzglx.zzb(sb2, listZzb, ",");
            string = sb2.toString();
        } else {
            bArr = this.zzb;
            String str2 = zzep.zza;
            int length2 = bArr.length;
            sb = new StringBuilder(length2 + length2);
            while (i2 < bArr.length) {
                sb.append(Character.forDigit((bArr[i2] >> 4) & 15, 16));
                sb.append(Character.forDigit(bArr[i2] & Ascii.SI, 16));
            }
            string = sb.toString();
        }
        String str3 = this.zza;
        StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + 18 + String.valueOf(string).length());
        sb3.append("mdta: key=");
        sb3.append(str3);
        sb3.append(", value=");
        sb3.append(string);
        return sb3.toString();
    }
}
