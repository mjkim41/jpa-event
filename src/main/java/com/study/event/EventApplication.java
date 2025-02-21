package com.study.event;

import com.study.event.config.DotEnvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(EventApplication.class);
		app.addInitializers(new DotEnvConfig());
		app.run(args);

	}

}
