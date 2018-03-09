Ext.Loader.setPath('Ext.ux', 'resources/ext/packages/ux/classic/src');
Ext.Loader.setPath('App.index', 'views/index');
Ext.require([
	//'Ext.ux.TabCloseMenu',
	'App.index.view.LeftMenu'
]);
Ext.application({
	
    name: 'App',
    
    appFolder: 'views',
    
    launch: function() {
	    Ext.create('Ext.container.Viewport', {
	    	layout: {
	            type: 'border',
	            padding: '5'
	        },
	        listeners:{
	        	contextmenu : {
	                element: 'el',
	                fn: function(event){
	                	event.preventDefault();  
	                	event.stopEvent();
	                }
	            }
	        },
	        items: [{
	            region: 'north',
	            height: 80,
	            split:true,
	            loader: {
                    url: 'views/header.html',
                    autoLoad: true,
                    scripts: true
                }
	        }, {
	            region: 'west',
	            xtype: 'panel', 
	            layout:'fit',
	            iconCls:'x-fa fa-bank',
	            split:true,
	            collapsible: true,
	            title: '系统菜单',
	            width: 250,
	            items:{
	            	xtype:'leftMenu'
	            }
	        }, {
	            region: 'south',
	            split:true,
	            height: 30,
	            bodyStyle: {
	                //background: '#5fa2dd',
	                textAlign: 'center',
	                lineHeight: '30px'
	            },
	            html: 'Copyright©2013-2017 XXXXXX科技有限公司 ',
	        }, {
	            region: 'center',
	            xtype: 'tabpanel',
            	id:'home-tabpanel',
                activeTab: 0,
                bodyStyle:'border: 0px;',
                plugins: Ext.create('Ext.ux.TabCloseMenu', {
                	closeTabText: '关闭当前标签',
                	closeTabIcon:'x-fa fa-times',
                	closeAllTabsText:'关闭所有标签',
                	closeAllTabsIcon:'x-fa fa-power-off',
                	closeOthersTabsText:'关闭其他标签',
                	closeOthersTabsIcon:'x-fa fa-tags',
            	}),
                items: {
                	title: '首页',
                	iconCls:'x-fa fa-bank',
                	closable:false,
                	layout:'fit',
                	items:{
                		xtype:'panel',
                		html: 'The first tab\'s content. Others may be added dynamically'
                	}
                }
	        }]
	    });
    }
});