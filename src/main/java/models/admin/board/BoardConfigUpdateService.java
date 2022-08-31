package models.admin.board;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;


public class BoardConfigUpdateService {
	
	public void update(HttpServletRequest request) {
		/** 유효성 검사 S */
		String[] boardIds = request.getParameterValues("boardId");
		if(boardIds == null || boardIds.length == 0) {
			throw new BadException("수정할 게시판을 선택하세요.");
		}
		
		for(String id : boardIds) {
			String boardNm = request.getParameter("boardName_" + id);
			if(boardNm == null || boardNm.isBlank()) {
				throw new BadException("게시판 이름을 입력해주세요.");
			}
		}
		/** 유효성 검사 E */
		
		/** 수정 처리 S */
		BoardConfigDao dao = BoardConfigDao.getInstance();
		for(String id : boardIds) {
			BoardConfigDto dto = new BoardConfigDto();
			String noOfRows = request.getParameter("noOfRows_" + id);
			if(noOfRows == null || noOfRows.isBlank()) {
				noOfRows = "20";
			}
			dto.setBoardId(id);
			dto.setBoardName(request.getParameter("boardName_" + id));
			dto.setNoOfRows(Integer.parseInt(noOfRows));
			dto.setIsUse(Integer.parseInt(request.getParameter("isUse_" + id)));
			dto.setIsMemberOnly(Integer.parseInt(request.getParameter("isMemberOnly_" + id)));
			dto.setUseComment(Integer.parseInt(request.getParameter("useComment_" + id)));
			
			boolean result = dao.update(dto);
			if(!result) {
				throw new BadException("오류가 발생하였습니다. 다시 시도해주세요.");
			}
		}
		/** 수정 처리 E */
		
		
	}

}
