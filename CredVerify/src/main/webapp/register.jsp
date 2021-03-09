<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<form action="UserRegister" method="post">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill the form for account creation.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>
	
	<label for="username"><b>Username</b></label>
	<input type="text" placeholder="Enter username" name="name" id="name" required>	
	
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>


    <hr>

    <p>By creating an account you agree to our <a href="terms-privacy.jsp">Terms and Privacy</a>.</p>
    <button type="submit" class="registerbtn">Register</button>
  </div>

  <div class="container signin">
    <p>Already have an account? <a href="login.jsp">Sign in</a>.<a href="index.jsp"> Go Home</a> <br></p>
  </div>
</form>
</body>
</html>