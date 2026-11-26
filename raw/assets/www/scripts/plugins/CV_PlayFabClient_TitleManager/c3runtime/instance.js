"use strict";

{
	const C3 = globalThis.C3;

	const DOM_COMPONENT_ID = "cv-playfab-titlemanager";

	const PLAYFAB_REF = "CV_PlayFab_MasterCollection";

	C3.Plugins.CV_PlayFabClient_TitleManager.Instance = class CV_PlayFabClient_TitleManagerInstance extends globalThis.ISDKInstanceBase
	{
		constructor()
		{
			super({ domComponentId: DOM_COMPONENT_ID })
			const properties = this._getInitProperties();
			
			//////////////////////////////////////
			//// Set Prototype Variables

			const self = this;
			const Conditions = C3.Plugins.CV_PlayFabClient_TitleManager.Cnds;

			//** Construct 3 Stacks **//
			this.C3Stacks = {

				GetTitleData : []
			};

			//** Construct 3 Current **//
			this.C3Current = {
			
				currentLoadTitleData : "",

				loopCatalogItems : 0,
				loopStoreItems : 0,
				loopTitleNews : 0
			};
			
			//** Construct 3 Memory **//
			this.C3Memory = {
				recentGetCatalogItems : [],
				recentGetStoreItems : {},
				recentGetTime : "",
				recentGetTitleData : {},
				recentGetTitleNews : [],
				recentServerResponse : "",
				recentTag : ""
			};

			//** Construct 3 Trigger **//
			this.C3Trigger = {

				getCatalogItems : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Catalog Items :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);		
						
						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];				

						// Push to framework memory.
						self.C3Memory.recentGetCatalogItems = _callback["data"]["Catalog"];
						
						// Call Function
						const trigger = Conditions.OnGetCatalogItems;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Catalog Items");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Catalog Items :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);		
						
						// Record Tag		
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];											

						// Clear framework memory.
						self.C3Memory.recentGetCatalogItems = [];

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.OnGetCatalogItems_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Catalog Items Error");
						}										
					}	
				
				},
				getStoreItems : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Store Items :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);			
						
						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];									

						// Push to framework memory.
						self.C3Memory.recentGetStoreItems = _callback["data"];
						
						// Call Function
						const trigger = Conditions.OnGetStoreItems;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Store Items");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Store Items :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);		
						
						// Record Tag
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];											

						// Clear framework memory.
						self.C3Memory.recentGetStoreItems = [];

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.OnGetStoreItems_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Store Items Error");
						}										
					}	
				
				},
				getTime : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Time :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);					

						// Push to framework memory.
						self.C3Memory.recentGetTime = _callback["data"]["Time"];
						
						// Call Function
						const trigger = Conditions.OnGetTime;
						self.Call(trigger);			
						
						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Time");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Time :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);					

						// Clear from framework memory.
						self.C3Memory.recentGetTime = "";

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.OnGetTime_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Time Error");
						}										
					}	
				
				},
				getTitleData : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Title Data :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);			
						
						// Record Tag
						self.C3Memory.recentTag = _callback["CustomData"]["Tag"];								

						// Push to framework memory.
						self.C3Memory.recentGetTitleData = _callback["data"]["Data"];
						
						// Call Function
						const trigger = Conditions.OnGetTitleData;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Title Data");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Title Data :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);

						// Record Tag
						self.C3Memory.recentTag = _error["CustomData"]["Tag"];											

						// Clear framework memory.
						self.C3Memory.recentGetTitleData = {};

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.OnGetTitleData_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Title Data Error");
						}										
					}	
				
				},	
				getTitleNews : function (_callback, _error) {
			
					if (_callback != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debug("Get Title News :: Positive Response Received : ");
							self.debug(_callback);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_callback);					

						// Push to framework memory.
						self.C3Memory.recentGetTitleNews = _callback["data"]["News"];
						
						// Call Function
						const trigger = Conditions.OnGetTitleNews;
						self.Call(trigger);				

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Title News");
						}					
					}
					else if (_error != null)
					{
						// Show Debug Data
						if (self.debugMode())
						{
							self.debugCommonLog();
							self.debug("Get Title News :: Negative Response Received : ");
							self.debug(_error);
						}

						// Set Server Response into C3Memory
						self.C3Memory.recentServerResponse = JSON.stringify(_error);					

						// Clear from framework memory.
						self.C3Memory.recentGetTitleNews = [];

						const errorReport = self.GenerateErrorReport(_error);
						if (self.debugMode())
						{
							self.debug("PlayFab Generated Report : ");
							self.debug(errorReport);
						}
			
						const trigger = Conditions.OnGetTitleNews_Error;
						self.Call(trigger);

						// Show Trigger Name
						if (self.debugMode())
						{
							self.debug("Triggered : On Get Title News Error");
						}										
					}	
				
				}							
			};

			//** Construct 3 Get **//
			this.C3Get = {

				CatalogItems_Direct : function (_target, _index, _fallback) {
		
					const x = _target;
					const i = _index;
					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i][x]) ) { return f; }

					const src = self.C3Memory.recentGetCatalogItems[i];
					return src[x];	
				},
				CatalogItems_Boolean : function (_target, _index) {
		
					const x = _target;
					const i = _index;
					const f = "False";

					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i][x]) ) { return f; }

					const src = self.C3Memory.recentGetCatalogItems[i];
					return src[x] == true ? "True" : "False";	
				},
				CatalogItems_SubGroup : function (_target, _index, _subGroup, _fallback) {
		
					const x = _target;
					const i = _index;
					const f = _fallback;
					const g = _subGroup;

					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i][x]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems[i][x][g]) ) { return f; }

					const src = self.C3Memory.recentGetCatalogItems[i];
					return src[x][g];	
				},
				CatalogItems_Count : function (_fallback) {

					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetCatalogItems) ) { return f; }

					return self.C3Memory.recentGetCatalogItems.length;
				},

				StoreItems_Direct : function (_target, _fallback) {

					const x = _target;
					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x]) ) { return f; }

					const src = self.C3Memory.recentGetStoreItems;
					return src[x];		
				},
				StoreItems_SubGroup : function (_target, _subGroup, _fallback) {

					const x = _target;
					const f = _fallback;
					const o = _subGroup;

					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][o]) ) { return f; }

					const src = self.C3Memory.recentGetStoreItems;
					return src[x][o];		
				},
				StoreItems_SubObject : function (_target, _index, _obj, _fallback) {
		
					const x = _target;
					const f = _fallback;
					const g = _index;
					const o = _obj;

					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][g]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][g][o]) ) { return f; } 

					const src = self.C3Memory.recentGetStoreItems;
					return src[x][g][o];	
				},
				StoreItems_SubList : function (_target, _index, _obj, _fallback) {
		
					const x = _target;
					const f = _fallback;
					const i = _index;
					const o = _obj;

					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][i]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][i][o]) ) { return f; } 

					const src = self.C3Memory.recentGetStoreItems;
					return src[x][i][o];	
				},
				StoreItems_SubListObj : function (_target, _index, _obj, _key, _fallback) {
		
					const x = _target;
					const f = _fallback;
					const i = _index;
					const o = _obj;
					const k = _key;

					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][i]) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][i][o]) ) { return f; } 
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems[x][i][o][k]) ) { return f; } 

					const src = self.C3Memory.recentGetStoreItems;
					return src[x][i][o][k];	
				},
				StoreItems_Count : function (_fallback) {

					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetStoreItems["Store"]) ) { return f; }

					return self.C3Memory.recentGetStoreItems["Store"].length;
				},

				Time : function (_fallback) {

					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetTime) ) { return f; }

					const src = self.C3Memory.recentGetTime;
					return src;					
				},

				TitleNews : function (_target, _index, _fallback) {

					const x = _target;
					const i = _index;
					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetTitleNews) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetTitleNews[i] ) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetTitleNews[i][x] ) ) { return f; }

					return self.C3Memory.recentGetTitleNews[i][x];
				},
				TitleNews_Count : function (_fallback) {

					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetTitleNews) ) { return f; }

					return self.C3Memory.recentGetTitleNews.length;
				},
				
				TitleData : function (_key, _fallback) {

					const k = _key;
					const f = _fallback;

					if ( !self.IsContaining(self.C3Memory.recentGetTitleData) ) { return f; }
					if ( !self.IsContaining(self.C3Memory.recentGetTitleData[k]) ) { return f; }

					const src = self.C3Memory.recentGetTitleData;
					return src[k];				
				}
			};

			//** System Methods **//
			this.Call = function (_path) {
				const trigger = _path;
	
				self._trigger(trigger);
			};

			//** Construct 3 DOM Handlers **//
			this._addDOMMessageHandlers([
				["get-catalog-items", e => this.C3Trigger.getCatalogItems(...e)],
				["get-store-items", e => this.C3Trigger.getStoreItems(...e)],
				["get-time", e => this.C3Trigger.getTime(...e)],
				["get-title-data", e => this.C3Trigger.getTitleData(...e)],
				["get-title-news", e => this.C3Trigger.getTitleNews(...e)]
            ]); 
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
		// Action Methods
		GetCatalogItems (_catalogVersion, _tag)
		{
			const version = _catalogVersion;

			const data = {};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};					

			if (typeof version !== "undefined")
			{
				data["CatalogVersion"] = version;
			}

			this._postToDOM("get-catalog-items", [data, customData]);
		}

		GetStoreItems (_catalogVersion, _storeID, _tag)
		{
			const version = _catalogVersion;
			const id	  = _storeID;

			const data = {
				"StoreId" : id
			};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};					

			if (typeof version !== "undefined")
			{
				data["CatalogVersion"] = version;
			}

			this._postToDOM("get-store-items", [data, customData]);
		}
		
		GetTime ()
		{
			const data = {};
			this._postToDOM("get-time", [data]);
		}

		GetTitleData (_all, _tag)
		{
			let keys = [];
			let data = {};

			const tag = _tag;

			const customData = {
				"Tag" : tag
			};					

			if (!_all)
			{
				keys = this.C3Stacks.GetTitleData;
				data["Keys"] = keys;
				this.C3Stacks.GetTitleData = [];
			}

			this._postToDOM("get-title-data", [data, customData]);
		}

		GetTitleNews (_count)
		{
			const count = _count;
			const data = {

				"Count" : count
			};

			this._postToDOM("get-title-news", [data]);
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
