package com.vinay.BugTrackingSystem.service;

import com.vinay.BugTrackingSystem.exception.ResourceNotFoundException;
import com.vinay.BugTrackingSystem.model.User;
import com.vinay.BugTrackingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+ id));
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public User updateUser(Long id, User userDetails) {
    User user = getUserById(id);

    user.setName(userDetails.getName());
    user.setEmail(userDetails.getEmail());
    user.setRole(userDetails.getRole());

    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
