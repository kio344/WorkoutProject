package controllers.seller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seller/message")
public class MessageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss=new String[] {"/seller/message"};
		req.setAttribute("addCss", addCss);

		try {
			RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/message.jsp");
			rd.forward(req, resp);
		} catch (RuntimeException e) {
			// TODO: handle exception
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
