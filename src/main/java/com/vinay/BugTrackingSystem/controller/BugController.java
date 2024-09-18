package com.vinay.BugTrackingSystem.controller;

import com.vinay.BugTrackingSystem.model.Bug;
import com.vinay.BugTrackingSystem.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bugs")
public class BugController {

  @Autowired
  private BugService bugService;

  @GetMapping
  public List<Bug> getAllBugs() {
    return bugService.getAllBugs();
  }

  @GetMapping("/{id}")
  public Bug getBugById(@PathVariable Long id) {
    return bugService.getBugById(id);
  }

  @PostMapping
  public Bug createBug(@RequestBody Bug bug, @RequestParam Long creatorId) {
    return bugService.createBug(bug, creatorId);
  }

  @PutMapping("/{id}")
  public Bug updateBug(@PathVariable Long id, @RequestBody Bug bugDetails) {
    return bugService.updateBug(id, bugDetails);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBug(@PathVariable Long id) {
    bugService.deleteBug(id);
    return ResponseEntity.ok().build();
  }
}

