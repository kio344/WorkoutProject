package dto.recordDto;

public class WorkoutDtDto {
	private int workoutDtId;
	private String regDate;
	private String workoutTime;

	public int getWorkoutDtId() {
		return workoutDtId;
	}

	public void setWorkoutDtId(int workoutDtId) {
		this.workoutDtId = workoutDtId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getWorkoutTime() {
		return workoutTime;
	}

	public void setWorkoutTime(String workoutTime) {
		this.workoutTime = workoutTime;
	}

	@Override
	public String toString() {
		return "WorkputDto [workoutDtId=" + workoutDtId + ", regDate=" + regDate + ", workoutTime=" + workoutTime + "]";
	}

}
