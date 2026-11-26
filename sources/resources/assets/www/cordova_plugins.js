cordova.define('cordova/plugin_list', function(require, exports, module) {
  module.exports = [
    {
      "id": "cordova-plugin-inappbrowser.inappbrowser",
      "file": "plugins/cordova-plugin-inappbrowser/www/inappbrowser.js",
      "pluginId": "cordova-plugin-inappbrowser",
      "clobbers": [
        "cordova.InAppBrowser.open"
      ]
    },
    {
      "id": "construct-mobile-advert2.AdMob",
      "file": "plugins/construct-mobile-advert2/www/admob.js",
      "pluginId": "construct-mobile-advert2",
      "clobbers": [
        "admob"
      ]
    },
    {
      "id": "community-cordova-plugin-consent.Consent",
      "file": "plugins/community-cordova-plugin-consent/www/consent.js",
      "pluginId": "community-cordova-plugin-consent",
      "clobbers": [
        "consent"
      ]
    },
    {
      "id": "cordova-plugin-device.device",
      "file": "plugins/cordova-plugin-device/www/device.js",
      "pluginId": "cordova-plugin-device",
      "clobbers": [
        "device"
      ]
    },
    {
      "id": "cordova-plugin-purchase.CdvPurchase",
      "file": "plugins/cordova-plugin-purchase/www/store.js",
      "pluginId": "cordova-plugin-purchase",
      "clobbers": [
        "store",
        "CdvPurchase"
      ]
    },
    {
      "id": "cordova-plugin-firebase-analytics.FirebaseAnalytics",
      "file": "plugins/cordova-plugin-firebase-analytics/www/FirebaseAnalytics.js",
      "pluginId": "cordova-plugin-firebase-analytics",
      "merges": [
        "cordova.plugins.firebase.analytics"
      ]
    },
    {
      "id": "cordova-plugin-fullscreen.AndroidFullScreen",
      "file": "plugins/cordova-plugin-fullscreen/www/AndroidFullScreen.js",
      "pluginId": "cordova-plugin-fullscreen",
      "clobbers": [
        "AndroidFullScreen"
      ]
    },
    {
      "id": "cordova-plugin-android-notch.notch",
      "file": "plugins/cordova-plugin-android-notch/www/notch.js",
      "pluginId": "cordova-plugin-android-notch",
      "clobbers": [
        "window.AndroidNotch"
      ]
    }
  ];
  module.exports.metadata = {
    "cordova-plugin-inappbrowser": "7.0.0",
    "construct-mobile-advert2": "1.0.0",
    "community-cordova-plugin-consent": "3.0.2",
    "cordova-plugin-device": "3.0.0",
    "construct-mobile-export2": "1.0.5",
    "cordova-plugin-purchase": "13.15.3",
    "cordova-support-android-plugin": "2.0.4",
    "cordova-plugin-firebase-analytics": "7.0.5",
    "cordova-plugin-vibration": "3.1.1",
    "cordova-plugin-fullscreen": "1.3.0",
    "cordova-plugin-android-notch": "1.0.0"
  };
});