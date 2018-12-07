package ua.keep.view;

public class MainView {

    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###header###-->", indexSingleton.getHeader())
                .replace("<!--###content###-->", indexSingleton.getLogin());
    }
}
