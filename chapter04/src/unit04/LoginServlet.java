package unit04;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("loginForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id="pinksung";
		String pwd="1234";
		String name="성윤정";
		
		String target = request.getParameter("target");
		
		if(id.equals(request.getParameter("id")) &&
			pwd.equals(request.getParameter("pwd")) ){
			// 로그인 성공 
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			if(target.isEmpty()) {			
				response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect(target);
			}
		}
		else{
			request.setAttribute("target", target);
			request.setAttribute("error", "id 또는 비밀번호가 일치하지 않습니다.");
			doGet(request, response);
		}
		
	
	}       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
}
