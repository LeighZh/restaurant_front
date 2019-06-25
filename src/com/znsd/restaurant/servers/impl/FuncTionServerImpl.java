package com.znsd.restaurant.servers.impl;

import com.znsd.restaurant.bean.AuthorityBean;
import com.znsd.restaurant.dao.impl.FuncTionDaoImpl;
import com.znsd.restaurant.servers.FuncTionServer;

import java.util.ArrayList;

public class FuncTionServerImpl implements FuncTionServer{
	
	public ArrayList<AuthorityBean> select(String name){
		return new FuncTionDaoImpl().select(name);
	}
}
