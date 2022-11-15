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

@WebServlet("/login")
public class LoginController extends HttpServlet {

	static int tryCount = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] { "member/login" });

		RequestDispatcher rd = req.getRequestDispatcher("/member/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");

		LoginService login = new LoginService();
		PrintWriter out = resp.getWriter();

		login.makeCookie(req, resp, tryCount);

		try {
			boolean isCookie = login.checkLimit(req);
			if (!isCookie) {
				UserDto dto = login.search(req, resp);
				out.print("<script>alert('로그인 성공')</script> \n");
				out.print("<script>parent.location.replace('/WorkOutProject')</script>");
				HttpSession session = req.getSession();
				session.setAttribute("member", dto);
				System.out.println(session.getAttribute("member"));
				tryCount = 0;
			}else {
				out.print("<script>alert('5분간 로그인 제한')</script>");
			}
			
		} catch (BadException e) {
			out.print("<script>alert('" + e.getMessage() + "(" + (tryCount+1) + "/5)" + "')</script>");
			tryCount++;
			System.out.println(tryCount);
		}

	}
}
