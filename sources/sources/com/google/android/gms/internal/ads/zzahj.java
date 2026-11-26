package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.core.view.MotionEventCompat;
import androidx.work.impl.Scheduler;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahj {
    public byte[] zzO;
    public zzaen zzU;
    public boolean zzW;
    public zzaem zzY;
    public zzv zzZ;
    public boolean zza;
    public int zzaa;
    private int zzab;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzael zzj;
    public byte[] zzk;
    public zzq zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public boolean zzy = false;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = -1;
    public int zzC = 1000;
    public int zzD = Scheduler.MAX_GREEDY_SCHEDULER_LIMIT;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public float zzN = -1.0f;
    public int zzP = 1;
    public int zzQ = -1;
    public int zzR = 8000;
    public long zzS = 0;
    public long zzT = 0;
    public boolean zzV = false;
    public boolean zzX = true;
    private String zzac = "eng";

    protected zzahj() {
    }

    private static Pair zzf(zzeg zzegVar) throws zzat {
        try {
            zzegVar.zzk(16);
            long jZzA = zzegVar.zzA();
            if (jZzA == 1482049860) {
                return new Pair("video/divx", null);
            }
            if (jZzA == 859189832) {
                return new Pair("video/3gpp", null);
            }
            if (jZzA != 826496599) {
                zzdt.zzc("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair("video/x-unknown", null);
            }
            int iZzg = zzegVar.zzg() + 20;
            byte[] bArrZzi = zzegVar.zzi();
            while (true) {
                int length = bArrZzi.length;
                if (iZzg >= length - 4) {
                    throw zzat.zzb("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzg + 1;
                if (bArrZzi[iZzg] == 0 && bArrZzi[i] == 0 && bArrZzi[iZzg + 2] == 1 && bArrZzi[iZzg + 3] == 15) {
                    return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrZzi, iZzg, length)));
                }
                iZzg = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzat {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzeg zzegVar) throws zzat {
        try {
            int iZzu = zzegVar.zzu();
            if (iZzu == 1) {
                return true;
            }
            if (iZzu == 65534) {
                zzegVar.zzh(24);
                if (zzegVar.zzD() == zzahk.zzf.getMostSignificantBits() && zzegVar.zzD() == zzahk.zzf.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzat {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        String.valueOf(str);
        throw zzat.zzb("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Code duplicated, block: B:135:0x0288 A[PHI: r9
      0x0288: PHI (r9v11 int) = (r9v5 int), (r9v6 int), (r9v7 int), (r9v8 int), (r9v9 int), (r9v10 int), (r9v0 int) binds: [B:139:0x02a4, B:133:0x0262, B:130:0x0234, B:128:0x022f, B:126:0x022a, B:124:0x0226, B:119:0x01fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:184:0x0408  */
    /* JADX WARN: Code duplicated, block: B:189:0x0421  */
    /* JADX WARN: Code duplicated, block: B:190:0x0423  */
    /* JADX WARN: Code duplicated, block: B:193:0x0430  */
    /* JADX WARN: Code duplicated, block: B:194:0x0440  */
    /* JADX WARN: Code duplicated, block: B:196:0x0446  */
    /* JADX WARN: Code duplicated, block: B:198:0x044a  */
    /* JADX WARN: Code duplicated, block: B:200:0x044e  */
    /* JADX WARN: Code duplicated, block: B:203:0x0456  */
    /* JADX WARN: Code duplicated, block: B:207:0x0460  */
    /* JADX WARN: Code duplicated, block: B:210:0x046e  */
    /* JADX WARN: Code duplicated, block: B:213:0x0473  */
    /* JADX WARN: Code duplicated, block: B:215:0x0479  */
    /* JADX WARN: Code duplicated, block: B:235:0x052c  */
    /* JADX WARN: Code duplicated, block: B:237:0x0553  */
    /* JADX WARN: Code duplicated, block: B:240:0x0558  */
    /* JADX WARN: Code duplicated, block: B:242:0x0566  */
    /* JADX WARN: Code duplicated, block: B:245:0x057a  */
    /* JADX WARN: Code duplicated, block: B:264:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:266:0x05e6  */
    /* JADX WARN: Code duplicated, block: B:268:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:284:0x0620  */
    /* JADX WARN: Code duplicated, block: B:286:0x062e  */
    /* JADX WARN: Code duplicated, block: B:289:0x063c  */
    /* JADX WARN: Code duplicated, block: B:290:0x063f  */
    /* JADX WARN: Code duplicated, block: B:293:0x0671  */
    /* JADX WARN: Code duplicated, block: B:329:? A[RETURN, SYNTHETIC] */
    @EnsuresNonNull({"this.output"})
    @RequiresNonNull({"codecId"})
    public final void zza(zzadd zzaddVar, int i) throws zzat {
        byte b;
        List listZzj;
        List listZzk;
        String str;
        String str2;
        int i2;
        List listZzg;
        int i3;
        String str3;
        int i4;
        zzt zztVar;
        int i5;
        int i6;
        float f;
        zzi zziVarZzg;
        byte[] bArr;
        int i7;
        int i8;
        int i9;
        String str4;
        zzaem zzaemVarZzu;
        zzer zzerVarZza;
        String str5 = this.zzc;
        int iZzz = 4;
        int i10 = 0;
        int iIntValue = -1;
        switch (str5) {
            case "V_MPEG4/ISO/AP":
                b = 6;
                break;
            case "V_MPEG4/ISO/SP":
                b = 4;
                break;
            case "A_MS/ACM":
                b = Ascii.ETB;
                break;
            case "A_TRUEHD":
                b = Ascii.DC2;
                break;
            case "A_VORBIS":
                b = Ascii.VT;
                break;
            case "A_MPEG/L2":
                b = Ascii.SO;
                break;
            case "A_MPEG/L3":
                b = Ascii.SI;
                break;
            case "V_MS/VFW/FOURCC":
                b = 9;
                break;
            case "S_DVBSUB":
                b = 33;
                break;
            case "V_MPEG4/ISO/ASP":
                b = 5;
                break;
            case "V_MPEG4/ISO/AVC":
                b = 7;
                break;
            case "S_VOBSUB":
                b = Ascii.US;
                break;
            case "A_DTS/LOSSLESS":
                b = Ascii.NAK;
                break;
            case "A_AAC":
                b = Ascii.CR;
                break;
            case "A_AC3":
                b = 16;
                break;
            case "A_DTS":
                b = 19;
                break;
            case "V_AV1":
                b = 2;
                break;
            case "V_VP8":
                b = 0;
                break;
            case "V_VP9":
                b = 1;
                break;
            case "S_HDMV/PGS":
                b = 32;
                break;
            case "V_THEORA":
                b = 10;
                break;
            case "A_DTS/EXPRESS":
                b = Ascii.DC4;
                break;
            case "A_PCM/FLOAT/IEEE":
                b = Ascii.SUB;
                break;
            case "A_PCM/INT/BIG":
                b = Ascii.EM;
                break;
            case "A_PCM/INT/LIT":
                b = 24;
                break;
            case "S_TEXT/ASS":
                b = Ascii.FS;
                break;
            case "S_TEXT/SSA":
                b = Ascii.GS;
                break;
            case "V_MPEGH/ISO/HEVC":
                b = 8;
                break;
            case "S_TEXT/WEBVTT":
                b = Ascii.RS;
                break;
            case "S_TEXT/UTF8":
                b = Ascii.ESC;
                break;
            case "V_MPEG2":
                b = 3;
                break;
            case "A_EAC3":
                b = 17;
                break;
            case "A_FLAC":
                b = Ascii.SYN;
                break;
            case "A_OPUS":
                b = Ascii.FF;
                break;
            default:
                b = -1;
                break;
        }
        String str6 = "audio/raw";
        switch (b) {
            case 0:
                str6 = "video/x-vnd.on2.vp8";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null && (zzerVarZza = zzer.zza(new zzeg(this.zzO))) != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11 = (z ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i8 = this.zzp;
                        if (i8 == -1) {
                            i8 = this.zzm;
                        }
                        this.zzp = i8;
                        i9 = this.zzq;
                        if (i9 == -1) {
                            i9 = this.zzn;
                        }
                        this.zzq = i9;
                    }
                    i6 = this.zzp;
                    if (i6 != -1 || (i7 = this.zzq) == -1) {
                        f = -1.0f;
                    } else {
                        f = (this.zzn * i6) / (this.zzm * i7);
                    }
                    if (this.zzy) {
                        if (this.zzE != -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f || this.zzM == -1.0f || this.zzN == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                            byteBufferOrder.put((byte) 0);
                            byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) ((this.zzL * 50000.0f) + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                            byteBufferOrder.putShort((short) (this.zzN + 0.5f));
                            byteBufferOrder.putShort((short) this.zzC);
                            byteBufferOrder.putShort((short) this.zzD);
                        }
                        zzh zzhVar = new zzh();
                        zzhVar.zza(this.zzz);
                        zzhVar.zzb(this.zzB);
                        zzhVar.zzc(this.zzA);
                        zzhVar.zzd(bArr);
                        zzhVar.zze(this.zzo);
                        zzhVar.zzf(this.zzo);
                        zziVarZzg = zzhVar.zzg();
                    } else {
                        zziVarZzg = null;
                    }
                    if (this.zzb != null) {
                        int i12 = zzahk.zza;
                        if (zzahk.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0 || Float.compare(this.zzt, 0.0f) != 0 || Float.compare(this.zzu, 0.0f) != 0) {
                        i10 = iIntValue;
                    } else if (Float.compare(this.zzv, 0.0f) != 0) {
                        if (Float.compare(this.zzv, 90.0f) == 0) {
                            i10 = 90;
                        } else if (Float.compare(this.zzv, -180.0f) == 0 || Float.compare(this.zzv, 180.0f) == 0) {
                            i10 = 180;
                        } else if (Float.compare(this.zzv, -90.0f) == 0) {
                            i10 = 270;
                        } else {
                            i10 = iIntValue;
                        }
                    }
                    zztVar.zzt(this.zzm);
                    zztVar.zzu(this.zzn);
                    zztVar.zzz(f);
                    zztVar.zzy(i10);
                    zztVar.zzA(this.zzw);
                    zztVar.zzB(this.zzx);
                    zztVar.zzC(zziVarZzg);
                    i5 = 2;
                } else {
                    if ("application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                        throw zzat.zzb("Unexpected MIME type.", null);
                    }
                    i5 = 3;
                }
                if (this.zzb != null) {
                    int i13 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    return;
                }
                zzaemVarZzu.zzu(this.zzZ);
                return;
            case 1:
                byte[] bArr2 = this.zzk;
                listZzj = bArr2 == null ? null : zzgpe.zzj(bArr2);
                str6 = "video/x-vnd.on2.vp9";
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z2 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i14 = (z2 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar2 = new zzh();
                            zzhVar2.zza(this.zzz);
                            zzhVar2.zzb(this.zzB);
                            zzhVar2.zzc(this.zzA);
                            zzhVar2.zzd(bArr);
                            zzhVar2.zze(this.zzo);
                            zzhVar2.zzf(this.zzo);
                            zziVarZzg = zzhVar2.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i15 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i16 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i14);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 2:
                byte[] bArr3 = this.zzk;
                listZzj = bArr3 == null ? null : zzgpe.zzj(bArr3);
                str6 = "video/av01";
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z3 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i17 = (z3 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar3 = new zzh();
                            zzhVar3.zza(this.zzz);
                            zzhVar3.zzb(this.zzB);
                            zzhVar3.zzc(this.zzA);
                            zzhVar3.zzd(bArr);
                            zzhVar3.zze(this.zzo);
                            zzhVar3.zzf(this.zzo);
                            zziVarZzg = zzhVar3.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i18 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i19 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i17);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 3:
                str6 = "video/mpeg2";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z4 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i110 = (z4 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar4 = new zzh();
                            zzhVar4.zza(this.zzz);
                            zzhVar4.zzb(this.zzB);
                            zzhVar4.zzc(this.zzA);
                            zzhVar4.zzd(bArr);
                            zzhVar4.zze(this.zzo);
                            zzhVar4.zzf(this.zzo);
                            zziVarZzg = zzhVar4.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i111 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i112 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i110);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr4 = this.zzk;
                listZzj = bArr4 == null ? null : Collections.singletonList(bArr4);
                str6 = "video/mp4v-es";
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z5 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i113 = (z5 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar5 = new zzh();
                            zzhVar5.zza(this.zzz);
                            zzhVar5.zzb(this.zzB);
                            zzhVar5.zzc(this.zzA);
                            zzhVar5.zzd(bArr);
                            zzhVar5.zze(this.zzo);
                            zzhVar5.zzf(this.zzo);
                            zziVarZzg = zzhVar5.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i114 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i115 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i113);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 7:
                zzacf zzacfVarZza = zzacf.zza(new zzeg(zzi(this.zzc)));
                listZzk = zzacfVarZza.zza;
                this.zzaa = zzacfVarZza.zzb;
                str = zzacfVarZza.zzl;
                str6 = "video/avc";
                str2 = str;
                i2 = -1;
                iZzz = -1;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z6 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i116 = (z6 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar6 = new zzh();
                            zzhVar6.zza(this.zzz);
                            zzhVar6.zzb(this.zzB);
                            zzhVar6.zzc(this.zzA);
                            zzhVar6.zzd(bArr);
                            zzhVar6.zze(this.zzo);
                            zzhVar6.zzf(this.zzo);
                            zziVarZzg = zzhVar6.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i117 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i118 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i116);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 8:
                zzadt zzadtVarZza = zzadt.zza(new zzeg(zzi(this.zzc)));
                listZzk = zzadtVarZza.zza;
                this.zzaa = zzadtVarZza.zzb;
                str = zzadtVarZza.zzn;
                str6 = "video/hevc";
                str2 = str;
                i2 = -1;
                iZzz = -1;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z7 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i119 = (z7 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar7 = new zzh();
                            zzhVar7.zza(this.zzz);
                            zzhVar7.zzb(this.zzB);
                            zzhVar7.zzc(this.zzA);
                            zzhVar7.zzd(bArr);
                            zzhVar7.zze(this.zzo);
                            zzhVar7.zzf(this.zzo);
                            zziVarZzg = zzhVar7.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1110 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i119);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 9:
                Pair pairZzf = zzf(new zzeg(zzi(this.zzc)));
                str6 = (String) pairZzf.first;
                listZzj = (List) pairZzf.second;
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z8 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1112 = (z8 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar8 = new zzh();
                            zzhVar8.zza(this.zzz);
                            zzhVar8.zzb(this.zzB);
                            zzhVar8.zzc(this.zzA);
                            zzhVar8.zzd(bArr);
                            zzhVar8.zze(this.zzo);
                            zzhVar8.zzf(this.zzo);
                            zziVarZzg = zzhVar8.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1113 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1114 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1112);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 10:
                str6 = "video/x-unknown";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z9 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1115 = (z9 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar9 = new zzh();
                            zzhVar9.zza(this.zzz);
                            zzhVar9.zzb(this.zzB);
                            zzhVar9.zzc(this.zzA);
                            zzhVar9.zzd(bArr);
                            zzhVar9.zze(this.zzo);
                            zzhVar9.zzf(this.zzo);
                            zziVarZzg = zzhVar9.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1116 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1117 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1115);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 11:
                listZzg = zzg(zzi(str5));
                i3 = 8192;
                str6 = "audio/vorbis";
                listZzk = listZzg;
                iZzz = -1;
                i2 = i3;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z10 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1118 = (z10 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar10 = new zzh();
                            zzhVar10.zza(this.zzz);
                            zzhVar10.zzb(this.zzB);
                            zzhVar10.zzc(this.zzA);
                            zzhVar10.zzd(bArr);
                            zzhVar10.zze(this.zzo);
                            zzhVar10.zzf(this.zzo);
                            zziVarZzg = zzhVar10.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1119 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11110 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1118);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 12:
                listZzg = new ArrayList(3);
                listZzg.add(zzi(this.zzc));
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzS).array());
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzT).array());
                i3 = 5760;
                str6 = "audio/opus";
                listZzk = listZzg;
                iZzz = -1;
                i2 = i3;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z11 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111 = (z11 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar11 = new zzh();
                            zzhVar11.zza(this.zzz);
                            zzhVar11.zzb(this.zzB);
                            zzhVar11.zzc(this.zzA);
                            zzhVar11.zzd(bArr);
                            zzhVar11.zze(this.zzo);
                            zzhVar11.zzf(this.zzo);
                            zziVarZzg = zzhVar11.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11112 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11113 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11111);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 13:
                List listSingletonList = Collections.singletonList(zzi(str5));
                zzaby zzabyVarZza = zzabz.zza(this.zzk);
                this.zzR = zzabyVarZza.zza;
                this.zzP = zzabyVarZza.zzb;
                str6 = "audio/mp4a-latm";
                str2 = zzabyVarZza.zzc;
                iZzz = -1;
                listZzk = listSingletonList;
                i2 = -1;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z12 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11114 = (z12 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar12 = new zzh();
                            zzhVar12.zza(this.zzz);
                            zzhVar12.zzb(this.zzB);
                            zzhVar12.zzc(this.zzA);
                            zzhVar12.zzd(bArr);
                            zzhVar12.zze(this.zzo);
                            zzhVar12.zzf(this.zzo);
                            zziVarZzg = zzhVar12.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11115 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11116 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11114);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 14:
                str6 = "audio/mpeg-L2";
                iZzz = -1;
                i2 = 4096;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z13 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11117 = (z13 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar13 = new zzh();
                            zzhVar13.zza(this.zzz);
                            zzhVar13.zzb(this.zzB);
                            zzhVar13.zzc(this.zzA);
                            zzhVar13.zzd(bArr);
                            zzhVar13.zze(this.zzo);
                            zzhVar13.zzf(this.zzo);
                            zziVarZzg = zzhVar13.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11118 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11119 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11117);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 15:
                str6 = "audio/mpeg";
                iZzz = -1;
                i2 = 4096;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z14 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111110 = (z14 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar14 = new zzh();
                            zzhVar14.zza(this.zzz);
                            zzhVar14.zzb(this.zzB);
                            zzhVar14.zzc(this.zzA);
                            zzhVar14.zzd(bArr);
                            zzhVar14.zze(this.zzo);
                            zzhVar14.zzf(this.zzo);
                            zziVarZzg = zzhVar14.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i111111 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i111112 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111110);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 16:
                str6 = "audio/ac3";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z15 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111113 = (z15 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar15 = new zzh();
                            zzhVar15.zza(this.zzz);
                            zzhVar15.zzb(this.zzB);
                            zzhVar15.zzc(this.zzA);
                            zzhVar15.zzd(bArr);
                            zzhVar15.zze(this.zzo);
                            zzhVar15.zzf(this.zzo);
                            zziVarZzg = zzhVar15.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i111114 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i111115 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111113);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 17:
                str6 = "audio/eac3";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z16 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111116 = (z16 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar16 = new zzh();
                            zzhVar16.zza(this.zzz);
                            zzhVar16.zzb(this.zzB);
                            zzhVar16.zzc(this.zzA);
                            zzhVar16.zzd(bArr);
                            zzhVar16.zze(this.zzo);
                            zzhVar16.zzf(this.zzo);
                            zziVarZzg = zzhVar16.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i111117 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i111118 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111116);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 18:
                this.zzU = new zzaen();
                str6 = "audio/true-hd";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z17 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111119 = (z17 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar17 = new zzh();
                            zzhVar17.zza(this.zzz);
                            zzhVar17.zzb(this.zzB);
                            zzhVar17.zzc(this.zzA);
                            zzhVar17.zzd(bArr);
                            zzhVar17.zze(this.zzo);
                            zzhVar17.zzf(this.zzo);
                            zziVarZzg = zzhVar17.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111110 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111111 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111119);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 19:
            case 20:
                this.zzV = true;
                str6 = "audio/vnd.dts";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z18 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1111112 = (z18 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar18 = new zzh();
                            zzhVar18.zza(this.zzz);
                            zzhVar18.zzb(this.zzB);
                            zzhVar18.zzc(this.zzA);
                            zzhVar18.zzd(bArr);
                            zzhVar18.zze(this.zzo);
                            zzhVar18.zzf(this.zzo);
                            zziVarZzg = zzhVar18.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111113 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111114 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1111112);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 21:
                str6 = "audio/vnd.dts.hd";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z19 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1111115 = (z19 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar19 = new zzh();
                            zzhVar19.zza(this.zzz);
                            zzhVar19.zzb(this.zzB);
                            zzhVar19.zzc(this.zzA);
                            zzhVar19.zzd(bArr);
                            zzhVar19.zze(this.zzo);
                            zzhVar19.zzf(this.zzo);
                            zziVarZzg = zzhVar19.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111116 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111117 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1111115);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 22:
                listZzj = Collections.singletonList(zzi(str5));
                str6 = "audio/flac";
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z110 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1111118 = (z110 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar110 = new zzh();
                            zzhVar110.zza(this.zzz);
                            zzhVar110.zzb(this.zzB);
                            zzhVar110.zzc(this.zzA);
                            zzhVar110.zzd(bArr);
                            zzhVar110.zze(this.zzo);
                            zzhVar110.zzf(this.zzo);
                            zziVarZzg = zzhVar110.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111119 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11111110 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1111118);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 23:
                if (zzh(new zzeg(zzi(this.zzc)))) {
                    iZzz = zzep.zzz(this.zzQ, ByteOrder.LITTLE_ENDIAN);
                    if (iZzz == 0) {
                        int i20 = this.zzQ;
                        StringBuilder sb = new StringBuilder(String.valueOf(i20).length() + 64);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i20);
                        sb.append(". Setting mimeType to audio/x-unknown");
                        zzdt.zzc("MatroskaExtractor", sb.toString());
                    } else {
                        i2 = -1;
                    }
                    listZzk = null;
                    str2 = null;
                    if (this.zzO != null) {
                        str2 = zzerVarZza.zza;
                        str6 = "video/dolby-vision";
                    }
                    str3 = str6;
                    boolean z111 = this.zzX;
                    if (true != this.zzW) {
                        i4 = 0;
                    } else {
                        i4 = 2;
                    }
                    int i11111111 = (z111 ? 1 : 0) | i4;
                    zztVar = new zzt();
                    if (!zzas.zza(str3)) {
                        if (zzas.zzb(str3)) {
                            if (this.zzr == 0) {
                                i8 = this.zzp;
                                if (i8 == -1) {
                                    i8 = this.zzm;
                                }
                                this.zzp = i8;
                                i9 = this.zzq;
                                if (i9 == -1) {
                                    i9 = this.zzn;
                                }
                                this.zzq = i9;
                            }
                            i6 = this.zzp;
                            if (i6 != -1) {
                                f = -1.0f;
                            } else {
                                f = -1.0f;
                            }
                            if (this.zzy) {
                                if (this.zzE != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                zzh zzhVar111 = new zzh();
                                zzhVar111.zza(this.zzz);
                                zzhVar111.zzb(this.zzB);
                                zzhVar111.zzc(this.zzA);
                                zzhVar111.zzd(bArr);
                                zzhVar111.zze(this.zzo);
                                zzhVar111.zzf(this.zzo);
                                zziVarZzg = zzhVar111.zzg();
                            } else {
                                zziVarZzg = null;
                            }
                            if (this.zzb != null) {
                                int i11111112 = zzahk.zza;
                                if (zzahk.zzg.containsKey(this.zzb)) {
                                    iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                                }
                            }
                            if (this.zzs == 0) {
                                i10 = iIntValue;
                            } else {
                                i10 = iIntValue;
                            }
                            zztVar.zzt(this.zzm);
                            zztVar.zzu(this.zzn);
                            zztVar.zzz(f);
                            zztVar.zzy(i10);
                            zztVar.zzA(this.zzw);
                            zztVar.zzB(this.zzx);
                            zztVar.zzC(zziVarZzg);
                            i5 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                            }
                            i5 = 3;
                        }
                        break;
                    } else {
                        zztVar.zzE(this.zzP);
                        zztVar.zzF(this.zzR);
                        zztVar.zzG(iZzz);
                        i5 = 1;
                    }
                    if (this.zzb != null) {
                        int i11111113 = zzahk.zza;
                        if (!zzahk.zzg.containsKey(this.zzb)) {
                            zztVar.zzc(this.zzb);
                        }
                    }
                    zztVar.zzb(i);
                    if (true != this.zza) {
                        str4 = "video/x-matroska";
                    } else {
                        str4 = "video/webm";
                    }
                    zztVar.zzl(str4);
                    zztVar.zzm(str3);
                    zztVar.zzn(i2);
                    zztVar.zze(this.zzac);
                    zztVar.zzf(i11111111);
                    zztVar.zzp(listZzk);
                    zztVar.zzj(str2);
                    zztVar.zzq(this.zzl);
                    this.zzZ = zztVar.zzM();
                    zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                    this.zzY = zzaemVarZzu;
                    if (this.zzV) {
                        zzaemVarZzu.zzu(this.zzZ);
                        return;
                    }
                    return;
                }
                zzdt.zzc("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                i2 = -1;
                iZzz = -1;
                str6 = "audio/x-unknown";
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z112 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111114 = (z112 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar112 = new zzh();
                            zzhVar112.zza(this.zzz);
                            zzhVar112.zzb(this.zzB);
                            zzhVar112.zzc(this.zzA);
                            zzhVar112.zzd(bArr);
                            zzhVar112.zze(this.zzo);
                            zzhVar112.zzf(this.zzo);
                            zziVarZzg = zzhVar112.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11111115 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11111116 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11111114);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 24:
                iZzz = zzep.zzz(this.zzQ, ByteOrder.LITTLE_ENDIAN);
                if (iZzz == 0) {
                    int i21 = this.zzQ;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i21).length() + 78);
                    sb2.append("Unsupported little endian PCM bit depth: ");
                    sb2.append(i21);
                    sb2.append(". Setting mimeType to audio/x-unknown");
                    zzdt.zzc("MatroskaExtractor", sb2.toString());
                    i2 = -1;
                    iZzz = -1;
                    str6 = "audio/x-unknown";
                } else {
                    i2 = -1;
                }
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z113 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111117 = (z113 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar113 = new zzh();
                            zzhVar113.zza(this.zzz);
                            zzhVar113.zzb(this.zzB);
                            zzhVar113.zzc(this.zzA);
                            zzhVar113.zzd(bArr);
                            zzhVar113.zze(this.zzo);
                            zzhVar113.zzf(this.zzo);
                            zziVarZzg = zzhVar113.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11111118 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11111119 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11111117);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 25:
                int i22 = this.zzQ;
                if (i22 == 8) {
                    iZzz = 3;
                } else if (i22 == 16) {
                    iZzz = 268435456;
                } else if (i22 == 24) {
                    iZzz = 1342177280;
                } else {
                    if (i22 != 32) {
                        StringBuilder sb3 = new StringBuilder(String.valueOf(i22).length() + 75);
                        sb3.append("Unsupported big endian PCM bit depth: ");
                        sb3.append(i22);
                        sb3.append(". Setting mimeType to audio/x-unknown");
                        zzdt.zzc("MatroskaExtractor", sb3.toString());
                        i2 = -1;
                        iZzz = -1;
                        str6 = "audio/x-unknown";
                        listZzk = null;
                        str2 = null;
                        if (this.zzO != null) {
                            str2 = zzerVarZza.zza;
                            str6 = "video/dolby-vision";
                        }
                        str3 = str6;
                        boolean z114 = this.zzX;
                        if (true != this.zzW) {
                            i4 = 0;
                        } else {
                            i4 = 2;
                        }
                        int i111111110 = (z114 ? 1 : 0) | i4;
                        zztVar = new zzt();
                        if (!zzas.zza(str3)) {
                            if (zzas.zzb(str3)) {
                                if (this.zzr == 0) {
                                    i8 = this.zzp;
                                    if (i8 == -1) {
                                        i8 = this.zzm;
                                    }
                                    this.zzp = i8;
                                    i9 = this.zzq;
                                    if (i9 == -1) {
                                        i9 = this.zzn;
                                    }
                                    this.zzq = i9;
                                }
                                i6 = this.zzp;
                                if (i6 != -1) {
                                    f = -1.0f;
                                } else {
                                    f = -1.0f;
                                }
                                if (this.zzy) {
                                    if (this.zzE != -1.0f) {
                                        bArr = null;
                                    } else {
                                        bArr = null;
                                    }
                                    zzh zzhVar114 = new zzh();
                                    zzhVar114.zza(this.zzz);
                                    zzhVar114.zzb(this.zzB);
                                    zzhVar114.zzc(this.zzA);
                                    zzhVar114.zzd(bArr);
                                    zzhVar114.zze(this.zzo);
                                    zzhVar114.zzf(this.zzo);
                                    zziVarZzg = zzhVar114.zzg();
                                } else {
                                    zziVarZzg = null;
                                }
                                if (this.zzb != null) {
                                    int i111111111 = zzahk.zza;
                                    if (zzahk.zzg.containsKey(this.zzb)) {
                                        iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                                    }
                                }
                                if (this.zzs == 0) {
                                    i10 = iIntValue;
                                } else {
                                    i10 = iIntValue;
                                }
                                zztVar.zzt(this.zzm);
                                zztVar.zzu(this.zzn);
                                zztVar.zzz(f);
                                zztVar.zzy(i10);
                                zztVar.zzA(this.zzw);
                                zztVar.zzB(this.zzx);
                                zztVar.zzC(zziVarZzg);
                                i5 = 2;
                            } else {
                                if ("application/x-subrip".equals(str3)) {
                                }
                                i5 = 3;
                            }
                            break;
                        } else {
                            zztVar.zzE(this.zzP);
                            zztVar.zzF(this.zzR);
                            zztVar.zzG(iZzz);
                            i5 = 1;
                        }
                        if (this.zzb != null) {
                            int i111111112 = zzahk.zza;
                            if (!zzahk.zzg.containsKey(this.zzb)) {
                                zztVar.zzc(this.zzb);
                            }
                        }
                        zztVar.zzb(i);
                        if (true != this.zza) {
                            str4 = "video/x-matroska";
                        } else {
                            str4 = "video/webm";
                        }
                        zztVar.zzl(str4);
                        zztVar.zzm(str3);
                        zztVar.zzn(i2);
                        zztVar.zze(this.zzac);
                        zztVar.zzf(i111111110);
                        zztVar.zzp(listZzk);
                        zztVar.zzj(str2);
                        zztVar.zzq(this.zzl);
                        this.zzZ = zztVar.zzM();
                        zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                        this.zzY = zzaemVarZzu;
                        if (this.zzV) {
                            zzaemVarZzu.zzu(this.zzZ);
                            return;
                        }
                        return;
                    }
                    iZzz = 1610612736;
                }
                i2 = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z115 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111111113 = (z115 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar115 = new zzh();
                            zzhVar115.zza(this.zzz);
                            zzhVar115.zzb(this.zzB);
                            zzhVar115.zzc(this.zzA);
                            zzhVar115.zzd(bArr);
                            zzhVar115.zze(this.zzo);
                            zzhVar115.zzf(this.zzo);
                            zziVarZzg = zzhVar115.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i111111114 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i111111115 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111111113);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 26:
                int i23 = this.zzQ;
                if (i23 == 32) {
                    i2 = -1;
                } else {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(i23).length() + 79);
                    sb4.append("Unsupported floating point PCM bit depth: ");
                    sb4.append(i23);
                    sb4.append(". Setting mimeType to audio/x-unknown");
                    zzdt.zzc("MatroskaExtractor", sb4.toString());
                    i2 = -1;
                    iZzz = -1;
                    str6 = "audio/x-unknown";
                }
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z116 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111111116 = (z116 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar116 = new zzh();
                            zzhVar116.zza(this.zzz);
                            zzhVar116.zzb(this.zzB);
                            zzhVar116.zzc(this.zzA);
                            zzhVar116.zzd(bArr);
                            zzhVar116.zze(this.zzo);
                            zzhVar116.zzf(this.zzo);
                            zziVarZzg = zzhVar116.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i111111117 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i111111118 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111111116);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 27:
                i2 = -1;
                iZzz = -1;
                str6 = "application/x-subrip";
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z117 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i111111119 = (z117 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar117 = new zzh();
                            zzhVar117.zza(this.zzz);
                            zzhVar117.zzb(this.zzB);
                            zzhVar117.zzc(this.zzA);
                            zzhVar117.zzd(bArr);
                            zzhVar117.zze(this.zzo);
                            zzhVar117.zzf(this.zzo);
                            zziVarZzg = zzhVar117.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111111110 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111111111 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i111111119);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
            case 29:
                int i24 = zzahk.zza;
                listZzk = zzgpe.zzk(zzahk.zzc, zzi(this.zzc));
                i2 = -1;
                iZzz = -1;
                str6 = "text/x-ssa";
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z118 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1111111112 = (z118 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar118 = new zzh();
                            zzhVar118.zza(this.zzz);
                            zzhVar118.zzb(this.zzB);
                            zzhVar118.zzc(this.zzA);
                            zzhVar118.zzd(bArr);
                            zzhVar118.zze(this.zzo);
                            zzhVar118.zzf(this.zzo);
                            zziVarZzg = zzhVar118.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111111113 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111111114 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1111111112);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 30:
                str6 = "text/vtt";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z119 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1111111115 = (z119 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar119 = new zzh();
                            zzhVar119.zza(this.zzz);
                            zzhVar119.zzb(this.zzB);
                            zzhVar119.zzc(this.zzA);
                            zzhVar119.zzd(bArr);
                            zzhVar119.zze(this.zzo);
                            zzhVar119.zzf(this.zzo);
                            zziVarZzg = zzhVar119.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111111116 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i1111111117 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1111111115);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 31:
                listZzj = zzgpe.zzj(zzi(str5));
                str6 = "application/vobsub";
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1110 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i1111111118 = (z1110 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar1110 = new zzh();
                            zzhVar1110.zza(this.zzz);
                            zzhVar1110.zzb(this.zzB);
                            zzhVar1110.zzc(this.zzA);
                            zzhVar1110.zzd(bArr);
                            zzhVar1110.zze(this.zzo);
                            zzhVar1110.zzf(this.zzo);
                            zziVarZzg = zzhVar1110.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i1111111119 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11111111110 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i1111111118);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case 32:
                str6 = "application/pgs";
                i2 = -1;
                iZzz = -1;
                listZzk = null;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1111 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111111111 = (z1111 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar1111 = new zzh();
                            zzhVar1111.zza(this.zzz);
                            zzhVar1111.zzb(this.zzB);
                            zzhVar1111.zzc(this.zzA);
                            zzhVar1111.zzd(bArr);
                            zzhVar1111.zze(this.zzo);
                            zzhVar1111.zzf(this.zzo);
                            zziVarZzg = zzhVar1111.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11111111112 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11111111113 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11111111111);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            case MotionEventCompat.AXIS_GENERIC_2 /* 33 */:
                byte[] bArr5 = new byte[4];
                System.arraycopy(zzi(str5), 0, bArr5, 0, 4);
                listZzj = zzgpe.zzj(bArr5);
                str6 = "application/dvbsubs";
                listZzk = listZzj;
                i2 = -1;
                iZzz = -1;
                str2 = null;
                if (this.zzO != null) {
                    str2 = zzerVarZza.zza;
                    str6 = "video/dolby-vision";
                }
                str3 = str6;
                boolean z1112 = this.zzX;
                if (true != this.zzW) {
                    i4 = 0;
                } else {
                    i4 = 2;
                }
                int i11111111114 = (z1112 ? 1 : 0) | i4;
                zztVar = new zzt();
                if (!zzas.zza(str3)) {
                    if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i8 = this.zzp;
                            if (i8 == -1) {
                                i8 = this.zzm;
                            }
                            this.zzp = i8;
                            i9 = this.zzq;
                            if (i9 == -1) {
                                i9 = this.zzn;
                            }
                            this.zzq = i9;
                        }
                        i6 = this.zzp;
                        if (i6 != -1) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (this.zzy) {
                            if (this.zzE != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zzh zzhVar1112 = new zzh();
                            zzhVar1112.zza(this.zzz);
                            zzhVar1112.zzb(this.zzB);
                            zzhVar1112.zzc(this.zzA);
                            zzhVar1112.zzd(bArr);
                            zzhVar1112.zze(this.zzo);
                            zzhVar1112.zzf(this.zzo);
                            zziVarZzg = zzhVar1112.zzg();
                        } else {
                            zziVarZzg = null;
                        }
                        if (this.zzb != null) {
                            int i11111111115 = zzahk.zza;
                            if (zzahk.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzahk.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i10 = iIntValue;
                        } else {
                            i10 = iIntValue;
                        }
                        zztVar.zzt(this.zzm);
                        zztVar.zzu(this.zzn);
                        zztVar.zzz(f);
                        zztVar.zzy(i10);
                        zztVar.zzA(this.zzw);
                        zztVar.zzB(this.zzx);
                        zztVar.zzC(zziVarZzg);
                        i5 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                        }
                        i5 = 3;
                    }
                    break;
                } else {
                    zztVar.zzE(this.zzP);
                    zztVar.zzF(this.zzR);
                    zztVar.zzG(iZzz);
                    i5 = 1;
                }
                if (this.zzb != null) {
                    int i11111111116 = zzahk.zza;
                    if (!zzahk.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str4 = "video/x-matroska";
                } else {
                    str4 = "video/webm";
                }
                zztVar.zzl(str4);
                zztVar.zzm(str3);
                zztVar.zzn(i2);
                zztVar.zze(this.zzac);
                zztVar.zzf(i11111111114);
                zztVar.zzp(listZzk);
                zztVar.zzj(str2);
                zztVar.zzq(this.zzl);
                this.zzZ = zztVar.zzM();
                zzaemVarZzu = zzaddVar.zzu(this.zzd, i5);
                this.zzY = zzaemVarZzu;
                if (this.zzV) {
                    zzaemVarZzu.zzu(this.zzZ);
                    return;
                }
                return;
            default:
                throw zzat.zzb("Unrecognized codec identifier.", null);
        }
    }

    final /* synthetic */ void zzb() {
        this.zzY.getClass();
    }

    final /* synthetic */ int zzc() {
        return this.zzab;
    }

    final /* synthetic */ void zzd(int i) {
        this.zzab = i;
    }

    final /* synthetic */ void zze(String str) {
        this.zzac = str;
    }
}
