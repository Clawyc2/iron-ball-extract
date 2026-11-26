"use strict";
{
   globalThis.C3.Plugins.EMI_INDO_Firebase_AnalyticsNew.Acts = {
        async LogEvent(name, value) {
            if (typeof cordova !== 'undefined') {
                await this._LogEvent(name, value);
            }
        },

        async Reset() {

            if (typeof cordova !== 'undefined') {
                await this._Reset();
            }
        },

       async LogEventJs(name, json) {
            if (typeof cordova !== 'undefined') {
                await this._LogEventJs(name, json);
            }
        },

       async SetEnabled(enabled) {

            if (typeof cordova !== 'undefined') {
                await this._SetEnabled(enabled);
            }
        },

        async SetUserId(userId) {

            if (typeof cordova !== 'undefined') {
                await this._SetUserId(userId);
            }
        },

       async SetUserPro(name, value) {

            if (typeof cordova !== 'undefined') {
                await this._SetUserPro(name, value);
            }
        },

        async SetCurrentScreen(screenName) {

            if (typeof cordova !== 'undefined') {
                await this._SetCurrentScreen(screenName)
            }
        },

        async SetDefaultEventParameters(json) {
            if (typeof cordova !== 'undefined') {
                await this._SetDefaultEventParameters(json)
            }
        }


    };
}