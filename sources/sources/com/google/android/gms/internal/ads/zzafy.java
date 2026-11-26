package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzafy {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static zzafx zza(String str) throws IOException {
        long j;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            xmlPullParserNewPullParser.next();
            if (!zzeq.zzb(xmlPullParserNewPullParser, "x:xmpmeta")) {
                throw zzat.zzb("Couldn't find xmp metadata", null);
            }
            zzgpe zzgpeVarZzi = zzgpe.zzi();
            long j2 = -9223372036854775807L;
            do {
                xmlPullParserNewPullParser.next();
                if (zzeq.zzb(xmlPullParserNewPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        String strZzc = zzeq.zzc(xmlPullParserNewPullParser, strArr[i2]);
                        if (strZzc != null) {
                            if (Integer.parseInt(strZzc) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i3 = 0;
                            while (true) {
                                if (i3 < 4) {
                                    String strZzc2 = zzeq.zzc(xmlPullParserNewPullParser, strArr2[i3]);
                                    if (strZzc2 != null) {
                                        j = Long.parseLong(strZzc2);
                                        if (j != -1) {
                                            break;
                                        }
                                    } else {
                                        i3++;
                                    }
                                }
                                j = -9223372036854775807L;
                                break;
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i >= 2) {
                                    zzgpeVarZzi = zzgpe.zzi();
                                    break;
                                }
                                String strZzc3 = zzeq.zzc(xmlPullParserNewPullParser, strArr3[i]);
                                if (strZzc3 != null) {
                                    zzgpeVarZzi = zzgpe.zzk(new zzafw("image/jpeg", "Primary", 0L, 0L), new zzafw("video/mp4", "MotionPhoto", Long.parseLong(strZzc3), 0L));
                                    break;
                                }
                                i++;
                            }
                            j2 = j;
                        }
                    }
                    return null;
                }
                if (zzeq.zzb(xmlPullParserNewPullParser, "Container:Directory")) {
                    zzgpeVarZzi = zzc(xmlPullParserNewPullParser, "Container", "Item");
                } else if (zzeq.zzb(xmlPullParserNewPullParser, "GContainer:Directory")) {
                    zzgpeVarZzi = zzc(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzeq.zza(xmlPullParserNewPullParser, "x:xmpmeta"));
            if (zzgpeVarZzi.isEmpty()) {
                return null;
            }
            return new zzafx(j2, zzgpeVarZzi);
        } catch (zzat | NumberFormatException | XmlPullParserException unused) {
            zzdt.zzc("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    public static boolean zzb(String str) {
        if (str == null) {
            return false;
        }
        String[] strArr = zza;
        for (int i = 0; i < 4; i++) {
            String str2 = strArr[i];
            String.valueOf(str2);
            if (str.contains(String.valueOf(str2).concat("=\"1\""))) {
                return true;
            }
        }
        return false;
    }

    private static zzgpe zzc(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzeq.zzb(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZzc = zzeq.zzc(xmlPullParser, strConcat2);
                String strZzc2 = zzeq.zzc(xmlPullParser, strConcat3);
                String strZzc3 = zzeq.zzc(xmlPullParser, strConcat4);
                String strZzc4 = zzeq.zzc(xmlPullParser, strConcat5);
                if (strZzc == null || strZzc2 == null) {
                    return zzgpe.zzi();
                }
                zzgpbVar.zzf(new zzafw(strZzc, strZzc2, strZzc3 != null ? Long.parseLong(strZzc3) : 0L, strZzc4 != null ? Long.parseLong(strZzc4) : 0L));
            }
        } while (!zzeq.zza(xmlPullParser, str.concat(":Directory")));
        return zzgpbVar.zzi();
    }
}
