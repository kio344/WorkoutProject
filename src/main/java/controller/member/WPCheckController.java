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
import models.member.MypageService;

@WebServlet("/mypage/wpc")
public class WPCheckController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/wpc.jsp");
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		System.out.println(dto);
		
		MypageService service = new MypageService();
		PrintWriter out = resp.getWriter();
		try {
			service.withdrawal(req, dto);
			
			session.removeAttribute("member");
			out.println("<script>alert('삭제가 완료 되었습니다.')</script>");
			System.out.println("남아있냐 세션?" + req.getAttribute("member"));
			out.println("<script>parent.location.replace('/WorkOutProject/index.jsp') </script>");
			
		} catch (RuntimeException e) {
			out.println("<script>alert('"+ e.getMessage() +"')</script>");
		}
		
	}
}
