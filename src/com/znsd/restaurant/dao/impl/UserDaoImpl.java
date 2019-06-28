package com.znsd.restaurant.dao.impl;

import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.bean.UserBean;
import com.znsd.restaurant.dao.DBUtils;
import com.znsd.restaurant.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

	@Override
	//用户名密码正确登录判断over
	public boolean userLogin(String name,String password) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		PreparedStatement prepareTwo = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("select loginName from user where loginName=? and loginPwd=?");
			prepare.setString(1, name);
			prepare.setString(2, password);
			query = prepare.executeQuery();
			if(query.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean register(UserBean userBean){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		PreparedStatement prepareTwo = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("select loginName from user where loginName=?");
			prepare.setString(1, userBean.getLoginName());
			query = prepare.executeQuery();
			if(query.next()){
				return true;
			}
			prepareTwo = connection.prepareStatement("INSERT INTO user(loginName,loginPwd,trueName,email,phone,address,money) VALUES(?,?,?,?,?,?,?)");
			prepareTwo.setString(1, userBean.getLoginName());
			prepareTwo.setString(2, userBean.getLoginPwd());
			prepareTwo.setString(3, userBean.getTrueName());
			prepareTwo.setString(4, userBean.getEmail());
			prepareTwo.setString(5, userBean.getPhone());
			prepareTwo.setString(6, userBean.getAddress());
			prepareTwo.setDouble(7, 0);
			prepareTwo.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(prepareTwo!=null)
					prepareTwo.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public void updata(String name,String password){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		try {
			prepare = connection.prepareStatement("UPDATE user SET loginPwd = ? WHERE loginName=?");
			prepare.setString(2, name);
			prepare.setString(1, password);
			prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean delete(UserBean userBean){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		PreparedStatement prepareTwo = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("select userName FROM USER WHERE userName =? AND PASSWORD = ? AND number = ? and sign='正常'");
			prepare.setString(1, userBean.getLoginName());
			prepare.setString(2, userBean.getLoginPwd());
			prepare.setLong(3, userBean.getId());
			query = prepare.executeQuery();
			if(query.next()){
				prepareTwo = connection.prepareStatement("UPDATE USER SET sign = '已删除'  WHERE userName=?");
				prepareTwo.setString(1, userBean.getLoginName());
				prepareTwo.execute();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(prepareTwo!=null)
					prepareTwo.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean afterRegister(String name,String password){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
//		try {
//			prepare = connection.prepareStatement("select userName from user where userName=? and password=? and sign='正常' AND (SELECT roleId FROM user_role WHERE userId in (SELECT userId FROM USER WHERE userName = ?))!=1");
//			prepare.setString(1, name);
//			prepare.setString(2, password);
//			prepare.setString(3, name);
//			query = prepare.executeQuery();
//			if(query.next()){
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally{
//			try {
//				if(query!=null)
//					query.close();
//				if(prepare!=null)
//					prepare.close();
//				if(connection!=null)
//					connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return false;
	}

	public List<RecordBean> queryRecord(String name,int start,int pageCount){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("SELECT userName,consumptionTime,consumptionMoney,recordId FROM record WHERE userName = ? AND SIGN = '正常' order by consumptionTime desc limit ?,?");
			prepare.setString(1, name);
			prepare.setInt(2, start);
			prepare.setInt(3, pageCount);
			query = prepare.executeQuery();
			List<RecordBean> list = new ArrayList<RecordBean>();
			while(query.next()){
				list.add(new RecordBean(query.getInt(4),query.getString(1), query.getDouble(3),query.getTimestamp(2).toString()));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int getRecordCount(String name){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("SELECT count(1) FROM record WHERE userName = ? AND SIGN = '正常';");
			prepare.setString(1, name);
			query = prepare.executeQuery();
			while(query.next()){
				return query.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public void recordRemove(String record){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		try {
			prepare = connection.prepareStatement("UPDATE record SET SIGN = '用户删除'  WHERE recordId IN ("+record+")");
			prepare.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<UserBean> afterQuery(int start,int pageSize){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("SELECT userName,createTime,lastTime,number,(SELECT SUM(consumptionMoney) FROM record WHERE userName=a.userName),sign FROM USER a limit ?,?");
			prepare.setInt(1, start);
			prepare.setInt(2, pageSize);
			query = prepare.executeQuery();
			List<UserBean> list = new ArrayList<UserBean>();
			while(query.next()){
				//list.add(new UserBean(query.getString(1),query.getTimestamp(2).toString(),query.getTimestamp(3).toString(),query.getLong(4),query.getDouble(5),query.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<UserBean> likeAfterQuery(String likeName){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("SELECT userName,createTime,lastTime,number,(SELECT SUM(consumptionMoney) FROM record WHERE userName=a.userName),sign FROM USER a where a.userName like ?");
			prepare.setString(1, likeName+"%");
			query = prepare.executeQuery();
			List<UserBean> list = new ArrayList<UserBean>();
			while(query.next()){
				//list.add(new UserBean(query.getString(1),query.getTimestamp(2).toString(),query.getTimestamp(3).toString(),query.getLong(4),query.getDouble(5),query.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public int afterUserCount(){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("select count(1) from user");
			query = prepare.executeQuery();
			while(query.next()){
				return query.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int likeAfterCount(String name){
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
		try {
			prepare = connection.prepareStatement("select count(1) from user where userName = ?");
			prepare.setString(1, name);
			query = prepare.executeQuery();
			while(query.next()){
				return query.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(query!=null)
					query.close();
				if(prepare!=null)
					prepare.close();
				if(connection!=null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
