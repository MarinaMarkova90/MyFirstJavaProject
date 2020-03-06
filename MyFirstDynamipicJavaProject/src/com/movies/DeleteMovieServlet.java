package com.movies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.service.Callservice;

/**
 * Servlet implementation class DeleteMovieServlet
 */
@WebServlet("/DeleteMovieServlet")
public class DeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()); 
		try {
			
			//проверка за натиснат бутон BACK
			if (request.getParameter("btn_back") != null) // натиснат е бутон back за връща към предходен екран
			{
				response.setContentType("text/html; charset=ISO-8859-1");
				response.setCharacterEncoding("ISO-8859-1");
				response.sendRedirect("menu.jsp");
				return;
			}
			
			//взема се радио бутона
			String values[] = request.getParameterValues("check_movies");
			String kynd_movie = values[0];

			// извикване на сървиз със заявка за create за запис в таблицата ticket
			String call = "GET";
			String serverUrl1 = "http://localhost:8080/tickets";
			String jsonobject1 = "";
			String rez1 = Callservice.callMethod(call, serverUrl1, jsonobject1); // извикване на сервиза за запис в
				
			// подготовка за формиране на таблица
			String to = "<TABLE>";
			String tz = "</TABLE>";
			String out = to;
			
			String tdo="<td>" ;
			String tdz="</td>" ;
			String tro="<tr>" ;
			String trz="</tr>" ;

			JSONArray jsonarray = new JSONArray(rez1);
			
			int br=0;
			
			// четене на резултата от сървиса JSON стринга като се използва jsonarray
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jsonobject = jsonarray.getJSONObject(i);

				String kMovie=jsonobject.getString("ticket_name");
				
				String movie = jsonobject.getString("description");
				Long ticketId = jsonobject.getLong("ticketId");
				
				if ( kMovie.equals(kynd_movie)) {
				out = out + tro+tdo + movie + tdz+  tdo +ticketId+ tdz +trz ;
				br=1;

				}
			}

			String print="";
			
			if (br==1) {
			print = out + tz;
			}else {
				print="No rows! ";
			}
			
			// добавяне на готовата таблица към request
			request.setAttribute("report_place", print);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("deleteMovie.jsp");
			dispatcher1.forward(request, response);
			
		
		
		
		}catch(Exception e) {
			System.out.println(e);
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
