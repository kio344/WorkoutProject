package controller.member;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;
import models.member.MyPageService;

@WebServlet("/wpc")
public class WPCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/wpc.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		
<<<<<<< HEAD
		MyPageService service = new MyPageService();
		service.withdrawal(req, dto);
=======
		MypageService service = new MypageService();
		PrintWriter out = resp.getWriter();
		try {
			service.withdrawal(req, dto);
			
			out.println("<script>alert('삭제가 완료 되었습니다.')</script>");
		} catch (RuntimeException e) {
			out.println("<script>alert('"+ e.getMessage() +"')</script>");
		}
>>>>>>> 707f3ecc737d314a75b0b52545b67a606cf396e5
		
	}
}
