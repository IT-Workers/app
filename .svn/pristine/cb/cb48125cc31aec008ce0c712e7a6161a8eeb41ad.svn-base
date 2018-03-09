package com.sun.user.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sun.common.dao.CommonDao;
import com.sun.user.model.Menu;

@Component("userDao")
public class UserDao extends CommonDao{

	/**
	 * 根据角色获取菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> getMenuListByRoleId(int roleId){
		return jdbcTemplate.queryForList("select * from menu where roleId = ? order by menuSort", Menu.class, roleId);
	}
	
	/**
	 * 获取所有菜单信息
	 * @return
	 */
	public List<Menu> getAllMenuList(){
		return jdbcTemplate.queryForList("select * from menu order by menuSort", Menu.class);
	}
	
	/**
	 * 修改节点为子节点
	 * @param nodeId
	 * @param parentNodeId
	 * @return
	 */
	public int updateMenuToChildNodeByNodeIdAndParentId(int nodeId, Integer parentNodeId) {
		return jdbcTemplate.update("update menu set menuParentId = ?, menuSort = ? where menuId = ? ", parentNodeId, 1, nodeId);
	}
	
	/**
	 * 修改菜单为上面的兄弟节点
	 * @param nodeId
	 * @param nextNodeId
	 * @param parentNodeId
	 * @return
	 */
	public int updateMenuToPreviousNode(int nodeId, int nextNodeId, Integer parentNodeId) {
		String sql = "update "+
				"menu n, menu t, menu c "+
			"set  "+
				"n.menuParentId = ?,  "+
				"t.menuParentId = ?,  "+
				"n.menuSort = t.menuSort," +
				"c.menuSort = c.menuSort + 1 "+ 
			"where  "+
				"n.menuId = ? "+
			"and  "+
				"t.menuId = ? " +
			"and " +
				"(c.menuParentId = t.menuParentId or c.menuParentId is null ) and c.menuSort >= t.menuSort";

		return jdbcTemplate.update(sql,parentNodeId, parentNodeId, nodeId, nextNodeId);
	}
	
	/**
	 * 修改菜单为下面的兄弟节点
	 * @param nodeId
	 * @param previousNodeId
	 * @param parentNodeId
	 * @return
	 */
	public int updateMenuToNextNode(int nodeId, int previousNodeId, Integer parentNodeId) {
		
		String sql = "update "+
				"menu n, menu t "+
			"set  "+
				"n.menuParentId = ?,  "+
				"t.menuParentId = ?,  "+
				"n.menuSort = t.menuSort + 1 " +
			"where  "+
				"n.menuId = ? "+
			"and  "+
				"t.menuId = ? ";
		
		return jdbcTemplate.update(sql,parentNodeId, parentNodeId, nodeId, previousNodeId);
	}
	
}
