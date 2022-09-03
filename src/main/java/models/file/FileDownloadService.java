package models.file;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jmsUtil.Utils.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDownloadService {

	HttpServletRequest req;
	HttpServletResponse resp;
	FileDao dao=FileDao.getInstance();

	public FileDownloadService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;

	}

	public FileDownloadService(HttpServletRequest request) {
		this.req = request;
	}

	public void download() throws IOException {
		showParaMap(req);
		String downloadNum = req.getParameter("num");
		if (downloadNum == null) {
			throw new RuntimeException("잘못된 접근입니다.");
		}
		FileInfoDto fileInfoDto=new FileInfoDto();
		fileInfoDto.setId(Integer.parseInt(downloadNum));
		
		fileInfoDto=dao.get(fileInfoDto);
		
		System.out.println(fileInfoDto);
		
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment;filename="+new String(fileInfoDto.getFileName().getBytes(),"ISO8859_1") );
		
		
		PrintWriter out=resp.getWriter();
		
		String filePath=BoardFilePath(Integer.parseInt(downloadNum), req);
		System.out.println(filePath);
		
		int i;
		try (
				FileInputStream fis=new FileInputStream(filePath);
				BufferedInputStream bis=new BufferedInputStream(fis);
				){
			
			while(( i=bis.read())!=-1) {
				out.write(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
