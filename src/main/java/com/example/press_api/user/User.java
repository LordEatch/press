package com.example.press_api.user;

import com.example.press_api.validation.Validation;
import jakarta.persistence.*;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String username;
  private String passwordHash;
  private boolean darkMode;

  public Integer getId() {
    return this.id;
  }
  public String getUsername() {
    return username;
  }
  public boolean isDarkMode() {
    return darkMode;
  }

  public User() {
  }

  public User(String username, String password) throws Exception {
    // Validate username and password format.
    if (!Validation.validateUsernameFormat(username)) {
      /* Throwing an exception here will crash the process but username and password formats
      *  should be checked before creating a user using the validation class anyway. This
      *  validation simply ensures that a user is not accidentally inserted into the database
      *  with an invalid username or password (if the checks were forgotten). */
      throw new Exception("Incorrect username format.");
    }
    if (!Validation.validatePasswordFormat(password)) {
      throw new Exception("Incorrect password format.");
    }

    this.username = username;
    this.passwordHash = generatePasswordHash(password);
    this.darkMode = false;
  }

  public boolean validatePasswordHash(String attemptedPasswordHash) {
    return attemptedPasswordHash.equals(this.passwordHash);
  }

  private static String generatePasswordHash(String plaintextPassword) {
    return plaintextPassword;
  }
}
