<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 15.10.2016
  Time: 13:07
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
    <table border = "0" width="100%" valign="top">
            <tr>
              <td align="center" colspan="5" valign="top">
                <form action="Commander">
                    <input type="hidden" name="command" value="CreateGift" />
                  <input type = "submit" value = "Create new gift"/>
                </form>
              </td>
            </tr>
            <tr width="70%">
              <td width="13%" align="center">
                <form action="Commander">
                    <input type="hidden" name="command" value="SortByPrice" />
                  <input type = "submit" value = "Sort by price"/>
                </form>
              </td>
              <td width="13%" align="center">
                <form action="Commander">
                    <input type="hidden" name="command" value="SortBySugar" />
                  <input type = "submit" value = "Sort by sugar"/>
                </form>
              </td>
              <td width="13%" align="center">
                <form action="Commander">
                    <input type="hidden" name="command" value="SortByWeight" />
                  <input type = "submit" value = "Sort by weight"/>
                </form>
              </td>
              <td width="13%" align="center">
                <form action="Commander">
                    <input type="hidden" name="command" value="TotalWeight" />
                  <input type = "submit" value = "Total weight"/>
                </form>
              </td>
              <td width="13%" align="center">
                <form action="Commander">
                    <input type="hidden" name="command" value="ParametersSearch" />
                  <input type = "submit" value = "Search sweets"/>
                </form>
              </td>
            </tr>
            <br><br><br>
            <tr><td colspan="5" align="center">Add sweet</td></tr>
            <br><br><br>
            <tr width="70%">
                <td width="13%" align="center">
                    <form action="Commander">
                        <input type="hidden" name="command" value="Butterscotch" />
                      <input type = "submit" name="butterscotch" value = "Butterscotch"/>
                    </form>
                </td>
                <td width="13%" align="center">
                  <form action="Commander">
                      <input type="hidden" name="command" value="Chocolate" />
                    <input type = "submit" name="chocolate" value = "Chocolate"/>
                  </form>
                </td>
                <td width="13%" align="center">
                  <form action="Commander">
                      <input type="hidden" name="command" value="Jelly" />
                    <input type = "submit" name="jelly" value = "Jelly"/>
                  </form>
                </td>
                <td width="13%" align="center">
                  <form action="Commander">
                      <input type="hidden" name="command" value="Liqueur" />
                    <input type = "submit"  name="liqueur" value = "Liqueur"/>
                  </form>
                </td>
                <td width="13%" align="center">
                  <form action="Commander">
                      <input type="hidden" name="command" value="Wafer" />
                    <input type = "submit" name="wafer" value = "Wafer"/>
                  </form>
                </td>
            </tr>
            <br><br><br>
            <tr><td colspan="5" align="center">Gift</td></tr>
            <br><br><br>
            <tr colspan="5">
                <%@ include file="showTable.jsp" %>
            </tr>
    </table>
</div>
</body>
</html>