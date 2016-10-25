<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 15.10.2016
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Year's gift</title>
  <script type="text/javascript">
    function validateLiqueur()
    {
      if(validate() == false ||
      validateNumbers(document.form.liqueur) == false){
        return false;
      }
      return true;
    }
  </script>
</head>
<body>

<div align="center" style="margin-top: 50px;">
  <h1>New Year's gift</h1>

  <table align="left" border = "0" width="100%">
      <form action="Commander" name="form" onsubmit="return validateLiqueur();">
        <%@ include file="sweetInfoForm.jsp" %>
        <tr>
          <td align="right" valign="top" width="45%">Liqueur(milliliters):</td>
          <td align="left" valign="top"><input type="text" name="liqueur" size="20px">
            <br><br></td>
        </tr>
        <tr>
          <td valign="top" width="45%"></td>
          <td align="left" valign="top">
            <input type="hidden" name="command" value="LiqueurGetInf" />
            <input type="submit" value="OK">
          </td>
        </tr>
      </form>
  </table>
</div>
</body>
</html>
