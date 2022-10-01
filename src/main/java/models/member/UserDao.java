package models.member;

import java.net.ConnectException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import models.seller.ProductDto;
import models.seller.ProductListDto;
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
	
	/**
	 * 유저 관리자에서 유저 검색
	 * @param select
	 * @param str
	 * @return
	 */
	public List<UserDto> searchMember(String select, String str) {
		SqlSession sqlSession = Connection.getSession();
		UserDto param = new UserDto();
		
		if(select.equals("name")) {
			param.setName("%" + str + "%");
		} else if(select.equals("fakeName")) {
			param.setFakeName("%" + str + "%");
		} else if(select.equals("sex")) {
			param.setSex("%" + str + "%");
		} else if(select.equals("id")) {
			param.setId("%" + str + "%");
		} else if(select.equals("userType")) {
			param.setUserType("%" + str + "%");
		}
		
		List<UserDto> member = sqlSession.selectList("UserInfoMapper.search", param);
		
		sqlSession.close();
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
