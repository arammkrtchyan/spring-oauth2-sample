package co.donebyme.oauth2.notesservice.port.adapter.service.collaborator;


import co.donebyme.oauth2.notesservice.model.author.Author;
import co.donebyme.oauth2.notesservice.model.author.AuthorId;

/**
 * @author Aram Mkrtchyan.
 */
class CollaboratorTranslator {


    Author toAuthorFromRepresentation(AuthorRepresentation representation) {
        return new Author(new AuthorId(representation.getId()), representation.getEmail());
    }

}
