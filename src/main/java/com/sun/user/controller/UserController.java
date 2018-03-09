package com.sun.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sun.common.controller.AbstractController;
import com.sun.user.service.UserService;

@RestController
@RequestMapping(path = "user")
public class UserController extends AbstractController{
	
	@Resource UserService userService;

	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping(path = "login")
	public void login() {
		write(userService.getUserMenuByRoleId(1));
	}
	/**
	 * 获取系统菜单
	 */
	@GetMapping(path = "menu/list")
	public void getMenuData(){
		write(userService.getAllMenuListForJSONObject());
	}
	/**
	 * 移动系统菜单
	 */
	@PostMapping(path = "menu/move")
	public void moveMenu(int nodeId, int nextNodeId, int previousNodeId, int parentNodeId){
		boolean result = userService.moveMenuByNodeIdAndTargetId(nodeId, nextNodeId, previousNodeId, parentNodeId);
		JSONObject obj = new JSONObject();
		obj.put("status", result);
		if(result){
			obj.put("message", "操作成功!");
			obj.put("code", 1);
		}else{
			obj.put("message", "操作失败请重试!");
			obj.put("code", -1);
		}
		
		write(obj);
	}
}
