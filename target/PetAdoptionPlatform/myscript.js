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

    if (name === "" || /\d/.test(name)) {
        nameError.textContent = "Please enter your name properly";
        isValid = false;
    }

    if (address === "") {
        addressError.textContent = "Please enter your address";
        isValid = false;
    }

    if (email === "" || !email.includes("@")) {
        emailError.textContent = "Please enter a valid email id";
        isValid = false;
    }

    if (password === "" || password.length < 8) {
        passwordError.textContent = "Please enter a password with at least 8 characters";
        isValid = false;
    }

    if (confirmPassword === "" || confirmPassword !== password) {
        confirmPasswordError.textContent = "Passwords do not match. Please confirm your password.";
        isValid = false;
    }

    if (mobile === "") {
        mobileError.textContent = "Please enter your mobile No.";
        isValid = false;
    }

    if (!agree) {
        agreeError.textContent = "Please agree to the above information";
        isValid = false;
    }

    return isValid;
}
