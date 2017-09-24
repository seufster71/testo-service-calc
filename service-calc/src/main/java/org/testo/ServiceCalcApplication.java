package org.testo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"org.testo"})
public class ServiceCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCalcApplication.class, args);
	}
}
