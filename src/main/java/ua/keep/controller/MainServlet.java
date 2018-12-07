package ua.keep.controller;

import ua.keep.dao.entities.User;
import ua.keep.dao.reporitory.UserRepository;
import ua.keep.view.IndexSingleton;
import ua.keep.view.MainView;
import ua.keep.view.UserView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MainServlet", urlPatterns = {"/main"}, loadOnStartup = 1)
public class MainServlet extends HttpServlet {
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

        MainView mainView = new MainView();
        out.println(mainView.getHtml());


    }

    @Override
    public void init() throws ServletException {
        super.init();
        //set path
        String path = getServletContext().getRealPath("/html/");
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        indexSingleton.setHtmlPath(path);
    }
}
