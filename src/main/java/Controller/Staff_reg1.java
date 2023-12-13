package Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Staff_reg1
 */
@WebServlet("/Staff_reg1")
public class Staff_reg1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Staff_reg1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session1=request.getSession(false);  
		 int id=(Integer)session1.getAttribute("id");
		 System.out.println(id);
		
		 try{  
			 String a1="",a2="",a3="",a4="",a5="",a6="",a7="",a8="",a9="";
			
				Class.forName("com.mysql.cj.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/college_mgmt","root","Ganga@123");  
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from staff_reg where id='"+id+"'");  
				while(rs.next())
				{
					a1=rs.getString("fname");  
					a2=rs.getString("lname");
					a3=rs.getString("gender");
					a4=rs.getString("dept");
					a5=rs.getString("mail");
					a6=rs.getString("phone");
					a7=rs.getString("uname");
					a8=rs.getString("pass");
					a9=rs.getString("conp");
					
				}
				
				
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();  
				out.print("<a href='staff_edit?identity="+id+"'>visit</a>");
				out.print("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <style>\r\n"
						+ "th, td,tr{\r\n"
						+ "  border: 10px solid white;\r\n"
						+ "  border-collapse: collapse;\r\n"
						+ " text-align: center;\r\n"
						+ "  background-color: #96D4D4;\r\n"
						+ "}\r\n"
						+ "table\r\n"
						+ "{\r\n"
						+ "  border: 5px solid white;\r\n"
						+ "  border-collapse: collapse;\r\n"
						+ " \r\n"
						+ "  background-color: #96D4D4;\r\n"
						+ "  height: 80%;\r\n"
						+ " \r\n"
						+ "  margin-left: 15%;\r\n"
						+ "  margin-top: 5%;\r\n"
						+ "  table-layout: fixed;\r\n"
						+ "  width: 70%;\r\n"
						+ "\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "        .profile-card {\r\n"
						+ "  background: #060606;\r\n"
						+ "  width: 59px;\r\n"
						+ "  height: 56px;\r\n"
						+ "  position: absolute;\r\n"
						+ "  left: 50%;\r\n"
						+ "  top: 50%;\r\n"
						+ "  z-index: 2;\r\n"
						+ "  overflow: hidden;\r\n"
						+ "  opacity: 0;\r\n"
						+ "  margin-top: 70px;\r\n"
						+ "  -webkit-transform: translate(-50%, -50%);\r\n"
						+ "  transform: translate(-50%, -50%);\r\n"
						+ "  -webkit-border-radius: 50%;\r\n"
						+ "  border-radius: 50%;\r\n"
						+ "  box-shadow: 10px 13px 16px rgba(14, 1, 1, 0.16), 0px 3px 6px rgba(0, 0, 0, 0.23);\r\n"
						+ "  animation: init 0.5s 0.2s cubic-bezier(0.55, 0.055, 0.675, 0.19) forwards, \r\n"
						+ "             moveDown 1s 0.8s cubic-bezier(0.6, -0.28, 0.735, 0.045) forwards, \r\n"
						+ "             moveUp 1s 1.8s cubic-bezier(0.175, 0.885, 0.32, 1.275) forwards, \r\n"
						+ "             materia 0.5s 2.7s cubic-bezier(0.86, 0, 0.07, 1) forwards;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "@keyframes init {\r\n"
						+ "  0% {\r\n"
						+ "    width: 0px;\r\n"
						+ "    height: 0px;\r\n"
						+ "  }\r\n"
						+ "  100% {\r\n"
						+ "    width: 56px;\r\n"
						+ "    height: 56px;\r\n"
						+ "    margin-top: 0px;\r\n"
						+ "    opacity: 1;\r\n"
						+ "  }\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "@keyframes moveDown {\r\n"
						+ "  0% {\r\n"
						+ "    top: 50%;\r\n"
						+ "  }\r\n"
						+ "  50% {\r\n"
						+ "    top: 40%;\r\n"
						+ "  }\r\n"
						+ "  100% {\r\n"
						+ "    top: 100%;\r\n"
						+ "  }\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "@keyframes moveUp {\r\n"
						+ "  0% {\r\n"
						+ "    background: #0d0d0d;\r\n"
						+ "    top: 100%;\r\n"
						+ "  }\r\n"
						+ "  50% {\r\n"
						+ "    top: 40%;\r\n"
						+ "  }\r\n"
						+ "  100% {\r\n"
						+ "    top: 50%;\r\n"
						+ "    background: #0c0c0c;\r\n"
						+ "  }\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "@keyframes materia {\r\n"
						+ "  0% {\r\n"
						+ "    background: #101010;\r\n"
						+ "  }\r\n"
						+ "  50% {\r\n"
						+ "    border-radius: 4px;\r\n"
						+ "  }\r\n"
						+ "  100% {\r\n"
						+ "    width: 640px;\r\n"
						+ "    height: 480px;\r\n"
						+ "    background: #0d0d0d;\r\n"
						+ "    border-radius: 4px;\r\n"
						+ "  }\r\n"
						+ "}\r\n"
						+ ".anc\r\n"
						+ "{\r\n"
						+ "  background-color: rgb(4, 4, 5);\r\n"
						+ "  width: 13%;\r\n"
						+ "  height: 10%;\r\n"
						+ "  margin-left: 65%;\r\n"
						+ "  display: inline;\r\n"
						+ "  color:red;\r\n"
						+ "}\r\n"
						+ "\r\n"
						+ "    </style>\r\n"
						+ "    <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n"
						+ "<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n"
						+ "<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Document</title>\r\n"
						+ "</head>\r\n"
						+ "<body background=\"back.jpg\">\r\n"
						+ "\r\n"
						+ "    <aside class=\"profile-card\">\r\n"
						+ "       <Div class=\"tab\">\r\n"
						+ "        <div class=\"anc\">\r\n"
						+ "        <a href='staff_edit?id=\"+id+\"'>visit</a>\r\n"
						+ "        <a href=\"\">Delete Permanently</a>\r\n"
						+ "      </div>\r\n"
						+ "        <h2 style=\"color: ghostwhite;\"><center>PROFILE</center></h2>\r\n"
						+ "        <table border 10px solid white>\r\n"
						+ "\r\n"
						+ "          \r\n"
						+ "          <tr>\r\n"
						+ "            <th>FIRST NAME</th>\r\n"
						+ "            <td>"+a1+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "          <tr>\r\n"
						+ "            <th>LAST NAME</th>\r\n"
						+ "            <td>"+a2+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "          <tr>\r\n"
						+ "            <th>GENDER</th>\r\n"
						+ "            <td>"+a3+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "          <tr>\r\n"
						+ "            <th>DEPARTMENT</th>\r\n"
						+ "            <td>"+a4+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "          <tr>\r\n"
						+ "            <th>MAIL</th>\r\n"
						+ "            <td>"+a5+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "          <tr>\r\n"
						+ "            <th>PHONE</th>\r\n"
						+ "            <td>"+a6+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "        \r\n"
						+ "          <tr>\r\n"
						+ "            <th>USER NAME</th>\r\n"
						+ "            <td>"+a7+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "          <tr>\r\n"
						+ "            <th>PASSWORD</th>\r\n"
						+ "            <td>"+a8+"</td>\r\n"
						+ "          </tr>\r\n"
						+ "        </table>\r\n"
						+ "       </Div>\r\n"
						+ "    </aside>\r\n"
						+ "</body>\r\n"
						+ "</html>");
		 
		 con.close(); 
	}
 
catch(Exception e){
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
