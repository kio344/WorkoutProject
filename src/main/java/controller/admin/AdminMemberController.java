package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.ProductSearchService;
import models.admin.UserManageService;
import models.seller.ProductDto;

@WebServlet("/admin/user")
public class AdminMemberController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("addCss", new String[] {"admin/admin"});
		
		RequestDispatcher rd = req.getRequestDispatcher("/admin/adminUserManage.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserManageService service = new UserManageService();
		try {
			service.memberGet(req);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
