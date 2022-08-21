package mikecl24.parallelhandler.domain;

import mikecl24.parallelhandler.service.ParallelExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TaskRunner implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(TaskRunner.class);
    List<Integer> tasks;

    public TaskRunner(List<Integer> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        logger.info("Running from thread: " + this.hashCode());
        for (int task: this.tasks) {
            logger.info("Handling job: " + task + " from thread " + this.hashCode());
            // Artificial delay...
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        logger.info("Thread finished " + this.hashCode());
    }
}
