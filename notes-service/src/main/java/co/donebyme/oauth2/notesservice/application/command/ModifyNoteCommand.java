package co.donebyme.oauth2.notesservice.application.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ModifyNoteCommand {

    @JsonIgnore
    private String modifierUser;

    private String noteId;

    @Size(max = 50)
    @NotEmpty
    private String title;

    @Size(max = 1000)
    private String note;

    @JsonCreator
    public ModifyNoteCommand(
            @JsonProperty("title") String title,
            @JsonProperty("note") String note) {
        this.title = title;
        this.note = note;
    }

    public ModifyNoteCommand setModifierUser(String modifierUser) {
        this.modifierUser = modifierUser;
        return this;
    }

    public ModifyNoteCommand setNoteId(String noteId) {
        this.noteId = noteId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getModifierUser() {
        return modifierUser;
    }
}
