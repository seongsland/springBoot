package seongsland;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Run extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
		System.out.println("spring started.");
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Run.class);
	}
}
