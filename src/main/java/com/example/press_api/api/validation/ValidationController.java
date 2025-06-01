package com.example.press_api.api.validation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// NOTE This will be used by the frontend to first check validity client-side for time sake.
// Validity will also need to be checked server-side.

@RestController
public class ValidationController {
  private static final String PATH = "/validation";

  @GetMapping(PATH + "/validate-username-format")
  public boolean validateUsernameFormat(@RequestParam String u) {
    return Validation.validateUsernameFormat(u);
  }

  @GetMapping(PATH + "/validate-password-format")
  public boolean validatePasswordFormat(@RequestParam String p) {
    return Validation.validatePasswordFormat(p);
  }
}
