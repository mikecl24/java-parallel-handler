package mikecl24.parallelhandler;
import mikecl24.parallelhandler.service.ParallelExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:parallelhandler.properties")
public class ParallelHandler {
    private static final Logger logger = LoggerFactory.getLogger(ParallelExecutor.class);

    public static void main(String[] args) {
        SpringApplication.run(ParallelHandler.class, args);
    }

}
