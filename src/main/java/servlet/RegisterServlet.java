package servlet;

import java.io.IOException;

import dao.UserDAOImpl;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phone_number");
        String address = request.getParameter("address");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Please fill all the required fields.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            request.setAttribute("error", "Invalid email format.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword((password)); // Hash the password
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);

        UserDAOImpl userDAO = new UserDAOImpl();
        if (userDAO.registerUser(user)) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
            request.setAttribute("error", "Registration failed. Please try again.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
} 