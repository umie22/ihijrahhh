<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("d");

String DB_DRIVER = "org.postgresql.Driver";
	String DB_CONNECTION = "jdbc:postgresql://ec2-176-34-215-248.eu-west-1.compute.amazonaws.com" +"/delu1t92658u0";
	String DB_USER = "zaiaryvqbpwwcb";	
	String DB_PASSWORD = "731fafeb016f84ea7f87300cbd19a24ba3e96adbaaf92504bc8d945d0302489b";

Class.forName(DB_DRIVER).newInstance();
Connection conn = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
Statement stat = conn.createStatement();
stat.executeUpdate("delete from announcement where announcement_id='"+id+"'");
response.sendRedirect("AnnouncementList.jsp");
%>

