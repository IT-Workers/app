Ext.require([
	'App.menu.controller.MenuListController'
])
Ext.define('App.menu.view.MenuList', {
    extend: 'Ext.tree.Panel',
    alias:'widget.menuList',
    controller:'menuListController',
    id:'menuList',
    useArrows:true,
    rootVisible:false,
    animate:true,
    columns: [{
        xtype: 'treecolumn',
        text: '菜单名称',
        dataIndex: 'text',
        flex: 1,
        sortable: false,
        hideable: false
    }, {
    	 xtype: 'actioncolumn',  
         text: '操作',
         align:"center",
         width: 300,
         items: [{  
        	 iconCls: 'x-fa fa-arrow-up',
             tooltip: '向上移动',  
             handler: 'onUpClick'
         },{
         },{  
        	 iconCls: 'x-fa fa-arrow-down',
             tooltip: '向下移动',  
             handler: 'onDownClick'
         }] 
        
    }],
    viewConfig: {
        plugins: {
            ptype: 'treeviewdragdrop'
        }
    },
    store:Ext.create('Ext.data.TreeStore', {
    	fields: ['text', 'iconCls'],
        proxy: {
            type: 'ajax',
            url: 'user/menu/list',
            reader: {
                type: 'json'
            }
        },
        autoLoad: true
    })
});






