<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 15.10.2016
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>New Year's gift</title>
  <script type="text/javascript">
    function validateChocolate()
    {
      if(validate() == false ||
      validateNumbers(document.form.chocolate) == false){
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
      <form action="Commander" name="form" onsubmit="return validateChocolate();">
        <%@ include file="sweetInfoForm.jsp" %>
        <tr>
          <td align="right" valign="top" width="45%">Chocolate(gramme):</td>
          <td align="left" valign="top"><input type="text" name="chocolate" size="20px">
            <br><br></td>
        </tr>
        <tr>
          <td valign="top" width="45%"></td>
          <td align="left" valign="top">
            <input type="hidden" name="command" value="ChocolateGetInf" />
              <input type="submit" value="OK">
          </td>
        </tr>
      </form>
  </table>
</div>
</body>
</html>

