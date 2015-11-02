/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Shoppingportal',

    extend: 'Shoppingportal.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Shoppingportal.view.mainleftmenutree.MainPanel':'Shoppingportal.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Shoppingportal.view.login.LoginPage':'Shoppingportal.view.mobileview.login.LoginPage',//'Shoppingportal.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Shoppingportal.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
