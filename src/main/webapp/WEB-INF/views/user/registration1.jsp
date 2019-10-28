<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body bgcolor="aqua">
Let’s create a new User!
<form action="${pageContext.request.contextPath}/registration"  method="post">
    <div class="container">
        <h1 align="center">Register Page</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>


        <label for="login"><b>Login</b></label>
        <input value="${userName}" type="text" placeholder="Enter login" name="login" required>

        <label for="psw"><b>Password</b></label>
        <input value="${password}" type="password" placeholder="Enter Password" name="psw" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input value="${repeatPassword}" type="password" placeholder="Repeat Password" name="psw-repeat" required>

        <label for="user_name"><b>Name</b></label>
        <input value="${firstName}" type="text" placeholder="user_name" name="user_name" required>

        <label for="user_surname"><b>Surname</b></label>
        <input value="${lastName}" type="text" placeholder="user_surname" name="user_surname" required>
        <hr>

        <label for="user_email"><b>Email</b></label>
        <input value="${email}" type="text" placeholder="user_email" name="user_email" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Sign in</a>.</p>
    </div>
</form>
</body>
</html>
