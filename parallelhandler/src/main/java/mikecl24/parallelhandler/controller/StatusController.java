package mikecl24.parallelhandler.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/")
    public String status() {
        return "Webserver is up";
    }
}
