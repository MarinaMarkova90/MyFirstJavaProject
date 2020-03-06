package com.report;

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
 * Servlet implementation class Report2Servlet
 */
@WebServlet("/Report2Servlet")
public class Report2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report2Servlet() {
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
			
			//�������� �� �������� ����� BACK
			if (request.getParameter("btn_back") != null) // �������� � ����� back �� ����� ��� ��������� �����
			{
				response.setContentType("text/html; charset=ISO-8859-1");
				response.setCharacterEncoding("ISO-8859-1");
				response.sendRedirect("menu.jsp");
				return;
			}
			//����� �� ����� ������
			String values[] = request.getParameterValues("check_movies");
			String kynd_movie = values[0];

			// ��������� �� ������ ��� ������ �� create �� ����� � ��������� ticket
			String call = "GET";
			String serverUrl1 = "http://localhost:8080/tickets";
			String jsonobject1 = "";
			String rez1 = Callservice.callMethod(call, serverUrl1, jsonobject1); // ��������� �� ������� �� �������
				
			// ���������� �� ��������� �� �������
			String t1 = "<TABLE>";
			String t2 = "</TABLE>";
			String tr1 = "<tr>" + "<td>";

			String tr2 = "</td>" + "</tr>";
			String out = t1;

			JSONArray jsonarray = new JSONArray(rez1);
			
			int br=0;
			
			// ������ �� ��������� �� ������� JSON ������� ���� �� �������� jsonarray
			for (int i = 0; i < jsonarray.length(); i++) {
				JSONObject jsonobject = jsonarray.getJSONObject(i);

				String kMovie=jsonobject.getString("ticket_name");
				
				String movie = jsonobject.getString("description");
				
				if ( kMovie.equals(kynd_movie) ) {
					if (movie.indexOf(request.getParameter("movie_name"))>-1) {
						
					
				out = out + tr1 + movie + tr2;
				br=1;
					}
				}
			}

			String print="";
			
			if (br==1) {
			print = out + t2;
			}else {
				print="No rows! ";
			}
			
			// �������� �� �������� ������� ��� request
			request.setAttribute("report_place", print);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("report2.jsp");
			dispatcher1.forward(request, response);
			} catch(Exception e) {
				
				System.out.println(e.getMessage());
				
				
				
				
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
