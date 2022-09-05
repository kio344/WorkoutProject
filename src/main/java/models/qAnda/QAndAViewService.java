package models.qAnda;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

public class QAndAViewService {
	
	public void view(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String answer = request.getParameter("answer");
		if(answer == null || answer.isBlank()) {
			throw new BadException("답변을 입력해주세요.");
		}
		
		QAndADto dto = new QAndADto();
		dto.setAnswer(answer);
		dto.setId(Integer.parseInt(id));
		
		QAndADao dao = QAndADao.getInstance();
		boolean result = dao.update(dto);
		if(!result) {
			throw new BadException("답변 작성 중 오류가 발생하였습니다.");
		}
	}

}
