package com.znsd.restaurant.servers.impl;

import com.znsd.restaurant.bean.AuthorityBean;
import com.znsd.restaurant.dao.TreeDao;
import com.znsd.restaurant.dao.impl.TreeDaoImpl;
import com.znsd.restaurant.servers.TreeService;

import java.util.List;

public class TreeServiceImpl implements TreeService{

	private TreeDao treeDao = new TreeDaoImpl();
	@Override
	public List<AuthorityBean> queryAuthority(String name) {
		return treeDao.queryAuthority(name);
	}
	
}
