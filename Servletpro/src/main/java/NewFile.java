import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/NewFile")
public class NewFile extends HttpServlet {
	public void service (HttpServletRequest rq,HttpServletResponse rs) throws ServletException, IOException {
		String a=rq.getParameter("f1");
		String b=rq.getParameter("f2");   
		try {
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vsb","root","rishi");
			
			String str="select * from user where username=? and password=?";
			PreparedStatement ps=cn.prepareStatement(str);
			
			ps.setString(1, a);
			ps.setString(2, b);
			ResultSet res=ps.executeQuery();
            if(res.next()) {
					String username=res.getString("username");
					String password=res.getString("password");
					String name=res.getString("name");
                    int m1=res.getInt("m1");
                    int m2=res.getInt("m2");
                    String result=res.getString("result");
	                  	HttpSession hsp=rq.getSession();
                		hsp.setAttribute("m1", m1);
                		HttpSession hsp2=rq.getSession();
                		hsp2.setAttribute("m2", m2);
                		HttpSession hsp3=rq.getSession();
                		hsp3.setAttribute("result", result);
                		
                		RequestDispatcher rd=rq.getRequestDispatcher("Result.jsp");
                	    rd.forward(rq, rs);
			    	}
					
			
                	else
                	{

                		RequestDispatcher rd=rq.getRequestDispatcher("Login.html");
                	    rd.include(rq, rs);
                	    rd=rq.getRequestDispatcher("New1.html");
                	    rd.include(rq, rs);  
                	}
				
				}
			
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
}}
	