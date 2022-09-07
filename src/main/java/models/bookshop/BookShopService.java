package models.bookshop;

import java.net.MulticastSocket;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.ibatis.session.SqlSession;
import mybatis.Connection;

public class BookShopService {
	
	public void list(HttpServletRequest req) {
		SqlSession sqlSession = Connection.getSession();
		int num = Integer.parseInt(req.getParameter("page"));
		ProductLimitDto limit = new ProductLimitDto();
		limit.setCount(3);
		
		int strat = (num * limit.getCount()) - limit.getCount();
		
		limit.setStart(strat);
		
		int items = sqlSession.selectOne("BookShopMapper.items");
		int totalPage = (int)(Math.ceil((double)items / limit.getCount()));
		
		req.setAttribute("totalPage", totalPage);
		
		List<BookShopDto> list = sqlSession.selectList("BookShopMapper.pageItems", limit);
		
		req.setAttribute("list", list);
	}
}
