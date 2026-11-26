"use strict";
{
    globalThis.C3.Plugins.EMI_INDO_Firebase_AnalyticsNew.Instance = class Firebase_AnalyticsNewInstance extends globalThis.ISDKInstanceBase {
        constructor() {
            super();

            const properties = this._getInitProperties();


            if (properties) { }

            this._isCordovaReady = false;

            if (typeof cordova !== 'undefined') {

                this._isCordovaReady = true;

            }


        }

        _release() {
            super._release();
        }

        _saveToJson() {
            return {
                // data to be saved for savegames
            };
        }

        _loadFromJson(o) {
            // load state for savegames
        }


        _LogEvent(name, value) {

            if (this._isCordovaReady) {
                cordova.plugins.firebase.analytics.logEvent(name,
                    {
                        value: value
                    });
            }

        }


        _Reset() {

            if (this._isCordovaReady) {
                cordova.plugins.firebase.analytics.resetAnalyticsData();
            }

        }


        _LogEventJs(name, json) {

            if (this._isCordovaReady) {
                var obj = {};
                obj = JSON.parse(json);
                cordova.plugins.firebase.analytics.logEvent(name, obj);
            }
            
        }


        _SetEnabled(enabled) {

            if (this._isCordovaReady) {
                cordova.plugins.firebase.analytics.setEnabled(enabled);
            }

        }



        _SetUserId(userId) {

            if (this._isCordovaReady) {
                cordova.plugins.firebase.analytics.setUserId(userId);
            }

        }



        _SetUserPro(name, value) {

            if (this._isCordovaReady) {
                cordova.plugins.firebase.analytics.setUserProperty(name, value);
            }
            
        }


        _SetCurrentScreen(screenName) {

            if (this._isCordovaReady) {
                cordova.plugins.firebase.analytics.setCurrentScreen(screenName);
            }

        }


        _SetDefaultEventParameters(json) {
            if (this._isCordovaReady) {
                var obj = {};
                obj = JSON.parse(json);
                cordova.plugins.firebase.analytics.setDefaultEventParameters(obj);
            }
        }



    };
}