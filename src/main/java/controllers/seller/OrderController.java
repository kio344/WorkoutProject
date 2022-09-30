package controllers.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.bookshop.BookPaymentDto;
import models.bookshop.BookProgress;
import models.seller.OrderService;

@WebServlet("/seller/order")
public class OrderController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss = new String[] { "/seller/order" };
		req.setAttribute("addCss", addCss);
		OrderService orderService=new OrderService(req,resp);
		RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/order.jsp");
		String progress=(String) req.getParameter("progress");
		System.out.println(progress);
		try {
			PaymentDao dao=PaymentDao.getInstance();
			BookPaymentDto bookPaymentDto=new BookPaymentDto();
			if (progress!=null&&!progress.isBlank()) {
				bookPaymentDto.setProgress(progress);
				System.out.println("스킵");
			}
			bookPaymentDto.setSeller("llll5563");
			
			req.setAttribute("list", dao.gets(bookPaymentDto));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rd.forward(req, resp);
	}
}
