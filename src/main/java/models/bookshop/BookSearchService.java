package models.bookshop;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import exception.BadException;
import mybatis.Connection;

public class BookSearchService {

	/**
	 * 책 카테고리별 검색
	 * 
	 * @param req
	 */
	public void search(HttpServletRequest req) {
		SqlSession sqlSession = Connection.getSession();
		String searchType = req.getParameter("type");
		ProductLimitDto dto = new ProductLimitDto();
		int num = Integer.parseInt(req.getParameter("page"));
		String search = req.getParameter("search");
		
		if (searchType == null || searchType.isBlank()) {
			searchType = "name";
		}

		if (searchType.equals("name")) {
			dto.setName(search);
		} else if (searchType.equals("kategorie")) {
			dto.setKategorie(search);
		} else if (searchType.equals("publisher")) {
			dto.setPublisher(search);
		}

		dto.setCount(3);
		int start = (num * dto.getCount()) - dto.getCount();
		
		int searchCount = sqlSession.selectOne("BookShopMapper.searchProduct", dto);
		if(search.isBlank() || search.equals(null)) {
			dto.setStart(start);
		}else {
			dto.setStart(searchCount);
		}
		
		dto.setStart(start);
		
		if (searchCount != 0) { 
			int totalPage = (int)(Math.ceil((double) searchCount / dto.getCount()));
			req.setAttribute("totalPage", totalPage);
		}

		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.search", dto);
		
		req.setAttribute("list", list);

		req.setAttribute("type", searchType);
		req.setAttribute("search", search); 
	}// search
}
