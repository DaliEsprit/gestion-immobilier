package tn.esprit.immobilier;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import tn.esprit.immobilier.services.FilesStoreService;

import javax.annotation.Resource;


@SpringBootApplication
@EnableAspectJAutoProxy
@EnableScheduling
public class ImmobilierApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ImmobilierApplication.class, args);
	}


}
