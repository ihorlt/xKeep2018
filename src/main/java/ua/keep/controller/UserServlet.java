package ua.keep.controller;

import ua.keep.dao.entities.User;
import ua.keep.dao.reporitory.UserRepository;
import ua.keep.formvalidator.RegisterFormValidator;
import ua.keep.view.UserView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", urlPatterns = {"/user/*"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if ( request.getParameter("email") != null ) {
            RegisterFormValidator registerFormValidator =
                    new RegisterFormValidator(
                            request.getParameter("username"),
                            request.getParameter("email"),
                            request.getParameter("password")
                    );
            if ( ! registerFormValidator.isFormValid() ) {
                out.println(registerFormValidator.getMessageError());
            } else {
                UserRepository userRepository = new UserRepository();
                User user = new User();
                user.setUserName(request.getParameter("username"));
                user.setEmail(request.getParameter("email"));
                user.setPassword(request.getParameter("password"));
                userRepository.saveUser(user);
            }
        }

        switch (request.getPathInfo()) {

            case "/register/":
            case "/register":
                UserView userView = new UserView();
                out.println(userView.getHtml());
                break;
            case "/logout/":
                session.setAttribute("user", null);
                response.sendRedirect("/main");
                break;
                default:
                    out.println("<html><head><title>MyServlet</title></head><body>");
                    out.write("<H1>Hello Servlet World! User!</H1>");
                    out.write("URI   \t" + request.getPathInfo());
                    out.println("</body>");
                    out.println("</html>");
        }
    }
}
