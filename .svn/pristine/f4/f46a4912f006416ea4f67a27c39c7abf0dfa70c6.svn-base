package com.sun.common.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author Sun
 * 抽象AbstractController 用户提供公共的方法
 */
public class AbstractController{
	
	
	@Resource protected HttpServletRequest request;

	@Resource protected HttpServletResponse response;
	
	/**
	 * @author Sun 
	 * @param json
	 * @param response
	 */
	protected void write(Object object){
		
		PrintWriter writer = null;
		try {
			response.setHeader("Content-type", "application/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			writer = response.getWriter();
			writer.print(JSON.toJSONString(object, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(writer != null){
				writer.close();
				writer = null;
			}
		}
	}

}
