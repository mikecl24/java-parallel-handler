package mikecl24.parallelhandler.controller;


import mikecl24.parallelhandler.service.ParallelExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @Value("${parallelhandler.poolsize}")
    private Integer poolSize;

    @Autowired
    ParallelExecutor parallelExecutor;

    @GetMapping("/")
    public String status() {
        return "Webserver is up";
    }

    /*
    Check the current pool size configuration
     */
    @GetMapping("/executor")
    public String trggerService() {
        int poolSize = this.parallelExecutor.getPoolSize();
        return "Executor is running with pool size: " + poolSize;
    }
}
