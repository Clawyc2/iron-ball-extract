"use strict";
{
    const C3 = globalThis.C3;

    C3.Plugins.CV_PlayFabClient_Authentication.Exps = {
        getAndroidPlayFabID()
        {
            return (this.getAndroidDevicePlayFabID);
        },

        getAndroidSessionTicket()
        {
            return (this.getAndroidDeviceSessionTicket);
        },

        getAndroidNewlyCreated()
        {
            return (this.getAndroidDeviceNewlyCreated);
        },

        getIOSPlayFabID()
        {
            return (this.getIOSDevicePlayFabID);
        },

        getIOSSessionTicket()
        {
            return (this.getIOSDeviceSessionTicket);
        },

        getIOSNewlyCreated()
        {
            return (this.getIOSDeviceNewlyCreated);
        },

        getFacebookPlayFabID()
        {
            return (this.getFacebookPlayFabID);
        },

        getFacebookSessionTicket()
        {
            return (this.getFacebookSessionTicket);
        },

        getFacebookNewlyCreated()
        {
            return (this.getFacebookNewlyCreated);
        },

        getGooglePlayFabID()
        {
            return (this.getGooglePlayFabID);
        },

        getGoogleSessionTicket()
        {
            return (this.getGoogleSessionTicket);
        },

        getGoogleNewlyCreated()
        {
            return (this.getGoogleNewlyCreated);
        },

        getEmailPlayFabID()
        {
            return (this.getCompanyEmailPlayFabID);
        },

        getEmailSessionTicket()
        {
            return (this.getCompanyEmailSessionTicket);
        },

        getEmailNewlyCreated()
        {
            return (this.getCompanyEmailNewlyCreated);
        },

        getUsernamePlayFabID()
        {
            return (this.getCompanyUsernamePlayFabID);
        },

        getUsernameSessionTicket()
        {
            return (this.getCompanyUsernameSessionTicket);
        },

        getUsernameNewlyCreated()
        {
            return (this.getCompanyUsernameNewlyCreated);
        },

        getRegisterPlayFabID()
        {
            return (this.getCompanyRegisterPlayFabID);
        },

        getRegisterSessionTicket()
        {
            return (this.getCompanyRegisterSessionTicket);
        },

        getRegisterNewlyCreated()
        {
            return (this.getCompanyRegisterNewlyCreated);
        },

        getCustomIDPlayFabID()
        {
            return (this.getCustomIDPlayFabID);
        },

        getCustomIDSessionTicket()
        {
            return (this.getCustomIDSessionTicket);
        },

        getCustomIDNewlyCreated()
        {
            return (this.getCustomIDNewlyCreated);
        },

        ServerResponse()
        {
            return (this.C3Memory.recentServerResponse);
        },

        PlayFabID()
        {
            return (this.getPlayFabID);
        },

        SessionTicket()
        {
            return (this.getSessionTicket);
        },

        IsNewlyCreated()
        {
            return (this.getIsNewlyCreated);
        }
    };
}
