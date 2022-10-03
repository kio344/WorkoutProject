package models.bookshop;

import java.time.LocalDateTime;

import commons.PaginationAddOn;

public class BookPaymentDto extends ProductLimitDto {
	private int num; // 넘
	private String userId; // 유저 아이디
	private int productNum; // 책 번호
	private int count; // 책 수량
	private LocalDateTime regDt; // 주문한 날짜
	private String destination; // 배송지
	private String progress; // 주문상태

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "BookPaymentDto [num=" + num + ", userId=" + userId + ", productNum=" + productNum + ", count=" + count
				+ ", regDt=" + regDt + ", destination=" + destination + ", progress=" + progress + "]";
	}
	
	

}
