package models.comment;

import javax.servlet.http.HttpServletRequest;

public class CommentUpdateService {
	
	public void update(HttpServletRequest request) {
		
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		
		CommentDao dao = CommentDao.getInstance();
		CommentDto dto = new CommentDto();
		
		dto.setContent(content);
		dto.setId(Integer.parseInt(id));
		
		dao.update(dto);
		
	}

}
