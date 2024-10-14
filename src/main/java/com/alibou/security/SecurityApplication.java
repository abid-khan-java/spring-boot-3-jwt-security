package com.alibou.security;

import com.alibou.security.auth.AuthenticationResponse;
import com.alibou.security.auth.AuthenticationService;
import com.alibou.security.auth.RegisterRequest;
import com.alibou.security.customException.UserAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static com.alibou.security.user.Role.ADMIN;
import static com.alibou.security.user.Role.MANAGER;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@Slf4j
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			log.info("Creating user Admin with role admin");
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("password")
					.role(ADMIN)
					.build();

			AuthenticationResponse registerAdmin;
			try {
				registerAdmin = service.register(admin);
                log.info("Admin token: {}", registerAdmin.getAccessToken());
			} catch (UserAlreadyExistsException e) {
				// do nothing
			}

			log.info("Creating user Manager with role manager");
			var manager = RegisterRequest.builder()
					.firstname("Manager")
					.lastname("Manger")
					.email("manager@mail.com")
					.password("password")
					.role(MANAGER)
					.build();

			AuthenticationResponse registerManger;
			try {
				registerManger = service.register(manager);
                log.info("Manager token: {}", registerManger.getAccessToken());
			} catch (UserAlreadyExistsException e) {
				// do nothing
			}

		};
	}
}
