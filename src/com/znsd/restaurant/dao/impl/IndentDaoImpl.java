package com.znsd.restaurant.dao.impl;

import com.znsd.restaurant.bean.IndentBean;
import com.znsd.restaurant.dao.DBUtils;
import com.znsd.restaurant.dao.IndentDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
**oyb
**2018年7月27日
**/
public class IndentDaoImpl implements IndentDao {

	@Override
	public List<IndentBean> main(String userName,String page, String pageSize) {
		// TODO Auto-generated method stub
		int first = (Integer.parseInt(page)-1)*Integer.parseInt(pageSize);
		Connection conn = DBUtils.getConnection();
		Statement sta = null;
		List<IndentBean> list =null ;
		try {
			sta = conn.createStatement();
			ResultSet res =sta.executeQuery("SELECT * FROM indent where userName="+userName+" AND SIGN = '正常' LIMIT "+first+","+pageSize);
			list = new ArrayList<IndentBean>();
			while(res.next()){
				list.add(new IndentBean(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String count(String userName) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		Statement sta = null;
		ResultSet res2=null;
		String count="";
//		try {
//			sta = conn.createStatement();
//			res2 = sta.executeQuery("SELECT COUNT(*) FROM indent where userName="+userName+" AND SIGN = '正常'");
//			while(res2.next()){
//				count= res2.getString(1);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return count;
	}

	@Override
	public void delete(String id, String name, String money) {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		Statement sta = null;
		try {
			sta = conn.createStatement();
			System.out.println("INSERT INTO record(userName,consumptionTime,consumptionMoney) VALUE("+name+",NOW(),"+money+");");
			sta.execute("UPDATE indent SET STATUS='已结账'  WHERE indentId="+id);
			sta.execute("INSERT INTO record(userName,consumptionTime,consumptionMoney) VALUE("+name+",NOW(),"+money+");");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void cancel(String id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		Statement sta = null;
		try {
			sta = conn.createStatement();
			sta.execute("UPDATE indent SET STATUS='已取消'  WHERE indentId="+id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<IndentBean> main2(String name, String page, String pageSize) {
		// TODO Auto-generated method stub
		int first = (Integer.parseInt(page)-1)*Integer.parseInt(pageSize);
		Connection conn = DBUtils.getConnection();
		Statement sta = null;
		List<IndentBean> list =null ;
		try {
			sta = conn.createStatement();
			ResultSet res =sta.executeQuery("SELECT * FROM indent LIMIT "+first+","+pageSize);
			list = new ArrayList<IndentBean>();
			while(res.next()){
				list.add(new IndentBean(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getDouble(7)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		Connection conn = DBUtils.getConnection();
		Statement sta = null;
		ResultSet res2=null;
		String count="";
		try {
			sta = conn.createStatement();
			res2 = sta.executeQuery("SELECT COUNT(*) FROM indent");
			while(res2.next()){
				count= res2.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}
