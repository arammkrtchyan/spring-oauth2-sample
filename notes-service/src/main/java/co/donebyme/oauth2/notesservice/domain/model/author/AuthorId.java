package co.donebyme.oauth2.notesservice.domain.model.author;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Aram Mkrtchyan.
 */
public class AuthorId implements Serializable {

    private String id;

    AuthorId(){}

    public AuthorId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorId authorId = (AuthorId) o;
        return Objects.equals(id, authorId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
