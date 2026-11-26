package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpe {
    static final zzgph zzb;
    private final SparseArray zzd = new SparseArray();
    private final int zze;
    public static final zzpe zza = new zzpe(zzgpe.zzj(zzpd.zza));
    private static final zzgpe zzc = zzgpe.zzl(2, 5, 6);

    static {
        zzgpg zzgpgVar = new zzgpg();
        zzgpgVar.zza(5, 6);
        zzgpgVar.zza(17, 6);
        zzgpgVar.zza(7, 6);
        zzgpgVar.zza(30, 10);
        zzgpgVar.zza(18, 6);
        zzgpgVar.zza(6, 8);
        zzgpgVar.zza(8, 8);
        zzgpgVar.zza(14, 8);
        zzb = zzgpgVar.zzc();
    }

    private zzpe(List list) {
        for (int i = 0; i < list.size(); i++) {
            zzpd zzpdVar = (zzpd) list.get(i);
            this.zzd.put(zzpdVar.zzb, zzpdVar);
        }
        int iMax = 0;
        for (int i2 = 0; i2 < this.zzd.size(); i2++) {
            iMax = Math.max(iMax, ((zzpd) this.zzd.valueAt(i2)).zzc);
        }
        this.zze = iMax;
    }

    static zzpe zza(Context context, zzd zzdVar, AudioDeviceInfo audioDeviceInfo) {
        return zzb(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), zzdVar, audioDeviceInfo);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0028  */
    static zzpe zzb(Context context, Intent intent, zzd zzdVar, AudioDeviceInfo audioDeviceInfo) {
        AudioManager audioManagerZza = zzcb.zza(context);
        if (audioDeviceInfo == null) {
            if (Build.VERSION.SDK_INT >= 33) {
                List<AudioDeviceInfo> audioDevicesForAttributes = audioManagerZza.getAudioDevicesForAttributes(zzdVar.zza());
                if (audioDevicesForAttributes.isEmpty()) {
                    audioDeviceInfo = null;
                } else {
                    audioDeviceInfo = audioDevicesForAttributes.get(0);
                }
            } else {
                audioDeviceInfo = null;
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && (zzep.zzN(context) || zzep.zzO(context))) {
            List<AudioProfile> directProfilesForAttributes = audioManagerZza.getDirectProfilesForAttributes(zzdVar.zza());
            HashMap map = new HashMap();
            map.put(2, new HashSet(zzgst.zzg(12)));
            for (int i = 0; i < directProfilesForAttributes.size(); i++) {
                AudioProfile audioProfile = directProfilesForAttributes.get(i);
                if (audioProfile.getEncapsulationType() != 1) {
                    int format = audioProfile.getFormat();
                    if (zzep.zzA(format) || zzb.containsKey(Integer.valueOf(format))) {
                        Integer numValueOf = Integer.valueOf(format);
                        if (map.containsKey(numValueOf)) {
                            Set set = (Set) map.get(numValueOf);
                            set.getClass();
                            set.addAll(zzgst.zzg(audioProfile.getChannelMasks()));
                        } else {
                            map.put(numValueOf, new HashSet(zzgst.zzg(audioProfile.getChannelMasks())));
                        }
                    }
                }
            }
            int i2 = zzgpe.zzd;
            zzgpb zzgpbVar = new zzgpb();
            for (Map.Entry entry : map.entrySet()) {
                zzgpbVar.zzf(new zzpd(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
            }
            return new zzpe(zzgpbVar.zzi());
        }
        AudioDeviceInfo[] devices = audioDeviceInfo == null ? audioManagerZza.getDevices(2) : new AudioDeviceInfo[]{audioDeviceInfo};
        zzgpn zzgpnVar = new zzgpn();
        zzgpnVar.zzg(8, 7);
        if (Build.VERSION.SDK_INT >= 31) {
            zzgpnVar.zzg(26, 27);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            zzgpnVar.zzf((Object) 30);
        }
        zzgpo zzgpoVarZzi = zzgpnVar.zzi();
        for (AudioDeviceInfo audioDeviceInfo2 : devices) {
            if (zzgpoVarZzi.contains(Integer.valueOf(audioDeviceInfo2.getType()))) {
                return zza;
            }
        }
        zzgpn zzgpnVar2 = new zzgpn();
        zzgpnVar2.zzf((Object) 2);
        if (Build.VERSION.SDK_INT >= 29 && (zzep.zzN(context) || zzep.zzO(context))) {
            int i3 = zzgpe.zzd;
            zzgpb zzgpbVar2 = new zzgpb();
            zzgrs it = zzb.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (Build.VERSION.SDK_INT >= zzep.zzD(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), zzdVar.zza())) {
                    zzgpbVar2.zzf(Integer.valueOf(iIntValue));
                }
            }
            zzgpbVar2.zzf((Object) 2);
            zzgpnVar2.zzh(zzgpbVar2.zzi());
            return new zzpe(zzf(zzgst.zzf(zzgpnVar2.zzi()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z || zze()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            zzgpnVar2.zzh(zzc);
        }
        if (intent == null || z || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new zzpe(zzf(zzgst.zzf(zzgpnVar2.zzi()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            zzgpnVar2.zzh(zzgst.zzg(intArrayExtra));
        }
        return new zzpe(zzf(zzgst.zzf(zzgpnVar2.zzi()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    static Uri zzc() {
        if (zze()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    private static boolean zze() {
        return Build.MANUFACTURER.equals("Amazon") || Build.MANUFACTURER.equals("Xiaomi");
    }

    private static zzgpe zzf(int[] iArr, int i) {
        int i2 = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        for (int i3 : iArr) {
            zzgpbVar.zzf(new zzpd(i3, i));
        }
        return zzgpbVar.zzi();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0047 A[RETURN] */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpe)) {
            return false;
        }
        zzpe zzpeVar = (zzpe) obj;
        SparseArray sparseArray = this.zzd;
        SparseArray<?> sparseArray2 = zzpeVar.zzd;
        String str = zzep.zza;
        if (Build.VERSION.SDK_INT < 31) {
            int size = sparseArray.size();
            if (size == sparseArray2.size()) {
                for (int i = 0; i < size; i++) {
                    if (Objects.equals(sparseArray.valueAt(i), sparseArray2.get(sparseArray.keyAt(i)))) {
                    }
                }
                if (this.zze == zzpeVar.zze) {
                    return true;
                }
            }
        } else if (sparseArray.contentEquals(sparseArray2)) {
            if (this.zze == zzpeVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iContentHashCode;
        String str = zzep.zza;
        int i = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.zzd;
        if (i >= 31) {
            iContentHashCode = sparseArray.contentHashCode();
        } else {
            int iKeyAt = 17;
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                iKeyAt = (((iKeyAt * 31) + sparseArray.keyAt(i2)) * 31) + Objects.hashCode(sparseArray.valueAt(i2));
            }
            iContentHashCode = iKeyAt;
        }
        return this.zze + (iContentHashCode * 31);
    }

    public final String toString() {
        String string = this.zzd.toString();
        int i = this.zze;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 50 + string.length() + 1);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", audioProfiles=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    /* JADX WARN: Code duplicated, block: B:15:0x003b  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d A[PHI: r1
      0x003d: PHI (r1v5 int) = (r1v4 int), (r1v9 int) binds: [B:11:0x002f, B:14:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    /* JADX WARN: Code duplicated, block: B:52:0x009f  */
    public final Pair zzd(zzv zzvVar, zzd zzdVar) {
        String str = zzvVar.zzo;
        str.getClass();
        int iZzh = zzas.zzh(str, zzvVar.zzk);
        if (!zzb.containsKey(Integer.valueOf(iZzh))) {
            return null;
        }
        int i = 6;
        if (iZzh != 18) {
            if (iZzh != 8) {
                if (iZzh == 30 && !zzep.zza(this.zzd, 30)) {
                    iZzh = 7;
                }
            } else if (zzep.zza(this.zzd, 8)) {
                iZzh = 8;
                if (iZzh == 30) {
                    iZzh = 7;
                }
            } else {
                iZzh = 7;
            }
        } else if (zzep.zza(this.zzd, 18)) {
            iZzh = 18;
            if (iZzh != 8) {
                if (iZzh == 30) {
                    iZzh = 7;
                }
            } else if (zzep.zza(this.zzd, 8)) {
                iZzh = 8;
                if (iZzh == 30) {
                    iZzh = 7;
                }
            } else {
                iZzh = 7;
            }
        } else {
            iZzh = 6;
        }
        SparseArray sparseArray = this.zzd;
        if (!zzep.zza(sparseArray, iZzh)) {
            return null;
        }
        zzpd zzpdVar = (zzpd) sparseArray.get(iZzh);
        zzpdVar.getClass();
        int iZzb = zzvVar.zzG;
        if (iZzb == -1 || iZzh == 18) {
            int i2 = zzvVar.zzH;
            if (i2 == -1) {
                i2 = 48000;
            }
            iZzb = zzpdVar.zzb(i2, zzdVar);
        } else if (!str.equals("audio/vnd.dts.uhd;profile=p2") || Build.VERSION.SDK_INT >= 33) {
            if (!zzpdVar.zza(iZzb)) {
                return null;
            }
        } else if (iZzb > 10) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 28) {
            i = iZzb;
        } else if (iZzb == 7) {
            i = 8;
        } else if (iZzb != 3 && iZzb != 4 && iZzb != 5) {
            i = iZzb;
        }
        if (Build.VERSION.SDK_INT <= 26 && "fugu".equals(Build.DEVICE) && i == 1) {
            i = 2;
        }
        int iZzB = zzep.zzB(i);
        if (iZzB != 0) {
            return Pair.create(Integer.valueOf(iZzh), Integer.valueOf(iZzB));
        }
        return null;
    }
}
