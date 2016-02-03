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

public class CreateAcp extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	PrintWriter out = response.getWriter();
	String role=request.getParameter("t1").trim();
	String yos=request.getParameter("t2").trim();
	String module=request.getParameter("t3").trim();
	String acp = "role="+role+"^"+"yos="+yos+","+module;
	try{
		byte ownerkey[] = AES.generateKey();
		byte cloudkey[] = AES.generateKey();
		String res = Database.createPolicy(acp,ownerkey,cloudkey);
    if(res.equals("success")){
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1= User policy created");
		rd.forward(request, response);
	}else{
		RequestDispatcher rd=request.getRequestDispatcher("OwnerScreen.jsp?t1=Error in creating policy");
		rd.forward(request, response);
	}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	}

}
