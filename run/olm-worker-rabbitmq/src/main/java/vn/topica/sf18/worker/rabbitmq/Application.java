package vn.topica.sf18.worker.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.topica.sf18.config.EnableCommonService;
import vn.topica.sf18.sql.config.EnableMySQL;

@EnableCommonService
@EnableMySQL
@SpringBootApplication
@Slf4j
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }

  @Override
  public void run(String... args) {

  }
}
