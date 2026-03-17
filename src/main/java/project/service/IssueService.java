package project.service;


import java.util.List;

import org.springframework.stereotype.Service;

import project.entity.Issue;
import project.entity.IssueCategory;
import project.entity.IssueStatus;
import project.repsoitory.IssueRepository;

@Service
public class IssueService {

    private final IssueRepository repository;

    public IssueService(IssueRepository repository) {
        this.repository = repository;
    }
    
    

    public Issue reportIssue(Issue issue) {
        return repository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return repository.findAll();
    }

    public List<Issue> filter(IssueCategory category, IssueStatus status) {
        if (category != null && status != null)
            return repository.findByCategoryAndStatus(category, status);
        else if (category != null)
            return repository.findByCategory(category);
        else if (status != null)
            return repository.findByStatus(status);
        return repository.findAll();
    }

    public Issue updateStatus(Long id, IssueStatus status) {
        Issue issue = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
        issue.setStatus(status);
        return repository.save(issue);
    }

    public Issue getIssueById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Issue not found"));
    }
}
