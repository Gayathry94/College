package Service;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpSession;

import Model.Login;
import Model.staff;
import Model.student;
public class Operations {
	
	public int add(student st)
	{
		int status=0;

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/college_mgmt","root","Ganga@123");  
			Statement stmt=con.createStatement();
		
			 status=stmt.executeUpdate("insert into student_reg(fname,lname,gender,dept,mail,phone,uname,pass,conp) values('"+st.getFname()+"','"+st.getLname()+"','"+st.getGender()+"','"+st.getDept()+"','"+st.getMail()+"','"+st.getPhone()+"','"+st.getUname()+"','"+st.getPass()+"','"+st.getConp()+"')");  
			
			
			 
			con.close(); 
			
		}
		catch(Exception e){
				System.out.println(e);
			}  

		return status;
	}
	public int add1(staff st)
	{
		int status=0;

		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/college_mgmt","root","Ganga@123");  
			Statement stmt=con.createStatement();
		
			 status=stmt.executeUpdate("insert into staff_reg(fname,lname,gender,dept,mail,phone,uname,pass,conp) values('"+st.getFname()+"','"+st.getLname()+"','"+st.getGender()+"','"+st.getDept()+"','"+st.getMail()+"','"+st.getPhone()+"','"+st.getUname()+"','"+st.getPass()+"','"+st.getConp()+"')");  
			
			
			 
			con.close(); 
			
		}
		catch(Exception e){
				System.out.println(e);
			}  

		return status;
	}

}
