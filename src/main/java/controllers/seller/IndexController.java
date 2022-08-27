package controllers.seller;

import java.io.IOException;
import static jmsUtil.Utils.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.seller.IndexService;
import models.seller.LoginException;

@WebServlet("/seller")
public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			IndexService service=new IndexService();
			service.process(req);
			
			RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/index.jsp");
			rd.forward(req, resp);
		}catch (LoginException e) {
			RequestDispatcher rd=req.getRequestDispatcher("/seller/login");
			rd.forward(req, resp);

		}
		
		catch (Exception e) {
			showAlertException(resp, e);
		}
		
	}

}
