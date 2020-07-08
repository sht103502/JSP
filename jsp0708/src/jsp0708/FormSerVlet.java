package jsp0708;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormSerVlet
 */
@WebServlet("/Form11")
public class FormSerVlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormSerVlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html; charset=UTF-8");
    	request.setCharacterEncoding("UTF-8");
    	String id=request.getParameter("id");
    	String pw=request.getParameter("pw");
    	PrintWriter out =response.getWriter();
    	out.println("아이디:" +id +"<br/>");
    	out.println("패스워드:"+pw +"<br/>");
    	
    	System.out.println("1아이디 : "+ id);
    	System.out.println("1패스워드 : "+ pw);
    	
    }
    
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doProcess(request, response);
    	System.out.println("doPost!");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		System.out.println("doGet!");
	}


	

}
