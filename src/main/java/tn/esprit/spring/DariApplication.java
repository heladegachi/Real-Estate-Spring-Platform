package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import tn.esprit.spring.entity.FileResponse;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DariApplication {

	public static void main(String[] args) {
		SpringApplication.run(DariApplication.class, args);
	}

}
