Ext.define('Shoppingportal.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Shoppingportal.view.reportui.querycriteria.QueryCriteriaView',
			'Shoppingportal.view.reportui.datachart.DataChartViewTab',
			'Shoppingportal.view.reportui.datachart.DataChartViewPanel',
			'Shoppingportal.view.reportui.ReportViewController' ,
			'Shoppingportal.view.fw.MainDataPointPanel',
			'Shoppingportal.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
