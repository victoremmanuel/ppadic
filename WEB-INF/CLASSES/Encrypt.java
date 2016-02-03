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

public class Encrypt extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	try{
		String res = Database.encrypt();
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1= Data encryption process completed");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Error in encrypting data");
		rd.forward(request, response);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
