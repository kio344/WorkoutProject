package models.qAnda;

import javax.servlet.http.HttpServletRequest;

import dto.UserDto;
import exception.BadException;

public class QAndADeleteService {
	
	public void delete(HttpServletRequest request) {
		UserDto user = (UserDto) request.getSession().getAttribute("member");
		
		if(!user.getUserType().equals("admin")) {
			throw new BadException("삭제 권한이 없습니다.");
		}
		
		QAndADao dao = QAndADao.getInstance();
		
		String _id = request.getParameter("id");
		
		QAndADto dto = new QAndADto();
		dto.setId(Integer.parseInt(_id));
		
		
		boolean result = dao.delete(dto);
		if(!result) {
			throw new BadException("오류가 발생하였습니다.");
		}
	}

}
