package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
	
		Cookie[] listCookies = request.getCookies();
		
		if(listCookies == null){
			out.println("There is no cookies");
			out.println("<br/>");
		} else {
			for(Cookie cookieFromList: listCookies){
				String name = cookieFromList.getName();
				String value = cookieFromList.getValue();
				
				out.println(name + " = " + value + "<br/>");
			}
		}
		Cookie cookie = new Cookie("user", "Jasmin");
		out.println(cookie.toString() + "<br/>");
		
		response.addCookie(cookie);
		
		cookie.setMaxAge(30);
		
		out.println("<p>Cookie is set</p>");
		
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
