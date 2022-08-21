package dto.recordDto;

public class ShoulderDto {
	
	private int shoulderId;
	private String MilitaryPress;
	private String SideLiteralRays;
	private String BentOverLiteralRays;
	private String FrontLiteralRays;
	private String ShoulderDumbbellPress;
	private String BackDeckFly;
	private String BehindNeckPress;
	private String Facefall;

	public int getShoulderId() {
		return shoulderId;
	}

	public void setShoulderId(int shoulderId) {
		this.shoulderId = shoulderId;
	}

	public String getMilitaryPress() {
		return MilitaryPress;
	}

	public void setMilitaryPress(String militaryPress) {
		MilitaryPress = militaryPress;
	}

	public String getSideLiteralRays() {
		return SideLiteralRays;
	}

	public void setSideLiteralRays(String sideLiteralRays) {
		SideLiteralRays = sideLiteralRays;
	}

	public String getBentOverLiteralRays() {
		return BentOverLiteralRays;
	}

	public void setBentOverLiteralRays(String bentOverLiteralRays) {
		BentOverLiteralRays = bentOverLiteralRays;
	}

	public String getFrontLiteralRays() {
		return FrontLiteralRays;
	}

	public void setFrontLiteralRays(String frontLiteralRays) {
		FrontLiteralRays = frontLiteralRays;
	}

	public String getShoulderDumbbellPress() {
		return ShoulderDumbbellPress;
	}

	public void setShoulderDumbbellPress(String shoulderDumbbellPress) {
		ShoulderDumbbellPress = shoulderDumbbellPress;
	}

	public String getBackDeckFly() {
		return BackDeckFly;
	}

	public void setBackDeckFly(String backDeckFly) {
		BackDeckFly = backDeckFly;
	}

	public String getBehindNeckPress() {
		return BehindNeckPress;
	}

	public void setBehindNeckPress(String behindNeckPress) {
		BehindNeckPress = behindNeckPress;
	}

	public String getFacefall() {
		return Facefall;
	}

	public void setFacefall(String facefall) {
		Facefall = facefall;
	}

	@Override
	public String toString() {
		return "ShoulderDto [shoulderId=" + shoulderId + ", MilitaryPress=" + MilitaryPress + ", SideLiteralRays="
				+ SideLiteralRays + ", BentOverLiteralRays=" + BentOverLiteralRays + ", FrontLiteralRays="
				+ FrontLiteralRays + ", ShoulderDumbbellPress=" + ShoulderDumbbellPress + ", BackDeckFly=" + BackDeckFly
				+ ", BehindNeckPress=" + BehindNeckPress + ", Facefall=" + Facefall + "]";
	}

}
