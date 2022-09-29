package controllers.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.seller.OrderService;

@WebServlet("/seller/order")
public class OrderController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss = new String[] { "/seller/message" };
		req.setAttribute("addCss", addCss);
		OrderService orderService=new OrderService(req,resp);
		RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/order.jsp");
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		rd.forward(req, resp);
	}
}
