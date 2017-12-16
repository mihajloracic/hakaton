package mihajlo.rac.demo.controller;

import mihajlo.rac.demo.model.User;
import mihajlo.rac.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseBody
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }


}
