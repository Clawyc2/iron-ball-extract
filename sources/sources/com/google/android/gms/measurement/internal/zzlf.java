package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.zip.GZIPInputStream;
import kotlin.time.DurationKt;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlf implements zzgz {
    private static volatile zzlf zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zziq zzD;
    private String zzE;
    long zza;
    private final zzfv zzc;
    private final zzfa zzd;
    private zzam zze;
    private zzfc zzf;
    private zzkr zzg;
    private zzaa zzh;
    private final zzlh zzi;
    private zzio zzj;
    private zzka zzk;
    private final zzku zzl;
    private zzfm zzm;
    private final zzge zzn;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;
    private boolean zzo = false;
    private final zzlm zzF = new zzla(this);

    zzlf(zzlg zzlgVar, zzge zzgeVar) {
        Preconditions.checkNotNull(zzlgVar);
        this.zzn = zzge.zzp(zzlgVar.zza, null, null);
        this.zzA = -1L;
        this.zzl = new zzku(this);
        zzlh zzlhVar = new zzlh(this);
        zzlhVar.zzX();
        this.zzi = zzlhVar;
        zzfa zzfaVar = new zzfa(this);
        zzfaVar.zzX();
        this.zzd = zzfaVar;
        zzfv zzfvVar = new zzfv(this);
        zzfvVar.zzX();
        this.zzc = zzfvVar;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new zzkv(this, zzlgVar));
    }

    static final void zzaa(com.google.android.gms.internal.measurement.zzfr zzfrVar, int i, String str) {
        List listZzp = zzfrVar.zzp();
        for (int i2 = 0; i2 < listZzp.size(); i2++) {
            if ("_err".equals(((com.google.android.gms.internal.measurement.zzfw) listZzp.get(i2)).zzg())) {
                return;
            }
        }
        com.google.android.gms.internal.measurement.zzfv zzfvVarZze = com.google.android.gms.internal.measurement.zzfw.zze();
        zzfvVarZze.zzj("_err");
        zzfvVarZze.zzi(Long.valueOf(i).longValue());
        com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) zzfvVarZze.zzaE();
        com.google.android.gms.internal.measurement.zzfv zzfvVarZze2 = com.google.android.gms.internal.measurement.zzfw.zze();
        zzfvVarZze2.zzj("_ev");
        zzfvVarZze2.zzk(str);
        com.google.android.gms.internal.measurement.zzfw zzfwVar2 = (com.google.android.gms.internal.measurement.zzfw) zzfvVarZze2.zzaE();
        zzfrVar.zzf(zzfwVar);
        zzfrVar.zzf(zzfwVar2);
    }

    static final void zzab(com.google.android.gms.internal.measurement.zzfr zzfrVar, String str) {
        List listZzp = zzfrVar.zzp();
        for (int i = 0; i < listZzp.size(); i++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzfw) listZzp.get(i)).zzg())) {
                zzfrVar.zzh(i);
                return;
            }
        }
    }

    private final zzq zzac(String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        if (zzhVarZzj == null || TextUtils.isEmpty(zzhVarZzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping", str);
            return null;
        }
        Boolean boolZzad = zzad(zzhVarZzj);
        if (boolZzad != null && !boolZzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping. appId", zzeu.zzn(str));
            return null;
        }
        String strZzy = zzhVarZzj.zzy();
        String strZzw = zzhVarZzj.zzw();
        long jZzb = zzhVarZzj.zzb();
        String strZzv = zzhVarZzj.zzv();
        long jZzm = zzhVarZzj.zzm();
        long jZzj = zzhVarZzj.zzj();
        boolean zZzai = zzhVarZzj.zzai();
        String strZzx = zzhVarZzj.zzx();
        zzhVarZzj.zza();
        return new zzq(str, strZzy, strZzw, jZzb, strZzv, jZzm, jZzj, (String) null, zZzai, false, strZzx, 0L, 0L, 0, zzhVarZzj.zzah(), false, zzhVarZzj.zzr(), zzhVarZzj.zzq(), zzhVarZzj.zzk(), zzhVarZzj.zzC(), (String) null, zzh(str).zzh(), "", (String) null);
    }

    private final Boolean zzad(zzh zzhVar) {
        try {
            if (zzhVar.zzb() != -2147483648L) {
                if (zzhVar.zzb() == Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzhVar.zzt(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(zzhVar.zzt(), 0).versionName;
                String strZzw = zzhVar.zzw();
                if (strZzw != null && strZzw.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List list = this.zzq;
        if (list == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        ((List) Preconditions.checkNotNull(this.zzq)).clear();
    }

    private final void zzaf(com.google.android.gms.internal.measurement.zzgb zzgbVar, long j, boolean z) {
        String str = true != z ? "_lte" : "_se";
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzlk zzlkVarZzp = zzamVar.zzp(zzgbVar.zzap(), str);
        zzlk zzlkVar = (zzlkVarZzp == null || zzlkVarZzp.zze == null) ? new zzlk(zzgbVar.zzap(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(j)) : new zzlk(zzgbVar.zzap(), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, str, zzav().currentTimeMillis(), Long.valueOf(((Long) zzlkVarZzp.zze).longValue() + j));
        com.google.android.gms.internal.measurement.zzgk zzgkVarZzd = com.google.android.gms.internal.measurement.zzgl.zzd();
        zzgkVarZzd.zzf(str);
        zzgkVarZzd.zzg(zzav().currentTimeMillis());
        zzgkVarZzd.zze(((Long) zzlkVar.zze).longValue());
        com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) zzgkVarZzd.zzaE();
        int iZza = zzlh.zza(zzgbVar, str);
        if (iZza >= 0) {
            zzgbVar.zzam(iZza, zzglVar);
        } else {
            zzgbVar.zzm(zzglVar);
        }
        if (j > 0) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzL(zzlkVar);
            zzay().zzj().zzc("Updated engagement user property. scope, value", true != z ? "lifetime" : "session-scoped", zzlkVar.zze);
        }
    }

    private final void zzag() {
        long jMax;
        long jMax2;
        zzaz().zzg();
        zzB();
        if (this.zza > 0) {
            long jAbs = 3600000 - Math.abs(zzav().elapsedRealtime() - this.zza);
            if (jAbs > 0) {
                zzay().zzj().zzb("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(jAbs));
                zzm().zzc();
                zzkr zzkrVar = this.zzg;
                zzal(zzkrVar);
                zzkrVar.zza();
                return;
            }
            this.zza = 0L;
        }
        if (!this.zzn.zzM() || !zzai()) {
            zzay().zzj().zza("Nothing to upload or uploading impossible");
            zzm().zzc();
            zzkr zzkrVar2 = this.zzg;
            zzal(zzkrVar2);
            zzkrVar2.zza();
            return;
        }
        long jCurrentTimeMillis = zzav().currentTimeMillis();
        zzg();
        long jMax3 = Math.max(0L, ((Long) zzeh.zzz.zza(null)).longValue());
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        boolean z = true;
        if (!zzamVar.zzH()) {
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            if (!zzamVar2.zzG()) {
                z = false;
            }
        }
        if (z) {
            String strZzl = zzg().zzl();
            if (TextUtils.isEmpty(strZzl) || ".none.".equals(strZzl)) {
                zzg();
                jMax = Math.max(0L, ((Long) zzeh.zzt.zza(null)).longValue());
            } else {
                zzg();
                jMax = Math.max(0L, ((Long) zzeh.zzu.zza(null)).longValue());
            }
        } else {
            zzg();
            jMax = Math.max(0L, ((Long) zzeh.zzs.zza(null)).longValue());
        }
        long jZza = this.zzk.zzc.zza();
        long jZza2 = this.zzk.zzd.zza();
        zzam zzamVar3 = this.zze;
        zzal(zzamVar3);
        long j = 0;
        long jZzd = zzamVar3.zzd();
        zzam zzamVar4 = this.zze;
        zzal(zzamVar4);
        boolean z2 = z;
        long jMax4 = Math.max(jZzd, zzamVar4.zze());
        if (jMax4 == 0) {
            jMax2 = 0;
        } else {
            long jAbs2 = jCurrentTimeMillis - Math.abs(jMax4 - jCurrentTimeMillis);
            long jAbs3 = Math.abs(jZza - jCurrentTimeMillis);
            long jAbs4 = jCurrentTimeMillis - Math.abs(jZza2 - jCurrentTimeMillis);
            long jMax5 = Math.max(jCurrentTimeMillis - jAbs3, jAbs4);
            long jMin = jMax3 + jAbs2;
            if (z2 && jMax5 > 0) {
                jMin = Math.min(jAbs2, jMax5) + jMax;
            }
            zzlh zzlhVar = this.zzi;
            zzal(zzlhVar);
            jMax2 = !zzlhVar.zzw(jMax5, jMax) ? jMax5 + jMax : jMin;
            if (jAbs4 != 0 && jAbs4 >= jAbs2) {
                int i = 0;
                while (true) {
                    zzg();
                    if (i >= Math.min(20, Math.max(0, ((Integer) zzeh.zzB.zza(null)).intValue()))) {
                        jMax2 = 0;
                        break;
                    }
                    zzg();
                    jMax2 += Math.max(j, ((Long) zzeh.zzA.zza(null)).longValue()) * (1 << i);
                    if (jMax2 > jAbs4) {
                        break;
                    }
                    i++;
                    j = 0;
                }
            }
            j = 0;
        }
        if (jMax2 == j) {
            zzay().zzj().zza("Next upload time is 0");
            zzm().zzc();
            zzkr zzkrVar3 = this.zzg;
            zzal(zzkrVar3);
            zzkrVar3.zza();
            return;
        }
        zzfa zzfaVar = this.zzd;
        zzal(zzfaVar);
        if (!zzfaVar.zza()) {
            zzay().zzj().zza("No network");
            zzm().zzb();
            zzkr zzkrVar4 = this.zzg;
            zzal(zzkrVar4);
            zzkrVar4.zza();
            return;
        }
        long jZza3 = this.zzk.zzb.zza();
        zzg();
        long jMax6 = Math.max(0L, ((Long) zzeh.zzq.zza(null)).longValue());
        zzlh zzlhVar2 = this.zzi;
        zzal(zzlhVar2);
        if (!zzlhVar2.zzw(jZza3, jMax6)) {
            jMax2 = Math.max(jMax2, jZza3 + jMax6);
        }
        zzm().zzc();
        long jCurrentTimeMillis2 = jMax2 - zzav().currentTimeMillis();
        if (jCurrentTimeMillis2 <= 0) {
            zzg();
            jCurrentTimeMillis2 = Math.max(0L, ((Long) zzeh.zzv.zza(null)).longValue());
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzay().zzj().zzb("Upload scheduled in approximately ms", Long.valueOf(jCurrentTimeMillis2));
        zzkr zzkrVar5 = this.zzg;
        zzal(zzkrVar5);
        zzkrVar5.zzd(jCurrentTimeMillis2);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0383 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x039b A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x03b4 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x03ce A[Catch: all -> 0x0cf7, TRY_ENTER, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x03de  */
    /* JADX WARN: Code duplicated, block: B:120:0x03e0 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:122:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:126:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:127:0x03fd A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0431  */
    /* JADX WARN: Code duplicated, block: B:135:0x0432 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0443  */
    /* JADX WARN: Code duplicated, block: B:140:0x044a A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0454 A[Catch: all -> 0x0cf7, LOOP:3: B:138:0x0444->B:142:0x0454, LOOP_END, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x0473  */
    /* JADX WARN: Code duplicated, block: B:148:0x0484 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0495  */
    /* JADX WARN: Code duplicated, block: B:151:0x0497 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:160:0x04d0 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x04de A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:165:0x04f3 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x051c  */
    /* JADX WARN: Code duplicated, block: B:173:0x0520 A[PHI: r7 r11 r17
      0x0520: PHI (r7v18 com.google.android.gms.internal.measurement.zzgb) = 
      (r7v17 com.google.android.gms.internal.measurement.zzgb)
      (r7v17 com.google.android.gms.internal.measurement.zzgb)
      (r7v20 com.google.android.gms.internal.measurement.zzgb)
      (r7v21 com.google.android.gms.internal.measurement.zzgb)
     binds: [B:161:0x04dc, B:163:0x04ef, B:159:0x04cd, B:158:0x04c6] A[DONT_GENERATE, DONT_INLINE]
      0x0520: PHI (r11v34 int) = (r11v1 int), (r11v1 int), (r11v1 int), (r11v36 int) binds: [B:161:0x04dc, B:163:0x04ef, B:159:0x04cd, B:158:0x04c6] A[DONT_GENERATE, DONT_INLINE]
      0x0520: PHI (r17v3 com.google.android.gms.internal.measurement.zzfr) = 
      (r17v0 com.google.android.gms.internal.measurement.zzfr)
      (r17v0 com.google.android.gms.internal.measurement.zzfr)
      (r17v0 com.google.android.gms.internal.measurement.zzfr)
      (r17v5 com.google.android.gms.internal.measurement.zzfr)
     binds: [B:161:0x04dc, B:163:0x04ef, B:159:0x04cd, B:158:0x04c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:183:0x056e A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x0579 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x057f A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0588  */
    /* JADX WARN: Code duplicated, block: B:374:0x0b61 A[Catch: all -> 0x0cf7, TryCatch #2 {all -> 0x0cf7, blocks: (B:3:0x000e, B:5:0x0025, B:8:0x002d, B:9:0x003f, B:12:0x0051, B:15:0x0078, B:17:0x00ae, B:20:0x00c0, B:22:0x00ca, B:175:0x0538, B:25:0x00f2, B:27:0x0100, B:30:0x0120, B:32:0x0126, B:34:0x0138, B:36:0x0146, B:38:0x0156, B:39:0x0163, B:40:0x0168, B:43:0x0181, B:113:0x03b4, B:114:0x03c0, B:117:0x03ce, B:123:0x03f1, B:120:0x03e0, B:146:0x0478, B:148:0x0484, B:151:0x0497, B:153:0x04a8, B:155:0x04b4, B:174:0x0522, B:160:0x04d0, B:162:0x04de, B:165:0x04f3, B:167:0x0504, B:169:0x0510, B:127:0x03fd, B:129:0x0409, B:131:0x0415, B:143:0x045a, B:135:0x0432, B:138:0x0444, B:140:0x044a, B:142:0x0454, B:69:0x01de, B:72:0x01e8, B:74:0x01f6, B:79:0x0245, B:75:0x0217, B:77:0x0229, B:83:0x0254, B:85:0x0280, B:86:0x02aa, B:88:0x02e2, B:90:0x02e9, B:93:0x02f5, B:95:0x032d, B:96:0x0349, B:98:0x034f, B:100:0x035f, B:104:0x0374, B:101:0x0369, B:107:0x037b, B:110:0x0383, B:111:0x039b, B:178:0x054d, B:180:0x055b, B:182:0x0566, B:193:0x0598, B:183:0x056e, B:185:0x0579, B:187:0x057f, B:190:0x058b, B:192:0x0593, B:194:0x059d, B:195:0x05a9, B:198:0x05b1, B:200:0x05c3, B:201:0x05cf, B:203:0x05d7, B:207:0x05fc, B:209:0x0621, B:211:0x0632, B:213:0x0638, B:215:0x0644, B:216:0x0673, B:218:0x0679, B:220:0x0687, B:221:0x068b, B:222:0x068e, B:223:0x0691, B:224:0x069f, B:226:0x06a5, B:228:0x06b5, B:229:0x06bc, B:231:0x06c8, B:232:0x06cf, B:233:0x06d2, B:235:0x0710, B:236:0x0723, B:238:0x0729, B:241:0x0744, B:243:0x075f, B:245:0x0776, B:247:0x077b, B:249:0x077f, B:251:0x0783, B:253:0x078d, B:254:0x0797, B:256:0x079b, B:258:0x07a1, B:259:0x07af, B:260:0x07b8, B:327:0x09f8, B:262:0x07c3, B:264:0x07da, B:269:0x07f4, B:271:0x0819, B:272:0x0821, B:274:0x0827, B:276:0x0839, B:282:0x084f, B:284:0x0864, B:285:0x0887, B:287:0x0893, B:289:0x08a8, B:290:0x08e4, B:294:0x08fc, B:296:0x0903, B:298:0x0912, B:300:0x0916, B:302:0x091a, B:304:0x091e, B:305:0x092a, B:306:0x092f, B:308:0x0935, B:310:0x0952, B:311:0x0957, B:326:0x09f5, B:312:0x096c, B:314:0x0971, B:318:0x0996, B:320:0x09c2, B:321:0x09cd, B:322:0x09df, B:324:0x09e7, B:315:0x097e, B:267:0x07e0, B:328:0x0a00, B:330:0x0a0c, B:331:0x0a12, B:332:0x0a1a, B:334:0x0a20, B:336:0x0a37, B:338:0x0a48, B:358:0x0ab8, B:360:0x0abe, B:362:0x0ad6, B:365:0x0add, B:370:0x0b0c, B:372:0x0b4f, B:375:0x0b84, B:376:0x0b88, B:377:0x0b93, B:379:0x0bd6, B:380:0x0be3, B:382:0x0bf2, B:385:0x0c0b, B:387:0x0c24, B:374:0x0b61, B:366:0x0ae5, B:368:0x0af1, B:369:0x0af5, B:388:0x0c3b, B:389:0x0c53, B:392:0x0c5b, B:393:0x0c60, B:394:0x0c70, B:396:0x0c8a, B:397:0x0ca5, B:399:0x0caf, B:403:0x0cd2, B:402:0x0cbf, B:339:0x0a60, B:341:0x0a66, B:343:0x0a6e, B:345:0x0a75, B:351:0x0a83, B:353:0x0a8a, B:355:0x0aa9, B:357:0x0ab0, B:356:0x0aad, B:352:0x0a87, B:344:0x0a72, B:204:0x05dc, B:206:0x05e2, B:406:0x0ce5), top: B:416:0x000e, inners: #0, #1, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:427:0x03f8 A[EDGE_INSN: B:427:0x03f8->B:124:0x03f8 BREAK  A[LOOP:2: B:114:0x03c0->B:123:0x03f1], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:430:0x03f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:432:0x045a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:444:0x0598 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x01c3  */
    private final boolean zzah(String str, long j) {
        int i;
        long j2;
        long j3;
        long j4;
        long j5;
        int iZzc;
        com.google.android.gms.internal.measurement.zzfw zzfwVarZzB;
        Long lValueOf;
        String str2;
        boolean z;
        int i2;
        boolean z2;
        com.google.android.gms.internal.measurement.zzgb zzgbVar;
        String str3;
        int i3;
        com.google.android.gms.internal.measurement.zzgb zzgbVar2;
        String str4;
        int i4;
        int i5;
        com.google.android.gms.internal.measurement.zzgb zzgbVar3;
        com.google.android.gms.internal.measurement.zzfr zzfrVar;
        int i6;
        com.google.android.gms.internal.measurement.zzfr zzfrVar2;
        ArrayList arrayList;
        int i7;
        int i8;
        int i9;
        String strZzh;
        int iCharCount;
        int iCodePointAt;
        byte b;
        String str5 = "_ai";
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzw();
        try {
            zzlc zzlcVar = new zzlc(this, null);
            zzam zzamVar2 = this.zze;
            zzal(zzamVar2);
            zzamVar2.zzU(null, j, this.zzA, zzlcVar);
            List list = zzlcVar.zzc;
            if (list != null && !list.isEmpty()) {
                com.google.android.gms.internal.measurement.zzgb zzgbVar4 = (com.google.android.gms.internal.measurement.zzgb) zzlcVar.zza.zzby();
                zzgbVar4.zzr();
                com.google.android.gms.internal.measurement.zzfr zzfrVar3 = null;
                com.google.android.gms.internal.measurement.zzfr zzfrVar4 = null;
                int i10 = 0;
                int i11 = 0;
                int i12 = -1;
                int i13 = -1;
                int i14 = 0;
                while (true) {
                    String str6 = "_et";
                    i = i11;
                    com.google.android.gms.internal.measurement.zzfr zzfrVar5 = zzfrVar3;
                    if (i10 >= zzlcVar.zzc.size()) {
                        break;
                    }
                    com.google.android.gms.internal.measurement.zzfr zzfrVar6 = (com.google.android.gms.internal.measurement.zzfr) ((com.google.android.gms.internal.measurement.zzfs) zzlcVar.zzc.get(i10)).zzby();
                    zzfv zzfvVar = this.zzc;
                    zzal(zzfvVar);
                    com.google.android.gms.internal.measurement.zzfr zzfrVar7 = zzfrVar4;
                    if (zzfvVar.zzr(zzlcVar.zza.zzx(), zzfrVar6.zzo())) {
                        zzay().zzk().zzc("Dropping blocked raw event. appId", zzeu.zzn(zzlcVar.zza.zzx()), this.zzn.zzj().zzd(zzfrVar6.zzo()));
                        zzfv zzfvVar2 = this.zzc;
                        zzal(zzfvVar2);
                        if (!zzfvVar2.zzp(zzlcVar.zza.zzx())) {
                            zzfv zzfvVar3 = this.zzc;
                            zzal(zzfvVar3);
                            if (!zzfvVar3.zzs(zzlcVar.zza.zzx()) && !"_err".equals(zzfrVar6.zzo())) {
                                zzv().zzN(this.zzF, zzlcVar.zza.zzx(), 11, "_ev", zzfrVar6.zzo(), 0);
                            }
                        }
                        str2 = str5;
                        i6 = i10;
                        i11 = i;
                        zzfrVar4 = zzfrVar7;
                        zzgbVar3 = zzgbVar4;
                    } else {
                        if (zzfrVar6.zzo().equals(zzhb.zza(str5))) {
                            zzfrVar6.zzi(str5);
                            zzay().zzj().zza("Renaming ad_impression to _ai");
                            if (Log.isLoggable(zzay().zzq(), 5)) {
                                int i15 = 0;
                                while (i15 < zzfrVar6.zza()) {
                                    String str7 = str5;
                                    if (FirebaseAnalytics.Param.AD_PLATFORM.equals(zzfrVar6.zzn(i15).zzg()) && !zzfrVar6.zzn(i15).zzh().isEmpty() && "admob".equalsIgnoreCase(zzfrVar6.zzn(i15).zzh())) {
                                        zzay().zzl().zza("AdMob ad impression logged from app. Potentially duplicative.");
                                    }
                                    i15++;
                                    str5 = str7;
                                }
                            }
                        }
                        str2 = str5;
                        zzfv zzfvVar4 = this.zzc;
                        zzal(zzfvVar4);
                        boolean zZzq = zzfvVar4.zzq(zzlcVar.zza.zzx(), zzfrVar6.zzo());
                        if (zZzq) {
                            z = zZzq;
                            i2 = i14;
                        } else {
                            zzal(this.zzi);
                            String strZzo = zzfrVar6.zzo();
                            Preconditions.checkNotEmpty(strZzo);
                            z = zZzq;
                            int iHashCode = strZzo.hashCode();
                            i2 = i14;
                            if (iHashCode != 94660) {
                                if (iHashCode != 95025) {
                                    if (iHashCode == 95027 && strZzo.equals("_ui")) {
                                        b = 1;
                                    } else {
                                        b = -1;
                                    }
                                } else if (strZzo.equals("_ug")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (strZzo.equals("_in")) {
                                b = 0;
                            } else {
                                b = -1;
                            }
                            if (b != 0 && b != 1 && b != 2) {
                                zzgbVar = zzgbVar4;
                                str3 = "_et";
                                i3 = i2;
                                z = false;
                            }
                            if (z) {
                                arrayList = new ArrayList(zzfrVar6.zzp());
                                i7 = 0;
                                i8 = -1;
                                i9 = -1;
                                while (true) {
                                    i5 = i3;
                                    i4 = i10;
                                    if (i7 < arrayList.size()) {
                                        break;
                                    }
                                    if ("value".equals(((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i7)).zzg())) {
                                        i8 = i7;
                                    } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i7)).zzg())) {
                                        i9 = i7;
                                    }
                                    i7++;
                                    i3 = i5;
                                    i10 = i4;
                                }
                                if (i8 != -1) {
                                    if (!((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i8)).zzw() || ((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i8)).zzu()) {
                                        if (i9 == -1) {
                                            strZzh = ((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i9)).zzh();
                                            if (strZzh.length() == 3) {
                                                iCharCount = 0;
                                                while (iCharCount < strZzh.length()) {
                                                    iCodePointAt = strZzh.codePointAt(iCharCount);
                                                    if (Character.isLetter(iCodePointAt)) {
                                                        iCharCount += Character.charCount(iCodePointAt);
                                                    }
                                                }
                                            }
                                        }
                                        zzay().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                        zzfrVar6.zzh(i8);
                                        zzab(zzfrVar6, "_c");
                                        zzaa(zzfrVar6, 19, FirebaseAnalytics.Param.CURRENCY);
                                        break;
                                    }
                                    zzay().zzl().zza("Value must be specified with a numeric type.");
                                    zzfrVar6.zzh(i8);
                                    zzab(zzfrVar6, "_c");
                                    zzaa(zzfrVar6, 18, "value");
                                }
                                if ("_e".equals(zzfrVar6.zzo())) {
                                    zzal(this.zzi);
                                    if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), "_fr") != null) {
                                        zzgbVar3 = zzgbVar;
                                    } else if (zzfrVar7 != null || Math.abs(zzfrVar7.zzc() - zzfrVar6.zzc()) > 1000) {
                                        zzgbVar3 = zzgbVar;
                                        zzfrVar5 = zzfrVar6;
                                        i12 = i;
                                    } else {
                                        com.google.android.gms.internal.measurement.zzfr zzfrVar8 = (com.google.android.gms.internal.measurement.zzfr) zzfrVar7.clone();
                                        if (zzaj(zzfrVar6, zzfrVar8)) {
                                            zzgbVar3 = zzgbVar;
                                            zzgbVar3.zzS(i13, zzfrVar8);
                                            zzfrVar2 = null;
                                            zzfrVar4 = null;
                                        } else {
                                            zzgbVar3 = zzgbVar;
                                            zzfrVar2 = zzfrVar6;
                                            i12 = i;
                                            zzfrVar4 = zzfrVar7;
                                        }
                                        zzfrVar5 = zzfrVar2;
                                    }
                                    zzfrVar4 = zzfrVar7;
                                } else {
                                    zzgbVar3 = zzgbVar;
                                    if ("_vs".equals(zzfrVar6.zzo())) {
                                        zzal(this.zzi);
                                        if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), str3) == null) {
                                            zzfrVar4 = zzfrVar7;
                                        } else if (zzfrVar5 != null || Math.abs(zzfrVar5.zzc() - zzfrVar6.zzc()) > 1000) {
                                            zzfrVar4 = zzfrVar6;
                                            i13 = i;
                                        } else {
                                            com.google.android.gms.internal.measurement.zzfr zzfrVar9 = (com.google.android.gms.internal.measurement.zzfr) zzfrVar5.clone();
                                            if (zzaj(zzfrVar9, zzfrVar6)) {
                                                zzgbVar3.zzS(i12, zzfrVar9);
                                                zzfrVar = null;
                                                zzfrVar5 = null;
                                            } else {
                                                zzfrVar = zzfrVar6;
                                                i13 = i;
                                            }
                                            zzfrVar4 = zzfrVar;
                                        }
                                    } else {
                                        zzfrVar4 = zzfrVar7;
                                    }
                                }
                                i6 = i4;
                                zzlcVar.zzc.set(i6, (com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE());
                                i11 = i + 1;
                                zzgbVar3.zzk(zzfrVar6);
                                i14 = i5;
                            } else {
                                i4 = i10;
                                i5 = i3;
                            }
                            if ("_e".equals(zzfrVar6.zzo())) {
                                zzal(this.zzi);
                                if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), "_fr") != null) {
                                    if (zzfrVar7 != null) {
                                    }
                                    zzgbVar3 = zzgbVar;
                                    zzfrVar5 = zzfrVar6;
                                    i12 = i;
                                } else {
                                    zzgbVar3 = zzgbVar;
                                }
                                zzfrVar4 = zzfrVar7;
                            } else {
                                zzgbVar3 = zzgbVar;
                                if ("_vs".equals(zzfrVar6.zzo())) {
                                    zzal(this.zzi);
                                    if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), str3) == null) {
                                        zzfrVar4 = zzfrVar7;
                                    } else if (zzfrVar5 != null) {
                                        zzfrVar4 = zzfrVar6;
                                        i13 = i;
                                    } else {
                                        zzfrVar4 = zzfrVar6;
                                        i13 = i;
                                    }
                                } else {
                                    zzfrVar4 = zzfrVar7;
                                }
                            }
                            i6 = i4;
                            zzlcVar.zzc.set(i6, (com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE());
                            i11 = i + 1;
                            zzgbVar3.zzk(zzfrVar6);
                            i14 = i5;
                        }
                        int i16 = 0;
                        boolean z3 = false;
                        boolean z4 = false;
                        while (true) {
                            z2 = z3;
                            if (i16 >= zzfrVar6.zza()) {
                                break;
                            }
                            if ("_c".equals(zzfrVar6.zzn(i16).zzg())) {
                                com.google.android.gms.internal.measurement.zzfv zzfvVar5 = (com.google.android.gms.internal.measurement.zzfv) zzfrVar6.zzn(i16).zzby();
                                zzgbVar2 = zzgbVar4;
                                str4 = str6;
                                zzfvVar5.zzi(1L);
                                zzfrVar6.zzk(i16, (com.google.android.gms.internal.measurement.zzfw) zzfvVar5.zzaE());
                                z3 = z2;
                                z4 = true;
                            } else {
                                zzgbVar2 = zzgbVar4;
                                str4 = str6;
                                if ("_r".equals(zzfrVar6.zzn(i16).zzg())) {
                                    com.google.android.gms.internal.measurement.zzfv zzfvVar6 = (com.google.android.gms.internal.measurement.zzfv) zzfrVar6.zzn(i16).zzby();
                                    zzfvVar6.zzi(1L);
                                    zzfrVar6.zzk(i16, (com.google.android.gms.internal.measurement.zzfw) zzfvVar6.zzaE());
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                            }
                            i16++;
                            str6 = str4;
                            zzgbVar4 = zzgbVar2;
                        }
                        zzgbVar = zzgbVar4;
                        str3 = str6;
                        if (!z4 && z) {
                            zzay().zzj().zzb("Marking event as conversion", this.zzn.zzj().zzd(zzfrVar6.zzo()));
                            com.google.android.gms.internal.measurement.zzfv zzfvVarZze = com.google.android.gms.internal.measurement.zzfw.zze();
                            zzfvVarZze.zzj("_c");
                            zzfvVarZze.zzi(1L);
                            zzfrVar6.zze(zzfvVarZze);
                        }
                        if (!z2) {
                            zzay().zzj().zzb("Marking event as real-time", this.zzn.zzj().zzd(zzfrVar6.zzo()));
                            com.google.android.gms.internal.measurement.zzfv zzfvVarZze2 = com.google.android.gms.internal.measurement.zzfw.zze();
                            zzfvVarZze2.zzj("_r");
                            zzfvVarZze2.zzi(1L);
                            zzfrVar6.zze(zzfvVarZze2);
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        if (zzamVar3.zzl(zza(), zzlcVar.zza.zzx(), false, false, false, false, true).zze > zzg().zze(zzlcVar.zza.zzx(), zzeh.zzn)) {
                            zzab(zzfrVar6, "_r");
                            i3 = i2;
                        } else {
                            i3 = 1;
                        }
                        if (zzln.zzai(zzfrVar6.zzo()) && z) {
                            zzam zzamVar4 = this.zze;
                            zzal(zzamVar4);
                            if (zzamVar4.zzl(zza(), zzlcVar.zza.zzx(), false, false, true, false, false).zzc > zzg().zze(zzlcVar.zza.zzx(), zzeh.zzm)) {
                                zzay().zzk().zzb("Too many conversions. Not logging as conversion. appId", zzeu.zzn(zzlcVar.zza.zzx()));
                                boolean z5 = false;
                                int i17 = -1;
                                com.google.android.gms.internal.measurement.zzfv zzfvVar7 = null;
                                for (int i18 = 0; i18 < zzfrVar6.zza(); i18++) {
                                    com.google.android.gms.internal.measurement.zzfw zzfwVarZzn = zzfrVar6.zzn(i18);
                                    if ("_c".equals(zzfwVarZzn.zzg())) {
                                        zzfvVar7 = (com.google.android.gms.internal.measurement.zzfv) zzfwVarZzn.zzby();
                                        i17 = i18;
                                    } else if ("_err".equals(zzfwVarZzn.zzg())) {
                                        z5 = true;
                                    }
                                }
                                if (z5) {
                                    if (zzfvVar7 != null) {
                                        zzfrVar6.zzh(i17);
                                    } else {
                                        zzfvVar7 = null;
                                        if (zzfvVar7 != null) {
                                            com.google.android.gms.internal.measurement.zzfv zzfvVar8 = (com.google.android.gms.internal.measurement.zzfv) zzfvVar7.clone();
                                            zzfvVar8.zzj("_err");
                                            zzfvVar8.zzi(10L);
                                            zzfrVar6.zzk(i17, (com.google.android.gms.internal.measurement.zzfw) zzfvVar8.zzaE());
                                        } else {
                                            zzay().zzd().zzb("Did not find conversion parameter. appId", zzeu.zzn(zzlcVar.zza.zzx()));
                                        }
                                    }
                                } else if (zzfvVar7 != null) {
                                    com.google.android.gms.internal.measurement.zzfv zzfvVar9 = (com.google.android.gms.internal.measurement.zzfv) zzfvVar7.clone();
                                    zzfvVar9.zzj("_err");
                                    zzfvVar9.zzi(10L);
                                    zzfrVar6.zzk(i17, (com.google.android.gms.internal.measurement.zzfw) zzfvVar9.zzaE());
                                } else {
                                    zzay().zzd().zzb("Did not find conversion parameter. appId", zzeu.zzn(zzlcVar.zza.zzx()));
                                }
                            }
                        }
                        if (z) {
                            arrayList = new ArrayList(zzfrVar6.zzp());
                            i7 = 0;
                            i8 = -1;
                            i9 = -1;
                            while (true) {
                                i5 = i3;
                                i4 = i10;
                                if (i7 < arrayList.size()) {
                                    break;
                                    break;
                                }
                                if ("value".equals(((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i7)).zzg())) {
                                    i8 = i7;
                                } else if (FirebaseAnalytics.Param.CURRENCY.equals(((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i7)).zzg())) {
                                    i9 = i7;
                                }
                                i7++;
                                i3 = i5;
                                i10 = i4;
                            }
                            if (i8 != -1) {
                                if (((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i8)).zzw()) {
                                }
                                if (i9 == -1) {
                                    strZzh = ((com.google.android.gms.internal.measurement.zzfw) arrayList.get(i9)).zzh();
                                    if (strZzh.length() == 3) {
                                        iCharCount = 0;
                                        while (iCharCount < strZzh.length()) {
                                            iCodePointAt = strZzh.codePointAt(iCharCount);
                                            if (Character.isLetter(iCodePointAt)) {
                                                iCharCount += Character.charCount(iCodePointAt);
                                            }
                                        }
                                    }
                                }
                                zzay().zzl().zza("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                zzfrVar6.zzh(i8);
                                zzab(zzfrVar6, "_c");
                                zzaa(zzfrVar6, 19, FirebaseAnalytics.Param.CURRENCY);
                                break;
                            }
                            if ("_e".equals(zzfrVar6.zzo())) {
                                zzal(this.zzi);
                                if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), "_fr") != null) {
                                    if (zzfrVar7 != null) {
                                    }
                                    zzgbVar3 = zzgbVar;
                                    zzfrVar5 = zzfrVar6;
                                    i12 = i;
                                } else {
                                    zzgbVar3 = zzgbVar;
                                }
                                zzfrVar4 = zzfrVar7;
                            } else {
                                zzgbVar3 = zzgbVar;
                                if ("_vs".equals(zzfrVar6.zzo())) {
                                    zzal(this.zzi);
                                    if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), str3) == null) {
                                        zzfrVar4 = zzfrVar7;
                                    } else if (zzfrVar5 != null) {
                                        zzfrVar4 = zzfrVar6;
                                        i13 = i;
                                    } else {
                                        zzfrVar4 = zzfrVar6;
                                        i13 = i;
                                    }
                                } else {
                                    zzfrVar4 = zzfrVar7;
                                }
                            }
                            i6 = i4;
                            zzlcVar.zzc.set(i6, (com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE());
                            i11 = i + 1;
                            zzgbVar3.zzk(zzfrVar6);
                            i14 = i5;
                        } else {
                            i4 = i10;
                            i5 = i3;
                        }
                        if ("_e".equals(zzfrVar6.zzo())) {
                            zzal(this.zzi);
                            if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), "_fr") != null) {
                                if (zzfrVar7 != null) {
                                }
                                zzgbVar3 = zzgbVar;
                                zzfrVar5 = zzfrVar6;
                                i12 = i;
                            } else {
                                zzgbVar3 = zzgbVar;
                            }
                            zzfrVar4 = zzfrVar7;
                        } else {
                            zzgbVar3 = zzgbVar;
                            if ("_vs".equals(zzfrVar6.zzo())) {
                                zzal(this.zzi);
                                if (zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE(), str3) == null) {
                                    zzfrVar4 = zzfrVar7;
                                } else if (zzfrVar5 != null) {
                                    zzfrVar4 = zzfrVar6;
                                    i13 = i;
                                } else {
                                    zzfrVar4 = zzfrVar6;
                                    i13 = i;
                                }
                            } else {
                                zzfrVar4 = zzfrVar7;
                            }
                        }
                        i6 = i4;
                        zzlcVar.zzc.set(i6, (com.google.android.gms.internal.measurement.zzfs) zzfrVar6.zzaE());
                        i11 = i + 1;
                        zzgbVar3.zzk(zzfrVar6);
                        i14 = i5;
                    }
                    zzfrVar3 = zzfrVar5;
                    zzgbVar4 = zzgbVar3;
                    i10 = i6 + 1;
                    str5 = str2;
                }
                com.google.android.gms.internal.measurement.zzgb zzgbVar5 = zzgbVar4;
                int i19 = i14;
                long j6 = 0;
                long jLongValue = 0;
                int i20 = i;
                int i21 = 0;
                while (i21 < i20) {
                    com.google.android.gms.internal.measurement.zzfs zzfsVarZze = zzgbVar5.zze(i21);
                    if ("_e".equals(zzfsVarZze.zzh())) {
                        zzal(this.zzi);
                        if (zzlh.zzB(zzfsVarZze, "_fr") != null) {
                            zzgbVar5.zzA(i21);
                            i20--;
                            i21--;
                        } else {
                            zzal(this.zzi);
                            zzfwVarZzB = zzlh.zzB(zzfsVarZze, "_et");
                            if (zzfwVarZzB == null) {
                                if (zzfwVarZzB.zzw()) {
                                    lValueOf = Long.valueOf(zzfwVarZzB.zzd());
                                } else {
                                    lValueOf = null;
                                }
                                if (lValueOf == null && lValueOf.longValue() > 0) {
                                    jLongValue += lValueOf.longValue();
                                }
                            }
                        }
                    } else {
                        zzal(this.zzi);
                        zzfwVarZzB = zzlh.zzB(zzfsVarZze, "_et");
                        if (zzfwVarZzB == null) {
                            if (zzfwVarZzB.zzw()) {
                                lValueOf = Long.valueOf(zzfwVarZzB.zzd());
                            } else {
                                lValueOf = null;
                            }
                            if (lValueOf == null) {
                            }
                        }
                    }
                    i21++;
                }
                zzaf(zzgbVar5, jLongValue, false);
                Iterator it = zzgbVar5.zzas().iterator();
                while (it.hasNext()) {
                    if ("_s".equals(((com.google.android.gms.internal.measurement.zzfs) it.next()).zzh())) {
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzA(zzgbVar5.zzap(), "_se");
                        break;
                    }
                }
                if (zzlh.zza(zzgbVar5, "_sid") >= 0) {
                    zzaf(zzgbVar5, jLongValue, true);
                } else {
                    int iZza = zzlh.zza(zzgbVar5, "_se");
                    if (iZza >= 0) {
                        zzgbVar5.zzB(iZza);
                        zzay().zzd().zzb("Session engagement user property is in the bundle without session ID. appId", zzeu.zzn(zzlcVar.zza.zzx()));
                    }
                }
                zzlh zzlhVar = this.zzi;
                zzal(zzlhVar);
                zzlhVar.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                zzfv zzfvVar10 = zzlhVar.zzf.zzc;
                zzal(zzfvVar10);
                if (zzfvVar10.zzn(zzgbVar5.zzap())) {
                    zzam zzamVar6 = zzlhVar.zzf.zze;
                    zzal(zzamVar6);
                    zzh zzhVarZzj = zzamVar6.zzj(zzgbVar5.zzap());
                    if (zzhVarZzj != null && zzhVarZzj.zzah() && zzlhVar.zzs.zzg().zze()) {
                        zzlhVar.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                        com.google.android.gms.internal.measurement.zzgk zzgkVarZzd = com.google.android.gms.internal.measurement.zzgl.zzd();
                        zzgkVarZzd.zzf("_npa");
                        zzgkVarZzd.zzg(zzlhVar.zzs.zzg().zza());
                        zzgkVarZzd.zze(1L);
                        com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) zzgkVarZzd.zzaE();
                        int i22 = 0;
                        while (true) {
                            if (i22 >= zzgbVar5.zzb()) {
                                zzgbVar5.zzm(zzglVar);
                                break;
                            }
                            if ("_npa".equals(zzgbVar5.zzao(i22).zzf())) {
                                zzgbVar5.zzam(i22, zzglVar);
                                break;
                            }
                            i22++;
                        }
                    }
                }
                zzgbVar5.zzai(Long.MAX_VALUE);
                zzgbVar5.zzQ(Long.MIN_VALUE);
                for (int i23 = 0; i23 < zzgbVar5.zza(); i23++) {
                    com.google.android.gms.internal.measurement.zzfs zzfsVarZze2 = zzgbVar5.zze(i23);
                    if (zzfsVarZze2.zzd() < zzgbVar5.zzd()) {
                        zzgbVar5.zzai(zzfsVarZze2.zzd());
                    }
                    if (zzfsVarZze2.zzd() > zzgbVar5.zzc()) {
                        zzgbVar5.zzQ(zzfsVarZze2.zzd());
                    }
                }
                zzgbVar5.zzz();
                zzgbVar5.zzo();
                zzaa zzaaVar = this.zzh;
                zzal(zzaaVar);
                zzgbVar5.zzf(zzaaVar.zza(zzgbVar5.zzap(), zzgbVar5.zzas(), zzgbVar5.zzat(), Long.valueOf(zzgbVar5.zzd()), Long.valueOf(zzgbVar5.zzc())));
                if (zzg().zzw(zzlcVar.zza.zzx())) {
                    HashMap map = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    SecureRandom secureRandomZzG = zzv().zzG();
                    int i24 = 0;
                    while (i24 < zzgbVar5.zza()) {
                        com.google.android.gms.internal.measurement.zzfr zzfrVar10 = (com.google.android.gms.internal.measurement.zzfr) zzgbVar5.zze(i24).zzby();
                        if (zzfrVar10.zzo().equals("_ep")) {
                            zzal(this.zzi);
                            String str8 = (String) zzlh.zzC((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE(), "_en");
                            zzas zzasVarZzn = (zzas) map.get(str8);
                            if (zzasVarZzn == null) {
                                zzam zzamVar7 = this.zze;
                                zzal(zzamVar7);
                                zzasVarZzn = zzamVar7.zzn(zzlcVar.zza.zzx(), (String) Preconditions.checkNotNull(str8));
                                if (zzasVarZzn != null) {
                                    map.put(str8, zzasVarZzn);
                                }
                            }
                            if (zzasVarZzn != null && zzasVarZzn.zzi == null) {
                                Long l = zzasVarZzn.zzj;
                                if (l != null && l.longValue() > 1) {
                                    zzal(this.zzi);
                                    zzlh.zzz(zzfrVar10, "_sr", zzasVarZzn.zzj);
                                }
                                Boolean bool = zzasVarZzn.zzk;
                                if (bool != null && bool.booleanValue()) {
                                    zzal(this.zzi);
                                    zzlh.zzz(zzfrVar10, "_efs", 1L);
                                }
                                arrayList2.add((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE());
                            }
                            zzgbVar5.zzS(i24, zzfrVar10);
                            j4 = j6;
                        } else {
                            zzfv zzfvVar11 = this.zzc;
                            zzal(zzfvVar11);
                            String strZzx = zzlcVar.zza.zzx();
                            String strZza = zzfvVar11.zza(strZzx, "measurement.account.time_zone_offset_minutes");
                            if (TextUtils.isEmpty(strZza)) {
                                j3 = j6;
                            } else {
                                try {
                                    j3 = Long.parseLong(strZza);
                                } catch (NumberFormatException e) {
                                    zzfvVar11.zzs.zzay().zzk().zzc("Unable to parse timezone offset. appId", zzeu.zzn(strZzx), e);
                                    j3 = j6;
                                }
                            }
                            long j7 = j6;
                            long jZzr = zzv().zzr(zzfrVar10.zzc(), j3);
                            com.google.android.gms.internal.measurement.zzfs zzfsVar = (com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE();
                            j4 = j7;
                            Long l2 = 1L;
                            if (TextUtils.isEmpty("_dbg")) {
                                j5 = j3;
                                zzfv zzfvVar12 = this.zzc;
                                zzal(zzfvVar12);
                                iZzc = zzfvVar12.zzc(zzlcVar.zza.zzx(), zzfrVar10.zzo());
                            } else {
                                Iterator it2 = zzfsVar.zzi().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        com.google.android.gms.internal.measurement.zzfw zzfwVar = (com.google.android.gms.internal.measurement.zzfw) it2.next();
                                        j5 = j3;
                                        if (!"_dbg".equals(zzfwVar.zzg())) {
                                            j3 = j5;
                                        } else if (l2.equals(Long.valueOf(zzfwVar.zzd()))) {
                                            iZzc = 1;
                                        } else {
                                            zzfv zzfvVar13 = this.zzc;
                                            zzal(zzfvVar13);
                                            iZzc = zzfvVar13.zzc(zzlcVar.zza.zzx(), zzfrVar10.zzo());
                                        }
                                    } else {
                                        j5 = j3;
                                        zzfv zzfvVar14 = this.zzc;
                                        zzal(zzfvVar14);
                                        iZzc = zzfvVar14.zzc(zzlcVar.zza.zzx(), zzfrVar10.zzo());
                                    }
                                }
                            }
                            if (iZzc <= 0) {
                                zzay().zzk().zzc("Sample rate must be positive. event, rate", zzfrVar10.zzo(), Integer.valueOf(iZzc));
                                arrayList2.add((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE());
                                zzgbVar5.zzS(i24, zzfrVar10);
                            } else {
                                zzas zzasVarZza = (zzas) map.get(zzfrVar10.zzo());
                                if (zzasVarZza == null) {
                                    zzam zzamVar8 = this.zze;
                                    zzal(zzamVar8);
                                    zzasVarZza = zzamVar8.zzn(zzlcVar.zza.zzx(), zzfrVar10.zzo());
                                    if (zzasVarZza == null) {
                                        zzay().zzk().zzc("Event being bundled has no eventAggregate. appId, eventName", zzlcVar.zza.zzx(), zzfrVar10.zzo());
                                        zzasVarZza = new zzas(zzlcVar.zza.zzx(), zzfrVar10.zzo(), 1L, 1L, 1L, zzfrVar10.zzc(), 0L, null, null, null, null);
                                    }
                                }
                                zzal(this.zzi);
                                Long l3 = (Long) zzlh.zzC((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE(), "_eid");
                                Boolean boolValueOf = Boolean.valueOf(l3 != null);
                                if (iZzc == 1) {
                                    arrayList2.add((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE());
                                    if (boolValueOf.booleanValue() && (zzasVarZza.zzi != null || zzasVarZza.zzj != null || zzasVarZza.zzk != null)) {
                                        map.put(zzfrVar10.zzo(), zzasVarZza.zza(null, null, null));
                                    }
                                    zzgbVar5.zzS(i24, zzfrVar10);
                                } else {
                                    if (secureRandomZzG.nextInt(iZzc) == 0) {
                                        zzal(this.zzi);
                                        Long lValueOf2 = Long.valueOf(iZzc);
                                        zzlh.zzz(zzfrVar10, "_sr", lValueOf2);
                                        arrayList2.add((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE());
                                        if (boolValueOf.booleanValue()) {
                                            zzasVarZza = zzasVarZza.zza(null, lValueOf2, null);
                                        }
                                        map.put(zzfrVar10.zzo(), zzasVarZza.zzb(zzfrVar10.zzc(), jZzr));
                                        secureRandomZzG = secureRandomZzG;
                                    } else {
                                        Long l4 = zzasVarZza.zzh;
                                        if ((l4 != null ? l4.longValue() : zzv().zzr(zzfrVar10.zzb(), j5)) != jZzr) {
                                            zzal(this.zzi);
                                            zzlh.zzz(zzfrVar10, "_efs", 1L);
                                            zzal(this.zzi);
                                            Long lValueOf3 = Long.valueOf(iZzc);
                                            zzlh.zzz(zzfrVar10, "_sr", lValueOf3);
                                            arrayList2.add((com.google.android.gms.internal.measurement.zzfs) zzfrVar10.zzaE());
                                            if (boolValueOf.booleanValue()) {
                                                zzasVarZza = zzasVarZza.zza(null, lValueOf3, true);
                                            }
                                            map.put(zzfrVar10.zzo(), zzasVarZza.zzb(zzfrVar10.zzc(), jZzr));
                                        } else if (boolValueOf.booleanValue()) {
                                            map.put(zzfrVar10.zzo(), zzasVarZza.zza(l3, null, null));
                                        }
                                        zzgbVar5 = zzgbVar5;
                                    }
                                    zzgbVar5.zzS(i24, zzfrVar10);
                                }
                                i24++;
                                secureRandomZzG = secureRandomZzG;
                                j6 = j4;
                            }
                        }
                        secureRandomZzG = secureRandomZzG;
                        i24++;
                        secureRandomZzG = secureRandomZzG;
                        j6 = j4;
                    }
                    j2 = j6;
                    if (arrayList2.size() < zzgbVar5.zza()) {
                        zzgbVar5.zzr();
                        zzgbVar5.zzg(arrayList2);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzamVar9.zzE((zzas) entry.getValue());
                    }
                } else {
                    j2 = 0;
                }
                String strZzx2 = zzlcVar.zza.zzx();
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzh zzhVarZzj2 = zzamVar10.zzj(strZzx2);
                if (zzhVarZzj2 == null) {
                    zzay().zzd().zzb("Bundling raw events w/o app info. appId", zzeu.zzn(zzlcVar.zza.zzx()));
                } else if (zzgbVar5.zza() > 0) {
                    long jZzn = zzhVarZzj2.zzn();
                    if (jZzn != j2) {
                        zzgbVar5.zzab(jZzn);
                    } else {
                        zzgbVar5.zzv();
                    }
                    long jZzp = zzhVarZzj2.zzp();
                    if (jZzp != j2) {
                        jZzn = jZzp;
                    }
                    if (jZzn != j2) {
                        zzgbVar5.zzac(jZzn);
                    } else {
                        zzgbVar5.zzw();
                    }
                    zzhVarZzj2.zzE();
                    zzgbVar5.zzI((int) zzhVarZzj2.zzo());
                    zzhVarZzj2.zzab(zzgbVar5.zzd());
                    zzhVarZzj2.zzZ(zzgbVar5.zzc());
                    String strZzs = zzhVarZzj2.zzs();
                    if (strZzs != null) {
                        zzgbVar5.zzW(strZzs);
                    } else {
                        zzgbVar5.zzs();
                    }
                    zzam zzamVar11 = this.zze;
                    zzal(zzamVar11);
                    zzamVar11.zzD(zzhVarZzj2);
                }
                if (zzgbVar5.zza() > 0) {
                    this.zzn.zzaw();
                    zzfv zzfvVar15 = this.zzc;
                    zzal(zzfvVar15);
                    com.google.android.gms.internal.measurement.zzfe zzfeVarZze = zzfvVar15.zze(zzlcVar.zza.zzx());
                    if (zzfeVarZze != null && zzfeVarZze.zzs()) {
                        zzgbVar5.zzK(zzfeVarZze.zzc());
                    } else if (zzlcVar.zza.zzF().isEmpty()) {
                        zzgbVar5.zzK(-1L);
                    } else {
                        zzay().zzk().zzb("Did not find measurement config or missing version info. appId", zzeu.zzn(zzlcVar.zza.zzx()));
                    }
                    zzam zzamVar12 = this.zze;
                    zzal(zzamVar12);
                    com.google.android.gms.internal.measurement.zzgc zzgcVar = (com.google.android.gms.internal.measurement.zzgc) zzgbVar5.zzaE();
                    zzamVar12.zzg();
                    zzamVar12.zzW();
                    Preconditions.checkNotNull(zzgcVar);
                    Preconditions.checkNotEmpty(zzgcVar.zzx());
                    Preconditions.checkState(zzgcVar.zzbe());
                    zzamVar12.zzz();
                    long jCurrentTimeMillis = zzamVar12.zzs.zzav().currentTimeMillis();
                    long jZzk = zzgcVar.zzk();
                    zzamVar12.zzs.zzf();
                    if (jZzk >= jCurrentTimeMillis - zzag.zzA()) {
                        long jZzk2 = zzgcVar.zzk();
                        zzamVar12.zzs.zzf();
                        if (jZzk2 > zzag.zzA() + jCurrentTimeMillis) {
                            zzamVar12.zzs.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeu.zzn(zzgcVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgcVar.zzk()));
                        }
                    } else {
                        zzamVar12.zzs.zzay().zzk().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzeu.zzn(zzgcVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzgcVar.zzk()));
                    }
                    byte[] bArrZzbv = zzgcVar.zzbv();
                    try {
                        zzlh zzlhVar2 = zzamVar12.zzf.zzi;
                        zzal(zzlhVar2);
                        byte[] bArrZzy = zzlhVar2.zzy(bArrZzbv);
                        zzamVar12.zzs.zzay().zzj().zzb("Saving bundle, size", Integer.valueOf(bArrZzy.length));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("app_id", zzgcVar.zzx());
                        contentValues.put("bundle_end_timestamp", Long.valueOf(zzgcVar.zzk()));
                        contentValues.put("data", bArrZzy);
                        contentValues.put("has_realtime", Integer.valueOf(i19));
                        if (zzgcVar.zzbk()) {
                            contentValues.put("retry_count", Integer.valueOf(zzgcVar.zze()));
                        }
                        try {
                            if (zzamVar12.zzh().insert("queue", null, contentValues) == -1) {
                                zzamVar12.zzs.zzay().zzd().zzb("Failed to insert bundle (got -1). appId", zzeu.zzn(zzgcVar.zzx()));
                            }
                        } catch (SQLiteException e2) {
                            zzamVar12.zzs.zzay().zzd().zzc("Error storing bundle. appId", zzeu.zzn(zzgcVar.zzx()), e2);
                        }
                    } catch (IOException e3) {
                        zzamVar12.zzs.zzay().zzd().zzc("Data loss. Failed to serialize bundle. appId", zzeu.zzn(zzgcVar.zzx()), e3);
                    }
                }
                zzam zzamVar13 = this.zze;
                zzal(zzamVar13);
                List list2 = zzlcVar.zzb;
                Preconditions.checkNotNull(list2);
                zzamVar13.zzg();
                zzamVar13.zzW();
                StringBuilder sb = new StringBuilder("rowid in (");
                for (int i25 = 0; i25 < list2.size(); i25++) {
                    if (i25 != 0) {
                        sb.append(",");
                    }
                    sb.append(((Long) list2.get(i25)).longValue());
                }
                sb.append(")");
                int iDelete = zzamVar13.zzh().delete("raw_events", sb.toString(), null);
                if (iDelete != list2.size()) {
                    zzamVar13.zzs.zzay().zzd().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(iDelete), Integer.valueOf(list2.size()));
                }
                zzam zzamVar14 = this.zze;
                zzal(zzamVar14);
                try {
                    zzamVar14.zzh().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{strZzx2, strZzx2});
                } catch (SQLiteException e4) {
                    zzamVar14.zzs.zzay().zzd().zzc("Failed to remove unused event metadata. appId", zzeu.zzn(strZzx2), e4);
                }
                zzam zzamVar15 = this.zze;
                zzal(zzamVar15);
                zzamVar15.zzC();
                zzam zzamVar16 = this.zze;
                zzal(zzamVar16);
                zzamVar16.zzx();
                return true;
            }
            zzam zzamVar17 = this.zze;
            zzal(zzamVar17);
            zzamVar17.zzC();
            zzam zzamVar18 = this.zze;
            zzal(zzamVar18);
            zzamVar18.zzx();
            return false;
        } catch (Throwable th) {
            zzam zzamVar19 = this.zze;
            zzal(zzamVar19);
            zzamVar19.zzx();
            throw th;
        }
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        if (zzamVar.zzF()) {
            return true;
        }
        zzam zzamVar2 = this.zze;
        zzal(zzamVar2);
        return !TextUtils.isEmpty(zzamVar2.zzr());
    }

    private final boolean zzaj(com.google.android.gms.internal.measurement.zzfr zzfrVar, com.google.android.gms.internal.measurement.zzfr zzfrVar2) {
        Preconditions.checkArgument("_e".equals(zzfrVar.zzo()));
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfw zzfwVarZzB = zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar.zzaE(), "_sc");
        String strZzh = zzfwVarZzB == null ? null : zzfwVarZzB.zzh();
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfw zzfwVarZzB2 = zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar2.zzaE(), "_pc");
        String strZzh2 = zzfwVarZzB2 != null ? zzfwVarZzB2.zzh() : null;
        if (strZzh2 == null || !strZzh2.equals(strZzh)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfrVar.zzo()));
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfw zzfwVarZzB3 = zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar.zzaE(), "_et");
        if (zzfwVarZzB3 == null || !zzfwVarZzB3.zzw() || zzfwVarZzB3.zzd() <= 0) {
            return true;
        }
        long jZzd = zzfwVarZzB3.zzd();
        zzal(this.zzi);
        com.google.android.gms.internal.measurement.zzfw zzfwVarZzB4 = zzlh.zzB((com.google.android.gms.internal.measurement.zzfs) zzfrVar2.zzaE(), "_et");
        if (zzfwVarZzB4 != null && zzfwVarZzB4.zzd() > 0) {
            jZzd += zzfwVarZzB4.zzd();
        }
        zzal(this.zzi);
        zzlh.zzz(zzfrVar2, "_et", Long.valueOf(jZzd));
        zzal(this.zzi);
        zzlh.zzz(zzfrVar, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzqVar) {
        return (TextUtils.isEmpty(zzqVar.zzb) && TextUtils.isEmpty(zzqVar.zzq)) ? false : true;
    }

    private static final zzkt zzal(zzkt zzktVar) {
        if (zzktVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (zzktVar.zzY()) {
            return zzktVar;
        }
        throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzktVar.getClass()))));
    }

    public static zzlf zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzlf.class) {
                if (zzb == null) {
                    zzb = new zzlf((zzlg) Preconditions.checkNotNull(new zzlg(context)), null);
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzlf zzlfVar, zzlg zzlgVar) {
        zzlfVar.zzaz().zzg();
        zzlfVar.zzm = new zzfm(zzlfVar);
        zzam zzamVar = new zzam(zzlfVar);
        zzamVar.zzX();
        zzlfVar.zze = zzamVar;
        zzlfVar.zzg().zzq((zzaf) Preconditions.checkNotNull(zzlfVar.zzc));
        zzka zzkaVar = new zzka(zzlfVar);
        zzkaVar.zzX();
        zzlfVar.zzk = zzkaVar;
        zzaa zzaaVar = new zzaa(zzlfVar);
        zzaaVar.zzX();
        zzlfVar.zzh = zzaaVar;
        zzio zzioVar = new zzio(zzlfVar);
        zzioVar.zzX();
        zzlfVar.zzj = zzioVar;
        zzkr zzkrVar = new zzkr(zzlfVar);
        zzkrVar.zzX();
        zzlfVar.zzg = zzkrVar;
        zzlfVar.zzf = new zzfc(zzlfVar);
        if (zzlfVar.zzr != zzlfVar.zzs) {
            zzlfVar.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzlfVar.zzr), Integer.valueOf(zzlfVar.zzs));
        }
        zzlfVar.zzo = true;
    }

    final void zzA() {
        zzaz().zzg();
        zzB();
        if (this.zzp) {
            return;
        }
        this.zzp = true;
        if (zzZ()) {
            FileChannel fileChannel = this.zzx;
            zzaz().zzg();
            int i = 0;
            if (fileChannel == null || !fileChannel.isOpen()) {
                zzay().zzd().zza("Bad channel to read from");
            } else {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
                try {
                    fileChannel.position(0L);
                    int i2 = fileChannel.read(byteBufferAllocate);
                    if (i2 == 4) {
                        byteBufferAllocate.flip();
                        i = byteBufferAllocate.getInt();
                    } else if (i2 != -1) {
                        zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(i2));
                    }
                } catch (IOException e) {
                    zzay().zzd().zzb("Failed to read from channel", e);
                }
            }
            int iZzi = this.zzn.zzh().zzi();
            zzaz().zzg();
            if (i > iZzi) {
                zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
                return;
            }
            if (i < iZzi) {
                FileChannel fileChannel2 = this.zzx;
                zzaz().zzg();
                if (fileChannel2 == null || !fileChannel2.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(4);
                    byteBufferAllocate2.putInt(iZzi);
                    byteBufferAllocate2.flip();
                    try {
                        fileChannel2.truncate(0L);
                        fileChannel2.write(byteBufferAllocate2);
                        fileChannel2.force(true);
                        if (fileChannel2.size() != 4) {
                            zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                        }
                        zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
                        return;
                    } catch (IOException e2) {
                        zzay().zzd().zzb("Failed to write to channel", e2);
                    }
                }
                zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(iZzi));
            }
        }
    }

    final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    final void zzC(String str, com.google.android.gms.internal.measurement.zzgb zzgbVar) {
        int iZza;
        int iIndexOf;
        zzpc.zzc();
        if (zzg().zzs(str, zzeh.zzat)) {
            zzfv zzfvVar = this.zzc;
            zzal(zzfvVar);
            Set setZzk = zzfvVar.zzk(str);
            if (setZzk != null) {
                zzgbVar.zzi(setZzk);
            }
        }
        if (zzg().zzs(str, zzeh.zzav)) {
            zzfv zzfvVar2 = this.zzc;
            zzal(zzfvVar2);
            if (zzfvVar2.zzv(str)) {
                zzgbVar.zzp();
            }
            zzfv zzfvVar3 = this.zzc;
            zzal(zzfvVar3);
            if (zzfvVar3.zzy(str)) {
                if (zzg().zzs(str, zzeh.zzaF)) {
                    String strZzar = zzgbVar.zzar();
                    if (!TextUtils.isEmpty(strZzar) && (iIndexOf = strZzar.indexOf(".")) != -1) {
                        zzgbVar.zzY(strZzar.substring(0, iIndexOf));
                    }
                } else {
                    zzgbVar.zzu();
                }
            }
        }
        if (zzg().zzs(str, zzeh.zzaw)) {
            zzfv zzfvVar4 = this.zzc;
            zzal(zzfvVar4);
            if (zzfvVar4.zzz(str) && (iZza = zzlh.zza(zzgbVar, "_id")) != -1) {
                zzgbVar.zzB(iZza);
            }
        }
        if (zzg().zzs(str, zzeh.zzax)) {
            zzfv zzfvVar5 = this.zzc;
            zzal(zzfvVar5);
            if (zzfvVar5.zzx(str)) {
                zzgbVar.zzq();
            }
        }
        if (zzg().zzs(str, zzeh.zzaA)) {
            zzfv zzfvVar6 = this.zzc;
            zzal(zzfvVar6);
            if (zzfvVar6.zzu(str)) {
                zzgbVar.zzn();
                if (zzg().zzs(str, zzeh.zzaB)) {
                    zzle zzleVar = (zzle) this.zzC.get(str);
                    if (zzleVar == null || zzleVar.zzb + zzg().zzi(str, zzeh.zzR) < zzav().elapsedRealtime()) {
                        zzleVar = new zzle(this);
                        this.zzC.put(str, zzleVar);
                    }
                    zzgbVar.zzR(zzleVar.zza);
                }
            }
        }
        if (zzg().zzs(str, zzeh.zzaC)) {
            zzfv zzfvVar7 = this.zzc;
            zzal(zzfvVar7);
            if (zzfvVar7.zzw(str)) {
                zzgbVar.zzy();
            }
        }
    }

    final void zzD(zzh zzhVar) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzaz().zzg();
        if (TextUtils.isEmpty(zzhVar.zzy()) && TextUtils.isEmpty(zzhVar.zzr())) {
            zzI((String) Preconditions.checkNotNull(zzhVar.zzt()), 204, null, null, null);
            return;
        }
        zzku zzkuVar = this.zzl;
        Uri.Builder builder = new Uri.Builder();
        String strZzy = zzhVar.zzy();
        if (TextUtils.isEmpty(strZzy)) {
            strZzy = zzhVar.zzr();
        }
        ArrayMap arrayMap3 = null;
        Uri.Builder builderAppendQueryParameter = builder.scheme((String) zzeh.zzd.zza(null)).encodedAuthority((String) zzeh.zze.zza(null)).path("config/app/".concat(String.valueOf(strZzy))).appendQueryParameter("platform", "android");
        zzkuVar.zzs.zzf().zzh();
        builderAppendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(68000L)).appendQueryParameter("runtime_version", "0");
        zzpc.zzc();
        if (!zzkuVar.zzs.zzf().zzs(zzhVar.zzt(), zzeh.zzar)) {
            builder.appendQueryParameter("app_instance_id", zzhVar.zzu());
        }
        String string = builder.build().toString();
        try {
            String str = (String) Preconditions.checkNotNull(zzhVar.zzt());
            URL url = new URL(string);
            zzay().zzj().zzb("Fetching remote configuration", str);
            zzfv zzfvVar = this.zzc;
            zzal(zzfvVar);
            com.google.android.gms.internal.measurement.zzfe zzfeVarZze = zzfvVar.zze(str);
            zzfv zzfvVar2 = this.zzc;
            zzal(zzfvVar2);
            String strZzh = zzfvVar2.zzh(str);
            if (zzfeVarZze == null) {
                arrayMap = arrayMap3;
            } else {
                if (TextUtils.isEmpty(strZzh)) {
                    arrayMap2 = null;
                } else {
                    arrayMap2 = new ArrayMap();
                    arrayMap2.put(HttpHeaders.IF_MODIFIED_SINCE, strZzh);
                }
                zzpc.zzc();
                if (zzg().zzs(null, zzeh.zzaD)) {
                    zzfv zzfvVar3 = this.zzc;
                    zzal(zzfvVar3);
                    String strZzf = zzfvVar3.zzf(str);
                    if (!TextUtils.isEmpty(strZzf)) {
                        if (arrayMap2 == null) {
                            arrayMap2 = new ArrayMap();
                        }
                        arrayMap3 = arrayMap2;
                        arrayMap3.put(HttpHeaders.IF_NONE_MATCH, strZzf);
                        arrayMap = arrayMap3;
                    }
                }
                arrayMap = arrayMap2;
            }
            this.zzt = true;
            zzfa zzfaVar = this.zzd;
            zzal(zzfaVar);
            zzkx zzkxVar = new zzkx(this);
            zzfaVar.zzg();
            zzfaVar.zzW();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzkxVar);
            zzfaVar.zzs.zzaz().zzo(new zzez(zzfaVar, str, url, null, arrayMap, zzkxVar));
        } catch (MalformedURLException unused) {
            zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeu.zzn(zzhVar.zzt()), string);
        }
    }

    final void zzE(zzaw zzawVar, zzq zzqVar) {
        zzaw zzawVar2;
        List<zzac> listZzt;
        List<zzac> listZzt2;
        List<zzac> listZzt3;
        String str;
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzqVar.zza;
        zzaw zzawVarZza = zzawVar;
        long j = zzawVarZza.zzd;
        zzpf.zzc();
        zziq zziqVar = null;
        boolean z = false;
        if (zzg().zzs(null, zzeh.zzak)) {
            zzev zzevVarZzb = zzev.zzb(zzawVarZza);
            zzaz().zzg();
            if (this.zzD != null && (str = this.zzE) != null && str.equals(str2)) {
                zziqVar = this.zzD;
            }
            zzln.zzK(zziqVar, zzevVarZzb.zzd, false);
            zzawVarZza = zzevVarZzb.zza();
        }
        zzal(this.zzi);
        if (zzlh.zzA(zzawVarZza, zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            List list = zzqVar.zzt;
            if (list == null) {
                zzawVar2 = zzawVarZza;
            } else if (!list.contains(zzawVarZza.zza)) {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzawVarZza.zza, zzawVarZza.zzc);
                return;
            } else {
                Bundle bundleZzc = zzawVarZza.zzb.zzc();
                bundleZzc.putLong("ga_safelisted", 1L);
                zzawVar2 = new zzaw(zzawVarZza.zza, new zzau(bundleZzc), zzawVarZza.zzc, zzawVarZza.zzd);
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                Preconditions.checkNotEmpty(str2);
                zzamVar2.zzg();
                zzamVar2.zzW();
                char c = 2;
                if (j < 0) {
                    zzamVar2.zzs.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeu.zzn(str2), Long.valueOf(j));
                    listZzt = Collections.emptyList();
                } else {
                    listZzt = zzamVar2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzac zzacVar : listZzt) {
                    if (zzacVar != null) {
                        boolean z2 = z;
                        zzay().zzj().zzd("User property timed out", zzacVar.zza, this.zzn.zzj().zzf(zzacVar.zzc.zzb), zzacVar.zzc.zza());
                        zzaw zzawVar3 = zzacVar.zzg;
                        if (zzawVar3 != null) {
                            zzY(new zzaw(zzawVar3, j), zzqVar);
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzamVar3.zza(str2, zzacVar.zzc.zzb);
                        z = z2;
                    }
                }
                boolean z3 = z;
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                Preconditions.checkNotEmpty(str2);
                zzamVar4.zzg();
                zzamVar4.zzW();
                if (j < 0) {
                    zzamVar4.zzs.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeu.zzn(str2), Long.valueOf(j));
                    listZzt2 = Collections.emptyList();
                } else {
                    String[] strArr = new String[2];
                    strArr[z3 ? 1 : 0] = str2;
                    strArr[1] = String.valueOf(j);
                    listZzt2 = zzamVar4.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr);
                }
                ArrayList arrayList = new ArrayList(listZzt2.size());
                for (zzac zzacVar2 : listZzt2) {
                    if (zzacVar2 != null) {
                        char c2 = c;
                        zzay().zzj().zzd("User property expired", zzacVar2.zza, this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzA(str2, zzacVar2.zzc.zzb);
                        zzaw zzawVar4 = zzacVar2.zzk;
                        if (zzawVar4 != null) {
                            arrayList.add(zzawVar4);
                        }
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zza(str2, zzacVar2.zzc.zzb);
                        c = c2;
                    }
                }
                char c3 = c;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzY(new zzaw((zzaw) it.next(), j), zzqVar);
                }
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                String str3 = zzawVar2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                zzamVar7.zzg();
                zzamVar7.zzW();
                if (j < 0) {
                    zzamVar7.zzs.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeu.zzn(str2), zzamVar7.zzs.zzj().zzd(str3), Long.valueOf(j));
                    listZzt3 = Collections.emptyList();
                } else {
                    String[] strArr2 = new String[3];
                    strArr2[z3 ? 1 : 0] = str2;
                    strArr2[1] = str3;
                    strArr2[c3] = String.valueOf(j);
                    listZzt3 = zzamVar7.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr2);
                }
                ArrayList arrayList2 = new ArrayList(listZzt3.size());
                for (zzac zzacVar3 : listZzt3) {
                    if (zzacVar3 != null) {
                        zzli zzliVar = zzacVar3.zzc;
                        zzlk zzlkVar = new zzlk((String) Preconditions.checkNotNull(zzacVar3.zza), zzacVar3.zzb, zzliVar.zzb, j, Preconditions.checkNotNull(zzliVar.zza()));
                        zzam zzamVar8 = this.zze;
                        zzal(zzamVar8);
                        if (zzamVar8.zzL(zzlkVar)) {
                            zzay().zzj().zzd("User property triggered", zzacVar3.zza, this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeu.zzn(zzacVar3.zza), this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                        }
                        zzaw zzawVar5 = zzacVar3.zzi;
                        if (zzawVar5 != null) {
                            arrayList2.add(zzawVar5);
                        }
                        zzacVar3.zzc = new zzli(zzlkVar);
                        zzacVar3.zze = true;
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzamVar9.zzK(zzacVar3);
                    }
                }
                zzY(zzawVar2, zzqVar);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzY(new zzaw((zzaw) it2.next(), j), zzqVar);
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzC();
            } finally {
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzamVar11.zzx();
            }
        }
    }

    final void zzF(zzaw zzawVar, String str) {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(str);
        if (zzhVarZzj == null || TextUtils.isEmpty(zzhVarZzj.zzw())) {
            zzay().zzc().zzb("No app data available; dropping event", str);
            return;
        }
        Boolean boolZzad = zzad(zzhVarZzj);
        if (boolZzad == null) {
            if (!"_ui".equals(zzawVar.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeu.zzn(str));
            }
        } else if (!boolZzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeu.zzn(str));
            return;
        }
        String strZzy = zzhVarZzj.zzy();
        String strZzw = zzhVarZzj.zzw();
        long jZzb = zzhVarZzj.zzb();
        String strZzv = zzhVarZzj.zzv();
        long jZzm = zzhVarZzj.zzm();
        long jZzj = zzhVarZzj.zzj();
        boolean zZzai = zzhVarZzj.zzai();
        String strZzx = zzhVarZzj.zzx();
        zzhVarZzj.zza();
        zzG(zzawVar, new zzq(str, strZzy, strZzw, jZzb, strZzv, jZzm, jZzj, (String) null, zZzai, false, strZzx, 0L, 0L, 0, zzhVarZzj.zzah(), false, zzhVarZzj.zzr(), zzhVarZzj.zzq(), zzhVarZzj.zzk(), zzhVarZzj.zzC(), (String) null, zzh(str).zzh(), "", (String) null));
    }

    final void zzG(zzaw zzawVar, zzq zzqVar) {
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzev zzevVarZzb = zzev.zzb(zzawVar);
        zzln zzlnVarZzv = zzv();
        Bundle bundle = zzevVarZzb.zzd;
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzlnVarZzv.zzL(bundle, zzamVar.zzi(zzqVar.zza));
        zzv().zzM(zzevVarZzb, zzg().zzd(zzqVar.zza));
        zzaw zzawVarZza = zzevVarZzb.zza();
        if ("_cmp".equals(zzawVarZza.zza) && "referrer API v2".equals(zzawVarZza.zzb.zzg("_cis"))) {
            String strZzg = zzawVarZza.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(strZzg)) {
                zzW(new zzli("_lgclid", zzawVarZza.zzd, strZzg, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
            }
        }
        zzE(zzawVarZza, zzqVar);
    }

    final void zzH() {
        this.zzs++;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0044  */
    /* JADX WARN: Code duplicated, block: B:14:0x0046 A[PHI: r10
      0x0046: PHI (r10v11 int) = (r10v2 int), (r10v0 int) binds: [B:12:0x0042, B:10:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x0101  */
    /* JADX WARN: Code duplicated, block: B:63:0x0151 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:6:0x002c, B:16:0x0049, B:71:0x0188, B:21:0x0063, B:26:0x00b5, B:25:0x00a6, B:29:0x00bd, B:32:0x00c9, B:34:0x00cf, B:36:0x00d7, B:39:0x00e8, B:42:0x00f4, B:44:0x00fa, B:49:0x0107, B:61:0x013c, B:63:0x0151, B:65:0x0170, B:67:0x017b, B:69:0x0181, B:70:0x0185, B:64:0x015f, B:55:0x0120, B:57:0x012b), top: B:80:0x002c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x015f A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:6:0x002c, B:16:0x0049, B:71:0x0188, B:21:0x0063, B:26:0x00b5, B:25:0x00a6, B:29:0x00bd, B:32:0x00c9, B:34:0x00cf, B:36:0x00d7, B:39:0x00e8, B:42:0x00f4, B:44:0x00fa, B:49:0x0107, B:61:0x013c, B:63:0x0151, B:65:0x0170, B:67:0x017b, B:69:0x0181, B:70:0x0185, B:64:0x015f, B:55:0x0120, B:57:0x012b), top: B:80:0x002c, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0185 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:6:0x002c, B:16:0x0049, B:71:0x0188, B:21:0x0063, B:26:0x00b5, B:25:0x00a6, B:29:0x00bd, B:32:0x00c9, B:34:0x00cf, B:36:0x00d7, B:39:0x00e8, B:42:0x00f4, B:44:0x00fa, B:49:0x0107, B:61:0x013c, B:63:0x0151, B:65:0x0170, B:67:0x017b, B:69:0x0181, B:70:0x0185, B:64:0x015f, B:55:0x0120, B:57:0x012b), top: B:80:0x002c, outer: #0 }] */
    final void zzI(String str, int i, Throwable th, byte[] bArr, Map map) {
        boolean z;
        String str2;
        zzam zzamVar;
        zzfa zzfaVar;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzt = false;
                zzae();
                throw th2;
            }
        }
        zzes zzesVarZzj = zzay().zzj();
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzesVarZzj.zzb("onConfigFetched. Response size", numValueOf);
        zzam zzamVar2 = this.zze;
        zzal(zzamVar2);
        zzamVar2.zzw();
        try {
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzh zzhVarZzj = zzamVar3.zzj(str);
            if (i == 200 || i == 204) {
                if (th == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else if (i == 304) {
                i = 304;
                if (th == null) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (zzhVarZzj == null) {
                zzay().zzk().zzb("App does not exist in onConfigFetched. appId", zzeu.zzn(str));
            } else {
                if (z || i == 404) {
                    List list = map != null ? (List) map.get(HttpHeaders.LAST_MODIFIED) : null;
                    String str3 = (list == null || list.isEmpty()) ? null : (String) list.get(0);
                    zzpc.zzc();
                    if (zzg().zzs(null, zzeh.zzaD)) {
                        List list2 = map != null ? (List) map.get(HttpHeaders.ETAG) : null;
                        if (list2 == null || list2.isEmpty()) {
                            str2 = null;
                        } else {
                            str2 = (String) list2.get(0);
                        }
                    } else {
                        str2 = null;
                    }
                    if (i == 404 || i == 304) {
                        zzfv zzfvVar = this.zzc;
                        zzal(zzfvVar);
                        if (zzfvVar.zze(str) == null) {
                            zzfv zzfvVar2 = this.zzc;
                            zzal(zzfvVar2);
                            if (!zzfvVar2.zzt(str, null, null, null)) {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                            }
                        }
                        zzhVarZzj.zzL(zzav().currentTimeMillis());
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzD(zzhVarZzj);
                        if (i == 404) {
                            zzay().zzl().zzb("Config not found. Using empty config. appId", str);
                        } else {
                            zzay().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                        }
                        zzfaVar = this.zzd;
                        zzal(zzfaVar);
                        if (zzfaVar.zza() || !zzai()) {
                            zzag();
                        } else {
                            zzX();
                        }
                    } else {
                        zzfv zzfvVar3 = this.zzc;
                        zzal(zzfvVar3);
                        if (zzfvVar3.zzt(str, bArr, str3, str2)) {
                            zzhVarZzj.zzL(zzav().currentTimeMillis());
                            zzam zzamVar5 = this.zze;
                            zzal(zzamVar5);
                            zzamVar5.zzD(zzhVarZzj);
                            if (i == 404) {
                                zzay().zzl().zzb("Config not found. Using empty config. appId", str);
                            } else {
                                zzay().zzj().zzc("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), numValueOf);
                            }
                            zzfaVar = this.zzd;
                            zzal(zzfaVar);
                            if (zzfaVar.zza()) {
                                zzag();
                            } else {
                                zzag();
                            }
                        } else {
                            zzamVar = this.zze;
                            zzal(zzamVar);
                        }
                    }
                    zzamVar.zzx();
                    this.zzt = false;
                    zzae();
                }
                zzhVarZzj.zzU(zzav().currentTimeMillis());
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzD(zzhVarZzj);
                zzay().zzj().zzc("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzfv zzfvVar4 = this.zzc;
                zzal(zzfvVar4);
                zzfvVar4.zzl(str);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i == 503 || i == 429) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzag();
            }
            zzam zzamVar7 = this.zze;
            zzal(zzamVar7);
            zzamVar7.zzC();
            zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzx();
            this.zzt = false;
            zzae();
        } catch (Throwable th3) {
            zzam zzamVar8 = this.zze;
            zzal(zzamVar8);
            zzamVar8.zzx();
            throw th3;
        }
    }

    final void zzJ(boolean z) {
        zzag();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0068 A[Catch: all -> 0x00ec, TRY_LEAVE, TryCatch #2 {all -> 0x00ec, blocks: (B:13:0x005e, B:14:0x0062, B:16:0x0068, B:17:0x006e, B:18:0x008a, B:21:0x0095, B:22:0x009c, B:24:0x009e, B:25:0x00ad, B:27:0x00af, B:29:0x00b3, B:32:0x00ba, B:33:0x00bb), top: B:59:0x005e, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e2 A[Catch: SQLiteException -> 0x00f6, all -> 0x016a, TryCatch #0 {SQLiteException -> 0x00f6, blocks: (B:12:0x0025, B:34:0x00c3, B:36:0x00d8, B:38:0x00de, B:40:0x00e9, B:39:0x00e2, B:42:0x00ed, B:43:0x00f5), top: B:57:0x0025, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0122 A[Catch: all -> 0x016a, PHI: r9
      0x0122: PHI (r9v18 int) = (r9v2 int), (r9v0 int) binds: [B:11:0x0023, B:9:0x0020] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x016a, blocks: (B:4:0x000d, B:5:0x000f, B:46:0x0122, B:51:0x0159, B:50:0x014a, B:12:0x0025, B:34:0x00c3, B:36:0x00d8, B:38:0x00de, B:40:0x00e9, B:39:0x00e2, B:42:0x00ed, B:43:0x00f5, B:45:0x00f7), top: B:58:0x000d, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0146  */
    /* JADX WARN: Code duplicated, block: B:50:0x014a A[Catch: all -> 0x016a, TryCatch #1 {all -> 0x016a, blocks: (B:4:0x000d, B:5:0x000f, B:46:0x0122, B:51:0x0159, B:50:0x014a, B:12:0x0025, B:34:0x00c3, B:36:0x00d8, B:38:0x00de, B:40:0x00e9, B:39:0x00e2, B:42:0x00ed, B:43:0x00f5, B:45:0x00f7), top: B:58:0x000d, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0094 A[SYNTHETIC] */
    final void zzK(int i, Throwable th, byte[] bArr, String str) {
        zzfa zzfaVar;
        zzam zzamVar;
        long jLongValue;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzae();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i == 200) {
            if (th == null) {
                try {
                    this.zzk.zzc.zzb(zzav().currentTimeMillis());
                    this.zzk.zzd.zzb(0L);
                    zzag();
                    zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                    zzam zzamVar2 = this.zze;
                    zzal(zzamVar2);
                    zzamVar2.zzw();
                    try {
                        for (Long l : list) {
                            try {
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                jLongValue = l.longValue();
                                zzamVar.zzg();
                                zzamVar.zzW();
                                try {
                                    if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) == 1) {
                                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                                    }
                                } catch (SQLiteException e) {
                                    zzamVar.zzs.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e);
                                    throw e;
                                }
                            } catch (SQLiteException e2) {
                                List list2 = this.zzz;
                                if (list2 == null || !list2.contains(l)) {
                                    throw e2;
                                }
                            }
                        }
                        zzam zzamVar3 = this.zze;
                        zzal(zzamVar3);
                        zzamVar3.zzC();
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzx();
                        this.zzz = null;
                        zzfaVar = this.zzd;
                        zzal(zzfaVar);
                        if (zzfaVar.zza() || !zzai()) {
                            this.zzA = -1L;
                            zzag();
                        } else {
                            zzX();
                        }
                        this.zza = 0L;
                    } catch (Throwable th3) {
                        zzam zzamVar5 = this.zze;
                        zzal(zzamVar5);
                        zzamVar5.zzx();
                        throw th3;
                    }
                } catch (SQLiteException e3) {
                    zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e3);
                    this.zza = zzav().elapsedRealtime();
                    zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
                }
            } else {
                zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i != 503 || i == 429) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzy(list);
                zzag();
            }
        } else if (i == 204) {
            i = 204;
            if (th == null) {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0L);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                zzamVar7.zzw();
                while (r9.hasNext()) {
                    zzamVar = this.zze;
                    zzal(zzamVar);
                    jLongValue = l.longValue();
                    zzamVar.zzg();
                    zzamVar.zzW();
                    if (zzamVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(jLongValue)}) == 1) {
                        throw new SQLiteException("Deleted fewer rows from queue than expected");
                    }
                }
                zzam zzamVar8 = this.zze;
                zzal(zzamVar8);
                zzamVar8.zzC();
                zzam zzamVar9 = this.zze;
                zzal(zzamVar9);
                zzamVar9.zzx();
                this.zzz = null;
                zzfaVar = this.zzd;
                zzal(zzfaVar);
                if (zzfaVar.zza()) {
                    this.zzA = -1L;
                    zzag();
                } else {
                    this.zzA = -1L;
                    zzag();
                }
                this.zza = 0L;
            } else {
                zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
                this.zzk.zzd.zzb(zzav().currentTimeMillis());
                if (i != 503) {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                } else {
                    this.zzk.zzb.zzb(zzav().currentTimeMillis());
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzy(list);
                zzag();
            }
        } else {
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i != 503) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            } else {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            zzam zzamVar11 = this.zze;
            zzal(zzamVar11);
            zzamVar11.zzy(list);
            zzag();
        }
        this.zzu = false;
        zzae();
    }

    /* JADX WARN: Code duplicated, block: B:67:0x0205  */
    /* JADX WARN: Code duplicated, block: B:70:0x020a A[Catch: all -> 0x0552, TryCatch #0 {all -> 0x0552, blocks: (B:23:0x00a5, B:25:0x00b4, B:40:0x0100, B:42:0x0113, B:44:0x012b, B:45:0x0152, B:47:0x01a2, B:50:0x01b7, B:54:0x01d0, B:56:0x01db, B:61:0x01ed, B:64:0x01fb, B:68:0x0207, B:70:0x020a, B:71:0x0229, B:73:0x022e, B:76:0x024e, B:80:0x0263, B:82:0x0293, B:85:0x029b, B:87:0x02aa, B:116:0x0395, B:118:0x03c3, B:119:0x03c8, B:121:0x03f1, B:161:0x04be, B:162:0x04c1, B:170:0x0541, B:123:0x0406, B:128:0x042b, B:130:0x0433, B:132:0x043b, B:136:0x044e, B:140:0x0461, B:144:0x046d, B:147:0x047b, B:152:0x049f, B:154:0x04a7, B:156:0x04af, B:158:0x04b5, B:150:0x048c, B:138:0x0459, B:126:0x0417, B:88:0x02bb, B:90:0x02e6, B:91:0x02f7, B:93:0x02ff, B:95:0x0305, B:97:0x030f, B:99:0x0319, B:101:0x031f, B:103:0x0325, B:104:0x032a, B:109:0x034d, B:112:0x0352, B:113:0x0366, B:114:0x0376, B:115:0x0386, B:163:0x04d5, B:165:0x050e, B:166:0x0511, B:167:0x0525, B:169:0x0529, B:74:0x023e, B:27:0x00be, B:29:0x00c2, B:33:0x00d3, B:35:0x00e2, B:37:0x00ec, B:39:0x00f2), top: B:177:0x00a5, inners: #1, #2, #3, #4 }] */
    final void zzL(zzq zzqVar) {
        int i;
        zzas zzasVarZzn;
        int i2;
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        long j;
        boolean z;
        long j2;
        int i3;
        String strZzw;
        int i4;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        if (zzak(zzqVar)) {
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzh zzhVarZzj = zzamVar.zzj(zzqVar.zza);
            if (zzhVarZzj != null && TextUtils.isEmpty(zzhVarZzj.zzy()) && !TextUtils.isEmpty(zzqVar.zzb)) {
                zzhVarZzj.zzL(0L);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzamVar2.zzD(zzhVarZzj);
                zzfv zzfvVar = this.zzc;
                zzal(zzfvVar);
                zzfvVar.zzm(zzqVar.zza);
            }
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            long jCurrentTimeMillis = zzqVar.zzm;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = zzav().currentTimeMillis();
            }
            long j3 = jCurrentTimeMillis;
            this.zzn.zzg().zzd();
            int i5 = zzqVar.zzn;
            if (i5 != 0 && i5 != 1) {
                zzay().zzk().zzc("Incorrect app type, assuming installed app. appId, appType", zzeu.zzn(zzqVar.zza), Integer.valueOf(i5));
                i5 = 0;
            }
            zzam zzamVar3 = this.zze;
            zzal(zzamVar3);
            zzamVar3.zzw();
            try {
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzlk zzlkVarZzp = zzamVar4.zzp(zzqVar.zza, "_npa");
                if (zzlkVarZzp == null || DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(zzlkVarZzp.zzb)) {
                    if (zzqVar.zzr != null) {
                        zzli zzliVar = new zzli("_npa", j3, Long.valueOf(true != zzqVar.zzr.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                        if (zzlkVarZzp == null || !zzlkVarZzp.zze.equals(zzliVar.zzd)) {
                            zzW(zzliVar, zzqVar);
                        }
                    } else if (zzlkVarZzp != null) {
                        zzP(new zzli("_npa", j3, null, DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
                    }
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzh zzhVarZzj2 = zzamVar5.zzj((String) Preconditions.checkNotNull(zzqVar.zza));
                if (zzhVarZzj2 != null) {
                    i = 0;
                    if (zzv().zzam(zzqVar.zzb, zzhVarZzj2.zzy(), zzqVar.zzq, zzhVarZzj2.zzr())) {
                        zzay().zzk().zzb("New GMP App Id passed in. Removing cached database data. appId", zzeu.zzn(zzhVarZzj2.zzt()));
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        String strZzt = zzhVarZzj2.zzt();
                        zzamVar6.zzW();
                        zzamVar6.zzg();
                        Preconditions.checkNotEmpty(strZzt);
                        try {
                            SQLiteDatabase sQLiteDatabaseZzh = zzamVar6.zzh();
                            String[] strArr = {strZzt};
                            int iDelete = sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("event_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("property_filters", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("consent_settings", "app_id=?", strArr);
                            if (iDelete > 0) {
                                zzamVar6.zzs.zzay().zzj().zzc("Deleted application data. app, records", strZzt, Integer.valueOf(iDelete));
                            }
                        } catch (SQLiteException e) {
                            zzamVar6.zzs.zzay().zzd().zzc("Error deleting application data. appId, error", zzeu.zzn(strZzt), e);
                        }
                        zzhVarZzj2 = null;
                    }
                } else {
                    i = 0;
                }
                if (zzhVarZzj2 != null) {
                    if (zzhVarZzj2.zzb() != -2147483648L) {
                        j2 = -2147483648L;
                        if (zzhVarZzj2.zzb() != zzqVar.zzj) {
                            i3 = 1;
                        }
                        strZzw = zzhVarZzj2.zzw();
                        if (zzhVarZzj2.zzb() == j2 || strZzw == null || strZzw.equals(zzqVar.zzc)) {
                            i4 = i;
                        } else {
                            i4 = 1;
                        }
                        if ((i3 | i4) != 0) {
                            Bundle bundle = new Bundle();
                            bundle.putString("_pv", strZzw);
                            zzaw zzawVar = new zzaw("_au", new zzau(bundle), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3);
                            j3 = j3;
                            zzE(zzawVar, zzqVar);
                        }
                    } else {
                        j2 = -2147483648L;
                    }
                    i3 = i;
                    strZzw = zzhVarZzj2.zzw();
                    if (zzhVarZzj2.zzb() == j2) {
                        i4 = i;
                    } else {
                        i4 = i;
                    }
                    if ((i3 | i4) != 0) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("_pv", strZzw);
                        zzaw zzawVar2 = new zzaw("_au", new zzau(bundle2), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3);
                        j3 = j3;
                        zzE(zzawVar2, zzqVar);
                    }
                }
                zzd(zzqVar);
                if (i5 == 0) {
                    zzam zzamVar7 = this.zze;
                    zzal(zzamVar7);
                    zzasVarZzn = zzamVar7.zzn(zzqVar.zza, "_f");
                    i2 = i;
                } else {
                    zzam zzamVar8 = this.zze;
                    zzal(zzamVar8);
                    zzasVarZzn = zzamVar8.zzn(zzqVar.zza, "_v");
                    i2 = 1;
                }
                if (zzasVarZzn == null) {
                    long j4 = ((j3 / 3600000) + 1) * 3600000;
                    if (i2 == 0) {
                        zzW(new zzli("_fot", j3, Long.valueOf(j4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
                        zzaz().zzg();
                        zzfm zzfmVar = (zzfm) Preconditions.checkNotNull(this.zzm);
                        String str = zzqVar.zza;
                        if (str == null || str.isEmpty()) {
                            zzfmVar.zza.zzay().zzm().zza("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            zzfmVar.zza.zzaz().zzg();
                            if (zzfmVar.zza()) {
                                zzfl zzflVar = new zzfl(zzfmVar, str);
                                zzfmVar.zza.zzaz().zzg();
                                Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                                PackageManager packageManager = zzfmVar.zza.zzau().getPackageManager();
                                if (packageManager == null) {
                                    zzfmVar.zza.zzay().zzm().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    int i6 = i;
                                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, i6);
                                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                                        zzfmVar.zza.zzay().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                    } else {
                                        ResolveInfo resolveInfo = listQueryIntentServices.get(i6);
                                        if (resolveInfo.serviceInfo != null) {
                                            String str2 = resolveInfo.serviceInfo.packageName;
                                            if (resolveInfo.serviceInfo.name != null && "com.android.vending".equals(str2) && zzfmVar.zza()) {
                                                try {
                                                    zzfmVar.zza.zzay().zzj().zzb("Install Referrer Service is", true != ConnectionTracker.getInstance().bindService(zzfmVar.zza.zzau(), new Intent(intent), zzflVar, 1) ? "not available" : "available");
                                                } catch (RuntimeException e2) {
                                                    zzfmVar.zza.zzay().zzd().zzb("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                                                }
                                            } else {
                                                zzfmVar.zza.zzay().zzk().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                            }
                                        }
                                    }
                                }
                            } else {
                                zzfmVar.zza.zzay().zzi().zza("Install Referrer Reporter is not available");
                            }
                        }
                        zzaz().zzg();
                        zzB();
                        Bundle bundle3 = new Bundle();
                        bundle3.putLong("_c", 1L);
                        bundle3.putLong("_r", 1L);
                        bundle3.putLong("_uwa", 0L);
                        bundle3.putLong("_pfo", 0L);
                        bundle3.putLong("_sys", 0L);
                        bundle3.putLong("_sysu", 0L);
                        bundle3.putLong("_et", 1L);
                        if (zzqVar.zzp) {
                            bundle3.putLong("_dac", 1L);
                        }
                        String str3 = (String) Preconditions.checkNotNull(zzqVar.zza);
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        Preconditions.checkNotEmpty(str3);
                        zzamVar9.zzg();
                        zzamVar9.zzW();
                        long jZzc = zzamVar9.zzc(str3, "first_open_count");
                        if (this.zzn.zzau().getPackageManager() == null) {
                            zzay().zzd().zzb("PackageManager is null, first open report might be inaccurate. appId", zzeu.zzn(str3));
                        } else {
                            try {
                                packageInfo = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(str3, 0);
                            } catch (PackageManager.NameNotFoundException e3) {
                                zzay().zzd().zzc("Package info is null, first open report might be inaccurate. appId", zzeu.zzn(str3), e3);
                                packageInfo = null;
                            }
                            if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                applicationInfo = null;
                            } else {
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    applicationInfo = null;
                                    if (!zzg().zzs(null, zzeh.zzab)) {
                                        bundle3.putLong("_uwa", 1L);
                                    } else if (jZzc == 0) {
                                        bundle3.putLong("_uwa", 1L);
                                        z = false;
                                        jZzc = 0;
                                    }
                                    z = false;
                                } else {
                                    applicationInfo = null;
                                    z = true;
                                }
                                zzW(new zzli("_fi", j3, Long.valueOf(true != z ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
                            }
                            try {
                                applicationInfo = Wrappers.packageManager(this.zzn.zzau()).getApplicationInfo(str3, 0);
                            } catch (PackageManager.NameNotFoundException e4) {
                                zzay().zzd().zzc("Application info is null, first open report might be inaccurate. appId", zzeu.zzn(str3), e4);
                            }
                            if (applicationInfo != null) {
                                if ((applicationInfo.flags & 1) != 0) {
                                    j = 1;
                                    bundle3.putLong("_sys", 1L);
                                } else {
                                    j = 1;
                                }
                                if ((applicationInfo.flags & 128) != 0) {
                                    bundle3.putLong("_sysu", j);
                                }
                            }
                        }
                        if (jZzc >= 0) {
                            bundle3.putLong("_pfo", jZzc);
                        }
                        zzG(new zzaw("_f", new zzau(bundle3), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzqVar);
                    } else {
                        zzW(new zzli("_fvt", j3, Long.valueOf(j4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
                        zzaz().zzg();
                        zzB();
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("_c", 1L);
                        bundle4.putLong("_r", 1L);
                        bundle4.putLong("_et", 1L);
                        if (zzqVar.zzp) {
                            bundle4.putLong("_dac", 1L);
                        }
                        zzG(new zzaw("_v", new zzau(bundle4), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzqVar);
                    }
                } else if (zzqVar.zzi) {
                    zzG(new zzaw("_cd", new zzau(new Bundle()), DebugKt.DEBUG_PROPERTY_VALUE_AUTO, j3), zzqVar);
                }
                zzam zzamVar10 = this.zze;
                zzal(zzamVar10);
                zzamVar10.zzC();
                zzam zzamVar11 = this.zze;
                zzal(zzamVar11);
                zzamVar11.zzx();
            } catch (Throwable th) {
                zzam zzamVar12 = this.zze;
                zzal(zzamVar12);
                zzamVar12.zzx();
                throw th;
            }
        }
    }

    final void zzM() {
        this.zzr++;
    }

    final void zzN(zzac zzacVar) {
        zzq zzqVarZzac = zzac((String) Preconditions.checkNotNull(zzacVar.zza));
        if (zzqVarZzac != null) {
            zzO(zzacVar, zzqVarZzac);
        }
    }

    final void zzO(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                String str = (String) Preconditions.checkNotNull(zzacVar.zza);
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzacVarZzk = zzamVar2.zzk(str, zzacVar.zzc.zzb);
                if (zzacVarZzk != null) {
                    zzay().zzc().zzc("Removing conditional user property", zzacVar.zza, this.zzn.zzj().zzf(zzacVar.zzc.zzb));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzamVar3.zza(str, zzacVar.zzc.zzb);
                    if (zzacVarZzk.zze) {
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzA(str, zzacVar.zzc.zzb);
                    }
                    zzaw zzawVar = zzacVar.zzk;
                    if (zzawVar != null) {
                        zzau zzauVar = zzawVar.zzb;
                        zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzacVar.zzk)).zza, zzauVar != null ? zzauVar.zzc() : null, zzacVarZzk.zzb, zzacVar.zzk.zzd, true, true)), zzqVar);
                    }
                } else {
                    zzay().zzk().zzc("Conditional user property doesn't exist", zzeu.zzn(zzacVar.zza), this.zzn.zzj().zzf(zzacVar.zzc.zzb));
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    final void zzP(zzli zzliVar, zzq zzqVar) {
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            if ("_npa".equals(zzliVar.zzb) && zzqVar.zzr != null) {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                zzW(new zzli("_npa", zzav().currentTimeMillis(), Long.valueOf(true != zzqVar.zzr.booleanValue() ? 0L : 1L), DebugKt.DEBUG_PROPERTY_VALUE_AUTO), zzqVar);
                return;
            }
            zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzliVar.zzb));
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzd(zzqVar);
                if ("_id".equals(zzliVar.zzb)) {
                    zzam zzamVar2 = this.zze;
                    zzal(zzamVar2);
                    zzamVar2.zzA((String) Preconditions.checkNotNull(zzqVar.zza), "_lair");
                }
                zzam zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzamVar3.zzA((String) Preconditions.checkNotNull(zzqVar.zza), zzliVar.zzb);
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                zzamVar4.zzC();
                zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzliVar.zzb));
            } finally {
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzx();
            }
        }
    }

    final void zzQ(zzq zzqVar) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        String str = (String) Preconditions.checkNotNull(zzqVar.zza);
        Preconditions.checkNotEmpty(str);
        zzamVar.zzg();
        zzamVar.zzW();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzamVar.zzh();
            String[] strArr = {str};
            int iDelete = sQLiteDatabaseZzh.delete("apps", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("user_attributes", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("conditional_properties", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("raw_events_metadata", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("queue", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("audience_filter_values", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("main_event_params", "app_id=?", strArr) + sQLiteDatabaseZzh.delete("default_event_params", "app_id=?", strArr);
            if (iDelete > 0) {
                zzamVar.zzs.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(iDelete));
            }
        } catch (SQLiteException e) {
            zzamVar.zzs.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeu.zzn(str), e);
        }
        if (zzqVar.zzh) {
            zzL(zzqVar);
        }
    }

    public final void zzR(String str, zziq zziqVar) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zziqVar != null) {
            this.zzE = str;
            this.zzD = zziqVar;
        }
    }

    protected final void zzS() {
        zzaz().zzg();
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzamVar.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    final void zzT(zzac zzacVar) {
        zzq zzqVarZzac = zzac((String) Preconditions.checkNotNull(zzacVar.zza));
        if (zzqVarZzac != null) {
            zzU(zzacVar, zzqVarZzac);
        }
    }

    final void zzU(zzac zzacVar, zzq zzqVar) {
        Preconditions.checkNotNull(zzacVar);
        Preconditions.checkNotEmpty(zzacVar.zza);
        Preconditions.checkNotNull(zzacVar.zzb);
        Preconditions.checkNotNull(zzacVar.zzc);
        Preconditions.checkNotEmpty(zzacVar.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            zzac zzacVar2 = new zzac(zzacVar);
            boolean z = false;
            zzacVar2.zze = false;
            zzam zzamVar = this.zze;
            zzal(zzamVar);
            zzamVar.zzw();
            try {
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                zzac zzacVarZzk = zzamVar2.zzk((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzc.zzb);
                if (zzacVarZzk != null && !zzacVarZzk.zzb.equals(zzacVar2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzb, zzacVarZzk.zzb);
                }
                if (zzacVarZzk != null && zzacVarZzk.zze) {
                    zzacVar2.zzb = zzacVarZzk.zzb;
                    zzacVar2.zzd = zzacVarZzk.zzd;
                    zzacVar2.zzh = zzacVarZzk.zzh;
                    zzacVar2.zzf = zzacVarZzk.zzf;
                    zzacVar2.zzi = zzacVarZzk.zzi;
                    zzacVar2.zze = true;
                    zzli zzliVar = zzacVar2.zzc;
                    zzacVar2.zzc = new zzli(zzliVar.zzb, zzacVarZzk.zzc.zzc, zzliVar.zza(), zzacVarZzk.zzc.zzf);
                } else if (TextUtils.isEmpty(zzacVar2.zzf)) {
                    zzli zzliVar2 = zzacVar2.zzc;
                    zzacVar2.zzc = new zzli(zzliVar2.zzb, zzacVar2.zzd, zzliVar2.zza(), zzacVar2.zzc.zzf);
                    zzacVar2.zze = true;
                    z = true;
                }
                if (zzacVar2.zze) {
                    zzli zzliVar3 = zzacVar2.zzc;
                    zzlk zzlkVar = new zzlk((String) Preconditions.checkNotNull(zzacVar2.zza), zzacVar2.zzb, zzliVar3.zzb, zzliVar3.zzc, Preconditions.checkNotNull(zzliVar3.zza()));
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzL(zzlkVar)) {
                        zzay().zzc().zzd("User property updated immediately", zzacVar2.zza, this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeu.zzn(zzacVar2.zza), this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                    }
                    if (z && zzacVar2.zzi != null) {
                        zzY(new zzaw(zzacVar2.zzi, zzacVar2.zzd), zzqVar);
                    }
                }
                zzam zzamVar4 = this.zze;
                zzal(zzamVar4);
                if (zzamVar4.zzK(zzacVar2)) {
                    zzay().zzc().zzd("Conditional property added", zzacVar2.zza, this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeu.zzn(zzacVar2.zza), this.zzn.zzj().zzf(zzacVar2.zzc.zzb), zzacVar2.zzc.zza());
                }
                zzam zzamVar5 = this.zze;
                zzal(zzamVar5);
                zzamVar5.zzC();
            } finally {
                zzam zzamVar6 = this.zze;
                zzal(zzamVar6);
                zzamVar6.zzx();
            }
        }
    }

    final void zzV(String str, zzai zzaiVar) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzaiVar);
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaiVar);
        zzamVar.zzg();
        zzamVar.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzaiVar.zzh());
        try {
            if (zzamVar.zzh().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzamVar.zzs.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeu.zzn(str));
            }
        } catch (SQLiteException e) {
            zzamVar.zzs.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeu.zzn(str), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:38:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:42:0x010c  */
    final void zzW(zzli zzliVar, zzq zzqVar) {
        zzas zzasVarZzn;
        long jLongValue;
        zzaz().zzg();
        zzB();
        if (zzak(zzqVar)) {
            if (!zzqVar.zzh) {
                zzd(zzqVar);
                return;
            }
            int iZzl = zzv().zzl(zzliVar.zzb);
            int length = 0;
            if (iZzl != 0) {
                zzln zzlnVarZzv = zzv();
                String str = zzliVar.zzb;
                zzg();
                String strZzD = zzlnVarZzv.zzD(str, 24, true);
                String str2 = zzliVar.zzb;
                zzv().zzN(this.zzF, zzqVar.zza, iZzl, "_ev", strZzD, str2 != null ? str2.length() : 0);
                return;
            }
            int iZzd = zzv().zzd(zzliVar.zzb, zzliVar.zza());
            if (iZzd != 0) {
                zzln zzlnVarZzv2 = zzv();
                String str3 = zzliVar.zzb;
                zzg();
                String strZzD2 = zzlnVarZzv2.zzD(str3, 24, true);
                Object objZza = zzliVar.zza();
                if (objZza != null && ((objZza instanceof String) || (objZza instanceof CharSequence))) {
                    length = objZza.toString().length();
                }
                zzv().zzN(this.zzF, zzqVar.zza, iZzd, "_ev", strZzD2, length);
                return;
            }
            Object objZzB = zzv().zzB(zzliVar.zzb, zzliVar.zza());
            if (objZzB == null) {
                return;
            }
            if ("_sid".equals(zzliVar.zzb)) {
                long j = zzliVar.zzc;
                String str4 = zzliVar.zzf;
                String str5 = (String) Preconditions.checkNotNull(zzqVar.zza);
                zzam zzamVar = this.zze;
                zzal(zzamVar);
                zzlk zzlkVarZzp = zzamVar.zzp(str5, "_sno");
                if (zzlkVarZzp != null) {
                    Object obj = zzlkVarZzp.zze;
                    if (obj instanceof Long) {
                        jLongValue = ((Long) obj).longValue();
                    } else {
                        if (zzlkVarZzp != null) {
                            zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzlkVarZzp.zze);
                        }
                        zzam zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        zzasVarZzn = zzamVar2.zzn(str5, "_s");
                        if (zzasVarZzn != null) {
                            jLongValue = zzasVarZzn.zzc;
                            zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                        } else {
                            jLongValue = 0;
                        }
                    }
                } else {
                    if (zzlkVarZzp != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", zzlkVarZzp.zze);
                    }
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    zzasVarZzn = zzamVar3.zzn(str5, "_s");
                    if (zzasVarZzn != null) {
                        jLongValue = zzasVarZzn.zzc;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(jLongValue));
                    } else {
                        jLongValue = 0;
                    }
                }
                zzW(new zzli("_sno", j, Long.valueOf(jLongValue + 1), str4), zzqVar);
            }
            zzlk zzlkVar = new zzlk((String) Preconditions.checkNotNull(zzqVar.zza), (String) Preconditions.checkNotNull(zzliVar.zzf), zzliVar.zzb, zzliVar.zzc, objZzB);
            zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(zzlkVar.zzc), objZzB);
            zzam zzamVar4 = this.zze;
            zzal(zzamVar4);
            zzamVar4.zzw();
            try {
                if ("_id".equals(zzlkVar.zzc)) {
                    zzam zzamVar5 = this.zze;
                    zzal(zzamVar5);
                    zzlk zzlkVarZzp2 = zzamVar5.zzp(zzqVar.zza, "_id");
                    if (zzlkVarZzp2 != null && !zzlkVar.zze.equals(zzlkVarZzp2.zze)) {
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zzA(zzqVar.zza, "_lair");
                    }
                }
                zzd(zzqVar);
                zzam zzamVar7 = this.zze;
                zzal(zzamVar7);
                boolean zZzL = zzamVar7.zzL(zzlkVar);
                zzam zzamVar8 = this.zze;
                zzal(zzamVar8);
                zzamVar8.zzC();
                if (!zZzL) {
                    zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                    zzv().zzN(this.zzF, zzqVar.zza, 9, null, null, 0);
                }
            } finally {
                zzam zzamVar9 = this.zze;
                zzal(zzamVar9);
                zzamVar9.zzx();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x020c A[Catch: SQLiteException -> 0x025e, all -> 0x0297, TryCatch #4 {SQLiteException -> 0x025e, blocks: (B:89:0x01c1, B:90:0x01c8, B:91:0x01dd, B:93:0x01e3, B:94:0x01ed, B:96:0x01f3, B:100:0x01fb, B:102:0x0206, B:104:0x020c, B:105:0x0213, B:108:0x022a), top: B:267:0x01c1 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x023e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0280 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:135:0x028e A[Catch: all -> 0x05ba, TRY_ENTER, TRY_LEAVE, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x02c7 A[Catch: all -> 0x05ba, TRY_ENTER, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x02d0 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x02dc A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:162:0x02e6 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x0302  */
    /* JADX WARN: Code duplicated, block: B:170:0x0309 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x031d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:173:0x031e A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x034c A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:182:0x035b  */
    /* JADX WARN: Code duplicated, block: B:185:0x0381 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x03b9 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x03be A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x03c6 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x03ce A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x03dd A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0408 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:202:0x0419  */
    /* JADX WARN: Code duplicated, block: B:205:0x043c A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:207:0x044d A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x0482 A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:209:0x048c A[Catch: all -> 0x05ba, TRY_LEAVE, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x04a7 A[Catch: MalformedURLException -> 0x0513, all -> 0x05ba, TryCatch #14 {MalformedURLException -> 0x0513, blocks: (B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5), top: B:278:0x0495, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x04b5 A[Catch: MalformedURLException -> 0x0513, all -> 0x05ba, TryCatch #14 {MalformedURLException -> 0x0513, blocks: (B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5), top: B:278:0x0495, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x04c7 A[Catch: MalformedURLException -> 0x0513, all -> 0x05ba, TryCatch #14 {MalformedURLException -> 0x0513, blocks: (B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5), top: B:278:0x0495, outer: #13 }] */
    /* JADX WARN: Code duplicated, block: B:223:0x052a A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:250:0x059f A[Catch: all -> 0x05ba, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:252:0x05aa A[Catch: all -> 0x05ba, TRY_LEAVE, TryCatch #13 {all -> 0x05ba, blocks: (B:3:0x0010, B:11:0x0038, B:15:0x004e, B:20:0x005c, B:24:0x0077, B:28:0x0095, B:34:0x00bd, B:38:0x00e0, B:40:0x00f1, B:68:0x013c, B:72:0x0164, B:76:0x016c, B:155:0x02ca, B:157:0x02d0, B:159:0x02dc, B:160:0x02e0, B:162:0x02e6, B:164:0x02fa, B:168:0x0303, B:170:0x0309, B:176:0x032e, B:173:0x031e, B:175:0x0328, B:177:0x0331, B:179:0x034c, B:183:0x035c, B:185:0x0381, B:187:0x03b9, B:189:0x03be, B:191:0x03c6, B:192:0x03c9, B:194:0x03ce, B:195:0x03d1, B:197:0x03dd, B:198:0x03f3, B:199:0x03f9, B:201:0x0408, B:203:0x041a, B:205:0x043c, B:207:0x044d, B:210:0x0495, B:212:0x04a7, B:214:0x04bc, B:216:0x04c7, B:217:0x04d0, B:213:0x04b5, B:219:0x0513, B:208:0x0482, B:209:0x048c, B:135:0x028e, B:223:0x052a, B:224:0x052d, B:154:0x02c7, B:225:0x052e, B:231:0x0570, B:248:0x0599, B:250:0x059f, B:252:0x05aa, B:236:0x057b, B:257:0x05b6, B:258:0x05b9), top: B:277:0x0010, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:297:0x02ff A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:298:0x02fa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:? A[LOOP:1: B:160:0x02e0->B:299:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:306:0x03f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:307:0x028c A[ADDED_TO_REGION, EDGE_INSN: B:307:0x028c->B:134:0x028c BREAK  A[LOOP:4: B:86:0x01b7->B:133:0x0283], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x01e3 A[EDGE_INSN: B:311:0x01e3->B:93:0x01e3 BREAK  A[LOOP:5: B:91:0x01dd->B:112:0x0244], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x010e A[Catch: all -> 0x0034, PHI: r6 r10
      0x010e: PHI (r6v24 long) = (r6v1 long), (r6v26 long), (r6v1 long) binds: [B:60:0x012e, B:51:0x0116, B:47:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x010e: PHI (r10v34 android.database.Cursor) = (r10v33 android.database.Cursor), (r10v36 android.database.Cursor), (r10v36 android.database.Cursor) binds: [B:60:0x012e, B:51:0x0116, B:47:0x010c] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x0034, blocks: (B:5:0x0021, B:13:0x003e, B:18:0x0056, B:22:0x0067, B:26:0x0082, B:31:0x00b4, B:37:0x00c9, B:43:0x00f7, B:48:0x010e, B:62:0x0131, B:66:0x0138, B:67:0x013b, B:83:0x01aa), top: B:276:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0138 A[Catch: all -> 0x0034, TryCatch #12 {all -> 0x0034, blocks: (B:5:0x0021, B:13:0x003e, B:18:0x0056, B:22:0x0067, B:26:0x0082, B:31:0x00b4, B:37:0x00c9, B:43:0x00f7, B:48:0x010e, B:62:0x0131, B:66:0x0138, B:67:0x013b, B:83:0x01aa), top: B:276:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0161  */
    /* JADX WARN: Code duplicated, block: B:71:0x0163  */
    /* JADX WARN: Code duplicated, block: B:74:0x0169  */
    /* JADX WARN: Code duplicated, block: B:75:0x016b  */
    /* JADX WARN: Code duplicated, block: B:81:0x01a4 A[Catch: all -> 0x0297, SQLiteException -> 0x029e, TRY_LEAVE, TryCatch #5 {SQLiteException -> 0x029e, blocks: (B:79:0x019e, B:81:0x01a4, B:85:0x01b1, B:86:0x01b7, B:87:0x01bb), top: B:269:0x019e }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01aa A[Catch: all -> 0x0034, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x0034, blocks: (B:5:0x0021, B:13:0x003e, B:18:0x0056, B:22:0x0067, B:26:0x0082, B:31:0x00b4, B:37:0x00c9, B:43:0x00f7, B:48:0x010e, B:62:0x0131, B:66:0x0138, B:67:0x013b, B:83:0x01aa), top: B:276:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01b1 A[Catch: all -> 0x0297, SQLiteException -> 0x029e, TRY_ENTER, TryCatch #5 {SQLiteException -> 0x029e, blocks: (B:79:0x019e, B:81:0x01a4, B:85:0x01b1, B:86:0x01b7, B:87:0x01bb), top: B:269:0x019e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:207:0x044d, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x05b3: MOVE (r9 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]), block:B:255:0x05b3 */
    final void zzX() {
        boolean z;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursorRawQuery;
        String string;
        zzh zzhVarZzj;
        int iZze;
        int iMax;
        zzam zzamVar;
        boolean z2;
        boolean z3;
        Cursor cursor3;
        int i;
        Cursor cursor4;
        List listEmptyList;
        com.google.android.gms.internal.measurement.zzfz zzfzVarZza;
        int size;
        ArrayList arrayList;
        int i2;
        boolean zZzi;
        boolean zZzi2;
        boolean zZzs;
        int i3;
        String strZzm;
        zzku zzkuVar;
        String string2;
        String strZzi;
        com.google.android.gms.internal.measurement.zzgb zzgbVar;
        Iterator it;
        String strZzJ;
        int i4;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        com.google.android.gms.internal.measurement.zzgc zzgcVar2;
        Cursor cursorQuery;
        Cursor cursor5;
        ArrayList arrayList2;
        int length;
        long j;
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        int i5;
        byte[] byteArray;
        com.google.android.gms.internal.measurement.zzgb zzgbVar2;
        Cursor cursorRawQuery2;
        zzaz().zzg();
        zzB();
        int i6 = 1;
        this.zzv = true;
        int i7 = 0;
        try {
            this.zzn.zzaw();
            Boolean boolZzj = this.zzn.zzt().zzj();
            try {
                if (boolZzj == null) {
                    zzay().zzk().zza("Upload data called on the client side before use of service was decided");
                    this.zzv = false;
                } else if (boolZzj.booleanValue()) {
                    zzay().zzd().zza("Upload called in the client side when service should be used");
                    this.zzv = false;
                } else if (this.zza > 0) {
                    zzag();
                    this.zzv = false;
                } else {
                    zzaz().zzg();
                    if (this.zzy != null) {
                        zzay().zzj().zza("Uploading requested multiple times");
                        this.zzv = false;
                    } else {
                        zzfa zzfaVar = this.zzd;
                        zzal(zzfaVar);
                        if (zzfaVar.zza()) {
                            long jCurrentTimeMillis = zzav().currentTimeMillis();
                            Cursor cursor6 = null;
                            int iZze2 = zzg().zze(null, zzeh.zzP);
                            zzg();
                            long jZzz = jCurrentTimeMillis - zzag.zzz();
                            for (int i8 = 0; i8 < iZze2 && zzah(null, jZzz); i8++) {
                            }
                            long jZza = this.zzk.zzc.zza();
                            if (jZza != 0) {
                                zzay().zzc().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(jCurrentTimeMillis - jZza)));
                            }
                            zzam zzamVar2 = this.zze;
                            zzal(zzamVar2);
                            String strZzr = zzamVar2.zzr();
                            long j2 = -1;
                            if (TextUtils.isEmpty(strZzr)) {
                                try {
                                    this.zzA = -1L;
                                    zzam zzamVar3 = this.zze;
                                    zzal(zzamVar3);
                                    zzg();
                                    long jZzz2 = jCurrentTimeMillis - zzag.zzz();
                                    zzamVar3.zzg();
                                    zzamVar3.zzW();
                                    try {
                                        cursorRawQuery = zzamVar3.zzh().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(jZzz2)});
                                        try {
                                            if (cursorRawQuery.moveToFirst()) {
                                                string = cursorRawQuery.getString(0);
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                            } else {
                                                zzamVar3.zzs.zzay().zzj().zza("No expired configs for apps with pending events");
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                                string = null;
                                            }
                                        } catch (SQLiteException e) {
                                            e = e;
                                            zzamVar3.zzs.zzay().zzd().zzb("Error selecting expired configs", e);
                                            if (cursorRawQuery != null) {
                                            }
                                            string = null;
                                            if (!TextUtils.isEmpty(string)) {
                                                zzam zzamVar4 = this.zze;
                                                zzal(zzamVar4);
                                                zzhVarZzj = zzamVar4.zzj(string);
                                                if (zzhVarZzj != null) {
                                                    zzD(zzhVarZzj);
                                                }
                                            }
                                            this.zzv = false;
                                            zzae();
                                        }
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        cursorRawQuery = null;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = null;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        throw th;
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                        zzam zzamVar5 = this.zze;
                                        zzal(zzamVar5);
                                        zzhVarZzj = zzamVar5.zzj(string);
                                        if (zzhVarZzj != null) {
                                            zzD(zzhVarZzj);
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                }
                            } else {
                                if (this.zzA == -1) {
                                    zzam zzamVar6 = this.zze;
                                    zzal(zzamVar6);
                                    try {
                                        cursorRawQuery2 = zzamVar6.zzh().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                        try {
                                            try {
                                                if (cursorRawQuery2.moveToFirst()) {
                                                    j2 = cursorRawQuery2.getLong(0);
                                                    if (cursorRawQuery2 != null) {
                                                        cursorRawQuery2.close();
                                                    }
                                                } else if (cursorRawQuery2 != null) {
                                                    cursorRawQuery2.close();
                                                }
                                            } catch (SQLiteException e3) {
                                                e = e3;
                                                zzamVar6.zzs.zzay().zzd().zzb("Error querying raw events", e);
                                                if (cursorRawQuery2 != null) {
                                                }
                                                this.zzA = j2;
                                                iZze = zzg().zze(strZzr, zzeh.zzf);
                                                iMax = Math.max(0, zzg().zze(strZzr, zzeh.zzg));
                                                zzamVar = this.zze;
                                                zzal(zzamVar);
                                                zzamVar.zzg();
                                                zzamVar.zzW();
                                                if (iZze > 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                Preconditions.checkArgument(z2);
                                                if (iMax > 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                Preconditions.checkArgument(z3);
                                                Preconditions.checkNotEmpty(strZzr);
                                                cursorQuery = zzamVar.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze));
                                                try {
                                                    try {
                                                        if (cursorQuery.moveToFirst()) {
                                                            arrayList2 = new ArrayList();
                                                            length = 0;
                                                            while (true) {
                                                                j = cursorQuery.getLong(i7);
                                                                try {
                                                                    byte[] blob = cursorQuery.getBlob(i6);
                                                                    i = i6;
                                                                    try {
                                                                        try {
                                                                            zzlh zzlhVar = zzamVar.zzf.zzi;
                                                                            zzal(zzlhVar);
                                                                            try {
                                                                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
                                                                                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                                                                byteArrayOutputStream = new ByteArrayOutputStream();
                                                                                bArr = new byte[1024];
                                                                                while (true) {
                                                                                    i5 = gZIPInputStream.read(bArr);
                                                                                    if (i5 <= 0) {
                                                                                        break;
                                                                                    }
                                                                                    cursor5 = cursorQuery;
                                                                                    try {
                                                                                        byteArrayOutputStream.write(bArr, 0, i5);
                                                                                        cursorQuery = cursor5;
                                                                                    } catch (IOException e4) {
                                                                                        e = e4;
                                                                                    }
                                                                                }
                                                                                gZIPInputStream.close();
                                                                                byteArrayInputStream.close();
                                                                                byteArray = byteArrayOutputStream.toByteArray();
                                                                                if (arrayList2.isEmpty()) {
                                                                                }
                                                                                try {
                                                                                    zzgbVar2 = (com.google.android.gms.internal.measurement.zzgb) zzlh.zzl(com.google.android.gms.internal.measurement.zzgc.zzt(), byteArray);
                                                                                    if (!cursorQuery.isNull(2)) {
                                                                                        zzgbVar2.zzaf(cursorQuery.getInt(2));
                                                                                    }
                                                                                    length += byteArray.length;
                                                                                    arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzgc) zzgbVar2.zzaE(), Long.valueOf(j)));
                                                                                } catch (IOException e5) {
                                                                                    zzamVar.zzs.zzay().zzd().zzc("Failed to merge queued bundle. appId", zzeu.zzn(strZzr), e5);
                                                                                }
                                                                                cursor5 = cursorQuery;
                                                                            } catch (IOException e6) {
                                                                                e = e6;
                                                                                cursor5 = cursorQuery;
                                                                            }
                                                                        } catch (SQLiteException e7) {
                                                                            e = e7;
                                                                            cursor5 = cursorQuery;
                                                                            cursor4 = cursor5;
                                                                            try {
                                                                                zzamVar.zzs.zzay().zzd().zzc("Error querying bundles. appId", zzeu.zzn(strZzr), e);
                                                                                listEmptyList = Collections.emptyList();
                                                                                if (cursor4 != null) {
                                                                                    cursor4.close();
                                                                                }
                                                                                if (!listEmptyList.isEmpty()) {
                                                                                    if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                                                                        it = listEmptyList.iterator();
                                                                                        while (true) {
                                                                                            if (!it.hasNext()) {
                                                                                                strZzJ = null;
                                                                                                break;
                                                                                            }
                                                                                            zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) ((Pair) it.next()).first;
                                                                                            if (!zzgcVar2.zzJ().isEmpty()) {
                                                                                                strZzJ = zzgcVar2.zzJ();
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        if (strZzJ != null) {
                                                                                            for (i4 = 0; i4 < listEmptyList.size(); i4++) {
                                                                                                zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i4)).first;
                                                                                                if (zzgcVar.zzJ().isEmpty()) {
                                                                                                    listEmptyList = listEmptyList.subList(0, i4);
                                                                                                    break;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    zzfzVarZza = com.google.android.gms.internal.measurement.zzga.zza();
                                                                                    size = listEmptyList.size();
                                                                                    arrayList = new ArrayList(listEmptyList.size());
                                                                                    if (zzg().zzt(strZzr)) {
                                                                                        i2 = 0;
                                                                                    } else {
                                                                                        i2 = 0;
                                                                                    }
                                                                                    zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                                                                    zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                                                    zzpi.zzc();
                                                                                    zZzs = zzg().zzs(null, zzeh.zzay);
                                                                                    for (i3 = 0; i3 < size; i3++) {
                                                                                        zzgbVar = (com.google.android.gms.internal.measurement.zzgb) ((com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i3)).first).zzby();
                                                                                        arrayList.add((Long) ((Pair) listEmptyList.get(i3)).second);
                                                                                        zzg().zzh();
                                                                                        zzgbVar.zzal(68000L);
                                                                                        zzgbVar.zzak(jCurrentTimeMillis);
                                                                                        this.zzn.zzaw();
                                                                                        zzgbVar.zzag(false);
                                                                                        if (i2 == 0) {
                                                                                            zzgbVar.zzq();
                                                                                        }
                                                                                        if (!zZzi) {
                                                                                            zzgbVar.zzx();
                                                                                            zzgbVar.zzt();
                                                                                        }
                                                                                        if (!zZzi2) {
                                                                                            zzgbVar.zzn();
                                                                                        }
                                                                                        zzC(strZzr, zzgbVar);
                                                                                        if (!zZzs) {
                                                                                            zzgbVar.zzy();
                                                                                        }
                                                                                        if (zzg().zzs(strZzr, zzeh.zzT)) {
                                                                                            byte[] bArrZzbv = ((com.google.android.gms.internal.measurement.zzgc) zzgbVar.zzaE()).zzbv();
                                                                                            zzlh zzlhVar2 = this.zzi;
                                                                                            zzal(zzlhVar2);
                                                                                            zzgbVar.zzJ(zzlhVar2.zzd(bArrZzbv));
                                                                                        }
                                                                                        zzfzVarZza.zza(zzgbVar);
                                                                                    }
                                                                                    if (Log.isLoggable(zzay().zzq(), 2)) {
                                                                                        zzlh zzlhVar3 = this.zzi;
                                                                                        zzal(zzlhVar3);
                                                                                        strZzm = zzlhVar3.zzm((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE());
                                                                                    } else {
                                                                                        strZzm = null;
                                                                                    }
                                                                                    zzal(this.zzi);
                                                                                    byte[] bArrZzbv2 = ((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE()).zzbv();
                                                                                    zzkuVar = this.zzl;
                                                                                    zzpc.zzc();
                                                                                    if (zzkuVar.zzs.zzf().zzs(strZzr, zzeh.zzau)) {
                                                                                        zzfv zzfvVar = zzkuVar.zzf.zzc;
                                                                                        zzal(zzfvVar);
                                                                                        strZzi = zzfvVar.zzi(strZzr);
                                                                                        if (TextUtils.isEmpty(strZzi)) {
                                                                                            string2 = (String) zzeh.zzp.zza(null);
                                                                                        } else {
                                                                                            Uri uri = Uri.parse((String) zzeh.zzp.zza(null));
                                                                                            Uri.Builder builderBuildUpon = uri.buildUpon();
                                                                                            builderBuildUpon.authority(strZzi + "." + uri.getAuthority());
                                                                                            string2 = builderBuildUpon.build().toString();
                                                                                        }
                                                                                    } else {
                                                                                        string2 = (String) zzeh.zzp.zza(null);
                                                                                    }
                                                                                    try {
                                                                                        URL url = new URL(string2);
                                                                                        Preconditions.checkArgument(!arrayList.isEmpty());
                                                                                        if (this.zzy != null) {
                                                                                            zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                                                        } else {
                                                                                            this.zzy = new ArrayList(arrayList);
                                                                                        }
                                                                                        this.zzk.zzd.zzb(jCurrentTimeMillis);
                                                                                        zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfzVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbv2.length), strZzm);
                                                                                        this.zzu = i;
                                                                                        zzfa zzfaVar2 = this.zzd;
                                                                                        zzal(zzfaVar2);
                                                                                        zzkw zzkwVar = new zzkw(this, strZzr);
                                                                                        zzfaVar2.zzg();
                                                                                        zzfaVar2.zzW();
                                                                                        Preconditions.checkNotNull(url);
                                                                                        Preconditions.checkNotNull(bArrZzbv2);
                                                                                        Preconditions.checkNotNull(zzkwVar);
                                                                                        zzfaVar2.zzs.zzaz().zzo(new zzez(zzfaVar2, strZzr, url, bArrZzbv2, null, zzkwVar));
                                                                                    } catch (MalformedURLException unused) {
                                                                                        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", zzeu.zzn(strZzr), string2);
                                                                                    }
                                                                                }
                                                                                this.zzv = false;
                                                                                zzae();
                                                                            } catch (Throwable th3) {
                                                                                th = th3;
                                                                                cursor3 = cursor4;
                                                                                if (cursor3 != null) {
                                                                                    cursor3.close();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                        }
                                                                    } catch (IOException e8) {
                                                                        e = e8;
                                                                        cursor5 = cursorQuery;
                                                                        zzamVar.zzs.zzay().zzd().zzc("Failed to unzip queued bundle. appId", zzeu.zzn(strZzr), e);
                                                                        if (cursor5.moveToNext()) {
                                                                            break;
                                                                        } else {
                                                                            break;
                                                                        }
                                                                        if (cursor5 != null) {
                                                                            cursor5.close();
                                                                        }
                                                                        listEmptyList = arrayList2;
                                                                        if (!listEmptyList.isEmpty()) {
                                                                            if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                                                                it = listEmptyList.iterator();
                                                                                while (true) {
                                                                                    if (!it.hasNext()) {
                                                                                        strZzJ = null;
                                                                                        break;
                                                                                    }
                                                                                    zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) ((Pair) it.next()).first;
                                                                                    if (!zzgcVar2.zzJ().isEmpty()) {
                                                                                        strZzJ = zzgcVar2.zzJ();
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                if (strZzJ != null) {
                                                                                    while (i4 < listEmptyList.size()) {
                                                                                        zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i4)).first;
                                                                                        if (zzgcVar.zzJ().isEmpty()) {
                                                                                            listEmptyList = listEmptyList.subList(0, i4);
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            zzfzVarZza = com.google.android.gms.internal.measurement.zzga.zza();
                                                                            size = listEmptyList.size();
                                                                            arrayList = new ArrayList(listEmptyList.size());
                                                                            if (zzg().zzt(strZzr)) {
                                                                                i2 = 0;
                                                                            } else {
                                                                                i2 = 0;
                                                                            }
                                                                            zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                                                            zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                                            zzpi.zzc();
                                                                            zZzs = zzg().zzs(null, zzeh.zzay);
                                                                            while (i3 < size) {
                                                                                zzgbVar = (com.google.android.gms.internal.measurement.zzgb) ((com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i3)).first).zzby();
                                                                                arrayList.add((Long) ((Pair) listEmptyList.get(i3)).second);
                                                                                zzg().zzh();
                                                                                zzgbVar.zzal(68000L);
                                                                                zzgbVar.zzak(jCurrentTimeMillis);
                                                                                this.zzn.zzaw();
                                                                                zzgbVar.zzag(false);
                                                                                if (i2 == 0) {
                                                                                    zzgbVar.zzq();
                                                                                }
                                                                                if (!zZzi) {
                                                                                    zzgbVar.zzx();
                                                                                    zzgbVar.zzt();
                                                                                }
                                                                                if (!zZzi2) {
                                                                                    zzgbVar.zzn();
                                                                                }
                                                                                zzC(strZzr, zzgbVar);
                                                                                if (!zZzs) {
                                                                                    zzgbVar.zzy();
                                                                                }
                                                                                if (zzg().zzs(strZzr, zzeh.zzT)) {
                                                                                    byte[] bArrZzbv3 = ((com.google.android.gms.internal.measurement.zzgc) zzgbVar.zzaE()).zzbv();
                                                                                    zzlh zzlhVar4 = this.zzi;
                                                                                    zzal(zzlhVar4);
                                                                                    zzgbVar.zzJ(zzlhVar4.zzd(bArrZzbv3));
                                                                                }
                                                                                zzfzVarZza.zza(zzgbVar);
                                                                            }
                                                                            if (Log.isLoggable(zzay().zzq(), 2)) {
                                                                                zzlh zzlhVar5 = this.zzi;
                                                                                zzal(zzlhVar5);
                                                                                strZzm = zzlhVar5.zzm((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE());
                                                                            } else {
                                                                                strZzm = null;
                                                                            }
                                                                            zzal(this.zzi);
                                                                            byte[] bArrZzbv4 = ((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE()).zzbv();
                                                                            zzkuVar = this.zzl;
                                                                            zzpc.zzc();
                                                                            if (zzkuVar.zzs.zzf().zzs(strZzr, zzeh.zzau)) {
                                                                                zzfv zzfvVar2 = zzkuVar.zzf.zzc;
                                                                                zzal(zzfvVar2);
                                                                                strZzi = zzfvVar2.zzi(strZzr);
                                                                                if (TextUtils.isEmpty(strZzi)) {
                                                                                    Uri uri2 = Uri.parse((String) zzeh.zzp.zza(null));
                                                                                    Uri.Builder builderBuildUpon2 = uri2.buildUpon();
                                                                                    builderBuildUpon2.authority(strZzi + "." + uri2.getAuthority());
                                                                                    string2 = builderBuildUpon2.build().toString();
                                                                                } else {
                                                                                    string2 = (String) zzeh.zzp.zza(null);
                                                                                }
                                                                            } else {
                                                                                string2 = (String) zzeh.zzp.zza(null);
                                                                            }
                                                                            URL url2 = new URL(string2);
                                                                            Preconditions.checkArgument(!arrayList.isEmpty());
                                                                            if (this.zzy != null) {
                                                                                zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                                            } else {
                                                                                this.zzy = new ArrayList(arrayList);
                                                                            }
                                                                            this.zzk.zzd.zzb(jCurrentTimeMillis);
                                                                            zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfzVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbv4.length), strZzm);
                                                                            this.zzu = i;
                                                                            zzfa zzfaVar3 = this.zzd;
                                                                            zzal(zzfaVar3);
                                                                            zzkw zzkwVar2 = new zzkw(this, strZzr);
                                                                            zzfaVar3.zzg();
                                                                            zzfaVar3.zzW();
                                                                            Preconditions.checkNotNull(url2);
                                                                            Preconditions.checkNotNull(bArrZzbv4);
                                                                            Preconditions.checkNotNull(zzkwVar2);
                                                                            zzfaVar3.zzs.zzaz().zzo(new zzez(zzfaVar3, strZzr, url2, bArrZzbv4, null, zzkwVar2));
                                                                        }
                                                                        this.zzv = false;
                                                                        zzae();
                                                                    }
                                                                } catch (IOException e9) {
                                                                    e = e9;
                                                                    i = i6;
                                                                }
                                                                try {
                                                                    if (cursor5.moveToNext()) {
                                                                        break;
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    i6 = i;
                                                                    cursorQuery = cursor5;
                                                                    i7 = 0;
                                                                } catch (SQLiteException e10) {
                                                                    e = e10;
                                                                    cursor4 = cursor5;
                                                                    zzamVar.zzs.zzay().zzd().zzc("Error querying bundles. appId", zzeu.zzn(strZzr), e);
                                                                    listEmptyList = Collections.emptyList();
                                                                    if (cursor4 != null) {
                                                                        cursor4.close();
                                                                    }
                                                                } catch (Throwable th4) {
                                                                    th = th4;
                                                                    cursor3 = cursor5;
                                                                    if (cursor3 != null) {
                                                                        cursor3.close();
                                                                    }
                                                                    throw th;
                                                                }
                                                            }
                                                            if (cursor5 != null) {
                                                                cursor5.close();
                                                            }
                                                            listEmptyList = arrayList2;
                                                        } else {
                                                            listEmptyList = Collections.emptyList();
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                            i = 1;
                                                        }
                                                    } catch (SQLiteException e11) {
                                                        e = e11;
                                                        i = 1;
                                                    }
                                                    if (!listEmptyList.isEmpty()) {
                                                        if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                                            it = listEmptyList.iterator();
                                                            while (true) {
                                                                if (!it.hasNext()) {
                                                                    strZzJ = null;
                                                                    break;
                                                                }
                                                                zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) ((Pair) it.next()).first;
                                                                if (!zzgcVar2.zzJ().isEmpty()) {
                                                                    strZzJ = zzgcVar2.zzJ();
                                                                    break;
                                                                }
                                                            }
                                                            if (strZzJ != null) {
                                                                while (i4 < listEmptyList.size()) {
                                                                    zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i4)).first;
                                                                    if (zzgcVar.zzJ().isEmpty()) {
                                                                        listEmptyList = listEmptyList.subList(0, i4);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        zzfzVarZza = com.google.android.gms.internal.measurement.zzga.zza();
                                                        size = listEmptyList.size();
                                                        arrayList = new ArrayList(listEmptyList.size());
                                                        if (zzg().zzt(strZzr)) {
                                                            i2 = 0;
                                                        } else {
                                                            i2 = 0;
                                                        }
                                                        zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                                        zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                        zzpi.zzc();
                                                        zZzs = zzg().zzs(null, zzeh.zzay);
                                                        while (i3 < size) {
                                                            zzgbVar = (com.google.android.gms.internal.measurement.zzgb) ((com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i3)).first).zzby();
                                                            arrayList.add((Long) ((Pair) listEmptyList.get(i3)).second);
                                                            zzg().zzh();
                                                            zzgbVar.zzal(68000L);
                                                            zzgbVar.zzak(jCurrentTimeMillis);
                                                            this.zzn.zzaw();
                                                            zzgbVar.zzag(false);
                                                            if (i2 == 0) {
                                                                zzgbVar.zzq();
                                                            }
                                                            if (!zZzi) {
                                                                zzgbVar.zzx();
                                                                zzgbVar.zzt();
                                                            }
                                                            if (!zZzi2) {
                                                                zzgbVar.zzn();
                                                            }
                                                            zzC(strZzr, zzgbVar);
                                                            if (!zZzs) {
                                                                zzgbVar.zzy();
                                                            }
                                                            if (zzg().zzs(strZzr, zzeh.zzT)) {
                                                                byte[] bArrZzbv5 = ((com.google.android.gms.internal.measurement.zzgc) zzgbVar.zzaE()).zzbv();
                                                                zzlh zzlhVar6 = this.zzi;
                                                                zzal(zzlhVar6);
                                                                zzgbVar.zzJ(zzlhVar6.zzd(bArrZzbv5));
                                                            }
                                                            zzfzVarZza.zza(zzgbVar);
                                                        }
                                                        if (Log.isLoggable(zzay().zzq(), 2)) {
                                                            zzlh zzlhVar7 = this.zzi;
                                                            zzal(zzlhVar7);
                                                            strZzm = zzlhVar7.zzm((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE());
                                                        } else {
                                                            strZzm = null;
                                                        }
                                                        zzal(this.zzi);
                                                        byte[] bArrZzbv6 = ((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE()).zzbv();
                                                        zzkuVar = this.zzl;
                                                        zzpc.zzc();
                                                        if (zzkuVar.zzs.zzf().zzs(strZzr, zzeh.zzau)) {
                                                            zzfv zzfvVar3 = zzkuVar.zzf.zzc;
                                                            zzal(zzfvVar3);
                                                            strZzi = zzfvVar3.zzi(strZzr);
                                                            if (TextUtils.isEmpty(strZzi)) {
                                                                Uri uri3 = Uri.parse((String) zzeh.zzp.zza(null));
                                                                Uri.Builder builderBuildUpon3 = uri3.buildUpon();
                                                                builderBuildUpon3.authority(strZzi + "." + uri3.getAuthority());
                                                                string2 = builderBuildUpon3.build().toString();
                                                            } else {
                                                                string2 = (String) zzeh.zzp.zza(null);
                                                            }
                                                        } else {
                                                            string2 = (String) zzeh.zzp.zza(null);
                                                        }
                                                        URL url3 = new URL(string2);
                                                        Preconditions.checkArgument(!arrayList.isEmpty());
                                                        if (this.zzy != null) {
                                                            zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                        } else {
                                                            this.zzy = new ArrayList(arrayList);
                                                        }
                                                        this.zzk.zzd.zzb(jCurrentTimeMillis);
                                                        zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfzVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbv6.length), strZzm);
                                                        this.zzu = i;
                                                        zzfa zzfaVar4 = this.zzd;
                                                        zzal(zzfaVar4);
                                                        zzkw zzkwVar3 = new zzkw(this, strZzr);
                                                        zzfaVar4.zzg();
                                                        zzfaVar4.zzW();
                                                        Preconditions.checkNotNull(url3);
                                                        Preconditions.checkNotNull(bArrZzbv6);
                                                        Preconditions.checkNotNull(zzkwVar3);
                                                        zzfaVar4.zzs.zzaz().zzo(new zzez(zzfaVar4, strZzr, url3, bArrZzbv6, null, zzkwVar3));
                                                    }
                                                    this.zzv = false;
                                                    zzae();
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    cursor5 = cursorQuery;
                                                }
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            cursor6 = cursorRawQuery2;
                                            if (cursor6 != null) {
                                                cursor6.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        cursorRawQuery2 = null;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        if (cursor6 != null) {
                                            cursor6.close();
                                        }
                                        throw th;
                                    }
                                    this.zzA = j2;
                                }
                                iZze = zzg().zze(strZzr, zzeh.zzf);
                                iMax = Math.max(0, zzg().zze(strZzr, zzeh.zzg));
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                if (iZze > 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                Preconditions.checkArgument(z2);
                                if (iMax > 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                Preconditions.checkArgument(z3);
                                Preconditions.checkNotEmpty(strZzr);
                                try {
                                    cursorQuery = zzamVar.zzh().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{strZzr}, null, null, "rowid", String.valueOf(iZze));
                                    if (cursorQuery.moveToFirst()) {
                                        listEmptyList = Collections.emptyList();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        i = 1;
                                    } else {
                                        arrayList2 = new ArrayList();
                                        length = 0;
                                        while (true) {
                                            j = cursorQuery.getLong(i7);
                                            byte[] blob2 = cursorQuery.getBlob(i6);
                                            i = i6;
                                            zzlh zzlhVar8 = zzamVar.zzf.zzi;
                                            zzal(zzlhVar8);
                                            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(blob2);
                                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream2);
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            bArr = new byte[1024];
                                            while (true) {
                                                i5 = gZIPInputStream.read(bArr);
                                                if (i5 <= 0) {
                                                    break;
                                                    break;
                                                } else {
                                                    cursor5 = cursorQuery;
                                                    byteArrayOutputStream.write(bArr, 0, i5);
                                                    cursorQuery = cursor5;
                                                }
                                                try {
                                                    zzlhVar8.zzs.zzay().zzd().zzb("Failed to ungzip content", e);
                                                    throw e;
                                                } catch (IOException e13) {
                                                    e = e13;
                                                    zzamVar.zzs.zzay().zzd().zzc("Failed to unzip queued bundle. appId", zzeu.zzn(strZzr), e);
                                                    if (cursor5.moveToNext()) {
                                                        break;
                                                        break;
                                                    } else {
                                                        break;
                                                        break;
                                                    }
                                                    if (cursor5 != null) {
                                                        cursor5.close();
                                                    }
                                                    listEmptyList = arrayList2;
                                                    if (!listEmptyList.isEmpty()) {
                                                        if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                                            it = listEmptyList.iterator();
                                                            while (true) {
                                                                if (!it.hasNext()) {
                                                                    strZzJ = null;
                                                                    break;
                                                                }
                                                                zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) ((Pair) it.next()).first;
                                                                if (!zzgcVar2.zzJ().isEmpty()) {
                                                                    strZzJ = zzgcVar2.zzJ();
                                                                    break;
                                                                }
                                                            }
                                                            if (strZzJ != null) {
                                                                while (i4 < listEmptyList.size()) {
                                                                    zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i4)).first;
                                                                    if (zzgcVar.zzJ().isEmpty()) {
                                                                        listEmptyList = listEmptyList.subList(0, i4);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        zzfzVarZza = com.google.android.gms.internal.measurement.zzga.zza();
                                                        size = listEmptyList.size();
                                                        arrayList = new ArrayList(listEmptyList.size());
                                                        if (zzg().zzt(strZzr)) {
                                                            i2 = 0;
                                                        } else {
                                                            i2 = 0;
                                                        }
                                                        zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                                        zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                                        zzpi.zzc();
                                                        zZzs = zzg().zzs(null, zzeh.zzay);
                                                        while (i3 < size) {
                                                            zzgbVar = (com.google.android.gms.internal.measurement.zzgb) ((com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i3)).first).zzby();
                                                            arrayList.add((Long) ((Pair) listEmptyList.get(i3)).second);
                                                            zzg().zzh();
                                                            zzgbVar.zzal(68000L);
                                                            zzgbVar.zzak(jCurrentTimeMillis);
                                                            this.zzn.zzaw();
                                                            zzgbVar.zzag(false);
                                                            if (i2 == 0) {
                                                                zzgbVar.zzq();
                                                            }
                                                            if (!zZzi) {
                                                                zzgbVar.zzx();
                                                                zzgbVar.zzt();
                                                            }
                                                            if (!zZzi2) {
                                                                zzgbVar.zzn();
                                                            }
                                                            zzC(strZzr, zzgbVar);
                                                            if (!zZzs) {
                                                                zzgbVar.zzy();
                                                            }
                                                            if (zzg().zzs(strZzr, zzeh.zzT)) {
                                                                byte[] bArrZzbv7 = ((com.google.android.gms.internal.measurement.zzgc) zzgbVar.zzaE()).zzbv();
                                                                zzlh zzlhVar9 = this.zzi;
                                                                zzal(zzlhVar9);
                                                                zzgbVar.zzJ(zzlhVar9.zzd(bArrZzbv7));
                                                            }
                                                            zzfzVarZza.zza(zzgbVar);
                                                        }
                                                        if (Log.isLoggable(zzay().zzq(), 2)) {
                                                            zzlh zzlhVar10 = this.zzi;
                                                            zzal(zzlhVar10);
                                                            strZzm = zzlhVar10.zzm((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE());
                                                        } else {
                                                            strZzm = null;
                                                        }
                                                        zzal(this.zzi);
                                                        byte[] bArrZzbv8 = ((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE()).zzbv();
                                                        zzkuVar = this.zzl;
                                                        zzpc.zzc();
                                                        if (zzkuVar.zzs.zzf().zzs(strZzr, zzeh.zzau)) {
                                                            zzfv zzfvVar4 = zzkuVar.zzf.zzc;
                                                            zzal(zzfvVar4);
                                                            strZzi = zzfvVar4.zzi(strZzr);
                                                            if (TextUtils.isEmpty(strZzi)) {
                                                                Uri uri4 = Uri.parse((String) zzeh.zzp.zza(null));
                                                                Uri.Builder builderBuildUpon4 = uri4.buildUpon();
                                                                builderBuildUpon4.authority(strZzi + "." + uri4.getAuthority());
                                                                string2 = builderBuildUpon4.build().toString();
                                                            } else {
                                                                string2 = (String) zzeh.zzp.zza(null);
                                                            }
                                                        } else {
                                                            string2 = (String) zzeh.zzp.zza(null);
                                                        }
                                                        URL url4 = new URL(string2);
                                                        Preconditions.checkArgument(!arrayList.isEmpty());
                                                        if (this.zzy != null) {
                                                            zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                                        } else {
                                                            this.zzy = new ArrayList(arrayList);
                                                        }
                                                        this.zzk.zzd.zzb(jCurrentTimeMillis);
                                                        zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfzVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbv8.length), strZzm);
                                                        this.zzu = i;
                                                        zzfa zzfaVar5 = this.zzd;
                                                        zzal(zzfaVar5);
                                                        zzkw zzkwVar4 = new zzkw(this, strZzr);
                                                        zzfaVar5.zzg();
                                                        zzfaVar5.zzW();
                                                        Preconditions.checkNotNull(url4);
                                                        Preconditions.checkNotNull(bArrZzbv8);
                                                        Preconditions.checkNotNull(zzkwVar4);
                                                        zzfaVar5.zzs.zzaz().zzo(new zzez(zzfaVar5, strZzr, url4, bArrZzbv8, null, zzkwVar4));
                                                    }
                                                    this.zzv = false;
                                                    zzae();
                                                }
                                            }
                                            gZIPInputStream.close();
                                            byteArrayInputStream2.close();
                                            byteArray = byteArrayOutputStream.toByteArray();
                                            if (arrayList2.isEmpty() && byteArray.length + length > iMax) {
                                                cursor5 = cursorQuery;
                                                break;
                                            }
                                            zzgbVar2 = (com.google.android.gms.internal.measurement.zzgb) zzlh.zzl(com.google.android.gms.internal.measurement.zzgc.zzt(), byteArray);
                                            if (!cursorQuery.isNull(2)) {
                                                zzgbVar2.zzaf(cursorQuery.getInt(2));
                                            }
                                            length += byteArray.length;
                                            arrayList2.add(Pair.create((com.google.android.gms.internal.measurement.zzgc) zzgbVar2.zzaE(), Long.valueOf(j)));
                                            cursor5 = cursorQuery;
                                            if (cursor5.moveToNext() || length > iMax) {
                                                break;
                                                break;
                                            } else {
                                                i6 = i;
                                                cursorQuery = cursor5;
                                                i7 = 0;
                                            }
                                        }
                                        if (cursor5 != null) {
                                            cursor5.close();
                                        }
                                        listEmptyList = arrayList2;
                                    }
                                } catch (SQLiteException e14) {
                                    e = e14;
                                    i = 1;
                                    cursor4 = null;
                                } catch (Throwable th8) {
                                    th = th8;
                                    cursor3 = null;
                                }
                                if (!listEmptyList.isEmpty()) {
                                    if (zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                        it = listEmptyList.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                strZzJ = null;
                                                break;
                                            }
                                            zzgcVar2 = (com.google.android.gms.internal.measurement.zzgc) ((Pair) it.next()).first;
                                            if (!zzgcVar2.zzJ().isEmpty()) {
                                                strZzJ = zzgcVar2.zzJ();
                                                break;
                                            }
                                        }
                                        if (strZzJ != null) {
                                            while (i4 < listEmptyList.size()) {
                                                zzgcVar = (com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i4)).first;
                                                if (zzgcVar.zzJ().isEmpty() && !zzgcVar.zzJ().equals(strZzJ)) {
                                                    listEmptyList = listEmptyList.subList(0, i4);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    zzfzVarZza = com.google.android.gms.internal.measurement.zzga.zza();
                                    size = listEmptyList.size();
                                    arrayList = new ArrayList(listEmptyList.size());
                                    if (zzg().zzt(strZzr) || !zzh(strZzr).zzi(zzah.AD_STORAGE)) {
                                        i2 = 0;
                                    } else {
                                        i2 = i;
                                    }
                                    zZzi = zzh(strZzr).zzi(zzah.AD_STORAGE);
                                    zZzi2 = zzh(strZzr).zzi(zzah.ANALYTICS_STORAGE);
                                    zzpi.zzc();
                                    zZzs = zzg().zzs(null, zzeh.zzay);
                                    while (i3 < size) {
                                        zzgbVar = (com.google.android.gms.internal.measurement.zzgb) ((com.google.android.gms.internal.measurement.zzgc) ((Pair) listEmptyList.get(i3)).first).zzby();
                                        arrayList.add((Long) ((Pair) listEmptyList.get(i3)).second);
                                        zzg().zzh();
                                        zzgbVar.zzal(68000L);
                                        zzgbVar.zzak(jCurrentTimeMillis);
                                        this.zzn.zzaw();
                                        zzgbVar.zzag(false);
                                        if (i2 == 0) {
                                            zzgbVar.zzq();
                                        }
                                        if (!zZzi) {
                                            zzgbVar.zzx();
                                            zzgbVar.zzt();
                                        }
                                        if (!zZzi2) {
                                            zzgbVar.zzn();
                                        }
                                        zzC(strZzr, zzgbVar);
                                        if (!zZzs) {
                                            zzgbVar.zzy();
                                        }
                                        if (zzg().zzs(strZzr, zzeh.zzT)) {
                                            byte[] bArrZzbv9 = ((com.google.android.gms.internal.measurement.zzgc) zzgbVar.zzaE()).zzbv();
                                            zzlh zzlhVar11 = this.zzi;
                                            zzal(zzlhVar11);
                                            zzgbVar.zzJ(zzlhVar11.zzd(bArrZzbv9));
                                        }
                                        zzfzVarZza.zza(zzgbVar);
                                    }
                                    if (Log.isLoggable(zzay().zzq(), 2)) {
                                        zzlh zzlhVar12 = this.zzi;
                                        zzal(zzlhVar12);
                                        strZzm = zzlhVar12.zzm((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE());
                                    } else {
                                        strZzm = null;
                                    }
                                    zzal(this.zzi);
                                    byte[] bArrZzbv10 = ((com.google.android.gms.internal.measurement.zzga) zzfzVarZza.zzaE()).zzbv();
                                    zzkuVar = this.zzl;
                                    zzpc.zzc();
                                    if (zzkuVar.zzs.zzf().zzs(strZzr, zzeh.zzau)) {
                                        zzfv zzfvVar5 = zzkuVar.zzf.zzc;
                                        zzal(zzfvVar5);
                                        strZzi = zzfvVar5.zzi(strZzr);
                                        if (TextUtils.isEmpty(strZzi)) {
                                            Uri uri5 = Uri.parse((String) zzeh.zzp.zza(null));
                                            Uri.Builder builderBuildUpon5 = uri5.buildUpon();
                                            builderBuildUpon5.authority(strZzi + "." + uri5.getAuthority());
                                            string2 = builderBuildUpon5.build().toString();
                                        } else {
                                            string2 = (String) zzeh.zzp.zza(null);
                                        }
                                    } else {
                                        string2 = (String) zzeh.zzp.zza(null);
                                    }
                                    URL url5 = new URL(string2);
                                    Preconditions.checkArgument(!arrayList.isEmpty());
                                    if (this.zzy != null) {
                                        zzay().zzd().zza("Set uploading progress before finishing the previous upload");
                                    } else {
                                        this.zzy = new ArrayList(arrayList);
                                    }
                                    this.zzk.zzd.zzb(jCurrentTimeMillis);
                                    zzay().zzj().zzd("Uploading data. app, uncompressed size, data", size > 0 ? zzfzVarZza.zzb(0).zzx() : "?", Integer.valueOf(bArrZzbv10.length), strZzm);
                                    this.zzu = i;
                                    zzfa zzfaVar6 = this.zzd;
                                    zzal(zzfaVar6);
                                    zzkw zzkwVar5 = new zzkw(this, strZzr);
                                    zzfaVar6.zzg();
                                    zzfaVar6.zzW();
                                    Preconditions.checkNotNull(url5);
                                    Preconditions.checkNotNull(bArrZzbv10);
                                    Preconditions.checkNotNull(zzkwVar5);
                                    zzfaVar6.zzs.zzaz().zzo(new zzez(zzfaVar6, strZzr, url5, bArrZzbv10, null, zzkwVar5));
                                }
                            }
                            this.zzv = false;
                        } else {
                            zzay().zzj().zza("Network not connected, ignoring upload request");
                            zzag();
                            this.zzv = false;
                        }
                    }
                }
                zzae();
            } catch (Throwable th9) {
                th = th9;
                z = false;
                this.zzv = z;
                zzae();
                throw th;
            }
        } catch (Throwable th10) {
            th = th10;
            z = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x016c A[Catch: all -> 0x0a63, TRY_ENTER, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0183 A[Catch: all -> 0x0a63, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0195  */
    /* JADX WARN: Code duplicated, block: B:61:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:65:0x01ed A[Catch: all -> 0x0a63, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01fd A[Catch: all -> 0x0a63, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0212 A[Catch: all -> 0x0a63, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0218  */
    /* JADX WARN: Code duplicated, block: B:72:0x0219 A[Catch: all -> 0x0a63, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0246 A[Catch: all -> 0x0a63, TRY_LEAVE, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02c4 A[Catch: all -> 0x0a63, TryCatch #3 {all -> 0x0a63, blocks: (B:28:0x0122, B:31:0x0134, B:33:0x013e, B:38:0x014a, B:88:0x02f8, B:97:0x032d, B:99:0x0363, B:101:0x0368, B:102:0x037f, B:106:0x0392, B:108:0x03ab, B:110:0x03b1, B:111:0x03c8, B:116:0x03ef, B:120:0x0410, B:121:0x0427, B:124:0x0438, B:127:0x0455, B:128:0x0469, B:130:0x0473, B:132:0x0480, B:134:0x0486, B:135:0x048f, B:136:0x049d, B:138:0x04b5, B:147:0x04ea, B:148:0x04ff, B:150:0x052d, B:153:0x0545, B:156:0x0586, B:158:0x05b4, B:160:0x05f2, B:161:0x05f7, B:163:0x05ff, B:164:0x0604, B:166:0x060c, B:167:0x0611, B:169:0x0621, B:171:0x0629, B:172:0x062e, B:174:0x0637, B:175:0x063b, B:177:0x0648, B:178:0x064d, B:180:0x0674, B:182:0x067c, B:183:0x0681, B:185:0x0687, B:186:0x068a, B:188:0x06a2, B:191:0x06aa, B:192:0x06c4, B:194:0x06ca, B:196:0x06e0, B:198:0x06ec, B:200:0x06f9, B:203:0x0712, B:205:0x0725, B:211:0x0731, B:212:0x0734, B:214:0x0752, B:216:0x075f, B:218:0x0763, B:220:0x0775, B:222:0x0779, B:224:0x0784, B:225:0x078f, B:227:0x07ce, B:229:0x07d8, B:230:0x07db, B:232:0x07e8, B:234:0x080a, B:235:0x0817, B:236:0x084d, B:238:0x0855, B:240:0x085f, B:241:0x086c, B:243:0x0876, B:244:0x0883, B:245:0x0890, B:247:0x0896, B:249:0x08c6, B:250:0x0909, B:251:0x0914, B:252:0x0920, B:254:0x0926, B:263:0x0972, B:264:0x09c0, B:266:0x09cf, B:278:0x0a30, B:269:0x09e7, B:271:0x09eb, B:257:0x0932, B:259:0x095c, B:274:0x0a02, B:275:0x0a19, B:277:0x0a1b, B:157:0x05a4, B:144:0x04d1, B:91:0x030e, B:92:0x0315, B:94:0x031b, B:96:0x0327, B:44:0x0160, B:47:0x016c, B:49:0x0183, B:55:0x01a5, B:63:0x01e7, B:65:0x01ed, B:67:0x01fd, B:69:0x0212, B:72:0x0219, B:84:0x02b9, B:86:0x02c4, B:73:0x0246, B:74:0x026b, B:76:0x0272, B:83:0x029e, B:82:0x028a, B:58:0x01b3, B:62:0x01dd), top: B:291:0x0122, inners: #1, #2, #4 }] */
    final void zzY(zzaw zzawVar, zzq zzqVar) {
        String strZzg;
        int i;
        long jLongValue;
        String upperCase;
        String strConcat;
        zzlk zzlkVarZzp;
        zzam zzamVar;
        zzlk zzlkVar;
        Object obj;
        zzam zzamVar2;
        Object obj2;
        double dDoubleValue;
        long length;
        int i2;
        long jDelete;
        int i3;
        zzar zzarVar;
        zzas zzasVar;
        com.google.android.gms.internal.measurement.zzgb zzgbVarZzt;
        ArrayList arrayList;
        zzam zzamVar3;
        com.google.android.gms.internal.measurement.zzgc zzgcVar;
        long jZzd;
        ContentValues contentValues;
        zzat zzatVar;
        int i4;
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        long jNanoTime = System.nanoTime();
        zzaz().zzg();
        zzB();
        String str = zzqVar.zza;
        zzal(this.zzi);
        if (!zzlh.zzA(zzawVar, zzqVar)) {
            return;
        }
        if (!zzqVar.zzh) {
            zzd(zzqVar);
            return;
        }
        zzfv zzfvVar = this.zzc;
        zzal(zzfvVar);
        String str2 = "_err";
        if (zzfvVar.zzr(str, zzawVar.zza)) {
            zzay().zzk().zzc("Dropping blocked event. appId", zzeu.zzn(str), this.zzn.zzj().zzd(zzawVar.zza));
            zzfv zzfvVar2 = this.zzc;
            zzal(zzfvVar2);
            if (!zzfvVar2.zzp(str)) {
                zzfv zzfvVar3 = this.zzc;
                zzal(zzfvVar3);
                if (!zzfvVar3.zzs(str)) {
                    if ("_err".equals(zzawVar.zza)) {
                        return;
                    }
                    zzv().zzN(this.zzF, str, 11, "_ev", zzawVar.zza, 0);
                    return;
                }
            }
            zzam zzamVar4 = this.zze;
            zzal(zzamVar4);
            zzh zzhVarZzj = zzamVar4.zzj(str);
            if (zzhVarZzj != null) {
                long jAbs = Math.abs(zzav().currentTimeMillis() - Math.max(zzhVarZzj.zzl(), zzhVarZzj.zzc()));
                zzg();
                if (jAbs > ((Long) zzeh.zzy.zza(null)).longValue()) {
                    zzay().zzc().zza("Fetching config for blocked app");
                    zzD(zzhVarZzj);
                    return;
                }
                return;
            }
            return;
        }
        zzev zzevVarZzb = zzev.zzb(zzawVar);
        zzv().zzM(zzevVarZzb, zzg().zzd(str));
        zzaw zzawVarZza = zzevVarZzb.zza();
        int i5 = 2;
        if (Log.isLoggable(zzay().zzq(), 2)) {
            zzay().zzj().zzb("Logging event", this.zzn.zzj().zzc(zzawVarZza));
        }
        zzam zzamVar5 = this.zze;
        zzal(zzamVar5);
        zzamVar5.zzw();
        try {
            zzd(zzqVar);
            boolean z = "ecommerce_purchase".equals(zzawVarZza.zza) || FirebaseAnalytics.Event.PURCHASE.equals(zzawVarZza.zza) || FirebaseAnalytics.Event.REFUND.equals(zzawVarZza.zza);
            if ("_iap".equals(zzawVarZza.zza)) {
                strZzg = zzawVarZza.zzb.zzg(FirebaseAnalytics.Param.CURRENCY);
                if (z) {
                    dDoubleValue = zzawVarZza.zzb.zzd("value").doubleValue() * 1000000.0d;
                    if (dDoubleValue == 0.0d) {
                        i = 1;
                        dDoubleValue = zzawVarZza.zzb.zze("value").longValue() * 1000000.0d;
                    } else {
                        i = 1;
                    }
                    if (dDoubleValue <= 9.223372036854776E18d || dDoubleValue < -9.223372036854776E18d) {
                        zzay().zzk().zzc("Data lost. Currency value is too big. appId", zzeu.zzn(str), Double.valueOf(dDoubleValue));
                        zzam zzamVar6 = this.zze;
                        zzal(zzamVar6);
                        zzamVar6.zzC();
                        zzam zzamVar7 = this.zze;
                        zzal(zzamVar7);
                        zzamVar7.zzx();
                        return;
                    }
                    jLongValue = Math.round(dDoubleValue);
                    if (FirebaseAnalytics.Event.REFUND.equals(zzawVarZza.zza)) {
                        jLongValue = -jLongValue;
                    }
                } else {
                    strZzg = strZzg;
                    i = 1;
                    jLongValue = zzawVarZza.zzb.zze("value").longValue();
                }
                if (!TextUtils.isEmpty(strZzg)) {
                    upperCase = strZzg.toUpperCase(Locale.US);
                    if (upperCase.matches("[A-Z]{3}")) {
                        strConcat = "_ltv_".concat(String.valueOf(upperCase));
                        zzam zzamVar8 = this.zze;
                        zzal(zzamVar8);
                        zzlkVarZzp = zzamVar8.zzp(str, strConcat);
                        if (zzlkVarZzp != null) {
                            obj2 = zzlkVarZzp.zze;
                            if (obj2 instanceof Long) {
                                long jLongValue2 = ((Long) obj2).longValue();
                                String str3 = zzawVarZza.zzc;
                                long jCurrentTimeMillis = zzav().currentTimeMillis();
                                Long lValueOf = Long.valueOf(jLongValue2 + jLongValue);
                                str2 = "_err";
                                zzlkVar = new zzlk(str, str3, strConcat, jCurrentTimeMillis, lValueOf);
                                str = str;
                                i5 = 2;
                                obj = null;
                            } else {
                                long j = jLongValue;
                                str2 = "_err";
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                int iZze = zzg().zze(str, zzeh.zzD) - 1;
                                Preconditions.checkNotEmpty(str);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                try {
                                    SQLiteDatabase sQLiteDatabaseZzh = zzamVar.zzh();
                                    i5 = 2;
                                    try {
                                        String[] strArr = new String[3];
                                        strArr[0] = str;
                                        strArr[i] = str;
                                        strArr[2] = String.valueOf(iZze);
                                        sQLiteDatabaseZzh.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr);
                                    } catch (SQLiteException e) {
                                        e = e;
                                        zzamVar.zzs.zzay().zzd().zzc("Error pruning currencies. appId", zzeu.zzn(str), e);
                                    }
                                } catch (SQLiteException e2) {
                                    e = e2;
                                    i5 = 2;
                                }
                                obj = null;
                                zzlkVar = new zzlk(str, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(j));
                                str = str;
                            }
                        } else {
                            long j2 = jLongValue;
                            str2 = "_err";
                            zzamVar = this.zze;
                            zzal(zzamVar);
                            int iZze2 = zzg().zze(str, zzeh.zzD) - 1;
                            Preconditions.checkNotEmpty(str);
                            zzamVar.zzg();
                            zzamVar.zzW();
                            SQLiteDatabase sQLiteDatabaseZzh2 = zzamVar.zzh();
                            i5 = 2;
                            String[] strArr2 = new String[3];
                            strArr2[0] = str;
                            strArr2[i] = str;
                            strArr2[2] = String.valueOf(iZze2);
                            sQLiteDatabaseZzh2.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr2);
                            obj = null;
                            zzlkVar = new zzlk(str, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(j2));
                            str = str;
                        }
                        zzamVar2 = this.zze;
                        zzal(zzamVar2);
                        if (!zzamVar2.zzL(zzlkVar)) {
                            zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeu.zzn(str), this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                            zzv().zzN(this.zzF, str, 9, null, null, 0);
                        }
                    }
                }
                obj = null;
            } else {
                if (z) {
                    z = true;
                    strZzg = zzawVarZza.zzb.zzg(FirebaseAnalytics.Param.CURRENCY);
                    if (z) {
                        dDoubleValue = zzawVarZza.zzb.zzd("value").doubleValue() * 1000000.0d;
                        if (dDoubleValue == 0.0d) {
                            i = 1;
                            dDoubleValue = zzawVarZza.zzb.zze("value").longValue() * 1000000.0d;
                        } else {
                            i = 1;
                        }
                        if (dDoubleValue <= 9.223372036854776E18d) {
                        }
                        zzay().zzk().zzc("Data lost. Currency value is too big. appId", zzeu.zzn(str), Double.valueOf(dDoubleValue));
                        zzam zzamVar9 = this.zze;
                        zzal(zzamVar9);
                        zzamVar9.zzC();
                        zzam zzamVar10 = this.zze;
                        zzal(zzamVar10);
                        zzamVar10.zzx();
                        return;
                    }
                    strZzg = strZzg;
                    i = 1;
                    jLongValue = zzawVarZza.zzb.zze("value").longValue();
                    if (!TextUtils.isEmpty(strZzg)) {
                        upperCase = strZzg.toUpperCase(Locale.US);
                        if (upperCase.matches("[A-Z]{3}")) {
                            strConcat = "_ltv_".concat(String.valueOf(upperCase));
                            zzam zzamVar11 = this.zze;
                            zzal(zzamVar11);
                            zzlkVarZzp = zzamVar11.zzp(str, strConcat);
                            if (zzlkVarZzp != null) {
                                obj2 = zzlkVarZzp.zze;
                                if (obj2 instanceof Long) {
                                    long j3 = jLongValue;
                                    str2 = "_err";
                                    zzamVar = this.zze;
                                    zzal(zzamVar);
                                    int iZze3 = zzg().zze(str, zzeh.zzD) - 1;
                                    Preconditions.checkNotEmpty(str);
                                    zzamVar.zzg();
                                    zzamVar.zzW();
                                    SQLiteDatabase sQLiteDatabaseZzh3 = zzamVar.zzh();
                                    i5 = 2;
                                    String[] strArr3 = new String[3];
                                    strArr3[0] = str;
                                    strArr3[i] = str;
                                    strArr3[2] = String.valueOf(iZze3);
                                    sQLiteDatabaseZzh3.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr3);
                                    obj = null;
                                    zzlkVar = new zzlk(str, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(j3));
                                    str = str;
                                } else {
                                    long jLongValue3 = ((Long) obj2).longValue();
                                    String str4 = zzawVarZza.zzc;
                                    long jCurrentTimeMillis2 = zzav().currentTimeMillis();
                                    Long lValueOf2 = Long.valueOf(jLongValue3 + jLongValue);
                                    str2 = "_err";
                                    zzlkVar = new zzlk(str, str4, strConcat, jCurrentTimeMillis2, lValueOf2);
                                    str = str;
                                    i5 = 2;
                                    obj = null;
                                }
                            } else {
                                long j4 = jLongValue;
                                str2 = "_err";
                                zzamVar = this.zze;
                                zzal(zzamVar);
                                int iZze4 = zzg().zze(str, zzeh.zzD) - 1;
                                Preconditions.checkNotEmpty(str);
                                zzamVar.zzg();
                                zzamVar.zzW();
                                SQLiteDatabase sQLiteDatabaseZzh4 = zzamVar.zzh();
                                i5 = 2;
                                String[] strArr4 = new String[3];
                                strArr4[0] = str;
                                strArr4[i] = str;
                                strArr4[2] = String.valueOf(iZze4);
                                sQLiteDatabaseZzh4.execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", strArr4);
                                obj = null;
                                zzlkVar = new zzlk(str, zzawVarZza.zzc, strConcat, zzav().currentTimeMillis(), Long.valueOf(j4));
                                str = str;
                            }
                            zzamVar2 = this.zze;
                            zzal(zzamVar2);
                            if (!zzamVar2.zzL(zzlkVar)) {
                                zzay().zzd().zzd("Too many unique user properties are set. Ignoring user property. appId", zzeu.zzn(str), this.zzn.zzj().zzf(zzlkVar.zzc), zzlkVar.zze);
                                zzv().zzN(this.zzF, str, 9, null, null, 0);
                            }
                        }
                    }
                } else {
                    i = 1;
                }
                obj = null;
            }
            boolean zZzai = zzln.zzai(zzawVarZza.zza);
            boolean zEquals = str2.equals(zzawVarZza.zza);
            zzv();
            zzau zzauVar = zzawVarZza.zzb;
            if (zzauVar == null) {
                length = 0;
            } else {
                zzat zzatVar2 = new zzat(zzauVar);
                length = 0;
                while (zzatVar2.hasNext()) {
                    Object objZzf = zzauVar.zzf(zzatVar2.next());
                    if (objZzf instanceof Parcelable[]) {
                        length += (long) ((Parcelable[]) objZzf).length;
                    }
                }
            }
            long j5 = length + 1;
            zzam zzamVar12 = this.zze;
            zzal(zzamVar12);
            String str5 = str;
            zzak zzakVarZzm = zzamVar12.zzm(zza(), str5, j5, true, zZzai, false, zEquals, false);
            long j6 = zzakVarZzm.zzb;
            zzg();
            long jIntValue = j6 - ((long) ((Integer) zzeh.zzj.zza(obj)).intValue());
            if (jIntValue > 0) {
                if (jIntValue % 1000 == 1) {
                    zzay().zzd().zzc("Data loss. Too many events logged. appId, count", zzeu.zzn(str5), Long.valueOf(zzakVarZzm.zzb));
                }
                zzam zzamVar13 = this.zze;
                zzal(zzamVar13);
                zzamVar13.zzC();
                zzam zzamVar14 = this.zze;
                zzal(zzamVar14);
                zzamVar14.zzx();
                return;
            }
            if (zZzai) {
                long j7 = zzakVarZzm.zza;
                zzg();
                long jIntValue2 = j7 - ((long) ((Integer) zzeh.zzl.zza(obj)).intValue());
                if (jIntValue2 > 0) {
                    if (jIntValue2 % 1000 == 1) {
                        zzay().zzd().zzc("Data loss. Too many public events logged. appId, count", zzeu.zzn(str5), Long.valueOf(zzakVarZzm.zza));
                    }
                    zzv().zzN(this.zzF, str5, 16, "_ev", zzawVarZza.zza, 0);
                    zzam zzamVar15 = this.zze;
                    zzal(zzamVar15);
                    zzamVar15.zzC();
                    zzam zzamVar16 = this.zze;
                    zzal(zzamVar16);
                    zzamVar16.zzx();
                    return;
                }
            }
            if (zEquals) {
                long jMax = zzakVarZzm.zzd - ((long) Math.max(0, Math.min(DurationKt.NANOS_IN_MILLIS, zzg().zze(zzqVar.zza, zzeh.zzk))));
                if (jMax > 0) {
                    if (jMax == 1) {
                        zzay().zzd().zzc("Too many error events logged. appId, count", zzeu.zzn(str5), Long.valueOf(zzakVarZzm.zzd));
                    }
                    zzam zzamVar17 = this.zze;
                    zzal(zzamVar17);
                    zzamVar17.zzC();
                    zzam zzamVar18 = this.zze;
                    zzal(zzamVar18);
                    zzamVar18.zzx();
                    return;
                }
            }
            Bundle bundleZzc = zzawVarZza.zzb.zzc();
            zzv().zzO(bundleZzc, "_o", zzawVarZza.zzc);
            if (zzv().zzae(str5)) {
                zzv().zzO(bundleZzc, "_dbg", 1L);
                zzv().zzO(bundleZzc, "_r", 1L);
            }
            if ("_s".equals(zzawVarZza.zza)) {
                zzam zzamVar19 = this.zze;
                zzal(zzamVar19);
                zzlk zzlkVarZzp2 = zzamVar19.zzp(zzqVar.zza, "_sno");
                if (zzlkVarZzp2 != null && (zzlkVarZzp2.zze instanceof Long)) {
                    zzv().zzO(bundleZzc, "_sno", zzlkVarZzp2.zze);
                }
            }
            zzam zzamVar20 = this.zze;
            zzal(zzamVar20);
            Preconditions.checkNotEmpty(str5);
            zzamVar20.zzg();
            zzamVar20.zzW();
            try {
                try {
                    SQLiteDatabase sQLiteDatabaseZzh5 = zzamVar20.zzh();
                    int iMin = Math.min(DurationKt.NANOS_IN_MILLIS, zzamVar20.zzs.zzf().zze(str5, zzeh.zzo));
                    i2 = 0;
                    try {
                        try {
                            String strValueOf = String.valueOf(Math.max(0, iMin));
                            String[] strArr5 = new String[i5];
                            strArr5[0] = str5;
                            strArr5[i] = strValueOf;
                            jDelete = sQLiteDatabaseZzh5.delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", strArr5);
                            while (true) {
                                if (!zzatVar.hasNext()) {
                                    zzfv zzfvVar4 = this.zzc;
                                    zzal(zzfvVar4);
                                    boolean zZzq = zzfvVar4.zzq(zzarVar.zza, zzarVar.zzb);
                                    zzam zzamVar21 = this.zze;
                                    zzal(zzamVar21);
                                    zzak zzakVarZzl = zzamVar21.zzl(zza(), zzarVar.zza, false, false, false, false, false);
                                    if (!zZzq || zzakVarZzl.zze >= zzg().zze(zzarVar.zza, zzeh.zzn)) {
                                        i4 = i3;
                                        break;
                                    }
                                } else if ("_r".equals(zzatVar.next())) {
                                }
                                i4 = 1;
                                break;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            zzamVar20.zzs.zzay().zzd().zzc("Error deleting over the limit events. appId", zzeu.zzn(str5), e);
                            jDelete = 0;
                        }
                        zzamVar3.zzh().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                        zzam zzamVar22 = this.zze;
                        zzal(zzamVar22);
                        zzatVar = new zzat(zzarVar.zzf);
                        zzamVar22.zzg();
                        zzamVar22.zzW();
                        Preconditions.checkNotNull(zzarVar);
                        Preconditions.checkNotEmpty(zzarVar.zza);
                        zzlh zzlhVar = zzamVar22.zzf.zzi;
                        zzal(zzlhVar);
                        byte[] bArrZzbv = zzlhVar.zzj(zzarVar).zzbv();
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_id", zzarVar.zza);
                        contentValues2.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzarVar.zzb);
                        contentValues2.put("timestamp", Long.valueOf(zzarVar.zzd));
                        contentValues2.put("metadata_fingerprint", Long.valueOf(jZzd));
                        contentValues2.put("data", bArrZzbv);
                        contentValues2.put("realtime", Integer.valueOf(i4));
                        try {
                            if (zzamVar22.zzh().insert("raw_events", null, contentValues2) == -1) {
                                zzamVar22.zzs.zzay().zzd().zzb("Failed to insert raw event (got -1). appId", zzeu.zzn(zzarVar.zza));
                            } else {
                                this.zza = 0L;
                            }
                        } catch (SQLiteException e4) {
                            zzamVar22.zzs.zzay().zzd().zzc("Error storing raw event. appId", zzeu.zzn(zzarVar.zza), e4);
                        }
                        zzam zzamVar23 = this.zze;
                        zzal(zzamVar23);
                        zzamVar23.zzC();
                        zzam zzamVar24 = this.zze;
                        zzal(zzamVar24);
                        zzamVar24.zzx();
                        zzag();
                        zzay().zzj().zzb("Background event processing time, ms", Long.valueOf(((System.nanoTime() - jNanoTime) + 500000) / 1000000));
                        return;
                    } catch (SQLiteException e5) {
                        zzamVar3.zzs.zzay().zzd().zzc("Error storing raw event metadata. appId", zzeu.zzn(zzgcVar.zzx()), e5);
                        throw e5;
                    }
                } catch (SQLiteException e6) {
                    e = e6;
                    i2 = 0;
                }
                zzamVar3 = this.zze;
                zzal(zzamVar3);
                zzgcVar = (com.google.android.gms.internal.measurement.zzgc) zzgbVarZzt.zzaE();
                zzamVar3.zzg();
                zzamVar3.zzW();
                Preconditions.checkNotNull(zzgcVar);
                Preconditions.checkNotEmpty(zzgcVar.zzx());
                byte[] bArrZzbv2 = zzgcVar.zzbv();
                zzlh zzlhVar2 = zzamVar3.zzf.zzi;
                zzal(zzlhVar2);
                jZzd = zzlhVar2.zzd(bArrZzbv2);
                contentValues = new ContentValues();
                contentValues.put("app_id", zzgcVar.zzx());
                contentValues.put("metadata_fingerprint", Long.valueOf(jZzd));
                contentValues.put("metadata", bArrZzbv2);
            } catch (IOException e7) {
                zzay().zzd().zzc("Data loss. Failed to insert raw event metadata. appId", zzeu.zzn(zzgbVarZzt.zzap()), e7);
            }
            if (jDelete > 0) {
                zzay().zzk().zzc("Data lost. Too many events stored on disk, deleted. appId", zzeu.zzn(str5), Long.valueOf(jDelete));
            }
            i3 = i2;
            zzar zzarVar2 = new zzar(this.zzn, zzawVarZza.zzc, str5, zzawVarZza.zza, zzawVarZza.zzd, 0L, bundleZzc);
            zzam zzamVar25 = this.zze;
            zzal(zzamVar25);
            zzas zzasVarZzn = zzamVar25.zzn(str5, zzarVar2.zzb);
            if (zzasVarZzn == null) {
                zzam zzamVar26 = this.zze;
                zzal(zzamVar26);
                if (zzamVar26.zzf(str5) >= zzg().zzb(str5) && zZzai) {
                    zzay().zzd().zzd("Too many event names used, ignoring event. appId, name, supported count", zzeu.zzn(str5), this.zzn.zzj().zzd(zzarVar2.zzb), Integer.valueOf(zzg().zzb(str5)));
                    zzv().zzN(this.zzF, str5, 8, null, null, 0);
                    zzam zzamVar27 = this.zze;
                    zzal(zzamVar27);
                    zzamVar27.zzx();
                    return;
                }
                zzasVar = new zzas(str5, zzarVar2.zzb, 0L, 0L, 0L, zzarVar2.zzd, 0L, null, null, null, null);
                zzarVar = zzarVar2;
            } else {
                zzar zzarVarZza = zzarVar2.zza(this.zzn, zzasVarZzn.zzf);
                zzas zzasVarZzc = zzasVarZzn.zzc(zzarVarZza.zzd);
                zzarVar = zzarVarZza;
                zzasVar = zzasVarZzc;
            }
            zzam zzamVar28 = this.zze;
            zzal(zzamVar28);
            zzamVar28.zzE(zzasVar);
            zzaz().zzg();
            zzB();
            Preconditions.checkNotNull(zzarVar);
            Preconditions.checkNotNull(zzqVar);
            Preconditions.checkNotEmpty(zzarVar.zza);
            Preconditions.checkArgument(zzarVar.zza.equals(zzqVar.zza));
            zzgbVarZzt = com.google.android.gms.internal.measurement.zzgc.zzt();
            zzgbVarZzt.zzad(i);
            zzgbVarZzt.zzZ("android");
            if (!TextUtils.isEmpty(zzqVar.zza)) {
                zzgbVarZzt.zzD(zzqVar.zza);
            }
            if (!TextUtils.isEmpty(zzqVar.zzd)) {
                zzgbVarZzt.zzF(zzqVar.zzd);
            }
            if (!TextUtils.isEmpty(zzqVar.zzc)) {
                zzgbVarZzt.zzG(zzqVar.zzc);
            }
            zzpi.zzc();
            if (zzg().zzs(null, zzeh.zzay) && !TextUtils.isEmpty(zzqVar.zzx)) {
                zzgbVarZzt.zzah(zzqVar.zzx);
            }
            long j8 = zzqVar.zzj;
            if (j8 != -2147483648L) {
                zzgbVarZzt.zzH((int) j8);
            }
            zzgbVarZzt.zzV(zzqVar.zze);
            if (!TextUtils.isEmpty(zzqVar.zzb)) {
                zzgbVarZzt.zzU(zzqVar.zzb);
            }
            zzgbVarZzt.zzL(zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv)).zzh());
            if (zzgbVarZzt.zzaq().isEmpty() && !TextUtils.isEmpty(zzqVar.zzq)) {
                zzgbVarZzt.zzC(zzqVar.zzq);
            }
            long j9 = zzqVar.zzf;
            if (j9 != 0) {
                zzgbVarZzt.zzM(j9);
            }
            zzgbVarZzt.zzP(zzqVar.zzs);
            zzlh zzlhVar3 = this.zzi;
            zzal(zzlhVar3);
            Map mapZzc = zzeh.zzc(zzlhVar3.zzf.zzn.zzau());
            if (mapZzc != null && !mapZzc.isEmpty()) {
                ArrayList arrayList2 = new ArrayList();
                int iIntValue = ((Integer) zzeh.zzO.zza(null)).intValue();
                for (Map.Entry entry : mapZzc.entrySet()) {
                    if (((String) entry.getKey()).startsWith("measurement.id.")) {
                        try {
                            int i6 = Integer.parseInt((String) entry.getValue());
                            if (i6 != 0) {
                                arrayList2.add(Integer.valueOf(i6));
                                if (arrayList2.size() >= iIntValue) {
                                    zzlhVar3.zzs.zzay().zzk().zzb("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList2.size()));
                                    break;
                                }
                                continue;
                            } else {
                                continue;
                            }
                        } catch (NumberFormatException e8) {
                            zzlhVar3.zzs.zzay().zzk().zzb("Experiment ID NumberFormatException", e8);
                        }
                    }
                }
                arrayList = arrayList2.isEmpty() ? null : arrayList2;
            }
            if (arrayList != null) {
                zzgbVarZzt.zzh(arrayList);
            }
            zzai zzaiVarZzc = zzh((String) Preconditions.checkNotNull(zzqVar.zza)).zzc(zzai.zzb(zzqVar.zzv));
            if (zzaiVarZzc.zzi(zzah.AD_STORAGE) && (!zzg().zzs(null, zzeh.zzaj) || zzqVar.zzo)) {
                Pair pairZzd = this.zzk.zzd(zzqVar.zza, zzaiVarZzc);
                if (!TextUtils.isEmpty((CharSequence) pairZzd.first) && zzqVar.zzo) {
                    zzgbVarZzt.zzae((String) pairZzd.first);
                    if (pairZzd.second != null) {
                        zzgbVarZzt.zzX(((Boolean) pairZzd.second).booleanValue());
                    }
                }
            }
            this.zzn.zzg().zzu();
            zzgbVarZzt.zzN(Build.MODEL);
            this.zzn.zzg().zzu();
            zzgbVarZzt.zzY(Build.VERSION.RELEASE);
            zzgbVarZzt.zzaj((int) this.zzn.zzg().zzb());
            zzgbVarZzt.zzan(this.zzn.zzg().zzc());
            if (this.zzn.zzJ()) {
                zzgbVarZzt.zzap();
                if (!TextUtils.isEmpty(null)) {
                    zzgbVarZzt.zzO(null);
                }
            }
            zzam zzamVar29 = this.zze;
            zzal(zzamVar29);
            zzh zzhVarZzj2 = zzamVar29.zzj(zzqVar.zza);
            if (zzhVarZzj2 == null) {
                zzhVarZzj2 = new zzh(this.zzn, zzqVar.zza);
                zzhVarZzj2.zzH(zzw(zzaiVarZzc));
                zzhVarZzj2.zzV(zzqVar.zzk);
                zzhVarZzj2.zzW(zzqVar.zzb);
                if (zzaiVarZzc.zzi(zzah.AD_STORAGE)) {
                    zzhVarZzj2.zzae(this.zzk.zzf(zzqVar.zza, zzqVar.zzo));
                }
                zzhVarZzj2.zzaa(0L);
                zzhVarZzj2.zzab(0L);
                zzhVarZzj2.zzZ(0L);
                zzhVarZzj2.zzJ(zzqVar.zzc);
                zzhVarZzj2.zzK(zzqVar.zzj);
                zzhVarZzj2.zzI(zzqVar.zzd);
                zzhVarZzj2.zzX(zzqVar.zze);
                zzhVarZzj2.zzS(zzqVar.zzf);
                zzhVarZzj2.zzac(zzqVar.zzh);
                zzhVarZzj2.zzT(zzqVar.zzs);
                zzam zzamVar30 = this.zze;
                zzal(zzamVar30);
                zzamVar30.zzD(zzhVarZzj2);
            }
            if (zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE) && !TextUtils.isEmpty(zzhVarZzj2.zzu())) {
                zzgbVarZzt.zzE((String) Preconditions.checkNotNull(zzhVarZzj2.zzu()));
            }
            if (!TextUtils.isEmpty(zzhVarZzj2.zzx())) {
                zzgbVarZzt.zzT((String) Preconditions.checkNotNull(zzhVarZzj2.zzx()));
            }
            zzam zzamVar31 = this.zze;
            zzal(zzamVar31);
            List listZzu = zzamVar31.zzu(zzqVar.zza);
            for (int i7 = i3; i7 < listZzu.size(); i7++) {
                com.google.android.gms.internal.measurement.zzgk zzgkVarZzd = com.google.android.gms.internal.measurement.zzgl.zzd();
                zzgkVarZzd.zzf(((zzlk) listZzu.get(i7)).zzc);
                zzgkVarZzd.zzg(((zzlk) listZzu.get(i7)).zzd);
                zzlh zzlhVar4 = this.zzi;
                zzal(zzlhVar4);
                zzlhVar4.zzu(zzgkVarZzd, ((zzlk) listZzu.get(i7)).zze);
                zzgbVarZzt.zzl(zzgkVarZzd);
            }
        } catch (Throwable th) {
            zzam zzamVar32 = this.zze;
            zzal(zzamVar32);
            zzamVar32.zzx();
            throw th;
        }
    }

    final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock != null && fileLock.isValid()) {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
        this.zze.zzs.zzf();
        try {
            FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzx = channel;
            FileLock fileLockTryLock = channel.tryLock();
            this.zzw = fileLockTryLock;
            if (fileLockTryLock != null) {
                zzay().zzj().zza("Storage concurrent access okay");
                return true;
            }
            zzay().zzd().zza("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzay().zzd().zzb("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            zzay().zzd().zzb("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            zzay().zzk().zzb("Storage lock already acquired", e3);
            return false;
        }
    }

    final long zza() {
        long jCurrentTimeMillis = zzav().currentTimeMillis();
        zzka zzkaVar = this.zzk;
        zzkaVar.zzW();
        zzkaVar.zzg();
        long jZza = zzkaVar.zze.zza();
        if (jZza == 0) {
            jZza = ((long) zzkaVar.zzs.zzv().zzG().nextInt(86400000)) + 1;
            zzkaVar.zze.zzb(jZza);
        }
        return ((((jCurrentTimeMillis + jZza) / 1000) / 60) / 60) / 24;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final Context zzau() {
        return this.zzn.zzau();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final Clock zzav() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzab zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzeu zzay() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    @Override // com.google.android.gms.measurement.internal.zzgz
    public final zzgb zzaz() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    final zzh zzd(zzq zzqVar) {
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzpc.zzc();
        zzld zzldVar = null;
        if (zzg().zzs(zzqVar.zza, zzeh.zzaA) && !zzqVar.zzw.isEmpty()) {
            this.zzC.put(zzqVar.zza, new zzle(this, zzqVar.zzw));
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        zzh zzhVarZzj = zzamVar.zzj(zzqVar.zza);
        zzai zzaiVarZzc = zzh(zzqVar.zza).zzc(zzai.zzb(zzqVar.zzv));
        String strZzf = zzaiVarZzc.zzi(zzah.AD_STORAGE) ? this.zzk.zzf(zzqVar.zza, zzqVar.zzo) : "";
        if (zzhVarZzj == null) {
            zzhVarZzj = new zzh(this.zzn, zzqVar.zza);
            if (zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE)) {
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
            }
            if (zzaiVarZzc.zzi(zzah.AD_STORAGE)) {
                zzhVarZzj.zzae(strZzf);
            }
        } else if (zzaiVarZzc.zzi(zzah.AD_STORAGE) && strZzf != null && !strZzf.equals(zzhVarZzj.zzA())) {
            zzhVarZzj.zzae(strZzf);
            if ((!zzg().zzs(null, zzeh.zzaj) || zzqVar.zzo) && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzqVar.zza, zzaiVarZzc).first)) {
                zzhVarZzj.zzH(zzw(zzaiVarZzc));
                zzam zzamVar2 = this.zze;
                zzal(zzamVar2);
                if (zzamVar2.zzp(zzqVar.zza, "_id") != null) {
                    zzam zzamVar3 = this.zze;
                    zzal(zzamVar3);
                    if (zzamVar3.zzp(zzqVar.zza, "_lair") == null) {
                        zzlk zzlkVar = new zzlk(zzqVar.zza, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lair", zzav().currentTimeMillis(), 1L);
                        zzam zzamVar4 = this.zze;
                        zzal(zzamVar4);
                        zzamVar4.zzL(zzlkVar);
                    }
                }
            }
        } else if (TextUtils.isEmpty(zzhVarZzj.zzu()) && zzaiVarZzc.zzi(zzah.ANALYTICS_STORAGE)) {
            zzhVarZzj.zzH(zzw(zzaiVarZzc));
        }
        zzhVarZzj.zzW(zzqVar.zzb);
        zzhVarZzj.zzF(zzqVar.zzq);
        if (!TextUtils.isEmpty(zzqVar.zzk)) {
            zzhVarZzj.zzV(zzqVar.zzk);
        }
        long j = zzqVar.zze;
        if (j != 0) {
            zzhVarZzj.zzX(j);
        }
        if (!TextUtils.isEmpty(zzqVar.zzc)) {
            zzhVarZzj.zzJ(zzqVar.zzc);
        }
        zzhVarZzj.zzK(zzqVar.zzj);
        String str = zzqVar.zzd;
        if (str != null) {
            zzhVarZzj.zzI(str);
        }
        zzhVarZzj.zzS(zzqVar.zzf);
        zzhVarZzj.zzac(zzqVar.zzh);
        if (!TextUtils.isEmpty(zzqVar.zzg)) {
            zzhVarZzj.zzY(zzqVar.zzg);
        }
        zzhVarZzj.zzG(zzqVar.zzo);
        zzhVarZzj.zzad(zzqVar.zzr);
        zzhVarZzj.zzT(zzqVar.zzs);
        zzpi.zzc();
        if (zzg().zzs(null, zzeh.zzay)) {
            zzhVarZzj.zzag(zzqVar.zzx);
        }
        zzny.zzc();
        if (zzg().zzs(null, zzeh.zzaq)) {
            zzhVarZzj.zzaf(zzqVar.zzt);
        } else {
            zzny.zzc();
            if (zzg().zzs(null, zzeh.zzap)) {
                zzhVarZzj.zzaf(null);
            }
        }
        if (zzhVarZzj.zzaj()) {
            zzam zzamVar5 = this.zze;
            zzal(zzamVar5);
            zzamVar5.zzD(zzhVarZzj);
        }
        return zzhVarZzj;
    }

    public final zzaa zzf() {
        zzaa zzaaVar = this.zzh;
        zzal(zzaaVar);
        return zzaaVar;
    }

    public final zzag zzg() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    final zzai zzh(String str) {
        String string;
        zzai zzaiVar = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzaiVar2 = (zzai) this.zzB.get(str);
        if (zzaiVar2 != null) {
            return zzaiVar2;
        }
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        Preconditions.checkNotNull(str);
        zzamVar.zzg();
        zzamVar.zzW();
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = zzamVar.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
                if (cursorRawQuery.moveToFirst()) {
                    string = cursorRawQuery.getString(0);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    string = "G1";
                }
                zzai zzaiVarZzb = zzai.zzb(string);
                zzV(str, zzaiVarZzb);
                return zzaiVarZzb;
            } catch (SQLiteException e) {
                zzamVar.zzs.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e);
                throw e;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final zzam zzi() {
        zzam zzamVar = this.zze;
        zzal(zzamVar);
        return zzamVar;
    }

    public final zzep zzj() {
        return this.zzn.zzj();
    }

    public final zzfa zzl() {
        zzfa zzfaVar = this.zzd;
        zzal(zzfaVar);
        return zzfaVar;
    }

    public final zzfc zzm() {
        zzfc zzfcVar = this.zzf;
        if (zzfcVar != null) {
            return zzfcVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfv zzo() {
        zzfv zzfvVar = this.zzc;
        zzal(zzfvVar);
        return zzfvVar;
    }

    final zzge zzq() {
        return this.zzn;
    }

    public final zzio zzr() {
        zzio zzioVar = this.zzj;
        zzal(zzioVar);
        return zzioVar;
    }

    public final zzka zzs() {
        return this.zzk;
    }

    public final zzlh zzu() {
        zzlh zzlhVar = this.zzi;
        zzal(zzlhVar);
        return zzlhVar;
    }

    public final zzln zzv() {
        return ((zzge) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    final String zzw(zzai zzaiVar) {
        if (!zzaiVar.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    final String zzx(zzq zzqVar) {
        try {
            return (String) zzaz().zzh(new zzky(this, zzqVar)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeu.zzn(zzqVar.zza), e);
            return null;
        }
    }

    final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
