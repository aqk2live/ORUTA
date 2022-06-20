<%-- 
    Document   : SeeUserFiles
    Author     : Abdulquader
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="pack1.DBConnect"%>
<%@page import="pack1.LoginServ"%>
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
				<li class="current_page_item"><a href="#" accesskey="1" title="">User Files</a></li>
				<li><a href="index.jsp" accesskey="2" title="">Homepage</a></li>
				<li><a href="About_Us.jsp" accesskey="3" title="">About Us</a></li>
				<li><a href="Careers.jsp" accesskey="4" title="">Careers</a></li>
				<li><a href="index.jsp" accesskey="5" title="">Logout</a></li>
			</ul>
		</div>
	</div>
	<div id="banner">&nbsp;</div>
	<div id="featured">
		<div class="container">
			<div class="title">
                            <h2><%=LoginServ.u%> Files</h2><br><br><br>
				<span class="byline">This section include all files of user's cloud</span></div>
                                       <%
                                           DBConnect dbc = new DBConnect();
                                           Statement st =  dbc.connect();  
                                          String sql = "select * from userfiles where username='"+request.getParameter("unm")+"' ;";
                                           ResultSet rs = st.executeQuery(sql);
                                       %> 
                                       
                                       <table style="width:100%" border="1"> 
  <tr>
    <th>File Name</th>
    <th>Date of creation</th>
   
  </tr>
  <%while(rs.next()) { %>
  <tr>
      <td><%=rs.getString("filename")%></td>
    <td><%=rs.getString("datcreate")%></td>
   
  </tr>
    <%}%>
</table>
                    
                </div>
		
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
