package controllers.community;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.board.BoardDto;
import models.board.ViewService;
import models.comment.CommentViewService;
import models.file.FileInfoDto;

@WebServlet("/board/view")
public class ViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addCss", new String[] {"community/view"});
		req.setAttribute("addJs", new String[] {"board/update"});
		try {
			ViewService service=new ViewService(req,resp);
			BoardDto board= service.get();
			List<FileInfoDto> fileList=service.getFile();
			
			req.setAttribute("fileList", fileList);
			req.setAttribute("board", board);
			
			CommentViewService viewService = new CommentViewService();
			viewService.view(req);
			
			RequestDispatcher rd=req.getRequestDispatcher("/community/view.jsp");
			rd.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
