package dto.recordDto;

public class ArmDto {
	private int ArmId;
	private String DumbbellBicepsCurl;
	private String BabellBicepsCurl;
	private String TricepsCurl;
	private String TricepsExtension;
	private String CloseGripBenchPress;
	private String CablePushDown;
	private String HammerCurl;

	public int getArmId() {
		return ArmId;
	}

	public void setArmId(int armId) {
		ArmId = armId;
	}

	public String getDumbbellBicepsCurl() {
		return DumbbellBicepsCurl;
	}

	public void setDumbbellBicepsCurl(String dumbbellBicepsCurl) {
		DumbbellBicepsCurl = dumbbellBicepsCurl;
	}

	public String getBabellBicepsCurl() {
		return BabellBicepsCurl;
	}

	public void setBabellBicepsCurl(String babellBicepsCurl) {
		BabellBicepsCurl = babellBicepsCurl;
	}

	public String getTricepsCurl() {
		return TricepsCurl;
	}

	public void setTricepsCurl(String tricepsCurl) {
		TricepsCurl = tricepsCurl;
	}

	public String getTricepsExtension() {
		return TricepsExtension;
	}

	public void setTricepsExtension(String tricepsExtension) {
		TricepsExtension = tricepsExtension;
	}

	public String getCloseGripBenchPress() {
		return CloseGripBenchPress;
	}

	public void setCloseGripBenchPress(String closeGripBenchPress) {
		CloseGripBenchPress = closeGripBenchPress;
	}

	public String getCablePushDown() {
		return CablePushDown;
	}

	public void setCablePushDown(String cablePushDown) {
		CablePushDown = cablePushDown;
	}

	public String getHammerCurl() {
		return HammerCurl;
	}

	public void setHammerCurl(String hammerCurl) {
		HammerCurl = hammerCurl;
	}

	@Override
	public String toString() {
		return "ArmDto [ArmId=" + ArmId + ", DumbbellBicepsCurl=" + DumbbellBicepsCurl + ", BabellBicepsCurl="
				+ BabellBicepsCurl + ", TricepsCurl=" + TricepsCurl + ", TricepsExtension=" + TricepsExtension
				+ ", CloseGripBenchPress=" + CloseGripBenchPress + ", CablePushDown=" + CablePushDown + ", HammerCurl="
				+ HammerCurl + "]";
	}

}
