package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.FileWriter;
public class Database{
    private static Connection con;
	
public static Connection getCon()throws Exception {
   try{
		 Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost/accesscontrol","root","root");
     
	}catch(Exception e){
		e.printStackTrace();
	}
	return con;
}
public static String change(String role){
	String msg = "fail";
	try{
		con = getCon();
		PreparedStatement stat=con.prepareStatement("delete from cloudkey where role=?");
		stat.setString(1,role);
		stat.executeUpdate();
		cloudEncrypt();
		msg = "success";
	}catch(Exception e){
		e.printStackTrace();
		msg = "fail";
	}
	return msg;
}
public static String cloudEncrypt()throws Exception{
	String msg = "fail";
	try{
	con = getCon();
	PreparedStatement stat1=con.prepareStatement("delete from cloudcontact");
	stat1.executeUpdate();
	stat1=con.prepareStatement("delete from cloudmedical");
	stat1.executeUpdate();
	stat1=con.prepareStatement("delete from cloudbilling");
	stat1.executeUpdate();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select role,rolekey from cloudkey");
	while(rs.next()){
		String role[] = rs.getString(1).split(",");
		String c1[] = role[0].split("\\^");
		String c2[] = c1[0].split("=");
		if(role[1].equals("BI")){
			byte key[] = rs.getBytes(2);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from ownerbilling");
			while(result.next()){
				byte pid[] = result.getBytes(1);
				byte pname[] = result.getBytes(2);
				byte amount[] = result.getBytes(3);
				byte e_pid[] = AES.encrypt(pid,key);
				byte e_pname[] = AES.encrypt(pname,key);
				byte e_amount[] = AES.encrypt(amount,key);
				PreparedStatement stat = con.prepareStatement("insert into cloudbilling values(?,?,?)");
				stat.setBytes(1,e_pid);
				stat.setBytes(2,e_pname);
				stat.setBytes(3,e_amount);
				stat.executeUpdate();
			}
		}
		if(role[1].equals("CI")){
			byte key[] = rs.getBytes(2);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from ownercontact");
			while(result.next()){
				byte pid[] = result.getBytes(1);
				byte pname[] = result.getBytes(2);
				byte desc[] = result.getBytes(3);
				byte contact[] = result.getBytes(4);
				byte address[] = result.getBytes(5);
				byte e_pid[] = AES.encrypt(pid,key);
				byte e_pname[] = AES.encrypt(pname,key);
				byte e_desc[] = AES.encrypt(desc,key);
				byte e_contact[] = AES.encrypt(contact,key);
				byte e_address[] = AES.encrypt(address,key);
				PreparedStatement stat = con.prepareStatement("insert into cloudcontact values(?,?,?,?,?)");
				stat.setBytes(1,e_pid);
				stat.setBytes(2,e_pname);
				stat.setBytes(3,e_desc);
				stat.setBytes(4,e_contact);
				stat.setBytes(5,e_address);
				stat.executeUpdate();
				
			}
		}
		if(role[1].equals("MR")){
			byte key[] = rs.getBytes(2);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from ownermedical");
			while(result.next()){
				byte pid[] = result.getBytes(1);
				byte pname[] = result.getBytes(2);
				byte problem[] = result.getBytes(3);
				byte prescription[] = result.getBytes(4);
				byte e_pid[] = AES.encrypt(pid,key);
				byte e_pname[] = AES.encrypt(pname,key);
				byte e_problem[] = AES.encrypt(problem,key);
				byte e_prescription[] = AES.encrypt(prescription,key);
				PreparedStatement stat = con.prepareStatement("insert into cloudmedical values(?,?,?,?)");
				stat.setBytes(1,e_pid);
				stat.setBytes(2,e_pname);
				stat.setBytes(3,e_problem);
				stat.setBytes(4,e_prescription);
				stat.executeUpdate();
				
			}
		}
	}
	msg = "success";
	}catch(Exception e){
		e.printStackTrace();
		msg = "fail";
	}
	return msg;
}

public static String encrypt()throws Exception{
	String msg = "fail";
	try{
	con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select role,rolekey from acp");
	while(rs.next()){
		String role[] = rs.getString(1).split(",");
		if(role[1].equals("BI")){
			byte key[] = rs.getBytes(2);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from billinginfo");
			while(result.next()){
				String pid = result.getString(1);
				String pname = result.getString(2);
				String amount = result.getString(3);
				byte e_pid[] = AES.encrypt(pid.getBytes(),key);
				byte e_pname[] = AES.encrypt(pname.getBytes(),key);
				byte e_amount[] = AES.encrypt(amount.getBytes(),key);
				PreparedStatement stat = con.prepareStatement("insert into ownerbilling values(?,?,?)");
				stat.setBytes(1,e_pid);
				stat.setBytes(2,e_pname);
				stat.setBytes(3,e_amount);
				stat.executeUpdate();
				stat = con.prepareStatement("delete from billinginfo where pid=?");
				stat.setString(1,pid);
				stat.executeUpdate();
			}
		}
		if(role[1].equals("CI")){
			byte key[] = rs.getBytes(2);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from contactinfo");
			while(result.next()){
				String pid = result.getString(1);
				String pname = result.getString(2);
				String desc = result.getString(3);
				String contact = result.getString(4);
				String address = result.getString(5);
				byte e_pid[] = AES.encrypt(pid.getBytes(),key);
				byte e_pname[] = AES.encrypt(pname.getBytes(),key);
				byte e_desc[] = AES.encrypt(desc.getBytes(),key);
				byte e_contact[] = AES.encrypt(contact.getBytes(),key);
				byte e_address[] = AES.encrypt(address.getBytes(),key);
				PreparedStatement stat = con.prepareStatement("insert into ownercontact values(?,?,?,?,?)");
				stat.setBytes(1,e_pid);
				stat.setBytes(2,e_pname);
				stat.setBytes(3,e_desc);
				stat.setBytes(4,e_contact);
				stat.setBytes(5,e_address);
				stat.executeUpdate();
				stat = con.prepareStatement("delete from contactinfo where pid=?");
				stat.setString(1,pid);
				stat.executeUpdate();
			}
		}
		if(role[1].equals("MR")){
			byte key[] = rs.getBytes(2);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery("select * from doctor");
			while(result.next()){
				String pid = result.getString(1);
				String pname = result.getString(2);
				String problem = result.getString(3);
				String prescription = result.getString(4);
				byte e_pid[] = AES.encrypt(pid.getBytes(),key);
				byte e_pname[] = AES.encrypt(pname.getBytes(),key);
				byte e_problem[] = AES.encrypt(problem.getBytes(),key);
				byte e_prescription[] = AES.encrypt(prescription.getBytes(),key);
				PreparedStatement stat = con.prepareStatement("insert into ownermedical values(?,?,?,?)");
				stat.setBytes(1,e_pid);
				stat.setBytes(2,e_pname);
				stat.setBytes(3,e_problem);
				stat.setBytes(4,e_prescription);
				stat.executeUpdate();
				stat = con.prepareStatement("delete from doctor where pid=?");
				stat.setString(1,pid);
				stat.executeUpdate();
			}
		}
	}
	msg = "success";
	}catch(Exception e){
		e.printStackTrace();
		msg = "fail";
	}
	return msg;
}
public static String createPolicy(String acp,byte[] ownerkey,byte[] cloudkey)throws Exception{
    String msg="no";
    boolean flag=false;
    con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select role from acp where role='"+acp+"'");
    if(rs.next()){
        flag=true;
        msg = "ACP already exist";
    }
	PreparedStatement stat=con.prepareStatement("insert into cloudkey values(?,?)");
	stat.setString(1,acp);
	stat.setBytes(2,cloudkey);
	stat.executeUpdate();
    if(!flag){
		stat=con.prepareStatement("insert into acp values(?,?)");
		stat.setString(1,acp);
		stat.setBytes(2,ownerkey);
		int i=stat.executeUpdate();
		if(i > 0){
			msg = "success";
		}
    }
    return msg;
}
public static String addContactInfo(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    con = getCon();
	PreparedStatement stat=con.prepareStatement("insert into contactinfo values(?,?,?,?,?)");
	stat.setString(1,input[0]);
	stat.setString(2,input[1]);
	stat.setString(3,input[2]);
	stat.setString(4,input[3]);
	stat.setString(5,input[4]);
	int i=stat.executeUpdate();
	if(i > 0){
		msg = "success";
	}
    return msg;
}
public static String addBillingInfo(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    con = getCon();
	PreparedStatement stat=con.prepareStatement("insert into billinginfo values(?,?,?)");
	stat.setString(1,input[0]);
	stat.setString(2,input[1]);
	stat.setString(3,input[2]);
	int i=stat.executeUpdate();
	if(i > 0){
		msg = "success";
	}
    return msg;
}
public static String addPatient(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    con = getCon();
	PreparedStatement stat=con.prepareStatement("insert into doctor values(?,?,?,?)");
	stat.setString(1,input[0]);
	stat.setString(2,input[1]);
	stat.setString(3,input[2]);
	stat.setString(4,input[3]);
	int i=stat.executeUpdate();
	if(i > 0){
		msg = "success";
	}
    return msg;
}
public static String addUser(String[] input)throws Exception{
    String msg="no";
    boolean flag=false;
    con = getCon();
	Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select username from adduser where username='"+input[0]+"'");
    if(rs.next()){
        flag=true;
        msg = "Username already exist";
    }
    if(!flag){
		PreparedStatement stat=con.prepareStatement("insert into adduser values(?,?,?,?,?,?,?,?,?)");
		stat.setString(1,input[0]);
		stat.setString(2,input[1]);
		stat.setString(3,input[2]);
		stat.setString(4,input[3]);
		stat.setString(5,input[4]);
		stat.setString(6,input[5]);
		stat.setString(7,input[6]);
		stat.setString(8,input[7]);
		stat.setString(9,input[8]);
		int i=stat.executeUpdate();
		if(i > 0){
			msg = "success";
		}
    }
    return msg;
}

public static String login(String input[])throws Exception{
    String msg="invalid login";
	con = getCon();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select designation from adduser where username='"+input[0]+"' and password='"+input[1]+"'");
    if(rs.next()){
	    msg = rs.getString(1);
    }
    return msg;
}

}
