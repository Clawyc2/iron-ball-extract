package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzw {
    final /* synthetic */ zzaa zza;
    private com.google.android.gms.internal.measurement.zzfs zzb;
    private Long zzc;
    private long zzd;

    /* synthetic */ zzw(zzaa zzaaVar, zzv zzvVar) {
        this.zza = zzaaVar;
    }

    /* JADX WARN: Code duplicated, block: B:52:0x011e A[PHI: r14 r16 r17
      0x011e: PHI (r14v1 android.database.Cursor) = (r14v2 android.database.Cursor), (r14v5 android.database.Cursor) binds: [B:51:0x011c, B:39:0x00f4] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r16v3 com.google.android.gms.internal.measurement.zzfs) = (r16v4 com.google.android.gms.internal.measurement.zzfs), (r16v8 com.google.android.gms.internal.measurement.zzfs) binds: [B:51:0x011c, B:39:0x00f4] A[DONT_GENERATE, DONT_INLINE]
      0x011e: PHI (r17v3 long) = (r17v4 long), (r17v7 long) binds: [B:51:0x011c, B:39:0x00f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    final com.google.android.gms.internal.measurement.zzfs zza(String str, com.google.android.gms.internal.measurement.zzfs zzfsVar) {
        Cursor cursor;
        com.google.android.gms.internal.measurement.zzfs zzfsVar2;
        long j;
        Cursor cursorRawQuery;
        Pair pair;
        Pair pair2;
        String strZzh = zzfsVar.zzh();
        List listZzi = zzfsVar.zzi();
        this.zza.zzf.zzu();
        Long l = (Long) zzlh.zzC(zzfsVar, "_eid");
        if (l != null) {
            if (strZzh.equals("_ep")) {
                Preconditions.checkNotNull(l);
                this.zza.zzf.zzu();
                String str2 = (String) zzlh.zzC(zzfsVar, "_en");
                if (TextUtils.isEmpty(str2)) {
                    this.zza.zzs.zzay().zzh().zzb("Extra parameter without an event name. eventId", l);
                    return null;
                }
                if (this.zzb == null || this.zzc == null || l.longValue() != this.zzc.longValue()) {
                    zzam zzamVarZzi = this.zza.zzf.zzi();
                    zzamVarZzi.zzg();
                    zzamVarZzi.zzW();
                    try {
                        cursorRawQuery = zzamVarZzi.zzh().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, l.toString()});
                        try {
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    zzfsVar2 = null;
                                    try {
                                        try {
                                            Pair pairCreate = Pair.create((com.google.android.gms.internal.measurement.zzfs) ((com.google.android.gms.internal.measurement.zzfr) zzlh.zzl(com.google.android.gms.internal.measurement.zzfs.zze(), cursorRawQuery.getBlob(0))).zzaE(), Long.valueOf(cursorRawQuery.getLong(1)));
                                            pair2 = pairCreate;
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                                pair2 = pairCreate;
                                            }
                                        } catch (SQLiteException e) {
                                            e = e;
                                            j = 0;
                                            zzamVarZzi.zzs.zzay().zzd().zzb("Error selecting main event", e);
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            pair = zzfsVar2;
                                        }
                                    } catch (IOException e2) {
                                        j = 0;
                                        try {
                                            zzamVarZzi.zzs.zzay().zzd().zzd("Failed to merge main event. appId, eventId", zzeu.zzn(str), l, e2);
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            zzamVarZzi.zzs.zzay().zzd().zzb("Error selecting main event", e);
                                            if (cursorRawQuery != null) {
                                                cursorRawQuery.close();
                                            }
                                            pair = zzfsVar2;
                                            if (pair != 0) {
                                            }
                                            this.zza.zzs.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                                            return zzfsVar2;
                                        }
                                        pair = zzfsVar2;
                                    }
                                } else {
                                    zzamVarZzi.zzs.zzay().zzj().zza("Main event not found");
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    pair2 = null;
                                    zzfsVar2 = null;
                                }
                                j = 0;
                                pair = pair2;
                            } catch (SQLiteException e4) {
                                e = e4;
                                zzfsVar2 = null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        zzfsVar2 = null;
                        j = 0;
                        cursorRawQuery = null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                    }
                    if (pair != 0 || pair.first == null) {
                        this.zza.zzs.zzay().zzh().zzc("Extra parameter without existing main event. eventName, eventId", str2, l);
                        return zzfsVar2;
                    }
                    this.zzb = (com.google.android.gms.internal.measurement.zzfs) pair.first;
                    this.zzd = ((Long) pair.second).longValue();
                    this.zza.zzf.zzu();
                    this.zzc = (Long) zzlh.zzC(this.zzb, "_eid");
                } else {
                    j = 0;
                }
                long j2 = this.zzd - 1;
                this.zzd = j2;
                if (j2 <= j) {
                    zzam zzamVarZzi2 = this.zza.zzf.zzi();
                    zzamVarZzi2.zzg();
                    zzamVarZzi2.zzs.zzay().zzj().zzb("Clearing complex main event info. appId", str);
                    try {
                        zzamVarZzi2.zzh().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                    } catch (SQLiteException e6) {
                        zzamVarZzi2.zzs.zzay().zzd().zzb("Error clearing complex main event", e6);
                    }
                } else {
                    this.zza.zzf.zzi().zzJ(str, l, this.zzd, this.zzb);
                }
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzfw zzfwVar : this.zzb.zzi()) {
                    this.zza.zzf.zzu();
                    if (zzlh.zzB(zzfsVar, zzfwVar.zzg()) == null) {
                        arrayList.add(zzfwVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    this.zza.zzs.zzay().zzh().zzb("No unique parameters in main event. eventName", str2);
                } else {
                    arrayList.addAll(listZzi);
                    listZzi = arrayList;
                }
                strZzh = str2;
            } else {
                this.zzc = l;
                this.zzb = zzfsVar;
                this.zza.zzf.zzu();
                Object objZzC = zzlh.zzC(zzfsVar, "_epc");
                long jLongValue = ((Long) (objZzC != null ? objZzC : 0L)).longValue();
                this.zzd = jLongValue;
                if (jLongValue <= 0) {
                    this.zza.zzs.zzay().zzh().zzb("Complex event with zero extra param count. eventName", strZzh);
                } else {
                    this.zza.zzf.zzi().zzJ(str, (Long) Preconditions.checkNotNull(l), this.zzd, zzfsVar);
                }
            }
        }
        com.google.android.gms.internal.measurement.zzfr zzfrVar = (com.google.android.gms.internal.measurement.zzfr) zzfsVar.zzby();
        zzfrVar.zzi(strZzh);
        zzfrVar.zzg();
        zzfrVar.zzd(listZzi);
        return (com.google.android.gms.internal.measurement.zzfs) zzfrVar.zzaE();
    }
}
