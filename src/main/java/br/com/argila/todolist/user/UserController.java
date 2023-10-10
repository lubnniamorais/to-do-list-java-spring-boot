package br.com.argila.todolist.user;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {
  /**
   * As informações vem do Body
   */

  @Autowired
  private IUserRepository userRepository;

  @PostMapping("/")
  public UserModel create(@RequestBody UserModel userModel) {
    var user = this.userRepository.findByUsername(userModel.getUsername());

    if(user != null) {
      System.out.println("User already exists");
      return null;
    }

    var userCreated = this.userRepository.save(userModel);

    return userCreated;
  }
}
