
Ext.define('App.index.controller.LeftMenuController', {
    extend: 'Ext.app.ViewController',
    alias:'controller.leftMenuController',
    init: function() {
    	this.control({
            'leftMenu': {
            	render: this.loadLeftMenu
            },
            'leftMenu > treepanel' :{
            	itemclick:this.itemclick
            }
        });
    },
    
    /**
     * 加载用户菜单
     */
    loadLeftMenu:function(menu , eOpts){
		Ext.Ajax.request({
		     url: 'user/login',
		     method:'get',
		     success: function(response, opts) {
		         menu.add(Ext.decode(response.responseText));
		     }
		 });
    },
    
    /**
     * 菜单的点击事件
     */
    itemclick : function(node , record , item , index , e , eOpts){
    	var menu = record.data;
    	var urlPath = menu.urlPath;
    	if(urlPath){
    		var tabPanel = Ext.getCmp('home-tabpanel');
    		var itemId = menu.id;
    		if(Ext.getCmp(itemId)){
    			tabPanel.setActiveTab(itemId);
    		}else{
    			tabPanel.setActiveTab({
    				id:menu.id,
    				title:menu.text,
    				closable:true,
    				iconCls:menu.iconCls,
    				layout:'fit',
    				items:{
    					xtype:Ext.create(urlPath)
    				}
        		});
    		}
    	}
    }
});