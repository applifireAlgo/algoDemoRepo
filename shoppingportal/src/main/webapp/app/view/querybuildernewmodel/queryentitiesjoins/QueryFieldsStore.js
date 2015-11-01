Ext.define('Shoppingportal.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Shoppingportal.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Shoppingportal.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
