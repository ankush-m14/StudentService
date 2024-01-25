package ankush.dev.studentinfo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentInfoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
