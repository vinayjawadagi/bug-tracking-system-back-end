package com.vinay.BugTrackingSystem.repository;

import com.vinay.BugTrackingSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
