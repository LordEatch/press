package com.example.press_api.user;

import com.example.press_api.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
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
  public String getUser(@PathVariable Integer id) {
    User returnedUser = userService.getUser(id);
    return returnedUser.toString();
  }

  @PostMapping("/create")
  public String createUser(
          @RequestParam String username,
          @RequestParam String password
  ) throws Exception {
    if (Validation.validateUsernameFormat(username) && Validation.validatePasswordFormat(password)) {
      User newUser = new User(username, password);
      userService.createUser(newUser);
      return "User inserted with id " + newUser.getId() + ".";
    } else {
      return "User not inserted. Incorrect username or password format.";
    }
  }
}
