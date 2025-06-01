package com.example.press_api.api.user;

import com.example.press_api.api.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// NOTE I need to change all return types in these methods to be RESTful.

@RestController
public class UserController {
  /* NOTE Is this redundant code? Can this be improved with inheritance? All controllers will
  *  need a path variable. */
  private static final String PATH = "/user";

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(PATH + "/{id}")
  public String getUser(@PathVariable Integer id) {
    User returnedUser = userService.getUser(id);
    return returnedUser.toString();
  }

  @PostMapping(PATH + "/create")
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
