package models.file;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jmsUtil.Utils.*;

public class FileDownloadService {

	HttpServletRequest req;
	HttpServletResponse resp;

	public FileDownloadService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;

	}

	public FileDownloadService(HttpServletRequest request) {
		this.req = request;
	}

	public void download() {
		showParaMap(req);
		String downloadNum = req.getParameter("num");
		if (downloadNum == null) {
			throw new RuntimeException("잘못된 접근입니다.");
		}
		
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", downloadNum)
		
	}
}
