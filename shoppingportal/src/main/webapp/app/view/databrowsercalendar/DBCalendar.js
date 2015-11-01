Ext.define('Shoppingportal.view.databrowsercalendar.DBCalendar', {
	extend : 'Shoppingportal.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Shoppingportal.view.databrowsercalendar.DBCalendarController',
	             'Shoppingportal.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
