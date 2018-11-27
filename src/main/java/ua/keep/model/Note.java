package ua.keep.model;

/**
 * Personal Notes for everu user
 */
public class Note {
    private long id;
    private long user_id;
    private String title;
    private String text;
    private String dateEdited;
    private int color;

    public Note(long id, long user_id, String title, String text, String dateEdited, int color) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.text = text;
        this.dateEdited = dateEdited;
        this.color = color;
    }

    public Note() {
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", dateEdited='" + dateEdited + '\'' +
                ", color=" + color +
                '}';
    }
}
