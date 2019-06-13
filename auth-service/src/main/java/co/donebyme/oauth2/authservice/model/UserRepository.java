package co.donebyme.oauth2.authservice.model;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aram Mkrtchyan.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
