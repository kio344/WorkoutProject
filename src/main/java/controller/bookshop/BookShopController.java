package controller.bookshop;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static jmsUtil.Utils.*;
import exception.BadException;
import models.bookshop.BookSearchService;

@WebServlet("/bookshop")
public class BookShopController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookSearchService searchService = new BookSearchService();
		try {
			String type = req.getParameter("type");
			searchService.search(req, type);
			
			RequestDispatcher rd = req.getRequestDispatcher("/book/index.jsp");
			rd.forward(req, resp);
		}catch (BadException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
