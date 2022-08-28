package community.dto;

public class CommunityDto {

	private int id; // 등록번호
	private String boardId; // 게시판 아이디
	private String boardName; // 게시판 이름
	private boolean comment; // 댓글 허용
	private String type; // 게시글 타입
	private String poster; // 글쓴이
	
	public CommunityDto () {}
	
	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	
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
	
	public String getBoardName() {
		return boardName;
	}
	
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
	public boolean isComment() {
		return comment;
	}
	
	public void setComment(boolean comment) {
		this.comment = comment;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "CommunityDto [id=" + id + ", boardId=" + boardId + ", boardName=" + boardName + ", comment=" + comment
				+ ", type=" + type + ", poster=" + poster + "]";
	}
	
	

}
