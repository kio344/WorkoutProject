package controllers.seller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.bookshop.BookPaymentDto;
import mybatis.Connection;

public class PaymentDao {
	private static PaymentDao instance=new PaymentDao();
	
	private PaymentDao() {}
	
	public List<BookPaymentDto> gets(BookPaymentDto dto){
		SqlSession session=Connection.getSession();
		
		List<BookPaymentDto> list=session.selectList("BookPaymentMapper.gets",dto);
		
		System.out.println(list);
		
		return list;
	}
	
	
	public static PaymentDao getInstance() {
		if (instance==null) {
			instance=new PaymentDao();
		}
		
		return instance;
	}
}
