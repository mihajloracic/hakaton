package mihajlo.rac.demo.service;


import mihajlo.rac.demo.model.User;
import mihajlo.rac.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        userRepository.save(user);
        return user;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.getOne(id);
    }

    public User login(String name, String password){
        User fromUsername = this.userRepository.findByName(name);
        if(fromUsername != null && fromUsername.getPassword().equals(password)){
            return fromUsername;
        }
        return null;
    }

    public User register(String name, String email, String password) {
        User fromUsername = this.userRepository.findByName(name);
        if(fromUsername == null){
            User newUser = new User(name, email, password);
            this.userRepository.save(newUser);
            return newUser;
        }
        return null;
    }
}
