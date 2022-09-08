package models.board;

import static jmsUtil.Utils.*;

import java.io.IOException;
import java.nio.channels.AlreadyBoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
public interface PosterCk {
	default void posterCheck(BoardDto board,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		UserDto loginDto=getLoginUser(req);
		
		if (!loginDto.getId().equals(board.getPoster())) {
			
			showAlert(resp, "해당 게시물은 본인이 작성한 게시물이 아닙니다.");
			
			replacePage(resp, req.getContextPath()+"/board/view?gid="+board.getGid(), null);
			
			throw new PosterCkException();
			
		}
		
	}
}
