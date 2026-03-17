package project.controller;




import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.entity.Issue;
import project.entity.IssueCategory;
import project.entity.IssueStatus;
import project.service.IssueService;

@RestController
@RequestMapping("/api/admin/issues")
@CrossOrigin
public class AdminController {

    private final IssueService service;

    public AdminController(IssueService service) {
        this.service = service;
    }

    // View all issues
    @GetMapping
    public List<Issue> getAll() {
        return service.getAllIssues();
    }

    // Update issue status
    @PutMapping("/{id}/status")
    public Issue updateStatus(@PathVariable Long id, @RequestParam IssueStatus status) {
        return service.updateStatus(id, status);
    }

    // Filter by category/status
    @GetMapping("/filter")
    public List<Issue> filter(
            @RequestParam(required = false) IssueCategory category,
            @RequestParam(required = false) IssueStatus status
    ) {
        return service.filter(category, status);
    }
}
