package com.znsd.restaurant.servers;

import com.znsd.restaurant.bean.RecordBean;

import java.util.List;

public interface RecordServers {

	Integer count();

	List<RecordBean> select(int start, int sss);

}
