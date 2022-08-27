package models.admin;

import java.util.List;

import models.seller.ProductDto;
import models.seller.SellerDao;

public class AdminProductService {
	
	/**
	 * 승인 요청 한 판매 신청 목록 불러오기
	 * @return
	 */
	public List<ProductDto> gets() {
		
		SellerDao dao = SellerDao.getInstance();
		
		List<ProductDto> products = dao.getReq("req");
		
		return products;
	}

}
