package com.sun.user.model;

import java.io.Serializable;

public class Menu implements Serializable{

	/**
	 * @author Sun
	 * 菜单Model
	 */
	private static final long serialVersionUID = 4922697442180099959L;
	
	/**
	 * 菜单Id
	 */
	private int menuId;
	/**
	 * 菜单的名称
	 */
	private String menuName;
	/**
	 * 菜单的路径
	 */
	private String menuPath;
	/**
	 * 菜单的图标
	 */
	private String menuIcon;
	/**
	 * 菜单的顺序
	 */
	private int menuSort;
	/**
	 * 菜单的父级Id
	 */
	private int menuParentId;
	/**
	 * 菜单的所属权限
	 */
	private int roleId;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPath() {
		return menuPath;
	}
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}
	public int getMenuSort() {
		return menuSort;
	}
	public void setMenuSort(int menuSort) {
		this.menuSort = menuSort;
	}
	public int getMenuParentId() {
		return menuParentId;
	}
	public void setMenuParentId(int menuParentId) {
		this.menuParentId = menuParentId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
