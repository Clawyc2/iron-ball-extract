package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaa extends zzkt {
    private String zza;
    private Set zzb;
    private Map zzc;
    private Long zzd;
    private Long zze;

    zzaa(zzlf zzlfVar) {
        super(zzlfVar);
    }

    private final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.get(num);
        }
        zzu zzuVar = new zzu(this, this.zza, null);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }

    private final boolean zzf(int i, int i2) {
        zzu zzuVar = (zzu) this.zzc.get(Integer.valueOf(i));
        if (zzuVar == null) {
            return false;
        }
        return zzuVar.zze.get(i2);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0278  */
    /* JADX WARN: Code duplicated, block: B:109:0x0287  */
    /* JADX WARN: Code duplicated, block: B:111:0x0292  */
    /* JADX WARN: Code duplicated, block: B:115:0x02c5 A[Catch: SQLiteException -> 0x02fd, all -> 0x047f, LOOP:11: B:115:0x02c5->B:548:?, LOOP_START, TryCatch #15 {all -> 0x047f, blocks: (B:113:0x02bf, B:115:0x02c5, B:117:0x02d6, B:118:0x02de, B:122:0x02f6, B:131:0x0305), top: B:481:0x02af }] */
    /* JADX WARN: Code duplicated, block: B:117:0x02d6 A[Catch: SQLiteException -> 0x02fd, all -> 0x047f, TryCatch #15 {all -> 0x047f, blocks: (B:113:0x02bf, B:115:0x02c5, B:117:0x02d6, B:118:0x02de, B:122:0x02f6, B:131:0x0305), top: B:481:0x02af }] */
    /* JADX WARN: Code duplicated, block: B:121:0x02f2 A[PHI: r0 r6
      0x02f2: PHI (r0v69 java.util.Map) = (r0v45 java.util.Map), (r0v71 java.util.Map), (r0v39 java.util.Map) binds: [B:132:0x031c, B:123:0x02fa, B:120:0x02f0] A[DONT_GENERATE, DONT_INLINE]
      0x02f2: PHI (r6v11 android.database.Cursor) = (r6v4 android.database.Cursor), (r6v12 android.database.Cursor), (r6v12 android.database.Cursor) binds: [B:132:0x031c, B:123:0x02fa, B:120:0x02f0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:122:0x02f6 A[Catch: SQLiteException -> 0x02fd, all -> 0x047f, TRY_ENTER, TRY_LEAVE, TryCatch #15 {all -> 0x047f, blocks: (B:113:0x02bf, B:115:0x02c5, B:117:0x02d6, B:118:0x02de, B:122:0x02f6, B:131:0x0305), top: B:481:0x02af }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0334  */
    /* JADX WARN: Code duplicated, block: B:140:0x0342  */
    /* JADX WARN: Code duplicated, block: B:142:0x035e  */
    /* JADX WARN: Code duplicated, block: B:185:0x0483  */
    /* JADX WARN: Code duplicated, block: B:187:0x0487  */
    /* JADX WARN: Code duplicated, block: B:191:0x0494  */
    /* JADX WARN: Code duplicated, block: B:193:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:199:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:203:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:204:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:208:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:214:0x0512  */
    /* JADX WARN: Code duplicated, block: B:221:0x054c  */
    /* JADX WARN: Code duplicated, block: B:224:0x0555  */
    /* JADX WARN: Code duplicated, block: B:226:0x055f  */
    /* JADX WARN: Code duplicated, block: B:228:0x0585  */
    /* JADX WARN: Code duplicated, block: B:229:0x0589  */
    /* JADX WARN: Code duplicated, block: B:234:0x05a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:258:0x062a  */
    /* JADX WARN: Code duplicated, block: B:261:0x063e  */
    /* JADX WARN: Code duplicated, block: B:265:0x0662  */
    /* JADX WARN: Code duplicated, block: B:266:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:269:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:277:0x073a  */
    /* JADX WARN: Code duplicated, block: B:284:0x0762  */
    /* JADX WARN: Code duplicated, block: B:286:0x076d  */
    /* JADX WARN: Code duplicated, block: B:293:0x0791  */
    /* JADX WARN: Code duplicated, block: B:295:0x0796 A[LOOP:8: B:278:0x073c->B:295:0x0796, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:298:0x079d  */
    /* JADX WARN: Code duplicated, block: B:301:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:324:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:328:0x07f1  */
    /* JADX WARN: Code duplicated, block: B:330:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:334:0x080b  */
    /* JADX WARN: Code duplicated, block: B:340:0x0840  */
    /* JADX WARN: Code duplicated, block: B:342:0x086b A[LOOP:10: B:338:0x083a->B:342:0x086b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:346:0x088b  */
    /* JADX WARN: Code duplicated, block: B:352:0x08ab  */
    /* JADX WARN: Code duplicated, block: B:355:0x08ba  */
    /* JADX WARN: Code duplicated, block: B:357:0x08cd  */
    /* JADX WARN: Code duplicated, block: B:361:0x0912 A[Catch: all -> 0x097d, SQLiteException -> 0x0980, LOOP:3: B:361:0x0912->B:378:0x096c, LOOP_START, PHI: r5
      0x0912: PHI (r5v57 java.util.Iterator) = (r5v47 java.util.Iterator), (r5v59 java.util.Iterator) binds: [B:360:0x0910, B:378:0x096c] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #14 {all -> 0x097d, blocks: (B:359:0x090c, B:361:0x0912, B:362:0x0917, B:364:0x0928, B:366:0x0938, B:368:0x0943, B:373:0x095f, B:370:0x094a, B:372:0x0958, B:380:0x0971), top: B:479:0x090c }] */
    /* JADX WARN: Code duplicated, block: B:366:0x0938 A[Catch: all -> 0x097d, SQLiteException -> 0x0980, TryCatch #14 {all -> 0x097d, blocks: (B:359:0x090c, B:361:0x0912, B:362:0x0917, B:364:0x0928, B:366:0x0938, B:368:0x0943, B:373:0x095f, B:370:0x094a, B:372:0x0958, B:380:0x0971), top: B:479:0x090c }] */
    /* JADX WARN: Code duplicated, block: B:367:0x0941  */
    /* JADX WARN: Code duplicated, block: B:376:0x0967  */
    /* JADX WARN: Code duplicated, block: B:378:0x096c A[LOOP:3: B:361:0x0912->B:378:0x096c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:379:0x096f  */
    /* JADX WARN: Code duplicated, block: B:382:0x0977  */
    /* JADX WARN: Code duplicated, block: B:400:0x09ad  */
    /* JADX WARN: Code duplicated, block: B:402:0x09b1  */
    /* JADX WARN: Code duplicated, block: B:406:0x09c1  */
    /* JADX WARN: Code duplicated, block: B:409:0x09e6  */
    /* JADX WARN: Code duplicated, block: B:412:0x09f7  */
    /* JADX WARN: Code duplicated, block: B:414:0x0a0e  */
    /* JADX WARN: Code duplicated, block: B:416:0x0a22  */
    /* JADX WARN: Code duplicated, block: B:417:0x0a2b  */
    /* JADX WARN: Code duplicated, block: B:419:0x0a5b  */
    /* JADX WARN: Code duplicated, block: B:422:0x0a63  */
    /* JADX WARN: Code duplicated, block: B:431:0x0ab4  */
    /* JADX WARN: Code duplicated, block: B:432:0x0abd  */
    /* JADX WARN: Code duplicated, block: B:436:0x0acc A[PHI: r49
      0x0acc: PHI (r49v3 java.util.Map) = (r49v4 java.util.Map), (r0v151 java.util.Map) binds: [B:435:0x0aca, B:433:0x0abe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:442:0x0af7  */
    /* JADX WARN: Code duplicated, block: B:458:0x0b87  */
    /* JADX WARN: Code duplicated, block: B:48:0x016c A[PHI: r0 r5 r7 r50 r51
      0x016c: PHI (r0v209 java.util.Map) = (r0v211 java.util.Map), (r0v216 java.util.Map) binds: [B:60:0x0198, B:47:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r5v63 android.database.Cursor) = (r5v64 android.database.Cursor), (r5v66 android.database.Cursor) binds: [B:60:0x0198, B:47:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r7v51 java.lang.Object) = (r7v61 java.lang.Object), (r7v62 java.lang.Object) binds: [B:60:0x0198, B:47:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r50v5 ??) = (r50v15 ??), (r50v16 ??) binds: [B:60:0x0198, B:47:0x016a] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r51v5 ??) = (r51v21 ??), (r51v22 ??) binds: [B:60:0x0198, B:47:0x016a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:519:0x0965 A[EDGE_INSN: B:519:0x0965->B:375:0x0965 BREAK  A[LOOP:3: B:361:0x0912->B:378:0x096c], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:520:0x09d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:522:0x0ad5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:523:0x0a9e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:526:0x0ac8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:528:0x0b55 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:530:0x0af1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:534:0x064c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:0x0638 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:538:0x078f A[EDGE_INSN: B:538:0x078f->B:292:0x078f BREAK  A[LOOP:8: B:278:0x073c->B:295:0x0796], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:540:0x082f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:541:0x0821 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:545:0x0885 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:546:0x087b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:550:0x0604 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:557:0x04da A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:559:0x04c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:562:0x051e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:565:0x050c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:578:0x046c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x023d A[EDGE_INSN: B:597:0x023d->B:87:0x023d BREAK  A[LOOP:22: B:76:0x01f6->B:90:0x0244], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x019d  */
    /* JADX WARN: Code duplicated, block: B:71:0x01df A[Catch: SQLiteException -> 0x024f, all -> 0x0b83, TRY_LEAVE, TryCatch #20 {all -> 0x0b83, blocks: (B:69:0x01d9, B:71:0x01df, B:75:0x01ef, B:76:0x01f6, B:77:0x01ff, B:78:0x020f, B:85:0x0237, B:80:0x021c, B:82:0x022a, B:84:0x0230, B:102:0x025f), top: B:485:0x01bb }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ef A[Catch: SQLiteException -> 0x024f, all -> 0x0b83, TRY_ENTER, TryCatch #20 {all -> 0x0b83, blocks: (B:69:0x01d9, B:71:0x01df, B:75:0x01ef, B:76:0x01f6, B:77:0x01ff, B:78:0x020f, B:85:0x0237, B:80:0x021c, B:82:0x022a, B:84:0x0230, B:102:0x025f), top: B:485:0x01bb }] */
    /* JADX WARN: Code duplicated, block: B:88:0x023f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0244 A[LOOP:22: B:76:0x01f6->B:90:0x0244, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v34 */
    /* JADX WARN: Type inference failed for: r11v35, types: [int] */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r11v45 */
    /* JADX WARN: Type inference failed for: r11v46 */
    /* JADX WARN: Type inference failed for: r11v48 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v12, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r18v13 */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v16 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r50v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r50v1 */
    /* JADX WARN: Type inference failed for: r50v10 */
    /* JADX WARN: Type inference failed for: r50v11 */
    /* JADX WARN: Type inference failed for: r50v12 */
    /* JADX WARN: Type inference failed for: r50v13 */
    /* JADX WARN: Type inference failed for: r50v14 */
    /* JADX WARN: Type inference failed for: r50v15 */
    /* JADX WARN: Type inference failed for: r50v16 */
    /* JADX WARN: Type inference failed for: r50v2 */
    /* JADX WARN: Type inference failed for: r50v3 */
    /* JADX WARN: Type inference failed for: r50v4 */
    /* JADX WARN: Type inference failed for: r50v5 */
    /* JADX WARN: Type inference failed for: r50v6 */
    /* JADX WARN: Type inference failed for: r50v7 */
    /* JADX WARN: Type inference failed for: r50v9 */
    /* JADX WARN: Type inference failed for: r51v0, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r51v1 */
    /* JADX WARN: Type inference failed for: r51v16 */
    /* JADX WARN: Type inference failed for: r51v17 */
    /* JADX WARN: Type inference failed for: r51v18 */
    /* JADX WARN: Type inference failed for: r51v19 */
    /* JADX WARN: Type inference failed for: r51v2 */
    /* JADX WARN: Type inference failed for: r51v20 */
    /* JADX WARN: Type inference failed for: r51v21 */
    /* JADX WARN: Type inference failed for: r51v22 */
    /* JADX WARN: Type inference failed for: r51v3 */
    /* JADX WARN: Type inference failed for: r51v4 */
    /* JADX WARN: Type inference failed for: r51v5 */
    /* JADX WARN: Type inference failed for: r51v6 */
    /* JADX WARN: Type inference failed for: r51v7 */
    /* JADX WARN: Type inference failed for: r51v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v24, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v26, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v30, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v60 */
    /* JADX WARN: Type inference failed for: r5v62, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v70 */
    /* JADX WARN: Type inference failed for: r5v71 */
    /* JADX WARN: Type inference failed for: r5v72 */
    /* JADX WARN: Type inference failed for: r5v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v48, types: [int] */
    /* JADX WARN: Type inference failed for: r7v49, types: [android.database.Cursor] */
    final List zza(String str, List list, List list2, Long l, Long l2) throws Throwable {
        boolean z;
        ?? r11;
        boolean z2;
        ?? r5;
        ?? r51;
        ?? r50;
        Object obj;
        Map map;
        ?? r52;
        ?? r53;
        Object obj2;
        ?? r6;
        boolean z3;
        ?? Query;
        Map map2;
        boolean z4;
        HashSet hashSet;
        HashSet hashSet2;
        Map map3;
        Iterator it;
        int iIntValue;
        com.google.android.gms.internal.measurement.zzgh zzghVar;
        BitSet bitSet;
        BitSet bitSet2;
        ArrayMap arrayMap;
        com.google.android.gms.internal.measurement.zzgh zzghVar2;
        List<com.google.android.gms.internal.measurement.zzej> list3;
        int i;
        boolean z5;
        Long lValueOf;
        String str2;
        Map arrayMap2;
        SQLiteDatabase sQLiteDatabaseZzh;
        ?? r7;
        Cursor cursorRawQuery;
        ArrayMap arrayMap3;
        Iterator it2;
        com.google.android.gms.internal.measurement.zzgh zzghVar3;
        List list4;
        Map map4;
        Integer numValueOf;
        List arrayList;
        String str3;
        zzv zzvVar;
        zzw zzwVar;
        ArrayMap arrayMap4;
        Iterator it3;
        com.google.android.gms.internal.measurement.zzfs zzfsVar;
        com.google.android.gms.internal.measurement.zzfs zzfsVarZza;
        zzam zzamVarZzi;
        String str4;
        String strZzh;
        zzas zzasVarZzn;
        zzas zzasVar;
        long j;
        String strZzh2;
        Map mapEmptyMap;
        Iterator it4;
        String str5;
        Iterator it5;
        int iIntValue2;
        Set set;
        Integer numValueOf2;
        Iterator it6;
        boolean zZzd;
        Map map5;
        long j2;
        zzx zzxVar;
        String str6;
        ArrayMap arrayMap5;
        ?? r8;
        ?? r18;
        ?? Query2;
        ?? r19;
        Integer numValueOf3;
        List list5;
        ?? r110;
        List arrayList2;
        String str7;
        ArrayList arrayList3;
        Iterator it7;
        zzam zzamVarZzi2;
        String str8;
        ContentValues contentValues;
        ArrayMap arrayMap6;
        Iterator it8;
        String strZzf;
        Map mapEmptyMap2;
        Iterator it9;
        int iIntValue3;
        Set set2;
        Integer numValueOf4;
        Iterator it10;
        boolean zZzd2;
        com.google.android.gms.internal.measurement.zzes zzesVar;
        Integer numValueOf5;
        zzz zzzVar;
        Integer numValueOf6;
        zzam zzamVarZzi3;
        String str9;
        ArrayMap arrayMap7;
        Cursor cursor;
        Cursor cursorQuery;
        Integer numValueOf7;
        List list6;
        List arrayList4;
        ArrayMap arrayMap8;
        ?? r12;
        boolean z6;
        int i2;
        Cursor cursorQuery2;
        ?? r54;
        ?? r55;
        Object obj3;
        boolean z7;
        List arrayList5;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it11 = list.iterator();
        while (true) {
            z = false;
            z = false;
            r11 = 1;
            r11 = 1;
            if (!it11.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((com.google.android.gms.internal.measurement.zzfs) it11.next()).zzh())) {
                z2 = true;
                break;
            }
        }
        zzoe.zzc();
        boolean zZzs = this.zzs.zzf().zzs(this.zza, zzeh.zzW);
        zzoe.zzc();
        boolean zZzs2 = this.zzs.zzf().zzs(this.zza, zzeh.zzV);
        if (z2) {
            zzam zzamVarZzi4 = this.zzf.zzi();
            String str10 = this.zza;
            zzamVarZzi4.zzW();
            zzamVarZzi4.zzg();
            Preconditions.checkNotEmpty(str10);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                SQLiteDatabase sQLiteDatabaseZzh2 = zzamVarZzi4.zzh();
                sQLiteDatabaseZzh2.update("events", contentValues2, "app_id = ?", new String[]{str10});
                r5 = sQLiteDatabaseZzh2;
            } catch (SQLiteException e) {
                zzamVarZzi4.zzs.zzay().zzd().zzc("Error resetting session-scoped event counts. appId", zzeu.zzn(str10), e);
                r5 = "Error resetting session-scoped event counts. appId";
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str11 = "audience_id";
        try {
            try {
                try {
                    if (zZzs2 && zZzs) {
                        zzam zzamVarZzi5 = this.zzf.zzi();
                        String str12 = this.zza;
                        Preconditions.checkNotEmpty(str12);
                        ArrayMap arrayMap9 = new ArrayMap();
                        try {
                            try {
                                cursorQuery2 = zzamVarZzi5.zzh().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str12}, null, null, null);
                                try {
                                    try {
                                        if (cursorQuery2.moveToFirst()) {
                                            while (true) {
                                                byte[] blob = cursorQuery2.getBlob(r11 == true ? 1 : 0);
                                                l = r11 == true ? 1 : 0;
                                                try {
                                                    try {
                                                        com.google.android.gms.internal.measurement.zzej zzejVar = (com.google.android.gms.internal.measurement.zzej) ((com.google.android.gms.internal.measurement.zzei) zzlh.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), blob)).zzaE();
                                                        if (zzejVar.zzo()) {
                                                            Integer numValueOf8 = Integer.valueOf(cursorQuery2.getInt(z ? 1 : 0));
                                                            List list7 = (List) arrayMap9.get(numValueOf8);
                                                            if (list7 == null) {
                                                                arrayList5 = new ArrayList();
                                                                arrayMap9.put(numValueOf8, arrayList5);
                                                            } else {
                                                                arrayList5 = list7;
                                                            }
                                                            arrayList5.add(zzejVar);
                                                            z7 = z;
                                                        } else {
                                                            z7 = z ? 1 : 0;
                                                        }
                                                    } catch (IOException e2) {
                                                        z7 = z ? 1 : 0;
                                                        zzamVarZzi5.zzs.zzay().zzd().zzc("Failed to merge filter. appId", zzeu.zzn(str12), e2);
                                                    }
                                                    if (!cursorQuery2.moveToNext()) {
                                                        break;
                                                    }
                                                    r11 = l;
                                                    z = z7;
                                                } catch (SQLiteException e3) {
                                                    e = e3;
                                                    l2 = z ? 1 : 0;
                                                    zzes zzesVarZzd = zzamVarZzi5.zzs.zzay().zzd();
                                                    Object objZzn = zzeu.zzn(str12);
                                                    zzesVarZzd.zzc("Database error querying filters. appId", objZzn, e);
                                                    mapEmptyMap3 = Collections.emptyMap();
                                                    obj = objZzn;
                                                    r50 = l;
                                                    r51 = l2;
                                                    obj3 = objZzn;
                                                    r55 = l;
                                                    r54 = l2;
                                                    if (cursorQuery2 != null) {
                                                        cursorQuery2.close();
                                                        obj = obj3;
                                                        r50 = r55;
                                                        r51 = r54;
                                                    }
                                                    map = mapEmptyMap3;
                                                    obj2 = obj;
                                                    r53 = r50;
                                                    r52 = r51;
                                                }
                                            }
                                            if (cursorQuery2 != null) {
                                                cursorQuery2.close();
                                            }
                                            map = arrayMap9;
                                            obj2 = str12;
                                            r53 = l;
                                            r52 = z7;
                                        } else {
                                            mapEmptyMap3 = Collections.emptyMap();
                                            obj = str12;
                                            r50 = true;
                                            r51 = false;
                                            obj3 = str12;
                                            r55 = true;
                                            r54 = false;
                                            if (cursorQuery2 != null) {
                                                cursorQuery2.close();
                                                obj = obj3;
                                                r50 = r55;
                                                r51 = r54;
                                            }
                                        }
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                    }
                                } catch (SQLiteException e5) {
                                    e = e5;
                                    l2 = z;
                                    l = r11;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (r5 != 0) {
                                    r5.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteException e6) {
                            e = e6;
                            l2 = 0;
                            l = 1;
                            cursorQuery2 = null;
                        } catch (Throwable th2) {
                            th = th2;
                            r5 = 0;
                            if (r5 != 0) {
                                r5.close();
                            }
                            throw th;
                        }
                        zzam zzamVarZzi6 = this.zzf.zzi();
                        String str13 = this.zza;
                        zzamVarZzi6.zzW();
                        zzamVarZzi6.zzg();
                        Preconditions.checkNotEmpty(str13);
                        SQLiteDatabase sQLiteDatabaseZzh3 = zzamVarZzi6.zzh();
                        String[] strArr = new String[2];
                        strArr[r52] = "audience_id";
                        strArr[r53] = "current_results";
                        String[] strArr2 = new String[r53];
                        strArr2[r52] = str13;
                        Query = sQLiteDatabaseZzh3.query("audience_filter_values", strArr, "app_id=?", strArr2, null, null, null);
                        if (Query.moveToFirst()) {
                            arrayMap8 = new ArrayMap();
                            r12 = r52;
                            z6 = z2;
                            while (true) {
                                i2 = Query.getInt(r12);
                                try {
                                    arrayMap8.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzgh) ((com.google.android.gms.internal.measurement.zzgg) zzlh.zzl(com.google.android.gms.internal.measurement.zzgh.zzf(), Query.getBlob(1))).zzaE());
                                    z3 = z6;
                                } catch (IOException e7) {
                                    z3 = z6;
                                    try {
                                        zzamVarZzi6.zzs.zzay().zzd().zzd("Failed to merge filter results. appId, audienceId, error", zzeu.zzn(str13), Integer.valueOf(i2), e7);
                                        z3 = z3;
                                    } catch (SQLiteException e8) {
                                        e = e8;
                                        str11 = str11;
                                        zzamVarZzi6.zzs.zzay().zzd().zzc("Database error querying filter results. appId", zzeu.zzn(str13), e);
                                        Map mapEmptyMap4 = Collections.emptyMap();
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        map2 = mapEmptyMap4;
                                        z4 = z3;
                                        if (!map2.isEmpty()) {
                                            hashSet = new HashSet(map2.keySet());
                                            if (z4) {
                                                String str14 = this.zza;
                                                zzam zzamVarZzi7 = this.zzf.zzi();
                                                str2 = this.zza;
                                                zzamVarZzi7.zzW();
                                                zzamVarZzi7.zzg();
                                                Preconditions.checkNotEmpty(str2);
                                                arrayMap2 = new ArrayMap();
                                                sQLiteDatabaseZzh = zzamVarZzi7.zzh();
                                                try {
                                                    try {
                                                        cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str2, str2});
                                                        try {
                                                            if (cursorRawQuery.moveToFirst()) {
                                                                do {
                                                                    numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                                    arrayList = (List) arrayMap2.get(numValueOf);
                                                                    if (arrayList == null) {
                                                                        arrayList = new ArrayList();
                                                                        arrayMap2.put(numValueOf, arrayList);
                                                                    }
                                                                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                                } while (cursorRawQuery.moveToNext());
                                                                if (cursorRawQuery != null) {
                                                                    cursorRawQuery.close();
                                                                }
                                                            } else {
                                                                arrayMap2 = Collections.emptyMap();
                                                                if (cursorRawQuery != null) {
                                                                    cursorRawQuery.close();
                                                                }
                                                            }
                                                        } catch (SQLiteException e9) {
                                                            e = e9;
                                                            zzamVarZzi7.zzs.zzay().zzd().zzc("Database error querying scoped filters. appId", zzeu.zzn(str2), e);
                                                            arrayMap2 = Collections.emptyMap();
                                                            if (cursorRawQuery != null) {
                                                            }
                                                            Preconditions.checkNotEmpty(str14);
                                                            Preconditions.checkNotNull(map2);
                                                            arrayMap3 = new ArrayMap();
                                                            if (!map2.isEmpty()) {
                                                                it2 = map2.keySet().iterator();
                                                                while (it2.hasNext()) {
                                                                    int iIntValue4 = ((Integer) it2.next()).intValue();
                                                                    Integer numValueOf9 = Integer.valueOf(iIntValue4);
                                                                    zzghVar3 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf9);
                                                                    list4 = (List) arrayMap2.get(numValueOf9);
                                                                    if (list4 != null) {
                                                                    }
                                                                    map4 = arrayMap2;
                                                                    arrayMap3.put(numValueOf9, zzghVar3);
                                                                    arrayMap2 = map4;
                                                                    hashSet = hashSet;
                                                                    it2 = it2;
                                                                }
                                                            }
                                                            hashSet2 = hashSet;
                                                            map3 = arrayMap3;
                                                            it = hashSet2.iterator();
                                                            while (it.hasNext()) {
                                                                iIntValue = ((Integer) it.next()).intValue();
                                                                zzghVar = (com.google.android.gms.internal.measurement.zzgh) map3.get(Integer.valueOf(iIntValue));
                                                                bitSet = new BitSet();
                                                                bitSet2 = new BitSet();
                                                                arrayMap = new ArrayMap();
                                                                if (zzghVar != null) {
                                                                    for (com.google.android.gms.internal.measurement.zzfq zzfqVar : zzghVar.zzj()) {
                                                                        if (zzfqVar.zzh()) {
                                                                            Integer numValueOf10 = Integer.valueOf(zzfqVar.zza());
                                                                            if (zzfqVar.zzg()) {
                                                                                lValueOf = Long.valueOf(zzfqVar.zzb());
                                                                            } else {
                                                                                lValueOf = null;
                                                                            }
                                                                            arrayMap.put(numValueOf10, lValueOf);
                                                                        }
                                                                    }
                                                                }
                                                                ArrayMap arrayMap10 = new ArrayMap();
                                                                if (zzghVar != null) {
                                                                    for (com.google.android.gms.internal.measurement.zzgj zzgjVar : zzghVar.zzm()) {
                                                                        if (!zzgjVar.zzi()) {
                                                                        }
                                                                    }
                                                                }
                                                                Map map6 = map3;
                                                                zzghVar2 = zzghVar;
                                                                if (zzghVar2 != null) {
                                                                    i = 0;
                                                                    while (i < zzghVar2.zzd() * 64) {
                                                                        if (zzlh.zzv(zzghVar2.zzn(), i)) {
                                                                            z5 = zZzs;
                                                                            this.zzs.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                                                            bitSet2.set(i);
                                                                            if (zzlh.zzv(zzghVar2.zzk(), i)) {
                                                                                bitSet.set(i);
                                                                            }
                                                                            i++;
                                                                            zZzs = z5;
                                                                        } else {
                                                                            z5 = zZzs;
                                                                        }
                                                                        arrayMap.remove(Integer.valueOf(i));
                                                                        i++;
                                                                        zZzs = z5;
                                                                    }
                                                                }
                                                                boolean z8 = zZzs;
                                                                Integer numValueOf11 = Integer.valueOf(iIntValue);
                                                                com.google.android.gms.internal.measurement.zzgh zzghVar4 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf11);
                                                                if (!zZzs2) {
                                                                }
                                                                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzghVar4, bitSet, bitSet2, arrayMap, arrayMap10, null));
                                                                zZzs = z8;
                                                                map3 = map6;
                                                            }
                                                            str3 = str11;
                                                            zzvVar = null;
                                                            if (!list.isEmpty()) {
                                                                zzwVar = new zzw(this, zzvVar);
                                                                arrayMap4 = new ArrayMap();
                                                                it3 = list.iterator();
                                                                while (it3.hasNext()) {
                                                                    zzfsVar = (com.google.android.gms.internal.measurement.zzfs) it3.next();
                                                                    zzfsVarZza = zzwVar.zza(this.zza, zzfsVar);
                                                                    if (zzfsVarZza != null) {
                                                                        zzamVarZzi = this.zzf.zzi();
                                                                        str4 = this.zza;
                                                                        strZzh = zzfsVarZza.zzh();
                                                                        zzasVarZzn = zzamVarZzi.zzn(str4, zzfsVar.zzh());
                                                                        if (zzasVarZzn == null) {
                                                                            zzamVarZzi.zzs.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeu.zzn(str4), zzamVarZzi.zzs.zzj().zzd(strZzh));
                                                                            zzasVar = new zzas(str4, zzfsVar.zzh(), 1L, 1L, 1L, zzfsVar.zzd(), 0L, null, null, null, null);
                                                                        } else {
                                                                            zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                                        }
                                                                        this.zzf.zzi().zzE(zzasVar);
                                                                        j = zzasVar.zzc;
                                                                        strZzh2 = zzfsVarZza.zzh();
                                                                        mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                                                                        if (mapEmptyMap == null) {
                                                                            zzam zzamVarZzi8 = this.zzf.zzi();
                                                                            str6 = this.zza;
                                                                            zzamVarZzi8.zzW();
                                                                            zzamVarZzi8.zzg();
                                                                            Preconditions.checkNotEmpty(str6);
                                                                            Preconditions.checkNotEmpty(strZzh2);
                                                                            arrayMap5 = new ArrayMap();
                                                                            SQLiteDatabase sQLiteDatabaseZzh4 = zzamVarZzi8.zzh();
                                                                            try {
                                                                                try {
                                                                                    String[] strArr3 = new String[2];
                                                                                    str5 = str3;
                                                                                    try {
                                                                                        strArr3[0] = str5;
                                                                                        r18 = 1;
                                                                                        strArr3[1] = "data";
                                                                                        it4 = it3;
                                                                                        try {
                                                                                            Query2 = sQLiteDatabaseZzh4.query("event_filters", strArr3, "app_id=? AND event_name=?", new String[]{str6, strZzh2}, null, null, null);
                                                                                            try {
                                                                                                try {
                                                                                                    if (Query2.moveToFirst()) {
                                                                                                        zzasVar = zzasVar;
                                                                                                        Query2 = Query2;
                                                                                                        while (true) {
                                                                                                            try {
                                                                                                                try {
                                                                                                                    com.google.android.gms.internal.measurement.zzej zzejVar2 = (com.google.android.gms.internal.measurement.zzej) ((com.google.android.gms.internal.measurement.zzei) zzlh.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), Query2.getBlob(1))).zzaE();
                                                                                                                    numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                                                                                                    list5 = (List) arrayMap5.get(numValueOf3);
                                                                                                                    if (list5 == null) {
                                                                                                                        r18 = Query2;
                                                                                                                        try {
                                                                                                                            arrayList2 = new ArrayList();
                                                                                                                            arrayMap5.put(numValueOf3, arrayList2);
                                                                                                                            r110 = r18;
                                                                                                                        } catch (SQLiteException e10) {
                                                                                                                            e = e10;
                                                                                                                            r8 = r18;
                                                                                                                            try {
                                                                                                                                zzamVarZzi8.zzs.zzay().zzd().zzc("Database error querying filters. appId", zzeu.zzn(str6), e);
                                                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                                                if (r8 != 0) {
                                                                                                                                    r8.close();
                                                                                                                                }
                                                                                                                            } catch (Throwable th3) {
                                                                                                                                th = th3;
                                                                                                                                if (r8 != 0) {
                                                                                                                                    r8.close();
                                                                                                                                }
                                                                                                                                throw th;
                                                                                                                            }
                                                                                                                        } catch (Throwable th4) {
                                                                                                                            th = th4;
                                                                                                                            r8 = r18;
                                                                                                                            if (r8 != 0) {
                                                                                                                                r8.close();
                                                                                                                            }
                                                                                                                            throw th;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        r110 = Query2;
                                                                                                                        arrayList2 = list5;
                                                                                                                    }
                                                                                                                    arrayList2.add(zzejVar2);
                                                                                                                    r19 = r110;
                                                                                                                } catch (IOException e11) {
                                                                                                                    r19 = Query2;
                                                                                                                    zzamVarZzi8.zzs.zzay().zzd().zzc("Failed to merge filter. appId", zzeu.zzn(str6), e11);
                                                                                                                }
                                                                                                                if (!r19.moveToNext()) {
                                                                                                                    break;
                                                                                                                }
                                                                                                                Query2 = r19;
                                                                                                                r18 = r19;
                                                                                                            } catch (SQLiteException e12) {
                                                                                                                e = e12;
                                                                                                                r18 = Query2;
                                                                                                            }
                                                                                                        }
                                                                                                        if (r19 != 0) {
                                                                                                            r19.close();
                                                                                                        }
                                                                                                        mapEmptyMap = arrayMap5;
                                                                                                    } else {
                                                                                                        zzasVar = zzasVar;
                                                                                                        mapEmptyMap = Collections.emptyMap();
                                                                                                        if (Query2 != 0) {
                                                                                                            Query2.close();
                                                                                                        }
                                                                                                    }
                                                                                                } catch (Throwable th5) {
                                                                                                    th = th5;
                                                                                                    r18 = Query2;
                                                                                                }
                                                                                            } catch (SQLiteException e13) {
                                                                                                e = e13;
                                                                                                r18 = Query2;
                                                                                                zzasVar = zzasVar;
                                                                                            }
                                                                                        } catch (SQLiteException e14) {
                                                                                            e = e14;
                                                                                            r8 = 0;
                                                                                            zzamVarZzi8.zzs.zzay().zzd().zzc("Database error querying filters. appId", zzeu.zzn(str6), e);
                                                                                            mapEmptyMap = Collections.emptyMap();
                                                                                            if (r8 != 0) {
                                                                                                r8.close();
                                                                                            }
                                                                                            arrayMap4.put(strZzh2, mapEmptyMap);
                                                                                            it5 = mapEmptyMap.keySet().iterator();
                                                                                            while (it5.hasNext()) {
                                                                                                iIntValue2 = ((Integer) it5.next()).intValue();
                                                                                                set = this.zzb;
                                                                                                numValueOf2 = Integer.valueOf(iIntValue2);
                                                                                                if (set.contains(numValueOf2)) {
                                                                                                    this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                                                } else {
                                                                                                    it6 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                                                                    zZzd = true;
                                                                                                    while (true) {
                                                                                                        if (!it6.hasNext()) {
                                                                                                            map5 = mapEmptyMap;
                                                                                                            j2 = j;
                                                                                                            break;
                                                                                                        }
                                                                                                        com.google.android.gms.internal.measurement.zzej zzejVar3 = (com.google.android.gms.internal.measurement.zzej) it6.next();
                                                                                                        zzxVar = new zzx(this, this.zza, iIntValue2, zzejVar3);
                                                                                                        map5 = mapEmptyMap;
                                                                                                        j2 = j;
                                                                                                        zZzd = zzxVar.zzd(this.zzd, this.zze, zzfsVarZza, j2, zzasVar, zzf(iIntValue2, zzejVar3.zzb()));
                                                                                                        if (!zZzd) {
                                                                                                            this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                            break;
                                                                                                        }
                                                                                                        zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                                        j = j2;
                                                                                                        mapEmptyMap = map5;
                                                                                                    }
                                                                                                    if (!zZzd) {
                                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                                    }
                                                                                                    j = j2;
                                                                                                    mapEmptyMap = map5;
                                                                                                }
                                                                                            }
                                                                                            it3 = it4;
                                                                                            str3 = str5;
                                                                                            zzwVar = zzwVar;
                                                                                        }
                                                                                    } catch (SQLiteException e15) {
                                                                                        e = e15;
                                                                                        it4 = it3;
                                                                                    }
                                                                                } catch (Throwable th6) {
                                                                                    th = th6;
                                                                                    r8 = 0;
                                                                                }
                                                                            } catch (SQLiteException e16) {
                                                                                e = e16;
                                                                                it4 = it3;
                                                                                str5 = str3;
                                                                            }
                                                                            arrayMap4.put(strZzh2, mapEmptyMap);
                                                                        } else {
                                                                            it4 = it3;
                                                                            zzasVar = zzasVar;
                                                                            str5 = str3;
                                                                        }
                                                                        it5 = mapEmptyMap.keySet().iterator();
                                                                        while (it5.hasNext()) {
                                                                            iIntValue2 = ((Integer) it5.next()).intValue();
                                                                            set = this.zzb;
                                                                            numValueOf2 = Integer.valueOf(iIntValue2);
                                                                            if (set.contains(numValueOf2)) {
                                                                                this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                                            } else {
                                                                                it6 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                                                zZzd = true;
                                                                                while (true) {
                                                                                    if (!it6.hasNext()) {
                                                                                        map5 = mapEmptyMap;
                                                                                        j2 = j;
                                                                                        break;
                                                                                    }
                                                                                    com.google.android.gms.internal.measurement.zzej zzejVar4 = (com.google.android.gms.internal.measurement.zzej) it6.next();
                                                                                    zzxVar = new zzx(this, this.zza, iIntValue2, zzejVar4);
                                                                                    map5 = mapEmptyMap;
                                                                                    j2 = j;
                                                                                    zZzd = zzxVar.zzd(this.zzd, this.zze, zzfsVarZza, j2, zzasVar, zzf(iIntValue2, zzejVar4.zzb()));
                                                                                    if (!zZzd) {
                                                                                        this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                        break;
                                                                                    }
                                                                                    zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                                    j = j2;
                                                                                    mapEmptyMap = map5;
                                                                                }
                                                                                if (!zZzd) {
                                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                                }
                                                                                j = j2;
                                                                                mapEmptyMap = map5;
                                                                            }
                                                                        }
                                                                        it3 = it4;
                                                                        str3 = str5;
                                                                        zzwVar = zzwVar;
                                                                    }
                                                                }
                                                            }
                                                            str7 = str3;
                                                            if (!list2.isEmpty()) {
                                                                arrayMap6 = new ArrayMap();
                                                                it8 = list2.iterator();
                                                                while (it8.hasNext()) {
                                                                    com.google.android.gms.internal.measurement.zzgl zzglVar = (com.google.android.gms.internal.measurement.zzgl) it8.next();
                                                                    strZzf = zzglVar.zzf();
                                                                    mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                                                                    if (mapEmptyMap2 == null) {
                                                                        zzamVarZzi3 = this.zzf.zzi();
                                                                        str9 = this.zza;
                                                                        zzamVarZzi3.zzW();
                                                                        zzamVarZzi3.zzg();
                                                                        Preconditions.checkNotEmpty(str9);
                                                                        Preconditions.checkNotEmpty(strZzf);
                                                                        arrayMap7 = new ArrayMap();
                                                                        try {
                                                                            cursorQuery = zzamVarZzi3.zzh().query("property_filters", new String[]{str7, "data"}, "app_id=? AND property_name=?", new String[]{str9, strZzf}, null, null, null);
                                                                            try {
                                                                                try {
                                                                                    if (cursorQuery.moveToFirst()) {
                                                                                        while (true) {
                                                                                            try {
                                                                                                com.google.android.gms.internal.measurement.zzes zzesVar2 = (com.google.android.gms.internal.measurement.zzes) ((com.google.android.gms.internal.measurement.zzer) zzlh.zzl(com.google.android.gms.internal.measurement.zzes.zzc(), cursorQuery.getBlob(1))).zzaE();
                                                                                                numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                                                                                list6 = (List) arrayMap7.get(numValueOf7);
                                                                                                if (list6 == null) {
                                                                                                    arrayList4 = new ArrayList();
                                                                                                    arrayMap7.put(numValueOf7, arrayList4);
                                                                                                } else {
                                                                                                    arrayList4 = list6;
                                                                                                }
                                                                                                arrayList4.add(zzesVar2);
                                                                                            } catch (IOException e17) {
                                                                                                zzamVarZzi3.zzs.zzay().zzd().zzc("Failed to merge filter", zzeu.zzn(str9), e17);
                                                                                            }
                                                                                            try {
                                                                                                if (!cursorQuery.moveToNext()) {
                                                                                                    break;
                                                                                                }
                                                                                                it8 = it8;
                                                                                            } catch (SQLiteException e18) {
                                                                                                e = e18;
                                                                                                cursor = cursorQuery;
                                                                                                try {
                                                                                                    zzamVarZzi3.zzs.zzay().zzd().zzc("Database error querying filters. appId", zzeu.zzn(str9), e);
                                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                                    if (cursor != null) {
                                                                                                        cursor.close();
                                                                                                    }
                                                                                                } catch (Throwable th7) {
                                                                                                    th = th7;
                                                                                                    if (cursor != null) {
                                                                                                        cursor.close();
                                                                                                    }
                                                                                                    throw th;
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        if (cursorQuery != null) {
                                                                                            cursorQuery.close();
                                                                                        }
                                                                                        mapEmptyMap2 = arrayMap7;
                                                                                    } else {
                                                                                        it8 = it8;
                                                                                        mapEmptyMap2 = Collections.emptyMap();
                                                                                        if (cursorQuery != null) {
                                                                                            cursorQuery.close();
                                                                                        }
                                                                                    }
                                                                                } catch (Throwable th8) {
                                                                                    th = th8;
                                                                                    cursor = cursorQuery;
                                                                                    if (cursor != null) {
                                                                                        cursor.close();
                                                                                    }
                                                                                    throw th;
                                                                                }
                                                                            } catch (SQLiteException e19) {
                                                                                e = e19;
                                                                                it8 = it8;
                                                                            }
                                                                        } catch (SQLiteException e20) {
                                                                            e = e20;
                                                                            it8 = it8;
                                                                            cursor = null;
                                                                        } catch (Throwable th9) {
                                                                            th = th9;
                                                                            cursor = null;
                                                                        }
                                                                        arrayMap6.put(strZzf, mapEmptyMap2);
                                                                    } else {
                                                                        it8 = it8;
                                                                    }
                                                                    it9 = mapEmptyMap2.keySet().iterator();
                                                                    while (it9.hasNext()) {
                                                                        iIntValue3 = ((Integer) it9.next()).intValue();
                                                                        set2 = this.zzb;
                                                                        numValueOf4 = Integer.valueOf(iIntValue3);
                                                                        if (set2.contains(numValueOf4)) {
                                                                            this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                                            break;
                                                                        }
                                                                        it10 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                                        zZzd2 = true;
                                                                        while (true) {
                                                                            if (it10.hasNext()) {
                                                                                zzesVar = (com.google.android.gms.internal.measurement.zzes) it10.next();
                                                                                if (Log.isLoggable(this.zzs.zzay().zzq(), 2)) {
                                                                                    zzes zzesVarZzj = this.zzs.zzay().zzj();
                                                                                    Integer numValueOf12 = Integer.valueOf(iIntValue3);
                                                                                    if (zzesVar.zzj()) {
                                                                                        numValueOf6 = Integer.valueOf(zzesVar.zza());
                                                                                    } else {
                                                                                        numValueOf6 = null;
                                                                                    }
                                                                                    zzesVarZzj.zzd("Evaluating filter. audience, filter, property", numValueOf12, numValueOf6, this.zzs.zzj().zzf(zzesVar.zze()));
                                                                                    this.zzs.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzesVar));
                                                                                }
                                                                                if (zzesVar.zzj()) {
                                                                                }
                                                                                zzes zzesVarZzk = this.zzs.zzay().zzk();
                                                                                Object objZzn2 = zzeu.zzn(this.zza);
                                                                                if (zzesVar.zzj()) {
                                                                                    numValueOf5 = Integer.valueOf(zzesVar.zza());
                                                                                } else {
                                                                                    numValueOf5 = null;
                                                                                }
                                                                                zzesVarZzk.zzc("Invalid property filter ID. appId, id", objZzn2, String.valueOf(numValueOf5));
                                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                            } else {
                                                                                mapEmptyMap2 = mapEmptyMap2;
                                                                            }
                                                                            if (!zZzd2) {
                                                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                                            }
                                                                            mapEmptyMap2 = mapEmptyMap2;
                                                                            zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                                            mapEmptyMap2 = mapEmptyMap2;
                                                                        }
                                                                    }
                                                                    it8 = it8;
                                                                }
                                                            }
                                                            arrayList3 = new ArrayList();
                                                            Set setKeySet = this.zzc.keySet();
                                                            setKeySet.removeAll(this.zzb);
                                                            it7 = setKeySet.iterator();
                                                            while (it7.hasNext()) {
                                                                int iIntValue5 = ((Integer) it7.next()).intValue();
                                                                Map map7 = this.zzc;
                                                                Integer numValueOf13 = Integer.valueOf(iIntValue5);
                                                                zzu zzuVar = (zzu) map7.get(numValueOf13);
                                                                Preconditions.checkNotNull(zzuVar);
                                                                com.google.android.gms.internal.measurement.zzfo zzfoVarZza = zzuVar.zza(iIntValue5);
                                                                arrayList3.add(zzfoVarZza);
                                                                zzamVarZzi2 = this.zzf.zzi();
                                                                str8 = this.zza;
                                                                com.google.android.gms.internal.measurement.zzgh zzghVarZzd = zzfoVarZza.zzd();
                                                                zzamVarZzi2.zzW();
                                                                zzamVarZzi2.zzg();
                                                                Preconditions.checkNotEmpty(str8);
                                                                Preconditions.checkNotNull(zzghVarZzd);
                                                                byte[] bArrZzbv = zzghVarZzd.zzbv();
                                                                contentValues = new ContentValues();
                                                                contentValues.put("app_id", str8);
                                                                contentValues.put(str7, numValueOf13);
                                                                contentValues.put("current_results", bArrZzbv);
                                                                try {
                                                                    try {
                                                                        if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                            zzamVarZzi2.zzs.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeu.zzn(str8));
                                                                        }
                                                                    } catch (SQLiteException e21) {
                                                                        e = e21;
                                                                        zzamVarZzi2.zzs.zzay().zzd().zzc("Error storing filter results. appId", zzeu.zzn(str8), e);
                                                                    }
                                                                } catch (SQLiteException e22) {
                                                                    e = e22;
                                                                }
                                                            }
                                                            return arrayList3;
                                                        }
                                                    } catch (Throwable th10) {
                                                        th = th10;
                                                        r7 = sQLiteDatabaseZzh;
                                                        if (r7 != 0) {
                                                            r7.close();
                                                        }
                                                        throw th;
                                                    }
                                                } catch (SQLiteException e23) {
                                                    e = e23;
                                                    cursorRawQuery = null;
                                                } catch (Throwable th11) {
                                                    th = th11;
                                                    r7 = 0;
                                                    if (r7 != 0) {
                                                        r7.close();
                                                    }
                                                    throw th;
                                                }
                                                Preconditions.checkNotEmpty(str14);
                                                Preconditions.checkNotNull(map2);
                                                arrayMap3 = new ArrayMap();
                                                if (!map2.isEmpty()) {
                                                    it2 = map2.keySet().iterator();
                                                    while (it2.hasNext()) {
                                                        int iIntValue6 = ((Integer) it2.next()).intValue();
                                                        Integer numValueOf14 = Integer.valueOf(iIntValue6);
                                                        zzghVar3 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf14);
                                                        list4 = (List) arrayMap2.get(numValueOf14);
                                                        if (list4 != null) {
                                                        }
                                                        map4 = arrayMap2;
                                                        arrayMap3.put(numValueOf14, zzghVar3);
                                                        arrayMap2 = map4;
                                                        hashSet = hashSet;
                                                        it2 = it2;
                                                    }
                                                }
                                                hashSet2 = hashSet;
                                                map3 = arrayMap3;
                                            } else {
                                                hashSet2 = hashSet;
                                                map3 = map2;
                                            }
                                            it = hashSet2.iterator();
                                            while (it.hasNext()) {
                                                iIntValue = ((Integer) it.next()).intValue();
                                                zzghVar = (com.google.android.gms.internal.measurement.zzgh) map3.get(Integer.valueOf(iIntValue));
                                                bitSet = new BitSet();
                                                bitSet2 = new BitSet();
                                                arrayMap = new ArrayMap();
                                                if (zzghVar != null) {
                                                    while (r3.hasNext()) {
                                                        if (zzfqVar.zzh()) {
                                                            Integer numValueOf15 = Integer.valueOf(zzfqVar.zza());
                                                            if (zzfqVar.zzg()) {
                                                                lValueOf = Long.valueOf(zzfqVar.zzb());
                                                            } else {
                                                                lValueOf = null;
                                                            }
                                                            arrayMap.put(numValueOf15, lValueOf);
                                                        }
                                                    }
                                                }
                                                ArrayMap arrayMap11 = new ArrayMap();
                                                if (zzghVar != null) {
                                                    while (r3.hasNext()) {
                                                        if (!zzgjVar.zzi()) {
                                                        }
                                                    }
                                                }
                                                Map map8 = map3;
                                                zzghVar2 = zzghVar;
                                                if (zzghVar2 != null) {
                                                    i = 0;
                                                    while (i < zzghVar2.zzd() * 64) {
                                                        if (zzlh.zzv(zzghVar2.zzn(), i)) {
                                                            z5 = zZzs;
                                                            this.zzs.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                                            bitSet2.set(i);
                                                            if (zzlh.zzv(zzghVar2.zzk(), i)) {
                                                                bitSet.set(i);
                                                            }
                                                            i++;
                                                            zZzs = z5;
                                                        } else {
                                                            z5 = zZzs;
                                                        }
                                                        arrayMap.remove(Integer.valueOf(i));
                                                        i++;
                                                        zZzs = z5;
                                                    }
                                                }
                                                boolean z9 = zZzs;
                                                Integer numValueOf16 = Integer.valueOf(iIntValue);
                                                com.google.android.gms.internal.measurement.zzgh zzghVar5 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf16);
                                                if (!zZzs2) {
                                                }
                                                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzghVar5, bitSet, bitSet2, arrayMap, arrayMap11, null));
                                                zZzs = z9;
                                                map3 = map8;
                                            }
                                        }
                                        str3 = str11;
                                        zzvVar = null;
                                        if (!list.isEmpty()) {
                                            zzwVar = new zzw(this, zzvVar);
                                            arrayMap4 = new ArrayMap();
                                            it3 = list.iterator();
                                            while (it3.hasNext()) {
                                                zzfsVar = (com.google.android.gms.internal.measurement.zzfs) it3.next();
                                                zzfsVarZza = zzwVar.zza(this.zza, zzfsVar);
                                                if (zzfsVarZza != null) {
                                                    zzamVarZzi = this.zzf.zzi();
                                                    str4 = this.zza;
                                                    strZzh = zzfsVarZza.zzh();
                                                    zzasVarZzn = zzamVarZzi.zzn(str4, zzfsVar.zzh());
                                                    if (zzasVarZzn == null) {
                                                        zzamVarZzi.zzs.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeu.zzn(str4), zzamVarZzi.zzs.zzj().zzd(strZzh));
                                                        zzasVar = new zzas(str4, zzfsVar.zzh(), 1L, 1L, 1L, zzfsVar.zzd(), 0L, null, null, null, null);
                                                    } else {
                                                        zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                    }
                                                    this.zzf.zzi().zzE(zzasVar);
                                                    j = zzasVar.zzc;
                                                    strZzh2 = zzfsVarZza.zzh();
                                                    mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                                                    if (mapEmptyMap == null) {
                                                        zzam zzamVarZzi9 = this.zzf.zzi();
                                                        str6 = this.zza;
                                                        zzamVarZzi9.zzW();
                                                        zzamVarZzi9.zzg();
                                                        Preconditions.checkNotEmpty(str6);
                                                        Preconditions.checkNotEmpty(strZzh2);
                                                        arrayMap5 = new ArrayMap();
                                                        SQLiteDatabase sQLiteDatabaseZzh5 = zzamVarZzi9.zzh();
                                                        String[] strArr4 = new String[2];
                                                        str5 = str3;
                                                        strArr4[0] = str5;
                                                        r18 = 1;
                                                        strArr4[1] = "data";
                                                        it4 = it3;
                                                        Query2 = sQLiteDatabaseZzh5.query("event_filters", strArr4, "app_id=? AND event_name=?", new String[]{str6, strZzh2}, null, null, null);
                                                        if (Query2.moveToFirst()) {
                                                            zzasVar = zzasVar;
                                                            Query2 = Query2;
                                                            while (true) {
                                                                com.google.android.gms.internal.measurement.zzej zzejVar5 = (com.google.android.gms.internal.measurement.zzej) ((com.google.android.gms.internal.measurement.zzei) zzlh.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), Query2.getBlob(1))).zzaE();
                                                                numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                                                list5 = (List) arrayMap5.get(numValueOf3);
                                                                if (list5 == null) {
                                                                    r18 = Query2;
                                                                    arrayList2 = new ArrayList();
                                                                    arrayMap5.put(numValueOf3, arrayList2);
                                                                    r110 = r18;
                                                                } else {
                                                                    r110 = Query2;
                                                                    arrayList2 = list5;
                                                                }
                                                                arrayList2.add(zzejVar5);
                                                                r19 = r110;
                                                                if (!r19.moveToNext()) {
                                                                    break;
                                                                    break;
                                                                }
                                                                Query2 = r19;
                                                                r18 = r19;
                                                            }
                                                            if (r19 != 0) {
                                                                r19.close();
                                                            }
                                                            mapEmptyMap = arrayMap5;
                                                        } else {
                                                            zzasVar = zzasVar;
                                                            mapEmptyMap = Collections.emptyMap();
                                                            if (Query2 != 0) {
                                                                Query2.close();
                                                            }
                                                        }
                                                        arrayMap4.put(strZzh2, mapEmptyMap);
                                                    } else {
                                                        it4 = it3;
                                                        zzasVar = zzasVar;
                                                        str5 = str3;
                                                    }
                                                    it5 = mapEmptyMap.keySet().iterator();
                                                    while (it5.hasNext()) {
                                                        iIntValue2 = ((Integer) it5.next()).intValue();
                                                        set = this.zzb;
                                                        numValueOf2 = Integer.valueOf(iIntValue2);
                                                        if (set.contains(numValueOf2)) {
                                                            this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                                        } else {
                                                            it6 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                                            zZzd = true;
                                                            while (true) {
                                                                if (!it6.hasNext()) {
                                                                    map5 = mapEmptyMap;
                                                                    j2 = j;
                                                                    break;
                                                                }
                                                                com.google.android.gms.internal.measurement.zzej zzejVar6 = (com.google.android.gms.internal.measurement.zzej) it6.next();
                                                                zzxVar = new zzx(this, this.zza, iIntValue2, zzejVar6);
                                                                map5 = mapEmptyMap;
                                                                j2 = j;
                                                                zZzd = zzxVar.zzd(this.zzd, this.zze, zzfsVarZza, j2, zzasVar, zzf(iIntValue2, zzejVar6.zzb()));
                                                                if (!zZzd) {
                                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                                    break;
                                                                }
                                                                zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                                j = j2;
                                                                mapEmptyMap = map5;
                                                            }
                                                            if (!zZzd) {
                                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                                            }
                                                            j = j2;
                                                            mapEmptyMap = map5;
                                                        }
                                                    }
                                                    it3 = it4;
                                                    str3 = str5;
                                                    zzwVar = zzwVar;
                                                }
                                            }
                                        }
                                        str7 = str3;
                                        if (!list2.isEmpty()) {
                                            arrayMap6 = new ArrayMap();
                                            it8 = list2.iterator();
                                            while (it8.hasNext()) {
                                                com.google.android.gms.internal.measurement.zzgl zzglVar2 = (com.google.android.gms.internal.measurement.zzgl) it8.next();
                                                strZzf = zzglVar2.zzf();
                                                mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                                                if (mapEmptyMap2 == null) {
                                                    zzamVarZzi3 = this.zzf.zzi();
                                                    str9 = this.zza;
                                                    zzamVarZzi3.zzW();
                                                    zzamVarZzi3.zzg();
                                                    Preconditions.checkNotEmpty(str9);
                                                    Preconditions.checkNotEmpty(strZzf);
                                                    arrayMap7 = new ArrayMap();
                                                    cursorQuery = zzamVarZzi3.zzh().query("property_filters", new String[]{str7, "data"}, "app_id=? AND property_name=?", new String[]{str9, strZzf}, null, null, null);
                                                    if (cursorQuery.moveToFirst()) {
                                                        while (true) {
                                                            com.google.android.gms.internal.measurement.zzes zzesVar3 = (com.google.android.gms.internal.measurement.zzes) ((com.google.android.gms.internal.measurement.zzer) zzlh.zzl(com.google.android.gms.internal.measurement.zzes.zzc(), cursorQuery.getBlob(1))).zzaE();
                                                            numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                                            list6 = (List) arrayMap7.get(numValueOf7);
                                                            if (list6 == null) {
                                                                arrayList4 = new ArrayList();
                                                                arrayMap7.put(numValueOf7, arrayList4);
                                                            } else {
                                                                arrayList4 = list6;
                                                            }
                                                            arrayList4.add(zzesVar3);
                                                            if (!cursorQuery.moveToNext()) {
                                                                break;
                                                                break;
                                                            }
                                                            it8 = it8;
                                                        }
                                                        if (cursorQuery != null) {
                                                            cursorQuery.close();
                                                        }
                                                        mapEmptyMap2 = arrayMap7;
                                                    } else {
                                                        it8 = it8;
                                                        mapEmptyMap2 = Collections.emptyMap();
                                                        if (cursorQuery != null) {
                                                            cursorQuery.close();
                                                        }
                                                    }
                                                    arrayMap6.put(strZzf, mapEmptyMap2);
                                                } else {
                                                    it8 = it8;
                                                }
                                                it9 = mapEmptyMap2.keySet().iterator();
                                                while (it9.hasNext()) {
                                                    iIntValue3 = ((Integer) it9.next()).intValue();
                                                    set2 = this.zzb;
                                                    numValueOf4 = Integer.valueOf(iIntValue3);
                                                    if (set2.contains(numValueOf4)) {
                                                        this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                                        break;
                                                        break;
                                                    }
                                                    it10 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                                    zZzd2 = true;
                                                    while (true) {
                                                        if (it10.hasNext()) {
                                                            zzesVar = (com.google.android.gms.internal.measurement.zzes) it10.next();
                                                            if (Log.isLoggable(this.zzs.zzay().zzq(), 2)) {
                                                                zzes zzesVarZzj2 = this.zzs.zzay().zzj();
                                                                Integer numValueOf17 = Integer.valueOf(iIntValue3);
                                                                if (zzesVar.zzj()) {
                                                                    numValueOf6 = Integer.valueOf(zzesVar.zza());
                                                                } else {
                                                                    numValueOf6 = null;
                                                                }
                                                                zzesVarZzj2.zzd("Evaluating filter. audience, filter, property", numValueOf17, numValueOf6, this.zzs.zzj().zzf(zzesVar.zze()));
                                                                this.zzs.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzesVar));
                                                            }
                                                            if (zzesVar.zzj()) {
                                                            }
                                                            zzes zzesVarZzk2 = this.zzs.zzay().zzk();
                                                            Object objZzn3 = zzeu.zzn(this.zza);
                                                            if (zzesVar.zzj()) {
                                                                numValueOf5 = Integer.valueOf(zzesVar.zza());
                                                            } else {
                                                                numValueOf5 = null;
                                                            }
                                                            zzesVarZzk2.zzc("Invalid property filter ID. appId, id", objZzn3, String.valueOf(numValueOf5));
                                                            this.zzb.add(Integer.valueOf(iIntValue3));
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                        } else {
                                                            mapEmptyMap2 = mapEmptyMap2;
                                                        }
                                                        if (!zZzd2) {
                                                            this.zzb.add(Integer.valueOf(iIntValue3));
                                                        }
                                                        mapEmptyMap2 = mapEmptyMap2;
                                                        zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                        mapEmptyMap2 = mapEmptyMap2;
                                                    }
                                                }
                                                it8 = it8;
                                            }
                                        }
                                        arrayList3 = new ArrayList();
                                        Set setKeySet2 = this.zzc.keySet();
                                        setKeySet2.removeAll(this.zzb);
                                        it7 = setKeySet2.iterator();
                                        while (it7.hasNext()) {
                                            int iIntValue7 = ((Integer) it7.next()).intValue();
                                            Map map9 = this.zzc;
                                            Integer numValueOf18 = Integer.valueOf(iIntValue7);
                                            zzu zzuVar2 = (zzu) map9.get(numValueOf18);
                                            Preconditions.checkNotNull(zzuVar2);
                                            com.google.android.gms.internal.measurement.zzfo zzfoVarZza2 = zzuVar2.zza(iIntValue7);
                                            arrayList3.add(zzfoVarZza2);
                                            zzamVarZzi2 = this.zzf.zzi();
                                            str8 = this.zza;
                                            com.google.android.gms.internal.measurement.zzgh zzghVarZzd2 = zzfoVarZza2.zzd();
                                            zzamVarZzi2.zzW();
                                            zzamVarZzi2.zzg();
                                            Preconditions.checkNotEmpty(str8);
                                            Preconditions.checkNotNull(zzghVarZzd2);
                                            byte[] bArrZzbv2 = zzghVarZzd2.zzbv();
                                            contentValues = new ContentValues();
                                            contentValues.put("app_id", str8);
                                            contentValues.put(str7, numValueOf18);
                                            contentValues.put("current_results", bArrZzbv2);
                                            if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                zzamVarZzi2.zzs.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeu.zzn(str8));
                                            }
                                        }
                                        return arrayList3;
                                    }
                                }
                                try {
                                    if (!Query.moveToNext()) {
                                        break;
                                    }
                                    z6 = z3 ? 1 : 0;
                                    str11 = str11;
                                    r12 = 0;
                                } catch (SQLiteException e24) {
                                    e = e24;
                                    zzamVarZzi6.zzs.zzay().zzd().zzc("Database error querying filter results. appId", zzeu.zzn(str13), e);
                                    Map mapEmptyMap5 = Collections.emptyMap();
                                    if (Query != 0) {
                                        Query.close();
                                    }
                                    map2 = mapEmptyMap5;
                                    z4 = z3;
                                }
                            }
                            if (Query != 0) {
                                Query.close();
                            }
                            map2 = arrayMap8;
                            z4 = z3;
                        } else {
                            Map mapEmptyMap6 = Collections.emptyMap();
                            if (Query != 0) {
                                Query.close();
                            }
                            map2 = mapEmptyMap6;
                            z4 = z2 ? 1 : 0;
                            str11 = "audience_id";
                        }
                        if (!map2.isEmpty()) {
                            hashSet = new HashSet(map2.keySet());
                            if (z4) {
                                String str15 = this.zza;
                                zzam zzamVarZzi10 = this.zzf.zzi();
                                str2 = this.zza;
                                zzamVarZzi10.zzW();
                                zzamVarZzi10.zzg();
                                Preconditions.checkNotEmpty(str2);
                                arrayMap2 = new ArrayMap();
                                sQLiteDatabaseZzh = zzamVarZzi10.zzh();
                                cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str2, str2});
                                if (cursorRawQuery.moveToFirst()) {
                                    do {
                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                        arrayList = (List) arrayMap2.get(numValueOf);
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                            arrayMap2.put(numValueOf, arrayList);
                                        }
                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                    } while (cursorRawQuery.moveToNext());
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                } else {
                                    arrayMap2 = Collections.emptyMap();
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                }
                                Preconditions.checkNotEmpty(str15);
                                Preconditions.checkNotNull(map2);
                                arrayMap3 = new ArrayMap();
                                if (!map2.isEmpty()) {
                                    it2 = map2.keySet().iterator();
                                    while (it2.hasNext()) {
                                        int iIntValue8 = ((Integer) it2.next()).intValue();
                                        Integer numValueOf19 = Integer.valueOf(iIntValue8);
                                        zzghVar3 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf19);
                                        list4 = (List) arrayMap2.get(numValueOf19);
                                        if (list4 != null || list4.isEmpty()) {
                                            map4 = arrayMap2;
                                            arrayMap3.put(numValueOf19, zzghVar3);
                                            arrayMap2 = map4;
                                            hashSet = hashSet;
                                            it2 = it2;
                                        } else {
                                            map4 = arrayMap2;
                                            List listZzq = this.zzf.zzu().zzq(zzghVar3.zzk(), list4);
                                            if (listZzq.isEmpty()) {
                                                arrayMap2 = map4;
                                            } else {
                                                com.google.android.gms.internal.measurement.zzgg zzggVar = (com.google.android.gms.internal.measurement.zzgg) zzghVar3.zzby();
                                                zzggVar.zzf();
                                                zzggVar.zzb(listZzq);
                                                List listZzq2 = this.zzf.zzu().zzq(zzghVar3.zzn(), list4);
                                                zzggVar.zzh();
                                                zzggVar.zzd(listZzq2);
                                                zzoh.zzc();
                                                if (this.zzs.zzf().zzs(null, zzeh.zzaH)) {
                                                    ArrayList arrayList6 = new ArrayList();
                                                    Iterator it12 = zzghVar3.zzj().iterator();
                                                    while (it12.hasNext()) {
                                                        com.google.android.gms.internal.measurement.zzfq zzfqVar2 = (com.google.android.gms.internal.measurement.zzfq) it12.next();
                                                        Iterator it13 = it12;
                                                        if (!list4.contains(Integer.valueOf(zzfqVar2.zza()))) {
                                                            arrayList6.add(zzfqVar2);
                                                        }
                                                        it12 = it13;
                                                    }
                                                    zzggVar.zze();
                                                    zzggVar.zza(arrayList6);
                                                    ArrayList arrayList7 = new ArrayList();
                                                    for (com.google.android.gms.internal.measurement.zzgj zzgjVar2 : zzghVar3.zzm()) {
                                                        if (!list4.contains(Integer.valueOf(zzgjVar2.zzb()))) {
                                                            arrayList7.add(zzgjVar2);
                                                        }
                                                    }
                                                    zzggVar.zzg();
                                                    zzggVar.zzc(arrayList7);
                                                } else {
                                                    for (int i3 = 0; i3 < zzghVar3.zza(); i3++) {
                                                        if (list4.contains(Integer.valueOf(zzghVar3.zze(i3).zza()))) {
                                                            zzggVar.zzi(i3);
                                                        }
                                                    }
                                                    for (int i4 = 0; i4 < zzghVar3.zzc(); i4++) {
                                                        if (list4.contains(Integer.valueOf(zzghVar3.zzi(i4).zzb()))) {
                                                            zzggVar.zzj(i4);
                                                        }
                                                    }
                                                }
                                                arrayMap3.put(Integer.valueOf(iIntValue8), (com.google.android.gms.internal.measurement.zzgh) zzggVar.zzaE());
                                                arrayMap2 = map4;
                                                hashSet = hashSet;
                                                it2 = it2;
                                            }
                                        }
                                    }
                                }
                                hashSet2 = hashSet;
                                map3 = arrayMap3;
                            } else {
                                hashSet2 = hashSet;
                                map3 = map2;
                            }
                            it = hashSet2.iterator();
                            while (it.hasNext()) {
                                iIntValue = ((Integer) it.next()).intValue();
                                zzghVar = (com.google.android.gms.internal.measurement.zzgh) map3.get(Integer.valueOf(iIntValue));
                                bitSet = new BitSet();
                                bitSet2 = new BitSet();
                                arrayMap = new ArrayMap();
                                if (zzghVar != null && zzghVar.zza() != 0) {
                                    while (r3.hasNext()) {
                                        if (zzfqVar.zzh()) {
                                            Integer numValueOf110 = Integer.valueOf(zzfqVar.zza());
                                            if (zzfqVar.zzg()) {
                                                lValueOf = Long.valueOf(zzfqVar.zzb());
                                            } else {
                                                lValueOf = null;
                                            }
                                            arrayMap.put(numValueOf110, lValueOf);
                                        }
                                    }
                                }
                                ArrayMap arrayMap12 = new ArrayMap();
                                if (zzghVar != null && zzghVar.zzc() != 0) {
                                    while (r3.hasNext()) {
                                        if (!zzgjVar.zzi() && zzgjVar.zza() > 0) {
                                            arrayMap12.put(Integer.valueOf(zzgjVar.zzb()), Long.valueOf(zzgjVar.zzc(zzgjVar.zza() - 1)));
                                            map3 = map3;
                                            zzghVar = zzghVar;
                                        }
                                    }
                                }
                                Map map10 = map3;
                                zzghVar2 = zzghVar;
                                if (zzghVar2 != null) {
                                    i = 0;
                                    while (i < zzghVar2.zzd() * 64) {
                                        if (zzlh.zzv(zzghVar2.zzn(), i)) {
                                            z5 = zZzs;
                                            this.zzs.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                                            bitSet2.set(i);
                                            if (zzlh.zzv(zzghVar2.zzk(), i)) {
                                                bitSet.set(i);
                                            }
                                            i++;
                                            zZzs = z5;
                                        } else {
                                            z5 = zZzs;
                                        }
                                        arrayMap.remove(Integer.valueOf(i));
                                        i++;
                                        zZzs = z5;
                                    }
                                }
                                boolean z10 = zZzs;
                                Integer numValueOf111 = Integer.valueOf(iIntValue);
                                com.google.android.gms.internal.measurement.zzgh zzghVar6 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf111);
                                if (!zZzs2 && z10 && (list3 = (List) map.get(numValueOf111)) != null && this.zze != null && this.zzd != null) {
                                    for (com.google.android.gms.internal.measurement.zzej zzejVar7 : list3) {
                                        int iZzb = zzejVar7.zzb();
                                        long jLongValue = this.zze.longValue() / 1000;
                                        if (zzejVar7.zzm()) {
                                            jLongValue = this.zzd.longValue() / 1000;
                                        }
                                        Integer numValueOf20 = Integer.valueOf(iZzb);
                                        if (arrayMap.containsKey(numValueOf20)) {
                                            arrayMap.put(numValueOf20, Long.valueOf(jLongValue));
                                        }
                                        if (arrayMap12.containsKey(numValueOf20)) {
                                            arrayMap12.put(numValueOf20, Long.valueOf(jLongValue));
                                        }
                                    }
                                }
                                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzghVar6, bitSet, bitSet2, arrayMap, arrayMap12, null));
                                zZzs = z10;
                                map3 = map10;
                            }
                        }
                        str3 = str11;
                        zzvVar = null;
                        if (!list.isEmpty()) {
                            zzwVar = new zzw(this, zzvVar);
                            arrayMap4 = new ArrayMap();
                            it3 = list.iterator();
                            while (it3.hasNext()) {
                                zzfsVar = (com.google.android.gms.internal.measurement.zzfs) it3.next();
                                zzfsVarZza = zzwVar.zza(this.zza, zzfsVar);
                                if (zzfsVarZza != null) {
                                    zzamVarZzi = this.zzf.zzi();
                                    str4 = this.zza;
                                    strZzh = zzfsVarZza.zzh();
                                    zzasVarZzn = zzamVarZzi.zzn(str4, zzfsVar.zzh());
                                    if (zzasVarZzn == null) {
                                        zzamVarZzi.zzs.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeu.zzn(str4), zzamVarZzi.zzs.zzj().zzd(strZzh));
                                        zzasVar = new zzas(str4, zzfsVar.zzh(), 1L, 1L, 1L, zzfsVar.zzd(), 0L, null, null, null, null);
                                    } else {
                                        zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                    }
                                    this.zzf.zzi().zzE(zzasVar);
                                    j = zzasVar.zzc;
                                    strZzh2 = zzfsVarZza.zzh();
                                    mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                                    if (mapEmptyMap == null) {
                                        zzam zzamVarZzi11 = this.zzf.zzi();
                                        str6 = this.zza;
                                        zzamVarZzi11.zzW();
                                        zzamVarZzi11.zzg();
                                        Preconditions.checkNotEmpty(str6);
                                        Preconditions.checkNotEmpty(strZzh2);
                                        arrayMap5 = new ArrayMap();
                                        SQLiteDatabase sQLiteDatabaseZzh6 = zzamVarZzi11.zzh();
                                        String[] strArr5 = new String[2];
                                        str5 = str3;
                                        strArr5[0] = str5;
                                        r18 = 1;
                                        strArr5[1] = "data";
                                        it4 = it3;
                                        Query2 = sQLiteDatabaseZzh6.query("event_filters", strArr5, "app_id=? AND event_name=?", new String[]{str6, strZzh2}, null, null, null);
                                        if (Query2.moveToFirst()) {
                                            zzasVar = zzasVar;
                                            Query2 = Query2;
                                            while (true) {
                                                com.google.android.gms.internal.measurement.zzej zzejVar8 = (com.google.android.gms.internal.measurement.zzej) ((com.google.android.gms.internal.measurement.zzei) zzlh.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), Query2.getBlob(1))).zzaE();
                                                numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                                list5 = (List) arrayMap5.get(numValueOf3);
                                                if (list5 == null) {
                                                    r18 = Query2;
                                                    arrayList2 = new ArrayList();
                                                    arrayMap5.put(numValueOf3, arrayList2);
                                                    r110 = r18;
                                                } else {
                                                    r110 = Query2;
                                                    arrayList2 = list5;
                                                }
                                                arrayList2.add(zzejVar8);
                                                r19 = r110;
                                                if (!r19.moveToNext()) {
                                                    break;
                                                    break;
                                                }
                                                Query2 = r19;
                                                r18 = r19;
                                            }
                                            if (r19 != 0) {
                                                r19.close();
                                            }
                                            mapEmptyMap = arrayMap5;
                                        } else {
                                            zzasVar = zzasVar;
                                            mapEmptyMap = Collections.emptyMap();
                                            if (Query2 != 0) {
                                                Query2.close();
                                            }
                                        }
                                        arrayMap4.put(strZzh2, mapEmptyMap);
                                    } else {
                                        it4 = it3;
                                        zzasVar = zzasVar;
                                        str5 = str3;
                                    }
                                    it5 = mapEmptyMap.keySet().iterator();
                                    while (it5.hasNext()) {
                                        iIntValue2 = ((Integer) it5.next()).intValue();
                                        set = this.zzb;
                                        numValueOf2 = Integer.valueOf(iIntValue2);
                                        if (set.contains(numValueOf2)) {
                                            this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                                        } else {
                                            it6 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                                            zZzd = true;
                                            while (true) {
                                                if (!it6.hasNext()) {
                                                    map5 = mapEmptyMap;
                                                    j2 = j;
                                                    break;
                                                }
                                                com.google.android.gms.internal.measurement.zzej zzejVar9 = (com.google.android.gms.internal.measurement.zzej) it6.next();
                                                zzxVar = new zzx(this, this.zza, iIntValue2, zzejVar9);
                                                map5 = mapEmptyMap;
                                                j2 = j;
                                                zZzd = zzxVar.zzd(this.zzd, this.zze, zzfsVarZza, j2, zzasVar, zzf(iIntValue2, zzejVar9.zzb()));
                                                if (!zZzd) {
                                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                                    break;
                                                }
                                                zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                                j = j2;
                                                mapEmptyMap = map5;
                                            }
                                            if (!zZzd) {
                                                this.zzb.add(Integer.valueOf(iIntValue2));
                                            }
                                            j = j2;
                                            mapEmptyMap = map5;
                                        }
                                    }
                                    it3 = it4;
                                    str3 = str5;
                                    zzwVar = zzwVar;
                                }
                            }
                        }
                        str7 = str3;
                        if (!list2.isEmpty()) {
                            arrayMap6 = new ArrayMap();
                            it8 = list2.iterator();
                            while (it8.hasNext()) {
                                com.google.android.gms.internal.measurement.zzgl zzglVar3 = (com.google.android.gms.internal.measurement.zzgl) it8.next();
                                strZzf = zzglVar3.zzf();
                                mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                                if (mapEmptyMap2 == null) {
                                    zzamVarZzi3 = this.zzf.zzi();
                                    str9 = this.zza;
                                    zzamVarZzi3.zzW();
                                    zzamVarZzi3.zzg();
                                    Preconditions.checkNotEmpty(str9);
                                    Preconditions.checkNotEmpty(strZzf);
                                    arrayMap7 = new ArrayMap();
                                    cursorQuery = zzamVarZzi3.zzh().query("property_filters", new String[]{str7, "data"}, "app_id=? AND property_name=?", new String[]{str9, strZzf}, null, null, null);
                                    if (cursorQuery.moveToFirst()) {
                                        while (true) {
                                            com.google.android.gms.internal.measurement.zzes zzesVar4 = (com.google.android.gms.internal.measurement.zzes) ((com.google.android.gms.internal.measurement.zzer) zzlh.zzl(com.google.android.gms.internal.measurement.zzes.zzc(), cursorQuery.getBlob(1))).zzaE();
                                            numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                                            list6 = (List) arrayMap7.get(numValueOf7);
                                            if (list6 == null) {
                                                arrayList4 = new ArrayList();
                                                arrayMap7.put(numValueOf7, arrayList4);
                                            } else {
                                                arrayList4 = list6;
                                            }
                                            arrayList4.add(zzesVar4);
                                            if (!cursorQuery.moveToNext()) {
                                                break;
                                                break;
                                            }
                                            it8 = it8;
                                        }
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        mapEmptyMap2 = arrayMap7;
                                    } else {
                                        it8 = it8;
                                        mapEmptyMap2 = Collections.emptyMap();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                    }
                                    arrayMap6.put(strZzf, mapEmptyMap2);
                                } else {
                                    it8 = it8;
                                }
                                it9 = mapEmptyMap2.keySet().iterator();
                                while (it9.hasNext()) {
                                    iIntValue3 = ((Integer) it9.next()).intValue();
                                    set2 = this.zzb;
                                    numValueOf4 = Integer.valueOf(iIntValue3);
                                    if (set2.contains(numValueOf4)) {
                                        this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                                        break;
                                        break;
                                    }
                                    it10 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                                    zZzd2 = true;
                                    while (true) {
                                        if (it10.hasNext()) {
                                            zzesVar = (com.google.android.gms.internal.measurement.zzes) it10.next();
                                            if (Log.isLoggable(this.zzs.zzay().zzq(), 2)) {
                                                zzes zzesVarZzj3 = this.zzs.zzay().zzj();
                                                Integer numValueOf112 = Integer.valueOf(iIntValue3);
                                                if (zzesVar.zzj()) {
                                                    numValueOf6 = Integer.valueOf(zzesVar.zza());
                                                } else {
                                                    numValueOf6 = null;
                                                }
                                                zzesVarZzj3.zzd("Evaluating filter. audience, filter, property", numValueOf112, numValueOf6, this.zzs.zzj().zzf(zzesVar.zze()));
                                                this.zzs.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzesVar));
                                            }
                                            if (zzesVar.zzj() || zzesVar.zza() > 256) {
                                                zzes zzesVarZzk3 = this.zzs.zzay().zzk();
                                                Object objZzn4 = zzeu.zzn(this.zza);
                                                if (zzesVar.zzj()) {
                                                    numValueOf5 = Integer.valueOf(zzesVar.zza());
                                                } else {
                                                    numValueOf5 = null;
                                                }
                                                zzesVarZzk3.zzc("Invalid property filter ID. appId, id", objZzn4, String.valueOf(numValueOf5));
                                                this.zzb.add(Integer.valueOf(iIntValue3));
                                                mapEmptyMap2 = mapEmptyMap2;
                                            } else {
                                                zzzVar = new zzz(this, this.zza, iIntValue3, zzesVar);
                                                zZzd2 = zzzVar.zzd(this.zzd, this.zze, zzglVar3, zzf(iIntValue3, zzesVar.zza()));
                                                if (zZzd2) {
                                                    zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                                                    mapEmptyMap2 = mapEmptyMap2;
                                                } else {
                                                    this.zzb.add(Integer.valueOf(iIntValue3));
                                                }
                                            }
                                        } else {
                                            mapEmptyMap2 = mapEmptyMap2;
                                        }
                                        if (!zZzd2) {
                                            this.zzb.add(Integer.valueOf(iIntValue3));
                                        }
                                        mapEmptyMap2 = mapEmptyMap2;
                                    }
                                }
                                it8 = it8;
                            }
                        }
                        arrayList3 = new ArrayList();
                        Set setKeySet3 = this.zzc.keySet();
                        setKeySet3.removeAll(this.zzb);
                        it7 = setKeySet3.iterator();
                        while (it7.hasNext()) {
                            int iIntValue9 = ((Integer) it7.next()).intValue();
                            Map map11 = this.zzc;
                            Integer numValueOf113 = Integer.valueOf(iIntValue9);
                            zzu zzuVar3 = (zzu) map11.get(numValueOf113);
                            Preconditions.checkNotNull(zzuVar3);
                            com.google.android.gms.internal.measurement.zzfo zzfoVarZza3 = zzuVar3.zza(iIntValue9);
                            arrayList3.add(zzfoVarZza3);
                            zzamVarZzi2 = this.zzf.zzi();
                            str8 = this.zza;
                            com.google.android.gms.internal.measurement.zzgh zzghVarZzd3 = zzfoVarZza3.zzd();
                            zzamVarZzi2.zzW();
                            zzamVarZzi2.zzg();
                            Preconditions.checkNotEmpty(str8);
                            Preconditions.checkNotNull(zzghVarZzd3);
                            byte[] bArrZzbv3 = zzghVarZzd3.zzbv();
                            contentValues = new ContentValues();
                            contentValues.put("app_id", str8);
                            contentValues.put(str7, numValueOf113);
                            contentValues.put("current_results", bArrZzbv3);
                            if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                zzamVarZzi2.zzs.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeu.zzn(str8));
                            }
                        }
                        return arrayList3;
                    }
                    r51 = 0;
                    r50 = 1;
                    obj = "events";
                    if (Query.moveToFirst()) {
                        Map mapEmptyMap7 = Collections.emptyMap();
                        if (Query != 0) {
                            Query.close();
                        }
                        map2 = mapEmptyMap7;
                        z4 = z2 ? 1 : 0;
                        str11 = "audience_id";
                    } else {
                        arrayMap8 = new ArrayMap();
                        r12 = r52;
                        z6 = z2;
                        while (true) {
                            i2 = Query.getInt(r12);
                            arrayMap8.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzgh) ((com.google.android.gms.internal.measurement.zzgg) zzlh.zzl(com.google.android.gms.internal.measurement.zzgh.zzf(), Query.getBlob(1))).zzaE());
                            z3 = z6;
                            if (!Query.moveToNext()) {
                                break;
                                break;
                            }
                            z6 = z3 ? 1 : 0;
                            str11 = str11;
                            r12 = 0;
                        }
                        if (Query != 0) {
                            Query.close();
                        }
                        map2 = arrayMap8;
                        z4 = z3;
                    }
                } catch (SQLiteException e25) {
                    e = e25;
                    z3 = z2 ? 1 : 0;
                }
                String[] strArr6 = new String[2];
                strArr6[r52] = "audience_id";
                strArr6[r53] = "current_results";
                String[] strArr7 = new String[r53];
                strArr7[r52] = str13;
                Query = sQLiteDatabaseZzh3.query("audience_filter_values", strArr6, "app_id=?", strArr7, null, null, null);
            } catch (Throwable th12) {
                th = th12;
                r6 = obj2;
                if (r6 != 0) {
                    r6.close();
                }
                throw th;
            }
        } catch (SQLiteException e26) {
            e = e26;
            z3 = z2 ? 1 : 0;
            str11 = "audience_id";
            Query = 0;
        } catch (Throwable th13) {
            th = th13;
            r6 = 0;
            if (r6 != 0) {
                r6.close();
            }
            throw th;
        }
        map = mapEmptyMap3;
        obj2 = obj;
        r53 = r50;
        r52 = r51;
        zzam zzamVarZzi12 = this.zzf.zzi();
        String str16 = this.zza;
        zzamVarZzi12.zzW();
        zzamVarZzi12.zzg();
        Preconditions.checkNotEmpty(str16);
        SQLiteDatabase sQLiteDatabaseZzh7 = zzamVarZzi12.zzh();
        if (!map2.isEmpty()) {
            hashSet = new HashSet(map2.keySet());
            if (z4) {
                String str17 = this.zza;
                zzam zzamVarZzi13 = this.zzf.zzi();
                str2 = this.zza;
                zzamVarZzi13.zzW();
                zzamVarZzi13.zzg();
                Preconditions.checkNotEmpty(str2);
                arrayMap2 = new ArrayMap();
                sQLiteDatabaseZzh = zzamVarZzi13.zzh();
                cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str2, str2});
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                        arrayList = (List) arrayMap2.get(numValueOf);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap2.put(numValueOf, arrayList);
                        }
                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                    } while (cursorRawQuery.moveToNext());
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    arrayMap2 = Collections.emptyMap();
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
                Preconditions.checkNotEmpty(str17);
                Preconditions.checkNotNull(map2);
                arrayMap3 = new ArrayMap();
                if (!map2.isEmpty()) {
                    it2 = map2.keySet().iterator();
                    while (it2.hasNext()) {
                        int iIntValue10 = ((Integer) it2.next()).intValue();
                        Integer numValueOf114 = Integer.valueOf(iIntValue10);
                        zzghVar3 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf114);
                        list4 = (List) arrayMap2.get(numValueOf114);
                        if (list4 != null) {
                        }
                        map4 = arrayMap2;
                        arrayMap3.put(numValueOf114, zzghVar3);
                        arrayMap2 = map4;
                        hashSet = hashSet;
                        it2 = it2;
                    }
                }
                hashSet2 = hashSet;
                map3 = arrayMap3;
            } else {
                hashSet2 = hashSet;
                map3 = map2;
            }
            it = hashSet2.iterator();
            while (it.hasNext()) {
                iIntValue = ((Integer) it.next()).intValue();
                zzghVar = (com.google.android.gms.internal.measurement.zzgh) map3.get(Integer.valueOf(iIntValue));
                bitSet = new BitSet();
                bitSet2 = new BitSet();
                arrayMap = new ArrayMap();
                if (zzghVar != null) {
                    while (r3.hasNext()) {
                        if (zzfqVar.zzh()) {
                            Integer numValueOf115 = Integer.valueOf(zzfqVar.zza());
                            if (zzfqVar.zzg()) {
                                lValueOf = Long.valueOf(zzfqVar.zzb());
                            } else {
                                lValueOf = null;
                            }
                            arrayMap.put(numValueOf115, lValueOf);
                        }
                    }
                }
                ArrayMap arrayMap13 = new ArrayMap();
                if (zzghVar != null) {
                    while (r3.hasNext()) {
                        if (!zzgjVar.zzi()) {
                        }
                    }
                }
                Map map12 = map3;
                zzghVar2 = zzghVar;
                if (zzghVar2 != null) {
                    i = 0;
                    while (i < zzghVar2.zzd() * 64) {
                        if (zzlh.zzv(zzghVar2.zzn(), i)) {
                            z5 = zZzs;
                            this.zzs.zzay().zzj().zzc("Filter already evaluated. audience ID, filter ID", Integer.valueOf(iIntValue), Integer.valueOf(i));
                            bitSet2.set(i);
                            if (zzlh.zzv(zzghVar2.zzk(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            zZzs = z5;
                        } else {
                            z5 = zZzs;
                        }
                        arrayMap.remove(Integer.valueOf(i));
                        i++;
                        zZzs = z5;
                    }
                }
                boolean z11 = zZzs;
                Integer numValueOf116 = Integer.valueOf(iIntValue);
                com.google.android.gms.internal.measurement.zzgh zzghVar7 = (com.google.android.gms.internal.measurement.zzgh) map2.get(numValueOf116);
                if (!zZzs2) {
                }
                this.zzc.put(Integer.valueOf(iIntValue), new zzu(this, this.zza, zzghVar7, bitSet, bitSet2, arrayMap, arrayMap13, null));
                zZzs = z11;
                map3 = map12;
            }
        }
        str3 = str11;
        zzvVar = null;
        if (!list.isEmpty()) {
            zzwVar = new zzw(this, zzvVar);
            arrayMap4 = new ArrayMap();
            it3 = list.iterator();
            while (it3.hasNext()) {
                zzfsVar = (com.google.android.gms.internal.measurement.zzfs) it3.next();
                zzfsVarZza = zzwVar.zza(this.zza, zzfsVar);
                if (zzfsVarZza != null) {
                    zzamVarZzi = this.zzf.zzi();
                    str4 = this.zza;
                    strZzh = zzfsVarZza.zzh();
                    zzasVarZzn = zzamVarZzi.zzn(str4, zzfsVar.zzh());
                    if (zzasVarZzn == null) {
                        zzamVarZzi.zzs.zzay().zzk().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzeu.zzn(str4), zzamVarZzi.zzs.zzj().zzd(strZzh));
                        zzasVar = new zzas(str4, zzfsVar.zzh(), 1L, 1L, 1L, zzfsVar.zzd(), 0L, null, null, null, null);
                    } else {
                        zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                    }
                    this.zzf.zzi().zzE(zzasVar);
                    j = zzasVar.zzc;
                    strZzh2 = zzfsVarZza.zzh();
                    mapEmptyMap = (Map) arrayMap4.get(strZzh2);
                    if (mapEmptyMap == null) {
                        zzam zzamVarZzi14 = this.zzf.zzi();
                        str6 = this.zza;
                        zzamVarZzi14.zzW();
                        zzamVarZzi14.zzg();
                        Preconditions.checkNotEmpty(str6);
                        Preconditions.checkNotEmpty(strZzh2);
                        arrayMap5 = new ArrayMap();
                        SQLiteDatabase sQLiteDatabaseZzh8 = zzamVarZzi14.zzh();
                        String[] strArr8 = new String[2];
                        str5 = str3;
                        strArr8[0] = str5;
                        r18 = 1;
                        strArr8[1] = "data";
                        it4 = it3;
                        Query2 = sQLiteDatabaseZzh8.query("event_filters", strArr8, "app_id=? AND event_name=?", new String[]{str6, strZzh2}, null, null, null);
                        if (Query2.moveToFirst()) {
                            zzasVar = zzasVar;
                            Query2 = Query2;
                            while (true) {
                                com.google.android.gms.internal.measurement.zzej zzejVar10 = (com.google.android.gms.internal.measurement.zzej) ((com.google.android.gms.internal.measurement.zzei) zzlh.zzl(com.google.android.gms.internal.measurement.zzej.zzc(), Query2.getBlob(1))).zzaE();
                                numValueOf3 = Integer.valueOf(Query2.getInt(0));
                                list5 = (List) arrayMap5.get(numValueOf3);
                                if (list5 == null) {
                                    r18 = Query2;
                                    arrayList2 = new ArrayList();
                                    arrayMap5.put(numValueOf3, arrayList2);
                                    r110 = r18;
                                } else {
                                    r110 = Query2;
                                    arrayList2 = list5;
                                }
                                arrayList2.add(zzejVar10);
                                r19 = r110;
                                if (!r19.moveToNext()) {
                                    break;
                                    break;
                                }
                                Query2 = r19;
                                r18 = r19;
                            }
                            if (r19 != 0) {
                                r19.close();
                            }
                            mapEmptyMap = arrayMap5;
                        } else {
                            zzasVar = zzasVar;
                            mapEmptyMap = Collections.emptyMap();
                            if (Query2 != 0) {
                                Query2.close();
                            }
                        }
                        arrayMap4.put(strZzh2, mapEmptyMap);
                    } else {
                        it4 = it3;
                        zzasVar = zzasVar;
                        str5 = str3;
                    }
                    it5 = mapEmptyMap.keySet().iterator();
                    while (it5.hasNext()) {
                        iIntValue2 = ((Integer) it5.next()).intValue();
                        set = this.zzb;
                        numValueOf2 = Integer.valueOf(iIntValue2);
                        if (set.contains(numValueOf2)) {
                            this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf2);
                        } else {
                            it6 = ((List) mapEmptyMap.get(numValueOf2)).iterator();
                            zZzd = true;
                            while (true) {
                                if (!it6.hasNext()) {
                                    map5 = mapEmptyMap;
                                    j2 = j;
                                    break;
                                }
                                com.google.android.gms.internal.measurement.zzej zzejVar11 = (com.google.android.gms.internal.measurement.zzej) it6.next();
                                zzxVar = new zzx(this, this.zza, iIntValue2, zzejVar11);
                                map5 = mapEmptyMap;
                                j2 = j;
                                zZzd = zzxVar.zzd(this.zzd, this.zze, zzfsVarZza, j2, zzasVar, zzf(iIntValue2, zzejVar11.zzb()));
                                if (!zZzd) {
                                    this.zzb.add(Integer.valueOf(iIntValue2));
                                    break;
                                }
                                zzd(Integer.valueOf(iIntValue2)).zzc(zzxVar);
                                j = j2;
                                mapEmptyMap = map5;
                            }
                            if (!zZzd) {
                                this.zzb.add(Integer.valueOf(iIntValue2));
                            }
                            j = j2;
                            mapEmptyMap = map5;
                        }
                    }
                    it3 = it4;
                    str3 = str5;
                    zzwVar = zzwVar;
                }
            }
        }
        str7 = str3;
        if (!list2.isEmpty()) {
            arrayMap6 = new ArrayMap();
            it8 = list2.iterator();
            while (it8.hasNext()) {
                com.google.android.gms.internal.measurement.zzgl zzglVar4 = (com.google.android.gms.internal.measurement.zzgl) it8.next();
                strZzf = zzglVar4.zzf();
                mapEmptyMap2 = (Map) arrayMap6.get(strZzf);
                if (mapEmptyMap2 == null) {
                    zzamVarZzi3 = this.zzf.zzi();
                    str9 = this.zza;
                    zzamVarZzi3.zzW();
                    zzamVarZzi3.zzg();
                    Preconditions.checkNotEmpty(str9);
                    Preconditions.checkNotEmpty(strZzf);
                    arrayMap7 = new ArrayMap();
                    cursorQuery = zzamVarZzi3.zzh().query("property_filters", new String[]{str7, "data"}, "app_id=? AND property_name=?", new String[]{str9, strZzf}, null, null, null);
                    if (cursorQuery.moveToFirst()) {
                        while (true) {
                            com.google.android.gms.internal.measurement.zzes zzesVar5 = (com.google.android.gms.internal.measurement.zzes) ((com.google.android.gms.internal.measurement.zzer) zzlh.zzl(com.google.android.gms.internal.measurement.zzes.zzc(), cursorQuery.getBlob(1))).zzaE();
                            numValueOf7 = Integer.valueOf(cursorQuery.getInt(0));
                            list6 = (List) arrayMap7.get(numValueOf7);
                            if (list6 == null) {
                                arrayList4 = new ArrayList();
                                arrayMap7.put(numValueOf7, arrayList4);
                            } else {
                                arrayList4 = list6;
                            }
                            arrayList4.add(zzesVar5);
                            if (!cursorQuery.moveToNext()) {
                                break;
                                break;
                            }
                            it8 = it8;
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        mapEmptyMap2 = arrayMap7;
                    } else {
                        it8 = it8;
                        mapEmptyMap2 = Collections.emptyMap();
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                    arrayMap6.put(strZzf, mapEmptyMap2);
                } else {
                    it8 = it8;
                }
                it9 = mapEmptyMap2.keySet().iterator();
                while (it9.hasNext()) {
                    iIntValue3 = ((Integer) it9.next()).intValue();
                    set2 = this.zzb;
                    numValueOf4 = Integer.valueOf(iIntValue3);
                    if (set2.contains(numValueOf4)) {
                        this.zzs.zzay().zzj().zzb("Skipping failed audience ID", numValueOf4);
                        break;
                        break;
                    }
                    it10 = ((List) mapEmptyMap2.get(numValueOf4)).iterator();
                    zZzd2 = true;
                    while (true) {
                        if (it10.hasNext()) {
                            zzesVar = (com.google.android.gms.internal.measurement.zzes) it10.next();
                            if (Log.isLoggable(this.zzs.zzay().zzq(), 2)) {
                                zzes zzesVarZzj4 = this.zzs.zzay().zzj();
                                Integer numValueOf117 = Integer.valueOf(iIntValue3);
                                if (zzesVar.zzj()) {
                                    numValueOf6 = Integer.valueOf(zzesVar.zza());
                                } else {
                                    numValueOf6 = null;
                                }
                                zzesVarZzj4.zzd("Evaluating filter. audience, filter, property", numValueOf117, numValueOf6, this.zzs.zzj().zzf(zzesVar.zze()));
                                this.zzs.zzay().zzj().zzb("Filter definition", this.zzf.zzu().zzp(zzesVar));
                            }
                            if (zzesVar.zzj()) {
                            }
                            zzes zzesVarZzk4 = this.zzs.zzay().zzk();
                            Object objZzn5 = zzeu.zzn(this.zza);
                            if (zzesVar.zzj()) {
                                numValueOf5 = Integer.valueOf(zzesVar.zza());
                            } else {
                                numValueOf5 = null;
                            }
                            zzesVarZzk4.zzc("Invalid property filter ID. appId, id", objZzn5, String.valueOf(numValueOf5));
                            this.zzb.add(Integer.valueOf(iIntValue3));
                            mapEmptyMap2 = mapEmptyMap2;
                        } else {
                            mapEmptyMap2 = mapEmptyMap2;
                        }
                        if (!zZzd2) {
                            this.zzb.add(Integer.valueOf(iIntValue3));
                        }
                        mapEmptyMap2 = mapEmptyMap2;
                        zzd(Integer.valueOf(iIntValue3)).zzc(zzzVar);
                        mapEmptyMap2 = mapEmptyMap2;
                    }
                }
                it8 = it8;
            }
        }
        arrayList3 = new ArrayList();
        Set setKeySet4 = this.zzc.keySet();
        setKeySet4.removeAll(this.zzb);
        it7 = setKeySet4.iterator();
        while (it7.hasNext()) {
            int iIntValue11 = ((Integer) it7.next()).intValue();
            Map map13 = this.zzc;
            Integer numValueOf118 = Integer.valueOf(iIntValue11);
            zzu zzuVar4 = (zzu) map13.get(numValueOf118);
            Preconditions.checkNotNull(zzuVar4);
            com.google.android.gms.internal.measurement.zzfo zzfoVarZza4 = zzuVar4.zza(iIntValue11);
            arrayList3.add(zzfoVarZza4);
            zzamVarZzi2 = this.zzf.zzi();
            str8 = this.zza;
            com.google.android.gms.internal.measurement.zzgh zzghVarZzd4 = zzfoVarZza4.zzd();
            zzamVarZzi2.zzW();
            zzamVarZzi2.zzg();
            Preconditions.checkNotEmpty(str8);
            Preconditions.checkNotNull(zzghVarZzd4);
            byte[] bArrZzbv4 = zzghVarZzd4.zzbv();
            contentValues = new ContentValues();
            contentValues.put("app_id", str8);
            contentValues.put(str7, numValueOf118);
            contentValues.put("current_results", bArrZzbv4);
            if (zzamVarZzi2.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                zzamVarZzi2.zzs.zzay().zzd().zzb("Failed to insert filter results (got -1). appId", zzeu.zzn(str8));
            }
        }
        return arrayList3;
    }

    @Override // com.google.android.gms.measurement.internal.zzkt
    protected final boolean zzb() {
        return false;
    }
}
