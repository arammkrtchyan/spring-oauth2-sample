package co.donebyme.oauth2.notesservice.port.adapter.controller;

/**
 * @author Aram Mkrtchyan.
 */
public class NoteView {

    private String note;

    private String title;

    private String id;

    NoteView(String note, String title, String id) {
        this.note = note;
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

}
