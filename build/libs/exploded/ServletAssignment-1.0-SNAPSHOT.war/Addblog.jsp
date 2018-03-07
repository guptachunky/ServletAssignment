<%--
  Created by IntelliJ IDEA.
  User: chunky
  Date: 1/3/18
  Time: 12:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Blog</title>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"/>
    <link rel="stylesheet" href="styles.css" type="text/css"/>
</head>
<body>

<h1> Menu </h1>
<hr/>
<div id="tabs">
    <ul>
        <li><a href="Home.jsp"><span>HOME</span></a></li>
        <li><a href="Login.jsp"><span>Login</span></a></li>
        <li><a href="Signin.jsp"><span>Sign In</span></a></li>
        <li><a href="Logout.jsp"><span>Log Out</span></a></li>
    </ul>
</div>


<form action="/addblog">
    Add Blog Content:- <textarea name="blog" cols="40" rows="5"></textarea>
    <input type="submit" value="Submit Blog">
</form>

</body>
</html>
