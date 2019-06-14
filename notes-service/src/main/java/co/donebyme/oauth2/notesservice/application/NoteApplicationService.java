package co.donebyme.oauth2.notesservice.application;


import co.donebyme.oauth2.notesservice.application.command.ModifyNoteCommand;
import co.donebyme.oauth2.notesservice.application.command.SubmitNoteCommand;
import co.donebyme.oauth2.notesservice.application.exception.NoteAccessDeniedException;
import co.donebyme.oauth2.notesservice.application.exception.NoteNotFoundException;
import co.donebyme.oauth2.notesservice.application.exception.UserNotFoundException;
import co.donebyme.oauth2.notesservice.domain.model.author.Author;
import co.donebyme.oauth2.notesservice.domain.model.author.CollaboratorService;
import co.donebyme.oauth2.notesservice.domain.model.note.Note;
import co.donebyme.oauth2.notesservice.domain.model.note.NoteId;
import co.donebyme.oauth2.notesservice.domain.model.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Aram Mkrtchyan.
 */
@Service
public class NoteApplicationService {


    private final NoteRepository noteRepository;

    private final CollaboratorService collaboratorService;

    @Autowired
    public NoteApplicationService(NoteRepository noteRepository, CollaboratorService collaboratorService) {
        this.noteRepository = noteRepository;
        this.collaboratorService = collaboratorService;
    }

    public Note submitNote(SubmitNoteCommand command) {
        String email = command.getEmail();
        Author author = collaboratorService.authorFrom(email);
        if(author == null) {
            throw new UserNotFoundException(String.format("No user with specified email: %s", email));
        } else {
            Note note = Note.submitNote(command.getTitle(), command.getNote(), author);
            return noteRepository.save(note);
        }
    }

    public List<Note> notesOfAuthor(String email) {
        Author author = collaboratorService.authorFrom(email);
        if (author == null) {
            throw new UserNotFoundException(String.format("No user with specified email: %s", email));
        }

        return noteRepository.notesOfUser(author);

    }

    public Note findById(String email, String identity) {
        Author author = collaboratorService.authorFrom(email);
        if (author == null) {
            throw new UserNotFoundException(String.format("No user with specified email: %s", email));
        }

        Optional<Note> note = noteRepository.of(NoteId.fromExisting(identity));


        return note.map(n -> {
            if (!Objects.equals(author.getAuthorId(), n.getAuthor().getAuthorId())) {
                throw new NoteAccessDeniedException("No access to the notes of the others.");
            }
            return n;
        }).orElseThrow(() ->
                new NoteNotFoundException("Couldn't find note with specified identity.")
        );

    }

    public Note modifyNote(ModifyNoteCommand command) {
        Note note = findById(command.getModifierUser(), command.getNoteId());

        note.changeNote(command.getNote())
                .changeTitle(command.getTitle());

        return this.noteRepository.save(note);
    }

}
