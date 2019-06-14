package co.donebyme.oauth2.notesservice.domain.model.note;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Note's identity value.
 *
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class NoteId implements Serializable {

    /**
     * Constructs Note id from existing identity.
     */
    public static NoteId fromExisting(String id) {
        return new NoteId(id);
    }

    private String id;

    NoteId(){}

    private NoteId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteId noteId = (NoteId) o;
        return Objects.equals(id, noteId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
