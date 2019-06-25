package com.znsd.restaurant.dao.impl;

import com.znsd.restaurant.bean.MenuBean;
import com.znsd.restaurant.dao.DBUtils;
import com.znsd.restaurant.dao.MenuDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl extends DBUtils implements MenuDao {

	@Override
	public String add(MenuBean ben) {
		// TODO Auto-generated method stub
		Connection connection = DBUtils.getConnection();
		PreparedStatement pre=null;
		String sql2="select vegetableId from vegetabletype where vegetableName=?";
		String sql="insert into menu(menuName,price,vegetableId,picture,addTime,menuType,sign,descripment) values(?,?,?,'img/3.jpg',Now(),?,'正常',?)";
		try {
			pre=connection.prepareStatement(sql2);
			pre.setString(1,ben.getVegetableName());
			ResultSet res=pre.executeQuery();
			int name=0;
			while(res.next()){
				System.out.println(res.getInt(1)+"..0.0...");
				name=res.getInt(1);
			}
			pre=connection.prepareStatement(sql);
			pre.setString(1,ben.getMenuName());
			pre.setDouble(2,ben.getPrice());
			pre.setInt(3,name);
			pre.setString(4,ben.getMenuType());
			pre.setString(5,ben.getDescribe());
			pre.execute();
			System.out.println("[][][][][][][]");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("报错");
		}
		return null;
	}

	@Override
	public void delete(String data) {
		Connection connection = DBUtils.getConnection();
		PreparedStatement prepare = null;
		try {
			
			prepare = connection.prepareStatement("UPDATE menu SET SIGN = '删除'  WHERE menuid IN ("+data+")");
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

	@Override
	public List<MenuBean> query(int start,int pageSize) {
		Connection connection=DBUtils.getConnection();
		String sql="SELECT menu.*,vegetabletype.vegetableName FROM menu,vegetabletype WHERE menu.sign='正常' AND menu.vegetableId = vegetabletype.vegetableId ORDER BY menu.addTime LIMIT ?,?";
		PreparedStatement prepare=null;
		List<MenuBean> list=new ArrayList<MenuBean>();
//		try {
//			prepare=connection.prepareStatement(sql);
//			prepare.setInt(1, start);
//			prepare.setInt(2, pageSize);
//			ResultSet res=prepare.executeQuery();
//			while(res.next()){
//				list.add(new MenuBean(res.getInt(1),res.getString(2),res.getDouble(3),res.getString(14),res.getString(5),res.getInt(6),res.getInt(7),res.getInt(8),res.getInt(9),res.getTimestamp(10),res.getString(11),res.getString(13)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return list;
	}
	@Override
	public void mod(String name,int id) {
		Connection con = getConnection();
		String sql="select vegetableId from vegetabletype where vegetableName=?";
		String sql2="update menu set vegetableId=? where menuId=?";
		PreparedStatement pr =null;
		ResultSet ex = null;
		int id2=666;
		try {
			pr=con.prepareStatement(sql);
			pr.setString(1,name);
			ex=pr.executeQuery();
			while(ex.next()){
				id2=ex.getInt(1);
			}
			pr=con.prepareStatement(sql2);
			pr.setInt(1,id2);
			pr.setInt(2,id);
			pr.execute();
			System.out.println("成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String select(String line,String pageSize,int first) {
		Connection con = getConnection();
		PreparedStatement pr =null;
		ResultSet ex = null;
		String[] st = line.split(",");
		String tab = "[";
		 try {
			 pr= con.prepareStatement("SELECT menuid,menuName,price,vegetableName,userCount,good,general,bad,menu.ADDTIME,menuType FROM menu,vegetabletype WHERE menu.vegetableId = vegetabletype.vegetableId AND menu.sign='正常' ORDER BY menu.ADDTIME LIMIT ?,?");
			 pr.setObject(1,first);
			 pr.setObject(2, Integer.parseInt(pageSize));
			 ex = pr.executeQuery();
			 while(ex.next()){
				 tab+="{\""+st[0]+"\":\""+ex.getObject(1)+"\",\""+st[1]+"\":\""+ex.getObject(2)+"\",\""+st[2]+"\":\""+ex.getObject(3)+"\",\""+st[3]+"\":\""+ex.getObject(4)+"\",\""+st[4]+
						"\":\""+ex.getObject(5)+
						"\",\""+st[5]+"\":\""+ex.getObject(6)+"\",\""+st[6]+"\":\""+ex.getObject(7)+"\",\""
						+st[7]+"\":\""+ex.getObject(8)+"\",\""+st[8]+"\":\""+ex.getObject(9)+"\",\""+st[9]+"\":\""+ex.getObject(10)+"\"},";
			 }
			 tab = tab.substring(0,tab.length()-1);
			 if(!"".equals(tab)){
				 tab+="]"; 
			 }
			 return tab;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ex!=null)
					ex.close();
				if(pr!=null)
					pr.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count() {
		Connection con = getConnection();
		PreparedStatement pr =null;
		ResultSet ex = null;
//		 try {
//			 pr= con.prepareStatement("SELECT count(1) FROM menu where sign='正常'");
//			 ex = pr.executeQuery();
//			 ex.next();
//			 return ex.getInt(1);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//				if(ex!=null)
//					ex.close();
//				if(pr!=null)
//					pr.close();
//				if(con!=null)
//					con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return 0;
	}

	@Override
	public void Typealter(String usName,String id) {
		Connection con = getConnection();
		PreparedStatement pr =null;
		 try {
			 pr = con.prepareStatement("UPDATE vegetabletype SET vegetablename=? WHERE vegetableId=?");
			 pr.setObject(1,usName);
			 pr.setObject(2,Integer.parseInt(id));
			 pr.execute();
		} catch (SQLException e){
			e.printStackTrace();
		}finally{
			try {
				if(pr!=null)
					pr.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
