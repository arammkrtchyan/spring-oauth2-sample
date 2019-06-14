package co.donebyme.oauth2.notesservice.model.note;


import co.donebyme.oauth2.notesservice.model.author.Author;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Aram Mkrtchyan.
 */
@Entity
public class Note {

    private String title;

    private String note;

    @EmbeddedId
    private NoteId noteId;

    @Embedded
    private Author author;

    private ZonedDateTime dateRecordAdded;

    private ZonedDateTime modifiedDate;

    public static Note submitNote(String title, String note, Author author) {
        return new Note(title, note, author);
    }

    Note() {
        // For JPA
    }

    private Note(String title, String note, Author author) {
        this(title, note, author, NoteId.fromExisting(UUID.randomUUID().toString()));
    }

    private Note(String title, String note, Author author, NoteId noteId) {
        this.title = validateTitle(title);
        this.note = validateNote(note);
        this.author = Objects.requireNonNull(author, "Notes author should be specified");
        this.noteId = noteId;
        this.dateRecordAdded = ZonedDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public NoteId getNoteId() {
        return noteId;
    }

    public String getNote() {
        return note;
    }

    public Author getAuthor() {
        return author;
    }


    public Note changeTitle(String title) {
        this.title = validateTitle(title);
        modifiedDate = ZonedDateTime.now();
        return this;
    }

    public Note changeNote(String note) {
        this.note = validateNote(note);
        modifiedDate = ZonedDateTime.now();
        return this;
    }

    public ZonedDateTime getDateRecordAdded() {
        return dateRecordAdded;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    private static String validateTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title can not be empty");
        } else if (title.length() >= 50) {
            throw new IllegalArgumentException("Length of the note's title can not exceed 50.");
        } else {
            return title;
        }
    }

    private static String validateNote(String note) {
        if (note != null && note.length() >= 1000) {
            throw new IllegalArgumentException("Length of the not can not exceed 1000.");
        } else {
            return note;
        }
    }
}
