package co.donebyme.oauth2.notesservice.port.adapter.service.collaborator;

import co.donebyme.oauth2.notesservice.domain.model.author.Author;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Aram Mkrtchyan.
 */
@Component
public class HttpUserInRoleAdapter implements UserInRoleAdapter {

    private RestTemplate restTemplate;

    private CollaboratorTranslator collaboratorTranslator = new CollaboratorTranslator();

    public HttpUserInRoleAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Author toAuthor(String email) {
        AuthorRepresentation representation = new AuthorRepresentation("1", email)/*restTemplate.getForEntity(
                // TODO make configurable or use eureka
                "http://localhost:8181/auth-service/users?email={email}",
                AuthorRepresentation.class,
                email
        ).getBody()*/;

        return collaboratorTranslator.toAuthorFromRepresentation(representation);
    }

}
