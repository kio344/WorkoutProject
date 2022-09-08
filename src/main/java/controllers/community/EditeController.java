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
import models.board.EditService;
import models.board.PosterCkException;
import models.file.FileInfoDto;
import static jmsUtil.Utils.*;
@WebServlet("/board/edit")
public class EditeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("addJs", new String[] {"ckeditor/ckeditor","board/write"});
		req.setAttribute("addCss", new String[] {"community/write"});
		try {
			EditService service=new EditService(req,resp);
			BoardDto board = service.get();
			List<FileInfoDto>fileList= service.getFile();
			
			req.setAttribute("board", board);
			req.setAttribute("fileList", fileList);
						
			RequestDispatcher rd=req.getRequestDispatcher("/community/edit.jsp");
			rd.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		try {
			EditService service=new EditService(req,resp);
			BoardDto board=service.editService();
			showAlert(resp, "수정되었습니다.");
			replacePage(resp, req.getContextPath()+"/board/view?gid="+board.getGid(), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
