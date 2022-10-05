package models.admin;

import javax.servlet.http.HttpServletRequest;

import models.qAnda.QAndADao;
import models.seller.SellerDao;

public class AdminService {
	
	public void service(HttpServletRequest request) {
		
		int qna = QAndADao.getInstance().count();
		
		int product = SellerDao.getInstance().count();
		
		request.setAttribute("QnA", qna);
		request.setAttribute("product", product);
		
	}

}
