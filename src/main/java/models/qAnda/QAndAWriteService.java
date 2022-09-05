package models.qAnda;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

public class QAndAWriteService {
	
	public void register(HttpServletRequest request) {
		String memId = request.getParameter("memId");
		String subject = request.getParameter("subject");
		String question = request.getParameter("question");
		
		if(subject == null || subject.isBlank()) {
			throw new BadException("질문 제목을 입력해주세요.");
		}
		
		if(question == null || question.isBlank()) {
			throw new BadException("질문 내용을 입력해주세요.");
		}
		
		QAndADto dto = new QAndADto();
		dto.setMemId(memId);
		dto.setSubject(subject);
		dto.setQuestion(question);
		
		QAndADao dao = QAndADao.getInstance();
		boolean result = dao.register(dto);
		
		if(!result) {
			throw new BadException("등록 중에 오류가 발생하였습니다.");
		}
		
		
	}

}
