package models.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

public class CommentViewService {
	
	public void view(HttpServletRequest request) {
		
		String gid = request.getParameter("gid");
		if(gid == null || gid.isBlank()) {
			throw new BadException("잘못된 요청입니다.");
		}
		
		CommentDto dto = new CommentDto();
		dto.setGid(gid);
		
		CommentDao dao = CommentDao.getInstance();
		List<CommentDto> comments = dao.gets(dto);
		
		request.setAttribute("comments", comments);
		
	}

}
