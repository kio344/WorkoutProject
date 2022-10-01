package models.seller;

import models.bookshop.BookPaymentDto;

public class BookPaymentLimitDto extends BookPaymentDto {
	private int start; // 시작 지점
	private int offset; // 갯수
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
}
