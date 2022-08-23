package models.seller;

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
	
	public static SellerDao getInstance() {
		if (instance==null) {
			instance=new SellerDao();
		}
		return instance;
	}
}
