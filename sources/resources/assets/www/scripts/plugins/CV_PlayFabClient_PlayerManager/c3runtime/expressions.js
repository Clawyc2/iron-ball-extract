"use strict";

{
	const C3 = globalThis.C3;

	C3.Plugins.CV_PlayFabClient_PlayerManager.Exps =
	{
		getAvatarURL () { return ( this.C3Get.AvatarURL() ); },
		getBannedUntil () { return ( this.C3Get.BannedUntil() ); },
		getCreatedDateTime () { return ( this.C3Get.Created() ); },
		getDisplayName () { return ( this.C3Get.DisplayName() ); },
		getLastLogin () { return ( this.C3Get.LastLogin() ); },
		getOrigin () { return ( this.C3Get.Origination() ); },
		getPlayerID () { return ( this.C3Get.PlayerID() ); },
		getPublisherID () { return ( this.C3Get.PublisherID() ); },
		getTitleID () { return ( this.C3Get.TitleID() ); },
		getUSDValue () { return ( this.C3Get.TotalValueToDateInUSD() === 0 ? 0 : (this.C3Get.TotalValueToDateInUSD()/100) ); },
	
		getEmail (_index) { return ( this.C3Get.ContactEmails_EmailAddress(_index) ); },
		getEmailName (_index) { return ( this.C3Get.ContactEmails_Name(_index) ); },
		getEmailStatus (_index) { return ( this.C3Get.ContactEmails_VerificationStatus(_index) ); },
	
		getLinkedEmail (_index) { return ( this.C3Get.LinkedAccounts_Email(_index) ); },
		getLinkedPlatform (_index) { return ( this.C3Get.LinkedAccounts_Platform(_index) ); },
		getLinkedUserID (_index) { return ( this.C3Get.LinkedAccounts_PlatformUserID(_index) ); },
		getLinkedUsername (_index) { return ( this.C3Get.LinkedAccounts_Username(_index) ); },

		getCity (_index) { return ( this.C3Get.Locations_City(_index) ); },
		getContinentCode (_index) { return ( this.C3Get.Locations_ContinentCode(_index) ); },
		getCountryCode (_index) { return ( this.C3Get.Locations_CountryCode(_index) ); },
		getLatitude (_index) { return ( this.C3Get.Locations_Latitude(_index) ); },
		getLongitude (_index) { return ( this.C3Get.Locations_Longitude(_index) ); },
	
		getStatisticName (_index) { return ( this.C3Get.Statistics_Name(_index) ); },
		getStatisticValue (_index) { return ( this.C3Get.Statistics_Value(_index) ); },
		getStatisticVersion (_index) { return ( this.C3Get.Statistics_Version(_index) ); },
	
		getTag (_index) { return ( this.C3Get.Tags_TagValue(_index) ); },
	
		getValueCurrency (_index) { return ( this.C3Get.ValuesToDate_Currency(_index) ); },
		getTotalValue (_index) { return ( this.C3Get.ValuesToDate_TotalValue(_index) === 0 ? 0 : (this.C3Get.ValuesToDate_TotalValue(_index)/100) ); },
		getTotalValueAsDec (_index) { return ( this.C3Get.ValuesToDate_TotalValueAsDecimal(_index) ); },
	
		loopEmailList () { return ( this.loopPlayerProfileEmail ); },
		countEmails () { return ( this.countPlayerProfileEmail ); },
	
		loopLinkedAccounts () { return ( this.loopPlayerProfileLinkedAccount ); },
		countLinkedAccounts () { return ( this.countPlayerProfileLinkedAccount ); },
	
		loopLocations () { return ( this.loopPlayerProfileLocation ); },
		countLocations () { return ( this.countPlayerProfileLocation ); },
	
		loopStatistics () { return ( this.loopPlayerProfileStatistic ); },
		countStatistics () { return ( this.countPlayerProfileStatistic ); },
	
		loopTags () { return ( this.loopPlayerProfileTag ); },
		countTags () { return ( this.countPlayerProfileTag ); },
	
		loopValues () { return ( this.loopPlayerProfileValueToDate ); },
		countValues () { return ( this.countPlayerProfileValueToDate ); },

		ServerResponse () { return ( this.C3Memory.recentServerResponse ); },

		Tag () { return ( this.C3Get.Tag() ); }	
	};
}
