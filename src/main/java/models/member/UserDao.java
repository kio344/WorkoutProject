package models.member;

import java.net.ConnectException;
import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;

public class UserDao {
	
	private static UserDao instance = new UserDao();
	private UserDao() {}
	/**
	 * 회원 등록
	 */
	public UserDto register(UserDto dto) {
			
		SqlSession sqlsession = mybatis.Connection.getSession();
		int affectedRows = sqlsession.insert("userInfoMapper.insert", dto);
		
		sqlsession.commit();
		sqlsession.close();
		
		if(affectedRows < 1)
			return null;
		
		return null;
	}
	
	/**
	 * 회원 조회
	 */
	
	public UserDto get(String id) {
		
		SqlSession sqlsession = mybatis.Connection.getSession();
		UserDto param = new UserDto();
		param.setId(id);
		
		UserDto member = sqlsession.selectOne("userInfoDto.search", param);
		
		sqlsession.close();
		
		return member;
	}

	/**
	 * 싱글톤 패턴
	 * @return
	 */
	public static UserDao getInstance () {
		if( instance == null) {
			instance = new UserDao();
		}
		return instance;
	}
	
	
}
