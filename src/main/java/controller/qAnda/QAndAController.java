package controller.qAnda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.qAnda.QAndAListService;

@WebServlet("/Q&A")
public class QAndAController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QAndAListService service = new QAndAListService();
		service.list(req);
		
		req.setAttribute("addCss", new String[] {"qAnda/style"});
		
		RequestDispatcher rd = req.getRequestDispatcher("/q&a/list.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
		
	}
	
}
