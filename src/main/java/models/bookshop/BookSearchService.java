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
	public void search(HttpServletRequest req, String type) {
		SqlSession sqlSession = Connection.getSession();

		String searchType = req.getParameter("type");
		ProductLimitDto dto = new ProductLimitDto();
		int num = Integer.parseInt(req.getParameter("page"));
		dto.setCount(3);
		int strat = (num * dto.getCount()) - dto.getCount();
		dto.setStart(strat);

		int items = sqlSession.selectOne("BookShopMapper.searchItems");
		if (items != 0) {
			int totalPage = (int) (Math.ceil((double) items / dto.getCount()));
			req.setAttribute("totalPage", totalPage);
		}
		if (searchType == null) {
			searchType = "name";
		}

		String search = req.getParameter("search");
		if(search.isBlank() && !type.isBlank()) { 
			throw new BadException("검색하신 결과가 없습니다.");
		}
			
		if (searchType.equals("name")) {
			dto.setName(search);
		} else if (searchType.equals("kategorie")) {
			dto.setKategorie(search);
		} else if (searchType.equals("publisher")) {
			dto.setPublisher(search);
		}
		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.search", dto);

		req.setAttribute("list", list);

/**		req.setAttribute("type", searchType);
		req.setAttribute("search", search); */
	}// search
	
//	public void list(HttpServletRequest req) {
//		SqlSession sqlSession = Connection.getSession();
//
//		ProductLimitDto dto = new ProductLimitDto();
//		int num = Integer.parseInt(req.getParameter("page"));
//		dto.setCount(3);
//		int strat = (num * dto.getCount()) - dto.getCount();
//		dto.setStart(strat);
//
//		int items = sqlSession.selectOne("BookShopMapper.searchItems");
//		if (items != 0) {
//			int totalPage = (int) (Math.ceil((double) items / dto.getCount()));
//			req.setAttribute("totalPage", totalPage);
//		}
//
//		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.pageItems", dto);
//		req.setAttribute("list", list);
//	
//	}
}
