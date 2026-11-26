package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzgvs implements zzgwf {
    private static final Charset zza = Charset.forName("UTF-8");
    private final InputStream zzb;

    private zzgvs(InputStream inputStream) {
        this.zzb = inputStream;
    }

    public static zzgvs zza(String str) {
        return new zzgvs(new ByteArrayInputStream(str.getBytes(zza)));
    }

    private static int zzc(zzhtg zzhtgVar) throws IOException {
        if (!(zzhtgVar instanceof zzhtk)) {
            throw new IOException("invalid key id: not a JSON primitive");
        }
        if (!zzhtgVar.zzg().zzc()) {
            throw new IOException("invalid key id: not a JSON number");
        }
        try {
            long jZzc = zzhdv.zzc(zzhtgVar.zzg().zzh());
            if (jZzc > 4294967295L || jZzc < -2147483648L) {
                throw new IOException("invalid key id");
            }
            return (int) jZzc;
        } catch (NumberFormatException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:105:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:71:0x014d  */
    @Override // com.google.android.gms.internal.ads.zzgwf
    public final zzhlg zzb() throws IOException {
        byte b;
        int i;
        byte b2;
        zzhlt zzhltVar;
        byte b3;
        zzhkw zzhkwVar;
        String str = NotificationCompat.CATEGORY_STATUS;
        String str2 = "keyData";
        try {
            try {
                InputStream inputStream = this.zzb;
                int i2 = zzgwq.zza;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int i3 = inputStream.read(bArr);
                    InputStream inputStream2 = inputStream;
                    if (i3 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i3);
                    inputStream = inputStream2;
                }
                zzhti zzhtiVarZze = zzhdv.zzb(new String(byteArrayOutputStream.toByteArray(), zza)).zze();
                if (!zzhtiVarZze.zzc("key")) {
                    throw new zzhtj("invalid keyset: no key");
                }
                zzhtg zzhtgVarZzh = zzhtiVarZze.zzh("key");
                if (!(zzhtgVarZzh instanceof zzhtf)) {
                    throw new zzhtj("invalid keyset: key must be an array");
                }
                zzhtf zzhtfVarZzf = zzhtgVarZzh.zzf();
                if (zzhtfVarZzf.zzb() == 0) {
                    throw new zzhtj("invalid keyset: key is empty");
                }
                zzhld zzhldVarZzh = zzhlg.zzh();
                if (zzhtiVarZze.zzc("primaryKeyId")) {
                    zzhldVarZzh.zza(zzc(zzhtiVarZze.zzh("primaryKeyId")));
                }
                int i4 = 0;
                while (i4 < zzhtfVarZzf.zzb()) {
                    zzhti zzhtiVarZze2 = zzhtfVarZzf.zzc(i4).zze();
                    if (!zzhtiVarZze2.zzc(str2) || !zzhtiVarZze2.zzc(str) || !zzhtiVarZze2.zzc("keyId") || !zzhtiVarZze2.zzc("outputPrefixType")) {
                        throw new zzhtj("invalid key");
                    }
                    zzhtg zzhtgVarZzh2 = zzhtiVarZze2.zzh(str2);
                    if (!(zzhtgVarZzh2 instanceof zzhti)) {
                        throw new zzhtj("invalid key: keyData must be an object");
                    }
                    zzhle zzhleVarZze = zzhlf.zze();
                    String strZzd = zzhtiVarZze2.zzh(str).zzd();
                    String str3 = str;
                    int iHashCode = strZzd.hashCode();
                    String str4 = str2;
                    int i5 = i4;
                    if (iHashCode != -891611359) {
                        if (iHashCode != 478389753) {
                            if (iHashCode == 1053567612 && strZzd.equals("DISABLED")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                        } else if (strZzd.equals("DESTROYED")) {
                            b = 2;
                        } else {
                            b = -1;
                        }
                    } else if (strZzd.equals("ENABLED")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        i = 3;
                    } else if (b == 1) {
                        i = 4;
                    } else {
                        if (b != 2) {
                            String.valueOf(strZzd);
                            throw new zzhtj("unknown status: ".concat(String.valueOf(strZzd)));
                        }
                        i = 5;
                    }
                    zzhleVarZze.zze(i);
                    zzhleVarZze.zzc(zzc(zzhtiVarZze2.zzh("keyId")));
                    String strZzd2 = zzhtiVarZze2.zzh("outputPrefixType").zzd();
                    switch (strZzd2) {
                        case "LEGACY":
                            b2 = 2;
                            break;
                        case "RAW":
                            b2 = 1;
                            break;
                        case "TINK":
                            b2 = 0;
                            break;
                        case "CRUNCHY":
                            b2 = 3;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                    if (b2 == 0) {
                        zzhltVar = zzhlt.TINK;
                    } else if (b2 == 1) {
                        zzhltVar = zzhlt.RAW;
                    } else if (b2 == 2) {
                        zzhltVar = zzhlt.LEGACY;
                    } else {
                        if (b2 != 3) {
                            String.valueOf(strZzd2);
                            throw new zzhtj("unknown output prefix type: ".concat(String.valueOf(strZzd2)));
                        }
                        zzhltVar = zzhlt.CRUNCHY;
                    }
                    zzhleVarZze.zzd(zzhltVar);
                    zzhti zzhtiVarZze3 = zzhtgVarZzh2.zze();
                    if (!zzhtiVarZze3.zzc("typeUrl") || !zzhtiVarZze3.zzc("value") || !zzhtiVarZze3.zzc("keyMaterialType")) {
                        throw new zzhtj("invalid keyData");
                    }
                    byte[] bArrZza = zzhrl.zza(zzhtiVarZze3.zzh("value").zzd(), 2);
                    zzhkv zzhkvVarZzd = zzhkx.zzd();
                    zzhkvVarZzd.zza(zzhtiVarZze3.zzh("typeUrl").zzd());
                    zzhvi zzhviVar = zzhvi.zzb;
                    zzhkvVarZzd.zzb(zzhvi.zzr(bArrZza, 0, bArrZza.length));
                    String strZzd3 = zzhtiVarZze3.zzh("keyMaterialType").zzd();
                    switch (strZzd3) {
                        case "REMOTE":
                            b3 = 3;
                            break;
                        case "SYMMETRIC":
                            b3 = 0;
                            break;
                        case "ASYMMETRIC_PRIVATE":
                            b3 = 1;
                            break;
                        case "ASYMMETRIC_PUBLIC":
                            b3 = 2;
                            break;
                        default:
                            b3 = -1;
                            break;
                    }
                    if (b3 == 0) {
                        zzhkwVar = zzhkw.SYMMETRIC;
                    } else if (b3 == 1) {
                        zzhkwVar = zzhkw.ASYMMETRIC_PRIVATE;
                    } else if (b3 == 2) {
                        zzhkwVar = zzhkw.ASYMMETRIC_PUBLIC;
                    } else {
                        if (b3 != 3) {
                            String.valueOf(strZzd3);
                            throw new zzhtj("unknown key material type: ".concat(String.valueOf(strZzd3)));
                        }
                        zzhkwVar = zzhkw.REMOTE;
                    }
                    zzhkvVarZzd.zzc(zzhkwVar);
                    zzhleVarZze.zza((zzhkx) zzhkvVarZzd.zzbu());
                    zzhldVarZzh.zzb((zzhlf) zzhleVarZze.zzbu());
                    i4 = i5 + 1;
                    str = str3;
                    str2 = str4;
                }
                zzhlg zzhlgVar = (zzhlg) zzhldVarZzh.zzbu();
                this.zzb.close();
                return zzhlgVar;
            } catch (Throwable th) {
                this.zzb.close();
                throw th;
            }
        } catch (zzhtj | IllegalStateException e) {
            throw new IOException(e);
        }
    }
}
