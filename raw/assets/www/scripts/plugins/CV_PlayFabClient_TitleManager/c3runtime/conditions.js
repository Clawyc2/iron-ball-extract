"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_TitleManager.Cnds =
	{
		OnGetCatalogItems () { return true; },
		OnGetCatalogItems_Error () { return true; },
		OnGetStoreItems () { return true; },
		OnGetStoreItems_Error () { return true; },
		OnGetTime () { return true; },
		OnGetTime_Error () { return true; },
		OnGetTitleData () { return true; },
		OnGetTitleData_Error () { return true; },
		OnGetTitleNews () { return true; },
		OnGetTitleNews_Error () { return true; },
	
		OnLoadTitleData (_key) 
		{ 
			if (_key === this.C3Current.currentLoadTitleData)
			return true; 
		},
		OnLoadTitleDataFailed (_key) 
		{ 
			if (_key === this.C3Current.currentLoadTitleData)
			return true; 
		},
		OnAnyLoadTitleData () { return true; },
		OnAnyLoadTitleDataFailed () { return true; },
	
		//* Loops *//
	
		ForEachCatalogItem () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();

			const fallback = 0;
			const count = this.C3Get.CatalogItems_Count(fallback);
	
			for (let i = 0 ; i < count; i++)
			{
				// Implementation here...
				this.C3Current.loopCatalogItems = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.C3Current.loopCatalogItems = 0;
					break;
				}
			}
	
			loopCtx.release();
		},
		ForEachStoreItem () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			const fallback = 0;
			const count = this.C3Get.StoreItems_Count(fallback);
	
			for (let i = 0 ; i < count; i++)
			{
				// Implementation here...
				this.C3Current.loopStoreItems = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.C3Current.loopStoreItems = 0;
					break;
				}
			}
	
			loopCtx.release();
		},
		ForEachTitleNews () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			const fallback = 0;
			const count = this.C3Get.TitleNews_Count(fallback);
	
			for (let i = 0 ; i < count; i++)
			{
				// Implementation here...
				this.C3Current.loopTitleNews = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.C3Current.loopTitleNews = 0;
					break;
				}
			}
	
			loopCtx.release();
		}
	};
}
