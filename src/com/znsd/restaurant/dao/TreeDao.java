package com.znsd.restaurant.dao;

import com.znsd.restaurant.bean.AuthorityBean;

import java.util.List;

public interface TreeDao {
	public List<AuthorityBean> queryAuthority(String name);
}
