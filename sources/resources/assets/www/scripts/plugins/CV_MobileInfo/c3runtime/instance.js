"use strict";

{
	const C3 = globalThis.C3;

	const DOM_COMPONENT_ID = "chadori-mobile-info";

        ///////////////////////////////////////////////////
        // Utilities

		function getPlatformFromIndex(index)
		{
			switch (index) 
			{
				case 0 :
					return "Android";
				case 1 :
					return "iOS";
				case 2 :
					return "Mac OS X";
				case 3 :
					return "WinCE";
				case 4 :
					return "browser";
				case 5 :
					return "Tizen";
				case 6 :
					return "BlackBerry 10";
				default :
					return "";
			}
		}

		function getBrowserPlatformKey()
		{
			return getPlatformFromIndex(4);
		}

		///////////////////////////////////////////////////

	C3.Plugins.CV_MobileInfo.Instance = class Mobile_Info_Instance extends globalThis.ISDKInstanceBase
	{
		constructor()
		{
			super({ domComponentId: DOM_COMPONENT_ID });
			
			this._isDebug = false;

			const properties = this._getInitProperties();
			if (properties)
			{
				this._isDebug = properties[0];
			}

            ///////////////////////////////////////////////////
            // Current References
			
			this._isSDKReady = false;
	
            ///////////////////////////////////////////////////
            // Memory References

			this._deviceInformation = {

				"isVirtual": false,

				"cordova": "",
				"model": "",
				"platform": getBrowserPlatformKey(),
				"uuid": "",
				"version": "",
				"manufacturer": "",
				"serial": ""
			};
		
            ///////////////////////////////////////////////////
            // System References

            this._addDOMMessageHandlers([
				["on-mobile-sdk", e => this._OnMobileSDK(...e)]
            ]);

            this._Conditions = C3.Plugins.CV_MobileInfo.Cnds;

            ///////////////////////////////////////////////////
            // Start SDK

            this.StartSDK(this._isDebug);
		}
		
		_release()
		{
			super._release();
		}
		
		_saveToJson()
		{
			return {
			};
		}
		
		_loadFromJson(o)
		{
		}

        ///////////////////////////////////////////////////
        // Core Methods

        StartSDK(isDebug, isAutoStart, isRunInBackground, isRunInFullPower, isOverrideBackButton, isExcludeTasksList)
        {
            this._postToDOM("start-sdk", [isDebug, isAutoStart, isRunInBackground, isRunInFullPower, isOverrideBackButton, isExcludeTasksList]);
        }

        ///////////////////////////////////////////////////
        // Utilities

        _Log(str) { if (!this._isDebug) { return; } console.log("[Mobile Info]", str) }

        ///////////////////////////////////////////////////
        // Silent DOM Callbacks

        _OnMobileSDK(deviceInformation)
        {
			this._deviceInformation = deviceInformation;
            this._isSDKReady = true;
        }

        ///////////////////////////////////////////////////
        // DOM Callbacks



        ///////////////////////////////////////////////////
        // Checks

        // Check if the domside.js has initialized.
        _IsSDKReady()
        {
            return this._isSDKReady;
        }

        ///////////////////////////////////////////////////
        // Conditions
		
		_IsPlatform(index)
		{
			return this._deviceInformation["platform"] === getPlatformFromIndex(index);
		}
	};
}
