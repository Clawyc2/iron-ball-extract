package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagv extends zzagq {
    public final String zza;
    public final zzgpe zzb;

    public zzagv(String str, String str2, List list) {
        super(str);
        zzgmd.zza(!list.isEmpty());
        this.zza = str2;
        zzgpe zzgpeVarZzq = zzgpe.zzq(list);
        this.zzb = zzgpeVarZzq;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagv zzagvVar = (zzagv) obj;
            if (Objects.equals(this.zzf, zzagvVar.zzf) && Objects.equals(this.zza, zzagvVar.zza) && this.zzb.equals(zzagvVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzagq
    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        String str = this.zzf;
        int length = String.valueOf(str).length();
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 14 + String.valueOf(str2).length() + 9 + String.valueOf(strValueOf).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": values=");
        sb.append(strValueOf);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        byte b;
        switch (this.zzf) {
            case "TAL":
                b = 6;
                break;
            case "TCM":
                b = Ascii.DLE;
                break;
            case "TDA":
                b = Ascii.FF;
                break;
            case "TP1":
                b = 2;
                break;
            case "TP2":
                b = 4;
                break;
            case "TP3":
                b = Ascii.DC2;
                break;
            case "TRK":
                b = 8;
                break;
            case "TT2":
                b = 0;
                break;
            case "TXT":
                b = Ascii.DC4;
                break;
            case "TYE":
                b = 10;
                break;
            case "TALB":
                b = 7;
                break;
            case "TCOM":
                b = 17;
                break;
            case "TCON":
                b = Ascii.SYN;
                break;
            case "TDAT":
                b = Ascii.CR;
                break;
            case "TDRC":
                b = Ascii.SO;
                break;
            case "TDRL":
                b = Ascii.SI;
                break;
            case "TEXT":
                b = Ascii.NAK;
                break;
            case "TIT2":
                b = 1;
                break;
            case "TPE1":
                b = 3;
                break;
            case "TPE2":
                b = 5;
                break;
            case "TPE3":
                b = 19;
                break;
            case "TRCK":
                b = 9;
                break;
            case "TYER":
                b = Ascii.VT;
                break;
            default:
                b = -1;
                break;
        }
        try {
            switch (b) {
                case 0:
                case 1:
                    zzamVar.zza((CharSequence) this.zzb.get(0));
                    break;
                case 2:
                case 3:
                    zzamVar.zzb((CharSequence) this.zzb.get(0));
                    break;
                case 4:
                case 5:
                    zzamVar.zzd((CharSequence) this.zzb.get(0));
                    break;
                case 6:
                case 7:
                    zzamVar.zzc((CharSequence) this.zzb.get(0));
                    break;
                case 8:
                case 9:
                    String str = (String) this.zzb.get(0);
                    String str2 = zzep.zza;
                    String[] strArrSplit = str.split("/", -1);
                    int i = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzamVar.zzg(Integer.valueOf(i));
                    zzamVar.zzh(numValueOf);
                    break;
                case 10:
                case 11:
                    zzamVar.zzi(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                    break;
                case 12:
                case 13:
                    String str3 = (String) this.zzb.get(0);
                    int i2 = Integer.parseInt(str3.substring(2, 4));
                    int i3 = Integer.parseInt(str3.substring(0, 2));
                    zzamVar.zzj(Integer.valueOf(i2));
                    zzamVar.zzk(Integer.valueOf(i3));
                    break;
                case 14:
                    List listZzb = zzb((String) this.zzb.get(0));
                    int size = listZzb.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                zzamVar.zzk((Integer) listZzb.get(2));
                            }
                        }
                        zzamVar.zzj((Integer) listZzb.get(1));
                    }
                    zzamVar.zzi((Integer) listZzb.get(0));
                    break;
                case 15:
                    List listZzb2 = zzb((String) this.zzb.get(0));
                    int size2 = listZzb2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                zzamVar.zzn((Integer) listZzb2.get(2));
                            }
                        }
                        zzamVar.zzm((Integer) listZzb2.get(1));
                    }
                    zzamVar.zzl((Integer) listZzb2.get(0));
                    break;
                case 16:
                case 17:
                    zzamVar.zzp((CharSequence) this.zzb.get(0));
                    break;
                case 18:
                case 19:
                    zzamVar.zzq((CharSequence) this.zzb.get(0));
                    break;
                case 20:
                case 21:
                    zzamVar.zzo((CharSequence) this.zzb.get(0));
                    break;
                case 22:
                    zzgpe zzgpeVar = this.zzb;
                    Integer numZzh = zzgst.zzh((String) zzgpeVar.get(0), 10);
                    if (numZzh != null) {
                        String strZza = zzagr.zza(numZzh.intValue());
                        if (strZza != null) {
                            zzamVar.zzt(strZza);
                        }
                    } else {
                        zzamVar.zzt((CharSequence) zzgpeVar.get(0));
                    }
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }
}
