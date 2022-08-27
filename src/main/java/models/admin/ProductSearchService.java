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
		
		List<ProductDto> products = dao.searchReq(select, str);
		if(products == null) {
			throw new BadException("해당 검색 데이터는 없습니다.");
		}
		
		return products;
	}

}
