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

public class Change extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	String role = request.getParameter("t1");
	PrintWriter out = response.getWriter();
	try{
		String res = Database.change(role);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1= User credential deleted");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Error in deleting credential");
		rd.forward(request, response);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
