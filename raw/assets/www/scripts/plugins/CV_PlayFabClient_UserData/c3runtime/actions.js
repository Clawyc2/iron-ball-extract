"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_UserData.Acts =
	{
		//* Get User Data *//
		PlanGetUserData (_key)
		{
			const key = _key;
			this.C3Stacks.GetUserData.push(key);
		},

		GetUserData (_tag)
		{
			this._GetUserData(_tag);
		},

		GetAllUserData (_tag)
		{
			this._GetAllUserData(_tag);
		},

		//* Get Other User Data *//
		PlanGetOtherUserData (_key)
		{
			const key = _key;
		
			this.C3Stacks.GetOtherUserData.push(key);
		},

		GetOtherUserData (_id, _tag)
		{
			const id = _id;
			this._GetOtherData(id, _tag);
		},

		GetAllOtherUserData (_id, _tag)
		{
			const id = _id;
			this._GetAllOtherData(id, _tag);
		},

		//* Get User ReadOnly Data *//
		PlanGetUserReadOnlyData (_key)
		{
			const key = _key;
			this.C3Stacks.GetUserReadOnlyData.push(key);
		},

		GetUserReadOnlyData (_tag)
		{
			this._GetUserReadOnlyData(_tag);
		},

		GetAllUserReadOnlyData (_tag)
		{
			this._GetAllUserReadOnlyData(_tag);
		},

		//* Get Other User ReadOnly Data *//
		PlanGetOtherUserReadOnlyData (_key)
		{
			const key = _key;
			this.C3Stacks.GetOtherUserReadOnlyData.push(key);
		},

		GetOtherUserReadOnlyData (_id, _tag)
		{
			const id = _id;
			this._GetOtherReadOnlyData(id, _tag);
		},

		GetAllOtherUserReadOnlyData (_id, _tag)
		{
			const id = _id;
			this._GetAllOtherReadOnlyData(id, _tag);
		},

		//* Update User Data *//
		PlanWriteUserData (_key, _value)
		{
			const key = _key;
			const value = _value;

			this.C3Stacks.UpdateUserData_Write[key] = value;
		},

		PlanRemoveUserData (_key)
		{
			const key = _key;

			this.C3Stacks.UpdateUserData_Remove.push(key);
		},	

		UpdateUserData (_permission, _tag)
		{
			const permission = _permission;

			this._UpdateUserData(permission, _tag);
		},

		//* Load User Data *//
		LoadUserData (_key) {

			const key = _key;

			//..Current Variable
			this.C3Current.LoadDataKeyName = key;

			const self = this;

			function fail()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadUserDataFailed);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadUserDataFailed);
			}
			function success()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadUserData);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadUserData);
			}
			
			if ( !this.IsContaining(this.C3Memory.recentGetUserData) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetUserData["Data"]) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetUserData["Data"][key]) ) { fail(); return; }

			success();
		},

		LoadUserReadOnlyData (_key) {

			const key = _key;

			//..Current Variable
			this.C3Current.LoadReadDataKeyName = key;

			const self = this;

			function fail()
			{	
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadUserReadOnlyDataFailed);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadUserReadOnlyDataFailed);	
			}
			function success()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadUserReadOnlyData);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadUserReadOnlyData);	
			}

			if ( !this.IsContaining(this.C3Memory.recentGetUserReadOnlyData) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetUserReadOnlyData["Data"]) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetUserReadOnlyData["Data"][key]) ) { fail(); return; }

			success();
		},
		//* Load Other User Data *//
		LoadOtherUserData (_key) {

			const key = _key;

			//..Current Variable
			this.C3Current.Other_LoadDataKeyName = key;

			const self = this;

			function fail()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadOtherUserDataFailed);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadOtherUserDataFailed);	
			}
			function success()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadOtherUserData);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadOtherUserData);				
			}

			if ( !this.IsContaining(this.C3Memory.recentGetOtherUserData) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetOtherUserData["Data"]) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetOtherUserData["Data"][key]) ) { fail(); return; }

			success();
		},

		LoadOtherUserReadOnlyData (_key) {

			const key = _key;

			//..Current Variable
			this.C3Current.Other_LoadReadDataKeyName = key;

			const self = this;

			function fail()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadOtherUserReadOnlyDataFailed);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadOtherUserReadOnlyDataFailed);		
			}
			function success()
			{
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnLoadOtherUserReadOnlyData);
				self._trigger(C3.Plugins.CV_PlayFabClient_UserData.Cnds.OnAnyLoadOtherUserReadOnlyData);		
			}

			if ( !this.IsContaining(this.C3Memory.recentGetOtherUserReadOnlyData) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetOtherUserReadOnlyData["Data"]) ) { fail(); return; }
			if ( !this.IsContaining(this.C3Memory.recentGetOtherUserReadOnlyData["Data"][key]) ) { fail(); return; }

			success();
		}
	};
}
