package com.znsd.restaurant.servers;

import com.znsd.restaurant.bean.AuthorityBean;

import java.util.List;

public interface TreeService {
	public List<AuthorityBean> queryAuthority(String name);
}
