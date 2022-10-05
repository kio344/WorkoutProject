package controller.qAnda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import exception.BadException;
import models.qAnda.QAndAWriteService;

import static jmsUtil.Utils.*;

@WebServlet("/Q&A/write")
public class QAndAWritercontroller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] {"qAnda/style"});
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		try {
			UserDto user = (UserDto) req.getSession().getAttribute("member");
			if(user == null) {
				throw new BadException("로그인 후 이용해주세요.");
			}
			RequestDispatcher rd = req.getRequestDispatcher("/q&a/write.jsp");
			rd.forward(req, resp);
		} catch (RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
			out.println("<script>history.back();</script>");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		try {
			QAndAWriteService service = new QAndAWriteService();
			service.register(req);
			replacePage(resp, req.getContextPath() + "/Q&A", "parent");
		} catch (RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}
	}
	
}
