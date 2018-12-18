package ua.keep.controller;

import ua.keep.dao.entities.Note;
import ua.keep.dao.entities.User;
import ua.keep.dao.reporitory.NoteRepository;
import ua.keep.view.NoteView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet(name = "NoteServlet", urlPatterns = {"/note/*"})
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/main");
            return;
        }

        NoteRepository noteRepository = new NoteRepository();
        // save note
        if ( request.getParameter("title") != null ) {
            Note note = new Note();
            note.setTitle(request.getParameter("title"));
            note.setText(request.getParameter("note"));
            note.setColorText(request.getParameter("colorFont"));
            note.setColorBackground(request.getParameter("background"));
            note.setUser_id(user.getId());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            note.setDateEdited(timestamp.toString());
            noteRepository.saveNote(note);
        }
        NoteView noteView = new NoteView();
        switch (request.getPathInfo()) {
            case "/index":
                out.println(noteView.getIndex(noteRepository.getNotesByUserId(user.getId())));
                break;
                default:
                    out.println(noteView.getHtml());
        }


    }
}
