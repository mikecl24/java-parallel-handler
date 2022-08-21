package mikecl24.parallelhandler.service;

import mikecl24.parallelhandler.domain.TaskRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ParallelExecutor {
    private static final Logger logger = LoggerFactory.getLogger(ParallelExecutor.class);

    @Value("${parallelhandler.poolsize}")
    private Integer poolSize;

    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskList;

    @PostConstruct
    public void init() {
        logger.info("TaskExecutor service started");
    }

    public Integer getPoolSize() {
        return this.poolSize;
    }

    @PreDestroy
    public void destroy() {
        logger.info("Shutdown initiated");
    }

    public void addTaskList(List<Integer> tasks) {
        TaskRunner taskRunner = new TaskRunner(tasks);
        this.taskList.execute(taskRunner);


    }
}
