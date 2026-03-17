package project.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.entity.Issue;
import project.service.IssueService;

@RestController
@RequestMapping("/api/user/issues")
@CrossOrigin
public class CitizenController {

    private final IssueService service;

    public CitizenController(IssueService service) {
        this.service = service;
    }

    // Report a new issue
    @PostMapping("/report")
    public Issue reportIssue(@RequestBody Issue issue) {
        return service.reportIssue(issue);
    }

    // View a single issue
    @GetMapping("/{id}")
    public Issue getMyIssue(@PathVariable Long id) {
        return service.getIssueById(id);
    }
 // View all issues (new endpoint for citizen)
    @GetMapping
    public List<Issue> getAllIssues() {
        return service.getAllIssues();
    }
}
