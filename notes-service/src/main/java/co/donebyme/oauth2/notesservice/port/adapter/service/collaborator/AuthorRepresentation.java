package co.donebyme.oauth2.notesservice.port.adapter.service.collaborator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aram Mkrtchyan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class AuthorRepresentation {

    private String email;

    private String id;

    @JsonCreator
    public AuthorRepresentation(
            @JsonProperty(value = "id") String id,
            @JsonProperty(value = "email") String email) {
        this.email = email;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
