package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefd extends zzefe {
    private static final SparseArray zzg;
    private final Context zzb;
    private final zzcxs zzc;
    private final TelephonyManager zzd;
    private final zzeev zze;
    private zzbdz.zzq zzf;

    static {
        SparseArray sparseArray = new SparseArray();
        zzg = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbdz.zzaf.zzd.CONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzbdz.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzbdz.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzbdz.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbdz.zzaf.zzd.DISCONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzbdz.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzbdz.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzbdz.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzbdz.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzbdz.zzaf.zzd.DISCONNECTED);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbdz.zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzbdz.zzaf.zzd.CONNECTING);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzbdz.zzaf.zzd.CONNECTING);
    }

    zzefd(Context context, zzcxs zzcxsVar, zzeev zzeevVar, zzeer zzeerVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzeerVar, zzgVar);
        this.zzb = context;
        this.zzc = zzcxsVar;
        this.zze = zzeevVar;
        this.zzd = (TelephonyManager) context.getSystemService("phone");
    }

    static final /* synthetic */ zzbdz.zzaf.zzd zze(Bundle bundle) {
        return (zzbdz.zzaf.zzd) zzg.get(zzfhc.zza(zzfhc.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzbdz.zzaf.zzd.UNSPECIFIED);
    }

    private static final zzbdz.zzq zzg(boolean z) {
        return z ? zzbdz.zzq.ENUM_TRUE : zzbdz.zzq.ENUM_FALSE;
    }

    public final void zza(boolean z) {
        zzgui.zzr(this.zzc.zza(new Bundle()), new zzefc(this, z), zzcbv.zzg);
    }

    final /* synthetic */ zzbdz.zzab zzb(Bundle bundle) {
        zzbdz.zzab.zzb zzbVar;
        zzbdz.zzab.zza zzaVarZzq = zzbdz.zzab.zzq();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzf = zzbdz.zzq.ENUM_TRUE;
        } else {
            this.zzf = zzbdz.zzq.ENUM_FALSE;
            if (i == 0) {
                zzaVarZzq.zzc(zzbdz.zzab.zzc.CELL);
            } else if (i != 1) {
                zzaVarZzq.zzc(zzbdz.zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZzq.zzc(zzbdz.zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbdz.zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbdz.zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbdz.zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbdz.zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZzq.zzg(zzbVar);
        }
        return zzaVarZzq.zzbu();
    }

    final /* synthetic */ byte[] zzc(boolean z, ArrayList arrayList, zzbdz.zzab zzabVar, zzbdz.zzaf.zzd zzdVar) {
        zzbdz.zzaf.zza.C0011zza c0011zzaZzz = zzbdz.zzaf.zza.zzz();
        c0011zzaZzz.zzv(arrayList);
        Context context = this.zzb;
        c0011zzaZzz.zzJ(zzg(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0));
        c0011zzaZzz.zzN(com.google.android.gms.ads.internal.zzt.zzf().zzf(context, this.zzd));
        zzeev zzeevVar = this.zze;
        c0011zzaZzz.zzk(zzeevVar.zzf());
        c0011zzaZzz.zzo(zzeevVar.zzj());
        c0011zzaZzz.zzR(zzeevVar.zzd());
        c0011zzaZzz.zzZ(zzdVar);
        c0011zzaZzz.zzz(zzabVar);
        c0011zzaZzz.zzV(this.zzf);
        c0011zzaZzz.zzg(zzg(z));
        c0011zzaZzz.zzad(zzeevVar.zzb());
        c0011zzaZzz.zzc(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        c0011zzaZzz.zzF(zzg(Settings.Global.getInt(context.getContentResolver(), "wifi_on", 0) != 0));
        return c0011zzaZzz.zzbu().zzaN();
    }

    final /* synthetic */ zzeev zzd() {
        return this.zze;
    }
}
