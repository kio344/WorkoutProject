package models.admin.board;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

public class BoardConfigDeleteService {
	
	public void delete(HttpServletRequest request) {
		/** 유효성 검사 S */
		String[] boardIds = request.getParameterValues("boardId");
		if(boardIds == null || boardIds.length == 0) {
			throw new BadException("삭제할 게시판을 선택하세요.");
		}
		/** 유효성 검사 E */
		
		/** 삭제 처리 S */
		BoardConfigDao dao = BoardConfigDao.getInstance();
		for(String id : boardIds) {
			BoardConfigDto board = new BoardConfigDto();
			board.setBoardId(id);
			dao.delete(board);
		}
		/** 삭제 처리 E */
	}

}
