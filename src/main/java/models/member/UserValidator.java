package models.member;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

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
		UserDto user = sqlsession.selectOne("userInfoMapper.user", param);
		
		sqlsession.close();
		
		if(user != null ) {
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
	
	
	/**
	 * 별명 중복 체크
	 */
	
	public void checkFakeName(String fakeName) {
		SqlSession sqlsession = Connection.getSession();
		
		UserDto param = new UserDto();
		param.setFakeName(fakeName);
		System.out.println("별명으로 찾아보기 = " + param);
		UserDto user = sqlsession.selectOne("userInfoMapper.fakeName", param);
		System.out.println("별명으로 찾아본 아이디의 데이터 = " + user);
		
		sqlsession.close();
		
		
		if(user != null ) {
			throw new BadException("중복된 별명이 존재합니다.");
		}
		
	}
	
	/**
	 * 회원가입
	 * @param dto
	 */
	public UserDto insertUser(UserDto dto ) {
		SqlSession sqlsession = Connection.getSession();
		
		int affectedRows = sqlsession.insert("userInfoMapper.insert", dto);
		
		sqlsession.commit();
		sqlsession.close();
		
		if(affectedRows < 1 ) 
			return null;
		
		return dto;
		
	}
	
	/**
	 * 이메일 형식 체크
	 * @param request
	 */
	public void emailCheck(HttpServletRequest request) {
		String email = request.getParameter("email");
		
		if(email == null || !(email.contains("@")) || !(email.contains("."))) {
			throw new BadException("이메일을 다시 입력해 주세요");
		}
	}
	
}
