package com.bootcamp.sb.sb_restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // inject some other beans into context from this Annotation for SchedulerConfig
public class SbRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbRestapiApplication.class, args);
	}

}
