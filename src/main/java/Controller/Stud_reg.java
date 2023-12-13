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

import Model.student;
import Service.Operations;

/**
 * Servlet implementation class Stud_reg
 */
@WebServlet("/Stud_reg")
public class Stud_reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Stud_reg() {
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
		student st=new student();
		int stud_id=0;
		st.setFname(request.getParameter("fname"));
		st.setLname(request.getParameter("lname"));
		st.setGender(request.getParameter("gender"));
		st.setDept(request.getParameter("dept"));
		st.setMail(request.getParameter("mail"));
		st.setPhone(request.getParameter("txtEmpPhone"));
		st.setUname(request.getParameter("uname"));
		st.setPass(request.getParameter("pass"));
		st.setConp(request.getParameter("conp"));
		Operations ser=new Operations();
		int i=ser.add(st);
		if(i==1)
		{
			
String role="student";
			
			
			try{  
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/college_mgmt","root","Ganga@123");  
				Statement stmt=con.createStatement();
				System.out.println("hi");
				ResultSet rs=stmt.executeQuery("select max(sid) from student_reg");  
				
					while(rs.next())
						{
							stud_id=rs.getInt("max(sid)");
							System.out.println(stud_id);
						} 
				System.out.println("hi");
				Statement stmt1=con.createStatement();
				stmt1.executeUpdate("insert into login(sid,uname,pass,role) values('"+stud_id+"','"+st.getUname()+"','"+st.getPass()+"','"+role+"')");
				System.out.println("hi");
				con.close(); 
				
				}
				catch(Exception e)
				{
					System.out.println(e);
				}  


			
			
			
			
			
			
			
			response.sendRedirect("home1.html");
		}
		else
		{
			response.sendRedirect("Student_reg.html");
		}
		
	}

}
