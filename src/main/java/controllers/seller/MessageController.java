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

import models.admin.MessageDto;
import models.seller.LoginException;
import models.seller.MessageService;

@WebServlet("/seller/message")
public class MessageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] addCss=new String[] {"/seller/message"};
		req.setAttribute("addCss", addCss);

		try {
			MessageService service=new MessageService(req);
			List<MessageDto> list = service.getUserMsg();
			req.setAttribute("list", list);
			RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/message.jsp");
			rd.forward(req, resp);
		}catch (LoginException e) {
			e.printStackTrace();
			showAlert(resp, "로그인 후 사용해주세요");
			RequestDispatcher rd=req.getRequestDispatcher("/jmsPage/login.jsp");

			replacePage(resp, req.getContextPath()+"/seller/login", "parent");
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("dd");
		}  

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			MessageService service=new MessageService(req);
			service.seeSetting();
			reloadPage(resp, "parent");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
