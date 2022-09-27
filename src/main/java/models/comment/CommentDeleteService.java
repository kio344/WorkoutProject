package models.comment;

import javax.servlet.http.HttpServletRequest;

public class CommentDeleteService {
	
	public void delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		
		CommentDao dao = CommentDao.getInstance();
		CommentDto dto = new CommentDto();
		dto.setId(Integer.parseInt(id));
		
		dao.delete(dto);
	}

}
