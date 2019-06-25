package com.znsd.restaurant.servlet;

import com.znsd.restaurant.bean.RecordBean;
import com.znsd.restaurant.servers.RecordServers;
import com.znsd.restaurant.servers.impl.RecordServersImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class RecordServlet
 */
public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RecordServers rs=new RecordServersImpl();
			String select=request.getParameter("select");
			if(select.equals("query")){
				query(request,rs,response);
			}
		
	}
	public  static final int sss = 2;
	public void query(HttpServletRequest request,RecordServers rs,HttpServletResponse response) throws ServletException, IOException{
		String page = request.getParameter("page");
		int currentPage=1;
		
		if (page !=null && !page.equals("")){
			currentPage = Integer.parseInt(page);
		}
		int start = (currentPage - 1) * sss;
		Integer count = rs.count();
		double pageCount=Math.ceil(Double.parseDouble(count.toString())/ sss);
		
		List<RecordBean> li=rs.select(start, sss);
		request.setAttribute("re", li);
	
		request.setAttribute("page", currentPage);
		request.setAttribute("pageCount", pageCount);
		
		request.getRequestDispatcher("xxx.jsp").forward(request, response);
	}

}
