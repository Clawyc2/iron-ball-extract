"use strict";

{
	const C3 = globalThis.C3;

	const DOM_COMPONENT_ID = "cv-playfab-playermanager";

	const PLAYFAB_REF = "CV_PlayFab_MasterCollection";

	C3.Plugins.CV_PlayFabClient_PlayerManager.Instance = class PlayFab_PlayerManager_Instance extends globalThis.ISDKInstanceBase
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
			//** State Variables **//
			this.isGettingPlayerProfile = false;

			//** Custom Variables **//
			this.loopPlayerProfileEmail = 0;
			this.loopPlayerProfileLinkedAccount = 0;
			this.loopPlayerProfileLocation = 0;
			this.loopPlayerProfileStatistic = 0;
			this.loopPlayerProfileTag = 0;
			this.loopPlayerProfileValueToDate = 0;
	
			this.countPlayerProfileEmail = 0;
			this.countPlayerProfileLinkedAccount = 0;
			this.countPlayerProfileLocation = 0;
			this.countPlayerProfileStatistic = 0;
			this.countPlayerProfileTag = 0;
			this.countPlayerProfileValueToDate = 0;
	
			//** System References **//
			const self = this;
			const Conditions = C3.Plugins.CV_PlayFabClient_PlayerManager.Cnds;
	
			//** Construct 3 Memory **//
			this.C3Memory = {

				recentGetPlayerProfile : [],
				recentServerResponse : "",

				recentResponseCustomData : ""
			};
		
			//** Construct 3 Trigger **//
			this.C3Trigger = {

				getPlayerProfile : function (_callback, _error) {
			
					if (_callback != null)
					{		
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Player Profile :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);			
							
						// Set the response's custom data.
						self.C3Memory.recentResponseCustomData = _callback["CustomData"];								

						const src = _callback["data"]["PlayerProfile"];
				
						// Record to C3 Memory
						self.C3Memory.recentGetPlayerProfile = src;
						
						//..Record count to property. 
						self.countPlayerProfileEmail = self.C3ListCounter.PlayerProfile("ContactEmailAddresses");
						self.countPlayerProfileLinkedAccount = self.C3ListCounter.PlayerProfile("LinkedAccounts");
						self.countPlayerProfileLocation = self.C3ListCounter.PlayerProfile("Locations");
						self.countPlayerProfileStatistic = self.C3ListCounter.PlayerProfile("Statistics");
						self.countPlayerProfileTag = self.C3ListCounter.PlayerProfile("Tags");
						self.countPlayerProfileValueToDate = self.C3ListCounter.PlayerProfile("ValuesToDate");
		
						// Call Function
						const trigger = Conditions.GetPlayerProfile;
						self.Call(trigger);			
						
						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Player Profile");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Player Profile :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);		
						
						// Set the response's custom data.
						self.C3Memory.recentResponseCustomData = _error["CustomData"];								

						const errorCode = _error["errorCode"];
				
						if (errorCode === 1033)
						{
							const trigger = Conditions.GetPlayerProfile_PlayerNotInGame;
							self.Call(trigger);	

							// Show Trigger Name
							if (self.debugMode())
							{
								self.debug("Triggered : On Player Not In Game");
							}						
						}
						else if (errorCode === 1298)
						{
							const trigger = Conditions.GetPlayerProfile_ProfileDoesNotExist;
							self.Call(trigger);

							// Show Trigger Name
							if (self.debugMode())
							{
								self.debug("Triggered : On Profile Does Not Exist");
							}												
						}	
						else
						{
							const errorReport = self.GenerateErrorReport(_error);
							if (self.debugMode())
							{
								self.debug("PlayFab Generated Report : ");
								self.debug(errorReport);
							}
			
							const trigger = Conditions.GetPlayerProfile_Error;
							self.Call(trigger);

							// Show Trigger Name
							if (self.debugMode())
							{
								self.debug("Triggered : On General Error");
							}												
						}
					}		
		
					//....isLoading
					self.isGettingPlayerProfile = false;
				}
			};
		
			//** Construct 3 Get **//
			this.C3Get = {
		
				AvatarURL : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "AvatarUrl";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				BannedUntil : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "BannedUntil";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				ContactEmails_EmailAddress : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "ContactEmailAddresses";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "EmailAddress";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				ContactEmails_Name : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "ContactEmailAddresses";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Name";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				ContactEmails_VerificationStatus : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "ContactEmailAddresses";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "VerificationStatus";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Created : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Created";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				DisplayName : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "DisplayName";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				LastLogin : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "LastLogin";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				LinkedAccounts_Email : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "LinkedAccounts";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Email";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				LinkedAccounts_Platform : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "LinkedAccounts";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Platform";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					//..Custom Output
					const retVal = src[itemSource][listIndex][subItemSource];
		
					if (retVal === "PlayFab")
					{
						return "Company";
					}
					else
					{
						return retVal;
					}
				},
				LinkedAccounts_PlatformUserID : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "LinkedAccounts";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "PlatformUserId";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				LinkedAccounts_Username : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "LinkedAccounts";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Username";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Locations_City : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Locations";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "City";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Locations_ContinentCode : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Locations";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "ContinentCode";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Locations_CountryCode : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Locations";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "CountryCode";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Locations_Latitude : function (_index) {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Locations";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Latitude";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Locations_Longitude : function (_index) {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Locations";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Longitude";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Origination : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Origination";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				PlayerID : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "PlayerId";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				PublisherID : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "PublisherId";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				Statistics_Name : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Statistics";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Name";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Statistics_Value : function (_index) {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Statistics";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Value";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Statistics_Version : function (_index) {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Statistics";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Version";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				Tags_TagValue : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Tags";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "TagValue";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				TitleID : function () {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "TitleId";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				TotalValueToDateInUSD : function () {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "TotalValueToDateInUSD";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					return src[itemSource];
				},
				ValuesToDate_Currency : function (_index) {
		
					const fallback = "";
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "ValuesToDate";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "Currency";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				ValuesToDate_TotalValue : function (_index) {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "ValuesToDate";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "TotalValue";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},
				ValuesToDate_TotalValueAsDecimal : function (_index) {
		
					const fallback = 0;
					const src = self.C3Memory.recentGetPlayerProfile;
		
					//..FailSafe : 1
					if (typeof src == "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "ValuesToDate";
					if (typeof src[itemSource] == "undefined") { return fallback; }
		
					//..FailSafe : 3
					const listIndex = _index;
					if (typeof src[itemSource][listIndex] == "undefined") { return fallback; }
		
					//..FailSafe : 4
					const subItemSource = "TotalValueAsDecimal";
					if (typeof src[itemSource][listIndex][subItemSource] == "undefined") { return fallback; }
		
					return src[itemSource][listIndex][subItemSource];
				},

				Tag : function () {
	
					const fallback = "";
					const src = self.C3Memory.recentResponseCustomData;
		
					//..FailSafe : 1
					if (typeof src === "undefined") { return fallback; }
		
					//..FailSafe : 2
					const itemSource = "Tag";
					if (typeof src[itemSource] === "undefined") { return fallback; }
		
					return src[itemSource];
				}				
			};
		
			//** Construct 3 Counter **//
			this.C3ListCounter = {
		
				PlayerProfile : function (_list) {
		
					const src = self.C3Memory.recentGetPlayerProfile[_list];
					if (typeof src == "undefined")
						return 0;
					if ( !Array.isArray( src ) )
						return 0;
			
					return src.length;
				}
			};
	
			//** System Methods **//
			this.Call = function (_path) {
				const trigger = _path;
	
				self._trigger(trigger);
			};

			//** Construct 3 DOM Handlers **//
			this._addDOMMessageHandlers([
				["get-player-profile", e => this.C3Trigger.getPlayerProfile(...e)]
            ]);
		}

		///////////////////////////////////////
		// Action Methods
		_GetPlayerProfile (_playfabID, _tag) {
		
			const playfabID = _playfabID;
		
			const data = {	
				"PlayFabId" : playfabID
			};

			const customData = {

				"Tag" : _tag
			};						
	
			//** Set Configuration **//
			if (!this.getGlobalProfileConstraintsMode())
			{
				data["ProfileConstraints"] = {};

				if ( this.getGlobalConfiguration("Config_AvatarURL") ) 		{ data["ProfileConstraints"]["ShowAvatarUrl"] = true; }
				if ( this.getGlobalConfiguration("Config_Banned") )    		{ data["ProfileConstraints"]["ShowBannedUntil"] = true; }
																		 // { data["ProfileConstraints"]["ShowCampaignAttributions"] = true; }
				if ( this.getGlobalConfiguration("Config_Creation") )  		{ data["ProfileConstraints"]["ShowCreated"] = true; }
				if ( this.getGlobalConfiguration("Config_Name") )      		{ data["ProfileConstraints"]["ShowDisplayName"] = true; }
				if ( this.getGlobalConfiguration("Config_LastLogin") ) 		{ data["ProfileConstraints"]["ShowLastLogin"] = true; }
				if ( this.getGlobalConfiguration("Config_Locations") ) 		{ data["ProfileConstraints"]["ShowLocations"] = true; }
																		 // { data["ProfileConstraints"]["ShowMemberships"] = false;
				if ( this.getGlobalConfiguration("Config_Origin") )    		{ data["ProfileConstraints"]["ShowOrigination"] = true; }
				if ( this.getGlobalConfiguration("Config_Stats") ) 	  		{ data["ProfileConstraints"]["ShowStatistics"] = true; }
				if ( this.getGlobalConfiguration("Config_Tags") )      		{ data["ProfileConstraints"]["ShowTags"] = true; }
				if ( this.getGlobalConfiguration("Config_ValuesUSD") ) 		{ data["ProfileConstraints"]["ShowTotalValueToDateInUsd"] = true; }
				if ( this.getGlobalConfiguration("Config_Values") )    		{ data["ProfileConstraints"]["ShowValuesToDate"] = true; }
		
				if ( this.getGlobalConfiguration("Config_Accounts") )  		{ data["ProfileConstraints"]["ShowLinkedAccounts"] = true; }
																		 // { data["ProfileConstraints"]["ShowPushNotificationRegistrations"] = true; }
				if ( this.getGlobalConfiguration("Config_Email") )     		{ data["ProfileConstraints"]["ShowContactEmailAddresses"] = true; }
			}
	
			this._postToDOM("get-player-profile", [data, customData]);
		}

		///////////////////////////////////////
		// Utility Methods
		platformToOption (_platform)
		{
			switch (_platform)
			{
				case "PlayFab" : 
					return 0;
				case "Custom" :
					return 1;
				case "GameCenter" :
					return 2;
				case "GooglePlay" :
					return 3;
				case "Steam" :
					return 4;
				case "XBoxLive" :
					return 5;
				case "Facebook" :
					return 6;
				case "IOSDevice" :
					return 7;
				case "AndroidDevice" :
					return 8;
				case "WindowsHello" :
					return 9;
				case "FacebookInstantGames" :
					return 10;
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
		getGlobalProfileConstraintsMode() {

			const src = globalThis[PLAYFAB_REF];
			return src["ProfileConstraints_Auto"];
		}
		getGlobalConfiguration(_target) {
		
			const src = globalThis[PLAYFAB_REF]["ProfileDataList"];
			return src[_target];
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
