package controllers.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jmsUtil.Utils.*;
import models.board.DeleteService;

@WebServlet("/board/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DeleteService service=new DeleteService(req, resp);
			service.boardDelete();
			
			
		}catch (RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		} 
		
		catch (Exception e) {
			e.printStackTrace();
			
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
	}
}
