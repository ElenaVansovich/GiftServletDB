<%--
  Created by IntelliJ IDEA.
  User: Elena
  Date: 18.10.2016
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script type="text/javascript">
    function validateNumbers(elemName) {
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

    function validateName(elemName) {
      var str = elemName.value;
      var re = /.+/;
      if(!str.match(re)) {
        elemName.style.border = '1px solid red';
        return false;
      } else {
        elemName.style.border = '1px solid black';
      }
      return true;
    }

    function validate()
    {
      if(validateName(document.form.name) == false ||
              validateNumbers(document.form.price) == false||
              validateNumbers(document.form.sugar) == false||
              validateNumbers(document.form.weight) == false) {
        return false;
      }
      return true;
    }
  </script>
</head>
<body>
  <td valign="top" width="45%"></td>
  <td align="left" valign="top">
    Enter information <br>
  </td>
  <tr>
    <td align="right" valign="top" width="45%">Name:</td>
    <td align="left" valign="top"><input type="text" name="name" size="20px">
      <br><br></td>
  </tr>
  <tr>
    <td align="right" valign="top" width="45%">Price:</td>
    <td align="left" valign="top"><input type="text" name="price" size="20px">
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
</body>
</html>
