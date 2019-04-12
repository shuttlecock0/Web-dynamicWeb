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


// @WebServlet("/")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Controller> map;

    public FrontController() {
        super();
        map = new HashMap<>();
        
    }
    
    private String getUri(HttpServletRequest request) {
    	String uri = request.getRequestURI();
		String ctxPath = request.getContextPath();
		String path = uri.substring(ctxPath.length());
		return path;
    }

    protected void move(HttpServletRequest request, HttpServletResponse response, String target) throws ServletException, IOException {
    	if(target== null) {
    		response.sendError(500);
    		return ;
    	}
    	
    	if(target.startsWith("redirect:")) {
    		if(target.startsWith("/")) {	// 절대 경로인경우 
        		target = request.getContextPath() +  
        				target.substring("redirect:".length());
    		}
    		response.sendRedirect(target);
    	} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(target);
			dispatcher.forward(request, response);
    	}
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String uri = getUri(req);
		Controller controller = map.get(uri);
		if(controller!=null) {
			String target;
			if(req.getMethod().equalsIgnoreCase("GET")) {
				target = controller.doGet(req, resp);
			} else {
				target = controller.doPost(req, resp);
			}
			move(req, resp, target);
		} else {
			resp.sendError(404, uri + " 경로가 없습니다.");
		}
    }
    
}
