package models.qAnda;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class QAndAListService {
	
	public void list(HttpServletRequest request) {
		QAndADao dao = QAndADao.getInstance();
		
		int limit = 10;
		String _page = request.getParameter("page");
		int page = (_page == null || _page.isBlank()) ? 1 : Integer.parseInt(_page);
		
		int total = dao.total();
		
		List<QAndADto> dtos = dao.gets(page, limit);
		
		request.setAttribute("page", page);
		request.setAttribute("total", total);
		request.setAttribute("list", dtos);
		request.setAttribute("limit", limit);
		
	}

}
