package models.seller;

public class LoginException extends RuntimeException{
	public LoginException() {
		super("로그인후 사용해주세요");
	}
	public LoginException(String msg) {
		super(msg);
	}
}
