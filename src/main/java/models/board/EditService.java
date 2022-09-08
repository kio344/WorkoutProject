package models.board;

import static jmsUtil.Utils.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import models.file.FileDao;
import models.file.FileInfoDto;
import models.seller.LoginException;

public class EditService implements PosterCk{
	HttpServletRequest req;
	HttpServletResponse resp;
	BoardDao boardDao = BoardDao.getInstance();
	FileDao fileDao = FileDao.getInstance();

	public EditService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;
	}

	public EditService(HttpServletRequest request) {
		this.req = request;
	}

	public BoardDto get() throws IOException {
		showParaMap(req);
		String gid = req.getParameter("gid");
		if (gid == null) {
			throw new RuntimeException("잘못된 요청입니다.");
		}
		BoardDto _dto = new BoardDto();
		_dto.setGid(Long.parseLong(gid));

		BoardDto dto = boardDao.get(_dto);
		
		posterCheck(dto, req, resp);

		return dto;
	}



	public List<FileInfoDto> getFile() {
		String gid = req.getParameter("gid");
		FileInfoDto fileInfoDto = new FileInfoDto();
		fileInfoDto.setGid(gid);

		return fileDao.gets(fileInfoDto);
	}

	public BoardDto editService() {
	
		String subject = req.getParameter("subject");
		String gid = req.getParameter("gid");
		String content = req.getParameter("content");

		BoardDto boardDto = new BoardDto();
		boardDto.setSubject(subject);
		boardDto.setGid(Long.parseLong(gid));
		boardDto.setContent(content);

		boardDao.update(boardDto);
		
		return boardDto;
	}

}
