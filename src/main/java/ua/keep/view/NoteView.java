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
            return "<div class=\"col-6 col-sm-4 col-md-3\" style=\"background-color: " + n.getColorBackground() + ";\">\n" +
                    "<h3>" + n.getTitle() + "</h3>\n" +
                    "<p>" + n.getText() + "</p>\n" +
                    "</div>\n" +
                    "<!--###-add-note-###-->";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-note-###-->", allNotes);
    }

}
