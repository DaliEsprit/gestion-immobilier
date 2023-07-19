package tn.esprit.immobilier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.log4j.Log4j2;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
@Log4j2
public class ImmobilierApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ImmobilierApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(" ####### Spring Started #######");
		
	}

}
