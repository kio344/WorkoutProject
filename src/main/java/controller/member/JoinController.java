package controller.member;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import css_js.AddCss_Js;
import models.member.JoinService;


@WebServlet("/join")
public class JoinController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JoinService service = new JoinService();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		service.join(req, resp);
		
		
	}
	
	
	
}
