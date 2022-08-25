package filters;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;
import exception.BadException;

public class UserAccessRequestWrapper extends HttpServletRequestWrapper{

	public UserAccessRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public UserAccessRequestWrapper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super(request);
		
		/**
		 * 1. 회원일때 비회원 접근 금지 (401)
		 * 2. 비회원일때 회원페이지 접근 금지(401)
		 * 3. 관리자 페이지 회원, 비회원 접근 금지(401)
		 */
		
		ResourceBundle bundle = ResourceBundle.getBundle("userAccess");
		String memberUrls = bundle.getString("member_urls");
		String guestUrls = bundle.getString("guest_urls");
		String URI = request.getRequestURI();
		HttpSession session = request.getSession();
		UserDto user = (UserDto)session.getAttribute("member");
		
		try {
			/** 1. 회원일때 비회원 페이지 접근시*/
		if(user != null && !guestUrls.isBlank() && guestUrls != null) {
			for(String url : guestUrls.split(",")) {
				if(URI.indexOf(url) != -1) { // 비회원 페이지 접근시
					throw new RuntimeException("비회원 전용 페이지 입니다.");
				}
			}
		}
		
		/** 2. 비회원이 회원페이지 접근시 */
		if(user == null && memberUrls != null && !memberUrls.isBlank()) {
			for(String url : memberUrls.split(",")) {
				if(URI.indexOf(url) != -1) {
					throw new RuntimeException("회원 전용 페이지 입니다.");
				}
			}
		}
		
		/** 3. 관리자 페이지 접근시 */
		
	}catch (RuntimeException e) {
		e.printStackTrace();
		request.setAttribute("statusCode", 401);
		request.setAttribute("errorMessage", e.getMessage());
		RequestDispatcher rd = request.getRequestDispatcher("/errors/error.jsp");
		rd.forward(request, response);
	}
		
}

}
