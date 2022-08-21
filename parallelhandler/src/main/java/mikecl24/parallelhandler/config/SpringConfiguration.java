package mikecl24.parallelhandler.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PreDestroy;

@Configuration
@EnableScheduling
public class SpringConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);

    @Value("${parallelhandler.poolsize}")
    private Integer poolSize;

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(this.poolSize);
        taskExecutor.setMaxPoolSize(this.poolSize);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @PreDestroy
    public void destroy() {
        logger.info("Shutdown initiated");
    }
}
