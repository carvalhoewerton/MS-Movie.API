package msmvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class MvapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvapiApplication.class, args);
	}

}
