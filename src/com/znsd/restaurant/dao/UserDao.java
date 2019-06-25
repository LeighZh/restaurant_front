package com.znsd.restaurant.dao;

import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.bean.UserBean;

import java.util.List;

public interface UserDao {
	public boolean userLogin(String name, String password);

	public boolean register(UserBean userBean);

	public void updata(String name, String password);

	public boolean delete(UserBean userBean);

	public boolean afterRegister(String name, String password);

	public List<RecordBean> queryRecord(String name, int start, int pageCount);

	public int getRecordCount(String name);

	public void recordRemove(String record);

	public List<UserBean> afterQuery(int start, int pageSize);
	
	public List<UserBean> likeAfterQuery(String likeName);
	
	public int afterUserCount();
	
	public int likeAfterCount(String name);
}
