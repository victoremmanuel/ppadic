package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.File;

public class AddUser extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String ename=request.getParameter("t1").trim();
	String contact=request.getParameter("t2").trim();
	String email=request.getParameter("t3").trim();
	String qualification=request.getParameter("t4").trim();
	String address=request.getParameter("t5").trim();
	String designation=request.getParameter("t6").trim();
	String experience=request.getParameter("t7").trim();
	String user=request.getParameter("t8").trim();
	String pass=request.getParameter("t9").trim();
	try{
		String input[]={ename,contact,email,qualification,address,designation,experience,user,pass};
		String res = Database.addUser(input);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=User details added");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Error in adding user");
		rd.forward(request, response);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
