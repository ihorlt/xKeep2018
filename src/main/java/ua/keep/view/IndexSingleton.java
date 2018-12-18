package ua.keep.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndexSingleton {

    private String htmlPath;
    private String page;
    private String header;
    private String login;
    private String register;
    private String noteForm;
    private String noteIndex;

    private static IndexSingleton ourInstance = new IndexSingleton();

    public static IndexSingleton getInstance() {
        return ourInstance;
    }

    private IndexSingleton() {
    }

    public String getPage() {
        return page;
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public String getHeader() {
        return header;
    }

    public String getLogin() {
        return login;
    }

    public String getNoteForm() {
        return noteForm;
    }

    public String getRegister() {
        return register;
    }

    public String getNoteIndex() {
        return noteIndex;
    }

    public void setHtmlPath(String htmlPath) {

        this.htmlPath = htmlPath;
        this.page = getPartialHtml("index.html");
        this.header = getPartialHtml("header.html");
        this.login = getPartialHtml("login.html");
        this.noteForm = getPartialHtml("note-form.html");
        this.noteIndex = getPartialHtml("note-index.html");
        this.register = getPartialHtml("register.html");
    }

    private String getPartialHtml(String filename){
        StringBuilder strb = new StringBuilder();
        Path file = Paths.get(this.htmlPath + filename);
        Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                strb.append(line).append("\n");
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return strb.toString();
    }
}
