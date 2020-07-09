package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out= response.getWriter();
		
		String imoticon[] =request.getParameterValues("pick");
		
		out.append("<html>");
		out.append("<head>");
		out.append("<title>이미지 선택 Test Page</title>");
		out.append("<style>");
		out.append("body{ background-color : orange;}");
		out.append("table{background-color : yellow;}");
		out.append("</style>");
		out.append("</head>");
		out.append("<boby>");
		out.append("<table>");
		out.append("<tr>");
		for(int i=0; i<imoticon.length; i++) {
			out.append("<td>");
			out.append("<img src='image/"+imoticon[i]+"'width= '200px' alt='ss'/> ");
			out.append("</td>");
			}
		
		out.append("</tr>");
		out.append("</table>");
		out.append("</body>");
		out.append("</html>");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		out.append("");
		
	}

}
