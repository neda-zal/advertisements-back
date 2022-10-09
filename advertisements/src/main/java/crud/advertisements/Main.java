package crud.advertisements;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@Slf4j
public class Main extends SpringBootServletInitializer  {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Main.class);
    app.run(args);
  }

}