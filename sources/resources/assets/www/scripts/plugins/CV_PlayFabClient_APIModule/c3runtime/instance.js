"use strict";

{
	const C3 = globalThis.C3;

	const DOM_COMPONENT_ID = "cv-playfab-api";

	const PLAYFAB_REF = "CV_PlayFab_MasterCollection";

	C3.Plugins.CV_PlayFabClient_APIModule.Instance = class PlayFab_API_Instance extends globalThis.ISDKInstanceBase
	{
		constructor()
		{
			super({ domComponentId: DOM_COMPONENT_ID })
			const properties = this._getInitProperties();
			
			if (properties)
			{
				this.titleID = properties[0];
				this.debugMode = properties[1] === 0 ? true : false;
				this.initialized = false;

				//** Profile Constraints **//
				this.ProfileConstraints_Auto = properties[2] === 0 ? true : false; //Automatic or Manual
		
				//** Client Profile Options **//
				this.Config_AvatarURL = properties[3] === 0 ? true : false;
				this.Config_Banned    = properties[4] === 0 ? true : false;
				this.Config_Campaign  = properties[5] === 0 ? true : false;
				this.Config_Creation  = properties[6] === 0 ? true : false;
				this.Config_Name      = properties[7] === 0 ? true : false;
				this.Config_LastLogin = properties[8] === 0 ? true : false;
				this.Config_Locations = properties[9] === 0 ? true : false;
				this.Config_Origin    = properties[10] === 0 ? true : false;
				this.Config_Stats     = properties[11] === 0 ? true : false;
				this.Config_Tags      = properties[12] === 0 ? true : false;
				this.Config_ValuesUSD = properties[13] === 0 ? true : false;
				this.Config_Values    = properties[14] === 0 ? true : false;

				this.Config_Accounts  = properties[15] === 0 ? true : false;
				this.Config_Push      = properties[16] === 0 ? true : false;
				this.Config_Email     = properties[17] === 0 ? true : false;
			}

			this.Initialize();
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

		///////////////////////////////////////
		// Core Methods

		Initialize()
		{
			//** Tools **/
			const self = this;
			const Conditions = C3.Plugins.CV_PlayFabClient_APIModule.Cnds;

			this.Call = function (_path) {
				const trigger = _path;
	
				self._trigger(trigger);
			};

			this.C3Memory = {

				Response: ""
			};

			this.C3Trigger = {

				CallAPIMethod : function (_callback, _error)
				{
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode)
						{
							self.debug("Call API Method :: Positive Response Received : ");
							self.debug(_callback);
						}				

						// Set Server Response into C3Memory
						self.C3Memory.Response = JSON.stringify(_callback);					

						// Call Function
						const trigger = Conditions.OnCallAPIResponse;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode)
						{
							self.debug("Triggered : On Call API Response");
						}
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode)
						{
							self.debugCommonLog();
							self.debug("Call API Method :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.Response = JSON.stringify(_error);						

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode)
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.OnCallAPIError;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode)
						{
							self.debug("Triggered : On Call API Error");
						}					
					}	
				}
			};				

			//** Construct 3 DOM Handlers **/
			this._addDOMMessageHandlers([
				["call-api-method", e => this.C3Trigger.CallAPIMethod(...e)]
			]);

			//** Start Initialization **/
			this.setGlobalObject();
			this.setGlobalSessionTicket(null);
			this._SetTitleID(this.titleID);
			this.setGlobalDebugMode(this.debugMode);

			this.setGlobalProfileConstraintsMode(this.ProfileConstraints_Auto);
	
			this.setGlobalConfiguration("Config_AvatarURL", this.Config_AvatarURL);
			this.setGlobalConfiguration("Config_Banned", this.Config_Banned);
			this.setGlobalConfiguration("Config_Campaign", this.Config_Campaign);
			this.setGlobalConfiguration("Config_Creation", this.Config_Creation);
			this.setGlobalConfiguration("Config_Name", this.Config_Name);
			this.setGlobalConfiguration("Config_LastLogin", this.Config_LastLogin);
			this.setGlobalConfiguration("Config_Locations", this.Config_Locations);
			this.setGlobalConfiguration("Config_Origin", this.Config_Origin);
			this.setGlobalConfiguration("Config_Stats", this.Config_Stats);
			this.setGlobalConfiguration("Config_Tags", this.Config_Tags);
			this.setGlobalConfiguration("Config_ValuesUSD", this.Config_ValuesUSD);
			this.setGlobalConfiguration("Config_Values", this.Config_Values);
	
			this.setGlobalConfiguration("Config_Accounts", this.Config_Accounts);
			this.setGlobalConfiguration("Config_Push", this.Config_Push);
			this.setGlobalConfiguration("Config_Email", this.Config_Email);
	
			this.setDebugCommonLog();

			//** Initialized **//
			this.initialized = true;

			if(this.debugMode)
			{
				this.debug("PlayFab Master Collection :: Initialized");
			}
		}

		///////////////////////////////////////
		// Action Methods
		_CallAPIMethod (_method, _data, _customData){
			
			const method = _method;
			const data = JSON.parse(_data);
			const customData = JSON.parse(_customData);

			this._postToDOM("call-api-method", [method, data, customData]);
		}

		_SetTitleID(_titleID){

			this.titleID = _titleID;
			this.setGlobalTitleID(_titleID);
			
			this._postToDOM("set-title-id", [_titleID]);
		}

		_ForgetAllCredentials()
		{
			this._postToDOM("forget-all-credentials", []);
			this.setGlobalSessionTicket(null);
		}

		///////////////////////////////////////
		// Condition Methods
		__IsClientLoggedIn()
		{
			if (!this.initialized) { return false; }
			const session = globalThis[PLAYFAB_REF]["session-ticket"];
			
			return session != null && session.length > 0;
		}

		///////////////////////////////////////
		// PlayFab Common Methods
		setGlobalObject()
		{
			if (typeof globalThis[PLAYFAB_REF] === "undefined")
			{
				globalThis[PLAYFAB_REF] = {};
			}
			if (typeof globalThis[PLAYFAB_REF]["ProfileDataList"] === "undefined")
			{
				globalThis[PLAYFAB_REF]["ProfileDataList"] = {};
			}
			if (typeof globalThis[PLAYFAB_REF]["GenerateErrorReport"] === "undefined")
			{
				globalThis[PLAYFAB_REF]["GenerateErrorReport"] = (error) => {
					if (error == null)
					return "";
					var fullErrors = error["errorMessage"];
					for (var paramName in error["errorDetails"])
						for (var msgIdx in error["errorDetails"][paramName])
							fullErrors += "\n" + paramName + ": " + error["errorDetails"][paramName][msgIdx];
					return fullErrors;
				};
			}
		}
		setGlobalSessionTicket (_session){

			globalThis[PLAYFAB_REF]["session-ticket"] = _session;
		}
		setGlobalTitleID (_titleID){

			globalThis[PLAYFAB_REF]["titleID"] = _titleID;
		}
		setGlobalDebugMode (_bool){

			globalThis[PLAYFAB_REF]["debugMode"] = _bool;		
		}
		setGlobalProfileConstraintsMode (_bool){

			globalThis[PLAYFAB_REF]["ProfileConstraints_Auto"] = _bool;		
		}
		setGlobalConfiguration (_target, _bool){

			globalThis[PLAYFAB_REF]["ProfileDataList"][_target] = _bool;
		}
		setDebugCommonLog (){

			globalThis[PLAYFAB_REF]["debugCommonLog"] = function (){
				console.log("Reminder :: The \"Red\" Error, \"POST 400 ()\" is a common PlayFab Error Log that indicates that the PlayFab Server's response is negative." + 
							"This error is converted into additional usable triggers in the PlayFab Modules. This error is harmless and nothing to worry about.");
			}
		}
		debug(_message){
			console.log(_message);
		}
		GenerateErrorReport(error)
		{
			return globalThis[PLAYFAB_REF]["GenerateErrorReport"](error);
		}
		//////////////////////////////
	};
}
