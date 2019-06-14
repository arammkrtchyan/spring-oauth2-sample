package co.donebyme.oauth2.notesservice.port.adapter.persistence;

import co.donebyme.oauth2.notesservice.model.author.Author;
import co.donebyme.oauth2.notesservice.model.note.Note;
import co.donebyme.oauth2.notesservice.model.note.NoteId;
import co.donebyme.oauth2.notesservice.model.note.NoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
public interface JpaNoteRepository extends NoteRepository, JpaRepository<Note, NoteId> {

    @Override
    default Optional<Note> of(NoteId noteId) {
        return findById(noteId);
    }

    List<Note> findByAuthor(Author author);

    @Override
    default List<Note> notesOfUser(Author author) {
        return findByAuthor(author);
    }
}
