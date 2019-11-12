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
 * Servlet implementation class ServletScopes
 */
@WebServlet("/ServletScopes")
public class ServletScopes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletScopes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// Request scope
		request.setAttribute("test", "Hello 1");
		String test1 = (String) request.getAttribute("test");
		out.println("Test 1 Request Scope is: " + test1);
		out.println("<p>");
		
		// Session scope
		HttpSession session = request.getSession();
		session.setAttribute("test", "Hello 2");
		String test2 = (String) session.getAttribute("test");
		out.println("Test 2 Session Scope is: " + test2);
		out.println("<p>");
		
		// Application scope
		ServletContext context = request.getServletContext();
		context.setAttribute("test", "Hello 3");
		String test3 = (String) context.getAttribute("test");
		out.println("Test 3 Application Scope is: " + test3);
		out.println("<p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
