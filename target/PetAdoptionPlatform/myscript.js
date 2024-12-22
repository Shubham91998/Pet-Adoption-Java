function validateForm() {
    const name = document.getElementById("name").value;
    const address = document.getElementById("address").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm_password").value;
    const mobile = document.getElementById("mobile").value;
    const agree = document.getElementById("agree").checked;

    const nameError = document.getElementById("name-error");
    const addressError = document.getElementById("address-error");
    const emailError = document.getElementById("email-error");
    const passwordError = document.getElementById("password-error");
    const confirmPasswordError = document.getElementById("confirm-password-error");
    const mobileError = document.getElementById("mobile-error");
    const agreeError = document.getElementById("agree-error");

    // Clear previous error messages
    nameError.textContent = "";
    addressError.textContent = "";
    emailError.textContent = "";
    passwordError.textContent = "";
    confirmPasswordError.textContent = "";
    mobileError.textContent = "";
    agreeError.textContent = "";

    let isValid = true;

    // Validate name (no numbers allowed)
    if (name === "" || /\d/.test(name)) {
        nameError.textContent = "Please enter your name properly";
        isValid = false;
    }

    // Validate address (cannot be empty)
    if (address === "") {
        addressError.textContent = "Please enter your address";
        isValid = false;
    }

    // Validate email (simple regex for email format)
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    if (email === "" || !emailPattern.test(email)) {
        emailError.textContent = "Please enter a valid email id";
        isValid = false;
    }

    // Validate password (minimum 8 characters)
    if (password === "" || password.length < 8) {
        passwordError.textContent = "Please enter a password with at least 8 characters";
        isValid = false;
    }

    // Validate confirm password (should match the password)
    if (confirmPassword === "" || confirmPassword !== password) {
        confirmPasswordError.textContent = "Passwords do not match. Please confirm your password.";
        isValid = false;
    }

    // Validate mobile number (should contain only digits and be of a valid length, for example, 10 digits)
    const mobilePattern = /^[0-9]{10}$/;
    if (mobile === "" || !mobilePattern.test(mobile)) {
        mobileError.textContent = "Please enter a valid 10-digit mobile number";
        isValid = false;
    }

    // Validate that the user agrees to the terms
    if (!agree) {
        agreeError.textContent = "Please agree to the terms and conditions";
        isValid = false;
    }

    return isValid;
}
