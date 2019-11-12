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
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		out.println("<html>");
		
		if(cookies == null){
			out.println("No cookies found <br/>");
		} else {
			for(Cookie oneCookie: cookies){
				String name = oneCookie.getName();
				String value = oneCookie.getValue();
				out.println(name + " = " + value + "<br/>");
			}
		}
	
		Cookie cookie = new Cookie("user", "Adian");
		Cookie cookie2 = new Cookie("boss", "Jasmin");
		Cookie cook3 = new Cookie("admin", "Amela");
		
		response.addCookie(cookie);
		response.addCookie(cook3);
		response.addCookie(cookie2);
		
		cookie.setMaxAge(100);
		
		out.println("Cookies were set.");
		
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
