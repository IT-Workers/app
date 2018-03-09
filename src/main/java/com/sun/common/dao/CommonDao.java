package com.sun.common.dao;

import javax.annotation.Resource;

import com.sun.common.jdbc.JdbcTemplate;


public abstract class CommonDao {
	
	@Resource protected JdbcTemplate jdbcTemplate;
	
}
