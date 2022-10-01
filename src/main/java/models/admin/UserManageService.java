package models.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import exception.BadException;
import models.member.UserDao;
import mybatis.Connection;

public class UserManageService {

	public List<UserDto> memberGets() {
		SqlSession sqlSession = Connection.getSession();
		
		List<UserDto> lists = new ArrayList<>();
		lists = sqlSession.selectList("userInfoMapper.list");
		
		sqlSession.close();
		
		return lists;
	}
	
	public List<UserDto> memberGet(HttpServletRequest req) {
		
		String select = req.getParameter("select");
		String str = req.getParameter("str");
		
		if(select == null) {
			select = "name";
		}
		
		if(str == null) {
			str = "";
		}
		
		UserDao dao = UserDao.getInstance(); 
		
		List<UserDto> user = dao.searchMember(select, str);
		
		if(user == null) {
			throw new BadException("검색 요건을 충족하는 사용자가 없습니다.");
		}
		
		req.setAttribute("user", user);
		
		return user;
	}
	
}
