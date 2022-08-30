package models.purpose;

public class BmiDto {
	
	private String base;
	private String bmi;
	private String bmiWe;
	
	public BmiDto() {
		
	}
	
	public BmiDto(String base, String bmi, String bmiWe) {
		this.base = base;
		this.bmi = bmi;
		this.bmiWe = bmiWe;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getBmi() {
		return bmi;
	}
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	public String getBmiWe() {
		return bmiWe;
	}
	public void setBmiWe(String bmiWe) {
		this.bmiWe = bmiWe;
	}

	@Override
	public String toString() {
		return "BmiDto [base=" + base + ", bmi=" + bmi + ", bmiWe=" + bmiWe + "]";
	}
	
	
	

}
