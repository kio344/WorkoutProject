package controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import dto.UserDto;
import models.member.MypageService;
import mybatis.Connection;

@WebServlet("/mypage")
public class MypageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/mypage/mypage.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		MypageService service = new MypageService();
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		SqlSession sqlSession = Connection.getSession();
		
		// session에 저장된 id 정보를 이용해 sql 구문을 사용, UserDto param에 sql구문으로 찾아낸 디비 정보를 입력
		UserDto param = sqlSession.selectOne("userInfoMapper.user", (UserDto)session.getAttribute("member"));
		
		try {
			service.update(req, param);
			
			out.println("<script> alert('수정 완료') </script>");
			out.println("<script>parent.location.replace('/WorkOutProject') </script>");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			out.println("<script>alert('"+ e.getMessage() +"') </script>");
		}
	}

}
