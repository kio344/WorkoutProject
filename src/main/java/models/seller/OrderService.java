package models.seller;

import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.seller.PaymentDao;
import models.bookshop.BookPaymentDto;

public class OrderService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	PaymentDao dao=PaymentDao.getInstance();
	
	private String mode;
	
	private String[] abnums;
	
	public OrderService() {
		
	}
	
	public OrderService(HttpServletRequest req, HttpServletResponse resp) {
		this.req=req;
		this.resp=resp;
	}
	
	public void setOrderProcess() {
		mode = req.getParameter("mode");	//처리할 작업(확인, 미확인, 삭제)
		mode=mode.toLowerCase();
		abnums = req.getParameterValues("abnum");
		System.out.println(mode);
		System.out.println(Arrays.toString(abnums));
		
		for(String abnum:abnums) {
		BookPaymentDto dto=new BookPaymentDto();
		dto.setNum(Integer.parseInt(abnum));
		dto.setProgress(mode);
		
		dao.update(dto);
		}
		
		
		
	}

}
