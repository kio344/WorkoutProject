package models.seller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	public OrderService() {
		
	}
	
	public OrderService(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}

}
