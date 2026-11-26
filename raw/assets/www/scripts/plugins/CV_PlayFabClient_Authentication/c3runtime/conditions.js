"use strict";
{
    const C3 = globalThis.C3;

    C3.Plugins.CV_PlayFabClient_Authentication.Cnds = {
        AndroidDeviceLogin()
        {
            return true;
        },

        AndroidDeviceLogin_AccountNotFound()
        {
            return true;
        },

        AndroidDeviceLogin_Error()
        {
            return true;
        },

        IOSDeviceLogin()
        {
            return true;
        },

        IOSDeviceLogin_AccountNotFound()
        {
            return true;
        },

        IOSDeviceLogin_Error()
        {
            return true;
        },

        CustomIDLogin()
        {
            return true;
        },

        CustomIDLogin_AccountNotFound()
        {
            return true;
        },

        CustomIDLogin_Error()
        {
            return true;
        },

        FacebookLogin()
        {
            return true;
        },

        FacebookLogin_AccountNotFound()
        {
            return true;
        },

        FacebookLogin_Error()
        {
            return true;
        },

        GoogleLogin()
        {
            return true;
        },

        GoogleLogin_AccountNotFound()
        {
            return true;
        },

        GoogleLogin_Error()
        {
            return true;
        },

        Company_EmailLogin()
        {
            return true;
        },

        Company_EmailLogin_AccountNotFound()
        {
            return true;
        },

        Company_EmailLogin_InvalidEmailOrPassword()
        {
            return true;
        },

        Company_EmailLogin_Error()
        {
            return true;
        },

        Company_UsernameLogin()
        {
            return true;
        },

        Company_UsernameLogin_AccountNotFound()
        {
            return true;
        },

        Company_UsernameLogin_InvalidUsernameOrPassword()
        {
            return true;
        },

        Company_UsernameLogin_Error()
        {
            return true;
        },

        Company_Register()
        {
            return true;
        },

        Company_Register_EmailAddressNotAvailable()
        {
            return true;
        },

        Company_Register_InvalidEmailAddress()
        {
            return true;
        },

        Company_Register_InvalidPassword()
        {
            return true;
        },

        Company_Register_InvalidUsername()
        {
            return true;
        },

        Company_Register_NameNotAvailable()
        {
            return true;
        },

        Company_Register_ProfaneDisplayName()
        {
            return true;
        },

        Company_Register_UsernameNotAvailable()
        {
            return true;
        },

        Company_Register_Error()
        {
            return true;
        },

        IsAnyAuthenticating()
        {
            for (let i = 0; i < 5; i++)
            {
                if (this.__IsAuthenticating(i) == true)
                {
                    return true;
                }
            }
            return false;
        },

        IsAuthenticating(authMethod)
        {
            return this.__IsAuthenticating(authMethod);
        }
    };
}
