package models.seller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
		
		sqlSession.commit();
		sqlSession.close();
		return affectedRows > 0;
	}
	
	
	public List<ProductDto> searchReq(String select, String str) {
		SqlSession sqlSession = Connection.getSession();
		ProductDto param = new ProductDto();
		if(select.equals("seller")) {
			param.setSeller("%" + str + "%");
		} else if(select.equals("name")) {
			param.setName("%" + str + "%");
		} else if(select.equals("kategorie")) {
			param.setKategorie("%" + str + "%");
		} else if(select.equals("company")) {
			param.setCompany("%" + str + "%");
		}
		
		List<ProductDto> products = sqlSession.selectList("RequestProductMap.searchReq", param);
		
		
		sqlSession.close();
		return products;
	}
	

	public static SellerDao getInstance() {
		if (instance==null) {
			instance=new SellerDao();
		}
		return instance;
	}
}
