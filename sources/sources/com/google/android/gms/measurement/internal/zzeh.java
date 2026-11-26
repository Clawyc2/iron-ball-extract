package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.webkit.ProxyConfig;
import androidx.work.WorkRequest;
import androidx.work.impl.Scheduler;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zznj;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzoq;
import com.google.android.gms.internal.measurement.zzot;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzpl;
import com.google.android.gms.internal.measurement.zzpo;
import com.google.android.gms.internal.measurement.zzpr;
import com.google.android.gms.internal.measurement.zzpu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeh {
    public static final zzeg zzA;
    public static final zzeg zzB;
    public static final zzeg zzC;
    public static final zzeg zzD;
    public static final zzeg zzE;
    public static final zzeg zzF;
    public static final zzeg zzG;
    public static final zzeg zzH;
    public static final zzeg zzI;
    public static final zzeg zzJ;
    public static final zzeg zzK;
    public static final zzeg zzL;
    public static final zzeg zzM;
    public static final zzeg zzN;
    public static final zzeg zzO;
    public static final zzeg zzP;
    public static final zzeg zzQ;
    public static final zzeg zzR;
    public static final zzeg zzS;
    public static final zzeg zzT;
    public static final zzeg zzU;
    public static final zzeg zzV;
    public static final zzeg zzW;
    public static final zzeg zzX;
    public static final zzeg zzY;
    public static final zzeg zzZ;
    public static final zzeg zza;
    public static final zzeg zzaA;
    public static final zzeg zzaB;
    public static final zzeg zzaC;
    public static final zzeg zzaD;
    public static final zzeg zzaE;
    public static final zzeg zzaF;
    public static final zzeg zzaG;
    public static final zzeg zzaH;
    private static final List zzaI = Collections.synchronizedList(new ArrayList());
    private static final Set zzaJ = Collections.synchronizedSet(new HashSet());
    public static final zzeg zzaa;
    public static final zzeg zzab;
    public static final zzeg zzac;
    public static final zzeg zzad;
    public static final zzeg zzae;
    public static final zzeg zzaf;
    public static final zzeg zzag;
    public static final zzeg zzah;
    public static final zzeg zzai;
    public static final zzeg zzaj;
    public static final zzeg zzak;
    public static final zzeg zzal;
    public static final zzeg zzam;
    public static final zzeg zzan;
    public static final zzeg zzao;
    public static final zzeg zzap;
    public static final zzeg zzaq;
    public static final zzeg zzar;
    public static final zzeg zzas;
    public static final zzeg zzat;
    public static final zzeg zzau;
    public static final zzeg zzav;
    public static final zzeg zzaw;
    public static final zzeg zzax;
    public static final zzeg zzay;
    public static final zzeg zzaz;
    public static final zzeg zzb;
    public static final zzeg zzc;
    public static final zzeg zzd;
    public static final zzeg zze;
    public static final zzeg zzf;
    public static final zzeg zzg;
    public static final zzeg zzh;
    public static final zzeg zzi;
    public static final zzeg zzj;
    public static final zzeg zzk;
    public static final zzeg zzl;
    public static final zzeg zzm;
    public static final zzeg zzn;
    public static final zzeg zzo;
    public static final zzeg zzp;
    public static final zzeg zzq;
    public static final zzeg zzr;
    public static final zzeg zzs;
    public static final zzeg zzt;
    public static final zzeg zzu;
    public static final zzeg zzv;
    public static final zzeg zzw;
    public static final zzeg zzx;
    public static final zzeg zzy;
    public static final zzeg zzz;

    static {
        Long lValueOf = Long.valueOf(WorkRequest.MIN_BACKOFF_MILLIS);
        zza = zza("measurement.ad_id_cache_time", lValueOf, lValueOf, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbj
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzb());
            }
        });
        zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbb
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzl());
            }
        });
        zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbn
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzd());
            }
        });
        zzd = zza("measurement.config.url_scheme", ProxyConfig.MATCH_HTTPS, ProxyConfig.MATCH_HTTPS, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbz
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return zznp.zzK();
            }
        });
        zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", new zzed() { // from class: com.google.android.gms.measurement.internal.zzcl
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return zznp.zzJ();
            }
        });
        zzf = zza("measurement.upload.max_bundles", 100, 100, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcx
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzw());
            }
        });
        zzg = zza("measurement.upload.max_batch_size", 65536, 65536, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdj
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzE());
            }
        });
        zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdv
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzv());
            }
        });
        zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdz
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzz());
            }
        });
        zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzea
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzA());
            }
        });
        zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbu
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzy());
            }
        });
        zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcf
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzB());
            }
        });
        zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcq
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzx());
            }
        });
        zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdb
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzD());
            }
        });
        zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdm
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzg());
            }
        });
        zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", new zzed() { // from class: com.google.android.gms.measurement.internal.zzdx
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return zznp.zzL();
            }
        });
        zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzeb
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzs());
            }
        });
        zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzec
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzH());
            }
        });
        zzs = zza("measurement.upload.interval", 3600000L, 3600000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzaz
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzu());
            }
        });
        zzt = zza("measurement.upload.realtime_upload_interval", lValueOf, lValueOf, new zzed() { // from class: com.google.android.gms.measurement.internal.zzba
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzm());
            }
        });
        zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbc
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zze());
            }
        });
        zzv = zza("measurement.upload.minimum_delay", 500L, 500L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbd
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzk());
            }
        });
        zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbe
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzj());
            }
        });
        zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbf
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzp());
            }
        });
        zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbg
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzn());
            }
        });
        zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbh
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzt());
            }
        });
        zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbi
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzG());
            }
        });
        zzB = zza("measurement.upload.retry_count", 6, 6, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbk
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzF());
            }
        });
        zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbl
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzC());
            }
        });
        zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbm
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzf());
            }
        });
        Integer numValueOf = Integer.valueOf(Scheduler.MAX_GREEDY_SCHEDULER_LIMIT);
        zzE = zza("measurement.audience.filter_result_max_count", numValueOf, numValueOf, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbo
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzi());
            }
        });
        zzF = zza("measurement.upload.max_public_user_properties", 25, 25, null);
        zzG = zza("measurement.upload.max_event_name_cardinality", 500, 500, null);
        zzH = zza("measurement.upload.max_public_event_params", 25, 25, null);
        zzI = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzo());
            }
        });
        zzJ = zza("measurement.test.boolean_flag", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzot.zzg());
            }
        });
        zzK = zza("measurement.test.string_flag", "---", "---", new zzed() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return zzot.zzf();
            }
        });
        zzL = zza("measurement.test.long_flag", -1L, -1L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zzot.zzd());
            }
        });
        zzM = zza("measurement.test.int_flag", -2, -2, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zzot.zzc());
            }
        });
        Double dValueOf = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", dValueOf, dValueOf, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Double.valueOf(zzot.zzb());
            }
        });
        zzO = zza("measurement.experiment.max_ids", 50, 50, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzh());
            }
        });
        zzP = zza("measurement.max_bundles_per_iteration", 100, 100, new zzed() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zznp.zzc());
            }
        });
        zzQ = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzq());
            }
        });
        zzR = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, new zzed() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Long.valueOf(zznp.zzr());
            }
        });
        zzS = zza("measurement.collection.log_event_and_bundle_v2", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoz.zzc());
            }
        });
        zzT = zza("measurement.quality.checksum", false, false, null);
        zzU = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoe.zze());
            }
        });
        zzV = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoe.zzd());
            }
        });
        zzW = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoe.zzf());
            }
        });
        zzX = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpr.zzc());
            }
        });
        zzY = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzon.zzc());
            }
        });
        zzZ = zza("measurement.lifecycle.app_in_background_parameter", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoq.zzc());
            }
        });
        zzaa = zza("measurement.integration.disable_firebase_instance_id", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpo.zzd());
            }
        });
        zzab = zza("measurement.collection.service.update_with_analytics_fix", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpu.zzc());
            }
        });
        zzac = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzob.zzd());
            }
        });
        zzad = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzok.zzd());
            }
        });
        zzae = zza("measurement.collection.synthetic_data_mitigation", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpl.zzc());
            }
        });
        zzaf = zza("measurement.service.storage_consent_support_version", 203600, 203600, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Integer.valueOf((int) zzns.zzb());
            }
        });
        zzag = zza("measurement.client.click_identifier_control.dev", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznj.zzc());
            }
        });
        zzah = zza("measurement.service.click_identifier_control", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznm.zzc());
            }
        });
        zzai = zza("measurement.module.pixie.fix_array", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzow.zzd());
            }
        });
        zzaj = zza("measurement.adid_zero.only_request_adid_if_enabled", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzng.zzc());
            }
        });
        zzak = zza("measurement.service.refactor.package_side_screen", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpf.zzd());
            }
        });
        zzal = zza("measurement.enhanced_campaign.service", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zze());
            }
        });
        zzam = zza("measurement.enhanced_campaign.client", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zzd());
            }
        });
        zzan = zza("measurement.enhanced_campaign.srsltid.client", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zzf());
            }
        });
        zzao = zza("measurement.enhanced_campaign.srsltid.service", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zznv.zzg());
            }
        });
        zzap = zza("measurement.service.store_null_safelist", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzny.zzd());
            }
        });
        zzaq = zza("measurement.service.store_safelist", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzny.zze());
            }
        });
        zzar = zza("measurement.redaction.no_aiid_in_config_request", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzl());
            }
        });
        zzas = zza("measurement.redaction.config_redacted_fields", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzf());
            }
        });
        zzat = zza("measurement.redaction.upload_redacted_fields", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzo());
            }
        });
        zzau = zza("measurement.redaction.upload_subdomain_override", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzp());
            }
        });
        zzav = zza("measurement.redaction.device_info", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzg());
            }
        });
        zzaw = zza("measurement.redaction.user_id", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzq());
            }
        });
        zzax = zza("measurement.redaction.google_signals", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzk());
            }
        });
        zzay = zza("measurement.collection.enable_session_stitching_token.service", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpi.zze());
            }
        });
        zzaz = zza("measurement.collection.enable_session_stitching_token.client.dev", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpi.zzd());
            }
        });
        zzaA = zza("measurement.redaction.app_instance_id", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzd());
            }
        });
        zzaB = zza("measurement.redaction.populate_ephemeral_app_instance_id", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzj());
            }
        });
        zzaC = zza("measurement.redaction.enhanced_uid", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdr
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzi());
            }
        });
        zzaD = zza("measurement.redaction.e_tag", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzds
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzh());
            }
        });
        zzaE = zza("measurement.redaction.client_ephemeral_aiid_generation", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdt
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zze());
            }
        });
        zzaF = zza("measurement.redaction.retain_major_os_version", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzm());
            }
        });
        zzaG = zza("measurement.redaction.scion_payload_generator", false, false, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzpc.zzn());
            }
        });
        zzaH = zza("measurement.audience.dynamic_filters.oob_fix", true, true, new zzed() { // from class: com.google.android.gms.measurement.internal.zzdy
            @Override // com.google.android.gms.measurement.internal.zzed
            public final Object zza() {
                zzeg zzegVar = zzeh.zza;
                return Boolean.valueOf(zzoh.zzd());
            }
        });
    }

    static zzeg zza(String str, Object obj, Object obj2, zzed zzedVar) {
        zzeg zzegVar = new zzeg(str, obj, obj2, zzedVar, null);
        zzaI.add(zzegVar);
        return zzegVar;
    }

    public static Map zzc(Context context) {
        com.google.android.gms.internal.measurement.zzhe zzheVarZza = com.google.android.gms.internal.measurement.zzhe.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzhp.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzay
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.internal.measurement.zzia.zzd();
            }
        });
        return zzheVarZza == null ? Collections.emptyMap() : zzheVarZza.zzc();
    }
}
