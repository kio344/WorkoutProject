package models.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;
import models.seller.ProductDto;
import models.seller.SellerDao;

public class ProductSearchService {
	
	public List<ProductDto> search(HttpServletRequest request) {
		String select = request.getParameter("select");
		String str = request.getParameter("str");
		
		if(select == null) {
			select = "seller";
		}
		
		if(str == null) {
			str = "";
		}
		
		SellerDao dao = SellerDao.getInstance();
		int limit = 10;
		String _page = request.getParameter("page");
		int page = (_page == null || _page.isBlank()) ? 1 : Integer.parseInt(_page);
		
		int total = dao.total(select, str);
		
		List<ProductDto> products = dao.searchReq(select, str, page, limit);
		if(products == null) {
			throw new BadException("해당 검색 데이터는 없습니다.");
		}
		
		request.setAttribute("page", page);
		request.setAttribute("total", total);
		request.setAttribute("products", products);
		request.setAttribute("limit", limit);
		
		return products;
	}

}
