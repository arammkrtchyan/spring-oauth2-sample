package co.donebyme.oauth2.notesservice.domain.model.note;


import co.donebyme.oauth2.notesservice.domain.model.author.Author;

import java.util.List;
import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
public interface NoteRepository {

    Note save(Note note);

    Optional<Note> of(NoteId noteId);

    List<Note> notesOfUser(Author author);

}
