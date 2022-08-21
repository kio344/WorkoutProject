package dto.recordDto;

public class BackDto {
	private int backId;
	private String Pullup;
	private String LatPullDown;
	private String SittedLow;
	private String BabelLow;
	private String OneArmLow;
	private String RomanianDeadlift;

	public int getBackId() {
		return backId;
	}

	public void setBackId(int backId) {
		this.backId = backId;
	}

	public String getPullup() {
		return Pullup;
	}

	public void setPullup(String pullup) {
		Pullup = pullup;
	}

	public String getLatPullDown() {
		return LatPullDown;
	}

	public void setLatPullDown(String latPullDown) {
		LatPullDown = latPullDown;
	}

	public String getSittedLow() {
		return SittedLow;
	}

	public void setSittedLow(String sittedLow) {
		SittedLow = sittedLow;
	}

	public String getBabelLow() {
		return BabelLow;
	}

	public void setBabelLow(String babelLow) {
		BabelLow = babelLow;
	}

	public String getOneArmLow() {
		return OneArmLow;
	}

	public void setOneArmLow(String oneArmLow) {
		OneArmLow = oneArmLow;
	}

	public String getRomanianDeadlift() {
		return RomanianDeadlift;
	}

	public void setRomanianDeadlift(String romanianDeadlift) {
		RomanianDeadlift = romanianDeadlift;
	}

	@Override
	public String toString() {
		return "BackDto [backId=" + backId + ", Pullup=" + Pullup + ", LatPullDown=" + LatPullDown + ", SittedLow="
				+ SittedLow + ", BabelLow=" + BabelLow + ", OneArmLow=" + OneArmLow + ", RomanianDeadlift="
				+ RomanianDeadlift + "]";
	}

}
