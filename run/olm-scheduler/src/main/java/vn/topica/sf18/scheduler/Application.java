package vn.topica.sf18.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import vn.topica.sf18.queue.rabbitmq.config.EnableRabbitmqQueue;

@EnableRabbitmqQueue
@EnableScheduling
@Slf4j
@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {

  }
}
