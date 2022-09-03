package models.file;

import java.time.LocalDateTime;

public class FileInfoDto {
	private int id ;	//파일 등록 번호
	private String gid ;	//그룹 ID
	private String memId ; //회원 아이디
	private String fileName ; //원본 파일명
	private String contentType ; //파일 형식
	private int isDone ; //0 - 파일 연관 작업 미완료 , 1 - 완료
	private LocalDateTime regDt; //파일 등록 일시
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getIsDone() {
		return isDone;
	}
	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
	@Override
	public String toString() {
		return "FileInfoDto [id=" + id + ", gid=" + gid + ", memId=" + memId + ", fileName=" + fileName
				+ ", contentType=" + contentType + ", isDone=" + isDone + ", regDt=" + regDt + "]";
	}

	
	
	
	
}
