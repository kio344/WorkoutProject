package models.admin;

public class MessageDto {

	private int num;
	private String recipient;
	private String message;
	private String see;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSee() {
		return see;
	}
	public void setSee(String see) {
		this.see = see;
	}
	@Override
	public String toString() {
		return "MessageDto [num=" + num + ", recipient=" + recipient + ", message=" + message + ", see=" + see + "]";
	}

}
