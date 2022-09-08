package models.comment;

import java.time.LocalDateTime;

public class CommentDto {

	private int id;
	private String boardId;
	private String gid;
	private String userName;
	private String content;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public LocalDateTime getModDt() {
		return modDt;
	}

	public void setModDt(LocalDateTime modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", boardId=" + boardId + ", gid=" + gid + ", userName=" + userName
				+ ", content=" + content + ", regDt=" + regDt + ", modDt=" + modDt + "]";
	}

}
