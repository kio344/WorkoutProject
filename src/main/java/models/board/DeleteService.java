package models.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.file.FileDao;
import models.file.FileInfoDto;

import static jmsUtil.Utils.*;

public class DeleteService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BoardDao boardDao=BoardDao.getInstance();
	private FileDao fileDao=FileDao.getInstance();
	
	public DeleteService(HttpServletRequest request,HttpServletResponse response) {
		this.req=request;
		this.resp=response;
	}
	
	public void boardDelete() {
		showParaMap(req);
		String gid=req.getParameter("gid");
		
		if (gid==null) {
			throw new RuntimeException("잘못된 요청");
		}
		
		deleteBoard(gid);
		deleteFile(gid);
	}
	private void deleteBoard(String gid) {
		BoardDto dto=new BoardDto();
		dto.setGid(Long.parseLong(gid));
		
		boardDao.delete(dto);

	}
	private void deleteFile(String gid) {
		FileInfoDto dto=new FileInfoDto();
		dto.setGid(gid);
		
		fileDao.delete(dto);

		
	}


}
