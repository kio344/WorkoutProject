package controllers.community;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.board.BoardDto;
import models.board.ListService;

@WebServlet("/board/main")
public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", "community/index");
		try {
			RequestDispatcher rd=req.getRequestDispatcher("/community/index.jsp");
			ListService service=new ListService(req);
			List<BoardDto> notice=service.getBoardPage("notice");	//공지사항
			List<BoardDto> free=service.getBoardPage("free"); //자유게시판
			List<BoardDto> recent=service.getBoardTotal(20);
			List<BoardDto> test=service.getBoardPage("test");
			req.setAttribute("notice",notice);
			req.setAttribute("free", free);
			req.setAttribute("recent", recent);
			req.setAttribute("test", test);
			

			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
