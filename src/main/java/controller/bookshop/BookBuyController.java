package controller.bookshop;

import static jmsUtil.Utils.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BadException;
import models.bookshop.BookPaymentDto;
import models.bookshop.BookPaymentService;
import models.bookshop.BookProductService;

@WebServlet("/bookshop/payment")
public class BookBuyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] {"bookshop/payment"});
		
		BookProductService service = new BookProductService();
		int abnum = Integer.parseInt(req.getParameter("abnum"));
		service.product(abnum, req);
		RequestDispatcher rd = req.getRequestDispatcher("/book/payment.jsp");
		HttpSession session = req.getSession();
		session.getAttribute("member");
		
		String name = req.getParameter("name");
		System.out.println(name);
		
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookPaymentService service = new BookPaymentService();
		
		try {
			service.setDto(req);
			showAlert(resp, "결제완료");
			replacePage(resp, req.getContextPath() + "/bookshop?type=&search=&page=1", "parent");
		} catch (Exception e) {
			e.printStackTrace();
			showAlertException(resp, e);
			System.out.println(req.getContextPath());
			replacePage(resp, req.getContextPath() + "/bookshop?type=&search=&page=1", "parent");
		}
	}
	
	
	
}
