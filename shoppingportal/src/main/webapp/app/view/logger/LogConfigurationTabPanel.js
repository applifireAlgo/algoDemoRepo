/**
 * 
 */
Ext
		.define(
				'Shoppingportal.view.logger.LogConfigurationTabPanel',
				{
					extend : 'Ext.form.Panel',
					xtype : 'logConfiguration',
					autoScroll : true,

					requires : [
							'Shoppingportal.view.logger.tabs.details.DetailsTab',
							'Shoppingportal.view.logger.tabs.fileconnector.FileConnectorTab',
							'Shoppingportal.view.logger.tabs.dbconnector.DBConnectorTab',
							'Shoppingportal.view.logger.tabs.syslogsocketconnector.SyslogSocketConnectorTab',
							'Shoppingportal.view.logger.tabs.tcpsocketconnector.TCPSocketConnectorTab',
							'Shoppingportal.view.logger.LogConfigurationTabPanelController',
							'Ext.form.field.Hidden', 'Ext.form.field.ComboBox',
							'Ext.form.FieldSet', 'Ext.form.FieldContainer',
							'Ext.layout.container.Column','Ext.ux.TabReorderer', 'Ext.form.field.Radio' ],
					controller : 'logConfigurationTabPanelController',

					items : [ {
						xtype : 'tabpanel',
						plugins : 'tabreorderer',

						defaults : {
							bodyPadding : 10,
							autoScroll : true,
						},
						items : [ {
							xtype : 'detailsTab',
							itemId : 'detailsTab'
						}, {
							xtype : 'fileConnectorTab',
							itemId : 'fileConnectorTab'
						}, {
							xtype : 'dbConnectorTab',
							itemId : 'dbConnectorTab'
						}, {
							xtype : 'syslogSocketConnectorTab',
							itemId : 'syslogSocketConnectorTab',
						}, {
							xtype : 'tcpSocketConnectorTab',
							itemId : 'tcpSocketConnectorTab'
						} ]

					}, {
						xtype : 'hidden',
						name : 'appConfigId',
						itemId : 'appConfigId'
					}],

					buttons : [ {
						text : 'Reset',
						itemId : 'resetButton',
						handler : 'onResetClick'
					}, {
						text : 'Update',
						formBind : true,
						itemId : 'submitButton',
						handler : 'onSubmitClick'
					} ]

				});