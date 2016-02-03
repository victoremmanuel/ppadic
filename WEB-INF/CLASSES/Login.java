package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	response.setContentType("text/html");
	boolean flag=false;
	HttpSession session=request.getSession();
	PrintWriter out = response.getWriter();
	String user=request.getParameter("t1");
	String pass=request.getParameter("t2");
	try{
		String input[] = {user,pass};
		String msg = Database.login(input);
		if(msg.equals("Receptionist")){
			session.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("RecepScreen.jsp?t1=Welcome "+user);
			rd.forward(request, response);
		}
		if(msg.equals("Doctor")){
			session.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("DoctorScreen.jsp?t1=Welcome "+user);
			rd.forward(request, response);
		}
		if(msg.equals("Nurse")){
			session.setAttribute("user",user);
			RequestDispatcher rd=request.getRequestDispatcher("NurseScreen.jsp?t1=Welcome "+user);
			rd.forward(request, response);
		}
		if(msg.equals("invalid login")){
			response.sendRedirect("Login.jsp?t1=Invalid User");
		}
	

	}catch(Exception e){
		e.printStackTrace();
	}
}

}
