package com.Duda_bldg_rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(exclude = {SecurityConf.class})
@EnableJpaRepositories(basePackages = "model")
@EntityScan(basePackages = "model")
@ComponentScan(basePackages = {"com.Duda_bldg_rent", "model"})
public class DudaBldgRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DudaBldgRentApplication.class, args);
	}

}
