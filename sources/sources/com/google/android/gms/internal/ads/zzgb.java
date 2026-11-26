package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzgb extends zzj {
    long zzb(zzgf zzgfVar) throws IOException;

    Uri zzc();

    void zzd() throws IOException;

    void zze(zzgz zzgzVar);

    default Map zzj() {
        return Collections.emptyMap();
    }
}
