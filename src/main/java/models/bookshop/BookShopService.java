package models.bookshop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class BookShopService {
	
	
	public void list(HttpServletRequest req) {
		SqlSession sqlSession = Connection.getSession();
		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.listAll");
		
		req.setAttribute("list", list);
		

	}
	
	
}
