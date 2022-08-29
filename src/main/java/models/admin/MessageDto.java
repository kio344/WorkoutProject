package models.admin;

public class MessageDto {

	private int num;
	private String recipient;
	private String message;
	private String read;

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

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	@Override
	public String toString() {
		return "MessageDto [num=" + num + ", recipient=" + recipient + ", message=" + message + ", read=" + read + "]";
	}
	
	

}
