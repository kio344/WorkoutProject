package models.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

import commons.Validator;
import dto.UserDto;
import exception.BadException;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/mypage.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		UserValidator validator = new UserValidator();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		LoginService login = new LoginService();
		PrintWriter out = resp.getWriter();
		MyPageService service = new MyPageService();
		
		try {
			login.search(dto.getId(), pw);
			service.check(req);
			service.update(req);
			service.emailCheck(req);
			
			out.print("<script>alert('변경 완료 되었습니다.')</script>");
			out.print("<script>parent.location.replace('/WorkOutProject')</script>");
			
		}catch (BadException e) {
			out.print("<script>alert('" + e.getMessage() + "')</script>");
		}
		
		
	}
	
	
}
