package models.seller;

import javax.servlet.http.HttpServletRequest;

import dto.UserDto;

import static jmsUtil.Utils.*;

public class ProductRemoveService {

	
	public void productRemoveProcess(HttpServletRequest req) {
		String productNum=req.getParameter("abnum");
		System.out.println(productNum);
		UserDto loginUser=getLoginUser(req);
		
		ProductDto product=new ProductDto();
		product.setAbnum(Integer.parseInt(productNum));
		product.setSeller(loginUser.getId());
		
		SellerDao dao=SellerDao.getInstance();
		
		dao.delete(product);
		
		
	}
}
