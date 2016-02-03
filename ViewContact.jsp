<%@page import="java.sql.Connection"%>
<%@page import="com.Database"%>
<%@page import="com.AES"%>
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
			<li><a href="AddContact.jsp">Add Contact Info</a></li><td></td>
			<li><a href="AddBilling.jsp">Add Billing Info</a></li><td></td>
			<li><a href="ViewContact.jsp">View Contact Info</a></li><td></td>
			<li><a href="ViewBilling.jsp">View Billing Info</a></li><td></td>
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
		<form name ="frm" method="post" action="Encrypt" onsubmit="return validate(this);">
			<table align="center" width="80%" border="1">
<tr><th>Patient ID</th><th>Patient Name</th><th>Problem Description</th><th>Contact No</th><th>Address</th></tr>
<%
try{
			  Connection con = Database.getCon();
			  Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(" SELECT * FROM acp,cloudkey WHERE acp.role = cloudkey.role");
			while(rs.next()){
				String role1[] = rs.getString(1).split(",");
				String role2[] = rs.getString(3).split(",");
				if(role1[1].equals("CI") && role2[1].equals("CI")){
					String access1[] = role1[0].split("\\^");
					String access2[] = role2[0].split("\\^");
					String userrole1[] = access1[0].split("=");
					String userrole2[] = access2[0].split("=");
					if(userrole1[1].equals("Receptionist") && userrole2[1].equals("Receptionist")){
						byte key1[] = rs.getBytes(2);
						byte key2[] = rs.getBytes(4);
						Statement st = con.createStatement();
						ResultSet result = st.executeQuery("select * from cloudcontact");
						while(result.next()){
						byte b1[] = AES.decrypt(result.getBytes(1),key2);
						byte b2[] = AES.decrypt(result.getBytes(2),key2);
						byte b3[] = AES.decrypt(result.getBytes(3),key2);
						byte b4[] = AES.decrypt(result.getBytes(4),key2);
						byte b5[] = AES.decrypt(result.getBytes(5),key2);%>
	<tr><td><%=new String(AES.decrypt(b1,key1))%></td>
	<td><%=new String(AES.decrypt(b2,key1))%></td>
	<td><%=new String(AES.decrypt(b3,key1))%></td>
	<td><%=new String(AES.decrypt(b4,key1))%></td>
	<td><%=new String(AES.decrypt(b5,key1))%></td>
					
			<%}}}}
		  }catch(Exception e){
			  e.printStackTrace();
		  }%>
		  </table>
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


