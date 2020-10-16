package br.com.sast;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sast.model.Email;

@SpringBootApplication
public class SastApplication {

	public static void main(String[] args) {
		SpringApplication.run(SastApplication.class, args);
		
	}

}
