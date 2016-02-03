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
	alert("Please Enter Patient ID");
	formObj.t1.focus();
	return false;
	}
	if(formObj.t2.value.length==0)
	{
	alert("Please Enter Patient Name");
	formObj.t2.focus();
	return false;
	}
	if(formObj.t3.value.length==0)
	{
	alert("Please Enter Amount");
	formObj.t3.focus();
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
		<li><a href="AddContact.jsp">Add Contact Info</a></li><td></td>
			<li><a href="AddBilling.jsp">Add Billing Info</a></li><td></td>
			<li><a href="ViewContact.jsp">View Contact Info</a></li><td></td>
			<li><a href="ViewBilling.jsp">View Billing Info</a></li><td></td>
			<li><a href="Logout.jsp">Logout</a></li><td></td>
			<td></td>
			
     
		</ul>
		
			
     
		</ul>
		
	</div>
	
</div>

<div id="wrapper">
	<!-- start page -->
	<div id="page">
		 <form name ="frm" method="post" action="AddBilling" onsubmit="return validate(this);">
		<!-- start content -->
		<div id="content">
			<div class="flower"><center><h1>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Screen To Add Billing Information<h1></div>
			<br/>
			<%
	String res = request.getParameter("t1");
	if(res != null){
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		
		out.println("<center><font size=3 color=red>"+res+"</font></center>");
	}%>
	
			<br/>
		
		
			<table align="right">
<tr><td><b>Patient ID</b></td><td><input type="text" name="t1" /></td></tr>
<tr><td><b>Patient Name</b></td><td><input type="text" name="t2"/> </td></tr>
<tr><td><b>Amount</b></td><td><input type="text" name="t3"/> </td></tr>

<tr><td></td><td><input type="submit" value="Add Billing"></td>
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


