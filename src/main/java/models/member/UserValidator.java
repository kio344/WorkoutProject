package models.member;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.ibatis.session.SqlSession;

import commons.Validator;
import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class UserValidator implements Validator, MobileValidator{

	/**
	 * 아이디 중복 체크
	 * @param id
	 */
	public void overlapUser(String id) {
		SqlSession sqlsession = Connection.getSession();
		
		UserDto param = new UserDto();
		param.setId(id);
		
		int count = sqlsession.selectOne("userInfoMapper.user", id);
		
		sqlsession.close();
		
		if(count > 0 ) {
			throw new BadException("이미 등록된 회원입니다.");
		}
	}
	
	/**
	 * 아이디 복잡성 체크
	 * @param id
	 */
	public void checkUserId(String id) {
		if(id.length() < 6) {
			throw new BadException("아아디가 짧습니다 6자리 이상으로 입력해 주세요.");
		}
		Pattern pattern = Pattern.compile("[^a-z0-9]", Pattern.CASE_INSENSITIVE); //패턴 알파벳, 숫자가 아닌 것 예외 처리
		Matcher matcher = pattern.matcher(id);
		if(matcher.find()){
			throw new BadException("아이디는 영문, 숫자만 입력해 주세요.");
		}
	}
	
}
