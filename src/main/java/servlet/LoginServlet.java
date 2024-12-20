package servlet;

import java.io.IOException;

import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Input validation
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Email and Password are required.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }

        // Initialize DAO and validate login credentials
        UserDAOImpl userDAO = new UserDAOImpl();
        try {
            if (userDAO.validateLogin(email, password)) {
                // Create session and redirect to welcome page
                HttpSession session = request.getSession();
                session.setAttribute("userEmail", email);
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "Invalid credentials. Please try again.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Log exception and show a friendly error page
            e.printStackTrace();
            request.setAttribute("error", "An unexpected error occurred. Please try again later.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
