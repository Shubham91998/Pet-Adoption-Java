<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="mystyle.css"/>
</head>
<body>
    <h1>Registration Form</h1>
    <form action="RegisterServlet" method="post" onsubmit="return validateForm()">
        <p>
            <label for="username">Name:</label>
            <input type="text" id="username" name="username" placeholder="Enter your full name" required/>
            <span id="name-error" class="error-message"></span>    
        </p>

        <p>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter your address" required/>
            <span id="address-error" class="error-message"></span>    
        </p>

        <p>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your Email" required/>
            <span id="email-error" class="error-message"></span>    
        </p>
        
        <p>
            <label for="phone_number">Mobile:</label>
            <input type="tel" id="phone_number" name="phone_number" placeholder="Enter your Mobile" required pattern="[0-9]{10}"/>
            <span id="mobile-error" class="error-message"></span>    
        </p>

        <p>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your Password" required minlength="8"/>
            <span id="password-error" class="error-message"></span>    
        </p>

        <p>
            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" placeholder="Enter your Confirm Password" required minlength="8"/>
            <span id="confirm-password-error" class="error-message"></span>    
        </p>

        <p>
            <input type="checkbox" id="agree" name="agree" required/>
            <label for="agree">I agree to the above information</label>
            <span id="agree-error" class="error-message"></span>   
        </p> 

        <p>
            <input type="submit" value="Submit" name="submit"/>
            <input type="reset" value="Reset" name="reset"/>
        </p>
    </form>

    <script src="myscript.js"></script>
</body>
</html>
