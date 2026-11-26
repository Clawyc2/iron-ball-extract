"use strict";

{
	const C3 = globalThis.C3;

	const DOM_COMPONENT_ID = "cv-playfab-userdata";

	const PLAYFAB_REF = "CV_PlayFab_MasterCollection";

	C3.Plugins.CV_PlayFabClient_UserData.Instance = class PlayFab_UserData_Instance extends globalThis.ISDKInstanceBase
	{
		constructor()
		{
			super({ domComponentId: DOM_COMPONENT_ID })
			const properties = this._getInitProperties();
			
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

		Initialize()
		{
			//** System References **//
			const self = this;
			const Conditions = C3.Plugins.CV_PlayFabClient_UserData.Cnds;
			
			//** Construct 3 Stacks **//
			this.C3Stacks = {
	
				GetUserData : [],
				GetUserReadOnlyData : [],
				GetOtherUserData : [],
				GetOtherUserReadOnlyData : [],			
				UpdateUserData_Write : {},
				UpdateUserData_Remove : []
			};
	
			//** Construct 3 Current **//
			this.C3Current = {
	
				//* User Data *//	
				LoadDataKeyName : "",
				LoadReadDataKeyName : "",
				
				//* Other Data *//
				Other_LoadDataKeyName : "",
				Other_LoadReadDataKeyName : ""			
			};
	
			//** Construct 3 Memory **//
			this.C3Memory = {
				//* Universal */
				recentUpdateUserData : {},
				//* User Data *//
				recentGetUserData : {},
				recentGetUserReadOnlyData : {},
				//* Other User Data *//
				recentGetOtherUserData : {},
				recentGetOtherUserReadOnlyData : {},
				recentServerResponse : "",
				recentTag : ""
			};

			//** Construct 3 Trigger **//
			this.C3Trigger = {

				//* Universal */
				updateUserData : function (_callback, _error) {
				
					if (_callback != null)
					{		
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Update User Data :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);		
						
						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];								

						// Push to framework memory.
						self.C3Memory.recentUpdateUserData = _callback["data"];

						// Call Function
						const trigger = Conditions.UpdateUserData;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Update User Data");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Update User Data :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);		
						
						// Record Tag	
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];								

						// Clear from framework memory.
						self.C3Memory.recentUpdateUserData = {};

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.UpdateUserData_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Update User Data Error");
						}										
					}	
				
				},

				//* User Data */
				getUserData : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get User Data :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);			
						
						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];							

						// Push to framework memory.
						self.C3Memory.recentGetUserData = _callback["data"];
						
						// Call Function
						const trigger = Conditions.GetUserData;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get User Data");
						}					
					}
					else if (_error != null)
					{	
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get User Data :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);	
						
						// Record Tag	
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];												

						// Clear from framework memory.
						self.C3Memory.recentGetUserData = {};

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.GetUserData_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get User Data Error");
						}										
					}	
				
				},
				
				getUserReadOnlyData : function (_callback, _error) {
				
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get User Read Only Data :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);

						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];											

						// Push to framework memory.
						self.C3Memory.recentGetUserReadOnlyData = _callback["data"];
						
						// Call Function
						const trigger = Conditions.GetUserReadOnlyData;
						self.Call(trigger);			
						
						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get User Read Only Data");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get User Read Only Data :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);				
						
						// Record Tag
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];												

						// Clear from framework memory.
						self.C3Memory.recentGetUserReadOnlyData = {};

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}

						const trigger = Conditions.GetUserReadOnlyData_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get User Read Only Data Error");
						}										
					}	
				
				},

				//* Other User Data */
				getOtherUserData : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Other User Data :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);					

						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];						

						// Push to framework memory.
						self.C3Memory.recentGetOtherUserData = _callback["data"];

						// Call Function
						const trigger = Conditions.GetOtherUserData;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Other User Data");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Other User Data :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);

						// Record Tag
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];												

						// Clear from framework memory.
						self.C3Memory.recentGetOtherUserData = {};

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.GetOtherUserData_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Other User Data Error");
						}										
					}	
				
				},
				
				getOtherUserReadOnlyData : function (_callback, _error) {
				
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Other User Read Only Data :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);			
						
						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];							

						// Push to framework memory.
						self.C3Memory.recentGetOtherUserReadOnlyData = _callback["data"];
						
						// Call Function
						const trigger = Conditions.GetOtherUserReadOnlyData;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Other User Read Only Data");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Other User Read Only Data :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);					

						// Record Tag
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];						

						// Clear from framework memory.
						self.C3Memory.recentGetOtherUserReadOnlyData = {};

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}

						const trigger = Conditions.GetOtherUserReadOnlyData_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Other User Read Only Data Error");
						}										
					}	
				
				}
			};
	
			//** Construct 3 Get **//
			this.C3Get = {
	
				//* User */
				GetUserData : function (_key, _target) {
		
					const o = _key;
					const x = _target;
	
					if (x === 0)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"][o]["Value"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetUserData["Data"][o];
						return src["Value"];	
					}
					else if (x === 1)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"][o]["LastUpdated"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetUserData["Data"][o];
						return src["LastUpdated"];
					}
					else if (x === 2)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["Data"][o]["Permission"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetUserData["Data"][o];
						return src["Permission"];
					}
					else
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserData) ) { return 0; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserData["DataVersion"]) ) { return 0; }
	
						const src = self.C3Memory.recentGetUserData;
						return src["DataVersion"];
					}
				},
				GetUserReadOnlyData : function (_key, _target) {
	
					const o = _key;
					const x = _target;
	
					if (x === 0)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"][o]["Value"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetUserReadOnlyData["Data"][o];
						return src["Value"];	
					}
					else if (x === 1)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"][o]["LastUpdated"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetUserReadOnlyData["Data"][o];
						return src["LastUpdated"];
					}
					else if (x === 2)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["Data"][o]["Permission"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetUserReadOnlyData["Data"][o];
						return src["Permission"];
					}
					else
					{
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData) ) { return 0; }
						if ( !self.IsContaining(self.C3Memory.recentGetUserReadOnlyData["DataVersion"]) ) { return 0; }
	
						const src = self.C3Memory.recentGetUserReadOnlyData;
						return src["DataVersion"];
					}		
				},
				
				//* Other User */
				GetOtherUserData : function (_key, _target) {
		
					const o = _key;
					const x = _target;
	
					if (x === 0)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"][o]["Value"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetOtherUserData["Data"][o];
						return src["Value"];	
					}
					else if (x === 1)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"][o]["LastUpdated"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetOtherUserData["Data"][o];
						return src["LastUpdated"];
					}
					else if (x === 2)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["Data"][o]["Permission"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetOtherUserData["Data"][o];
						return src["Permission"];
					}
					else
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData) ) { return 0; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserData["DataVersion"]) ) { return 0; }
	
						const src = self.C3Memory.recentGetOtherUserData;
						return src["DataVersion"];
					}
				},
				GetOtherUserReadOnlyData : function (_key, _target) {
	
					const o = _key;
					const x = _target;
	
					if (x === 0)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o]["Value"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o];
						return src["Value"];	
					}
					else if (x === 1)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o]["LastUpdated"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o];
						return src["LastUpdated"];
					}
					else if (x === 2)
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o]) ) { return ""; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o]["Permission"]) ) { return ""; }
	
						const src = self.C3Memory.recentGetOtherUserReadOnlyData["Data"][o];
						return src["Permission"];
					}
					else
					{
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData) ) { return 0; }
						if ( !self.IsContaining(self.C3Memory.recentGetOtherUserReadOnlyData["DataVersion"]) ) { return 0; }
	
						const src = self.C3Memory.recentGetOtherUserReadOnlyData;
						return src["DataVersion"];
					}		
				},
	
				//* Universal */
				GetUpdateUserData : function () {
	
					if ( !self.IsContaining(self.C3Memory.recentUpdateUserData) ) { return 0; }		
					if ( !self.IsContaining(self.C3Memory.recentUpdateUserData["DataVersion"]) ) { return 0; }
	
					const src = self.C3Memory.recentUpdateUserData;
					return src["DataVersion"];	
				}
			};
	
			//** System Methods **//
			this.Call = function (_path) {
				const trigger = _path;
	
				self._trigger(trigger);
			};

			//** Construct 3 DOM Handlers **//
			this._addDOMMessageHandlers([
				["get-user-data", e => this.C3Trigger.getUserData(...e)],
				["get-user-read-only-data", e => this.C3Trigger.getUserReadOnlyData(...e)],

				["update-user-data", e => this.C3Trigger.updateUserData(...e)],

				["get-other-user-data", e => this.C3Trigger.getOtherUserData(...e)],
				["get-other-user-read-only-data", e => this.C3Trigger.getOtherUserReadOnlyData(...e)]
            ]); 
		}

		///////////////////////////////////////
		// Action Methods

		//** User Data **//
		_GetUserData (_tag)
		{
			const keys = this.C3Stacks.GetUserData;
			const data = {
				"Keys" : keys
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};						

			//..Clear Stack
			this.C3Stacks.GetUserData = [];

			this._postToDOM("get-user-data", [data, customData]);	
		}

		_GetUserReadOnlyData (_tag) {

			const keys = this.C3Stacks.GetUserReadOnlyData;
			const data = {
				"Keys" : keys
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};						

			//..Clear Stack
			this.C3Stacks.GetUserReadOnlyData = [];

			this._postToDOM("get-user-read-only-data", [data, customData]);	
		}

		_GetAllUserData (_tag)
		{
			const data = {};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};			

			this._postToDOM("get-user-data", [data, customData]);	
		}

		_GetAllUserReadOnlyData (_tag) {

			const data = {};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};			

			this._postToDOM("get-user-read-only-data", [data, customData]);	
		}

		_UpdateUserData (_permission, _tag) {
			
			const writeItems  = this.C3Stacks.UpdateUserData_Write;
			const removeItems = this.C3Stacks.UpdateUserData_Remove;
			const permission  = _permission === 0 ? "Private" : "Public";

			const data = {
			"Data" : writeItems,
			"KeysToRemove" : removeItems,
			"Permission" : permission	
			};
			
			const tag = _tag;

			const customData = {
				"Tag" : tag
			};			

			this.C3Stacks.UpdateUserData_Write = {};
			this.C3Stacks.UpdateUserData_Remove = [];
			
			this._postToDOM("update-user-data", [data, customData]);
		}

		//** Other Data **/
		_GetOtherData (_PlayFabID, _tag)
		{
			const keys = this.C3Stacks.GetOtherUserData;
			const id = _PlayFabID;

			const data = {
				"Keys" : keys,
				"PlayFabId" : id
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};						

			//..Clear Stack
			this.C3Stacks.GetOtherUserData = [];
			this._postToDOM("get-other-user-data", [data, customData]);
		}

		_GetOtherReadOnlyData (_PlayFabID, _tag) {

			const keys = this.C3Stacks.GetOtherUserReadOnlyData;
			const id = _PlayFabID;

			const data = {
				"Keys" : keys,
				"PlayFabId" : id
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};			

			//..Clear Stack
			this.C3Stacks.GetOtherUserReadOnlyData = [];
			this._postToDOM("get-other-user-read-only-data", [data, customData]);	
		}

		_GetAllOtherData (_PlayFabID, _tag)
		{
			const id = _PlayFabID;
			const data = {

				"PlayFabId" : id
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};			

			this._postToDOM("get-other-user-data", [data, customData]);
		}

		_GetAllOtherReadOnlyData (_PlayFabID, _tag) {

			const id = _PlayFabID;

			const data = {

				"PlayFabId" : id
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};			

			this._postToDOM("get-other-user-read-only-data", [data, customData]);	
		}

		///////////////////////////////////////
		// Utility Methods
		IsContaining (_obj) {

			if (typeof _obj === "undefined")
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		///////////////////////////////////////
		// PlayFab Common Methods
		debugMode() {
			const src = globalThis[PLAYFAB_REF];
			return src["debugMode"];
		}
		debug(_message){
			console.log(_message);
		}
		debugCommonLog(){
			globalThis[PLAYFAB_REF]["debugCommonLog"]();
		}
		GenerateErrorReport(error)
		{
			return globalThis[PLAYFAB_REF]["GenerateErrorReport"](error);
		}
		///////////////////////////////////////
	};
}
