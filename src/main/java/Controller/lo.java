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

import Model.Login;
import Service.Operations;

/**
 * Servlet implementation class lo
 */
@WebServlet("/lo")
public class lo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String role="",pass ="";
		String uname="";	
		int id=0,sid=0;
		String uname1=request.getParameter("uname");
		String pass1=request.getParameter("pass");
		System.out.println("post");
		System.out.println("hi");
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/college_mgmt","root","Ganga@123");  
			Statement stmt=con.createStatement();
			
			
			
			ResultSet rs=stmt.executeQuery("select * from login where uname='"+uname1+"' and pass='"+pass1+"'"); 

			while(rs.next()) {
				uname=rs.getString("uname");
				//System.out.println(uname);
				pass=rs.getString("pass");
				//System.out.println(pass);
				role=rs.getString("role");
				//System.out.println(role);
			}
			
			switch(role)
			{
			case "staff":
				//System.out.println(role);
				Statement stmt1=con.createStatement();
				//System.out.println("hi");
				ResultSet rs1=stmt1.executeQuery("select * from login where role='"+role+"' and uname='"+uname1+"' and pass='"+pass1+"'");
				//System.out.println("hi");
				
				
				
				
				while(rs1.next())
				{
					//System.out.println("Entry");
					id=rs1.getInt("id");
					System.out.println(id);
					
				}
				System.out.println(id);
				HttpSession session1=request.getSession();
				session1.setAttribute("id",id);
				
				response.sendRedirect("Staff_reg1");
			break;
				
			case "student":
				Statement stmt2=con.createStatement();
				ResultSet rs2=stmt2.executeQuery("select sid from login where role='"+role+"' and uname='"+uname1+"' and pass='"+pass1+"'");
				while(rs2.next())
				{
					sid=rs2.getInt("sid");
				}
				HttpSession session2=request.getSession();
				session2.setAttribute("sid",sid);
				response.sendRedirect("Stud_reg1");
				break;
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}  
		

}
}
