package controller.admin.boardConfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.board.BoardConfigDeleteService;
import models.admin.board.BoardConfigUpdateService;

import static jmsUtil.Utils.*;

@WebServlet("/admin/boards")
public class BoardController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
			String mode = req.getParameter("mode");
			if(mode.equals("update")) {
				BoardConfigUpdateService service = new BoardConfigUpdateService();
				service.update(req);
			} else {
				BoardConfigDeleteService service = new BoardConfigDeleteService();
				service.delete(req);
			}
			
			reloadPage(resp, "parent");
		} catch (RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}
		
	}

}
