package com.sun.user.model;

import java.io.Serializable;

public class Department implements Serializable{

	/**
	 * @author Sun
	 * 部门Model
	 */
	private static final long serialVersionUID = -8250934150402939453L;
	
	/**
	 * ID
	 */
	private int departmentId;
	/**
	 * 编号
	 */
	private String departmentNo;
	/**
	 * 名称
	 */
	private String departmentName;
	/**
	 * 图标
	 */
	private String departmentIcon;
	/**
	 * 上级部门ID
	 */
	private int departmentParentId;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentIcon() {
		return departmentIcon;
	}
	public void setDepartmentIcon(String departmentIcon) {
		this.departmentIcon = departmentIcon;
	}
	public int getDepartmentParentId() {
		return departmentParentId;
	}
	public void setDepartmentParentId(int departmentParentId) {
		this.departmentParentId = departmentParentId;
	}
	
}
