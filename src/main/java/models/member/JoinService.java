package models.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import commons.Validator;
import dto.UserDto;

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
		int mobile = Integer.parseInt(request.getParameter("mobile"));
		String address = request.getParameter("address");
		
		UserDto dto = new UserDto(id, password, name, email, mobile, address);
		
		
		validator.overlapUser(id);
		/** 중복 회원 체크 끝 */
		
		/** 아이디 체크 시작 */
		
		/** 아이디 체크 끝 */
	}
	
}
