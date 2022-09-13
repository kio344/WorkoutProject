package models.admin;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import mybatis.Connection;

public class UserManageService {

	public void memberGets() {
		SqlSession sqlSession = Connection.getSession();

		UserDto param = new UserDto();
		UserDto list = (UserDto)sqlSession.selectList("userInfoMapper.list", param);
		
		System.out.println(list);
			
		
		
		
//		sqlSession.close();
		
//		System.out.println(list);
		
		
	}
	
	public void memberGet(HttpServletRequest req) {
		SqlSession sqlSession = Connection.getSession();
		
		UserDto user = sqlSession.selectOne("UserInfoMapper.user", req);

		System.out.println(user);
		
		sqlSession.close();
	}
	
	
}
