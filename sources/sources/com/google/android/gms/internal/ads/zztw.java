package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zztw implements zzvn {
    private final zzadg zza;
    private zzada zzb;
    private zzadb zzc;

    public zztw(zzadg zzadgVar) {
        this.zza = zzadgVar;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zza(zzj zzjVar, Uri uri, Map map, long j, long j2, zzadd zzaddVar) throws IOException {
        zzacr zzacrVar = new zzacr(zzjVar, j, j2);
        this.zzc = zzacrVar;
        if (this.zzb != null) {
            return;
        }
        zzada[] zzadaVarArrZzb = this.zza.zzb(uri, map);
        int length = zzadaVarArrZzb.length;
        zzgpb zzgpbVarZzv = zzgpe.zzv(length);
        if (length == 1) {
            this.zzb = zzadaVarArrZzb[0];
        } else {
            for (int i = 0; i < length; i++) {
                zzada zzadaVar = zzadaVarArrZzb[i];
                try {
                    if (zzadaVar.zza(zzacrVar)) {
                        this.zzb = zzadaVar;
                        zzgmd.zzh(zzadaVar != null || zzacrVar.zzn() == j);
                        zzacrVar.zzl();
                        break;
                    } else {
                        zzgpbVarZzv.zzh(zzadaVar.zzb());
                        boolean z = this.zzb != null || zzacrVar.zzn() == j;
                        zzgmd.zzh(z);
                        zzacrVar.zzl();
                    }
                } catch (EOFException unused) {
                    if (this.zzb != null || zzacrVar.zzn() == j) {
                    }
                } catch (Throwable th) {
                    zzgmd.zzh(this.zzb != null || zzacrVar.zzn() == j);
                    zzacrVar.zzl();
                    throw th;
                }
                zzgmd.zzh(z);
                zzacrVar.zzl();
            }
            if (this.zzb == null) {
                String strZzd = zzglx.zzd(zzgqe.zzc(zzgpe.zzr(zzadaVarArrZzb), zztv.zza), ", ");
                StringBuilder sb = new StringBuilder(strZzd.length() + 58);
                sb.append("None of the available extractors (");
                sb.append(strZzd);
                sb.append(") could read the stream.");
                throw new zzww(sb.toString(), uri, zzgpbVarZzv.zzi());
            }
        }
        this.zzb.zzc(zzaddVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzb() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zzc() {
        zzada zzadaVar = this.zzb;
        if (zzadaVar != null && (zzadaVar instanceof zzahs)) {
            ((zzahs) zzadaVar).zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final long zzd() {
        zzadb zzadbVar = this.zzc;
        if (zzadbVar != null) {
            return zzadbVar.zzn();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final void zze(long j, long j2) {
        zzada zzadaVar = this.zzb;
        zzadaVar.getClass();
        zzadaVar.zze(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzvn
    public final int zzf(zzaea zzaeaVar) throws IOException {
        zzadb zzadbVar;
        zzada zzadaVar = this.zzb;
        if (zzadaVar == null || (zzadbVar = this.zzc) == null) {
            throw null;
        }
        return zzadaVar.zzd(zzadbVar, zzaeaVar);
    }
}
