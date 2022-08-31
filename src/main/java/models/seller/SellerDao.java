package models.seller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import models.admin.MessageDto;
import mybatis.Connection;

public class SellerDao {
	private static SellerDao instance=new SellerDao();
	private SellerDao() {}
	
	/**
	 * @author 5563a
	 * @param product
	 */
	public ProductDto register(ProductDto product) {
		SqlSession session=Connection.getSession();
		
		session.insert("RequestProductMap.register",product);
		
		session.commit();
		session.close();
		
		return product;
	}
	
	/**

	 * 
	 * 판매자, 요청 상품 상태 만 채워주면 됩니다.
	 * 
	 * @param product
	 */
	public List<ProductDto> getProductList(ProductDto product) {
		SqlSession session=Connection.getSession();
		
		List<ProductDto> list=session.selectList("RequestProductMap.getlist",product);
		
		return list;
	}
	
	/**
	 * 신청자(Userid) , status : 상태값(요청중(req),승인(ture),거부(false)) 조건으로 상품 갯수 가져옴
	 * @param product - seller status 만채워주면 됨
	 * @return 해당 seller status 에 맞는 상품 갯수
	 */
	public int getlistCount(ProductDto product) {
		SqlSession session=Connection.getSession();
		int count =session.selectOne("RequestProductMap.getlistCount",product);
		
		session.close();
		
		return count;
	}
	
	
/*
	 * status 값에 따른 판매 신청 목록 불러오기
	 * @param status
	 * @return
	 */
	public List<ProductDto> getReq(String status) {
		SqlSession sqlSession = Connection.getSession();
		ProductDto param = new ProductDto();
		param.setStatus(status);
		
		List<ProductDto> products = sqlSession.selectList("RequestProductMap.getReq", param);
		
		sqlSession.close();
		return products;
	}
	
	/**
	 * 승인/미승인 status 업데이트
	 * 승인/미승인에 관한 메세지 판매자에게 전송
	 * @param abnum
	 * @param status
	 * @return
	 */
	public boolean updateReq(int abnum, String status) {
		SqlSession sqlSession = Connection.getSession();
		ProductDto param = new ProductDto();
		param.setAbnum(abnum);
		param.setStatus(status);
		
		int affectedRows = sqlSession.update("RequestProductMap.statusUp", param);
		
		
		ProductDto param1 = new ProductDto();
		param1.setAbnum(abnum);
		param1.setStatus(status);
		
		ProductDto product = sqlSession.selectOne("RequestProductMap.get", param1);
		
		MessageDto msg = new MessageDto();
		
		String str = (status.equals("true")) ? "승인" : "미승인";
		String name = product.getName();
		String m1 = "관리자가 " + name + " 상품을 " + str + " 했습니다.";
		
		msg.setRecipient(product.getSeller());
		msg.setMessage(m1);
		
		int nums = sqlSession.insert("MessageMapper.sendMsg", msg);
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0 && nums > 0;
	}
	
	/**
	 * 상품 신청 목록 검색(승인/미승인 처리 안된 상품)
	 * @param select
	 * @param str
	 * @return
	 */
	public List<ProductDto> searchReq(String select, String str, int page, int limit) {
		SqlSession sqlSession = Connection.getSession();
		ProductListDto param = new ProductListDto();
		if(select.equals("seller")) {
			param.setSeller("%" + str + "%");
		} else if(select.equals("name")) {
			param.setName("%" + str + "%");
		} else if(select.equals("kategorie")) {
			param.setKategorie("%" + str + "%");
		} else if(select.equals("company")) {
			param.setCompany("%" + str + "%");
		}
		
		int offset = (page - 1) * limit;
		
		param.setLimit(limit);
		param.setOffset(offset);
		
		List<ProductDto> products = sqlSession.selectList("RequestProductMap.searchReq", param);
		
		
		sqlSession.close();
		return products;
	}
	
	public int total(String select, String str) {
		SqlSession sqlSession = Connection.getSession();
		ProductListDto param = new ProductListDto();
		if(select.equals("seller")) {
			param.setSeller("%" + str + "%");
		} else if(select.equals("name")) {
			param.setName("%" + str + "%");
		} else if(select.equals("kategorie")) {
			param.setKategorie("%" + str + "%");
		} else if(select.equals("company")) {
			param.setCompany("%" + str + "%");
		}
		
		int total = sqlSession.selectOne("RequestProductMap.countReq", param);
		sqlSession.close();
		return total;
		
	}
	 

	public static SellerDao getInstance() {
		if (instance==null) {
			instance=new SellerDao();
		}
		return instance;
	}
}
