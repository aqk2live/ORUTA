<%-- 
    Document   : About_Us
    Created on : 4-Apr-2014, 3:20:05 PM
    Author     : Abdulquader
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="pack1.DBConnect"%>
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
			<h1><a href="index.jsp">ORUTA Cloud</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1" title="">Share Files</a></li>
				<li><a href="Our_Clients.jsp" accesskey="4" title="">Our Clients</a></li>
				<li><a href="Contact_Us.jsp" accesskey="5" title="">Contact Us</a></li>
                                                                                   <li><a href="index.jsp" accesskey="2" title="">Logout</a></li>
			</ul>
		</div>
	</div>
	<div id="banner">&nbsp;</div>
	<div id="featured">
		<div class="container">
			<div class="title">
				<h2>Received file history</h2>
                                <%--<span class="byline">Privacy preserving public auditing for secure cloud storage</span>--%> </div>
                                
                                <%
                                           DBConnect dbc = new DBConnect();
                                           Statement st =  dbc.connect();  
                                          String sql = "select * from sharefiles where sendto='"+request.getParameter("unm")+"' ;";
                                           ResultSet rs = st.executeQuery(sql);
                                       %> 
                                
                                <table style="width:100%" border="1">
                                    
                                    
                                    <tr>
                                        <th>Sender</th>
                                        <th>Messages</th>
                                        <th>File</th>
                                        <th>Date of receiving</th>
                                    </tr>
                                    <%while(rs.next()) { %>
                                    <tr>
                                         <td><%=rs.getString("sendfrom")%></td>
                                          <td><%=rs.getString("msg")%></td>
                                           <td><%=rs.getString("file")%></td>
                                            <td><%=rs.getString("dat")%></td>
                                    </tr>
                                    <% } %>
                                    
                                </table>
                                
                                
		</div>
		
	</div>
	
	
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2014 Sitename.com. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by SIMPLE IT LABS.</p>
</div>
</body>
</html>
