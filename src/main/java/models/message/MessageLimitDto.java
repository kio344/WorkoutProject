package models.message;

import models.admin.MessageDto;

public class MessageLimitDto extends MessageDto {
	private int offset;
	private int start;
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		return "MessageLimiteDto [offset=" + offset + ", start=" + start + "]";
	}
	
	
}
