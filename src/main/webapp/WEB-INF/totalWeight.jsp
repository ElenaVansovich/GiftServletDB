<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 16.10.2016
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Year's gift</title>
</head>
<body>
<div align="center" style="margin-top: 50px;">

  <h1>New Year's gift</h1><br><br>

  ${requestScope.totalWeight}

  <br><br>
  <form action="Commander">
    <input type="hidden" name="command" value="ShowGift" />
    <input type = "submit" value = "OK"/>
  </form>
</div>
</body>
</html>
