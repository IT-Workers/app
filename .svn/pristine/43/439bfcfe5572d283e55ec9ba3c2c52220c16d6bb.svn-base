package com.sun.common.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonService {

	/**
	 * 根据字段分组
	 * @param fields
	 * @param list
	 * @return
	 */
	protected static <T> Map<String, List<T>> group(String [] fields, List<T> list){
		
		Map<String, List<T>> result = new LinkedHashMap<String, List<T>>();
		
		if(list == null) return result;
		 
		List<T> grouplist = null;
		
		for(T item : list){
			
			String key = groupKey(fields, item);
			
			grouplist = result.get(key);
			
			if(grouplist == null){
				grouplist = new ArrayList<T>();
				result.put(key, grouplist);
			}
			
			grouplist.add(item);
		}
		
		return result;
	}
	
	/**
	 * 获取字段的值
	 * @param fields
	 * @param t
	 * @return
	 */
	private static <T> String groupKey(String [] fields, T t){
		String value = "";
		for(String field : fields){
			for(Method method : t.getClass().getDeclaredMethods()){
				if(method.getName().equalsIgnoreCase( "get" + field)){
					try {
						value +=  method.invoke(t, new Object[]{});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return value;
	}	
}
