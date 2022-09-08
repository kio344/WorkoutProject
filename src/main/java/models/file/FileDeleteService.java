package models.file;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jmsUtil.Utils.*;

public class FileDeleteService {
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private FileDao fileDao=FileDao.getInstance();
	
	public FileDeleteService(HttpServletRequest request,HttpServletResponse response) {
		this.req=request;
		this.resp=response;
	}
	
	
	public void delete() {
		String id=req.getParameter("num");
		if (id==null) {
			throw new RuntimeException("잘못된 요청");
		}
		
		FileInfoDto _fileInfoDto=new FileInfoDto();
		_fileInfoDto.setId(Integer.parseInt(id));
		
		fileDao.delete(_fileInfoDto);
				
		String filePath=BoardFilePath(Integer.parseInt(id), req);
		File file=new File(filePath);
		file.delete();
		
		
	}
}
