package controllers.seller;

import java.io.IOException;
import static jmsUtil.Utils.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.seller.GetProductListService;
import models.seller.LoginException;
import models.seller.ProductDto;
import models.seller.ProductListDto;

@WebServlet("/seller/myproduct")
public class MyProductController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			GetProductListService service=new GetProductListService();
			List<ProductListDto> list =service.getlistPage(req);
			req.setAttribute("list", list);
			RequestDispatcher rd =req.getRequestDispatcher("/jmsPage/myProduct.jsp");
			rd.forward(req, resp);
			
		}catch (LoginException e) {
			showAlertException(resp, e);
			replacePage(resp, req.getContextPath()+"/seller/login", "parent");
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
