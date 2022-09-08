package jmsUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;

public class Utils {

	/**
	 * 원하는 파라미터 값 만 체크 맵 key값 파라미터 이름 , value 파라미터 값
	 * 
	 * @param req
	 * @param msg
	 */
	public static void ckNullParaMap(HttpServletRequest req, Map<String, String> msg) {

		for (Entry<String, String> en : msg.entrySet()) {
			String key = en.getKey();
			String value = en.getValue();

			if (req.getParameter(key) == null || req.getParameter(key).isBlank()) {
				throw new RuntimeException(value);
			}
		}
	}

	/**
	 * 모든 파라미터값 Null체크
	 * 
	 * @param req
	 */
	public static void ckNullParaMap(HttpServletRequest req) {

		Set parakey = req.getParameterMap().keySet();

		parakey.forEach(t -> {
			if (req.getParameter((String) t) == null || req.getParameter((String) t).isBlank()) {
				throw new RuntimeException(t + "값이 비어있습니다.");
			}
		});
	}

	/**
	 * 모든 파라미터값 콘솔 출력
	 * 
	 * @param req
	 */
	public static void showParaMap(HttpServletRequest req) {

		Set parakey = req.getParameterMap().keySet();

		parakey.forEach(t -> {
			System.out.println(t + " : " + req.getParameter((String) t));
		});
	}

	/**
	 * 오류 발생시 alert 출력
	 * 
	 * @param resp
	 * @param e
	 * @throws IOException
	 */
	public static void showAlertException(HttpServletResponse resp, Exception e) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>alert('" + e.getMessage() + "')</script>");
	}

	/**
	 * 원하는 alert 출력
	 * 
	 * @param resp
	 * @param msg
	 * @throws IOException
	 */
	public static void showAlert(HttpServletResponse resp, String msg) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>alert('" + msg + "')</script>");

	}

	/**
	 * 페이지 이동
	 * 
	 * @param resp
	 * @param href
	 * @param target
	 * @throws IOException
	 */
	public static void replacePage(HttpServletResponse resp, String href, String target) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>" + target + ".location.replace('" + href + "')" + "</script>");

	}

	/**
	 * 페이지 새로 고침
	 * 
	 * @param resp
	 * @param target
	 * @throws IOException
	 */
	public static void reloadPage(HttpServletResponse resp, String target) throws IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>" + target + ".location.reload()" + "</script>");
	}

	/**
	 * 로그인중인 회원 정보
	 * @author 5563a
	 * @param req
	 * @return
	 */
	public static UserDto getLoginUser(HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserDto user = (UserDto) session.getAttribute("member");

		return user;
	}

	
	public static String BoardFilePath(int num,HttpServletRequest req) {
		String filePath=req.getServletContext().getRealPath("/community/uploadFolder/"+(num%10)+"/"+num);
		
		return filePath;
	}
}
