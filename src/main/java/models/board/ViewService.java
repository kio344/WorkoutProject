package models.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.file.FileDao;
import models.file.FileInfoDto;

import static jmsUtil.Utils.*;

import java.util.List;

public class ViewService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private BoardDao boardDao=BoardDao.getInstance();
	private FileDao fileDao=FileDao.getInstance();
	
	public ViewService(HttpServletRequest request,HttpServletResponse response) {
		this.req=request;
		this.resp=response;
	}
	public ViewService(HttpServletRequest request) {
		this.req=request;
		
	}
	
	public BoardDto get() {
		showParaMap(req);
		String gid=req.getParameter("gid");
		if (gid==null) {
			throw new RuntimeException("잘못된 요청");
		}
		BoardDto _boardDto=new BoardDto();
		_boardDto.setGid(Long.parseLong(gid));
		
		BoardDto boardDto= boardDao.get(_boardDto);
		
		if (boardDto==null) {
			throw new RuntimeException("잘못된 요청");
		}
		
		
		return boardDto;
	}
	
	public List<FileInfoDto> getFile(){
		String gid=req.getParameter("gid");
		FileInfoDto fileInfoDto=new FileInfoDto();
		fileInfoDto.setGid(gid);
		
		
		return fileDao.gets(fileInfoDto);
	}
}
