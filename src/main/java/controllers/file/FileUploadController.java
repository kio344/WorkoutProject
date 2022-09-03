package controllers.file;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.file.FileInfoDto;
import models.file.FileUploadService;
import models.file.LocalDateTimeSerializer;

import static jmsUtil.Utils.*;

@WebServlet("/board/fileupload")
public class FileUploadController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher rd=req.getRequestDispatcher("/community/fileUpload.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GsonBuilder gsonBuilder=new GsonBuilder();
		gsonBuilder.registerTypeAdapter(LocalDateTime.class,new LocalDateTimeSerializer());
		Gson gson=gsonBuilder.setPrettyPrinting().create();
		resp.setContentType("application/json;charset=utf-8");
		PrintWriter out=resp.getWriter();
		try {
			FileUploadService service=new FileUploadService(req,resp);
			List<FileInfoDto> list =service.fileupload();
			String json=gson.toJson(list);
			out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
