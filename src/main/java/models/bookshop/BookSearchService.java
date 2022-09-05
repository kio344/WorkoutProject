package models.bookshop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class BookSearchService {
	
	/**
	 * 책 검색
	 * @param req
	 */
	public void search(HttpServletRequest req) {
		
		String bookName = req.getParameter("bookName");
		
		SqlSession sqlSession = Connection.getSession();
		
		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.search", bookName);
		
		System.out.println(list);
		req.setAttribute("bookList", list);
	}
}
