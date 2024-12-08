package com.example.demo;

import com.example.demo.service.Greeting;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class DemoApplication {




	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(DemoApplication.class, args);

		int port = 1025;
		Server server = NettyServerBuilder.forPort(port)
				.addService(new Greeting())
				.build()
				.start();
		log.info("Starting server at: {}", server.getPort());
		server.awaitTermination();
	}

}
