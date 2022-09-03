package models.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jmsUtil.Utils.*;

public class WriteService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	
	public WriteService(HttpServletRequest request,HttpServletResponse response) {
		req=request;
		resp=response;

	}
	public WriteService(HttpServletRequest request) {
		req=request;
	}
	
	public void write() {
		showParaMap(req);
	}
}
