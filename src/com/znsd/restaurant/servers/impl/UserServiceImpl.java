package com.znsd.restaurant.servers.impl;

import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.bean.UserBean;
import com.znsd.restaurant.dao.UserDao;
import com.znsd.restaurant.dao.impl.UserDaoImpl;
import com.znsd.restaurant.servers.UserService;

import java.util.List;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl();
	@Override
	public boolean loginJudge(String name,String password) {
		return userDao.userLogin(name, password);
	}
	@Override
	public boolean register(UserBean userBean) {
		return userDao.register(userBean);
	}
	@Override
	public void updata(String name, String password) {
		userDao.updata(name, password);
	}
	@Override
	public boolean delete(UserBean userBean) {
		return userDao.delete(userBean);
	}
	@Override
	public boolean afterRegister(String name, String password) {
		return userDao.afterRegister(name, password);
	}

	public List<RecordBean> queryRecord(String name,int begin,int pageCount){
		return userDao.queryRecord(name,begin,pageCount);
	}
	
	public int getRecordCount(String name){
		return userDao.getRecordCount(name);
	}
	
	
	public void recordRemove(String record){
		userDao.recordRemove(record);
	}
	
	public List<UserBean> afterQuery(int start,int pageSize){
		return userDao.afterQuery(start,pageSize);
	}
	
	public List<UserBean> likeAfterQuery(String likeName){
		return userDao.likeAfterQuery(likeName);
	}
	
	public int afterUserCount(){
		return userDao.afterUserCount();
	}
	
	public int likeAfterCount(String name){
		return userDao.likeAfterCount(name);
	}
}
