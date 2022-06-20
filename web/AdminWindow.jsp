<%-- 
    Document   : AdminWindow
    Created on : 22-Nov-2014, 10:49:17 PM
    Author     : Abdulquader
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="pack1.DBConnect"%>
<%-- 
    Document   : Launch
    Created on : 31-Mar-2014, 8:41:56 AM
    Author     : Abdulquader
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<link href="fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="wrapper">
	<div id="header" class="container">
		<div id="logo">
			<h1><a href="#">ORUTA Cloud</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1" title="">Admin Page</a></li>
				<li><a href="About_Us.jsp" accesskey="3" title="">About Us</a></li>
				<li><a href="Tparegister.jsp" accesskey="4" title="">TPA Register</a></li>
				<li><a href="Contact_Us.jsp" accesskey="5" title="">Contact Us</a></li>
                                                                                    <li><a href="index.jsp" accesskey="2" title="">Logout</a></li>
			</ul>
		</div>
	</div>
	<div id="banner">&nbsp;</div>
	<div id="featured">
		<div class="container">
			<div class="title">
                            <h2 style=" color:  #ffffff">Welcome Administrator</h2><br><br><br>
                                        <span class="byline" style=" color:  #ffffff">List of Cloud Users</span></div>
                                        
                                        <%
                                           DBConnect dbc = new DBConnect();
                                           Statement st =  dbc.connect();  
                                           String sql = "select * from user_details where post='cloud user' ;";
                                           ResultSet rs = st.executeQuery(sql);
                                        %>
                                      <table style=" width: 100%">
                                            
                                            <tr>
                                                <td style='text-align:center;vertical-align:middle'><h4>User name</h4></td>
                                                <td style='text-align:center;vertical-align:middle'><h4>Password</h4></td>
                                                <td style='text-align:center;vertical-align:middle'><h4>Account Holder name</h4></td>
                                                <td style='text-align:center;vertical-align:middle'><h4>Gender</h4></td>
                                                <td style='text-align:center;vertical-align:middle'><h4>phone number</h4></td>
                                                <td style='text-align:center;vertical-align:middle'><h4>Email ID</h4></td>
                                                <td style='text-align:center;vertical-align:middle'><h4>Address</h4></td>
                                        </tr>
                                            <%!String usernm;%>
                            <% while(rs.next()){    usernm=rs.getString("username");%>
                            
                                        <tr>
                                            <td style='text-align:center;vertical-align:middle'><b><%=usernm%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><b><%=rs.getString("passwd")%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><b><%=rs.getString("name")%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><b><%=rs.getString("gender")%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><b><%=rs.getString("phno")%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><b><%=rs.getString("email")%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><b><%=rs.getString("address")%></b></td>
                                            <td style='text-align:center;vertical-align:middle'><a href="DeleteUserServ?unm=<%=usernm%>">
  <img src="images/delete icon.jpg" alt="Click here to delete" style=" color:  #79C255; width: 30px; height: 30px; border: 0">
            </a></td>
                                            <td style='text-align:center;vertical-align:middle'><a href="SeeUserFiles.jsp?unm=<%=usernm%>">
  <img src="images/Turning_pages.gif" alt="Click here to see user Files" style=" color:  #79C255; width: 30px; height: 30px; border: 0">
            </a></td>
                                            <td style='text-align:center;vertical-align:middle'><a href="sharefiles.jsp?unm=<%=usernm%>">
  <img src="images/sharefile.png" alt="Click here to see shared Files" style=" color:  #79C255; width: 30px; height: 30px; border: 0">
            </a></td>
                                        </tr>
                               <% }%>
                                        </table> 
                   
		
		
	</div>
	<div id="extra" class="container">
		<div class="title">
			<h2>Cloud Computing</h2>
			<span class="byline">Maximizing the effectiveness of the shared resources & Minimizing threats</span> </div>
		<div id="three-column">
			<div class="boxA">
				<div class="box"> <span class="fa fa-cloud-download"></span>
					<p>Cloud resources are usually not only shared by multiple users but are also dynamically reallocated per demand.</p>
				</div>
			</div>
			<div class="boxB">
				<div class="box"> <span class="fa fa-cogs"></span>
					<p>cloud computing is computing that involves a large number of computers connected through a network such as the Internet.</p>
				</div>
			</div>
			<div class="boxC">
				<div class="box"> <span class="fa fa-user"></span>
					<p>Cloud computing is a synonym for distributed computing and means the ability to run an application on many computers.</p>
				</div>
			</div>
		</div>
		<ul class="actions">
			<li><a href="About_Us.jsp" class="button">More on Cloud</a></li>
		</ul>
	</div>
	
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2014 Sitename.com. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by SIMPLE IT LABS.</p>
</div>
</body>
</html>
