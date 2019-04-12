package unit04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unit04.domain.Member;
import unit04.domain.PageInfo;
import unit04.service.MemberService;
import unit04.service.MemberServiceImpl;
import unit04.util.ParseUtil;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/MemberListServlet")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService service;
    
    public MemberListServlet() {
        super(); 
        service = MemberServiceImpl.getInstance();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		int page = 1;
		String strPage = request.getParameter("page");
		if(strPage != null) {
			page = Integer.parseInt(strPage);
		}
		*/
		int page = ParseUtil.parseInt(request.getParameter("page"));
		
		PageInfo<Member> pi = service.getPage(page);
		request.setAttribute("pi", pi);
		
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/member/list.jsp");
		dispatcher.forward(request, response);
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
