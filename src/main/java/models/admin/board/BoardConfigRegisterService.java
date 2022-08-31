package models.admin.board;

import javax.servlet.http.HttpServletRequest;

import exception.BadException;

import static jmsUtil.Utils.*;

import java.util.HashMap;
import java.util.Map;

public class BoardConfigRegisterService {
	
	public void register(HttpServletRequest request) {
		// 유효성 검사
		Map<String, String> map = new HashMap<>();
		map.put("boardId", "게시판 아이디를 입력해주세요.");
		map.put("boardName", "게시판 이름을 입력해주세요.");
		ckNullParaMap(request, map);
		
		//값 받아오기
		BoardConfigDto boardConfig = new BoardConfigDto();
		boardConfig.setBoardId(request.getParameter("boardId"));
		boardConfig.setBoardName(request.getParameter("boardName"));
		boardConfig.setNoOfRows(Integer.parseInt(request.getParameter("noOfRows")));
		boardConfig.setIsUse(Integer.parseInt(request.getParameter("isUse")));
		boardConfig.setIsMemberOnly(Integer.parseInt(request.getParameter("isMemberOnly")));
		boardConfig.setUseComment(Integer.parseInt(request.getParameter("useComment")));
		
		//DB 처리
		BoardConfigDao dao = BoardConfigDao.getInstance();
		boolean result = dao.register(boardConfig);
		if(!result) {
			throw new BadException("게시판 등록이 정상적으로 작동하지않았습니다.");
		}
		
	}

}
