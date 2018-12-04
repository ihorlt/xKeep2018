package ua.keep.controller.dao.entities;

/**
 * Personal Notes for everu user
 */
public class Note {
    private long id;
    private long user_id;
    private String title;
    private String text;
    private String dateEdited;
    private String colorText;
    private String colorBackground;

    public Note() {
    }

    public Note(long id, long user_id, String title, String text,
                String dateEdited, String colorText, String colorBackground) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        this.dateEdited = dateEdited;
        this.colorText = colorText;
        this.colorBackground = colorBackground;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(String dateEdited) {
        this.dateEdited = dateEdited;
    }

    public String getColorText() {
        return colorText;
    }

    public void setColorText(String colorText) {
        this.colorText = colorText;
    }

    public String getColorBackground() {
        return colorBackground;
    }

    public void setColorBackground(String colorBackground) {
        this.colorBackground = colorBackground;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", dateEdited='" + dateEdited + '\'' +
                ", colorText='" + colorText + '\'' +
                ", colorBackground='" + colorBackground + '\'' +
                '}';
    }
}
