package ua.keep.view;

public class NoteView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getNoteIndex());
    }
}
