package controller.mypage;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import models.member.LoginService;
import models.member.MypageService;
import mybatis.Connection;

@WebServlet("/mypage/basics")
public class MypageBasicsController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/mypage/mypage_basics.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		MypageService service = new MypageService();
		
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		
		PrintWriter out = resp.getWriter();
		
		try {
			
			String year = req.getParameter("year");
			String month = req.getParameter("month"); 
			String day = req.getParameter("day"); 
			String ymd = year + month + day;
			System.out.println(ymd);
			
			service.check(req);
			service.update(req, dto);
			
			out.println("<script> alert('수정 완료') </script>");
			out.println("<script>parent.location.replace('/WorkOutProject') </script>");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			out.println("<script>alert('"+ e.getMessage() +"') </script>");
		}
	}

}
