package com.movies;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.json.JSONObject;
import com.service.Callservice;;

/**
 * Servlet implementation class MoviesServlet
 */
@WebServlet("/MoviesServlet")
public class MoviesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoviesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String butt_back = request.getParameter("btn_back"); // достъпване на бутона за връщане към предходна страница

			if (butt_back != null) // натиснат е бутон back за връща към екрана за филмите
				
			{	
				
				response.setContentType("text/html; charset=ISO-8859-1");
				response.setCharacterEncoding("ISO-8859-1");
				response.sendRedirect("menu.jsp");
		     	return;
			}

            //вземане на стойността на радио бутона и на текстово поле description
			String values[] = request.getParameterValues("ticket_name");
			String kynd_movie = values[0];
			String description = request.getParameter("description");

			//проверка да не се въвежда празно
			if (description.trim().length() == 0) {

				response.setContentType("text/html; charset=ISO-8859-1");
				response.setCharacterEncoding("ISO-8859-1");
				request.setAttribute("mess_txt", "Please, fill the Movie Name !");

				RequestDispatcher dispatcher1 = request.getRequestDispatcher("movies.jsp");
				dispatcher1.forward(request, response);
				return;
			}

			
			
			//извикване на сървиз със заявка за create за запис в таблицата ticket
			String call1 = "POST";
			String serverUrl1 = "http://localhost:8080/tickets";
			String jsonobject1 = "{\"description\":\"" + description + "\", \"ticket_name\":\"" + kynd_movie + "\" }";
			String rez1 = Callservice.callMethod(call1, serverUrl1, jsonobject1); // извикване на сервиза за запис в таблица ticket

			
			//  Вземане на параметър от Json отговора от сървиса
			JSONObject myResponse1 = new JSONObject(rez1.toString());
			String mess1 = "Movie:  " + myResponse1.getString("description") + "  Number: " + myResponse1.getLong("ticketId")  ;

			
			//формиране на Respons за новата страница
			response.setContentType("text/html; charset=ISO-8859-1");
			response.setCharacterEncoding("ISO-8859-1");
			request.setAttribute("mess1_txt", mess1);
			request.setAttribute("ticket_id", myResponse1.getLong("ticketId"));

			// запаметяване на ticketId в session
			HttpSession session = request.getSession();
			session.setAttribute("request1_ticketid", myResponse1.getLong("ticketId"));
			session.setAttribute("mess_for_movie", mess1);
			
			// зареждане на другата страница
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("comments.jsp");
			dispatcher1.forward(request, response);

		} catch (Exception ex) {

			System.out.println("ERROR: " + ex.getMessage());
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
