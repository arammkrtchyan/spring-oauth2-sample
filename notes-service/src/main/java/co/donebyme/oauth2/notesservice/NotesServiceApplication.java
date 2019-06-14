package co.donebyme.oauth2.notesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NotesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesServiceApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Configuration
    @EnableResourceServer
    public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            super.configure(http);
        }

        @Primary
        @Bean
        public RemoteTokenServices tokenService() {
            RemoteTokenServices tokenService = new RemoteTokenServices();
            tokenService.setCheckTokenEndpointUrl(
                    "http://localhost:8181/auth-service/oauth/check_token");
            tokenService.setClientId("fooClientIdPassword");
            tokenService.setClientSecret("secret");
            return tokenService;
        }
    }

}
