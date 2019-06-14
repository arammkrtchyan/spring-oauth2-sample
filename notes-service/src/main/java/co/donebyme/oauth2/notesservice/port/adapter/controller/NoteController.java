package co.donebyme.oauth2.notesservice.port.adapter.controller;


import co.donebyme.oauth2.notesservice.application.NoteApplicationService;
import co.donebyme.oauth2.notesservice.application.command.ModifyNoteCommand;
import co.donebyme.oauth2.notesservice.application.command.SubmitNoteCommand;
import co.donebyme.oauth2.notesservice.model.note.Note;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aram Mkrtchyan.
 */
@RestController
@RequestMapping("/notes")
public class NoteController {


    private final NoteApplicationService noteApplicationService;

    public NoteController(NoteApplicationService noteApplicationService) {
        this.noteApplicationService = noteApplicationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Note submitNote(@Valid @RequestBody SubmitNoteCommand command) {
        return noteApplicationService.submitNote(command.setEmail(getUserEmail()));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}")
    public NoteView findNote(@PathVariable String id) {
        return noteView(noteApplicationService.findById(getUserEmail(), id));
    }


    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<NoteView> notesOfUser() {
        return noteApplicationService.notesOfAuthor(getUserEmail()).stream()
                .map(this::noteView).collect(Collectors.toList());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public NoteView modifyNote(@PathVariable String id, @Valid @RequestBody ModifyNoteCommand command) {
        command.setModifierUser(getUserEmail()).setNoteId(id);
        return noteView(noteApplicationService.modifyNote(command));
    }

    private NoteView noteView(Note note) {
        return new NoteView(
                note.getNote(),
                note.getTitle(),
                note.getNoteId().getId()
        );
    }

    private String getUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

}
