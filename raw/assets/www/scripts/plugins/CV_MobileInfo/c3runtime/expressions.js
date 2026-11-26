"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_MobileInfo.Exps =
	{
		Cordova 		() { return ( this._deviceInformation["cordova"] ); 		},
		Model 	 		() { return ( this._deviceInformation["model"] ); 			},
		Platform  		() { return ( this._deviceInformation["platform"] ); 		},
		UUID 	 		() { return ( this._deviceInformation["uuid"] ); 			},
		OSVersion 		() { return ( this._deviceInformation["version"] ); 		},
		Manufacturer 	() { return ( this._deviceInformation["manufacturer"] ); 	},
		Serial 			() { return ( this._deviceInformation["serial"] ); 			}
	};
}
