package controller.bookshop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.Pagination;
import models.bookshop.BookProductService;

@WebServlet("/bookshop/product")
public class BookProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int abnum = Integer.parseInt(req.getParameter("abnum"));
		
		BookProductService service = new BookProductService();
		
		service.product(abnum, req);
		
		RequestDispatcher rd = req.getRequestDispatcher("/book/store.jsp");
		
//		Pagination page = new Pagination(1, abnum); 페이지 네이션 기능 구현중
		
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

	
	
}
