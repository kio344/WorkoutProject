package models.bookshop;

import models.seller.ProductDto;

public class ProductLimitDto extends ProductDto {
	private int start; // 시작 지점
	private int count; // 갯수
	
//	private int limit; 
	
	public ProductLimitDto() {}

	public ProductLimitDto(int start, int count) {
		this.start = start;
		this.count = count;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "ProductLimitDto [start=" + start + ", count=" + count + "]";
	}

}
