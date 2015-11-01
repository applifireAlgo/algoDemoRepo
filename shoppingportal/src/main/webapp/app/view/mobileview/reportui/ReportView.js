Ext.define('Shoppingportal.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Shoppingportal.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Shoppingportal.view.mobileview.reportui.datachart.DataChartViewTab',
			'Shoppingportal.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Shoppingportal.view.mobileview.reportui.ReportViewController' ,
			'Shoppingportal.view.mobileview.fw.DataPointPanel',
			'Shoppingportal.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
