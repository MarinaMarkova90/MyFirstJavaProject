package com.movies;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Callservice;

/**
 * Servlet implementation class CommentsServlet
 */
@WebServlet("/CommentsServlet")
public class CommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsServlet() {
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
		    HttpSession session = request.getSession();
			
			String btn_back = request.getParameter("back"); // бутон за правене на запис в таблица comments

			if (btn_back != null) // натиснат е бутон back за връща към екрана за филмите

			{
				response.setContentType("text/html; charset=ISO-8859-1");
				response.setCharacterEncoding("ISO-8859-1");

				RequestDispatcher dispatcher = request.getRequestDispatcher("movies.jsp"); //movies.jsp  е името на втория servlet
				dispatcher.forward(request, response);
				return;
			}

			//взема данни от екрана 
			String aname = request.getParameter("aname");
			String nacionality = request.getParameter("nacionality");
			String text = request.getParameter("text");

			//прави проверка за задължително попълнени данни в текстовите полета
			if (aname.trim().length() == 0 || nacionality.trim().length() == 0 || text.trim().length() == 0) {

				response.setContentType("text/html; charset=ISO-8859-1");
				response.setCharacterEncoding("ISO-8859-1");
				request.setAttribute("mess_txt", "Please, fiel the all text box !");
				request.setAttribute("mess1_txt", (String) session.getAttribute("mess_for_movie"));
				RequestDispatcher dispatcher1 = request.getRequestDispatcher("comments.jsp");
				dispatcher1.forward(request, response);
				return;
			}

			// вземане на параметъра ticketid от сесията
			long ticketid = (long) session.getAttribute("request1_ticketid");

			//извикване на сървиз за запис в таблица comments
			String call2 = "POST"; // request.getParameter("email");
			String serverUrl2 = "http://localhost:8080/tickets/" + ticketid + "/comments";
			String jsonobject2 = "{\"aname\":\"" + request.getParameter("aname") + "\", \"nacionality\":\"" + nacionality + "\", \"text\":\"" + request.getParameter("text") + "\"}";
			String rez2 = Callservice.callMethod(call2, serverUrl2, jsonobject2);   //извикване на сървиза

			//формиране на съобщение за успешен запис
			String mess2 = "<h2> You success add actor name: " + aname + " with nacionality: " + nacionality + "with other movies: " + text + "</h2>";

			//подготовка на responsa за диспечара към същата страница
			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			request.setAttribute("mess1_txt", (String) session.getAttribute("mess_for_movie"));
			request.setAttribute("mess_txt", mess2);

			RequestDispatcher dispatcher = request.getRequestDispatcher("comments.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
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
