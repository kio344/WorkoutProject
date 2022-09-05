package models.bookshop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class BookSearchService {

	/**
	 * 책 검색
	 * 
	 * @param req
	 */
	public void search(HttpServletRequest req, String type) {
		String searchType = req.getParameter("type");
		BookShopDto dto = new BookShopDto();
		String search = req.getParameter("search");
		if(searchType == null) {
			searchType = "name";
		}

		if (searchType.equals("name")) {
			dto.setName(search);
		} else if (searchType.equals("kategorie")) {
			dto.setKategorie(search);
		} else if (searchType.equals("publisher")) {
			dto.setPublisher(search);
		}

		SqlSession sqlSession = Connection.getSession();

		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.search", dto);
		req.setAttribute("bookList", list);

	}
}
