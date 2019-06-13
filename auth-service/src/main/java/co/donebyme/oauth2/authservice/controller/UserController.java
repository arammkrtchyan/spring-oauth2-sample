package co.donebyme.oauth2.authservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Aram Mkrtchyan.
 */
@RestController
public class UserController {

    @GetMapping({"/user", "/me"})
    @PreAuthorize("#oauth2.hasScope('read')")
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }

}
