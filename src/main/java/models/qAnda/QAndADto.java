package models.qAnda;

import java.time.LocalDateTime;

public class QAndADto {

	private int id;
	private String memId;
	private String subject;
	private String question;
	private String answer;
	private int isAnswer;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(int isAnswer) {
		this.isAnswer = isAnswer;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	public LocalDateTime getModDt() {
		return modDt;
	}

	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "QAndADto [id=" + id + ", memId=" + memId + ", subject=" + subject + ", question=" + question
				+ ", answer=" + answer + ", isAnswer=" + isAnswer + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}

}
