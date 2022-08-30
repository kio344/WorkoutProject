package controller.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import models.member.LoginService;
import models.member.MyPageService;
import mybatis.Connection;
=======
>>>>>>> 707f3ecc737d314a75b0b52545b67a606cf396e5

@WebServlet("/mypage")
public class MypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/mypage/mypage.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
<<<<<<< HEAD
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		MyPageService service = new MyPageService();
		String pw = req.getParameter("pw");
		HttpSession session = req.getSession();
		
		UserDto dto = (UserDto)session.getAttribute("member");
		LoginService login = new LoginService();
		PrintWriter out = resp.getWriter();
		
		try {
			login.search(dto.getId());
			service.update(req, dto);
			service.check(req);
			
			out.println("<script> alert('수정 완료') </script>");
			out.println("<script>parent.location.replace('/WorkOutProject'); </script>");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			out.println("<script>alert('"+ e.getMessage() +"') </script>");
		}
=======
		
>>>>>>> 707f3ecc737d314a75b0b52545b67a606cf396e5
	}
}
