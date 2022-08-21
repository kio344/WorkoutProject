package dto.recordDto;

public class ChestDto {
	private int chestId;
	private String BenchPress;
	private String DumbbellPress;
	private String InclineBenchPress;
	private String DumbbellFly;
	private String Dips;
	private String CableCrossOver;

	public int getchestId() {
		return chestId;
	}

	public void setchestId(int chestId) {
		chestId = chestId;
	}

	public String getBenchPress() {
		return BenchPress;
	}

	public void setBenchPress(String benchPress) {
		BenchPress = benchPress;
	}

	public String getDumbbellPress() {
		return DumbbellPress;
	}

	public void setDumbbellPress(String dumbbellPress) {
		DumbbellPress = dumbbellPress;
	}

	public String getInclineBenchPress() {
		return InclineBenchPress;
	}

	public void setInclineBenchPress(String inclineBenchPress) {
		InclineBenchPress = inclineBenchPress;
	}

	public String getDumbbellFly() {
		return DumbbellFly;
	}

	public void setDumbbellFly(String dumbbellFly) {
		DumbbellFly = dumbbellFly;
	}

	public String getDips() {
		return Dips;
	}

	public void setDips(String dips) {
		Dips = dips;
	}

	public String getCableCrossOver() {
		return CableCrossOver;
	}

	public void setCableCrossOver(String cableCrossOver) {
		CableCrossOver = cableCrossOver;
	}

	@Override
	public String toString() {
		return "AbsDto [CHESTId=" + chestId + ", BenchPress=" + BenchPress + ", DumbbellPress=" + DumbbellPress
				+ ", InclineBenchPress=" + InclineBenchPress + ", DumbbellFly=" + DumbbellFly + ", Dips=" + Dips
				+ ", CableCrossOver=" + CableCrossOver + "]";
	}

}
