package models.admin;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;
import models.seller.SellerDao;

public class ProductUpdateService {

	/**
	 * 승인/미승인 처리 업데이트
	 * @param request
	 */
	public void update(HttpServletRequest request) {
		// 유효성 검사
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		
		if(id == null || id.isBlank()) {
			throw new BadException("잘못된 접근 입니다.");
		}
		if(status == null || status.isBlank()) {
			throw new BadException("잘못된 접근 입니다.");
		}
		
		try {
			Integer.parseInt(id);
		} catch (Exception e) {
			throw new BadException("잘못된 접근 입니다.");
		}
		
		// 승인/미승인 업데이트 처리
		SellerDao dao = SellerDao.getInstance();
		boolean result = dao.updateReq(Integer.parseInt(id), status);
		if(!result) {
			throw new BadException("오류가 발생했습니다.");
		}
		
		
	}
	
}
