package models.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.board.BoardConfigDao;
import models.admin.board.BoardConfigDto;

public class ListService {
	HttpServletRequest req;
	HttpServletResponse resp;
	BoardConfigDao boardConfigDao=BoardConfigDao.getInstance();
	BoardDao boardDao=BoardDao.getInstance();

	public ListService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;
	}

	public ListService(HttpServletRequest request) {
		this.req = request;
	}

	public List<BoardDto> getBoard() {
		
		
		String boardId=req.getParameter("boardId");
		BoardConfigDto _boardConfig=new BoardConfigDto();
		_boardConfig.setBoardId(boardId);
		if (boardId==null) {
			throw new RuntimeException("잘못된 요청입니다.");
		}
		

		BoardConfigDto boardConfigDto=boardConfigDao.get(_boardConfig);
		if (boardConfigDto==null) {
			throw new RuntimeException("존재하지 않는 게시판 입니다.");
		}
		
//		System.out.println(boardConfigDto);
		BoardDto boardDto=new BoardDto();
		boardDto.setBoardId(boardConfigDto.getBoardId());
		
		List<BoardDto> list= boardDao.gets(boardDto);
		
		System.out.println(list);
		
		
		
		return list;
	}
}
