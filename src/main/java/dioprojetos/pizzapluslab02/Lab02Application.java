package dioprojetos.pizzapluslab02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Lab02Application {


	public static void main(String[] args) {
		SpringApplication.run(Lab02Application.class, args);
	}

}
