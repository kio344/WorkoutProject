package filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import controllers.seller.PaymentDao;
import dto.UserDto;
import models.admin.MessageDto;
import models.message.MessageDao;
import models.seller.BookPaymentLimitDto;
import models.seller.SellerDao;

import static jmsUtil.Utils.*;

public class GetMessageReqWap extends HttpServletRequestWrapper {

	public GetMessageReqWap(HttpServletRequest request) {
		super(request);

		GetMessage();
		getOrder();
	}

	private void getOrder() {
		HttpServletRequest req = (HttpServletRequest) this.getRequest();

		UserDto user = getLoginUser(req);
		if (user == null) {
			return;
		}

		 PaymentDao dao = PaymentDao.getInstance();
		BookPaymentLimitDto paymentDto = new BookPaymentLimitDto();
		
		paymentDto.setSeller(user.getId());
		paymentDto.setProgress("payment");
		
		
		req.setAttribute("orderCount", dao.getsCount(paymentDto));

	}

	private void GetMessage() {
		HttpServletRequest req = (HttpServletRequest) this.getRequest();

		UserDto user = getLoginUser(req);
		if (user == null) {
			return;
		}

		MessageDao dao = MessageDao.getInstance();
		MessageDto msg = new MessageDto();
		msg.setSee("false");
		msg.setRecipient(user.getId());
		int myCount = dao.getsUserMsgC(msg);
		req.setAttribute("readNotMsg", myCount);

	}

}
