package by.chemerisuk.cordova.firebase;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import by.chemerisuk.cordova.support.CordovaMethod;
import by.chemerisuk.cordova.support.ReflectiveCordovaPlugin;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseAnalyticsPlugin extends ReflectiveCordovaPlugin {
    private static final String TAG = "FirebaseAnalyticsPlugin";
    private FirebaseAnalytics firebaseAnalytics;

    @Override // org.apache.cordova.CordovaPlugin
    protected void pluginInitialize() {
        Log.d(TAG, "Starting Firebase Analytics plugin");
        this.firebaseAnalytics = FirebaseAnalytics.getInstance(this.f4cordova.getActivity().getApplicationContext());
    }

    @CordovaMethod
    private void logEvent(CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        this.firebaseAnalytics.logEvent(cordovaArgs.getString(0), parse(cordovaArgs.getJSONObject(1)));
        callbackContext.success();
    }

    @CordovaMethod
    private void setUserId(CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        this.firebaseAnalytics.setUserId(cordovaArgs.getString(0));
        callbackContext.success();
    }

    @CordovaMethod
    private void setUserProperty(CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        this.firebaseAnalytics.setUserProperty(cordovaArgs.getString(0), cordovaArgs.getString(1));
        callbackContext.success();
    }

    @CordovaMethod
    private void resetAnalyticsData(CordovaArgs cordovaArgs, CallbackContext callbackContext) {
        this.firebaseAnalytics.resetAnalyticsData();
        callbackContext.success();
    }

    @CordovaMethod
    private void setEnabled(CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        this.firebaseAnalytics.setAnalyticsCollectionEnabled(cordovaArgs.getBoolean(0));
        callbackContext.success();
    }

    @CordovaMethod
    private void setCurrentScreen(CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        String string = cordovaArgs.getString(0);
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME, string);
        this.firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
        callbackContext.success();
    }

    @CordovaMethod
    private void setDefaultEventParameters(CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        this.firebaseAnalytics.setDefaultEventParameters(parse(cordovaArgs.getJSONObject(0)));
        callbackContext.success();
    }

    private static Bundle parse(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                bundle.putLong(next, ((Long) obj).longValue());
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(parse(jSONArray.getJSONObject(i)));
                }
                bundle.putParcelableArrayList(next, arrayList);
            } else {
                Log.w(TAG, "Value for key " + next + " is not supported");
            }
        }
        return bundle;
    }
}
