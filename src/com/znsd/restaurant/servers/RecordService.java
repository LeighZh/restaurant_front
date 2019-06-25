package com.znsd.restaurant.servers;

import com.znsd.restaurant.bean.RecordBean;

import java.util.List;

public interface RecordService {
	public String select(String line, String pageSize, int first);
	
	public List<RecordBean> consumptionQuery(int start, int pageSize);

	public void delete(String data);

	public List<RecordBean> likeQuery(int start, int pageSize, String name);
	
	public int getCount();
	
	public int likeCount(String name);

	public void Deskdelete(String record);

}
