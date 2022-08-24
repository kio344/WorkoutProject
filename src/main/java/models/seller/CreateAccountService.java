package models.seller;

import javax.servlet.http.HttpServletRequest;

import dto.UserDto;
import models.member.UserDao;

import static jmsUtil.Utils.*;
public class CreateAccountService {
	public void createAccount(HttpServletRequest req) {
		showParaMap(req);
		
		ckNullParaMap(req);
		
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String name = req.getParameter("passwordRe");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");
		
		UserDto user=new UserDto();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setAddress(address);
		
		UserDao dao=UserDao.getInstance();
		dao.insertSeller(user);
		
	}
}
