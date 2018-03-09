
Ext.define('App.menu.controller.MenuListController', {
    extend: 'Ext.app.ViewController',
    alias:'controller.menuListController',
    
    /**
     * 向上移动
     */
    onUpClick: function (view , rowIndex, colIndex, item, e, record, rowEl) {  
    	
    	if(rowIndex == 0){
    		Ext.Msg.show({
    		    title:'警告',
    		    message: '<div style="height: 45px;line-height: 45px;position: fixed;padding-left: 26px">已经到顶了！</div>',
    		    buttons: Ext.Msg.OK,
    		    icon: Ext.Msg.WARNING,
    		});
    		return;
    	}
    	
    	var treepanel = view.up("treepanel")
    	
    	var treeRoot = treepanel.getRootNode();
    	
    	var nodeArray = new Array();
    	
    	findChildNodeByNodes(nodeArray, treeRoot.childNodes)
    	
    	var selfNode = nodeArray[rowIndex];
    	
    	var parentNode = selfNode.parentNode;
    	
    	var previousNode = selfNode.previousSibling;
    	
    	if(previousNode){
    		previousNode.appendChild(selfNode);
    		previousNode.expand();
    	}else{
    		parentNode.parentNode.insertBefore(selfNode, parentNode);
    	}
    	
    	moveTree(view, selfNode);
    },
    /**
     * 向下移动
     */
    onDownClick: function (view , rowIndex, colIndex, item, e, record, rowEl) {  
    	
    	var treepanel = view.up("treepanel")
    	
    	var treeRoot = treepanel.getRootNode();
    	
    	var nodeArray = new Array();
    	
    	findChildNodeByNodes(nodeArray, treeRoot.childNodes)
    	
    	var selfNode = nodeArray[rowIndex];
    	
    	var parentNode = selfNode.parentNode;
    	
    	var nextNode = selfNode.nextSibling;
    	
    	if(nextNode == null){
    		if(selfNode.childNodes.length > 0){
    			parentNode.insertBefore(selfNode.firstChild, selfNode);
    		}else{
    			if(parentNode.parentNode){
    				parentNode.parentNode.insertBefore(selfNode, parentNode.nextSibling);
    			}else{
    				Ext.Msg.show({
    	    		    title:'警告',
    	    		    message: '<div style="height: 45px;line-height: 45px;position: fixed;padding-left: 26px">已经到底了！</div>',
    	    		    buttons: Ext.Msg.OK,
    	    		    icon: Ext.Msg.WARNING,
    	    		});
    				return;
    			}
    		}
    	}else{
    		if(nextNode.childNodes.length > 0){
    			console.log(nextNode.firstChild);
    			nextNode.insertBefore(selfNode, nextNode.firstChild);
    		}else{
    			nextNode.appendChild(selfNode);
    			nextNode.expand();
    		}
    	}
    	moveTree(view, selfNode);
    }
    
});

/**
 * 递归查询节点
 */
function findChildNodeByNodes(nodeArray, treeNodes){
	
	for(i in treeNodes){
		var node = treeNodes[i];
		nodeArray.push(node);
		if(node.childNodes && node.childNodes.length > 0){
			findChildNodeByNodes(nodeArray, node.childNodes);
		}
	}
}
/**
 *请求后台移动菜单 
 */
function moveTree(view, node){
	var mask = new Ext.LoadMask({
	    msg    : '数据处理中...',
	    target : view.up("treepanel"),
	    removeMask: true
	});
	mask.show();
	
	var nodeId = node.data.id, nextNodeId = 0, previousNodeId=0, parentNodeId = 0;
	
	if(node.nextSibling){
		nextNodeId = node.nextSibling.data.id;
	}
	if(node.previousSibling){
		previousNodeId = node.previousSibling.data.id;
	}
	if(node.parentNode){
		parentNodeId = node.parentNode.data.id == 'root' ? 0 : node.parentNode.data.id;
	}
	Ext.Ajax.request({
	     url: 'user/menu/move',
	     params:{
	    	nodeId         : nodeId,
	    	nextNodeId     : nextNodeId,
	    	previousNodeId : previousNodeId,
	    	parentNodeId   : parentNodeId
	     },
	     method:'post',
	     success: function(response, opts) {
	         var obj = Ext.decode(response.responseText);
	         mask.hide();
	         if(obj.status){
	        	 Ext.Msg.show({
	     		    title:'成功',
	     		    message: '<div style="height: 45px;line-height: 45px;position: fixed;padding-left: 18px">'+obj.message+'</div>',
	     		    buttons: Ext.Msg.OK,
	     		    icon: Ext.Msg.INFO,
	     		}); 
	         }else{
	        	 Ext.Msg.show({
	     		    title:'错误',
	     		    message: '<div style="height: 45px;line-height: 45px;position: fixed;padding-left: 18px">'+obj.message+'</div>',
	     		    buttons: Ext.Msg.OK,
	     		    icon: Ext.Msg.ERROR,
	     		}); 
	         }
	     },
	     failure: function(response, opts) {
	    	 mask.hide();
	    	 Ext.Msg.show({
    		    title:'错误',
    		    message: '<div style="height: 45px;line-height: 45px;position: fixed;padding-left: 18px">操作失败请重试！</div>',
    		    buttons: Ext.Msg.OK,
    		    icon: Ext.Msg.ERROR,
    		});
	     }
	 });
}
