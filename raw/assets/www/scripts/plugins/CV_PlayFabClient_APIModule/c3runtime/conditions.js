"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_APIModule.Cnds =
	{
		IsInitialized ()
		{
			return this.initialized;
		},
		IsLoggedIn ()
		{
			return this.__IsClientLoggedIn();
		},
		OnCallAPIResponse ()
		{
			return true;
		},
		OnCallAPIError ()
		{
			return true;
		}
	};
}
