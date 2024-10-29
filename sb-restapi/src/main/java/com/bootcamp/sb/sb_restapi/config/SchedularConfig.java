package com.bootcamp.sb.sb_restapi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// Check myself only when someone call me
// SchedularConfig -> can perform regular check
// @EnableScheduling in Application.java
@Component
public class SchedularConfig {
  // main thread: listening web layer ...

  // @Scheduled(fixedDelay = 5000) // 5000ms = 5s
  // fixedDelay = endtask -> 5s -> starttask -> 6s -> endtask
  public void sayHello() throws Exception {
    System.out.println("Task A: Say Hello ... Start=" + System.currentTimeMillis()); // thread for Task A ...
    Thread.sleep(6000);
    System.out.println("Task A: Say Hello ... End=" + System.currentTimeMillis());
  }

  // @Scheduled(fixedRate = 3000) // no stop(), has zone()
  // fixedRate = 每3秒就starttask, 唔理task行完未, but ...
  // endtask -> thread得一條, 遲咗所以即starttask -> 4s -> endtask+starttask
  public void sayBye() throws Exception {
    // write if () ... if need to stop this thread
    System.out.println("Task B: Say Bye ... Start=" + System.currentTimeMillis());
    Thread.sleep(4000);
    System.out.println("Task B: Say Bye ... End=" + System.currentTimeMillis());
  }


  // Lark Week 26 - 28 Chapter 19 Cron Job
  // timezone follows localhost by default
  // @Scheduled(cron = "0 55 20 * * TUE")
  public void runTask() {
    System.out.println("Cron Job Test");
  }
}
