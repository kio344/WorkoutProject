package models.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.bcrypt.BCrypt;

import static jmsUtil.Utils.*;
import dto.UserDto;
import models.member.UserDao;

public class LoginService {
	public UserDto login(HttpServletRequest req ) {
		
		showParaMap(req);
		String _id=req.getParameter("id");
		String _password=req.getParameter("password");
		
		UserDto _user=new UserDto();
		_user.setId(_id);
		_user.setPassword(_password);
		
		System.out.println(_user);
		
		UserDao dao=UserDao.getInstance();
		
		UserDto getUserDB=dao.get(_user.getId());
		
		if (getUserDB==null) {
			throw new RuntimeException("아이디 또는 비밀번호를 확인해 주세요");
		}
		
		boolean pwCheck=BCrypt.checkpw(_password, getUserDB.getPassword());
		
		if (!pwCheck) {
			throw new RuntimeException("아이디 또는 비밀번호를 확인해 주세요");

		}
		getUserDB.setPassword("");
		
		HttpSession session=req.getSession();
		session.setAttribute("member",getUserDB );
		
		return getUserDB;
	}
}
