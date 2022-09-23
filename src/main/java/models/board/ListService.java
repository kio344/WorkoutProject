package models.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.admin.board.BoardConfigDao;
import models.admin.board.BoardConfigDto;

public class ListService {
	HttpServletRequest req;
	HttpServletResponse resp;
	BoardConfigDao boardConfigDao = BoardConfigDao.getInstance();
	BoardDao boardDao = BoardDao.getInstance();

	public ListService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;
	}

	public ListService(HttpServletRequest request) {
		this.req = request;
	}

	/**
	 * 해당 게시판의 모든 게시물 가져오기 
	 * 
	 * 
	 * 
	 * @author 5563a
	 * @return
	 */
	public List<BoardDto> getBoard() {

		String boardId = req.getParameter("boardId");
		BoardConfigDto _boardConfig = new BoardConfigDto();
		_boardConfig.setBoardId(boardId);
		if (boardId == null) {
			throw new RuntimeException("잘못된 요청입니다.");
		}

		BoardConfigDto boardConfigDto = boardConfigDao.get(_boardConfig);
		if (boardConfigDto == null) {
			throw new RuntimeException("존재하지 않는 게시판 입니다.");
		}

//		System.out.println(boardConfigDto);
		BoardLimitDto boardDto = new BoardLimitDto();
		boardDto.setBoardId(boardConfigDto.getBoardId());

		List<BoardDto> list = boardDao.gets(boardDto);

		System.out.println(list);

		return list;
	}

	/**
	 * 해당 게시판의 게시물 가져오기 페이지네이션 추가
	 * 
	 * @author 5563a
	 * @return
	 */
	public List<BoardDto> getBoardPage() {

		String boardId = req.getParameter("boardId");
		System.out.println("접속한 게시판: "+boardId);
		BoardConfigDto _boardConfig = new BoardConfigDto();
		_boardConfig.setBoardId(boardId);
		if (boardId == null) {
			throw new RuntimeException("잘못된 요청입니다.");
		}

		BoardConfigDto boardConfigDto = boardConfigDao.get(_boardConfig);
		if (boardConfigDto == null) {
			throw new RuntimeException("존재하지 않는 게시판 입니다.");
		}

		String _num = req.getParameter("num");
		int num;
		
		if (_num == null) {
			req.setAttribute("num", 1);
			num = 1;
		} else {
			try {
				
				num = Integer.parseInt(_num);
			} catch (Exception e) {
				throw new RuntimeException("잘못된 요청입니다.");
				
			}
		}
		


//		System.out.println(boardConfigDto);
		BoardLimitDto boardDto = new BoardLimitDto();
		
		boardDto.setBoardId(boardConfigDto.getBoardId());
		boardDto.setOffset(boardConfigDto.getNoOfRows());
		boardDto.setStart(boardConfigDto.getNoOfRows()*(num-1));

		System.out.println(boardDto.getBoardId());
		
		List<BoardDto> list = boardDao.getpage(boardDto);
		
		int totalBoard=boardDao.getsCount(boardDto);
		int totalPage= (int)Math.ceil( (double)totalBoard /boardConfigDto.getNoOfRows());

		req.setAttribute("totalPage", totalPage);
		System.out.println(list);

		return list;
	}
	
	public List<BoardDto> getBoardPage(String id) {

		String boardId = id;
		BoardConfigDto _boardConfig = new BoardConfigDto();
		_boardConfig.setBoardId(boardId);
		if (boardId == null) {
			throw new RuntimeException("잘못된 요청입니다.");
		}

		BoardConfigDto boardConfigDto = boardConfigDao.get(_boardConfig);
		if (boardConfigDto == null) {
			throw new RuntimeException("존재하지 않는 게시판 입니다.");
		}

		String _num = req.getParameter("num");
		int num;
		
		if (_num == null) {
			req.setAttribute("num", 1);
			num = 1;
		} else {
			try {
				
				num = Integer.parseInt(_num);
			} catch (Exception e) {
				throw new RuntimeException("잘못된 요청입니다.");
				
			}
		}
		


//		System.out.println(boardConfigDto);
		BoardLimitDto boardDto = new BoardLimitDto();

		boardDto.setBoardId(boardConfigDto.getBoardId());
		boardDto.setOffset(boardConfigDto.getNoOfRows());
		boardDto.setStart(boardConfigDto.getNoOfRows()*(num-1));

		List<BoardDto> list = boardDao.getpage(boardDto);
		
		int totalBoard=boardDao.getsCount(boardDto);
		int totalPage= (int)Math.ceil( (double)totalBoard /boardConfigDto.getNoOfRows());

		req.setAttribute("totalPage", totalPage);
		System.out.println(list);

		return list;
	}
	
	/**
	 * 모든 게시글
	 * 개수
	 * @param boardLimitDto
	 * @return
	 */
	public List<BoardDto> getBoardTotal(int count){
		
		BoardLimitDto boardLimitDto=new BoardLimitDto();
		boardLimitDto.setOffset(count);
		boardLimitDto.setStart(0);
		
		
		
		
		return boardDao.getpage(boardLimitDto);
	}
}
