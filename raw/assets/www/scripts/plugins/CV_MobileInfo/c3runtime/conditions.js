"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_MobileInfo.Cnds =
	{
		isVirtual ()
		{
			return this._deviceInformation["isVirtual"];
		},
	
		isPlatform (index)
		{
			return this._IsPlatform(index);
		}
	};
}
