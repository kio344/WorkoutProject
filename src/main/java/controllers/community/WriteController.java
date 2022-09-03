package controllers.community;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.board.WriteService;

@WebServlet("/board/write")
public class WriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addJs", new String[] {"ckeditor/ckeditor","board/write"});
		try {
			RequestDispatcher rd=req.getRequestDispatcher("/community/write.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			WriteService  service=new WriteService(req,resp);
			service.write();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
