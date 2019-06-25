package com.znsd.restaurant.servers;

import com.znsd.restaurant.bean.IndentBean;

import java.util.List;

/**
**oyb
**2018年7月27日
**/
public interface IndentServers {

	List<IndentBean> main(String userName, String page, String pageSize);

	String count(String name);

	void delete(String id, String name, String money);

	void cancel(String id);

	List<IndentBean> main2(String name, String page, String pageSize);

	String count2();

}
