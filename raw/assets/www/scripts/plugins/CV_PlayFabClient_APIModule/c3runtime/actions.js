"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_APIModule.Acts =
	{
		SetTitleID (_titleID)
		{
			this._SetTitleID(_titleID);
		},
		Logout ()
		{
			this._ForgetAllCredentials();
		},
		CallAPIMethod (_method, data, customData)
		{
			this._CallAPIMethod(_method, data, customData);
		}
	};
}
