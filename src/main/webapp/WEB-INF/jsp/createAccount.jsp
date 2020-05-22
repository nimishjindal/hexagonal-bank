<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="AccountForm" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register an account with our bank</title>
    <form:form modelAttribute="registration">
        name: <form:input path="name" />
        <input type="submit" value="create account" />
    </form:form>
</head>
<body>
${message}
</body>
</html>