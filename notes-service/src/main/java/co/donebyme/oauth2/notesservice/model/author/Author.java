package co.donebyme.oauth2.notesservice.model.author;

import javax.persistence.*;

/**
 * In this domain represents the user who wrote the note.
 *
 * @author Aram Mkrtchyan.
 */
@Embeddable
public class Author {

    @Embedded
    @AttributeOverride(name = "id", column = @Column(name = "author_id"))
    private AuthorId authorId;

    @Transient
    private String email;

    Author(){}

    public Author(AuthorId authorId, String email) {
        this.authorId = authorId;
        this.email = email;
    }

    public AuthorId getAuthorId() {
        return authorId;
    }

    public String getEmail() {
        return email;
    }
}
