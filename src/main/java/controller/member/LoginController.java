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
import exception.BadException;
import models.member.LoginService;
import models.member.UserValidator;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] {"member/login"});
		
		RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		LoginService login = new LoginService();
		PrintWriter out = resp.getWriter();
		
		try{
			UserDto dto = login.search(id, pw);
			out.print("<script>alert('로그인 성공')</script> \n");
			out.print("<script>parent.location.replace('/WorkOutProject')</script>");
			HttpSession session = req.getSession();
			session.setAttribute("member", dto);
			System.out.println(session.getAttribute("member"));
		}catch (BadException e) {
			out.print("<script>alert('" + e.getMessage() + "')</script>");
		}
		
	}
}
