package models.seller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jmsUtil.Utils.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.UserDto;

public class GetProductListService {
	public List<ProductDto> getlist(HttpServletRequest req){
		showParaMap(req);
		
		Map<String, String> check=new HashMap<>();
		check.put("status", "잘못된 요청 입니다.");
		
		ckNullParaMap(req,check);
		
		HttpSession session=req.getSession();
		UserDto userDto=(UserDto)session.getAttribute("member");
		
		if (userDto==null) {
			throw new LoginException();
		}
		
		SellerDao dao=SellerDao.getInstance();
		
		String seller=userDto.getId();
		String status=req.getParameter("status");
		
		ProductDto product=new ProductDto();
		product.setSeller(seller);
		product.setStatus(status);
		
		return dao.getProductList(product);
	}
}
