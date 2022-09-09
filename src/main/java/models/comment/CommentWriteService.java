package models.comment;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

public class CommentWriteService {
	
	public void write(HttpServletRequest request) {
		String boardId = request.getParameter("boardId");
		String gid = request.getParameter("gid");
		String userName = request.getParameter("userName");
		String content = request.getParameter("content");
		
		if(content == null || content.isBlank()) {
			throw new BadException("댓글 내용을 입력하지 않았습니다.");
		}
		
		CommentDao dao = CommentDao.getInstance();
		CommentDto dto = new CommentDto();
		dto.setBoardId(boardId);
		dto.setGid(gid);
		dto.setUserName(userName);
		dto.setContent(content);
		
		dao.register(dto);
		
	}

}
