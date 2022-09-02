package models.seller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.UserDto;
import models.admin.MessageDto;
import models.message.MessageDao;
import static jmsUtil.Utils.*;

public class MessageService {

	private HttpServletRequest req;
	private MessageDao msgdao=MessageDao.getInstance();
	private UserDto loginUser;	//로그인한 유저
	String[] abnum ;	//선택한 메세지 num
	
	public MessageService(HttpServletRequest request) {
		this.req=request;
		loginUser=getLoginUser(request);
		
	}
	
	public List<MessageDto> getUserMsg() {
		if (getLoginUser(req)==null) {
			 throw new LoginException();
		}
		msgdao = MessageDao.getInstance();

		MessageDto msgdto = new MessageDto();
		msgdto.setRecipient(loginUser.getId());

		List<MessageDto> list = msgdao.getsUserMsg(msgdto);

		return list;

	}

	/**
	 * 메세지 확인, 미확인,삭제 처리
	 * @author 5563a
	 */
	public void seeSetting() {
		String mode = req.getParameter("mode");	//처리할 작업(확인, 미확인, 삭제)
		 abnum = req.getParameterValues("num");	//처리할 메세지 선택(num)
//		System.out.println(Arrays.toString(abnum));
		if (mode.equals("true")) {
//			System.out.println("확인 처리");
			seeSetTrue();
		}
		if (mode.equals("false")) {
//			System.out.println("미 확인 처리");
			seeSetFalse();
		}
		if (mode.equals("delete")) {
//			System.out.println("삭제처리");
			delete();
		}

	}

	
	/**
	 * 메세지 확인 처리
	 * @author 5563a
	 */
	public void seeSetTrue() {
		MessageDto dto=new MessageDto();
		dto.setSee("true");
		for(String num:abnum) {
			
			dto.setNum(Integer.parseInt(num));
			msgdao.update(dto);

		}
		
		
		
	}

	/**
	 * 메세지 미확인 처리
	 * @author 5563a
	 */
	public void seeSetFalse() {
		MessageDto dto=new MessageDto();
		dto.setSee("false");
		for(String num:abnum) {
			
			dto.setNum(Integer.parseInt(num));
			msgdao.update(dto);

		}
		
	}
	
	/**
	 * 메세지 삭제
	 * @author 5563a
	 */
	public void delete() {
		MessageDto dto=new MessageDto();
		for(String num:abnum) {
			dto.setNum(Integer.parseInt(num));
			msgdao.delete(dto);

		}
	}

}
