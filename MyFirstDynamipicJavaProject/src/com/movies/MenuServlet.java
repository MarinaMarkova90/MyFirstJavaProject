package com.movies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Callservice;

/**
 * Servlet implementation class MenuServlet
 */
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String b_l = request.getParameter("load");
		String b_k = request.getParameter("button_kind");
		String b_a = request.getParameter("btn_add");
		String b_r = request.getParameter("button_report");
		String b_d = request.getParameter("button_delete");
		
		
		
		
		if (b_l != null) {
			
			HttpSession session=request.getSession(); 
			request.setAttribute("mess_txt", "You already prepared a database");
			
//			String load = (String)session.getAttribute("LoudDataBase");
			if(null == session.getAttribute("LoudDataBase")) {
				
			
//	        session.setAttribute("LoudDataBase", "1");  

			System.out.println("b_l");
			//извикване на сървиз със заявка за create за запис в таблицата ticket
			String call1 = "POST";
			String serverUrl1 = "http://localhost:8080/tickets";
			String description = "Umirai trudno 2 ";
			String kynd_movie = "movies";
			String jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			String rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
			System.out.println(rez1);
			 description = "Cougar";
			 kynd_movie = "movies";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
		
			 description = "Friends";
			 kynd_movie = "movies";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
			 
			 description = "FearFactor";
			 kynd_movie = "reality";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
		
			 description = "BigBrother";
			 kynd_movie = "reality";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
			 
			 description = "DancingStars";
			 kynd_movie = "reality";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
		
			 description = "Mikey Mouse";
			 kynd_movie = "kinder";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
		
			 description = "Tom and Jerry";
			 kynd_movie = "kinder";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
		
			 description = "Bears";
			 kynd_movie = "kinder";
			 jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket
//		
			  call1 = "POST";
		      serverUrl1 = "http://localhost:8080/tickets/1/comments"; 
			 String bodyComment = "{\"text\":\"Na vseki kilometar\",\"aname\":\"Blank\", \"nacionality\":\"usa\" }";
			 rez1 = Callservice.callMethod(call1, serverUrl1, bodyComment);
			 
			  serverUrl1 = "http://localhost:8080/tickets/1/comments"; 
				 bodyComment = "{\"text\":\"None\",\"aname\":\"Mathue Perry\", \"nacionality\":\"usa\" }";
				 rez1 = Callservice.callMethod(call1, serverUrl1, bodyComment);
			 
				  serverUrl1 = "http://localhost:8080/tickets/2/comments"; 
					 bodyComment = "{\"text\":\"Joe\",\"aname\":\"Leblank\", \"nacionality\":\"usa\" }";
					 rez1 = Callservice.callMethod(call1, serverUrl1, bodyComment);
				 
			 
//			 HttpSession session=request.getSession();  
		        session.setAttribute("LoudDataBase", "1");  
		        
		        
		   
		        
		        request.setAttribute("mess_txt", "Success prepare data!");
				
		        
		        
			}
			 
			 
			 
			 
//			request.setAttribute("mess_txt", "Success prepare data!");
//			
			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("menu.jsp");
			dispatcher1.forward(request, response);
			
//			response.setContentType("text/html; charset=ISO-8859-1");
//			response.setCharacterEncoding("ISO-8859-1");
//			response.sendRedirect("menu.jsp");
			return;
		}
		if (b_k != null) //
		{
			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			response.sendRedirect("report2.jsp");
			return;
		}
		if (b_a != null) {
			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			response.sendRedirect("movies.jsp");
			return;

		}

		if (b_r != null) {

			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			response.sendRedirect("report.jsp");
			return;
		}
		if (b_d != null) {

			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			response.sendRedirect("deleteMovie.jsp");
			return;
		}
	}
	
		

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
