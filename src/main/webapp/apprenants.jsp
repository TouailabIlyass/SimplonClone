<%@ page import="com.simplonclone.simplonclone.entity.Apprenant" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: musan
  Date: 11/1/2022
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    List<Apprenant> list = (List<Apprenant>)request.getAttribute("apprenants");

    for (Apprenant apprenant: list
         ) {
        response.getWriter().println("<h1>"+apprenant.getFirstname()+" "+apprenant.getLastname()+"</h1>");

    }


%>

</body>
</html>
