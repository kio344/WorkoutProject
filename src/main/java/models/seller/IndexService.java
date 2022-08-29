package models.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dto.UserDto;

import static jmsUtil.Utils.*;

public class IndexService {
	public void process(HttpServletRequest req) {
		UserDto loginUser = getLoginUser(req);

		if (loginUser==null) {
			throw new  LoginException();
		}
		
		SellerDao dao = SellerDao.getInstance();

		ProductDto product = new ProductDto();
		product.setSeller(loginUser.getId());

		product.setStatus("req");
		int reqCount = dao.getlistCount(product);

		product.setStatus("true");
		int trueCount = dao.getlistCount(product);

		product.setStatus("false");
		int falseCount = dao.getlistCount(product);
		
		req.setAttribute("reqCount", reqCount);
		req.setAttribute("trueCount", trueCount);
		req.setAttribute("falseCount", falseCount);

	}
}
