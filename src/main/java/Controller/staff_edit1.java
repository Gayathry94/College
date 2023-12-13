package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class staff_edit1
 */
@WebServlet("/staff_edit1")
public class staff_edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staff_edit1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session3=request.getSession(false);  
		 int id=(Integer)session3.getAttribute("id");
		 System.out.println(id);
		 int status;
		 String a1=request.getParameter("fname");
		 String a2=request.getParameter("lname");
		 String a3=request.getParameter("gender");
		 String a4=request.getParameter("dept");
		 String a5=request.getParameter("mail");
		 String a6=request.getParameter("phone");
		 String a7=request.getParameter("uname");
		 String a8=request.getParameter("pass");
		 System.out.println(a1);
		 try{  
			 Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/college_mgmt","root","Ganga@123"); 
				Statement stmt=con.createStatement();
				status=stmt.executeUpdate("update staff_reg set fname='"+a1+"',lname='"+a2+"',gender='"+a3+"',dept='"+a4+"',mail='"+a5+"',phone='"+a6+"',uname='"+a7+"',pass='"+a8+"' where id='"+id+"'");
				if(status==1) {
					response.sendRedirect("lo.html");
				}
				else
				{
					response.sendRedirect("staff_edit");
				}
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
