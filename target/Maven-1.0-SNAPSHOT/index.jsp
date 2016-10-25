<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New Year's gift</title>
</head>
<body>

<div align="center" style="margin-top: 50px;">
    <h1>New Year's</h1>
    <form action="Commander">
        <input type="hidden" name="command" value="CreateGift" />
        <input type = "submit" name="makeGift" value = "Create gift" width="17%"/>
    </form>
</div>

</body>
</html>