package project.repsoitory;

import org.springframework.data.jpa.repository.JpaRepository;

import project.entity.Issue;
import project.entity.IssueCategory;
import project.entity.IssueStatus;
import java.util.List;

public interface IssueRepository extends JpaRepository<Issue,Long> {
	
	 List<Issue> findByCategory(IssueCategory category);
	    List<Issue> findByStatus(IssueStatus status);
	    List<Issue> findByCategoryAndStatus(IssueCategory category, IssueStatus status);

}
