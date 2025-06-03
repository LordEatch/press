package com.example.press_api.user;

import com.example.press_api.validation.Validation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

// NOTE I need to change all return types in these methods to be RESTful.

@CrossOrigin(origins = "http://localhost:3000") // NOTE All controllers will need this. Can I make this better with OOP?
@RequestMapping("/user")
@RestController
public class UserController {
  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Integer id) {
    User user = userService.getUser(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ResponseEntity<User> createUser(
          @RequestParam String username,
          @RequestParam String password
  ) throws Exception {
    if (Validation.validateUsernameFormat(username) && Validation.validatePasswordFormat(password)) {
      User newUser = new User(username, password);
      userService.createUser(newUser);
      return new ResponseEntity<>(newUser, HttpStatus.OK);
    } else {
      // NOTE I need to change this to return an invalid input format message with the response!
      return new ResponseEntity<>(new User(), HttpStatus.BAD_REQUEST);
    }
  }
}
