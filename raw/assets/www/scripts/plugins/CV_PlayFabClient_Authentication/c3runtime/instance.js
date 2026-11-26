"use strict";

{
    const C3 = globalThis.C3;

    const DOM_COMPONENT_ID = "cv-playfab-authentication";

    const PLAYFAB_REF = "CV_PlayFab_MasterCollection";

    C3.Plugins.CV_PlayFabClient_Authentication.Instance = class PlayFab_Authentication_Instance extends globalThis.ISDKInstanceBase
    {
        constructor()
        {
            super({ domComponentId: DOM_COMPONENT_ID })
            const properties = this._getInitProperties();

            this.Initialize();
        }

        _release()
        {
            super._release();
        }

        _saveToJson()
        {
            return {};
        }

        _loadFromJson(o)
        {}

		///////////////////////////////////////
		// Core Methods        
        Initialize()
        {
            //** Custom Properties **//
            this.getPlayFabID = "";
            this.getSessionTicket = "";
            this.getIsNewlyCreated = "";

            this.getAndroidDevicePlayFabID = "";
            this.getAndroidDeviceSessionTicket = "";
            this.getAndroidDeviceNewlyCreated = "";

            this.getIOSDevicePlayFabID = "";
            this.getIOSDeviceSessionTicket = "";
            this.getIOSDeviceNewlyCreated = "";

            this.getCustomIDPlayFabID = "";
            this.getCustomIDSessionTicket = "";
            this.getCustomIDNewlyCreated = "";

            this.getFacebookPlayFabID = "";
            this.getFacebookSessionTicket = "";
            this.getFacebookNewlyCreated = "";
            this.getFacebookErrorMessage = "";

            this.getGooglePlayFabID = "";
            this.getGoogleSessionTicket = "";
            this.getGoogleNewlyCreated = "";

            this.getCompanyEmailPlayFabID = "";
            this.getCompanyEmailSessionTicket = "";
            this.getCompanyEmailNewlyCreated = "";

            this.getCompanyUsernamePlayFabID = "";
            this.getCompanyUsernameSessionTicket = "";
            this.getCompanyUsernameNewlyCreated = "";

            this.getCompanyRegisterPlayFabID = "";
            this.getCompanyRegisterSessionTicket = "";
            this.getCompanyRegisterNewlyCreated = "";

            //** System References **//
            const self = this;
            const Conditions = C3.Plugins.CV_PlayFabClient_Authentication.Cnds;

            //** Utilities **//
            this.C3Memory = {

                recentServerResponse: ""
            };

            this.C3Current = {

                isCompany_Authenticating: false,
                isFacebook_Authenticating: false,
                isGooglePlay_Authenticating: false,
                isAndroid_Authenticating: false,
                isIOS_Authenticating: false,
                isCustomID_Authenticating: false
            };

            this.C3Trigger = {

                androidDeviceLogin: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Android Device Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getAndroidDevicePlayFabID = PlayFabID;
                        self.getAndroidDeviceSessionTicket = SessionTicket;
                        self.getAndroidDeviceNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.AndroidDeviceLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Android Device Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Android Device Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.AndroidDeviceLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.AndroidDeviceLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isAndroid_Authenticating = false;   
                },

                iosDeviceLogin: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("IOS Device Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getIOSDevicePlayFabID = PlayFabID;
                        self.getIOSDeviceSessionTicket = SessionTicket;
                        self.getIOSDeviceNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.IOSDeviceLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On IOS Device Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("IOS Device Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.IOSDeviceLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.IOSDeviceLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isIOS_Authenticating = false; 
                },

                anonymousCustomID: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Custom ID Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        var PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //...Record
                        self.getCustomIDPlayFabID = PlayFabID;
                        self.getCustomIDSessionTicket = SessionTicket;
                        self.getCustomIDNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.CustomIDLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Custom ID Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Custom ID Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.CustomIDLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.CustomIDLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isCustomID_Authenticating = false;                     
                },

                facebookLogin: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Facebook Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getFacebookPlayFabID = PlayFabID;
                        self.getFacebookSessionTicket = SessionTicket;
                        self.getFacebookNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.FacebookLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Facebook Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Facebook Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.FacebookLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.FacebookLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isFacebook_Authenticating = false; 
                },

                googleLogin: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Google Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getGooglePlayFabID = PlayFabID;
                        self.getGoogleSessionTicket = SessionTicket;
                        self.getGoogleNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.GoogleLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Google Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Google Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.GoogleLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.GoogleLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }

                    }

                    //....Notifier
                    self.C3Current.isGooglePlay_Authenticating = false; 
                },

                companyEmailLogin: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Company Email Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getCompanyEmailPlayFabID = PlayFabID;
                        self.getCompanyEmailSessionTicket = SessionTicket;
                        self.getCompanyEmailNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.Company_EmailLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Company Email Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Company Email Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.Company_EmailLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else if (errorCode === 1142)
                        {
                            // Call Function
                            const trigger = Conditions.Company_EmailLogin_InvalidEmailOrPassword;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Invalid Email Or Password");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.Company_EmailLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isCompany_Authenticating = false; 
                },

                companyUsernameLogin: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Company Username Login :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getCompanyUsernamePlayFabID = PlayFabID;
                        self.getCompanyUsernameSessionTicket = SessionTicket;
                        self.getCompanyUsernameNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.Company_UsernameLogin;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Company Username Login");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Company Username Login :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error["errorCode"];

                        if (errorCode === 1001)
                        {
                            // Call Function
                            const trigger = Conditions.Company_UsernameLogin_AccountNotFound;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Account Not Found");
                            }
                        }
                        else if (errorCode === 1003)
                        {
                            // Call Function
                            const trigger = Conditions.Company_UsernameLogin_InvalidUsernameOrPassword;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Invalid Username Or Password");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            // Call Function
                            const trigger = Conditions.Company_UsernameLogin_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isCompany_Authenticating = false;                     
                },

                companyRegister: function(_callback, _error)
                {

                    if (_callback != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debug("Company Register :: Positive Response Received : ");
                            self.debug(_callback);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_callback);

                        const PlayFabID = _callback["data"]["PlayFabId"];
                        const SessionTicket = _callback["data"]["SessionTicket"];
                        const NewlyCreated = _callback["data"]["NewlyCreated"] == 1 ? "True" : "False";

                        //..Record
                        self.getCompanyRegisterPlayFabID = PlayFabID;
                        self.getCompanyRegisterSessionTicket = SessionTicket;
                        self.getCompanyRegisterNewlyCreated = NewlyCreated;

                        self.getPlayFabID = PlayFabID;
                        self.getSessionTicket = SessionTicket;
                        self.getIsNewlyCreated = NewlyCreated;

                        //..Push to SDK
                        const token = _callback["data"]["EntityToken"]["EntityToken"];
                        const ticket = SessionTicket;

                        self.SetEntityToken(token);
                        self.SetSessionTicket(ticket);

                        // Call Function
                        const trigger = Conditions.Company_Register;
                        self.Call(trigger);

                        // Show Trigger Name
                        if (self.debugMode())
                        {
                            self.debug("Triggered : On Company Register");
                        }
                    }
                    else if (_error != null)
                    {
                        // Show Debug Data
                        if (self.debugMode())
                        {
                            self.debugCommonLog();
                            self.debug("Company Register :: Negative Response Received : ");
                            self.debug(_error);
                        }

                        // Set Server Response into C3Memory
                        self.C3Memory.recentServerResponse = JSON.stringify(_error);

                        const errorCode = _error.errorCode;

                        if (errorCode === 1006)
                        {
                            const trigger = Conditions.Company_Register_EmailAddressNotAvailable;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Email Address Not Available");
                            }
                        }
                        else if (errorCode === 1005)
                        {
                            const trigger = Conditions.Company_Register_InvalidEmailAddress;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Invalid Email Address");
                            }
                        }
                        else if (errorCode === 1008)
                        {
                            const trigger = Conditions.Company_Register_InvalidPassword;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Invalid Password");
                            }
                        }
                        else if (errorCode === 1007)
                        {
                            const trigger = Conditions.Company_Register_InvalidUsername;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Invalid Username");
                            }
                        }
                        else if (errorCode === 1058)
                        {
                            const trigger = Conditions.Company_Register_NameNotAvailable;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Name Not Available");
                            }
                        }
                        else if (errorCode === 1234)
                        {
                            const trigger = Conditions.Company_Register_ProfaneDisplayName;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Profane Display Name");
                            }
                        }
                        else if (errorCode === 1009)
                        {
                            const trigger = Conditions.Company_Register_UsernameNotAvailable;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On Username Not Available");
                            }
                        }
                        else
                        {
                            const errorReport = self.GenerateErrorReport(_error);
                            if (self.debugMode())
                            {
                                self.debug("PlayFab Generated Report : ");
                                self.debug(errorReport);
                            }

                            const trigger = Conditions.Company_Register_Error;
                            self.Call(trigger);

                            // Show Trigger Name
                            if (self.debugMode())
                            {
                                self.debug("Triggered : On General Error");
                            }
                        }
                    }

                    //....Notifier
                    self.C3Current.isCompany_Authenticating = false; 
                }
            };

            //** System Utilities **//
            this.Call = function(_path)
            {
                const trigger = _path;

                self._trigger(trigger);
            };

			//** Construct 3 DOM Handlers **//
			this._addDOMMessageHandlers([
                ["login-with-android", e => this.C3Trigger.androidDeviceLogin(...e)],
                ["login-with-ios", e => this.C3Trigger.iosDeviceLogin(...e)],
                ["login-with-custom-id", e => this.C3Trigger.anonymousCustomID(...e)],
                ["login-with-facebook", e => this.C3Trigger.facebookLogin(...e)],
                ["login-with-google", e => this.C3Trigger.googleLogin(...e)],
                ["login-with-email", e => this.C3Trigger.companyEmailLogin(...e)],
                ["login-with-playfab", e => this.C3Trigger.companyUsernameLogin(...e)],
                ["register-with-playfab", e => this.C3Trigger.companyRegister(...e)],
                ["set-session-ticket", e => this.setGlobalSessionTicket(...e)]
            ]);
        }

		///////////////////////////////////////
		// Action Methods
        _AndroidDeviceLogin(_titleID, _UUID, _OS, _model, _create)
        {

            const create = _create === 0 ? true : false;

            const data = {
                "AndroidDeviceId": _UUID,
                "OS": _OS,
                "AndroidDevice": _model,
                "CreateAccount": create,
                "TitleId": _titleID
            };

            //....Notifier
            this.C3Current.isAndroid_Authenticating = true;         

            this._postToDOM("login-with-android", [data]);
        }

        _IOSDeviceLogin (_titleID, _UUID, _OS, _model, _create)
        {

            const create = _create === 0 ? true : false;

            const data = {
                "DeviceId": _UUID,
                "OS": _OS,
                "DeviceModel": _model,
                "CreateAccount": create,
                "TitleId": _titleID
            };

            //....Notifier
            this.C3Current.isIOS_Authenticating = true;   

            this._postToDOM("login-with-ios", [data]);
        }

        _CustomIDLogin(_titleID, _customID, _create)
        {

            const create = _create === 0 ? true : false;

            const data = {
                "CustomId": _customID,
                "CreateAccount": create,
                "TitleId": _titleID
            };

            //....Notifier
            this.C3Current.isCustomID_Authenticating = true;   

            this._postToDOM("login-with-custom-id", [data]);
        }

        _FacebookLogin(_titleID, _accessToken, _create)
        {

            const create = _create === 0 ? true : false;

            const data = {
                "AccessToken": _accessToken,
                "CreateAccount": create,
                "TitleId": _titleID
            };

            //....Notifier
            this.C3Current.isFacebook_Authenticating = true;   

            this._postToDOM("login-with-facebook", [data]);
        }

        _GoogleLogin(_titleID, _serverAuthCode, _create)
        {

            const create = _create === 0 ? true : false;

            const data = {
                "ServerAuthCode": _serverAuthCode,
                "CreateAccount": create,
                "TitleId": _titleID
            };

            //....Notifier
            this.C3Current.isGooglePlay_Authenticating = true;   

            this._postToDOM("login-with-google", [data]);
        }

        _CompanyLogin(_titleID, _key, _password, _method)
        {

            //....Notifier
            this.C3Current.isCompany_Authenticating = true;               

            if (_method === 0)
            {
                const data = {
                    "Email": _key,
                    "Password": _password,
                    "TitleId": _titleID
                };

                this._postToDOM("login-with-email", [data]);
            }
            else
            {
                const data = {
                    "Username": _key,
                    "Password": _password,
                    "TitleId": _titleID
                };

                this._postToDOM("login-with-playfab", [data]);
            }

        }

        _CompanyRegister(_titleID, _username, _password, _email, _displayName)
        {

            const data = {
                "RequireBothUsernameAndEmail": true,
                "Username": _username,
                "Password": _password,
                "Email": _email,
                "DisplayName": _displayName,
                "TitleId": _titleID
            };

            //....Notifier
            this.C3Current.isCompany_Authenticating = true;   

            this._postToDOM("register-with-playfab", [data]);
        }

		///////////////////////////////////////
		// Condition Methods
        __IsAuthenticating(authMethod)
        {
            switch (authMethod)
            {
                case (0):
                    return this.C3Current.isCompany_Authenticating;
                case (1):
                    return this.C3Current.isFacebook_Authenticating;
                case (2):
                    return this.C3Current.isGooglePlay_Authenticating;
                case (3):
                    return this.C3Current.isAndroid_Authenticating;
                case (4):
                    return this.C3Current.isIOS_Authenticating;
                case (5):
                    return this.C3Current.isCustomID_Authenticating;
                default:
                    return false;
            }
        }
        
		///////////////////////////////////////
        // PlayFab Methods
        SetEntityToken(_token)
        {
            this._postToDOM("set-entity-token", [_token]);
        }
        SetSessionTicket(_ticket)
        {
            this._postToDOM("set-session-ticket", [_ticket]);
        }

		///////////////////////////////////////
		// PlayFab Common Methods
        getTitleID()
        {
            const src = globalThis[PLAYFAB_REF];
            return src["titleID"];
        }
        setGlobalSessionTicket (_session){

			globalThis[PLAYFAB_REF]["session-ticket"] = _session;
		}
        debugMode()
        {
            const src = globalThis[PLAYFAB_REF];
            return src["debugMode"];
        }
        debug(_message)
        {
            console.log(_message);
        }
        debugCommonLog()
        {
            globalThis[PLAYFAB_REF]["debugCommonLog"]();
        }
        GenerateErrorReport(error)
        {
            return globalThis[PLAYFAB_REF]["GenerateErrorReport"](error);
        }
        //////////////////////////////
    };
}
