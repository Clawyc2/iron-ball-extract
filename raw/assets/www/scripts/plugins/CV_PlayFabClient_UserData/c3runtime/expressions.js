"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_UserData.Exps =
	{
		//** User Data **//
		getDataVersion ()
		{
			const key = undefined;
			const target = 3;

			return ( this.C3Get.GetUserData(key, target) ); 
		},
		getReadDataVersion ()
		{
			const key = undefined;
			const target = 3;

			return ( this.C3Get.GetUserReadOnlyData(key, target) ); 
		},
		getUpdateDataVersion ()
		{
			return ( this.C3Get.GetUpdateUserData() ); 
		},

		retDataLastUpdated () { const key = this.C3Current.LoadDataKeyName; return ( this.C3Get.GetUserData (key, 1) ); },
		retDataPermission () { const key = this.C3Current.LoadDataKeyName; return ( this.C3Get.GetUserData (key, 2) ); },
		retDataValue () { const key = this.C3Current.LoadDataKeyName; return ( this.C3Get.GetUserData (key, 0) ); },

		retDataKey () { return ( this.C3Current.LoadDataKeyName ); },

		retReadDataLastUpdated () { const key = this.C3Current.LoadReadDataKeyName; return ( this.C3Get.GetUserReadOnlyData (key, 1) ); },
		retReadDataPermission () { const key = this.C3Current.LoadReadDataKeyName; return ( this.C3Get.GetUserReadOnlyData (key, 2) ); },
		retReadDataValue () { const key = this.C3Current.LoadReadDataKeyName; return ( this.C3Get.GetUserReadOnlyData (key, 0) ); },

		retReadDataKey () { return ( this.C3Current.LoadReadDataKeyName ); },

		//** Other User Data **//
		getODataVersion ()
		{
			const key = undefined;
			const target = 3;

			return ( this.C3Get.GetOtherUserData(key, target) ); 
		},
		getOReadDataVersion ()
		{
			const key = undefined;
			const target = 3;

			return ( this.C3Get.GetOtherUserReadOnlyData(key, target) ); 
		},

		retODataLastUpdated () { const key = this.C3Current.Other_LoadDataKeyName; return ( this.C3Get.GetOtherUserData (key, 1) ); },
		retODataPermission () { const key = this.C3Current.Other_LoadDataKeyName; return ( this.C3Get.GetOtherUserData (key, 2) ); },
		retODataValue () { const key = this.C3Current.Other_LoadDataKeyName; return ( this.C3Get.GetOtherUserData (key, 0) ); },

		retODataKey () { return ( this.C3Current.Other_LoadDataKeyName ); },
		
		retOReadDataLastUpdated () { const key = this.C3Current.Other_LoadReadDataKeyName; return ( this.C3Get.GetOtherUserReadOnlyData (key, 1) ); },
		retOReadDataPermission () { const key = this.C3Current.Other_LoadReadDataKeyName; return ( this.C3Get.GetOtherUserReadOnlyData (key, 2) ); },
		retOReadDataValue () { const key = this.C3Current.Other_LoadReadDataKeyName; return ( this.C3Get.GetOtherUserReadOnlyData (key, 0) ); },

		retOReadDataKey () { return ( this.C3Current.Other_LoadReadDataKeyName ); },

		ServerResponse () { return ( this.C3Memory.recentServerResponse ); },

		Tag () { return ( this.C3Memory.recentTag ); },

		/* Load */
	
		UserLoad (_key) 
		{ 
			const key = _key;
			return ( this.C3Get.GetUserData (key, 0) ); 
		},		
	
		UserReadLoad (_key) 
		{ 
			const key = _key;
			return ( this.C3Get.GetUserReadOnlyData (key, 0) ); 
		},		
	
		OtherLoad (_key) 
		{ 
			const key = _key;
			return ( this.C3Get.GetOtherUserData (key, 0) ); 
		},
	
		OtherReadLoad (_key) 
		{ 
			const key = _key;
			return ( this.C3Get.GetOtherUserReadOnlyData (key, 0) ); 
		}	
	};
}
