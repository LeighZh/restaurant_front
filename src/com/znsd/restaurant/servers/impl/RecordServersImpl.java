package com.znsd.restaurant.servers.impl;

import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.dao.RecordDao;
import com.znsd.restaurant.dao.impl.RecordDaoImpl;
import com.znsd.restaurant.servers.RecordServers;

import java.util.List;

public class RecordServersImpl implements RecordServers{
	RecordDao rs=new RecordDaoImpl();

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> select(int start, int sss) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
