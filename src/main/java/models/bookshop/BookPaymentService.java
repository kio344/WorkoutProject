package models.bookshop;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class BookPaymentService {
	
	public void setDto(HttpServletRequest req) throws Exception{
		BookPaymentDto dto = new BookPaymentDto();
		req.setCharacterEncoding("UTF-8");
		String userId = req.getParameter("userId");
		int abnum = Integer.parseInt(req.getParameter("abnum"));
		int count = Integer.parseInt(req.getParameter("count"));
		String addr = req.getParameter("addr");
		String datiladdr = req.getParameter("datiladdr");
		String address = (addr + " " + datiladdr);
		
		dto.setUserId(userId);
		dto.setProductNum(abnum);
		dto.setCount(count);
		dto.setDestination(address);
		dto.setProgress(BookProgress.PAYMENT.toString());
		
		SqlSession session = Connection.getSession();
		
		int affectedRows = session.insert("BookPaymentMapper.insertInfo", dto);
		
		session.commit();
		session.close();
		
		if(affectedRows < 1 ) {
			return;
		}
	}
}
