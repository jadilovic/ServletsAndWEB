package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletScopes2
 */
@WebServlet("/ServletScopes2")
public class ServletScopes2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletScopes2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<p> new line</p>");
		
		// Request scope
		request.setAttribute("test", "Hello 1");
		String test1 = (String) request.getAttribute("test");
		response.getWriter().append("Request Scope Test 1 is: ").append(test1);
		response.getWriter().append("<p> new line</p>");
		
		// Session scope
		HttpSession session = request.getSession();
		session.setAttribute("test", "Hello 2");
		String test2 = (String) session.getAttribute("test");
		response.getWriter().append("Session Scope Test 2 is: " + test2);
		response.getWriter().append("<p> new line</p>");
		
		// Application scope
		ServletContext context = request.getServletContext();
		context.setAttribute("test", "Hello 3");
		String test3 = (String) context.getAttribute("test");
		response.getWriter().append("Application Scope Test 3 is: ").append(test3);
		response.getWriter().append("<p> new line</p>");
		
		// Paremeter in web.xml
		PrintWriter out = response.getWriter();
		String userName = context.getInitParameter("name");
		out.println("<p>" + userName + "</p>");
		response.getWriter().append("XML name parameter: " + userName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
