package com.znsd.restaurant.servlet;

import com.znsd.restaurant.dao.impl.EvaluateDaoImp;
import com.znsd.restaurant.servers.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class IndextSelectServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appliaction/JSON;charsex=UTF-8");
		String line = request.getParameter("line");
		String fame = request.getParameter("fame");
		String page = request.getParameter("page");//页数
		String pageSize = request.getParameter("rows");//一页多少个
		int count=0;
		int first = Integer.parseInt(pageSize)*(Integer.parseInt(page)-1);
		String select = null;
		if("订单查询".equals(fame)){
			 select = new IndextSelectServersImpl().select(line,pageSize,first);
			 count = new IndextSelectServersImpl().count();
		}else if("菜谱".equals(fame)){
			 select = new MenuServersImpl().select(line, pageSize, first);
			 count = new MenuServersImpl().count();
		}else if("菜系".equals(fame)){
			select = new VegetableTypeServiceImpl().select(line, pageSize, first);
			count = new VegetableTypeServiceImpl().count();
		}else if("类型".equals(fame)){
			select = new TypeServiceImpl().select(line, pageSize, first);
		}else if("消费记录".equals(fame)){
			select = new RecordServiceImpl().select(line, pageSize, first);
		}else if("用户评价查询".equals(fame)){
			 select = new EvaluateDaoImp().select(line, pageSize, first);
		}else if("用户查询".equals(fame)){
			select = new RearUserServersImpl().select(line, pageSize, first);
		}else if("订桌".equals(fame)){
			select = new ReviseDeskServersImpl().select(line, pageSize, first);
		}
		//System.out.println(select);
		response.getWriter().print("{\"total\":"+count+",\"rows\":"+select+"}");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
