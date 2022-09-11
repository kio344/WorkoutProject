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
	final static int Limit = 7;

	public List<ProductDto> getlist(HttpServletRequest req) {
		showParaMap(req);

		Map<String, String> check = new HashMap<>();
		check.put("status", "잘못된 요청 입니다.");

		ckNullParaMap(req, check);

		HttpSession session = req.getSession();
		UserDto userDto = (UserDto) session.getAttribute("member");

		if (userDto == null) {
			throw new LoginException();
		}

		SellerDao dao = SellerDao.getInstance();

		String seller = userDto.getId();
		String status = req.getParameter("status");

		ProductDto product = new ProductDto();
		product.setSeller(seller);
		product.setStatus(status);

		return dao.getProductList(product);
	}

	public List<ProductListDto> getlistPage(HttpServletRequest req) {
		showParaMap(req);

		Map<String, String> check = new HashMap<>();
		check.put("status", "잘못된 요청 입니다.");

		String _num = req.getParameter("num");
		
		int num = 0;
		if (_num == null || _num.equals("")) {
			num = 1;
		}else {
			num=Integer.parseInt(_num);
		}
		System.out.println(num);
		
		ckNullParaMap(req, check);

		HttpSession session = req.getSession();
		UserDto userDto = (UserDto) session.getAttribute("member");

		if (userDto == null) {
			throw new LoginException();
		}

		SellerDao dao = SellerDao.getInstance();

		String seller = userDto.getId();
		String status = req.getParameter("status");

		ProductListDto product = new ProductListDto();
		product.setSeller(seller);
		product.setStatus(status);
		product.setOffset(Limit * (num - 1));
		product.setLimit(Limit);
		
		int total=dao.getlistPageCount(product);
		int totalPage=(int)(Math.ceil((double)total/Limit));
		req.setAttribute("totalPage", totalPage);

		return dao.getProductListPage(product);
	}
	

}
