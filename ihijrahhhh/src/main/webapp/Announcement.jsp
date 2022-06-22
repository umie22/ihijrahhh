<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<title>Announcement</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<head><link rel="stylesheet" href="style.css"></head>

<body>


<!-- SIDEBAR -->
<div class="container" style="padding:0; margin:0; height:100%;width:200px;background-color:#353c49;position:fixed!important;z-index:1;overflow:auto">
<img alt="" src="IHijrahLogo.png" style="width:150px; margin: 20px 20px 0px 50px;">
<h3 style="text-align: center; color: white; padding-bottom:2em;">WELCOME</h3>
<a href="#" class="btn1" style="display:block;">DASHBOARD</a>
<a href="#" class="btn2" style="display:block;">PAYMENT VERIFICATION </a>
<a href="#" class="btn4" style="display:block;">CLASS SCHEDULE</a>
<a href="AnnouncementList.jsp" class="btn5" style="display:block;">ANNOUNCEMENT</a>
<a href="#" class="btn6" style="display:block;">ACCOUNT</a>
<a href="#" class="btn8" style="display:block;">LOGOUT</a>

</div>
<!-- SIDEBAR -->

<!-- TOPBAR -->      
 <div style=" background-color: #102e44; height:100px; color:blue; padding-left:70px; "><img class="user" alt="" src="user.jpg"></div>
 <!-- TOPBAR -->   


	<div class="container" style="margin: 20px 10px 0px 210px; background-color:#004a80; height:600px; ">
	
	<h2>ANNOUNCEMENT DETAILS</h2>
		
		<!-- FILL IN FORM -->
		<form action="" method="post">
		
			<div class="row">
      			<div class="col-25">
        		<label for="a_date">ID</label>
      			</div>
      		
      			<div class="col-75" >
        		<input type="text" id="a_id" name="Id">
      			</div>
   			 </div>
			
    		<div class="row">
      			<div class="col-25">
        		<label for="a_date">Date</label>
      			</div>
      		
      			<div class="col-75">
        		<input type="date" id="a_date" name="Date" placeholder="DD-MM-YYYY">
      			</div>
   			 </div>
    
    		<div class="row">
      			<div class="col-25">
        		<label for="details">Details</label>
      			</div>
      
      			<div class="col-75">
        		<textarea id="details" name="Detail" placeholder="Announcement details" style="height:200px"></textarea>
      			</div>
    		</div><br>
    
    		<div class="row">
  				<input type="submit" style="margin-left:20px;">	
  				<input type="reset" style="text-align:left; ">
    		</div>
  		</form>
		<!-- FILL IN FORM --> 
		
	</div>
		
</body>
</html>
<%
String a =request.getParameter("Id");
String b = request.getParameter("Date");
String c = request.getParameter("Detail");

String DB_DRIVER = "org.postgresql.Driver";
	String DB_CONNECTION = "jdbc:postgresql://ec2-176-34-215-248.eu-west-1.compute.amazonaws.com" +"/delu1t92658u0";
	String DB_USER = "zaiaryvqbpwwcb";	
	String DB_PASSWORD = "731fafeb016f84ea7f87300cbd19a24ba3e96adbaaf92504bc8d945d0302489b";

Connection conn = null;
PreparedStatement stat = null;
Class.forName(DB_DRIVER).newInstance();
if(a!=null && b!=null && c!=null){
	conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
	String data = "insert into announcement(announcement_id,announcement_date,announcement_detail) values(?,?,?)";
	stat = conn.prepareStatement(data);
	stat.setString(1,a);
	stat.setString(2,b);
	stat.setString(3,c);
	stat.executeUpdate();
	response.sendRedirect("AnnouncementList.jsp");
}



%>