<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.hibernate.SessionFactory" %>
<%@ page import="org.hibernate.cfg.Configuration" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Query" %><%--
  Created by IntelliJ IDEA.
  User: chunky
  Date: 3/3/18
  Time: 8:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Blog</title>

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
        <li><a href="Addblog.jsp"><span>Add Blog</span></a></li>
        <li><a href="/showblog"><span>Show Blog</span></a></li>
        <li><a href="Logout.jsp"><span>Log Out</span></a></li>
    </ul>
</div>

<%
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session sessionObj = sessionFactory.openSession();
    sessionObj.beginTransaction();
    HttpSession sess = request.getSession();
    UserDetails obj = (UserDetails) sess.getAttribute("userId");
    String quer = "from Blog where userDetails_username ='" + obj.getUsername() + "'";
    Query query = sessionObj.createQuery(quer);
    List<Blog> results = query.list();
//        request.setAttribute("result", results);
//        request.getRequestDispatcher("Showblog.jsp").forward(request, response);
    for (Blog b : results) {
%>
<%=        b.getContent()%>
</br>
  <%
    }

%>


</body>
</html>
