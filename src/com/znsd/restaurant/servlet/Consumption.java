package com.znsd.restaurant.servlet;

import com.alibaba.fastjson.JSON;
import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.servers.RecordService;
import com.znsd.restaurant.servers.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Consumption extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appliaction/JSON;charsex=UTF-8");
		String judge = request.getParameter("judge");
		RecordService recordService = new RecordServiceImpl();
		if(judge.equals("query")){
			this.consumptionQuery(request, response, recordService);
		}else if(judge.equals("delete")){
			this.delete(request, response, recordService);
		}else if(judge.equals("likeQuery")){
			this.likeQuery(request, response, recordService);
		}else if(judge.equals("Deskdelete")){
			this.Deskdelete(request, response, recordService);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void Deskdelete(HttpServletRequest request, HttpServletResponse response,RecordService recordService){
		String record = request.getParameter("data");
		if(record!=null && record!=""){
			recordService.Deskdelete(record);
		}
	}

	public void consumptionQuery(HttpServletRequest request, HttpServletResponse response,RecordService recordService){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int start = (Integer.parseInt(page)-1)*Integer.parseInt(rows);
		List<RecordBean> list = recordService.consumptionQuery(start, Integer.parseInt(rows));
		int count = recordService.getCount();
		try {
			response.getWriter().print("{\"total\":"+count+",\"rows\":"+JSON.toJSONString(list)+"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(HttpServletRequest request, HttpServletResponse response,RecordService recordService){
		String record = request.getParameter("data");
		if(record!=null && record!=""){
			recordService.delete(record);
		}
	}
	
	public void likeQuery(HttpServletRequest request, HttpServletResponse response,RecordService recordService){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String likeName = request.getParameter("likeName");
		if(likeName == null || likeName.equals("")){
			consumptionQuery(request,response,recordService);
			return ;
		}
		int start = (Integer.parseInt(page)-1)*Integer.parseInt(rows);
		List<RecordBean> likeQuery = recordService.likeQuery(start, Integer.parseInt(rows), likeName);
		int likeCount = recordService.likeCount(likeName);
		try {
			response.getWriter().print("{\"total\":"+likeCount+",\"rows\":"+JSON.toJSONString(likeQuery)+"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
