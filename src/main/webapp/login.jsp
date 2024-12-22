<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form validation</title>
    <link rel="stylesheet" href="mystyle.css"/>
</head>
<body>
    <h1>Login Form</h1>
    <!-- Display error message if exists -->
    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
    <form action="LoginServlet" method="post" onsubmit="return loginCheck()">
      

      <p>
        <label form="name">Email:</label>
        <input type="text" id="email" name="email" placeholder="Enter your Email"/>
        <span id="email-error" class="error-message"></span>    
      </p>


      <p>
        <label form="name">Password:</label>
        <input type="password" id="password" name="password" placeholder="Enter your Password"/>
        <span id="password-error" class="error-message"></span>    
      </p>
      <p class="reg"><a href="register.jsp">Click here for Registration</a></p>
      <p>
        <input type="submit" value="submit" name="submit"/>
        <input type="reset" value="Reset" name="reset"/>
      </p>

      
     
    </form>
    <c:if test="${not empty errorMessage}">
    <p class="error">${errorMessage}</p>
</c:if>
    

    <script src="myscript.js"></script>
</body>
</html>