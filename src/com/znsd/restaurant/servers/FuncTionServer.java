package com.znsd.restaurant.servers;

import com.znsd.restaurant.bean.AuthorityBean;

import java.util.ArrayList;

public interface FuncTionServer {
	public ArrayList<AuthorityBean> select(String name);
}
