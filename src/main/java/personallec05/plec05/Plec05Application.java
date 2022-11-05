package personallec05.plec05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class Plec05Application {

  public static void main(String[] args) {
    SpringApplication.run(Plec05Application.class, args);
  }

}
