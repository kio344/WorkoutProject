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
	
	
	public static SellerDao getInstance() {
		if (instance==null) {
			instance=new SellerDao();
		}
		return instance;
	}
}
