package exception;

public class BadException extends RuntimeException{
	
	public BadException () {
		this("잘못된 요청입니다.");
	}
	
	public BadException(String msg) {
		super(msg);
	}
	
}
