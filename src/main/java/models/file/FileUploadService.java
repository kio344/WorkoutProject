package models.file;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import static jmsUtil.Utils.*;

import com.mysql.cj.result.Field;

import dto.UserDto;

public class FileUploadService {

	HttpServletRequest req;
	HttpServletResponse resp;
	FileDao dao = FileDao.getInstance();

	public FileUploadService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;
	}

	public FileUploadService(HttpServletRequest request) {
		this.req = request;
	}

	public List<FileInfoDto> fileupload() throws Exception {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		
		List<FileItem> _list = upload.parseRequest(req);

		List<FileInfoDto> list=new ArrayList<>();
		
		
		File uploadFolder=new File(req.getServletContext().getRealPath("/community/uploadFolder/"));
		if (!uploadFolder.exists()) {
			uploadFolder.mkdirs();
		}
		for(int i=0;i<10;i++) {
			String splitPath=uploadFolder.getAbsolutePath()+File.separator+i;
			File uploadFolders=new File(splitPath);
			if (!uploadFolders.exists()) {
				uploadFolders.mkdirs();
				
			}
		}

		UserDto loginUser = getLoginUser(req);
		if (loginUser == null) {
			loginUser=new UserDto();
			loginUser.setId("TestUser");

		}

		
		String gid="";
		
		for (FileItem _file : _list) {
			if (_file.isFormField()) {
				gid=_file.getString();
			}
		}

		for (FileItem _file : _list) {
			FileInfoDto fileInfoDto = new FileInfoDto();
			fileInfoDto.setGid(gid);
			
			if (!_file.isFormField()) {
				fileInfoDto.setFileName(_file.getName());
				fileInfoDto.setContentType(_file.getContentType());
				fileInfoDto.setMemId(loginUser.getId());
				dao.insert(fileInfoDto);
				
				File uploadPath=new File(uploadFolder.getAbsoluteFile()+File.separator+(fileInfoDto.getId()%10)+File.separator+fileInfoDto.getId());
				
				_file.write(uploadPath);
				
				list.add(fileInfoDto);
			}
	
		}
		System.out.println(list);
		return list;

	}

}
