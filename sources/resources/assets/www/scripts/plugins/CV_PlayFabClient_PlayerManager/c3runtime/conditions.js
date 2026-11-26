"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_PlayerManager.Cnds =
	{
		GetPlayerProfile () { return true; },
		GetPlayerProfile_PlayerNotInGame () { return true; },
		GetPlayerProfile_ProfileDoesNotExist () { return true; },
		GetPlayerProfile_Error () { return true; },
	
		IsGettingPlayerProfile () { return this.isGettingPlayerProfile; },
	
		ForEachEmailAddresses () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			for (let i = 0 ; i < this.countPlayerProfileEmail; i++)
			{
				// Implementation here...
				this.loopPlayerProfileEmail = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.loopPlayerProfileEmail = 0;
					break;
				}
			}
	
			loopCtx.release();
		},
	
		ForEachLinkedAccounts () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			for (let i = 0 ; i < this.countPlayerProfileLinkedAccount; i++)
			{
				// Implementation here...
				this.loopPlayerProfileLinkedAccount = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.loopPlayerProfileLinkedAccount = 0;
					break;
				}
			}
	
			loopCtx.release();
		},	
	
		ForEachLocations () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			for (let i = 0 ; i < this.countPlayerProfileLocation; i++)
			{
				// Implementation here...
				this.loopPlayerProfileLocation = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.loopPlayerProfileLocation = 0;
					break;
				}
			}
	
			loopCtx.release();
		},
	
		ForEachStatistics () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			for (let i = 0 ; i < this.countPlayerProfileStatistic; i++)
			{
				// Implementation here...
				this.loopPlayerProfileStatistic = i;
				
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.loopPlayerProfileStatistic = 0;
					break;
				}
			}
	
			loopCtx.release();
		},
		
		ForEachTags () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			for (let i = 0 ; i < this.countPlayerProfileTag; i++)
			{
				// Implementation here...
				this.loopPlayerProfileTag = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.loopPlayerProfileTag = 0;
					break;
				}
			}
	
			loopCtx.release();
		},
	
		ForEachValuesToDate () 
		{ 
			const loopCtx = this.runtime.sdk.createLoopingConditionContext();
	
			for (let i = 0 ; i < this.countPlayerProfileValueToDate; i++)
			{
				// Implementation here...
				this.loopPlayerProfileValueToDate = i;
	
				loopCtx.retrigger();

				if (loopCtx.isStopped)
				{
					// Reset here...
					this.loopPlayerProfileValueToDate = 0;
					break;
				}
			}
	
			loopCtx.release();
		},

		IsAccountLinked (_option)
		{ 
			for (let i = 0 ; i < this.countPlayerProfileLinkedAccount ; i++)
			{
				if (this.platformToOption(this.C3Get.LinkedAccounts_Platform(i)) === _option) {return true};
			}
	
			return false;
		},
	
		IsAccountOrigin (_option)
		{ 
			return this.platformToOption(this.C3Get.Origination()) === _option;
		}
	};
}
