"use strict";
{
    const C3 = globalThis.C3;

    C3.Plugins.CV_PlayFabClient_Authentication.Acts = {
        AndroidDeviceLogin(_UUID, _OS, _model, _create)
        {
            const titleID = this.getTitleID();
            const UUID = _UUID;
            const OS = _OS;
            const model = _model;
            const create = _create;
            //....Login Call
            this._AndroidDeviceLogin(titleID, UUID, OS, model, create);
        },

        IOSDeviceLogin(_UUID, _OS, _model, _create)
        {
            const titleID = this.getTitleID();
            const UUID = _UUID;
            const OS = _OS;
            const model = _model;
            const create = _create;       
            //....Login Call
            this._IOSDeviceLogin(titleID, UUID, OS, model, create);
        },

        CustomIDLogin(_customID, _create)
        {
            const titleID = this.getTitleID();
            const customID = _customID;
            const create = _create;          
            //....Login Call		
            this._CustomIDLogin(titleID, customID, create);
        },

        FacebookLogin(_accessToken, _create)
        {
            const titleID = this.getTitleID();
            const accessToken = _accessToken;
            const create = _create;        
            //....Login Call
            this._FacebookLogin(titleID, accessToken, create);
        },

        GoogleLogin(_authCode, _create)
        {
            const titleID = this.getTitleID();
            const serverAuthCode = _authCode;
            const create = _create;              
            //....Login Call
            this._GoogleLogin(titleID, serverAuthCode, create);
        },

        CompanyLogin(_key, _password, _method)
        {
            const titleID = this.getTitleID();
            const key = _key;
            const password = _password;
            const method = _method;            
            //....Login Call		
            this._CompanyLogin(titleID, key, password, method);
        },

        CompanyRegister(_email, _username, _password, _displayName)
        {
            const titleID = this.getTitleID();
            const email = _email;
            const username = _username;
            const password = _password;
            const displayName = _displayName;                
            //....Login Call		
            this._CompanyRegister(titleID, username, password, email, displayName);
        }
    };
}
