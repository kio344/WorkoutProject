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
import models.seller.ProductDto;

@WebServlet("/admin/product")
public class AdminProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductSearchService service = new ProductSearchService();
		List<ProductDto> products = service.search(req);
		req.setAttribute("products", products);

		String[] addCss = { "admin/product", "admin/admin" };
		String[] addJs = { "admin/product" };

		req.setAttribute("addCss", addCss);
		req.setAttribute("addJs", addJs);

		RequestDispatcher rd = req.getRequestDispatcher("/admin/adminProduct.jsp");
		rd.forward(req, resp);
	}

}
