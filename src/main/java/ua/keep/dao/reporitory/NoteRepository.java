package ua.keep.dao.reporitory;

import ua.keep.dao.entities.Note;
import ua.keep.dao.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Getting / Putting Data into / from Database
 */
public class NoteRepository {

    public void saveNote(Note note) {
        DataSource dataSource = new DataSource();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO note (user_id, title, text, colorText, colorBackground, dateEdited) VALUES (?,?,?,?,?,?)")
        ) {
            stmt.setLong(1, note.getUser_id());
            stmt.setString(2, note.getTitle());
            stmt.setString(3, note.getText());
            stmt.setString(4, note.getColorText());
            stmt.setString(5, note.getColorBackground());
            stmt.setString(6, note.getDateEdited());

            System.out.println(stmt.toString());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Note> getNotesByUserId( long userId ) {
        DataSource dataSource = new DataSource();
        List<Note> notes = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT id, user_id, title, text, colorText, colorBackground, dateEdited FROM note WHERE user_id = " + userId);
        ) {
            while ( rs.next() ) {
                notes.add(new Note(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("text"),
                        rs.getString("dateEdited"),
                        rs.getString("colorText"),
                        rs.getString("colorBackground")
                ));
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

        return notes;
    }

}
