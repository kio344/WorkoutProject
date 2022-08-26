package models.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.bcrypt.BCrypt;

import dto.UserDto;

public class MypageService {
	
	/** 마이페이지 수정 기능
	 *  
	 * @return
	 */
	public UserDto regMypage(HttpServletRequest request) {
		UserValidator validator = new UserValidator();
		
		// 필수 데이터 확인
		Map<String, String> requiredField = new HashMap<>();
		requiredField.put("name", "이름을 입력하세요.");
		requiredField.put("email", "이메일을 입력하세요.");
		requiredField.put("mobile", "전화번호를 입력하세요.");
		requiredField.put("address", "주소를 입력하세요.");
		requiredField.put("height", "키를 입력하세요.");
		requiredField.put("weight", "몸무게를 입력하세요.");
		requiredField.put("age", "나이를 입력하세요.");
		requiredField.put("sex", "성별을 입력하세요.");
		
		validator.check(request, requiredField);
		String id =request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");	
		String email = request.getParameter("email");	
		String mobile = request.getParameter("mobile");	
		String address = request.getParameter("address");	
		String height = request.getParameter("height");	
		String weight = request.getParameter("weight");	
		String age = request.getParameter("age");	
		String sex = request.getParameter("sex");
		
		//이메일 형식 확인
		validator.emailCheck(request);
		//전화번호 형식 확인
		validator.checkMobile(mobile);
		
		
		//수정 내용 저장
		UserDto dto = new UserDto();
		
		dto.setId(id);
		dto.setPassword(pw); // 비밀번호는 히든 걸려서 안보이고 있음
		dto.setName(name);
		dto.setEmail(email);
		dto.setMobile(mobile);
		dto.setAddress(address);
		dto.setHeight((double)Integer.parseInt(height));
		dto.setWeight((double)Integer.parseInt(weight));
		dto.setAge((double)Integer.parseInt(age));
		dto.setSex(sex);
		
		return validator.insertUser(dto);
	}
	
}
