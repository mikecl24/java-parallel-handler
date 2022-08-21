package mikecl24.parallelhandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:parallelhandler.properties")
public class ParallelHandler {
    public static void main(String[] args) {
        SpringApplication.run(ParallelHandler.class, args);
    }
}
