package com.vinay.BugTrackingSystem.service;

import com.vinay.BugTrackingSystem.exception.ResourceNotFoundException;
import com.vinay.BugTrackingSystem.model.Bug;
import com.vinay.BugTrackingSystem.model.User;
import com.vinay.BugTrackingSystem.repository.BugRepository;
import com.vinay.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BugService {

  @Autowired
  private BugRepository bugRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Bug> getAllBugs() {
    return bugRepository.findAll();
  }

  public Bug getBugById(Long id) {
    return bugRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Bug not found with id: " + id));
  }

  public Bug createBug(Bug bug, Long creatorId) {
    User creator = userRepository.findById(creatorId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + creatorId));

    bug.setCreatedBy(creator);
    return bugRepository.save(bug);
  }

  public Bug updateBug(Long id, Bug bugDetails) {
    Bug bug = getBugById(id);

    bug.setTitle(bugDetails.getTitle());
    bug.setDescription(bugDetails.getDescription());
    bug.setStatus(bugDetails.getStatus());
    bug.setPriority(bugDetails.getPriority());

    return bugRepository.save(bug);
  }

  public void deleteBug(Long id) {
    bugRepository.deleteById(id);
  }
}

