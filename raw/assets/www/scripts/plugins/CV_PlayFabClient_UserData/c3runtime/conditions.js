"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_UserData.Cnds =
	{
		//* User */
		GetUserData () { return true; },
		GetUserData_Error () { return true; },

		GetUserReadOnlyData () { return true; },
		GetUserReadOnlyData_Error () { return true; },

		//* Other User */
		GetOtherUserData () { return true; },
		GetOtherUserData_Error () { return true; },

		GetOtherUserReadOnlyData () { return true; },
		GetOtherUserReadOnlyData_Error () { return true; },

		//* Universal */
		UpdateUserData () { return true; },
		UpdateUserData_Error () { return true; },

		//* User *//
		OnLoadUserData (_key) 
		{ 
			if (this.C3Current.LoadDataKeyName === _key)
			return true; 
		},
		OnLoadUserDataFailed (_key) 
		{ 
			if (this.C3Current.LoadDataKeyName === _key)
			return true; 
		},
		
		OnAnyLoadUserData () { return true; },
		OnAnyLoadUserDataFailed () { return true; },

		OnLoadUserReadOnlyData (_key) 
		{ 
			if (this.C3Current.LoadReadDataKeyName === _key)
			return true; 
		},
		OnLoadUserReadOnlyDataFailed (_key) 
		{ 
			if (this.C3Current.LoadReadDataKeyName === _key)
			return true; 
		},

		OnAnyLoadUserReadOnlyData () { return true; },
		OnAnyLoadUserReadOnlyDataFailed () { return true; },

		//* Other User *//
		OnLoadOtherUserData (_key) 
		{ 
			if (this.C3Current.Other_LoadDataKeyName === _key)
			return true; 
		},
		OnLoadOtherUserDataFailed (_key) 
		{ 
			if (this.C3Current.Other_LoadDataKeyName === _key)
			return true; 
		},
		
		OnAnyLoadOtherUserData () { return true; },
		OnAnyLoadOtherUserDataFailed () { return true; },

		OnLoadOtherUserReadOnlyData (_key) 
		{ 
			if (this.C3Current.Other_LoadReadDataKeyName === _key)
			return true; 
		},
		OnLoadOtherUserReadOnlyDataFailed (_key) 
		{ 
			if (this.C3Current.Other_LoadReadDataKeyName === _key)
			return true; 
		},

		OnAnyLoadOtherUserReadOnlyData () { return true; },
		OnAnyLoadOtherUserReadOnlyDataFailed () { return true; },
		}
}
