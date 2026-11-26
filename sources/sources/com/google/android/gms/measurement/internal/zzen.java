package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzen extends zzf {
    private final zzem zza;
    private boolean zzb;

    zzen(zzge zzgeVar) {
        super(zzgeVar);
        Context contextZzau = this.zzs.zzau();
        this.zzs.zzf();
        this.zza = new zzem(this, contextZzau, "google_app_measurement_local.db");
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fa A[Catch: all -> 0x0153, TryCatch #8 {all -> 0x0153, blocks: (B:66:0x00f4, B:68:0x00fa, B:69:0x00fd, B:84:0x0130), top: B:104:0x00f4 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0112  */
    /* JADX WARN: Code duplicated, block: B:79:0x0123  */
    /* JADX WARN: Code duplicated, block: B:81:0x0128  */
    /* JADX WARN: Code duplicated, block: B:86:0x0144  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149 A[PHI: r8 r16
      0x0149: PHI (r8v3 android.database.sqlite.SQLiteDatabase) = (r8v2 android.database.sqlite.SQLiteDatabase), (r8v4 android.database.sqlite.SQLiteDatabase) binds: [B:72:0x0115, B:87:0x0147] A[DONT_GENERATE, DONT_INLINE]
      0x0149: PHI (r16v5 ??) = (r16v4 ??), (r16v6 ??) binds: [B:72:0x0115, B:87:0x0147] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0158  */
    /* JADX WARN: Code duplicated, block: B:96:0x015d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r16v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v24 */
    /* JADX WARN: Type inference failed for: r16v25 */
    /* JADX WARN: Type inference failed for: r16v26 */
    /* JADX WARN: Type inference failed for: r16v27 */
    /* JADX WARN: Type inference failed for: r16v28 */
    /* JADX WARN: Type inference failed for: r16v29 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v7 */
    private final boolean zzq(int i, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseZzh;
        ?? r16;
        boolean z;
        ?? RawQuery;
        ?? r10;
        ?? r17;
        zzg();
        ?? r2 = 0;
        if (this.zzb) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("entry", bArr);
        this.zzs.zzf();
        int i2 = 0;
        int i3 = 5;
        for (int i4 = 5; i2 < i4; i4 = 5) {
            ?? r8 = 0;
            r8 = 0;
            r8 = 0;
            sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseZzh = zzh();
                if (sQLiteDatabaseZzh == null) {
                    this.zzb = true;
                    return r2;
                }
                try {
                    sQLiteDatabaseZzh.beginTransaction();
                    RawQuery = sQLiteDatabaseZzh.rawQuery("select count(1) from messages", null);
                    long j = 0;
                    if (RawQuery != 0) {
                        try {
                            try {
                                if (RawQuery.moveToFirst()) {
                                    j = RawQuery.getLong(r2);
                                }
                            } catch (Throwable th) {
                                th = th;
                                r8 = RawQuery;
                                if (r8 != 0) {
                                    r8.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteDatabaseLockedException unused) {
                            r17 = r2;
                            r8 = RawQuery;
                            r16 = r17;
                            try {
                                SystemClock.sleep(i3);
                                i3 += 20;
                                if (r8 != 0) {
                                    r8.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                i2++;
                                r2 = r16;
                            } catch (Throwable th2) {
                                th = th2;
                                if (r8 != 0) {
                                    r8.close();
                                }
                                if (sQLiteDatabaseZzh != null) {
                                    sQLiteDatabaseZzh.close();
                                }
                                throw th;
                            }
                        } catch (SQLiteFullException e) {
                            e = e;
                            r17 = r2;
                            sQLiteDatabase = sQLiteDatabaseZzh;
                            r10 = RawQuery;
                            r16 = r17;
                            this.zzs.zzay().zzd().zzb("Error writing entry; local database full", e);
                            this.zzb = true;
                            if (r10 != 0) {
                                r10.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            r2 = r16;
                        } catch (SQLiteException e2) {
                            e = e2;
                            r17 = r2;
                            z = true;
                            sQLiteDatabase = sQLiteDatabaseZzh;
                            RawQuery = RawQuery;
                            r16 = r17;
                            if (sQLiteDatabase != null) {
                                try {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    sQLiteDatabaseZzh = sQLiteDatabase;
                                    r8 = RawQuery;
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    throw th;
                                }
                            }
                            this.zzs.zzay().zzd().zzb("Error writing entry to local database", e);
                            this.zzb = z;
                            if (RawQuery != 0) {
                                RawQuery.close();
                            }
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            i2++;
                            r2 = r16;
                        }
                    }
                    if (j >= 100000) {
                        this.zzs.zzay().zzd().zza("Data loss, local db full");
                        long j2 = 100001 - j;
                        String[] strArr = new String[1];
                        strArr[r2] = Long.toString(j2);
                        long jDelete = sQLiteDatabaseZzh.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                        if (jDelete != j2) {
                            r17 = r2;
                            try {
                                try {
                                    z = true;
                                    try {
                                        this.zzs.zzay().zzd().zzd("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j2), Long.valueOf(jDelete), Long.valueOf(j2 - jDelete));
                                        r17 = r17;
                                    } catch (SQLiteFullException e3) {
                                        e = e3;
                                        sQLiteDatabase = sQLiteDatabaseZzh;
                                        r10 = RawQuery;
                                        r16 = r17;
                                        this.zzs.zzay().zzd().zzb("Error writing entry; local database full", e);
                                        this.zzb = true;
                                        if (r10 != 0) {
                                            r10.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i2++;
                                        r2 = r16;
                                    } catch (SQLiteException e4) {
                                        e = e4;
                                        sQLiteDatabase = sQLiteDatabaseZzh;
                                        RawQuery = RawQuery;
                                        r16 = r17;
                                        if (sQLiteDatabase != null) {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        }
                                        this.zzs.zzay().zzd().zzb("Error writing entry to local database", e);
                                        this.zzb = z;
                                        if (RawQuery != 0) {
                                            RawQuery.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        i2++;
                                        r2 = r16;
                                    }
                                } catch (SQLiteDatabaseLockedException unused2) {
                                    r8 = RawQuery;
                                    r16 = r17;
                                    SystemClock.sleep(i3);
                                    i3 += 20;
                                    if (r8 != 0) {
                                        r8.close();
                                    }
                                    if (sQLiteDatabaseZzh != null) {
                                        sQLiteDatabaseZzh.close();
                                    }
                                    i2++;
                                    r2 = r16;
                                }
                            } catch (SQLiteFullException e5) {
                                e = e5;
                                r17 = r17;
                                sQLiteDatabase = sQLiteDatabaseZzh;
                                r10 = RawQuery;
                                r16 = r17;
                                this.zzs.zzay().zzd().zzb("Error writing entry; local database full", e);
                                this.zzb = true;
                                if (r10 != 0) {
                                    r10.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                i2++;
                                r2 = r16;
                            } catch (SQLiteException e6) {
                                e = e6;
                                r17 = r17;
                                z = true;
                                sQLiteDatabase = sQLiteDatabaseZzh;
                                RawQuery = RawQuery;
                                r16 = r17;
                                if (sQLiteDatabase != null) {
                                    if (sQLiteDatabase.inTransaction()) {
                                        sQLiteDatabase.endTransaction();
                                    }
                                }
                                this.zzs.zzay().zzd().zzb("Error writing entry to local database", e);
                                this.zzb = z;
                                if (RawQuery != 0) {
                                    RawQuery.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                i2++;
                                r2 = r16;
                            }
                        } else {
                            r17 = r2;
                            z = true;
                        }
                    } else {
                        r17 = r2;
                        z = true;
                    }
                    sQLiteDatabaseZzh.insertOrThrow("messages", null, contentValues);
                    sQLiteDatabaseZzh.setTransactionSuccessful();
                    sQLiteDatabaseZzh.endTransaction();
                    if (RawQuery != 0) {
                        RawQuery.close();
                    }
                    sQLiteDatabaseZzh.close();
                    return z;
                } catch (SQLiteDatabaseLockedException unused3) {
                    r16 = r2;
                } catch (SQLiteFullException e7) {
                    e = e7;
                    r17 = r2;
                    RawQuery = 0;
                } catch (SQLiteException e8) {
                    e = e8;
                    r17 = r2;
                    z = true;
                    RawQuery = 0;
                }
            } catch (SQLiteDatabaseLockedException unused4) {
                r16 = r2;
                sQLiteDatabaseZzh = null;
            } catch (SQLiteFullException e9) {
                e = e9;
                r16 = r2;
                r10 = 0;
            } catch (SQLiteException e10) {
                e = e10;
                r16 = r2;
                z = true;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseZzh = null;
                if (r8 != 0) {
                    r8.close();
                }
                if (sQLiteDatabaseZzh != null) {
                    sQLiteDatabaseZzh.close();
                }
                throw th;
            }
        }
        ?? r18 = r2;
        this.zzs.zzay().zzj().zza("Failed to write entry to local database");
        return r18;
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01f1 A[Catch: all -> 0x0244, TryCatch #3 {all -> 0x0244, blocks: (B:31:0x0095, B:33:0x009b, B:35:0x00a9, B:37:0x00bc, B:39:0x00c1, B:45:0x00da, B:46:0x00dd, B:44:0x00d6, B:48:0x00e0, B:50:0x00f3, B:57:0x010f, B:58:0x0113, B:59:0x0116, B:55:0x0108, B:61:0x0119, B:63:0x012c, B:70:0x0148, B:71:0x014d, B:72:0x0150, B:68:0x0141, B:74:0x0153, B:75:0x0164, B:76:0x0175, B:78:0x018b, B:79:0x019a, B:117:0x01eb, B:119:0x01f1, B:120:0x01f4, B:135:0x0227, B:127:0x0211), top: B:155:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:122:0x0205  */
    /* JADX WARN: Code duplicated, block: B:130:0x0218  */
    /* JADX WARN: Code duplicated, block: B:132:0x021d A[PHI: r9 r11 r23
      0x021d: PHI (r9v3 int) = (r9v1 int), (r9v1 int), (r9v4 int) binds: [B:123:0x0208, B:138:0x023b, B:131:0x021b] A[DONT_GENERATE, DONT_INLINE]
      0x021d: PHI (r11v7 ??) = (r11v5 ??), (r11v6 ??), (r11v8 ??) binds: [B:123:0x0208, B:138:0x023b, B:131:0x021b] A[DONT_GENERATE, DONT_INLINE]
      0x021d: PHI (r23v9 java.util.List) = (r23v6 java.util.List), (r23v7 java.util.List), (r23v10 java.util.List) binds: [B:123:0x0208, B:138:0x023b, B:131:0x021b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:137:0x0238  */
    /* JADX WARN: Code duplicated, block: B:144:0x0248  */
    /* JADX WARN: Code duplicated, block: B:146:0x024d  */
    /* JADX WARN: Code duplicated, block: B:155:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:175:0x023e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:176:0x023e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x023e A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r11v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v4 */
    public final List zzi(int i) {
        ?? r11;
        List list;
        ?? Zzh;
        ?? Query;
        ?? r4;
        ?? r12;
        long j;
        ?? r15;
        ?? r14;
        Object obj;
        Object obj2;
        zzg();
        List list2 = null;
        if (this.zzb) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!zzl()) {
            return arrayList;
        }
        int i2 = 5;
        int i3 = 0;
        while (i3 < 5) {
            try {
                Zzh = zzh();
                if (Zzh == 0) {
                    this.zzb = true;
                    return list2;
                }
                try {
                    Zzh.beginTransaction();
                    try {
                        Cursor cursorQuery = Zzh.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
                        try {
                            long j2 = -1;
                            if (cursorQuery.moveToFirst()) {
                                j = cursorQuery.getLong(0);
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                            } else {
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                j = -1;
                            }
                            if (j != -1) {
                                r14 = "rowid<?";
                                r15 = new String[]{String.valueOf(j)};
                            } else {
                                List list3 = list2;
                                r15 = list3;
                                r14 = list3;
                            }
                            String[] strArr = new String[3];
                            strArr[0] = "rowid";
                            strArr[1] = "type";
                            list = list2;
                            try {
                                strArr[2] = "entry";
                                Query = Zzh.query("messages", strArr, r14, r15, null, null, "rowid asc", Integer.toString(100));
                                while (Query.moveToNext()) {
                                    try {
                                        j2 = Query.getLong(0);
                                        int i4 = Query.getInt(1);
                                        byte[] blob = Query.getBlob(2);
                                        if (i4 == 0) {
                                            Parcel parcelObtain = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain.unmarshall(blob, 0, blob.length);
                                                    parcelObtain.setDataPosition(0);
                                                    zzaw zzawVarCreateFromParcel = zzaw.CREATOR.createFromParcel(parcelObtain);
                                                    parcelObtain.recycle();
                                                    if (zzawVarCreateFromParcel != null) {
                                                        arrayList.add(zzawVarCreateFromParcel);
                                                    }
                                                } catch (SafeParcelReader.ParseException unused) {
                                                    this.zzs.zzay().zzd().zza("Failed to load event from local database");
                                                    parcelObtain.recycle();
                                                }
                                            } catch (Throwable th) {
                                                parcelObtain.recycle();
                                                throw th;
                                            }
                                        } else if (i4 == 1) {
                                            Parcel parcelObtain2 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain2.unmarshall(blob, 0, blob.length);
                                                    parcelObtain2.setDataPosition(0);
                                                    obj = (zzli) zzli.CREATOR.createFromParcel(parcelObtain2);
                                                    parcelObtain2.recycle();
                                                } catch (SafeParcelReader.ParseException unused2) {
                                                    this.zzs.zzay().zzd().zza("Failed to load user property from local database");
                                                    parcelObtain2.recycle();
                                                    obj = list;
                                                }
                                                if (obj != null) {
                                                    arrayList.add(obj);
                                                }
                                            } catch (Throwable th2) {
                                                parcelObtain2.recycle();
                                                throw th2;
                                            }
                                        } else if (i4 == 2) {
                                            Parcel parcelObtain3 = Parcel.obtain();
                                            try {
                                                try {
                                                    parcelObtain3.unmarshall(blob, 0, blob.length);
                                                    parcelObtain3.setDataPosition(0);
                                                    obj2 = (zzac) zzac.CREATOR.createFromParcel(parcelObtain3);
                                                    parcelObtain3.recycle();
                                                } catch (SafeParcelReader.ParseException unused3) {
                                                    this.zzs.zzay().zzd().zza("Failed to load conditional user property from local database");
                                                    parcelObtain3.recycle();
                                                    obj2 = list;
                                                }
                                                if (obj2 != null) {
                                                    arrayList.add(obj2);
                                                }
                                            } catch (Throwable th3) {
                                                parcelObtain3.recycle();
                                                throw th3;
                                            }
                                        } else if (i4 == 3) {
                                            this.zzs.zzay().zzk().zza("Skipping app launch break");
                                        } else {
                                            this.zzs.zzay().zzd().zza("Unknown record type in local database");
                                        }
                                    } catch (SQLiteDatabaseLockedException unused4) {
                                        SystemClock.sleep(i2);
                                        i2 += 20;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzh != 0) {
                                            Zzh.close();
                                        }
                                        i3++;
                                        list2 = list;
                                    } catch (SQLiteFullException e) {
                                        e = e;
                                        this.zzs.zzay().zzd().zzb("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzh != 0) {
                                            Zzh.close();
                                        }
                                        i3++;
                                        list2 = list;
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        if (Zzh != 0) {
                                            try {
                                                if (Zzh.inTransaction()) {
                                                    Zzh.endTransaction();
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                r4 = Query;
                                                r11 = Zzh;
                                                if (r4 != 0) {
                                                    r4.close();
                                                }
                                                if (r11 != 0) {
                                                    r11.close();
                                                }
                                                throw th;
                                            }
                                        }
                                        this.zzs.zzay().zzd().zzb("Error reading entries from local database", e);
                                        this.zzb = true;
                                        if (Query != 0) {
                                            Query.close();
                                        }
                                        if (Zzh != 0) {
                                            Zzh.close();
                                        }
                                        i3++;
                                        list2 = list;
                                    }
                                }
                                if (Zzh.delete("messages", "rowid <= ?", new String[]{Long.toString(j2)}) < arrayList.size()) {
                                    this.zzs.zzay().zzd().zza("Fewer entries removed from local database than expected");
                                }
                                Zzh.setTransactionSuccessful();
                                Zzh.endTransaction();
                                if (Query != 0) {
                                    Query.close();
                                }
                                Zzh.close();
                                return arrayList;
                            } catch (SQLiteDatabaseLockedException unused5) {
                                Query = list;
                                SystemClock.sleep(i2);
                                i2 += 20;
                                if (Query != 0) {
                                    Query.close();
                                }
                                if (Zzh != 0) {
                                    Zzh.close();
                                }
                                i3++;
                                list2 = list;
                            } catch (SQLiteFullException e3) {
                                e = e3;
                                Query = list;
                                this.zzs.zzay().zzd().zzb("Error reading entries from local database", e);
                                this.zzb = true;
                                if (Query != 0) {
                                    Query.close();
                                }
                                if (Zzh != 0) {
                                    Zzh.close();
                                }
                                i3++;
                                list2 = list;
                            } catch (SQLiteException e4) {
                                e = e4;
                                Query = list;
                                if (Zzh != 0) {
                                    if (Zzh.inTransaction()) {
                                        Zzh.endTransaction();
                                    }
                                }
                                this.zzs.zzay().zzd().zzb("Error reading entries from local database", e);
                                this.zzb = true;
                                if (Query != 0) {
                                    Query.close();
                                }
                                if (Zzh != 0) {
                                    Zzh.close();
                                }
                                i3++;
                                list2 = list;
                            } catch (Throwable th5) {
                                th = th5;
                                r4 = list;
                                r11 = Zzh;
                                if (r4 != 0) {
                                    r4.close();
                                }
                                if (r11 != 0) {
                                    r11.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            list = list2;
                            r12 = cursorQuery;
                            if (r12 != 0) {
                                r12.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        list = list2;
                        r12 = list;
                    }
                } catch (SQLiteDatabaseLockedException unused6) {
                    list = list2;
                } catch (SQLiteFullException e5) {
                    e = e5;
                    list = list2;
                } catch (SQLiteException e6) {
                    e = e6;
                    list = list2;
                } catch (Throwable th8) {
                    th = th8;
                    list = list2;
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                list = list2;
                Zzh = list;
                Query = Zzh;
            } catch (SQLiteFullException e7) {
                e = e7;
                list = list2;
                Zzh = list;
                Query = Zzh;
            } catch (SQLiteException e8) {
                e = e8;
                list = list2;
                Zzh = list;
                Query = Zzh;
            } catch (Throwable th9) {
                th = th9;
                List list4 = list2;
                r11 = list4;
                r4 = list4;
            }
        }
        List list5 = list2;
        this.zzs.zzay().zzk().zza("Failed to read events from database in reasonable time");
        return list5;
    }

    public final void zzj() {
        int iDelete;
        zzg();
        try {
            SQLiteDatabase sQLiteDatabaseZzh = zzh();
            if (sQLiteDatabaseZzh == null || (iDelete = sQLiteDatabaseZzh.delete("messages", null, null)) <= 0) {
                return;
            }
            this.zzs.zzay().zzj().zzb("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e) {
            this.zzs.zzay().zzd().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    final boolean zzl() {
        Context contextZzau = this.zzs.zzau();
        this.zzs.zzf();
        return contextZzau.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0069 A[PHI: r4
      0x0069: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:29:0x0060, B:35:0x007c, B:32:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i = 5;
            for (int i2 = 0; i2 < 5; i2++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase sQLiteDatabaseZzh = zzh();
                    if (sQLiteDatabaseZzh == null) {
                        this.zzb = true;
                        return false;
                    }
                    sQLiteDatabaseZzh.beginTransaction();
                    sQLiteDatabaseZzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    sQLiteDatabaseZzh.setTransactionSuccessful();
                    sQLiteDatabaseZzh.endTransaction();
                    sQLiteDatabaseZzh.close();
                    return true;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(i);
                    i += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteFullException e) {
                    this.zzs.zzay().zzd().zzb("Error deleting app launch break from local database", e);
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteException e2) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    this.zzs.zzay().zzd().zzb("Error deleting app launch break from local database", e2);
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.zzs.zzay().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzacVar) {
        byte[] bArrZzan = this.zzs.zzv().zzan(zzacVar);
        if (bArrZzan.length <= 131072) {
            return zzq(2, bArrZzan);
        }
        this.zzs.zzay().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzaw zzawVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzax.zza(zzawVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzq(0, bArrMarshall);
        }
        this.zzs.zzay().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzli zzliVar) {
        Parcel parcelObtain = Parcel.obtain();
        zzlj.zza(zzliVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return zzq(1, bArrMarshall);
        }
        this.zzs.zzay().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
