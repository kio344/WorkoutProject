package models.member;

import org.apache.ibatis.session.SqlSession;

import commons.Validator;
import dto.UserDto;
import exception.BadException;
import mybatis.Connection;

public class UserValidator implements Validator{

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
	
	
	
}
