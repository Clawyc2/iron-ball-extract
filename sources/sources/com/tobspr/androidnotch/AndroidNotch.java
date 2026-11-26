package com.tobspr.androidnotch;

import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.appcompat.app.AppCompatActivity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class AndroidNotch extends CordovaPlugin {
    private static final String TAG = "AndroidNotch";

    @Override // org.apache.cordova.CordovaPlugin
    public boolean execute(String str, CordovaArgs cordovaArgs, CallbackContext callbackContext) throws JSONException {
        AppCompatActivity activity = this.f4cordova.getActivity();
        activity.getWindow();
        if ("setLayout".equals("action")) {
            this.webView.getView().setSystemUiVisibility(1024);
            return true;
        }
        if (Build.VERSION.SDK_INT < 28) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
            return true;
        }
        DisplayCutout displayCutout = getInsets().getDisplayCutout();
        float f = activity.getResources().getDisplayMetrics().density;
        if ("hasCutout".equals(str)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, displayCutout != null));
            return true;
        }
        if ("getInsetsTop".equals(str)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, displayCutout != null ? displayCutout.getSafeInsetTop() / f : 0.0f));
            return true;
        }
        if ("getInsetsRight".equals(str)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, displayCutout != null ? displayCutout.getSafeInsetRight() / f : 0.0f));
            return true;
        }
        if ("getInsetsBottom".equals(str)) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, displayCutout != null ? displayCutout.getSafeInsetBottom() / f : 0.0f));
            return true;
        }
        if (!"getInsetsLeft".equals(str)) {
            return false;
        }
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, displayCutout != null ? displayCutout.getSafeInsetLeft() / f : 0.0f));
        return true;
    }

    private WindowInsets getInsets() {
        return this.webView.getView().getRootWindowInsets();
    }
}
