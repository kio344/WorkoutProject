package controllers.seller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.bookshop.BookPaymentDto;
import models.seller.BookPaymentLimitDto;
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
	
	public BookPaymentDto update(BookPaymentDto dto) {
		SqlSession session=Connection.getSession();

		session.update("BookPaymentMapper.update",dto);
		session.commit();
		System.out.println(dto);
		session.close();
		return dto;
	}
	
	public int getsCount(BookPaymentLimitDto dto) {
		SqlSession session=Connection.getSession();

		int result =session.selectOne("BookPaymentMapper.getsCount",dto);


		
		session.close();
		return result;
	}
	
	
	public static PaymentDao getInstance() {
		if (instance==null) {
			instance=new PaymentDao();
		}
		
		return instance;
	}
	
	
}
