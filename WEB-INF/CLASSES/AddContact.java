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

public class AddContact extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String pid=request.getParameter("t1").trim();
	String pname=request.getParameter("t2").trim();
	String problem=request.getParameter("t3").trim();
	String contact=request.getParameter("t4").trim();
	String address=request.getParameter("t5").trim();
	try{
		String input[]={pid,pname,problem,contact,address};
		String res = Database.addContactInfo(input);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("RecepScreen.jsp?t1=Contact details added");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("RecepScreen.jsp?t1=Error in adding contact");
		rd.forward(request, response);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
