package dto.recordDto;

public class RecordDto {
	private int recordId;
	private String set;
	private String count;
	private String memo;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "RecordDto [record=" + recordId + ", set=" + set + ", count=" + count + ", memo=" + memo + "]";
	}

}
