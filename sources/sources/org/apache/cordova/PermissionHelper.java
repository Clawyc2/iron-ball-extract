package org.apache.cordova;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class PermissionHelper {
    @Deprecated
    public static void requestPermission(CordovaPlugin cordovaPlugin, int i, String str) {
        requestPermissions(cordovaPlugin, i, new String[]{str});
    }

    @Deprecated
    public static void requestPermissions(CordovaPlugin cordovaPlugin, int i, String[] strArr) {
        cordovaPlugin.f4cordova.requestPermissions(cordovaPlugin, i, strArr);
    }

    @Deprecated
    public static boolean hasPermission(CordovaPlugin cordovaPlugin, String str) {
        return cordovaPlugin.f4cordova.hasPermission(str);
    }
}
