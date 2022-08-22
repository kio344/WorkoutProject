package models.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.mindrot.bcrypt.BCrypt;

import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class LoginService {

	/**
	 * 로그인 처리
	 * 아이디, 비밀번호 값 입력 받고
	 * DB에 유저 정보 검색 후 아이디와 비밀번호 검증
	 * @throws IOException 
	 * 
	 */
	public UserDto search(String id, String pw){
		
		SqlSession sqlsession = Connection.getSession();
		
		UserDto login_user = sqlsession.selectOne("userInfoMapper.check", id);
		
		if(login_user == null) {
			throw new BadException("없는 아이디입니다. 다시 시도해주세요");
		}
		
		if(!BCrypt.checkpw(pw, login_user.getPassword())) {
			throw new BadException("비밀번호가 일치하지 않습니다.");
		}
		return login_user;
		
	}
}
