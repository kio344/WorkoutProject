package models.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.bcrypt.BCrypt;

import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class MypageService {


	/**
	 * 인적사항 업데이트
	 * @param req
	 * @param param
	 */
	
	public void update(HttpServletRequest req, UserDto dto) {
		UserValidator validator = new UserValidator();
		check(req);
		
		String name = req.getParameter("nameRe");
		String fakeName = req.getParameter("fakeNameRe");
		String email = req.getParameter("emailRe");
		String mobile = req.getParameter("mobileRe");
		String address = req.getParameter("addressRe");
		
		//별명 중복 체크
		validator.checkFakeName(fakeName);
		
		//이메일 체크
//		validator.emailCheck(req);
		
		HttpSession session = req.getSession();
		//번호 형식 체크
		if(mobile != null && !mobile.isBlank()) {
			mobile = mobile.replaceAll("[^0-9]", "");
			
			if(!validator.checkMobile(mobile)) {
				throw new BadException("번호 형식이 맞지 않습니다.");
			}
		}
		dto.setName(name);
		dto.setFakeName(fakeName);
		dto.setEmail(email);
		dto.setMobile(mobile);
		dto.setAddress(address);
		
		//정보 수정 완료
		UserDao dao = UserDao.getInstance();
		System.out.println(dto);
		dao.update(dto);
		System.out.println("업뎃 DB = "+dto);
		session.setAttribute("member", dto);
		System.out.println("session = " + session.getAttribute("member"));
	}
	
	
	public void check(HttpServletRequest req) {
		//제대로 들어갔나 체크
		String name = req.getParameter("nameRe");
		String fakeName = req.getParameter("fakeNameRe");
		String email = req.getParameter("emailRe");
		String mobile = req.getParameter("mobileRe");
		String address = req.getParameter("addressRe");
		
		if(name == null || name.isBlank()) {
			throw new BadException("아이디가 없습니다.");
		}
		if(fakeName == null || fakeName.isBlank()) {
			throw new BadException("별명이 없습니다.");
		}
		if(email == null || email.isBlank()) {
			throw new BadException("이메일이 없습니다.");
		}
		if(mobile == null || mobile.isBlank()) {
			throw new BadException("전화번호가 없습니다.");
		}
		if(address == null || address.isBlank()) {
			throw new BadException("주소가 없습니다.");
		}
	}

	
	
	/**
	 * 비번 업데이트
	 * @param req
	 * @param param
	 */
	public void passwordUpdate(HttpServletRequest req, UserDto dto) {
		pwCheck(req);
		
		//비밀번호 일치 확인
		String pw = req.getParameter("pw");
		if(!BCrypt.checkpw(pw, dto.getPassword())) {//일단 현재 페이지에서 만들었지만 추후 비밀번호 수정 버튼을 클릭시 체크 과정을 거치게 할거면 이동할 예정
			throw new BadException("현재 비밀번호가 일치하지 않습니다.");
		}
		
		if(req.getParameter("pwRe").length() < 8) {
			throw new BadException("비밀번호는 8자리 이상 입력하세요.");
		}
		
		//변경 비밀번호 해시화
		String pwRe = BCrypt.hashpw(req.getParameter("pwRe"), BCrypt.gensalt(10));
		//변경 비밀번호 저장
		dto.setPassword(pwRe);
		
		//DB 저장
		UserDao dao = UserDao.getInstance();
		dao.update(dto);
		System.out.println("디비 저장 = " + dto);
		
		//세션에 저장해주기
		HttpSession session = req.getSession();
		session.setAttribute("member", dto);
		System.out.println("세션 저장 = " + dto);
	}

	public void pwCheck(HttpServletRequest req) {// 비밀번호 변경 페이지에서 입력이 제대로 완료 됐는지 확인
		String pw = req.getParameter("pw");
		String pwRe = req.getParameter("pwRe");
		String pwReCheck = req.getParameter("pwReCheck");
		
		if(pw == null || pw.isBlank()) {
			throw new BadException("비밀번호를 입력하세요.");
		}
		if(pwRe == null || pwRe.isBlank()) {
			throw new BadException("변경할 비밀번호를 입력하세요.");
		}
		if(pwReCheck == null || pwReCheck.isBlank()) {
			throw new BadException("변경 비밀번호 확인을 입력하세요.");
		}else if(!pwRe.equals(pwReCheck)) {
			throw new BadException("변경할 비밀번호가 일치하지 않습니다.");
		}
	}

	
	/**
	 * 신체정보 업데이트
	 * @param req
	 * @param param
	 */
	public void physicalUpdate(HttpServletRequest req, UserDto param) { // 나이 같은 경우는 나중에 년생을 선택하게 해서 현재 년도와 비교해서 나이 값을 도출하는 방식이 필요해 보임
		physicalCheck(req);
		
		SqlSession sqlSession = Connection.getSession();
		UserDto dto = sqlSession.selectOne("userInfoMapper.user", param);
		sqlSession.close();
		
		dto.setHeight(Double.parseDouble(req.getParameter("heightRe")));
		dto.setWeight(Double.parseDouble(req.getParameter("weightRe")));
		dto.setAge(Double.parseDouble(req.getParameter("ageRe")));
		dto.setSex(req.getParameter("sexRe"));
		
		System.out.println(dto);
		
		//DB 저장
		UserDao dao = UserDao.getInstance();
		dao.bmiUpdate(dto);
		System.out.println("디비 저장 = " + dto);

		//세션에 저장해주기 - 비번은 비워서 저장하기
		HttpSession session = req.getSession();
		session.setAttribute("member", dto);
		System.out.println("세션 저장 = " + dto);
	}
	
	public void physicalCheck(HttpServletRequest req) {
		
		double height = Double.parseDouble(req.getParameter("heightRe")); 
		double weight = Double.parseDouble(req.getParameter("weightRe")); 
		double age = Double.parseDouble(req.getParameter("ageRe")); 
		String sex = req.getParameter("sexRe");
		
		if(height <= 0) {
			throw new BadException("정상적인 키를 입력 해주세요.");
		}
		if(weight <= 0) {
			throw new BadException("비정상적인 입력값 입니다.");
		}
		if(age <= 0) {
			throw new BadException("정상적인 나이 값을 입력해주세요.");
		}
		if(sex == null || sex.isBlank()) {
			throw new BadException("성별을 체크해주세요.");
		}
	}
	
	/**
	 * 회원 탈퇴
	 * @param req - 현재 비번 입력,
	 * @param dto
	 */
	public void withdrawal(HttpServletRequest req, UserDto dto) {
		
		SqlSession sqlSession = Connection.getSession();
		
		//현재 비번과 입력 비번 비교
		boolean equalPw = BCrypt.checkpw("pw", dto.getPassword());
		if(equalPw) {//일치하면
 			sqlSession.delete("userInfoMapper.delete", dto);
 			sqlSession.close();
		}else {//비번이 일치하지 않으면
			throw new BadException("비밀번호가 일치하지 않습니다.");
		}
	}
	
}
