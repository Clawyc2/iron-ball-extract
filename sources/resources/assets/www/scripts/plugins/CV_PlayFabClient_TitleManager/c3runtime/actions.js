"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_TitleManager.Acts =
	{
		GetCatalogItems (_tag)
		{
			const ver = undefined;
			this.GetCatalogItems(ver, _tag);
		},
	
		GetCatalogItemsWithVersion (_version, _tag)
		{
			const ver = _version;
			this.GetCatalogItems(ver, _tag);
		},
	
		GetStoreItems (_storeID, _tag)
		{
			const ver = undefined;
			const id  = _storeID
			this.GetStoreItems(ver, id, _tag);
		},
	
		GetStoreItemsWithVersion (_storeID, _catalogVersion, _tag)
		{
			const ver = _catalogVersion;
			const id  = _storeID
			this.GetStoreItems(ver, id, _tag);
		},
	
		GetTime ()
		{
			this.GetTime();
		},
	
		GetAllTitleData (_tag)
		{
			const all = true;
			this.GetTitleData(all, _tag);
		},
	
		PlanGetTitleData (_key)
		{
			this.C3Stacks.GetTitleData.push(_key);
		},
	
		GetTitleData (_tag)
		{
			const all = false;
			this.GetTitleData(all, _tag);
		},
		
		GetTitleNews (_count)
		{
			this.GetTitleNews(_count);
		},
	
		LoadTitleData (_key)
		{
	
			const key = _key;
			const self = this;
	
			//..Current Variable
			this.C3Current.currentLoadTitleData = key;
	
			function fail()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_TitleManager.Cnds.OnLoadTitleDataFailed);	
				self._trigger(C3.Plugins.CV_PlayFabClient_TitleManager.Cnds.OnAnyLoadTitleDataFailed);	
			}
			function success()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_TitleManager.Cnds.OnLoadTitleData);	
				self._trigger(C3.Plugins.CV_PlayFabClient_TitleManager.Cnds.OnAnyLoadTitleData);	
			}
			
			if ( !self.IsContaining(self.C3Memory.recentGetTitleData) ) { fail(); return; }
			if ( !self.IsContaining(self.C3Memory.recentGetTitleData[key]) ) { fail(); return; }
	
			success();
		}
	};
}
