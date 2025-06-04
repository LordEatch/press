package com.example.validation;

public class Validation {
  // NOTE These are public because I may need to access them when displaying error messages to users creating an account.
  public static final int MIN_USERNAME_LENGTH = 5;
  public static final int MAX_USERNAME_LENGTH = 20;
  public static final int MIN_PASSWORD_LENGTH = 8;
  public static final int MAX_PASSWORD_LENGTH = 50;

  public static boolean validateUsernameFormat(String attemptedUsername) {
    int attemptedUsernameLength = attemptedUsername.length();
    return MIN_USERNAME_LENGTH <= attemptedUsernameLength && attemptedUsernameLength <= MAX_USERNAME_LENGTH;
  }

  public static boolean validatePasswordFormat(String attemptedPassword) {
    int attemptedPasswordLength = attemptedPassword.length();
    return MIN_PASSWORD_LENGTH <= attemptedPasswordLength && attemptedPasswordLength <= MAX_PASSWORD_LENGTH;
  }
}
