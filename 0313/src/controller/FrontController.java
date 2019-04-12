package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> map;

	public FrontController() {
		super();
		map = new HashMap<>();
		// 요청 PATH 문자열과 Controller 인스턴스를 수동으로 맵에 등록
		// 요청 PATH별 Controller 등록
		map.put("/index.do", new IndexController());
	}

	private String getUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = uri.substring(ctxPath.length());
		return path;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = getUri(req);
		Controller controller = map.get(uri);
		if (controller != null) { // 컨트롤러가 있는 경우
			String target;
			if (req.getMethod().equalsIgnoreCase("GET")) { // 요청 Method 분석
				target = controller.doGet(req, resp);
			} else {
				target = controller.doPost(req, resp);
			}
			move(req, resp, target); // 페이지 이동
		} else { // 컨트롤러가 없는 경우 404 에러 발생
			resp.sendError(404, uri + " 경로가 없습니다.");
		}
	}

	protected void move(HttpServletRequest request, HttpServletResponse response, String target)
			throws ServletException, IOException {
		if (target.startsWith("redirect:")) { // redirect인 경우
			target = target.substring("redirect:".length());
			if (target.startsWith("/")) { // 절대 경로인경우
				target = request.getContextPath() + target;
			}
			response.sendRedirect(target);
		} else { // forwarding인 경우
			target += ".jsp";
			System.out.println(target);
			RequestDispatcher dispatcher = request.getRequestDispatcher(target);
			dispatcher.forward(request, response);
		}
	}

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	*/
}
