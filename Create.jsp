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
		
			
     
		</ul>
		
	</div>
	
</div>

<div id="wrapper">
	<!-- start page -->
	<div id="page">
		 <form name ="frm" method="post" action="CreateAcp" onsubmit="return validate(this);">
		<!-- start content -->
		<div id="content">
			<div class="flower"><center><h1>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Create ACP Screen<h1></div>
			<br/>
			<%
	String res = request.getParameter("t1");
	if(res != null){
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("<center><font size=3 color=red>"+res+"</font></center>");
	}%>
	
			<br/>
		
		
			<table align="right">
<tr><td><b>Role</b></td><td><select name="t1">
<option value="Doctor">Doctor</option>
<option value="Nurse">Nurse</option>
<option value="Receptionist">Receptionist</option>
</td></tr>
<tr><td><b>YOS</b></td><td><select name="t2"><!-- Year Of Service -->
<option value="2">2</option>
</td></tr>
<tr><td><b>Access Module</b></td><td><select name="t3">
<option value="BI">BI</option><!-- Billing Info -->
<option value="CI">CI</option><!-- Contact Info -->
<option value="MR">MR</option><!-- Medical Report -->
</td></tr>

<tr><td></td><td><input type="submit" value="Create ACP"></td>
</td></tr></table>
</form>
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


