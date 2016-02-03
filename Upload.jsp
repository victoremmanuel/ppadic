<%@page import="java.sql.Connection"%>
<%@page import="com.Database"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Access Control In Public Clouds</title>
<meta name="keywords" content="" />
<meta name="Premium Series" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<!-- start header -->
<div id="header">
	<div id="logo">
		<h1><span>PRIVACY PRESERVING DELEGATED ACCESS CONTROL IN PUBLIC CLOUDS</center></span></h1>
		
	</div>
	<div id="menu">
		<ul id="main">
			<li class="current_page_item"><a href="AddUser.jsp">Add  Users</a></li><td></td>
			<li><a href="Create.jsp">Create ACP</a></li><td></td>
			<li><a href="Encrypt.jsp">Encrypt & Upload</a></li><td></td>
			<li><a href="Upload.jsp">Cloud Upload</a></li><td></td>
			<li><a href="Change.jsp">Change Credentials</a></li><td></td>
			<li><a href="Logout.jsp">Logout</a></li><td></td>
			<td></td>
			
     
		</ul>
		
	</div>
	
</div>
<div id="wrapper">
	<!-- start page -->
	<div id="page">
		
		<!-- start content -->
		<div id="content">
			<%
	String res = request.getParameter("t1");
	if(res != null){
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("<center><font size=3 color=red>"+res+"</font></center>");
	}%>
			<br/>
		<center>
		<form name ="frm" method="post" action="CloudEncrypt" onsubmit="return validate(this);">
			<table align="center" width="80%" border="1">
<tr><th>Patient ID</th><th>Patient Name</th><th>Problem Description</th><th>Contact No</th><th>Address</th></tr>
<%
try{
			  Connection con = Database.getCon();
			  Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ownercontact");
			while(rs.next()){%>
			<tr><td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
			<%}
		  }catch(Exception e){
			  e.printStackTrace();
		  }%>
		  </table><br/><br/>
	
	<table align="center" width="80%" border="1">
<tr><th>Patient ID</th><th>Patient Name</th><th>Amount</th></tr>
<%
try{
			  Connection con = Database.getCon();
			  Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from ownerbilling");
			while(rs.next()){%>
			<tr><td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<%}
		  }catch(Exception e){
			  e.printStackTrace();
		  }%>
		  </table><br/><br/>
	<input type="submit" value="Encrypt&Upload">
		
			</center><br /><div class="post">
				
				<div class="entry">
					
				</div>
			</div>
		</div>
		<!-- end content -->
		<!-- start sidebars -->
		
		<!-- end sidebars -->
		<div style="clear: both;">&nbsp;</div>
	</div>
	<!-- end page -->
</div>
</body>
</html>


