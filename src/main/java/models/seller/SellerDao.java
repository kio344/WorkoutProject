package models.seller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.Connection;

public class SellerDao {
	private static SellerDao instance=new SellerDao();
	private SellerDao() {}
	
	public void register(ProductDto product) {
		SqlSession session=Connection.getSession();
		
		session.insert("RequestProductMap.register",product);
		
		session.commit();
		session.close();
		
	}
	
	/**
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
	
	public static SellerDao getInstance() {
		if (instance==null) {
			instance=new SellerDao();
		}
		return instance;
	}
}
