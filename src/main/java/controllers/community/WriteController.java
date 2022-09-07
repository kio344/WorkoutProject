package controllers.community;

import java.io.IOException;

import static jmsUtil.Utils.*;
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
		req.setAttribute("addCss", new String[] {"community/write"});
		try {
			RequestDispatcher rd=req.getRequestDispatcher("/community/write.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			WriteService  service=new WriteService(req,resp);
			service.write();
			
			showAlert(resp, "게시글 등록이 완료되었습니다.");
		}catch (RuntimeException e) {
			showAlertException(resp, e);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
}
