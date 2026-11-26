"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_TitleManager.Exps =
	{
		/* Catalog Items */
		catalogItemID (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "ItemId";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogItemClass (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "ItemClass";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogVersion (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "CatalogVersion";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogDisplayName (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "DisplayName";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogDescription (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "Description";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogItemImage (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "ItemImageUrl";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogCustomData (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "CustomData";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		catalogVirtualPrice (_index, _key) 
		{ 
			const fallback = 0;
			const index = _index;
			const target = "VirtualCurrencyPrices";
			const subGroup = _key;
			const data = ( this.C3Get.CatalogItems_SubGroup (target, index, subGroup, fallback) ); 
			return data;
		},
		catalogRealPrice (_index, _key) 
		{ 
			const fallback = 0;
			const index = _index;
			const target = "RealCurrencyPrices";
			const subGroup = _key;
			const data = ( this.C3Get.CatalogItems_SubGroup (target, index, subGroup, fallback) ); 
			return (data/100);
		},
		isStackable (_index) 
		{ 
			const index = _index;
			const target = "IsStackable";
			return ( this.C3Get.CatalogItems_Boolean (target, index) ); 
		},
		isLimitedEdition (_index) 
		{ 
			const index = _index;
			const target = "IsLimitedEdition";
			return ( this.C3Get.CatalogItems_Boolean (target, index) ); 
		},
		limitedEditionCount (_index) 
		{ 
			const fallback = 0;
			const index = _index;
			const target = "InitialLimitedEditionCount";
			return ( this.C3Get.CatalogItems_Direct (target, index, fallback) ); 
		},
		consumeUsageCount (_index) 
		{ 
			const fallback = 0;
			const index = _index;
			const target = "Consumable";
			const subGroup = "UsageCount";
			return ( this.C3Get.CatalogItems_SubGroup (target, index, subGroup, fallback) ); 
		},
		consumeUsagePeriod (_index) 
		{ 
			const fallback = 0;
			const index = _index;
			const target = "Consumable";
			const subGroup = "UsagePeriod";
			return ( this.C3Get.CatalogItems_SubGroup (target, index, subGroup, fallback) ); 
		},
		consumeUsagePeriodGroup (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "Consumable";
			const subGroup = "UsagePeriodGroup";
			return ( this.C3Get.CatalogItems_SubGroup (target, index, subGroup, fallback) ); 
		},

		loopCatalogItems () 
		{ 
			const index = this.C3Current.loopCatalogItems;
			return ( index ); 
		},
		countCatalogItems () 
		{ 
			const fallback = 0;
			const count = this.C3Get.CatalogItems_Count(fallback);
			return ( count ); 
		},

		/* Store Items */
		storeID () 
		{ 
			const fallback = "";
			const target = "StoreId";
			return ( this.C3Get.StoreItems_Direct (target, fallback) ); 
		},
		storeCatalogVersion () 
		{ 
			const fallback = "";
			const target = "CatalogVersion";
			return ( this.C3Get.StoreItems_Direct (target, fallback) ); 
		},
		marketDescription () 
		{ 
			const fallback = "";
			const target = "MarketingData";
			const subGroup = "Description";
			return ( this.C3Get.StoreItems_SubGroup (target, subGroup, fallback) ); 
		},
		marketDisplayName () 
		{ 
			const fallback = "";
			const target = "MarketingData";
			const subGroup = "DisplayName";
			return ( this.C3Get.StoreItems_SubGroup (target, subGroup, fallback) ); 
		},
		marketMetadata (_obj) 
		{ 
			const fallback = "";
			const target = "MarketingData";
			const subGroup = "Metadata";
			const obj = _obj;
			return ( this.C3Get.StoreItems_SubObject (target, subGroup, obj, fallback) ); 
		},
		sourceType () 
		{ 
			const fallback = "";
			const target = "Source";
			return ( this.C3Get.StoreItems_Direct (target, fallback) ); 
		},
		storeDisplayPosition (_index) 
		{ 
			const fallback = 0;
			const target = "Store";
			const index = _index;
			const obj = "DisplayPosition";
			return ( this.C3Get.StoreItems_SubList (target, index, obj, fallback) ); 
		},
		storeItemID (_index) 
		{ 
			const fallback = "";
			const target = "Store";
			const index = _index;
			const obj = "ItemId";
			return ( this.C3Get.StoreItems_SubList (target, index, obj, fallback) ); 
		},
		storeRealPrice (_index, _key) 
		{ 
			const fallback = 0;
			const target = "Store";
			const index = _index;
			const obj = "RealCurrencyPrices";
			const key = _key;
			const data = ( this.C3Get.StoreItems_SubListObj (target, index, obj, key, fallback) ); 
			return (data/100);
		},
		storeVirtualPrice (_index, _key) 
		{ 
			const fallback = 0;
			const target = "Store";
			const index = _index;
			const obj = "VirtualCurrencyPrices";
			const key = _key;
			const data = ( this.C3Get.StoreItems_SubListObj (target, index, obj, key, fallback) ); 
			return data;
		},
		storeCustomData (_index, _key) 
		{ 
			const fallback = "";
			const target = "Store";
			const index = _index;
			const obj = "CustomData";
			const key = _key;
			return ( this.C3Get.StoreItems_SubListObj (target, index, obj, key, fallback) ); 
		},

		loopStoreItems () 
		{ 
			const index = this.C3Current.loopStoreItems;
			return ( index ); 
		},
		countStoreItems () 
		{ 
			const fallback = 0;
			const count = this.C3Get.StoreItems_Count(fallback);
			return ( count ); 
		},

		/* Time */
		getTime () 
		{ 
			const fallback = "";
			return ( this.C3Get.Time (fallback) ); 
		},

		/* Title News */
		getNewsTimeStamp (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "Timestamp";
			return ( this.C3Get.TitleNews (target, index, fallback) ); 
		},
		getNewsTitle (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "Title";
			return ( this.C3Get.TitleNews (target, index, fallback) ); 
		},
		getNewsBody (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "Body";
			return ( this.C3Get.TitleNews (target, index, fallback) ); 
		},
		getNewsID (_index) 
		{ 
			const fallback = "";
			const index = _index;
			const target = "NewsId";
			return ( this.C3Get.TitleNews (target, index, fallback) ); 
		},	
		getNewsCount () 
		{ 
			const fallback = 0;
			return ( this.C3Get.TitleNewsCount (fallback) ); 
		},

		loopTitleNews () 
		{ 
			const index = this.C3Current.loopTitleNews;
			return ( index ); 
		},
		countTitleNews () 
		{ 
			const fallback = 0;
			const count = this.C3Get.TitleNews_Count(fallback);
			return ( count ); 
		},
		
		/* Title Data */
		retTitleDataValue () 
		{ 
			const fallback = "";
			const key = this.C3Current.currentLoadTitleData;

			return ( this.C3Get.TitleData (key, fallback) ); 
		},	
		retTitleDataKey () 
		{ 
			const key = this.C3Current.currentLoadTitleData;
			return ( key ); 
		},

		/* Load */
		Load (_key) 
		{ 
			const fallback = "";
			const key = _key;

			return ( this.C3Get.TitleData (key, fallback) ); 
		},			

		ServerResponse () { return ( this.C3Memory.recentServerResponse ); },

		Tag () { return ( this.C3Memory.recentTag ); }
	};
}
