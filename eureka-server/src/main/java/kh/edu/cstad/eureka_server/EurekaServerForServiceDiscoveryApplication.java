package kh.edu.cstad.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerForServiceDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerForServiceDiscoveryApplication.class, args);
	}

}
