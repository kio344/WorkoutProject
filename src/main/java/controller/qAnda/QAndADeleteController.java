package controller.qAnda;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.qAnda.QAndADeleteService;

import static jmsUtil.Utils.*;

@WebServlet("/Q&A/delete")
public class QAndADeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			QAndADeleteService service = new QAndADeleteService();
			service.delete(req);
			
			replacePage(resp, req.getContextPath() + "/Q&A", "parent");
		}catch(RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}
		
	}
}
