package mikecl24.parallelhandler.scheduled;

import mikecl24.parallelhandler.domain.TaskRunner;
import mikecl24.parallelhandler.service.ParallelExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TaskPopulator {
    private static final Logger logger = LoggerFactory.getLogger(TaskPopulator.class);

        @Autowired
        private ParallelExecutor parallelExecutor;
        /*
        Initialize runner pool every 10 seconds
         */
        @Scheduled(fixedDelay = 10000, initialDelay = 1000)
        public void populate() {
            logger.info("Populating executor pools");
            ArrayList<Integer> tasks = new ArrayList<>();
            tasks.add(1);
            tasks.add(2);
            tasks.add(3);

            parallelExecutor.addTaskList(tasks);
            parallelExecutor.addTaskList(tasks);
            parallelExecutor.addTaskList(tasks);
        }
}
