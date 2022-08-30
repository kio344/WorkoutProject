package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.ProductUpdateService;

import static jmsUtil.Utils.*;

@WebServlet("/admin/update")
public class ProductUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		try {
			ProductUpdateService service = new ProductUpdateService();
			service.update(req);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}
		
		
	}

}
