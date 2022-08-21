package mikecl24.parallelhandler.service;

import mikecl24.parallelhandler.domain.TaskRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ParallelExecutor {

    private static final Logger logger = LoggerFactory.getLogger(ParallelExecutor.class);

    @Value("${parallelhandler.poolsize}")
    private Integer poolSize;

    /*
    Initialize runner pool after service is setup
     */
    @PostConstruct
    public void init() {
        logger.info("Starting parallel executor service with " + this.poolSize.toString() + " threads");
        ExecutorService taskList = Executors.newFixedThreadPool(this.poolSize);

        ArrayList<Integer> tasks = new ArrayList<>();
        tasks.add(1);
        tasks.add(2);
        tasks.add(3);

        TaskRunner taskRunner1 = new TaskRunner(tasks);
        TaskRunner taskRunner2 = new TaskRunner(tasks);
        TaskRunner taskRunner3 = new TaskRunner(tasks);
        taskList.execute(taskRunner1);
        taskList.execute(taskRunner2);
        taskList.execute(taskRunner3);
    }

    public Integer getPoolSize() {
        return this.poolSize;
    }
}
