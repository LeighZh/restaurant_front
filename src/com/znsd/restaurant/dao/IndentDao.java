package com.znsd.restaurant.dao;

import com.znsd.restaurant.bean.IndentBean;

import java.util.List;

/**
**oyb
**2018年7月27日
**/
public interface IndentDao {

	List<IndentBean> main(String userName, String page, String pageSize);

	String count(String userName);

	void delete(String id, String name, String money);

	void cancel(String id);

	List<IndentBean> main2(String name, String page, String pageSize);

	String count();

}
