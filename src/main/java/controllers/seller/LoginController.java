package controllers.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.seller.LoginService;

import static jmsUtil.Utils.*;
@WebServlet("/seller/login")
public class LoginController extends HttpServlet {
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
			LoginService service =new LoginService();
			service.login(req);
			showAlert(resp, "로그인 성공");
			
			replacePage(resp, req.getContextPath()+"/seller", "parent");


		} catch (RuntimeException e) {
			showAlertException(resp, e);
			e.printStackTrace();
		}
	}
}
