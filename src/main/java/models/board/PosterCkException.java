package models.board;

public class PosterCkException extends RuntimeException {
	public PosterCkException() {
		super("본인이 작성한글이 아닙니다.");
	}
	public PosterCkException(String msg) {
		super(msg);
	}
}
