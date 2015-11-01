Ext.define('Shoppingportal.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Shoppingportal.view.art.masterform.MasterFormModel','Shoppingportal.view.art.masterform.MasterFormViewModel','Shoppingportal.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	