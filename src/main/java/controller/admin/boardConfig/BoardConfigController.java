package controller.admin.boardConfig;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.board.BoardConfigDao;
import models.admin.board.BoardConfigDto;
import models.admin.board.BoardConfigRegisterService;

import static jmsUtil.Utils.*;

@WebServlet("/admin/board")
public class BoardConfigController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<BoardConfigDto> list = BoardConfigDao.getInstance().gets();
		
		req.setAttribute("list", list);
		
		req.setAttribute("addCss", new String[] {"admin/list"});
		req.setAttribute("addJs", new String[] {"admin/list"});
		
		RequestDispatcher rd = req.getRequestDispatcher("/admin/board/board.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		try {
			BoardConfigRegisterService service = new BoardConfigRegisterService();
			service.register(req);
			
			reloadPage(resp, "parent");
		} catch(RuntimeException e) {
			e.printStackTrace();
			showAlertException(resp, e);
		}
		
	}

}
