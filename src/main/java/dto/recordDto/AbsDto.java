package dto.recordDto;

public class AbsDto {

	private int absId;
	private String Crunch;
	private String HangingLegRays;
	private String LegRays;
	private String SitUp;

	public int getAbsId() {
		return absId;
	}

	public void setAbsId(int absId) {
		absId = absId;
	}

	public String getCrunch() {
		return Crunch;
	}

	public void setCrunch(String Crunch) {
		this.Crunch = Crunch;
	}

	public String getHangingLegRays() {
		return HangingLegRays;
	}

	public void setHangingLegRays(String hangingLegRays) {
		HangingLegRays = hangingLegRays;
	}

	public String getLegRays() {
		return LegRays;
	}

	public void setLegRays(String legRays) {
		LegRays = legRays;
	}

	public String getSitUp() {
		return SitUp;
	}

	public void setSitUp(String sitUp) {
		SitUp = sitUp;
	}

	@Override
	public String toString() {
		return "AbsDto [AbsId=" + absId + ", crunch=" + Crunch + ", HangingLegRays=" + HangingLegRays + ", LegRays="
				+ LegRays + ", SitUp=" + SitUp + "]";
	}

}
