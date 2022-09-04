package controller.qAnda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.qAnda.QAndADao;
import models.qAnda.QAndADto;
import models.qAnda.QAndAViewService;

import static jmsUtil.Utils.*;

@WebServlet("/Q&A/view")
public class QAndAViewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QAndADao dao = QAndADao.getInstance();
		QAndADto dto = dao.get(Integer.parseInt(req.getParameter("id")));
		
		req.setAttribute("question", dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("/q&a/view.jsp");
		rd.forward(req, resp);
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
