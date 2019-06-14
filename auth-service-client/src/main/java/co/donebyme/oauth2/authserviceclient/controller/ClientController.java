package co.donebyme.oauth2.authserviceclient.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Aram Mkrtchyan.
 */
@RestController("/api")
public class ClientController {

    @GetMapping("/hello")
    @PreAuthorize("#oauth2.hasScope('foo')")
    public String hello(Principal principal) {
        return principal.getName();
    }

}
