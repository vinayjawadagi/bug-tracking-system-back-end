package com.vinay.BugTrackingSystem.repository;

import com.vinay.BugTrackingSystem.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
