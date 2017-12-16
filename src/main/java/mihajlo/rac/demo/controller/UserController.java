package mihajlo.rac.demo.controller;

import mihajlo.rac.demo.model.User;
import mihajlo.rac.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody User user){
        User fromUsername = this.userService.register(user.getName(), user.getEmail(), user.getPassword());
        if(fromUsername != null){
            return new ResponseEntity(fromUsername, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody User user) {
        User fromUsername = this.userService.login(user.getName(), user.getPassword());
        if(fromUsername != null){
            return new ResponseEntity(fromUsername, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

}
