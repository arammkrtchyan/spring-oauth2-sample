package co.donebyme.oauth2.notesservice.port.adapter.service.collaborator;

import co.donebyme.oauth2.notesservice.domain.model.author.Author;

/**
 * @author Aram Mkrtchyan.
 */
public interface UserInRoleAdapter {

    Author toAuthor(String identity);

}
