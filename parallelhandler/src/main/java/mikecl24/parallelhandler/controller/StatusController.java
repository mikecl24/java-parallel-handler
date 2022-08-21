package mikecl24.parallelhandler.controller;


import mikecl24.parallelhandler.service.ParallelExecutor;
import org.apache.catalina.loader.ParallelWebappClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @Autowired
    ParallelExecutor parallelExecutor;

    @GetMapping("/")
    public String status() {
        return "Webserver is up";
    }

    @PostMapping("/trigger")
    public String trggerService() {
        int poolSize = this.parallelExecutor.getPoolSize();
        return "Started task with thread count: " + poolSize;
    }
}
