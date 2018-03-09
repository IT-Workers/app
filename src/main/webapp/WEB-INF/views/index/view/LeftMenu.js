Ext.require([
	'App.index.controller.LeftMenuController'
])
Ext.define('App.index.view.LeftMenu', {
    extend: 'Ext.panel.Panel',
    alias:'widget.leftMenu',
    controller:'leftMenuController',
    layout: {
        type: 'accordion',
        animate: true,
        activeOnTop: true
    },
    border:false
});