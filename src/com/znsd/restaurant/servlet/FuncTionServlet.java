package com.znsd.restaurant.servlet;

import com.alibaba.fastjson.JSON;
import com.znsd.restaurant.bean.AuthorityBean;
import com.znsd.restaurant.servers.impl.FuncTionServerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class FuncTionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appliaction/JSON;charsex=UTF-8");
		String name = (String)request.getSession().getAttribute("name");
		ArrayList<AuthorityBean> select = new FuncTionServerImpl().select(name);
		String json = JSON.toJSONString(select);
		/*System.out.println("\"children\":"+json);*/
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
