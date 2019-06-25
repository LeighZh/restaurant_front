package com.znsd.restaurant.dao.impl;

import com.znsd.restaurant.bean.AuthorityBean;
import com.znsd.restaurant.dao.DBUtils;
import com.znsd.restaurant.dao.TreeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TreeDaoImpl implements TreeDao{

	@Override
	public List<AuthorityBean> queryAuthority(String name) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		ResultSet query = null;
//		try {
//			prepare = connection.prepareStatement("SELECT authorityName FROM authorityTwo WHERE authorityId IN(SELECT authority FROM role_authority WHERE roleId IN	(SELECT roleId FROM user_role WHERE userId = (SELECT userId FROM USER WHERE userName = ? AND SIGN = '正常')))");
//			prepare.setString(1, name);
//			query = prepare.executeQuery();
//			List<AuthorityBean> list = new ArrayList<AuthorityBean>();
//			while(query.next()){
//				list.add(new AuthorityBean(query.getString(1)));
//			}
//			return list;
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
		return null;
	}

}
