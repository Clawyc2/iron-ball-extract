"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_APIModule.Exps =
	{
		GetTitleID ()
		{
			return (this.titleID);
		},
		Response ()
		{
			return (this.C3Memory.Response);
		}
	};
}
