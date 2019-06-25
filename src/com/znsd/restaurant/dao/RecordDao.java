package com.znsd.restaurant.dao;

import com.znsd.restaurant.bean.RecordBean;

import java.util.List;

public interface RecordDao {

	List<RecordBean> likeQuery(int start, int pageSize, String name);

	int getCount();

	int likeCount(String name);

	void Deskdelete(String record);

	List<RecordBean> consumptionQuery(int start, int pageSize);

	String select(String line, String pageSize, int first);

}
