package unit04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit04.domain.Member;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/joinForm.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = map(request);
		System.out.println(member);
		
		// 회원 가입을 위한 유효성 검사 실패로 가정
		request.setAttribute("member", member);
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/joinForm.jsp");
		dispatcher.forward(request, response);
	}

	
	private Member map(HttpServletRequest request) {
		Member member = new Member();
		
		member.setUserId(request.getParameter("userId"));
		member.setPassword(request.getParameter("password"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		member.setGender(request.getParameter("gender"));
		return member;
	}
	
	
}





