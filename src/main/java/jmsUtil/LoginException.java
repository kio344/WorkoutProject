package jmsUtil;

public class LoginException extends RuntimeException{
	public LoginException() {
		super("로그인이 필요한 서비스입니다.");
		
	}
	public LoginException(String msg) {
		super(msg);
		
	}
}
