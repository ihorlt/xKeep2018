package ua.keep.controller;

import ua.keep.model.User;
import ua.keep.reporitory.UserRepository;
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
        UserView userView = new UserView();

        HttpSession session = request.getSession();

        if ( request.getParameter("email") != null ) {
            UserRepository userRepository = new UserRepository();
            User user = userRepository.getUserByEmailByPassword(request.getParameter("email"),
                    request.getParameter("password"));
            if ( user == null ) {
                out.write("Please Login Again");
            } else {
                session.setAttribute("user", user);
                response.sendRedirect("/note/");
            }

        }

        switch (request.getPathInfo()) {
            case "/login/":
                out.write(userView.getLogin());
                break;
            case "/register":
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
