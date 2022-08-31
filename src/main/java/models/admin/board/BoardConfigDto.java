package models.admin.board;

import java.time.LocalDateTime;

public class BoardConfigDto {

	private String boardId;
	private String boardName;
	private int noOfRows;
	private int isUse;
	private int isMemberOnly;
	private int useComment;
	private LocalDateTime regDt;
	private LocalDateTime modDt;

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public int getNoOfRows() {
		return noOfRows;
	}

	public void setNoOfRows(int noOfRows) {
		this.noOfRows = noOfRows;
	}

	public int getIsUse() {
		return isUse;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	public int getIsMemberOnly() {
		return isMemberOnly;
	}

	public void setIsMemberOnly(int isMemberOnly) {
		this.isMemberOnly = isMemberOnly;
	}

	public int getUseComment() {
		return useComment;
	}

	public void setUseComment(int useComment) {
		this.useComment = useComment;
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
		return "BoardConfigDto [boardId=" + boardId + ", boardName=" + boardName + ", noOfRows=" + noOfRows + ", isUse="
				+ isUse + ", isMemberOnly=" + isMemberOnly + ", useComment=" + useComment + ", regDt=" + regDt
				+ ", modDt=" + modDt + "]";
	}

}
