package models.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;

import static jmsUtil.Utils.*;

import java.util.HashMap;
import java.util.Map;

public class WriteService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	public WriteService(HttpServletRequest request,HttpServletResponse response) {
		req=request;
		resp=response;

	}
	public WriteService(HttpServletRequest request) {
		req=request;
	}
	
	public void write() {
		showParaMap(req);
		
		UserDto loginUser=getLoginUser(req);
		if (loginUser==null) {
			loginUser=new UserDto();
			loginUser.setId("TestUser");
		}
		
		Map<String, String> validator=new HashMap<>();
		validator.put("boardId", "잘못된 요청입니다.");
		validator.put("gid", "잘못된 요청입니다.");
		validator.put("subject", "제목을 입력해 주세요");
		validator.put("content", "내용을 입력해 주세요");

		String boardId=req.getParameter("boardId");
		Long gid=Long.parseLong(req.getParameter("gid"));
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		
		ckNullParaMap(req, validator);
		
		BoardDto board=new BoardDto();

		board.setBoardId(boardId);
		board.setGid(gid);
		board.setSubject(subject);
		board.setPoster(loginUser.getId());
		board.setContent(content);
		
		BoardDao dao=BoardDao.getInstance();
		
		dao.insert(board);
		
		System.out.println(board);
		
		
		
		
		
		


		
	}
}
