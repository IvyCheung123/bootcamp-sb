package com.bootcamp.sb.sb_restapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Before server startup, similar to ...
// @Autowired(required = false) -> this class not exist will not run, run if exist
// private CommandLineRunner commandLineRunner;
// if (commandLineRunner != null)
//   commandLineRunner.run();

// Purpose: healthcheck before system is published (server startup for client to use)

@Component // create one bean for this class
public class AppStartRunner implements CommandLineRunner {
  // CommandLineRunner is used for sth (outside dependencies check, e.g. @Autowired) must be done before server startup
  // so do not throw

  @Override
  public void run(String... args) throws Exception {
    System.out.println("AppStartRunner ...");
    // throw new Exception();
  }
}
