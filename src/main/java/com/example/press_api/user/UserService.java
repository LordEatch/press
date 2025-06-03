package com.example.press_api.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository repository;

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public User getUser(Integer id) {
    return repository.findById(id).orElse(null);
  }

  public void createUser(User user) {
    repository.save(user);
  }
}
