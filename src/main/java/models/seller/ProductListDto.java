package models.seller;

public class ProductListDto extends ProductDto{
	
	private int offset; // 레코드 시작 지점
	private int limit; // 레코드 추출 갯수

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
