"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_PlayerManager.Acts =
	{
		GetPlayerProfile (_playfabID, _tag)
		{
			//....isLoading
			this.sGettingPlayerProfile = true;
			//....Link Call
			this._GetPlayerProfile (_playfabID, _tag);
		}
	};
}
