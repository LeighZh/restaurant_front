package com.znsd.restaurant.servlet;

import com.alibaba.fastjson.JSON;
import com.znsd.restaurant.bean.IndentBean;
import com.znsd.restaurant.servers.IndentServers;
import com.znsd.restaurant.servers.impl.IndentServersImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class IndentServlet
 */
public class IndentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appliaction/JSON;charsex=UTF-8");
		String mark = request.getParameter("mark");
		IndentServers ind = new IndentServersImpl();
		if(mark.equals("a")){
			String page = request.getParameter("page");
			String pageSize = request.getParameter("rows");
			String name = request.getParameter("userName");
			List<IndentBean> list = ind.main(name,page,pageSize);
			String count = (String) ind.count(name);
			response.getWriter().write("{\"total\":"+count+",\"rows\":"+JSON.toJSONString(list)+"}");
		}else if(mark.equals("delete")){
			String id = request.getParameter("indentId");
			String name = request.getParameter("userName");
			String money = request.getParameter("money");
 			ind.delete(id,name,money);
		}else if(mark.equals("cancel")){
			String id = request.getParameter("indentId");
			ind.cancel(id);
		}else if(mark.equals("b")){
			String page = request.getParameter("page");
			String pageSize = request.getParameter("rows");
			String name = request.getParameter("userName");
			List<IndentBean> list = ind.main2(name,page,pageSize);
			String count = (String) ind.count2();
			response.getWriter().write("{\"total\":"+count+",\"rows\":"+JSON.toJSONString(list)+"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
