package models.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.mindrot.bcrypt.BCrypt;

import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class MyPageService {

	/**
	 * 비밀번호 변경 체크
	 */
	public void check(HttpServletRequest request) {
		String repw = request.getParameter("repw");
		String repwRe = request.getParameter("repwRe");
		String nameRe = request.getParameter("nameRe");
		String addressRe = request.getParameter("addressRe");
		
		if(repw == null || repw.isBlank()) {
			throw new BadException("변경할 비밀번호가 없습니다.");
		}
		
		if(repwRe == null || repwRe.isBlank()) {
			throw new BadException("비밀번호 확인칸이 비어있습니다.");
		}
		
		if(!(repw.equals(repwRe))) {
			throw new BadException("비밀번호가 일치하지 일치하지 않습니다.");
		}
		
		if(nameRe == null || nameRe.isBlank()) {
			throw new BadException("이름이 비어있습니다.");
		}
		
		if(addressRe == null || addressRe.isBlank()) {
			throw new BadException("주소가 비어있습니다.");
		}
		
	}
	
	/**
	 * 정보 변경사항 저장
	 * @param request
	 */
	public void update(HttpServletRequest request) {
		SqlSession sqlsession = Connection.getSession();
		HttpSession session = request.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		String repw = BCrypt.hashpw(request.getParameter("repw"), BCrypt.gensalt(10));
		
		dto.setId(dto.getId());
		dto.setPassword(repw);
		dto.setName(request.getParameter("nameRe"));
		dto.setEmail(request.getParameter("emailRe"));
		dto.setMobile(request.getParameter("mobileRe"));
		dto.setAddress(request.getParameter("addressRe"));
		
		sqlsession.update("userInfoMapper.update", dto);
		
		sqlsession.commit();
		sqlsession.close();
		
		session.setAttribute("member", dto);
	}
	public void emailCheck(HttpServletRequest request ) {
		String emailRe = request.getParameter("emailRe");
		
		if(emailRe == null || !(emailRe.contains("@") || !(emailRe.contains(".")))) {
			throw new BadException("이메일 형식이 아닙니다.");
		}
	}
}
