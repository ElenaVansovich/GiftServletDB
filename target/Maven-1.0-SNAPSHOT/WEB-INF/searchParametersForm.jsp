<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 16.10.2016
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Year's gift</title>
  <script type="text/javascript">

    function validate(elemName) {
      var str = elemName.value;
      var re = /[0-9]+/;
      if(!str.match(re)) {
        elemName.style.border = '1px solid red';
        return false;
      } else {
        elemName.style.border = '1px solid black';
      }
      return true;
    }

    function validateSearch()
    {
      if(validate(document.searchForm.price) == false ||
        validate(document.searchForm.sugar) == false ||
        validate(document.searchForm.weight) == false){
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
    <tr>
      <td valign="top" width="45%"></td>
      <td align="left" valign="top">
        Enter parameters <br>
      </td>
      <form action="Commander" name="searchForm" onsubmit="return validateSearch();">
        <tr>
          <td align="right" valign="top" width="45%">Price:</td>
          <td align="left" valign="top">
            <input type="text" name="price" size="20px">
            <br><br></td>
        </tr>
        <tr>
          <td align="right" valign="top" width="45%">Sugar(gramme):</td>
          <td align="left" valign="top"><input type="text" name="sugar" size="20px">
            <br><br></td>
        </tr>
        <tr>
          <td align="right" valign="top" width="45%">Weight(gramme):</td>
          <td align="left" valign="top"><input type="text" name="weight" size="20px">
            <br><br></td>
        </tr>
        <tr>
          <td valign="top" width="45%"></td>
          <td align="left" valign="top">
            <input type="hidden" name="command" value="Search" />
            <input type="submit" value="OK">
          </td>
        </tr>
      </form>
  </table>
</div>
</body>
</html>
