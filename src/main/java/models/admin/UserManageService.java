package models.admin;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import mybatis.Connection;

public class UserManageService {

	public List<UserDto> service(HttpServletRequest request) {

		String select = request.getParameter("select");
		String text = request.getParameter("str");

		if (select == null || select.isBlank()) {
			select = "name";
		}

		if (text == null || text.isBlank()) {
			text = "";
		}

		UserDto param = new UserDto();

		switch (select) {
		case "name":
				param.setName("%" + text + "%");
			break;
		case "fakeName":
				param.setFakeName("%" + text + "%");
			break;
		case "sex":
				param.setSex("%" + text + "%");
			break;
		case "id":
				param.setId("%" + text + "%");
			break;
		case "userType":
				param.setUserType("%" + text + "%");
			break;
		}
		
		List<UserDto> members = adminUserGets(param);
		
		return members;

	}

	public List<UserDto> adminUserGets(UserDto param) {
		SqlSession sqlSession = Connection.getSession();

		List<UserDto> members = sqlSession.selectList("userInfoMapper.adminUser", param);

		return members;
	}

	public void memberGets() {
		SqlSession sqlSession = Connection.getSession();

		UserDto param = new UserDto();
		UserDto list = (UserDto) sqlSession.selectList("userInfoMapper.list", param);

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
