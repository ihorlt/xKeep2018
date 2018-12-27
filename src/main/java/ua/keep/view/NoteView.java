package ua.keep.view;

import ua.keep.dao.entities.Note;

import java.util.List;
import java.util.stream.Collectors;

public class NoteView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getNoteForm());
    }

    public String getIndex( List<Note> notes ) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getNoteIndex());

        String allNotes = notes.stream().map(n -> {
            String text = "";
            if ( n.getText() != null ) {
                text = n.getText().length() > 20 ? n.getText().substring(0, 19) : n.getText();
            }
            return "<a class=\"note-short-view\" href=\"/note/edit?id=" + n.getId() + "\">" +
                    "<div class=\"col-6 col-sm-4 col-md-3\" style=\"background-color: " + n.getColorBackground() + ";\">\n" +
                    "<h3 style=\"color: " + n.getColorText() + ";\">" + n.getTitle() + "</h3>\n" +
                    "<p style=\"color: " + n.getColorText() + ";\">" + text +
                    "</p>\n" +
                    "</div>\n" +
                    "</a>";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-note-###-->", allNotes);
    }

    public String getExistingNote( Note note) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getNoteForm())
                .replace("></textarea>", ">" +
                        note.getText() +
                        "</textarea>")
                .replace("<!--###existing-note-id###-->", "<input name=\"noteid\" type=\"hidden\" value=\"" + note.getId() + "\">");
    }

}
