package controller.bookshop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

@WebServlet("/book/buy")
public class BookBuyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("member", session);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int bookPrice = Integer.parseInt(req.getParameter("price"));
		int bookCount = Integer.parseInt(req.getParameter("count"));
		
		int bookTotal = bookPrice * bookCount;
		System.out.println(bookTotal);
		
	}
	
	
	
}
