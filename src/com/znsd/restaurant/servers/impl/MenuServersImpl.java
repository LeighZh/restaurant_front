package com.znsd.restaurant.servers.impl;

import com.znsd.restaurant.bean.MenuBean;
import com.znsd.restaurant.dao.MenuDao;
import com.znsd.restaurant.dao.impl.MenuDaoImpl;
import com.znsd.restaurant.servers.MenuServers;

import java.util.List;

public class MenuServersImpl implements MenuServers{
	@Override
	public String select(String line, String pageSize, int first) {
		// TODO Auto-generated method stub
		return menu.select(line, pageSize, first);
	}

	private MenuDao menu=new MenuDaoImpl();
	@Override
	public String add(MenuBean ben) {
		// TODO Auto-generated method stub
		return menu.add(ben);
	}

	@Override
	public void delete(String name) {
		menu.delete(name);
	}

	@Override
	public List<MenuBean> query(int start,int pageSize) {
		// TODO Auto-generated method stub
		return menu.query(start,pageSize);
	}

	@Override
	public void mod(String name,int id) {
		// TODO Auto-generated method stub
		menu.mod(name, id);
	}

	public int count() {
		return menu.count();
	}
	
	public int getCount(){
		return menu.count();
	}

	public void Typealter(String usName, String id) {
		 menu.Typealter(usName, id);
	}
}
