package filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import dto.UserDto;
import models.admin.MessageDto;
import models.message.MessageDao;

import static jmsUtil.Utils.*;

public class GetMessageReqWap extends HttpServletRequestWrapper {
	
	public GetMessageReqWap(HttpServletRequest request) {
		super(request);

		GetMessage();
	}

	private void GetMessage() {
		HttpServletRequest req=(HttpServletRequest)this.getRequest();
		
		UserDto user=getLoginUser(req);
		if (user==null) {
			return;
		}
		
	MessageDao dao=MessageDao.getInstance();
	MessageDto msg=new MessageDto();
	msg.setSee("false");
	msg.setRecipient(user.getId());
	int myCount= dao.getsUserMsgC(msg);
	req.setAttribute("readNotMsg", myCount);
	System.out.println(myCount);
		
	}
	
}
