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
public class SubmitNoteCommand {

    @JsonIgnore
    private String email;

    @Size(max = 50)
    @NotEmpty(message = "Please provide title of the note.")
    private String title;

    @Size(max = 1000)
    private String note;

    @JsonCreator
    public SubmitNoteCommand(
            @JsonProperty("email") String email,
            @JsonProperty("title")String title,
            @JsonProperty("note")String note) {
        this.email = email;
        this.title = title;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    @JsonIgnore
    public SubmitNoteCommand setEmail(String email) {
        this.email = email;
        return this;
    }
}
