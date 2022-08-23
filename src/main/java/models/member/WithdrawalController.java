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

import dto.UserDto;
import exception.BadException;

@WebServlet("/withdrawal")
public class WithdrawalController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/withdrawal.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		WithdrawalSerivce delete = new WithdrawalSerivce();
		
		
		try {
			delete.delete(dto);
			session.removeAttribute("member");
			out.print("<script>alert('회원 탈퇴되었습니다. 이용해주셔서 감사합니다.')</script>");
			out.print("<script>parent.location.replace('/WorkOutProject')</script>");
		}catch (BadException e) {
			out.print("<script>alert('" + e.getMessage() + "')</script>");
		}
		
	}

	
	
}
