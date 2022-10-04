package controller.qAnda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.qAnda.QAndAAdminViewService;
import models.qAnda.QAndAViewService;

import static jmsUtil.Utils.*;

@WebServlet("/Q&A/view")
public class QAndAViewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] {"qAnda/style"});
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			QAndAAdminViewService service = new QAndAAdminViewService();
			service.view(req);
			
			RequestDispatcher rd = req.getRequestDispatcher("/q&a/view.jsp");
			rd.forward(req, resp);
		} catch (RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
			out.println("<script>history.back();</script>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			
			QAndAViewService service = new QAndAViewService();
			service.view(req);
			
			replacePage(resp, req.getContextPath() + "/Q&A", "parent");
		} catch(RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}
		
	}
	
}
