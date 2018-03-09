package com.sun.user.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.common.service.CommonService;
import com.sun.user.dao.UserDao;
import com.sun.user.model.Menu;

@Service("userService")
public class UserService extends CommonService{

	@Resource UserDao userDao;
	
	/**
	 * 获取用户的菜单
	 * @param roleId
	 * @return
	 */
	public JSONArray getUserMenuByRoleId(int roleId){
		
		Map<String, List<Menu>> mapMenuList = group(new String[]{"menuParentId"}, userDao.getMenuListByRoleId(roleId));
		
		JSONArray items = new JSONArray();
		
		for(Menu menu : mapMenuList.get("0")){
			
			JSONObject item = new JSONObject();
			
			item.put("xtype", "treepanel");
			item.put("id", menu.getMenuId());
			item.put("title", menu.getMenuName());
			item.put("iconCls", menu.getMenuIcon());
			item.put("animate", true);
			item.put("useArrows", true);
			item.put("rootVisible", false);
			
			JSONObject store = new JSONObject();
			
			JSONObject root = new JSONObject();
			root.put("children", findChildren(mapMenuList, menu));
			store.put("root", root);
			
			item.put("store", store);
			
			items.add(item);
			
		}
		return items;
	}
	/**
	 * 递归查询子节点
	 * @param mapMenuList
	 * @param menu
	 * @return
	 */
	private JSONArray findChildren(Map<String, List<Menu>> mapMenuList, Menu menu){
		JSONArray childrens = new JSONArray();
		List<Menu> menuList = mapMenuList.get(menu.getMenuId()+"");
		if(menuList != null){
			for(Menu child: menuList){
				JSONObject children = new JSONObject();
				children.put("id", child.getMenuId());
				children.put("text", child.getMenuName());
				if(child.getMenuIcon() != null){
					children.put("iconCls", child.getMenuIcon());
				}
				if(mapMenuList.get(child.getMenuId()+"") == null){
					children.put("leaf", true);
					children.put("urlPath", child.getMenuPath());
				}else{
					children.put("children", findChildren(mapMenuList, child));
				}
				childrens.add(children);
			}
		}
		return childrens;
	}
	
	/**
	 * 获取所有子菜单信息
	 * @return
	 */
	public JSONObject getAllMenuListForJSONObject(){
		
		Map<String, List<Menu>> mapMenuList = group(new String[]{"menuParentId"}, userDao.getAllMenuList());
		
		JSONObject root = new JSONObject();
		
		JSONArray childrens = new JSONArray();
		
		for(Menu menu : mapMenuList.get("0")){
			JSONObject child = new JSONObject();
			child.put("id", menu.getMenuId());
			child.put("text",menu.getMenuName());
			child.put("iconCls", menu.getMenuIcon());
			child.put("urlPath", menu.getMenuPath());
			child.put("expanded",true);
			child.put("children", findChildren(mapMenuList, menu));
			childrens.add(child);
		}
		root.put("children", childrens);
		return root;
	}
	/**
	 * 移动系统菜单
	 * @param nodeId
	 * @param targetId
	 * @return
	 */
	@Transactional
	public boolean moveMenuByNodeIdAndTargetId(int nodeId, int nextNodeId, int previousNodeId, int parentNodeId) {
		
		int result = 0;
		
		if(nextNodeId == 0 && previousNodeId == 0){
			result = userDao.updateMenuToChildNodeByNodeIdAndParentId(nodeId, parentNodeId == 0 ? null : parentNodeId);
		}else if(nextNodeId != 0 && previousNodeId == 0){
			result = userDao.updateMenuToPreviousNode(nodeId, nextNodeId, parentNodeId == 0 ? null : parentNodeId );
		}else if(nextNodeId == 0 && previousNodeId != 0){
			result = userDao.updateMenuToNextNode(nodeId, previousNodeId, parentNodeId == 0 ? null : parentNodeId);
		}else{
			result = userDao.updateMenuToPreviousNode(nodeId, nextNodeId, parentNodeId == 0 ? null : parentNodeId );
		}
		
		return result > 0;
	}
	
}
