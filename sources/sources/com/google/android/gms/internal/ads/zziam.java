package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziam extends zzhwo implements zzhya {
    private static final zziam zzb;
    private static volatile zzhyh zzc;
    private zzhxa zza = zzbM();

    static {
        zziam zziamVar = new zziam();
        zzb = zziamVar;
        zzhwo.zzbu(zziam.class, zziamVar);
    }

    private zziam() {
    }

    public static zzial zzc() {
        return (zzial) zzb.zzbn();
    }

    final /* synthetic */ void zzd(zziak zziakVar) {
        zziakVar.getClass();
        zzhxa zzhxaVar = this.zza;
        if (!zzhxaVar.zza()) {
            this.zza = zzhwo.zzbN(zzhxaVar);
        }
        this.zza.add(zziakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        zzhyh zzhwjVar;
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zziak.class});
        }
        if (iOrdinal == 3) {
            return new zziam();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzial(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhyhVar = zzc;
        if (zzhyhVar != null) {
            return zzhyhVar;
        }
        synchronized (zziam.class) {
            zzhwjVar = zzc;
            if (zzhwjVar == null) {
                zzhwjVar = new zzhwj(zzb);
                zzc = zzhwjVar;
            }
        }
        return zzhwjVar;
    }
}
