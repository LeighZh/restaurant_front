package com.znsd.restaurant.servers.impl;

import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.dao.RecordDao;
import com.znsd.restaurant.dao.impl.RecordDaoImpl;
import com.znsd.restaurant.servers.RecordService;

import java.util.List;

public class RecordServiceImpl implements RecordService{
	
	private RecordDao recordDao = new RecordDaoImpl();
	@Override
	public String select(String line, String pageSize, int first) {
		return recordDao.select(line, pageSize, first);
	}
	
	public List<RecordBean> consumptionQuery(int start,int pageSize){
		return recordDao.consumptionQuery(start, pageSize);
	}
	
	public void delete(String data){
		recordDao.Deskdelete(data);
	}
	
	public List<RecordBean> likeQuery(int start,int pageSize,String name){
		return recordDao.likeQuery(start, pageSize, name);
	}
	
	public int getCount(){
		return recordDao.getCount();
	}
	
	public int likeCount(String name){
		return recordDao.likeCount(name);
	}

	public void Deskdelete(String record) {
		recordDao.Deskdelete(record);
	}

}
