package co.donebyme.oauth2.authservice.security;

import co.donebyme.oauth2.authservice.model.User;
import co.donebyme.oauth2.authservice.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Aram Mkrtchyan.
 */
@Service
public class SystemUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public SystemUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
