package models.board;



class BoardLimitDto extends BoardDto{
	private int start;
	private int offset;
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
	@Override
	public String toString() {
		return "BoardLimitDto [start=" + start + ", offset=" + offset + "]";
	}
	
	
}
