package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpi;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzgr implements Callable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgw zzc;

    zzgr(zzgw zzgwVar, zzaw zzawVar, String str) {
        this.zzc = zzgwVar;
        this.zza = zzawVar;
        this.zzb = str;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x032d A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x0343 A[LOOP:1: B:98:0x0327->B:103:0x0343, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x0370 A[Catch: all -> 0x061d, LOOP:2: B:106:0x036a->B:108:0x0370, LOOP_END, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0409 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x042f A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0466 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x04b3 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x051d A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0533 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x053e A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0542 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x0544 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:135:0x055d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:139:0x05a1 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x02a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:164:0x033f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x04c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x04ad A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0205 A[Catch: all -> 0x061d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0244 A[Catch: SecurityException -> 0x0601, all -> 0x061d, TryCatch #0 {SecurityException -> 0x0601, blocks: (B:69:0x023c, B:71:0x0244, B:73:0x024a), top: B:153:0x023c, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x026b A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0290 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02a6 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x02ad A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x02fb A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0308 A[Catch: all -> 0x061d, TryCatch #2 {all -> 0x061d, blocks: (B:13:0x007c, B:15:0x0088, B:18:0x00a3, B:20:0x00a9, B:23:0x00c4, B:25:0x00db, B:26:0x00e2, B:28:0x00ec, B:29:0x00f9, B:31:0x0103, B:32:0x0110, B:34:0x011b, B:35:0x0123, B:37:0x013f, B:41:0x014c, B:43:0x0161, B:45:0x0171, B:47:0x0179, B:49:0x017f, B:50:0x0182, B:52:0x0191, B:54:0x019f, B:56:0x01a5, B:58:0x01b9, B:60:0x01c3, B:61:0x01d4, B:63:0x01d8, B:65:0x01e5, B:68:0x0205, B:69:0x023c, B:71:0x0244, B:73:0x024a, B:74:0x0261, B:76:0x026b, B:77:0x0278, B:78:0x028a, B:80:0x0290, B:86:0x02a6, B:91:0x02d8, B:93:0x02fb, B:95:0x0308, B:97:0x0314, B:98:0x0327, B:100:0x032d, B:102:0x033f, B:104:0x0345, B:105:0x0363, B:106:0x036a, B:108:0x0370, B:109:0x03a6, B:111:0x0409, B:112:0x0421, B:114:0x042f, B:116:0x0476, B:117:0x04ad, B:119:0x04b3, B:121:0x04c6, B:122:0x04d3, B:124:0x051d, B:125:0x052b, B:127:0x0533, B:128:0x0536, B:130:0x053e, B:133:0x0547, B:136:0x055f, B:137:0x0562, B:139:0x05a1, B:140:0x05aa, B:132:0x0544, B:115:0x0466, B:90:0x02ad, B:147:0x0602, B:38:0x0143, B:40:0x0149), top: B:157:0x007c, inners: #0, #1 }] */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzlf zzlfVar;
        String strZzt;
        List listZzu;
        Iterator it;
        zzlk zzlkVar;
        List list;
        zzlh zzlhVarZzu;
        com.google.android.gms.internal.measurement.zzgl[] zzglVarArr;
        int i;
        Bundle bundle;
        zzas zzasVarZzn;
        com.google.android.gms.internal.measurement.zzfz zzfzVar;
        Bundle bundle2;
        zzh zzhVar;
        com.google.android.gms.internal.measurement.zzgb zzgbVar;
        zzas zzasVarZzc;
        long j;
        zzar zzarVar;
        com.google.android.gms.internal.measurement.zzgb zzgbVar2;
        com.google.android.gms.internal.measurement.zzfr zzfrVarZze;
        zzat zzatVar;
        long jZzn;
        long jZzp;
        String strZzB;
        com.google.android.gms.internal.measurement.zzfv zzfvVarZze;
        Object objZzf;
        String strZzt2;
        Iterator it2;
        this.zzc.zza.zzA();
        zzio zzioVarZzr = this.zzc.zza.zzr();
        zzaw zzawVar = this.zza;
        String str = this.zzb;
        zzioVarZzr.zzg();
        zzge.zzO();
        Preconditions.checkNotNull(zzawVar);
        Preconditions.checkNotEmpty(str);
        if (!zzioVarZzr.zzs.zzf().zzs(str, zzeh.zzS)) {
            zzioVarZzr.zzs.zzay().zzc().zzb("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzawVar.zza) && !"_iapx".equals(zzawVar.zza)) {
            zzioVarZzr.zzs.zzay().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str, zzawVar.zza);
            return null;
        }
        com.google.android.gms.internal.measurement.zzfz zzfzVarZza = com.google.android.gms.internal.measurement.zzga.zza();
        zzioVarZzr.zzf.zzi().zzw();
        try {
            zzh zzhVarZzj = zzioVarZzr.zzf.zzi().zzj(str);
            if (zzhVarZzj == null) {
                zzioVarZzr.zzs.zzay().zzc().zzb("Log and bundle not available. package_name", str);
                byte[] bArr2 = new byte[0];
                zzioVarZzr.zzf.zzi().zzx();
                return bArr2;
            }
            if (!zzhVarZzj.zzai()) {
                zzioVarZzr.zzs.zzay().zzc().zzb("Log and bundle disabled. package_name", str);
                byte[] bArr3 = new byte[0];
                zzioVarZzr.zzf.zzi().zzx();
                return bArr3;
            }
            com.google.android.gms.internal.measurement.zzgb zzgbVarZzt = com.google.android.gms.internal.measurement.zzgc.zzt();
            zzgbVarZzt.zzad(1);
            zzgbVarZzt.zzZ("android");
            if (!TextUtils.isEmpty(zzhVarZzj.zzt())) {
                zzgbVarZzt.zzD(zzhVarZzj.zzt());
            }
            if (!TextUtils.isEmpty(zzhVarZzj.zzv())) {
                zzgbVarZzt.zzF((String) Preconditions.checkNotNull(zzhVarZzj.zzv()));
            }
            if (!TextUtils.isEmpty(zzhVarZzj.zzw())) {
                zzgbVarZzt.zzG((String) Preconditions.checkNotNull(zzhVarZzj.zzw()));
            }
            if (zzhVarZzj.zzb() != -2147483648L) {
                zzgbVarZzt.zzH((int) zzhVarZzj.zzb());
            }
            zzgbVarZzt.zzV(zzhVarZzj.zzm());
            zzgbVarZzt.zzP(zzhVarZzj.zzk());
            String strZzy = zzhVarZzj.zzy();
            String strZzr = zzhVarZzj.zzr();
            if (!TextUtils.isEmpty(strZzy)) {
                zzgbVarZzt.zzU(strZzy);
            } else if (!TextUtils.isEmpty(strZzr)) {
                zzgbVarZzt.zzC(strZzr);
            }
            zzai zzaiVarZzh = zzioVarZzr.zzf.zzh(str);
            zzgbVarZzt.zzM(zzhVarZzj.zzj());
            if (zzioVarZzr.zzs.zzJ() && zzioVarZzr.zzs.zzf().zzt(zzgbVarZzt.zzap()) && zzaiVarZzh.zzi(zzah.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                zzgbVarZzt.zzO(null);
            }
            zzgbVarZzt.zzL(zzaiVarZzh.zzh());
            if (!zzaiVarZzh.zzi(zzah.AD_STORAGE) || (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzaj) && !zzhVarZzj.zzah())) {
                zzioVarZzr.zzs.zzg().zzu();
                zzgbVarZzt.zzN(Build.MODEL);
                zzioVarZzr.zzs.zzg().zzu();
                zzgbVarZzt.zzY(Build.VERSION.RELEASE);
                zzgbVarZzt.zzaj((int) zzioVarZzr.zzs.zzg().zzb());
                zzgbVarZzt.zzan(zzioVarZzr.zzs.zzg().zzc());
                try {
                    if (zzaiVarZzh.zzi(zzah.ANALYTICS_STORAGE) && zzhVarZzj.zzu() != null) {
                        zzgbVarZzt.zzE(zzio.zza((String) Preconditions.checkNotNull(zzhVarZzj.zzu()), Long.toString(zzawVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzj.zzx())) {
                        zzgbVarZzt.zzT((String) Preconditions.checkNotNull(zzhVarZzj.zzx()));
                    }
                    strZzt = zzhVarZzj.zzt();
                    listZzu = zzioVarZzr.zzf.zzi().zzu(strZzt);
                    it = listZzu.iterator();
                    do {
                        if (!it.hasNext()) {
                            zzlkVar = null;
                            break;
                        }
                        zzlkVar = (zzlk) it.next();
                    } while (!"_lte".equals(zzlkVar.zzc));
                    if (zzlkVar != null || zzlkVar.zze == null) {
                        list = listZzu;
                        zzlk zzlkVar2 = new zzlk(strZzt, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzioVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                        list.add(zzlkVar2);
                        zzioVarZzr.zzf.zzi().zzL(zzlkVar2);
                    } else {
                        list = listZzu;
                    }
                    zzlhVarZzu = zzioVarZzr.zzf.zzu();
                    zzlhVarZzu.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzlhVarZzu.zzs.zzg().zze()) {
                        strZzt2 = zzhVarZzj.zzt();
                        Preconditions.checkNotNull(strZzt2);
                        if (zzhVarZzj.zzah() && zzlhVarZzu.zzf.zzo().zzn(strZzt2)) {
                            zzlhVarZzu.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                                if ("_npa".equals(((zzlk) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            list.add(new zzlk(strZzt2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzlhVarZzu.zzs.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    zzglVarArr = new com.google.android.gms.internal.measurement.zzgl[list.size()];
                    for (i = 0; i < list.size(); i++) {
                        com.google.android.gms.internal.measurement.zzgk zzgkVarZzd = com.google.android.gms.internal.measurement.zzgl.zzd();
                        zzgkVarZzd.zzf(((zzlk) list.get(i)).zzc);
                        zzgkVarZzd.zzg(((zzlk) list.get(i)).zzd);
                        zzioVarZzr.zzf.zzu().zzu(zzgkVarZzd, ((zzlk) list.get(i)).zze);
                        zzglVarArr[i] = (com.google.android.gms.internal.measurement.zzgl) zzgkVarZzd.zzaE();
                    }
                    zzgbVarZzt.zzj(Arrays.asList(zzglVarArr));
                    zzev zzevVarZzb = zzev.zzb(zzawVar);
                    zzioVarZzr.zzs.zzv().zzL(zzevVarZzb.zzd, zzioVarZzr.zzf.zzi().zzi(str));
                    zzioVarZzr.zzs.zzv().zzM(zzevVarZzb, zzioVarZzr.zzs.zzf().zzd(str));
                    bundle = zzevVarZzb.zzd;
                    bundle.putLong("_c", 1L);
                    zzioVarZzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle.putLong("_r", 1L);
                    bundle.putString("_o", zzawVar.zzc);
                    if (zzioVarZzr.zzs.zzv().zzae(zzgbVarZzt.zzap())) {
                        zzioVarZzr.zzs.zzv().zzO(bundle, "_dbg", 1L);
                        zzioVarZzr.zzs.zzv().zzO(bundle, "_r", 1L);
                    }
                    zzasVarZzn = zzioVarZzr.zzf.zzi().zzn(str, zzawVar.zza);
                    if (zzasVarZzn == null) {
                        zzgbVar = zzgbVarZzt;
                        bundle2 = bundle;
                        zzasVarZzc = new zzas(str, zzawVar.zza, 0L, 0L, 0L, zzawVar.zzd, 0L, null, null, null, null);
                        j = 0;
                        zzfzVar = zzfzVarZza;
                        zzhVar = zzhVarZzj;
                    } else {
                        zzfzVar = zzfzVarZza;
                        bundle2 = bundle;
                        zzhVar = zzhVarZzj;
                        zzgbVar = zzgbVarZzt;
                        long j2 = zzasVarZzn.zzf;
                        zzasVarZzc = zzasVarZzn.zzc(zzawVar.zzd);
                        j = j2;
                    }
                    zzas zzasVar = zzasVarZzc;
                    zzioVarZzr.zzf.zzi().zzE(zzasVar);
                    zzgbVar2 = zzgbVar;
                    zzarVar = new zzar(zzioVarZzr.zzs, zzawVar.zzc, str, zzawVar.zza, zzawVar.zzd, j, bundle2);
                    zzfrVarZze = com.google.android.gms.internal.measurement.zzfs.zze();
                    zzfrVarZze.zzm(zzarVar.zzd);
                    zzfrVarZze.zzi(zzarVar.zzb);
                    zzfrVarZze.zzl(zzarVar.zze);
                    zzatVar = new zzat(zzarVar.zzf);
                    while (zzatVar.hasNext()) {
                        String next = zzatVar.next();
                        zzfvVarZze = com.google.android.gms.internal.measurement.zzfw.zze();
                        zzfvVarZze.zzj(next);
                        objZzf = zzarVar.zzf.zzf(next);
                        if (objZzf != null) {
                            zzioVarZzr.zzf.zzu().zzt(zzfvVarZze, objZzf);
                            zzfrVarZze.zze(zzfvVarZze);
                        }
                    }
                    zzgbVar2.zzk(zzfrVarZze);
                    com.google.android.gms.internal.measurement.zzgd zzgdVarZza = com.google.android.gms.internal.measurement.zzgf.zza();
                    com.google.android.gms.internal.measurement.zzft zzftVarZza = com.google.android.gms.internal.measurement.zzfu.zza();
                    zzftVarZza.zza(zzasVar.zzc);
                    zzftVarZza.zzb(zzawVar.zza);
                    zzgdVarZza.zza(zzftVarZza);
                    zzgbVar2.zzaa(zzgdVarZza);
                    zzgbVar2.zzf(zzioVarZzr.zzf.zzf().zza(zzhVar.zzt(), Collections.emptyList(), zzgbVar2.zzat(), Long.valueOf(zzfrVarZze.zzc()), Long.valueOf(zzfrVarZze.zzc())));
                    if (zzfrVarZze.zzq()) {
                        zzgbVar2.zzai(zzfrVarZze.zzc());
                        zzgbVar2.zzQ(zzfrVarZze.zzc());
                    }
                    jZzn = zzhVar.zzn();
                    if (jZzn != 0) {
                        zzgbVar2.zzab(jZzn);
                    }
                    jZzp = zzhVar.zzp();
                    if (jZzp != 0) {
                        zzgbVar2.zzac(jZzp);
                    } else if (jZzn != 0) {
                        zzgbVar2.zzac(jZzn);
                    }
                    strZzB = zzhVar.zzB();
                    zzpi.zzc();
                    if (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzay) && strZzB != null) {
                        zzgbVar2.zzah(strZzB);
                    }
                    zzhVar.zzE();
                    zzgbVar2.zzI((int) zzhVar.zzo());
                    zzioVarZzr.zzs.zzf().zzh();
                    zzgbVar2.zzal(68000L);
                    zzgbVar2.zzak(zzioVarZzr.zzs.zzav().currentTimeMillis());
                    zzgbVar2.zzag(Boolean.TRUE.booleanValue());
                    if (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzaG)) {
                        zzioVarZzr.zzf.zzC(zzgbVar2.zzap(), zzgbVar2);
                    }
                    zzfzVar.zza(zzgbVar2);
                    zzhVar.zzab(zzgbVar2.zzd());
                    zzhVar.zzZ(zzgbVar2.zzc());
                    zzioVarZzr.zzf.zzi().zzD(zzhVar);
                    zzioVarZzr.zzf.zzi().zzC();
                    zzioVarZzr.zzf.zzi().zzx();
                    try {
                        return zzioVarZzr.zzf.zzu().zzy(((com.google.android.gms.internal.measurement.zzga) zzfzVar.zzaE()).zzbv());
                    } catch (IOException e) {
                        zzioVarZzr.zzs.zzay().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzeu.zzn(str), e);
                        return null;
                    }
                } catch (SecurityException e2) {
                    zzioVarZzr.zzs.zzay().zzc().zzb("app instance id encryption failed", e2.getMessage());
                    bArr = new byte[0];
                    zzlfVar = zzioVarZzr.zzf;
                }
            } else {
                Pair pairZzd = zzioVarZzr.zzf.zzs().zzd(zzhVarZzj.zzt(), zzaiVarZzh);
                if (!zzhVarZzj.zzah() || TextUtils.isEmpty((CharSequence) pairZzd.first)) {
                    zzioVarZzr.zzs.zzg().zzu();
                    zzgbVarZzt.zzN(Build.MODEL);
                    zzioVarZzr.zzs.zzg().zzu();
                    zzgbVarZzt.zzY(Build.VERSION.RELEASE);
                    zzgbVarZzt.zzaj((int) zzioVarZzr.zzs.zzg().zzb());
                    zzgbVarZzt.zzan(zzioVarZzr.zzs.zzg().zzc());
                    if (zzaiVarZzh.zzi(zzah.ANALYTICS_STORAGE)) {
                        zzgbVarZzt.zzE(zzio.zza((String) Preconditions.checkNotNull(zzhVarZzj.zzu()), Long.toString(zzawVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzj.zzx())) {
                        zzgbVarZzt.zzT((String) Preconditions.checkNotNull(zzhVarZzj.zzx()));
                    }
                    strZzt = zzhVarZzj.zzt();
                    listZzu = zzioVarZzr.zzf.zzi().zzu(strZzt);
                    it = listZzu.iterator();
                    do {
                        if (!it.hasNext()) {
                            zzlkVar = null;
                            break;
                        }
                        zzlkVar = (zzlk) it.next();
                    } while (!"_lte".equals(zzlkVar.zzc));
                    if (zzlkVar != null) {
                        list = listZzu;
                        zzlk zzlkVar3 = new zzlk(strZzt, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzioVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                        list.add(zzlkVar3);
                        zzioVarZzr.zzf.zzi().zzL(zzlkVar3);
                    } else {
                        list = listZzu;
                        zzlk zzlkVar4 = new zzlk(strZzt, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzioVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                        list.add(zzlkVar4);
                        zzioVarZzr.zzf.zzi().zzL(zzlkVar4);
                    }
                    zzlhVarZzu = zzioVarZzr.zzf.zzu();
                    zzlhVarZzu.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzlhVarZzu.zzs.zzg().zze()) {
                        strZzt2 = zzhVarZzj.zzt();
                        Preconditions.checkNotNull(strZzt2);
                        if (zzhVarZzj.zzah()) {
                            zzlhVarZzu.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                                if ("_npa".equals(((zzlk) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            list.add(new zzlk(strZzt2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzlhVarZzu.zzs.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    zzglVarArr = new com.google.android.gms.internal.measurement.zzgl[list.size()];
                    while (i < list.size()) {
                        com.google.android.gms.internal.measurement.zzgk zzgkVarZzd2 = com.google.android.gms.internal.measurement.zzgl.zzd();
                        zzgkVarZzd2.zzf(((zzlk) list.get(i)).zzc);
                        zzgkVarZzd2.zzg(((zzlk) list.get(i)).zzd);
                        zzioVarZzr.zzf.zzu().zzu(zzgkVarZzd2, ((zzlk) list.get(i)).zze);
                        zzglVarArr[i] = (com.google.android.gms.internal.measurement.zzgl) zzgkVarZzd2.zzaE();
                    }
                    zzgbVarZzt.zzj(Arrays.asList(zzglVarArr));
                    zzev zzevVarZzb2 = zzev.zzb(zzawVar);
                    zzioVarZzr.zzs.zzv().zzL(zzevVarZzb2.zzd, zzioVarZzr.zzf.zzi().zzi(str));
                    zzioVarZzr.zzs.zzv().zzM(zzevVarZzb2, zzioVarZzr.zzs.zzf().zzd(str));
                    bundle = zzevVarZzb2.zzd;
                    bundle.putLong("_c", 1L);
                    zzioVarZzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle.putLong("_r", 1L);
                    bundle.putString("_o", zzawVar.zzc);
                    if (zzioVarZzr.zzs.zzv().zzae(zzgbVarZzt.zzap())) {
                        zzioVarZzr.zzs.zzv().zzO(bundle, "_dbg", 1L);
                        zzioVarZzr.zzs.zzv().zzO(bundle, "_r", 1L);
                    }
                    zzasVarZzn = zzioVarZzr.zzf.zzi().zzn(str, zzawVar.zza);
                    if (zzasVarZzn == null) {
                        zzgbVar = zzgbVarZzt;
                        bundle2 = bundle;
                        zzasVarZzc = new zzas(str, zzawVar.zza, 0L, 0L, 0L, zzawVar.zzd, 0L, null, null, null, null);
                        j = 0;
                        zzfzVar = zzfzVarZza;
                        zzhVar = zzhVarZzj;
                    } else {
                        zzfzVar = zzfzVarZza;
                        bundle2 = bundle;
                        zzhVar = zzhVarZzj;
                        zzgbVar = zzgbVarZzt;
                        long j3 = zzasVarZzn.zzf;
                        zzasVarZzc = zzasVarZzn.zzc(zzawVar.zzd);
                        j = j3;
                    }
                    zzas zzasVar2 = zzasVarZzc;
                    zzioVarZzr.zzf.zzi().zzE(zzasVar2);
                    zzgbVar2 = zzgbVar;
                    zzarVar = new zzar(zzioVarZzr.zzs, zzawVar.zzc, str, zzawVar.zza, zzawVar.zzd, j, bundle2);
                    zzfrVarZze = com.google.android.gms.internal.measurement.zzfs.zze();
                    zzfrVarZze.zzm(zzarVar.zzd);
                    zzfrVarZze.zzi(zzarVar.zzb);
                    zzfrVarZze.zzl(zzarVar.zze);
                    zzatVar = new zzat(zzarVar.zzf);
                    while (zzatVar.hasNext()) {
                        String next2 = zzatVar.next();
                        zzfvVarZze = com.google.android.gms.internal.measurement.zzfw.zze();
                        zzfvVarZze.zzj(next2);
                        objZzf = zzarVar.zzf.zzf(next2);
                        if (objZzf != null) {
                            zzioVarZzr.zzf.zzu().zzt(zzfvVarZze, objZzf);
                            zzfrVarZze.zze(zzfvVarZze);
                        }
                    }
                    zzgbVar2.zzk(zzfrVarZze);
                    com.google.android.gms.internal.measurement.zzgd zzgdVarZza2 = com.google.android.gms.internal.measurement.zzgf.zza();
                    com.google.android.gms.internal.measurement.zzft zzftVarZza2 = com.google.android.gms.internal.measurement.zzfu.zza();
                    zzftVarZza2.zza(zzasVar2.zzc);
                    zzftVarZza2.zzb(zzawVar.zza);
                    zzgdVarZza2.zza(zzftVarZza2);
                    zzgbVar2.zzaa(zzgdVarZza2);
                    zzgbVar2.zzf(zzioVarZzr.zzf.zzf().zza(zzhVar.zzt(), Collections.emptyList(), zzgbVar2.zzat(), Long.valueOf(zzfrVarZze.zzc()), Long.valueOf(zzfrVarZze.zzc())));
                    if (zzfrVarZze.zzq()) {
                        zzgbVar2.zzai(zzfrVarZze.zzc());
                        zzgbVar2.zzQ(zzfrVarZze.zzc());
                    }
                    jZzn = zzhVar.zzn();
                    if (jZzn != 0) {
                        zzgbVar2.zzab(jZzn);
                    }
                    jZzp = zzhVar.zzp();
                    if (jZzp != 0) {
                        zzgbVar2.zzac(jZzp);
                    } else if (jZzn != 0) {
                        zzgbVar2.zzac(jZzn);
                    }
                    strZzB = zzhVar.zzB();
                    zzpi.zzc();
                    if (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzay)) {
                        zzgbVar2.zzah(strZzB);
                    }
                    zzhVar.zzE();
                    zzgbVar2.zzI((int) zzhVar.zzo());
                    zzioVarZzr.zzs.zzf().zzh();
                    zzgbVar2.zzal(68000L);
                    zzgbVar2.zzak(zzioVarZzr.zzs.zzav().currentTimeMillis());
                    zzgbVar2.zzag(Boolean.TRUE.booleanValue());
                    if (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzaG)) {
                        zzioVarZzr.zzf.zzC(zzgbVar2.zzap(), zzgbVar2);
                    }
                    zzfzVar.zza(zzgbVar2);
                    zzhVar.zzab(zzgbVar2.zzd());
                    zzhVar.zzZ(zzgbVar2.zzc());
                    zzioVarZzr.zzf.zzi().zzD(zzhVar);
                    zzioVarZzr.zzf.zzi().zzC();
                    zzioVarZzr.zzf.zzi().zzx();
                    return zzioVarZzr.zzf.zzu().zzy(((com.google.android.gms.internal.measurement.zzga) zzfzVar.zzaE()).zzbv());
                }
                try {
                    zzgbVarZzt.zzae(zzio.zza((String) pairZzd.first, Long.toString(zzawVar.zzd)));
                    if (pairZzd.second != null) {
                        zzgbVarZzt.zzX(((Boolean) pairZzd.second).booleanValue());
                    }
                    zzioVarZzr.zzs.zzg().zzu();
                    zzgbVarZzt.zzN(Build.MODEL);
                    zzioVarZzr.zzs.zzg().zzu();
                    zzgbVarZzt.zzY(Build.VERSION.RELEASE);
                    zzgbVarZzt.zzaj((int) zzioVarZzr.zzs.zzg().zzb());
                    zzgbVarZzt.zzan(zzioVarZzr.zzs.zzg().zzc());
                    if (zzaiVarZzh.zzi(zzah.ANALYTICS_STORAGE)) {
                        zzgbVarZzt.zzE(zzio.zza((String) Preconditions.checkNotNull(zzhVarZzj.zzu()), Long.toString(zzawVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzhVarZzj.zzx())) {
                        zzgbVarZzt.zzT((String) Preconditions.checkNotNull(zzhVarZzj.zzx()));
                    }
                    strZzt = zzhVarZzj.zzt();
                    listZzu = zzioVarZzr.zzf.zzi().zzu(strZzt);
                    it = listZzu.iterator();
                    do {
                        if (!it.hasNext()) {
                            zzlkVar = null;
                            break;
                        }
                        zzlkVar = (zzlk) it.next();
                    } while (!"_lte".equals(zzlkVar.zzc));
                    if (zzlkVar != null) {
                        list = listZzu;
                        zzlk zzlkVar5 = new zzlk(strZzt, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzioVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                        list.add(zzlkVar5);
                        zzioVarZzr.zzf.zzi().zzL(zzlkVar5);
                    } else {
                        list = listZzu;
                        zzlk zzlkVar6 = new zzlk(strZzt, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_lte", zzioVarZzr.zzs.zzav().currentTimeMillis(), 0L);
                        list.add(zzlkVar6);
                        zzioVarZzr.zzf.zzi().zzL(zzlkVar6);
                    }
                    zzlhVarZzu = zzioVarZzr.zzf.zzu();
                    zzlhVarZzu.zzs.zzay().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzlhVarZzu.zzs.zzg().zze()) {
                        strZzt2 = zzhVarZzj.zzt();
                        Preconditions.checkNotNull(strZzt2);
                        if (zzhVarZzj.zzah()) {
                            zzlhVarZzu.zzs.zzay().zzc().zza("Turning off ad personalization due to account type");
                            it2 = list.iterator();
                            while (it2.hasNext()) {
                                if ("_npa".equals(((zzlk) it2.next()).zzc)) {
                                    it2.remove();
                                    break;
                                }
                            }
                            list.add(new zzlk(strZzt2, DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_npa", zzlhVarZzu.zzs.zzav().currentTimeMillis(), 1L));
                        }
                    }
                    zzglVarArr = new com.google.android.gms.internal.measurement.zzgl[list.size()];
                    while (i < list.size()) {
                        com.google.android.gms.internal.measurement.zzgk zzgkVarZzd3 = com.google.android.gms.internal.measurement.zzgl.zzd();
                        zzgkVarZzd3.zzf(((zzlk) list.get(i)).zzc);
                        zzgkVarZzd3.zzg(((zzlk) list.get(i)).zzd);
                        zzioVarZzr.zzf.zzu().zzu(zzgkVarZzd3, ((zzlk) list.get(i)).zze);
                        zzglVarArr[i] = (com.google.android.gms.internal.measurement.zzgl) zzgkVarZzd3.zzaE();
                    }
                    zzgbVarZzt.zzj(Arrays.asList(zzglVarArr));
                    zzev zzevVarZzb3 = zzev.zzb(zzawVar);
                    zzioVarZzr.zzs.zzv().zzL(zzevVarZzb3.zzd, zzioVarZzr.zzf.zzi().zzi(str));
                    zzioVarZzr.zzs.zzv().zzM(zzevVarZzb3, zzioVarZzr.zzs.zzf().zzd(str));
                    bundle = zzevVarZzb3.zzd;
                    bundle.putLong("_c", 1L);
                    zzioVarZzr.zzs.zzay().zzc().zza("Marking in-app purchase as real-time");
                    bundle.putLong("_r", 1L);
                    bundle.putString("_o", zzawVar.zzc);
                    if (zzioVarZzr.zzs.zzv().zzae(zzgbVarZzt.zzap())) {
                        zzioVarZzr.zzs.zzv().zzO(bundle, "_dbg", 1L);
                        zzioVarZzr.zzs.zzv().zzO(bundle, "_r", 1L);
                    }
                    zzasVarZzn = zzioVarZzr.zzf.zzi().zzn(str, zzawVar.zza);
                    if (zzasVarZzn == null) {
                        zzgbVar = zzgbVarZzt;
                        bundle2 = bundle;
                        zzasVarZzc = new zzas(str, zzawVar.zza, 0L, 0L, 0L, zzawVar.zzd, 0L, null, null, null, null);
                        j = 0;
                        zzfzVar = zzfzVarZza;
                        zzhVar = zzhVarZzj;
                    } else {
                        zzfzVar = zzfzVarZza;
                        bundle2 = bundle;
                        zzhVar = zzhVarZzj;
                        zzgbVar = zzgbVarZzt;
                        long j4 = zzasVarZzn.zzf;
                        zzasVarZzc = zzasVarZzn.zzc(zzawVar.zzd);
                        j = j4;
                    }
                    zzas zzasVar3 = zzasVarZzc;
                    zzioVarZzr.zzf.zzi().zzE(zzasVar3);
                    zzgbVar2 = zzgbVar;
                    zzarVar = new zzar(zzioVarZzr.zzs, zzawVar.zzc, str, zzawVar.zza, zzawVar.zzd, j, bundle2);
                    zzfrVarZze = com.google.android.gms.internal.measurement.zzfs.zze();
                    zzfrVarZze.zzm(zzarVar.zzd);
                    zzfrVarZze.zzi(zzarVar.zzb);
                    zzfrVarZze.zzl(zzarVar.zze);
                    zzatVar = new zzat(zzarVar.zzf);
                    while (zzatVar.hasNext()) {
                        String next3 = zzatVar.next();
                        zzfvVarZze = com.google.android.gms.internal.measurement.zzfw.zze();
                        zzfvVarZze.zzj(next3);
                        objZzf = zzarVar.zzf.zzf(next3);
                        if (objZzf != null) {
                            zzioVarZzr.zzf.zzu().zzt(zzfvVarZze, objZzf);
                            zzfrVarZze.zze(zzfvVarZze);
                        }
                    }
                    zzgbVar2.zzk(zzfrVarZze);
                    com.google.android.gms.internal.measurement.zzgd zzgdVarZza3 = com.google.android.gms.internal.measurement.zzgf.zza();
                    com.google.android.gms.internal.measurement.zzft zzftVarZza3 = com.google.android.gms.internal.measurement.zzfu.zza();
                    zzftVarZza3.zza(zzasVar3.zzc);
                    zzftVarZza3.zzb(zzawVar.zza);
                    zzgdVarZza3.zza(zzftVarZza3);
                    zzgbVar2.zzaa(zzgdVarZza3);
                    zzgbVar2.zzf(zzioVarZzr.zzf.zzf().zza(zzhVar.zzt(), Collections.emptyList(), zzgbVar2.zzat(), Long.valueOf(zzfrVarZze.zzc()), Long.valueOf(zzfrVarZze.zzc())));
                    if (zzfrVarZze.zzq()) {
                        zzgbVar2.zzai(zzfrVarZze.zzc());
                        zzgbVar2.zzQ(zzfrVarZze.zzc());
                    }
                    jZzn = zzhVar.zzn();
                    if (jZzn != 0) {
                        zzgbVar2.zzab(jZzn);
                    }
                    jZzp = zzhVar.zzp();
                    if (jZzp != 0) {
                        zzgbVar2.zzac(jZzp);
                    } else if (jZzn != 0) {
                        zzgbVar2.zzac(jZzn);
                    }
                    strZzB = zzhVar.zzB();
                    zzpi.zzc();
                    if (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzay)) {
                        zzgbVar2.zzah(strZzB);
                    }
                    zzhVar.zzE();
                    zzgbVar2.zzI((int) zzhVar.zzo());
                    zzioVarZzr.zzs.zzf().zzh();
                    zzgbVar2.zzal(68000L);
                    zzgbVar2.zzak(zzioVarZzr.zzs.zzav().currentTimeMillis());
                    zzgbVar2.zzag(Boolean.TRUE.booleanValue());
                    if (zzioVarZzr.zzs.zzf().zzs(null, zzeh.zzaG)) {
                        zzioVarZzr.zzf.zzC(zzgbVar2.zzap(), zzgbVar2);
                    }
                    zzfzVar.zza(zzgbVar2);
                    zzhVar.zzab(zzgbVar2.zzd());
                    zzhVar.zzZ(zzgbVar2.zzc());
                    zzioVarZzr.zzf.zzi().zzD(zzhVar);
                    zzioVarZzr.zzf.zzi().zzC();
                    zzioVarZzr.zzf.zzi().zzx();
                    return zzioVarZzr.zzf.zzu().zzy(((com.google.android.gms.internal.measurement.zzga) zzfzVar.zzaE()).zzbv());
                } catch (SecurityException e3) {
                    zzioVarZzr.zzs.zzay().zzc().zzb("Resettable device id encryption failed", e3.getMessage());
                    bArr = new byte[0];
                    zzlfVar = zzioVarZzr.zzf;
                }
            }
            zzlfVar.zzi().zzx();
            return bArr;
        } catch (Throwable th) {
            zzioVarZzr.zzf.zzi().zzx();
            throw th;
        }
    }
}
