Ext.define('Shoppingportal.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Shoppingportal.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Shoppingportal.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
