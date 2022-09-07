package models.board;

import java.time.LocalDateTime;

public class BoardDto {
	private Long id;
	private Long gid;
	private String boardId;
	private String subject;
	private String poster;
	private String content;
	private LocalDateTime regDt;

	public BoardDto() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGid() {
		return gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", gid=" + gid + ", boardId=" + boardId + ", subject=" + subject + ", poster="
				+ poster + ", content=" + content + ", regDt=" + regDt + "]";
	}

	
	
}
