<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sweets.*" %>
<%@ page import="servlets.Commander" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 18.10.2016
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table width="100%">

  <tr>
    <td align="center" valign="top" width="16%">Class</td>
    <td align="center" valign="top" width="16%">Name</td>
    <td align="center" valign="top" width="16%">Price</td>
    <td align="center" valign="top" width="16%">Sugar(gramme)</td>
    <td align="center" valign="top" width="16%">Weight(gramme)</td>
    <td align="center" valign="top" width="16%">Additional information</td>
  </tr>
  <tr>
      <%for(Sweet sweet: Commander.sweetList){%>
  <tr>
    <%Double sweetInf = 0.0;%>
    <%if(sweet.getClass().getName().equals(new Butterscotch().getClass().getName())){%>
    <%Butterscotch butterscotch = (Butterscotch)sweet;%>
    <%sweetInf = butterscotch.getMilk();%>
    <td align="center" valign="top" width="16%"><%=SweetType.BUTTERSCOTCH.toString().toLowerCase()%></td>
    <%}%>
    <%if(sweet.getClass().getName().equals(new Chocolate().getClass().getName())){%>
    <%Chocolate chocolate = (Chocolate)sweet;%>
    <%sweetInf = chocolate.getChocolate();%>
    <td align="center" valign="top" width="16%"><%=SweetType.CHOCOLATE.toString().toLowerCase()%></td>
    <%}%>
    <%if(sweet.getClass().getName().equals(new Jelly().getClass().getName())){%>
    <%Jelly jelly = (Jelly)sweet;%>
    <%sweetInf = jelly.getGelatin();%>
    <td align="center" valign="top" width="16%"><%=SweetType.JELLY.toString().toLowerCase()%></td>
    <%}%>
    <%if(sweet.getClass().getName().equals(new Liqueur().getClass().getName())){%>
    <%Liqueur liqueur = (Liqueur)sweet;%>
    <%sweetInf = liqueur.getLiqueur();%>
    <td align="center" valign="top" width="16%"><%=SweetType.LIQUEUR.toString().toLowerCase()%></td>
    <%}%>
    <%if(sweet.getClass().getName().equals(new Wafer().getClass().getName())){%>
    <%Wafer wafer = (Wafer)sweet;%>
    <%sweetInf = wafer.getWafer();%>
    <td align="center" valign="top" width="16%"><%=SweetType.WAFER.toString().toLowerCase()%></td>
    <%}%>


    <td align="center" valign="top" width="16%"><%=sweet.getName().toString()%></td>
    <td align="center" valign="top" width="16%"><%=sweet.getPrice()%></td>
    <td align="center" valign="top" width="16%"><%=sweet.getSugar()%></td>
    <td align="center" valign="top" width="16%"><%=sweet.getWeight()%></td>
    <td align="center" valign="top" width="16%"><%=sweetInf.toString()%></td>
  </tr>
  <%}%>
  </tr>
</table>
</body>
</html>
