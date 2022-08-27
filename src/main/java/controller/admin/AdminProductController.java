package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.AdminProductService;
import models.seller.ProductDto;

@WebServlet("/admin/product")
public class AdminProductController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminProductService service = new AdminProductService();
		List<ProductDto> products = service.gets();
		req.setAttribute("products", products);
		
		String[] addCss = { "admin/product" };
		String[] addJs = { "admin/product" };
		
		req.setAttribute("addCss", addCss);
		req.setAttribute("addJs", addJs);
		RequestDispatcher rd = req.getRequestDispatcher("/admin/adminProduct.jsp");
		rd.forward(req, resp);
	}

}
