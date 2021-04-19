package com.henrique3g.crudproductssimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class CrudProductsSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudProductsSimpleApplication.class, args);
	}

}
