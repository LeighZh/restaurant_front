package com.znsd.restaurant.servlet;

import com.alibaba.fastjson.JSON;
import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.bean.UserBean;
import com.znsd.restaurant.servers.UserService;
import com.znsd.restaurant.servers.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appliaction/JSON;charsex=UTF-8");
		String judge = request.getParameter("judge");
		UserService userServlet = new UserServiceImpl();
		if(judge.equals("login")){
			this.login(request, response, userServlet);
		}else if(judge.equals("register")){
			this.register(request, response, userServlet);
		}else if(judge.equals("update")){
			this.updata(request, response, userServlet);
		}else if(judge.equals("delete")){
			this.delete(request, response, userServlet);
		}else if(judge.equals("afterRegister")){
			this.afterRegister(request, response, userServlet);
		}else if(judge.equals("record")){
			this.queryRecord(request, response, userServlet);
		}else if(judge.equals("recrodDelete")){
			this.recordRemove(request, response, userServlet);
		}else if(judge.equals("afterQuery")){
			this.afterQuery(request, response, userServlet);
		}else if(judge.equals("likeAfterQuery")){
			this.afterLikeQuery(request, response, userServlet);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String name = request.getParameter("loginName");
		String password = request.getParameter("loginPwd");
		boolean loginJudge = userServlet.loginJudge(name,password);
		if(loginJudge){
			request.getSession().setAttribute("loginName", name);
		}
		try {
			response.getWriter().print(JSON.toJSONString(loginJudge));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String trueName = request.getParameter("trueName");
		System.out.println(trueName);
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		UserBean userBean = new UserBean(loginName, loginPwd, trueName, email, phone, address);
		boolean register = userServlet.register(userBean);
		if(register!=true){
			request.getSession().setAttribute("loginName", loginName);
		}
		try {
			response.getWriter().print(JSON.toJSONString(register));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updata(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		userServlet.updata(name, password);
		request.getSession().removeAttribute("userName");
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String number = request.getParameter("number");
		long lon = Long.parseLong(number);
		//UserBean userBean = new UserBean(name,password,lon);
		//boolean register = userServlet.delete(userBean);
		/*if(register==true){
			request.getSession().removeAttribute("userName");
		}
		try {
			response.getWriter().print(JSON.toJSONString(register));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void afterRegister(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		boolean afterRegister = userServlet.afterRegister(name, password);
		if(afterRegister){
			request.getSession().setAttribute("name", name);
		}
		try {
			response.getWriter().print(JSON.toJSONString(afterRegister));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void queryRecord(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String name = (String)request.getSession().getAttribute("userName");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int start = (Integer.parseInt(page)-1)*Integer.parseInt(rows);
		List<RecordBean> query = userServlet.queryRecord(name,start,Integer.parseInt(rows));
		String jsonString = JSON.toJSONString(query);
		try {
			int recordCount = userServlet.getRecordCount(name);
			response.getWriter().write("{\"total\":"+recordCount+",\"rows\":"+jsonString+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void recordRemove(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String record = request.getParameter("data");
		if(record!=null && record!=""){
			userServlet.recordRemove(record);
		}
	}
	
	public void afterQuery(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int start = (Integer.parseInt(page)-1)*Integer.parseInt(rows);
		List<UserBean> query = userServlet.afterQuery(start,Integer.parseInt(rows));
		try {
			int afterUserCount = userServlet.afterUserCount();
			response.getWriter().print("{\"total\":"+afterUserCount+",\"rows\":"+JSON.toJSONString(query)+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void afterLikeQuery(HttpServletRequest request, HttpServletResponse response,UserService userServlet){
		String likeName = request.getParameter("likeName");
		if(likeName == null ||likeName.equals("")){
			this.afterQuery(request, response, userServlet);
			return;
		}
		List<UserBean> likeAfterQuery = userServlet.likeAfterQuery(likeName);
		try {
			int likeAfterCount = userServlet.likeAfterCount(likeName);
			response.getWriter().print("{\"total\":"+likeAfterCount+",\"rows\":"+JSON.toJSONString(likeAfterQuery)+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
