<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 16.10.2016
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Year's gift</title>
</head>
<body>
<div align="center" style="margin-top: 50px;">
  <h1>New Year's gift</h1>

  <table align="center" border = "0" width="70%">
    <form action="Commander">
      
      <%@ include file="showTable.jsp" %>
      <br><br>
      <tr>
        <td colspan="6" align="center">
          <input type="hidden" name="command" value="ShowGift" />
          <input type = "submit" value = "OK"/>
        </td>
      </tr>
    </form>
  </table>
</div>
</body>
</html>
