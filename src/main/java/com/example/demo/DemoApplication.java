package com.example.demo;

import com.example.demo.service.Greeting;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class DemoApplication {




	public static void main(String[] args) throws IOException {

		Server server = ServerBuilder.forPort(Integer.parseInt(System.getenv("PORT")))
				.addService(new Greeting())
				.build();
		server.start();
		log.info("Starting server at: {}", server.getPort());

		SpringApplication.run(DemoApplication.class, args);

	}

}
