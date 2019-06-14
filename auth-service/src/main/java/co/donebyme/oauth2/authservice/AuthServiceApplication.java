package co.donebyme.oauth2.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthServiceApplication implements CommandLineRunner  {

	@Autowired
	public AuthServiceApplication(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(passwordEncoder.encode("aram"));
	}
}
