package models.member;

import java.net.ConnectException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import mybatis.Connection;

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
		
		return dto;
	}
	
	/**
	 * 회원 정보 수정
	 * @param dto
	 */
	public void update(UserDto dto) {
		SqlSession sqlSession = Connection.getSession();
		
		sqlSession.update("userInfoMapper.update", dto);
		
		sqlSession.commit();
		sqlSession.close();
		
	}
	/**
	 * 회원 타입정보 수정
	 * @param dto
	 */
	public void typeUpdate(UserDto dto) {
		SqlSession sqlSession = Connection.getSession();
		
		sqlSession.update("userInfoMapper.typeUpdate", dto);
		
		sqlSession.commit();
		sqlSession.close();
		
	}

	
	/**
	 * 유저(판매자) 정보 추가
	 * @param user
	 * @return
	 * @author 정민상
	 */
	public UserDto insertSeller(UserDto user) {
		SqlSession sqlsession = mybatis.Connection.getSession();
		int affectedRows = sqlsession.insert("userInfoMapper.insertSeller", user);
		
		sqlsession.commit();
		sqlsession.close();
		
		if(affectedRows < 1)
			return null;
		
		return user;
	}
	
	/**
	 * 회원 조회
	 */
	
	public UserDto get(String id) {
		
		SqlSession sqlsession = mybatis.Connection.getSession();
		UserDto param = new UserDto();
		param.setId(id);
		
		UserDto member = sqlsession.selectOne("userInfoMapper.user", param);
		
		sqlsession.close();
		
		return member;
	}
	
	public boolean bmiUpdate(UserDto dto) {
		SqlSession sqlSession = mybatis.Connection.getSession();
		int affectedRows = sqlSession.update("userInfoMapper.bmiUpdate", dto);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	/**
	 * 회원 삭제
	 */
	public boolean delete(UserDto userDto) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.delete("userInfoMapper.delete", userDto);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	/**
	 * 관리자가 회원 삭제
	 */
	public boolean userDelete(int num) {
		SqlSession sqlSession = Connection.getSession();
		
		int affectedRows = sqlSession.delete("userInfoMapper.userDelete", num);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
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
