package models.board;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import models.file.FileDao;
import models.file.FileInfoDto;

import static jmsUtil.Utils.*;

import java.io.IOException;

public class DeleteService implements PosterCk {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BoardDao boardDao=BoardDao.getInstance();
	private FileDao fileDao=FileDao.getInstance();
	BoardDto getboard=null;
	
	public DeleteService(HttpServletRequest request,HttpServletResponse response) {
		this.req=request;
		this.resp=response;
	}
	
	public void boardDelete() throws IOException {
		showParaMap(req);
		String gid=req.getParameter("gid");
		
		if (gid==null) {
			throw new RuntimeException("잘못된 요청");
		}
		
		if (getLoginUser(req)==null) {
			throw new RuntimeException("로그인 후 사용해 주세요");
		}
		

		deleteBoard(gid);
		deleteFile(gid);
		
		showAlert(resp, "삭제되었습니다.");
		replacePage(resp, req.getContextPath()+"/board/list?boardId="+getboard.getBoardId(), "parent");
		
	}
	
	
	private void deleteBoard(String gid) throws IOException {
		BoardDto dto=new BoardDto();
		dto.setGid(Long.parseLong(gid));
		
		getboard=boardDao.get(dto);
		
		posterCheck(getboard, req, resp);
		
		boardDao.delete(dto);

	}
	
	
	private void deleteFile(String gid) {
		FileInfoDto dto=new FileInfoDto();
		dto.setGid(gid);
		
		fileDao.delete(dto);

		
	}


}
