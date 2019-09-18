package me.ashaneediri.fbretrieve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * SpringBoot main class
 *
 */
@SpringBootApplication
@ImportResource("classpath:WebContentInterceptor.xml")
public class FbDataRetrieverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FbDataRetrieverApplication.class, args);
	}
}
