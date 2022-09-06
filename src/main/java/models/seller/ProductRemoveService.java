package models.seller;

import javax.servlet.http.HttpServletRequest;

public class ProductRemoveService {
	public void productRemove(HttpServletRequest req) {
		System.out.println(req.getAttribute("abnum"));
	}
}
