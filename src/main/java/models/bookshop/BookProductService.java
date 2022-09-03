package models.bookshop;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import mybatis.*;

public class BookProductService {

	public void product(int abnum, HttpServletRequest request) {
		
		SqlSession sqlSession = Connection.getSession();
		
		BookShopDto dto =  sqlSession.selectOne("BookShopMapper.get", abnum);
		
		request.setAttribute("dto", dto);
		
		sqlSession.close();
		
	}
}
