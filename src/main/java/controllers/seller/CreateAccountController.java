package controllers.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jmsUtil.Utils.*;

import models.seller.CreateAccountService;
@WebServlet("/seller/createAccount")
public class CreateAccountController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss=new String[] {"/seller/login"};
		String[] addJs=new String[] {"/seller/login"};
		req.setAttribute("addCss", addCss);
		req.setAttribute("addJs", addJs);
		RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/login.jsp");
		rd.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			CreateAccountService service=new CreateAccountService();
			service.createAccount(req);
		} catch (Exception e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}

	}
	
}
