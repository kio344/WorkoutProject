package controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import css_js.AddCss_Js;
import exception.BadException;
import models.member.JoinService;


@WebServlet("/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] {"member/join"});
		
		RequestDispatcher rd = req.getRequestDispatcher("/member/join.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		JoinService service = new JoinService();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		try {
			service.join(req, resp);
			out.print("<script>alert('회원가입 성공')</script> \n");
			out.print("<script>parent.location.replace('/WorkOutProject')</script>");
			
		}catch (BadException e) {
			out.print("<script>alert('" + e.getMessage() + "')</script>");
			
		}
		
	}
	
	
	
}
