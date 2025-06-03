package com.example.press_api.validation;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* NOTE This mapping will be used by the frontend to first check validity client-side for UX.
*  Validity will also need to be checked server-side. */

@RequestMapping("/validation")
@RestController
public class ValidationController {
  @GetMapping("/validate-username-format")
  public ResponseEntity<Boolean> validateUsernameFormat(@RequestParam String u) {
    Boolean usernameValid = Validation.validateUsernameFormat(u);
    return new ResponseEntity<>(usernameValid, HttpStatus.OK);
  }

  @GetMapping("/validate-password-format")
  public ResponseEntity<Boolean> validatePasswordFormat(@RequestParam String p) {
    Boolean passwordValid = Validation.validateUsernameFormat(p);
    return new ResponseEntity<>(passwordValid, HttpStatus.OK);
  }

  @GetMapping("/csrf")
  public CsrfToken getCsrfToken(HttpServletRequest request) {
    return (CsrfToken) request.getAttribute("_csrf");
  }
}
