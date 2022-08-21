package dto.recordDto;

public class LowerbodyDto {
	private int lowerbodyId;
	private String Squat;
	private String Legpress;
	private String LegExtension;
	private String Legcurl;
	private String HipBridge;
	private String DunkKick;
	private String ConventionalDeadLift;

	public int getLowerbodyId() {
		return lowerbodyId;
	}

	public void setLowerbodyId(int lowerbodyId) {
		this.lowerbodyId = lowerbodyId;
	}

	public String getSquat() {
		return Squat;
	}

	public void setSquat(String squat) {
		Squat = squat;
	}

	public String getLegpress() {
		return Legpress;
	}

	public void setLegpress(String legpress) {
		Legpress = legpress;
	}

	public String getLegExtension() {
		return LegExtension;
	}

	public void setLegExtension(String legExtension) {
		LegExtension = legExtension;
	}

	public String getLegcurl() {
		return Legcurl;
	}

	public void setLegcurl(String legcurl) {
		Legcurl = legcurl;
	}

	public String getHipBridge() {
		return HipBridge;
	}

	public void setHipBridge(String hipBridge) {
		HipBridge = hipBridge;
	}

	public String getDunkKick() {
		return DunkKick;
	}

	public void setDunkKick(String dunkKick) {
		DunkKick = dunkKick;
	}

	public String getConventionalDeadLift() {
		return ConventionalDeadLift;
	}

	public void setConventionalDeadLift(String ConventionalDeadLift) {
		this.ConventionalDeadLift = ConventionalDeadLift;
	}

	@Override
	public String toString() {
		return "LowerbodyDto [lowerbodyId=" + lowerbodyId + ", Squat=" + Squat + ", Legpress=" + Legpress
				+ ", LegExtension=" + LegExtension + ", Legcurl=" + Legcurl + ", HipBridge=" + HipBridge + ", DunkKick="
				+ DunkKick + ", conventionalDeadLift=" + ConventionalDeadLift + "]";
	}

}
