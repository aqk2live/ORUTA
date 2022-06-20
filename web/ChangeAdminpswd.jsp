<%-- 
    Document   : ChangeAdminpswd
    Created on : 22-Nov-2014, 6:43:41 PM
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
			<h1><a href="index.jsp">ORUTA Cloud</a></h1>
		</div>
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1" title="">Admin change password page</a></li>
				<li><a href="index.jsp" accesskey="2" title="">Homepage</a></li>
				<li><a href="Login.jsp" accesskey="3" title="">Login page</a></li>
				<li><a href="About_Us.jsp" accesskey="4" title="">About Us</a></li>
				<li><a href="Contact_Us.jsp" accesskey="5" title="">Contact Us</a></li>
			</ul>
		</div>
	</div>
	<div id="banner">&nbsp;</div>
	<div id="featured">
		<div class="container">
			<div class="title">
				<h2>Admin Change Password page</h2>
                                <%--<span class="byline">Privacy preserving public auditing for secure cloud storage</span>--%> </div>
                                <form id="form1" method="post" action="ChangeAdminpswdServ">
                                    <center>
                                        
                                        <table>
                               
				<tr>
                                    <td> <label for="inputtext1">Enter Username :</label></td>
                                    <td><input id="inputtext1" type="text" name="username" value="" /></td>
                                </tr><tr></tr>
                                    <tr>
                                    <td><label for="inputtext2">Old Password:</label></td>
                                    <td><input id="inputtext2" type="password" name="oldpassword" value="" /><br></td>
                                   
                                </tr><tr></tr>
                                    <tr>
                                        <td><label for="inputtext2">New Password:</label></td>
                                        <td><input id="inputtext2" type="password" name="newpassword" value="" /></td>
                                
                                    </tr><tr></tr>
                                
                                
                                                
                                        </table><br><br>

                                        
                                        
                                    </center>
                                    <input id="inputsubmit1" type="submit" class="button" name="inputsubmit1" value="Change Password" /><br></br>
                                    
                                </form>
		</div>
		
	</div>
	
	
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2014 Sitename.com. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by SIMPLE IT LABS.</p>
</div>
</body>
</html>