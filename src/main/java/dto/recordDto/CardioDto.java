package dto.recordDto;

public class CardioDto {
	private int cardioId;
	private String Cycle;
	private String Walking;
	private String Running;
	private String Treadmill;
	private String RowingMachine;

	public int getCardioId() {
		return cardioId;
	}

	public void setCardioId(int cardioId) {
		this.cardioId = cardioId;
	}

	public String getCycle() {
		return Cycle;
	}

	public void setCycle(String cycle) {
		Cycle = cycle;
	}

	public String getWalking() {
		return Walking;
	}

	public void setWalking(String Walking) {
		this.Walking = Walking;
	}

	public String getRunning() {
		return Running;
	}

	public void setRunning(String running) {
		Running = running;
	}

	public String getTreadmill() {
		return Treadmill;
	}

	public void setTreadmill(String treadmill) {
		Treadmill = treadmill;
	}

	public String getRowingMachine() {
		return RowingMachine;
	}

	public void setRowingMachine(String RowingMachine) {
		this.RowingMachine = RowingMachine;
	}

	@Override
	public String toString() {
		return "CardioDto [cardioId=" + cardioId + ", Cycle=" + Cycle + ", Walking=" + Walking + ", Running=" + Running
				+ ", Treadmill=" + Treadmill + ", RowingMachine=" + RowingMachine + "]";
	}

}
