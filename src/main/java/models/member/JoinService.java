package models.member;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.bcrypt.BCrypt;

import commons.Validator;
import dto.UserDto;
import exception.BadException;
import models.member.UserValidator;

public class JoinService {

	/**
	 *	회원가입 처리
	 *	1. 필수 데이터 검증
	 *	2. 중복회원 체크
	 *	3. 아이디 체크(알파벳 + 숫자), 복잡성 체크
	 *	3-1. 휴대전화번호 유입시 형식체크, 형식 통일화(숫자로만 구성)
	 *	4. 비밀번호 해시화(bcrypt)
	 *	5. DB 저장 처리
	 * @param req
	 */
	
	public void join(HttpServletRequest request) {
		
		/** 1. 필수 데이터 검증 시작 */
		Map<String, String> check = new HashMap<>();
		UserValidator validator = new UserValidator();
		
		check.put("id", "아이디를 입력해 주세요.");
		check.put("pw", "비밀번호를 입력해 주세요.");
		check.put("pwre", "비밀번호를 확인해 주세요.");
		check.put("email", "이메일을 입력해 주세요.");
		check.put("name", "이름을 입력해 주세요.");
		check.put("mobile", "핸드폰 번호를 입력해 주세요.");
		check.put("address", "주소를 입력해 주세요.");
		
		validator.check(request, check);
		/** 1. 필수 데이터 검증 끝 */
		
		/** 중복 회원 체크 시작 */
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		
		
		
		validator.overlapUser(id);
		/** 중복 회원 체크 끝 */
		
		/** 아이디 체크 시작 */
		validator.checkUserId(id);
		/** 아이디 체크 끝 */
		
		/** 전화번호 유효성 검사 시작 */
		if(mobile != null || !mobile.isBlank()) {
			mobile = mobile.replaceAll("[^0-9]", "");
			if(!validator.checkMobile(mobile)) {
				throw new BadException("전화번호 형식이 아닙니다. 숫자만 입력해 주세요.");
			}
		}
		/** 전화번호 유효성 검사 끝 */
		
		/** 비밀번호 암호화 (Bcrypt) 시작 */
		String hash = BCrypt.hashpw(mobile, BCrypt.gensalt(10));
		UserDto dto = new UserDto();
		
		dto.setId(id);
		dto.setPassword(hash);
		dto.setName(name);
		dto.setEmail(email);
		dto.setMobile(mobile);
		dto.setAddress(address);
		
		
		/** 비밀번호 암호화 (Bcrypt) 끝 */
		
		
		
		
	}
	
}
