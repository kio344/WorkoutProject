package controller.purpose;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadException;
import models.purpose.PurposeService;

@WebServlet("/purpose")
public class PurposeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] addCss = { "purpose/style" };
		req.setAttribute("addCss", addCss);

		RequestDispatcher rd = req.getRequestDispatcher("/purpose/purpose.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=utf-8");

		PrintWriter out = resp.getWriter();

		try {
			PurposeService service = new PurposeService();
			service.bmi(req);

			out.print("<script>parent.location.reload();</script>");
		} catch (BadException e) {
			e.printStackTrace();
			out.print("<script>alert('" + e.getMessage() + "');</script>");
		}

	}

}
