<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Access Control In Public Clouds</title>
<meta name="keywords" content="" />
<meta name="Premium Series" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
<script language="javascript">
	function validate(formObj)
	{
	if(formObj.t1.value.length==0)
	{
	alert("Please Enter Employee Name");
	formObj.t1.focus();
	return false;
	}
	if(formObj.t2.value.length==0)
	{
	alert("Please Enter Contact No");
	formObj.t2.focus();
	return false;
	}
	if(formObj.t3.value.length==0)
	{
	alert("Please Enter Email ID");
	formObj.t3.focus();
	return false;
	}
	if(formObj.t4.value.length==0)
	{
	alert("Please Enter Qualification");
	formObj.t4.focus();
	return false;
	}
	if(formObj.t5.value.length==0)
	{
	alert("Please Enter Address");
	formObj.t5.focus();
	return false;
	}
	if(formObj.t8.value.length==0)
	{
	alert("Please Enter Username");
	formObj.t8.focus();
	return false;
	}
	if(formObj.t9.value.length==0)
	{
	alert("Please Enter Password");
	formObj.t9.focus();
	return false;
	}
	formObj.actionUpdateData.value="update";
	return true;
	}
	</script>
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
		 <form name ="frm" method="post" action="AddUser" onsubmit="return validate(this);">
		<!-- start content -->
		<div id="content">
			<div class="flower"><center><h1>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Screen To Add Users<h1></div>
			<br/>
			<%
	String res = request.getParameter("t1");
	if(res != null){
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("<center><font size=3 color=red>"+res+"</font></center>");
	}%>
	
			<br/>
		
		
			<table align="right">
<tr><td><b>Employee Name</b></td><td><input type="text" name="t1" /></td></tr>
<tr><td><b>Contact No</b></td><td><input type="text" name="t2"/> </td></tr>
<tr><td><b>Email ID</b></td><td><input type="text" name="t3"/> </td></tr>
<tr><td><b>Qualification</b></td><td><input type="text" name="t4"/> </td></tr>
<tr><td><b>Address</b></td><td><input type="text" name="t5"/> </td></tr>
<tr><td><b>Designation</b></td><td><select name="t6">
<option value="Doctor">Doctor</option>
<option value="Nurse">Nurse</option>
<option value="Receptionist">Receptionist</option>
</td></tr>
<tr><td><b>Experience</b></td><td><select name="t7">
<option value="0">0</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</td></tr>
<tr><td><b>Username</b></td><td><input type="text" name="t8"/> </td></tr>
<tr><td><b>Password</b></td><td><input type="password" name="t9"/> </td></tr>

<tr><td></td><td><input type="submit" value="Add User"></td>
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


