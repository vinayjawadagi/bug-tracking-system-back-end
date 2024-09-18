package com.vinay.BugTrackingSystem.repository;

import com.vinay.BugTrackingSystem.model.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug, Long> {

}
