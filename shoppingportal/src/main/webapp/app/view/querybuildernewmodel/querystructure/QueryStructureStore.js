Ext.define('Shoppingportal.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Shoppingportal.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Shoppingportal.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
